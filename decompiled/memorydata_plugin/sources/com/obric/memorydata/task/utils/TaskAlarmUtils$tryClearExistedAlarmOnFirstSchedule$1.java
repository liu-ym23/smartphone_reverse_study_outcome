package com.obric.memorydata.task.utils;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.task.utils.TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1", f = "TaskAlarmUtils.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
final class TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1(Continuation<? super TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), TaskAlarmUtils$tryClearExistedAlarmOnFirstSchedule$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L10;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L7
    L23:
        b.b().a(Unit.INSTANCE);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r19);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getStringSet("ALARM_REQUEST_CODE_SET", SetsKt.emptySet()), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L7
    L14:
        if (r10.hasNext() == false) goto L20;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", "tryClearExistedAlarmOnFirstSchedule code: " + Integer.parseInt(r1), false, 4, null);     // Catch: Throwable -> L7 NumberFormatException -> L18
        b.b(b.f12969a, Integer.parseInt(r1));     // Catch: Throwable -> L7 NumberFormatException -> L18
    L18:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskAlarmUtils", ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);     // Catch: Throwable -> L7
        goto L14
    L20:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).saveStringSet("ALARM_REQUEST_CODE_SET", SetsKt.emptySet());     // Catch: Throwable -> L7
        Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (au.a(3000, r2) != r5) goto L23;
        return r5;
    L7:
        th = move-exception;
        b.b().a(Unit.INSTANCE);
        throw th;
    }
}
