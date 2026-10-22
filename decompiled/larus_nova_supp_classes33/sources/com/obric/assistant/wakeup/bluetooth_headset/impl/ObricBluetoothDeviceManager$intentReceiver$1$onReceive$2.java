package com.obric.assistant.wakeup.bluetooth_headset.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceConnectState;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import tha.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$intentReceiver$1$onReceive$2", f = "ObricBluetoothDeviceManager.kt", i = {}, l = {228, 245}, m = "invokeSuspend", n = {}, s = {})
public final class ObricBluetoothDeviceManager$intentReceiver$1$onReceive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricBluetoothDeviceManager$intentReceiver$1$onReceive$2(Continuation<? super ObricBluetoothDeviceManager$intentReceiver$1$onReceive$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricBluetoothDeviceManager$intentReceiver$1$onReceive$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L43:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        FLogger r9 = FLogger.a;
        r9.i("Obric-BluetoothDeviceManager", "check again A, alc disconnected recheck again ... a2dp: " + ObricBluetoothDeviceManager.h + " hfp: " + ObricBluetoothDeviceManager.g);
        if (ObricBluetoothDeviceManager.h != null) goto L43;
        if (ObricBluetoothDeviceManager.g != null) goto L43;
        IBluetoothHeadSetAPI r2 = c.a();
        if (r2 != null) goto L20;
    L22:
        boolean r4 = false;
    L23:
        IBluetoothHeadSetAPI r6 = c.a();
        if (r6 != null) goto L26;
    L28:
        r3 = false;
    L29:
        r9.i("Obric-BluetoothDeviceManager", "check again B , each profile connect state result is a2dp " + r4 + " hfp " + r3 + ' ');
        if (r4 == true) goto L32;
        if (r3 == false) goto L43;
    L32:
        if (r3 == false) goto L34;
        String r5 = "hfp";
    L35:
        ObricBluetoothDeviceManager.c(r5);
        r9.i("Obric-BluetoothDeviceManager", "check again C ,after all device disconnect, device is hfp " + ObricBluetoothDeviceManager.g + " a2dp " + ObricBluetoothDeviceManager.h + " , if any is not-null , send connected state");
        if (ObricBluetoothDeviceManager.g == null) goto L38;
    L39:
        StateFlowImpl r10 = ObricBluetoothDeviceManager.l;
        BlueDeviceConnectState r7 = BlueDeviceConnectState.CONNECTED;
        this.label = 2;
        r10.setValue(r7);
        if (Unit.INSTANCE != r0) goto L43;
        return r0;
    L38:
        if (ObricBluetoothDeviceManager.h == null) goto L43;
    L34:
        r5 = "a2dp";
        goto L35
    L26:
        if (r6.a() != true) goto L28;
    L20:
        if (r2.h() != true) goto L22;
        r4 = true;
        goto L23
    L10:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L13;
        return r0;
    }
}
