package com.monitor.cloudmessage.b.a;

import android.content.Context;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.monitor.cloudmessage.CloudMessageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h extends com.monitor.cloudmessage.b.a implements com.monitor.cloudmessage.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.monitor.cloudmessage.a.f f5829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f5830b;
    private ConcurrentLinkedQueue<a> c;
    private a d;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5833b;
        final /* synthetic */ h c;

        public a(h r1, String r2, String r3) {
            this.c = r1;
            this.f5832a = r2;
            this.f5833b = r3;
        }
    }

    public h() {
        this.f5830b = null;
        this.c = new ConcurrentLinkedQueue();
        this.d = new a(this, "error_data", "error_ids");
    }

    public String a(String r1) {
        if (LogTypeName.MONITOR_TYPE_BLOCK.equals(r1) == false) goto L5;
        return "log_exception";
    L5:
        return "log_performance";
    }

    public void a(com.monitor.cloudmessage.a.f r3) {
        this.f5829a = (com.monitor.cloudmessage.a.f) ZeusTransformUtils.wrapperContextForParams(r3, com.monitor.cloudmessage.a.f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "monitor_log";
    }

    public String b(String r2) {
        return "cloudMessage_" + r2;
    }

    @Override // com.monitor.cloudmessage.f.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList();
        File r1 = this.f5830b;
        if (r1 == null) goto L5;
        r0.add(r1.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r25) {
        JSONObject r0 = new JSONObject(r25.a());
        if (this.f5829a != null) goto L6;
        return false;
    L6:
        if (a(r0, r25) == false) goto L8;
        return true;
    L8:
        long r19 = r0.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r21 = r0.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        String[] r7 = this.f5829a.a(r0);
        if (r7 != null) goto L11;
    L33:
        return true;
    L11:
        if (r7.length <= 0) goto L33;
        int r6 = r7.length;
        boolean r1 = false;
        boolean r2 = false;
        int r5 = 0;
    L13:
        if (r5 >= r6) goto L30;
        String r4 = r7[r5];
        int r3 = 0;
    L15:
        r3 = r3 + 1;
        if (r3 > 100) goto L29;
        if (this.c.isEmpty() == true) goto L20;
        a r13 = (a) ZeusTransformUtils.preCheckCast(this.c.poll(), a.class, "com.obric.memorydata.plugin");
        if (r13 == this.d) goto L24;
        File r8 = com.monitor.cloudmessage.c.b.a.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13.f5832a, b(r4));
        this.f5830b = r8;
        if (r8 == null) goto L28;
        String r14 = r4;
        com.monitor.cloudmessage.f.b.a r12 = new com.monitor.cloudmessage.f.b.a(a(r4), 0, false, r25.d(), this, null);
        r12.a(1);
        r12.c(true);
        com.monitor.cloudmessage.f.a.a(r12);
        this.f5829a.a(r14, r13.f5833b);
        Thread.sleep(100);
        r2 = false;
        r1 = true;
        r4 = r14;
        r5 = r5;
        r6 = r6;
        r7 = r7;
        r3 = r3;
        goto L15
    L28:
        this.c.clear();
        r1 = false;
        r2 = false;
        goto L29
    L24:
        this.c.clear();
        r2 = false;
        goto L29
    L20:
        if (r2 == true) goto L15;
        this.f5829a.a(r19, r21, r4, new AnonymousClass1(this));
        r2 = true;
    L29:
        r5 = r5 + 1;
        r6 = r6;
        r7 = r7;
        goto L13
    L30:
        if (r1 == false) goto L32;
        c(r25);
        goto L33
    L32:
        a("Monitor日志查询为空", r25);
        goto L33
    }
}
