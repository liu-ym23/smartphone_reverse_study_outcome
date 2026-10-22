package com.ss.android.lark.log;

import android.util.Pair;
import com.ss.alog.middleware.ALogService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.component.logger.api.LogLevel;
import com.suite.component.logger.b;
import com.suite.component.logger.f;
import com.suite.lark.component.logger.dynamic.DynamicLogFilterProvider;
import com.suite.lark.component.logger.printer.MoltenV2Printer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pqb.e;
import pqb.g;
import qqb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Log {
    public static final int A_LOGGER = 4;
    public static final int MOLTEN_LOGGER = 8;
    private static String _logTag;
    private static final List<a> errorHooks = null;
    private static boolean inited;
    private static c logger;
    private static f sLogConfig;

    public Log() {
    }

    static {
        logger = new h();
        inited = false;
        _logTag = "lark";
        errorHooks = new CopyOnWriteArrayList();
    }

    public static void initWithNone() {
        sLogConfig = new f(new f.a());
        logger = new h();
        inited = true;
    }

    public static void flushDiskLog() {
        ALogService.flushSafely();
    }

    public static f getLogConfig() {
        return sLogConfig;
    }

    public static void addErrorHook(a r1) {
        errorHooks.add(r1);
    }

    public static void d(String r1) {
        d(_logTag, r1);
    }

    public static void e(String r1) {
        e(_logTag, r1);
    }

    public static void i(String r1) {
        i(_logTag, r1);
    }

    public static void init(f r9) {
        sLogConfig = r9;
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r9, "logConfig");
        e r1 = new e(r9);
        Intrinsics.checkNotNullParameter(r1, "logger");
        e.a = r1;
        g.a r2 = g.a;
        monitor-enter(r2);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (g.a() != null) goto L7;
        new g();     // Catch: Throwable -> L40
    L7:
        monitor-exit(r2);
        boolean r6 = r9.d;
        if (r6 == false) goto L11;
        LogLevel r3 = LogLevel.DEBUG;
    L12:
        com.suite.lark.component.logger.c.a r4 = new com.suite.lark.component.logger.c.a(new b(r3, r9.e, r9.f, r6, r9.c));
        f r5 = f.a;
        Intrinsics.checkNotNullParameter(r5, "cache");
        ((com.suite.component.logger.api.b) r4).c = r5;
        knc.a r7 = knc.a.a;
        Intrinsics.checkNotNullParameter(r7, "collector");
        ((com.suite.component.logger.api.b) r4).d.add(r7);
        d r8 = d.a;
        Intrinsics.checkNotNullParameter(r8, "collector");
        ((com.suite.component.logger.api.b) r4).d.add(r8);
        knc.b r10 = new knc.b();
        Intrinsics.checkNotNullParameter(r10, "collector");
        ((com.suite.component.logger.api.b) r4).d.add(r10);
        lnc.b r11 = new lnc.b();
        Intrinsics.checkNotNullParameter(r11, "interceptor");
        ((com.suite.component.logger.api.b) r4).e.add(r11);
        lnc.c r12 = (lnc.c) DynamicLogFilterProvider.b.getValue();
        Intrinsics.checkNotNullParameter(r12, "interceptor");
        ((com.suite.component.logger.api.b) r4).e.add(r12);
        if (r9.d == false) goto L15;
        com.suite.component.logger.api.g r13 = new com.suite.component.logger.api.g(new LarkLoggerFactory.create.1.1(r9));
        Intrinsics.checkNotNullParameter(r13, "printer");
        ((com.suite.component.logger.api.b) r4).f.add(r13);
    L15:
        mnc.a r14 = new mnc.a(r1, new LarkLoggerFactory.create.1.2(r9));
        Intrinsics.checkNotNullParameter(r14, "printer");
        ((com.suite.component.logger.api.b) r4).f.add(r14);
        if (r9.b != 8) goto L29;
        f.b r15 = r9.i;
        if (r15 == null) goto L20;
        Pair r16 = r15.a();
    L21:
        String r17 = r9.c;
        int r18 = r9.g;
        if (r16 == null) goto L24;
        String r19 = (String) r16.first;
    L25:
        if (r16 == null) goto L27;
        String r20 = (String) r16.second;
    L28:
        MoltenV2Printer r21 = new MoltenV2Printer(new MoltenV2Printer.b(r17, r18, r19, r20), new LarkLoggerFactory.create.1.3(r9));
        Intrinsics.checkNotNullParameter(r21, "printer");
        ((com.suite.component.logger.api.b) r4).f.add(r21);
        goto L29
    L27:
        r20 = null;
        goto L28
    L24:
        r19 = null;
        goto L25
    L20:
        r16 = null;
    L29:
        com.suite.component.logger.api.b r22 = com.suite.component.logger.Log.a;
        Intrinsics.checkNotNullParameter(r4, "builder");
        if (com.suite.component.logger.Log.c == true) goto L37;
        com.suite.component.logger.Log.c = true;
        com.suite.component.logger.Log.a = r4;
        com.suite.component.logger.Log.b = r4.a();
        com.suite.component.logger.api.a r23 = com.suite.component.logger.Log.a.c;
        if (r23 == null) goto L38;
        Iterator<T> r24 = r23.a().iterator();
    L35:
        if (r24.hasNext() == false) goto L38;
        com.suite.component.logger.c r25 = (com.suite.component.logger.c) r24.next();
        com.suite.component.logger.api.h r26 = com.suite.component.logger.Log.b;
        Intrinsics.checkNotNull(r25);
        r26.h(r25);
    L38:
        logger = new d(com.suite.component.logger.Log.b);
        inited = true;
        return;
    L37:
        com.suite.component.logger.Log.b.w("log", "default logger can only set once", null);
        goto L38
    L11:
        r3 = LogLevel.INFO;
        goto L12
    }

    public static boolean removeErrorHook(a r1) {
        return errorHooks.remove(r1);
    }

    public static void v(String r1) {
        v(_logTag, r1);
    }

    public static void w(String r1) {
        w(_logTag, r1);
    }

    public static void d(String r2, String r3) {
        if (cacheLogIfNeeded(3, r2, r3, null) == true) goto L6;
        logger.d(r2, r3);
        return;
    }

    public static void e(String r2, String r3) {
        e(r2, r3, null, false);
    }

    public static void i(String r2, String r3) {
        if (cacheLogIfNeeded(4, r2, r3, null) == true) goto L6;
        logger.i(r2, r3);
        return;
    }

    public static void json(String r1, String r2) {
        json(_logTag, r1, r2);
    }

    public static void v(String r2, String r3) {
        if (cacheLogIfNeeded(2, r2, r3, null) == true) goto L6;
        logger.v(r2, r3);
        return;
    }

    public static void w(String r2, String r3) {
        if (cacheLogIfNeeded(5, r2, r3, null) == true) goto L6;
        logger.w(r2, r3);
        return;
    }

    public static void warn(String r1, Map<String, String> r2) {
        warn(r1, "", r2);
    }

    public static void wtf(String r1, String r2) {
        logger.wtf(r1, r2);
    }

    public static void d(String r1, Throwable r2) {
        d(_logTag, r1, r2);
    }

    public static void e(String r1, Throwable r2) {
        e(r1, r2, false);
    }

    public static void i(String r1, Throwable r2) {
        i(_logTag, r1, r2);
    }

    public static void v(String r1, Throwable r2) {
        v(_logTag, r1, r2);
    }

    public static void w(String r1, Throwable r2) {
        w(_logTag, r1, r2);
    }

    public static void d(String r1, String r2, Throwable r3) {
        if (cacheLogIfNeeded(3, r1, r2, r3) == true) goto L6;
        logger.d(r1, r2, r3);
        return;
    }

    public static void e(String r1, Throwable r2, boolean r3) {
        e(_logTag, r1, r2, r3);
    }

    public static void error(String r1, String[] r2, Map<String, String> r3) {
        error(r1, r2, "", r3);
    }

    public static void i(String r1, String r2, Throwable r3) {
        if (cacheLogIfNeeded(4, r1, r2, r3) == true) goto L6;
        logger.i(r1, r2, r3);
        return;
    }

    public static void json(String r1, String r2, String r3) {
        logger.a(r1, r2, r3);
    }

    public static void v(String r1, String r2, Throwable r3) {
        if (cacheLogIfNeeded(2, r1, r2, r3) == true) goto L6;
        logger.v(r1, r2, r3);
        return;
    }

    public static void w(String r1, String r2, Throwable r3) {
        if (cacheLogIfNeeded(5, r1, r2, r3) == true) goto L6;
        logger.w(r1, r2, r3);
        return;
    }

    public static void warn(String r1, String r2, Map<String, String> r3) {
        warn(r1, _logTag, r2, r3);
    }

    public static void wtf(String r1, String r2, Throwable r3) {
        logger.wtf(r1, r2, r3);
    }

    public static void xml(String r1, String r2, String r3) {
        logger.c(r1, r2, r3);
    }

    public static void e(String r1, String r2, Throwable r3) {
        e(r1, r2, r3, false);
    }

    public static void warn(String r1, String[] r2, Map<String, String> r3) {
        warn(r1, r2, "", r3);
    }

    private static boolean cacheLogIfNeeded(int r3, String r4, String r5, Throwable r6) {
        if (inited == false) goto L22;
        return false;
    L22:
        Object r1 = com.suite.component.logger.c.w;     // Catch: Throwable -> L19
        com.suite.component.logger.c r2 = com.suite.component.logger.c.a.a();     // Catch: Throwable -> L19
        LogLevel r7 = LogLevel.fromValue(r3);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r7, "<set-?>");     // Catch: Throwable -> L19
        r2.a = r7;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L19
        r2.b = r4;     // Catch: Throwable -> L19
        r2.b("[cache] " + r5);     // Catch: Throwable -> L19
        r2.j = r6;     // Catch: Throwable -> L19
        r2.k = ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L19
        String r8 = ThreadMethodProxy.currentThread().getName();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r8, "<set-?>");     // Catch: Throwable -> L19
        r2.l = r8;     // Catch: Throwable -> L19
        r2.o = System.currentTimeMillis();     // Catch: Throwable -> L19
        int r9 = knc.b.a;     // Catch: Throwable -> L19
        knc.b.a.a(r2);     // Catch: Throwable -> L19
        f r10 = f.a;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r2, "item");     // Catch: Throwable -> L19
        LinkedList<com.suite.component.logger.c> r11 = f.b;     // Catch: Throwable -> L19
        monitor-enter(r11);     // Catch: Throwable -> L19
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L7:
        if (f.b.size() >= 2000) goto L9;
        f.b.add(r2);     // Catch: Throwable -> L12
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L19
        return true;
    L23:
        return true;
    }

    public static void debug(String r6, String r7, String r8, Map<String, String> r9) {
        logger.b(LogLevel.DEBUG.getNumber(), r6, new String[]{r7}, r8, r9);
    }

    public static void e(String r1, String r2, Throwable r3, boolean r4) {
        if (cacheLogIfNeeded(6, r1, r2, r3) == true) goto L5;
        logger.e(r1, r2, r3);
    L5:
        reportError(r1, r2, r3, Boolean.valueOf(r4));
    }

    public static void error(String r6, String[] r7, String r8, Map<String, String> r9) {
        logger.b(LogLevel.ERROR.getNumber(), r6, r7, r8, r9);
    }

    public static void info(String r6, String r7, String r8, Map<String, String> r9) {
        logger.b(LogLevel.INFO.getNumber(), r6, new String[]{r7}, r8, r9);
    }

    public static void reportError(String r0, String r1, Throwable r2, Boolean r3) {
        Iterator<a> r4 = errorHooks.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        a r5 = r4.next();
        r3.booleanValue();
        r5.e();
        goto L4
    }

    public static void warn(String r6, String[] r7, String r8, Map<String, String> r9) {
        logger.b(LogLevel.WARN.getNumber(), r6, r7, r8, r9);
    }

    public static void error(String r2, String r3, String r4, Map<String, String> r5) {
        error(r2, new String[]{r3}, r4, r5);
    }

    public static void warn(String r2, String r3, String r4, Map<String, String> r5) {
        warn(r2, new String[]{r3}, r4, r5);
    }
}
