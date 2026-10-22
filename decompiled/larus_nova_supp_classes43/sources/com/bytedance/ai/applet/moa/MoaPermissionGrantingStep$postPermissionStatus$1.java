package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaPermissionGrantingStep", f = "MoaPermissionGrantingStep.kt", i = {}, l = {121}, m = "postPermissionStatus-BWLJW6A", n = {}, s = {})
public final class MoaPermissionGrantingStep$postPermissionStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaPermissionGrantingStep this$0;

    public MoaPermissionGrantingStep$postPermissionStatus$1(MoaPermissionGrantingStep r1, Continuation<? super MoaPermissionGrantingStep$postPermissionStatus$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        MoaPermissionGrantingStep r11 = this.this$0;
        int r0 = MoaPermissionGrantingStep.c;
        Object r12 = r11.d(null, null, null, this);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Result.box-impl(r12);
    }
}
