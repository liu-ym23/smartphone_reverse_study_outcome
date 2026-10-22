package com.bytedance.apm.block.evil;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class EvilMethodSwitcher {
    public EvilMethodSwitcher() {
    }

    public static long getEvilThresholdMs() {
        return 1000;
    }

    public static long getLaunchEvilThresholdMs() {
        return 100;
    }

    public static boolean isLaunchLimitEvilMethodDepth() {
        return false;
    }

    public static boolean isLimitEvilMethodDepth() {
        return false;
    }

    public static boolean isMessageKeyEnable() {
        return false;
    }

    public static boolean isOpenLaunchEvilMethod() {
        return false;
    }
}
