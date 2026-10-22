package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.utils.BuildDiff;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i1 {
    public static final String a(ILiveMode r2) {
        String r1 = null;
        if (BuildDiff.INSTANCE.isSaas() == true) goto L5;
        if (r2 == null) goto L11;
        r1 = IRoomKtKt.getSceneName(r2);
    L11:
        if (r1 != null) goto L14;
        return "";
    L14:
        switch(r1.hashCode()) {
            case 3165170: goto L29;
            case 93166550: goto L26;
            case 103772132: goto L23;
            case 112202875: goto L20;
            case 439491086: goto L17;
            default: goto L42;
        };
    L42:
        return "";
    L17:
        if (r1.equals("third_party") == true) goto L35;
        return "";
    L35:
        return "third_party";
    L20:
        if (r1.equals(FileUtils.VIDEO) == false) goto L37;
        return "video_live";
    L37:
        return "";
    L23:
        if (r1.equals("media") == false) goto L38;
        return "media";
    L38:
        return "";
    L26:
        if (r1.equals("audio") == false) goto L39;
        return "voice_live";
    L39:
        return "";
    L29:
        if (r1.equals("game") == false) goto L40;
        return "game";
    L40:
        return "";
    L5:
        if ((r2 instanceof ILiveMode) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L11;
        r1 = r2.getSceneName();
        goto L11
    }
}
