package com.bytedance.crash.looper;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LooperMessageManager {
    private static final int BLOCK_INTERNAL_MS = 3000;
    private static final int GROUP_POOL_SIZE = 30;
    private static final int HISTORY_RING_SIZE = 50;
    private static final long LONG_MESSAGE_THRESHOLD = 200;
    private static final String MESSAGE_IS_RUNNING = "message is running";
    private static final String NO_MESSAGE_RUNNING = "no message running";
    private static final int PENDING_MESSAGE_MAX_COUNT = 200;
    private final Runnable mBlockRunnable;
    private volatile CollectionState mCollectionState;
    private volatile CollectionStateHistory mCollectionStateHistory;
    private boolean mIsJavaMessage;
    private long mLastCpuTime;
    private long mLastUpTime;
    private long mLastWallTime;
    private JSONArray mStackArray;

    private interface CollectionState {
        CollectionState onMessage(Message r1, long r2, long r4, long r6);
    }

    private static class CollectionStateCurrent implements CollectionState {
        private boolean mCollectedPendingMessage;
        private File mDirectory;
        private final JSONObject mJsonObject;
        private HistoryMessage mMessage;

        private CollectionStateCurrent() {
            this.mJsonObject = new JSONObject();
        }

        /* synthetic */ CollectionStateCurrent(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void access$300(CollectionStateCurrent r0, File r1, long r2, boolean r4) {
            r0.dumpBlockedMessage(r1, r2, r4);
        }

        static /* synthetic */ void access$800(CollectionStateCurrent r0) {
            r0.updateState();
        }

        private void dumpBlockedMessage(File r5, long r6, boolean r8) {
            JSONObject r0 = this.mJsonObject;
            monitor-enter(r0);
            JSONObject r1 = this.mJsonObject.optJSONObject("current_message");     // Catch: Throwable -> L13 JSONException -> L19
            if (r1 != null) goto L11;
            r1 = new JSONObject();     // Catch: Throwable -> L13 JSONException -> L19
            this.mJsonObject.put("current_message", r1);     // Catch: Throwable -> L13 JSONException -> L19
            if (r8 == false) goto L9;
            String r9 = LooperMessageManager.MESSAGE_IS_RUNNING;
        L10:
            r1.put("message", r9);     // Catch: Throwable -> L13 JSONException -> L19
            goto L11
        L9:
            r9 = LooperMessageManager.NO_MESSAGE_RUNNING;
        L11:
            r1.put("currentMessageCost", r6);     // Catch: Throwable -> L13 JSONException -> L19
            r1.put("currentMessageCpu", -1);     // Catch: Throwable -> L13 JSONException -> L19
            this.mDirectory = r5;     // Catch: Throwable -> L13 JSONException -> L19
            writeToFile();     // Catch: Throwable -> L13 JSONException -> L19
        L13:
            th = move-exception;
            throw th;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
        }

        private void updateBlockedMessage() {
            JSONObject r0 = this.mJsonObject;
            monitor-enter(r0);
            JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(this.mJsonObject.opt("current_message"), JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9 JSONException -> L15
            if (r1 != null) goto L7;
            r1 = new JSONObject();     // Catch: Throwable -> L9 JSONException -> L15
            this.mJsonObject.put("current_message", r1);     // Catch: Throwable -> L9 JSONException -> L15
        L7:
            r1.put("message", this.mMessage.getTag());     // Catch: Throwable -> L9 JSONException -> L15
            r1.put("currentMessageLastCost", this.mMessage.mWallDuration);     // Catch: Throwable -> L9 JSONException -> L15
            r1.put("currentMessageLastCpu", this.mMessage.mCpuDuration);     // Catch: Throwable -> L9 JSONException -> L15
            writeToFile();     // Catch: Throwable -> L9 JSONException -> L15
        L9:
            th = move-exception;
            throw th;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        private void updateState() {
            this.mCollectedPendingMessage = true;
        }

        private void writeToFile() {
            File r0 = this.mDirectory;
            if (r0 == null) goto L6;
            FileUtils.writeFile(LooperMessageConfig.getCurrentJsonFile(r0), this.mJsonObject, false);
            return;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message r3, long r4, long r6, long r8) {
            AnonymousClass1 r1 = null;
            HistoryMessage r0 = new HistoryMessage(r1);
            this.mMessage = r0;
            r0.setDuration(r4, r6);
            this.mMessage.copyFrom(r3, r8);
            updateBlockedMessage();
            if (this.mCollectedPendingMessage == false) goto L5;
            return null;
        L5:
            return new CollectionStatePending(r1);
        }
    }

    private static class CollectionStateHistory implements CollectionState {
        private final PackedMessagesChunk mPackedMessagesChunk;
        private final PackingMessages mPackingMessages;

        private static class PackedMessagesChunk {
            private final PackedMessages[] mBuffer;
            private int mReadPosition;
            private final int mSize;
            private int mWritePosition;

            PackedMessagesChunk(int r5) {
                this.mBuffer = new PackedMessages[r5];
                int r0 = 0;
            L3:
                if (r0 >= r5) goto L5;
                this.mBuffer[r0] = new PackedMessages(null);
                r0 = r0 + 1;
                goto L3
            L5:
                this.mSize = r5;
                this.mWritePosition = -1;
            }

            static /* synthetic */ PackedMessages access$1400(PackedMessagesChunk r0) {
                return r0.getFirstRead();
            }

            static /* synthetic */ PackedMessages access$1500(PackedMessagesChunk r0) {
                return r0.getNextRead();
            }

            static /* synthetic */ PackedMessages access$2000(PackedMessagesChunk r0) {
                return r0.getNextMessage();
            }

            private PackedMessages getFirstRead() {
                int r0 = this.mWritePosition;
                if (r0 != (-1)) goto L6;
                return null;
            L6:
                int r1 = r0 + 1;
                this.mReadPosition = r1;
                if (r1 != this.mSize) goto L9;
            L10:
                this.mReadPosition = 0;
            L12:
                return this.mBuffer[this.mReadPosition];
            L9:
                if (this.mBuffer[r1].mWallDuration != 0) goto L12;
                goto L10
            }

            private PackedMessages getNextMessage() {
                int r0 = this.mWritePosition + 1;
                this.mWritePosition = r0;
                if (r0 != this.mSize) goto L6;
                this.mWritePosition = 0;
            L6:
                return this.mBuffer[this.mWritePosition];
            }

            private PackedMessages getNextRead() {
                int r0 = this.mReadPosition + 1;
                this.mReadPosition = r0;
                if (r0 != (this.mWritePosition + 1)) goto L7;
                return null;
            L7:
                if (r0 != this.mSize) goto L10;
                this.mReadPosition = 0;
            L10:
                return this.mBuffer[this.mReadPosition];
            }
        }

        private static class PackingMessages extends TimePeriodHistoryMessages {
            private final HashMap<String, LinkableHistoryMessageGroup> mHashMap;
            private HistoryMessageGroup mLongestGroup;
            private final LinkableMessagePool mMessagePool;
            private final PackedMessagesChunk mPackedChunk;

            PackingMessages(PackedMessagesChunk r3, int r4) {
                AnonymousClass1 r0 = null;
                super(r0);
                this.mHashMap = new HashMap(r4);
                this.mMessagePool = new LinkableMessagePool(r4, r0);
                this.mPackedChunk = r3;
            }

            static /* synthetic */ void access$1200(PackingMessages r0, Message r1, long r2, long r4, long r6) {
                r0.mergeMessage(r1, r2, r4, r6);
            }

            static /* synthetic */ void access$1300(PackingMessages r0, boolean r1) {
                r0.pushToChunk(r1);
            }

            private void addOneMsg(Message r5, long r6, long r8, long r10) {
                this.mCount++;
                if (this.mDelay != Long.MAX_VALUE) goto L10;
                long r11 = getDelay(r5, r10);
                if (r11 > 0) goto L10;
                if ((this.mWallDuration + r11) <= 0) goto L9;
                this.mDelay = 0;
                goto L10
            L9:
                this.mDelay = r11 + this.mWallDuration;
            L10:
                this.mWallDuration += r6;
                this.mCpuDuration += r8;
            }

            private String getHashKey(Message r1) {
                if (r1.getCallback() == null) goto L7;
                Object r0 = r1.getCallback();
            L11:
                return r0.getClass().getName();
            L7:
                if (r1.getTarget() == null) goto L9;
                r0 = r1.getTarget();
                goto L11
            L9:
                return "unknown";
            }

            private void mergeMessage(Message r14, long r15, long r17, long r19) {
                if (r15 <= 200) goto L5;
                pushToChunk(true);
            L5:
                String r1 = getHashKey(r14);
                LinkableHistoryMessageGroup r3 = (LinkableHistoryMessageGroup) ZeusTransformUtils.preCheckCast(this.mHashMap.get(r1), LinkableHistoryMessageGroup.class, "com.obric.memorydata.plugin");
                if (r3 != null) goto L15;
                r3 = LinkableMessagePool.access$2100(this.mMessagePool);
                if (r3 != null) goto L13;
                pushToChunk(true);
                LinkableHistoryMessageGroup r2 = LinkableMessagePool.access$2100(this.mMessagePool);
                if (r2 != null) goto L12;
                return;
            L12:
                r3 = r2;
            L13:
                this.mHashMap.put(r1, r3);
                r3.copyFrom(r14, r19);
            L15:
                LinkableHistoryMessageGroup r4 = r3;
                LinkableHistoryMessageGroup.access$2200(r4, r14, r15, r17, r19);
                addOneMsg(r14, r15, r17, r19);
                if (this.mLongestGroup != null) goto L18;
            L19:
                this.mLongestGroup = r4;
            L20:
                pushToChunk(false);
                return;
            L18:
                if (r4.mWallDuration <= this.mLongestGroup.mWallDuration) goto L20;
                goto L19
            }

            private void pushToChunk(boolean r5) {
                if (this.mWallDuration == 0) goto L5;
            L6:
                if (r5 == false) goto L8;
            L10:
                PackedMessages r6 = PackedMessagesChunk.access$2000(this.mPackedChunk);
                r6.reset();
                r6.mCount = this.mCount;
                r6.mWallDuration = this.mWallDuration;
                r6.mCpuDuration = this.mCpuDuration;
                r6.mDelay = this.mDelay;
                r6.copyIdleFrom(this);
                r6.copyLongestFrom(this.mLongestGroup);
                r6.copyShadowFrom(this.mLongestGroup);
                reset();
                return;
            L8:
                if (this.mWallDuration > 200) goto L10;
                return;
            L5:
                if (this.mCount != 0) goto L6;
            }

            @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages
            public void mergeIdle(long r3, long r5) {
                if (r3 <= 200) goto L5;
                pushToChunk(true);
            L5:
                super.mergeIdle(r3, r5);
                this.mWallDuration += r3;
                this.mCpuDuration += r5;
                pushToChunk(false);
            }

            @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
            public void reset() {
                super.reset();
                this.mLongestGroup = null;
                Iterator<LinkableHistoryMessageGroup> r0 = this.mHashMap.values().iterator();
            L4:
                if (r0.hasNext() == false) goto L8;
                LinkableHistoryMessageGroup r1 = (LinkableHistoryMessageGroup) ZeusTransformUtils.preCheckCast(r0.next(), LinkableHistoryMessageGroup.class, "com.obric.memorydata.plugin");
                if (r1 == null) goto L4;
                LinkableMessagePool.access$1900(this.mMessagePool, r1);
                goto L4
            L8:
                this.mHashMap.clear();
            }
        }

        private CollectionStateHistory() {
            PackedMessagesChunk r0 = new PackedMessagesChunk(50);
            this.mPackedMessagesChunk = r0;
            this.mPackingMessages = new PackingMessages(r0, 30);
        }

        /* synthetic */ CollectionStateHistory(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void access$400(CollectionStateHistory r0, File r1, long r2, long r4, long r6, long r8) {
            r0.dumpAllMessage(r1, r2, r4, r6, r8);
        }

        private void dumpAllMessage(File r4, long r5, long r7, long r9, long r11) {
            PackingMessages.access$1300(this.mPackingMessages, true);
            JSONArray r0 = new JSONArray();
            PackedMessages r1 = PackedMessagesChunk.access$1400(this.mPackedMessagesChunk);
        L3:
            if (r1 == null) goto L7;
            JSONObject r2 = new JSONObject();
            r1.toJson(r2);     // Catch: JSONException -> L11
            r0.put(r2);     // Catch: JSONException -> L11
        L6:
            r1 = PackedMessagesChunk.access$1500(this.mPackedMessagesChunk);
            goto L3
        L7:
            JSONObject r3 = new JSONObject();
            r3.put("history_message", r0);     // Catch: JSONException -> L12
            JSONObject r6 = new JSONObject();     // Catch: JSONException -> L12
            r6.put("dump_wall_time", r5);     // Catch: JSONException -> L12
            r6.put("dump_up_time", r7);     // Catch: JSONException -> L12
            r6.put("last_wall_time", r9);     // Catch: JSONException -> L12
            r6.put("last_cpu_time", r11);     // Catch: JSONException -> L12
            r3.put("history_details", r6);     // Catch: JSONException -> L12
        L9:
            FileUtils.writeFile(LooperMessageConfig.getHistoryJsonFile(r4), r3, false);
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message r9, long r10, long r12, long r14) {
            if (r9 == null) goto L4;
            PackingMessages.access$1200(this.mPackingMessages, r9, r10, r12, r14);
        L5:
            return this;
        L4:
            this.mPackingMessages.mergeIdle(r10, r12);
            goto L5
        }
    }

    private static class CollectionStatePending implements CollectionState {
        private LinkedList<HistoryMessage> mHistoryQueue;
        private final LinkedList<ShadowMessage> mPendingQueue;

        private CollectionStatePending() {
            this.mPendingQueue = new LinkedList();
            this.mHistoryQueue = new LinkedList();
        }

        /* synthetic */ CollectionStatePending(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void access$600(CollectionStatePending r0, long r1) {
            r0.collectPendingMessage(r1);
        }

        static /* synthetic */ void access$700(CollectionStatePending r0, CollectionStatePending r1) {
            r0.setHistoryQueue(r1);
        }

        static /* synthetic */ void access$900(CollectionStatePending r0, File r1) {
            r0.dumpAllMessages(r1);
        }

        private void collectPendingMessage(long r7) {
            MessageQueue r0 = getMainMessageQueue();
            Field r1 = getField("android.os.MessageQueue", "mMessages");
            Field r2 = getField("android.os.Message", "next");
            if (r0 == null) goto L18;
            if (r1 == null) goto L26;
            if (r2 == null) goto L28;
            monitor-enter(r0);     // Catch: Throwable -> L19
            Message r3 = (Message) ZeusTransformUtils.preCheckCast(getMember(r1, r0), Message.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            int r4 = 0;
        L9:
            if (r3 == null) goto L13;
            int r5 = r4 + 1;     // Catch: Throwable -> L15
            if (r4 >= 200) goto L13;
            ShadowMessage r6 = new ShadowMessage(null);     // Catch: Throwable -> L15
            r6.copyFrom(r3, r7);     // Catch: Throwable -> L15
            this.mPendingQueue.add(r6);     // Catch: Throwable -> L15
            r3 = (Message) ZeusTransformUtils.preCheckCast(getMember(r2, r3), Message.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            r4 = r5;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            goto L29
        L27:
            return;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L29:
            return;
        L28:
            return;
        L26:
            return;
        }

        private void dumpAllMessages(File r11) {
            JSONArray r0 = new JSONArray();
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
        L4:
            if (r2 >= 200) goto L26;
            if (r3 < this.mHistoryQueue.size()) goto L7;
            if (r4 >= this.mPendingQueue.size()) goto L26;
            int r8 = r4 + 1;
            ShadowMessage r5 = (ShadowMessage) ZeusTransformUtils.preCheckCast(this.mPendingQueue.get(r4), ShadowMessage.class, "com.obric.memorydata.plugin");
            JSONObject r6 = new JSONObject();
            r5.toJson(r6);     // Catch: JSONException -> L33
            int r7 = r2 + 1;
            r6.put(OaidModel.KEY_ID, r2);     // Catch: JSONException -> L32
            r0.put(r6);     // Catch: JSONException -> L32
        L24:
            r2 = r7;
        L25:
            r4 = r8;
            goto L4
        L7:
            int r9 = r3 + 1;
            HistoryMessage r10 = (HistoryMessage) ZeusTransformUtils.preCheckCast(this.mHistoryQueue.get(r3), HistoryMessage.class, "com.obric.memorydata.plugin");
            JSONObject r12 = new JSONObject();
            r10.toJson(r12);     // Catch: JSONException -> L31
            int r13 = r2 + 1;
            r12.put(OaidModel.KEY_ID, r2);     // Catch: JSONException -> L30
            r0.put(r12);     // Catch: JSONException -> L30
        L11:
            r2 = r13;
        L13:
            if (r4 < this.mPendingQueue.size()) goto L15;
        L17:
            r3 = r9;
            goto L4
        L15:
            if (r10.equals((ShadowMessage) ZeusTransformUtils.preCheckCast(this.mPendingQueue.get(r4), ShadowMessage.class, "com.obric.memorydata.plugin")) == false) goto L17;
            r4 = r4 + 1;
        L26:
            JSONObject r14 = new JSONObject();
            r14.put("pending_messages", r0);     // Catch: JSONException -> L34
        L28:
            FileUtils.writeFile(LooperMessageConfig.getPendingJsonFile(r11), r14, false);
        }

        private static Field getField(String r1, String r2) {
            Field r3 = ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getDeclaredField(r2);     // Catch: Exception -> L4
            r3.setAccessible(true);     // Catch: Exception -> L4
            return r3;
        L4:
            return null;
        }

        private static MessageQueue getMainMessageQueue() {
            if (Looper.getMainLooper() == null) goto L12;
            Looper r0 = Looper.getMainLooper();
            if (r0 != Looper.myLooper()) goto L8;
            return Looper.myQueue();
        L8:
            if (Build.VERSION.SDK_INT >= 23) goto L18;
            Field r1 = r0.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L14
            r1.setAccessible(true);     // Catch: Throwable -> L14
            return (MessageQueue) ZeusTransformUtils.preCheckCast(r1.get(r0), MessageQueue.class, "com.obric.memorydata.plugin");
        L18:
            return r0.getQueue();
        L12:
            return null;
        }

        private static Object getMember(Field r0, Object r1) {
            return r0.get(r1);
        L4:
            return null;
        }

        private void setHistoryQueue(CollectionStatePending r1) {
            this.mHistoryQueue = r1.mHistoryQueue;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message r3, long r4, long r6, long r8) {
            if (r3 == null) goto L4;
            HistoryMessage r0 = new HistoryMessage(null);
            r0.copyFrom(r3, r8);
            r0.setDuration(r4, r6);
            this.mHistoryQueue.add(r0);
        L4:
            return this;
        }
    }

    private static class HistoryMessage extends ShadowMessage {
        protected long mCpuDuration;
        protected long mWallDuration;

        private HistoryMessage() {
            super(null);
        }

        /* synthetic */ HistoryMessage(AnonymousClass1 r1) {
            this();
        }

        public String getTag() {
            if (this.mCallback == null) goto L7;
            return this.mCallback;
        L7:
            if (this.mTarget != null) goto L9;
            return LooperMessageManager.NO_MESSAGE_RUNNING;
        L9:
            return this.mTarget;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        public void reset() {
            super.reset();
            setDuration(0, 0);
        }

        public void setDuration(long r1, long r3) {
            this.mWallDuration = r1;
            this.mCpuDuration = r3;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        public void toJson(JSONObject r4) {
            super.toJson(r4);
            r4.put("duration", this.mWallDuration);
            r4.put("cpuDuration", this.mCpuDuration);
        }
    }

    private static class HistoryMessageGroup extends HistoryMessage {
        protected int mCount;

        private HistoryMessageGroup() {
            super(null);
        }

        /* synthetic */ HistoryMessageGroup(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        public void reset() {
            super.reset();
            this.mCount = 0;
        }
    }

    private static class LinkableHistoryMessageGroup extends HistoryMessageGroup {
        private LinkableHistoryMessageGroup mNext;

        private LinkableHistoryMessageGroup() {
            super(null);
        }

        /* synthetic */ LinkableHistoryMessageGroup(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void access$2200(LinkableHistoryMessageGroup r0, Message r1, long r2, long r4, long r6) {
            r0.addOneMsg(r1, r2, r4, r6);
        }

        static /* synthetic */ LinkableHistoryMessageGroup access$2400(LinkableHistoryMessageGroup r0) {
            return r0.mNext;
        }

        static /* synthetic */ LinkableHistoryMessageGroup access$2402(LinkableHistoryMessageGroup r0, LinkableHistoryMessageGroup r1) {
            r0.mNext = r1;
            return r1;
        }

        private void addOneMsg(Message r3, long r4, long r6, long r8) {
            this.mWallDuration += r4;
            this.mCpuDuration += r6;
            this.mCount++;
            long r5 = getDelay(r3, r8);
            if (this.mDelay <= r5) goto L6;
            this.mDelay = r5;
            return;
        }
    }

    private static class LinkableMessagePool {
        private LinkableHistoryMessageGroup mHead;

        private LinkableMessagePool(int r3) {
        L3:
            if (r3 <= 0) goto L5;
            recycle(new LinkableHistoryMessageGroup(null));
            r3 = r3 - 1;
            goto L3
        }

        /* synthetic */ LinkableMessagePool(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$1900(LinkableMessagePool r0, LinkableHistoryMessageGroup r1) {
            r0.recycle(r1);
        }

        static /* synthetic */ LinkableHistoryMessageGroup access$2100(LinkableMessagePool r0) {
            return r0.obtain();
        }

        private LinkableHistoryMessageGroup obtain() {
            LinkableHistoryMessageGroup r0 = this.mHead;
            if (r0 == null) goto L6;
            this.mHead = LinkableHistoryMessageGroup.access$2400(r0);
            LinkableHistoryMessageGroup.access$2402(r0, null);
            r0.reset();
            return r0;
        L6:
            return null;
        }

        private void recycle(LinkableHistoryMessageGroup r2) {
            LinkableHistoryMessageGroup.access$2402(r2, this.mHead);
            this.mHead = r2;
        }
    }

    private static class PackedMessages extends TimePeriodHistoryMessages {
        private long mLongestGroupCpuDuration;
        private long mLongestGroupDelay;
        private int mLongestGroupMessageCount;
        private long mLongestGroupWallDuration;

        private PackedMessages() {
            super(null);
        }

        /* synthetic */ PackedMessages(AnonymousClass1 r1) {
            this();
        }

        private int getType() {
            if (this.mCount != 0) goto L6;
            return 1;
        L6:
            if (isLongMessage() == false) goto L8;
            return 8;
        L8:
            return 9;
        }

        public void copyLongestFrom(HistoryMessageGroup r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            this.mLongestGroupMessageCount = r3.mCount;
            this.mLongestGroupWallDuration = r3.mWallDuration;
            this.mLongestGroupCpuDuration = r3.mCpuDuration;
            this.mLongestGroupDelay = r3.mDelay;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        public void reset() {
            super.reset();
            this.mLongestGroupMessageCount = 0;
            this.mLongestGroupWallDuration = 0;
            this.mLongestGroupCpuDuration = 0;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        public void toJson(JSONObject r5) {
            super.toJson(r5);
            int r0 = getType();
            if (r0 != 9) goto L5;
            r5.put("LongestGroupMessageCount", this.mLongestGroupMessageCount);
            r5.put("LongestGroupDuration", this.mLongestGroupWallDuration);
            r5.put("LongestGroupCpuDuration", this.mLongestGroupCpuDuration);
            r5.put("LongestGroupDelay", this.mLongestGroupDelay);
            r5.put("messageCount", this.mCount);
        L5:
            r5.put(NotificationCompat.CATEGORY_MESSAGE, getTag());
            r5.put("type", r0);
        }
    }

    private static class ShadowMessage {
        private static final int MINIMUM_WHEN = 100;
        protected String mCallback;
        protected long mDelay;
        protected String mTarget;
        protected int mWhat;

        private ShadowMessage() {
            this.mDelay = Long.MAX_VALUE;
        }

        /* synthetic */ ShadowMessage(AnonymousClass1 r1) {
            this();
        }

        public static long getDelay(Message r2, long r3) {
            if (isInstant(r2) == true) goto L7;
            return Long.MAX_VALUE;
        L7:
            return r2.getWhen() - r3;
        }

        public static boolean isInstant(Message r4) {
            if (r4.getWhen() <= 100) goto L5;
            return true;
        L5:
            return false;
        }

        public void copyFrom(Message r6, long r7) {
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.getTarget() == null) goto L8;
            this.mTarget = r6.getTarget().getClass().getName();
        L8:
            if (r6.getCallback() == null) goto L23;
            String r0 = r6.getCallback().getClass().getName();
            this.mCallback = r0;
            if (r0.startsWith("Y.ARunnable") == false) goto L23;
            String r1 = r6.getCallback().toString();
            int r2 = 0;
            if (r1.charAt(0) < '0') goto L23;
            if (r1.charAt(0) > '9') goto L23;
            StringBuilder r3 = new StringBuilder();
            r3.append(this.mCallback);
            r3.append(".run$");
        L17:
            if (r2 >= r1.length()) goto L22;
            if (r1.charAt(r2) == '_') goto L22;
            r3.append(r1.charAt(r2));
            r2 = r2 + 1;
        L22:
            this.mCallback = r3.toString();
        L23:
            this.mDelay = getDelay(r6, r7);
            this.mWhat = r6.what;
        }

        public void copyShadowFrom(ShadowMessage r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            this.mTarget = r2.mTarget;
            this.mCallback = r2.mCallback;
            this.mWhat = r2.mWhat;
        }

        public boolean equals(ShadowMessage r5) {
            if (this.mDelay == r5.mDelay) goto L5;
        L11:
            return false;
        L5:
            if (this.mWhat != r5.mWhat) goto L11;
            if (this.mTarget != r5.mTarget) goto L11;
            if (this.mCallback != r5.mCallback) goto L11;
            return true;
        }

        public void reset() {
            this.mTarget = null;
            this.mCallback = null;
            this.mDelay = Long.MAX_VALUE;
            this.mWhat = -1;
        }

        public void toJson(JSONObject r5) {
            String r0 = this.mCallback;
            if (r0 == null) goto L5;
            r5.put("callback", r0);
        L5:
            String r1 = this.mTarget;
            if (r1 == null) goto L8;
            r5.put(TypedValues.AttributesType.S_TARGET, r1);
        L8:
            int r2 = this.mWhat;
            if (r2 == (-1)) goto L11;
            r5.put("what", r2);
        L11:
            long r3 = this.mDelay;
            if (r3 == Long.MAX_VALUE) goto L15;
            r5.put("when", r3);
            return;
        }
    }

    private static class TimePeriodHistoryMessages extends HistoryMessageGroup {
        private static final int DILE_TIME_THRESHOLD = 1;
        private int mIdleCount;
        private long mIdleCpuDuration;
        private long mIdleWallDuration;

        private TimePeriodHistoryMessages() {
            super(null);
        }

        /* synthetic */ TimePeriodHistoryMessages(AnonymousClass1 r1) {
            this();
        }

        public void copyIdleFrom(TimePeriodHistoryMessages r3) {
            this.mIdleCount = r3.mIdleCount;
            this.mIdleWallDuration = r3.mIdleWallDuration;
            this.mIdleCpuDuration = r3.mIdleCpuDuration;
        }

        public boolean isLongMessage() {
            if (this.mCount == 1) goto L5;
        L7:
            return false;
        L5:
            if ((this.mWallDuration - this.mIdleWallDuration) <= 200) goto L7;
            return true;
        }

        public void mergeIdle(long r3, long r5) {
            this.mIdleWallDuration += r3;
            this.mIdleCpuDuration += r5;
            if (r3 <= 1) goto L6;
            this.mIdleCount++;
            return;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        public void reset() {
            super.reset();
            this.mIdleWallDuration = 0;
            this.mIdleCpuDuration = 0;
            this.mIdleCount = 0;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        public void toJson(JSONObject r4) {
            super.toJson(r4);
            if (this.mIdleCount == 0) goto L6;
            r4.put("idleDuration", this.mIdleWallDuration);
            r4.put("idleCpuDuration", this.mIdleCpuDuration);
            r4.put("idleCount", this.mIdleCount);
            return;
        }
    }

    public LooperMessageManager() {
        this.mBlockRunnable = new AnonymousClass1(this);
    }

    static /* synthetic */ JSONArray access$000(LooperMessageManager r0) {
        return r0.mStackArray;
    }

    private void dumpBlockStack(File r3) {
        if (this.mStackArray.length() == 0) goto L6;
        JSONObject r0 = new JSONObject();
        JSONUtils.put(r0, "block_stack", this.mStackArray);
        FileUtils.writeFile(LooperMessageConfig.getBlockStackJsonFile(r3), r0, false);
        return;
    }

    void dumpMessages(File r19) {
        long r4 = System.currentTimeMillis();
        long r12 = SystemClock.uptimeMillis();
        monitor-enter(this);
        AnonymousClass1 r14 = null;
        if (this.mCollectionState != null) goto L7;
        boolean r10 = false;
        long r8 = 0;
        long r16 = 0;
        CollectionStateHistory r2 = null;
        CollectionStateCurrent r15 = null;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L35
        if (r15 == null) goto L18;
        CollectionStateCurrent.access$300(r15, r19, r4 - r8, r10);
    L18:
        if (r2 == null) goto L20;
        CollectionStateHistory.access$400(r2, r19, r4, r12, r8, r16);
    L20:
        dumpBlockStack(r19);
        CollectionStatePending r3 = new CollectionStatePending(r14);
        CollectionStatePending.access$600(r3, r12);
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L23:
        if (ZeusTransformUtils.instanceOf(this.mCollectionState, CollectionStatePending.class) == false) goto L26;
        CollectionStatePending.access$700(r3, (CollectionStatePending) ZeusTransformUtils.preCheckCast(this.mCollectionState, CollectionStatePending.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
        this.mCollectionState = this.mCollectionStateHistory;     // Catch: Throwable -> L32
    L29:
        monitor-exit(this);     // Catch: Throwable -> L32
        CollectionStatePending.access$900(r3, r19);
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(this.mCollectionState, CollectionStateCurrent.class) == false) goto L29;
        if (r15 == null) goto L29;
        CollectionStateCurrent.access$800(r15);     // Catch: Throwable -> L32
        goto L29
    L7:
        if (this.mLastWallTime != 0) goto L9;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L35
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(this.mCollectionState, CollectionStateHistory.class) == false) goto L12;
        r2 = (CollectionStateHistory) ZeusTransformUtils.preCheckCast(this.mCollectionState, CollectionStateHistory.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        CollectionStateCurrent r5 = new CollectionStateCurrent(r14);     // Catch: Throwable -> L35
        long r6 = this.mLastWallTime;     // Catch: Throwable -> L35
        long r9 = this.mLastCpuTime;     // Catch: Throwable -> L35
        r10 = this.mIsJavaMessage;     // Catch: Throwable -> L35
        this.mCollectionState = r5;     // Catch: Throwable -> L35
        r15 = r5;
        r16 = r9;
        r8 = r6;
    L35:
        th = move-exception;
        throw th;
    }

    public synchronized void onMessage(Message r17) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.mCollectionState != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r10 = SystemClock.currentThreadTimeMillis();     // Catch: Throwable -> L24
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L24
        long r14 = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        long r2 = this.mLastWallTime;     // Catch: Throwable -> L24
        if (r2 == 0) goto L18;
        long r4 = r12 - r2;     // Catch: Throwable -> L24
        long r6 = r10 - this.mLastCpuTime;     // Catch: Throwable -> L24
        CollectionState r0 = this.mCollectionState.onMessage(r17, r4, r6, this.mLastUpTime);     // Catch: Throwable -> L24
        if (GlobalSwitch.isAllowBlockStack() == false) goto L15;
        if (r17 != null) goto L14;
        DefaultWorkThread.postDelayed(this.mBlockRunnable, 3000);     // Catch: Throwable -> L24
        goto L15
    L14:
        DefaultWorkThread.removeCallbacks(this.mBlockRunnable);     // Catch: Throwable -> L24
    L15:
        if (r0 != null) goto L17;
        r0 = this.mCollectionStateHistory;     // Catch: Throwable -> L24
    L17:
        this.mCollectionState = r0;     // Catch: Throwable -> L24
    L18:
        if (r17 == null) goto L20;
        boolean r1 = true;
    L21:
        this.mIsJavaMessage = r1;     // Catch: Throwable -> L24
        this.mLastWallTime = r12;     // Catch: Throwable -> L24
        this.mLastCpuTime = r10;     // Catch: Throwable -> L24
        this.mLastUpTime = r14;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L20:
        r1 = false;
        goto L21
    }

    void start() {
        CollectionStateHistory r0 = new CollectionStateHistory(null);
        this.mCollectionStateHistory = r0;
        this.mCollectionState = r0;
        this.mStackArray = new JSONArray();
    }

    void stop() {
        this.mCollectionState = null;
    }
}
