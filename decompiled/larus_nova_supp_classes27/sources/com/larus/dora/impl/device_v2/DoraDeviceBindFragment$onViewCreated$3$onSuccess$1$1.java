package com.larus.dora.impl.device_v2;

import android.view.View;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device_v2.DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1", f = "DoraDeviceBindFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.c0 $pageInfo;
    int label;
    final /* synthetic */ DoraDeviceBindFragment this$0;

    public DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1(DoraDeviceBindFragment r1, c59.c0 r2, Continuation<? super DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1> r3) {
        this.this$0 = r1;
        this.$pageInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1(this.this$0, this.$pageInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        final DoraDeviceBindFragment r5 = this.this$0;
        final c59.c0 r0 = this.$pageInfo;
        DoraDeviceBindFragment.c r1 = r5.g;
        if (r1 == null) goto L10;
        View r2 = r1.getRoot();
        if (r2 == null) goto L10;
        r2.post(new i(r5, r0));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
