package com.bytedance.android.anniex.lite.container;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends ib.f.a {
    public com.bytedance.android.anniex.base.lifecycle.a a;
    public ia.c b;
    public ib.f.a c;
    public volatile boolean d;

    public static final class a implements Runnable {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ WebView c;
        public final /* synthetic */ Throwable d;

        public a(n r1, String r10, WebView r11, Throwable r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n r0 = this.a;     // Catch: Throwable -> L13
            ia.c r1 = r0.b;     // Catch: Throwable -> L13
            if (r1 == null) goto L9;
            String r10 = this.b;     // Catch: Throwable -> L13
            Throwable r11 = this.d;     // Catch: Throwable -> L13
            com.bytedance.android.anniex.base.lifecycle.a r12 = r0.a;     // Catch: Throwable -> L13
            if (r12 == null) goto L9;
            if (r10 != null) goto L8;
            r10 = null;
        L8:
            r12.g(r10, r1, r11);     // Catch: Throwable -> L13
        L9:
            ib.f.a r13 = this.a.c;     // Catch: Throwable -> L13
            if (r13 == null) goto L16;
            r13.onLoadFail(this.b, this.c, this.d);     // Catch: Throwable -> L13
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ WebView c;

        public b(n r1, String r10, WebView r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n r0 = this.a;     // Catch: Throwable -> L13
            ia.c r1 = r0.b;     // Catch: Throwable -> L13
            if (r1 == null) goto L9;
            String r10 = this.b;     // Catch: Throwable -> L13
            com.bytedance.android.anniex.base.lifecycle.a r11 = r0.a;     // Catch: Throwable -> L13
            if (r11 == null) goto L9;
            if (r10 != null) goto L8;
            r10 = null;
        L8:
            r11.h(r10, r1);     // Catch: Throwable -> L13
        L9:
            ib.f.a r12 = this.a.c;     // Catch: Throwable -> L13
            if (r12 == null) goto L16;
            r12.onLoadStart(this.b, this.c);     // Catch: Throwable -> L13
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ WebView c;

        public c(n r1, String r10, WebView r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n r0 = this.a;     // Catch: Throwable -> L13
            ia.c r1 = r0.b;     // Catch: Throwable -> L13
            if (r1 == null) goto L9;
            String r10 = this.b;     // Catch: Throwable -> L13
            com.bytedance.android.anniex.base.lifecycle.a r11 = r0.a;     // Catch: Throwable -> L13
            if (r11 == null) goto L9;
            if (r10 != null) goto L8;
            r10 = null;
        L8:
            r11.i(r10, r1);     // Catch: Throwable -> L13
        L9:
            ib.f.a r12 = this.a.c;     // Catch: Throwable -> L13
            if (r12 == null) goto L16;
            r12.onLoadUriSuccess(this.b, this.c);     // Catch: Throwable -> L13
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ WebView c;

        public d(n r1, String r10, WebView r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ib.f.a r0 = this.a.c;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b, this.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ n a;
        public final /* synthetic */ String b;
        public final /* synthetic */ WebView c;
        public final /* synthetic */ String d;

        public e(n r1, String r10, WebView r11, String r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ib.f.a r0 = this.a.c;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b(this.b, this.c, this.d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public n() {
        throw null;
    }

    public final void c(Runnable r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.d == false) goto L9;
        r10.run();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw null;     // Catch: Throwable -> L10
    }

    @Override // ib.f.a
    public final void a(String r10, WebView r11) {
        c(new d(this, r10, r11));
    }

    @Override // ib.f.a, ib.f
    public final void onLoadStart(String r10, WebView r11) {
        c(new b(this, r10, r11));
    }

    @Override // ib.f.a, ib.f
    public final void onLoadUriSuccess(String r10, WebView r11) {
        c(new c(this, r10, r11));
    }

    @Override // ib.f.a
    public final void b(String r10, WebView r11, String r12) {
        c(new e(this, r10, r11, r12));
    }

    @Override // ib.f.a, ib.f
    public final void onLoadFail(String r10, WebView r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r12, "e");
        c(new a(this, r10, r11, r12));
    }
}
