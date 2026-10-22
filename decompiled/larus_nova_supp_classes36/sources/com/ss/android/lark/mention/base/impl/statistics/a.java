package com.ss.android.lark.mention.base.impl.statistics;

import android.os.SystemClock;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z5c.a0;
import z5c.c4;
import z5c.e1;
import z5c.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static String a;
    public static boolean b;
    public static int c;
    public static boolean d;
    public static long e;
    public static final Map<String, Long> f = null;

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.statistics.a$a, reason: collision with other inner class name */
    public static final class RunnableC0177a implements Runnable {
        public final /* synthetic */ int a;

        public RunnableC0177a(int r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = this.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            s5c.a r2 = i0.c.a(String.valueOf(SystemClock.elapsedRealtime() - a.e));     // Catch: Throwable -> L9
            if (com.ss.android.lark.mention.base.a.a() == false) goto L6;
            s5c.a r3 = c4.d;     // Catch: Throwable -> L9
        L7:
            s5c.a r4 = a0.c.a(String.valueOf(r0));     // Catch: Throwable -> L9
            Statistics.sendEvent("im_mention_finish", s5c.d.b.b(r2, r3).plus(r3).plus(r4).toJson());     // Catch: Throwable -> L9
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
            return;
        L6:
            r3 = c4.c;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        public final void a() {
            long r0 = this.a;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
            s5c.a r1 = e1.c.a(String.valueOf(SystemClock.elapsedRealtime() - r0));     // Catch: Throwable -> L9
            if (com.ss.android.lark.mention.base.a.a() == false) goto L6;
            s5c.a r3 = c4.d;     // Catch: Throwable -> L9
        L7:
            Statistics.sendEvent("im_mention_same_chat_open", s5c.d.b.b(r1, r3).toJson());     // Catch: Throwable -> L9
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
            return;
        L6:
            r3 = c4.c;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = "";
        f = new LinkedHashMap();
    }

    public static Map a() {
        HashMap r0 = new HashMap();
        if (d == false) goto L5;
        int r1 = 2;
    L6:
        r0.put("sync_type", Integer.valueOf(r1));
        r0.put("chat_type", Integer.valueOf(c));
        return r0;
    L5:
        r1 = 1;
        goto L6
    }

    public static void c(String r4) {
        e = SystemClock.elapsedRealtime();
        if (r4 != null) goto L5;
        return;
    L5:
        LinkedHashMap r0 = (LinkedHashMap) f;
        Long r5 = (Long) r0.get(r4);
        if (r5 == null) goto L8;
        long r1 = r5.longValue();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new b(r1));
    L8:
        r0.clear();
    }

    public static void b(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "channelId");
        f.put(r4, Long.valueOf(SystemClock.elapsedRealtime()));
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC0177a(r3));
    }
}
