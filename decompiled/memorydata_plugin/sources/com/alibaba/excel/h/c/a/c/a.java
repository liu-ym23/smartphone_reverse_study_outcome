package com.alibaba.excel.h.c.a.c;

import com.alibaba.excel.h.c.a.d;
import com.alibaba.excel.h.c.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Deque;
import java.util.LinkedList;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Deque<String> f189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f190b;
    private StringBuilder c;
    private StringBuilder d;
    private PackageRelationshipCollection e;

    public a(com.alibaba.excel.h.c.b r3, e r4) {
        super(r3, r4);
        this.f189a = new LinkedList();
        this.e = (PackageRelationshipCollection) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin")).K().get(r3.k()), PackageRelationshipCollection.class, "com.obric.memorydata.plugin");
    }

    public StringBuilder A() {
        return this.d;
    }

    public PackageRelationshipCollection B() {
        return this.e;
    }

    public void a(StringBuilder r1) {
        this.c = r1;
    }

    @Override // com.alibaba.excel.h.c.a.d, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    public void b(StringBuilder r1) {
        this.d = r1;
    }

    public void d(Integer r1) {
        this.f190b = r1;
    }

    @Override // com.alibaba.excel.h.c.a.d, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r0 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Integer r6 = y();
        Integer r2 = r0.y();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Deque<String> r7 = x();
        Deque<String> r3 = r0.x();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        StringBuilder r8 = z();
        StringBuilder r4 = r0.z();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        StringBuilder r9 = A();
        StringBuilder r10 = r0.A();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        PackageRelationshipCollection r11 = B();
        PackageRelationshipCollection r12 = r0.B();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        return true;
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

    @Override // com.alibaba.excel.h.c.a.d, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = y();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Deque<String> r6 = x();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        StringBuilder r10 = z();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        StringBuilder r14 = A();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        PackageRelationshipCollection r17 = B();
        int r18 = (r15 + r16) * 59;
        if (r17 == null) goto L23;
        r3 = r17.hashCode();
    L23:
        return r18 + r3;
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

    public Deque<String> x() {
        return this.f189a;
    }

    public Integer y() {
        return this.f190b;
    }

    public StringBuilder z() {
        return this.c;
    }
}
