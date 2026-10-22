package com.ss.android.lark.monitor;

import android.app.Application;
import com.larksuite.framework.thread.CoreThreadPool;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LarkMetrics implements k.a {
    public Application a;
    public y b;
    public final CopyOnWriteArrayList<com.ss.android.lark.monitor.a> c;
    public i d;
    public ScheduledExecutorService e;
    public com.ss.android.lark.monitor.traffic.j f;
    public k g;
    public volatile boolean h;
    public long i;
    public volatile boolean j;
    public volatile boolean k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SwitchType {
        public static final int BACK_TO_BACK = 2;
        public static final int BACK_TO_FORE = 0;
        public static final int FORE_TO_BACK = 1;
        public static final int FORE_TO_FORE = 3;
    }

    public static final class a {
        public static final LarkMetrics a = null;

        static {
            a = new LarkMetrics();
        }
    }

    public LarkMetrics() {
        this.c = new CopyOnWriteArrayList();
        this.i = System.currentTimeMillis();
        this.j = true;
        this.k = false;
    }

    public final void a(final i r4) {
        Iterator r0 = ((ArrayList) r4.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) r0.next();
        if (r4.e.contains(r1) == false) goto L4;
        return;
    L8:
        this.d = r4;
        this.k = r4.h;
        if (r4.d == false) goto L11;
        com.ss.android.lark.monitor.traffic.j r2 = new com.ss.android.lark.monitor.traffic.j(r4);
        this.f = r2;
        this.c.add(r2);
    L11:
        int r3 = w.a;
        ScheduledExecutorService r5 = CoreThreadPool.getDefault().getScheduleThreadPool();
        this.e = r5;
        r5.execute(new h(this, r4));
    }

    public final void b(final String r6) {
        boolean r0 = this.j;
        this.j = false;
        if (r0 == true) goto L5;
    L7:
        this.e.execute(new g(this, r6));
        return;
    L5:
        if ((System.currentTimeMillis() - this.i) >= 5000) goto L7;
    }
}
