package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends BaseMVIView<i, com.bytedance.android.livesdk.gift.platform.business.pkTray.a> {
    public final View h;
    public final b i;
    public final TextView j;
    public final HSImageView k;
    public final Context l;
    public final ViewGroup m;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public final void i() {
        AnimatorSet r0 = this.i.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.m.removeView(this.h);
    }

    public final Context getContext() {
        return this.l;
    }

    public k(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        this.l = r3;
        this.m = r4;
        View r5 = LayoutInflater.from(r3).inflate(2131566120, r4, false);
        r4.addView(r5);
        r5.setVisibility(8);
        r5.setOnClickListener(a.a);
        Unit r6 = Unit.INSTANCE;
        this.h = r5;
        this.i = new b();
        this.j = (TextView) r5.findViewById(2131367236);
        TextView r7 = (TextView) r5.findViewById(2131367266);
        this.k = r5.findViewById(2131373724);
    }

    public final void b(com.bytedance.android.anya.k r13, MVIState r14) {
        i r15 = (i) r14;
        Intrinsics.checkNotNullParameter(r13, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r15, "state");
        r r0 = r15.b;
        KProperty[] r1 = i.e;
        KProperty r3 = r1[1];
        r0.getClass();
        Object r4 = r13.c.a(r0);
        if (r4 == null) goto L5;
        r13.b.a.invoke(r0);
        ImageLoader.bindImage(this.k, (py.k) r4);
    L5:
        r r2 = r15.a;
        KProperty r5 = r1[0];
        r2.getClass();
        Object r6 = r13.c.a(r2);
        if (r6 == null) goto L8;
        r13.b.a.invoke(r2);
        this.j.setText(this.l.getString(2131918947, new Object[]{(String) r6}));
    L8:
        r r7 = r15.c;
        KProperty r8 = r1[2];
        r7.getClass();
        Object r9 = r13.c.a(r7);
        if (r9 == null) goto L14;
        r13.b.a.invoke(r7);
        o r10 = (o) r9;
        if (j.a[r10.a.ordinal()] != 1) goto L14;
        final b r11 = this.i;
        final View r16 = this.h;
        final long r17 = r10.b;
        final Function0<Unit> r18 = new CrossRoomTrayView$startTrayAnimation$1(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r16, "view");
        Intrinsics.checkNotNullParameter(r18, "endCallback");
        r16.setVisibility(0);
        r16.setTranslationY(0.0f);
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{0.0f, 1.0f});
        r19.setDuration(800);
        r19.setInterpolator(new PathInterpolator(0.65f, 0.0f, 0.35f, 1.0f));
        com.bytedance.android.live.revenue.common.e.b(r19, new CrossRoomTrayAnimator$startEnterAnimation$$inlined$apply$lambda$1(r11, r16, r18, r17));
        r19.start();
    L14:
        r r110 = r15.d;
        KProperty r20 = r1[3];
        r110.getClass();
        Object r21 = r13.c.a(r110);
        if (r21 == null) goto L18;
        r13.b.a.invoke(r110);
        a1.o(this.h, ((Number) r21).intValue());
        return;
    }
}
