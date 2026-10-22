package com.larus.bmhome.taskskill.ui;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.network.PcDeviceRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.ui.PcDevicePanelFragment$loadDevices$1$result$1", f = "PcDevicePanelFragment.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
public final class PcDevicePanelFragment$loadDevices$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends PcDevice>>>, Object> {
    int label;

    public PcDevicePanelFragment$loadDevices$1$result$1(Continuation<? super PcDevicePanelFragment$loadDevices$1$result$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PcDevicePanelFragment$loadDevices$1$result$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends List<PcDevice>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((Result) r4).unbox-impl();
    L12:
        return Result.box-impl(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        PcDeviceRepository r6 = PcDeviceRepository.a;
        this.label = 1;
        r5 = r6.b(this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
