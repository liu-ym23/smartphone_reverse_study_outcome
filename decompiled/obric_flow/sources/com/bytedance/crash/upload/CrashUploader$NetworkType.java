package com.bytedance.crash.upload;

/* JADX INFO: loaded from: classes2.dex */
public final enum CrashUploader$NetworkType extends Enum<CrashUploader$NetworkType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CrashUploader$NetworkType f4090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CrashUploader$NetworkType f4091b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CrashUploader$NetworkType f4092c = null;
    public static final CrashUploader$NetworkType d = null;
    public static final CrashUploader$NetworkType e = null;
    public static final CrashUploader$NetworkType f = null;
    public static final /* synthetic */ CrashUploader$NetworkType[] g = null;

    static {
        CrashUploader$NetworkType r5 = new CrashUploader$NetworkType("NONE", 0);
        f4090a = r5;
        CrashUploader$NetworkType r10 = new CrashUploader$NetworkType("MOBILE", 1);
        f4091b = r10;
        CrashUploader$NetworkType r11 = new CrashUploader$NetworkType("MOBILE_2G", 2);
        CrashUploader$NetworkType r12 = new CrashUploader$NetworkType("MOBILE_3G", 3);
        f4092c = r12;
        CrashUploader$NetworkType r13 = new CrashUploader$NetworkType("WIFI", 4);
        d = r13;
        CrashUploader$NetworkType r14 = new CrashUploader$NetworkType("MOBILE_4G", 5);
        e = r14;
        CrashUploader$NetworkType r15 = new CrashUploader$NetworkType("MOBILE_5G", 6);
        f = r15;
        g = new CrashUploader$NetworkType[]{r5, r10, r11, r12, r13, r14, r15, new CrashUploader$NetworkType("WIFI_24GHZ", 7), new CrashUploader$NetworkType("WIFI_5GHZ", 8), new CrashUploader$NetworkType("MOBILE_3G_H", 9), new CrashUploader$NetworkType("MOBILE_3G_HP", 10)};
    }

    public CrashUploader$NetworkType(String r5, int r10) {
        super(r5, r10);
    }

    public static CrashUploader$NetworkType valueOf(String r5) {
        return (CrashUploader$NetworkType) Enum.valueOf(CrashUploader$NetworkType.class, r5);
    }

    public static CrashUploader$NetworkType[] values() {
        return (CrashUploader$NetworkType[]) g.clone();
    }
}
