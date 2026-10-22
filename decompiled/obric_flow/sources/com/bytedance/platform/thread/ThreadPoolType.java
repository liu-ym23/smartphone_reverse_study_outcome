package com.bytedance.platform.thread;

/* JADX INFO: loaded from: classes2.dex */
public final enum ThreadPoolType extends Enum<ThreadPoolType> {
    public static final ThreadPoolType BACKGROUND = null;
    public static final ThreadPoolType DEFAULT = null;
    public static final ThreadPoolType FIXED = null;
    public static final ThreadPoolType IO = null;
    public static final ThreadPoolType SCHEDULED = null;
    public static final ThreadPoolType SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadPoolType[] f7201a = null;

    static {
        ThreadPoolType r5 = new ThreadPoolType("IO", 0);
        IO = r5;
        ThreadPoolType r10 = new ThreadPoolType("DEFAULT", 1);
        DEFAULT = r10;
        ThreadPoolType r11 = new ThreadPoolType("BACKGROUND", 2);
        BACKGROUND = r11;
        ThreadPoolType r12 = new ThreadPoolType("FIXED", 3);
        FIXED = r12;
        ThreadPoolType r13 = new ThreadPoolType("SCHEDULED", 4);
        SCHEDULED = r13;
        ThreadPoolType r14 = new ThreadPoolType("SINGLE", 5);
        SINGLE = r14;
        f7201a = new ThreadPoolType[]{r5, r10, r11, r12, r13, r14};
    }

    public static ThreadPoolType valueOf(String r5) {
        return (ThreadPoolType) Enum.valueOf(ThreadPoolType.class, r5);
    }

    public static ThreadPoolType[] values() {
        return (ThreadPoolType[]) f7201a.clone();
    }
}
