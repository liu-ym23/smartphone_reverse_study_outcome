package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.ResourceCenterRegisterPostAction;
import hs8.d;
import is8.g;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ApiPostUploadActionAdapter implements com.larus.bmhome.upload.sdk.impl.post.b {
    public final hs8.c a;

    public ApiPostUploadActionAdapter(ResourceCenterRegisterPostAction r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.a = r2;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.post.b
    public final boolean a(is8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "route");
        return this.a.a(r2);
    }

    @Override // com.larus.bmhome.upload.sdk.impl.post.b
    public final Object b(com.larus.bmhome.upload.sdk.impl.post.c r11, Continuation<? super com.larus.bmhome.upload.sdk.impl.post.c> r12) {
        if ((r12 instanceof ApiPostUploadActionAdapter$execute$1) == false) goto L7;
        ApiPostUploadActionAdapter$execute$1 r0 = (ApiPostUploadActionAdapter$execute$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        d r14 = (d) r13;
        g r4 = r14.a;
        is8.a r5 = r14.b;
        hs8.a r6 = r14.c;
        return new com.larus.bmhome.upload.sdk.impl.post.c(r4, r5, r6.a, r6.b, r14.d, r14.e);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        hs8.c r15 = this.a;
        d r7 = new d(r11.a, r11.b, new hs8.a(r11.c, r11.d), r11.e, r11.f);
        r0.label = 1;
        r13 = r15.b(r7, r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new ApiPostUploadActionAdapter$execute$1(this, r12);
        goto L8
    }
}
