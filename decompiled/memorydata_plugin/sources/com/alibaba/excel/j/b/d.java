package com.alibaba.excel.j.b;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExcelTypeEnum f242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f243b;
    private OutputStream c;
    private Charset d;
    private Boolean e;
    private InputStream f;
    private File g;
    private Boolean h;
    private Boolean i;
    private String j;
    private Boolean k;
    private Boolean l;

    public d() {
    }

    public Boolean A() {
        return this.i;
    }

    public String B() {
        return this.j;
    }

    public Boolean C() {
        return this.k;
    }

    public Boolean D() {
        return this.l;
    }

    @Override // com.alibaba.excel.j.b.a, com.alibaba.excel.metadata.d
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, d.class);
    }

    @Override // com.alibaba.excel.j.b.a, com.alibaba.excel.metadata.d
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r0 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Boolean r6 = w();
        Boolean r2 = r0.w();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Boolean r7 = z();
        Boolean r3 = r0.z();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Boolean r8 = A();
        Boolean r4 = r0.A();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Boolean r9 = C();
        Boolean r10 = r0.C();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        Boolean r11 = D();
        Boolean r12 = r0.D();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        ExcelTypeEnum r13 = s();
        ExcelTypeEnum r14 = r0.s();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        File r15 = t();
        File r16 = r0.t();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        OutputStream r17 = u();
        OutputStream r18 = r0.u();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        Charset r19 = v();
        Charset r20 = r0.v();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        InputStream r21 = x();
        InputStream r22 = r0.x();
        if (r21 != null) goto L82;
        if (r22 != null) goto L83;
    L84:
        File r23 = y();
        File r24 = r0.y();
        if (r23 != null) goto L89;
        if (r24 != null) goto L90;
    L91:
        String r25 = B();
        String r26 = r0.B();
        if (r25 != null) goto L96;
        if (r26 != null) goto L97;
    L98:
        return true;
    L97:
        return false;
    L96:
        if (r25.equals(r26) == true) goto L98;
    L90:
        return false;
    L89:
        if (r23.equals(r24) == true) goto L91;
    L83:
        return false;
    L82:
        if (r21.equals(r22) == true) goto L84;
    L76:
        return false;
    L75:
        if (r19.equals(r20) == true) goto L77;
    L69:
        return false;
    L68:
        if (r17.equals(r18) == true) goto L70;
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

    @Override // com.alibaba.excel.j.b.a, com.alibaba.excel.metadata.d
    public int hashCode() {
        int r0 = super.hashCode();
        Boolean r1 = w();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Boolean r6 = z();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Boolean r10 = A();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Boolean r14 = C();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        Boolean r18 = D();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        ExcelTypeEnum r22 = s();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        File r26 = t();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        OutputStream r30 = u();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        int r33 = r31 + r32;
        Charset r34 = v();
        int r35 = r33 * 59;
        if (r34 != null) goto L37;
        int r36 = 43;
    L38:
        int r37 = r35 + r36;
        InputStream r38 = x();
        int r39 = r37 * 59;
        if (r38 != null) goto L41;
        int r40 = 43;
    L42:
        int r41 = r39 + r40;
        File r42 = y();
        int r43 = r41 * 59;
        if (r42 != null) goto L45;
        int r44 = 43;
    L46:
        String r45 = B();
        int r46 = (r43 + r44) * 59;
        if (r45 == null) goto L51;
        r3 = r45.hashCode();
    L51:
        return r46 + r3;
    L45:
        r44 = r42.hashCode();
        goto L46
    L41:
        r40 = r38.hashCode();
        goto L42
    L37:
        r36 = r34.hashCode();
        goto L38
    L33:
        r32 = r30.hashCode();
        goto L34
    L29:
        r28 = r26.hashCode();
        goto L30
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

    public ExcelTypeEnum s() {
        return this.f242a;
    }

    public File t() {
        return this.f243b;
    }

    public OutputStream u() {
        return this.c;
    }

    public Charset v() {
        return this.d;
    }

    public Boolean w() {
        return this.e;
    }

    public InputStream x() {
        return this.f;
    }

    public File y() {
        return this.g;
    }

    public Boolean z() {
        return this.h;
    }
}
