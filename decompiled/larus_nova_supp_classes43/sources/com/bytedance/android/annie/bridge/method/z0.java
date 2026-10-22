package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.MakePhoneCallResultModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z0 {
    public final /* synthetic */ a1 a;

    public final void a() {
        a1 r0 = this.a;
        MakePhoneCallResultModel r1 = new MakePhoneCallResultModel();
        r1.a(MakePhoneCallResultModel.Code.Failed);
        r1.b("phoneNumber is null");
        r0.finishWithResult(r1);
    }

    public final void b() {
        a1 r0 = this.a;
        MakePhoneCallResultModel r1 = new MakePhoneCallResultModel();
        r1.a(MakePhoneCallResultModel.Code.Success);
        r1.b("Call Success!");
        r0.finishWithResult(r1);
    }

    public z0(a1 r1) {
        this.a = r1;
    }
}
