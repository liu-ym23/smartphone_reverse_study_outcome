package com.facebook.imagepipeline.common;

/* JADX INFO: loaded from: classes2.dex */
public final enum Priority extends Enum<Priority> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Priority f8048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Priority f8049b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Priority f8050c = null;
    public static final /* synthetic */ Priority[] d = null;

    static {
        Priority r5 = new Priority("LOW", 0);
        f8048a = r5;
        Priority r10 = new Priority("MEDIUM", 1);
        f8049b = r10;
        Priority r11 = new Priority("HIGH", 2);
        f8050c = r11;
        d = new Priority[]{r5, r10, r11, new Priority("IMMEDIATE", 3)};
    }

    public Priority(String r5, int r10) {
        super(r5, r10);
    }

    public static Priority valueOf(String r5) {
        return (Priority) Enum.valueOf(Priority.class, r5);
    }

    public static Priority[] values() {
        return (Priority[]) d.clone();
    }
}
