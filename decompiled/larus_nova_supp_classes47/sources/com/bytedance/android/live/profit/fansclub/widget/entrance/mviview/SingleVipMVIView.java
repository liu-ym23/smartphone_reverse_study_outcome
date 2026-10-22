package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import eu0.m0;
import eu0.o0;
import eu0.q0;
import eu0.r0;
import eu0.s0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleVipMVIView extends com.bytedance.android.anya.d<m0, o0, eu0.h> {
    public final CompositeDisposable h;
    public final Interpolator i;
    public final Interpolator j;
    public final Interpolator k;
    public AnimatorSet l;
    public final ArrayList<Animator> m;
    public final View n;
    public final RelativeLayout o;
    public final HSImageView p;
    public final HSImageView q;
    public final Context r;
    public final DataCenter s;
    public final ViewGroup t;

    public final void p() {
        com.bytedance.android.live.revenue.common.o.a(this.q);
        Iterator<Animator> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Animator r1 = r0.next();
        r1.removeAllListeners();
        if (r1.isRunning() == false) goto L4;
        r1.cancel();
        goto L4
    L8:
        this.m.clear();
        this.o.setAlpha(1.0f);
        this.o.getBackground().setAlpha(255);
        this.p.setScaleX(1.0f);
        this.p.setScaleY(1.0f);
    }

    public final void i() {
        p();
        this.h.clear();
    }

    public final Context getContext() {
        return this.r;
    }

    public final void a(com.bytedance.android.anya.dsl.f<m0> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleVipMVIView$bindToParent$1 r0 = SingleVipMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        if ((r9 instanceof q0) == false) goto L6;
        AnimatorSet r10 = com.bytedance.android.live.revenue.common.e.c(this.p, new float[]{1.0f, 0.9f});
        r10.setDuration(150);
        r10.setInterpolator(this.i);
        AnimatorSet r0 = com.bytedance.android.live.revenue.common.e.c(this.p, new float[]{0.9f, 1.06f});
        r0.setDuration(200);
        r0.setInterpolator(this.i);
        AnimatorSet r6 = com.bytedance.android.live.revenue.common.e.c(this.p, new float[]{1.06f, 1.0f});
        r6.setDuration(150);
        r6.setInterpolator(this.i);
        AnimatorSet r4 = new AnimatorSet();
        r4.playSequentially(new Animator[]{r10, r0, r6});
        r4.start();
        this.m.add(r4);
        Unit r12 = Unit.INSTANCE;
        this.l = r4;
        RxUtilKt.c(Observable.timer(1300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(this)), this.h);
    L11:
        return true;
    L6:
        if ((r9 instanceof s0) == false) goto L9;
        ObjectAnimator r13 = ObjectAnimator.ofInt(this.o.getBackground(), "alpha", new int[]{255, 77, 255, 77, 255, 77, 255});
        r13.setDuration(9000);
        r13.setInterpolator(new LinearInterpolator());
        r13.start();
        this.m.add(r13);
        Unit r14 = Unit.INSTANCE;
        goto L11
    L9:
        if ((r9 instanceof r0) == false) goto L13;
        this.o.setBackground(s1.m(2131253208));
        ObjectAnimator r15 = ObjectAnimator.ofInt(this.o.getBackground(), "alpha", new int[]{25, 255});
        r15.setDuration(750);
        r15.start();
        this.m.add(r15);
        Unit r16 = Unit.INSTANCE;
        goto L11
    L13:
        return false;
    }

    public final void b(com.bytedance.android.anya.k r10, MVIState r12) {
        o0 r13 = (o0) r12;
        Intrinsics.checkNotNullParameter(r10, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r13, "state");
        com.bytedance.android.anya.internal.r r0 = r13.a;
        KProperty[] r1 = o0.g;
        KProperty r3 = r1[0];
        r0.getClass();
        Object r4 = r10.c.a(r0);
        int r5 = 8;
        if (r4 == null) goto L9;
        r10.b.a.invoke(r0);
        boolean r2 = ((Boolean) r4).booleanValue();
        ViewGroup r6 = this.t;
        if (r2 == false) goto L7;
        int r7 = 0;
    L8:
        r6.setVisibility(r7);
        goto L9
    L7:
        r7 = 8;
    L9:
        com.bytedance.android.anya.internal.r r8 = r13.c();
        Object r9 = r10.c.a(r8);
        if (r9 == null) goto L16;
        r10.b.a.invoke(r8);
        int r14 = ((Number) r9).intValue();
        HSImageView r15 = this.p;
        r15.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        if (r14 == 0) goto L16;
        if (r14 == (-1)) goto L16;
        ImageLoader.bindDrawableResource(r15, r14);
    L16:
        com.bytedance.android.anya.internal.r r16 = r13.c;
        KProperty r17 = r1[2];
        r16.getClass();
        Object r18 = r10.c.a(r16);
        if (r18 == null) goto L22;
        r10.b.a.invoke(r16);
        boolean r19 = ((Boolean) r18).booleanValue();
        HSImageView r20 = this.p;
        if (r19 == false) goto L21;
        r5 = 0;
    L21:
        r20.setVisibility(r5);
    L22:
        com.bytedance.android.anya.internal.r r22 = r13.b();
        Object r23 = r10.c.a(r22);
        if (r23 == null) goto L27;
        r10.b.a.invoke(r22);
        int r24 = ((Number) r23).intValue();
        if (r24 == 0) goto L27;
        this.o.setBackground(s1.m(r24));
    L27:
        com.bytedance.android.anya.internal.r r25 = r13.a();
        Object r26 = r10.c.a(r25);
        if (r26 == null) goto L38;
        r10.b.a.invoke(r25);
        int r27 = r.a[((EntranceAnimState) r26).ordinal()];
        if (r27 == 1) goto L37;
        if (r27 != 2) goto L33;
        AbstractDraweeController r28 = Fresco.newDraweeControllerBuilder().setUri(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).Q("/revenue/entrance/ttlive_user_vip_activate_shining.webp")).setControllerListener(new t(this)).setAutoPlayAnimations(true).build();
        HSImageView r29 = this.q;
        r29.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r29.setController(r28);
        r29.setVisibility(0);
        final AnimatorSet r30 = com.bytedance.android.live.revenue.common.e.c(this.p, new float[]{1.0f, 0.4f});
        r30.setDuration(200);
        r30.setInterpolator(this.i);
        final ObjectAnimator r32 = ObjectAnimator.ofFloat(this.p, "alpha", new float[]{1.0f, 0.0f});
        r32.setDuration(50);
        AnimatorSet r33 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.b(r33, new SingleVipMVIView$playActivateHidingAnim$$inlined$apply$lambda$1(this, r30, r32));
        r33.playSequentially(new Animator[]{r30, r32});
        r33.start();
        this.m.add(r33);
        Unit r34 = Unit.INSTANCE;
        goto L38
    L33:
        if (r27 == 3) goto L35;
        p();
        goto L38
    L35:
        final AnimatorSet r35 = com.bytedance.android.live.revenue.common.e.c(this.p, new float[]{0.4f, 1.04f});
        r35.setDuration(250);
        r35.setInterpolator(this.j);
        final AnimatorSet r36 = com.bytedance.android.live.revenue.common.e.c(this.p, new float[]{1.04f, 0.98f, 1.005f, 1.0f});
        r36.setDuration(450);
        r36.setInterpolator(this.k);
        final ObjectAnimator r37 = ObjectAnimator.ofFloat(this.p, "alpha", new float[]{0.0f, 1.0f});
        r37.setDuration(100);
        AnimatorSet r38 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.b(r38, new SingleVipMVIView$playActivateShowingAnim$$inlined$apply$lambda$1(this, r35, r37, r36));
        r38.play(r35).with(r37).before(r36);
        r38.start();
        this.m.add(r38);
        Unit r39 = Unit.INSTANCE;
        goto L38
    L37:
        AbstractDraweeController r40 = Fresco.newDraweeControllerBuilder().setUri(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).Q("/revenue/entrance/ttlive_user_vip_follow_anim.webp")).setAutoPlayAnimations(true).setControllerListener(new w(this)).build();
        HSImageView r42 = this.q;
        r42.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r42.setController(r40);
        ObjectAnimator r43 = ObjectAnimator.ofFloat(this.o, "alpha", new float[]{0.0f, 1.0f});
        r43.setDuration(300);
        r43.start();
        this.m.add(r43);
        Unit r44 = Unit.INSTANCE;
    L38:
        com.bytedance.android.anya.internal.r r110 = r13.f;
        KProperty r45 = r1[5];
        r110.getClass();
        Object r46 = r10.c.a(r110);
        if (r46 == null) goto L42;
        r10.b.a.invoke(r110);
        HSImageView r111 = this.p;
        r111.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        Intrinsics.checkNotNullParameter(r111, "$this$bindImage");
        ImageLoader.bindImage(r111, (py.k) r46);
        return;
    }

    public SingleVipMVIView(Context r5, DataCenter r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "containerView");
        this.r = r5;
        this.s = r6;
        this.t = r7;
        this.h = new CompositeDisposable();
        this.i = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        this.j = PathInterpolatorCompat.create(0.26f, 0.44f, 0.48f, 1.0f);
        this.k = PathInterpolatorCompat.create(0.17f, 0.0f, 0.83f, 1.0f);
        this.m = new ArrayList();
        View r8 = LayoutInflater.from(r5).inflate(2131567560, r7, true);
        this.n = r8;
        this.o = (RelativeLayout) r8.findViewById(2131392628);
        this.p = r8.findViewById(2131392626);
        this.q = r8.findViewById(2131392627);
    }
}
