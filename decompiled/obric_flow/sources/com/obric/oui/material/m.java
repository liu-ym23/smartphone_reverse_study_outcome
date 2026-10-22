package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable.ConstantState f13668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13670c;
    public final ColorStateList d;
    public final int e;
    public final ColorStateList f;
    public final long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f13671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c[] f13672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final es.a[] f13675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f13676m;

    public m(Drawable.ConstantState r5, int r10, boolean r11, ColorStateList r12, int r13, ColorStateList r14, long r15, boolean r16, c[] r17, int r18, int r19, es.a[] r110, int r111) {
        this.f13668a = r5;
        this.f13669b = r10;
        this.f13670c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f13671h = r16;
        this.f13672i = r17;
        this.f13673j = r18;
        this.f13674k = r19;
        this.f13675l = r110;
        this.f13676m = r111;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f13669b;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return newDrawable(null, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources r5) {
        return newDrawable(r5, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources r5, Resources.Theme r10) {
        GradientDrawable r11 = null;
        Drawable.ConstantState r12 = this.f13668a;     // Catch: Exception -> L21
        if (r12 == null) goto L12;
        if (r10 == null) goto L8;
        Drawable r13 = r12.newDrawable(r5, r10);     // Catch: Exception -> L21
    L13:
        OMaterialDrawable r14 = new OMaterialDrawable();
        if ((r13 instanceof GradientDrawable) == false) goto L16;
        r11 = (GradientDrawable) r13;
    L16:
        if (r11 == null) goto L19;
        OMaterialDrawable.access$copyGradientInternalStateFrom(r14, r11);
    L19:
        OMaterialDrawable.access$setEnableShadow$p(r14, this.f13670c);
        r14.setAnimDuration(this.g);
        r14.setEnableStateChangeTransition(this.f13671h);
        r14.setMaterialConfigs(this.f13672i, this.f13673j, this.f13674k, false);
        r14.setShadowConfigs(this.f13675l);
        r14.setSolidColors(this.d);
        r14.setStrokeConfigs(this.e, this.f);
        Boolean r15 = Boolean.FALSE;
        r14.setCallbackInitArray(new Boolean[]{r15, r15});
        r14.setRequireApiVersion(this.f13676m);
        return r14;
    L8:
        if (r5 == null) goto L10;
        r13 = r12.newDrawable(r5);     // Catch: Exception -> L21
        goto L13
    L10:
        r13 = r12.newDrawable();     // Catch: Exception -> L21
    L12:
        r13 = null;
        goto L13
    }
}
