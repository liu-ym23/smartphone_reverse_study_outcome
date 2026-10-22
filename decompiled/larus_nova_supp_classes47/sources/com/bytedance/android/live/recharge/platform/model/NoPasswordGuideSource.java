package com.bytedance.android.live.recharge.platform.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/NoPasswordGuideSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PK_ONE_STEP", "DOUYIN_OR_ZFB", "FANS_CLUB_JOIN", "FANS_CLUB_SEND_LIGHT_BOARD", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NoPasswordGuideSource extends Enum<NoPasswordGuideSource> {
    public static final NoPasswordGuideSource DOUYIN_OR_ZFB = null;
    public static final NoPasswordGuideSource FANS_CLUB_JOIN = null;
    public static final NoPasswordGuideSource FANS_CLUB_SEND_LIGHT_BOARD = null;
    public static final NoPasswordGuideSource PK_ONE_STEP = null;
    public static final /* synthetic */ NoPasswordGuideSource[] a = null;
    private final String value;

    static {
        NoPasswordGuideSource r1 = new NoPasswordGuideSource("PK_ONE_STEP", 0, "pk_free_v2");
        PK_ONE_STEP = r1;
        NoPasswordGuideSource r2 = new NoPasswordGuideSource("DOUYIN_OR_ZFB", 1, "52");
        DOUYIN_OR_ZFB = r2;
        NoPasswordGuideSource r3 = new NoPasswordGuideSource("FANS_CLUB_JOIN", 2, "fanclub_free");
        FANS_CLUB_JOIN = r3;
        NoPasswordGuideSource r4 = new NoPasswordGuideSource("FANS_CLUB_SEND_LIGHT_BOARD", 3, "fansclub_panel_light_board_free");
        FANS_CLUB_SEND_LIGHT_BOARD = r4;
        a = new NoPasswordGuideSource[]{r1, r2, r3, r4};
    }

    public static NoPasswordGuideSource valueOf(String r1) {
        return (NoPasswordGuideSource) r27.a.a(NoPasswordGuideSource.class, r1);
    }

    public static NoPasswordGuideSource[] values() {
        return (NoPasswordGuideSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public NoPasswordGuideSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
