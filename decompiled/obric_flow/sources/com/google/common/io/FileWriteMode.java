package com.google.common.io;

/* JADX INFO: loaded from: classes2.dex */
public final enum FileWriteMode extends Enum<FileWriteMode> {
    public static final FileWriteMode APPEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileWriteMode[] f9299a = null;

    static {
        FileWriteMode r5 = new FileWriteMode("APPEND", 0);
        APPEND = r5;
        f9299a = new FileWriteMode[]{r5};
    }

    public static FileWriteMode valueOf(String r5) {
        return (FileWriteMode) Enum.valueOf(FileWriteMode.class, r5);
    }

    public static FileWriteMode[] values() {
        return (FileWriteMode[]) f9299a.clone();
    }
}
