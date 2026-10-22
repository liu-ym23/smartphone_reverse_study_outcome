package com.bytedance.android.live.revenue.platform.interacteffect.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/interacteffect/api/MessageType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "MSG_TYPE_LIVE_INTERACTION", "MSG_TYPE_LIVE_GIFT_NOTIFY", "UNKNOWN", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MessageType extends Enum<MessageType> {
    public static final a Companion = null;
    public static final MessageType MSG_TYPE_LIVE_GIFT_NOTIFY = null;
    public static final MessageType MSG_TYPE_LIVE_INTERACTION = null;
    public static final MessageType UNKNOWN = null;
    public static final /* synthetic */ MessageType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.revenue.platform.interacteffect.api.MessageType$a] */
    static {
        MessageType r1 = new MessageType("MSG_TYPE_LIVE_INTERACTION", 0, 40);
        MSG_TYPE_LIVE_INTERACTION = r1;
        MessageType r2 = new MessageType("MSG_TYPE_LIVE_GIFT_NOTIFY", 1, 57);
        MSG_TYPE_LIVE_GIFT_NOTIFY = r2;
        MessageType r3 = new MessageType("UNKNOWN", 2, -1);
        UNKNOWN = r3;
        a = new MessageType[]{r1, r2, r3};
        Companion = new a();
    }

    public static MessageType valueOf(String r1) {
        return (MessageType) r27.a.a(MessageType.class, r1);
    }

    public static MessageType[] values() {
        return (MessageType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MessageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
