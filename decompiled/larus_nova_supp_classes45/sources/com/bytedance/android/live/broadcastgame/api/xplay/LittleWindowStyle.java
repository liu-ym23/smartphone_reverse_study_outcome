package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/LittleWindowStyle;", "", "Large", "Small", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LittleWindowStyle extends Enum<LittleWindowStyle> {
    public static final LittleWindowStyle Large = null;
    public static final LittleWindowStyle Small = null;
    public static final /* synthetic */ LittleWindowStyle[] a = null;

    static {
        LittleWindowStyle r1 = new LittleWindowStyle("Large", 0);
        Large = r1;
        LittleWindowStyle r2 = new LittleWindowStyle("Small", 1);
        Small = r2;
        a = new LittleWindowStyle[]{r1, r2};
    }

    public static LittleWindowStyle valueOf(String r1) {
        return (LittleWindowStyle) r27.a.a(LittleWindowStyle.class, r1);
    }

    public static LittleWindowStyle[] values() {
        return (LittleWindowStyle[]) a.clone();
    }

    public LittleWindowStyle(String r1, int r2) {
        super(r1, r2);
    }
}
