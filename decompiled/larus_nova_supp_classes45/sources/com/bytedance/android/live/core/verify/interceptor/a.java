package com.bytedance.android.live.core.verify.interceptor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import java.util.Map;
import v80.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements ILiveFaceCertCallback {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ t80.a d;
    public final /* synthetic */ Map e;

    public final void onVerifyResult(LiveCertResult r9) {
        StringBuilder r0 = new StringBuilder("Minor Verified result， isFaceOnly: ");
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
        ALogger.i("MinorInterceptor", r0.toString());
        if (this.a.d == false) goto L24;
        if (r9 != null) goto L15;
    L20:
        f2.c(s1.B(2131916535), 0);
        t80.a r4 = this.d;
        if (r4 == null) goto L23;
        r4.onVerifyResult(1);
    L23:
        this.e.put("verify_result", "fail");
    L37:
        this.e.put("live_result", String.valueOf(r9));
        int r5 = do0.a.a;
        RechargeVerifyTraceStep r6 = RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_RESULT;
        if (r9 == null) goto L40;
        int r7 = r9.getErrorCode();
    L41:
        do0.a.a(r6, r7, this.b, this.c, "", this.e);
        return;
    L40:
        r7 = 0;
        goto L41
    L15:
        if (r9.getErrorCode() != 0) goto L20;
        f2.c(s1.B(2131915630), 0);
        t80.a r8 = this.d;
        if (r8 == null) goto L19;
        r8.onVerifyResult(3);
    L19:
        this.e.put("verify_result", "success");
        goto L37
    L24:
        if (r9 == null) goto L37;
        LiveCertStatus r11 = r9.getStatus();
        if (r11 == null) goto L37;
        if (r11.getCertStatus() != 1) goto L33;
        f2.c(s1.B(2131915630), 0);
        t80.a r12 = this.d;
        if (r12 == null) goto L32;
        r12.onVerifyResult(3);
    L32:
        this.e.put("verify_result", "success");
        goto L37
    L33:
        t80.a r13 = this.d;
        if (r13 == null) goto L36;
        r13.onVerifyResult(1);
    L36:
        this.e.put("verify_result", "fail");
        goto L37
    L5:
        r2 = null;
        goto L6
    }

    public a(f r1, String r2, String r3, t80.a r4, Map r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
