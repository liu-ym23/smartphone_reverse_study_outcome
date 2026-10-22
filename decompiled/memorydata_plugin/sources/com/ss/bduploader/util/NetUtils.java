package com.ss.bduploader.util;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class NetUtils {
    private static Context gContext;

    public NetUtils() {
    }

    public static Context getApplicationContext() {
        return gContext;
    }

    public static void setApplicationContext(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (gContext != null) goto L6;
        gContext = r3;
        return;
    }
}
