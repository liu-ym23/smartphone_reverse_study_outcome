package com.obric.assistant.audio.service;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.audio.continuous_talk.h0;
import com.obric.audio.continuous_talk.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import iga.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0096\u0001J\t\u0010\u000e\u001a\u00020\bH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0005H\u0096\u0001JJ\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0001J#\u0010\u001d\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001fH\u0096\u0001J\t\u0010 \u001a\u00020\u0005H\u0096\u0001J\t\u0010!\u001a\u00020\u0005H\u0096\u0001J+\u0010\"\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020\b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001fH\u0096\u0001J\u001b\u0010$\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010%\u001a\u00020\bH\u0096\u0001J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J#\u0010*\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J\t\u0010,\u001a\u00020+H\u0096\u0001J\t\u0010-\u001a\u00020\u0005H\u0096\u0001J\u001b\u0010.\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010/\u001a\u000200H\u0096\u0001J-\u00101\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u00102\u001a\u0004\u0018\u0001032\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001fH\u0096\u0001¨\u00065"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAssistantForAudioDelegate;", "Lcom/obric/assistant/audio/service/IObricAssistantForAudio;", "<init>", "()V", "botIsEmpty", NameKeys.UnloadStrategy_No_Strategy, "conversationIsEmpty", "enableSilenceTimeout", NameKeys.UnloadStrategy_No_Strategy, "generateCallId", "getChatWindowLightView", "Landroid/view/View;", "getVariantInputOpenStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "isVariantInputOpen", "keyEndType", "mobClickTalkEnd", NameKeys.UnloadStrategy_No_Strategy, "botId", "conversationId", "callId", "messageId", "endType", "duration", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "onContinuousTalkChatWindowShow", "audioVisualizer", "Lcom/obric/assistant/spi/chat/IObricAudioVisualizer;", "prepareContinuousTalkVisualizer", "timeOutCallback", "Lkotlin/Function0;", "recordAudioDenied", "recordingStarted", "setContinuousTalkVisualizerMode", "continuousMode", "setContinuousTalkVisualizerRecognizing", "recognizing", "setVoiceViewVisible", LynxUIOverlay.PROP_VISIBLE, "activity", "Landroid/app/Activity;", "setVoiceViewVisibleAnimated", NameKeys.UnloadStrategy_No_Strategy, "silenceTimeoutMs", "startClickFailedOther", "updateContinuousTalkVisualizerAudioData", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "updateContinuousTalkVisualizerState", "state", "Lcom/obric/assistant/audio/service/ObricAssistantAudioVisualizerState;", "onAnimationEnd", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantForAudioDelegate implements IObricAssistantForAudio {
    public static final ObricAssistantForAudioDelegate b = null;
    public final /* synthetic */ IObricAssistantForAudio a;

    static {
        b = new ObricAssistantForAudioDelegate();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final boolean O4() {
        return this.a.O4();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final long P4() {
        return this.a.P4();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void Q4(a r2, boolean r3) {
        this.a.Q4(r2, r3);
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String R4() {
        return this.a.R4();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void S4(a r2) {
        this.a.S4(r2);
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void T4(a r2, boolean r3, l0 r4) {
        this.a.T4(r2, r3, r4);
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String U4() {
        return this.a.U4();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void V4(boolean r2, Activity r3) {
        this.a.V4(r2, r3);
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void W4(a r2, h0 r3) {
        this.a.W4(r2, r3);
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final boolean X4() {
        return this.a.X4();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String Y4() {
        return this.a.Y4();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final void Z4(FragmentActivity r2) {
        this.a.Z4(r2);
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String a5() {
        return this.a.a5();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String b5() {
        return this.a.b5();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final i1<Boolean> c5() {
        return this.a.c5();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String d5() {
        return this.a.d5();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final String e5() {
        return this.a.e5();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantForAudio
    public final boolean f5(a r2, ObricAssistantAudioVisualizerState r3, Function0<Unit> r4) {
        return this.a.f5(r2, r3, r4);
    }

    private ObricAssistantForAudioDelegate() {
        this.a = (IObricAssistantForAudio) ServiceManager.get().getService(IObricAssistantForAudio.class);
    }
}
