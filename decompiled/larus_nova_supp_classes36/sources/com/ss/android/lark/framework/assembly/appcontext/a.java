package com.ss.android.lark.framework.assembly.appcontext;

import android.content.Context;
import android.content.res.Configuration;
import com.ss.android.lark.app.initiator.AppLaunchLifecycle;
import com.ss.android.lark.appcontext.applifecycle.q;
import com.ss.android.lark.appcontext.applifecycle.u;
import com.ss.android.lark.appcontext.applifecycle.v;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements AppLaunchLifecycle.b {
    @Inject
    public a() {
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void c(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        Object r0 = q.c;
        Iterator r1 = ((ConcurrentHashMap) q.a.a.a).keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((u) r1.next()).a(r3);
        goto L4
    }

    public final void d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        Object r0 = q.c;
        Iterator r1 = ((ConcurrentHashMap) q.a.a.b).keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((v) r1.next()).onConfigurationChanged(r3);
        goto L4
    L6:
        Iterator r4 = ((ConcurrentHashMap) q.a.a.a).keySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        ((u) r4.next()).b();
        goto L8
    }
}
