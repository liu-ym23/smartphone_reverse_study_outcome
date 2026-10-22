package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z implements zob.b {
    public final /* synthetic */ a0.a a;

    public z(y r1) {
        this.a = r1;
    }

    @Override // zob.b
    public final void a(Locale r1, Locale r2) {
        ((y) this.a).a.getClass();
        qa5.b.a.a.a.b().a();
        if (com.ss.android.lark.utils.o0.b(LarkContext.getApplication()) == false) goto L6;
        com.bytedance.ee.bear.lark.dependency.g r3 = (com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class);
        LarkContext.getApplication();
        r3.H0();
        return;
    }
}
