package com.ss.android.lark.officewebview.webview_api.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.webview_api.platform.PlatformPluginVersion;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import otb.i;
import otb.o;
import rxb.f;
import rxb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeRenderInWebViewServiceAdapter implements txb.a {
    public final oxb.e a;
    public final ConcurrentHashMap<String, rxb.d> b;
    public final Lazy c;
    public final ConcurrentHashMap<rxb.a, otb.b> d;

    public static final class a implements i {
        public final rxb.d a;

        @Override // otb.i
        public final void destroy() {
            this.a.destroy();
        }

        @Override // otb.i
        public final String viewId() {
            return this.a.viewId();
        }

        public a(rxb.d r2) {
            Intrinsics.checkNotNullParameter(r2, "api");
            this.a = r2;
        }

        @Override // otb.i
        public final View a(ViewGroup r2) {
            return this.a.a(r2);
        }

        @Override // otb.i
        public final View b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "viewId");
            return this.a.b(r2);
        }
    }

    public static final class b implements otb.b {
        public final rxb.a a;

        public b(rxb.a r2) {
            Intrinsics.checkNotNullParameter(r2, "api");
            this.a = r2;
        }
    }

    public static final class c implements rxb.c {
        public final exb.a a;

        public c(exb.a r2) {
            Intrinsics.checkNotNullParameter(r2, "office");
            this.a = r2;
            new ConcurrentHashMap();
        }

        @Override // rxb.c
        public final void e(Throwable r3) {
            Intrinsics.checkNotNullParameter("NativeComponentHandler", "tag");
            this.a.getClass();
            exb.a.b("NativeComponentHandler", "insertNativeComponent parse subComponents error", r3);
        }

        @Override // rxb.c
        public final void w(String r3) {
            Intrinsics.checkNotNullParameter("NativeComponentFactoryProvider", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.a.getClass();
            exb.a.f("NativeComponentFactoryProvider", r3);
        }

        @Override // rxb.c
        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.a.getClass();
            exb.a.a(r2, r3);
        }

        @Override // rxb.c
        public final void i(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.a.getClass();
            exb.a.c(r2, r3);
        }

        @Override // rxb.c
        public final void a(String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r6, "msg");
            exb.a r2 = this.a;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r6, "msg");
            exb.a.a(r2.e(r4, r5), r6);
        }

        @Override // rxb.c
        public final void b(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r4, "msg");
            this.a.d(r2, r3, r4);
        }

        @Override // rxb.c
        public final void e(String r5, String r6, Throwable r7) {
            Intrinsics.checkNotNullParameter("NativeComponentHandler", "tag");
            Intrinsics.checkNotNullParameter(r6, "msg");
            exb.a r3 = this.a;
            r3.getClass();
            Intrinsics.checkNotNullParameter("NativeComponentHandler", "tag");
            Intrinsics.checkNotNullParameter(r6, "msg");
            exb.a.b(r3.e("NativeComponentHandler", r5), r6, r7);
        }
    }

    public static final class d implements rxb.d {
        public final i a;

        @Override // rxb.d
        public final void destroy() {
            this.a.destroy();
        }

        @Override // rxb.d
        public final String viewId() {
            return this.a.viewId();
        }

        public d(i r2) {
            Intrinsics.checkNotNullParameter(r2, "office");
            this.a = r2;
        }

        @Override // rxb.d
        public final View a(ViewGroup r2) {
            return this.a.a(r2);
        }

        @Override // rxb.d
        public final View b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "viewId");
            return this.a.b(r2);
        }
    }

    public static final class e implements rxb.b {
        public final otb.c a;
        public final Map<String, rxb.d> b;

        @Override // rxb.b
        public final rxb.d a() {
            String r0 = this.a.getViewId();
            if (r0 == null) goto L7;
            rxb.d r1 = this.b.get(r0);
            if (r1 == null) goto L7;
            return r1;
        L7:
            i r2 = this.a.a();
            if (r2 != null) goto L12;
            return null;
        L12:
            return new d(r2);
        }

        @Override // rxb.b
        public final void destroy() {
            this.a.destroy();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(otb.c r2, Map<String, ? extends rxb.d> r3) {
            Intrinsics.checkNotNullParameter(r2, "office");
            Intrinsics.checkNotNullParameter(r3, "factoryMap");
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // txb.a
    public final boolean d() {
        return this.a.d();
    }

    @Override // txb.a
    public final rxb.c getLogger() {
        return (rxb.c) this.c.getValue();
    }

    @Override // txb.a
    public final Map<PlatformPluginVersion, Boolean> x() {
        Map<com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion, Boolean> r0 = this.a.p();
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
        Iterator<T> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        r1.put(PlatformPluginVersion.valueOf(((com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion) r3.getKey()).name()), r3.getValue());
        goto L4
    L6:
        return r1;
    }

    @Override // txb.a
    public final void A(ts5.d r2) {
        Intrinsics.checkNotNullParameter(r2, "monitor");
        otb.b r3 = this.d.remove(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        this.a.w(r3);
    }

    @Override // txb.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        this.a.a(r2);
    }

    @Override // txb.a
    public final rxb.b c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "viewId");
        otb.c r4 = this.a.c(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new e(r4, this.b);
    }

    @Override // txb.a
    public final f f(String r10) {
        exb.e r11 = this.a.f(r10);
        if (r11 == null) goto L12;
        f r1 = new f(r11.f());
        g r2 = r1.b();
        o r3 = r11.d();
        r2.a(new g(r3.c(), r3.d(), r3.b(), r3.a()));
        r1.d(r11.b());
        r1.e(r11.c());
        r1.f(r11.e());
        Object r12 = r11.a();
        if ((r12 instanceof hxb.b) == false) goto L7;
        ((hxb.b) r12).getClass();
        throw null;
    L7:
        if ((r12 instanceof gxb.c) == false) goto L9;
        gxb.c r13 = (gxb.c) r12;
        r12 = new sxb.a(r13.a, r13.b, r13.c, r13.d, r13.e, r13.f);
    L9:
        r1.c(r12);
        return r1;
    L12:
        return null;
    }

    @Override // txb.a
    public final rxb.d g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        rxb.d r0 = this.b.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        i r3 = this.a.g(r2);
        if (r3 != null) goto L10;
        return null;
    L10:
        return new d(r3);
    }

    @Override // txb.a
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        this.b.remove(r2);
        this.a.h(r2);
    }

    @Override // txb.a
    public final void j(rxb.d r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.b.put(r3.viewId(), r3);
        this.a.G(new a(r3));
    }

    @Override // txb.a
    public final void l(rxb.a r3) {
        Intrinsics.checkNotNullParameter(r3, "monitor");
        ConcurrentHashMap<rxb.a, otb.b> r0 = this.d;
        otb.b r1 = r0.get(r3);
        if (r1 != null) goto L8;
        r1 = new b(r3);
        otb.b r4 = r0.putIfAbsent(r3, r1);
        if (r4 == null) goto L8;
        r1 = r4;
    L8:
        otb.b r2 = r1;
        oxb.e r5 = this.a;
        Intrinsics.checkNotNull(r2);
        r5.x(r2);
    }

    public OfficeRenderInWebViewServiceAdapter(OfficeWebView r2, oxb.e r3) {
        Intrinsics.checkNotNullParameter(r2, "officeWebView");
        Intrinsics.checkNotNullParameter(r3, "officeService");
        this.a = r3;
        this.b = new ConcurrentHashMap();
        this.c = LazyKt.lazy(new OfficeRenderInWebViewServiceAdapter$loggerAdapter$2(this));
        this.d = new ConcurrentHashMap();
    }

    @Override // txb.a
    public final void r(String r10, sxb.a r11) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        Intrinsics.checkNotNullParameter(r11, "params");
        this.a.L(r10, new gxb.c(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f));
    }

    @Override // txb.a
    public final void z(String r10, sxb.a r11) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        Intrinsics.checkNotNullParameter(r11, "params");
        this.a.I(r10, new gxb.c(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f));
    }
}
