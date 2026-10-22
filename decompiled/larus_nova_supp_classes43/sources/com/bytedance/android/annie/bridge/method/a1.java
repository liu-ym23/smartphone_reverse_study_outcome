package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.MakePhoneCallResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "makePhoneCall")
public final class a1 extends e7.m<e7.m0, MakePhoneCallResultModel> {
    public a1() {
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.m0 r12 = (e7.m0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        if (r11.getContext() != null) goto L6;
        MakePhoneCallResultModel r13 = new MakePhoneCallResultModel();
        r13.a(MakePhoneCallResultModel.Code.Failed);
        r13.b("Context not provided in host");
        finishWithResult(r13);
        return;
    L6:
        if (r12.a() != null) goto L8;
        MakePhoneCallResultModel r14 = new MakePhoneCallResultModel();
        r14.a(MakePhoneCallResultModel.Code.Failed);
        r14.b("phoneNumber is null");
        finishWithResult(r14);
        return;
    L8:
        String r0 = r12.a();
        Intrinsics.checkNotNull(r0);
        if (StringsKt.isBlank(r0) == false) goto L11;
        MakePhoneCallResultModel r15 = new MakePhoneCallResultModel();
        r15.a(MakePhoneCallResultModel.Code.Failed);
        r15.b("phoneNumber is  blank");
        finishWithResult(r15);
        return;
    L11:
        ((o9.b) Annie.getService(o9.b.class, r11.a())).q1(r12, r11.getContext(), new z0(this));
    }
}
