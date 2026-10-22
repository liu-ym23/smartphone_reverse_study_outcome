package com.alibaba.excel.a.c.a;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.m;
import com.alibaba.excel.i.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {

    /* JADX INFO: renamed from: com.alibaba.excel.a.c.a.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f136a = null;

        static {
            int[] r0 = new int[CellDataTypeEnum.values().length];
            f136a = r0;
            r0[CellDataTypeEnum.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f136a[CellDataTypeEnum.DIRECT_STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f136a[CellDataTypeEnum.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f136a[CellDataTypeEnum.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f136a[CellDataTypeEnum.NUMBER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f136a[CellDataTypeEnum.EMPTY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public e() {
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r5, String r6) {
        com.alibaba.excel.e.c.b r4 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.c.a r7 = r4.g();
        com.alibaba.excel.metadata.data.f<?> r8 = r7.v();
        StringBuilder r0 = r7.z();
        String r1 = r0.toString();
        CellDataTypeEnum r2 = r8.getType();
        switch(AnonymousClass1.f136a[r2.ordinal()]) {
            case 1: goto L17;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L11;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L5;
        };
    L14:
        r8.a(r1);
        CellDataTypeEnum r3 = CellDataTypeEnum.STRING;
    L15:
        r8.a(r3);
    L21:
        if (r8.e() != null) goto L23;
    L25:
        r8.c();
        r8.a(r7.u());
        r8.b(r7.y());
        r7.s().put(r7.y(), r8);
        return;
    L23:
        if (r4.d().b().a().booleanValue() == false) goto L25;
        r8.a(r8.e().trim());
        goto L25
    L5:
        throw new IllegalStateException("Cannot set values now");
    L7:
        if (o.a(r1) == true) goto L12;
        r8.a(CellDataTypeEnum.NUMBER);
        r8.b(new BigDecimal(r1));
        r8.a(r8.j().round(com.alibaba.excel.d.b.f148a));
    L12:
        r3 = CellDataTypeEnum.EMPTY;
        goto L15
    L11:
        if (o.a(r1) == true) goto L12;
        r8.a(com.alibaba.excel.i.b.a(r0.toString()));
        goto L21
    L17:
        if (o.a(r1) == true) goto L21;
        r8.a(r4.a().x().a(Integer.valueOf(r1)));
        goto L21
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r2, String r3, Attributes r4) {
        com.alibaba.excel.e.c.b r1 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        Attributes r5 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r4, Attributes.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.c.a r6 = r1.g();
        r6.d(Integer.valueOf(m.b(r5.getValue("r"), r6.y())));
        r6.a(new com.alibaba.excel.metadata.data.f(CellDataTypeEnum.buildFromCellType(r5.getValue("t"))));
        r6.a(new StringBuilder());
        String r7 = r5.getValue("s");
        if (o.a(r7) == false) goto L5;
        int r8 = 0;
    L6:
        r6.v().a(r1.f().a(r8));
        return;
    L5:
        r8 = Integer.parseInt(r7);
        goto L6
    }
}
