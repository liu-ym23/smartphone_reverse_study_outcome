package com.bytedance.android.live.profit.privilege.model.touch;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001b\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$Position", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/GrowthTouchData$Position;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "value", "J", "getValue", "()J", "PositionUnknown", "PositionGiftPanelTop", "PositionDiamondListBanner", "PositionGiftPanelEntrance", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GrowthTouchData$Position extends Enum<GrowthTouchData$Position> {
    public static final GrowthTouchData$Position PositionDiamondListBanner = null;
    public static final GrowthTouchData$Position PositionGiftPanelEntrance = null;
    public static final GrowthTouchData$Position PositionGiftPanelTop = null;
    public static final GrowthTouchData$Position PositionUnknown = null;
    public static final /* synthetic */ GrowthTouchData$Position[] a = null;
    private final long value;

    static {
        GrowthTouchData$Position r1 = new GrowthTouchData$Position("PositionUnknown", 0, 0);
        PositionUnknown = r1;
        GrowthTouchData$Position r2 = new GrowthTouchData$Position("PositionGiftPanelTop", 1, 1);
        PositionGiftPanelTop = r2;
        GrowthTouchData$Position r3 = new GrowthTouchData$Position("PositionDiamondListBanner", 2, 2);
        PositionDiamondListBanner = r3;
        GrowthTouchData$Position r4 = new GrowthTouchData$Position("PositionGiftPanelEntrance", 3, 22);
        PositionGiftPanelEntrance = r4;
        a = new GrowthTouchData$Position[]{r1, r2, r3, r4};
    }

    public static GrowthTouchData$Position valueOf(String r1) {
        return (GrowthTouchData$Position) r27.a.a(GrowthTouchData$Position.class, r1);
    }

    public static GrowthTouchData$Position[] values() {
        return (GrowthTouchData$Position[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public GrowthTouchData$Position(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
