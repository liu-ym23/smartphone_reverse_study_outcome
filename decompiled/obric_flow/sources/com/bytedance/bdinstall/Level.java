package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes2.dex */
public final enum Level extends Enum<Level> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Level[] f3949a = null;

    static {
        f3949a = new Level[]{new Level("L0", 0), new Level("L1", 1)};
    }

    public Level(String r5, int r10) {
        super(r5, r10);
    }

    public static Level valueOf(String r5) {
        return (Level) Enum.valueOf(Level.class, r5);
    }

    public static Level[] values() {
        return (Level[]) f3949a.clone();
    }
}
