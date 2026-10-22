package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<String>> f2551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2552b;

    public j() {
        this.f2551a = new LinkedHashMap();
        this.f2552b = null;
    }

    public j(String r2) {
        this.f2551a = new LinkedHashMap();
        this.f2552b = r2;
    }

    public String a() {
        if (this.f2551a.isEmpty() == true) goto L5;
        String r0 = k.a(this.f2551a, RpcUtils.CHARSET_UTF8);
        String r1 = this.f2552b;
        if (r1 != null) goto L9;
    L17:
        return r0;
    L9:
        if (r1.length() == 0) goto L17;
        if (this.f2552b.indexOf(63) < 0) goto L16;
        StringBuilder r3 = new StringBuilder().append(this.f2552b);
        String r2 = "&";
    L15:
        return r3.append(r2).append(r0).toString();
    L16:
        r3 = new StringBuilder().append(this.f2552b);
        r2 = "?";
        goto L15
    L5:
        return this.f2552b;
    }

    public void a(String r4, int r5) {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(this.f2551a.get(r4), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r5));
        this.f2551a.put(r4, r0);
    }

    public void a(String r4, String r5) {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(this.f2551a.get(r4), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r5));
        this.f2551a.put(r4, r0);
    }

    public String toString() {
        return a();
    }
}
