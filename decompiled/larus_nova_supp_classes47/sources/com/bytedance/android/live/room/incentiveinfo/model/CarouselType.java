package com.bytedance.android.live.room.incentiveinfo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/model/CarouselType;", "", "ADD", "REMOVE", "UPDATE", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CarouselType extends Enum<CarouselType> {
    public static final CarouselType ADD = null;
    public static final CarouselType REMOVE = null;
    public static final CarouselType UPDATE = null;
    public static final /* synthetic */ CarouselType[] a = null;

    static {
        CarouselType r1 = new CarouselType("ADD", 0);
        ADD = r1;
        CarouselType r2 = new CarouselType("REMOVE", 1);
        REMOVE = r2;
        CarouselType r3 = new CarouselType("UPDATE", 2);
        UPDATE = r3;
        a = new CarouselType[]{r1, r2, r3};
    }

    public static CarouselType valueOf(String r1) {
        return (CarouselType) a.a(CarouselType.class, r1);
    }

    public static CarouselType[] values() {
        return (CarouselType[]) a.clone();
    }

    public CarouselType(String r1, int r2) {
        super(r1, r2);
    }
}
