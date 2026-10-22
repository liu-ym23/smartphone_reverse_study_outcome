package com.obric.aikernel.res.update;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask$onNewConfig$1$1", f = "UpdateTask.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
final class UpdateTask$onNewConfig$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super UpdateResult>, Object> {
    int label;
    final /* synthetic */ UpdateTask this$0;

    UpdateTask$onNewConfig$1$1(UpdateTask r10, Continuation<? super UpdateTask$onNewConfig$1$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UpdateTask$onNewConfig$1$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super UpdateResult> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super UpdateResult> r11) {
        return ((UpdateTask$onNewConfig$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r13 = Result.m32constructorimpl(Boxing.boxBoolean(((Boolean) r10).booleanValue()));     // Catch: Throwable -> L15
    L17:
        UpdateTask r14 = this.this$0;
        Throwable r15 = Result.m35exceptionOrNullimpl(r13);
        if (r15 == null) goto L20;
        String r16 = "update " + UpdateTask.f(r14) + " failed " + r14.H() + ": " + ExceptionsKt.stackTraceToString(r15);
        com.obric.aikernel.runtime.utils.d.f5417a.f("PackageUpdater", r16);
        p.c(r14.H(), CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r16);
    L20:
        UpdateTask r17 = this.this$0;
        if (Result.m39isSuccessimpl(r13) == true) goto L23;
    L28:
        UpdateResult r18 = this.this$0.H();
        UpdateTask r19 = this.this$0;
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "update " + UpdateTask.f(r19) + " finished with " + r18);
        return r18;
    L23:
        if (((Boolean) r13).booleanValue() == false) goto L26;
        r17.H().success("update succeed");
        r17.H().setStage(500);
        goto L28
    L26:
        if (p.c(r17.H(), "update", "doUpdate returned false without terminal failure") == false) goto L28;
        com.obric.aikernel.runtime.utils.d.f5417a.f("PackageUpdater", "update " + UpdateTask.f(r17) + " returned false without terminal failure: " + r17.H());
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        UpdateTask r20 = this.this$0;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r10 = r20.D(this);     // Catch: Throwable -> L15
        if (r10 != r11) goto L13;
        return r11;
    L15:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
