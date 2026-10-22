package com.bytedance.bdinstall.util;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class InstallPmsUtils {
    public InstallPmsUtils() {
    }

    private static boolean checkPermission(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        return true;
    L12:
        if (r5.checkSelfPermission(r4) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public static boolean checkReadPhoneStatePermission(Context r2) {
        return checkPermission((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_PHONE_STATE");
    }
}
