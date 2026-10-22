package com.larus.dora.impl.device_v2;

import java.util.Map;
import kotlin.Lazy;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/impl/device_v2/DoraSmartDeviceBindFragment$DslHBindDevicePage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device_v2.DoraSmartDeviceBindFragment$setupPage$1$1$pageConfig$1", f = "DoraSmartDeviceBindFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSmartDeviceBindFragment$setupPage$1$1$pageConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraSmartDeviceBindFragment.b>, Object> {
    final /* synthetic */ c59.c0 $pageInfo;
    int label;

    public DoraSmartDeviceBindFragment$setupPage$1$1$pageConfig$1(c59.c0 r1, Continuation<? super DoraSmartDeviceBindFragment$setupPage$1$1$pageConfig$1> r2) {
        this.$pageInfo = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraSmartDeviceBindFragment$setupPage$1$1$pageConfig$1(this.$pageInfo, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super DoraSmartDeviceBindFragment.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        Lazy r3 = c59.s.a;
        c59.i r4 = this.$pageInfo.a;
        if (r4 == null) goto L7;
        Map<String, Object> r5 = r4.b;
    L9:
        return c59.s.c(r5, DoraSmartDeviceBindFragment.b.class);
    L7:
        r5 = null;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
