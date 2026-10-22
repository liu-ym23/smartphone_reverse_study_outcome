package com.mammon.speechaudiosdk.kmp.bridge;

import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantLoudnessStrategyParameter;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioLoudnessStrategyParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantLoudnessStrategyParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioLoudnessStrategyParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechAudioLoudnessStratergyParam2NativeKt {
    public static final SAMICoreVoiceAssistantLoudnessStrategyParameter toNative(SpeechAudioLoudnessStrategyParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        SAMICoreVoiceAssistantLoudnessStrategyParameter r0 = new SAMICoreVoiceAssistantLoudnessStrategyParameter();
        r0.metaData = r2.getMetaData();
        r0.deviceAiData = r2.getDeviceAiData();
        r0.loudNormAlgoType = r2.getLoudNormAlgoType();
        r0.audioDumpPath = r2.getAudioDumpPath();
        return r0;
    }
}
