package com.bytedance.bpea.entry.api.device.info;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import java.net.Inet4Address;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static String a(final Inet4Address r3, TokenCert r4) {
            int r0 = b.a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r2 = com.bytedance.bpea.entry.api.device.info.a.a;     // Catch: BPEAException -> L4
            return (String) r1.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r4, "deviceInfo_inet4Address_getHostAddress", 100028), new InetAddressEntry$Companion$getHostAddressUnsafe$2(r3));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }
    }

    static {
    }
}
