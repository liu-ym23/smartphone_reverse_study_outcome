package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.internal.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public final class CircularProgressIndicatorSpec extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Px
    public int f3511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Px
    public int f3512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3513i;

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        this(r10, r11, r12, CircularProgressIndicator.f3510t);
    }

    public CircularProgressIndicatorSpec(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(r10, r11, r12, r13);
        int r14 = r10.getResources().getDimensionPixelSize(q5.d.mtrl_progress_circular_size_medium);
        int r15 = r10.getResources().getDimensionPixelSize(q5.d.mtrl_progress_circular_inset_medium);
        TypedArray r16 = k.h(r10, r11, l.CircularProgressIndicator, r12, r13, new int[0]);
        this.f3511g = Math.max(com.google.android.material.resources.c.d(r10, r16, l.CircularProgressIndicator_indicatorSize, r14), this.f3521a * 2);
        this.f3512h = com.google.android.material.resources.c.d(r10, r16, l.CircularProgressIndicator_indicatorInset, r15);
        this.f3513i = r16.getInt(l.CircularProgressIndicator_indicatorDirectionCircular, 0);
        r16.recycle();
        e();
    }

    @Override // com.google.android.material.progressindicator.b
    void e() {
    }
}
