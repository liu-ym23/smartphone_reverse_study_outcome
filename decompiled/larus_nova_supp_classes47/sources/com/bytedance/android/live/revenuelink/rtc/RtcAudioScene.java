package com.bytedance.android.live.revenuelink.rtc;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revenuelink/rtc/RtcAudioScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NORMAL", "CHAT_ROOM", "KTV", "PK", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RtcAudioScene extends Enum<RtcAudioScene> {
    public static final RtcAudioScene CHAT_ROOM = null;
    public static final RtcAudioScene KTV = null;
    public static final RtcAudioScene NORMAL = null;
    public static final RtcAudioScene PK = null;
    public static final /* synthetic */ RtcAudioScene[] a = null;
    private final String value;

    static {
        RtcAudioScene r1 = new RtcAudioScene("NORMAL", 0, "IES_normal");
        NORMAL = r1;
        RtcAudioScene r2 = new RtcAudioScene("CHAT_ROOM", 1, "IES_chatroom");
        CHAT_ROOM = r2;
        RtcAudioScene r3 = new RtcAudioScene("KTV", 2, "IES_KTV");
        KTV = r3;
        RtcAudioScene r4 = new RtcAudioScene("PK", 3, "IES_PK");
        PK = r4;
        a = new RtcAudioScene[]{r1, r2, r3, r4};
    }

    public static RtcAudioScene valueOf(String r1) {
        return (RtcAudioScene) r27.a.a(RtcAudioScene.class, r1);
    }

    public static RtcAudioScene[] values() {
        return (RtcAudioScene[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public RtcAudioScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
