package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import ua7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LoginServiceImpl$f extends a<ua7.b> {
    public final /* synthetic */ String a;
    public final /* synthetic */ LoginServiceImpl b;
    public final /* synthetic */ n38.m c;

    public final void onResponse(ua7.b r4) {
        if (r4 == null) goto L6;
        boolean r1 = true;
        if (r4.c != true) goto L6;
    L8:
        if (r1 == true) goto L10;
        n38.m r2 = this.c;
        if (r4 == null) goto L20;
        int r3 = r4.g;
    L21:
        if (r4 == null) goto L23;
        String r5 = r4.i;
    L24:
        r2.a(r3, r5, null, null);
        return;
    L23:
        r5 = null;
        goto L24
    L20:
        r3 = -1;
        goto L21
    L10:
        if (Intrinsics.areEqual(this.a, "aweme_v2") == false) goto L12;
        this.b.k(LoginPlatform.DOUYIN);
    L12:
        CopyOnWriteArrayList r6 = this.b.c;
        String r7 = this.a;
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        ((n38.g) r8.next()).a(r7);
        goto L14
    L16:
        this.c.onSuccess(null);
        return;
    L6:
        r1 = false;
        goto L8
    }

    public LoginServiceImpl$f(String r1, LoginServiceImpl r2, n38.m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
