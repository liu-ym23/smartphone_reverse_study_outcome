package com.bytedance.crash.looper;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
        CollectionState onMessage(Message r10, long r11, long r12, long r13);
    }

    private static class CollectionStateCurrent implements CollectionState {
        private boolean mCollectedPendingMessage;
        private File mDirectory;
        private final JSONObject mJsonObject;
        private HistoryMessage mMessage;

        private CollectionStateCurrent() {
            this.mJsonObject = new JSONObject();
        }

        /* synthetic */ CollectionStateCurrent(AnonymousClass1 r10) {
            this();
        }

        static /* synthetic */ void access$300(CollectionStateCurrent r10, File r11, long r12, boolean r13) {
            r10.dumpBlockedMessage(r11, r12, r13);
        }

        static /* synthetic */ void access$800(CollectionStateCurrent r10) {
            r10.updateState();
        }

        private void dumpBlockedMessage(File r10, long r11, boolean r12) {
            JSONObject r13 = this.mJsonObject;
            monitor-enter(r13);
            JSONObject r14 = this.mJsonObject.optJSONObject("current_message");     // Catch: Throwable -> L13 JSONException -> L19
            if (r14 != null) goto L11;
            r14 = new JSONObject();     // Catch: Throwable -> L13 JSONException -> L19
            this.mJsonObject.put("current_message", r14);     // Catch: Throwable -> L13 JSONException -> L19
            if (r12 == false) goto L9;
            String r15 = LooperMessageManager.MESSAGE_IS_RUNNING;
        L10:
            r14.put("message", r15);     // Catch: Throwable -> L13 JSONException -> L19
            goto L11
        L9:
            r15 = LooperMessageManager.NO_MESSAGE_RUNNING;
        L11:
            r14.put("currentMessageCost", r11);     // Catch: Throwable -> L13 JSONException -> L19
            r14.put("currentMessageCpu", -1);     // Catch: Throwable -> L13 JSONException -> L19
            this.mDirectory = r10;     // Catch: Throwable -> L13 JSONException -> L19
            writeToFile();     // Catch: Throwable -> L13 JSONException -> L19
        L13:
            th = move-exception;
            throw th;
        L15:
            monitor-exit(r13);     // Catch: Throwable -> L13
        }

        private void updateBlockedMessage() {
            JSONObject r10 = this.mJsonObject;
            monitor-enter(r10);
            JSONObject r11 = (JSONObject) this.mJsonObject.opt("current_message");     // Catch: Throwable -> L9 JSONException -> L15
            if (r11 != null) goto L7;
            r11 = new JSONObject();     // Catch: Throwable -> L9 JSONException -> L15
            this.mJsonObject.put("current_message", r11);     // Catch: Throwable -> L9 JSONException -> L15
        L7:
            r11.put("message", this.mMessage.getTag());     // Catch: Throwable -> L9 JSONException -> L15
            r11.put("currentMessageLastCost", this.mMessage.mWallDuration);     // Catch: Throwable -> L9 JSONException -> L15
            r11.put("currentMessageLastCpu", this.mMessage.mCpuDuration);     // Catch: Throwable -> L9 JSONException -> L15
            writeToFile();     // Catch: Throwable -> L9 JSONException -> L15
        L9:
            th = move-exception;
            throw th;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
        }

        private void updateState() {
            this.mCollectedPendingMessage = true;
        }

        private void writeToFile() {
            File r10 = this.mDirectory;
            if (r10 == null) goto L6;
            FileUtils.writeFile(LooperMessageConfig.getCurrentJsonFile(r10), this.mJsonObject, false);
            return;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message r10, long r11, long r12, long r13) {
            AnonymousClass1 r14 = null;
            HistoryMessage r15 = new HistoryMessage(r14);
            this.mMessage = r15;
            r15.setDuration(r11, r12);
            this.mMessage.copyFrom(r10, r13);
            updateBlockedMessage();
            if (this.mCollectedPendingMessage == false) goto L5;
            return null;
        L5:
            return new CollectionStatePending(r14);
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

            PackedMessagesChunk(int r10) {
                this.mBuffer = new PackedMessages[r10];
                int r11 = 0;
            L3:
                if (r11 >= r10) goto L5;
                this.mBuffer[r11] = new PackedMessages(null);
                r11 = r11 + 1;
                goto L3
            L5:
                this.mSize = r10;
                this.mWritePosition = -1;
            }

            static /* synthetic */ PackedMessages access$1400(PackedMessagesChunk r10) {
                return r10.getFirstRead();
            }

            static /* synthetic */ PackedMessages access$1500(PackedMessagesChunk r10) {
                return r10.getNextRead();
            }

            static /* synthetic */ PackedMessages access$2000(PackedMessagesChunk r10) {
                return r10.getNextMessage();
            }

            private PackedMessages getFirstRead() {
                int r10 = this.mWritePosition;
                if (r10 != (-1)) goto L6;
                return null;
            L6:
                int r11 = r10 + 1;
                this.mReadPosition = r11;
                if (r11 != this.mSize) goto L9;
            L10:
                this.mReadPosition = 0;
            L12:
                return this.mBuffer[this.mReadPosition];
            L9:
                if (this.mBuffer[r11].mWallDuration != 0) goto L12;
                goto L10
            }

            private PackedMessages getNextMessage() {
                int r10 = this.mWritePosition + 1;
                this.mWritePosition = r10;
                if (r10 != this.mSize) goto L6;
                this.mWritePosition = 0;
            L6:
                return this.mBuffer[this.mWritePosition];
            }

            private PackedMessages getNextRead() {
                int r10 = this.mReadPosition + 1;
                this.mReadPosition = r10;
                if (r10 != (this.mWritePosition + 1)) goto L7;
                return null;
            L7:
                if (r10 != this.mSize) goto L10;
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

            PackingMessages(PackedMessagesChunk r10, int r11) {
                AnonymousClass1 r12 = null;
                super(r12);
                this.mHashMap = new HashMap(r11);
                this.mMessagePool = new LinkableMessagePool(r11, r12);
                this.mPackedChunk = r10;
            }

            static /* synthetic */ void access$1200(PackingMessages r10, Message r11, long r12, long r13, long r14) {
                r10.mergeMessage(r11, r12, r13, r14);
            }

            static /* synthetic */ void access$1300(PackingMessages r10, boolean r11) {
                r10.pushToChunk(r11);
            }

            private void addOneMsg(Message r10, long r11, long r12, long r13) {
                this.mCount++;
                if (this.mDelay != Long.MAX_VALUE) goto L10;
                long r14 = ShadowMessage.getDelay(r10, r13);
                if (r14 > 0) goto L10;
                long r15 = this.mWallDuration;
                if ((r14 + r15) <= 0) goto L9;
                this.mDelay = 0;
                goto L10
            L9:
                this.mDelay = r14 + r15;
            L10:
                this.mWallDuration += r11;
                this.mCpuDuration += r12;
            }

            private String getHashKey(Message r10) {
                if (r10.getCallback() == null) goto L7;
                Object r11 = r10.getCallback();
            L11:
                return r11.getClass().getName();
            L7:
                if (r10.getTarget() == null) goto L9;
                r11 = r10.getTarget();
                goto L11
            L9:
                return "unknown";
            }

            private void mergeMessage(Message r14, long r15, long r17, long r19) {
                if (r15 <= LooperMessageManager.LONG_MESSAGE_THRESHOLD) goto L5;
                pushToChunk(true);
            L5:
                String r10 = getHashKey(r14);
                LinkableHistoryMessageGroup r11 = this.mHashMap.get(r10);
                if (r11 != null) goto L15;
                r11 = LinkableMessagePool.access$2100(this.mMessagePool);
                if (r11 != null) goto L13;
                pushToChunk(true);
                LinkableHistoryMessageGroup r12 = LinkableMessagePool.access$2100(this.mMessagePool);
                if (r12 != null) goto L12;
                return;
            L12:
                r11 = r12;
            L13:
                this.mHashMap.put(r10, r11);
                r11.copyFrom(r14, r19);
            L15:
                LinkableHistoryMessageGroup r13 = r11;
                LinkableHistoryMessageGroup.access$2200(r13, r14, r15, r17, r19);
                addOneMsg(r14, r15, r17, r19);
                HistoryMessageGroup r16 = this.mLongestGroup;
                if (r16 != null) goto L18;
            L19:
                this.mLongestGroup = r13;
            L20:
                pushToChunk(false);
                return;
            L18:
                if (r13.mWallDuration <= r16.mWallDuration) goto L20;
                goto L19
            }

            private void pushToChunk(boolean r10) {
                long r11 = this.mWallDuration;
                if (r11 == 0) goto L5;
            L6:
                if (r10 == false) goto L8;
            L10:
                PackedMessages r12 = PackedMessagesChunk.access$2000(this.mPackedChunk);
                r12.reset();
                r12.mCount = this.mCount;
                r12.mWallDuration = this.mWallDuration;
                r12.mCpuDuration = this.mCpuDuration;
                r12.mDelay = this.mDelay;
                r12.copyIdleFrom(this);
                r12.copyLongestFrom(this.mLongestGroup);
                r12.copyShadowFrom(this.mLongestGroup);
                reset();
                return;
            L8:
                if (r11 > LooperMessageManager.LONG_MESSAGE_THRESHOLD) goto L10;
                return;
            L5:
                if (this.mCount != 0) goto L6;
            }

            @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages
            protected void mergeIdle(long r10, long r11) {
                if (r10 <= LooperMessageManager.LONG_MESSAGE_THRESHOLD) goto L5;
                pushToChunk(true);
            L5:
                super.mergeIdle(r10, r11);
                this.mWallDuration += r10;
                this.mCpuDuration += r11;
                pushToChunk(false);
            }

            @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
            protected void reset() {
                super.reset();
                this.mLongestGroup = null;
                Iterator<LinkableHistoryMessageGroup> r10 = this.mHashMap.values().iterator();
            L4:
                if (r10.hasNext() == false) goto L8;
                LinkableHistoryMessageGroup r11 = r10.next();
                if (r11 == null) goto L4;
                LinkableMessagePool.access$1900(this.mMessagePool, r11);
                goto L4
            L8:
                this.mHashMap.clear();
            }
        }

        private CollectionStateHistory() {
            PackedMessagesChunk r10 = new PackedMessagesChunk(50);
            this.mPackedMessagesChunk = r10;
            this.mPackingMessages = new PackingMessages(r10, 30);
        }

        /* synthetic */ CollectionStateHistory(AnonymousClass1 r10) {
            this();
        }

        static /* synthetic */ void access$400(CollectionStateHistory r10, File r11, long r12, long r13, long r14, long r15) {
            r10.dumpAllMessage(r11, r12, r13, r14, r15);
        }

        private void dumpAllMessage(File r10, long r11, long r12, long r13, long r14) {
            PackingMessages.access$1300(this.mPackingMessages, true);
            JSONArray r15 = new JSONArray();
            PackedMessages r16 = PackedMessagesChunk.access$1400(this.mPackedMessagesChunk);
        L3:
            if (r16 == null) goto L7;
            JSONObject r17 = new JSONObject();
            r16.toJson(r17);     // Catch: JSONException -> L11
            r15.put(r17);     // Catch: JSONException -> L11
        L6:
            r16 = PackedMessagesChunk.access$1500(this.mPackedMessagesChunk);
            goto L3
        L7:
            JSONObject r18 = new JSONObject();
            r18.put("history_message", r15);     // Catch: JSONException -> L12
            JSONObject r19 = new JSONObject();     // Catch: JSONException -> L12
            r19.put("dump_wall_time", r11);     // Catch: JSONException -> L12
            r19.put("dump_up_time", r12);     // Catch: JSONException -> L12
            r19.put("last_wall_time", r13);     // Catch: JSONException -> L12
            r19.put("last_cpu_time", r14);     // Catch: JSONException -> L12
            r18.put("history_details", r19);     // Catch: JSONException -> L12
        L9:
            FileUtils.writeFile(LooperMessageConfig.getHistoryJsonFile(r10), r18, false);
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message r10, long r11, long r12, long r14) {
            if (r10 == null) goto L4;
            PackingMessages.access$1200(this.mPackingMessages, r10, r11, r12, r14);
        L5:
            return this;
        L4:
            this.mPackingMessages.mergeIdle(r11, r12);
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

        /* synthetic */ CollectionStatePending(AnonymousClass1 r10) {
            this();
        }

        static /* synthetic */ void access$600(CollectionStatePending r10, long r11) {
            r10.collectPendingMessage(r11);
        }

        static /* synthetic */ void access$700(CollectionStatePending r10, CollectionStatePending r11) {
            r10.setHistoryQueue(r11);
        }

        static /* synthetic */ void access$900(CollectionStatePending r10, File r11) {
            r10.dumpAllMessages(r11);
        }

        private void collectPendingMessage(long r10) {
            MessageQueue r11 = getMainMessageQueue();
            Field r12 = getField("android.os.MessageQueue", "mMessages");
            Field r13 = getField("android.os.Message", "next");
            if (r11 == null) goto L18;
            if (r12 == null) goto L26;
            if (r13 == null) goto L28;
            monitor-enter(r11);     // Catch: Throwable -> L19
            Message r14 = (Message) getMember(r12, r11);     // Catch: Throwable -> L15
            int r15 = 0;
        L9:
            if (r14 == null) goto L13;
            int r16 = r15 + 1;     // Catch: Throwable -> L15
            if (r15 >= 200) goto L13;
            ShadowMessage r17 = new ShadowMessage(null);     // Catch: Throwable -> L15
            r17.copyFrom(r14, r10);     // Catch: Throwable -> L15
            this.mPendingQueue.add(r17);     // Catch: Throwable -> L15
            r14 = (Message) getMember(r13, r14);     // Catch: Throwable -> L15
            r15 = r16;
        L13:
            monitor-exit(r11);     // Catch: Throwable -> L15
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

        private void dumpAllMessages(File r10) {
            JSONArray r11 = new JSONArray();
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
        L4:
            if (r12 >= 200) goto L26;
            if (r13 < this.mHistoryQueue.size()) goto L7;
            if (r14 >= this.mPendingQueue.size()) goto L26;
            int r15 = r14 + 1;
            ShadowMessage r16 = this.mPendingQueue.get(r14);
            JSONObject r17 = new JSONObject();
            r16.toJson(r17);     // Catch: JSONException -> L33
            int r18 = r12 + 1;
            r17.put(OaidModel.KEY_ID, r12);     // Catch: JSONException -> L32
            r11.put(r17);     // Catch: JSONException -> L32
        L24:
            r12 = r18;
        L25:
            r14 = r15;
            goto L4
        L7:
            int r19 = r13 + 1;
            HistoryMessage r20 = this.mHistoryQueue.get(r13);
            JSONObject r21 = new JSONObject();
            r20.toJson(r21);     // Catch: JSONException -> L31
            int r22 = r12 + 1;
            r21.put(OaidModel.KEY_ID, r12);     // Catch: JSONException -> L30
            r11.put(r21);     // Catch: JSONException -> L30
        L11:
            r12 = r22;
        L13:
            if (r14 < this.mPendingQueue.size()) goto L15;
        L17:
            r13 = r19;
            goto L4
        L15:
            if (r20.equals(this.mPendingQueue.get(r14)) == false) goto L17;
            r14 = r14 + 1;
        L26:
            JSONObject r23 = new JSONObject();
            r23.put("pending_messages", r11);     // Catch: JSONException -> L34
        L28:
            FileUtils.writeFile(LooperMessageConfig.getPendingJsonFile(r10), r23, false);
        }

        private static Field getField(String r10, String r11) {
            Field r12 = Class.forName(r10).getDeclaredField(r11);     // Catch: Exception -> L4
            r12.setAccessible(true);     // Catch: Exception -> L4
            return r12;
        L4:
            return null;
        }

        private static MessageQueue getMainMessageQueue() {
            if (Looper.getMainLooper() == null) goto L12;
            Looper r10 = Looper.getMainLooper();
            if (r10 != Looper.myLooper()) goto L8;
            return Looper.myQueue();
        L8:
            if (Build.VERSION.SDK_INT >= 23) goto L18;
            Field r11 = r10.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L14
            r11.setAccessible(true);     // Catch: Throwable -> L14
            return (MessageQueue) r11.get(r10);
        L18:
            return r10.getQueue();
        L12:
            return null;
        }

        private static Object getMember(Field r10, Object r11) {
            return r10.get(r11);
        L4:
            return null;
        }

        private void setHistoryQueue(CollectionStatePending r10) {
            this.mHistoryQueue = r10.mHistoryQueue;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.CollectionState
        public CollectionState onMessage(Message r10, long r11, long r12, long r13) {
            if (r10 == null) goto L4;
            HistoryMessage r14 = new HistoryMessage(null);
            r14.copyFrom(r10, r13);
            r14.setDuration(r11, r12);
            this.mHistoryQueue.add(r14);
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

        /* synthetic */ HistoryMessage(AnonymousClass1 r10) {
            this();
        }

        protected String getTag() {
            String r10 = this.mCallback;
            if (r10 == null) goto L5;
            return r10;
        L5:
            String r11 = this.mTarget;
            if (r11 == null) goto L8;
            return r11;
        L8:
            return LooperMessageManager.NO_MESSAGE_RUNNING;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            setDuration(0, 0);
        }

        protected void setDuration(long r10, long r11) {
            this.mWallDuration = r10;
            this.mCpuDuration = r11;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void toJson(JSONObject r10) {
            super.toJson(r10);
            r10.put("duration", this.mWallDuration);
            r10.put("cpuDuration", this.mCpuDuration);
        }
    }

    private static class HistoryMessageGroup extends HistoryMessage {
        protected int mCount;

        private HistoryMessageGroup() {
            super(null);
        }

        /* synthetic */ HistoryMessageGroup(AnonymousClass1 r10) {
            this();
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            this.mCount = 0;
        }
    }

    private static class LinkableHistoryMessageGroup extends HistoryMessageGroup {
        private LinkableHistoryMessageGroup mNext;

        private LinkableHistoryMessageGroup() {
            super(null);
        }

        /* synthetic */ LinkableHistoryMessageGroup(AnonymousClass1 r10) {
            this();
        }

        static /* synthetic */ void access$2200(LinkableHistoryMessageGroup r10, Message r11, long r12, long r13, long r14) {
            r10.addOneMsg(r11, r12, r13, r14);
        }

        static /* synthetic */ LinkableHistoryMessageGroup access$2400(LinkableHistoryMessageGroup r10) {
            return r10.mNext;
        }

        static /* synthetic */ LinkableHistoryMessageGroup access$2402(LinkableHistoryMessageGroup r10, LinkableHistoryMessageGroup r11) {
            r10.mNext = r11;
            return r11;
        }

        private void addOneMsg(Message r10, long r11, long r12, long r13) {
            this.mWallDuration += r11;
            this.mCpuDuration += r12;
            this.mCount++;
            long r14 = ShadowMessage.getDelay(r10, r13);
            if (this.mDelay <= r14) goto L6;
            this.mDelay = r14;
            return;
        }
    }

    private static class LinkableMessagePool {
        private LinkableHistoryMessageGroup mHead;

        private LinkableMessagePool(int r10) {
        L3:
            if (r10 <= 0) goto L5;
            recycle(new LinkableHistoryMessageGroup(null));
            r10 = r10 - 1;
            goto L3
        }

        /* synthetic */ LinkableMessagePool(int r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ void access$1900(LinkableMessagePool r10, LinkableHistoryMessageGroup r11) {
            r10.recycle(r11);
        }

        static /* synthetic */ LinkableHistoryMessageGroup access$2100(LinkableMessagePool r10) {
            return r10.obtain();
        }

        private LinkableHistoryMessageGroup obtain() {
            LinkableHistoryMessageGroup r10 = this.mHead;
            if (r10 == null) goto L6;
            this.mHead = LinkableHistoryMessageGroup.access$2400(r10);
            LinkableHistoryMessageGroup.access$2402(r10, null);
            r10.reset();
            return r10;
        L6:
            return null;
        }

        private void recycle(LinkableHistoryMessageGroup r10) {
            LinkableHistoryMessageGroup.access$2402(r10, this.mHead);
            this.mHead = r10;
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

        /* synthetic */ PackedMessages(AnonymousClass1 r10) {
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

        protected void copyLongestFrom(HistoryMessageGroup r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            this.mLongestGroupMessageCount = r10.mCount;
            this.mLongestGroupWallDuration = r10.mWallDuration;
            this.mLongestGroupCpuDuration = r10.mCpuDuration;
            this.mLongestGroupDelay = r10.mDelay;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            this.mLongestGroupMessageCount = 0;
            this.mLongestGroupWallDuration = 0;
            this.mLongestGroupCpuDuration = 0;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.TimePeriodHistoryMessages, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void toJson(JSONObject r10) {
            super.toJson(r10);
            int r11 = getType();
            if (r11 != 9) goto L5;
            r10.put("LongestGroupMessageCount", this.mLongestGroupMessageCount);
            r10.put("LongestGroupDuration", this.mLongestGroupWallDuration);
            r10.put("LongestGroupCpuDuration", this.mLongestGroupCpuDuration);
            r10.put("LongestGroupDelay", this.mLongestGroupDelay);
            r10.put("messageCount", this.mCount);
        L5:
            r10.put(NotificationCompat.CATEGORY_MESSAGE, getTag());
            r10.put(WsConstants.KEY_CONNECTION_TYPE, r11);
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

        /* synthetic */ ShadowMessage(AnonymousClass1 r10) {
            this();
        }

        protected static long getDelay(Message r10, long r11) {
            if (isInstant(r10) == true) goto L7;
            return Long.MAX_VALUE;
        L7:
            return r10.getWhen() - r11;
        }

        protected static boolean isInstant(Message r10) {
            if (r10.getWhen() <= 100) goto L5;
            return true;
        L5:
            return false;
        }

        protected void copyFrom(Message r10, long r11) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.getTarget() == null) goto L8;
            this.mTarget = r10.getTarget().getClass().getName();
        L8:
            if (r10.getCallback() == null) goto L23;
            String r12 = r10.getCallback().getClass().getName();
            this.mCallback = r12;
            if (r12.startsWith("Y.ARunnable") == false) goto L23;
            String r13 = r10.getCallback().toString();
            int r14 = 0;
            if (r13.charAt(0) < '0') goto L23;
            if (r13.charAt(0) > '9') goto L23;
            StringBuilder r15 = new StringBuilder();
            r15.append(this.mCallback);
            r15.append(".run$");
        L17:
            if (r14 >= r13.length()) goto L22;
            if (r13.charAt(r14) == '_') goto L22;
            r15.append(r13.charAt(r14));
            r14 = r14 + 1;
        L22:
            this.mCallback = r15.toString();
        L23:
            this.mDelay = getDelay(r10, r11);
            this.mWhat = r10.what;
        }

        protected void copyShadowFrom(ShadowMessage r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            this.mTarget = r10.mTarget;
            this.mCallback = r10.mCallback;
            this.mWhat = r10.mWhat;
        }

        protected boolean equals(ShadowMessage r10) {
            if (this.mDelay == r10.mDelay) goto L5;
        L11:
            return false;
        L5:
            if (this.mWhat != r10.mWhat) goto L11;
            if (this.mTarget != r10.mTarget) goto L11;
            if (this.mCallback != r10.mCallback) goto L11;
            return true;
        }

        protected void reset() {
            this.mTarget = null;
            this.mCallback = null;
            this.mDelay = Long.MAX_VALUE;
            this.mWhat = -1;
        }

        protected void toJson(JSONObject r10) {
            String r11 = this.mCallback;
            if (r11 == null) goto L5;
            r10.put("callback", r11);
        L5:
            String r12 = this.mTarget;
            if (r12 == null) goto L8;
            r10.put(TypedValues.AttributesType.S_TARGET, r12);
        L8:
            int r13 = this.mWhat;
            if (r13 == (-1)) goto L11;
            r10.put("what", r13);
        L11:
            long r14 = this.mDelay;
            if (r14 == Long.MAX_VALUE) goto L15;
            r10.put("when", r14);
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

        /* synthetic */ TimePeriodHistoryMessages(AnonymousClass1 r10) {
            this();
        }

        protected void copyIdleFrom(TimePeriodHistoryMessages r10) {
            this.mIdleCount = r10.mIdleCount;
            this.mIdleWallDuration = r10.mIdleWallDuration;
            this.mIdleCpuDuration = r10.mIdleCpuDuration;
        }

        protected boolean isLongMessage() {
            if (this.mCount == 1) goto L5;
        L7:
            return false;
        L5:
            if ((this.mWallDuration - this.mIdleWallDuration) <= LooperMessageManager.LONG_MESSAGE_THRESHOLD) goto L7;
            return true;
        }

        protected void mergeIdle(long r10, long r11) {
            this.mIdleWallDuration += r10;
            this.mIdleCpuDuration += r11;
            if (r10 <= 1) goto L6;
            this.mIdleCount++;
            return;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessageGroup, com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void reset() {
            super.reset();
            this.mIdleWallDuration = 0;
            this.mIdleCpuDuration = 0;
            this.mIdleCount = 0;
        }

        @Override // com.bytedance.crash.looper.LooperMessageManager.HistoryMessage, com.bytedance.crash.looper.LooperMessageManager.ShadowMessage
        protected void toJson(JSONObject r10) {
            super.toJson(r10);
            if (this.mIdleCount == 0) goto L6;
            r10.put("idleDuration", this.mIdleWallDuration);
            r10.put("idleCpuDuration", this.mIdleCpuDuration);
            r10.put("idleCount", this.mIdleCount);
            return;
        }
    }

    public LooperMessageManager() {
        this.mBlockRunnable = new AnonymousClass1(this);
    }

    static /* synthetic */ JSONArray access$000(LooperMessageManager r10) {
        return r10.mStackArray;
    }

    private void dumpBlockStack(File r10) {
        if (this.mStackArray.length() == 0) goto L6;
        JSONObject r11 = new JSONObject();
        JSONUtils.put(r11, "block_stack", this.mStackArray);
        FileUtils.writeFile(LooperMessageConfig.getBlockStackJsonFile(r10), r11, false);
        return;
    }

    void dumpMessages(File r19) {
        long r10 = System.currentTimeMillis();
        long r12 = SystemClock.uptimeMillis();
        monitor-enter(this);
        AnonymousClass1 r14 = null;
        if (this.mCollectionState != null) goto L7;
        boolean r11 = false;
        long r13 = 0;
        long r16 = 0;
        CollectionStateHistory r15 = null;
        CollectionStateCurrent r17 = null;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L35
        if (r17 == null) goto L18;
        CollectionStateCurrent.access$300(r17, r19, r10 - r13, r11);
    L18:
        if (r15 == null) goto L20;
        CollectionStateHistory.access$400(r15, r19, r10, r12, r13, r16);
    L20:
        dumpBlockStack(r19);
        CollectionStatePending r18 = new CollectionStatePending(r14);
        CollectionStatePending.access$600(r18, r12);
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L23:
        if ((this.mCollectionState instanceof CollectionStatePending) == false) goto L26;
        CollectionStatePending.access$700(r18, (CollectionStatePending) this.mCollectionState);     // Catch: Throwable -> L32
        this.mCollectionState = this.mCollectionStateHistory;     // Catch: Throwable -> L32
    L29:
        monitor-exit(this);     // Catch: Throwable -> L32
        CollectionStatePending.access$900(r18, r19);
        return;
    L26:
        if ((this.mCollectionState instanceof CollectionStateCurrent) == false) goto L29;
        if (r17 == null) goto L29;
        CollectionStateCurrent.access$800(r17);     // Catch: Throwable -> L32
        goto L29
    L7:
        if (this.mLastWallTime != 0) goto L9;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L35
        return;
    L9:
        if ((this.mCollectionState instanceof CollectionStateHistory) == false) goto L12;
        r15 = (CollectionStateHistory) this.mCollectionState;     // Catch: Throwable -> L35
        CollectionStateCurrent r20 = new CollectionStateCurrent(r14);     // Catch: Throwable -> L35
        long r21 = this.mLastWallTime;     // Catch: Throwable -> L35
        long r22 = this.mLastCpuTime;     // Catch: Throwable -> L35
        r11 = this.mIsJavaMessage;     // Catch: Throwable -> L35
        this.mCollectionState = r20;     // Catch: Throwable -> L35
        r17 = r20;
        r16 = r22;
        r13 = r21;
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
        long r11 = this.mLastWallTime;     // Catch: Throwable -> L24
        if (r11 == 0) goto L18;
        long r13 = r12 - r11;     // Catch: Throwable -> L24
        long r15 = r10 - this.mLastCpuTime;     // Catch: Throwable -> L24
        CollectionState r16 = this.mCollectionState.onMessage(r17, r13, r15, this.mLastUpTime);     // Catch: Throwable -> L24
        if (GlobalSwitch.isAllowBlockStack() == false) goto L15;
        if (r17 != null) goto L14;
        DefaultWorkThread.postDelayed(this.mBlockRunnable, WsConstants.EXIT_DELAY_TIME);     // Catch: Throwable -> L24
        goto L15
    L14:
        DefaultWorkThread.removeCallbacks(this.mBlockRunnable);     // Catch: Throwable -> L24
    L15:
        if (r16 != null) goto L17;
        r16 = this.mCollectionStateHistory;     // Catch: Throwable -> L24
    L17:
        this.mCollectionState = r16;     // Catch: Throwable -> L24
    L18:
        if (r17 == null) goto L20;
        boolean r18 = true;
    L21:
        this.mIsJavaMessage = r18;     // Catch: Throwable -> L24
        this.mLastWallTime = r12;     // Catch: Throwable -> L24
        this.mLastCpuTime = r10;     // Catch: Throwable -> L24
        this.mLastUpTime = r14;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L20:
        r18 = false;
        goto L21
    }

    void start() {
        CollectionStateHistory r10 = new CollectionStateHistory(null);
        this.mCollectionStateHistory = r10;
        this.mCollectionState = r10;
        this.mStackArray = new JSONArray();
    }

    void stop() {
        this.mCollectionState = null;
    }
}
