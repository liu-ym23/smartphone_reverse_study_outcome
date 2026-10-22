package com.bytedance.common.utility.io;

/* JADX INFO: loaded from: classes2.dex */
public final enum FileUtils$ImageType extends Enum<FileUtils$ImageType> {
    public static final FileUtils$ImageType GIF = null;
    public static final FileUtils$ImageType JPG = null;
    public static final FileUtils$ImageType PNG = null;
    public static final FileUtils$ImageType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileUtils$ImageType[] f3968a = null;

    static {
        FileUtils$ImageType r5 = new FileUtils$ImageType("UNKNOWN", 0);
        UNKNOWN = r5;
        FileUtils$ImageType r10 = new FileUtils$ImageType("JPG", 1);
        JPG = r10;
        FileUtils$ImageType r11 = new FileUtils$ImageType("PNG", 2);
        PNG = r11;
        FileUtils$ImageType r12 = new FileUtils$ImageType("GIF", 3);
        GIF = r12;
        f3968a = new FileUtils$ImageType[]{r5, r10, r11, r12};
    }

    public static FileUtils$ImageType valueOf(String r5) {
        return (FileUtils$ImageType) Enum.valueOf(FileUtils$ImageType.class, r5);
    }

    public static FileUtils$ImageType[] values() {
        return (FileUtils$ImageType[]) f3968a.clone();
    }
}
