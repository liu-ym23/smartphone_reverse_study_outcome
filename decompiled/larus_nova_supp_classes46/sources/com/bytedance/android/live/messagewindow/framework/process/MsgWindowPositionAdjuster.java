package com.bytedance.android.live.messagewindow.framework.process;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MsgWindowPositionAdjuster implements h71.d {
    public final c a;
    public final Lazy b;
    public final View c;

    public final void a() {
        float r0 = ((h71.e) this.b.getValue()).c();
        ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L8;
        r2.bottomMargin = s1.f(r0);
    L8:
        ViewGroup.LayoutParams r3 = this.c.getLayoutParams();
        this.c.setLayoutParams(r3);
    }

    public final void b() {
        float r0 = ((h71.e) this.b.getValue()).a();
        ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L8;
        r2.rightMargin = s1.f(r0);
    L8:
        ViewGroup.LayoutParams r3 = this.c.getLayoutParams();
        this.c.setLayoutParams(r3);
    }

    public final void c() {
        float r0 = ((h71.e) this.b.getValue()).d();
        ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L8;
        r2.topMargin = s1.f(r0);
    L8:
        ViewGroup.LayoutParams r3 = this.c.getLayoutParams();
        this.c.setLayoutParams(r3);
    }

    public final void e() {
        float r0 = ((h71.e) this.b.getValue()).b();
        ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L8;
        r2.leftMargin = s1.f(r0);
    L8:
        ViewGroup.LayoutParams r3 = this.c.getLayoutParams();
        this.c.setLayoutParams(r3);
    }

    public final void load() {
        c r0 = this.a;
        r0.getClass();
        Observable r1 = xs2.b.a().b(z61.b.class);
        if (r1 == null) goto L8;
        Disposable r2 = r1.subscribe(new b(r0));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, r0.b);
        return;
    L9:
        return;
    }

    public final void unload() {
        c r0 = this.a;
        r0.b.clear();
        r0.a.clear();
    }

    public final void d() {
        c();
        a();
        b();
        e();
    }

    public MsgWindowPositionAdjuster(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cardContainer");
        this.c = r2;
        this.a = new c();
        this.b = LazyKt.lazy(new MsgWindowPositionAdjuster$msgWindowPositionStrategy$2(this));
    }
}
