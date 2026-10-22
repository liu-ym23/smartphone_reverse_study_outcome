package com.bytedance.android.ec.core.address;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements ti.j {
    public i() {
    }

    public final void a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        AddressSDK.c("deleteAddress", r10);
    }
}
