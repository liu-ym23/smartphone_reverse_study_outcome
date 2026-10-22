package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;
import ora.a;
import sra.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class FormatUtils {
    public static final ConcurrentHashMap<TYPE, a> a = null;

    public static final enum TYPE extends Enum<TYPE> {
        public static final TYPE BORDER = null;
        public static final TYPE BUNDLE = null;
        public static final TYPE INTENT = null;
        public static final TYPE JSON = null;
        public static final TYPE MSG = null;
        public static final TYPE STACKTRACE = null;
        public static final TYPE STACKTRACE_STR = null;
        public static final TYPE THREAD = null;
        public static final TYPE THROWABLE = null;
        public static final /* synthetic */ TYPE[] a = null;

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
            a = new TYPE[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        public static TYPE[] values() {
            return (TYPE[]) a.clone();
        }

        public static TYPE valueOf(String r1) {
            return (TYPE) r27.a.a(TYPE.class, r1);
        }

        public TYPE(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        ConcurrentHashMap<TYPE, a> r0 = new ConcurrentHashMap();
        a = r0;
        r0.put(TYPE.MSG, new qra.a());
        r0.put(TYPE.JSON, new rra.a());
        r0.put(TYPE.BUNDLE, new sra.a());
        r0.put(TYPE.INTENT, new b());
        r0.put(TYPE.BORDER, new pra.a());
        r0.put(TYPE.STACKTRACE, new ura.a());
        r0.put(TYPE.THREAD, new vra.a());
        r0.put(TYPE.THROWABLE, new tra.a());
    }

    public static String a(TYPE r1, Intent r2) {
        ((a) a.get(r1)).getClass();
        return b.b(r2);
    }

    public static String b(TYPE r1, Bundle r2) {
        ((a) a.get(r1)).getClass();
        return wra.b.b(r2);
    }

    public static String c(TYPE r2, String r3) {
        a r0 = a.get(r2);
        if (r0 != null) goto L5;
        return r3;
    L5:
        if (r2 != TYPE.BORDER) goto L9;
        return r0.a(new String[]{r3});
    L9:
        return r0.a(r3);
    }

    public static String d(TYPE r1, Thread r2) {
        return a.get(r1).a(r2);
    }

    public static String e(TYPE r1, Throwable r2) {
        return a.get(r1).a(r2);
    }

    public static String f(TYPE r1, StackTraceElement[] r2) {
        return a.get(r1).a(r2);
    }
}
