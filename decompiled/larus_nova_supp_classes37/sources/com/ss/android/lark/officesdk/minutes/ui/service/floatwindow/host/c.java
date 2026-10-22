package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements wfb.g {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ Function0<Unit> b;

    public final void a(boolean r5) {
        if (r5 == false) goto L4;
        this.a.invoke();
        return;
    L4:
        int r6 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "permissionResult", "permission denied", null, 8);
        this.b.invoke();
    }

    public c(Function0<Unit> r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
