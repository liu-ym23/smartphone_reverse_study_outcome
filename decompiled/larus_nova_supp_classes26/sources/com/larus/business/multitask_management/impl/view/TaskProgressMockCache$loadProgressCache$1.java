package com.larus.business.multitask_management.impl.view;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import nuc.a1;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.view.TaskProgressMockCache$loadProgressCache$1", f = "TaskProgressBarUpdateStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TaskProgressMockCache$loadProgressCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public TaskProgressMockCache$loadProgressCache$1(Continuation<? super TaskProgressMockCache$loadProgressCache$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        TaskProgressMockCache$loadProgressCache$1 r0 = new TaskProgressMockCache$loadProgressCache$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.larus.business.multitask_management.impl.view.d0] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L54;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        wt7.c r11 = wt7.a.a;     // Catch: Throwable -> L7
        String r0 = ((gd9.z) TaskProgressMockCache.a.getValue()).a("multitask_progress_progress_cache", "", "keva_repo_multitask");     // Catch: Throwable -> L7
        kuc.a.f(StringCompanionObject.INSTANCE);     // Catch: Throwable -> L7
        v2 r1 = v2.a;     // Catch: Throwable -> L7
        kuc.a.e(IntCompanionObject.INSTANCE);     // Catch: Throwable -> L7
        a1 r2 = kuc.a.c(r1, w0.a);     // Catch: Throwable -> L7
        r11.getClass();     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl((Map) wt7.c.a(r0, r2));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r12);
        if (r3 == null) goto L13;
        FLogger.a.e("multitask-TaskProgressMockCache", "loadProgressCache failed: " + r3.getMessage());
        r12 = MapsKt.emptyMap();
    L13:
        final Map r13 = (Map) r12;
        if (r13 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L51;
        il9.a r5 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r5 == null) goto L29;
        List r6 = r5.J(new d0(r13));
        if (r6 == null) goto L29;
        List r7 = r6;
        ?? r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r15 = r7.iterator();
    L27:
        if (r15.hasNext() == false) goto L30;
        r14.add(((kl9.u) r15.next()).a);
    L30:
        TaskProgressMockCache$map$1 r16 = TaskProgressMockCache.f;
        monitor-enter(r16);
        LinkedHashMap r17 = new LinkedHashMap();     // Catch: Throwable -> L48
        Iterator r18 = r13.entrySet().iterator();     // Catch: Throwable -> L48
    L34:
        if (r18.hasNext() == false) goto L38;
        Map.Entry r19 = (Map.Entry) r18.next();     // Catch: Throwable -> L48
        if (r14.contains(r19.getKey()) == false) goto L34;
        r17.put(r19.getKey(), r19.getValue());     // Catch: Throwable -> L48
        goto L34
    L38:
        Iterator r20 = r17.entrySet().iterator();     // Catch: Throwable -> L48
    L40:
        if (r20.hasNext() == false) goto L45;
        Map.Entry r21 = (Map.Entry) r20.next();     // Catch: Throwable -> L48
        String r22 = (String) r21.getKey();     // Catch: Throwable -> L48
        int r23 = ((Number) r21.getValue()).intValue();     // Catch: Throwable -> L48
        TaskProgressMockCache$map$1 r24 = TaskProgressMockCache.f;     // Catch: Throwable -> L48
        a0 r25 = (a0) r24.get(r22);     // Catch: Throwable -> L48
        if (r25 != null) goto L44;
        r25 = new a0();     // Catch: Throwable -> L48
        r24.put(r22, r25);     // Catch: Throwable -> L48
    L44:
        r25.a = RangesKt.coerceIn(Math.max(r25.a, r23), 0, 500);     // Catch: Throwable -> L48
        goto L40
    L45:
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L48
        monitor-exit(r16);
    L48:
        th = move-exception;
        throw th;
    L29:
        r14 = CollectionsKt.emptyList();
    L51:
        TaskProgressMockCache.e.setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L16:
        if (r13.isEmpty() == true) goto L19;
        r4 = false;
    L7:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L54:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
