package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class z implements ntb.x {
    public z() {
    }

    @Override // ntb.x
    public final void show(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "message");
        UDToast.show(r2, r3);
    }
}
