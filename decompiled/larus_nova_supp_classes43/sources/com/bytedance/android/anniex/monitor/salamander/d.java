package com.bytedance.android.anniex.monitor.salamander;

import com.bytedance.salamander.anniex.i7;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.q1;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends q1 {
    public final Function0<String> a;
    public final Set<Integer> b;

    public d(Function0<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.a = r10;
        this.b = SetsKt.setOf(new Integer[]{2, 11, 3});
    }

    public final void onReceivedError(LynxError r10) {
        super.onReceivedError(r10);
        SLMonitorCompat.a.getClass();
        if (SLMonitorCompat.b == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L11;
        int r0 = r10.getErrorCode() / 100;
        if (this.b.contains(Integer.valueOf(r0)) == false) goto L9;
        return;
    L9:
        String r1 = (String) this.a.invoke();
        i7 r11 = new i7();
        r11.a = r10.getErrorCode();
        String r12 = r10.getMsg();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.b = r12;
        String r13 = SLMonitorCompat.NativeErrorScene.LynxError.getValue();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r11.c = r13;
        Unit r14 = Unit.INSTANCE;
        SLMonitorCompat.o(r1, r11);
        return;
    }
}
