package com.lynx.component.svg;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.component.svg.parser.SVG;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.serval.svg.SVGRender;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import x6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends i {
    public final int j;
    public volatile String k;
    public volatile String l;
    public volatile String m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public volatile Drawable q;
    public volatile SVGRender r;
    public final d s;
    public int t;
    public int u;
    public volatile boolean v;
    public boolean w;

    /* JADX INFO: renamed from: com.lynx.component.svg.a$a, reason: collision with other inner class name */
    public class RunnableC0042a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ a b;

        public final void a() {
            if (this.b.v == false) goto L6;
            this.b.p = false;
            return;
        L6:
            a r0 = this.b;
            String r2 = this.a;
            r0.getClass();
            String r3 = new String(Base64.decode(r2.substring(26).getBytes(StandardCharsets.UTF_8), 0), StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(r3) == false) goto L9;
            UIThreadUtils.runOnUiThread(new x5a.a(r0));
            return;
        L9:
            r0.l = r3;
            r0.l();
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

        public RunnableC0042a(a r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ a c;

        /* JADX INFO: renamed from: com.lynx.component.svg.a$b$a, reason: collision with other inner class name */
        public class RunnableC0043a implements Runnable {
            public final /* synthetic */ j6a.a a;
            public final /* synthetic */ b b;

            public final void a() {
                if (this.b.c.v == false) goto L6;
                this.b.c.p = false;
                return;
            L6:
                a r0 = this.b.c;
                r0.q = this.a;
                this.b.c.e(0);
                a.k(this.b.c);
                this.b.c.p = false;
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

            public RunnableC0043a(b r1, j6a.a r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.lynx.component.svg.a$b$b, reason: collision with other inner class name */
        public class RunnableC0044b implements Runnable {
            public final /* synthetic */ b a;

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c.p = false;     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0044b(b r1) {
                this.a = r1;
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ b a;

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c.p = false;     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(b r1) {
                this.a = r1;
            }
        }

        public final void a() {
        L7:
            e = move-exception;
            LLog.e("lynx_SVGRenderer", "renderServalSVG failed: " + e.getMessage());
            UIThreadUtils.runOnUiThread(new c(this));
            return;
        L3:
            if (this.c.r == null) goto L5;
            this.c.r.setColor(this.c.m);     // Catch: Exception -> L7
            UIThreadUtils.runOnUiThread(new RunnableC0043a(this, new j6a.a(this.c.r.renderPicture(this.c.l, new Rect(0, 0, this.a, this.b)))));     // Catch: Exception -> L7
        L10:
            return;
        L5:
            UIThreadUtils.runOnUiThread(new RunnableC0044b(this));     // Catch: Exception -> L7
            goto L10
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

        public b(a r1, int r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static class c implements d.c {
        public final WeakReference<a> a;

        /* JADX INFO: renamed from: com.lynx.component.svg.a$c$a, reason: collision with other inner class name */
        public class RunnableC0045a implements Runnable {
            public final /* synthetic */ c a;

            @Override // java.lang.Runnable
            public final void run() {
                a r0 = this.a.a.get();     // Catch: Throwable -> L9
                if (r0 != null) goto L5;
                return;
            L5:
                if (r0.v == true) goto L16;
                r0.e(0);     // Catch: Throwable -> L9
                r0.p = false;     // Catch: Throwable -> L9
                return;
            L16:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L17;
                throw th;
            }

            public RunnableC0045a(c r1) {
                this.a = r1;
            }
        }

        @Override // com.lynx.component.svg.d.InterfaceC0046d
        public final void onStart() {
        }

        @Override // com.lynx.component.svg.d.InterfaceC0046d
        public final void onSuccess() {
        }

        public c(a r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.lynx.component.svg.d.InterfaceC0046d
        public final void onError(String r4) {
            a r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.v == true) goto L10;
            LLog.e("lynx_SVGRenderer", "requestSrc error! the src is " + r0.k + " error message is " + r4);
            r0.q = null;
            UIThreadUtils.runOnUiThread(new RunnableC0045a(this));
            return;
        }

        @Override // com.lynx.component.svg.d.c
        public final void a(String r5, SVG r6) {
            a r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.v == false) goto L8;
            return;
        L8:
            if (r0.n == false) goto L10;
            r0.l = r5;
            r0.m();
            return;
        L10:
            if (r6 != null) goto L12;
            r0.p = false;
            return;
        L12:
            int r7 = r0.t;
            int r1 = r0.u;
            LynxThreadPool.e().execute(new x5a.b(r0, r7, r1, r6));
        }
    }

    @Override // x6a.i
    public final void f() {
        this.v = true;
        this.r = null;
        this.s.a();
    }

    public final void l() {
        if (this.n == false) goto L6;
        m();
        return;
    L6:
        if (TextUtils.isEmpty(this.l) == false) goto L8;
        this.p = false;
        return;
    L8:
        LynxThreadPool.e().execute(new x5a.c(this));
    }

    public final void m() {
        if (TextUtils.isEmpty(this.l) == false) goto L6;
        this.p = false;
        return;
    L6:
        int r0 = this.t;
        int r1 = this.u;
        LynxThreadPool.e().execute(new b(this, r0, r1));
    }

    public final void n() {
        if (this.p == false) goto L5;
        return;
    L5:
        Rect r0 = this.a;
        int r1 = r0.width();
        int r2 = r0.height();
        if (r1 <= 0) goto L26;
        if (r2 <= 0) goto L30;
        this.t = r1;
        this.u = r2;
        this.o = false;
        if (TextUtils.isEmpty(this.l) == true) goto L12;
    L15:
        this.p = true;
        if (TextUtils.isEmpty(this.k) == true) goto L22;
        if (this.k.startsWith("data:image/svg+xml;base64") == false) goto L20;
        String r3 = this.k;
        LynxThreadPool.e().execute(new RunnableC0042a(this, r3));
        return;
    L20:
        this.s.c(this.k, new c(this));
        return;
    L22:
        if (TextUtils.isEmpty(this.l) == true) goto L24;
        l();
        return;
    L24:
        this.p = false;
        return;
    L12:
        if (TextUtils.isEmpty(this.k) == false) goto L15;
        this.q = null;
        e(0);
        return;
    L30:
        return;
    }

    public static void k(a r4) {
        LynxContext r0 = r4.d.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getEventEmitter() != null) goto L7;
        return;
    L7:
        if (r4.w != true) goto L12;
        m7a.a r1 = new m7a.a(r4.j, "load");
        r1.a("height", Integer.valueOf(r4.u));
        r1.a("width", Integer.valueOf(r4.t));
        r0.getEventEmitter().sendCustomEvent(r1);
        return;
    }

    @Override // x6a.i
    public final void g(Canvas r4) {
        super.g(r4);
        Rect r0 = this.a;
        int r1 = r0.width();
        int r2 = r0.height();
        if (r1 <= 0) goto L13;
        if (r2 <= 0) goto L13;
        if (r1 == this.t) goto L8;
    L11:
        this.o = true;
        n();
        goto L13
    L8:
        if (r2 != this.u) goto L11;
        if (this.o == true) goto L11;
    L13:
        if (this.q == null) goto L16;
        this.q.draw(r4);
        return;
    }

    @Override // x6a.i
    public final void j(PropBundle r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        String r4 = null;
        if (r7.contains(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L12;
        String r0 = r7.a.getString(LynxError.LYNX_ERROR_KEY_RESOURCE_URL);
        if (o(r0, this.k) == false) goto L12;
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r0 = null;
    L11:
        this.k = r0;
        boolean r1 = true;
    L14:
        if (r7.contains(LynxAccessibilityModule.MSG_CONTENT) == false) goto L22;
        String r2 = r7.a.getString(LynxAccessibilityModule.MSG_CONTENT);
        if (o(r2, this.l) == false) goto L22;
        if (TextUtils.isEmpty(r2) == false) goto L20;
        r2 = null;
    L20:
        this.l = r2;
        r1 = true;
    L22:
        if (r7.contains("current-color") == false) goto L31;
        String r3 = r7.a.getString("current-color");
        if (TextUtils.isEmpty(r3) == true) goto L28;
        r4 = r3.trim();
    L28:
        if (o(r4, this.m) == false) goto L31;
        this.m = r4;
        r1 = true;
    L31:
        if (r7.getProps().hasKey("enable-serval-svg") == false) goto L41;
        boolean r5 = r7.getProps().getBoolean("enable-serval-svg", false);
        if (r5 == this.n) goto L41;
        this.n = r5;
        if (this.n == true) goto L37;
    L39:
        r1 = true;
        goto L41
    L37:
        if (this.r != null) goto L39;
        LynxThreadPool.e().execute(new com.lynx.component.svg.c(this));
    L41:
        if (r7.getEventHandlers() != null) goto L43;
    L45:
        if (r1 == false) goto L48;
        this.o = true;
        n();
        return;
    L48:
        return;
    L43:
        if (EventsListener.convertEventListeners(r7.getEventHandlers()).containsKey("load") == false) goto L45;
        this.w = true;
    L12:
        r1 = false;
        goto L14
    }

    public a(PlatformRendererContext r2, int r3) {
        super(r2, r3);
        this.n = false;
        this.o = false;
        this.p = false;
        this.t = -1;
        this.u = -1;
        this.v = false;
        this.w = false;
        this.j = r3;
        this.s = new d(this.d.d);
    }

    public static boolean o(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L8;
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        if (r4 == null) goto L14;
        return true;
    L14:
        return false;
    L13:
        return !r3.equals(r4);
    }
}
