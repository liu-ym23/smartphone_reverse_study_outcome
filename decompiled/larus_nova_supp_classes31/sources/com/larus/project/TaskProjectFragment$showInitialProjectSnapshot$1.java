package com.larus.project;

import android.content.Context;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.TaskProjectFragment$showInitialProjectSnapshot$1", f = "TaskProjectFragment.kt", i = {0, 0, 0}, l = {438}, m = "invokeSuspend", n = {"snapshot", "loadFailed", "previousItemCount"}, s = {"L$0", "I$0", "I$1"})
final class TaskProjectFragment$showInitialProjectSnapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IProjectListDataSource $dataSource;
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ TaskProjectFragment this$0;

    public TaskProjectFragment$showInitialProjectSnapshot$1(IProjectListDataSource r1, TaskProjectFragment r2, Continuation<? super TaskProjectFragment$showInitialProjectSnapshot$1> r3) {
        this.$dataSource = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TaskProjectFragment$showInitialProjectSnapshot$1(this.$dataSource, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x009d -> B:35:0x00a4). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r3 = this.I$1;
        int r4 = this.I$0;
        com.larus.bmhome.taskskill.service.i r5 = (com.larus.bmhome.taskskill.service.i) this.L$0;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
        com.larus.bmhome.taskskill.service.i r6 = r5;
        int r7 = r4;
        int r8 = r3;
        Object r9 = r0;
        TaskProjectFragment$showInitialProjectSnapshot$1 r10 = this;
    L36:
        if (Result.isFailure-impl(r12) == false) goto L38;
        FLogger.a.e("TaskProjectFragment", "load initial project list failed", Result.exceptionOrNull-impl(r12));
        com.larus.bmhome.taskskill.service.i r13 = r6;
    L43:
        TaskProjectFragment$showInitialProjectSnapshot$1 r14 = r10;
        int r15 = 1;
    L45:
        r14.this$0.l = false;
        if (r15 != 0) goto L48;
    L51:
        TaskProjectFragment r16 = r14.this$0;
        if (r15 != 0) goto L54;
        r2 = true;
    L54:
        TaskProjectFragment.X90(r16, r13, true, r2);
        if (r15 == 0) goto L60;
        Context r17 = r14.this$0.getContext();
        if (r17 == null) goto L60;
        t19.s r18 = t19.s.a;
        String r19 = r17.getString(2131906830);
        r18.getClass();
        t19.s.t(r17, r19);
    L60:
        return Unit.INSTANCE;
    L48:
        if (r13.a.isEmpty() == false) goto L51;
        r14.this$0.ca0();
        return Unit.INSTANCE;
    L38:
        ResultKt.throwOnFailure(r12);
        com.larus.bmhome.taskskill.service.i r110 = (com.larus.bmhome.taskskill.service.i) r12;
        if (r110.b == true) goto L41;
    L44:
        r15 = r7;
        r13 = r110;
        r14 = r10;
        r0 = r9;
    L10:
        if (r13.b == false) goto L45;
        TaskProjectFragment r20 = r14.this$0;
        int r21 = TaskProjectFragment.w;
        r20.getClass();
        List r22 = r13.a;
        if ((r22 instanceof Collection) == true) goto L14;
    L16:
        Iterator r23 = r22.iterator();
        int r24 = 0;
    L18:
        if (r23.hasNext() == false) goto L30;
        i r25 = x.a(((com.larus.bmhome.taskskill.service.h) r23.next()).a);
        if (r25 != null) goto L22;
    L24:
        boolean r26 = false;
    L25:
        if (r26 == false) goto L18;
        r24 = r24 + 1;
        if (r24 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
        goto L18
    L22:
        if (r20.ba0(r25) != true) goto L24;
        r26 = true;
    L30:
        if (r24 >= 20) goto L45;
        int r27 = r13.a.size();
        IProjectListDataSource r28 = r14.$dataSource;
        r14.L$0 = r13;
        r14.I$0 = r15;
        r14.I$1 = r27;
        r14.label = 1;
        Object r29 = r28.d(r14);
        if (r29 != r0) goto L34;
        return r0;
    L34:
        Object r30 = r0;
        r10 = r14;
        r12 = r29;
        r6 = r13;
        r7 = r15;
        r8 = r27;
        r9 = r30;
        goto L36
    L14:
        if (r22.isEmpty() == false) goto L16;
        r24 = 0;
        goto L30
    L41:
        if (r110.a.size() > r8) goto L44;
        FLogger.a.w("TaskProjectFragment", "initial project list load made no progress");
        r13 = r110;
        goto L43
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r13 = this.$dataSource.getList();
        r15 = 0;
        r14 = this;
        goto L10
    }
}
