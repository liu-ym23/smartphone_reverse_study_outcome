package com.larus.common.account.platform.larklogin;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import kotlin.TuplesKt;
import org.json.JSONObject;
import sc7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j extends sa7.h<xa7.c> {
    public final /* synthetic */ LarkLogin a;
    public final /* synthetic */ String b;

    public final void onSuccess(ua7.b r6) {
        xa7.c r7 = (xa7.c) r6;
        FLogger.a.i("LarkLogin", "login success");
        LarkLogin r0 = this.a;
        LarkLogin.a r1 = LarkLogin.g;
        r0.getClass();
        if (r7 == null) goto L18;
        com.ss.android.account.d r2 = ((ua7.h) r7).p;
        if (r2 == null) goto L18;
        String r3 = ((a) r2).k;
        if (r3 == null) goto L18;
        String r4 = p0.a(r3);
        if (r4 == null) goto L18;
        JSONObject r5 = ((a) ((ua7.h) r7).p).o;
        if (r5 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        boolean r9 = !r8;
        ((Keva) r0.d.getValue()).storeBoolean("is_enterprise_account_".concat(r4), r9);
        r0.f = TuplesKt.to(r4, Boolean.valueOf(r9));
        goto L18
    L14:
        if (r5.optInt("passport_enterprise_user_type") != 0) goto L16;
        r8 = true;
    L18:
        LarkOAuthSessionCoordinator r10 = LarkLogin.h;
        String r11 = this.b;
        if (r7 == null) goto L23;
        com.ss.android.account.d r12 = ((ua7.h) r7).p;
        if (r12 == null) goto L23;
        Boolean r13 = Boolean.valueOf(((a) r12).g);
    L24:
        r10.c(r11, new LarkOAuthSessionCoordinator$c.d(r13));
        return;
    L23:
        r13 = null;
        goto L24
    }

    public j(LarkLogin r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onError(ua7.b r7, int r8) {
        xa7.c r9 = (xa7.c) r7;
        FLogger.a.i("LarkLogin", "login fail, errorCode: " + r8);
        LarkOAuthSessionCoordinator r0 = LarkLogin.h;
        String r1 = this.b;
        String r10 = String.valueOf(r8);
        String r3 = null;
        if (r9 == null) goto L5;
        String r4 = ((ua7.b) r9).i;
    L6:
        if (r9 == null) goto L8;
        Integer r5 = Integer.valueOf(((ua7.b) r9).h);
    L9:
        if (r9 == null) goto L11;
        r3 = ((ua7.b) r9).j;
    L11:
        r0.c(r1, new LarkOAuthSessionCoordinator$c.c(r10, r4, r5, r3));
        return;
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
