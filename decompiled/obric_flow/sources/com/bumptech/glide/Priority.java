package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public final enum Priority extends Enum<Priority> {
    public static final Priority HIGH = null;
    public static final Priority IMMEDIATE = null;
    public static final Priority LOW = null;
    public static final Priority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Priority[] f1378a = null;

    static {
        Priority r5 = new Priority("IMMEDIATE", 0);
        IMMEDIATE = r5;
        Priority r10 = new Priority("HIGH", 1);
        HIGH = r10;
        Priority r11 = new Priority("NORMAL", 2);
        NORMAL = r11;
        Priority r12 = new Priority("LOW", 3);
        LOW = r12;
        f1378a = new Priority[]{r5, r10, r11, r12};
    }

    public static Priority valueOf(String r5) {
        return (Priority) Enum.valueOf(Priority.class, r5);
    }

    public static Priority[] values() {
        return (Priority[]) f1378a.clone();
    }
}
