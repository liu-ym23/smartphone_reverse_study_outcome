package com.mammon.speechaudiosdk.kmp.session;

import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionUplinkEventType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AndroidSpeechVoiceAssistantSessionImpl$NativeSAMICoreImpl$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

    static {
        int[] r0 = new int[SpeechVoiceAssistantSessionUplinkEventType.values().length];
        r0[SpeechVoiceAssistantSessionUplinkEventType.StartSession.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
    L21:
        r0[SpeechVoiceAssistantSessionUplinkEventType.FinishSession.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
    L31:
        r0[SpeechVoiceAssistantSessionUplinkEventType.CancelSession.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
    L23:
        r0[SpeechVoiceAssistantSessionUplinkEventType.EndASR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
    L25:
        r0[SpeechVoiceAssistantSessionUplinkEventType.StartTTS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
    L19:
        r0[SpeechVoiceAssistantSessionUplinkEventType.BidirectionalTTSText.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
    L27:
        r0[SpeechVoiceAssistantSessionUplinkEventType.BIDIRECTIONALEndTTS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
    L10:
        $EnumSwitchMapping$0 = r0;
    }
}
