package com.bytedance.bdinstall.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.util.RomUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class BuildLoader extends BaseLoader {
    private final Context mContext;

    BuildLoader(Context r10) {
        super(true, false);
        this.mContext = r10;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    @SuppressLint({"MissingPermission"})
    protected boolean doLoad(JSONObject r10) {
        r10.put("os", "Android");
        r10.put("os_version", Build.VERSION.RELEASE);
        r10.put("os_api", Build.VERSION.SDK_INT);
        String r11 = Build.BRAND;
        if (r11.equals("Pico") == false) goto L5;
        Object r12 = RomUtils.getProductName();
    L6:
        r10.put("device_model", r12);
        r10.put("device_brand", r11);
        r10.put("device_manufacturer", Build.MANUFACTURER);
        r10.put("cpu_abi", Build.CPU_ABI);
        return true;
    L5:
        r12 = Build.MODEL;
        goto L6
    }
}
