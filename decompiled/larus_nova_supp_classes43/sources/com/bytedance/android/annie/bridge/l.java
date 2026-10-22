package com.bytedance.android.annie.bridge;

import com.bytedance.ies.web.jsbridge2.d0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements r {
    public l() {
    }

    @Override // com.bytedance.android.annie.bridge.r
    public final void K0(d0 r10, Function2<? super String, ? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "jsBridge2");
        Intrinsics.checkNotNullParameter(r11, "block");
    }
}
