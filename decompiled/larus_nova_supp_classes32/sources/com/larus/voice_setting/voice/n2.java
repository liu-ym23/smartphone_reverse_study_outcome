package com.larus.voice_setting.voice;

import android.media.AudioManager;
import com.larus.common.apphost.AppHost;
import com.lynx.jsbridge.LynxResourceModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n2 {
    static {
    }

    public static int a() {
        Object r0 = AppHost.a.getApplication().getSystemService(LynxResourceModule.AUDIO_TYPE);
        if ((r0 instanceof AudioManager) == false) goto L5;
        AudioManager r1 = (AudioManager) r0;
    L7:
        if (r1 == null) goto L9;
        int r2 = r1.getStreamVolume(3);
    L10:
        if (r1 == null) goto L12;
        int r3 = r1.getStreamMaxVolume(3);
    L14:
        return (int) ((r2 / r3) * 100);
    L12:
        r3 = 15;
        goto L14
    L9:
        r2 = 0;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
