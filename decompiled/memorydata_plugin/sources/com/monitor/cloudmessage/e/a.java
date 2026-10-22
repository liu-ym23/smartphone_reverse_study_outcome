package com.monitor.cloudmessage.e;

import com.bytedance.apm.e.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static void a(String r3) {
        a(r3, "上传成功", 2, null);
    }

    public static void a(String r2, com.monitor.cloudmessage.entity.a r3) {
        a(r3.d(), r2, 0, null);
    }

    public static void a(String r2, com.monitor.cloudmessage.entity.a r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        a(r3.d(), r2, 0, r5);
    }

    public static void a(String r7, String r8, int r9, Map<String, String> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        if (com.bytedance.apm.b.k() == false) goto L5;
        e.d("cloudmessage", new String[]{"report: commandId=" + r7, ", message=" + r8, ", code=" + r9, ", specificParams=" + r11});
    L5:
        HashMap r0 = null;
        if (r11 == null) goto L8;
        r0 = new HashMap(r11);
    L8:
        com.monitor.cloudmessage.f.b.b r12 = new com.monitor.cloudmessage.f.b.b(0, false, r7, r0);
        r12.a(r9);
        r12.a(r8);
        com.monitor.cloudmessage.f.a.a(r12);
    }

    public static boolean a(String r10, File r11, String r12, String r13) {
        if (com.bytedance.apm.b.k() == false) goto L6;
        e.d("cloudmessage", new String[]{"postFile: commandId=" + r10, "postFile=" + r11.getAbsolutePath(), ", uploadMessage=" + r13, ", fileType=" + r12});
    L6:
        return com.monitor.cloudmessage.f.c.a.a(r11, 1, r12, r10, r13, System.currentTimeMillis(), null);
    }
}
