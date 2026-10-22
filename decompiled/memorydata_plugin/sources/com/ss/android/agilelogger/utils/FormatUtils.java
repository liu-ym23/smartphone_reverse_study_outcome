package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class FormatUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<TYPE, com.ss.android.agilelogger.formatter.a> f15015a;

    public static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE BORDER = null;
        public static final TYPE BUNDLE = null;
        public static final TYPE INTENT = null;
        public static final TYPE JSON = null;
        public static final TYPE MSG = null;
        public static final TYPE STACKTRACE = null;
        public static final TYPE STACKTRACE_STR = null;
        public static final TYPE THREAD = null;
        public static final TYPE THROWABLE = null;

        static {
            TYPE r0 = new TYPE("MSG", 0);
            MSG = r0;
            TYPE r1 = new TYPE("JSON", 1);
            JSON = r1;
            TYPE r3 = new TYPE("BUNDLE", 2);
            BUNDLE = r3;
            TYPE r5 = new TYPE("INTENT", 3);
            INTENT = r5;
            TYPE r7 = new TYPE("THROWABLE", 4);
            THROWABLE = r7;
            TYPE r9 = new TYPE("BORDER", 5);
            BORDER = r9;
            TYPE r11 = new TYPE("STACKTRACE", 6);
            STACKTRACE = r11;
            TYPE r13 = new TYPE("THREAD", 7);
            THREAD = r13;
            TYPE r15 = new TYPE("STACKTRACE_STR", 8);
            STACKTRACE_STR = r15;
            $VALUES = new TYPE[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private TYPE(String r1, int r2) {
            super(r1, r2);
        }

        public static TYPE valueOf(String r2) {
            return (TYPE) ZeusTransformUtils.preCheckCast(Enum.valueOf(TYPE.class, r2), TYPE.class, "com.obric.memorydata.plugin");
        }

        public static TYPE[] values() {
            return (TYPE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TYPE[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        ConcurrentHashMap<TYPE, com.ss.android.agilelogger.formatter.a> r0 = new ConcurrentHashMap();
        f15015a = r0;
        r0.put(TYPE.MSG, new com.ss.android.agilelogger.formatter.b.a());
        f15015a.put(TYPE.JSON, new com.ss.android.agilelogger.formatter.b.a.a());
        f15015a.put(TYPE.BUNDLE, new com.ss.android.agilelogger.formatter.b.b.a());
        f15015a.put(TYPE.INTENT, new com.ss.android.agilelogger.formatter.b.b.b());
        f15015a.put(TYPE.BORDER, new com.ss.android.agilelogger.formatter.a.b());
        f15015a.put(TYPE.STACKTRACE, new com.ss.android.agilelogger.formatter.c.a());
        f15015a.put(TYPE.THREAD, new com.ss.android.agilelogger.formatter.d.a());
        f15015a.put(TYPE.THROWABLE, new com.ss.android.agilelogger.formatter.b.c.a());
    }

    public static String a(TYPE r2, Intent r3) {
        return ((com.ss.android.agilelogger.formatter.b.b.b) ZeusTransformUtils.preCheckCast((com.ss.android.agilelogger.formatter.a) ZeusTransformUtils.preCheckCast(f15015a.get(r2), com.ss.android.agilelogger.formatter.a.class, "com.obric.memorydata.plugin"), com.ss.android.agilelogger.formatter.b.b.b.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static String a(TYPE r2, Bundle r3) {
        return ((com.ss.android.agilelogger.formatter.b.b.a) ZeusTransformUtils.preCheckCast((com.ss.android.agilelogger.formatter.a) ZeusTransformUtils.preCheckCast(f15015a.get(r2), com.ss.android.agilelogger.formatter.a.class, "com.obric.memorydata.plugin"), com.ss.android.agilelogger.formatter.b.b.a.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static String a(TYPE r3, String r4) {
        com.ss.android.agilelogger.formatter.a r0 = (com.ss.android.agilelogger.formatter.a) ZeusTransformUtils.preCheckCast(f15015a.get(r3), com.ss.android.agilelogger.formatter.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return r4;
    L5:
        if (r3 != TYPE.BORDER) goto L9;
        return r0.a(new String[]{r4});
    L9:
        return r0.a(r4);
    }

    public static String a(TYPE r2, Thread r3) {
        return ((com.ss.android.agilelogger.formatter.a) ZeusTransformUtils.preCheckCast(f15015a.get(r2), com.ss.android.agilelogger.formatter.a.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static String a(TYPE r2, Throwable r3) {
        return ((com.ss.android.agilelogger.formatter.a) ZeusTransformUtils.preCheckCast(f15015a.get(r2), com.ss.android.agilelogger.formatter.a.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public static String a(TYPE r2, StackTraceElement[] r3) {
        return ((com.ss.android.agilelogger.formatter.a) ZeusTransformUtils.preCheckCast(f15015a.get(r2), com.ss.android.agilelogger.formatter.a.class, "com.obric.memorydata.plugin")).a(r3);
    }
}
