package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import hs8.e;
import hs8.f;
import is8.g;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ApiCredentialProviderAdapter implements js8.c {
    public final f a;

    public ApiCredentialProviderAdapter(f r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // js8.c
    public final boolean b(AuthMode r2) {
        Intrinsics.checkNotNullParameter(r2, "authMode");
        return this.a.b(r2);
    }

    @Override // js8.c
    public final Object a(g r5, is8.a r6, Continuation<? super js8.b> r7) {
        if ((r7 instanceof ApiCredentialProviderAdapter$fetch$1) == false) goto L7;
        ApiCredentialProviderAdapter$fetch$1 r0 = (ApiCredentialProviderAdapter$fetch$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        e r9 = (e) r8;
        return new js8.b(r9.a, r9.b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        f r10 = this.a;
        r0.label = 1;
        r8 = r10.a(r5, r6, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ApiCredentialProviderAdapter$fetch$1(this, r7);
        goto L8
    }
}
