package com.larus.account.base.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import pb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LoginServiceImpl$g extends a {
    public final /* synthetic */ Function1<String, Unit> a;
    public final /* synthetic */ Function1<Long, Unit> b;

    public final void onSuccess(ua7.b r4) {
        pb7.c r5 = (pb7.c) r4;
        boolean r0 = false;
        if (r5 == null) goto L12;
        String r1 = ((nb7.a) r5).p;
        if (r1 == null) goto L12;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L12;
        r0 = true;
        goto L12
    L9:
        r2 = false;
    L12:
        if (r0 == false) goto L14;
        this.a.invoke(((nb7.a) r5).p);
        return;
    L14:
        this.b.invoke(-1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoginServiceImpl$g(Function1<? super String, Unit> r1, Function1<? super Long, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onError(ua7.b r3, int r4) {
        pb7.c r5 = (pb7.c) r3;
        this.b.invoke(Long.valueOf(r4));
    }
}
