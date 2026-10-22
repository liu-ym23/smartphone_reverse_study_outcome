package com.bytedance.android.live.room.incentiveinfo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/model/CarouselTabType;", "", "", "value", "I", "getValue", "()I", "DOU_PLUS", "FRESHMAN_SUPPORT", "ANCHOR_TRAFFIC_SUPPORT", "ROOM_INDICATOR", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CarouselTabType extends Enum<CarouselTabType> {
    public static final CarouselTabType ANCHOR_TRAFFIC_SUPPORT = null;
    public static final CarouselTabType DOU_PLUS = null;
    public static final CarouselTabType FRESHMAN_SUPPORT = null;
    public static final CarouselTabType ROOM_INDICATOR = null;
    public static final /* synthetic */ CarouselTabType[] a = null;
    private final int value;

    static {
        CarouselTabType r2 = new CarouselTabType("DOU_PLUS", 0, 1);
        DOU_PLUS = r2;
        CarouselTabType r3 = new CarouselTabType("FRESHMAN_SUPPORT", 1, 2);
        FRESHMAN_SUPPORT = r3;
        CarouselTabType r4 = new CarouselTabType("ANCHOR_TRAFFIC_SUPPORT", 2, 3);
        ANCHOR_TRAFFIC_SUPPORT = r4;
        CarouselTabType r5 = new CarouselTabType("ROOM_INDICATOR", 3, 4);
        ROOM_INDICATOR = r5;
        a = new CarouselTabType[]{r2, r3, r4, r5};
    }

    public static CarouselTabType valueOf(String r1) {
        return (CarouselTabType) a.a(CarouselTabType.class, r1);
    }

    public static CarouselTabType[] values() {
        return (CarouselTabType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CarouselTabType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
