package com.bytedance.android.live.browser;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/browser/LynxThreadStrategy;", "", "ALL_ON_UI", "MOST_ON_TASM", "PART_ON_LAYOUT", "MULTI_THREADS", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LynxThreadStrategy extends Enum<LynxThreadStrategy> {
    public static final LynxThreadStrategy ALL_ON_UI = null;
    public static final LynxThreadStrategy MOST_ON_TASM = null;
    public static final LynxThreadStrategy MULTI_THREADS = null;
    public static final LynxThreadStrategy PART_ON_LAYOUT = null;
    public static final /* synthetic */ LynxThreadStrategy[] a = null;

    static {
        LynxThreadStrategy r1 = new LynxThreadStrategy("ALL_ON_UI", 0);
        ALL_ON_UI = r1;
        LynxThreadStrategy r2 = new LynxThreadStrategy("MOST_ON_TASM", 1);
        MOST_ON_TASM = r2;
        LynxThreadStrategy r3 = new LynxThreadStrategy("PART_ON_LAYOUT", 2);
        PART_ON_LAYOUT = r3;
        LynxThreadStrategy r4 = new LynxThreadStrategy("MULTI_THREADS", 3);
        MULTI_THREADS = r4;
        a = new LynxThreadStrategy[]{r1, r2, r3, r4};
    }

    public static LynxThreadStrategy valueOf(String r1) {
        return (LynxThreadStrategy) r27.a.a(LynxThreadStrategy.class, r1);
    }

    public static LynxThreadStrategy[] values() {
        return (LynxThreadStrategy[]) a.clone();
    }

    public LynxThreadStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
