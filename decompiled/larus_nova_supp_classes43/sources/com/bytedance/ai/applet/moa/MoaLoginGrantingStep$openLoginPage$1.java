package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep", f = "MoaLoginGrantingStep.kt", i = {0, 0, 0, 1}, l = {441, 451}, m = "openLoginPage-gIAlu-s", n = {com.bytedance.android.ec.core.event.a.KEY_URL, "context", "appletId", "app"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class MoaLoginGrantingStep$openLoginPage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$openLoginPage$1(MoaLoginGrantingStep r1, Continuation<? super MoaLoginGrantingStep$openLoginPage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        MoaLoginGrantingStep r11 = this.this$0;
        int r0 = MoaLoginGrantingStep.m;
        Object r12 = r11.m(null, this);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Result.box-impl(r12);
    }
}
