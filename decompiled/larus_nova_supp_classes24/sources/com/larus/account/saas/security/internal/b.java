package com.larus.account.saas.security.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends sa7.h<xa7.c> {
    public b() {
    }

    public final void onSuccess(ua7.b r5) {
        xa7.c r6 = (xa7.c) r5;
        String r2 = null;
        j.b("/passport/doubao/safety_alert/confirm/", true, null, null);
        com.larus.account.saas.runtime.internal.delegate.a r0 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r1 = new StringBuilder("confirm success, msg=");
        if (r6 == null) goto L5;
        r2 = ((ua7.b) r6).i;
    L5:
        r1.append(r2);
        r0.d("AccountSecurityConfirm", r1.toString());
    }

    public final void onError(ua7.b r6, int r7) {
        xa7.c r8 = (xa7.c) r6;
        int r0 = j.a;
        Integer r1 = Integer.valueOf(r7);
        String r2 = null;
        if (r8 == null) goto L6;
        String r3 = ((ua7.b) r8).i;
        if (r3 == null) goto L6;
    L9:
        j.b("/passport/doubao/safety_alert/confirm/", false, r1, r3);
        com.larus.account.saas.runtime.internal.delegate.a r4 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r5 = new StringBuilder("confirm failed, code=");
        r5.append(r7);
        r5.append(", msg=");
        if (r8 == null) goto L12;
        r2 = ((ua7.b) r8).i;
    L12:
        r5.append(r2);
        r4.f("AccountSecurityConfirm", r5.toString());
        return;
    L6:
        if (r8 == null) goto L8;
        r3 = ((ua7.b) r8).j;
        goto L9
    L8:
        r3 = null;
        goto L9
    }
}
