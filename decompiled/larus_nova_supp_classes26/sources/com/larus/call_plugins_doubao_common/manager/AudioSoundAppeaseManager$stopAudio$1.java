package com.larus.call_plugins_doubao_common.manager;

import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager$stopAudio$1", f = "AudioSoundAppeaseManager.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
public final class AudioSoundAppeaseManager$stopAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $currentTime;
    final /* synthetic */ long $minPlayingTime;
    final /* synthetic */ Function1<Boolean, Unit> $onStopCallback;
    int label;
    final /* synthetic */ AudioSoundAppeaseManager this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioSoundAppeaseManager$stopAudio$1(long r1, Object r3, AudioSoundAppeaseManager r4, Function1<? super Boolean, Unit> r5, Continuation<? super AudioSoundAppeaseManager$stopAudio$1> r6) {
        this.$minPlayingTime = r1;
        this.$currentTime = r3;
        this.this$0 = r4;
        this.$onStopCallback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AudioSoundAppeaseManager$stopAudio$1(this.$minPlayingTime, this.$currentTime, this.this$0, this.$onStopCallback, r9);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        FLogger.a.i("AudioSoundSoothingManager", "stopAudio delay currentTime: " + this.$currentTime);
        AudioSoundAppeaseManager r9 = this.this$0;
        int r2 = AudioSoundAppeaseManager.i;
        IVideoController r10 = r9.d();
        if (r10 == null) goto L14;
        r10.stop();
    L14:
        Function1<Boolean, Unit> r11 = this.$onStopCallback;
        if (r11 == null) goto L18;
        r11.invoke(Boxing.boxBoolean(false));
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        long r3 = this.$minPlayingTime - ((Number) this.$currentTime).longValue();
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L11;
        return r0;
    }
}
