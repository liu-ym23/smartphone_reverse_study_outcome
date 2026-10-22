package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionAsrContextParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTokenType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreAsrContextCreateParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAsrContextParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionAsrContextParam2NativeKt {
    public static final SAMICoreAsrContextCreateParameter toNative(SpeechVoiceAssistantSessionAsrContextParam r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SAMICoreAsrContextCreateParameter r0 = new SAMICoreAsrContextCreateParameter();
        r0.url = r5.getUrl();
        r0.appKey = r5.getAppKey();
        r0.header = r5.getHeader();
        r0.taskId = r5.getTaskId();
        r0.sessionId = r5.getSessionId();
        SpeechAudioTokenType r1 = r5.getTokenType();
        int[] r2 = null;
        if (r1 == null) goto L5;
        SAMICoreTokenType r3 = SAMICoreTokenType.fromInt(r1.getValue());
    L6:
        r0.tokenType = r3;
        r0.token = r5.getToken();
        r0.format = r5.getAudioConfig().getFormat();
        r0.sampleRate = r5.getAudioConfig().getSampleRate();
        r0.channel = r5.getAudioConfig().getChannel();
        r0.connect_timeout = r5.getConnectTimeout();
        r0.language = r5.getLanguage();
        r0.extra = r5.getExtra();
        r0.model = r5.getModel();
        r0.sos_silence_timeout = r5.getSosSilenceTimeout();
        r0.eos_silence_timeout = r5.getEosSilenceTimeout();
        r0.sentence_max_time = r5.getSentenceMaxTime();
        r0.enable_punctuation = r5.getEnablePunctuation();
        r0.enable_speaker_diarization = r5.getEnableSpeakerDiarization();
        r0.timestamp = r5.getTimestamp();
        r0.enable_audio_cache = r5.getEnableAudioCache();
        r0.audio_cache_size = r5.getAudioCacheSize();
        r0.enable_remove_first_audio_data = r5.getEnableRemoveFirstAudioData();
        r0.enable_net_transport_compress = r5.getAudioConfig().getEnableNetTransportCompress() ? 1 : 0;
        r0.business_info = r5.getBusinessInfo();
        r0.enable_speech_rejection = r5.getEnableSpeechRejection();
        r0.audio_src = r5.getAudioSrc();
        r0.retry_mode = r5.getRetryMode();
        r0.retry_count = r5.getRetryCount();
        List<Integer> r4 = r5.getRetryIntervalTimeMs();
        if (r4 == null) goto L9;
        r2 = CollectionsKt.toIntArray(r4);
    L9:
        r0.retry_interval_time_ms = r2;
        r0.max_buffer_count = r5.getMaxBufferCount();
        r0.finish_wait_timeout = r5.getFinishWaitTimeout();
        return r0;
    L5:
        r3 = null;
        goto L6
    }
}
