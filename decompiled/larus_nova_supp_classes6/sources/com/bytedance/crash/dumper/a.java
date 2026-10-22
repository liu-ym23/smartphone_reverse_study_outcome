package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.monitor.j;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a {
    public static void a(File r7) {
        com.bytedance.crash.monitor.a r0 = j.a;
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        if (r0.i() == 0) goto L13;
        if (TextUtils.isEmpty(r0.j()) == true) goto L13;
        r1.put("version_code", r0.i());     // Catch: Throwable -> L11
        r1.put("update_version_code", r0.f());     // Catch: Throwable -> L11
        r1.put("version_name", r0.j());     // Catch: Throwable -> L11
        r1.put("app_version", r0.j());     // Catch: Throwable -> L11
        r1.put("manifest_version_code", r0.m());     // Catch: Throwable -> L11
    L13:
        if (r1.length() > 0) goto L18;
        return;
    L18:
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(r7, "version.json"), r1.toString(), false);     // Catch: Exception -> L17
        return;
    }
}
