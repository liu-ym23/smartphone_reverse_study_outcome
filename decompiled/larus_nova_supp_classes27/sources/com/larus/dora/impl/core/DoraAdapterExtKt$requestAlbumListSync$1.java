package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {}, l = {940}, m = "requestAlbumListSync", n = {}, s = {})
final class DoraAdapterExtKt$requestAlbumListSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$requestAlbumListSync$1(Continuation<? super DoraAdapterExtKt$requestAlbumListSync$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        int r7 = this.label | Integer.MIN_VALUE;
        this.label = r7;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r7 - Integer.MIN_VALUE;
        DoraAdapterExtKt$requestAlbumListSync$1 r8 = this;
    L6:
        Object r0 = r8.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r8.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L11;
        ResultKt.throwOnFailure(r0);
    L15:
        v39.b r3 = (v39.b) r0;
        if ((r3 instanceof v39.b.f) == false) goto L18;
        byte[] r9 = ((v39.b.f) r3).b.d;
    L20:
        return r9;
    L18:
        r9 = new byte[0];
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r0);
        s0 r4 = s0.a;
        qk4.c r5 = new qk4.c(null);
        r8.label = 1;
        r0 = r4.a(r5, 0, r8);
        if (r0 != r1) goto L15;
        return r1;
    L5:
        r8 = new DoraAdapterExtKt$requestAlbumListSync$1(this);
        goto L6
    }
}
