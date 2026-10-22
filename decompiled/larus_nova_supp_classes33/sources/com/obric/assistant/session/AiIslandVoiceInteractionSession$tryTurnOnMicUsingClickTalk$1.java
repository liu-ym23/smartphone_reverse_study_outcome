package com.obric.assistant.session;

import bga.f;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.session.model.IDoraOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.AiIslandVoiceInteractionSession$tryTurnOnMicUsingClickTalk$1", f = "AiIslandVoiceInteractionSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiIslandVoiceInteractionSession$tryTurnOnMicUsingClickTalk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AiIslandVoiceInteractionSession$tryTurnOnMicUsingClickTalk$1(Continuation<? super AiIslandVoiceInteractionSession$tryTurnOnMicUsingClickTalk$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AiIslandVoiceInteractionSession$tryTurnOnMicUsingClickTalk$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r5);
        IDoraOperation r6 = f.a();     // Catch: Exception -> L30
        if (r6 == null) goto L8;
        r6.e();     // Catch: Exception -> L30
    L8:
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L30
        if (r7 == null) goto L15;
        DeviceService r8 = r7.device();     // Catch: Exception -> L30
        if (r8 == null) goto L15;
        if (r8.n0("ota3p5") != true) goto L15;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L24;
        FLogger.a.i("AiIslandVoiceInteractionSession", "tryTurnOnMicUsingClickTalk, start VUI... with wakeMode SILENT_LAUNCH");     // Catch: Exception -> L30
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L30
        if (r10 == null) goto L23;
        SessionService r11 = r10.d();     // Catch: Exception -> L30
        if (r11 == null) goto L23;
        Boxing.boxInt(r11.o(5, 18));     // Catch: Exception -> L30
    L23:
        SoundEffectHelper.INSTANCE.playRelease();     // Catch: Exception -> L30
    L32:
        return Unit.INSTANCE;
    L24:
        FLogger.a.i("AiIslandVoiceInteractionSession", "tryTurnOnMicUsingClickTalk, start VUI... with wakeMode DEFAULT");     // Catch: Exception -> L30
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L30
        if (r12 == null) goto L32;
        SessionService r13 = r12.d();     // Catch: Exception -> L30
        if (r13 == null) goto L32;
        Boxing.boxInt(r13.o(5, 1));     // Catch: Exception -> L30
    L15:
        r9 = false;
    L30:
        FLogger.a.e("AiIslandVoiceInteractionSession", "tryTurnOnMicUsingClickTalk, try start dora VUI error");
        goto L32
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
