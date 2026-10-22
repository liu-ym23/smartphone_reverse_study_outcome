package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.larksuite.framework.callback.UICallbackExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements mpc.b {
    public final /* synthetic */ mpc.b a;

    @Override // mpc.b
    public final void onSuccess() {
        int r0 = opc.d.a;
        UICallbackExecutor.post(opc.b.a);
        this.a.onSuccess();
    }

    public f(u48.c r1) {
        this.a = r1;
    }

    @Override // mpc.b
    public final void onFailure(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        int r0 = opc.d.a;
        UICallbackExecutor.post(opc.b.a);
        this.a.onFailure(r2, r3);
    }
}
