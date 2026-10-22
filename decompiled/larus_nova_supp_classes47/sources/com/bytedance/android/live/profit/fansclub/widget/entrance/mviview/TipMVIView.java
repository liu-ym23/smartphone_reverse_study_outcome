package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.b0;
import eu0.j0;
import eu0.p0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TipMVIView extends com.bytedance.android.anya.d<eu0.j, p0, eu0.h> {
    public static final float p = 0.0f;
    public static final float q = 0.0f;
    public final CompositeDisposable h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public Disposable l;
    public final Context m;
    public final DataCenter n;
    public final ViewGroup o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TipMVIView a;
        public final /* synthetic */ com.bytedance.android.anya.a0 b;

        public b(TipMVIView r1, com.bytedance.android.anya.a0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            TipMVIView r7 = this.a;
            r7.o(new b0(false, ((j0) this.b).a, r7.n));
        }
    }

    public final TextView p() {
        return (TextView) this.k.getValue();
    }

    static {
        p = UtilityKotlinExtentionsKt.h(131);
        q = UtilityKotlinExtentionsKt.h(160);
    }

    public final void g() {
        LayoutInflater.from(this.m).inflate(2131567554, this.o, true);
        UtilityKotlinExtentionsKt.t(this.o);
    }

    public final void i() {
        this.h.clear();
    }

    public final float q() {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(this.n);
        if (r0 != null) goto L7;
        return p;
    L7:
        if (r0.I() == false) goto L9;
        boolean r2 = true;
        if (r0.K() == true) goto L14;
        r2 = true ^ r0.x();
    L14:
        if (r2 == false) goto L17;
        return p;
    L17:
        return q;
    L9:
        return p;
    }

    public final Context getContext() {
        return this.m;
    }

    public final void a(com.bytedance.android.anya.dsl.f<eu0.j> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        TipMVIView$bindToParent$1 r0 = TipMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r6) {
        Intrinsics.checkNotNullParameter(r6, "e");
        if ((r6 instanceof j0) == false) goto L8;
        ALogger.w("FansClubTipMVIView", "ShowTipEffect");
        Disposable r0 = this.l;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        j0 r1 = (j0) r6;
        o(new b0(true, r1.a, this.n));
        Disposable r7 = RxUtilKt.h(Observable.timer(r1.b, TimeUnit.MILLISECONDS)).subscribe(new b(this, r6));
        RxUtilKt.c(r7, this.h);
        Unit r2 = Unit.INSTANCE;
        this.l = r7;
        return true;
    L8:
        return false;
    }

    public final void b(com.bytedance.android.anya.k r18, MVIState r19) {
        p0 r2 = (p0) r19;
        Intrinsics.checkNotNullParameter(r18, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r2, "state");
        com.bytedance.android.anya.internal.r r3 = r2.a;
        KProperty[] r4 = p0.c;
        KProperty r6 = r4[0];
        r3.getClass();
        Object r7 = r18.c.a(r3);
        String r8 = "FansClubTipMVIView";
        if (r7 == null) goto L9;
        r18.b.a.invoke(r3);
        boolean r5 = ((Boolean) r7).booleanValue();
        ALogger.i("FansClubTipMVIView", "show=" + r5);
        if (r5 == false) goto L7;
        UtilityKotlinExtentionsKt.w(this.o);
        AnimatorSet r9 = new AnimatorSet();
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setStartDelay(200);
        r10.setDuration(150);
        r10.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.56f, 0.46f, 1.0f));
        r10.addUpdateListener(new z(this));
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, q()});
        r12.setDuration(250);
        r12.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
        r12.addUpdateListener(new a0(this));
        r9.playTogether(new Animator[]{r10, r12});
        AnimatorSet r13 = com.bytedance.android.live.revenue.common.e.c(p(), new float[]{1.0f, 1.2f});
        r13.setStartDelay(150);
        r13.setDuration(150);
        r13.setInterpolator(PathInterpolatorCompat.create(0.29f, 0.22f, 0.21f, 1.51f));
        Unit r14 = Unit.INSTANCE;
        AnimatorSet r15 = com.bytedance.android.live.revenue.common.e.c(p(), new float[]{1.2f, 1.0f});
        r15.setDuration(200);
        r15.setInterpolator(PathInterpolatorCompat.create(0.29f, 0.22f, 0.21f, 1.51f));
        r9.playSequentially(new Animator[]{r13, r15});
        com.bytedance.android.live.revenue.common.e.b(r9, new TipMVIView$showTip$3(this));
        r9.start();
        goto L9
    L7:
        r8 = "FansClubTipMVIView";
        AnimatorSet r16 = new AnimatorSet();
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r17.setDuration(150);
        r17.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.56f, 0.46f, 1.0f));
        r17.addUpdateListener(new x(this));
        ValueAnimator r20 = ValueAnimator.ofFloat(new float[]{q(), 0.0f});
        r20.setDuration(250);
        r20.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.68f, 0.06f));
        r20.addUpdateListener(new y(this));
        char r22 = 1;
        r16.playTogether(new Animator[]{r17, r20});
        com.bytedance.android.live.revenue.common.e.b(r16, new TipMVIView$hideTip$1(this));
        r16.start();
    L10:
        com.bytedance.android.anya.internal.r r23 = r2.b;
        KProperty r24 = r4[r22];
        r23.getClass();
        Object r25 = r18.c.a(r23);
        if (r25 == null) goto L14;
        r18.b.a.invoke(r23);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.k r26 = (com.bytedance.android.live.profit.fansclub.widget.entrance.data.k) r25;
        ALogger.i(r8, "tip=" + r26);
        ((TextView) this.j.getValue()).setText(r26.a);
        p().setText(r26.b);
        return;
    L14:
        return;
    L9:
        r22 = 1;
        goto L10
    }

    public TipMVIView(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.h = new CompositeDisposable();
        this.i = LazyKt.lazy(new TipMVIView$content$2(this));
        this.j = LazyKt.lazy(new TipMVIView$line1$2(this));
        this.k = LazyKt.lazy(new TipMVIView$line2$2(this));
    }
}
