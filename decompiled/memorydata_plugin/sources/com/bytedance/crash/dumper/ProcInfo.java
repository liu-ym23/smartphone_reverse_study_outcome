package com.bytedance.crash.dumper;

import com.bytedance.crash.jni.NativeBridge;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ProcInfo {
    public static final long GB = 1073741824;
    public static final long KB = 1024;
    public static final long MB = 1048576;

    public ProcInfo() {
    }

    public static int getFdCount(File r0) {
        return NativeBridge.getFdCount(r0.getAbsolutePath());
    }

    public static String getFdCountRange(int r1) {
        if (r1 <= 2000) goto L7;
        return "(2000 - MAX)";
    L7:
        if (r1 <= 1500) goto L11;
        return "(1500 - 2000]";
    L11:
        if (r1 <= 1200) goto L15;
        return "(1200 - 1500]";
    L15:
        if (r1 <= 960) goto L19;
        return "(960 - 1200]";
    L19:
        if (r1 <= 800) goto L23;
        return "(800 - 960]";
    L23:
        if (r1 <= 600) goto L27;
        return "(600 - 800]";
    L27:
        if (r1 <= 400) goto L30;
        return "(400 - 600]";
    L30:
        return "(0 - 400]";
    }

    public static int getPthreadKeyCount(File r0) {
        return NativeBridge.PthreadKeyCount(r0.getAbsolutePath());
    }

    public static String getPthreadKeyCountRange(int r1) {
        if (r1 <= 120) goto L7;
        return "(120 - MAX]";
    L7:
        if (r1 <= 100) goto L11;
        return "(100 - 120]";
    L11:
        if (r1 <= 80) goto L15;
        return "(80 - 100]";
    L15:
        if (r1 <= 60) goto L19;
        return "(60 - 80]";
    L19:
        if (r1 <= 40) goto L22;
        return "(40 - 60]";
    L22:
        return "(0 - 40]";
    }

    public static int getThreadCount(File r0) {
        return NativeBridge.getThreadCount(r0.getAbsolutePath());
    }

    public static String getThreadCountRange(int r1) {
        if (r1 <= 750) goto L7;
        return "(750 - MAX)";
    L7:
        if (r1 <= 650) goto L11;
        return "(650 - 750]";
    L11:
        if (r1 <= 550) goto L15;
        return "(550 - 650]";
    L15:
        if (r1 <= 450) goto L19;
        return "(450 - 550]";
    L19:
        if (r1 <= 350) goto L23;
        return "(350 - 450]";
    L23:
        if (r1 <= 250) goto L27;
        return "(250 - 350]";
    L27:
        if (r1 <= 150) goto L30;
        return "(150 - 250]";
    L30:
        return "[0 - 150]";
    }

    private static long getVmMaxSize(boolean r2) {
        if (r2 == false) goto L4;
        return 4294967296L;
    L4:
        return 3221225472L;
    }

    public static long getVmPeakKb(File r2) {
        return NativeBridge.getVmSize(r2.getAbsolutePath(), true);
    }

    public static String getVmRange64(long r2) {
        long r3 = r2 * 1024;
        if (r3 <= 25769803776L) goto L7;
        return "(24GB - MAX)";
    L7:
        if (r3 <= 21474836480L) goto L11;
        return "(20GB - 24GB]";
    L11:
        if (r3 <= 17179869184L) goto L15;
        return "(16GB - 20GB]";
    L15:
        if (r3 <= 12884901888L) goto L19;
        return "(12GB - 16GB]";
    L19:
        if (r3 <= 10737418240L) goto L23;
        return "(10GB - 12GB]";
    L23:
        if (r3 <= 9663676416L) goto L27;
        return "(9GB - 10GB]";
    L27:
        if (r3 <= 8589934592L) goto L31;
        return "(8GB - 9GB]";
    L31:
        if (r3 <= 7516192768L) goto L35;
        return "(7GB - 8GB]";
    L35:
        if (r3 <= 6442450944L) goto L39;
        return "(6GB - 7GB]";
    L39:
        if (r3 <= 5368709120L) goto L43;
        return "(5GB - 6GB]";
    L43:
        if (r3 <= 4294967296L) goto L46;
        return "(4GB - 5GB]";
    L46:
        return "[0GB - 4GB]";
    }

    public static long getVmRssKb(File r2) {
        return NativeBridge.getVmRss(r2.getAbsolutePath());
    }

    public static String getVmRssRange(long r2) {
        long r3 = r2 * 1024;
        if (r3 <= 5368709120L) goto L7;
        return "(5GB - MAX)";
    L7:
        if (r3 <= 4294967296L) goto L11;
        return "(4GB - 5GB]";
    L11:
        if (r3 <= 3221225472L) goto L15;
        return "(3GB - 4GB]";
    L15:
        if (r3 <= 2147483648L) goto L19;
        return "(2GB - 3GB]";
    L19:
        if (r3 <= GB) goto L23;
        return "(1GB - 2GB]";
    L23:
        if (r3 <= 939524096) goto L27;
        return "(896MB - 1GB]";
    L27:
        if (r3 <= 805306368) goto L31;
        return "(768MB - 896MB]";
    L31:
        if (r3 <= 671088640) goto L35;
        return "(640MB - 768MB]";
    L35:
        if (r3 <= 536870912) goto L39;
        return "(512MB - 640MB]";
    L39:
        if (r3 <= 402653184) goto L43;
        return "(384MB - 512MB]";
    L43:
        if (r3 <= 268435456) goto L47;
        return "(256MB - 384MB]";
    L47:
        if (r3 <= 134217728) goto L50;
        return "(128MB - 256MB]";
    L50:
        return "(0MB - 128MB]";
    }

    public static long getVmSizeKb(File r2) {
        return NativeBridge.getVmSize(r2.getAbsolutePath(), false);
    }

    public static String getVmUsage32(long r4, boolean r6) {
        float r5 = r4 * 1024;
        float r7 = getVmMaxSize(r6);
        if (r5 <= (0.95f * r7)) goto L7;
        return "(95% - 100%]";
    L7:
        if (r5 <= (0.9f * r7)) goto L11;
        return "(90% - 95%]";
    L11:
        if (r5 <= (0.85f * r7)) goto L15;
        return "(85% - 90%]";
    L15:
        if (r5 <= (0.8f * r7)) goto L19;
        return "(80% - 85%]";
    L19:
        if (r5 <= (0.7f * r7)) goto L23;
        return "(70% - 80%]";
    L23:
        if (r5 <= (0.6f * r7)) goto L27;
        return "(60% - 70%]";
    L27:
        if (r5 <= (r7 * 0.5f)) goto L30;
        return "(50% - 60%]";
    L30:
        return "[0% - 50%]";
    }

    public static int getVmaCount(File r0) {
        return NativeBridge.getVmaCount(r0.getAbsolutePath());
    }

    public static boolean isFdLeak(int r6) {
        if (r6 <= (((double) NativeBridge.getFdLimit()) * 0.9d)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMemoryLeak32(long r2, boolean r4) {
        if ((r2 * 1024) <= (getVmMaxSize(r4) * 0.9f)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isPthreadKeyLeak(int r1) {
        if (r1 <= 100) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isRssExcess(long r2) {
        if (r2 <= 209715200) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isThreadLeak(int r1) {
        if (r1 <= 350) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isVmaCountLeak(int r1) {
        if (r1 <= 60000) goto L5;
        return true;
    L5:
        return false;
    }
}
