package com.facebook.drawee.generic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Looper;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorDrawable f7907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f7908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f7909c;
    public RoundingParams d;
    public final RootDrawable e;
    public final FadeDrawable f;
    public final ForwardingDrawable g;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder r10) {
        ColorDrawable r5 = new ColorDrawable(0);
        this.f7907a = r5;
        FrescoSystrace.a().getClass();
        this.f7908b = r10.f7915a;
        this.f7909c = r10.f7916b;
        this.d = r10.f7926p;
        ForwardingDrawable r11 = new ForwardingDrawable(r5);
        this.g = r11;
        List r12 = r10.f7924n;
        if (r12 == null) goto L5;
        int r13 = r12.size();
    L6:
        if (r13 != 0) goto L9;
        r13 = 1;
    L9:
        if (r10.f7925o == null) goto L11;
        int r14 = 1;
    L12:
        int r15 = r13 + r14;
        Drawable[] r16 = new Drawable[r15 + 6];
        r16[0] = a(r10.f7923m, null);
        r16[1] = a(r10.d, r10.e);
        ScalingUtils.ScaleType r17 = r10.f7922l;
        r11.setColorFilter(null);
        r16[2] = WrappingUtils.a(r11, r17);
        r16[3] = a(r10.f7920j, r10.f7921k);
        r16[4] = a(r10.f, r10.g);
        r16[5] = a(r10.f7918h, r10.f7919i);
        if (r15 <= 0) goto L24;
        List r18 = r10.f7924n;
        if (r18 == null) goto L20;
        Iterator r19 = r18.iterator();
        int r20 = 0;
    L18:
        if (r19.hasNext() == false) goto L21;
        r16[r20 + 6] = a((Drawable) r19.next(), null);
        r20 = r20 + 1;
    L21:
        StateListDrawable r21 = r10.f7925o;
        if (r21 == null) goto L24;
        r16[r20 + 6] = a(r21, null);
        goto L24
    L20:
        r20 = 1;
    L24:
        FadeDrawable r22 = new FadeDrawable(r16);
        this.f = r22;
        r22.f7840k = GenericDraweeHierarchyBuilder.s;
        if (r22.f7839j != 1) goto L27;
        r22.f7839j = 0;
    L27:
        RootDrawable r23 = new RootDrawable(WrappingUtils.a(r22, this.d));
        this.e = r23;
        r23.mutate();
        r22.f7846q++;
        r22.b();
        a();
        r22.c(1);
        r22.c();
        r22.a();
        FrescoSystrace.a().getClass();
        return;
    L11:
        r14 = 0;
        goto L12
    L5:
        r13 = 1;
        goto L6
    }

    public final Drawable a(Drawable r5, ScalingUtils.AbstractScaleType r10) {
        Context r11 = this.f7909c;
        if (r11 != null) goto L5;
        Drawable r12 = WrappingUtils.b(r5, this.d, this.f7908b);
    L7:
        return WrappingUtils.a(r12, r10);
    L5:
        r12 = WrappingUtils.b(r5, this.d, r11.getResources());
        goto L7
    }

    public final void b() {
        this.g.b(this.f7907a);
        FadeDrawable r5 = this.f;
        if (r5 == null) goto L6;
        r5.f7846q++;
        r5.b();
        a();
        this.f.c(1);
        this.f.c();
        this.f.a();
        return;
    }

    public final void a() {
        this.f.d(1);
        this.f.d(2);
        this.f.d(3);
        this.f.d(4);
        this.f.d(5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(float r5) {
        Drawable r10 = this.f.a(3);
        if (r10 != 0) goto L6;
        return;
    L6:
        if (r5 < 0.999f) goto L12;
        if ((r10 instanceof Animatable) == false) goto L10;
        ((Animatable) r10).stop();
    L10:
        this.f.d(3);
    L15:
        r10.setLevel(Math.round(r5 * 10000.0f));
        return;
    L12:
        if ((r10 instanceof Animatable) == false) goto L14;
        ((Animatable) r10).start();
    L14:
        this.f.c(3);
        goto L15
    }

    public final ScaleTypeDrawable b(int r5) {
        DrawableParent r10 = a(r5);
        if ((r10 instanceof ScaleTypeDrawable) == true) goto L5;
        ScalingUtils.ScaleType r11 = ScalingUtils.ScaleType.f7893a;
        Drawable r12 = WrappingUtils.a(r10.a(WrappingUtils.f7933a), r11);
        r10.a(r12);
        Preconditions.a(r12, "Parent has no child drawable!");
        return (ScaleTypeDrawable) r12;
    L5:
        return (ScaleTypeDrawable) r10;
    }

    public final void a(Drawable r5, float r10, boolean r11) {
        Context r12 = this.f7909c;
        if (r12 != null) goto L5;
        Drawable r13 = WrappingUtils.b(r5, this.d, this.f7908b);
    L6:
        r13.mutate();
        this.g.b(r13);
        this.f.f7846q++;
        a();
        this.f.c(2);
        a(r10);
        if (r11 == false) goto L9;
        this.f.c();
    L9:
        this.f.a();
        return;
    L5:
        r13 = WrappingUtils.b(r5, this.d, r12.getResources());
        goto L6
    }

    public final void a(float r5, boolean r10) {
        if (this.f.a(3) != null) goto L5;
        return;
    L5:
        this.f.f7846q++;
        a(r5);
        if (r10 == false) goto L8;
        this.f.c();
    L8:
        this.f.a();
    }

    public final DrawableParent a(int r5) {
        DrawableParent r10 = this.f.b(r5);
        r10.c();
        if ((r10.c() instanceof ScaleTypeDrawable) == true) goto L5;
        return r10;
    L5:
        return (ScaleTypeDrawable) r10.c();
    }

    public final void a(int r5, Drawable r10) {
        if (r10 != null) goto L5;
        this.f.a(r5, null);
        return;
    L5:
        Context r11 = this.f7909c;
        if (r11 != null) goto L8;
        Drawable r12 = WrappingUtils.b(r10, this.d, this.f7908b);
    L9:
        a(r5).a(r12);
        return;
    L8:
        r12 = WrappingUtils.b(r10, this.d, r11.getResources());
        goto L9
    }

    public final void a(final Drawable r5, final ScalingUtils.ScaleType r10) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L8;
        Context r11 = this.f7909c;
        if ((r11 instanceof Activity) == false) goto L10;
        ((Activity) r11).runOnUiThread(new AnonymousClass1(this, r5, r10));
        return;
    L10:
        return;
    L8:
        a(1, r5);
        ScaleTypeDrawable r12 = b(1);
        if (Objects.a(r12.d, r10) == true) goto L13;
        r12.d = r10;
        r12.e();
        r12.invalidateSelf();
        return;
    }

    public final void a(RoundingParams r5) {
        this.d = r5;
        RootDrawable r10 = this.e;
        ColorDrawable r11 = WrappingUtils.f7933a;
        Drawable r12 = r10.f7847a;
        if (r5 == null) goto L11;
        if (r5.f7927a != RoundingParams.RoundingMethod.f7930a) goto L11;
        if ((r12 instanceof RoundedCornersDrawable) == false) goto L9;
        RoundedCornersDrawable r13 = (RoundedCornersDrawable) r12;
        WrappingUtils.a(r13, r5);
        r13.f7866l = r5.d;
        r13.invalidateSelf();
    L13:
        int r14 = 0;
    L15:
        if (r14 >= this.f.f7831c.length) goto L21;
        if (this.f7909c != null) goto L19;
        WrappingUtils.a(a(r14), this.d, this.f7908b);
    L20:
        r14 = r14 + 1;
        goto L15
    L19:
        WrappingUtils.a(a(r14), this.d, this.f7909c.getResources());
        goto L20
    L21:
        return;
    L9:
        r10.b(WrappingUtils.a(r10.b(WrappingUtils.f7933a), r5));
    L11:
        if ((r12 instanceof RoundedCornersDrawable) == false) goto L13;
        ColorDrawable r15 = WrappingUtils.f7933a;
        r10.b(((RoundedCornersDrawable) r12).b(r15));
        r15.setCallback(null);
        goto L13
    }
}
