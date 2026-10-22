package com.ttnet.org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.BuildCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BuildInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_FINGERPRINT_LENGTH = 128;
    private static final String TAG = "BuildInfo";
    private static ApplicationInfo sBrowserApplicationInfo = null;
    private static PackageInfo sBrowserPackageInfo = null;
    private static String sFirebaseAppId = "";
    private static boolean sInitialized;
    public String abiString;
    public String androidBuildFingerprint;
    public String customThemes;
    public String gmsVersionCode;
    public String hostPackageLabel;
    public long hostVersionCode;
    public String installerPackageName;
    public boolean isAutomotive;
    public boolean isTV;
    public String packageName;
    public String resourcesVersion;
    public long versionCode;
    public String versionName;

    private static class Holder {
        private static BuildInfo sInstance;

        static {
            sInstance = new BuildInfo();
        }

        private Holder() {
        }

        static /* synthetic */ BuildInfo access$000() {
            return sInstance;
        }
    }

    static {
    }

    @VisibleForTesting
    BuildInfo() {
        this.hostPackageLabel = "";
        this.packageName = "";
        this.versionName = "";
        this.installerPackageName = "";
        this.gmsVersionCode = "";
        this.abiString = "";
        this.androidBuildFingerprint = "";
        this.customThemes = "";
        this.resourcesVersion = "";
        boolean r10 = true;
        sInitialized = true;
        Context r11 = ContextUtils.getApplicationContext();     // Catch: Exception -> L25
        String r12 = r11.getPackageName();     // Catch: Exception -> L25
        PackageManager r13 = r11.getPackageManager();     // Catch: Exception -> L25
        PackageInfo r14 = r13.getPackageInfo(r12, 0);     // Catch: Exception -> L25
        long r15 = packageVersionCode(r14);     // Catch: Exception -> L25
        this.hostVersionCode = r15;     // Catch: Exception -> L25
        PackageInfo r16 = sBrowserPackageInfo;     // Catch: Exception -> L25
        if (r16 == null) goto L6;
        this.packageName = r16.packageName;     // Catch: Exception -> L25
        this.versionCode = packageVersionCode(r16);     // Catch: Exception -> L25
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);     // Catch: Exception -> L25
        sBrowserApplicationInfo = sBrowserPackageInfo.applicationInfo;     // Catch: Exception -> L25
        sBrowserPackageInfo = null;     // Catch: Exception -> L25
    L7:
        this.hostPackageLabel = nullToEmpty(r13.getApplicationLabel(r14.applicationInfo));     // Catch: Exception -> L25
        this.installerPackageName = nullToEmpty(r13.getInstallerPackageName(this.packageName));     // Catch: Exception -> L25
        String r17 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L28;
    L12:
        this.resourcesVersion = r17;     // Catch: Exception -> L25
        if (Build.VERSION.SDK_INT < 21) goto L16;
        String r18 = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L25
    L15:
        this.abiString = r18;     // Catch: Exception -> L25
        String r19 = Build.FINGERPRINT;     // Catch: Exception -> L25
        this.androidBuildFingerprint = r19.substring(0, Math.min(r19.length(), 128));     // Catch: Exception -> L25
        UiModeManager r20 = (UiModeManager) r11.getSystemService("uimode");     // Catch: Exception -> L25
        if (r20 != null) goto L20;
    L22:
        r10 = false;
    L23:
        this.isTV = r10;     // Catch: Exception -> L25
        this.isAutomotive = r11.getPackageManager().hasSystemFeature("android.hardware.type.automotive");     // Catch: Exception -> L25
        return;
    L20:
        if (r20.getCurrentModeType() != 4) goto L22;
    L16:
        r18 = String.format("ABI1: %s, ABI2: %s", new Object[]{Build.CPU_ABI, Build.CPU_ABI2});     // Catch: Exception -> L25
        goto L15
    L28:
        r17 = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L11
    L11:
        r17 = "Not found";
        goto L12
    L6:
        this.packageName = r12;     // Catch: Exception -> L25
        this.versionCode = r15;     // Catch: Exception -> L25
        this.versionName = nullToEmpty(r14.versionName);     // Catch: Exception -> L25
        sBrowserApplicationInfo = r11.getApplicationInfo();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Log.e(TAG, "NameNotFoundException: " + e, new Object[0]);
    }

    @CalledByNative
    private static String[] getAll() {
        return getInstance().getAllProperties();
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }

    public static BuildInfo getInstance() {
        return Holder.access$000();
    }

    private static boolean isAtLeastPreReleaseCodename(String r10, String r11) {
        if ("REL".equals(r11) == false) goto L5;
        return false;
    L5:
        Locale r12 = Locale.ROOT;
        if (r11.toUpperCase(r12).compareTo(r10.toUpperCase(r12)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isAtLeastT() {
        if (Build.VERSION.SDK_INT >= 32) goto L5;
    L7:
        return false;
    L5:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }

    public static boolean isDebugAndroid() {
        String r10 = Build.TYPE;
        if ("eng".equals(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(r10) == true) goto L8;
        return false;
    }

    private static String nullToEmpty(CharSequence r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.toString();
    }

    public static long packageVersionCode(PackageInfo r10) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApiHelperForP.getLongVersionCode(r10);
    L7:
        return r10.versionCode;
    }

    public static void setBrowserPackageInfo(PackageInfo r10) {
        sBrowserPackageInfo = r10;
    }

    public static void setFirebaseAppId(String r10) {
        sFirebaseAppId = r10;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean targetsAtLeastT() {
        if (ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion < 33) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    String[] getAllProperties() {
        String r10 = ContextUtils.getApplicationContext().getPackageName();
        String[] r11 = new String[28];
        r11[0] = Build.BRAND;
        r11[1] = Build.DEVICE;
        r11[2] = Build.ID;
        r11[3] = Build.MANUFACTURER;
        r11[4] = Build.MODEL;
        r11[5] = String.valueOf(Build.VERSION.SDK_INT);
        r11[6] = Build.TYPE;
        r11[7] = Build.BOARD;
        r11[8] = r10;
        r11[9] = String.valueOf(this.hostVersionCode);
        r11[10] = this.hostPackageLabel;
        r11[11] = this.packageName;
        r11[12] = String.valueOf(this.versionCode);
        r11[13] = this.versionName;
        r11[14] = this.androidBuildFingerprint;
        r11[15] = this.gmsVersionCode;
        r11[16] = this.installerPackageName;
        r11[17] = this.abiString;
        r11[18] = sFirebaseAppId;
        r11[19] = this.customThemes;
        r11[20] = this.resourcesVersion;
        r11[21] = String.valueOf(ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion);
        boolean r12 = isDebugAndroid();
        String r13 = NetConst.ENCRYPT_VERISON_CODE;
        if (r12 == false) goto L5;
        String r14 = NetConst.ENCRYPT_VERISON_CODE;
    L6:
        r11[22] = r14;
        if (this.isTV == false) goto L9;
        String r15 = NetConst.ENCRYPT_VERISON_CODE;
    L10:
        r11[23] = r15;
        r11[24] = Build.VERSION.INCREMENTAL;
        r11[25] = Build.HARDWARE;
        if (isAtLeastT() == false) goto L13;
        String r16 = NetConst.ENCRYPT_VERISON_CODE;
    L14:
        r11[26] = r16;
        if (this.isAutomotive == true) goto L18;
        r13 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L18:
        r11[27] = r13;
        return r11;
    L13:
        r16 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        goto L14
    L9:
        r15 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        goto L10
    L5:
        r14 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        goto L6
    }

    public ApplicationInfo getBrowserApplicationInfo() {
        return sBrowserApplicationInfo;
    }
}
