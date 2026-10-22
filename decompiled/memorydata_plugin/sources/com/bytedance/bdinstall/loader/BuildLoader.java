package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.util.RomUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class BuildLoader extends BaseLoader {
    private final Context mContext;

    BuildLoader(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(true, false);
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r2) {
        r2.put("os", LocationInfoConst.SYSTEM);
        r2.put("os_version", Build.VERSION.RELEASE);
        r2.put("os_api", Build.VERSION.SDK_INT);
        if (Build.BRAND.equals("Pico") == false) goto L5;
        String r1 = RomUtils.getProductName();
    L6:
        r2.put("device_model", r1);
        r2.put("device_brand", Build.BRAND);
        r2.put("device_manufacturer", Build.MANUFACTURER);
        r2.put("cpu_abi", Build.CPU_ABI);
        return true;
    L5:
        r1 = Build.MODEL;
        goto L6
    }
}
