package com.bytedance.crash.util;

import com.bytedance.crash.config.BitsConfig;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SlardarProperties {
    public SlardarProperties() {
    }

    public static String getReleaseBuild() {
        return BitsConfig.getReleaseBuild();
    }
}
