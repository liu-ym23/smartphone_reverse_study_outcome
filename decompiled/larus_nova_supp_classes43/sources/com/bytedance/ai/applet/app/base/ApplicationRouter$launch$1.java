package com.bytedance.ai.applet.app.base;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.base.ApplicationRouter$DefaultImpls", f = "ApplicationRouter.kt", i = {}, l = {IAPI.OPTION_SET_USE_UDP_PATH}, m = "launch-gIAlu-s", n = {}, s = {})
final class ApplicationRouter$launch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ApplicationRouter$launch$1(Continuation<? super ApplicationRouter$launch$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        int r11 = this.label | Integer.MIN_VALUE;
        this.label = r11;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r11 - Integer.MIN_VALUE;
        ApplicationRouter$launch$1 r12 = this;
    L6:
        Object r0 = r12.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r12.label;
        if (r1 == 0) goto L16;
        if (r1 != 1) goto L15;
        ResultKt.throwOnFailure(r0);
        Object r13 = ((Result) r0).unbox-impl();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r13;
    L13:
        return Result.box-impl(r13);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        r12.label = 1;
        throw null;
    L5:
        r12 = new ApplicationRouter$launch$1(this);
        goto L6
    }
}
