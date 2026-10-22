package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.ChooseMediaResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "chooseMedia")
public final class g extends com.bytedance.android.annie.bridge.b<com.bytedance.android.annie.bridge.i, ChooseMediaResultModel> {
    public final void onTerminate() {
    }

    public g() {
    }

    public final void invoke(Object r10, CallContext r11) {
        com.bytedance.android.annie.bridge.i r12 = (com.bytedance.android.annie.bridge.i) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.b();
        String r13 = r12.a();
        if (r13 == null) goto L17;
        if (r0 == null) goto L17;
        if (Intrinsics.areEqual(r0.toLowerCase(Locale.ROOT), "camera") == false) goto L17;
        if (r13.length() != 0) goto L10;
        boolean r14 = true;
    L11:
        if (r14 == false) goto L17;
        ChooseMediaResultModel r15 = new ChooseMediaResultModel();
        r15.a(ChooseMediaResultModel.Code.InvalidParam);
        r15.b("CameraType not provided with sourceType specified as camera in params");
        finishWithResult(r15);
        return;
    L10:
        r14 = false;
    L17:
        a9.g r16 = (a9.g) Annie.getService(a9.g.class, r11.a());     // Catch: Exception -> L15
        r11.getContext();     // Catch: Exception -> L15
        r16.d0();     // Catch: Exception -> L15
        return;
    L15:
        ChooseMediaResultModel r17 = new ChooseMediaResultModel();
        r17.a(ChooseMediaResultModel.Code.Failed);
        r17.b("chooseMedia not implemented in host");
        finishWithResult(r17);
    }
}
