package com.bytedance.common.wschannel.event;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MessageAckEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MessageState f2108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2109b;
    private final int c;
    private final int d;
    private final int e;
    private JSONObject f;

    public static final enum MessageState extends Enum<MessageState> {
        private static final /* synthetic */ MessageState[] $VALUES = null;
        public static final MessageState Default = null;
        public static final MessageState Failed = null;
        public static final MessageState Success = null;
        public static final MessageState TimeOut = null;
        final int mState;

        static {
            MessageState r0 = new MessageState("Default", 0, 0);
            Default = r0;
            MessageState r1 = new MessageState("TimeOut", 1, 1);
            TimeOut = r1;
            MessageState r3 = new MessageState("Failed", 2, 2);
            Failed = r3;
            MessageState r5 = new MessageState("Success", 3, 3);
            Success = r5;
            $VALUES = new MessageState[]{r0, r1, r3, r5};
        }

        private MessageState(String r1, int r2, int r3) {
            super(r1, r2);
            this.mState = r3;
        }

        public static MessageState valueOf(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return Default;
        L11:
            return Success;
        L13:
            return Failed;
        L15:
            return TimeOut;
        }

        public static MessageState valueOf(String r2) {
            return (MessageState) ZeusTransformUtils.preCheckCast(Enum.valueOf(MessageState.class, r2), MessageState.class, "com.obric.memorydata.plugin");
        }

        public static MessageState[] values() {
            return (MessageState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MessageState[].class, "com.obric.memorydata.plugin");
        }

        public int getTypeValue() {
            return this.mState;
        }
    }

    public MessageAckEvent(String r2, int r3, int r4, int r5, String r6) {
        this.f2108a = MessageState.Default;
        this.f2109b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = new JSONObject(r6);     // Catch: JSONException -> L5
        return;
    }

    public void a(MessageState r1) {
        this.f2108a = r1;
    }

    public String toString() {
        return "UniqueId:" + this.f2109b + ", ChannelId:" + this.c + ", methodId:" + this.e + ", state:" + this.f2108a + ", logInfo:" + this.f.toString();
    }
}
