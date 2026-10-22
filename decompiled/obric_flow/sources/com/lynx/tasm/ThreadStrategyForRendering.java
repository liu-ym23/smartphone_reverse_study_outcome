package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
public final enum ThreadStrategyForRendering extends Enum<ThreadStrategyForRendering> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadStrategyForRendering f10065b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadStrategyForRendering f10066c = null;
    public static final ThreadStrategyForRendering d = null;
    public static final ThreadStrategyForRendering e = null;
    public static final /* synthetic */ ThreadStrategyForRendering[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10067a;

    static {
        ThreadStrategyForRendering r5 = new ThreadStrategyForRendering("ALL_ON_UI", 0, 0);
        f10065b = r5;
        ThreadStrategyForRendering r10 = new ThreadStrategyForRendering("MOST_ON_TASM", 1, 1);
        f10066c = r10;
        ThreadStrategyForRendering r11 = new ThreadStrategyForRendering("PART_ON_LAYOUT", 2, 2);
        d = r11;
        ThreadStrategyForRendering r12 = new ThreadStrategyForRendering("MULTI_THREADS", 3, 3);
        e = r12;
        f = new ThreadStrategyForRendering[]{r5, r10, r11, r12};
    }

    public ThreadStrategyForRendering(String r5, int r10, int r11) {
        super(r5, r10);
        this.f10067a = r11;
    }

    public static ThreadStrategyForRendering valueOf(String r5) {
        return (ThreadStrategyForRendering) Enum.valueOf(ThreadStrategyForRendering.class, r5);
    }

    public static ThreadStrategyForRendering[] values() {
        return (ThreadStrategyForRendering[]) f.clone();
    }
}
