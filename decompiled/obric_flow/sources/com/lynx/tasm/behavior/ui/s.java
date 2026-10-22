package com.lynx.tasm.behavior.ui;

import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UIBody f10594a;

    public s(UIBody r5) {
        this.f10594a = r5;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r5) {
        Exception r10 = (Exception) r5;
        UIBody r11 = this.f10594a;
        if (r11.getLynxContext() == null) goto L6;
        ((com.lynx.tasm.b0) r11.getLynxContext()).o(r10);
        return;
    }
}
