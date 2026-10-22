package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import kotlin.jvm.internal.Intrinsics;
import m38.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LoginServiceImpl$c implements n38.t {
    public final /* synthetic */ String a;
    public final /* synthetic */ n38.t b;

    @Override // n38.t
    public final void a() {
        this.b.a();
    }

    @Override // n38.t
    public final void b(Boolean r4) {
        a r0 = a.a;
        boolean r1 = Intrinsics.areEqual(r4, Boolean.TRUE);
        r0.getClass();
        a.c = r1;
        a.c(r0, this.a, LoginPlatform.LARK);
        this.b.b(r4);
    }

    public LoginServiceImpl$c(String r1, n38.t r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // n38.t
    public final void c(int r2, String r3, Integer r4, String r5) {
        a.a.getClass();
        this.b.c(r2, r3, r4, r5);
    }
}
