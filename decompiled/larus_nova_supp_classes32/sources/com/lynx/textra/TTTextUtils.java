package com.lynx.textra;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TTTextUtils {
    public static Context context = null;
    public static float density_ = 1.0f;

    public TTTextUtils() {
    }

    public static float Dp2Px(float r0, float r1) {
        return (r0 * r1) / 160.0f;
    }

    public static float Px2Dp(float r1, float r2) {
        return (r1 * 160.0f) / r2;
    }

    public static native int nativeGetSystemPropInt(String r0);

    public static String SystemDefaultFamilyName() {
        Context r0 = context;
        if (r0 != null) goto L7;
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    L7:
        return PlatformFontCaps.Factory.getStrategy(r0).defaultFamilyName();
    }

    public static float Dp2Px(float r1) {
        return r1 * density_;
    }

    public static float Px2Dp(float r1) {
        return r1 / density_;
    }

    public static void SetDpi(float r2) {
        monitor-enter(TTTextUtils.class);
        density_ = r2 / 160.0f;     // Catch: Throwable -> L8
        monitor-exit(TTTextUtils.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static byte[] SystemFontStyleAdjust(float r2, short r3) {
        BBufferOutputStream r0 = new BBufferOutputStream(6);
        r0.writeFloat(r2);
        Context r4 = context;
        if (r4 == null) goto L5;
        r0.writeShort(PlatformFontCaps.Factory.getStrategy(r4).adjust(r3));
    L7:
        return r0.getByteArray();
    L5:
        r0.writeShort(r3);
        goto L7
    }
}
