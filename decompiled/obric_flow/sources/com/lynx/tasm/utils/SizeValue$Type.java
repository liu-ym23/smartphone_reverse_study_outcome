package com.lynx.tasm.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SizeValue$Type extends Enum<SizeValue$Type> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SizeValue$Type f11158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SizeValue$Type f11159b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SizeValue$Type[] f11160c = null;

    static {
        SizeValue$Type r5 = new SizeValue$Type("UNKNOWN", 0);
        SizeValue$Type r10 = new SizeValue$Type("PERCENTAGE", 1);
        f11158a = r10;
        SizeValue$Type r11 = new SizeValue$Type("DEVICE_PX", 2);
        f11159b = r11;
        f11160c = new SizeValue$Type[]{r5, r10, r11};
    }

    public SizeValue$Type(String r5, int r10) {
        super(r5, r10);
    }

    public static SizeValue$Type valueOf(String r5) {
        return (SizeValue$Type) Enum.valueOf(SizeValue$Type.class, r5);
    }

    public static SizeValue$Type[] values() {
        return (SizeValue$Type[]) f11160c.clone();
    }
}
