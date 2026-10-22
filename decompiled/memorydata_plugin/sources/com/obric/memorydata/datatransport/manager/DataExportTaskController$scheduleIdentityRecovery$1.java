package com.obric.memorydata.datatransport.manager;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.manager.DataExportTaskController$scheduleIdentityRecovery$1", f = "DataExportTaskController.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
final class DataExportTaskController$scheduleIdentityRecovery$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int label;

    DataExportTaskController$scheduleIdentityRecovery$1(Continuation<? super DataExportTaskController$scheduleIdentityRecovery$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new DataExportTaskController$scheduleIdentityRecovery$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DataExportTaskController$scheduleIdentityRecovery$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DataExportTaskController$scheduleIdentityRecovery$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0032 -> B:13:0x0035). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r4 = this.I$0;
        ResultKt.throwOnFailure(r8);
    L14:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L16;
    L20:
        r2 = r2 + 1;
    L9:
        if (r2 >= r4) goto L21;
        this.I$0 = r4;
        this.I$1 = r2;
        this.label = 1;
        if (au.a(500, this) != r0) goto L14;
        return r0;
    L21:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DataExportTask", "account identity is still unavailable; keep export snapshot hidden", null, 4, null);
    L19:
        return Unit.INSTANCE;
    L16:
        if (AppContext.INSTANCE.isLogin() == false) goto L20;
        c.f9761a.c();
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r2 = 0;
        r4 = 60;
        goto L9
    }
}
