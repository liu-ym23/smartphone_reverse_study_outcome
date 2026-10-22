package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.threadwindow.FlowThreadWindowRepository", f = "FlowThreadWindowRepository.kt", i = {}, l = {28}, m = "loadInitData-IoAF18A", n = {}, s = {})
final class FlowThreadWindowRepository$loadInitData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowThreadWindowRepository this$0;

    public FlowThreadWindowRepository$loadInitData$1(FlowThreadWindowRepository r1, Continuation<? super FlowThreadWindowRepository$loadInitData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Target.SIZE_ORIGINAL;
        FlowThreadWindowRepository r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L5;
        this.label = r1 - Target.SIZE_ORIGINAL;
        FlowThreadWindowRepository$loadInitData$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        ResultKt.throwOnFailure(r2);
    L15:
        r3 = ((Result) r2).unbox-impl();
    L17:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r3;
    L20:
        return Result.box-impl(r3);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        CoroutineDispatcher r5 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadInitData$2 r6 = new FlowThreadWindowRepository$loadInitData$2(r8, null);
        r0.label = 1;
        r2 = BuildersKt.withContext(r5, r6, r0);
        if (r2 != r3) goto L15;
    L5:
        r0 = new FlowThreadWindowRepository$loadInitData$1(r8, this);
        goto L6
    }
}
