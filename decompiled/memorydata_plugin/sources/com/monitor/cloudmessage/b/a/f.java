package com.monitor.cloudmessage.b.a;

import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class f extends com.monitor.cloudmessage.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5826a;

    public f() {
        this.f5826a = 0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "new_file";
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r8) {
        JSONObject r0 = r8.b();
        if ((System.currentTimeMillis() - this.f5826a) >= 120000) goto L6;
        com.monitor.cloudmessage.e.a.a("2分钟不重复处理文件回捞", r8);
        return false;
    L6:
        this.f5826a = System.currentTimeMillis();
        String r7 = r0.optString("rootNode");
        String r1 = r0.optString("relativeFilename");
        if (r1.contains("../") == true) goto L50;
        if ("systemlib_so".equals(r7) == true) goto L11;
        File r9 = com.monitor.cloudmessage.utils.c.b(r7, r1);
    L25:
        if (r9 == null) goto L48;
        com.monitor.cloudmessage.e.a.a("handling file upload:" + r9.getAbsolutePath(), r8);
        if (r9.exists() == false) goto L46;
        if (r9.canRead() == false) goto L44;
        if (r9.isDirectory() == true) goto L33;
    L37:
        File r2 = com.monitor.cloudmessage.e.b.a().b();
        if (r2 == null) goto L42;
        File r3 = new File(r2, r8.d() + "_temp");
        com.monitor.cloudmessage.utils.c.a(r3);
        com.monitor.cloudmessage.utils.c.a(new File(r3, "result.zip").getAbsolutePath(), new String[]{r9.getAbsolutePath()});
        com.monitor.cloudmessage.e.b.a().a(r8, r3, r0.optString("fileContentType", "unknown"));
        return true;
    L42:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L33:
        if (com.bytedance.apm.util.b.a(r9) <= 134217728) goto L37;
        throw new CloudMessageException("回捞目录过大，禁止回捞");
    L44:
        throw new CloudMessageException("文件或目录无可读权限");
    L46:
        throw new CloudMessageException("文件或目录不存在");
    L48:
        throw new CloudMessageException("目录参数解析失败");
    L11:
        if (r1.endsWith(".so") == false) goto L13;
    L23:
        r9 = new File(r1);
        goto L25
    L13:
        if (r1.endsWith(".odex") == true) goto L23;
        if (r1.endsWith(".jar") == true) goto L23;
        if (r1.endsWith(".vdex") == true) goto L23;
        if (r1.endsWith(".art") == true) goto L23;
        throw new CloudMessageException("非so, jar, odex, vdex, art 文件无权回捞");
    L50:
        throw new CloudMessageException("it's not allowed to use the form `../` to route in path");
    }
}
