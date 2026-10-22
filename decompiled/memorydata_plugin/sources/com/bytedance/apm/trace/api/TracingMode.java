package com.bytedance.apm.trace.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum TracingMode extends Enum<TracingMode> {
    private static final /* synthetic */ TracingMode[] $VALUES = null;
    public static final TracingMode BATCH = null;

    static {
        TracingMode r0 = new TracingMode("BATCH", 0);
        BATCH = r0;
        $VALUES = new TracingMode[]{r0};
    }

    private TracingMode(String r1, int r2) {
        super(r1, r2);
    }

    public static TracingMode valueOf(String r2) {
        return (TracingMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(TracingMode.class, r2), TracingMode.class, "com.obric.memorydata.plugin");
    }

    public static TracingMode[] values() {
        return (TracingMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TracingMode[].class, "com.obric.memorydata.plugin");
    }
}
