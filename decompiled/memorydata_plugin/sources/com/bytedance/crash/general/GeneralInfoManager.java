package com.bytedance.crash.general;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileSystemUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GeneralInfoManager {
    private static final String DIRECTORY = "general";
    private static GeneralInfoManager sInstance;
    private AppInfo mAppInfo;
    private final Context mContext;
    private final File mDirectory;
    private HardwareInfo mHardwareInfo;
    private RomInfo mRomInfo;

    private GeneralInfoManager(Context r3, File r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mDirectory = FileSystemUtils.createDirectory(r4, "general");
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    private static GeneralInfoManager get() {
        if (sInstance != null) goto L18;
        monitor-enter(GeneralInfoManager.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L12;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        File r2 = Global.getRootDirectory();     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        if (r2 == null) goto L12;
        sInstance = new GeneralInfoManager(r1, r2);     // Catch: Throwable -> L14
    L12:
        monitor-exit(GeneralInfoManager.class);     // Catch: Throwable -> L14
    L18:
        return sInstance;
    }

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
        GeneralInfoManager r0 = get();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getHardwareInfo().getJiffy();
    }

    public static long getLastUpdateTime(long r4) {
        GeneralInfoManager r0 = get();
        if (r0 != null) goto L5;
    L12:
        return 0;
    L5:
        if (r4 == 0) goto L7;
        AppInfo r5 = AppInfo.findAppInfo(r0.mDirectory, r4);
        if (r5 == null) goto L12;
        return r5.mLastUpdateTime;
    L7:
        return r0.getAppInfo().mLastUpdateTime;
    }

    public static String getRandomDeviceId() {
        GeneralInfoManager r0 = get();
        if (r0 == null) goto L7;
        return r0.getRomInfo().getRandomDeviceId();
    L7:
        return RomInfoHelper.getRandomDeviceId();
    }

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
        GeneralInfoManager r0 = get();
        if (r0 == null) goto L6;
        r0.getAppInfo();
        return;
    }

    public static boolean isRoot() {
        return RomInfoHelper.checkRoot();
    }

    public static void putAppInfo(JSONObject r4, long r5) {
        GeneralInfoManager r0 = get();
        if (r0 == null) goto L13;
        AppInfo r1 = r0.getAppInfo();
        if (r5 > 0) goto L7;
    L11:
        r1.putTo(r4);
        return;
    L7:
        if (r5 >= r1.mLastUpdateTime) goto L11;
        AppInfo r6 = AppInfo.findAppInfo(r0.mDirectory, r5);
        if (r6 == null) goto L11;
        r1 = r6;
        goto L11
    }

    public static void putHardwareInfo(JSONObject r1) {
        GeneralInfoManager r0 = get();
        if (r0 == null) goto L6;
        r0.getHardwareInfo().putTo(r1);
        return;
    }

    public static void putRomInfo(JSONObject r1) {
        GeneralInfoManager r0 = get();
        if (r0 == null) goto L6;
        r0.getRomInfo().putTo(r1);
        return;
    }

    public File getDirectory() {
        return this.mDirectory;
    }
}
