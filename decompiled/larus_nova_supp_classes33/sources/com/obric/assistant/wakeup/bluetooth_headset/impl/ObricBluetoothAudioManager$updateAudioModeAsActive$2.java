package com.obric.assistant.wakeup.bluetooth_headset.impl;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothAudioManager$updateAudioModeAsActive$2", f = "ObricBluetoothAudioManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricBluetoothAudioManager$updateAudioModeAsActive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    int label;

    public ObricBluetoothAudioManager$updateAudioModeAsActive$2(Continuation<? super ObricBluetoothAudioManager$updateAudioModeAsActive$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricBluetoothAudioManager$updateAudioModeAsActive$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<Object> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r5);
        ObricBluetoothAudioManager r6 = ObricBluetoothAudioManager.a;
        int r7 = ObricBluetoothAudioManager.c();
        FLogger r0 = FLogger.a;
        r0.w("Obric-BluetoothAudioManager", "updateAudioModeAsActive getHeadsetStatus status is " + r7);
        if (r7 != 1) goto L7;
        r0.w("Obric-BluetoothAudioManager", "updateAudioModeAsActive HEADSET ON");
        if (ObricBluetoothAudioManager.c == true) goto L20;
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.HEADSET_PLUG");
        ObricBluetoothAudioManager.a(AppHost.a.getApplication(), ObricBluetoothAudioManager.k, r8);
        ObricBluetoothAudioManager.c = true;
    L20:
        return Unit.INSTANCE;
    L7:
        if (r7 == 2) goto L9;
        r0.w("Obric-BluetoothAudioManager", "updateAudioModeAsActive SPEAKER ON");
        return Unit.INSTANCE;
    L9:
        r0.w("Obric-BluetoothAudioManager", "updateAudioModeAsActive BLUETOOTH ON, start sco if necessary");
        Handler r9 = ObricBluetoothAudioManager.g;
        if (r9 == null) goto L12;
        r9.removeCallbacksAndMessages(null);
    L12:
        if (r9 == null) goto L25;
        return Boxing.boxBoolean(r9.sendMessageDelayed(Message.obtain(r9, 1), 0));
    L25:
        return null;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
