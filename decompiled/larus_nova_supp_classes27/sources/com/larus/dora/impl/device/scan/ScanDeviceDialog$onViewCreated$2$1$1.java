package com.larus.dora.impl.device.scan;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.DoraDeviceViewModel;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialog$onViewCreated$2$1$1", f = "ScanDeviceDialog.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
public final class ScanDeviceDialog$onViewCreated$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $scanDeviceModel;
    int label;
    final /* synthetic */ ScanDeviceDialog this$0;

    public ScanDeviceDialog$onViewCreated$2$1$1(ScanDeviceDialog r1, j r2, Continuation<? super ScanDeviceDialog$onViewCreated$2$1$1> r3) {
        this.this$0 = r1;
        this.$scanDeviceModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ScanDeviceDialog$onViewCreated$2$1$1(this.this$0, this.$scanDeviceModel, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        ScanDeviceDialog r7 = this.this$0;
        int r2 = ScanDeviceDialog.l;
        ((DoraDeviceViewModel) r7.d.getValue()).setSwitchingDevice(false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ScanDeviceDialog r8 = this.this$0;
        int r3 = ScanDeviceDialog.l;
        ((DoraDeviceViewModel) r8.d.getValue()).setSwitchingDevice(true);
        ScanDeviceDialog r9 = this.this$0;
        j r4 = this.$scanDeviceModel;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        DoraDevice r5 = new DoraDevice();
        r5.name = r4.b;
        r5.mac = r4.a;
        r5.sn = r4.c;
        r5.sku = r4.d;
        r5.type = r4.getType();
        this.label = 1;
        if (ScanDeviceDialog.S90(r9, r5, this) != r0) goto L11;
        return r0;
    }
}
