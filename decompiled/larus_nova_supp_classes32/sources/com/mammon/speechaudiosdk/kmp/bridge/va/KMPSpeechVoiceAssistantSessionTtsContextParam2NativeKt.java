package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.structures.SAMICoreTtsContextCreateParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionTtsContextParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreTtsContextCreateParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionTtsContextParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionTtsContextParam2NativeKt {
    public static final SAMICoreTtsContextCreateParameter toNative(SpeechVoiceAssistantSessionTtsContextParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        SAMICoreTtsContextCreateParameter r0 = new SAMICoreTtsContextCreateParameter();
        r0.format = r2.getAudioConfig().getFormat();
        r0.sampleRate = r2.getAudioConfig().getSampleRate();
        r0.bitRate = r2.getAudioConfig().getBitRate();
        r0.enableNetTransportCompress = r2.getAudioConfig().getEnableNetTransportCompress();
        r0.speaker = r2.getSpeaker();
        r0.extra = r2.getExtra();
        r0.internal = r2.getInternalParam();
        return r0;
    }
}
