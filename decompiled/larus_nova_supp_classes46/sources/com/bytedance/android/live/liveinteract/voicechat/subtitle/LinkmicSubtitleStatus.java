package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "CHECK_IN", "OPEN", "CLOSE", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicSubtitleStatus extends Enum<LinkmicSubtitleStatus> {
    public static final LinkmicSubtitleStatus CHECK_IN = null;
    public static final LinkmicSubtitleStatus CLOSE = null;
    public static final LinkmicSubtitleStatus OPEN = null;
    public static final LinkmicSubtitleStatus UNKNOWN = null;
    public static final /* synthetic */ LinkmicSubtitleStatus[] a = null;
    private final int value;

    static {
        LinkmicSubtitleStatus r1 = new LinkmicSubtitleStatus("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        LinkmicSubtitleStatus r2 = new LinkmicSubtitleStatus("CHECK_IN", 1, 1);
        CHECK_IN = r2;
        LinkmicSubtitleStatus r3 = new LinkmicSubtitleStatus("OPEN", 2, 2);
        OPEN = r3;
        LinkmicSubtitleStatus r4 = new LinkmicSubtitleStatus("CLOSE", 3, 3);
        CLOSE = r4;
        a = new LinkmicSubtitleStatus[]{r1, r2, r3, r4};
    }

    public static LinkmicSubtitleStatus valueOf(String r1) {
        return (LinkmicSubtitleStatus) r27.a.a(LinkmicSubtitleStatus.class, r1);
    }

    public static LinkmicSubtitleStatus[] values() {
        return (LinkmicSubtitleStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicSubtitleStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
