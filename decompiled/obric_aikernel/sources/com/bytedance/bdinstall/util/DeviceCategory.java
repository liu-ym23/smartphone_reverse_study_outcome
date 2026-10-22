package com.bytedance.bdinstall.util;

/* JADX INFO: loaded from: classes.dex */
public final enum DeviceCategory extends Enum<DeviceCategory> {
    private static final /* synthetic */ DeviceCategory[] $VALUES = null;
    public static final DeviceCategory AR = null;
    public static final DeviceCategory CAR = null;
    public static final DeviceCategory PAD = null;
    public static final DeviceCategory PHONE = null;
    public static final DeviceCategory TV = null;
    public static final DeviceCategory VR = null;
    public static final DeviceCategory WATCH = null;
    private String lower;

    static {
        DeviceCategory r10 = new DeviceCategory("PHONE", 0, "phone");
        PHONE = r10;
        DeviceCategory r11 = new DeviceCategory("PAD", 1, "pad");
        PAD = r11;
        DeviceCategory r12 = new DeviceCategory("TV", 2, "tv");
        TV = r12;
        DeviceCategory r13 = new DeviceCategory("CAR", 3, "car");
        CAR = r13;
        DeviceCategory r14 = new DeviceCategory("VR", 4, "vr");
        VR = r14;
        DeviceCategory r15 = new DeviceCategory("AR", 5, "ar");
        AR = r15;
        DeviceCategory r16 = new DeviceCategory("WATCH", 6, "watch");
        WATCH = r16;
        $VALUES = new DeviceCategory[]{r10, r11, r12, r13, r14, r15, r16};
    }

    private DeviceCategory(String r10, int r11, String r12) {
        super(r10, r11);
        this.lower = r12;
    }

    public static DeviceCategory valueOf(String r10) {
        return (DeviceCategory) Enum.valueOf(DeviceCategory.class, r10);
    }

    public static DeviceCategory[] values() {
        return (DeviceCategory[]) $VALUES.clone();
    }

    public String getLower() {
        return this.lower;
    }
}
