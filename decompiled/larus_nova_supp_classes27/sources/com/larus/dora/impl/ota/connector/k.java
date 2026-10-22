package com.larus.dora.impl.ota.connector;

import com.bytedance.keva.Keva;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new i());
    }

    public static Keva b() {
        return (Keva) a.getValue();
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        g49.d.d("OtaWifiRecoveryStore", "clear: reason=" + r4 + ", device=" + c(b().getString("sn", "")) + ", fileName=" + b().getString("file_name", ""));
        b().erase("sn");
        b().erase("file_name");
        b().erase("mark_time");
    }

    public static String c(String r9) {
        if (StringsKt.isBlank(r9) == false) goto L7;
        return "";
    L7:
        return CollectionsKt.joinToString$default(ArraysKt.take(MessageDigest.getInstance("SHA-256").digest(("dora_ota_wifi_recovery_v1:" + r9).getBytes(Charsets.UTF_8)), 16), "", null, null, 0, null, new j(), 30, null);
    }

    public static void d(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "sn");
        Intrinsics.checkNotNullParameter(r6, "fileName");
        if (StringsKt.isBlank(r5) == false) goto L6;
        g49.d.e("OtaWifiRecoveryStore", "markUploadStarted: skip because sn is blank, fileName=" + r6);
        return;
    L6:
        b().storeString("sn", r5);
        b().storeString("file_name", r6);
        b().storeLong("mark_time", System.currentTimeMillis());
        g49.d.d("OtaWifiRecoveryStore", "markUploadStarted: device=" + c(r5) + ", fileName=" + r6);
    }
}
