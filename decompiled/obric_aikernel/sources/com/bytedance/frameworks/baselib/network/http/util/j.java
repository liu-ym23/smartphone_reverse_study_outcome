package com.bytedance.frameworks.baselib.network.http.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<String>> f1888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1889b;

    public j(String r10) {
        this.f1888a = new LinkedHashMap();
        this.f1889b = r10;
    }

    public void a(String r10, int r11) {
        List<String> r12 = this.f1888a.get(r10);
        if (r12 != null) goto L5;
        r12 = new LinkedList();
    L5:
        r12.add(String.valueOf(r11));
        this.f1888a.put(r10, r12);
    }

    public void b(String r10, String r11) {
        List<String> r12 = this.f1888a.get(r10);
        if (r12 != null) goto L5;
        r12 = new LinkedList();
    L5:
        r12.add(String.valueOf(r11));
        this.f1888a.put(r10, r12);
    }

    public String c() {
        if (this.f1888a.isEmpty() == true) goto L5;
        String r10 = k.c(this.f1888a, "UTF-8");
        String r11 = this.f1889b;
        if (r11 != null) goto L9;
    L17:
        return r10;
    L9:
        if (r11.length() == 0) goto L17;
        if (this.f1889b.indexOf(63) < 0) goto L16;
        StringBuilder r12 = new StringBuilder();
        r12.append(this.f1889b);
        String r13 = "&";
    L14:
        r12.append(r13);
        r12.append(r10);
        return r12.toString();
    L16:
        r12 = new StringBuilder();
        r12.append(this.f1889b);
        r13 = "?";
        goto L14
    L5:
        return this.f1889b;
    }

    public String toString() {
        return c();
    }
}
