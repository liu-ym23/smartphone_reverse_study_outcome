package com.bytedance.ai.applet.app.foundation;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v {
    public final AppletApplication a;
    public final List<w> b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final AppletAppResourceLoader m;
    public final Lazy n;

    public static final class a {
    }

    static {
    }

    public final AppletAuthorizeHelper a() {
        return (AppletAuthorizeHelper) this.e.getValue();
    }

    public final com.bytedance.ai.applet.app.foundation.a b() {
        return (com.bytedance.ai.applet.app.foundation.a) this.l.getValue();
    }

    public final com.bytedance.ai.applet.app.foundation.performance.c c() {
        return (com.bytedance.ai.applet.app.foundation.performance.c) this.h.getValue();
    }

    public final ApplicationRouter d() {
        return (ApplicationRouter) this.c.getValue();
    }

    public final j e() {
        return (j) this.g.getValue();
    }

    public final List<w> f() {
        List<w> r0 = this.b;
        monitor-enter(r0);
        List<w> r1 = CollectionsKt.toList(this.b);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public v(AppletApplication r10) {
        Intrinsics.checkNotNullParameter(r10, "app");
        this.a = r10;
        List<w> r0 = Collections.synchronizedList(new ArrayList());
        this.b = r0;
        this.c = LazyKt.lazy(new k(this));
        this.d = LazyKt.lazy(new n(this));
        this.e = LazyKt.lazy(new o(this));
        this.f = LazyKt.lazy(new p(this));
        this.g = LazyKt.lazy(new q(this));
        this.h = LazyKt.lazy(new r(this));
        this.i = LazyKt.lazy(new s(this));
        this.j = LazyKt.lazy(new t(this));
        this.k = LazyKt.lazy(new u(this));
        this.l = LazyKt.lazy(new l(this));
        AppletAppResourceLoader r1 = new AppletAppResourceLoader(r10);
        r0.add(r1);
        this.m = r1;
        this.n = LazyKt.lazy(new m(this));
    }
}
