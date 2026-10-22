package com.bytedance.android.live.link.player;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/link/player/DeviceType;", "", "NORMAL_MOBILE", "NORMAL_MOBILE_H", "PAD_V", "PAD_H", "FOLD_FULL", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DeviceType extends Enum<DeviceType> {
    public static final DeviceType FOLD_FULL = null;
    public static final DeviceType NORMAL_MOBILE = null;
    public static final DeviceType NORMAL_MOBILE_H = null;
    public static final DeviceType PAD_H = null;
    public static final DeviceType PAD_V = null;
    public static final /* synthetic */ DeviceType[] a = null;

    static {
        DeviceType r1 = new DeviceType("NORMAL_MOBILE", 0);
        NORMAL_MOBILE = r1;
        DeviceType r2 = new DeviceType("NORMAL_MOBILE_H", 1);
        NORMAL_MOBILE_H = r2;
        DeviceType r3 = new DeviceType("PAD_V", 2);
        PAD_V = r3;
        DeviceType r4 = new DeviceType("PAD_H", 3);
        PAD_H = r4;
        DeviceType r5 = new DeviceType("FOLD_FULL", 4);
        FOLD_FULL = r5;
        a = new DeviceType[]{r1, r2, r3, r4, r5};
    }

    public static DeviceType valueOf(String r1) {
        return (DeviceType) a.a(DeviceType.class, r1);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) a.clone();
    }

    public DeviceType(String r1, int r2) {
        super(r1, r2);
    }
}
