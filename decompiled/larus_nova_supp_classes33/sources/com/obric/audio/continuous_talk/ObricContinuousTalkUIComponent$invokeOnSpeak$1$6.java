package com.obric.audio.continuous_talk;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.audio.service.ObricAssistantAudioVisualizerState;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.spi.audio.IObricAsrService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import laa.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$invokeOnSpeak$1$6", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {372}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$invokeOnSpeak$1$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ hia.a $newSession;
    int label;
    final /* synthetic */ ObricContinuousTalkUIComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContinuousTalkUIComponent a;

        public a(ObricContinuousTalkUIComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r14, Continuation r15) {
            hia.b r16 = (hia.b) r14;
            final ObricContinuousTalkUIComponent r17 = this.a;
            int r0 = ObricContinuousTalkUIComponent.M;
            r17.getClass();
            FLogger r1 = FLogger.a;
            r1.i("ObricContinuousTalkUIComponent", "handleTalkEvent: " + r16);
            boolean r2 = r16 instanceof hia.b.h;
            if (r2 == true) goto L5;
        L9:
            boolean r3 = r16 instanceof hia.b.d;
            if (r3 == false) goto L12;
            r17.C3(false);
        L12:
            String r4 = null;
            if (r3 == false) goto L15;
            ObricAssistantAudioVisualizerState r5 = ObricAssistantAudioVisualizerState.QueryRejected;
        L18:
            f r6 = r17.z3();
            if (r6 == null) goto L21;
            iga.a r7 = r6.Zs();
        L23:
            if (r3 == true) goto L25;
        L35:
            boolean r8 = false;
        L37:
            if (r3 == true) goto L39;
        L51:
            boolean r10 = false;
        L52:
            if (r5 == null) goto L67;
            if (r8 == false) goto L55;
            r17.x = true;
            boolean r9 = ObricAssistantForAudioDelegate.b.f5(r7, r5, new e0(r17));
        L68:
            if (r3 == false) goto L93;
            if (r17.m0() == false) goto L93;
            AVKitDuplexState r11 = r17.v;
            if (r11 == null) goto L74;
            AVKitDuplexState.UpState r12 = r11.getUpState();
        L76:
            if ((r12 instanceof AVKitCoreStates.Finished) == true) goto L93;
            int r18 = r17.w + 1;
            r17.w = r18;
            if (r8 == false) goto L83;
            if (r9 == true) goto L83;
            if (r17.E3() == false) goto L129;
            FLogger.a.i("ObricContinuousTalkUIComponent", "first reject start timeout without animation callback");
            r17.G3();
        L129:
            return Unit.INSTANCE;
        L83:
            if (r10 == false) goto L88;
            if (r9 == true) goto L88;
            r17.y = false;
            FLogger.a.i("ObricContinuousTalkUIComponent", "reject closeTalk without animation callback");
            c r13 = r17.p3();
            if (r13 == null) goto L129;
            c.a.a(r13, ObricContinuousTalkEndType.INTERRUPT, null, false, false, 6);
        L88:
            if (r18 < 2) goto L129;
            if (r17.y == false) goto L129;
            FLogger.a.i("ObricContinuousTalkUIComponent", "reject closeTalk waiting animation end");
            goto L129
        L74:
            r12 = null;
        L93:
            if ((r16 instanceof hia.b.j) == false) goto L104;
            IObricAsrService r19 = (IObricAsrService) ServiceManager.get().getService(IObricAsrService.class);
            if (r19 == null) goto L97;
            r4 = r19.i(((hia.b.j) r16).a);
        L97:
            FLogger r110 = FLogger.a;
            StringBuilder r20 = new StringBuilder("handleTalkEvent VoiceAuthResult  roomid = ");
            hia.b.j r111 = (hia.b.j) r16;
            r20.append(r111.a);
            r20.append(' ');
            r110.i("ObricContinuousTalkUIComponent", r20.toString());
            if (r4 == null) goto L129;
            if (r111.c == false) goto L129;
            ISessionAuthenticationService r112 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
            if (r112 == null) goto L129;
            r112.d(r4, true);
            goto L129
        L104:
            if (r2 == false) goto L107;
            FLogger.a.i("ObricContinuousTalkUIComponent", "handleTalkEvent VadVoiceActived");
            r17.x = false;
            r17.C3(true);
            goto L129
        L107:
            if ((r16 instanceof hia.b.i) == false) goto L129;
            r17.C3(false);
            if (r17.y == false) goto L113;
            r17.y = false;
            FLogger.a.i("ObricContinuousTalkUIComponent", "vad voice finish, closeTalk after reject");
            c r21 = r17.p3();
            if (r21 == null) goto L129;
            c.a.a(r21, ObricContinuousTalkEndType.INTERRUPT, null, false, false, 6);
            goto L129
        L113:
            AVKitDuplexState r113 = r17.v;
            if (r113 == null) goto L116;
            AVKitDuplexState.UpState r114 = r113.getUpState();
        L118:
            if ((r114 instanceof AVKitCoreStates.Listening) == false) goto L126;
            AVKitDuplexState r115 = r17.v;
            if (r115 == null) goto L122;
            AVKitDuplexState.DownState r116 = r115.getDownState();
        L124:
            if ((r116 instanceof AVKitCoreStates.DownWaiting) == false) goto L126;
            ObricAssistantAudioVisualizerState r117 = ObricAssistantAudioVisualizerState.TtsEnd;
        L127:
            ObricAssistantForAudioDelegate.b.f5(r7, r117, null);
            goto L129
        L122:
            r116 = null;
        L126:
            r117 = null;
            goto L127
        L116:
            r114 = null;
            goto L118
        L55:
            if (r10 == false) goto L66;
            r17.x = false;
            r17.y = true;
            Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L63
            hia.a r119 = r17.n;     // Catch: Throwable -> L63
            if (r119 == null) goto L60;
            r119.g();     // Catch: Throwable -> L63
            Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L63
        L61:
            Result.constructor-impl(r120);     // Catch: Throwable -> L63
        L65:
            r9 = ObricAssistantForAudioDelegate.b.f5(r7, r5, new f0(r17));
            goto L68
        L60:
            r120 = null;
        L63:
            th = move-exception;
            Result.Companion r121 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L65
        L66:
            ObricAssistantForAudioDelegate.b.f5(r7, r5, null);
        L67:
            r9 = false;
            goto L68
        L39:
            if (r17.m0() == false) goto L51;
            AVKitDuplexState r122 = r17.v;
            if (r122 == null) goto L43;
            AVKitDuplexState.UpState r123 = r122.getUpState();
        L45:
            if ((r123 instanceof AVKitCoreStates.Finished) == true) goto L51;
            if ((r17.w + 1) < 2) goto L51;
            if (r17.y == true) goto L51;
            r10 = true;
            goto L52
        L43:
            r123 = null;
            goto L45
        L25:
            if (r17.m0() == false) goto L35;
            AVKitDuplexState r22 = r17.v;
            if (r22 == null) goto L29;
            AVKitDuplexState.UpState r23 = r22.getUpState();
        L31:
            if ((r23 instanceof AVKitCoreStates.Finished) == true) goto L35;
            if (r17.w != 0) goto L35;
            r8 = true;
            goto L37
        L29:
            r23 = null;
            goto L31
        L21:
            r7 = null;
            goto L23
        L15:
            if (r2 == false) goto L17;
            r5 = ObricAssistantAudioVisualizerState.SpeechStarted;
            goto L18
        L17:
            r5 = null;
            goto L18
        L5:
            if (r17.y == false) goto L9;
            r17.y = false;
            r1.i("ObricContinuousTalkUIComponent", "vad voice active, closeTalk after reject");
            c r24 = r17.p3();
            if (r24 == null) goto L129;
            c.a.a(r24, ObricContinuousTalkEndType.INTERRUPT, null, false, false, 6);
            goto L129
        }
    }

    public ObricContinuousTalkUIComponent$invokeOnSpeak$1$6(hia.a r1, ObricContinuousTalkUIComponent r2, Continuation<? super ObricContinuousTalkUIComponent$invokeOnSpeak$1$6> r3) {
        this.$newSession = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricContinuousTalkUIComponent$invokeOnSpeak$1$6(this.$newSession, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Flow<hia.b> r6 = this.$newSession.s();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
