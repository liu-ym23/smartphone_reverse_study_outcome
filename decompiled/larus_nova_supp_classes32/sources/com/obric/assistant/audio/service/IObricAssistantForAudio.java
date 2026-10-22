package com.obric.assistant.audio.service;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.audio.continuous_talk.h0;
import com.obric.audio.continuous_talk.l0;
import iga.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0004H&J\b\u0010\u0013\u001a\u00020\rH&J\b\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0011H&J\b\u0010\u0016\u001a\u00020\u0011H&J\b\u0010\u0017\u001a\u00020\u0011H&J\b\u0010\u0018\u001a\u00020\u0011H&J\b\u0010\u0019\u001a\u00020\u0011H&JI\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010 H&¢\u0006\u0002\u0010!J\"\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&H&J.\u0010'\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010)2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&H&J\u001a\u0010+\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020\u0004H&J\u001a\u0010-\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020/H&J*\u00100\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00101\u001a\u00020\u00042\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&H&J\u0012\u00102\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$H&¨\u00063"}, d2 = {"Lcom/obric/assistant/audio/service/IObricAssistantForAudio;", NameKeys.UnloadStrategy_No_Strategy, "getVariantInputOpenStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", NameKeys.UnloadStrategy_No_Strategy, "isVariantInputOpen", "setVoiceViewVisible", NameKeys.UnloadStrategy_No_Strategy, LynxUIOverlay.PROP_VISIBLE, "activity", "Landroid/app/Activity;", "setVoiceViewVisibleAnimated", "duration", NameKeys.UnloadStrategy_No_Strategy, "getChatWindowLightView", "Landroid/view/View;", "generateCallId", NameKeys.UnloadStrategy_No_Strategy, "enableSilenceTimeout", "silenceTimeoutMs", "keyEndType", "conversationIsEmpty", "botIsEmpty", "recordAudioDenied", "recordingStarted", "startClickFailedOther", "mobClickTalkEnd", "botId", "conversationId", "callId", "messageId", "endType", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "prepareContinuousTalkVisualizer", "audioVisualizer", "Lcom/obric/assistant/spi/chat/IObricAudioVisualizer;", "timeOutCallback", "Lkotlin/Function0;", "updateContinuousTalkVisualizerState", "state", "Lcom/obric/assistant/audio/service/ObricAssistantAudioVisualizerState;", "onAnimationEnd", "setContinuousTalkVisualizerRecognizing", "recognizing", "updateContinuousTalkVisualizerAudioData", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "setContinuousTalkVisualizerMode", "continuousMode", "onContinuousTalkChatWindowShow", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAssistantForAudio {
    boolean O4();

    long P4();

    void Q4(a r1, boolean r2);

    String R4();

    void S4(a r1);

    void T4(a r1, boolean r2, l0 r3);

    String U4();

    void V4(boolean r1, Activity r2);

    void W4(a r1, h0 r2);

    boolean X4();

    String Y4();

    void Z4(FragmentActivity r1);

    String a5();

    String b5();

    i1<Boolean> c5();

    String d5();

    String e5();

    boolean f5(a r1, ObricAssistantAudioVisualizerState r2, Function0<Unit> r3);
}
