package com.bytedance.android.ec.core.sku;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Runnable {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static void a() {
        Map r0 = SkuPerformanceOpt.b();
        if (r0 == null) goto L5;
        Object r1 = r0.get("ec_sku_load_on_boot_finish");
    L6:
        Intrinsics.areEqual(r1, 1);
        qh.a.a();
        Context r10 = ECAppInfoService.e.getApplicationContext();
        if (r10 == null) goto L10;
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "yata_sku", "ecom_sku_pannel_template", wh.a.b(r10), SkuPerformanceOpt$preloadTemplate$1.INSTANCE);
    L10:
        dm.a.a("SkuPerformanceOpt").i("preloadTemplate on bootFinish");
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
