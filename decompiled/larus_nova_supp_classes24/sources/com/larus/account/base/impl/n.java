package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import m38.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n implements n38.h {
    public final /* synthetic */ String a;
    public final /* synthetic */ n38.h b;

    public n(String r1, n38.h r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // n38.h
    public final void b(LoginPlatform r3, String r4, Boolean r5) {
        a r0 = a.a;
        boolean r1 = Intrinsics.areEqual(r5, Boolean.TRUE);
        r0.getClass();
        a.c = r1;
        if (o0.d(this.a) == false) goto L5;
        String r2 = "authorized";
    L8:
        a.c(r0, r2, r3);
        this.b.b(r3, r4, r5);
        return;
    L5:
        if (r4 != null) goto L7;
        r2 = "";
        goto L8
    L7:
        r2 = r4;
        goto L8
    }

    @Override // n38.h
    public final void a(LoginPlatform r11, int r12, String r13, String r14, String r15, Integer r16, String r17, Map r19) {
        a.a.getClass();
        this.b.a(r11, r12, r13, r14, r15, r16, r17, r19);
    }
}
