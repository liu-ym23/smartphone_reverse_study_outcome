package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.h4;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u {
    public AudioGradientView a;
    public final AudioSpectrumView b;
    public final AudioGradientView c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;
    public final PathInterpolator l;
    public final PathInterpolator m;
    public final PathInterpolator n;
    public boolean o;
    public boolean p;
    public RealtimeCallLifeState q;
    public com.obric.assistant.view.continuespeech.a r;
    public Animator s;
    public final ArrayDeque<com.obric.assistant.view.continuespeech.a> t;
    public Function0<Unit> u;
    public final LinkedList<Float> v;
    public long w;

    public static final class a {
    }

    public static class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RealtimeCallLifeState.values().length];
            r0[RealtimeCallLifeState.SpeechStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[RealtimeCallLifeState.Thingking.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[RealtimeCallLifeState.QueryRejected.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[RealtimeCallLifeState.TTSEnd.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[RealtimeCallLifeState.FinishSession.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class d extends b {
        public boolean a;
        public final /* synthetic */ u b;

        public d(u r1) {
            this.b = r1;
        }

        @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.a = true;
        }

        @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            Intrinsics.checkNotNullParameter(r2, "p0");
            if (this.a == false) goto L6;
            this.a = false;
            return;
        L6:
            Function0<Unit> r3 = this.b.u;
            if (r3 == null) goto L10;
            r3.invoke();
            return;
        }

        @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.b.o = false;
        }
    }

    static {
    }

    public static void b(Animator r2) {
        r2.cancel();
        if ((r2 instanceof AnimatorSet) == false) goto L9;
        Iterator<T> r0 = ((AnimatorSet) r2).getChildAnimations().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        Animator r1 = (Animator) r0.next();
        Intrinsics.checkNotNull(r1);
        b(r1);
    L9:
        if ((r2 instanceof ValueAnimator) == false) goto L11;
        ((ValueAnimator) r2).removeAllUpdateListeners();
    L11:
        r2.removeAllListeners();
    }

    public final Pair<Animator, Boolean> d(boolean r12) {
        FLogger.a.i("AudioContinueAnimDelegate", "createTimeOutAnimation timeOut:" + r12);
        ArrayList r0 = new ArrayList();
        float r1 = 0.0f;
        float r2 = 1.0f;
        if (r12 == true) goto L5;
        float r3 = RangesKt.coerceIn(this.c.getGrayRatio(), 0.0f, 1.0f);
    L6:
        if (r12 == true) goto L8;
        long r4 = RangesKt.coerceAtLeast((long) (this.h * r3), 0);
    L12:
        if (r12 == false) goto L14;
        float r5 = 0.0f;
    L15:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{this.b.getPauseProgress(), r5});
        r6.setDuration(r4);
        if (r12 == false) goto L18;
        PathInterpolator r7 = this.m;
    L19:
        r6.setInterpolator(r7);
        r6.addUpdateListener(new com.obric.assistant.view.continuespeech.b(this));
        Intrinsics.checkNotNull(r6);
        r0.add(r6);
        if (r12 == false) goto L22;
        float r8 = 1.0f;
    L23:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{this.c.getGrayRatio(), r8});
        r9.setDuration(r4);
        if (r12 == false) goto L26;
        PathInterpolator r10 = this.m;
    L27:
        r9.setInterpolator(r10);
        r9.addUpdateListener(new l(this));
        Intrinsics.checkNotNull(r9);
        r0.add(r9);
        int r11 = com.obric.assistant.chat.p.a;
        AudioGradientView r13 = this.a;
        Float r14 = null;
        if (HomeService.a.o() == false) goto L39;
        if (r13 != null) goto L87;
        Fragment r15 = null;
    L51:
        if (r15 == null) goto L57;
        t1a.b r16 = s1a.a.g(r15);
        if (r16 == null) goto L57;
        laa.d r17 = r16.getAbility(laa.d.class);
        if (r17 == null) goto L57;
        Boolean r18 = Boolean.valueOf(r17.aF());
    L58:
        if (r18 == null) goto L72;
        boolean r19 = r18.booleanValue();
        if (r12 == false) goto L65;
        if (r19 == false) goto L63;
        r1 = 0.4f;
    L63:
        Float r20 = Float.valueOf(r1);
    L64:
        r14 = r20;
        goto L72
    L65:
        boolean r21 = v19.h.a;
        boolean r22 = v19.h.b(this.b.getContext());
        if (r19 == true) goto L71;
        if (r22 == false) goto L70;
        r2 = 0.6f;
        goto L71
    L70:
        r2 = 0.32f;
    L71:
        r20 = Float.valueOf(r2);
    L72:
        if (r14 == null) goto L82;
        float[] r23 = new float[2];
        AudioGradientView r24 = this.a;
        if (r24 == null) goto L76;
        float r25 = r24.getAlpha();
    L77:
        r23[0] = r25;
        r23[1] = r14.floatValue();
        ValueAnimator r26 = ValueAnimator.ofFloat(r23);
        r26.setDuration(r4);
        if (r12 == false) goto L80;
        PathInterpolator r27 = this.m;
    L81:
        r26.setInterpolator(r27);
        r26.addUpdateListener(new m(this));
        Intrinsics.checkNotNull(r26);
        r0.add(r26);
        goto L82
    L80:
        r27 = this.l;
        goto L81
    L76:
        r25 = r14.floatValue();
    L82:
        AnimatorSet r28 = new AnimatorSet();
        r28.playTogether(r0);
        if (r12 == false) goto L86;
        r28.setStartDelay(1000);
        r28.addListener(new d(this));
    L86:
        return new Pair(r28, Boolean.valueOf(r12));
    L57:
        r18 = null;
        goto L58
    L87:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L32
        Object r30 = Result.constructor-impl(CompatKt.findFragment(r13));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r30) == false) goto L37;
        r30 = null;
    L37:
        r15 = (Fragment) r30;
    L32:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L39:
        if (r13 == null) goto L57;
        Context r32 = r13.getContext();
        if (r32 == null) goto L57;
        FragmentActivity r33 = com.larus.utils.i.a(r32);
        if (r33 == null) goto L57;
        if ((r33 instanceof h4) == true) goto L48;
        r33 = null;
    L48:
        if (r33 == null) goto L57;
        r15 = r33.getSupportFragmentManager().findFragmentById(2131373275);
        goto L51
    L26:
        r10 = this.l;
        goto L27
    L22:
        r8 = 0.0f;
        goto L23
    L18:
        r7 = this.l;
        goto L19
    L14:
        r5 = 1.0f;
        goto L15
    L8:
        if (this.o == false) goto L10;
        r4 = 8000;
        goto L12
    L10:
        r4 = 5000;
        goto L12
    L5:
        r3 = 1.0f;
        goto L6
    }

    public final void f(RealtimeCallLifeState r4) {
        if (this.t.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayDeque r0 = new ArrayDeque();
    L7:
        if ((!this.t.isEmpty()) == false) goto L12;
        com.obric.assistant.view.continuespeech.a r1 = (com.obric.assistant.view.continuespeech.a) this.t.removeFirst();
        if (r1.c == r4) goto L7;
        r0.addLast(r1);
    L12:
        if ((!r0.isEmpty()) == false) goto L14;
        this.t.addLast(r0.removeFirst());
        goto L12
    }

    public u(AudioSpectrumView r4, AudioGradientView r5) {
        Intrinsics.checkNotNullParameter(r4, "audioSpectrumView");
        Intrinsics.checkNotNullParameter(r5, "voiceGradientView");
        this.a = null;
        this.b = r4;
        this.c = r5;
        this.d = 50;
        this.e = 150;
        this.f = 200;
        this.g = 250;
        this.h = 300;
        this.i = 350;
        this.j = 700;
        this.k = 1000;
        this.l = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.m = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        this.n = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
        this.o = true;
        this.t = new ArrayDeque();
        this.v = new LinkedList();
    }

    public final Pair<Animator, Boolean> c(boolean r9, float r10) {
        FLogger.a.i("AudioContinueAnimDelegate", "createInputAnimation show:" + r9 + " curSpeakIntensity:" + this.b.getSpeakIntensity() + " speakIntensityEndValue:" + r10);
        ArrayList r0 = new ArrayList();
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{this.b.getSpeakIntensity(), r10});
        r11.setDuration(this.h);
        r11.setInterpolator(this.l);
        r11.addUpdateListener(new n(this));
        Intrinsics.checkNotNull(r11);
        r0.add(r11);
        float r12 = 0.0f;
        if (r9 == false) goto L5;
        float r5 = 0.0f;
    L6:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{this.b.getPauseIntensity(), r5});
        r6.setDuration(this.h);
        r6.setInterpolator(this.l);
        r6.addUpdateListener(new o(this));
        Intrinsics.checkNotNull(r6);
        r0.add(r6);
        if (r9 == true) goto L10;
        r12 = 1.0f;
    L10:
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{this.b.getPauseProgress(), r12});
        r13.setDuration(this.h);
        r13.setInterpolator(this.l);
        r13.addUpdateListener(new p(this));
        Intrinsics.checkNotNull(r13);
        r0.add(r13);
        AnimatorSet r14 = new AnimatorSet();
        r14.playTogether(r0);
        return new Pair(r14, Boolean.valueOf(r9));
    L5:
        r5 = 1.0f;
        goto L6
    }

    public final void g(float r4, boolean r5) {
        if (this.q == RealtimeCallLifeState.SpeechStarted) goto L5;
        if (r5 == true) goto L5;
        return;
    L5:
        this.v.offer(Float.valueOf(r4));
        if (Math.abs(System.currentTimeMillis() - this.w) < 400) goto L14;
        Float r6 = CollectionsKt.maxOrNull(this.v);
        if (r6 == null) goto L10;
        float r7 = r6.floatValue();
    L11:
        this.v.clear();
        Pair<Animator, Boolean> r8 = c(true, r7);
        e((Animator) r8.getFirst(), ((Boolean) r8.getSecond()).booleanValue(), null, null);
        this.w = System.currentTimeMillis();
        return;
    L10:
        r7 = 0.0f;
        goto L11
    }

    public static final void a(u r2, Animator r3, boolean r4) {
        if (Intrinsics.areEqual(r3, r2.s) == false) goto L27;
        com.obric.assistant.view.continuespeech.a r5 = r2.r;
        com.obric.assistant.view.continuespeech.a r0 = null;
        r2.s = null;
        r2.r = null;
        if (r4 == true) goto L12;
        if (r5 == null) goto L12;
        Function0<Unit> r6 = r5.d;
        if (r6 == null) goto L12;
        r6.invoke();
    L12:
        if ((!r2.t.isEmpty()) == false) goto L18;
        com.obric.assistant.view.continuespeech.a r7 = (com.obric.assistant.view.continuespeech.a) r2.t.removeFirst();
        RealtimeCallLifeState r8 = r7.c;
        if (r8 == null) goto L17;
        if (r8 != r2.q) goto L12;
    L17:
        r0 = r7;
    L18:
        if (r0 == null) goto L26;
        r2.r = r0;
        Animator r9 = r0.a;
        r9.addListener(new z(r2));
        r9.start();
        r2.s = r9;
        return;
    L26:
        return;
    }

    public final void e(Animator r2, boolean r3, RealtimeCallLifeState r4, Function0<Unit> r5) {
        com.obric.assistant.view.continuespeech.a r0 = new com.obric.assistant.view.continuespeech.a(r2, r3, r4, r5);
        com.obric.assistant.view.continuespeech.a r6 = this.r;
        Animator r7 = this.s;
        if (r6 == null) goto L10;
        if (r7 == null) goto L10;
        this.t.addLast(r0);
        if (r6.b == false) goto L12;
        r7.cancel();
        return;
    L12:
        return;
    L10:
        this.r = r0;
        Animator r8 = r0.a;
        r8.addListener(new z(this));
        r8.start();
        this.s = r8;
    }
}
