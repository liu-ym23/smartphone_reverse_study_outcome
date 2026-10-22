package com.airbnb.lottie.network;

import u.b;

/* JADX INFO: loaded from: classes.dex */
public final enum FileExtension extends Enum<FileExtension> {
    public static final FileExtension JSON = null;
    public static final FileExtension ZIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileExtension[] f1294a = null;
    public final String extension;

    static {
        FileExtension r5 = new FileExtension("JSON", 0, ".json");
        JSON = r5;
        FileExtension r10 = new FileExtension("ZIP", 1, ".zip");
        ZIP = r10;
        f1294a = new FileExtension[]{r5, r10};
    }

    public FileExtension(String r5, int r10, String r11) {
        super(r5, r10);
        this.extension = r11;
    }

    public static FileExtension forFile(String r5) {
        FileExtension[] r10 = values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        FileExtension r13 = r10[r12];
        if (r5.endsWith(r13.extension) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        b.b("Unable to find correct extension for " + r5);
        return JSON;
    }

    public static FileExtension valueOf(String r5) {
        return (FileExtension) Enum.valueOf(FileExtension.class, r5);
    }

    public static FileExtension[] values() {
        return (FileExtension[]) f1294a.clone();
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
