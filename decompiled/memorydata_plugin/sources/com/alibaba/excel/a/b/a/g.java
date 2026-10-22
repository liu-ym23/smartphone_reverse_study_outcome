package com.alibaba.excel.a.b.a;

import com.alibaba.excel.enums.RowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class g extends a implements com.alibaba.excel.a.b.a {
    public g() {
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r5, Record r6) {
        com.alibaba.excel.e.b.b r4 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        if (r4.b() != null) goto L6;
        return;
    L6:
        if (r4.g().s().isEmpty() == true) goto L8;
        com.alibaba.excel.h.c.a.b.a r7 = r4.g();
        r4.a(new com.alibaba.excel.h.c.a.c(Integer.valueOf(r4.g().u().intValue() + 1), r7.x(), r4.b().f(), r7.s()));
        r4.e().b(r4);
        r7.b(new LinkedHashMap());
        r7.a(RowTypeEnum.EMPTY);
    L8:
        r4.e().c(r4);
    }
}
