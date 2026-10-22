package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements ILiveFaceCertCallback {
    public final /* synthetic */ v80.f a;
    public final /* synthetic */ t80.a b;
    public final /* synthetic */ Map c;

    public final void onVerifyResult(LiveCertResult r9) {
        StringBuilder r0 = new StringBuilder("receive Certication  result， isFaceOnly: ");
        r0.append(this.a.d);
        r0.append(", errorCode = ");
        Integer r1 = null;
        if (r9 == null) goto L5;
        Integer r2 = Integer.valueOf(r9.getErrorCode());
    L6:
        r0.append(r2);
        r0.append(", status = ");
        if (r9 == null) goto L11;
        LiveCertStatus r3 = r9.getStatus();
        if (r3 == null) goto L11;
        r1 = Integer.valueOf(r3.getCertStatus());
    L11:
        r0.append(r1);
        ALogger.i("LiveRechargeInterceptor", r0.toString());
        if (this.a.d == false) goto L24;
        if (r9 != null) goto L15;
    L20:
        f2.c(s1.B(2131916535), 0);
        t80.a r4 = this.b;
        if (r4 == null) goto L23;
        r4.onVerifyResult(1);
    L23:
        this.c.put("verify_result", "fail");
    L37:
        this.c.put("live_result", String.valueOf(r9));
        int r5 = do0.a.a;
        RechargeVerifyTraceStep r6 = RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_RESULT;
        if (r9 == null) goto L40;
        int r7 = r9.getErrorCode();
    L41:
        do0.a.a(r6, r7, "", "", "", this.c);
        return;
    L40:
        r7 = 0;
        goto L41
    L15:
        if (r9.getErrorCode() != 0) goto L20;
        f2.c(s1.B(2131915630), 0);
        t80.a r8 = this.b;
        if (r8 == null) goto L19;
        r8.onVerifyResult(3);
    L19:
        this.c.put("verify_result", "success");
        goto L37
    L24:
        if (r9 == null) goto L37;
        LiveCertStatus r10 = r9.getStatus();
        if (r10 == null) goto L37;
        if (r10.getCertStatus() != 1) goto L33;
        f2.c(s1.B(2131915630), 0);
        t80.a r11 = this.b;
        if (r11 == null) goto L32;
        r11.onVerifyResult(3);
    L32:
        this.c.put("verify_result", "success");
        goto L37
    L33:
        t80.a r12 = this.b;
        if (r12 == null) goto L36;
        r12.onVerifyResult(1);
    L36:
        this.c.put("verify_result", "fail");
        goto L37
    L5:
        r2 = null;
        goto L6
    }

    public v(v80.f r1, t80.a r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
