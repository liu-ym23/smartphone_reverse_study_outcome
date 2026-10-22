package com.bytedance.frameworks.baselib.network.d;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f2318a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set<String> f2319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Set<String> f2320b;
        public Set<String> c;
        private final String d;

        a(String r1) {
            this.d = r1;
        }

        static /* synthetic */ String a(a r0) {
            return r0.d;
        }

        boolean a() {
            if (com.bytedance.common.utility.collection.a.a(this.f2319a) == true) goto L5;
        L9:
            return false;
        L5:
            if (com.bytedance.common.utility.collection.a.a(this.f2320b) == false) goto L9;
            if (com.bytedance.common.utility.collection.a.a(this.c) == false) goto L9;
            return true;
        }
    }

    public c() {
        this.f2318a = new ArrayList();
    }

    public JSONObject a() {
        if (com.bytedance.common.utility.collection.a.a(this.f2318a) == false) goto L6;
        return null;
    L6:
        JSONObject r1 = new JSONObject();
        Iterator<a> r8 = this.f2318a.iterator();     // Catch: Exception -> L40
    L8:
        if (r8.hasNext() == false) goto L39;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L40
        if (r2 == null) goto L8;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L40
        if (com.bytedance.common.utility.collection.a.a(r2.f2319a) == true) goto L20;
        JSONArray r4 = new JSONArray();     // Catch: Exception -> L40
        Iterator<String> r5 = r2.f2319a.iterator();     // Catch: Exception -> L40
    L16:
        if (r5.hasNext() == false) goto L18;
        r4.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L40
        goto L16
    L18:
        r3.put("rm_header", r4);     // Catch: Exception -> L40
    L20:
        if (com.bytedance.common.utility.collection.a.a(r2.f2320b) == true) goto L27;
        JSONArray r6 = new JSONArray();     // Catch: Exception -> L40
        Iterator<String> r7 = r2.f2320b.iterator();     // Catch: Exception -> L40
    L23:
        if (r7.hasNext() == false) goto L25;
        r6.put((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L40
        goto L23
    L25:
        r3.put("rm_query", r6);     // Catch: Exception -> L40
    L27:
        if (com.bytedance.common.utility.collection.a.a(r2.c) == true) goto L34;
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L40
        Iterator<String> r10 = r2.c.iterator();     // Catch: Exception -> L40
    L30:
        if (r10.hasNext() == false) goto L32;
        r9.put((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L40
        goto L30
    L32:
        r3.put("add_query", r9);     // Catch: Exception -> L40
    L34:
        if (TextUtils.isEmpty(a.a(r2)) == false) goto L36;
        String r11 = "null";
    L37:
        r1.put(r11, r3);     // Catch: Exception -> L40
        goto L8
    L36:
        r11 = a.a(r2);     // Catch: Exception -> L40
    L39:
        return r1;
    }

    void a(a r1) {
        if (r1 == null) goto L5;
        this.f2318a.add(r1);
        return;
    }
}
