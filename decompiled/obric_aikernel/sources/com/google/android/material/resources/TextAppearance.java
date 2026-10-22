package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final ColorStateList f3575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f3576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f3579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f3580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f3581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f3583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private ColorStateList f3584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f3585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @FontRes
    private final int f3586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Typeface f3588n;

    class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f3590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f3591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextAppearance f3592d;

        a(TextAppearance r10, Context r11, TextPaint r12, e r13) {
            this.f3592d = r10;
            this.f3589a = r11;
            this.f3590b = r12;
            this.f3591c = r13;
        }

        @Override // com.google.android.material.resources.e
        public void a(int r10) {
            this.f3591c.a(r10);
        }

        @Override // com.google.android.material.resources.e
        public void b(@NonNull Typeface r10, boolean r11) {
            this.f3592d.p(this.f3589a, this.f3590b, r10);
            this.f3591c.b(r10, r11);
        }
    }

    public TextAppearance(@NonNull Context r10, @StyleRes int r11) {
        this.f3587m = false;
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.TextAppearance);
        l(r12.getDimension(l.TextAppearance_android_textSize, 0.0f));
        k(c.a(r10, r12, l.TextAppearance_android_textColor));
        c.a(r10, r12, l.TextAppearance_android_textColorHint);
        c.a(r10, r12, l.TextAppearance_android_textColorLink);
        this.f3577c = r12.getInt(l.TextAppearance_android_textStyle, 0);
        this.f3578d = r12.getInt(l.TextAppearance_android_typeface, 1);
        int r13 = c.f(r12, l.TextAppearance_fontFamily, l.TextAppearance_android_fontFamily);
        this.f3586l = r12.getResourceId(r13, 0);
        this.f3576b = r12.getString(r13);
        r12.getBoolean(l.TextAppearance_textAllCaps, false);
        this.f3575a = c.a(r10, r12, l.TextAppearance_android_shadowColor);
        this.f3579e = r12.getFloat(l.TextAppearance_android_shadowDx, 0.0f);
        this.f3580f = r12.getFloat(l.TextAppearance_android_shadowDy, 0.0f);
        this.f3581g = r12.getFloat(l.TextAppearance_android_shadowRadius, 0.0f);
        r12.recycle();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        TypedArray r14 = r10.obtainStyledAttributes(r11, l.MaterialTextAppearance);
        int r15 = l.MaterialTextAppearance_android_letterSpacing;
        this.f3582h = r14.hasValue(r15);
        this.f3583i = r14.getFloat(r15, 0.0f);
        r14.recycle();
        return;
    L5:
        this.f3582h = false;
        this.f3583i = 0.0f;
    }

    static /* synthetic */ Typeface a(TextAppearance r10) {
        return r10.f3588n;
    }

    static /* synthetic */ Typeface b(TextAppearance r10, Typeface r11) {
        r10.f3588n = r11;
        return r11;
    }

    static /* synthetic */ boolean c(TextAppearance r10, boolean r11) {
        r10.f3587m = r11;
        return r11;
    }

    private void d() {
        if (this.f3588n != null) goto L8;
        String r10 = this.f3576b;
        if (r10 == null) goto L8;
        this.f3588n = Typeface.create(r10, this.f3577c);
    L8:
        if (this.f3588n != null) goto L21;
        int r11 = this.f3578d;
        if (r11 != 1) goto L12;
        Typeface r12 = Typeface.SANS_SERIF;
    L19:
        this.f3588n = r12;
        this.f3588n = Typeface.create(this.f3588n, this.f3577c);
        return;
    L12:
        if (r11 != 2) goto L14;
        r12 = Typeface.SERIF;
        goto L19
    L14:
        if (r11 == 3) goto L16;
        r12 = Typeface.DEFAULT;
        goto L19
    L16:
        r12 = Typeface.MONOSPACE;
        goto L19
    }

    private boolean m(Context r10) {
        if (d.a() == false) goto L5;
        return true;
    L5:
        int r11 = this.f3586l;
        if (r11 == 0) goto L8;
        Typeface r12 = ResourcesCompat.getCachedFont(r10, r11);
    L9:
        if (r12 != null) goto L13;
        return false;
    L13:
        return true;
    L8:
        r12 = null;
        goto L9
    }

    public Typeface e() {
        d();
        return this.f3588n;
    }

    @NonNull
    @VisibleForTesting
    public Typeface f(@NonNull Context r10) {
        if (this.f3587m == false) goto L7;
        return this.f3588n;
    L7:
        if (r10.isRestricted() == false) goto L17;
    L14:
        d();
        this.f3587m = true;
        return this.f3588n;
    L17:
        Typeface r11 = ResourcesCompat.getFont(r10, this.f3586l);     // Catch: Exception -> L12 Throwable -> L16
        this.f3588n = r11;     // Catch: Exception -> L12 Throwable -> L16
        if (r11 == null) goto L14;
        this.f3588n = Typeface.create(r11, this.f3577c);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Log.d("TextAppearance", "Error loading font " + this.f3576b, e);
        goto L14
    }

    public void g(@NonNull Context r10, @NonNull TextPaint r11, @NonNull e r12) {
        p(r10, r11, e());
        h(r10, new a(this, r10, r11, r12));
    }

    public void h(@NonNull Context r10, @NonNull final e r11) {
        if (m(r10) == false) goto L5;
        f(r10);
    L6:
        int r12 = this.f3586l;
        if (r12 != 0) goto L10;
        this.f3587m = true;
    L10:
        if (this.f3587m == false) goto L19;
        r11.b(this.f3588n, true);
        return;
    L19:
        ResourcesCompat.getFont(r10, r12, new AnonymousClass1(this, r11), null);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L22:
        return;
    L17:
        this.f3587m = true;
        r11.a(1);
        return;
    L15:
        e = move-exception;
        Log.d("TextAppearance", "Error loading font " + this.f3576b, e);
        this.f3587m = true;
        r11.a(-3);
        return;
    L5:
        d();
        goto L6
    }

    @Nullable
    public ColorStateList i() {
        return this.f3584j;
    }

    public float j() {
        return this.f3585k;
    }

    public void k(@Nullable ColorStateList r10) {
        this.f3584j = r10;
    }

    public void l(float r10) {
        this.f3585k = r10;
    }

    public void n(@NonNull Context r10, @NonNull TextPaint r11, @NonNull e r12) {
        o(r10, r11, r12);
        ColorStateList r13 = this.f3584j;
        if (r13 == null) goto L5;
        int r14 = r13.getColorForState(r11.drawableState, r13.getDefaultColor());
    L6:
        r11.setColor(r14);
        float r15 = this.f3581g;
        float r16 = this.f3579e;
        float r17 = this.f3580f;
        ColorStateList r18 = this.f3575a;
        if (r18 == null) goto L9;
        int r19 = r18.getColorForState(r11.drawableState, r18.getDefaultColor());
    L10:
        r11.setShadowLayer(r15, r16, r17, r19);
        return;
    L9:
        r19 = 0;
        goto L10
    L5:
        r14 = ViewCompat.MEASURED_STATE_MASK;
        goto L6
    }

    public void o(@NonNull Context r10, @NonNull TextPaint r11, @NonNull e r12) {
        if (m(r10) == false) goto L5;
        p(r10, r11, f(r10));
        return;
    L5:
        g(r10, r11, r12);
    }

    public void p(@NonNull Context r10, @NonNull TextPaint r11, @NonNull Typeface r12) {
        Typeface r13 = f.a(r10, r12);
        if (r13 == null) goto L5;
        r12 = r13;
    L5:
        r11.setTypeface(r12);
        int r14 = this.f3577c & (~r12.getStyle());
        if ((r14 & 1) == 0) goto L8;
        boolean r15 = true;
    L9:
        r11.setFakeBoldText(r15);
        if ((r14 & 2) == 0) goto L12;
        float r16 = -0.25f;
    L13:
        r11.setTextSkewX(r16);
        r11.setTextSize(this.f3585k);
        if (Build.VERSION.SDK_INT >= 21) goto L16;
        return;
    L16:
        if (this.f3582h == false) goto L20;
        r11.setLetterSpacing(this.f3583i);
        return;
    L20:
        return;
    L12:
        r16 = 0.0f;
        goto L13
    L8:
        r15 = false;
        goto L9
    }
}
