package com.bytedance.ai.resource;

import android.util.LruCache;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements w2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f2718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2719c;
    public final AtomicInteger d;
    public String e;
    public final ConcurrentHashMap f;
    public WeakReference g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f2721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final kotlinx.coroutines.sync.d f2723k;

    public f0(int r5, String r10, boolean r11) {
        if ((r5 & 4) == 0) goto L5;
        r11 = false;
    L5:
        Intrinsics.checkNotNullParameter(r10, "packageName");
        this.f2717a = r10;
        this.f2718b = false;
        this.f2719c = r11;
        this.d = new AtomicInteger(0);
        LruCache r12 = e0.f2711a;
        this.e = IIvyAIPackageResourceService.Companion.openSession(null);
        this.f = new ConcurrentHashMap();
        this.f2720h = true;
        this.f2723k = kotlinx.coroutines.sync.e.a();
    }

    public final Applet a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Applet r10 = null;
        if (this.f2720h == true) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f2720h == false) goto L16;
        Object r11 = this.f.get(r5);     // Catch: Throwable -> L12
        if ((r11 instanceof Applet) == false) goto L14;
        r10 = (Applet) r11;     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return r10;
    L16:
        monitor-exit(this);
        return null;
    }

    public final void b(AIPackage r5) {
        if (Intrinsics.areEqual(r5.f2259b, this.f2717a) == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "listener");
        r5.E = new WeakReference(this);
        r5.f2276x = this.e;
        this.f.put(r5.c(), r5);
        return;
    }

    public final Widget c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetId");
        Widget r10 = null;
        if (this.f2720h == true) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f2720h == false) goto L16;
        Object r11 = this.f.get(r5);     // Catch: Throwable -> L12
        if ((r11 instanceof Widget) == false) goto L14;
        r10 = (Widget) r11;     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return r10;
    L16:
        monitor-exit(this);
        return null;
    }

    public final void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "newSessionId");
        if (this.f2719c == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.e, r5) == true) goto L12;
        LruCache r10 = e0.f2711a;
        e0.j(this.e);
        String r11 = f4.b.b(new StringBuilder("updateSessionId from "), this.e, " to ", r5);
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L9;
        r12.d("AIManager", r11);
    L9:
        this.e = r5;
        return;
    }
}
