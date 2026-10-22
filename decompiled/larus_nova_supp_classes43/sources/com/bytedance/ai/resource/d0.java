package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d0 implements AIPackage.b {
    public final String a;
    public volatile boolean b;
    public final boolean c;
    public final AtomicInteger d;
    public String e;
    public final ConcurrentHashMap<String, AIPackage> f;
    public WeakReference<a> g;
    public boolean h;
    public long i;
    public String j;
    public final MutexImpl k;

    public interface a {
        void a(String r1);
    }

    public final List<Widget> f() {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, AIPackage>> r1 = this.f.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<String, AIPackage> r10 = r1.next();
        if (r10.getValue().c() != AIPackage.AIPackageType.WIDGET) goto L4;
        AIPackage r11 = r10.getValue();
        if ((r11 instanceof Widget) == false) goto L10;
        Widget r12 = (Widget) r11;
    L11:
        if (r12 == null) goto L4;
        r0.add(r12);
        goto L4
    L10:
        r12 = null;
        goto L11
    L13:
        return r0;
    }

    public final void i() {
        if (this.b == true) goto L13;
        this.h = false;
        if (this.c == true) goto L7;
        AppletResourceTool r0 = AppletResourceTool.a;
        String r1 = this.e;
        r0.getClass();
        AppletResourceTool.a(r1);
    L7:
        WeakReference<a> r10 = this.g;
        if (r10 == null) goto L14;
        a r11 = r10.get();
        if (r11 == null) goto L15;
        r11.a(this.a);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final AIPackage c(AIPackage r10) {
        if (Intrinsics.areEqual(r10.b, this.a) == true) goto L6;
        return null;
    L6:
        Intrinsics.checkNotNullParameter(this, "listener");
        r10.I = new WeakReference(this);
        AIPackage r0 = this.f.putIfAbsent(r10.a(), r10);
        if (r0 != null) goto L9;
        r0 = r10;
    L9:
        r0.x = this.e;
        if (r0.y == AIPackage.PackageStatus.READY) goto L12;
    L14:
        AIPackage.PackageStatus r11 = r10.y;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r0.y = r11;
    L15:
        return r0;
    L12:
        if (r10.y != AIPackage.PackageStatus.BASE_READY) goto L14;
        com.bytedance.ai.utils.g.a.i("AIManager", "ignore package status downgrade from READY to BASE_READY. packageName: " + r10.b + ", appId: " + r10.a());
        goto L15
    }

    public final Applet d(Applet r10) {
        Intrinsics.checkNotNullParameter(r10, "applet");
        AIPackage r11 = c(r10);
        if ((r11 instanceof Applet) == true) goto L7;
        return null;
    L7:
        return (Applet) r11;
    }

    public final Widget e(Widget r10) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        AIPackage r11 = c(r10);
        if ((r11 instanceof Widget) == true) goto L7;
        return null;
    L7:
        return (Widget) r11;
    }

    public final Applet g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Applet r1 = null;
        if (this.h == true) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.h == false) goto L13;
        AIPackage r11 = this.f.get(r10);     // Catch: Throwable -> L15
        if ((r11 instanceof Applet) == false) goto L11;
        r1 = (Applet) r11;     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return r1;
    L13:
        monitor-exit(this);
        return null;
    }

    public final Widget h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Widget r1 = null;
        if (this.h == true) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.h == false) goto L13;
        AIPackage r11 = this.f.get(r10);     // Catch: Throwable -> L15
        if ((r11 instanceof Widget) == false) goto L11;
        r1 = (Widget) r11;     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return r1;
    L13:
        monitor-exit(this);
        return null;
    }

    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "newSessionId");
        if (this.c == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.e, r10) == true) goto L9;
        AppletResourceTool r0 = AppletResourceTool.a;
        String r1 = this.e;
        r0.getClass();
        AppletResourceTool.a(r1);
        com.bytedance.ai.utils.g.a.d("AIManager", "updateSessionId from " + this.e + " to " + r10);
        this.e = r10;
        return;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage.b
    public final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
        if (Intrinsics.areEqual(r10, this.a) == true) goto L5;
        return;
    L5:
        if (this.h == false) goto L22;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.h == false) goto L13;
        this.d.incrementAndGet();     // Catch: Throwable -> L16
        if (this.c == false) goto L12;
        n5.a.a.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r10, "packageName");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);     // Catch: Throwable -> L16
    L12:
        com.bytedance.ai.utils.g.a.d("AIManager", "-------PackageInfoWithSession " + hashCode() + ": " + r10 + " markInUse: " + this.d.get() + ", isClient:" + this.c);     // Catch: Throwable -> L16
    L13:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    }

    @Override // com.bytedance.ai.model.objects.AIPackage.b
    public final void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
        if (Intrinsics.areEqual(r10, this.a) == true) goto L5;
        return;
    L5:
        if (this.h == false) goto L24;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.h == false) goto L15;
        int r1 = this.d.decrementAndGet();     // Catch: Throwable -> L18
        if (this.c == false) goto L12;
        n5.a.a.getClass();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r10, "packageName");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);     // Catch: Throwable -> L18
    L12:
        com.bytedance.ai.utils.g.a.d("AIManager", "-------PackageInfoWithSession " + hashCode() + ": " + r10 + " markOutOfUse: " + this.d.get() + ", isClient:" + this.c);     // Catch: Throwable -> L18
        if (r1 != 0) goto L15;
        i();     // Catch: Throwable -> L18
    L15:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    }

    public d0(String r10, boolean r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        Intrinsics.checkNotNullParameter(r10, "packageName");
        this.a = r10;
        this.b = r11;
        this.c = false;
        this.d = new AtomicInteger(0);
        this.e = AppletResourceTool.s(AppletResourceTool.a);
        this.f = new ConcurrentHashMap();
        this.h = true;
        this.k = kotlinx.coroutines.sync.b.a();
    }
}
