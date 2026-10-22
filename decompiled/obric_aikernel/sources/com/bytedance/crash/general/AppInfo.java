package com.bytedance.crash.general;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.crash.config.BitsConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.AppInfoUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AppInfo implements Serializable {
    private static final String KEY_APP_DISPLAY_NAME = "display_name";
    private static final String KEY_APP_PACKAGE = "package";
    private static final String KEY_APP_RELEASE_BUILD = "release_build";
    private static final String KEY_APP_VERIFY_INFO = "verify_info";
    private static final String KEY_NPTH_BYTRACE_ID = "bytrace_id";
    public static final String KEY_NPTH_VERSION_CODE = "sdk_version";
    public static final String KEY_NPTH_VERSION_NAME = "sdk_version_name";
    private static final int MAX_FILE_COUNT = 3;
    private static final String SUFFIX = ".aif";
    private static final long TOW_WEEKS = 1209600000;
    private static final long serialVersionUID = 1;
    Map<String, Object> mAppExtension;
    int mAppVersionCode;
    String mAppVersionName;
    String mBitWide;
    String mDisplayName;
    long mLastUpdateTime;
    String mNpthBytraceId;
    int mNpthVersionCode;
    String mNpthVersionName;
    String mPackageName;
    String mReleaseBuild;

    public AppInfo() {
    }

    static /* synthetic */ long access$000(File r10) {
        return getLastUpdateTime(r10);
    }

    private static void clear(@NonNull File r10) {
        File[] r11 = getSortedFilesArray(r10);
        if (r11 == null) goto L15;
        int r12 = 3;
        if (r11.length <= 3) goto L19;
        long r13 = System.currentTimeMillis();
    L8:
        if (r12 >= r11.length) goto L20;
        long r14 = getLastUpdateTime(r11[r12]);
        if (r14 >= 0) goto L12;
    L13:
        r11[r12].delete();
    L14:
        r12 = r12 + 1;
        goto L8
    L12:
        if ((r13 - r14) <= TOW_WEEKS) goto L14;
    L20:
        return;
    L19:
        return;
    }

    static AppInfo findAppInfo(File r10, long r11) {
        File[] r12 = getSortedFilesArray(r10);
        if (r12 == null) goto L14;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L23;
        AppInfo r15 = (AppInfo) SerializeFactory.load(r12[r14]);     // Catch: Throwable -> L16
        if (r15 == null) goto L13;
        if (r11 <= r15.mLastUpdateTime) goto L13;
        return r15;
    L13:
        r14 = r14 + 1;
        goto L5
    L23:
        return null;
    L14:
        return null;
    }

    static AppInfo get(@NonNull Context r10, @NonNull File r11) {
        String r12 = r10.getPackageName();
        PackageInfo r13 = null;
        PackageInfo r14 = r10.getPackageManager().getPackageInfo(r12, 0);     // Catch: Throwable -> L10
        File r15 = new File(r11, r14.lastUpdateTime + SUFFIX);     // Catch: Throwable -> L8
        AppInfo r16 = (AppInfo) SerializeFactory.load(r15);     // Catch: Throwable -> L26
        if (r16 == null) goto L12;
        return r16;
    L12:
        AppInfo r17 = new AppInfo();
        r17.mPackageName = r12;
        if (NativeBridge.is64BitRuntime() == false) goto L15;
        String r18 = "64";
    L16:
        r17.mBitWide = r18;
        r17.mReleaseBuild = BitsConfig.getReleaseBuild();
        r17.mNpthVersionCode = 4020254;
        r17.mNpthVersionName = NpthBuildConfig.VERSION_NAME;
        r17.mNpthBytraceId = AppInfoUtils.getBytraceId();
        r17.mAppExtension = BitsConfig.getPropertiesMap();
        if (r14 == null) goto L23;
        r17.mLastUpdateTime = r14.lastUpdateTime;
        r17.mAppVersionCode = r14.versionCode;
        r17.mAppVersionName = r14.versionName;
        ApplicationInfo r19 = r14.applicationInfo;
        if (r19 == null) goto L23;
        int r20 = r19.labelRes;
        if (r20 <= 0) goto L23;
        r17.mDisplayName = r10.getString(r20);
    L23:
        if (r15 == null) goto L25;
        clear(r11);
        SerializeFactory.store(r15, r17);
    L25:
        return r17;
    L15:
        r18 = "32";
    L9:
        r13 = r14;
    L11:
        r14 = r13;
    L8:
        r15 = null;
    L10:
        r15 = null;
        goto L11
    }

    private static long getLastUpdateTime(File r10) {
        String r11 = r10.getName();     // Catch: Throwable -> L4
        return Long.parseLong(r11.substring(0, r11.length() - 4));
    L4:
        return -1;
    }

    private static File[] getSortedFilesArray(File r10) {
        File[] r11 = r10.listFiles(new AnonymousClass1());
        if (r11 == null) goto L5;
        Arrays.sort(r11, new AnonymousClass2());
    L5:
        return r11;
    }

    void putTo(JSONObject r10) {
        JSONUtils.put(r10, "package", this.mPackageName);
        JSONUtils.put(r10, "display_name", this.mDisplayName);
        JSONUtils.put(r10, "app_version", this.mAppVersionName);
        JSONUtils.put(r10, "version_code", Integer.valueOf(this.mAppVersionCode));
        JSONUtils.put(r10, "verify_info", this.mBitWide);
        JSONUtils.put(r10, "release_build", this.mReleaseBuild);
        JSONUtils.put(r10, KEY_NPTH_BYTRACE_ID, this.mNpthBytraceId);
        JSONUtils.put(r10, "sdk_version", Integer.valueOf(this.mNpthVersionCode));
        JSONUtils.put(r10, KEY_NPTH_VERSION_NAME, this.mNpthVersionName);
        JSONUtils.put(r10, Header.KEY_APP_LAST_UPDATE_TIME, Long.valueOf(this.mLastUpdateTime));
        Map<String, Object> r11 = this.mAppExtension;
        if (r11 == null) goto L8;
        Iterator<String> r12 = r11.keySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        String r13 = r12.next();
        JSONUtils.put(r10, r13, this.mAppExtension.get(r13));
        goto L6
    L10:
        return;
    }
}
