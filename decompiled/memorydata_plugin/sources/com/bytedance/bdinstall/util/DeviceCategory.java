package com.bytedance.bdinstall.util;

import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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
        DeviceCategory r0 = new DeviceCategory("PHONE", 0, MemoryKeyInfoEntity.KEY_PHONE);
        PHONE = r0;
        DeviceCategory r1 = new DeviceCategory("PAD", 1, "pad");
        PAD = r1;
        DeviceCategory r3 = new DeviceCategory("TV", 2, f.e);
        TV = r3;
        DeviceCategory r5 = new DeviceCategory("CAR", 3, "car");
        CAR = r5;
        DeviceCategory r7 = new DeviceCategory("VR", 4, "vr");
        VR = r7;
        DeviceCategory r9 = new DeviceCategory("AR", 5, "ar");
        AR = r9;
        DeviceCategory r11 = new DeviceCategory("WATCH", 6, "watch");
        WATCH = r11;
        $VALUES = new DeviceCategory[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private DeviceCategory(String r1, int r2, String r3) {
        super(r1, r2);
        this.lower = r3;
    }

    public static DeviceCategory valueOf(String r2) {
        return (DeviceCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(DeviceCategory.class, r2), DeviceCategory.class, "com.obric.memorydata.plugin");
    }

    public static DeviceCategory[] values() {
        return (DeviceCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DeviceCategory[].class, "com.obric.memorydata.plugin");
    }

    public String getLower() {
        return this.lower;
    }
}
