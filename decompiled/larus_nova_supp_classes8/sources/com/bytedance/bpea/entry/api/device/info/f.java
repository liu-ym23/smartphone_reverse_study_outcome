package com.bytedance.bpea.entry.api.device.info;

import android.content.Context;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static String a(final Context r3, TokenCert r4) {
            int r0 = f.a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r1 = BaseAuthEntry.a;     // Catch: BPEAException -> L4
            int r2 = com.bytedance.bpea.entry.api.device.info.a.a;     // Catch: BPEAException -> L4
            return (String) r1.a(com.bytedance.bpea.entry.api.device.info.a.C0370a.a(r4, "deviceInfo_settings_getAndroidId", 102003), new SettingsEntry$Companion$getAndroidIdUnsafe$1(r3));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }
    }

    static {
    }
}
