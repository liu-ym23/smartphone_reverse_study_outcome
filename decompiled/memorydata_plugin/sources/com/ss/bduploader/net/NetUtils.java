package com.ss.bduploader.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class NetUtils {
    public static final int NETTYPE_UNKNOWN = -1;

    public NetUtils() {
    }

    public static String getNetExtraInfo(Context r2) {
        NetworkInfo r3 = getNetworkInfo((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        if (r3.isAvailable() == false) goto L9;
        return r3.getExtraInfo();
    L9:
        return null;
    }

    public static int getNetType(Context r2) {
        NetworkInfo r3 = getNetworkInfo((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        if (r3 == null) goto L9;
        if (r3.isAvailable() == false) goto L9;
        return r3.getType();
    L9:
        return -1;
    }

    public static NetworkInfo getNetworkInfo(Context r2) {
        return ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();
    L5:
        return null;
    }
}
