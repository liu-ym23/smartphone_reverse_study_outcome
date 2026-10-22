package com.obric.assistant.audio;

import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.utils.j;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.audio.ObricTtsServiceImpl$readAuthenticationContent$1", f = "ObricTtsServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricTtsServiceImpl$readAuthenticationContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $playScene;
    int label;
    final /* synthetic */ ObricTtsServiceImpl this$0;

    public ObricTtsServiceImpl$readAuthenticationContent$1(String r1, ObricTtsServiceImpl r2, String r3, Continuation<? super ObricTtsServiceImpl$readAuthenticationContent$1> r4) {
        this.$playScene = r1;
        this.this$0 = r2;
        this.$content = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricTtsServiceImpl$readAuthenticationContent$1(this.$playScene, this.this$0, this.$content, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r14);
        FLogger r15 = FLogger.a;
        r15.i("ObricTtsServiceImpl", "readAuthenticationContent: start playTtsSimple, playScene=" + this.$playScene);
        ObricTtsServiceImpl r0 = this.this$0;
        String r2 = this.$playScene;
        String r3 = this.$content;
        int r4 = ObricTtsServiceImpl.e;
        r0.getClass();
        if (j.c(AppHost.a.getApplication()) == true) goto L7;
        r15.i("ObricTtsServiceImpl", "playTtsSimple, is nova default assistant: false , return");
    L36:
        return Unit.INSTANCE;
    L7:
        r15.i("ObricTtsServiceImpl", "playTtsSimple: playScene = " + r2 + ", content = " + r3);
        z2 r5 = z2.a;
        if (r5.enableObricIndependentTts() == false) goto L10;
        IObricChainTtsService.a.getClass();
        IObricChainTtsService r6 = IObricChainTtsService.a.a();
    L11:
        boolean r7 = true;
        if (r6 == null) goto L26;
        if (Intrinsics.areEqual(r2, "requestDismissKeyguard") == false) goto L23;
        IDoraWakeupService.a.getClass();
        IDoraWakeupService r1 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class, false, false);
        if (r1 != null) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L23;
    L24:
        r15.i("ObricTtsServiceImpl", "playTtsSimple: use ObricTtsClient (independent tts pipeline), playScene=" + r2 + ", allowDoraScene=" + r7);
        r6.a(r3, null, r2, r7);
        goto L36
    L18:
        if (r1.b() != true) goto L20;
        r8 = true;
    L23:
        r7 = false;
        goto L24
    L26:
        if (r5.enableObricIndependentTts() == false) goto L28;
        r15.i("ObricTtsServiceImpl", "playTtsSimple: IObricTtsClientService not available, fallback to IM tts pipeline");
    L28:
        IFlowTtsClientService.a.getClass();
        PlayStateEnum r9 = IFlowTtsClientService.a.a().m();
        if (r9 != PlayStateEnum.PLAY_STATE_STOPPED) goto L32;
        r7 = false;
    L32:
        if (r7 == false) goto L34;
        r15.i("ObricTtsServiceImpl", "playTtsSimple: already has active tts, state=" + r9 + ", so interrupt and play new content");
        IFlowTtsClientService.a.a().f("playTtsSimple: playScene is " + r2 + ", interrupt current tts and play new content");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ObricTtsServiceImpl$playTtsSimple$1(r0, r2, r3, null), 2, null);
        goto L36
    L34:
        r15.i("ObricTtsServiceImpl", "playTtsSimple: start tts directly");
        r0.h(r2, r3);
        goto L36
    L10:
        r6 = null;
        goto L11
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
