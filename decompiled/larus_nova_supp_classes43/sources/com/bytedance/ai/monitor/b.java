package com.bytedance.ai.monitor;

import android.os.Handler;
import com.bytedance.ai.debug.g;
import com.bytedance.ai.event.MessageIndication;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.c;
import k5.d;
import k5.h;
import k5.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l5.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final AtomicBoolean a = null;
    public static final Handler b = null;
    public static h c;
    public static final CopyOnWriteArrayList<Runnable> d = null;
    public static final HashMap<String, String> e = null;

    static {
        a = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("AppletReportingThread");
        d = new CopyOnWriteArrayList();
        e = new HashMap();
        g.a.getClass();
        ThreadMethodProxy.start(r0);
        b = new Handler(r0.getLooper());
    }

    public static void c(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r10.b() == true) goto L5;
        return;
    L5:
        JSONObject r1 = r10.n();
        String r11 = r10.getType();
        if (Intrinsics.areEqual(r11, "jsb_event") == false) goto L11;
        h r0 = c;
        if (r0 == null) goto L30;
        r0.e(r10.a, r1, r10.a(), r10.j);
        return;
    L30:
        return;
    L11:
        if (Intrinsics.areEqual(r11, "error_event") == false) goto L17;
        h r12 = c;
        if (r12 == null) goto L15;
        r12.c(r10.a, r1, r10.a(), r10.j);
    L15:
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "event");
        return;
    L17:
        if (r10.d == false) goto L25;
        h r13 = c;
        if (r13 == null) goto L21;
        r13.a(r10.a, r1, r10.a(), r10.j);
    L21:
        z.a(r1, r10.a());
        z.a(r1, r10.j);
        h r14 = c;
        if (r14 == null) goto L24;
        r14.d(r10.a, r1);
    L24:
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "event");
        return;
    L25:
        h r15 = c;
        if (r15 == null) goto L28;
        String r16 = r10.a;
        r10.a();
        r15.b(r16, r1);
    L28:
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "event");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, k5.d] */
    public static void e(final Runnable r1) {
        ?? r0 = new d(r1);
        n5.a.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "task");
        r0.invoke();
    }

    public static void b(final String r10, final j r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "builder");
        final long r0 = System.currentTimeMillis();
        e(new k5.b(r10, r11, r0));
    }

    public static void d(final String r10, final j r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "builder");
        final long r0 = System.currentTimeMillis();
        e(new k5.a(r10, r11, r0));
    }

    public static void a(final AppletErrorCode r10, final String r11, final String r12, final Function1 r13) {
        Intrinsics.checkNotNullParameter(r10, "code");
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        Intrinsics.checkNotNullParameter(r13, "build");
        final long r14 = System.currentTimeMillis();
        e(new c(r10, r11, r12, r13, r14));
    }
}
