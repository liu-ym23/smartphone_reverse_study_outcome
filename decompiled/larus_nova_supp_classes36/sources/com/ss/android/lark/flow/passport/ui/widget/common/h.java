package com.ss.android.lark.flow.passport.ui.widget.common;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import uzb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends GradientDrawable {
    public static final float e = 0.0f;
    public static final int f = 0;
    public static final Map<g, Integer> g = null;
    public final Context a;
    public g b;
    public ValueAnimator c;
    public final Map<g, Integer> d;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ h a;
        public final /* synthetic */ int b;

        public b(h r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            h r0 = this.a;
            int r1 = this.b;
            Object r5 = r4.getAnimatedValue();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
            r0.setStroke(r1, ((Integer) r5).intValue());
        }
    }

    static {
        if (com.ss.android.lark.passport.a.b() == false) goto L5;
        float r0 = 30.0f;
    L6:
        e = r0;
        f = 2131109044;
        int r3 = 0;
        g[] r1 = {g.a, g.b, g.c};
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(3), 16));
    L7:
        if (r3 >= 3) goto L9;
        g r2 = r1[r3];
        r4.put(r2, Integer.valueOf(r2.a()));
        r3 = r3 + 1;
        goto L7
    L9:
        g = r4;
        return;
    L5:
        r0 = 6.0f;
        goto L6
    }

    public final ValueAnimator c(g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Map<g, Integer> r0 = this.d;
        Integer r1 = r0.get(r4);
        if (r1 != null) goto L5;
        r1 = Integer.valueOf(UDColorUtils.getColor(this.a, r4.a()));
        r0.put(r4, r1);
    L5:
        int r2 = r1.intValue();
        ValueAnimator r3 = b(l.a(LarkContext.getApplication(), 1.0f), r2);
        this.b = r4;
        return r3;
    }

    public final void a(g r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Integer r4 = Integer.valueOf(r3);
        this.d.put(r2, r4);
    }

    public final ValueAnimator b(int r5, int r6) {
        Map<g, Integer> r0 = this.d;
        g r1 = this.b;
        Integer r2 = r0.get(r1);
        if (r2 != null) goto L5;
        r2 = Integer.valueOf(UDColorUtils.getColor(this.a, this.b.a()));
        r0.put(r1, r2);
    L5:
        int r3 = r2.intValue();
        ValueAnimator r4 = this.c;
        if (r4 != null) goto L19;
    L17:
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r3, r6});
        r7.setDuration(300);
        r7.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
        r7.setEvaluator(new ArgbEvaluator());
        r7.addUpdateListener(new b(this, r5));
        r7.start();
        this.c = r7;
        Intrinsics.checkNotNull(r7);
        return r7;
    L19:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L10
        Object r9 = r4.getAnimatedValue();     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L10
        Object r10 = Result.constructor-impl(Integer.valueOf(((Integer) r9).intValue()));     // Catch: Throwable -> L10
    L13:
        if (Result.exceptionOrNull-impl(r10) == null) goto L16;
        r10 = Integer.valueOf(r3);
    L16:
        r3 = ((Number) r10).intValue();
    L10:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public h(Context r5, float r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r6 = e;
    L6:
        if ((r7 & 4) == 0) goto L8;
        g.c r8 = g.a;
    L9:
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r8, "initState");
        this.a = r5;
        this.b = r8;
        Map<g, Integer> r9 = g;
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r9.size()));
        Iterator r10 = ((LinkedHashMap) r9).entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r10.next();
        r0.put(r1.getKey(), Integer.valueOf(UDColorUtils.getColor(this.a, ((Number) r1.getValue()).intValue())));
        goto L11
    L13:
        Map<g, Integer> r11 = MapsKt.toMutableMap(r0);
        this.d = r11;
        Context r2 = this.a;
        if ((r2 instanceof Application) == false) goto L18;
        int r3 = com.ss.android.lark.officesdk.utils.di.e.a;
        if (com.ss.android.lark.officesdk.utils.di.e.a.b(r2) == false) goto L18;
        UDToast.show(this.a, "InputBgUtils.setStrokeColor(), don't use application context");
    L18:
        Integer r4 = r11.get(r8);
        if (r4 != null) goto L21;
        r4 = Integer.valueOf(UDColorUtils.getColor(this.a, r8.d));
        r11.put(r8, r4);
    L21:
        setStroke(l.a(this.a, 1.0f), r4.intValue());
        setColor(UDColorUtils.getColor(this.a, f));
        setCornerRadius(l.a(this.a, r6));
        return;
    L8:
        r8 = null;
        goto L9
    }
}
