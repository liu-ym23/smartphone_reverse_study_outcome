package com.larus.call_plugins_doubao_common.manager;

import android.content.Context;
import com.larus.audio.AudioServiceDelegate;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager$startPlay$1", f = "AudioSoundAppeaseManager.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
final class AudioSoundAppeaseManager$startPlay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AudioSoundAppeaseManager.a $listener;
    int label;
    final /* synthetic */ AudioSoundAppeaseManager this$0;

    public AudioSoundAppeaseManager$startPlay$1(AudioSoundAppeaseManager r1, Context r2, AudioSoundAppeaseManager.a r3, Continuation<? super AudioSoundAppeaseManager$startPlay$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AudioSoundAppeaseManager$startPlay$1(this.this$0, this.$context, null, r5);
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
        String r7 = (String) r6;
        if (r7.length() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L42;
        AudioSoundAppeaseManager r3 = this.this$0;
        if (r3.g == false) goto L20;
        FLogger.a.i("AudioSoundSoothingManager", "[realPlayAudio] playMusic cancelled due to shouldCancelPlay");
    L44:
        return Unit.INSTANCE;
    L20:
        if (Intrinsics.areEqual(r3.a, com.larus.call_plugins_doubao_common.b.b) == true) goto L22;
    L27:
        r3.f = true;
        IVideoController r4 = r3.d();
        if (r4 == null) goto L30;
        r4.setLocalURL(r7);
    L30:
        IVideoController r8 = r3.d();
        if (r8 == null) goto L33;
        r8.setLooping(r3.a.c);
    L33:
        IVideoController r9 = r3.d();
        if (r9 == null) goto L36;
        r9.w(r3.a.d);
    L36:
        IVideoController r10 = r3.d();
        if (r10 == null) goto L39;
        r10.p(new l(r3));
    L39:
        IVideoController r11 = r3.d();
        if (r11 == null) goto L44;
        r11.play();
        goto L44
    L22:
        if (AudioServiceDelegate.a.F().b() == true) goto L27;
        IVideoController r12 = r3.d();
        if (r12 == null) goto L26;
        r12.stop();
    L26:
        FLogger.a.e("AudioSoundSoothingManager", "[realPlayAudio] is not connect");
        goto L44
    L42:
        FLogger.a.e("AudioSoundSoothingManager", "[realPlayAudio] failure resolveAudioPath");
        goto L44
    L14:
        r2 = false;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FLogger.a.i("AudioSoundSoothingManager", "[playAudio] startPlay access focus");
        AudioSoundAppeaseManager r13 = this.this$0;
        Context r5 = this.$context;
        this.label = 1;
        r6 = AudioSoundAppeaseManager.a(r13, r5, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
