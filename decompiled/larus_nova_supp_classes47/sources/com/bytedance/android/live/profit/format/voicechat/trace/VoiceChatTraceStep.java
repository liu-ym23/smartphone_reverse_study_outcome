package com.bytedance.android.live.profit.format.voicechat.trace;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/trace/VoiceChatTraceStep;", "", "", "step", "Ljava/lang/String;", "getStep", "()Ljava/lang/String;", "BOOT_CONFIG", "CHAT_START_REQ", "CHAT_CLOSE_REQ", "SEND_GIFT", "CLICK_START", "CHAT_CLOSE", "GIFT_ANIM_START", "GIFT_ANIM_END", "JOIN_ROOM", "FIRST_FRAME", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VoiceChatTraceStep extends Enum<VoiceChatTraceStep> {
    public static final VoiceChatTraceStep BOOT_CONFIG = null;
    public static final VoiceChatTraceStep CHAT_CLOSE = null;
    public static final VoiceChatTraceStep CHAT_CLOSE_REQ = null;
    public static final VoiceChatTraceStep CHAT_START_REQ = null;
    public static final VoiceChatTraceStep CLICK_START = null;
    public static final VoiceChatTraceStep FIRST_FRAME = null;
    public static final VoiceChatTraceStep GIFT_ANIM_END = null;
    public static final VoiceChatTraceStep GIFT_ANIM_START = null;
    public static final VoiceChatTraceStep JOIN_ROOM = null;
    public static final VoiceChatTraceStep SEND_GIFT = null;
    public static final /* synthetic */ VoiceChatTraceStep[] a = null;
    private final String step;

    public static VoiceChatTraceStep valueOf(String r1) {
        return (VoiceChatTraceStep) a.a(VoiceChatTraceStep.class, r1);
    }

    public static VoiceChatTraceStep[] values() {
        return (VoiceChatTraceStep[]) a.clone();
    }

    static {
        VoiceChatTraceStep r1 = new VoiceChatTraceStep("BOOT_CONFIG", 0, "boot_config");
        BOOT_CONFIG = r1;
        VoiceChatTraceStep r2 = new VoiceChatTraceStep("CHAT_START_REQ", 1, "chat_start_req");
        CHAT_START_REQ = r2;
        VoiceChatTraceStep r3 = new VoiceChatTraceStep("CHAT_CLOSE_REQ", 2, "chat_close_req");
        CHAT_CLOSE_REQ = r3;
        VoiceChatTraceStep r4 = new VoiceChatTraceStep("SEND_GIFT", 3, "send_gift");
        SEND_GIFT = r4;
        VoiceChatTraceStep r5 = new VoiceChatTraceStep("CLICK_START", 4, "click");
        CLICK_START = r5;
        VoiceChatTraceStep r6 = new VoiceChatTraceStep("CHAT_CLOSE", 5, "chat_close");
        CHAT_CLOSE = r6;
        VoiceChatTraceStep r7 = new VoiceChatTraceStep("GIFT_ANIM_START", 6, "animation_start");
        GIFT_ANIM_START = r7;
        VoiceChatTraceStep r8 = new VoiceChatTraceStep("GIFT_ANIM_END", 7, "animation_end");
        GIFT_ANIM_END = r8;
        VoiceChatTraceStep r9 = new VoiceChatTraceStep("JOIN_ROOM", 8, "join_room");
        JOIN_ROOM = r9;
        VoiceChatTraceStep r10 = new VoiceChatTraceStep("FIRST_FRAME", 9, "first_frame");
        FIRST_FRAME = r10;
        a = new VoiceChatTraceStep[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getStep() {
        return this.step;
    }

    public VoiceChatTraceStep(String r1, int r2, String r3) {
        super(r1, r2);
        this.step = r3;
    }
}
