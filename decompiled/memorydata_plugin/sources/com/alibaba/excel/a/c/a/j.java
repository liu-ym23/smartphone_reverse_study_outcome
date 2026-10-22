package com.alibaba.excel.a.c.a;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.enums.RowTypeEnum;
import com.alibaba.excel.i.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.apache.commons.collections4.MapUtils;
import org.xml.sax.Attributes;

/* JADX INFO: loaded from: classes.dex */
public class j extends b {
    public j() {
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r7, String r8) {
        com.alibaba.excel.e.c.b r6 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.c.a r9 = r6.g();
        if (MapUtils.isEmpty(r9.s()) == false) goto L5;
        RowTypeEnum r0 = RowTypeEnum.EMPTY;
    L7:
        if (r0 != RowTypeEnum.DATA) goto L19;
        boolean r1 = false;
        Iterator<com.alibaba.excel.metadata.e> r2 = r9.s().values().iterator();
    L10:
        if (r2.hasNext() == false) goto L17;
        com.alibaba.excel.metadata.e r3 = (com.alibaba.excel.metadata.e) ZeusTransformUtils.preCheckCast(r2.next(), com.alibaba.excel.metadata.e.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.alibaba.excel.metadata.data.f.class) == false) goto L13;
        if (((com.alibaba.excel.metadata.data.f) ZeusTransformUtils.preCheckCast(r3, com.alibaba.excel.metadata.data.f.class, "com.obric.memorydata.plugin")).getType() == CellDataTypeEnum.EMPTY) goto L10;
    L13:
        r1 = true;
    L17:
        if (r1 == true) goto L19;
        r0 = RowTypeEnum.EMPTY;
    L19:
        r6.a(new com.alibaba.excel.h.c.a.c(r9.u(), r0, r9.f(), r9.s()));
        r6.e().b(r6);
        r9.d(null);
        r9.b(new LinkedHashMap());
        return;
    L5:
        r0 = RowTypeEnum.DATA;
        goto L7
    }

    @Override // com.alibaba.excel.a.c.a.b, com.alibaba.excel.a.c.a.k
    public void a(com.alibaba.excel.e.c.b r6, String r7, Attributes r8) {
        com.alibaba.excel.e.c.b r5 = (com.alibaba.excel.e.c.b) ZeusTransformUtils.wrapperContextForParams(r6, com.alibaba.excel.e.c.b.class, "com.obric.memorydata.plugin");
        Attributes r9 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r8, Attributes.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.c.a r10 = r5.g();
        int r11 = m.a(r9.getValue("r"), r10.u());
        Integer r12 = r5.b().u();
    L4:
        if ((r12.intValue() + 1) >= r11) goto L6;
        r5.a(new com.alibaba.excel.h.c.a.c(Integer.valueOf(r12.intValue() + 1), RowTypeEnum.EMPTY, r10.f(), new LinkedHashMap()));
        r5.e().b(r5);
        r10.d(null);
        r10.b(new LinkedHashMap());
        r12 = Integer.valueOf(r12.intValue() + 1);
        goto L4
    L6:
        r10.b(Integer.valueOf(r11));
    }
}
