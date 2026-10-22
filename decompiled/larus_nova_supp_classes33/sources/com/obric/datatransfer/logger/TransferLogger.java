package com.obric.datatransfer.logger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TransferLogger {
    public static com.obric.datatransfer.logger.a b;
    public final String a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/datatransfer/logger/TransferLogger$Level;", "", "", "levelValue", "I", "getLevelValue", "()I", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "datatransfer_release"}, k = 1, mv = {1, 8, 0})
    public static final enum Level extends Enum<Level> {
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level VERBOSE = null;
        public static final Level WARN = null;
        public static final /* synthetic */ Level[] a = null;
        private final int levelValue;

        public static Level valueOf(String r1) {
            return (Level) r27.a.a(Level.class, r1);
        }

        public static Level[] values() {
            return (Level[]) a.clone();
        }

        static {
            Level r0 = new Level("VERBOSE", 0, 2);
            VERBOSE = r0;
            Level r1 = new Level("DEBUG", 1, 3);
            DEBUG = r1;
            Level r4 = new Level("INFO", 2, 4);
            INFO = r4;
            Level r7 = new Level("WARN", 3, 5);
            WARN = r7;
            Level r9 = new Level("ERROR", 4, 6);
            ERROR = r9;
            a = new Level[]{r0, r1, r4, r7, r9};
        }

        public final int getLevelValue() {
            return this.levelValue;
        }

        public Level(String r1, int r2, int r3) {
            super(r1, r2);
            this.levelValue = r3;
        }
    }

    public static final class a {
        public static TransferLogger a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "tag");
            return new TransferLogger(r1);
        }
    }

    static {
        b = new b();
    }

    public TransferLogger(String r1) {
        this.a = r1;
    }

    public static void a(TransferLogger r3, String r4) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "message");
        b.log(Level.DEBUG, r3.a, r4, null);
    }

    public static void c(TransferLogger r3, String r4) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "message");
        b.log(Level.INFO, r3.a, r4, null);
    }

    public final void b(String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        b.log(Level.ERROR, this.a, r4, r5);
    }

    public final void d(String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        b.log(Level.WARN, this.a, r4, r5);
    }
}
