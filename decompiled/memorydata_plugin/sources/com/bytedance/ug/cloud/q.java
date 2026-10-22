package com.bytedance.ug.cloud;

import android.os.Bundle;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class q implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f3353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f3354b;
    private List<m> c;
    private AtomicInteger d;

    q(g r3) {
        this.c = new CopyOnWriteArrayList();
        this.d = new AtomicInteger(0);
        this.f3353a = r3;
        a(new n(r3.f3340b));
        if (r3.d == false) goto L7;
        m r0 = a(r3);
        if (r0 == null) goto L7;
        a(r0);
    L7:
        this.f3354b = new d(r3.f3340b, r3.c);
    }

    private m a(g r2) {
        int r3 = this.f3353a.e;
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L9;
        return null;
    L9:
        return new h();
    L11:
        return new i(this.f3353a.f3339a, this.f3353a.f3340b);
    }

    public k a(m r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.c.add(r4);
        return this;
    }

    @Override // com.bytedance.ug.cloud.k
    public void a(String r6, int r7, String r8, Bundle r9) {
        if (r9 == null) goto L11;
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r9.keySet().iterator();
    L5:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r2, r9.get(r2));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        a(r6, r7, r8, r0);
        return;
    L11:
        r0 = null;
        goto L12
    }

    public void a(String r3, int r4, String r5, JSONObject r6) {
        if (r4 != 0) goto L4;
    L6:
        b r1 = new b(this.d.addAndGet(1));
        r1.f3334a = this.f3353a.f3340b;
        r1.f3335b = this.f3353a.c;
        r1.d = r3;
        r1.f = r4;
        r1.h = r6;
        r1.e = r5;
        r1.g = String.valueOf(System.currentTimeMillis());
        this.f3354b.a("ug_sdk_action_check", r1.b());
        Iterator<m> r2 = this.c.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((m) ZeusTransformUtils.preCheckCast(r2.next(), m.class, "com.obric.memorydata.plugin")).a(r1);
        goto L8
    L10:
        return;
    L4:
        if (TextUtils.isEmpty(r5) == false) goto L6;
        r5 = "其他错误";
        goto L6
    }
}
