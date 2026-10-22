package com.bytedance.android.live.core.utils;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class TimeUtils {
    private static final SimpleDateFormat CUR_TIME_FORMAT = null;
    private static final SimpleDateFormat H_M_S_TIME_FORMAT = null;
    private static final SimpleDateFormat LIVE_ROOM_OP_TIME_FORMAT = null;
    private static final SimpleDateFormat M_D_TIME_FORMAT = null;

    static {
        CUR_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        LIVE_ROOM_OP_TIME_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        M_D_TIME_FORMAT = new SimpleDateFormat("MM月dd日");
        H_M_S_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    }

    public static long currentTimeMillis() {
        return System.nanoTime() / 1000000;
    }

    private TimeUtils() {
    }

    public static String formatChineseDurationString(long r8) {
        if (r8 >= 0) goto L6;
        return "";
    L6:
        int r3 = (int) (r8 / 86400000);
        long r9 = r8 % 86400000;
        int r2 = (int) (r9 / 3600000);
        long r11 = r9 % 3600000;
        int r5 = (int) (r11 / 60000);
        int r12 = (int) ((r11 % 60000) / 1000);
        StringBuilder r13 = new StringBuilder();
        if (r3 <= 0) goto L10;
        r13.append(r3);
        r13.append(s1.p(2131755238, r3));
    L10:
        if (r3 > 0) goto L12;
        if (r2 > 0) goto L12;
    L13:
        Locale r4 = Locale.ROOT;
        r13.append(String.format(r4, "%02d", new Object[]{Integer.valueOf(r5)}));
        r13.append(s1.p(2131755240, r5));
        r13.append(String.format(r4, "%02d", new Object[]{Integer.valueOf(r12)}));
        r13.append(s1.p(2131755242, r12));
        return r13.toString();
    L12:
        r13.append(String.format(Locale.ROOT, "%02d", new Object[]{Integer.valueOf(r2)}));
        r13.append(s1.p(2131755239, r2));
        goto L13
    }

    public static String formatLiveDuration(int r5) {
        return String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[]{Integer.valueOf(r5 / 3600000), Integer.valueOf((r5 % 3600000) / 60000), Integer.valueOf((r5 % 60000) / 1000)});
    }

    public static String formatLiveRoomOpTime(long r2) {
        return LIVE_ROOM_OP_TIME_FORMAT.format(new Date(r2));
    }

    public static String formatVideoDuration(int r7) {
        int r1 = r7 / 3600000;
        int r0 = (r7 % 3600000) / 60000;
        int r8 = (r7 % 60000) / 1000;
        if (r1 != 0) goto L6;
        return String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(r0), Integer.valueOf(r8)});
    L6:
        return String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r0), Integer.valueOf(r8)});
    }

    public static boolean isToday(long r2) {
        SimpleDateFormat r0 = CUR_TIME_FORMAT;
        return r0.format(new Date(r2)).equals(r0.format(new Date()));
    }

    public static String getTimeDescription(Context r9, long r11) {
        long r0 = System.currentTimeMillis() - r11;
        if (r0 > 60000) goto L7;
        return r9.getString(2131915972);
    L7:
        if (r0 > 3600000) goto L11;
        int r12 = (int) (r0 / 60000);
        return r9.getResources().getQuantityString(2131755237, r12, new Object[]{Integer.valueOf(r12)});
    L11:
        if (r0 > 86400000) goto L15;
        int r13 = (int) (r0 / 3600000);
        return r9.getResources().getQuantityString(2131755235, r13, new Object[]{Integer.valueOf(r13)});
    L15:
        return CUR_TIME_FORMAT.format(new Date(r11));
    }

    public static boolean isToday(long r2, long r4) {
        SimpleDateFormat r0 = CUR_TIME_FORMAT;
        return r0.format(new Date(r2)).equals(r0.format(new Date(r4)));
    }

    public static String getTimeDescription(Context r7, long r8, long r11) {
        long r12 = r11 - r8;
        if (r12 > 60000) goto L7;
        return r7.getString(2131915972);
    L7:
        if (r12 > 3600000) goto L11;
        int r9 = (int) (r12 / 60000);
        return r7.getResources().getQuantityString(2131755237, r9, new Object[]{Integer.valueOf(r9)});
    L11:
        if (r12 > 86400000) goto L15;
        int r13 = (int) (r12 / 3600000);
        return r7.getResources().getQuantityString(2131755235, r13, new Object[]{Integer.valueOf(r13)});
    L15:
        return CUR_TIME_FORMAT.format(new Date(r8));
    }
}
