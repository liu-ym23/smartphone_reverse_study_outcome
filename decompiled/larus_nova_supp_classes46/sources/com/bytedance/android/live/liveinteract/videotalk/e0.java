package com.bytedance.android.live.liveinteract.videotalk;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 extends com.bytedance.android.live.liveinteract.a {
    public final TextView C;
    public final ImageView D;
    public final TextView E;
    public final ObjectAnimator F;
    public final ObjectAnimator G;
    public final ObjectAnimator H;
    public final ObjectAnimator I;
    public final ObjectAnimator J;
    public final ObjectAnimator K;
    public final ObjectAnimator L;
    public final ObjectAnimator M;
    public final ObjectAnimator N;
    public final ObjectAnimator O;
    public final ObjectAnimator P;
    public final ObjectAnimator Q;
    public final ObjectAnimator R;
    public ObjectAnimator S;
    public ObjectAnimator T;

    @Override // com.bytedance.android.live.liveinteract.a
    public final void b() {
        this.e.setScaleX(0.5f);
        this.e.setScaleY(0.5f);
        this.g.setAlpha(0.0f);
        this.E.setAlpha(1.0f);
        this.C.setAlpha(1.0f);
        this.D.setAlpha(1.0f);
        super.b();
    }

    @Override // com.bytedance.android.live.liveinteract.a
    public final void c() {
        if (this.j == true) goto L5;
        this.w.playTogether(new Animator[]{this.F, this.G, this.k, this.H, this.l, this.I, this.J, this.K, this.L, this.M});
        this.x.playTogether(new Animator[]{this.n, this.o, this.N, this.O});
        this.y.playTogether(new Animator[]{this.p, this.q, this.P, this.Q, this.r});
        this.z.playTogether(new Animator[]{this.s, this.v, this.u, this.t, this.R});
        super.a();
        this.z.addListener(new d0(this));
        this.j = true;
    L5:
        this.A = true;
        this.w.start();
    }

    public e0(View r14) {
        Intrinsics.checkNotNullParameter(r14, "itemView");
        super(r14);
        TextView r0 = (TextView) r14.findViewById(2131389540);
        this.C = r0;
        ImageView r1 = (ImageView) r14.findViewById(2131389534);
        this.D = r1;
        TextView r15 = (TextView) r14.findViewById(2131389541);
        this.E = r15;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.e, "scaleX", new float[]{0.5f, 1.0f});
        r2.setDuration(400);
        r2.setInterpolator(this.h);
        ((ArrayList) this.i).add(r2);
        Unit r4 = Unit.INSTANCE;
        this.F = r2;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.e, "scaleY", new float[]{0.5f, 1.0f});
        r3.setDuration(400);
        r3.setInterpolator(this.h);
        ((ArrayList) this.i).add(r3);
        this.G = r3;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.f, "translationY", new float[]{s1.f(10.0f), 0.0f});
        r5.setDuration(400);
        r5.setInterpolator(this.h);
        ((ArrayList) this.i).add(r5);
        this.H = r5;
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.g, "translationY", new float[]{s1.f(10.0f), 0.0f});
        r6.setDuration(400);
        r6.setInterpolator(this.h);
        ((ArrayList) this.i).add(r6);
        this.I = r6;
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{0.0f, 0.15f});
        r7.setDuration(400);
        r7.setInterpolator(this.h);
        ((ArrayList) this.i).add(r7);
        this.J = r7;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{1.0f, 0.0f});
        r8.setDuration(300);
        ((ArrayList) this.i).add(r8);
        this.K = r8;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{1.0f, 0.0f});
        r9.setDuration(300);
        ((ArrayList) this.i).add(r9);
        this.L = r9;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r15, "alpha", new float[]{1.0f, 0.0f});
        r10.setDuration(300);
        ((ArrayList) this.i).add(r10);
        this.M = r10;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.g, "scaleX", new float[]{1.0f, 0.83f});
        r11.setDuration(400);
        ((ArrayList) this.i).add(r11);
        this.N = r11;
        ObjectAnimator r12 = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{0.15f, 1.0f});
        r12.setDuration(400);
        ((ArrayList) this.i).add(r12);
        this.O = r12;
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.g, "scaleX", new float[]{0.83f, 0.97f});
        r13.setDuration(400);
        ((ArrayList) this.i).add(r13);
        this.P = r13;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.g, "alpha", new float[]{1.0f, 0.15f});
        r16.setDuration(400);
        ((ArrayList) this.i).add(r16);
        this.Q = r16;
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r15, "alpha", new float[]{0.0f, 1.0f});
        r17.setDuration(300);
        ((ArrayList) this.i).add(r17);
        this.R = r17;
    }
}
