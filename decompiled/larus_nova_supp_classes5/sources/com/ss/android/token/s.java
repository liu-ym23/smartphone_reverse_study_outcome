package com.ss.android.token;

import com.bytedance.android.sdk.bdticketguard.data.c;
import com.bytedance.android.sdk.bdticketguard.j1;
import com.bytedance.android.sdk.bdticketguard.w0;
import tb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class s implements i.a {
    public /* synthetic */ s() {
    }

    @Override // com.ss.android.token.i.a
    public final void a(j r12, j r13) {
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.v == false) goto L5;
        AttestSignCompensateTask.d.getClass();
        AttestSignCompensateTask.a("sec_ts_update");
    L5:
        j1 r0 = w0.a;
        j1 r1 = w0.a;
        if (r1 == null) goto L13;
        a.d("TokenFactory", "[TokenTimeUtil] updateSecTime current=" + r12);
        if (r13 == null) goto L10;
        Long r10 = Long.valueOf(r13.b);
    L11:
        r1.f(new c(r12.a, r12.b, r12.c, r12.f, r12.g, r10), null);
        return;
    L10:
        r10 = null;
        goto L11
    }
}
