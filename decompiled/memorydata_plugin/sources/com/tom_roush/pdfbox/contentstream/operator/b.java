package com.tom_roush.pdfbox.contentstream.operator;

import com.tom_roush.pdfbox.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    private static final ConcurrentMap<String, b> d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f16095b;
    private d c;

    static {
        d = new ConcurrentHashMap();
    }

    private b(String r3) {
        this.f16094a = r3;
        if (r3.startsWith("/") == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Operators are not allowed to start with / '" + r3 + "'");
    }

    public static b a(String r4) {
        if (r4.equals("ID") == true) goto L13;
        if ("BI".equals(r4) == true) goto L13;
        ConcurrentMap<String, b> r1 = d;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1.get(r4), b.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L14;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1.putIfAbsent(r4, new b(r4)), b.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        return r3;
    L16:
        return (b) ZeusTransformUtils.preCheckCast(r1.get(r4), b.class, "com.obric.memorydata.plugin");
    L14:
        return r2;
    L13:
        return new b(r4);
    }

    public String a() {
        return this.f16094a;
    }

    public void a(d r1) {
        this.c = r1;
    }

    public void a(byte[] r1) {
        this.f16095b = r1;
    }

    public byte[] b() {
        return this.f16095b;
    }

    public String toString() {
        return "PDFOperator{" + this.f16094a + "}";
    }
}
