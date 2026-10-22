package com.mammon.audiosdk.structures;

import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SAMICoreWakeupAdaptiveEmbeddingSaveParameter {
    public int save;
    public String wkrId;

    public SAMICoreWakeupAdaptiveEmbeddingSaveParameter() {
        this(NameKeys.UnloadStrategy_No_Strategy, 1);
    }

    public SAMICoreWakeupAdaptiveEmbeddingSaveParameter(long r1, int r3) {
        this(String.valueOf(r1), r3);
    }

    public SAMICoreWakeupAdaptiveEmbeddingSaveParameter(String r1, int r2) {
        this.wkrId = r1;
        this.save = r2;
    }
}
