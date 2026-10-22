package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveTryLoadCertPluginResultModel;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "live.tryLoadCertPlugin")
public final class s1 extends w20.o3<JsonObject, LiveTryLoadCertPluginResultModel> {
    public s1() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IHostOCRApiProxy r4 = jc1.k.f(IHostOCRApiProxy.class);
        if (r4 != null) goto L5;
    L7:
        IHostOCRApiProxy r5 = jc1.k.f(IHostOCRApiProxy.class);
        if (r5 == null) goto L12;
        r5.tryLoadCertPlugin(r3.getContext(), new r1(this));
        return;
    L12:
        return;
    L5:
        if (r4.isCertPluginLoaded() != true) goto L7;
        LiveTryLoadCertPluginResultModel r6 = new LiveTryLoadCertPluginResultModel();
        r6.a(LiveTryLoadCertPluginResultModel.Code.Success);
        r6.b("cert plugin loaded");
        Unit r7 = Unit.INSTANCE;
        finishWithResult(r6);
    }
}
