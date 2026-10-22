package com.lynx.tasm;

import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxView f10897a;

    public k0(LynxView r5) {
        this.f10897a = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap r5 = new HashMap();
        LynxView.access$000(this.f10897a, r5);
        return r5;
    }
}
