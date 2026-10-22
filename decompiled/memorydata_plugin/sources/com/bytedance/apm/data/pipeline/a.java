package com.bytedance.apm.data.pipeline;

import com.bytedance.apm.e.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.data.a<com.bytedance.apm.data.b> {
    private static volatile a c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f1293b;

    private a() {
    }

    public static a b() {
        if (c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public void a(b r3) {
        this.f1293b = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.apm.data.a
    public void d(com.bytedance.apm.data.b r8) {
        com.bytedance.apm.data.b r9 = (com.bytedance.apm.data.b) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.apm.data.b.class, "com.obric.memorydata.plugin");
        JSONObject r6 = r9.a();
        boolean r4 = r9.a(r6);
        if (com.bytedance.apm.b.k() == true) goto L16;
    L8:
        if (r4 == false) goto L10;
    L12:
        a(r9.b(), r9.c(), r6, r4, false);
        b r7 = this.f1293b;
        if (r7 == null) goto L18;
        r7.a(r9.b(), r9.c(), r6);
        return;
    L18:
        return;
    L10:
        if (r9.d() == true) goto L12;
        return;
    L16:
        e.a(com.bytedance.apm.e.b.h, new Object[]{"logType: " + r9.b() + ", subType: " + r9.c() + "data: " + r6, " ,sample: " + r4});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
