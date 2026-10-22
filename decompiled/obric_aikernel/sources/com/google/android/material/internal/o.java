package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(18)
class o implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f3458a;

    o(@NonNull View r10) {
        this.f3458a = r10.getOverlay();
    }

    @Override // com.google.android.material.internal.p
    public void add(@NonNull Drawable r10) {
        this.f3458a.add(r10);
    }

    @Override // com.google.android.material.internal.p
    public void remove(@NonNull Drawable r10) {
        this.f3458a.remove(r10);
    }
}
