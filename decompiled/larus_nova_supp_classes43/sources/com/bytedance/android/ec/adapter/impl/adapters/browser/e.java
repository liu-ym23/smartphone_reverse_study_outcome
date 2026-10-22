package com.bytedance.android.ec.adapter.impl.adapters.browser;

import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements IECBridgeMethod.c {
    public final /* synthetic */ CallContext a;

    public e(CallContext r1) {
        this.a = r1;
    }

    public final void a(JSONObject r10) {
        Intrinsics.checkNotNullParameter("skuConfirmed", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r10, "params");
        this.a.b("skuConfirmed", r10);
    }
}
