package com.bytedance.apm.trace.api;

/* JADX INFO: loaded from: classes2.dex */
public final enum TracingMode extends Enum<TracingMode> {
    public static final TracingMode BATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TracingMode[] f3897a = null;

    static {
        TracingMode r5 = new TracingMode("BATCH", 0);
        BATCH = r5;
        f3897a = new TracingMode[]{r5};
    }

    public static TracingMode valueOf(String r5) {
        return (TracingMode) Enum.valueOf(TracingMode.class, r5);
    }

    public static TracingMode[] values() {
        return (TracingMode[]) f3897a.clone();
    }
}
