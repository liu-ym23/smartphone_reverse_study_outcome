package com.larus.dora.impl.log;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.concurrent.TimeUnit;
import kj4.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ f(boolean r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final boolean r0 = this.a;
        boolean r1 = DoraLogManager.q.get();
        g49.d.d("DoraLogManager", "getLogInfo isOta " + DoraLogManager.m + ", isQuery " + DoraLogManager.l + ", isBusy " + r1 + ", isAuto " + DoraLogManager.t);
        DoraLogManager r6 = DoraLogManager.a;
        boolean r7 = false;
        if (DoraLogManager.l() == false) goto L5;
        p.c(2);
        r6.B(false);
        DoraLogManager.t(r6, false, "getLogInfo interrupt(isOta " + DoraLogManager.m + ", isQuery " + DoraLogManager.l + ", isBusy " + r1 + ')', DoraLogManager.e, 0, 24);
        return Unit.INSTANCE;
    L5:
        DoraLogManager.p = DoraLogManager.o.schedule(new h(r0), 10000, TimeUnit.MILLISECONDS);
        DoraDevice r2 = DoraAdapterExtKt.h(a.g());
        if (r2 == null) goto L11;
        if (o59.a.x(r2) != true) goto L11;
        r7 = true;
    L11:
        if (r7 == false) goto L16;
        mj4.f r4 = a.g().c;
        if (r0 == false) goto L15;
        r4.d.g(4, 7, new byte[]{1, 1, 1});
    L21:
        return Unit.INSTANCE;
    L15:
        r4.d.g(4, 7, new byte[]{1, 1, 0});
        goto L21
    L16:
        mj4.f r5 = a.g().c;
        if (r0 == false) goto L19;
        r5.d.g(4, 7, new byte[]{1, 1, 1});
        goto L21
    L19:
        r5.d.g(4, 7, new byte[]{1, 0});
        goto L21
    }
}
