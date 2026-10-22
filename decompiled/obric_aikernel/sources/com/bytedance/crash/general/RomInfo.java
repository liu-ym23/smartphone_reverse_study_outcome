package com.bytedance.crash.general;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class RomInfo implements Serializable {
    private static final String FILE_NAME = "rom.inf";
    public static final String KEY_OS_TYPE = "os";
    private static final String KEY_ROM_HARMONY_OS = "is_hm_os";
    private static final String KEY_ROM_INCREMENTAL = "rom";
    public static final String KEY_ROM_KERNEL_VERSION = "kernel_version";
    public static final String KEY_ROM_OS_API = "os_api";
    public static final String KEY_ROM_OS_VERSION = "os_version";
    private static final String KEY_ROM_VERSION = "rom_version";
    private static final long serialVersionUID = 1;
    private boolean mIsHarmonyOs;
    private String mKernelVersion;
    private int mOsApiLevel;
    private String mOsVersion;
    private String mRandomDeviceId;
    private String mRomIncremental;
    private String mRomVersion;

    public RomInfo() {
    }

    @NonNull
    static RomInfo get(@NonNull File r10) {
        File r11 = new File(r10, FILE_NAME);
        String r12 = RomInfoHelper.getRomVersion();
        RomInfo r13 = (RomInfo) SerializeFactory.load(r11);     // Catch: Exception -> L5
    L6:
        if (r13 != null) goto L8;
    L9:
        RomInfo r14 = new RomInfo();
        r14.mRomVersion = r12;
        r14.mOsVersion = RomInfoHelper.getOsVersion();
        r14.mIsHarmonyOs = RomInfoHelper.isHarmonyOs();
        r14.mKernelVersion = RomInfoHelper.getKernelVersion();
        r14.mRomIncremental = RomInfoHelper.getRomIncremental();
        r14.mOsApiLevel = RomInfoHelper.getOsApiLevel();
        r14.mRandomDeviceId = RomInfoHelper.getRandomDeviceId();
        SerializeFactory.store(r11, r14);
        return r14;
    L8:
        if (r12.equals(String.valueOf(r13.mRomVersion)) == false) goto L9;
        return r13;
    L5:
        r13 = null;
        goto L6
    }

    String getRandomDeviceId() {
        return this.mRandomDeviceId;
    }

    void putTo(JSONObject r10) {
        JSONUtils.put(r10, "os", "Android");
        JSONUtils.put(r10, "os_version", this.mOsVersion);
        JSONUtils.put(r10, "os_api", Integer.valueOf(this.mOsApiLevel));
        JSONUtils.put(r10, "is_hm_os", Boolean.valueOf(this.mIsHarmonyOs));
        JSONUtils.put(r10, "kernel_version", this.mKernelVersion);
        JSONUtils.put(r10, "rom", this.mRomIncremental);
        JSONUtils.put(r10, "rom_version", this.mRomVersion);
    }
}
