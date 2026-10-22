package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.DoLiveCertResultModel;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p2 implements ILiveFaceCertCallback {
    public final /* synthetic */ q2 a;

    public p2(q2 r1) {
        this.a = r1;
    }

    public final void onVerifyResult(LiveCertResult r4) {
        q2 r0 = this.a;
        DoLiveCertResultModel r1 = new DoLiveCertResultModel();
        r1.c(DoLiveCertResultModel.Code.Success);
        r1.h(BuildConfig.FLAVOR);
        if (r4 == null) goto L7;
        r1.d(Integer.valueOf(r4.getErrorCode()));
        r1.e(r4.getErrorMsg());
        r1.i(r4.getTicket());
        r1.f(r4.getExtraData());
        LiveCertStatus r5 = r4.getStatus();
        if (r5 == null) goto L7;
        r1.b(Integer.valueOf(r5.getCertStatus()));
        r1.g(Integer.valueOf(r5.getManualStatus()));
        r1.a(Integer.valueOf(r5.getAgeRange()));
    L7:
        Unit r6 = Unit.INSTANCE;
        r0.finishWithResult(r1);
    }
}
