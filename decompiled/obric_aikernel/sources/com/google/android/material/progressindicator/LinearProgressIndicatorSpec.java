package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.internal.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressIndicatorSpec extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f3519i;

    public LinearProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        this(r10, r11, r12, LinearProgressIndicator.f3516t);
    }

    public LinearProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        boolean r14 = false;
        TypedArray r15 = k.h(r10, r11, l.LinearProgressIndicator, q5.b.linearProgressIndicatorStyle, LinearProgressIndicator.f3516t, new int[0]);
        this.f3517g = r15.getInt(l.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f3518h = r15.getInt(l.LinearProgressIndicator_indicatorDirectionLinear, 0);
        r15.recycle();
        e();
        if (this.f3518h != 1) goto L5;
        r14 = true;
    L5:
        this.f3519i = r14;
    }

    @Override // com.google.android.material.progressindicator.b
    void e() {
        if (this.f3517g == 0) goto L5;
        return;
    L5:
        if (this.f3522b > 0) goto L12;
        if (this.f3523c.length < 3) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
    L12:
        throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
    }
}
