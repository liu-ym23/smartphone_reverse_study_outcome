package com.lynx.tasm.behavior.ui;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UIBody.UIBodyView f10689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIBody f10690b;

    public t(UIBody r5, UIBody.UIBodyView r10, com.lynx.tasm.b0 r11) {
        this.f10690b = r5;
        this.f10689a = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f10690b.mContext.getClass();
        UIBody r5 = this.f10690b;
        r5.f10385a = this.f10689a;
        r5.initialize();
        this.f10690b.mContext.getClass();
        return null;
    }
}
