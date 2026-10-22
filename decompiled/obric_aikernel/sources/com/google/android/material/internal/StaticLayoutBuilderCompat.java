package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f3350n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f3351o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private static Constructor<StaticLayout> f3352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private static Object f3353q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f3354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f3355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Layout.Alignment f3359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f3361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f3362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3363j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3364k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private TextUtils.TruncateAt f3366m;

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable r10) {
            super("Error thrown initializing StaticLayout " + r10.getMessage(), r10);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r10 = 1;
    L6:
        f3350n = r10;
        return;
    L5:
        r10 = 0;
        goto L6
    }

    private StaticLayoutBuilderCompat(CharSequence r10, TextPaint r11, int r12) {
        this.f3354a = r10;
        this.f3355b = r11;
        this.f3356c = r12;
        this.f3357d = 0;
        this.f3358e = r10.length();
        this.f3359f = Layout.Alignment.ALIGN_NORMAL;
        this.f3360g = Integer.MAX_VALUE;
        this.f3361h = 0.0f;
        this.f3362i = 1.0f;
        this.f3363j = f3350n;
        this.f3364k = true;
        this.f3366m = null;
    }

    private void b() {
        if (f3351o == false) goto L28;
        return;
    L28:
    L25:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L6:
        if (this.f3365l == true) goto L8;
    L10:
        boolean r10 = false;
    L12:
        if (Build.VERSION.SDK_INT < 18) goto L18;
        Class<?> r11 = TextDirectionHeuristic.class;
        if (r10 == false) goto L16;
        TextDirectionHeuristic r12 = TextDirectionHeuristics.RTL;     // Catch: Exception -> L25
    L17:
        f3353q = r12;     // Catch: Exception -> L25
    L23:
        Class r13 = Integer.TYPE;     // Catch: Exception -> L25
        Class r14 = Float.TYPE;     // Catch: Exception -> L25
        Constructor<StaticLayout> r15 = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, r13, r13, TextPaint.class, r13, Layout.Alignment.class, r11, r14, r14, Boolean.TYPE, TextUtils.TruncateAt.class, r13, r13});     // Catch: Exception -> L25
        f3352p = r15;     // Catch: Exception -> L25
        r15.setAccessible(true);     // Catch: Exception -> L25
        f3351o = true;     // Catch: Exception -> L25
        return;
    L16:
        r12 = TextDirectionHeuristics.LTR;     // Catch: Exception -> L25
        goto L17
    L18:
        ClassLoader r16 = StaticLayoutBuilderCompat.class.getClassLoader();     // Catch: Exception -> L25
        if (this.f3365l == false) goto L21;
        String r17 = "RTL";
    L22:
        Class<?> r18 = r16.loadClass("android.text.TextDirectionHeuristic");     // Catch: Exception -> L25
        Class<?> r19 = r16.loadClass("android.text.TextDirectionHeuristics");     // Catch: Exception -> L25
        f3353q = r19.getField(r17).get(r19);     // Catch: Exception -> L25
        r11 = r18;
        goto L23
    L21:
        r17 = "LTR";
        goto L22
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r10 = true;
        goto L12
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence r10, @NonNull TextPaint r11, @IntRange(from = 0) int r12) {
        return new StaticLayoutBuilderCompat(r10, r11, r12);
    }

    public StaticLayout a() {
        if (this.f3354a != null) goto L5;
        this.f3354a = "";
    L5:
        int r10 = Math.max(0, this.f3356c);
        CharSequence r11 = this.f3354a;
        if (this.f3360g != 1) goto L8;
        r11 = TextUtils.ellipsize(r11, this.f3355b, r10, this.f3366m);
    L8:
        int r12 = Math.min(r11.length(), this.f3358e);
        this.f3358e = r12;
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        b();
        return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f3352p)).newInstance(new Object[]{r11, Integer.valueOf(this.f3357d), Integer.valueOf(this.f3358e), this.f3355b, Integer.valueOf(r10), this.f3359f, Preconditions.checkNotNull(f3353q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f3364k), null, Integer.valueOf(r10), Integer.valueOf(this.f3360g)});
    L35:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L11:
        if (this.f3365l == true) goto L13;
    L15:
        StaticLayout.Builder r13 = StaticLayout.Builder.obtain(r11, this.f3357d, r12, this.f3355b, r10);
        r13.setAlignment(this.f3359f);
        r13.setIncludePad(this.f3364k);
        if (this.f3365l == false) goto L18;
        TextDirectionHeuristic r14 = TextDirectionHeuristics.RTL;
    L19:
        r13.setTextDirection(r14);
        TextUtils.TruncateAt r15 = this.f3366m;
        if (r15 == null) goto L22;
        r13.setEllipsize(r15);
    L22:
        r13.setMaxLines(this.f3360g);
        float r16 = this.f3361h;
        if (r16 == 0.0f) goto L25;
    L26:
        r13.setLineSpacing(r16, this.f3362i);
    L28:
        if (this.f3360g <= 1) goto L31;
        r13.setHyphenationFrequency(this.f3363j);
    L31:
        return r13.build();
    L25:
        if (this.f3362i == 1.0f) goto L28;
    L18:
        r14 = TextDirectionHeuristics.LTR;
        goto L19
    L13:
        if (this.f3360g != 1) goto L15;
        this.f3359f = Layout.Alignment.ALIGN_OPPOSITE;
        goto L15
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment r10) {
        this.f3359f = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(@Nullable TextUtils.TruncateAt r10) {
        this.f3366m = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(int r10) {
        this.f3363j = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat g(boolean r10) {
        this.f3364k = r10;
        return this;
    }

    public StaticLayoutBuilderCompat h(boolean r10) {
        this.f3365l = r10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(float r10, float r11) {
        this.f3361h = r10;
        this.f3362i = r11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(@IntRange(from = 0) int r10) {
        this.f3360g = r10;
        return this;
    }
}
