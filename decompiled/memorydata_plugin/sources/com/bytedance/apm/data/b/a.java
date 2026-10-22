package com.bytedance.apm.data.b;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f1291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.k.a<JSONObject> f1292b;

    private a() {
        this.f1292b = new com.bytedance.apm.k.a(20);
    }

    public static a a() {
        if (f1291a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1291a != null) goto L9;
        f1291a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1291a;
    }

    public void a(JSONObject r1) {
        this.f1292b.a(r1);
    }

    public List<JSONObject> b() {
        return this.f1292b.a();
    }
}
