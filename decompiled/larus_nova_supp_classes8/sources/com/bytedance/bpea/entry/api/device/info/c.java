package com.bytedance.bpea.entry.api.device.info;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import java.util.Enumeration;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static Enumeration a(TokenCert r3) {
            int r0 = c.a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r2 = com.bytedance.bpea.entry.api.device.info.a.a;     // Catch: BPEAException -> L4
            return (Enumeration) r1.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r3, "deviceInfo_networkInterface_getNetworkInterfaces", 100016), NetworkInterfaceEntry$Companion$getNetworkInterfacesUnsafe$1.INSTANCE);
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static {
    }
}
