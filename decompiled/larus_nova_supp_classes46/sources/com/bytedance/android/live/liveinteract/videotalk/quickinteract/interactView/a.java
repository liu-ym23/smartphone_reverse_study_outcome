package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final View a;
    public final View b;
    public final View c;
    public final View d;
    public final n e;
    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f f;
    public AnimatorSet g;
    public AnimatorSet h;
    public AnimatorSet i;
    public int j;
    public QuickInteractTask k;
    public boolean l;
    public boolean m;
    public final float n;
    public final com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a o;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a$a, reason: collision with other inner class name */
    public static final class C0102a extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public C0102a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            Function0 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            Function0 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Function0 c;
        public final /* synthetic */ QuickInteractTask d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            Function0 r4 = this.c;
            if (r4 == null) goto L5;
            Unit r5 = (Unit) r4.invoke();
        L5:
            a r6 = this.a;
            r6.k = null;
            r6.h = null;
            AnimatorSet r7 = r6.i;
            if (r7 == null) goto L10;
            boolean r1 = true;
            if (r7.isStarted() != true) goto L10;
        L11:
            if (r1 == true) goto L16;
            this.a.j = 0;
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
            com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r8 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
            if (r8 == null) goto L17;
            r8.k7(this.d);
            return;
        L17:
            return;
        L16:
            return;
        L10:
            r1 = false;
            goto L11
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            Function0 r3 = this.b;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }

        public c(a r1, Function0 r2, Function0 r3, QuickInteractTask r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = r4.getAnimatedValue();
            if (r5 == null) goto L7;
            float r6 = ((Float) r5).floatValue();
            a r0 = this.a;
            r0.c.setAlpha((1 - r6) * r0.n);
            this.a.d.setAlpha(r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = r4.getAnimatedValue();
            if (r5 == null) goto L7;
            float r6 = ((Float) r5).floatValue();
            a r0 = this.a;
            r0.c.setAlpha((1 - r6) * r0.n);
            this.a.d.setAlpha(r6);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ String c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            a r4 = this.a;
            r4.g = null;
            AnimatorSet r5 = r4.i;
            if (r5 == null) goto L7;
            boolean r1 = true;
            if (r5.isStarted() != true) goto L7;
        L8:
            if (r1 == true) goto L10;
            this.a.j = 0;
        L10:
            this.b.invoke(this.c);
            return;
        L7:
            r1 = false;
            goto L8
        }

        public f(a r1, Function1 r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final void b() {
        AnimatorSet r0 = this.h;
        if (r0 != null) goto L5;
    L9:
        this.h = null;
        return;
    L5:
        if (r0.isStarted() != true) goto L9;
        AnimatorSet r1 = this.h;
        if (r1 == null) goto L9;
        r1.end();
        goto L9
    }

    public final void c() {
        AnimatorSet r0 = this.g;
        if (r0 != null) goto L5;
    L9:
        this.g = null;
        return;
    L5:
        if (r0.isStarted() != true) goto L9;
        AnimatorSet r1 = this.g;
        if (r1 == null) goto L9;
        r1.end();
        goto L9
    }

    public final void f() {
        c();
        b();
        n r0 = this.e;
        if (r0.a.getCurrentView().getId() != 2131375504) goto L5;
        r0.a.reset();
        r0.a.showNext();
    L5:
        View r1 = null;
        r0.e = null;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f r2 = this.f;
        r2.a.setCurrentText("0");
        View r3 = r2.a.getNextView();
        if ((r3 instanceof TextView) == false) goto L9;
        r1 = r3;
    L9:
        TextView r4 = (TextView) r1;
        if (r4 == null) goto L12;
        r4.setText("0");
    L12:
        r2.d = "0";
    }

    public a(View r2, com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a r3) {
        Intrinsics.checkNotNullParameter(r2, "parentContext");
        Intrinsics.checkNotNullParameter(r3, "animationCallback");
        this.o = r3;
        this.a = r2.findViewById(2131379435);
        this.b = r2.findViewById(2131372905);
        View r4 = r2.findViewById(2131375537);
        this.c = r4;
        this.d = r2.findViewById(2131375501);
        ImageView r0 = (ImageView) r2.findViewById(2131375513);
        this.e = new n(r2);
        this.f = new com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f(r2);
        this.n = r4.getAlpha();
    }

    public final Animator d(long r2, long r4) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.setStartDelay(r2);
        r0.setDuration(r4);
        r0.addUpdateListener(new d(this));
        return r0;
    }

    public final Animator e(long r2, long r4) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r0.setStartDelay(r2);
        r0.setDuration(r4);
        r0.addUpdateListener(new e(this));
        return r0;
    }

    public final void g(String r8, Function1<? super String, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "score");
        Intrinsics.checkNotNullParameter(r9, "onNormalScoreUpdated");
        if (this.j == 3) goto L12;
        AnimatorSet r0 = this.i;
        if (r0 == null) goto L9;
        if (r0.isRunning() == true) goto L12;
    L9:
        if (this.l == true) goto L12;
        boolean r1 = false;
    L13:
        if (r1 == false) goto L16;
        c();
        return;
    L16:
        c();
        this.j = 1;
        this.g = new AnimatorSet();
        if (this.m == false) goto L21;
        AnimatorSet r2 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a(this.f, r8, 0, 4);
        AnimatorSet r3 = this.g;
        if (r3 == null) goto L31;
        r3.play(r2);
    L31:
        AnimatorSet r4 = this.g;
        if (r4 == null) goto L34;
        r4.addListener(new f(this, r9, r8));
    L34:
        AnimatorSet r10 = this.g;
        if (r10 == null) goto L38;
        r10.start();
        return;
    L38:
        return;
    L21:
        Animator r5 = d(0, 200);
        AnimatorSet r6 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a(this.f, r8, 0, 6);
        AnimatorSet r7 = this.g;
        if (r7 == null) goto L26;
        AnimatorSet.Builder r11 = r7.play(r5);
        if (r11 == null) goto L26;
        r11.before(r6);
    L26:
        Animator r12 = e(500, 200);
        AnimatorSet r13 = this.g;
        if (r13 == null) goto L31;
        AnimatorSet.Builder r14 = r13.play(r6);
        if (r14 == null) goto L31;
        r14.before(r12);
    L12:
        r1 = true;
        goto L13
    }

    public final void a(QuickInteractTask r17, Function0<Unit> r18, Function0<Unit> r19, Function0<Unit> r20, Function0<Unit> r21) {
        Intrinsics.checkNotNullParameter(r17, "task");
        boolean r5 = false;
        if (this.j == 3) goto L12;
        AnimatorSet r3 = this.i;
        if (r3 == null) goto L9;
        if (r3.isRunning() == true) goto L12;
    L9:
        if (this.l == true) goto L12;
        boolean r4 = false;
    L13:
        if (r4 == false) goto L16;
        b();
        return;
    L16:
        b();
        this.j = 2;
        this.k = r17;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f r6 = this.f;
        String r7 = r17.b;
        if (this.m == false) goto L19;
        long r13 = 0;
    L20:
        AnimatorSet r8 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.f.a(r6, r7, r13, 4);
        AnimatorSet r9 = new AnimatorSet();
        this.h = r9;
        if (this.m == false) goto L23;
        r9.play(r8);
    L29:
        if (r17.c <= 0) goto L31;
        r5 = true;
    L31:
        if (r5 == false) goto L50;
        n r10 = this.e;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r17, "task");
        ImageUtil.loadRoundImage(r10.b, r17.e);
        r10.c.setText(r17.f);
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r11.setStartDelay(300);
        r11.setDuration(350);
        r11.addUpdateListener(new k(r10));
        r11.addListener(new l(r10, r17));
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{0, 1});
        r12.setDuration(350);
        r12.setStartDelay(300);
        r12.addListener(new m(r10, r17));
        AnimatorSet r14 = new AnimatorSet();
        r14.play(r11).with(r12);
        AnimatorSet r15 = this.h;
        if (r15 == null) goto L37;
        AnimatorSet.Builder r16 = r15.play(r8);
        if (r16 == null) goto L37;
        r16.before(r14);
    L37:
        r14.addListener(new C0102a(r20));
        long r22 = (r17.c * ((long) 1000)) - ((long) 350);
        n r23 = this.e;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r17, "task");
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r2.setStartDelay(r22);
        r2.setDuration(350);
        r2.addUpdateListener(new h(r23));
        r2.addListener(new i(r23));
        ValueAnimator r24 = ValueAnimator.ofInt(new int[]{0, 1});
        r24.setDuration(350);
        r24.setStartDelay(r22);
        r24.addListener(new j(r23));
        AnimatorSet r25 = new AnimatorSet();
        r25.play(r2).with(r24);
        AnimatorSet r26 = this.h;
        if (r26 == null) goto L42;
        AnimatorSet.Builder r27 = r26.play(r14);
        if (r27 == null) goto L42;
        r27.before(r25);
    L42:
        r25.addListener(new b(r21));
        if (this.m == true) goto L56;
        Animator r28 = e(r22, 350);
        AnimatorSet r29 = this.h;
        if (r29 == null) goto L56;
        AnimatorSet.Builder r30 = r29.play(r25);
        if (r30 == null) goto L56;
        r30.with(r28);
    L56:
        AnimatorSet r31 = this.h;
        if (r31 == null) goto L59;
        r31.addListener(new c(this, r18, r19, r17));
    L59:
        AnimatorSet r1 = this.h;
        if (r1 == null) goto L63;
        r1.start();
        return;
    L63:
        return;
    L50:
        if (this.m == true) goto L56;
        Animator r32 = e(500, 200);
        AnimatorSet r33 = this.h;
        if (r33 == null) goto L56;
        AnimatorSet.Builder r34 = r33.play(r8);
        if (r34 == null) goto L56;
        r34.before(r32);
        goto L56
    L23:
        Animator r35 = d(0, 200);
        AnimatorSet r36 = this.h;
        if (r36 == null) goto L29;
        AnimatorSet.Builder r37 = r36.play(r35);
        if (r37 == null) goto L29;
        r37.before(r8);
        goto L29
    L19:
        r13 = 300;
    L12:
        r4 = true;
        goto L13
    }
}
