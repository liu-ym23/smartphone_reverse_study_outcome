package com.ttnet.org.chromium.base.compat;

import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.net.LinkProperties;
import com.ttnet.org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(28)
@DoNotInline
public final class ApiHelperForP {
    private ApiHelperForP() {
    }

    public static long getLongVersionCode(PackageInfo r8) {
        return r8.getLongVersionCode();
    }

    public static String getPrivateDnsServerName(LinkProperties r8) {
        return r8.getPrivateDnsServerName();
    }

    public static boolean isPrivateDnsActive(LinkProperties r8) {
        return r8.isPrivateDnsActive();
    }
}
