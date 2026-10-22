package com.alibaba.excel.j.a.b;

import com.alibaba.excel.e.c;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.j.b.a.d;
import com.alibaba.excel.j.b.a.e;
import com.alibaba.excel.metadata.data.h;
import com.alibaba.excel.metadata.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f228b;
    private com.alibaba.excel.j.b.a.c c;
    private d d;
    private Row e;
    private Integer f;
    private Cell g;
    private Integer h;
    private Integer i;
    private k j;
    private List<h<?>> k;
    private h<?> l;
    private Boolean m;
    private com.alibaba.excel.metadata.a.c n;
    private Object o;
    private Class<?> p;
    private CellDataTypeEnum q;
    private Boolean r;

    public c a() {
        return this.f227a;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    public e b() {
        return this.f228b;
    }

    public com.alibaba.excel.j.b.a.c c() {
        return this.c;
    }

    public d d() {
        return this.d;
    }

    public Row e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Integer r0 = f();
        Integer r2 = r6.f();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Integer r1 = h();
        Integer r3 = r6.h();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Integer r4 = i();
        Integer r7 = r6.i();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        Boolean r8 = m();
        Boolean r9 = r6.m();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        Boolean r10 = r();
        Boolean r11 = r6.r();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        c r12 = a();
        c r13 = r6.a();
        if (r12 != null) goto L51;
        if (r13 != null) goto L52;
    L53:
        e r14 = b();
        e r15 = r6.b();
        if (r14 != null) goto L58;
        if (r15 != null) goto L59;
    L60:
        com.alibaba.excel.j.b.a.c r16 = c();
        com.alibaba.excel.j.b.a.c r17 = r6.c();
        if (r16 != null) goto L65;
        if (r17 != null) goto L66;
    L67:
        d r18 = d();
        d r19 = r6.d();
        if (r18 != null) goto L72;
        if (r19 != null) goto L73;
    L74:
        Row r20 = e();
        Row r21 = r6.e();
        if (r20 != null) goto L79;
        if (r21 != null) goto L80;
    L81:
        Cell r22 = g();
        Cell r23 = r6.g();
        if (r22 != null) goto L86;
        if (r23 != null) goto L87;
    L88:
        k r24 = j();
        k r25 = r6.j();
        if (r24 != null) goto L93;
        if (r25 != null) goto L94;
    L95:
        List<h<?>> r26 = k();
        List<h<?>> r27 = r6.k();
        if (r26 != null) goto L100;
        if (r27 != null) goto L101;
    L102:
        h<?> r28 = l();
        h<?> r29 = r6.l();
        if (r28 != null) goto L107;
        if (r29 != null) goto L108;
    L109:
        com.alibaba.excel.metadata.a.c r30 = n();
        com.alibaba.excel.metadata.a.c r31 = r6.n();
        if (r30 != null) goto L114;
        if (r31 != null) goto L115;
    L116:
        Object r32 = o();
        Object r33 = r6.o();
        if (r32 != null) goto L121;
        if (r33 != null) goto L122;
    L123:
        Class<?> r34 = p();
        Class<?> r35 = r6.p();
        if (r34 != null) goto L128;
        if (r35 != null) goto L129;
    L130:
        CellDataTypeEnum r36 = q();
        CellDataTypeEnum r37 = r6.q();
        if (r36 != null) goto L135;
        if (r37 != null) goto L136;
    L137:
        return true;
    L136:
        return false;
    L135:
        if (r36.equals(r37) == true) goto L137;
    L129:
        return false;
    L128:
        if (r34.equals(r35) == true) goto L130;
    L122:
        return false;
    L121:
        if (r32.equals(r33) == true) goto L123;
    L115:
        return false;
    L114:
        if (r30.equals(r31) == true) goto L116;
    L108:
        return false;
    L107:
        if (r28.equals(r29) == true) goto L109;
    L101:
        return false;
    L100:
        if (r26.equals(r27) == true) goto L102;
    L94:
        return false;
    L93:
        if (r24.equals(r25) == true) goto L95;
    L87:
        return false;
    L86:
        if (r22.equals(r23) == true) goto L88;
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

    public Integer f() {
        return this.f;
    }

    public Cell g() {
        return this.g;
    }

    public Integer h() {
        return this.h;
    }

    public int hashCode() {
        Integer r0 = f();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Integer r3 = h();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        Integer r7 = i();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        Boolean r11 = m();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        int r14 = r12 + r13;
        Boolean r15 = r();
        int r16 = r14 * 59;
        if (r15 != null) goto L21;
        int r17 = 43;
    L22:
        int r18 = r16 + r17;
        c r19 = a();
        int r20 = r18 * 59;
        if (r19 != null) goto L25;
        int r21 = 43;
    L26:
        int r22 = r20 + r21;
        e r23 = b();
        int r24 = r22 * 59;
        if (r23 != null) goto L29;
        int r25 = 43;
    L30:
        int r26 = r24 + r25;
        com.alibaba.excel.j.b.a.c r27 = c();
        int r28 = r26 * 59;
        if (r27 != null) goto L33;
        int r29 = 43;
    L34:
        int r30 = r28 + r29;
        d r31 = d();
        int r32 = r30 * 59;
        if (r31 != null) goto L37;
        int r33 = 43;
    L38:
        int r34 = r32 + r33;
        Row r35 = e();
        int r36 = r34 * 59;
        if (r35 != null) goto L41;
        int r37 = 43;
    L42:
        int r38 = r36 + r37;
        Cell r39 = g();
        int r40 = r38 * 59;
        if (r39 != null) goto L45;
        int r41 = 43;
    L46:
        int r42 = r40 + r41;
        k r43 = j();
        int r44 = r42 * 59;
        if (r43 != null) goto L49;
        int r45 = 43;
    L50:
        int r46 = r44 + r45;
        List<h<?>> r47 = k();
        int r48 = r46 * 59;
        if (r47 != null) goto L53;
        int r49 = 43;
    L54:
        int r50 = r48 + r49;
        h<?> r51 = l();
        int r52 = r50 * 59;
        if (r51 != null) goto L57;
        int r53 = 43;
    L58:
        int r54 = r52 + r53;
        com.alibaba.excel.metadata.a.c r55 = n();
        int r56 = r54 * 59;
        if (r55 != null) goto L61;
        int r57 = 43;
    L62:
        int r58 = r56 + r57;
        Object r59 = o();
        int r60 = r58 * 59;
        if (r59 != null) goto L65;
        int r61 = 43;
    L66:
        int r62 = r60 + r61;
        Class<?> r63 = p();
        int r64 = r62 * 59;
        if (r63 != null) goto L69;
        int r65 = 43;
    L70:
        CellDataTypeEnum r66 = q();
        int r67 = (r64 + r65) * 59;
        if (r66 == null) goto L75;
        r1 = r66.hashCode();
    L75:
        return r67 + r1;
    L69:
        r65 = r63.hashCode();
        goto L70
    L65:
        r61 = r59.hashCode();
        goto L66
    L61:
        r57 = r55.hashCode();
        goto L62
    L57:
        r53 = r51.hashCode();
        goto L58
    L53:
        r49 = r47.hashCode();
        goto L54
    L49:
        r45 = r43.hashCode();
        goto L50
    L45:
        r41 = r39.hashCode();
        goto L46
    L41:
        r37 = r35.hashCode();
        goto L42
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

    public Integer i() {
        return this.i;
    }

    public k j() {
        return this.j;
    }

    public List<h<?>> k() {
        return this.k;
    }

    public h<?> l() {
        return this.l;
    }

    public Boolean m() {
        return this.m;
    }

    public com.alibaba.excel.metadata.a.c n() {
        return this.n;
    }

    public Object o() {
        return this.o;
    }

    public Class<?> p() {
        return this.p;
    }

    public CellDataTypeEnum q() {
        return this.q;
    }

    public Boolean r() {
        return this.r;
    }
}
