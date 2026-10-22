package com.larus.dora.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class DoraVoiceCallMonitor$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[DoraVoiceCallMonitor$EVENT.values().length];
        r0[DoraVoiceCallMonitor$EVENT.VAD_END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L23:
        r0[DoraVoiceCallMonitor$EVENT.TTS_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L35:
        r0[DoraVoiceCallMonitor$EVENT.VAD_END_TX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L25:
        r0[DoraVoiceCallMonitor$EVENT.TTS_START_RX.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L27:
        r0[DoraVoiceCallMonitor$EVENT.QUERY_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L21:
        r0[DoraVoiceCallMonitor$EVENT.QUERY_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L29:
        r0[DoraVoiceCallMonitor$EVENT.CLIENT_VAD_END.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L31:
        r0[DoraVoiceCallMonitor$EVENT.CLIENT_TTS_START.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L11:
        a = r0;
    }
}
