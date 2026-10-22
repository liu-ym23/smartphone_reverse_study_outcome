package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final Animator a;
    public final ArrayList<Animator> b;
    public List<? extends View> c;
    public long d;
    public Function0<Unit> e;
    public Function0<Unit> f;
    public TimeInterpolator g;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a.invoke(r2.getAnimatedValue());
        }
    }

    public b() {
        this.a = new AnimatorSet();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = 300;
    }

    public static void b(b r4, float[] r5) {
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "values");
        float[] r1 = Arrays.copyOf(r5, r5.length);
        Intrinsics.checkNotNullParameter(r1, "values");
        r4.a(View.SCALE_X, Arrays.copyOf(r1, r1.length), null);
        float[] r6 = Arrays.copyOf(r5, r5.length);
        Intrinsics.checkNotNullParameter(r6, "values");
        r4.a(View.SCALE_Y, Arrays.copyOf(r6, r6.length), null);
    }

    public final void a(Property<View, Float> r4, float[] r5, Function1<Object, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "property");
        Intrinsics.checkNotNullParameter(r5, "values");
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ObjectAnimator r1 = ObjectAnimator.ofFloat((View) r0.next(), r4, Arrays.copyOf(r5, r5.length));
        r1.setRepeatCount(0);
        if (r6 == null) goto L8;
        r1.addUpdateListener(new a(r6));
    L8:
        this.b.add(r1);
        goto L4
    }
}
