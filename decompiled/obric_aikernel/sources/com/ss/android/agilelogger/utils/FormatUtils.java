package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;
import pa.a;
import ta.b;

/* JADX INFO: loaded from: classes2.dex */
public class FormatUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<TYPE, a> f7850a;

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
            TYPE r10 = new TYPE("MSG", 0);
            MSG = r10;
            TYPE r11 = new TYPE("JSON", 1);
            JSON = r11;
            TYPE r12 = new TYPE("BUNDLE", 2);
            BUNDLE = r12;
            TYPE r13 = new TYPE("INTENT", 3);
            INTENT = r13;
            TYPE r14 = new TYPE("THROWABLE", 4);
            THROWABLE = r14;
            TYPE r15 = new TYPE("BORDER", 5);
            BORDER = r15;
            TYPE r16 = new TYPE("STACKTRACE", 6);
            STACKTRACE = r16;
            TYPE r17 = new TYPE("THREAD", 7);
            THREAD = r17;
            TYPE r18 = new TYPE("STACKTRACE_STR", 8);
            STACKTRACE_STR = r18;
            $VALUES = new TYPE[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private TYPE(String r10, int r11) {
            super(r10, r11);
        }

        public static TYPE valueOf(String r10) {
            return (TYPE) Enum.valueOf(TYPE.class, r10);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }
    }

    static {
        ConcurrentHashMap<TYPE, a> r10 = new ConcurrentHashMap();
        f7850a = r10;
        r10.put(TYPE.MSG, new ra.a());
        f7850a.put(TYPE.JSON, new sa.a());
        f7850a.put(TYPE.BUNDLE, new ta.a());
        f7850a.put(TYPE.INTENT, new b());
        f7850a.put(TYPE.BORDER, new qa.a());
        f7850a.put(TYPE.STACKTRACE, new va.a());
        f7850a.put(TYPE.THREAD, new wa.a());
        f7850a.put(TYPE.THROWABLE, new ua.a());
    }

    public static String a(TYPE r10, Intent r11) {
        return ((b) f7850a.get(r10)).b(r11);
    }

    public static String b(TYPE r10, Bundle r11) {
        return ((ta.a) f7850a.get(r10)).b(r11);
    }

    public static String c(TYPE r10, String r11) {
        a r12 = f7850a.get(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        if (r10 != TYPE.BORDER) goto L9;
        return r12.a(new String[]{r11});
    L9:
        return r12.a(r11);
    }

    public static String d(TYPE r10, Thread r11) {
        return f7850a.get(r10).a(r11);
    }

    public static String e(TYPE r10, Throwable r11) {
        return f7850a.get(r10).a(r11);
    }

    public static String f(TYPE r10, StackTraceElement[] r11) {
        return f7850a.get(r10).a(r11);
    }
}
