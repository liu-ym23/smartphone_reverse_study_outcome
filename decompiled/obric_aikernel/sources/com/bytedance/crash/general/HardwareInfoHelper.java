package com.bytedance.crash.general;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.ReflexHelper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class HardwareInfoHelper {
    private static final long DEFAULT_TICKS = 100;
    private static final String UNKNOWN = "unknown";

    public HardwareInfoHelper() {
    }

    @NonNull
    public static String getCpuAbi() {
        StringBuilder r10 = new StringBuilder();
    L19:
        e = move-exception;
        StringBuilder r11 = r10;
        Exception e10 = e;
    L21:
        NpthLog.w(e10);
    L22:
        r10 = r11;
    L23:
        String r12 = r10.toString();
        if (TextUtils.isEmpty(r12) == false) goto L33;
        return "unknown";
    L33:
        return r12;
    L4:
        if (Build.VERSION.SDK_INT < 21) goto L18;
        String[] r13 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L19
        if (r13.length <= 0) goto L23;
        r11 = new StringBuilder();     // Catch: Exception -> L19
        int r14 = 0;
    L27:
    L15:
        e10 = e;
        goto L21
    L10:
        if (r14 >= r13.length) goto L22;
        r11.append(r13[r14]);     // Catch: Exception -> L15
        if (r14 == (r13.length - 1)) goto L14;
        r11.append(", ");     // Catch: Exception -> L15
    L14:
        r14 = r14 + 1;
        goto L27
    L18:
        r10 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L19
        goto L23
    }

    @NonNull
    public static String getCpuHardware() {
        String r10 = Build.HARDWARE;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return "unknown";
    L6:
        return r10;
    }

    @NonNull
    public static String getCpuModel() {
        FileReader r10 = null;
        FileReader r11 = new FileReader("/proc/cpuinfo");     // Catch: Throwable -> L31 IOException -> L33
    L66:
        BufferedReader r12 = new BufferedReader(r11);     // Catch: Throwable -> L25 IOException -> L28
    L68:
        String r13 = r12.readLine();     // Catch: Throwable -> L21 IOException -> L23
        if (r13 == null) goto L19;
        if (r13.contains(":") == false) goto L68;
        String[] r14 = r13.split(":");     // Catch: Throwable -> L21 IOException -> L23
        if (r14[0].contains("Hardware") == true) goto L13;
        if (r14[0].contains("model name") == false) goto L68;
    L13:
        String r15 = r14[1];     // Catch: Throwable -> L21 IOException -> L23
        r11.close();     // Catch: IOException -> L16
        r12.close();     // Catch: IOException -> L16
    L18:
        return r15;
    L16:
        e = move-exception;
        NpthLog.e(e);
        goto L18
    L19:
        r11.close();     // Catch: IOException -> L38
        r12.close();     // Catch: IOException -> L38
    L44:
        String r16 = Build.BOARD;
        if (r16 != null) goto L77;
        return "unknown";
    L77:
        return r16;
    L23:
        e = e;
    L30:
        r10 = r11;
    L58:
        NpthLog.e(e);     // Catch: Throwable -> L48
        if (r10 == null) goto L40;
        r10.close();     // Catch: IOException -> L38
    L40:
        if (r12 == null) goto L44;
        r12.close();     // Catch: IOException -> L38
    L48:
        th = th;
    L49:
        if (r10 != null) goto L61;
    L53:
        if (r12 == null) goto L57;
        r12.close();     // Catch: IOException -> L51
    L51:
        e = move-exception;
        NpthLog.e(e);
    L57:
        throw th;
    L61:
        r10.close();     // Catch: IOException -> L51
    L21:
        th = th;
    L27:
        r10 = r11;
    L28:
        e = e;
        r12 = null;
    L25:
        th = th;
        r12 = null;
    L38:
        e = move-exception;
        NpthLog.e(e);
    L33:
        e = e;
        r12 = null;
    L31:
        th = th;
        r12 = null;
        goto L49
    }

    public static int getDisplayDensityInt(DisplayMetrics r10) {
        return r10.densityDpi;
    }

    @NonNull
    public static String getDisplayDensityStr(DisplayMetrics r10) {
        int r11 = r10.densityDpi;
        if (r11 != 120) goto L5;
        return "ldpi";
    L5:
        if (r11 != 240) goto L7;
        return "hdpi";
    L7:
        if (r11 == 320) goto L9;
        return "mdpi";
    L9:
        return "xhdpi";
    }

    @NonNull
    public static String getDisplayResolution(DisplayMetrics r10) {
        return r10.heightPixels + "x" + r10.widthPixels;
    }

    public static long getJiffies() {
        return 1000 / getScClkTck();
    }

    public static String getRamSize() {
        long r10 = getTotalMemorySizeFromFile();
        if (r10 != 0) goto L6;
        r10 = getTotalMemorySizeFromActivityManager();
    L6:
        return sizeToTag(r10);
    }

    private static long getScClkTck() {
        long r10 = -1;
        if (Build.VERSION.SDK_INT < 21) goto L15;
        r10 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L10:
        if (r10 > 0) goto L17;
        return 100;
    L17:
        return r10;
    L15:
        int r11 = ReflexHelper.getStaticInt("libcore.io.OsConstants", "_SC_CLK_TCK");     // Catch: Throwable -> L14
        Object r12 = ReflexHelper.getStaticObject("libcore.io.Libcore", "os");     // Catch: Throwable -> L14
        if (r12 == null) goto L10;
        r10 = ((Long) ReflexHelper.getMethod("libcore.io.Os", "sysconf", new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r11)})).longValue();     // Catch: Throwable -> L14
        goto L10
    }

    private static long getTotalMemorySizeFromActivityManager() {
        Context r10 = Global.getContext();
        if (r10 == null) goto L6;
        ActivityManager r11 = (ActivityManager) r10.getSystemService("activity");
        ActivityManager.MemoryInfo r12 = new ActivityManager.MemoryInfo();
        r11.getMemoryInfo(r12);
        return r12.totalMem;
    L6:
        return 0;
    }

    private static long getTotalMemorySizeFromFile() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new FileReader(CommonProcUtil.MEMORY_INFO_PATH));     // Catch: Throwable -> L16
        String r12 = r11.readLine();     // Catch: Throwable -> L12
        if (r12 != null) goto L7;
    L11:
        FileSystemUtils.close(r11);
        return 0;
    L7:
        if (r12.startsWith("MemTotal:") == false) goto L11;
        long r13 = Long.parseLong(r12.substring(9).trim().split(" ")[0]) * 1024;
        FileSystemUtils.close(r11);
        return r13;
    L12:
        r10 = r11;
    L13:
        FileSystemUtils.close(r10);
        return 0;
    }

    @NonNull
    public static String getVendorBrand() {
        String r10 = Build.BRAND;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return "unknown";
    L6:
        return r10;
    }

    @NonNull
    public static String getVendorManufacturer() {
        String r10 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return "unknown";
    L6:
        return r10;
    }

    @NonNull
    public static String getVendorModel() {
        String r10 = Build.BRAND;
        String r11 = Build.MODEL;
        if (TextUtils.isEmpty(r11) == false) goto L7;
        if (r10 != null) goto L13;
        return "unknown";
    L13:
        return r10;
    L7:
        if (r10 != null) goto L9;
    L12:
        return r11;
    L9:
        if (r11.contains(r10) == true) goto L12;
        return r10 + ' ' + r11;
    }

    static String sizeToTag(long r22) {
        if (r22 > 0) goto L6;
        return "Invalid";
    L6:
        long[] r10 = {256, 512, 1024, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, 3072, 4096, 5120, 6144, PlaybackStateCompat.ACTION_PLAY_FROM_URI, 10240, 12288, PlaybackStateCompat.ACTION_PREPARE, 24576, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID, 49152, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, 1048576};
        String[] r11 = {"256MB", "512MB", "1GB", "2GB", "3GB", "4GB", "5GB", "6GB", "8GB", "10GB", "12GB", "16GB", "24GB", "32GB", "48GB", "64GB", "128GB", "256GB", "512GB", "1TB"};
        int r12 = 0;
    L7:
        if (r12 >= 20) goto L13;
        if (r22 < ((r10[r12] * 1024) * 1024)) goto L11;
        r12 = r12 + 1;
        goto L7
    L11:
        return r11[r12];
    L13:
        return "1TB+";
    }
}
