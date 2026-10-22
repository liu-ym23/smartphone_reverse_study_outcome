package com.bytedance.crash.general;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
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

    @NonNull
    static HardwareInfo get(@NonNull Context r10, @NonNull File r11) {
        File r12 = new File(r11, FILE_NAME);
        HardwareInfo r13 = (HardwareInfo) SerializeFactory.load(r12);     // Catch: Exception -> L5
    L6:
        if (r13 != null) goto L11;
        r13 = new HardwareInfo();
        r13.mVendorModel = HardwareInfoHelper.getVendorModel();
        r13.mVendorBrand = HardwareInfoHelper.getVendorBrand();
        r13.mVendorManufacturer = HardwareInfoHelper.getVendorManufacturer();
        r13.mJiffies = HardwareInfoHelper.getJiffies();
        r13.mCpuAbi = HardwareInfoHelper.getCpuAbi();
        r13.mCpuModel = HardwareInfoHelper.getCpuModel();
        r13.mCpuHardware = HardwareInfoHelper.getCpuHardware();
        DisplayMetrics r14 = r10.getResources().getDisplayMetrics();
        if (r14 == null) goto L10;
        r13.mDisplayResolution = HardwareInfoHelper.getDisplayResolution(r14);
        r13.mDisplayDensity = HardwareInfoHelper.getDisplayDensityStr(r14);
        r13.mDisplayDensityDpi = HardwareInfoHelper.getDisplayDensityInt(r14);
    L10:
        r13.mRamSize = HardwareInfoHelper.getRamSize();
        SerializeFactory.store(r12, r13);
    L11:
        return r13;
    L5:
        r13 = null;
        goto L6
    }

    long getJiffy() {
        return this.mJiffies;
    }

    void putTo(@NonNull JSONObject r10) {
        JSONUtils.put(r10, "device_brand", this.mVendorBrand);
        JSONUtils.put(r10, "device_model", this.mVendorModel);
        JSONUtils.put(r10, "device_manufacturer", this.mVendorManufacturer);
        JSONUtils.put(r10, "density_dpi", Integer.valueOf(this.mDisplayDensityDpi));
        JSONUtils.put(r10, "resolution", this.mDisplayResolution);
        JSONUtils.put(r10, "display_density", this.mDisplayDensity);
        JSONUtils.put(r10, "cpu_abi", this.mCpuAbi);
        JSONUtils.put(r10, KEY_HW_CPU_HARDWARE, this.mCpuHardware);
        JSONUtils.put(r10, KEY_HW_CPU_MODEL, this.mCpuModel);
        JSONUtils.put(r10, KEY_HW_RAM_SIZE, this.mRamSize);
    }
}
