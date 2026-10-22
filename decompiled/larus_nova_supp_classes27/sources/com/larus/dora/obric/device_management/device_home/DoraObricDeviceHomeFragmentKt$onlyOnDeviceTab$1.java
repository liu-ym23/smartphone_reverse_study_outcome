package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\b\u0010\u0002\u001a\u0004\u0018\u0001H\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "T", "value", "page", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeTabPage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeFragmentKt$onlyOnDeviceTab$1", f = "DoraObricDeviceHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricDeviceHomeFragmentKt$onlyOnDeviceTab$1 extends SuspendLambda implements Function3<Object, DoraObricDeviceHomeTabPage, Continuation<Object>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public DoraObricDeviceHomeFragmentKt$onlyOnDeviceTab$1(Continuation<? super DoraObricDeviceHomeFragmentKt$onlyOnDeviceTab$1> r2) {
        super(3, r2);
    }

    public final Object invoke(Object r2, DoraObricDeviceHomeTabPage r3, Continuation<Object> r4) {
        DoraObricDeviceHomeFragmentKt$onlyOnDeviceTab$1 r0 = new DoraObricDeviceHomeFragmentKt$onlyOnDeviceTab$1(r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(r1, (DoraObricDeviceHomeTabPage) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        Object r4 = this.L$0;
        if (((DoraObricDeviceHomeTabPage) this.L$1) != DoraObricDeviceHomeTabPage.DEVICE) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L14;
        return null;
    L14:
        return r4;
    L7:
        r0 = false;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
