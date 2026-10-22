package com.ss.ttvideoengine.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface FormatProvider {
    public static final FormatProvider DEFAULT = null;
    public static final int FORMAT_M3U8 = 1;
    public static final int FORMAT_MPD = 2;
    public static final int FORMAT_NORMAL = 0;

    public static class Default implements FormatProvider {
        public Default() {
        }

        private static boolean isM3u8(String r1) {
            if (r1.contains(".m3u8?") == false) goto L5;
        L12:
            return true;
        L5:
            if (r1.endsWith(".m3u8") == true) goto L12;
            if (r1.contains(".m3u?") == true) goto L12;
            if (r1.endsWith(".m3u") == true) goto L12;
            return false;
        }

        private static boolean isMpd(String r1) {
            if (r1.endsWith(".mpd") == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.contains(".mpd?") == true) goto L8;
            return false;
        }

        @Override // com.ss.ttvideoengine.utils.FormatProvider
        public int provideFormat(String r3) {
            if (r3 != null) goto L5;
            return 0;
        L5:
            String r4 = r3.toLowerCase();
            if (isM3u8(r4) == false) goto L10;
            return 1;
        L10:
            if (isMpd(r4) == false) goto L13;
            return 2;
        L13:
            return 0;
        }
    }

    public static class FormatProviderHolder {
        private static FormatProvider sInstance;

        public FormatProviderHolder() {
        }

        static {
            sInstance = FormatProvider.DEFAULT;
        }

        public static FormatProvider get() {
            FormatProvider r0 = sInstance;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return FormatProvider.DEFAULT;
        }

        public static boolean isM3u8(String r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            if (get().provideFormat(r2) != 1) goto L9;
            return true;
        L9:
            return false;
        }

        public static boolean isMpd(String r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            if (get().provideFormat(r2) != 2) goto L9;
            return true;
        L9:
            return false;
        }

        public static void set(FormatProvider r0) {
            sInstance = r0;
        }
    }

    int provideFormat(String r1);

    static {
        DEFAULT = new Default();
    }
}
