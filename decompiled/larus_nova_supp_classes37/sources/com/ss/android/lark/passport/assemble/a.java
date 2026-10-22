package com.ss.android.lark.passport.assemble;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements com.ss.android.lark.passport.dpop.a {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.passport.dpop.a
    public final com.ss.android.lark.passport.dpop.a.b a() {
        Object r0 = ((Result) DPoPServiceInst.a.getValue()).unbox-impl();
        if (Result.isSuccess-impl(r0) == false) goto L11;
        com.bytedance.dpop.d r1 = ((com.bytedance.dpop.c) r0).a();
        String r2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r2, "str");
        r1.b.put("jti", r2);
        Object r3 = r1.a();
        if (Result.isSuccess-impl(r3) == false) goto L8;
        return new com.ss.android.lark.passport.dpop.a.f((String) r3);
    L8:
        if (Result.exceptionOrNull-impl(r3) == null) goto L11;
        return new com.ss.android.lark.passport.dpop.a.e();
    L11:
        if (Result.exceptionOrNull-impl(r0) == null) goto L14;
        return new com.ss.android.lark.passport.dpop.a.d();
    L14:
        return com.ss.android.lark.passport.dpop.a.c.a;
    }
}
