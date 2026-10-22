package com.lynx.tasm;

import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxView f10878c;

    public h0(LynxView r5, int r10, int r11) {
        this.f10878c = r5;
        this.f10876a = r10;
        this.f10877b = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap r5 = new HashMap();
        r5.put("widthMeasureSpec", String.valueOf(this.f10876a));
        r5.put("heightMeasureSpec", String.valueOf(this.f10877b));
        LynxView.access$000(this.f10878c, r5);
        return r5;
    }
}
