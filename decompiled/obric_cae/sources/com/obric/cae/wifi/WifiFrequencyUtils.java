package com.obric.cae.wifi;

/* JADX INFO: loaded from: classes2.dex */
public class WifiFrequencyUtils {
    public static final int BAND_24_GHZ = 1;
    public static final int BAND_5_GHZ = 2;
    public static final int BAND_6_GHZ = 3;
    public static final int BAND_UNKNOWN = 0;
    public static final int BASE_FREQ_24GHZ = 2407;
    public static final int BASE_FREQ_5GHZ = 5000;
    public static final int BASE_FREQ_6GHZ = 5950;
    public static final int CHANNEL_SPACING = 5;
    public static final int MAX_FREQ_24GHZ = 2484;
    public static final int MAX_FREQ_5GHZ = 5885;
    public static final int MAX_FREQ_6GHZ = 7125;
    public static final int MIN_FREQ_24GHZ = 2412;
    public static final int MIN_FREQ_5GHZ = 5170;
    public static final int MIN_FREQ_6GHZ = 5925;

    public WifiFrequencyUtils() {
    }

    public static int getBand(int r8) {
        if (r8 < 2412) goto L9;
        if (r8 > 2484) goto L9;
        return 1;
    L9:
        if (r8 < 5170) goto L15;
        if (r8 > 5885) goto L15;
        return 2;
    L15:
        if (r8 >= 5925) goto L17;
        return 0;
    L17:
        if (r8 > 7125) goto L22;
        return 3;
    L22:
        return 0;
    }

    public static String getBandString(int r8) {
        if (r8 != 1) goto L5;
        return "2.4GHz";
    L5:
        if (r8 != 2) goto L7;
        return "5GHz";
    L7:
        if (r8 == 3) goto L10;
        return "Unknown";
    L10:
        return "6GHz";
    }

    public static int getChannel(int r8) {
        if (r8 < 2412) goto L13;
        if (r8 > 2484) goto L13;
        if (r8 != 2484) goto L9;
        return 14;
    L9:
        int r10 = r8 - 2407;
    L11:
        return r10 / 5;
    L13:
        if (r8 < 5170) goto L18;
        if (r8 > 5885) goto L18;
        r10 = r8 - 5000;
    L18:
        if (r8 >= 5925) goto L20;
        return -1;
    L20:
        if (r8 > 7125) goto L24;
        r10 = r8 - 5950;
        goto L11
    L24:
        return -1;
    }
}
