package com.bytedance.crash.general;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GeneralInfoManager {
    private static final String DIRECTORY = "general";

    @SuppressLint({"StaticFieldLeak"})
    private static GeneralInfoManager sInstance;
    private AppInfo mAppInfo;
    private final Context mContext;
    private final File mDirectory;
    private HardwareInfo mHardwareInfo;
    private RomInfo mRomInfo;

    private GeneralInfoManager(@NonNull Context r10, @NonNull File r11) {
        this.mDirectory = FileSystemUtils.createDirectory(r11, "general");
        this.mContext = r10;
    }

    private static GeneralInfoManager get() {
        if (sInstance != null) goto L18;
        monitor-enter(GeneralInfoManager.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L12;
        Context r10 = Global.getContext();     // Catch: Throwable -> L14
        File r11 = Global.getRootDirectory();     // Catch: Throwable -> L14
        if (r10 == null) goto L12;
        if (r11 == null) goto L12;
        sInstance = new GeneralInfoManager(r10, r11);     // Catch: Throwable -> L14
    L12:
        monitor-exit(GeneralInfoManager.class);     // Catch: Throwable -> L14
    L18:
        return sInstance;
    }

    @NonNull
    private AppInfo getAppInfo() {
        if (this.mAppInfo != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mAppInfo != null) goto L8;
        this.mAppInfo = AppInfo.get(this.mContext, this.mDirectory);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mAppInfo;
    }

    @NonNull
    private HardwareInfo getHardwareInfo() {
        if (this.mHardwareInfo != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mHardwareInfo != null) goto L8;
        this.mHardwareInfo = HardwareInfo.get(this.mContext, this.mDirectory);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mHardwareInfo;
    }

    public static long getJiffy() {
        GeneralInfoManager r10 = get();
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.getHardwareInfo().getJiffy();
    }

    public static long getLastUpdateTime(long r10) {
        GeneralInfoManager r11 = get();
        if (r11 != null) goto L5;
    L12:
        return 0;
    L5:
        if (r10 == 0) goto L7;
        AppInfo r12 = AppInfo.findAppInfo(r11.mDirectory, r10);
        if (r12 == null) goto L12;
        return r12.mLastUpdateTime;
    L7:
        return r11.getAppInfo().mLastUpdateTime;
    }

    public static String getRandomDeviceId() {
        GeneralInfoManager r10 = get();
        if (r10 == null) goto L7;
        return r10.getRomInfo().getRandomDeviceId();
    L7:
        return RomInfoHelper.getRandomDeviceId();
    }

    @NonNull
    private RomInfo getRomInfo() {
        if (this.mRomInfo != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mRomInfo != null) goto L8;
        this.mRomInfo = RomInfo.get(this.mDirectory);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mRomInfo;
    }

    public static void init() {
        GeneralInfoManager r10 = get();
        if (r10 == null) goto L6;
        r10.getAppInfo();
        return;
    }

    public static boolean isRoot() {
        return RomInfoHelper.checkRoot();
    }

    public static void putAppInfo(JSONObject r10, long r11) {
        GeneralInfoManager r12 = get();
        if (r12 == null) goto L13;
        AppInfo r13 = r12.getAppInfo();
        if (r11 > 0) goto L7;
    L11:
        r13.putTo(r10);
        return;
    L7:
        if (r11 >= r13.mLastUpdateTime) goto L11;
        AppInfo r14 = AppInfo.findAppInfo(r12.mDirectory, r11);
        if (r14 == null) goto L11;
        r13 = r14;
        goto L11
    }

    public static void putHardwareInfo(JSONObject r10) {
        GeneralInfoManager r11 = get();
        if (r11 == null) goto L6;
        r11.getHardwareInfo().putTo(r10);
        return;
    }

    public static void putRomInfo(JSONObject r10) {
        GeneralInfoManager r11 = get();
        if (r11 == null) goto L6;
        r11.getRomInfo().putTo(r10);
        return;
    }

    public File getDirectory() {
        return this.mDirectory;
    }
}
