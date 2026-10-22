package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final boolean a() {
        Object r0 = LarkNetworkLevelManager.d;
        if (b(LarkNetworkLevelManager.a.a().getCurNetWorkLevel()) == true) goto L20;
        Object r1 = LarkContext.getApplication().getSystemService("connectivity");
        if ((r1 instanceof ConnectivityManager) == false) goto L7;
        ConnectivityManager r2 = (ConnectivityManager) r1;
    L9:
        if (r2 == null) goto L15;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 == null) goto L15;
        if (r3.isConnected() != true) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L21;
        return false;
    L21:
        return true;
    L15:
        r4 = false;
        goto L16
    L7:
        r2 = null;
        goto L9
    L20:
        return true;
    }

    public static final boolean b(NetworkLevelListener.NetworkLevel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1 != NetworkLevelListener.NetworkLevel.NET_UNAVAILABLE) goto L5;
    L10:
        return true;
    L5:
        if (r1 == NetworkLevelListener.NetworkLevel.SERVICE_UNAVAILABLE) goto L10;
        if (r1 == NetworkLevelListener.NetworkLevel.OFFLINE) goto L10;
        return false;
    }
}
