package com.obric.assistant.wakeup.bluetooth_headset.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceConnectState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$intentReceiver$1$onReceive$1", f = "ObricBluetoothDeviceManager.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
public final class ObricBluetoothDeviceManager$intentReceiver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricBluetoothDeviceManager$intentReceiver$1$onReceive$1(Continuation<? super ObricBluetoothDeviceManager$intentReceiver$1$onReceive$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricBluetoothDeviceManager$intentReceiver$1$onReceive$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        FLogger.a.i("Obric-BluetoothDeviceManager", "alc disconnected send disconnect state END");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger r8 = FLogger.a;
        StringBuilder r2 = new StringBuilder("alc disconnected send DISCONNECTED state, current state is ");
        StateFlowImpl r4 = ObricBluetoothDeviceManager.l;
        r2.append(r4.getValue());
        r2.append(" , device is hfp ");
        r2.append(ObricBluetoothDeviceManager.g);
        r2.append(" a2dp ");
        r2.append(ObricBluetoothDeviceManager.h);
        r2.append(' ');
        r8.i("Obric-BluetoothDeviceManager", r2.toString());
        BlueDeviceConnectState r9 = BlueDeviceConnectState.DISCONNECTED;
        this.label = 1;
        r4.setValue(r9);
        if (Unit.INSTANCE != r0) goto L11;
        return r0;
    }
}
