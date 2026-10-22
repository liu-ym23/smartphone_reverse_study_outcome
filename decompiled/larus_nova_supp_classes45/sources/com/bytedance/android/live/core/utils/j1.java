package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveModeKt_androidKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j1 {
    static {
    }

    @JvmStatic
    public static final String a(LiveMode r1) {
        if (r1 == null) goto L4;
        String r2 = LiveModeKt_androidKt.getSceneName(r1);
    L5:
        if (r2 != null) goto L8;
        return "";
    L8:
        switch(r2.hashCode()) {
            case 3165170: goto L23;
            case 93166550: goto L20;
            case 103772132: goto L17;
            case 112202875: goto L14;
            case 439491086: goto L11;
            default: goto L36;
        };
    L36:
        return "";
    L11:
        if (r2.equals("third_party") == true) goto L29;
        return "";
    L29:
        return "third_party";
    L14:
        if (r2.equals(FileUtils.VIDEO) == false) goto L31;
        return "video_live";
    L31:
        return "";
    L17:
        if (r2.equals("media") == false) goto L32;
        return "media";
    L32:
        return "";
    L20:
        if (r2.equals("audio") == false) goto L33;
        return "voice_live";
    L33:
        return "";
    L23:
        if (r2.equals("game") == false) goto L34;
        return "game";
    L34:
        return "";
    L4:
        r2 = null;
        goto L5
    }
}
