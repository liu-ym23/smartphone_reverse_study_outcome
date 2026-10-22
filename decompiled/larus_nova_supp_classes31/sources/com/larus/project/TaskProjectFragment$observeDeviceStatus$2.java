package com.larus.project;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.project.TaskProjectFragment$observeDeviceStatus$2", f = "TaskProjectFragment.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
final class TaskProjectFragment$observeDeviceStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TaskProjectFragment this$0;

    public TaskProjectFragment$observeDeviceStatus$2(TaskProjectFragment r1, Continuation<? super TaskProjectFragment$observeDeviceStatus$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TaskProjectFragment$observeDeviceStatus$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        AllDeviceResponse r5 = (AllDeviceResponse) r4;
        TaskProjectFragment r2 = this.this$0;
        if (r5 == null) goto L14;
        List<PcDevice> r6 = r5.getDevices();
    L15:
        if (r6 != null) goto L17;
        r6 = CollectionsKt.emptyList();
    L17:
        int r3 = TaskProjectFragment.w;
        r2.fa0(r6);
        return Unit.INSTANCE;
    L14:
        r6 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        GetAllDevicesRepo r7 = GetAllDevicesRepo.a;
        this.label = 1;
        r4 = GetAllDevicesRepo.e("TaskProjectFragment.observeDeviceStatus", this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
