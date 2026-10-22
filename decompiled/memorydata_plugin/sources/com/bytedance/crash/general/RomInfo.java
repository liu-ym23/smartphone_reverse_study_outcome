package com.bytedance.crash.general;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

    static RomInfo get(File r4) {
        File r2 = new File(r4, FILE_NAME);
        String r5 = RomInfoHelper.getRomVersion();
        RomInfo r0 = (RomInfo) ZeusTransformUtils.preCheckCast((RomInfo) ZeusTransformUtils.preCheckCast(SerializeFactory.load(r2), RomInfo.class, "com.obric.memorydata.plugin"), RomInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L6:
        if (r0 != null) goto L8;
    L9:
        RomInfo r1 = new RomInfo();
        r1.mRomVersion = r5;
        r1.mOsVersion = RomInfoHelper.getOsVersion();
        r1.mIsHarmonyOs = RomInfoHelper.isHarmonyOs();
        r1.mKernelVersion = RomInfoHelper.getKernelVersion();
        r1.mRomIncremental = RomInfoHelper.getRomIncremental();
        r1.mOsApiLevel = RomInfoHelper.getOsApiLevel();
        r1.mRandomDeviceId = RomInfoHelper.getRandomDeviceId();
        SerializeFactory.store(r2, r1);
        return r1;
    L8:
        if (r5.equals(String.valueOf(r0.mRomVersion)) == false) goto L9;
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    String getRandomDeviceId() {
        return this.mRandomDeviceId;
    }

    void putTo(JSONObject r3) {
        JSONUtils.put(r3, "os", LocationInfoConst.SYSTEM);
        JSONUtils.put(r3, "os_version", this.mOsVersion);
        JSONUtils.put(r3, "os_api", Integer.valueOf(this.mOsApiLevel));
        JSONUtils.put(r3, "is_hm_os", Boolean.valueOf(this.mIsHarmonyOs));
        JSONUtils.put(r3, "kernel_version", this.mKernelVersion);
        JSONUtils.put(r3, "rom", this.mRomIncremental);
        JSONUtils.put(r3, "rom_version", this.mRomVersion);
    }
}
