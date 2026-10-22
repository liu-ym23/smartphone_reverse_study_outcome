package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LandscapeQuickShotLayerWidget a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ Ref.FloatRef c;
    public final /* synthetic */ Ref.FloatRef d;
    public final /* synthetic */ float e;
    public final /* synthetic */ Ref.IntRef f;
    public final /* synthetic */ Ref.IntRef g;
    public final /* synthetic */ Ref.IntRef h;
    public final /* synthetic */ Ref.IntRef i;
    public final /* synthetic */ Ref.IntRef j;
    public final /* synthetic */ Ref.FloatRef k;
    public final /* synthetic */ float l;
    public final /* synthetic */ Ref.IntRef m;
    public final /* synthetic */ Ref.IntRef n;
    public final /* synthetic */ int o;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "animation");
        if ((!Intrinsics.areEqual(this.b, this.a.e)) == false) goto L5;
        return;
    L5:
        this.c.element = r6.getAnimatedFraction();
        Ref.FloatRef r7 = this.d;
        float r0 = 1;
        float r1 = r0 - this.e;
        Ref.FloatRef r2 = this.c;
        float r3 = r0 - (r1 * r2.element);
        r7.element = r3;
        this.f.element = (int) (this.g.element * r3);
        Ref.IntRef r8 = this.h;
        r8.element = (int) (this.i.element * r3);
        Ref.IntRef r4 = this.j;
        float r5 = this.k.element;
        float r9 = ((int) this.l) - r5;
        float r10 = r2.element;
        r4.element = (int) (r5 + (r9 * r10));
        Ref.IntRef r11 = this.m;
        int r12 = this.n.element;
        r11.element = (int) ((r12 + ((this.o - r12) * r10)) - r8.element);
        ImageView r13 = this.a.b;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dialogContainerImageView");
    L8:
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L17;
        r14.width = this.f.element;
        r14.height = this.h.element;
        r13.setLayoutParams(r14);
        View r15 = ((Widget) this.a).contentView;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L15;
        r16.width = -2;
        r16.height = -2;
        r15.setLayoutParams(r16);
        r15.setX(this.j.element);
        r15.setY(this.m.element);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public j(LandscapeQuickShotLayerWidget r1, Bitmap r2, Ref.FloatRef r3, Ref.FloatRef r4, float r5, Ref.IntRef r6, Ref.IntRef r7, Ref.IntRef r8, Ref.IntRef r9, Ref.IntRef r10, Ref.FloatRef r11, float r12, Ref.IntRef r13, Ref.IntRef r14, int r15) {
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
        this.o = r15;
    }
}
