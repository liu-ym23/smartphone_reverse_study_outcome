package com.larus.audio.asr;

import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneBroadcastEventType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class p0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[KMPFlowAudioSceneBroadcastEventType.values().length];
        r0[KMPFlowAudioSceneBroadcastEventType.ASR_WAIT_REPLY_BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[KMPFlowAudioSceneBroadcastEventType.ASR_WAIT_REPLY_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
