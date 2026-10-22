package com.bytedance.android.live.effect.avadjust;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/effect/avadjust/AvAdjustTemplate$AvAdjustContentType", "", "Lcom/bytedance/android/live/effect/avadjust/AvAdjustTemplate$AvAdjustContentType;", "COLOR_ADJUST", "LENS", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AvAdjustTemplate$AvAdjustContentType extends Enum<AvAdjustTemplate$AvAdjustContentType> {
    public static final AvAdjustTemplate$AvAdjustContentType COLOR_ADJUST = null;
    public static final AvAdjustTemplate$AvAdjustContentType LENS = null;
    public static final /* synthetic */ AvAdjustTemplate$AvAdjustContentType[] a = null;

    static {
        AvAdjustTemplate$AvAdjustContentType r1 = new AvAdjustTemplate$AvAdjustContentType("COLOR_ADJUST", 0);
        COLOR_ADJUST = r1;
        AvAdjustTemplate$AvAdjustContentType r2 = new AvAdjustTemplate$AvAdjustContentType("LENS", 1);
        LENS = r2;
        a = new AvAdjustTemplate$AvAdjustContentType[]{r1, r2};
    }

    public static AvAdjustTemplate$AvAdjustContentType valueOf(String r1) {
        return (AvAdjustTemplate$AvAdjustContentType) r27.a.a(AvAdjustTemplate$AvAdjustContentType.class, r1);
    }

    public static AvAdjustTemplate$AvAdjustContentType[] values() {
        return (AvAdjustTemplate$AvAdjustContentType[]) a.clone();
    }

    public AvAdjustTemplate$AvAdjustContentType(String r1, int r2) {
        super(r1, r2);
    }
}
