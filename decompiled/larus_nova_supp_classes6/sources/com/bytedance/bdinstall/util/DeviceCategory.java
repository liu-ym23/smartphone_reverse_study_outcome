package com.bytedance.bdinstall.util;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum DeviceCategory extends Enum<DeviceCategory> {
    public static final DeviceCategory AR = null;
    public static final DeviceCategory CAR = null;
    public static final DeviceCategory PAD = null;
    public static final DeviceCategory PHONE = null;
    public static final DeviceCategory TV = null;
    public static final DeviceCategory VR = null;
    public static final DeviceCategory WATCH = null;
    public static final /* synthetic */ DeviceCategory[] a = null;
    private String lower;

    static {
        DeviceCategory r0 = new DeviceCategory("PHONE", 0, "phone");
        PHONE = r0;
        DeviceCategory r1 = new DeviceCategory("PAD", 1, "pad");
        PAD = r1;
        DeviceCategory r2 = new DeviceCategory("TV", 2, "tv");
        TV = r2;
        DeviceCategory r4 = new DeviceCategory("CAR", 3, "car");
        CAR = r4;
        DeviceCategory r6 = new DeviceCategory("VR", 4, "vr");
        VR = r6;
        DeviceCategory r8 = new DeviceCategory("AR", 5, "ar");
        AR = r8;
        DeviceCategory r10 = new DeviceCategory("WATCH", 6, "watch");
        WATCH = r10;
        a = new DeviceCategory[]{r0, r1, r2, r4, r6, r8, r10};
    }

    public static DeviceCategory[] values() {
        return (DeviceCategory[]) a.clone();
    }

    public String getLower() {
        return this.lower;
    }

    public static DeviceCategory valueOf(String r1) {
        return (DeviceCategory) a.a(DeviceCategory.class, r1);
    }

    public DeviceCategory(String r1, int r2, String r3) {
        super(r1, r2);
        this.lower = r3;
    }
}
