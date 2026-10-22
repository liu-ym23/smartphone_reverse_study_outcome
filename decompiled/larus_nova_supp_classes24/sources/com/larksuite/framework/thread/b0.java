package com.larksuite.framework.thread;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b0 {
    public static ScheduledExecutorService a;
    public static ScheduledFuture<?> b;
    public static ScheduledFuture<?> c;
    public static int d;
    public static int e;
    public static boolean f;
    public static boolean g;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        public static void a() {
            long r0 = System.currentTimeMillis();
            if ((b0.e % 2) != 0) goto L28;
            ScheduledFuture<?> r2 = b0.b;
            if (r2 != null) goto L7;
        L20:
            b0.b = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new a(), 0, TimeUnit.SECONDS);
            PThreadPoolExecutor r3 = (com.larksuite.framework.thread.b) CoreThreadPool.getDefault().getFixedThreadPool();
            int r4 = r3.getQueue().size();
            Log.i("TestThreadPoolDelay", "backUpTaskNum:" + r4);
            if (r4 >= 10) goto L25;
            int r5 = r3.getCorePoolSize();
            int r6 = com.larksuite.framework.thread.b.j;
            if (r5 == r6) goto L28;
            r3.setCorePoolSize(r6);
            r3.setMaximumPoolSize(r6 + 3);
            goto L28
        L25:
            Log.e("TestThreadPoolDelay", "fixedThread Pool over backup task , num:" + r4);
            int r7 = com.larksuite.framework.thread.b.j;
            int r8 = Math.min(r7 * 2, (int) (((double) r7) + Math.ceil((double) (((float) r4) / ((float) 10)))));
            Log.i("TestThreadPoolDelay", "need thread num:" + r8);
            if (r3.getCorePoolSize() == r8) goto L28;
            r3.setCorePoolSize(r8);
            r3.setMaximumPoolSize(r8 + 3);
            goto L28
        L7:
            if (r2.isDone() == true) goto L19;
            Log.e("TestThreadPoolDelay", "found ScheduleThreadPool schedule task delay over 10s, please check", new Throwable(), true);
            PThreadScheduledThreadPoolExecutor r9 = CoreThreadPool.getDefault().getScheduleThreadPool();
            if ((r9 instanceof g) == false) goto L13;
            ThreadFactory r10 = ((g) r9).getThreadFactory();
            if ((r10 instanceof n) == false) goto L13;
            ((n) r10).b();
        L13:
            int r11 = b0.d + 1;
            b0.d = r11;
            if (r11 < 2) goto L20;
            PThreadScheduledThreadPoolExecutor r12 = (g) CoreThreadPool.getDefault().getScheduleThreadPool();
            int r13 = r12.getCorePoolSize();
            if (r13 >= 6) goto L20;
            r12.setCorePoolSize(6);
            Log.w("TestThreadPoolDelay", "org add schedule thread pool core size is: " + r13 + ", add to 6");
            goto L20
        L19:
            b0.d = 0;
        L28:
            b0.e++;
            t r14 = (t) CoreThreadPool.getDefault().getCachedThreadPool();
            b0.a(r14.a(), r14.d(), 10000);
            t r15 = (t) CoreThreadPool.getDefault().getFixedThreadPool();
            b0.a(r15.a(), r15.d(), 5000);
            t r16 = (t) CoreThreadPool.getDefault().getScheduleThreadPool();
            b0.a(r16.a(), r16.d(), 5000);
            w r17 = (w) CoreThreadPool.getNonblockingHandler();
            List<a0> r19 = r17.f;
            monitor-enter(r19);
            LinkedList r20 = new LinkedList(r17.f);     // Catch: Throwable -> L34
            monitor-exit(r19);     // Catch: Throwable -> L34
            b0.a(r20, r17.a(), 5000);
            w r21 = (w) CoreThreadPool.getBackgroundHandler();
            b0.a(r21.b(), r21.a(), 5000);
            w r22 = (w) CoreThreadPool.getSerialTaskHandler();
            b0.a(r22.b(), r22.a(), 5000);
            Log.d("TestThreadPoolDelay", "check public thread block cost time:" + (System.currentTimeMillis() - r0));
            return;
        L34:
            th = move-exception;
            throw th;
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

    public b0() {
    }

    public static void d() {
        d = 0;
        b();
        monitor-enter(b0.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (c == null) goto L8;
        monitor-exit(b0.class);     // Catch: Throwable -> L11
        return;
    L8:
        Log.i("TestThreadPoolDelay", "startScheduleThreadPoolTest");     // Catch: Throwable -> L11
        c = a.scheduleWithFixedDelay(new b(), 10, 5, TimeUnit.SECONDS);     // Catch: Throwable -> L11
        monitor-exit(b0.class);     // Catch: Throwable -> L11
    }

    public static void b() {
        if (a == null) goto L6;
        return;
    L6:
        monitor-enter(b0.class);
        a = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk_test");     // Catch: Throwable -> L10
        monitor-exit(b0.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static String c() {
        CoreThreadPool.a r0 = CoreThreadPool.mCoreThreadPoolDep;
        String r1 = "";
        if (r0 != null) goto L5;
        return "";
    L5:
        Context r2 = r0.getContext();
        if (r2 != null) goto L22;
        return "";
    L22:
    L18:
        e = e;
    L19:
        Log.w("TestThreadPoolDelay", "get version name exception", e);
        String r3 = r1;
    L21:
        return r3.toLowerCase();
    L9:
        if (TextUtils.isEmpty("8.2.0-alpha1") == false) goto L11;
        r3 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 128).versionName;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r3) == false) goto L21;
        return "";
    L16:
        e = move-exception;
        r1 = r3;
        e = e;
        goto L19
    L11:
        return "8.2.0-alpha1".toLowerCase();
    }

    public static void a(List r12, String r13, long r14) {
        Iterator r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L45;
        a0 r0 = (a0) r15.next();
        if ((System.currentTimeMillis() - r0.c) <= r14) goto L4;
        Thread r1 = r0.b;
        boolean r3 = false;
        String r2 = r0.a.split("#")[0];
        long r4 = System.currentTimeMillis() - r0.c;
        monitor-enter(b0.class);
        if (f == false) goto L15;
        r3 = g;     // Catch: Throwable -> L42
        monitor-exit(b0.class);
    L35:
        if (r3 == false) goto L37;
        Log.e("TestThreadPoolDelay", "Hawei phone found block, threadPoolName:" + r13 + ",threadName: " + r1.getName() + ",has block, block time is(ms) " + r4 + ", taskName is: " + r2);
    L41:
        r0.d++;
        goto L4
    L37:
        StackTraceElement[] r5 = r0.b.getStackTrace();
        Throwable r6 = new Throwable();
        r6.setStackTrace(r5);
        Boolean r7 = Boolean.TRUE;
        if (r0.d < 2) goto L40;
        r7 = Boolean.FALSE;
    L40:
        Log.e("TestThreadPoolDelay", "threadPoolName:" + r13 + ",threadName: " + r1.getName() + ",has block, block time is(ms) " + r4 + ", taskName is: " + r2 + ", stackTrace is：", r6, r7.booleanValue());
        goto L41
    L15:
        f = true;     // Catch: Throwable -> L42
        String r9 = Build.BRAND;     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r9) == false) goto L20;
        g = false;     // Catch: Throwable -> L42
        monitor-exit(b0.class);
        goto L35
    L20:
        Log.d("TestThreadPoolDelay", "brand:" + r9);     // Catch: Throwable -> L42
        boolean r8 = "HUAWEI".equalsIgnoreCase(r9);     // Catch: Throwable -> L42
        String r10 = c();     // Catch: Throwable -> L42
        if (r10.contains("alpha") == false) goto L23;
    L25:
        boolean r11 = false;
    L26:
        if (r8 == false) goto L29;
        if (r11 == false) goto L29;
        boolean r16 = true;
    L30:
        g = r16;     // Catch: Throwable -> L42
        if (r8 == false) goto L34;
        if (r11 == false) goto L34;
        r3 = true;
    L34:
        monitor-exit(b0.class);
    L29:
        r16 = false;
        goto L30
    L23:
        if (r10.contains("beta") == true) goto L25;
        r11 = true;
    L42:
        th = move-exception;
        throw th;
    }
}
