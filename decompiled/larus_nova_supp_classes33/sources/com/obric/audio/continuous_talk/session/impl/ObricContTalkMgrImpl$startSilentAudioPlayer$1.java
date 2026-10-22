package com.obric.audio.continuous_talk.session.impl;

import android.media.AudioTrack;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.ObricContTalkMgrImpl$startSilentAudioPlayer$1", f = "ObricContTalkMgrImpl.kt", i = {0}, l = {194}, m = "invokeSuspend", n = {"silentBuffer"}, s = {"L$0"})
final class ObricContTalkMgrImpl$startSilentAudioPlayer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ObricContTalkMgrImpl this$0;

    public ObricContTalkMgrImpl$startSilentAudioPlayer$1(ObricContTalkMgrImpl r1, Continuation<? super ObricContTalkMgrImpl$startSilentAudioPlayer$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContTalkMgrImpl$startSilentAudioPlayer$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        byte[] r2 = (byte[]) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L28 CancellationException -> L33
    L13:
    L37:
        if (this.this$0.z == false) goto L32;
        q r3 = this.this$0.x;     // Catch: Throwable -> L24 CancellationException -> L26
        if (r3 == null) goto L21;
        int r4 = r2.length;     // Catch: Throwable -> L24 CancellationException -> L26
        Intrinsics.checkNotNullParameter(r2, "data");     // Catch: Throwable -> L24 CancellationException -> L26
        AudioTrack r5 = r3.b;     // Catch: Throwable -> L24 CancellationException -> L26
        if (r5 == null) goto L21;
        r5.write(r2, 0, r4);     // Catch: Throwable -> L24 CancellationException -> L26
    L21:
        this.L$0 = r2;     // Catch: Throwable -> L24 CancellationException -> L26
        this.label = 1;     // Catch: Throwable -> L24 CancellationException -> L26
        if (DelayKt.delay(20, this) != r0) goto L37;
        return r0;
    L32:
        return Unit.INSTANCE;
    L26:
        e = move-exception;
        ObricContTalkMgrImpl$startSilentAudioPlayer$1 r6 = this;
        e = e;
    L35:
        com.larus.audio.call.util.e.a.i(r6.this$0.v, "silent audio writer canceled");
        throw e;
    L24:
        th = move-exception;
        ObricContTalkMgrImpl$startSilentAudioPlayer$1 r7 = this;
        th = th;
    L30:
        com.larus.audio.call.util.e.a.e(r7.this$0.v, "silent audio writer crashed: " + th);
        r7.this$0.X();
        goto L32
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
        r2 = new byte[this.this$0.A];     // Catch: Throwable -> L28 CancellationException -> L33
    L33:
        e = e;
        r6 = this;
    L28:
        th = th;
        r7 = this;
        goto L30
    }
}
