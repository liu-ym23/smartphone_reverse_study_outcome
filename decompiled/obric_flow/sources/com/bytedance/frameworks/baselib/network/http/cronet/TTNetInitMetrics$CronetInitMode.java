package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes2.dex */
public final enum TTNetInitMetrics$CronetInitMode extends Enum<TTNetInitMetrics$CronetInitMode> {
    public static final TTNetInitMetrics$CronetInitMode FORCE_INIT = null;
    public static final TTNetInitMetrics$CronetInitMode LAZY_INIT = null;
    public static final TTNetInitMetrics$CronetInitMode NONE = null;
    public static final TTNetInitMetrics$CronetInitMode PRE_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTNetInitMetrics$CronetInitMode[] f4670a = null;
    final int initMode;

    static {
        TTNetInitMetrics$CronetInitMode r5 = new TTNetInitMetrics$CronetInitMode("NONE", 0, 0);
        NONE = r5;
        TTNetInitMetrics$CronetInitMode r10 = new TTNetInitMetrics$CronetInitMode("LAZY_INIT", 1, 1);
        LAZY_INIT = r10;
        TTNetInitMetrics$CronetInitMode r11 = new TTNetInitMetrics$CronetInitMode("PRE_INIT", 2, 2);
        PRE_INIT = r11;
        TTNetInitMetrics$CronetInitMode r12 = new TTNetInitMetrics$CronetInitMode("FORCE_INIT", 3, 3);
        FORCE_INIT = r12;
        f4670a = new TTNetInitMetrics$CronetInitMode[]{r5, r10, r11, r12};
    }

    public TTNetInitMetrics$CronetInitMode(String r5, int r10, int r11) {
        super(r5, r10);
        this.initMode = r11;
    }

    public static TTNetInitMetrics$CronetInitMode valueOf(String r5) {
        return (TTNetInitMetrics$CronetInitMode) Enum.valueOf(TTNetInitMetrics$CronetInitMode.class, r5);
    }

    public static TTNetInitMetrics$CronetInitMode[] values() {
        return (TTNetInitMetrics$CronetInitMode[]) f4670a.clone();
    }
}
