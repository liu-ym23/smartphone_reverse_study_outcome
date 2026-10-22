package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f3636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f3637b;

    public b(float r10, @NonNull c r11) {
    L4:
        if ((r11 instanceof b) == false) goto L6;
        r11 = ((b) r11).f3636a;
        r10 = r10 + ((b) r11).f3637b;
        goto L4
    L6:
        this.f3636a = r11;
        this.f3637b = r10;
    }

    @Override // com.google.android.material.shape.c
    public float a(@NonNull RectF r10) {
        return Math.max(0.0f, this.f3636a.a(r10) + this.f3637b);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.f3636a.equals(r11.f3636a) == false) goto L14;
        if (this.f3637b != r11.f3637b) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3636a, Float.valueOf(this.f3637b)});
    }
}
