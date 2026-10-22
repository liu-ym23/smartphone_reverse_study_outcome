package com.larus.dora.impl.device.ota;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTAReporter {
    public static final k0 a = null;

    static {
        a = new k0(0);
    }

    public static void d() {
        k0 r0 = a;
        r0.h = System.currentTimeMillis() / ((long) 1000);
        JSONObject r1 = new JSONObject();
        r1.put("udid", r0.a);
        r1.put("event", r0.b);
        r1.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r0.c);
        r1.put("os_version", r0.d);
        r1.put("product", r0.e);
        JSONObject r2 = new JSONObject();
        r2.put("errcode", r0.f.a);
        r2.put("errmsg", r0.f.b);
        r2.put("retry_count", r0.f.c);
        r2.put("status", r0.f.d);
        r1.put("property", r2);
        r1.put("traceid", r0.g);
        r1.put("timestamp", r0.h);
        l0 r3 = new l0(0);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.f = r3;
        g49.d.d("DoraOTAReporter", "report body: " + r1);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraOTAReporter$reportEvent$1(r1, null), 3, null);
    }

    public static void b(String r2) {
        l0 r0 = a.f;
        r0.d = EventTypeOTAStatus.FAIL.getCode();
        r0.a = EventTypeOTAErrorCode.DOWNLOAD_FAILED.getCode();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.b = r2;
        d();
    }

    public static void c(String r2) {
        l0 r0 = a.f;
        r0.d = EventTypeOTAStatus.FAIL.getCode();
        r0.a = EventTypeOTAErrorCode.INSTALL_FAILED.getCode();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.b = r2;
        d();
    }

    public static void a(String r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "udid");
        Intrinsics.checkNotNullParameter(r3, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r4, "osVersion");
        Intrinsics.checkNotNullParameter(r5, "product");
        Intrinsics.checkNotNullParameter(r6, "traceId");
        k0 r0 = a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.a = r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.c = r3;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.d = r4;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.e = r5;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.g = r6;
    }
}
