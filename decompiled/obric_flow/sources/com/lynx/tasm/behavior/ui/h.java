package com.lynx.tasm.behavior.ui;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxBaseUI f10487a;

    public h(LynxBaseUI r5) {
        this.f10487a = r5;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        this.f10487a.invalidate();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
    }
}
