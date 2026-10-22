package com.bytedance.bpea.entry.api.device.info;

import android.content.pm.PackageManager;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static List a(final PackageManager r4, final int r5, TokenCert r6) {
            ArrayList r0 = new ArrayList();
            int r1 = d.a;     // Catch: BPEAException -> L5
            BaseAuthEntry.Companion r2 = BaseAuthEntry.a;     // Catch: BPEAException -> L5
            int r3 = com.bytedance.bpea.entry.api.device.info.a.a;     // Catch: BPEAException -> L5
            return (List) r2.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r6, "deviceInfo_packageManger_getInstalledPackages", 101309), new PackageManagerEntry$Companion$getInstalledPackagesUnsafe$1(r4, r5));
        L5:
            e = move-exception;
            e.printStackTrace();
            return r0;
        }
    }

    static {
    }
}
