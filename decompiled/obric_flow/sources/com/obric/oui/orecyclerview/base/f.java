package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f13716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f13717c;
    public final Lazy d;
    public final Lazy e;
    public boolean f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13718h;

    public f(Context r5, Interpolator r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "interpolator");
        this.f13715a = r5;
        this.f13716b = r10;
        this.f13717c = LazyKt.lazy(new OverScrollerAdapter$systemOverScroller$2(this));
        this.d = LazyKt.lazy(OverScrollerAdapter$fluidScrollerX$2.INSTANCE);
        this.e = LazyKt.lazy(OverScrollerAdapter$fluidScrollerY$2.INSTANCE);
        this.f = true;
        this.g = -1;
        this.f13718h = -1;
    }

    public final int a() {
        if (this.f == false) goto L7;
        return c().getCurrX();
    L7:
        return (int) ((c) this.d.getValue()).c(this.f13718h).f13706a;
    }

    public final int b() {
        if (this.f == false) goto L7;
        return c().getCurrY();
    L7:
        return (int) ((c) this.e.getValue()).c(this.f13718h).f13706a;
    }

    public final OverScroller c() {
        return (OverScroller) this.f13717c.getValue();
    }

    public final boolean d() {
        if (this.f == true) goto L5;
        b r5 = ((c) this.d.getValue()).c(this.f13718h);
        b r10 = ((c) this.e.getValue()).c(this.f13718h);
        if (r5.f13708c == true) goto L9;
    L11:
        return false;
    L9:
        if (r10.f13708c == false) goto L11;
        return true;
    L5:
        return c().isFinished();
    }
}
