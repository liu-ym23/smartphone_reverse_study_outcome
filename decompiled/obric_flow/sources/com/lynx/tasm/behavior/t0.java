package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f10374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10376c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ReadableMap e;
    public final /* synthetic */ PaintingContext f;

    public t0(PaintingContext r5, long r10, int r11, int r12, String r13, ReadableMap r14) {
        this.f = r5;
        this.f10374a = r10;
        this.f10375b = r11;
        this.f10376c = r12;
        this.d = r13;
        this.e = r14;
    }

    public final void a(Object... r10) {
        PaintingContext r5 = this.f;
        if (r5.f10170b == true) goto L11;
        com.lynx.tasm.b0 r11 = r5.f10169a.f10289c;
        if (r11 == null) goto L13;
        s0 r12 = new s0(this, this.f10374a, this.f10375b, r10);
        UIBody.UIBodyView r13 = r11.l();
        if (r13 == null) goto L12;
        r13.runOnTasmThread(r12);
        return;
    L12:
        return;
    L13:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n0 r5 = this.f.f10169a;
        int r10 = this.f10376c;
        LynxBaseUI r11 = r5.v(r10);
        if (r11 == null) goto L6;
        androidx.core.view.inputmethod.a r12 = new androidx.core.view.inputmethod.a(this, 9);
        com.lynx.tasm.behavior.utils.c.a(r11, this.d, this.e, r12);
        return;
    L6:
        a(new Object[]{6, String.format("Worklet: node %d does not have a LynxUI", new Object[]{Integer.valueOf(r10)})});
    }
}
