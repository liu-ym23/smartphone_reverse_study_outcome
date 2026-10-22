package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class i extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f3640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f3641b;

    public i(@NonNull f r10, float r11) {
        this.f3640a = r10;
        this.f3641b = r11;
    }

    @Override // com.google.android.material.shape.f
    boolean b() {
        return this.f3640a.b();
    }

    @Override // com.google.android.material.shape.f
    public void d(float r10, float r11, float r12, @NonNull n r13) {
        this.f3640a.d(r10, r11 - this.f3641b, r12, r13);
    }
}
