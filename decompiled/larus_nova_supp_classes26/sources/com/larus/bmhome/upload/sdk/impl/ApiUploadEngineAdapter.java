package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import hs8.e;
import hs8.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ApiUploadEngineAdapter implements com.larus.bmhome.upload.sdk.impl.engine.c {
    public final g a;

    public ApiUploadEngineAdapter(ResourceUploadEngine r2) {
        Intrinsics.checkNotNullParameter(r2, "engine");
        this.a = r2;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final boolean a(is8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "route");
        return this.a.a(r2);
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final Object b(String r9, is8.g r10, is8.a r11, js8.b r12, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> r13, Continuation<? super com.larus.bmhome.upload.sdk.impl.engine.b> r14) {
        if ((r14 instanceof ApiUploadEngineAdapter$upload$1) == false) goto L7;
        ApiUploadEngineAdapter$upload$1 r0 = (ApiUploadEngineAdapter$upload$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ApiUploadEngineAdapter$upload$1 r7 = r0;
        Object r15 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        hs8.a r16 = (hs8.a) r15;
        return new com.larus.bmhome.upload.sdk.impl.engine.b(r16.a, r16.b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        g r4 = this.a;
        e r5 = new e(r12.a, r12.b);
        r7.label = 1;
        r15 = r4.b(r9, r10, r11, r5, r13, r7);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new ApiUploadEngineAdapter$upload$1(this, r14);
        goto L8
    }
}
