package com.larus.account.saas.mfa.assist;

import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import d48.c$a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements c$a {
    public final /* synthetic */ i<Unit> a;
    public final /* synthetic */ AtomicBoolean b;

    @Override // d48.c$a
    public final void onAppLifeCycleChange(boolean r3) {
        if (r3 == false) goto L4;
        return;
    L4:
        if (this.a.isActive() == true) goto L6;
        return;
    L6:
        if (this.b.compareAndSet(false, true) == false) goto L11;
        SaasApp.a.g(this);
        i<Unit> r4 = this.a;
        Result.Companion r0 = Result.Companion;
        r4.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        return;
    }

    public c(j r1, AtomicBoolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
