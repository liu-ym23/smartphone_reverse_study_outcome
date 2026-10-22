package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.FragmentManager;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0.a<Boolean> f450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yd.d<n> f451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f456h;

    public final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.k, androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.h f457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f458b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public c f459m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f460n;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r8, androidx.lifecycle.h r10, FragmentManager.c r11) {
            he.i.f(r11, "onBackPressedCallback");
            this.f460n = r8;
            this.f457a = r10;
            this.f458b = r11;
            r10.a(this);
        }

        @Override // androidx.activity.c
        public final void cancel() {
            this.f457a.c(this);
            n r8 = this.f458b;
            r8.getClass();
            r8.f499b.remove(this);
            c r10 = this.f459m;
            if (r10 == null) goto L5;
            r10.cancel();
        L5:
            this.f459m = null;
        }

        @Override // androidx.lifecycle.k
        public final void onStateChanged(androidx.lifecycle.m r8, androidx.lifecycle.h.a r10) {
            if (r10 != androidx.lifecycle.h.a.ON_START) goto L6;
            OnBackPressedDispatcher r11 = this.f460n;
            r11.getClass();
            n r12 = this.f458b;
            he.i.f(r12, "onBackPressedCallback");
            r11.f451c.addLast(r12);
            c r13 = new c(r11, r12);
            r12.f499b.add(r13);
            r11.d();
            r12.f500c = new v(r11);
            this.f459m = r13;
            return;
        L6:
            if (r10 != androidx.lifecycle.h.a.ON_STOP) goto L11;
            c r14 = this.f459m;
            if (r14 == null) goto L15;
            r14.cancel();
            return;
        L15:
            return;
        L11:
            if (r10 != androidx.lifecycle.h.a.ON_DESTROY) goto L17;
            cancel();
            return;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f461a = null;

        static {
            f461a = new a();
        }

        public final OnBackInvokedCallback a(final ge.a<xd.j> r8) {
            he.i.f(r8, "onBackInvoked");
            return new t(r8);
        }

        public final void b(Object r8, int r10, Object r11) {
            he.i.f(r8, "dispatcher");
            he.i.f(r11, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
            ((OnBackInvokedDispatcher) r8).registerOnBackInvokedCallback(r10, (OnBackInvokedCallback) r11);
        }

        public final void c(Object r8, Object r10) {
            he.i.f(r8, "dispatcher");
            he.i.f(r10, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
            ((OnBackInvokedDispatcher) r8).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r10);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f462a = null;

        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ge.l<androidx.activity.b, xd.j> f463a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ge.l<androidx.activity.b, xd.j> f464b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ge.a<xd.j> f465c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ge.a<xd.j> f466d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(ge.l<? super androidx.activity.b, xd.j> r8, ge.l<? super androidx.activity.b, xd.j> r10, ge.a<xd.j> r11, ge.a<xd.j> r12) {
                this.f463a = r8;
                this.f464b = r10;
                this.f465c = r11;
                this.f466d = r12;
            }

            @Override // android.window.OnBackAnimationCallback
            public final void onBackCancelled() {
                this.f466d.f();
            }

            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                this.f465c.f();
            }

            @Override // android.window.OnBackAnimationCallback
            public final void onBackProgressed(BackEvent r8) {
                he.i.f(r8, "backEvent");
                androidx.activity.b r10 = new androidx.activity.b(r8);
                this.f464b.invoke(r10);
            }

            @Override // android.window.OnBackAnimationCallback
            public final void onBackStarted(BackEvent r8) {
                he.i.f(r8, "backEvent");
                androidx.activity.b r10 = new androidx.activity.b(r8);
                this.f463a.invoke(r10);
            }
        }

        static {
            f462a = new b();
        }

        public final OnBackInvokedCallback a(ge.l<? super androidx.activity.b, xd.j> r8, ge.l<? super androidx.activity.b, xd.j> r10, ge.a<xd.j> r11, ge.a<xd.j> r12) {
            he.i.f(r8, "onBackStarted");
            he.i.f(r10, "onBackProgressed");
            he.i.f(r11, "onBackInvoked");
            he.i.f(r12, "onBackCancelled");
            return new a(r8, r10, r11, r12);
        }
    }

    public final class c implements androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f468b;

        public c(OnBackPressedDispatcher r8, n r10) {
            this.f468b = r8;
            this.f467a = r10;
        }

        @Override // androidx.activity.c
        public final void cancel() {
            OnBackPressedDispatcher r8 = this.f468b;
            yd.d<n> r10 = r8.f451c;
            n r11 = this.f467a;
            r10.remove(r11);
            if (he.i.a(r8.f452d, r11) == false) goto L5;
            r11.getClass();
            r8.f452d = null;
        L5:
            r11.getClass();
            r11.f499b.remove(this);
            ge.a<xd.j> r12 = r11.f500c;
            if (r12 == null) goto L8;
            r12.f();
        L8:
            r11.f500c = null;
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public final void a(androidx.lifecycle.m r8, FragmentManager.c r10) {
        he.i.f(r10, "onBackPressedCallback");
        androidx.lifecycle.h r11 = r8.getLifecycle();
        if (r11.b() != androidx.lifecycle.h.b.f2157a) goto L5;
        return;
    L5:
        LifecycleOnBackPressedCancellable r12 = new LifecycleOnBackPressedCancellable(this, r11, r10);
        r10.f499b.add(r12);
        d();
        r10.f500c = new u(this);
    }

    public final void b() {
        yd.d<n> r8 = this.f451c;
        ListIterator<n> r10 = r8.listIterator(r8.size());
    L4:
        if (r10.hasPrevious() == false) goto L8;
        n r11 = r10.previous();
        if (r11.f498a == false) goto L4;
    L9:
        n r12 = r11;
        this.f452d = null;
        if (r12 == null) goto L13;
        r12.a();
        return;
    L13:
        Runnable r13 = this.f449a;
        if (r13 == null) goto L20;
        r13.run();
        return;
    L20:
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final void c(boolean r8) {
        OnBackInvokedDispatcher r10 = this.f454f;
        if (r10 == null) goto L16;
        OnBackInvokedCallback r11 = this.f453e;
        if (r11 == null) goto L17;
        a r12 = a.f461a;
        if (r8 == true) goto L9;
    L11:
        if (r8 == false) goto L13;
        return;
    L13:
        if (this.f455g == false) goto L20;
        r12.c(r10, r11);
        this.f455g = false;
        return;
    L20:
        return;
    L9:
        if (this.f455g == true) goto L11;
        r12.b(r10, 0, r11);
        this.f455g = true;
        return;
    L17:
        return;
    }

    public final void d() {
        boolean r8 = this.f456h;
        yd.d<n> r10 = this.f451c;
        boolean r11 = false;
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<n> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        if (r12.next().f498a == false) goto L9;
        r11 = true;
    L13:
        this.f456h = r11;
        if (r11 == r8) goto L25;
        i0.a<Boolean> r13 = this.f450b;
        if (r13 == null) goto L19;
        r13.accept(Boolean.valueOf(r11));
    L19:
        if (Build.VERSION.SDK_INT < 33) goto L26;
        c(r11);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }

    public OnBackPressedDispatcher(Runnable r8) {
        this.f449a = r8;
        this.f450b = null;
        this.f451c = new yd.d();
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 33) goto L5;
        return;
    L5:
        if (r10 < 34) goto L7;
        OnBackInvokedCallback r11 = b.f462a.a(new o(this), new p(this), new q(this), new r(this));
    L8:
        this.f453e = r11;
        return;
    L7:
        r11 = a.f461a.a(new s(this));
        goto L8
    }
}
