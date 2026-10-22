package com.obric.assistant.audio;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.audio.service.IObricAssistantForAudio;
import com.obric.assistant.audio.service.ObricAssistantAudioVisualizerState;
import com.obric.assistant.component.clicktalk.i0;
import com.obric.assistant.component.clicktalk.m0;
import com.obric.assistant.view.continuespeech.AudioContinueGradientView;
import com.obric.assistant.view.continuespeech.AudioGradientView;
import com.obric.assistant.view.continuespeech.RealtimeCallLifeState;
import com.obric.assistant.view.continuespeech.t;
import com.obric.assistant.view.continuespeech.u;
import com.obric.assistant.view.continuespeech.v;
import com.obric.assistant.view.continuespeech.w;
import com.obric.audio.continuous_talk.h0;
import com.obric.audio.continuous_talk.l0;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import laa.j;
import laa.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016JI\u0010\"\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u00192\b\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u00192\b\u0010&\u001a\u0004\u0018\u00010\u00192\b\u0010'\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\"\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010.H\u0016J,\u0010/\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u00100\u001a\u0004\u0018\u0001012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010.H\u0016J\u001a\u00103\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00104\u001a\u00020\fH\u0016J\u001a\u00105\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00106\u001a\u000207H\u0016J*\u00108\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00109\u001a\u00020\f2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010.H\u0016J\u0012\u0010:\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0016\u0010;\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0016\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0016\u0010A\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010B\u001a\u0004\u0018\u00010C2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\f\u0010D\u001a\u00020E*\u000201H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006F"}, d2 = {"Lcom/obric/assistant/audio/ObricAssistantForAudioImpl;", "Lcom/obric/assistant/audio/service/IObricAssistantForAudio;", "<init>", "()V", "clickTalkConfig", "Lcom/obric/assistant/component/clicktalk/ClickTalkConfig;", "getClickTalkConfig", "()Lcom/obric/assistant/component/clicktalk/ClickTalkConfig;", "clickTalkConfig$delegate", "Lkotlin/Lazy;", "getVariantInputOpenStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", NameKeys.UnloadStrategy_No_Strategy, "isVariantInputOpen", "setVoiceViewVisible", NameKeys.UnloadStrategy_No_Strategy, LynxUIOverlay.PROP_VISIBLE, "activity", "Landroid/app/Activity;", "setVoiceViewVisibleAnimated", "duration", NameKeys.UnloadStrategy_No_Strategy, "getChatWindowLightView", "Landroid/view/View;", "generateCallId", NameKeys.UnloadStrategy_No_Strategy, "enableSilenceTimeout", "silenceTimeoutMs", "keyEndType", "conversationIsEmpty", "botIsEmpty", "recordAudioDenied", "recordingStarted", "startClickFailedOther", "mobClickTalkEnd", "botId", "conversationId", "callId", "messageId", "endType", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "prepareContinuousTalkVisualizer", "audioVisualizer", "Lcom/obric/assistant/spi/chat/IObricAudioVisualizer;", "timeOutCallback", "Lkotlin/Function0;", "updateContinuousTalkVisualizerState", "state", "Lcom/obric/assistant/audio/service/ObricAssistantAudioVisualizerState;", "onAnimationEnd", "setContinuousTalkVisualizerRecognizing", "recognizing", "updateContinuousTalkVisualizerAudioData", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "setContinuousTalkVisualizerMode", "continuousMode", "onContinuousTalkChatWindowShow", "getChatWindowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getLegacyChatVContext", "Lcom/larus/ui/arch/context/external/VContext;", "getCompatChatVContext", "visualizer", "Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "toRealtimeCallLifeState", "Lcom/obric/assistant/view/continuespeech/RealtimeCallLifeState;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantForAudioImpl implements IObricAssistantForAudio {
    public final Lazy a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricAssistantAudioVisualizerState.values().length];
            r0[ObricAssistantAudioVisualizerState.SpeechStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ObricAssistantAudioVisualizerState.Thinking.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ObricAssistantAudioVisualizerState.QueryRejected.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ObricAssistantAudioVisualizerState.TtsEnd.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ObricAssistantAudioVisualizerState.FinishSession.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static j d() {
        t1a.b r1 = c(null);
        if (r1 == null) goto L8;
        j r2 = r1.getAbility(j.class);
        if (r2 == null) goto L8;
        return r2;
    L8:
        t1a.b r3 = b(null);
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.getAbility(j.class);
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String U4() {
        return "conversation_is_empty";
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String Y4() {
        return "bot_is_empty";
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String a5() {
        return "recording_started";
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String b5() {
        return "end_type";
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String d5() {
        return "record_audio_denied";
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String e5() {
        return "other";
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final long P4() {
        return ((i0) this.a.getValue()).b;
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String R4() {
        StateFlowImpl r0 = m0.a;
        return UUID.randomUUID().toString();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final boolean X4() {
        return ((i0) this.a.getValue()).a;
    }

    public ObricAssistantForAudioImpl() {
        this.a = LazyKt.lazy(new g());
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final boolean O4() {
        j r0 = d();
        if (r0 == null) goto L9;
        b1 r1 = r0.O4();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final i1<Boolean> c5() {
        j r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.O4();
    }

    public static m a(Activity r2) {
        t1a.b r0 = c(r2);
        if (r0 == null) goto L6;
        m r1 = r0.getAbility(m.class);
        if (r1 == null) goto L6;
        return r1;
    L6:
        t1a.b r3 = b(r2);
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.getAbility(m.class);
    }

    public static t1a.b b(Activity r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (r1 != null) goto L5;
        t1a.b r2 = com.obric.assistant.chat.p.b();     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L14;
        r3 = null;
    L14:
        return (t1a.b) r3;
    L5:
        r2 = com.obric.assistant.chat.p.a(r1);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static t1a.b c(Activity r2) {
        if (r2 != null) goto L4;
        r2 = AppHost.a.a().getCurrentActivity();
    L4:
        Object r1 = null;
        if ((r2 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r3 = (FragmentActivity) r2;
    L8:
        if (r3 != null) goto L10;
        return null;
    L10:
        Fragment r4 = r3.getSupportFragmentManager().findFragmentById(2131373275);
        if (r4 != null) goto L14;
        return null;
    L14:
        if (r4.isAdded() == false) goto L27;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        Object r5 = Result.constructor-impl(s1a.a.g(r4));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r5) == true) goto L24;
        r1 = r5;
    L24:
        return (t1a.b) r1;
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L27:
        return null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void S4(iga.a r2) {
        if ((r2 instanceof AudioContinueGradientView) == false) goto L5;
        AudioContinueGradientView r3 = (AudioContinueGradientView) r2;
    L6:
        if (r3 == null) goto L9;
        r3.d.p = true;
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void Z4(FragmentActivity r1) {
        m r2 = a(r1);
        if (r2 == null) goto L6;
        r2.Rb();
        return;
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void Q4(iga.a r2, boolean r3) {
        if ((r2 instanceof AudioContinueGradientView) == false) goto L5;
        AudioContinueGradientView r4 = (AudioContinueGradientView) r2;
    L6:
        if (r4 == null) goto L9;
        r4.setRecognizing(r3);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void V4(boolean r1, Activity r2) {
        m r3 = a(r2);
        if (r3 == null) goto L6;
        r3.DH(r1);
        return;
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void W4(iga.a r5, h0 r6) {
        AudioGradientView r1 = null;
        if ((r5 instanceof AudioContinueGradientView) == false) goto L5;
        AudioContinueGradientView r7 = (AudioContinueGradientView) r5;
    L6:
        if (r7 == null) goto L16;
        m r0 = a(null);
        if (r0 == null) goto L10;
        View r2 = r0.LD();
    L11:
        u r3 = r7.d;
        if ((r2 instanceof AudioGradientView) == false) goto L14;
        r1 = (AudioGradientView) r2;
    L14:
        r3.a = r1;
        r7.setTimeOutCallback(r6);
        return;
    L10:
        r2 = null;
        goto L11
    L16:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void T4(iga.a r2, boolean r3, l0 r4) {
        if ((r2 instanceof AudioContinueGradientView) == false) goto L5;
        AudioContinueGradientView r5 = (AudioContinueGradientView) r2;
    L6:
        if (r5 == null) goto L9;
        r5.setMode(r3 ? 1 : 0);
        r5.setTimeOutCallback(r4);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final boolean f5(iga.a r17, ObricAssistantAudioVisualizerState r18, Function0<Unit> r19) {
        Pair r3 = null;
        if ((r17 instanceof AudioContinueGradientView) == false) goto L5;
        AudioContinueGradientView r0 = (AudioContinueGradientView) r17;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r18 == null) goto L23;
        int r9 = a.a[r18.ordinal()];
        if (r9 == 1) goto L22;
        if (r9 == 2) goto L21;
        if (r9 == 3) goto L20;
        if (r9 == 4) goto L19;
        if (r9 != 5) goto L18;
        RealtimeCallLifeState r10 = RealtimeCallLifeState.FinishSession;
    L24:
        u r1 = r0.d;
        r1.getClass();
        FLogger r11 = FLogger.a;
        r11.i("AudioContinueAnimDelegate", "onRealtimeCallLifeStateUpdate state:" + r10 + " curState:" + r1.q);
        RealtimeCallLifeState r12 = r1.q;
        RealtimeCallLifeState r13 = RealtimeCallLifeState.Thingking;
        if (r10 != r13) goto L43;
        if (r12 != r10) goto L43;
        com.obric.assistant.view.continuespeech.a r14 = r1.r;
        if (r14 == null) goto L30;
        RealtimeCallLifeState r15 = r14.c;
    L31:
        if (r15 != r13) goto L43;
        Animator r16 = r1.s;
        if (r16 != null) goto L35;
    L37:
        boolean r110 = false;
    L38:
        if (r110 == false) goto L43;
        AudioGradientView r2 = r1.a;
        if (r2 == null) goto L42;
        r2.setAnimating(true);
    L42:
        r1.c.setAnimating(true);
        return false;
    L35:
        if (r16.isRunning() != true) goto L37;
        r110 = true;
        goto L38
    L30:
        r15 = null;
    L43:
        if (r12 != r13) goto L46;
        if (r12 == r10) goto L46;
        boolean r111 = true;
    L47:
        if (r111 == false) goto L49;
        r1.f(r13);
    L49:
        r1.q = r10;
        if (r111 == false) goto L60;
        com.obric.assistant.view.continuespeech.a r112 = r1.r;
        if (r112 == null) goto L54;
        RealtimeCallLifeState r113 = r112.c;
    L55:
        if (r113 != r13) goto L60;
        Animator r114 = r1.s;
        if (r114 == null) goto L60;
        r114.cancel();
        goto L60
    L54:
        r113 = null;
    L60:
        if (r12 != RealtimeCallLifeState.TTSEnd) goto L66;
        if (r12 == r10) goto L66;
        if (r10 == RealtimeCallLifeState.FinishSession) goto L66;
        Pair r115 = r1.d(false);
        r1.e((Animator) r115.getFirst(), ((Boolean) r115.getSecond()).booleanValue(), null, null);
    L66:
        if (r12 != RealtimeCallLifeState.SpeechStarted) goto L70;
        if (r12 == r10) goto L70;
        Pair r116 = r1.c(false, 0.0f);
        r1.e((Animator) r116.getFirst(), ((Boolean) r116.getSecond()).booleanValue(), null, null);
    L70:
        if (r10 != null) goto L72;
        int r117 = -1;
    L73:
        if (r117 == 2) goto L85;
        if (r117 == 3) goto L80;
        if (r117 == 4) goto L79;
        if (r117 != 5) goto L86;
        r11.i("AudioContinueAnimDelegate", "createFinishAnimation");
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r1.c, View.ALPHA, new float[]{0.0f});
        r4.setDuration(r1.e);
        r4.addListener(new v(r1));
        r3 = new Pair(r4, Boolean.FALSE);
    L86:
        if (r3 == null) goto L95;
        if (r10 == null) goto L89;
        r1.f(r10);
    L89:
        r1.e((Animator) r3.getFirst(), ((Boolean) r3.getSecond()).booleanValue(), r10, r19);
        if (r19 == null) goto L96;
        return true;
    L96:
        return false;
    L95:
        return false;
    L79:
        r3 = r1.d(true);
        goto L86
    L80:
        r11.i("AudioContinueAnimDelegate", "createRejectAnimation");
        float r5 = r1.b.getPauseIntensity();
        ValueAnimator r118 = ValueAnimator.ofFloat(new float[]{r5, 0.0f});
        r118.setDuration(r1.e);
        r118.setInterpolator(r1.m);
        r118.addUpdateListener(new com.obric.assistant.view.continuespeech.q(r1));
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, r5});
        r6.setDuration(r1.f);
        r6.setStartDelay(r1.j);
        r6.setInterpolator(r1.n);
        r6.addUpdateListener(new com.obric.assistant.view.continuespeech.r(r1));
        ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{0.0f, 0.5f});
        r119.setDuration(r1.i);
        r119.setInterpolator(r1.m);
        r119.addUpdateListener(new com.obric.assistant.view.continuespeech.s(r1));
        ValueAnimator r120 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r120.setDuration(r1.i);
        r120.setInterpolator(r1.m);
        r120.addUpdateListener(new t(r1));
        ValueAnimator r121 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r121.setDuration(r1.i);
        r121.setStartDelay(r1.i);
        r121.setInterpolator(r1.m);
        r121.addUpdateListener(new com.obric.assistant.view.continuespeech.c(r1));
        AnimatorSet r122 = new AnimatorSet();
        r122.playTogether(new Animator[]{r118, r6, r119, r120, r121});
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{1.0f, 0.2f});
        r7.setDuration(r1.d);
        r7.setInterpolator(r1.m);
        r7.addUpdateListener(new com.obric.assistant.view.continuespeech.d(r1));
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.2f, 1.0f});
        r8.setDuration(r1.e);
        r8.setInterpolator(r1.m);
        r8.addUpdateListener(new com.obric.assistant.view.continuespeech.e(r1));
        ValueAnimator r123 = ValueAnimator.ofFloat(new float[]{1.0f, 0.2f});
        r123.setDuration(r1.d);
        r123.setInterpolator(r1.m);
        r123.addUpdateListener(new com.obric.assistant.view.continuespeech.f(r1));
        ValueAnimator r124 = ValueAnimator.ofFloat(new float[]{0.2f, 1.0f});
        r124.setDuration(r1.g);
        r124.setInterpolator(r1.m);
        r124.addUpdateListener(new com.obric.assistant.view.continuespeech.g(r1));
        AnimatorSet r125 = new AnimatorSet();
        r125.playSequentially(new Animator[]{r7, r8, r123, r124});
        ArrayList r20 = new ArrayList();
        r20.add(r122);
        r20.add(r125);
        AudioGradientView r21 = r1.a;
        if (r21 == null) goto L83;
        float r126 = r21.getAlpha();
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r21, "alpha", new float[]{r126, 0.0f, r126, 0.0f});
        r22.setDuration(r1.e * ((long) 3));
        r22.setInterpolator(r1.n);
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r21, "alpha", new float[]{0.0f, r126});
        r23.setDuration(r1.f);
        r23.setInterpolator(r1.n);
        AnimatorSet r24 = new AnimatorSet();
        r24.playSequentially(new Animator[]{r22, r23});
        r20.add(r24);
    L83:
        AnimatorSet r25 = new AnimatorSet();
        r25.playTogether(r20);
        r3 = new Pair(r25, Boolean.FALSE);
        goto L86
    L85:
        r11.i("AudioContinueAnimDelegate", "createThinkingAnimation");
        ValueAnimator r26 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r26.setDuration(r1.i);
        r26.setInterpolator(r1.m);
        r26.setRepeatCount(-1);
        r26.setRepeatMode(1);
        r26.addListener(new w(r1));
        r3 = new Pair(r26, Boolean.TRUE);
        goto L86
    L72:
        r117 = u.c.a[r10.ordinal()];
    L46:
        r111 = false;
        goto L47
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        r10 = RealtimeCallLifeState.TTSEnd;
        goto L24
    L20:
        r10 = RealtimeCallLifeState.QueryRejected;
        goto L24
    L21:
        r10 = RealtimeCallLifeState.Thingking;
        goto L24
    L22:
        r10 = RealtimeCallLifeState.SpeechStarted;
        goto L24
    L23:
        r10 = null;
        goto L24
    L5:
        r0 = null;
        goto L7
    }
}
