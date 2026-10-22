package com.obric.oui.animation.easy;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewPropertySpringAnimator<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<p5.a> f6177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<i9.c<? super T>, i9.d> f6178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f6179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a<T> f6181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i9.b.q f6182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final T f6183g;

    public interface a<T extends View> {
        void a(ViewPropertySpringAnimator<T> r10);

        void b(ViewPropertySpringAnimator<T> r10);
    }

    public static final class b implements i9.b.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPropertySpringAnimator f6184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i9.c f6185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f6186c;

        b(ViewPropertySpringAnimator r10, i9.c r11, c r12) {
            this.f6184a = r10;
            this.f6185b = r11;
            this.f6186c = r12;
        }

        @Override // i9.b.p
        public void a(i9.b<? extends i9.b<?>> r10, boolean r11, float r12, float r13) {
            ViewPropertySpringAnimator.b(this.f6184a).remove(this.f6185b);
            if (r10 == null) goto L5;
            r10.h(this);
        L5:
            if (r10 == null) goto L7;
            r10.k(this.f6186c);
        L7:
            ViewPropertySpringAnimator.d(this.f6184a, null);
            if (ViewPropertySpringAnimator.b(this.f6184a).isEmpty() == false) goto L14;
            if (r11 == true) goto L15;
            a r14 = ViewPropertySpringAnimator.a(this.f6184a);
            if (r14 == null) goto L16;
            r14.a(this.f6184a);
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    public static final class c implements i9.b.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPropertySpringAnimator f6187a;

        c(ViewPropertySpringAnimator r10) {
            this.f6187a = r10;
        }

        @Override // i9.b.q
        public void a(i9.b<? extends i9.b<?>> r10, float r11, float r12) {
            i9.b.q r13 = ViewPropertySpringAnimator.c(this.f6187a);
            if (r13 == null) goto L6;
            r13.a(r10, r11, r12);
            return;
        }
    }

    public static final class d implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f6188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f6189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f6190c;

        d(Function1 r10, Function1 r11, Function1 r12) {
            this.f6188a = r10;
            this.f6189b = r11;
            this.f6190c = r12;
        }

        @Override // com.obric.oui.animation.easy.ViewPropertySpringAnimator.a
        public void a(ViewPropertySpringAnimator<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "animator");
            this.f6190c.invoke(r10);
        }

        @Override // com.obric.oui.animation.easy.ViewPropertySpringAnimator.a
        public void b(ViewPropertySpringAnimator<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "animator");
            this.f6188a.invoke(r10);
        }
    }

    public ViewPropertySpringAnimator(T r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.f6183g = r10;
        this.f6177a = new ArrayList();
        this.f6178b = new LinkedHashMap();
        this.f6179c = 0.5f;
        this.f6180d = 1500.0f;
    }

    public static final /* synthetic */ a a(ViewPropertySpringAnimator r10) {
        return r10.f6181e;
    }

    public static final /* synthetic */ Map b(ViewPropertySpringAnimator r10) {
        return r10.f6178b;
    }

    public static final /* synthetic */ i9.b.q c(ViewPropertySpringAnimator r10) {
        return r10.f6182f;
    }

    public static final /* synthetic */ void d(ViewPropertySpringAnimator r10, i9.b.q r11) {
        r10.f6182f = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator f(ViewPropertySpringAnimator r10, i9.c r11, float r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = ViewPropertySpringAnimator$animateProperty$2.INSTANCE;
    L6:
        return r10.e(r11, r12, r13);
    }

    private final void g(i9.c<? super T> r10, float r11, Function1<? super com.obric.oui.animation.easy.a, Unit> r12) {
        i9.d r13 = this.f6178b.get(r10);
        if (r13 != null) goto L5;
        r13 = new i9.d(this.f6183g, r10);
        h(r13, r10);
        this.f6178b.put(r10, r13);
    L5:
        com.obric.oui.animation.easy.a r14 = new com.obric.oui.animation.easy.a(r11);
        r12.invoke(r14);
        r14.e(this.f6179c);
        r14.f(this.f6180d);
        this.f6177a.add(new p5.a(r13, r14));
    }

    private final void h(i9.d r10, i9.c<? super T> r11) {
        c r12 = new c(this);
        r10.b(r12);
        r10.a(new b(this, r11, r12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewPropertySpringAnimator n(ViewPropertySpringAnimator r10, Function1 r11, Function1 r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = ViewPropertySpringAnimator$setListener$1.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = ViewPropertySpringAnimator$setListener$2.INSTANCE;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = ViewPropertySpringAnimator$setListener$3.INSTANCE;
    L12:
        return r10.m(r11, r12, r13);
    }

    public final ViewPropertySpringAnimator<T> e(i9.c<? super T> r10, float r11, Function1<? super com.obric.oui.animation.easy.a, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r12, "config");
        g(r10, r11, r12);
        return this;
    }

    public final ViewPropertySpringAnimator<T> i(float r10) {
        this.f6179c = r10;
        return this;
    }

    public final ViewPropertySpringAnimator<T> j(float r10) {
        this.f6180d = r10;
        return this;
    }

    public final boolean k() {
        Collection<i9.d> r10 = this.f6178b.values();
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (((i9.d) r11.next()).g() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return false;
    }

    public final ViewPropertySpringAnimator<T> l(a<T> r10) {
        this.f6181e = r10;
        return this;
    }

    public final ViewPropertySpringAnimator<T> m(Function1<? super ViewPropertySpringAnimator<T>, Unit> r10, Function1<? super ViewPropertySpringAnimator<T>, Unit> r11, Function1<? super ViewPropertySpringAnimator<T>, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "onStart");
        Intrinsics.checkNotNullParameter(r11, "onCancel");
        Intrinsics.checkNotNullParameter(r12, "onEnd");
        return l(new d(r10, r11, r12));
    }

    public final void o(i9.b.q r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.f6182f = r10;
    }

    public final ViewPropertySpringAnimator<T> p() {
        if (this.f6177a.isEmpty() == true) goto L12;
        List r10 = CollectionsKt.toList(this.f6177a);
        this.f6177a.clear();
        a<T> r11 = this.f6181e;
        if (r11 == null) goto L8;
        r11.b(this);
    L8:
        Iterator r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        ((p5.a) r12.next()).a();
    L12:
        return this;
    }

    public final ViewPropertySpringAnimator<T> q(float r10, Function1<? super com.obric.oui.animation.easy.a, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "config");
        i9.b.r r12 = i9.b.f9412m;
        Intrinsics.checkNotNullExpressionValue(r12, "DynamicAnimation.TRANSLATION_Y");
        return e(r12, r10, r11);
    }
}
