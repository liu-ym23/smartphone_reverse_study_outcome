package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.setting.x;
import com.bytedance.android.livesdkapi.model.LiveAudioSubtitleSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L6;
    L7:
        if (r0 != null) goto L10;
    L12:
        return false;
    L10:
        if (r0.intValue() != 25) goto L12;
    L13:
        return true;
    L6:
        if (r0.intValue() == 29) goto L13;
        goto L7
    }

    static {
    }

    public static boolean b(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.intValue() != 25) goto L11;
    L12:
        return true;
    L5:
        if (r2.intValue() == 29) goto L12;
        goto L6
    }

    public static boolean c(boolean r0) {
        if (r0 == false) goto L7;
        if (((LiveAudioSubtitleSetting) x.a.getValue()).getRadioAnchorEnable() == false) goto L8;
    L9:
        return false;
    L8:
        return true;
    L7:
        if (((LiveAudioSubtitleSetting) x.a.getValue()).getRadioEnable() == true) goto L9;
        goto L8
    }

    public static boolean d(boolean r1) {
        if (r1 == false) goto L8;
        if (((LiveAudioSubtitleSetting) x.a.getValue()).getRadioAnchorEnable() == true) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (((LiveAudioSubtitleSetting) x.a.getValue()).getRadioEnable() != true) goto L10;
        return true;
    }
}
