package com.ss.android.lark.image.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum DiskCacheStrategy extends Enum<DiskCacheStrategy> {
    public static final DiskCacheStrategy ALL = null;
    public static final DiskCacheStrategy NONE = null;
    public static final DiskCacheStrategy RESULT = null;
    public static final DiskCacheStrategy SOURCE = null;
    public static final /* synthetic */ DiskCacheStrategy[] a = null;
    private final boolean cacheResult;
    private final boolean cacheSource;

    static {
        DiskCacheStrategy r0 = new DiskCacheStrategy("ALL", 0, true, true);
        ALL = r0;
        DiskCacheStrategy r1 = new DiskCacheStrategy("NONE", 1, false, false);
        NONE = r1;
        DiskCacheStrategy r4 = new DiskCacheStrategy("SOURCE", 2, true, false);
        SOURCE = r4;
        DiskCacheStrategy r5 = new DiskCacheStrategy("RESULT", 3, false, true);
        RESULT = r5;
        a = new DiskCacheStrategy[]{r0, r1, r4, r5};
    }

    public static DiskCacheStrategy[] values() {
        return (DiskCacheStrategy[]) a.clone();
    }

    public boolean cacheResult() {
        return this.cacheResult;
    }

    public boolean cacheSource() {
        return this.cacheSource;
    }

    public static DiskCacheStrategy valueOf(String r1) {
        return (DiskCacheStrategy) a.a(DiskCacheStrategy.class, r1);
    }

    public DiskCacheStrategy(String r1, int r2, boolean r3, boolean r4) {
        super(r1, r2);
        this.cacheSource = r3;
        this.cacheResult = r4;
    }
}
