package com.larus.asr;

import com.larus.asr.handsfree.HandsfreeDirectEntry;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class ChatBottomSpeakerComponent$d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[VoiceInputType.values().length];
        r0[VoiceInputType.ClickSpeaker.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L21:
        r0[VoiceInputType.DoraVoiceSpeaker.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L29:
        r0[VoiceInputType.ThirdPartySpeaker.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L23:
        r0[VoiceInputType.DoraRadioSpeaker.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L8:
        a = r0;
        int[] r1 = new int[HandsfreeDirectEntry.values().length];
        r1[HandsfreeDirectEntry.MIC_ICON_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
    L25:
        r1[HandsfreeDirectEntry.VOICE_INPUT_BUTTON_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
    L11:
        b = r1;
    }
}
