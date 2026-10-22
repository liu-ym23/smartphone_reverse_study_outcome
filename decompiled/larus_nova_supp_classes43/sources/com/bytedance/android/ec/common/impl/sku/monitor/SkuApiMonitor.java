package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.api.LogPbData;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SkuApiMonitor {
    public SkuApiMonitor() {
    }

    public static void a(final SkuViewModel r12, SkuInfoResponseDTO r13, Throwable r14) {
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        Function2<String, Pair<? extends String, ? extends String>[], Unit> r0 = new SkuApiMonitor$monitorApiRequestError$1(r12);
        if (r13 == null) goto L16;
        if (r14 != null) goto L16;
        if (r13.getStatusCode() == 0) goto L33;
        Pair[] r15 = new Pair[5];     // Catch: Throwable -> L29
        r15[0] = new Pair("api_path", "/live/promotion/common_skus/");     // Catch: Throwable -> L29
        r15[1] = new Pair(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, "1");     // Catch: Throwable -> L29
        LogPbData r10 = r13.getLogPb();     // Catch: Throwable -> L29
        if (r10 == null) goto L14;
        String r11 = r10.getImprId();     // Catch: Throwable -> L29
        if (r11 == null) goto L14;
    L15:
        r15[2] = new Pair(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, r11);     // Catch: Throwable -> L29
        r15[3] = new Pair("status_code", String.valueOf(r13.getStatusCode()));     // Catch: Throwable -> L29
        r15[4] = new Pair("error_desc", r13.getStatusMsg());     // Catch: Throwable -> L29
        r0.invoke("api_request_error_event", r15);     // Catch: Throwable -> L29
        dm.a.a("live_api_request_error").w(r15.toString(), null);     // Catch: Throwable -> L29
        return;
    L14:
        r11 = "";
        goto L15
    L33:
        return;
    L16:
        Pair[] r16 = new Pair[3];     // Catch: Throwable -> L29
        r16[0] = new Pair("api_path", "/live/promotion/common_skus/");     // Catch: Throwable -> L29
        r16[1] = new Pair(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, "0");     // Catch: Throwable -> L29
        String r17 = "response is null";
        if (r14 == null) goto L20;
        String r18 = r14.getMessage();     // Catch: Throwable -> L29
    L21:
        r16[2] = new Pair("error_desc", r18);     // Catch: Throwable -> L29
        r0.invoke("api_request_error_event", r16);     // Catch: Throwable -> L29
        dm.a.b r19 = dm.a.a("live_api_request_error");     // Catch: Throwable -> L29
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L29
        r1.append(r16);     // Catch: Throwable -> L29
        r1.append(" Throwable: ");     // Catch: Throwable -> L29
        if (r14 == null) goto L27;
        String r110 = r14.toString();     // Catch: Throwable -> L29
        if (r110 == null) goto L27;
        r17 = r110;
    L27:
        r1.append(r17);     // Catch: Throwable -> L29
        r19.w(r1.toString(), null);     // Catch: Throwable -> L29
        return;
    L20:
        r18 = "response is null";
    L29:
        th = move-exception;
        ECExceptionMonitor.f(th, "api request error monitor has an exception");
    }
}
