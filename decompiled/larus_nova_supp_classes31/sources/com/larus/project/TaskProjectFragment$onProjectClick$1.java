package com.larus.project;

import android.content.Context;
import com.larus.bmhome.taskskill.l2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.utils.j0;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.TaskProjectFragment$onProjectClick$1", f = "TaskProjectFragment.kt", i = {}, l = {640}, m = "invokeSuspend", n = {}, s = {})
final class TaskProjectFragment$onProjectClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ i $project;
    int label;
    final /* synthetic */ TaskProjectFragment this$0;

    public TaskProjectFragment$onProjectClick$1(TaskProjectFragment r1, i r2, String r3, Continuation<? super TaskProjectFragment$onProjectClick$1> r4) {
        this.this$0 = r1;
        this.$project = r2;
        this.$deviceId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new TaskProjectFragment$onProjectClick$1(this.this$0, this.$project, this.$deviceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L41
    L13:
        AllDeviceResponse r9 = (AllDeviceResponse) r8;     // Catch: Throwable -> L41
        Object r3 = null;
        if (r9 == null) goto L16;
        List r10 = r9.getDevices();     // Catch: Throwable -> L41
    L17:
        if (r10 != null) goto L19;
        r10 = CollectionsKt.emptyList();     // Catch: Throwable -> L41
    L19:
        String r4 = this.$deviceId;     // Catch: Throwable -> L41
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L41
    L21:
        if (r11.hasNext() == false) goto L36;
        Object r5 = r11.next();     // Catch: Throwable -> L41
        PcDevice r6 = (PcDevice) r5;     // Catch: Throwable -> L41
        if (r6 == null) goto L25;
        String r7 = r6.getDeviceId();     // Catch: Throwable -> L41
    L27:
        if (Intrinsics.areEqual(r7, r4) == false) goto L33;
        if (r6 == null) goto L30;
        boolean r12 = Intrinsics.areEqual(r6.r(), Boxing.boxBoolean(true));     // Catch: Throwable -> L41
    L31:
        if (r12 == false) goto L33;
        boolean r13 = true;
    L34:
        if (r13 == false) goto L21;
        r3 = r5;
        goto L36
    L30:
        r12 = false;
    L33:
        r13 = false;
        goto L34
    L25:
        r7 = null;
    L36:
        PcDevice r14 = (PcDevice) r3;     // Catch: Throwable -> L41
        if (r14 != null) goto L46;
        TaskProjectFragment r15 = this.this$0;     // Catch: Throwable -> L41
        int r16 = TaskProjectFragment.w;     // Catch: Throwable -> L41
        Context r17 = r15.getContext();     // Catch: Throwable -> L41
        if (r17 == null) goto L43;
        t19.s.a.getClass();     // Catch: Throwable -> L41
        t19.s.s(r17, 2131906239);     // Catch: Throwable -> L41
    L43:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L41
        this.this$0.m = false;
        return r18;
    L46:
        List r19 = l2.a;     // Catch: Throwable -> L41
        Context r20 = this.this$0.getContext();     // Catch: Throwable -> L41
        if (l2.b(r14.o()) == false) goto L50;
    L54:
        if (r2 == true) goto L58;
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L41
        this.this$0.m = false;
        return r21;
    L58:
        TaskProjectFragment r22 = this.this$0;     // Catch: Throwable -> L41
        i r23 = this.$project;     // Catch: Throwable -> L41
        String r24 = r14.d();     // Catch: Throwable -> L41
        String r25 = r14.e();     // Catch: Throwable -> L41
        int r26 = TaskProjectFragment.w;     // Catch: Throwable -> L41
        r22.aa0(r23, r24, r25);     // Catch: Throwable -> L41
        this.this$0.m = false;
        return Unit.INSTANCE;
    L50:
        if (AppHost.a.isOversea() == false) goto L52;
        int r27 = 2131906237;
    L53:
        t19.s r28 = t19.s.a;     // Catch: Throwable -> L41
        int r29 = j0.a;     // Catch: Throwable -> L41
        String r30 = j0.d(r27);     // Catch: Throwable -> L41
        r28.getClass();     // Catch: Throwable -> L41
        t19.s.t(r20, r30);     // Catch: Throwable -> L41
        r2 = false;
        goto L54
    L52:
        r27 = 2131906236;
        goto L53
    L16:
        r10 = null;
        goto L17
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        GetAllDevicesRepo r31 = GetAllDevicesRepo.a;     // Catch: Throwable -> L41
        this.label = 1;     // Catch: Throwable -> L41
        r8 = GetAllDevicesRepo.e("TaskProjectFragment.onProjectClick", this);     // Catch: Throwable -> L41
        if (r8 != r0) goto L13;
        return r0;
    L41:
        th = move-exception;
        this.this$0.m = false;
        throw th;
    }
}
