package com.larus.audio.audiov3.task.sami.v2;

import com.larus.audio.audiov3.config.BusinessTypeEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public /* synthetic */ class a0$a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[BusinessTypeEnum.values().length];
        r0[BusinessTypeEnum.ASR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[BusinessTypeEnum.TTS_BY_MSG_ID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[BusinessTypeEnum.TTS_BY_TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
