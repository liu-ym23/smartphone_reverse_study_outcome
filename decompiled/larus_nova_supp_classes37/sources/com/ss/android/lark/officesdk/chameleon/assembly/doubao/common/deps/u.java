package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class u implements ntb.u {
    public u() {
    }

    @Override // ntb.u
    public final void sendEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        com.ss.android.lark.statistics.b.b(r2, r3);
    }
}
