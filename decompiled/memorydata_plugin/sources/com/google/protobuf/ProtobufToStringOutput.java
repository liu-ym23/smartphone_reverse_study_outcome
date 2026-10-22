package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtobufToStringOutput {
    private static final ThreadLocal<OutputMode> outputMode = null;

    private static final enum OutputMode extends java.lang.Enum<OutputMode> {
        private static final /* synthetic */ OutputMode[] $VALUES = null;
        public static final OutputMode DEBUG_FORMAT = null;
        public static final OutputMode TEXT_FORMAT = null;

        private static /* synthetic */ OutputMode[] $values() {
            return new OutputMode[]{DEBUG_FORMAT, TEXT_FORMAT};
        }

        static {
            DEBUG_FORMAT = new OutputMode("DEBUG_FORMAT", 0);
            TEXT_FORMAT = new OutputMode("TEXT_FORMAT", 1);
            $VALUES = $values();
        }

        private OutputMode(String r1, int r2) {
            super(r1, r2);
        }

        public static OutputMode valueOf(String r2) {
            return (OutputMode) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(OutputMode.class, r2), OutputMode.class, "com.obric.memorydata.plugin");
        }

        public static OutputMode[] values() {
            return (OutputMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OutputMode[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        outputMode = ThreadLocal.withInitial($$Lambda$ProtobufToStringOutput$zsFHwd0Edg1HYgggSb6Iyf7mqPU.INSTANCE);
    }

    private ProtobufToStringOutput() {
    }

    public static void callWithDebugFormat(Runnable r2) {
        callWithSpecificFormat((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), OutputMode.DEBUG_FORMAT);
    }

    private static void callWithSpecificFormat(Runnable r2, OutputMode r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        OutputMode r5 = setOutputMode(r3);
        r4.run();     // Catch: Throwable -> L6
        setOutputMode(r5);
        return;
    L6:
        th = move-exception;
        setOutputMode(r5);
        throw th;
    }

    public static void callWithTextFormat(Runnable r2) {
        callWithSpecificFormat((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), OutputMode.TEXT_FORMAT);
    }

    static /* synthetic */ OutputMode lambda$static$0() {
        return OutputMode.TEXT_FORMAT;
    }

    private static OutputMode setOutputMode(OutputMode r4) {
        ThreadLocal<OutputMode> r0 = outputMode;
        OutputMode r1 = (OutputMode) ZeusTransformUtils.preCheckCast(r0.get(), OutputMode.class, "com.obric.memorydata.plugin");
        r0.set(r4);
        return r1;
    }

    public static boolean shouldOutputDebugFormat() {
        if (outputMode.get() != OutputMode.DEBUG_FORMAT) goto L5;
        return true;
    L5:
        return false;
    }
}
