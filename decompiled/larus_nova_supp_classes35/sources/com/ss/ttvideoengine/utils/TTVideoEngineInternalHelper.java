package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TTVideoEngineInternalHelper {
    public TTVideoEngineInternalHelper() {
    }

    public static float getVolume(Context r2) {
        if (r2 != null) goto L5;
        return 0.0f;
    L5:
        int r0 = 0;
        AudioManager r3 = (AudioManager) r2.getSystemService("audio");     // Catch: Exception -> L16
        if (r3 == null) goto L10;
        int r4 = r3.getStreamVolume(3);     // Catch: Exception -> L16
    L11:
        if (r4 < 0) goto L15;
        r0 = r4;
        goto L15
    L10:
        r4 = 0;
    L15:
        return r0;
    }
}
