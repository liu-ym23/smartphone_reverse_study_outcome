package com.monitor.cloudmessage.b.a;

import android.content.Context;
import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d extends com.monitor.cloudmessage.b.a implements com.monitor.cloudmessage.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f5824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5825b;

    public d() {
        this.f5824a = null;
        this.f5825b = false;
    }

    private void e(com.monitor.cloudmessage.entity.a r7) {
        com.monitor.cloudmessage.f.b.b r6 = new com.monitor.cloudmessage.f.b.b(0, false, r7.d(), null);
        r6.a(0);
        r6.a("数据库文件正在处理中");
        com.monitor.cloudmessage.f.a.a(r6);
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "db";
    }

    @Override // com.monitor.cloudmessage.f.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f5824a;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r14) {
        JSONObject r1 = new JSONObject(r14.a());
        if (a(r1, r14) == false) goto L6;
        return true;
    L6:
        if (this.f5825b == false) goto L9;
        e(r14);
        return true;
    L9:
        this.f5825b = true;
        File r2 = null;
        String r5 = r1.optString("db_name", "");     // Catch: Throwable -> L17
        r2 = com.monitor.cloudmessage.c.b.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L17
    L11:
        this.f5825b = false;
        if (r2 != null) goto L15;
        a("Sqlite文件拷贝失败", r14);
        return true;
    L15:
        this.f5824a = r2;
        com.monitor.cloudmessage.f.b.a r0 = new com.monitor.cloudmessage.f.b.a(r1.optString("fileContentType", "default_db_file_type"), 0, false, r14.d(), this, null);
        r0.a(false);
        r0.b(true);
        com.monitor.cloudmessage.f.a.a(r0);
        return true;
    }
}
