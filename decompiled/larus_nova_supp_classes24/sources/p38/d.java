package p38;

import com.larus.login.impl.a0;
import com.larus.utils.logger.FLogger;
import n38.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends ua7.a<xa7.c> {
    public final /* synthetic */ m a;

    public d(a0.a r1) {
        this.a = r1;
    }

    public final void onResponse(ua7.b r4) {
        xa7.c r5 = (xa7.c) r4;
        FLogger.a.i("ChangePhoneManager", "doAuthVerify response:" + r5);
        if (r5 == null) goto L7;
        boolean r1 = true;
        if (((ua7.b) r5).c != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        this.a.onSuccess(r5.z.optString("ticket"));
        return;
    L10:
        m r0 = this.a;
        if (r5 == null) goto L13;
        int r2 = ((ua7.b) r5).g;
    L15:
        if (r5 == null) goto L17;
        String r6 = ((ua7.b) r5).i;
    L18:
        r0.a(r2, r6, null, null);
        return;
    L17:
        r6 = null;
        goto L18
    L13:
        r2 = -1;
    L7:
        r1 = false;
        goto L8
    }
}
