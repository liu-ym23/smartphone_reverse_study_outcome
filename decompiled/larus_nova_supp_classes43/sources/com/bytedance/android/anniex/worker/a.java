package com.bytedance.android.anniex.worker;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IDLXBridgeMethod.b {
    public final /* synthetic */ JSWorkerBDXBridge a;

    public a(JSWorkerBDXBridge r1) {
        this.a = r1;
    }

    public final void a(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.a.a(r10, r11);
    }
}
