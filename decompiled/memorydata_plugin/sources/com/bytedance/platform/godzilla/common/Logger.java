package com.bytedance.platform.godzilla.common;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Level f2988b;
    private static e c;

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.common.Logger$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2989a = null;

        static {
            int[] r0 = new int[Level.values().length];
            f2989a = r0;
            r0[Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f2989a[Level.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f2989a[Level.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f2989a[Level.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level NONE = null;
        public static final Level WARNING = null;

        static {
            Level r0 = new Level(CipherConst.LEVEL_DEBUG, 0);
            DEBUG = r0;
            Level r1 = new Level(CipherConst.LEVEL_INFO, 1);
            INFO = r1;
            Level r3 = new Level("WARNING", 2);
            WARNING = r3;
            Level r5 = new Level(CipherConst.LEVEL_ERROR, 3);
            ERROR = r5;
            Level r7 = new Level("NONE", 4);
            NONE = r7;
            $VALUES = new Level[]{r0, r1, r3, r5, r7};
        }

        private Level(String r1, int r2) {
            super(r1, r2);
        }

        public static Level valueOf(String r2) {
            return (Level) ZeusTransformUtils.preCheckCast(Enum.valueOf(Level.class, r2), Level.class, "com.obric.memorydata.plugin");
        }

        public static Level[] values() {
            return (Level[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Level[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f2988b = Level.INFO;
        f2987a = false;
        c = new AnonymousClass1();
    }

    public static void a(Level r1) {
        f2988b = r1;
        if (r1 != Level.DEBUG) goto L6;
        f2987a = true;
        return;
    }

    public static void a(e r2) {
        c = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
    }

    public static void a(String r1, String r2) {
        a(r1, r2, Level.INFO);
    }

    public static void a(String r2, String r3, Level r4) {
        if (r4.ordinal() < f2988b.ordinal()) goto L6;
        c.a(r2, r3, r4);
        return;
    }
}
