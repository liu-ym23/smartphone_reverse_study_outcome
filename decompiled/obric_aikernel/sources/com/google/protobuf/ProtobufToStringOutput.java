package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
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

        private OutputMode(String r10, int r11) {
            super(r10, r11);
        }

        public static OutputMode valueOf(String r10) {
            return (OutputMode) java.lang.Enum.valueOf(OutputMode.class, r10);
        }

        public static OutputMode[] values() {
            return (OutputMode[]) $VALUES.clone();
        }
    }

    static {
        outputMode = ThreadLocal.withInitial(b.f4295a);
    }

    private ProtobufToStringOutput() {
    }

    public static /* synthetic */ OutputMode a() {
        return lambda$static$0();
    }

    public static void callWithDebugFormat(Runnable r10) {
        callWithSpecificFormat(r10, OutputMode.DEBUG_FORMAT);
    }

    private static void callWithSpecificFormat(Runnable r10, OutputMode r11) {
        OutputMode r12 = setOutputMode(r11);
        r10.run();     // Catch: Throwable -> L6
        setOutputMode(r12);
        return;
    L6:
        th = move-exception;
        setOutputMode(r12);
        throw th;
    }

    public static void callWithTextFormat(Runnable r10) {
        callWithSpecificFormat(r10, OutputMode.TEXT_FORMAT);
    }

    private static /* synthetic */ OutputMode lambda$static$0() {
        return OutputMode.TEXT_FORMAT;
    }

    private static OutputMode setOutputMode(OutputMode r10) {
        ThreadLocal<OutputMode> r11 = outputMode;
        OutputMode r12 = r11.get();
        r11.set(r10);
        return r12;
    }

    public static boolean shouldOutputDebugFormat() {
        if (outputMode.get() != OutputMode.DEBUG_FORMAT) goto L5;
        return true;
    L5:
        return false;
    }
}
