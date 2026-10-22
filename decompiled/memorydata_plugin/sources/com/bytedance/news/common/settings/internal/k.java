package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
