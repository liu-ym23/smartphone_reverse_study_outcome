package com.google.android.material.sidesheet;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
interface SheetCallback {
    void onSlide(@NonNull View r5, float r10);

    void onStateChanged(@NonNull View r5, int r10);
}
