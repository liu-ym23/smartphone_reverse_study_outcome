package com.lynx.tasm;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f10880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10882c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ LynxView f;

    public i0(LynxView r5, boolean r10, int r11, int r12, int r13, int r14) {
        this.f = r5;
        this.f10880a = r10;
        this.f10881b = r11;
        this.f10882c = r12;
        this.d = r13;
        this.e = r14;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap r5 = new HashMap();
        r5.put(LynxResourceModule.PARAMS_KEY, "" + this.f10880a + " " + this.f10881b + " " + this.f10882c + " " + this.d + " " + this.e);
        LynxView.access$000(this.f, r5);
        return r5;
    }
}
