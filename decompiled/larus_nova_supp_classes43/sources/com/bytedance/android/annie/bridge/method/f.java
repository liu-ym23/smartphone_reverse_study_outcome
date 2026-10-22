package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.ChooseAndUploadParamModel;
import com.bytedance.android.annie.bridge.ChooseAndUploadResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "chooseAndUpload")
public final class f extends com.bytedance.android.annie.bridge.a<ChooseAndUploadParamModel, ChooseAndUploadResultModel> {
    public final void onTerminate() {
    }

    public f() {
    }

    public final void invoke(Object r10, CallContext r11) {
        ChooseAndUploadParamModel r12 = (ChooseAndUploadParamModel) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Integer r13 = r12.a();
        if (r13 != null) goto L5;
    L14:
        String r0 = r11.a();     // Catch: Exception -> L12
        if (r0 != null) goto L10;
        r0 = "host";
    L10:
        a9.g r14 = (a9.g) Annie.getService(a9.g.class, r0);     // Catch: Exception -> L12
        r11.getContext();     // Catch: Exception -> L12
        r14.d0();     // Catch: Exception -> L12
        return;
    L12:
        ChooseAndUploadResultModel r15 = new ChooseAndUploadResultModel();
        r15.a(ChooseAndUploadResultModel.Code.Failed);
        r15.b("chooseAndUpload not implemented in host");
        finishWithResult(r15);
        return;
    L5:
        if (r13.intValue() > 0) goto L14;
        ChooseAndUploadResultModel r16 = new ChooseAndUploadResultModel();
        r16.a(ChooseAndUploadResultModel.Code.InvalidParam);
        r16.b("maxCount must be greater than 0");
        finishWithResult(r16);
    }
}
