package com.ttnet.org.chromium.base.library_loader;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
class ModernLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTime.";
    private static final String DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP = "ChromiumAndroidLinker.ModernLinkerDetailedLoadTimeByBlkioCgroup.";
    private static final String SELF_CGROUP_FILE_NAME = "/proc/self/cgroup";
    private static final String SUFFIX_UNKNOWN = "Unknown";
    private static final String TAG = "ModernLinker";
    private static Natives sNativesInstance;

    interface Natives {
        int getRelroSharingResult();

        boolean loadLibrary(String r10, Linker.LibInfo r11, boolean r12);

        boolean useRelros(long r10, Linker.LibInfo r11);
    }

    static {
    }

    ModernLinker() {
    }

    private static String extractBlkioCgroupFromLine(String r10) {
        int r11 = r10.indexOf(":blkio:");
        if (r11 != (-1)) goto L7;
        return "";
    L7:
        return r10.substring(r11 + 7);
    }

    @VisibleForTesting(otherwise = 2)
    static Natives getModernLinkerJni() {
        Natives r10 = sNativesInstance;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return new ModernLinkerJni();
    }

    private void loadAndProduceSharedRelro(String r10) {
        this.mLocalLibInfo.mLibFilePath = r10;
        boolean r11 = true;
        if (getModernLinkerJni().loadLibrary(r10, this.mLocalLibInfo, true) == true) goto L7;
        Log.e(TAG, "Unable to load with ModernLinker, using the system linker instead", new Object[0]);
        this.mLocalLibInfo.mRelroFd = -1;
    L7:
        if (this.mLocalLibInfo.mRelroFd != (-1)) goto L10;
        r11 = false;
    L10:
        RecordHistogram.recordBooleanHistogram("ChromiumAndroidLinker.RelroProvidedSuccessfully", r11);
    }

    private void loadWithoutProducingRelro(String r10) {
        if (getModernLinkerJni().loadLibrary(r10, this.mLocalLibInfo, false) == true) goto L6;
        resetAndThrow(String.format("Unable to load library: %s", new Object[]{r10}));
        return;
    }

    private String readBackgroundStateFromCgroups() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream(SELF_CGROUP_FILE_NAME)));     // Catch: IOException -> L33
        String r11 = null;
    L36:
        String r12 = r10.readLine();     // Catch: Throwable -> L27
        if (r12 == null) goto L10;
        r11 = extractBlkioCgroupFromLine(r12);     // Catch: Throwable -> L27
        if (r11.equals("") == true) goto L36;
    L10:
        if (r11 == null) goto L25;
        if (r11.equals("") == true) goto L25;
        r10.close();     // Catch: IOException -> L33
        if (r11.equals("/") == false) goto L20;
        return "Foreground";
    L20:
        if (r11.equals("/background") == false) goto L23;
        return "Background";
    L23:
        Log.e(TAG, "blkio cgroup with unexpected name: '%s'", new Object[]{r11});
        return SUFFIX_UNKNOWN;
    L25:
        r10.close();     // Catch: IOException -> L33
        return SUFFIX_UNKNOWN;
    L27:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: IOException -> L33
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L33
    L33:
        Log.e(TAG, "IOException while reading %s", new Object[]{SELF_CGROUP_FILE_NAME});
        return SUFFIX_UNKNOWN;
    }

    private void recordDetailedLoadTimeSince(TimeUtils.UptimeMillisTimer r10, String r11, String r12) {
        long r13 = r10.getElapsedMillis();
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX + r11, r13);
        RecordHistogram.recordTimesHistogram(DETAILED_LOAD_TIME_HISTOGRAM_PREFIX_BLKIO_CGROUP + r11 + "." + r12, r13);
    }

    public static void reportDlopenExtTime(long r10) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerDlopenExtTime", r10);
    }

    public static void reportIteratePhdrTime(long r10) {
        RecordHistogram.recordTimesHistogram("ChromiumAndroidLinker.ModernLinkerIteratePhdrTime", r10);
    }

    private void resetAndThrow(String r10) {
        this.mState = 1;
        Log.e(TAG, r10, new Object[0]);
        throw new UnsatisfiedLinkError(r10);
    }

    static void setModernLinkerNativesForTesting(Natives r10) {
        sNativesInstance = r10;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected void atomicReplaceRelroLocked(boolean r10) {
        if (this.mRemoteLibInfo.mRelroFd != (-1)) goto L6;
        return;
    L6:
        if (this.mLocalLibInfo != null) goto L8;
        return;
    L8:
        getModernLinkerJni().useRelros(this.mLocalLibInfo.mLoadAddress, this.mRemoteLibInfo);
        RecordHistogram.recordBooleanHistogram("ChromiumAndroidLinker.RelroAvailableImmediately", r10);
        RecordHistogram.recordEnumeratedHistogram("ChromiumAndroidLinker.RelroSharingStatus2", getModernLinkerJni().getRelroSharingResult(), 9);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected boolean keepMemoryReservationUntilLoad() {
        return true;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    protected void loadLibraryImplLocked(String r10, int r11) {
        boolean r12 = false;
        if ("monochrome".equals(r10) == true) goto L6;
        Log.i(TAG, "loadLibraryImplLocked: %s, relroMode=%d", new Object[]{r10, Integer.valueOf(r11)});
    L6:
        String r13 = readBackgroundStateFromCgroups();
        TimeUtils.UptimeMillisTimer r14 = new TimeUtils.UptimeMillisTimer();
        String r15 = System.mapLibraryName(r10);
        if (r11 != 0) goto L9;
        this.mState = 3;
    L13:
        String r16 = readBackgroundStateFromCgroups();
        if (r13.equals(r16) == false) goto L16;
    L22:
        if (r12 == false) goto L27;
        if (r11 != 1) goto L25;
        String r17 = "Produce";
    L26:
        recordDetailedLoadTimeSince(r14, r17, r13);
        goto L27
    L25:
        r17 = "Consume";
    L27:
        TimeUtils.UptimeMillisTimer r18 = new TimeUtils.UptimeMillisTimer();
        System.loadLibrary(r10);     // Catch: UnsatisfiedLinkError -> L30
    L31:
        if (r12 == false) goto L33;
        String r19 = "Second";
    L34:
        recordDetailedLoadTimeSince(r18, r19, r13);
        return;
    L33:
        r19 = "NoSharing";
    L30:
        resetAndThrow("Failed at System.loadLibrary()");
        goto L31
    L16:
        if (r13.equals(SUFFIX_UNKNOWN) == false) goto L18;
    L21:
        r13 = SUFFIX_UNKNOWN;
        goto L22
    L18:
        if (r16.equals(SUFFIX_UNKNOWN) == true) goto L21;
        r13 = "Mixed";
        goto L22
    L9:
        if (r11 != 1) goto L11;
        loadAndProduceSharedRelro(r15);
        this.mState = 2;
    L12:
        r12 = true;
        goto L13
    L11:
        loadWithoutProducingRelro(r15);
        this.mState = 3;
        goto L12
    }
}
