package com.larus.dora.obric.onboarding;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$2$onSessionEvent$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {473, 501}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingViewModelV2$2$onSessionEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.im.service.audio.z0.a $event;
    int label;
    final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

    public ObricDoraGOnboardingViewModelV2$2$onSessionEvent$1(ObricDoraGOnboardingViewModelV2 r1, com.larus.im.service.audio.z0.a r2, Continuation<? super ObricDoraGOnboardingViewModelV2$2$onSessionEvent$1> r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricDoraGOnboardingViewModelV2$2$onSessionEvent$1(this.this$0, this.$event, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L9;
        if (r5 != 2) goto L8;
        ResultKt.throwOnFailure(r20);
    L92:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
    L25:
        if (Intrinsics.areEqual(this.this$0.get_wakeupQueryUiStateFlow().getValue(), c2.d.a) == false) goto L28;
        this.this$0.get_wakeupQueryUiStateFlow().setValue(c2.e.a);
    L28:
        if (ObricDoraGOnboardingViewModelV2.access$getVuiMode$p(this.this$0) != 14) goto L31;
        this.this$0.playVideoCallTTS();
        goto L92
    L31:
        if (ObricDoraGOnboardingViewModelV2.access$getVuiMode$p(this.this$0) != 6) goto L92;
        this.this$0.stopTTS("call start");
        if (ObricDoraGOnboardingViewModelV2.access$getShouldPlayWakeUpTTSOnLlmCallStarted$p(this.this$0) == false) goto L35;
        this.this$0.playWakeUpTTS();
        goto L92
    L35:
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "skip wakeup tts on llm call started");
        goto L92
    L10:
        ResultKt.throwOnFailure(r20);
        IDoraService.h r6 = ObricDoraGOnboardingViewModelV2.access$getSession(this.this$0);
        if (r6 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == true) goto L18;
        pf9.z r8 = this.$event;
        if ((r8 instanceof pf9.o) == false) goto L37;
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "call start,  cur wakeup query " + this.this$0.get_wakeupQueryUiStateFlow().getValue());
        MutableSharedFlow<Unit> r0 = this.this$0.get_llmCallStartedSharedFlow();
        Unit r2 = Unit.INSTANCE;
        this.label = 1;
        if (r0.emit(r2, this) != r4) goto L25;
        return r4;
    L37:
        if ((r8 instanceof pf9.z) == false) goto L39;
        ObricDoraGOnboardingViewModelV2.access$setCurrentQueryId$p(this.this$0, r8.a);
        this.this$0.stopTTS("next query begin, cur tts stop");
        this.this$0.get_wakeupQueryUiStateFlow().setValue(c2.b.a);
        goto L92
    L39:
        byte[] r11 = null;
        if ((r8 instanceof pf9.a0) == false) goto L45;
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "query end");
        this.this$0.get_avatarUiStateFlow().setValue(AvatarUiState.THINKING);
        this.this$0.get_wakeupQueryUiStateFlow().setValue(c2.c.a);
        Channel<g> r1 = this.this$0.get_llmCallEventSharedFlow();
        g.a r3 = new g.a(LLMCallEvent.QUERY_END, null, System.currentTimeMillis());
        this.label = 2;
        if (r1.send(r3, this) != r4) goto L92;
        return r4;
    L45:
        if ((r8 instanceof pf9.d0) == false) goto L48;
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "replay begin, wakeup query : " + this.this$0.get_wakeupQueryUiStateFlow().getValue());
        goto L92
    L48:
        if ((r8 instanceof pf9.f0) == true) goto L92;
        if ((r8 instanceof pf9.e0) == false) goto L83;
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "replay end, wakeup query : " + this.this$0.get_wakeupQueryUiStateFlow().getValue());
        if (Intrinsics.areEqual(this.this$0.get_wakeupQueryUiStateFlow().getValue(), c2.c.a) == false) goto L92;
        Ref.IntRef r9 = new Ref.IntRef();
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        String r12 = ObricDoraGOnboardingViewModelV2.access$getCurrentQueryId$p(this.this$0);     // Catch: Throwable -> L79
        if (r12 == null) goto L81;
        ObricDoraGOnboardingViewModelV2 r13 = this.this$0;     // Catch: Throwable -> L79
        IDoraAVLinkService r14 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L79
        if (r14 == null) goto L59;
        Integer r15 = r14.y1(r12);     // Catch: Throwable -> L79
    L60:
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "1 query id: " + ObricDoraGOnboardingViewModelV2.access$getCurrentQueryId$p(r13) + ", imageUuid: " + r15);     // Catch: Throwable -> L79
        if (r15 == null) goto L77;
        uj4.g r16 = (uj4.g) ObricDoraGOnboardingViewModelV2.access$getQueryImages$p(r13).b(r15);     // Catch: Throwable -> L79
        if (r16 == null) goto L65;
        r11 = r16.b;     // Catch: Throwable -> L79
    L65:
        if (r11 != null) goto L67;
    L76:
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "query image data is null or empty");     // Catch: Throwable -> L79
        goto L77
    L67:
        if (r11.length != 0) goto L69;
        boolean r17 = true;
    L70:
        if (r17 == true) goto L76;
        Bitmap r18 = BitmapFactory.decodeByteArray(r11, 0, r11.length);     // Catch: Throwable -> L79
        if (r18 != null) goto L75;
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "query image decode failed");     // Catch: Throwable -> L79
        goto L77
    L75:
        Matrix r21 = new Matrix();     // Catch: Throwable -> L79
        r21.postRotate(90.0f);     // Catch: Throwable -> L79
        r10.element = Bitmap.createBitmap(r18, 0, 0, r18.getWidth(), r18.getHeight(), r21, true);     // Catch: Throwable -> L79
        r9.element = 1;     // Catch: Throwable -> L79
        goto L77
    L69:
        r17 = false;
    L77:
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "4 query id: " + ObricDoraGOnboardingViewModelV2.access$getCurrentQueryId$p(r13) + ", imageUuid: " + r15);     // Catch: Throwable -> L79
        goto L81
    L59:
        r15 = null;
    L81:
        this.this$0.get_wakeupQueryUiStateFlow().setValue(new c2.a(r9.element, (Bitmap) r10.element, 4));
    L79:
        th = move-exception;
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "err: " + th.getMessage());
        g49.d.c(ObricDoraGOnboardingViewModelV2.TAG, "onSession event image err:", th);
        goto L81
    L83:
        if ((r8 instanceof pf9.q) == false) goto L89;
        Iterator r22 = ((pf9.q) r8).a.iterator();
    L86:
        if (r22.hasNext() == false) goto L92;
        pf9.p r23 = (pf9.p) r22.next();
        goto L86
    L89:
        if ((r8 instanceof pf9.n) == false) goto L92;
        g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "call finish");
        goto L92
    L18:
        return Unit.INSTANCE;
    L13:
        if (r6.a() != 11) goto L15;
        r7 = true;
        goto L16
    }
}
