package com.obric.memorydata.utils;

import android.app.KeyguardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    public static int a(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        return r0.get(11);
    }

    public static boolean a(Context r2) {
        return ((KeyguardManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("keyguard"), KeyguardManager.class, "com.obric.memorydata.plugin")).isKeyguardLocked();
    }

    public static boolean b(Context r2) {
        ConnectivityManager r3 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        NetworkInfo r4 = r3.getActiveNetworkInfo();
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r4.isConnected() == true) goto L9;
        return false;
    L9:
        if (r4.getType() == 1) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }
}
