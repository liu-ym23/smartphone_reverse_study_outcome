package com.larus.asr.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class ChatSpeakerStatus$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ChatSpeakerStatus.values().length];
        r0[ChatSpeakerStatus.Cancel.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[ChatSpeakerStatus.Speech.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
