package com.lynx.tasm.ui.image;

import com.facebook.drawee.drawable.ScalingUtils;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o {
    public o() {
    }

    public static ScalingUtils.ScaleType a(ScalingUtils.ScaleType r1) {
        if (r1 != ScalingUtils.ScaleType.FIT_CENTER) goto L7;
        return h0.d;
    L7:
        if (r1 != ScalingUtils.ScaleType.CENTER_CROP) goto L11;
        return h0.c;
    L11:
        if (r1 != ScalingUtils.ScaleType.CENTER) goto L15;
        return h0.b;
    L15:
        if (r1 == ScalingUtils.ScaleType.FIT_XY) goto L17;
        return r1;
    L17:
        return h0.a;
    }

    public static ScalingUtils.ScaleType b(String r3) {
        if ("aspectFit".equals(r3) == false) goto L7;
        return ScalingUtils.ScaleType.FIT_CENTER;
    L7:
        if ("aspectFill".equals(r3) == false) goto L11;
        return ScalingUtils.ScaleType.CENTER_CROP;
    L11:
        if ("scaleToFill".equals(r3) == false) goto L15;
        return ScalingUtils.ScaleType.FIT_XY;
    L15:
        if ("center".equals(r3) == true) goto L17;
        if (r3 == null) goto L27;
        if (r3.equals(VoiceDisplayScene.NONE) == true) goto L27;
        if (r3.length() == 0) goto L27;
        throw new RuntimeException("Invalid resize mode: '" + r3 + "'");
    L27:
        return ScalingUtils.ScaleType.FIT_XY;
    L17:
        return ScalingUtils.ScaleType.CENTER;
    }
}
