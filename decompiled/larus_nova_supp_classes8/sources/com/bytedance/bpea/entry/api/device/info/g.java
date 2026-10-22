package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.WifiInfo;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static Integer a(final WifiInfo r4, TokenCert r5) {
            int r0 = 0;
            int r1 = g.a;     // Catch: BPEAException -> L5
            BaseAuthEntry.Companion r2 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
            int r3 = com.bytedance.bpea.entry.api.device.info.a.a;     // Catch: BPEAException -> L5
            return Integer.valueOf(((Number) r2.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r5, "deviceInfo_wifiInfo_getIpAddress", 102304), new WifiInfoEntry$Companion$getIpAddressUnsafe$1(r4))).intValue());
        L5:
            e = move-exception;
            e.printStackTrace();
            return r0;
        }

        @JvmStatic
        public static String b(final WifiInfo r3, TokenCert r4) {
            int r0 = g.a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r2 = com.bytedance.bpea.entry.api.device.info.a.a;     // Catch: BPEAException -> L4
            return (String) r1.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r4, "deviceInfo_wifiInfo_getMacAddress", 101700), new WifiInfoEntry$Companion$getMacAddressUnsafe$1(r3));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }
    }

    static {
    }
}
