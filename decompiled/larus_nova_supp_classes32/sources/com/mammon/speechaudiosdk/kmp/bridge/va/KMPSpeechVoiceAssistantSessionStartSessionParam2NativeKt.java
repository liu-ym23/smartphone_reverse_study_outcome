package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionStartSessionParam;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionRequestType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantPropertyParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionStartSessionParam;", "toActualBytes", NameKeys.UnloadStrategy_No_Strategy, "requestedSize", NameKeys.UnloadStrategy_No_Strategy, "actualSize", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionStartSessionParam2NativeKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SpeechVoiceAssistantSessionRequestType.values().length];
            r0[SpeechVoiceAssistantSessionRequestType.MessageASR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SpeechVoiceAssistantSessionRequestType.MessageTTS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SpeechVoiceAssistantSessionRequestType.BidirectionalTTS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final SAMICoreVoiceAssistantPropertyParameter toNative(SpeechVoiceAssistantSessionStartSessionParam r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        SAMICoreVoiceAssistantPropertyParameter r0 = new SAMICoreVoiceAssistantPropertyParameter();
        r0.taskId = r3.getTaskId();
        r0.sessionId = r3.getSessionId();
        r0.conversationId = r3.getConversationId();
        r0.enableAudioInput = r3.getEnableAudioInput();
        r0.enableUploadAudio = r3.getEnableUploadAudio();
        r0.enableTextReading = r3.getEnableTextReading();
        r0.enablePlayer = r3.getEnablePlayer();
        r0.enableRealtimeVoiceCall = r3.getEnableRealtimeVoiceCall();
        r0.interruptType = r3.getInterruptType();
        r0.question = r3.getQuestion();
        r0.chat = r3.getChat();
        r0.reconnectQuestionId = r3.getReconnectQuestionId();
        r0.reconnectStatus = r3.getReconnectStatus();
        r0.business = r3.getBusiness();
        r0.triggerType = r3.getTriggerType();
        r0.extra = r3.getExtra();
        r0.updateUIContextPayload = r3.getUpdateUIContextPayload();
        r0.updatePersonalContextPayload = r3.getUpdatePersonalContextPayload();
        r0.uploadInfoPayload = r3.getUploadInfoPayload();
        r0.trace = r3.getTrace();
        r0.playerStatus = r3.getPlayerStatus();
        r0.volume = r3.getVolume();
        r0.sceneType = r3.getSceneType();
        r0.imageId = r3.getImageId();
        r0.wakeupId = r3.getWakeupId();
        r0.imageType = r3.getImageType();
        r0.intentMode = r3.getIntentMode();
        r0.imageStatus = r3.getImageStatus();
        r0.highQuality = r3.getHighQuality();
        r0.enableTouch = r3.getEnableTouch();
        r0.enableBurst = r3.getEnableBurst();
        r0.enableAudioRecorder = r3.getEnableAudioRecorder();
        r0.audioRecordChannels = r3.getAudioRecordChannels();
        r0.imgData = toActualBytes(r3.getImgData(), r3.getImgDataLen());
        r0.updateAudioConfigPayload = r3.getUpdateAudioConfigPayload();
        r0.multimodalStatus = r3.getMultimodalStatus();
        r0.vuiQueryMode = r3.getVuiQueryMode();
        r0.enableOneShot = r3.getEnableOneShot();
        r0.wakeupWord = r3.getWakeupWord();
        r0.wakeupAudioDurationMs = r3.getWakeupAudioDurationMs();
        SpeechVoiceAssistantSessionRequestType r4 = r3.getRequestType();
        if (r4 == null) goto L14;
        r0.requestType = r4.getValue();
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L7;
        r0.enableAudioInput = true;
        goto L14
    L7:
        if (r5 != 2) goto L9;
        r0.enableTextReading = true;
        goto L14
    L9:
        if (r5 != 3) goto L14;
        r0.enableTextReading = true;
    L14:
        return r0;
    }

    private static final int actualSize(byte[] r0, int r1) {
        int r2 = r0.length;
        if (r1 > 0) goto L5;
        return r2;
    L5:
        return Math.min(r1, r2);
    }

    private static final byte[] toActualBytes(byte[] r2, int r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.length != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return null;
    L11:
        int r4 = actualSize(r2, r3);
        if (r4 != r2.length) goto L15;
        return r2;
    L15:
        return Arrays.copyOf(r2, r4);
    L8:
        r1 = false;
        goto L9
    }
}
