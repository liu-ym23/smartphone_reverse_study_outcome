package com.obric.assistant.component;

import com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.audio.tts.IObricChainTtsService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricAppeaseComponent$startPlayAppease$2", f = "ObricAppeaseComponent.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
final class ObricAppeaseComponent$startPlayAppease$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricAppeaseComponent this$0;

    public ObricAppeaseComponent$startPlayAppease$2(ObricAppeaseComponent r1, Continuation<? super ObricAppeaseComponent$startPlayAppease$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricAppeaseComponent$startPlayAppease$2(this.this$0, r3);
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
    L12:
        if (ObricAppeaseComponent.h3(this.this$0, "stopJob") == true) goto L14;
        AudioSoundAppeaseManager r8 = this.this$0.B3();
        int r2 = AudioSoundAppeaseManager.i;
        r8.h(false, null);
        ObricAppeaseComponent r9 = this.this$0;
        r9.getClass();
        FLogger r3 = FLogger.a;
        r3.i("ObricAppeaseComponent", "playAppeaseText");
        String[] r4 = r9.t;
        String r5 = r4[Random.Default.nextInt(r4.length)];
        if (com.larus.platform.service.z2.a.enableObricIndependentTts() == false) goto L24;
        IObricChainTtsService.a.getClass();
        IObricChainTtsService r6 = IObricChainTtsService.a.a();
        if (r6 != null) goto L20;
        r3.e("ObricAppeaseComponent", "playAppeaseText: IObricTtsClientService not available, fallback to IM tts client");
        Intrinsics.checkNotNull(r5);
        r9.z3(r5);
    L21:
        IDoraWakeupService r10 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r10 == null) goto L28;
        r10.j(false);
    L28:
        return Unit.INSTANCE;
    L20:
        r3.i("ObricAppeaseComponent", "playAppeaseText: invoke IObricTtsClientService.startByText");
        Intrinsics.checkNotNull(r5);
        r6.a(r5, r9.C3(), "appease_tts_message", false);
        goto L21
    L24:
        Intrinsics.checkNotNull(r5);
        r9.z3(r5);
        IDoraWakeupService r11 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r11 == null) goto L28;
        r11.j(false);
        goto L28
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("ObricAppeaseComponent", "stop job, executing...");
        this.label = 1;
        if (DelayKt.delay(12192, this) != r0) goto L12;
        return r0;
    }
}
