package com.bytedance.crash.dumper;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MemoryInfo {
    public static void a(File r2) {
        Context r0 = com.bytedance.crash.i.getContext();
        if (r0 == null) goto L6;
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");
        DevMemoryInfo.dump(r2);
        SysMemoryInfo.dump(r2, r1);
        AppMemoryInfo.dump(r2, r1);
        return;
    }

    public static void b(JSONObject r12, File r13) {
        JSONObject r0 = null;
        BufferedReader r1 = null;
        if (r13 == null) goto L20;
        AppMemoryInfo r2 = AppMemoryInfo.load(r13);
        SysMemoryInfo r3 = SysMemoryInfo.load(r13);
        DevMemoryInfo r4 = DevMemoryInfo.load(r13);
        JSONObject r5 = new JSONObject();
        PolarisFileWrapper r6 = new PolarisFileWrapper(r13, "sys_memtrack.txt");
        if (r6.exists() == true) goto L53;
    L19:
        r0 = r5;
    L27:
        if (r2 == null) goto L29;
        r2.pushTo(r12);
    L29:
        if (r3 == null) goto L31;
        r3.pushTo(r12);
    L31:
        if (r4 == null) goto L33;
        r4.pushTo(r12);
    L33:
        if (r0 == null) goto L46;
        JSONObject r7 = r12.optJSONObject("memory_info");
        if (r7 != null) goto L39;
        r12.putOpt("memory_info", r0);     // Catch: Throwable -> L47
        return;
    L70:
        return;
    L39:
        if (r7.has("graphicPss") == true) goto L68;
        Iterator<String> r14 = r0.keys();
    L42:
        if (r14.hasNext() == false) goto L71;
        String r15 = r14.next();
        if (r7.has(r15) == true) goto L42;
        r7.put(r15, r0.opt(r15));
        goto L42
    L71:
        return;
    L68:
        return;
    L46:
        return;
    L53:
        BufferedReader r16 = new BufferedReader(new PolarisFileReaderWrapper(r6));     // Catch: Throwable -> L48
    L51:
        String r8 = r16.readLine();     // Catch: Throwable -> L17
        if (r8 == null) goto L16;
        if ("".equals(r8) == true) goto L51;
        String[] r9 = r8.split(" ");     // Catch: Throwable -> L17
        if (r9.length != 3) goto L51;
        String r10 = r9[0];     // Catch: Throwable -> L17
        r5.putOpt(r10.substring(0, r10.length() - 1), Long.valueOf(Long.parseLong(r9[1]) * 1024));     // Catch: Throwable -> L17
        goto L51
    L16:
        com.bytedance.crash.util.i.a(r16);
    L17:
        r1 = r16;
    L18:
        com.bytedance.crash.util.i.a(r1);
        goto L19
    L20:
        Context r17 = com.bytedance.crash.i.getContext();
        if (r17 == null) goto L25;
        ActivityManager r18 = (ActivityManager) r17.getSystemService("activity");
        if (r18 == null) goto L25;
        r2 = new AppMemoryInfo(r18);
        r3 = new SysMemoryInfo(r18);
    L26:
        r4 = new DevMemoryInfo();
    L25:
        r2 = null;
        r3 = null;
        goto L26
    }
}
