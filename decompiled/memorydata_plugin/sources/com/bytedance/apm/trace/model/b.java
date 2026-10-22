package com.bytedance.apm.trace.model;

import android.text.TextUtils;
import com.bytedance.apm.trace.api.c;
import com.bytedance.apm.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.apm.trace.api.a, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1476b;
    private final long c;
    private long d;
    private long e;
    private final a f;
    private String g;
    private Map<String, String> h;
    private List<com.bytedance.b.a.b> i;
    private boolean j;
    private long k;
    private long l;

    b(String r1, String r2, a r3, long r4) {
        this.f1475a = r1;
        this.f = r3;
        this.f1476b = r2;
        this.c = r4;
    }

    static /* synthetic */ long a(b r2) {
        return r2.c;
    }

    private JSONObject a() {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L23
        r1.put("log_type", this.f1476b);     // Catch: JSONException -> L23
        r1.put("span_id", this.c + "");     // Catch: JSONException -> L23
        r1.put("operation_name", this.f1475a);     // Catch: JSONException -> L23
        if (this.d == 0) goto L7;
        r1.put("parent_id", this.d + "");     // Catch: JSONException -> L23
    L7:
        if (this.e == 0) goto L9;
        r1.put("reference_id", this.e + "");     // Catch: JSONException -> L23
    L9:
        r1.put("start_timestamp", this.k);     // Catch: JSONException -> L23
        r1.put("finish_timestamp", this.l);     // Catch: JSONException -> L23
        Map<String, String> r0 = this.h;     // Catch: JSONException -> L23
        if (r0 == null) goto L15;
        if (r0.isEmpty() == true) goto L15;
        r1.put("tags", new JSONObject(this.h));     // Catch: JSONException -> L23
    L15:
        if (i.a(this.i) == true) goto L21;
        JSONArray r2 = new JSONArray();     // Catch: JSONException -> L23
        Iterator<com.bytedance.b.a.b> r3 = this.i.iterator();     // Catch: JSONException -> L23
    L18:
        if (r3.hasNext() == false) goto L20;
        r2.put(((com.bytedance.b.a.b) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.b.a.b.class, "com.obric.memorydata.plugin")).a());     // Catch: JSONException -> L23
        goto L18
    L20:
        r1.put("logs", r2);     // Catch: JSONException -> L23
    L21:
        r1.put("thread_id", this.g);     // Catch: JSONException -> L23
        r1.put("is_finished", 1);     // Catch: JSONException -> L23
        return r1;
    L23:
        return null;
    }

    static /* synthetic */ JSONObject b(b r0) {
        return r0.a();
    }

    static /* synthetic */ boolean c(b r0) {
        return r0.j;
    }

    static /* synthetic */ a d(b r0) {
        return r0.f;
    }

    @Override // com.bytedance.apm.trace.api.b
    public com.bytedance.apm.trace.api.a a(long r1) {
        this.d = r1;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.b
    public com.bytedance.apm.trace.api.a a(String r1) {
        this.g = r1;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.b
    public com.bytedance.apm.trace.api.a a(String r2, String r3) {
        this.f.a(r2);
        if (this.h != null) goto L6;
        this.h = new HashMap();
    L6:
        if (TextUtils.equals(r2, "error") == false) goto L8;
        this.j = true;
    L8:
        this.h.put(r2, r3);
        return this;
    }

    @Override // com.bytedance.apm.trace.api.c
    public void a(long r2, long r4) {
        String r0 = this.g;
        if (r0 != null) goto L5;
    L6:
        this.g = Thread.currentThread().getName();
    L7:
        this.k = r2;
        this.l = r4;
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(this));
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    @Override // com.bytedance.apm.trace.api.b
    public com.bytedance.apm.trace.api.a b(long r1) {
        this.e = r1;
        return this;
    }
}
