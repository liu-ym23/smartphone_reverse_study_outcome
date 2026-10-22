package com.bytedance.apm.trace.api.wrapper;

/* JADX INFO: loaded from: classes.dex */
public final enum TracingWrapperMode extends Enum<TracingWrapperMode> {
    private static final /* synthetic */ TracingWrapperMode[] $VALUES = null;
    public static final TracingWrapperMode PARALLEL_WRAPPER_MODE = null;
    public static final TracingWrapperMode SERIAL_WRAPPER_MODE = null;

    static {
        TracingWrapperMode r10 = new TracingWrapperMode("PARALLEL_WRAPPER_MODE", 0);
        PARALLEL_WRAPPER_MODE = r10;
        TracingWrapperMode r11 = new TracingWrapperMode("SERIAL_WRAPPER_MODE", 1);
        SERIAL_WRAPPER_MODE = r11;
        $VALUES = new TracingWrapperMode[]{r10, r11};
    }

    private TracingWrapperMode(String r10, int r11) {
        super(r10, r11);
    }

    public static TracingWrapperMode valueOf(String r10) {
        return (TracingWrapperMode) Enum.valueOf(TracingWrapperMode.class, r10);
    }

    public static TracingWrapperMode[] values() {
        return (TracingWrapperMode[]) $VALUES.clone();
    }
}
