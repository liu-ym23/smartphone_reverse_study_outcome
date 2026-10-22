package com.ttnet.org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
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
        boolean r1 = true;
        sInitialized = true;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
        String r4 = r3.getPackageName();     // Catch: Exception -> L25
        PackageManager r5 = r3.getPackageManager();     // Catch: Exception -> L25
        PackageInfo r6 = r5.getPackageInfo(r4, 0);     // Catch: Exception -> L25
        long r7 = packageVersionCode(r6);     // Catch: Exception -> L25
        this.hostVersionCode = r7;     // Catch: Exception -> L25
        PackageInfo r9 = sBrowserPackageInfo;     // Catch: Exception -> L25
        if (r9 == null) goto L6;
        this.packageName = r9.packageName;     // Catch: Exception -> L25
        this.versionCode = packageVersionCode(sBrowserPackageInfo);     // Catch: Exception -> L25
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);     // Catch: Exception -> L25
        sBrowserApplicationInfo = sBrowserPackageInfo.applicationInfo;     // Catch: Exception -> L25
        sBrowserPackageInfo = null;     // Catch: Exception -> L25
    L7:
        this.hostPackageLabel = nullToEmpty(r5.getApplicationLabel(r6.applicationInfo));     // Catch: Exception -> L25
        this.installerPackageName = nullToEmpty(r5.getInstallerPackageName(this.packageName));     // Catch: Exception -> L25
        String r8 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L30;
    L12:
        this.resourcesVersion = r8;     // Catch: Exception -> L25
        if (Build.VERSION.SDK_INT < 21) goto L16;
        String r10 = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L25
    L15:
        this.abiString = r10;     // Catch: Exception -> L25
        this.androidBuildFingerprint = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));     // Catch: Exception -> L25
        UiModeManager r0 = (UiModeManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("uimode"), UiModeManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
        if (r0 != null) goto L20;
    L22:
        r1 = false;
    L23:
        this.isTV = r1;     // Catch: Exception -> L25
        this.isAutomotive = r3.getPackageManager().hasSystemFeature("android.hardware.type.automotive");     // Catch: Exception -> L25
        return;
    L20:
        if (r0.getCurrentModeType() != 4) goto L22;
    L16:
        r10 = String.format("ABI1: %s, ABI2: %s", new Object[]{Build.CPU_ABI, Build.CPU_ABI2});     // Catch: Exception -> L25
        goto L15
    L30:
        r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L11
    L11:
        r8 = "Not found";
        goto L12
    L6:
        this.packageName = r4;     // Catch: Exception -> L25
        this.versionCode = r7;     // Catch: Exception -> L25
        this.versionName = nullToEmpty(r6.versionName);     // Catch: Exception -> L25
        sBrowserApplicationInfo = r3.getApplicationInfo();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Log.e(TAG, "NameNotFoundException: " + e, new Object[0]);
    }

    private static String[] getAll() {
        return getInstance().getAllProperties();
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }

    public static BuildInfo getInstance() {
        return Holder.access$000();
    }

    private static boolean isAtLeastPreReleaseCodename(String r2, String r3) {
        if ("REL".equals(r3) == false) goto L6;
        return false;
    L6:
        if (r3.toUpperCase(Locale.ROOT).compareTo(r2.toUpperCase(Locale.ROOT)) < 0) goto L9;
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
        if ("eng".equals(Build.TYPE) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(Build.TYPE) == true) goto L8;
        return false;
    }

    private static String nullToEmpty(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3.toString();
    }

    public static long packageVersionCode(PackageInfo r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApiHelperForP.getLongVersionCode(r2);
    L7:
        return r2.versionCode;
    }

    public static void setBrowserPackageInfo(PackageInfo r0) {
        sBrowserPackageInfo = r0;
    }

    public static void setFirebaseAppId(String r0) {
        sFirebaseAppId = r0;
    }

    public static boolean targetsAtLeastT() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion < 33) goto L5;
        return true;
    L5:
        return false;
    }

    String[] getAllProperties() {
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        String[] r2 = new String[28];
        r2[0] = Build.BRAND;
        r2[1] = Build.DEVICE;
        r2[2] = Build.ID;
        r2[3] = Build.MANUFACTURER;
        r2[4] = Build.MODEL;
        r2[5] = String.valueOf(Build.VERSION.SDK_INT);
        r2[6] = Build.TYPE;
        r2[7] = Build.BOARD;
        r2[8] = r0;
        r2[9] = String.valueOf(this.hostVersionCode);
        r2[10] = this.hostPackageLabel;
        r2[11] = this.packageName;
        r2[12] = String.valueOf(this.versionCode);
        r2[13] = this.versionName;
        r2[14] = this.androidBuildFingerprint;
        r2[15] = this.gmsVersionCode;
        r2[16] = this.installerPackageName;
        r2[17] = this.abiString;
        r2[18] = sFirebaseAppId;
        r2[19] = this.customThemes;
        r2[20] = this.resourcesVersion;
        r2[21] = String.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion);
        String r1 = "1";
        if (isDebugAndroid() == false) goto L5;
        String r3 = "1";
    L6:
        r2[22] = r3;
        if (this.isTV == false) goto L9;
        String r4 = "1";
    L10:
        r2[23] = r4;
        r2[24] = Build.VERSION.INCREMENTAL;
        r2[25] = Build.HARDWARE;
        if (isAtLeastT() == false) goto L13;
        String r5 = "1";
    L14:
        r2[26] = r5;
        if (this.isAutomotive == true) goto L18;
        r1 = "0";
    L18:
        r2[27] = r1;
        return r2;
    L13:
        r5 = "0";
        goto L14
    L9:
        r4 = "0";
        goto L10
    L5:
        r3 = "0";
        goto L6
    }

    public ApplicationInfo getBrowserApplicationInfo() {
        return sBrowserApplicationInfo;
    }
}
