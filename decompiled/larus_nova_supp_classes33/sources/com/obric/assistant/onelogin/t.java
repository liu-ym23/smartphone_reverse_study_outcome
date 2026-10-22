package com.obric.assistant.onelogin;

import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class t implements Function2 {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ int b;

    public /* synthetic */ t(Ref.IntRef r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r8, Object r9) {
        final Ref.IntRef r0 = this.a;
        final int r1 = this.b;
        int r10 = ((Integer) r8).intValue();
        String r11 = (String) r9;
        Intrinsics.checkNotNullParameter(r11, "msg");
        int r2 = r0.element + 1;
        r0.element = r2;
        if (r2 <= r1) goto L5;
    L7:
        FLogger.a.w("ObricOneLoginUtils", "system logout failed, >= max retry time, exit, code: " + r10 + ", msg: " + r11);
        StateFlowImpl r12 = c0.a;
    L8:
        Object r13 = r12.getValue();
        ((Boolean) r13).booleanValue();
        if (r12.compareAndSet(r13, Boolean.FALSE) == false) goto L8;
    L11:
        return Unit.INSTANCE;
    L5:
        if (r10 != 1002) goto L7;
        FLogger.a.w("ObricOneLoginUtils", "system logout failed, service disconnect, retryCount: " + r0.element + ", code: " + r10 + ", msg: " + r11);
        t0.b(new v(r0, r1), 200);
        goto L11
    }
}
