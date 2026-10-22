package com.larus.account.saas.security.kickout;

import h48.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements d {
    public final /* synthetic */ Function0<Unit> a;

    @Override // h48.d
    public final void confirm() {
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public a(Function0<Unit> r1) {
        this.a = r1;
    }
}
