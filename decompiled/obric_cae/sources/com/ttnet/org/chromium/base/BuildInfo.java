package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;

/* JADX INFO: loaded from: classes2.dex */
public class BuildInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_FINGERPRINT_LENGTH = 128;
    private static final String TAG = "BuildInfo";
    private static PackageInfo sBrowserPackageInfo = null;
    private static String sFirebaseAppId = "";
    private static boolean sInitialized;
    public String abiString;
    public String androidBuildFingerprint;
    public String customThemes;
    public String extractedFileSuffix;
    public String gmsVersionCode;
    public String hostPackageLabel;
    public long hostVersionCode;
    public String installerPackageName;
    public String packageName;
    public String resourcesVersion;
    public long versionCode;
    public String versionName;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.BuildInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static BuildInfo sInstance;

        static {
            sInstance = new BuildInfo(null);
        }

        private Holder() {
        }

        public static /* synthetic */ BuildInfo access$100() {
            return sInstance;
        }
    }

    private BuildInfo() {
        this.hostPackageLabel = "";
        this.packageName = "";
        this.versionName = "";
        this.installerPackageName = "";
        this.gmsVersionCode = "";
        this.abiString = "";
        this.androidBuildFingerprint = "";
        this.extractedFileSuffix = "";
        this.customThemes = "";
        this.resourcesVersion = "";
        sInitialized = true;
        Context r8 = ContextUtils.getApplicationContext();     // Catch: Exception -> L23
        String r10 = r8.getPackageName();     // Catch: Exception -> L23
        PackageManager r11 = r8.getPackageManager();     // Catch: Exception -> L23
        PackageInfo r12 = r11.getPackageInfo(r10, 0);     // Catch: Exception -> L23
        long r13 = packageVersionCode(r12);     // Catch: Exception -> L23
        this.hostVersionCode = r13;     // Catch: Exception -> L23
        PackageInfo r14 = sBrowserPackageInfo;     // Catch: Exception -> L23
        PackageInfo r15 = null;
        if (r14 == null) goto L6;
        this.packageName = r14.packageName;     // Catch: Exception -> L23
        this.versionCode = packageVersionCode(r14);     // Catch: Exception -> L23
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);     // Catch: Exception -> L23
        sBrowserPackageInfo = null;     // Catch: Exception -> L23
    L7:
        this.hostPackageLabel = nullToEmpty(r11.getApplicationLabel(r12.applicationInfo));     // Catch: Exception -> L23
        this.installerPackageName = nullToEmpty(r11.getInstallerPackageName(this.packageName));     // Catch: Exception -> L23
        r15 = r11.getPackageInfo("com.google.android.gms", 0);     // Catch: PackageManager.NameNotFoundException -> L26 Exception -> L23
    L9:
        if (r15 == null) goto L11;
        String r16 = String.valueOf(packageVersionCode(r15));     // Catch: Exception -> L23
    L12:
        this.gmsVersionCode = r16;     // Catch: Exception -> L23
        String r17 = "true";
        r11.getPackageInfo("projekt.substratum", 0);     // Catch: PackageManager.NameNotFoundException -> L15 Exception -> L23
    L16:
        this.customThemes = r17;     // Catch: Exception -> L23
        String r18 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L31;
    L21:
        this.resourcesVersion = r18;     // Catch: Exception -> L23
        this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L23
        this.extractedFileSuffix = String.format("@%x_%x", new Object[]{Long.valueOf(this.versionCode), Long.valueOf(r12.lastUpdateTime)});     // Catch: Exception -> L23
        String r19 = Build.FINGERPRINT;     // Catch: Exception -> L23
        this.androidBuildFingerprint = r19.substring(0, Math.min(r19.length(), 128));     // Catch: Exception -> L23
        return;
    L31:
        r18 = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L20
    L20:
        r18 = "Not found";
    L15:
        r17 = "false";
        goto L16
    L11:
        r16 = "gms versionCode not available.";
        goto L12
    L6:
        this.packageName = r10;     // Catch: Exception -> L23
        this.versionCode = r13;     // Catch: Exception -> L23
        this.versionName = nullToEmpty(r12.versionName);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Log.e(TAG, "NameNotFoundException: " + e, new Object[0]);
    }

    @CalledByNative
    private static String[] getAll() {
        BuildInfo r8 = getInstance();
        String r10 = ContextUtils.getApplicationContext().getPackageName();
        String[] r11 = new String[23];
        r11[0] = Build.BRAND;
        r11[1] = Build.DEVICE;
        r11[2] = Build.ID;
        r11[3] = Build.MANUFACTURER;
        r11[4] = Build.MODEL;
        r11[5] = String.valueOf(Build.VERSION.SDK_INT);
        r11[6] = Build.TYPE;
        r11[7] = Build.BOARD;
        r11[8] = r10;
        r11[9] = String.valueOf(r8.hostVersionCode);
        r11[10] = r8.hostPackageLabel;
        r11[11] = r8.packageName;
        r11[12] = String.valueOf(r8.versionCode);
        r11[13] = r8.versionName;
        r11[14] = r8.androidBuildFingerprint;
        r11[15] = r8.gmsVersionCode;
        r11[16] = r8.installerPackageName;
        r11[17] = r8.abiString;
        r11[18] = sFirebaseAppId;
        r11[19] = r8.customThemes;
        r11[20] = r8.resourcesVersion;
        r11[21] = r8.extractedFileSuffix;
        if (isAtLeastQ() == false) goto L5;
        String r12 = "1";
    L6:
        r11[22] = r12;
        return r11;
    L5:
        r12 = "0";
        goto L6
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }

    public static BuildInfo getInstance() {
        return Holder.access$100();
    }

    public static boolean isAtLeastQ() {
        return true;
    }

    public static boolean isDebugAndroid() {
        String r8 = Build.TYPE;
        if ("eng".equals(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(r8) == true) goto L8;
        return false;
    }

    private static String nullToEmpty(CharSequence r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8.toString();
    }

    private static long packageVersionCode(PackageInfo r8) {
        return ApiHelperForP.getLongVersionCode(r8);
    }

    public static void setBrowserPackageInfo(PackageInfo r8) {
        sBrowserPackageInfo = r8;
    }

    public static void setFirebaseAppId(String r8) {
        sFirebaseAppId = r8;
    }

    public static boolean targetsAtLeastQ() {
        if (ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ BuildInfo(AnonymousClass1 r8) {
        this();
    }
}
