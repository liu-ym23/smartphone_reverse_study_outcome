package com.larus.dora.impl.device.manage.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/dora/device/DoraDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$selectedDevice$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$selectedDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraDevice>, Object> {
    int label;
    final /* synthetic */ DoraGDeviceManagementViewModel this$0;

    public DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$selectedDevice$1(DoraGDeviceManagementViewModel r1, Continuation<? super DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$selectedDevice$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$selectedDevice$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super DoraDevice> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        List r6 = DoraAdapterExtKt.k(kj4.a.g());
        g49.d.d(DoraGDeviceManagementViewModel.TAG, "fetchLatestCardContentInternal: bindList size=" + r6.size() + ", currentDeviceMac=" + DoraGDeviceManagementViewModel.access$getCurrentDeviceMac$p(this.this$0));
        DoraGDeviceManagementViewModel r0 = this.this$0;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((DoraDevice) r1).mac, DoraGDeviceManagementViewModel.access$getCurrentDeviceMac$p(r0)) == false) goto L6;
        return r1;
    L10:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
