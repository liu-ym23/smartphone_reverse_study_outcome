package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    public ViewGroupOverlayApi14(Context r5, ViewGroup r10, View r11) {
        super(r5, r10, r11);
    }

    public static ViewGroupOverlayApi14 createFrom(ViewGroup r5) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.createFrom(r5);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void add(@NonNull View r5) {
        this.overlayViewGroup.add(r5);
    }

    @Override // com.google.android.material.internal.ViewGroupOverlayImpl
    public void remove(@NonNull View r5) {
        this.overlayViewGroup.remove(r5);
    }
}
