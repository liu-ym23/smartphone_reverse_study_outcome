package com.bytedance.bdinstall.util;

import android.content.Context;
import android.provider.Settings;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class HardwareUtils {
    public HardwareUtils() {
    }

    public static String getSecureAndroidId(Context r2) {
        return Settings.Secure.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "android_id");
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
