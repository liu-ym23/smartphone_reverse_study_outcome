package com.larus.business.multitask_management.impl.view;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import nuc.a1;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.view.TaskProgressMockCache$saveProgressCache$1", f = "TaskProgressBarUpdateStrategy.kt", i = {0}, l = {106}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class TaskProgressMockCache$saveProgressCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public TaskProgressMockCache$saveProgressCache$1(Continuation<? super TaskProgressMockCache$saveProgressCache$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        TaskProgressMockCache$saveProgressCache$1 r0 = new TaskProgressMockCache$saveProgressCache$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = "";
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L28:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        wt7.c r8 = wt7.a.a;     // Catch: Throwable -> L20
        TaskProgressMockCache$map$1 r4 = TaskProgressMockCache.f;     // Catch: Throwable -> L20
        LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));     // Catch: Throwable -> L20
        Iterator<T> r9 = r4.entrySet().iterator();     // Catch: Throwable -> L20
    L13:
        if (r9.hasNext() == false) goto L15;
        Object r10 = r9.next();     // Catch: Throwable -> L20
        r5.put(((Map.Entry) r10).getKey(), Boxing.boxInt(((a0) ((Map.Entry) r10).getValue()).a));     // Catch: Throwable -> L20
        goto L13
    L15:
        kuc.a.f(StringCompanionObject.INSTANCE);     // Catch: Throwable -> L20
        v2 r11 = v2.a;     // Catch: Throwable -> L20
        kuc.a.e(IntCompanionObject.INSTANCE);     // Catch: Throwable -> L20
        a1 r12 = kuc.a.c(r11, w0.a);     // Catch: Throwable -> L20
        r8.getClass();     // Catch: Throwable -> L20
        String r13 = wt7.c.b(r5, r12);     // Catch: Throwable -> L20
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L20
    L22:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 != null) goto L25;
        r0 = r14;
    L26:
        ((gd9.z) TaskProgressMockCache.a.getValue()).k("multitask_progress_progress_cache", (String) r0, "keva_repo_multitask");
        TaskProgressMockCache.c = null;
        return Unit.INSTANCE;
    L25:
        FLogger.a.e("multitask-TaskProgressMockCache", "saveProgressCache failed: " + r15.getMessage());
    L20:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.L$0 = (CoroutineScope) this.L$0;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r1) goto L28;
        return r1;
    }
}
