package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdkapi.service.ILiveService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements ILiveService.OnWalletVerifyCallBack {
    public final /* synthetic */ bw.u a;

    public q(lu.h r1) {
        this.a = r1;
    }

    public final void onVerify(boolean r5, Map<String, ? extends Object> r6) {
        HashMap r0 = new HashMap();
        if (r6 == null) goto L24;
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L24;
        Map.Entry<String, ? extends Object> r1 = r7.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L6;
        if (r2.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 != true) goto L6;
        if (r1.getValue() == null) goto L6;
        String r4 = r1.getKey();
        Object r8 = "";
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        Object r9 = r1.getValue();
        if (r9 == null) goto L23;
        r8 = r9;
    L23:
        r0.put(r4, r8);
        goto L6
    L12:
        r3 = false;
    L24:
        bw.u r10 = this.a;
        if (r10 == null) goto L37;
        r10.a(r5);
        return;
    }
}
