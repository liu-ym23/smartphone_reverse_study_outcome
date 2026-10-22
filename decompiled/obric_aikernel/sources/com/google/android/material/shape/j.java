package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3642a;

    public j(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.f3642a = r10;
    }

    @Override // com.google.android.material.shape.c
    public float a(@NonNull RectF r10) {
        return this.f3642a * r10.height();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L9;
        return false;
    L9:
        if (this.f3642a != ((j) r10).f3642a) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f3642a)});
    }
}
