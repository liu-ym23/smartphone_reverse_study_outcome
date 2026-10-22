package com.alibaba.excel.metadata;

import com.alibaba.excel.exception.ExcelGenerateException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Field f297b;
    private String c;
    private List<String> d;
    private Boolean e;
    private Boolean f;
    private com.alibaba.excel.metadata.a.a g;
    private com.alibaba.excel.metadata.a.f h;
    private com.alibaba.excel.metadata.a.j i;
    private com.alibaba.excel.metadata.a.e j;

    public k(Integer r3, Field r4, String r5, List<String> r6, Boolean r7, Boolean r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.f296a = r3;
        this.f297b = r4;
        this.c = r5;
        if (r9 != null) goto L5;
        this.d = new ArrayList();
    L13:
        this.e = r7;
        this.f = r8;
        return;
    L5:
        this.d = r9;
        Iterator<String> r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        if (((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")) != null) goto L7;
        throw new ExcelGenerateException("head name can not be null.");
    }

    public Integer a() {
        return this.f296a;
    }

    public void a(Integer r1) {
        this.f296a = r1;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, k.class);
    }

    public Field b() {
        return this.f297b;
    }

    public String c() {
        return this.c;
    }

    public List<String> d() {
        return this.d;
    }

    public Boolean e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Integer r0 = a();
        Integer r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Boolean r1 = e();
        Boolean r3 = r6.e();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Boolean r4 = f();
        Boolean r7 = r6.f();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        Field r8 = b();
        Field r9 = r6.b();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        String r10 = c();
        String r11 = r6.c();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        List<String> r12 = d();
        List<String> r13 = r6.d();
        if (r12 != null) goto L51;
        if (r13 != null) goto L52;
    L53:
        com.alibaba.excel.metadata.a.a r14 = g();
        com.alibaba.excel.metadata.a.a r15 = r6.g();
        if (r14 != null) goto L58;
        if (r15 != null) goto L59;
    L60:
        com.alibaba.excel.metadata.a.f r16 = h();
        com.alibaba.excel.metadata.a.f r17 = r6.h();
        if (r16 != null) goto L65;
        if (r17 != null) goto L66;
    L67:
        com.alibaba.excel.metadata.a.j r18 = i();
        com.alibaba.excel.metadata.a.j r19 = r6.i();
        if (r18 != null) goto L72;
        if (r19 != null) goto L73;
    L74:
        com.alibaba.excel.metadata.a.e r20 = j();
        com.alibaba.excel.metadata.a.e r21 = r6.j();
        if (r20 != null) goto L79;
        if (r21 != null) goto L80;
    L81:
        return true;
    L80:
        return false;
    L79:
        if (r20.equals(r21) == true) goto L81;
    L73:
        return false;
    L72:
        if (r18.equals(r19) == true) goto L74;
    L66:
        return false;
    L65:
        if (r16.equals(r17) == true) goto L67;
    L59:
        return false;
    L58:
        if (r14.equals(r15) == true) goto L60;
    L52:
        return false;
    L51:
        if (r12.equals(r13) == true) goto L53;
    L45:
        return false;
    L44:
        if (r10.equals(r11) == true) goto L46;
    L38:
        return false;
    L37:
        if (r8.equals(r9) == true) goto L39;
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

    public Boolean f() {
        return this.f;
    }

    public com.alibaba.excel.metadata.a.a g() {
        return this.g;
    }

    public com.alibaba.excel.metadata.a.f h() {
        return this.h;
    }

    public int hashCode() {
        Integer r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Boolean r3 = e();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        Boolean r7 = f();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        Field r11 = b();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        int r14 = r12 + r13;
        String r15 = c();
        int r16 = r14 * 59;
        if (r15 != null) goto L21;
        int r17 = 43;
    L22:
        int r18 = r16 + r17;
        List<String> r19 = d();
        int r20 = r18 * 59;
        if (r19 != null) goto L25;
        int r21 = 43;
    L26:
        int r22 = r20 + r21;
        com.alibaba.excel.metadata.a.a r23 = g();
        int r24 = r22 * 59;
        if (r23 != null) goto L29;
        int r25 = 43;
    L30:
        int r26 = r24 + r25;
        com.alibaba.excel.metadata.a.f r27 = h();
        int r28 = r26 * 59;
        if (r27 != null) goto L33;
        int r29 = 43;
    L34:
        int r30 = r28 + r29;
        com.alibaba.excel.metadata.a.j r31 = i();
        int r32 = r30 * 59;
        if (r31 != null) goto L37;
        int r33 = 43;
    L38:
        com.alibaba.excel.metadata.a.e r34 = j();
        int r35 = (r32 + r33) * 59;
        if (r34 == null) goto L43;
        r1 = r34.hashCode();
    L43:
        return r35 + r1;
    L37:
        r33 = r31.hashCode();
        goto L38
    L33:
        r29 = r27.hashCode();
        goto L34
    L29:
        r25 = r23.hashCode();
        goto L30
    L25:
        r21 = r19.hashCode();
        goto L26
    L21:
        r17 = r15.hashCode();
        goto L22
    L17:
        r13 = r11.hashCode();
        goto L18
    L13:
        r9 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public com.alibaba.excel.metadata.a.j i() {
        return this.i;
    }

    public com.alibaba.excel.metadata.a.e j() {
        return this.j;
    }
}
