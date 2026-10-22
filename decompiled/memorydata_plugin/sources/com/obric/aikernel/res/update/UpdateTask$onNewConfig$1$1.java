package com.obric.aikernel.res.update;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/res/update/UpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask$onNewConfig$1$1", f = "UpdateTask.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
final class UpdateTask$onNewConfig$1$1 extends SuspendLambda implements Function2<al, Continuation<? super UpdateResult>, Object> {
    int label;
    final /* synthetic */ s this$0;

    UpdateTask$onNewConfig$1$1(s r3, Continuation<? super UpdateTask$onNewConfig$1$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new UpdateTask$onNewConfig$1$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super UpdateResult> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super UpdateResult> r4) {
        return ((UpdateTask$onNewConfig$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), UpdateTask$onNewConfig$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L13:
        Object r9 = Result.m1421constructorimpl(Boxing.boxBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue()));     // Catch: Throwable -> L15
    L17:
        s r2 = this.this$0;
        Throwable r3 = Result.m1424exceptionOrNullimpl(r9);
        if (r3 == null) goto L20;
        String r4 = "update " + s.d(r2) + " failed " + r2.a() + ": " + ExceptionsKt.stackTraceToString(r3);
        com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", r4);
        t.a(r2.a(), CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r4);
    L20:
        s r5 = this.this$0;
        if (Result.m1428isSuccessimpl(r9) == true) goto L23;
    L28:
        UpdateResult r10 = this.this$0.a();
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "update " + s.d(this.this$0) + " finished with " + r10);
        return r10;
    L23:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L26;
        r5.a().success("update succeed");
        r5.a().setStage(500);
        goto L28
    L26:
        if (t.a(r5.a(), BuildConfig.CHANNEL, "doUpdate returned false without terminal failure") == false) goto L28;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", "update " + s.d(r5) + " returned false without terminal failure: " + r5.a());
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        s r11 = this.this$0;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r8 = r11.b(this);     // Catch: Throwable -> L15
        if (r8 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
