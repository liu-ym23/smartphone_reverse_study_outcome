package com.larus.avlink.impl;

import android.media.AudioManager;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a() {
        Object r2 = AppHost.a.getApplication().getSystemService("audio");     // Catch: Exception -> L17
        if ((r2 instanceof AudioManager) == false) goto L6;
        AudioManager r3 = (AudioManager) r2;     // Catch: Exception -> L17
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        int r4 = r3.getStreamVolume(3);     // Catch: Exception -> L17
        if (Build.VERSION.SDK_INT < 28) goto L12;
        int r5 = r3.getStreamMinVolume(3);     // Catch: Exception -> L17
    L13:
        int r6 = (int) ((((double) (r3.getStreamMaxVolume(3) - r5)) * 0.125d) + ((double) r5));     // Catch: Exception -> L17
        FLogger.a.i("DoraAVLinkPlatform", "adjustSystemVoice systemVolume:" + r4 + " expectVoice:" + r6);     // Catch: Exception -> L17
        if (r4 >= r6) goto L22;
        r3.setStreamVolume(3, r6, 1);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L12:
        r5 = 0;
        goto L13
    L6:
        r3 = null;
    L17:
        e = move-exception;
        FLogger.a.e("DoraAVLinkPlatform", "adjustSystemVoice failed", e);
    }
}
