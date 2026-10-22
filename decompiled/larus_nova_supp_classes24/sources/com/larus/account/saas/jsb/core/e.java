package com.larus.account.saas.jsb.core;

import kotlin.Unit;
import y38.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements x38.h {
    public final /* synthetic */ x38.g<Unit> a;

    @Override // x38.h
    public final void onSendSuccess() {
        this.a.onSuccess(Unit.INSTANCE);
    }

    public e(m r1) {
        this.a = r1;
    }

    @Override // x38.h
    public final void a(int r4, String r5) {
        x38.g<Unit> r0 = this.a;
        Integer r6 = Integer.valueOf(r4);
        if (r6.intValue() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L12;
        int r7 = r6.intValue();
    L13:
        if (r5 != null) goto L15;
        r5 = FlowAccountMobileSendCodeCore.Error.SEND_CODE_FAILED.getMessage();
    L15:
        r0.a(new x38.a(r7, r5, null));
        return;
    L12:
        r7 = FlowAccountMobileSendCodeCore.Error.SEND_CODE_FAILED.getCode();
        goto L13
    L5:
        r1 = false;
        goto L7
    }
}
