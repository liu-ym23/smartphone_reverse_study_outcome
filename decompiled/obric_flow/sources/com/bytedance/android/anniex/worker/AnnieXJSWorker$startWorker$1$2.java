package com.bytedance.android.anniex.worker;

import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class AnnieXJSWorker$startWorker$1$2 implements lk.a {
    @Override // lk.a
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        tc.c r10 = tc.c.f22119c;
        i r11 = (i) fj.a.a(tc.c.f22119c, i.class, i.class);
        if (r11 == null) goto L5;
        x r12 = new x("anniex_worker_jsError");
        r12.e = com.lynx.tasm.utils.d.k("msg", r5);
        ((com.bytedance.ies.bullet.service.monitor.i) r11).d(r12);
    L5:
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AnnieXJSWorker", "handleError: " + r5, null, 12);
    }
}
