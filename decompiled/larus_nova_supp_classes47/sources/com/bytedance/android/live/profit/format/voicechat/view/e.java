package com.bytedance.android.live.profit.format.voicechat.view;

import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[VoiceChatState.values().length];
        a = r0;
        r0[VoiceChatState.CONNECTING.ordinal()] = 1;
        r0[VoiceChatState.TIME_UP.ordinal()] = 2;
        r0[VoiceChatState.SPEAKING.ordinal()] = 3;
        r0[VoiceChatState.THINKING.ordinal()] = 4;
        r0[VoiceChatState.LISTENING.ordinal()] = 5;
        r0[VoiceChatState.WAITING.ordinal()] = 6;
    }
}
