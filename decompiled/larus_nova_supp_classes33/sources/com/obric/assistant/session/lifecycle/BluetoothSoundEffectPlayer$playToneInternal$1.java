package com.obric.assistant.session.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.lifecycle.BluetoothSoundEffectPlayer", f = "BaseSessionLifecycleImpl.kt", i = {}, l = {205, 207}, m = "playToneInternal", n = {}, s = {})
final class BluetoothSoundEffectPlayer$playToneInternal$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BluetoothSoundEffectPlayer this$0;

    public BluetoothSoundEffectPlayer$playToneInternal$1(BluetoothSoundEffectPlayer r1, Continuation<? super BluetoothSoundEffectPlayer$playToneInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BluetoothSoundEffectPlayer.d(this.this$0, this);
    }
}
