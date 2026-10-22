package com.larus.dora.obric.device_management.device_home;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$load$1$cachedDiaryData$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricDeviceHomeViewModel$load$1$cachedDiaryData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $accountId;
    int label;
    final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

    public DoraObricDeviceHomeViewModel$load$1$cachedDiaryData$1(DoraObricDeviceHomeViewModel r1, String r2, Continuation<? super DoraObricDeviceHomeViewModel$load$1$cachedDiaryData$1> r3) {
        this.this$0 = r1;
        this.$accountId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricDeviceHomeViewModel$load$1$cachedDiaryData$1(this.this$0, this.$accountId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        DoraObricDeviceHomeUsageRepository r3 = DoraObricDeviceHomeViewModel.access$getUsageRepository$p(this.this$0);
        String r0 = this.$accountId;
        r3.getClass();
        return DoraObricDeviceHomeUsageRepository.a(r0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
