package com.bytedance.apm.trace.api.wrapper;

/* JADX INFO: loaded from: classes2.dex */
public final enum TracingWrapperMode extends Enum<TracingWrapperMode> {
    public static final TracingWrapperMode PARALLEL_WRAPPER_MODE = null;
    public static final TracingWrapperMode SERIAL_WRAPPER_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TracingWrapperMode[] f3898a = null;

    static {
        TracingWrapperMode r5 = new TracingWrapperMode("PARALLEL_WRAPPER_MODE", 0);
        PARALLEL_WRAPPER_MODE = r5;
        TracingWrapperMode r10 = new TracingWrapperMode("SERIAL_WRAPPER_MODE", 1);
        SERIAL_WRAPPER_MODE = r10;
        f3898a = new TracingWrapperMode[]{r5, r10};
    }

    public static TracingWrapperMode valueOf(String r5) {
        return (TracingWrapperMode) Enum.valueOf(TracingWrapperMode.class, r5);
    }

    public static TracingWrapperMode[] values() {
        return (TracingWrapperMode[]) f3898a.clone();
    }
}
