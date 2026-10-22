package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import r5.h;

/* JADX INFO: loaded from: classes.dex */
abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final ExtendedFloatingActionButton f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f3258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f3259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private h f3260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private h f3261f;

    class a extends Property<ExtendedFloatingActionButton, Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f3262a;

        a(b r10, Class r11, String r12) {
            this.f3262a = r10;
            super(r11, r12);
        }

        public Float a(ExtendedFloatingActionButton r10) {
            return Float.valueOf(r5.a.a(0.0f, 1.0f, (Color.alpha(r10.getCurrentTextColor()) / 255.0f) / Color.alpha(r10.originalTextCsl.getColorForState(r10.getDrawableState(), b.m(this.f3262a).originalTextCsl.getDefaultColor()))));
        }

        public void b(ExtendedFloatingActionButton r10, Float r11) {
            int r12 = r10.originalTextCsl.getColorForState(r10.getDrawableState(), b.m(this.f3262a).originalTextCsl.getDefaultColor());
            ColorStateList r13 = ColorStateList.valueOf(Color.argb((int) (r5.a.a(0.0f, Color.alpha(r12) / 255.0f, r11.floatValue()) * 255.0f), Color.red(r12), Color.green(r12), Color.blue(r12)));
            if (r11.floatValue() != 1.0f) goto L5;
            r13 = r10.originalTextCsl;
        L5:
            r10.silentlyUpdateTextColor(r13);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(ExtendedFloatingActionButton r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(ExtendedFloatingActionButton r10, Float r11) {
            b(r10, r11);
        }
    }

    b(@NonNull ExtendedFloatingActionButton r10, com.google.android.material.floatingactionbutton.a r11) {
        this.f3258c = new ArrayList();
        this.f3257b = r10;
        this.f3256a = r10.getContext();
        this.f3259d = r11;
    }

    static /* synthetic */ ExtendedFloatingActionButton m(b r10) {
        return r10.f3257b;
    }

    @Override // com.google.android.material.floatingactionbutton.e
    @CallSuper
    public void a() {
        this.f3259d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.e
    @Nullable
    public h d() {
        return this.f3261f;
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public final void f(@NonNull Animator.AnimatorListener r10) {
        this.f3258c.remove(r10);
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public final void g(@NonNull Animator.AnimatorListener r10) {
        this.f3258c.add(r10);
    }

    @Override // com.google.android.material.floatingactionbutton.e
    @CallSuper
    public void h() {
        this.f3259d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public final void i(@Nullable h r10) {
        this.f3261f = r10;
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public AnimatorSet j() {
        return n(o());
    }

    @Override // com.google.android.material.floatingactionbutton.e
    @NonNull
    public final List<Animator.AnimatorListener> k() {
        return this.f3258c;
    }

    @NonNull
    AnimatorSet n(@NonNull h r10) {
        ArrayList r11 = new ArrayList();
        if (r10.j("opacity") == false) goto L6;
        r11.add(r10.f("opacity", this.f3257b, View.ALPHA));
    L6:
        if (r10.j("scale") == false) goto L9;
        r11.add(r10.f("scale", this.f3257b, View.SCALE_Y));
        r11.add(r10.f("scale", this.f3257b, View.SCALE_X));
    L9:
        if (r10.j("width") == false) goto L12;
        r11.add(r10.f("width", this.f3257b, ExtendedFloatingActionButton.WIDTH));
    L12:
        if (r10.j("height") == false) goto L15;
        r11.add(r10.f("height", this.f3257b, ExtendedFloatingActionButton.HEIGHT));
    L15:
        if (r10.j("paddingStart") == false) goto L18;
        r11.add(r10.f("paddingStart", this.f3257b, ExtendedFloatingActionButton.PADDING_START));
    L18:
        if (r10.j("paddingEnd") == false) goto L21;
        r11.add(r10.f("paddingEnd", this.f3257b, ExtendedFloatingActionButton.PADDING_END));
    L21:
        if (r10.j("labelOpacity") == false) goto L23;
        r11.add(r10.f("labelOpacity", this.f3257b, new a(this, Float.class, "LABEL_OPACITY_PROPERTY")));
    L23:
        AnimatorSet r12 = new AnimatorSet();
        r5.b.a(r12, r11);
        return r12;
    }

    public final h o() {
        h r10 = this.f3261f;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.f3260e != null) goto L9;
        this.f3260e = h.d(this.f3256a, b());
    L9:
        return (h) Preconditions.checkNotNull(this.f3260e);
    }

    @Override // com.google.android.material.floatingactionbutton.e
    @CallSuper
    public void onAnimationStart(Animator r10) {
        this.f3259d.c(r10);
    }
}
