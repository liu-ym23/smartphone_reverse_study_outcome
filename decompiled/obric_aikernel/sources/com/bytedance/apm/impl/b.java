package com.bytedance.apm.impl;

import androidx.annotation.Nullable;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import r4.d;
import r4.f;

/* JADX INFO: loaded from: classes.dex */
final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f957b;

    public b(@Nullable Map<String, String> r10, d r11) {
        this.f957b = r10;
        this.f956a = r11;
    }

    private String c() {
        StringBuilder r10 = new StringBuilder(this.f956a.b());
        r10.append("\"");
        Iterator<Map.Entry<String, String>> r11 = this.f957b.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, String> r12 = r11.next();
        String r13 = r12.getKey();
        String r14 = r12.getValue();
        r10.append("; ");
        r10.append(r13);
        r10.append("=\"");
        r10.append(r14);
        r10.append("\"");
        goto L4
    L6:
        r10.deleteCharAt(r10.length() - 1);
        return r10.toString();
    }

    @Override // r4.f
    public String a() {
        return this.f956a.a();
    }

    @Override // r4.f
    public String b() {
        return c();
    }

    @Override // r4.f
    public String d() {
        return this.f956a.d();
    }

    @Override // r4.f
    public long length() {
        return this.f956a.length();
    }

    @Override // r4.f
    public void writeTo(OutputStream r10) {
        this.f956a.writeTo(r10);
    }
}
