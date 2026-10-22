package com.alibaba.excel.c.a;

import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.slf4j.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f143b;

    @Deprecated
    private Integer c;
    private Integer d;

    static {
        f142a = d.a(c.class);
    }

    public c() {
    }

    @Override // com.alibaba.excel.c.a.b
    public com.alibaba.excel.c.c a(PackagePart r7) {
        long r0 = r7.getSize();
        if (r0 >= 0) goto L9;
        r0 = r7.getInputStream().available();     // Catch: IOException -> L6
    L6:
        f142a.warn("Unable to get file size, default used MapCache");
        return new com.alibaba.excel.c.b();
    L9:
        if (this.f143b != null) goto L12;
        this.f143b = 5L;
    L12:
        if (r0 >= (this.f143b.longValue() * TimeUtils.NANOSECONDS_PER_MILLISECOND)) goto L18;
        org.slf4j.c r6 = f142a;
        if (r6.isDebugEnabled() == false) goto L17;
        r6.debug("Use map cache.size:{}", Long.valueOf(r0));
    L17:
        return new com.alibaba.excel.c.b();
    L18:
        org.slf4j.c r8 = f142a;
        if (r8.isDebugEnabled() == false) goto L22;
        r8.debug("Use ehcache.size:{}", Long.valueOf(r0));
    L22:
        if (this.c == null) goto L26;
        return new com.alibaba.excel.c.a(this.c, this.d);
    L26:
        if (this.d != null) goto L29;
        this.d = 20;
    L29:
        return new com.alibaba.excel.c.a(this.c, this.d);
    }

    public Long a() {
        return this.f143b;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    @Deprecated
    public Integer b() {
        return this.c;
    }

    public Integer c() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Long r0 = a();
        Long r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Integer r1 = b();
        Integer r3 = r6.b();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Integer r4 = c();
        Integer r7 = r6.c();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        return true;
    L31:
        return false;
    L30:
        if (r4.equals(r7) == true) goto L32;
    L24:
        return false;
    L23:
        if (r1.equals(r3) == true) goto L25;
    L17:
        return false;
    L16:
        if (r0.equals(r2) == true) goto L18;
        goto L17
    }

    public int hashCode() {
        Long r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Integer r3 = b();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        Integer r6 = c();
        int r7 = (r4 + r5) * 59;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return r7 + r1;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
