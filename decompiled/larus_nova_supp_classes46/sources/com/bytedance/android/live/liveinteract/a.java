package com.bytedance.android.live.liveinteract;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a {
    public boolean A;
    public boolean B;
    public final TextView a;
    public final View b;
    public final TextView c;
    public final SimpleDraweeView d;
    public final ImageView e;
    public final TextView f;
    public final View g;
    public final Interpolator h;
    public final List<ObjectAnimator> i;
    public boolean j;
    public final ObjectAnimator k;
    public final ObjectAnimator l;
    public final ObjectAnimator m;
    public final ObjectAnimator n;
    public final ObjectAnimator o;
    public final ObjectAnimator p;
    public final ObjectAnimator q;
    public final ObjectAnimator r;
    public final ObjectAnimator s;
    public final ObjectAnimator t;
    public final ObjectAnimator u;
    public final ObjectAnimator v;
    public final AnimatorSet w;
    public final AnimatorSet x;
    public final AnimatorSet y;
    public final AnimatorSet z;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$a, reason: collision with other inner class name */
    public static final class C0009a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC0010a implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0010a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r0 = this.a.a;     // Catch: Throwable -> L6
                if (r0.A == false) goto L9;
                r0.m.start();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$b$b, reason: collision with other inner class name */
        public static final class RunnableC0011b implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0011b(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r0 = this.a.a;     // Catch: Throwable -> L6
                if (r0.A == false) goto L9;
                r0.x.start();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            super.onAnimationEnd(r4);
            this.a.e.postDelayed(new RunnableC0010a(this), 300);
            this.a.e.postDelayed(new RunnableC0011b(this), 2000);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            this.a.f.setVisibility(0);
            this.a.g.setVisibility(0);
            this.a.e.setVisibility(0);
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$c$a, reason: collision with other inner class name */
        public static final class RunnableC0012a implements Runnable {
            public final /* synthetic */ c a;

            public RunnableC0012a(c r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r0 = this.a.a;     // Catch: Throwable -> L8
                if (r0.A == true) goto L5;
                return;
            L5:
                if (r0.B == false) goto L15;
                r0.z.start();     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            super.onAnimationEnd(r4);
            a r5 = this.a;
            r5.B = true;
            r5.e.postDelayed(new RunnableC0012a(this), 5000);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            this.a.a.setVisibility(0);
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.a$d$a, reason: collision with other inner class name */
        public static final class RunnableC0013a implements Runnable {
            public final /* synthetic */ d a;

            public RunnableC0013a(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a r0 = this.a.a;     // Catch: Throwable -> L6
                if (r0.A == false) goto L9;
                r0.z.start();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            super.onAnimationEnd(r4);
            this.a.e.postDelayed(new RunnableC0013a(this), 1300);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            this.a.c.setVisibility(0);
            this.a.b.setVisibility(0);
        }
    }

    public static final class e extends BaseControllerListener<ImageInfo> {
        public e() {
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            super.onFinalImageSet(r2, (ImageInfo) r3, r4);
            if ((r4 instanceof AnimatedDrawable2) == false) goto L6;
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r4;
            r5.setAnimationListener(new com.bytedance.android.live.liveinteract.b(r5.getFrameCount(), r4));
            return;
        }
    }

    static {
    }

    public abstract void c();

    public final void d() {
        this.B = false;
        this.n.cancel();
        this.m.cancel();
        this.f.setAlpha(0.0f);
        this.e.setAlpha(1.0f);
        this.y.start();
        e r1 = new e();
        this.d.setVisibility(0);
        this.d.setController(Fresco.newDraweeControllerBuilder().setUri("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_fast_invite_tick.webp").setAutoPlayAnimations(true).setControllerListener(r1).build());
    }

    public void a() {
        this.w.addListener(new b(this));
        this.x.addListener(new c(this));
        this.y.addListener(new d(this));
    }

    public void b() {
        this.e.setAlpha(1.0f);
        this.a.setAlpha(1.0f);
        this.f.setAlpha(1.0f);
        this.b.setAlpha(0.0f);
        this.c.setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        this.g.setScaleX(1.0f);
        this.e.setVisibility(4);
        this.a.setVisibility(4);
        this.g.setVisibility(4);
        this.f.setVisibility(4);
        this.b.setVisibility(4);
        this.c.setVisibility(4);
        this.d.setVisibility(4);
        this.A = false;
        this.B = false;
    }

    public a(View r15) {
        Intrinsics.checkNotNullParameter(r15, "itemView");
        TextView r0 = (TextView) r15.findViewById(2131375617);
        this.a = r0;
        View r1 = r15.findViewById(2131386029);
        this.b = r1;
        TextView r2 = (TextView) r15.findViewById(2131374201);
        this.c = r2;
        SimpleDraweeView r3 = r15.findViewById(2131388632);
        this.d = r3;
        ImageView r4 = (ImageView) r15.findViewById(2131363623);
        this.e = r4;
        TextView r5 = (TextView) r15.findViewById(2131381484);
        this.f = r5;
        this.g = r15.findViewById(2131374105);
        Interpolator r16 = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        this.h = r16;
        ArrayList r6 = new ArrayList();
        this.i = r6;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{0.0f, 1.0f});
        r8.setDuration(400);
        r8.setInterpolator(r16);
        r6.add(r8);
        Unit r12 = Unit.INSTANCE;
        this.k = r8;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{0.0f, 1.0f});
        r9.setDuration(400);
        r9.setInterpolator(r16);
        r6.add(r9);
        this.l = r9;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{1.0f, 0.5f, 1.0f});
        r10.setDuration(1600);
        r10.setRepeatCount(4);
        r10.setInterpolator(r16);
        r6.add(r10);
        this.m = r10;
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.0f});
        r17.setDuration(300);
        r6.add(r17);
        this.n = r17;
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{0.0f, 1.0f});
        r18.setDuration(400);
        r6.add(r18);
        this.o = r18;
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{0.0f, 1.0f});
        r19.setDuration(400);
        r6.add(r19);
        this.p = r19;
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{1.0f, 0.0f});
        r110.setDuration(300);
        r6.add(r110);
        this.q = r110;
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.0f, 0.5f});
        r111.setDuration(400);
        r6.add(r111);
        this.r = r111;
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{1.0f, 0.0f});
        r112.setDuration(300);
        r6.add(r112);
        this.s = r112;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{1.0f, 0.0f});
        r113.setDuration(300);
        r6.add(r113);
        this.t = r113;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{1.0f, 0.0f});
        r114.setDuration(300);
        r6.add(r114);
        this.u = r114;
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.5f, 0.0f});
        r115.setDuration(300);
        r6.add(r115);
        this.v = r115;
        this.w = new AnimatorSet();
        this.x = new AnimatorSet();
        this.y = new AnimatorSet();
        this.z = new AnimatorSet();
    }
}
