package com.bytedance.android.annie.container.dialog;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements Runnable {
    public final /* synthetic */ PopupHybridParamVoNew a;
    public final /* synthetic */ BaseDialogFragment b;

    public g(PopupHybridParamVoNew r1, BaseDialogFragment r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        if (this.a.l3() <= 0) goto L7;
        BaseDialogFragment r0 = this.b;
        int r1 = this.a.l3();
        int r10 = BaseDialogFragment.r;
        HybridFragment r11 = r0.f;
        if (r11 == null) goto L11;
        r11.setRadius(r0.da0(r1));
        return;
    L11:
        return;
    L7:
        BaseDialogFragment r12 = this.b;
        int r13 = this.a.o3();
        int r14 = this.a.p3();
        int r15 = this.a.n3();
        int r16 = this.a.m3();
        HybridFragment r17 = r12.f;
        if (r17 == null) goto L13;
        r17.setRadius(r12.da0(r13), r12.da0(r14), r12.da0(r15), r12.da0(r16));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
