package com.bytedance.android.live.core.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class PerformanceUtil {
    private static final long CPU_STAT_WAITING = 360;
    public static final int DEVICE_PERFORMANCE_HIGH = 3;
    public static final int DEVICE_PERFORMANCE_MEDIUM = 2;
    public static final int DEVICE_PERFORMANCE_POOR = 1;
    public static final int DEVICE_PERFORMANCE_UNKOWN = 0;
    private static final int DEVICE_SCORE_0 = 0;
    private static final int DEVICE_SCORE_1 = 1;
    private static final int DEVICE_SCORE_2 = 2;
    private static final int DEVICE_SCORE_3 = 3;
    private static final int DEVICE_SCORE_4 = 4;
    private static final int DEVICE_SCORE_5 = 5;
    private static final int DEVICE_SCORE_6 = 6;
    private static final int DEVICE_SCORE_7 = 7;
    private static final int[] MAX_CLOCK_SPEED_FOR_SCORE = null;
    private static final int[] MAX_RAM_FOR_SCORE = null;
    private static final long MB = 1048576;
    private static final int MHZ_IN_KHZ = 1000;
    private static String sCpuSpeedRateValue;
    private static String sCpuValue;
    private static long sLastGetCpuSpeedRateTime;
    private static long sLastGetCpuTime;

    static {
        MAX_RAM_FOR_SCORE = new int[]{0, 192, 290, 512, RomUtils.SZ, 1536, 2048};
        MAX_CLOCK_SPEED_FOR_SCORE = new int[]{0, 528, 620, 1020, 1220, 1520, 2020};
        sLastGetCpuTime = -1;
        sCpuValue = "";
        sLastGetCpuSpeedRateTime = -1;
        sCpuSpeedRateValue = "";
    }

    private static int getClockSpeedScore() {
        e0.a r0 = e0.a;
        int r1 = -1;
        int r2 = 0;
        int r3 = -1;
    L79:
        if (r2 >= e0.c()) goto L23;
        PolarisFileWrapper r7 = new PolarisFileWrapper("/sys/devices/system/cpu/cpu" + r2 + "/cpufreq/cpuinfo_max_freq");     // Catch: IOException -> L53
        if (r7.exists() == false) goto L22;
        byte[] r8 = new byte[128];     // Catch: IOException -> L53
        PolarisFileInputStreamWrapper r9 = new PolarisFileInputStreamWrapper(r7);     // Catch: IOException -> L53
        r9.read(r8);     // Catch: Throwable -> L18 NumberFormatException -> L77
        int r11 = 0;
    L11:
        if (Character.isDigit(r8[r11]) == false) goto L14;
        if (r11 >= 128) goto L14;
        r11 = r11 + 1;     // Catch: Throwable -> L18 NumberFormatException -> L77
    L14:
        Integer r6 = Integer.valueOf(Integer.parseInt(new String(r8, 0, r11)));     // Catch: Throwable -> L18 NumberFormatException -> L77
        if (r6.intValue() <= r3) goto L21;
        r3 = r6.intValue();     // Catch: Throwable -> L18 NumberFormatException -> L77
    L18:
        th = move-exception;
        r9.close();     // Catch: IOException -> L53
        throw th;     // Catch: IOException -> L53
    L21:
        r9.close();     // Catch: IOException -> L53
    L22:
        r2 = r2 + 1;     // Catch: IOException -> L53
        goto L79
    L23:
        if (r3 != (-1)) goto L52;
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper("/proc/cpuinfo");     // Catch: IOException -> L53
        byte[] r12 = new byte[RomUtils.SZ];     // Catch: Throwable -> L41
        int r13 = r4.read(r12);     // Catch: Throwable -> L41 Throwable -> L78
        int r14 = 0;
    L27:
        if (r14 >= r13) goto L45;
        byte r15 = r12[r14];     // Catch: Throwable -> L41 Throwable -> L78
        if (r15 == 10) goto L31;
        if (r14 == 0) goto L31;
    L44:
        r14 = r14 + 1;
    L31:
        if (r15 != 10) goto L33;
        r14 = r14 + 1;     // Catch: Throwable -> L41 Throwable -> L78
    L33:
        int r16 = r14;
    L34:
        if (r16 >= r13) goto L44;
        int r17 = r16 - r14;     // Catch: Throwable -> L41 Throwable -> L78
        if (r12[r16] != "cpu MHz".charAt(r17)) goto L44;
        if (r17 == 6) goto L39;
        r16 = r16 + 1;
        goto L34
    L39:
        int r18 = e0.a(r12, r16);     // Catch: Throwable -> L41 Throwable -> L78
    L46:
        int r19 = r18 * 1000;
        if (r19 <= r3) goto L49;
        r3 = r19;
    L49:
        r4.close();     // Catch: IOException -> L53
        goto L52
    L45:
        r18 = -1;
    L41:
        th = move-exception;
        r4.close();     // Catch: IOException -> L53
        throw th;     // Catch: IOException -> L53
    L52:
        r1 = r3;
    L54:
        long r5 = r1;
        if (r5 != (-1)) goto L57;
        return 0;
    L57:
        int[] r21 = MAX_CLOCK_SPEED_FOR_SCORE;
        if (r5 > (r21[1] * 1000)) goto L61;
        return 1;
    L61:
        if (r5 > (r21[2] * 1000)) goto L64;
        return 2;
    L64:
        if (r5 > (r21[3] * 1000)) goto L67;
        return 3;
    L67:
        if (r5 > (r21[4] * 1000)) goto L70;
        return 4;
    L70:
        if (r5 > (r21[5] * 1000)) goto L73;
        return 5;
    L73:
        if (r5 > (r21[6] * 1000)) goto L75;
        return 6;
    L75:
        return 7;
    }

    public static long getDalvikPss() {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        return r0.dalvikPss;
    }

    public static float getDeviceCpuUsage() {
        RandomAccessFile r2 = new RandomAccessFile("/proc/stat", "r");     // Catch: Throwable -> L10
        String[] r1 = r2.readLine().split(" +");     // Catch: Throwable -> L10
        long r4 = CastLongProtector.parseLong(r1[4]);     // Catch: Throwable -> L10
        long r7 = ((((CastLongProtector.parseLong(r1[2]) + CastLongProtector.parseLong(r1[3])) + CastLongProtector.parseLong(r1[5])) + CastLongProtector.parseLong(r1[6])) + CastLongProtector.parseLong(r1[7])) + CastLongProtector.parseLong(r1[8]);
        Thread.sleep(CPU_STAT_WAITING);     // Catch: Exception -> L13 Throwable -> L10
    L7:
        r2.seek(0);     // Catch: Throwable -> L10
        String r3 = r2.readLine();     // Catch: Throwable -> L10
        r2.close();     // Catch: Throwable -> L10
        String[] r0 = r3.split(" +");     // Catch: Throwable -> L10
        long r5 = CastLongProtector.parseLong(r0[4]);     // Catch: Throwable -> L10
        long r14 = ((((CastLongProtector.parseLong(r0[2]) + CastLongProtector.parseLong(r0[3])) + CastLongProtector.parseLong(r0[5])) + CastLongProtector.parseLong(r0[6])) + CastLongProtector.parseLong(r0[7])) + CastLongProtector.parseLong(r0[8]);
        return (r14 - r7) / ((r14 + r5) - (r7 + r4));
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    }

    public static long getNativePss() {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        return r0.nativePss;
    }

    public static long getOtherPss() {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        return r0.otherPss;
    }

    public static long getTotalPss() {
        Debug.MemoryInfo r0 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r0);
        return r0.getTotalPss();
    }

    private static int getNumCoresScore() {
        int r0 = e0.c();
        if (r0 >= 1) goto L6;
        return 0;
    L6:
        if (r0 != 1) goto L10;
        return 2;
    L10:
        if (r0 > 3) goto L13;
        return 4;
    L13:
        return 6;
    }

    private PerformanceUtil() {
    }

    public static String getCpuSpeedRate() {
        return sCpuSpeedRateValue;
    }

    public static String getCpuUsage(String r4) {
        if ((SystemClock.elapsedRealtime() - sLastGetCpuTime) <= n5.DEFAULT_SHOW_DURATION) goto L6;
        i60.a.c();
        sCpuValue = String.valueOf(i60.a.d());
        sLastGetCpuTime = SystemClock.elapsedRealtime();
    L6:
        return sCpuValue;
    }

    private static int getRamScore(Context r8) {
        e0.a r0 = e0.a;
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        ActivityManager r9 = (ActivityManager) r8.getSystemService("activity");
        if (r9 != null) goto L5;
        long r2 = -1;
    L6:
        int[] r11 = MAX_RAM_FOR_SCORE;
        if (r2 > (((long) r11[0]) * MB)) goto L10;
        return 0;
    L10:
        if (r2 > (((long) r11[1]) * MB)) goto L13;
        return 1;
    L13:
        if (r2 > (((long) r11[2]) * MB)) goto L16;
        return 2;
    L16:
        if (r2 > (((long) r11[3]) * MB)) goto L19;
        return 3;
    L19:
        if (r2 > (((long) r11[4]) * MB)) goto L22;
        return 4;
    L22:
        if (r2 > (((long) r11[5]) * MB)) goto L25;
        return 5;
    L25:
        if (r2 > (((long) r11[6]) * MB)) goto L27;
        return 6;
    L27:
        return 7;
    L5:
        r9.getMemoryInfo(r1);
        r2 = r1.totalMem;
        goto L6
    }

    public static int getTotalScore(Context r4) {
        int r0 = getNumCoresScore();
        int r1 = getClockSpeedScore();
        int r5 = getRamScore(r4);
        Logger.d("PUtil", "coreScore " + r0 + " clockSpeedScore " + r1 + " ramScore " + r5);
        if (r0 == 0) goto L23;
        if (r1 == 0) goto L29;
        if (r5 != 0) goto L8;
        return 0;
    L8:
        if (r0 <= 4) goto L21;
        if (r1 <= 4) goto L27;
        if (r5 > 4) goto L13;
        return 1;
    L13:
        if (r0 == 6) goto L15;
        return 2;
    L15:
        if (r1 != 7) goto L25;
        if (r5 != 7) goto L26;
        return 3;
    L26:
        return 2;
    L25:
        return 2;
    L27:
        return 1;
    L21:
        return 1;
    L29:
        return 0;
    L23:
        return 0;
    }
}
