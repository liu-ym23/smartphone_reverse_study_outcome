package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LandscapeQuickShotObserveWidget a;
    public final /* synthetic */ Ref.FloatRef b;
    public final /* synthetic */ Ref.FloatRef c;
    public final /* synthetic */ float d;
    public final /* synthetic */ Ref.IntRef e;
    public final /* synthetic */ Ref.IntRef f;
    public final /* synthetic */ Ref.IntRef g;
    public final /* synthetic */ Ref.IntRef h;
    public final /* synthetic */ Ref.IntRef i;
    public final /* synthetic */ Ref.FloatRef j;
    public final /* synthetic */ Ref.FloatRef k;
    public final /* synthetic */ Ref.IntRef l;
    public final /* synthetic */ Ref.IntRef m;
    public final /* synthetic */ int n;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        this.b.element = r6.getAnimatedFraction();
        Ref.FloatRef r7 = this.c;
        float r0 = 1;
        float r1 = r0 - this.d;
        Ref.FloatRef r2 = this.b;
        float r3 = r0 - (r1 * r2.element);
        r7.element = r3;
        this.e.element = (int) (this.f.element * r3);
        Ref.IntRef r8 = this.g;
        r8.element = (int) (this.h.element * r3);
        Ref.IntRef r4 = this.i;
        float r5 = this.j.element;
        float r9 = ((int) this.k.element) - r5;
        float r10 = r2.element;
        r4.element = (int) (r5 + (r9 * r10));
        Ref.IntRef r11 = this.l;
        int r12 = this.m.element;
        r11.element = (int) ((r12 + ((this.n - r12) * r10)) - r8.element);
        HSImageView r13 = this.a.c;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L5:
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L14;
        r14.width = this.e.element;
        r14.height = this.g.element;
        r13.setLayoutParams(r14);
        View r15 = ((Widget) this.a).contentView;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L12;
        r16.width = -2;
        r16.height = -2;
        r15.setLayoutParams(r16);
        r15.setX(this.i.element);
        r15.setY(this.l.element);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public o(LandscapeQuickShotObserveWidget r1, Ref.FloatRef r2, Ref.FloatRef r3, float r4, Ref.IntRef r5, Ref.IntRef r6, Ref.IntRef r7, Ref.IntRef r8, Ref.IntRef r9, Ref.FloatRef r10, Ref.FloatRef r11, Ref.IntRef r12, Ref.IntRef r13, int r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
