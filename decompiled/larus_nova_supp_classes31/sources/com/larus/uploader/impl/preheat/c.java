package com.larus.uploader.impl.preheat;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "uid");
        String r1 = Locale.getDefault().getCountry();
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L11:
        String r3 = r1.toUpperCase(Locale.US);
        Pair[] r4 = new Pair[6];
        AppHost.Companion r5 = AppHost.a;
        r4[0] = TuplesKt.to("appid", String.valueOf(r5.getAppId()));
        String r6 = z2.a.getDeviceId();
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r4[1] = TuplesKt.to("did", r6);
        r4[2] = TuplesKt.to("uid", r9);
        r4[3] = TuplesKt.to("version_code", String.valueOf(r5.getVersionCode()));
        r4[4] = TuplesKt.to("region", r3);
        r4[5] = TuplesKt.to("device_platform", "android");
        return CollectionsKt.joinToString$default(MapsKt.linkedMapOf(r4).entrySet(), "&", null, null, 0, null, new b(), 30, null);
    L8:
        if (AppHost.a.isOversea() == false) goto L10;
        r1 = "US";
        goto L11
    L10:
        r1 = "CN";
        goto L11
    L5:
        r2 = false;
        goto L6
    }
}
