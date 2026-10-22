package io.noties.markwon.html.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class a implements Cloneable, Map.Entry<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f16575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16576b;
    private String c;

    public a(String r2, String r3, b r4) {
        io.noties.markwon.html.jsoup.a.b.a(r2);
        this.f16576b = r2.trim();
        io.noties.markwon.html.jsoup.a.b.a(r2);
        this.c = r3;
        this.f16575a = r4;
    }

    public String a() {
        return this.f16576b;
    }

    public String a(String r4) {
        String r0 = this.f16575a.c(this.f16576b);
        b r1 = this.f16575a;
        if (r1 == null) goto L7;
        int r2 = r1.a(this.f16576b);
        if (r2 == (-1)) goto L7;
        this.f16575a.f16578b[r2] = r4;
    L7:
        this.c = r4;
        return r0;
    }

    public String b() {
        return this.c;
    }

    public a c() {
        return (a) ZeusTransformUtils.preCheckCast(super.clone(), a.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public /* synthetic */ Object clone() {
        return c();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L26;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        String r2 = this.f16576b;
        if (r2 == null) goto L16;
        if (r2.equals(r6.f16576b) == false) goto L17;
    L18:
        String r4 = this.c;
        if (r4 == null) goto L22;
        return r4.equals(r6.c);
    L22:
        if (r6.c != null) goto L25;
        return true;
    L25:
        return false;
    L17:
        return false;
    L16:
        if (r6.f16576b == null) goto L18;
        goto L17
    }

    @Override // java.util.Map.Entry
    public /* synthetic */ String getKey() {
        return a();
    }

    @Override // java.util.Map.Entry
    public /* synthetic */ String getValue() {
        return b();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String r0 = this.f16576b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // java.util.Map.Entry
    public /* synthetic */ String setValue(String r3) {
        return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
