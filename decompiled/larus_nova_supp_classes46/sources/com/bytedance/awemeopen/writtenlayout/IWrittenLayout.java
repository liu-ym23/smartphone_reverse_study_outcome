package com.bytedance.awemeopen.writtenlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class IWrittenLayout implements h, k, f, j, d, n, e, l, g, b, i, c, m {
    public final Context a;
    public final Lazy b;

    public abstract View f();

    public final View j() {
        return (View) this.b.getValue();
    }

    @Override // com.bytedance.awemeopen.writtenlayout.h, com.bytedance.awemeopen.writtenlayout.k, com.bytedance.awemeopen.writtenlayout.f, com.bytedance.awemeopen.writtenlayout.j, com.bytedance.awemeopen.writtenlayout.d, com.bytedance.awemeopen.writtenlayout.n, com.bytedance.awemeopen.writtenlayout.e, com.bytedance.awemeopen.writtenlayout.l, com.bytedance.awemeopen.writtenlayout.g, com.bytedance.awemeopen.writtenlayout.b, com.bytedance.awemeopen.writtenlayout.i, com.bytedance.awemeopen.writtenlayout.c, com.bytedance.awemeopen.writtenlayout.m
    public Context getContext() {
        return this.a;
    }

    public IWrittenLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new IWrittenLayout$view$2(this));
    }

    public static void d(RelativeLayout.LayoutParams r1) {
        Intrinsics.checkNotNullParameter(r1, "$receiver");
        r1.addRule(9);
    }

    public final int g(float r2) {
        float r0 = a.a;
        return a.a(getContext(), r2);
    }

    public static void q(TextView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$receiver");
        r1.setTextColor(r1.getResources().getColor(r2));
    }

    public final void h(ViewGroup.LayoutParams r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        float r0 = a.a;
        r2.height = a.a(getContext(), r3);
    }

    public final void i(ViewGroup.LayoutParams r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        float r0 = a.a;
        r2.width = a.a(getContext(), r3);
    }

    public final LinearLayout.LayoutParams m(LinearLayout r2, Function1<? super LinearLayout.LayoutParams, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -1);
        if (r3 == null) goto L5;
        r3.invoke(r4);
    L5:
        return r4;
    }

    public final FrameLayout n(ViewGroup.LayoutParams r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "lparams");
        FrameLayout r0 = new FrameLayout(getContext());
        r0.setLayoutParams(r3);
        r4.invoke(r0);
        return r0;
    }

    public final FrameLayout.LayoutParams v(FrameLayout r2, Function1<? super FrameLayout.LayoutParams, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        if (r3 == null) goto L5;
        r3.invoke(r4);
    L5:
        return r4;
    }

    public final LinearLayout.LayoutParams w(LinearLayout r2, Function1<? super LinearLayout.LayoutParams, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        if (r3 == null) goto L5;
        r3.invoke(r4);
    L5:
        return r4;
    }

    public final RelativeLayout.LayoutParams x(RelativeLayout r2, Function1<? super RelativeLayout.LayoutParams, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(-2, -2);
        if (r3 == null) goto L5;
        r3.invoke(r4);
    L5:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, com.bytedance.awemeopen.infra.base.image.AoImageView, java.lang.Object] */
    public final AoImageView e(ViewGroup r3, ViewGroup.LayoutParams r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        Intrinsics.checkNotNullParameter(r4, "lparams");
        ?? r0 = new AoImageView(r3.getContext());
        if (r5 == null) goto L5;
        r5.invoke(r0);
    L5:
        r3.addView(r0, r4);
        return r0;
    }

    public final ImageView k(ViewGroup r3, ViewGroup.LayoutParams r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        Intrinsics.checkNotNullParameter(r4, "lparams");
        ImageView r0 = new ImageView(r3.getContext());
        if (r5 == null) goto L5;
        r5.invoke(r0);
    L5:
        r3.addView(r0, r4);
        return r0;
    }

    public final ImageView l(ViewGroup r2, ViewGroup.LayoutParams r3, Function1<? super ImageView, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        Intrinsics.checkNotNullParameter(r3, "lparams");
        return k(r2, r3, r4);
    }

    public final LinearLayout o(int r3, ViewGroup.LayoutParams r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "lparams");
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(r3);
        r0.setLayoutParams(r4);
        r5.invoke(r0);
        return r0;
    }

    public final AppCompatTextView p(Integer r3, ViewGroup.LayoutParams r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "lparams");
        AppCompatTextView r0 = new AppCompatTextView(getContext());
        if (r3 == null) goto L5;
        r0.setId(r3.intValue());
    L5:
        if (r5 == null) goto L7;
        r5.invoke(r0);
    L7:
        r0.setLayoutParams(r4);
        return r0;
    }

    public final AppCompatTextView r(ViewGroup r2, ViewGroup.LayoutParams r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        Intrinsics.checkNotNullParameter(r3, "lparams");
        return s(r2, null, r3, r4);
    }

    public final View t(ViewGroup r2, ViewGroup.LayoutParams r3, Function1<? super View, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        Intrinsics.checkNotNullParameter(r3, "lparams");
        return u(r2, r3, r4);
    }

    public final View u(ViewGroup r3, ViewGroup.LayoutParams r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        Intrinsics.checkNotNullParameter(r4, "lparams");
        View r0 = new View(r3.getContext());
        if (r5 == null) goto L5;
        r5.invoke(r0);
    L5:
        r3.addView(r0, r4);
        return r0;
    }

    public static void a(ViewGroup r1, View r2, ViewGroup.LayoutParams r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "lparams");
        b(r1, null, r2, r3, r4);
    }

    public static /* synthetic */ void c(IWrittenLayout r0, ViewGroup r1, View r2, ViewGroup.LayoutParams r3) {
        r0.getClass();
        a(r1, r2, r3, null);
    }

    public final AppCompatTextView s(ViewGroup r2, Integer r3, ViewGroup.LayoutParams r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        Intrinsics.checkNotNullParameter(r4, "lparams");
        AppCompatTextView r6 = p(r3, r4, r5);
        r2.addView(r6);
        return r6;
    }

    public static void b(ViewGroup r1, Integer r2, View r3, ViewGroup.LayoutParams r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "lparams");
        if (r2 == null) goto L5;
        r3.setId(r2.intValue());
    L5:
        if (r5 == null) goto L7;
        r5.invoke(r3);
    L7:
        r1.addView(r3, r4);
    }
}
