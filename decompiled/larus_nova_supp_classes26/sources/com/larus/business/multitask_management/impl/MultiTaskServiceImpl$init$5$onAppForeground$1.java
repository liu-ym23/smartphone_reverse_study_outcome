package com.larus.business.multitask_management.impl;

import com.larus.multitask_management.api.PullType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.MultiTaskServiceImpl$init$5$onAppForeground$1", f = "MultiTaskServiceImpl.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
public final class MultiTaskServiceImpl$init$5$onAppForeground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiTaskServiceImpl this$0;

    public MultiTaskServiceImpl$init$5$onAppForeground$1(MultiTaskServiceImpl r1, Continuation<? super MultiTaskServiceImpl$init$5$onAppForeground$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MultiTaskServiceImpl$init$5$onAppForeground$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L13:
        List r6 = (List) r5;
    L14:
        il9.a r7 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r7 == null) goto L23;
        StateFlowImpl r8 = r7.I0();
        if (r8 == null) goto L23;
        List r9 = (List) r8.getValue();
        if (r9 == null) goto L23;
        if ((!r9.isEmpty()) != true) goto L23;
        r2 = true;
    L23:
        if (r2 == false) goto L26;
        this.this$0.e();
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        il9.a r10 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r10 == null) goto L14;
        PullType r3 = PullType.ADDITIONAL;
        this.label = 1;
        r5 = r10.p2(false, true, r3, this);
        if (r5 != r0) goto L13;
        return r0;
    }
}
