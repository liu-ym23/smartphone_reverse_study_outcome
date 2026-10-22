package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class FansClubMVIView<SUPER_STATE extends MVIState<SUPER_STATE>, STATE extends MVIState<STATE>> extends com.bytedance.android.anya.d<SUPER_STATE, STATE, eu0.h> {
    public final CompositeDisposable h;
    public ObjectAnimator i;
    public AnimatorSet j;
    public final View k;
    public final HSImageView l;
    public final RelativeLayout m;
    public final HSImageView n;
    public final TextView o;
    public final Context p;
    public final DataCenter q;
    public final ViewGroup r;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FansClubMVIView a;

        public a(FansClubMVIView r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            AnimatorSet r3 = this.a.j;
            if (r3 == null) goto L6;
            r3.start();
            return;
        }
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ FansClubMVIView a;
        public final /* synthetic */ long b;

        public b(FansClubMVIView r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailure(String r5, Throwable r6) {
            long r0 = SystemClock.uptimeMillis() - this.b;
            com.bytedance.android.live.profit.privilege.e r7 = com.bytedance.android.live.profit.privilege.e.a;
            Integer r8 = null;
            if (r6 == null) goto L5;
            String r2 = q0.a(r6);
        L6:
            if (r6 == null) goto L8;
            r8 = Integer.valueOf(r0.a(r6));
        L8:
            JSONObject r9 = com.bytedance.android.live.profit.privilege.e.k(false, r2, r8);
            JSONObject r10 = com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r0));
            JSONObject r1 = new JSONObject();
            com.bytedance.android.live.profit.privilege.e.p("ttilive_fans_show_anim_status_all", r9, r10, r1);
            com.bytedance.android.live.profit.privilege.e.p("ttilive_fans_show_anim_status_error", r9, r10, r1);
            FansClubMVIView r12 = this.a;
            r12.o(new eu0.t(r12.q));
            return;
        L5:
            r2 = null;
            goto L6
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            ImageInfo r6 = (ImageInfo) r4;
            Intrinsics.checkNotNullParameter(r3, "id");
            if ((r5 instanceof AnimatedDrawable2) == false) goto L6;
            long r7 = SystemClock.uptimeMillis() - this.b;
            com.bytedance.android.live.profit.privilege.e r0 = com.bytedance.android.live.profit.privilege.e.a;
            com.bytedance.android.live.profit.privilege.e.p("ttilive_fans_show_anim_status_all", com.bytedance.android.live.profit.privilege.e.k(true, null, null), com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r7)), new JSONObject());
            ((AnimatedDrawable2) r5).setAnimationListener(new com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.c(this));
            return;
        }
    }

    public static final class c implements Interpolator {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r3) {
            return ((r3 * r3) * (-2.0f)) + (2 * r3);
        }
    }

    public abstract String q();

    public abstract boolean r();

    public final void g() {
        this.k.setOnClickListener(new w0(new FansClubMVIView$onAttach$1(this), 1000));
        View r0 = this.k;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r1 = fu0.b.a(this.q);
        if (r1 == null) goto L5;
        boolean r2 = r1.A();
    L6:
        if (r2 == false) goto L12;
        if (r() == false) goto L10;
        int r3 = 2131919079;
    L15:
        r3.c(r0, s1.B(r3), true);
        return;
    L10:
        r3 = 2131916323;
        goto L15
    L12:
        if (r() == false) goto L14;
        r3 = 2131919070;
        goto L15
    L14:
        r3 = 2131916322;
        goto L15
    L5:
        r2 = false;
        goto L6
    }

    public final void p() {
        com.bytedance.android.live.revenue.common.o.a(this.l);
        ObjectAnimator r0 = this.i;
        if (r0 != null) goto L5;
    L9:
        AnimatorSet r1 = this.j;
        if (r1 != null) goto L12;
    L16:
        this.m.setAlpha(1.0f);
        this.n.setScaleX(1.0f);
        this.n.setScaleY(1.0f);
        this.n.setVisibility(0);
        return;
    L12:
        if (r1.isRunning() != true) goto L16;
        AnimatorSet r2 = this.j;
        if (r2 == null) goto L16;
        r2.cancel();
        goto L16
    L5:
        if (r0.isRunning() != true) goto L9;
        ObjectAnimator r3 = this.i;
        if (r3 == null) goto L9;
        r3.cancel();
        goto L9
    }

    public final void i() {
        p();
        this.h.clear();
    }

    public final void s() {
        Interpolator r0 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        AnimatorSet r1 = com.bytedance.android.live.revenue.common.e.c(this.n, new float[]{1.0f, 0.9f});
        r1.setDuration(150);
        r1.setInterpolator(r0);
        AnimatorSet r5 = com.bytedance.android.live.revenue.common.e.c(this.n, new float[]{0.9f, 1.06f});
        r5.setDuration(200);
        r5.setInterpolator(r0);
        AnimatorSet r6 = com.bytedance.android.live.revenue.common.e.c(this.n, new float[]{1.06f, 1.0f});
        r6.setDuration(150);
        r6.setInterpolator(r0);
        AnimatorSet r2 = new AnimatorSet();
        r2.playSequentially(new Animator[]{r1, r5, r6});
        r2.start();
        Unit r3 = Unit.INSTANCE;
        this.j = r2;
        RxUtilKt.c(Observable.timer(1300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.h);
    }

    public final Context getContext() {
        return this.p;
    }

    public final void t(boolean r8) {
        Fresco.newDraweeControllerBuilder().setUri(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).Q(q())).setAutoPlayAnimations(true).setControllerListener(new b(this, SystemClock.uptimeMillis())).build();
        o(new eu0.t(this.q));
        if (r8 == false) goto L5;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.m, "scaleX", new float[]{1.0f, 1.2f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.m, "scaleY", new float[]{1.0f, 1.3f});
        AnimatorSet r5 = new AnimatorSet();
        r5.setDuration(300);
        r5.playTogether(new Animator[]{r9, r4});
        r5.setInterpolator(c.a);
        r5.start();
        return;
    L5:
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this.m, "alpha", new float[]{0.0f, 1.0f});
        r10.setDuration(300);
        r10.start();
        Unit r0 = Unit.INSTANCE;
        this.i = r10;
    }

    public FansClubMVIView(Context r2, DataCenter r3, ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.h = new CompositeDisposable();
        View r6 = LayoutInflater.from(r2).inflate(r5, r4, true);
        this.k = r6;
        this.l = r6.findViewById(2131372113);
        this.m = (RelativeLayout) r6.findViewById(2131372114);
        this.n = r6.findViewById(2131372112);
        this.o = (TextView) r6.findViewById(2131372117);
    }
}
