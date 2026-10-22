package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static WifiInfo a(final WifiManager r3, TokenCert r4) {
            int r0 = h.a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r2 = com.bytedance.bpea.entry.api.device.info.a.a;     // Catch: BPEAException -> L4
            return (WifiInfo) r1.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r4, "deviceInfo_wifimanager_getConnectionInfo", 102301), new WifiManagerEntry$Companion$getConnectionInfoUnsafe$1(r3));
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static {
    }
}
