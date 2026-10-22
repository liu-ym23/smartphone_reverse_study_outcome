package com.obric.update.impl.v2.gateway;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public c() {
    }

    public static boolean a() {
        return NetworkUtils.isNetworkAvailable(AppHost.a.getApplication());
    }

    public static boolean b() {
        return NetworkUtils.isWifi(AppHost.a.getApplication());
    }
}
