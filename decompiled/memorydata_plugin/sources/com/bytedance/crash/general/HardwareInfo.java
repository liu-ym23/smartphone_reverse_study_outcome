package com.bytedance.crash.general;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HardwareInfo implements Serializable {
    private static final String FILE_NAME = "hardware.inf";
    public static final String KEY_HW_CPU_ABI = "cpu_abi";
    public static final String KEY_HW_CPU_HARDWARE = "hardware";
    public static final String KEY_HW_CPU_MODEL = "cpu_model";
    public static final String KEY_HW_DENSITY_DPI = "density_dpi";
    public static final String KEY_HW_DISPLAY_DENSITY = "display_density";
    public static final String KEY_HW_DISPLAY_RESOLUTION = "resolution";
    public static final String KEY_HW_RAM_SIZE = "ram_size";
    public static final String KEY_HW_VENDOR_BRAND = "device_brand";
    public static final String KEY_HW_VENDOR_MANUFACTURER = "device_manufacturer";
    public static final String KEY_HW_VENDOR_MODEL = "device_model";
    private static final long serialVersionUID = 20241001154124L;
    private String mCpuAbi;
    private String mCpuHardware;
    private String mCpuModel;
    private String mDisplayDensity;
    private int mDisplayDensityDpi;
    private String mDisplayResolution;
    private long mJiffies;
    private String mRamSize;
    private String mVendorBrand;
    private String mVendorManufacturer;
    private String mVendorModel;

    public HardwareInfo() {
    }

    static HardwareInfo get(Context r5, File r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        File r1 = new File(r6, FILE_NAME);
        HardwareInfo r8 = (HardwareInfo) ZeusTransformUtils.preCheckCast((HardwareInfo) ZeusTransformUtils.preCheckCast(SerializeFactory.load(r1), HardwareInfo.class, "com.obric.memorydata.plugin"), HardwareInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L6:
        if (r8 != null) goto L11;
        r8 = new HardwareInfo();
        r8.mVendorModel = HardwareInfoHelper.getVendorModel();
        r8.mVendorBrand = HardwareInfoHelper.getVendorBrand();
        r8.mVendorManufacturer = HardwareInfoHelper.getVendorManufacturer();
        r8.mJiffies = HardwareInfoHelper.getJiffies();
        r8.mCpuAbi = HardwareInfoHelper.getCpuAbi();
        r8.mCpuModel = HardwareInfoHelper.getCpuModel();
        r8.mCpuHardware = HardwareInfoHelper.getCpuHardware();
        DisplayMetrics r9 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r9 == null) goto L10;
        r8.mDisplayResolution = HardwareInfoHelper.getDisplayResolution(r9);
        r8.mDisplayDensity = HardwareInfoHelper.getDisplayDensityStr(r9);
        r8.mDisplayDensityDpi = HardwareInfoHelper.getDisplayDensityInt(r9);
    L10:
        r8.mRamSize = HardwareInfoHelper.getRamSize();
        SerializeFactory.store(r1, r8);
    L11:
        return r8;
    L5:
        r8 = null;
        goto L6
    }

    long getJiffy() {
        return this.mJiffies;
    }

    void putTo(JSONObject r3) {
        JSONUtils.put(r3, "device_brand", this.mVendorBrand);
        JSONUtils.put(r3, "device_model", this.mVendorModel);
        JSONUtils.put(r3, "device_manufacturer", this.mVendorManufacturer);
        JSONUtils.put(r3, "density_dpi", Integer.valueOf(this.mDisplayDensityDpi));
        JSONUtils.put(r3, "resolution", this.mDisplayResolution);
        JSONUtils.put(r3, "display_density", this.mDisplayDensity);
        JSONUtils.put(r3, "cpu_abi", this.mCpuAbi);
        JSONUtils.put(r3, KEY_HW_CPU_HARDWARE, this.mCpuHardware);
        JSONUtils.put(r3, KEY_HW_CPU_MODEL, this.mCpuModel);
        JSONUtils.put(r3, KEY_HW_RAM_SIZE, this.mRamSize);
    }
}
