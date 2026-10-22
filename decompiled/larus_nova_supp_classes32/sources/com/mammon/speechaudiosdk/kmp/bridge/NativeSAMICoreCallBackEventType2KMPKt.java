package com.mammon.speechaudiosdk.kmp.bridge;

import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionDownlinkEventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toVoiceAssistantSessionDownlinkEventKmp", "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionDownlinkEventType;", "Lcom/mammon/audiosdk/enums/SAMICoreCallBackEventType;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NativeSAMICoreCallBackEventType2KMPKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SAMICoreCallBackEventType.values().length];
            r0[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r0[SAMICoreCallBackEventType.TaskFinished.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r0[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r0[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r0[SAMICoreCallBackEventType.SessionCanceled.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r0[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[SAMICoreCallBackEventType.ASRResponse.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[SAMICoreCallBackEventType.ASREnded.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r0[SAMICoreCallBackEventType.ChatResponse.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r0[SAMICoreCallBackEventType.ChatEnded.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r0[SAMICoreCallBackEventType.TTSSentenceStart.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[SAMICoreCallBackEventType.TTSResponse.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r0[SAMICoreCallBackEventType.TTSSentenceEnd.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r0[SAMICoreCallBackEventType.TTSEnded.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r0[SAMICoreCallBackEventType.ASRInfo.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final SpeechVoiceAssistantSessionDownlinkEventType toVoiceAssistantSessionDownlinkEventKmp(SAMICoreCallBackEventType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
            case 1: goto L21;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L26;
            case 14: goto L25;
            case 15: goto L24;
            case 16: goto L23;
            default: goto L22;
        };
    L22:
        return SpeechVoiceAssistantSessionDownlinkEventType.Unknown;
    L23:
        return SpeechVoiceAssistantSessionDownlinkEventType.ASRInfo;
    L24:
        return SpeechVoiceAssistantSessionDownlinkEventType.TTSEnded;
    L25:
        return SpeechVoiceAssistantSessionDownlinkEventType.TTSSentenceEnd;
    L26:
        return SpeechVoiceAssistantSessionDownlinkEventType.TTSResponse;
    L27:
        return SpeechVoiceAssistantSessionDownlinkEventType.TTSSentenceStart;
    L28:
        return SpeechVoiceAssistantSessionDownlinkEventType.ChatEnded;
    L29:
        return SpeechVoiceAssistantSessionDownlinkEventType.ChatResponse;
    L30:
        return SpeechVoiceAssistantSessionDownlinkEventType.ASREnded;
    L31:
        return SpeechVoiceAssistantSessionDownlinkEventType.ASRResponse;
    L32:
        return SpeechVoiceAssistantSessionDownlinkEventType.SessionFailed;
    L33:
        return SpeechVoiceAssistantSessionDownlinkEventType.SessionCanceled;
    L34:
        return SpeechVoiceAssistantSessionDownlinkEventType.SessionFinished;
    L35:
        return SpeechVoiceAssistantSessionDownlinkEventType.SessionStarted;
    L36:
        return SpeechVoiceAssistantSessionDownlinkEventType.TaskFailed;
    L37:
        return SpeechVoiceAssistantSessionDownlinkEventType.TaskFinished;
    L21:
        return SpeechVoiceAssistantSessionDownlinkEventType.TaskStarted;
    }
}
