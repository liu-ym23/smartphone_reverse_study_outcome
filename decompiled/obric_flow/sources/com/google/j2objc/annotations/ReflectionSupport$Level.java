package com.google.j2objc.annotations;

/* JADX INFO: loaded from: classes2.dex */
public final enum ReflectionSupport$Level extends Enum<ReflectionSupport$Level> {
    public static final ReflectionSupport$Level FULL = null;
    public static final ReflectionSupport$Level NATIVE_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReflectionSupport$Level[] f9463a = null;

    static {
        ReflectionSupport$Level r5 = new ReflectionSupport$Level("NATIVE_ONLY", 0);
        NATIVE_ONLY = r5;
        ReflectionSupport$Level r10 = new ReflectionSupport$Level("FULL", 1);
        FULL = r10;
        f9463a = new ReflectionSupport$Level[]{r5, r10};
    }

    public static ReflectionSupport$Level valueOf(String r5) {
        return (ReflectionSupport$Level) Enum.valueOf(ReflectionSupport$Level.class, r5);
    }

    public static ReflectionSupport$Level[] values() {
        return (ReflectionSupport$Level[]) f9463a.clone();
    }
}
