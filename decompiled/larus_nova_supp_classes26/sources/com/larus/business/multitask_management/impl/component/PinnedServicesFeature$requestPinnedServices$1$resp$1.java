package com.larus.business.multitask_management.impl.component;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ll9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/multitask_management/api/data/quick_access/PinResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.PinnedServicesFeature$requestPinnedServices$1$resp$1", f = "PinnedServicesFeature.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
public final class PinnedServicesFeature$requestPinnedServices$1$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super r>, Object> {
    final /* synthetic */ int $pageSize;
    int label;
    final /* synthetic */ PinnedServicesFeature this$0;

    public PinnedServicesFeature$requestPinnedServices$1$resp$1(PinnedServicesFeature r1, int r2, Continuation<? super PinnedServicesFeature$requestPinnedServices$1$resp$1> r3) {
        this.this$0 = r1;
        this.$pageSize = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PinnedServicesFeature$requestPinnedServices$1$resp$1(this.this$0, this.$pageSize, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super r> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L16:
        return (r) r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        il9.b r8 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r8 == null) goto L14;
        String r2 = this.this$0.h;
        ll9.h r3 = new ll9.h(Boxing.boxInt(this.$pageSize), r2, 4);
        this.label = 1;
        r7 = r8.R1(r3, this);
        if (r7 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
