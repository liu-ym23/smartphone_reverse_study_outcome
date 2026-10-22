package com.ss.ttvideoengine.strategrycenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StrategyKeys {
    public static int mInteractionBlockDurationNonPreloaded = 800;
    public static int mInteractionBlockDurationPreloaded = 400;

    public StrategyKeys() {
    }

    public static void setIntValue(int r1, int r2) {
        if (r1 != 120) goto L5;
        mInteractionBlockDurationPreloaded = r2;
        return;
    L5:
        if (r1 != 121) goto L11;
        mInteractionBlockDurationNonPreloaded = r2;
        return;
    }
}
