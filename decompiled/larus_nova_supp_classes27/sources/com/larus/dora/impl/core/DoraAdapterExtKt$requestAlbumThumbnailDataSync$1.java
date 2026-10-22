package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {}, l = {956}, m = "requestAlbumThumbnailDataSync", n = {}, s = {})
final class DoraAdapterExtKt$requestAlbumThumbnailDataSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$requestAlbumThumbnailDataSync$1(Continuation<? super DoraAdapterExtKt$requestAlbumThumbnailDataSync$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        int r14 = this.label | Integer.MIN_VALUE;
        this.label = r14;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r14 - Integer.MIN_VALUE;
        DoraAdapterExtKt$requestAlbumThumbnailDataSync$1 r15 = this;
    L6:
        Object r0 = r15.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r15.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        ResultKt.throwOnFailure(r0);
    L15:
        v39.b r2 = (v39.b) r0;
        if ((r2 instanceof v39.b.f) == false) goto L18;
        byte[] r16 = ((v39.b.f) r2).b.d;
    L20:
        return r16;
    L18:
        r16 = new byte[0];
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r0);
        s0 r3 = s0.a;
        qk4.d r11 = new qk4.d(null, 0, 0, (byte) 0);
        r15.label = 1;
        r0 = r3.a(r11, 0, r15);
        if (r0 != r8) goto L15;
        return r8;
    L5:
        r15 = new DoraAdapterExtKt$requestAlbumThumbnailDataSync$1(this);
        goto L6
    }
}
