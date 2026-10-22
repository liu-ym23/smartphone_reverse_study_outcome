package com.lynx.textra;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface PlatformFontCaps {
    public static final String DEFAULT_FAMILY_NAME = "sans-serif";
    public static final int MaxVariation = 1000;
    public static final int MinVariation = 100;

    /* JADX INFO: renamed from: com.lynx.textra.PlatformFontCaps$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static short $default$clamp(PlatformFontCaps r0, int r1) {
            if (r1 < 1000) goto L6;
            r1 = 1000;
        L6:
            if (r1 > 100) goto L9;
            r1 = 100;
        L9:
            return (short) r1;
        }
    }

    public static class Factory {
        public Factory() {
        }

        public static PlatformFontCaps getStrategy(Context r2) {
            String r0 = Build.BRAND;
            if ("oppo".equalsIgnoreCase(r0) == false) goto L7;
            return new OppoFontCaps(r2);
        L7:
            if ("vivo".equalsIgnoreCase(r0) == false) goto L11;
            return new VivoFontCaps();
        L11:
            if ("xiaomi".equalsIgnoreCase(r0) == false) goto L15;
            return new XiaomiFontCaps(r2);
        L15:
            if ("huawei".equalsIgnoreCase(r0) == false) goto L19;
            return new HuaweiFontCaps(r2);
        L19:
            if ("honor".equalsIgnoreCase(r0) == false) goto L23;
            return new HonorFontCaps(r2);
        L23:
            return new DefaultFontCaps();
        }
    }

    short adjust(short r1);

    short clamp(int r1);

    String defaultFamilyName();
}
