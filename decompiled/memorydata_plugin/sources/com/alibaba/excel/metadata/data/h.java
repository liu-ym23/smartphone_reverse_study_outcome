package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;

/* JADX INFO: loaded from: classes.dex */
public class h<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LocalDateTime f284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f285b;
    private List<ImageData> c;
    private b d;
    private HyperlinkData e;
    private com.alibaba.excel.j.b.b.a f;
    private CellStyle g;

    public h() {
    }

    @Override // com.alibaba.excel.metadata.data.a, com.alibaba.excel.metadata.a
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, h.class);
    }

    @Override // com.alibaba.excel.metadata.data.a, com.alibaba.excel.metadata.a
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r0 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        LocalDateTime r6 = i();
        LocalDateTime r2 = r0.i();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        g r7 = j();
        g r3 = r0.j();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        List<ImageData> r8 = k();
        List<ImageData> r4 = r0.k();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        b r9 = l();
        b r10 = r0.l();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        HyperlinkData r11 = m();
        HyperlinkData r12 = r0.m();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        com.alibaba.excel.j.b.b.a r13 = n();
        com.alibaba.excel.j.b.b.a r14 = r0.n();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        CellStyle r15 = o();
        CellStyle r16 = r0.o();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        return true;
    L62:
        return false;
    L61:
        if (r15.equals(r16) == true) goto L63;
    L55:
        return false;
    L54:
        if (r13.equals(r14) == true) goto L56;
    L48:
        return false;
    L47:
        if (r11.equals(r12) == true) goto L49;
    L41:
        return false;
    L40:
        if (r9.equals(r10) == true) goto L42;
    L34:
        return false;
    L33:
        if (r8.equals(r4) == true) goto L35;
    L27:
        return false;
    L26:
        if (r7.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.metadata.data.a, com.alibaba.excel.metadata.a
    public int hashCode() {
        int r0 = super.hashCode();
        LocalDateTime r1 = i();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        g r6 = j();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        List<ImageData> r10 = k();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        b r14 = l();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        HyperlinkData r18 = m();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        com.alibaba.excel.j.b.b.a r22 = n();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        CellStyle r25 = o();
        int r26 = (r23 + r24) * 59;
        if (r25 == null) goto L31;
        r3 = r25.hashCode();
    L31:
        return r26 + r3;
    L25:
        r24 = r22.hashCode();
        goto L26
    L21:
        r20 = r18.hashCode();
        goto L22
    L17:
        r16 = r14.hashCode();
        goto L18
    L13:
        r12 = r10.hashCode();
        goto L14
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r1.hashCode();
        goto L6
    }

    public LocalDateTime i() {
        return this.f284a;
    }

    public g j() {
        return this.f285b;
    }

    public List<ImageData> k() {
        return this.c;
    }

    public b l() {
        return this.d;
    }

    public HyperlinkData m() {
        return this.e;
    }

    public com.alibaba.excel.j.b.b.a n() {
        return this.f;
    }

    public CellStyle o() {
        return this.g;
    }
}
