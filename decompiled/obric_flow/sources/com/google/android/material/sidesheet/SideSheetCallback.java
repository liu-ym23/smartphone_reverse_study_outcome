package com.google.android.material.sidesheet;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SideSheetCallback implements SheetCallback {
    public SideSheetCallback() {
    }

    public void onLayout(@NonNull View r5) {
    }

    @Override // com.google.android.material.sidesheet.SheetCallback
    public abstract void onSlide(@NonNull View r5, float r10);

    @Override // com.google.android.material.sidesheet.SheetCallback
    public abstract void onStateChanged(@NonNull View r5, int r10);
}
