package com.lynx.tasm.behavior.ui;

import androidx.core.util.Consumer;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxUI f10491a;

    public k(LynxUI r5) {
        this.f10491a = r5;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r5) {
        Exception r10 = (Exception) r5;
        LynxContext r11 = this.f10491a.mContext;
        if (r11 == null) goto L6;
        ((com.lynx.tasm.b0) r11).o(r10);
        return;
    }
}
