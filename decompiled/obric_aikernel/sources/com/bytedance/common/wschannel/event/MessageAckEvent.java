package com.bytedance.common.wschannel.event;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MessageAckEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MessageState f1298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f1302e;

    public static final enum MessageState extends Enum<MessageState> {
        private static final /* synthetic */ MessageState[] $VALUES = null;
        public static final MessageState Default = null;
        public static final MessageState Failed = null;
        public static final MessageState Success = null;
        public static final MessageState TimeOut = null;
        final int mState;

        static {
            MessageState r10 = new MessageState("Default", 0, 0);
            Default = r10;
            MessageState r11 = new MessageState("TimeOut", 1, 1);
            TimeOut = r11;
            MessageState r12 = new MessageState("Failed", 2, 2);
            Failed = r12;
            MessageState r13 = new MessageState("Success", 3, 3);
            Success = r13;
            $VALUES = new MessageState[]{r10, r11, r12, r13};
        }

        private MessageState(String r10, int r11, int r12) {
            super(r10, r11);
            this.mState = r12;
        }

        public static MessageState valueOf(int r10) {
            if (r10 == 1) goto L15;
            if (r10 == 2) goto L13;
            if (r10 == 3) goto L11;
            return Default;
        L11:
            return Success;
        L13:
            return Failed;
        L15:
            return TimeOut;
        }

        public static MessageState valueOf(String r10) {
            return (MessageState) Enum.valueOf(MessageState.class, r10);
        }

        public static MessageState[] values() {
            return (MessageState[]) $VALUES.clone();
        }

        public int getTypeValue() {
            return this.mState;
        }
    }

    public MessageAckEvent(String r10, int r11, int r12, int r13, String r14) {
        this.f1298a = MessageState.Default;
        this.f1299b = r10;
        this.f1300c = r11;
        this.f1301d = r13;
        this.f1302e = new JSONObject(r14);     // Catch: JSONException -> L5
        return;
    }

    public void a(MessageState r10) {
        this.f1298a = r10;
    }

    public String toString() {
        return "UniqueId:" + this.f1299b + ", ChannelId:" + this.f1300c + ", methodId:" + this.f1301d + ", state:" + this.f1298a + ", logInfo:" + this.f1302e.toString();
    }
}
