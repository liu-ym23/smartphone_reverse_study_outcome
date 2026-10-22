package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.content.Context;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements ntb.f {
    public g() {
    }

    @Override // ntb.f
    public final void e0() {
    }

    @Override // ntb.f
    public final boolean J(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Boolean r3 = OfficeSDKManager.isDebug();
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.booleanValue();
    }

    @Override // ntb.f
    public final boolean V(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Boolean r3 = OfficeSDKManager.isDebug();
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.booleanValue();
    }
}
