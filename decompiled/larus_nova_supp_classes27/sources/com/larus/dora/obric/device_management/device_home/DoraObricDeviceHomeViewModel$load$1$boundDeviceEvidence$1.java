package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.device.DoraDevice;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeUsageEvidence;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$load$1$boundDeviceEvidence$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeViewModel$load$1$boundDeviceEvidence$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super s1>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ List<DoraDevice> $rawBindList;
    int label;
    final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

    public DoraObricDeviceHomeViewModel$load$1$boundDeviceEvidence$1(DoraObricDeviceHomeViewModel r1, String r2, List<? extends DoraDevice> r3, Continuation<? super DoraObricDeviceHomeViewModel$load$1$boundDeviceEvidence$1> r4) {
        this.this$0 = r1;
        this.$accountId = r2;
        this.$rawBindList = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricDeviceHomeViewModel$load$1$boundDeviceEvidence$1(this.this$0, this.$accountId, this.$rawBindList, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super s1> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        DoraObricDeviceHomeUsageRepository r4 = DoraObricDeviceHomeViewModel.access$getUsageRepository$p(this.this$0);
        String r0 = this.$accountId;
        List<DoraDevice> r1 = this.$rawBindList;
        r4.getClass();
        return DoraObricDeviceHomeUsageRepository.b(r0, r1);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
