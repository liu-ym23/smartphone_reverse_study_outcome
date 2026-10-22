package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ThreadStrategyForRendering extends Enum<ThreadStrategyForRendering> {
    public static final ThreadStrategyForRendering ALL_ON_UI = null;
    public static final ThreadStrategyForRendering MOST_ON_TASM = null;
    public static final ThreadStrategyForRendering MULTI_THREADS = null;
    public static final ThreadStrategyForRendering PART_ON_LAYOUT = null;
    public static final /* synthetic */ ThreadStrategyForRendering[] a = null;
    private int mId;

    static {
        ThreadStrategyForRendering r0 = new ThreadStrategyForRendering("ALL_ON_UI", 0, 0);
        ALL_ON_UI = r0;
        ThreadStrategyForRendering r1 = new ThreadStrategyForRendering("MOST_ON_TASM", 1, 1);
        MOST_ON_TASM = r1;
        ThreadStrategyForRendering r3 = new ThreadStrategyForRendering("PART_ON_LAYOUT", 2, 2);
        PART_ON_LAYOUT = r3;
        ThreadStrategyForRendering r5 = new ThreadStrategyForRendering("MULTI_THREADS", 3, 3);
        MULTI_THREADS = r5;
        a = new ThreadStrategyForRendering[]{r0, r1, r3, r5};
    }

    public static ThreadStrategyForRendering[] values() {
        return (ThreadStrategyForRendering[]) a.clone();
    }

    public int id() {
        return this.mId;
    }

    public static ThreadStrategyForRendering valueOf(String r1) {
        return (ThreadStrategyForRendering) r27.a.a(ThreadStrategyForRendering.class, r1);
    }

    public ThreadStrategyForRendering(String r1, int r2, int r3) {
        super(r1, r2);
        this.mId = r3;
    }
}
