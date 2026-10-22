package com.bytedance.android.monitorV2;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements t4.b {
    @Override // t4.b
    public final void a(String r10, String r11, JSONObject r12) {
        if (com.bytedance.apm.util.a.f3906c == false) goto L32;
        d5.b.f("HybridMultiMonitor", "fileRecord, outputFile: " + com.bytedance.apm.util.a.f3906c + ", service: " + r10 + ", eventType: " + r11);
        Intrinsics.checkNotNullParameter(r11, "eventType");
        Intrinsics.checkNotNullParameter(r12, "data");
        if (Intrinsics.areEqual("samplecustom", r11) == false) goto L7;
    L30:
        String r13 = r12.getJSONObject("extra").optString("url", "");     // Catch: Exception -> L25
        File r14 = k5.d.c(h.e().f3581a, "monitor_data_debug");     // Catch: Exception -> L25
        if (r14 != null) goto L22;
        return;
    L22:
        if (r14.exists() == false) goto L37;
        k5.d.f(new File(r14, "custom_with_" + Uri.parse(r13).getQueryParameter("bytest_case_id")).getAbsolutePath(), StringsKt.trimIndent("\n     " + r12 + "\n     \n     "));     // Catch: Exception -> L25
        return;
    L37:
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (Intrinsics.areEqual("newcustom", r11) == true) goto L30;
        if (Intrinsics.areEqual("custom", r11) == true) goto L30;
        JSONObject r15 = r12.getJSONObject("extra").getJSONObject("nativeBase");     // Catch: Exception -> L17
        String r16 = r15.getString("navigation_id");     // Catch: Exception -> L17
        String r17 = r15.optString("url", "");     // Catch: Exception -> L17
        File r18 = k5.d.c(h.e().f3581a, "monitor_data_debug");     // Catch: Exception -> L17
        if (r18 != null) goto L14;
        return;
    L14:
        if (r18.exists() == false) goto L34;
        String r19 = new File(r18, r16 + "_with_" + Uri.parse(r17).getQueryParameter("bytest_case_id")).getAbsolutePath();     // Catch: Exception -> L17
        StringBuilder r20 = new StringBuilder("\n     ");     // Catch: Exception -> L17
        r20.append(r12);     // Catch: Exception -> L17
        r20.append("\n     \n     ");     // Catch: Exception -> L17
        k5.d.f(r19, StringsKt.trimIndent(r20.toString()));     // Catch: Exception -> L17
        return;
    L34:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
