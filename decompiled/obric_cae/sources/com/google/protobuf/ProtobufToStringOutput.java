package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class ProtobufToStringOutput {
    private static final ThreadLocal<OutputMode> outputMode = null;

    public static final enum OutputMode extends java.lang.Enum<OutputMode> {
        private static final /* synthetic */ OutputMode[] $VALUES = null;
        public static final OutputMode DEBUG_FORMAT = null;
        public static final OutputMode DEFAULT_FORMAT = null;
        public static final OutputMode TEXT_FORMAT = null;

        private static /* synthetic */ OutputMode[] $values() {
            return new OutputMode[]{DEBUG_FORMAT, TEXT_FORMAT, DEFAULT_FORMAT};
        }

        static {
            DEBUG_FORMAT = new OutputMode("DEBUG_FORMAT", 0);
            TEXT_FORMAT = new OutputMode("TEXT_FORMAT", 1);
            DEFAULT_FORMAT = new OutputMode("DEFAULT_FORMAT", 2);
            $VALUES = $values();
        }

        private OutputMode(String r8, int r10) {
            super(r8, r10);
        }

        public static OutputMode valueOf(String r8) {
            return (OutputMode) java.lang.Enum.valueOf(OutputMode.class, r8);
        }

        public static OutputMode[] values() {
            return (OutputMode[]) $VALUES.clone();
        }
    }

    static {
        outputMode = ThreadLocal.withInitial(new f(0));
    }

    private ProtobufToStringOutput() {
    }

    public static /* synthetic */ OutputMode a() {
        return lambda$static$0();
    }

    public static void callWithDebugFormat(Runnable r8) {
        callWithSpecificFormat(r8, OutputMode.DEBUG_FORMAT);
    }

    private static void callWithSpecificFormat(Runnable r8, OutputMode r10) {
        OutputMode r11 = setOutputMode(r10);
        r8.run();     // Catch: Throwable -> L6
        setOutputMode(r11);
        return;
    L6:
        th = move-exception;
        setOutputMode(r11);
        throw th;
    }

    public static void callWithTextFormat(Runnable r8) {
        callWithSpecificFormat(r8, OutputMode.TEXT_FORMAT);
    }

    public static boolean isDefaultFormat() {
        if (outputMode.get() != OutputMode.DEFAULT_FORMAT) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ OutputMode lambda$static$0() {
        return OutputMode.DEFAULT_FORMAT;
    }

    private static OutputMode setOutputMode(OutputMode r8) {
        ThreadLocal<OutputMode> r10 = outputMode;
        OutputMode r11 = r10.get();
        r10.set(r8);
        return r11;
    }

    public static boolean shouldOutputDebugFormat() {
        if (outputMode.get() != OutputMode.DEBUG_FORMAT) goto L5;
        return true;
    L5:
        return false;
    }
}
