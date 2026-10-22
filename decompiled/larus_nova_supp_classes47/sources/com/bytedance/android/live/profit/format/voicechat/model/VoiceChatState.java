package com.bytedance.android.live.profit.format.voicechat.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/VoiceChatState;", "", "", "state", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "Companion", "a", "CONNECTING", "WAITING", "LISTENING", "THINKING", "SPEAKING", "TIME_UP", "UNKNOWN", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VoiceChatState extends Enum<VoiceChatState> {
    public static final VoiceChatState CONNECTING = null;
    public static final a Companion = null;
    public static final VoiceChatState LISTENING = null;
    public static final VoiceChatState SPEAKING = null;
    public static final VoiceChatState THINKING = null;
    public static final VoiceChatState TIME_UP = null;
    public static final VoiceChatState UNKNOWN = null;
    public static final VoiceChatState WAITING = null;
    public static final /* synthetic */ VoiceChatState[] a = null;
    private final String state;

    public static final class a {
        public a() {
        }
    }

    static {
        VoiceChatState r1 = new VoiceChatState("CONNECTING", 0, "connecting");
        CONNECTING = r1;
        VoiceChatState r2 = new VoiceChatState("WAITING", 1, "waiting");
        WAITING = r2;
        VoiceChatState r3 = new VoiceChatState("LISTENING", 2, "listening");
        LISTENING = r3;
        VoiceChatState r4 = new VoiceChatState("THINKING", 3, "thinking");
        THINKING = r4;
        VoiceChatState r5 = new VoiceChatState("SPEAKING", 4, "speaking");
        SPEAKING = r5;
        VoiceChatState r6 = new VoiceChatState("TIME_UP", 5, "time_up");
        TIME_UP = r6;
        VoiceChatState r7 = new VoiceChatState("UNKNOWN", 6, "unknown");
        UNKNOWN = r7;
        a = new VoiceChatState[]{r1, r2, r3, r4, r5, r6, r7};
        Companion = new a();
    }

    public static VoiceChatState valueOf(String r1) {
        return (VoiceChatState) r27.a.a(VoiceChatState.class, r1);
    }

    public static VoiceChatState[] values() {
        return (VoiceChatState[]) a.clone();
    }

    public final String getState() {
        return this.state;
    }

    public VoiceChatState(String r1, int r2, String r3) {
        super(r1, r2);
        this.state = r3;
    }
}
