package com.bytedance.frameworks.baselib.network.http;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c.C0124c> f2435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2436b;
    private final List<a> c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2438b;
        public int c;
        public long d;
        public long e;
        public boolean f;

        public a(String r1, String r2, int r3, long r4, long r6, boolean r8) {
            this.f2437a = r1;
            this.f2438b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r8;
        }
    }

    public i(List<c.C0124c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        this.f2435a = r0;
        this.f2436b = 0;
        this.c = new CopyOnWriteArrayList();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L10;
        r0.addAll(r4);
        return;
    }

    public void a(String r12, String r13, int r14, long r15, h r17, b r18) {
        if (r17 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r10 = r1;
        if (r18.aa <= 0) goto L11;
        long r2 = r18.aa;
    L12:
        a r3 = new a(r12, r13, r14, r15, System.currentTimeMillis() - r2, r10);
        this.c.add(r3);
        if (r18.d == null) goto L16;
        r18.d.setRotationHostRetryInfo(c());
        return;
    L16:
        return;
    L11:
        r2 = r18.g;
        goto L12
    L5:
        if (r17.a() == false) goto L7;
        r1 = true;
        goto L8
    }

    public boolean a() {
        if (this.f2435a.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f2436b >= this.f2435a.size()) goto L8;
        return false;
    }

    public c.C0124c b() {
        if (this.f2436b < this.f2435a.size()) goto L6;
        return null;
    L6:
        List<c.C0124c> r0 = this.f2435a;
        int r1 = this.f2436b;
        this.f2436b = r1 + 1;
        return (c.C0124c) ZeusTransformUtils.preCheckCast(r0.get(r1), c.C0124c.class, "com.obric.memorydata.plugin");
    }

    public JSONObject c() {
        if (this.c.isEmpty() == false) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        Iterator<a> r6 = this.c.iterator();     // Catch: JSONException -> L13
    L9:
        if (r6.hasNext() == false) goto L12;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L13
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L13
        r2.put("callback_duration", r1.d);     // Catch: JSONException -> L13
        r2.put("request_duration", r1.e);     // Catch: JSONException -> L13
        r2.put("code", r1.c);     // Catch: JSONException -> L13
        r0.put(r1.f2437a + r1.f2438b, r2);     // Catch: JSONException -> L13
    L12:
        return r0;
    }

    public i d() {
        ArrayList r0 = new ArrayList();
        Iterator<c.C0124c> r1 = this.f2435a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(((c.C0124c) ZeusTransformUtils.preCheckCast(r1.next(), c.C0124c.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        i r2 = new i(r0);
        r2.f2436b = this.f2436b;
        Iterator<a> r14 = this.c.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.memorydata.plugin");
        r2.c.add(new a(r3.f2437a, r3.f2438b, r3.c, r3.d, r3.e, r3.f));
        goto L8
    L10:
        return r2;
    }
}
