package com.obric.assistant.wakeup.bluetooth_headset.impl;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothAudioManager$updateAudioModeAsDeactive$2", f = "ObricBluetoothAudioManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricBluetoothAudioManager$updateAudioModeAsDeactive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    int label;

    public ObricBluetoothAudioManager$updateAudioModeAsDeactive$2(Continuation<? super ObricBluetoothAudioManager$updateAudioModeAsDeactive$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricBluetoothAudioManager$updateAudioModeAsDeactive$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<Object> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r4);
        ObricBluetoothAudioManager r5 = ObricBluetoothAudioManager.a;
        int r6 = ObricBluetoothAudioManager.c();
        if (r6 != 1) goto L7;
        FLogger.a.w("Obric-BluetoothAudioManager", "updateAudioModeAsDeactive HEADSET ON, now close speaker");
    L19:
        th = move-exception;
        FLogger.a.w("Obric-BluetoothAudioManager", "unregisterHeadset error", th);
    L21:
        ObricBluetoothAudioManager.c = false;
    L23:
        return Unit.INSTANCE;
    L16:
        if (ObricBluetoothAudioManager.c == false) goto L21;
        ObricBluetoothAudioManager.b(AppHost.a.getApplication(), ObricBluetoothAudioManager.k);     // Catch: Throwable -> L19
        goto L21
    L7:
        if (r6 != 2) goto L23;
        FLogger.a.w("Obric-BluetoothAudioManager", "updateAudioModeAsDeactive BLUETOOTH ON , now stop sco");
        Handler r7 = ObricBluetoothAudioManager.g;
        if (r7 == null) goto L12;
        r7.removeCallbacksAndMessages(null);
    L12:
        if (r7 != null) goto L29;
        return null;
    L29:
        return Boxing.boxBoolean(r7.sendMessageDelayed(Message.obtain(r7, 2), 0));
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
