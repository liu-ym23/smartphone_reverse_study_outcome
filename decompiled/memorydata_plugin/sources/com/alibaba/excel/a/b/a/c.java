package com.alibaba.excel.a.b.a;

import com.alibaba.excel.exception.ExcelAnalysisStopException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f123a = true;

    static {
    }

    public c() {
    }

    private void a(com.alibaba.excel.h.c.a.b.b r6) {
        if (r6.C() == null) goto L5;
        return;
    L5:
        BoundSheetRecord[] r5 = BoundSheetRecord.orderByBofPosition(r6.J());
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L7:
        if (r1 >= r5.length) goto L9;
        BoundSheetRecord r2 = r5[r1];
        r0.add(new com.alibaba.excel.h.c.b(Integer.valueOf(r1), r2.getSheetname()));
        r1 = r1 + 1;
        goto L7
    L9:
        r6.a(r0);
        if (r6.K().booleanValue() == false) goto L13;
        return;
    L13:
        throw new ExcelAnalysisStopException("Just need to get the list of sheets.");
    }

    @Override // com.alibaba.excel.a.b.b
    public void b(com.alibaba.excel.e.b.b r5, Record r6) {
        com.alibaba.excel.e.b.b r7 = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
        BOFRecord r8 = (BOFRecord) ZeusTransformUtils.preCheckCast(r6, BOFRecord.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.b.b r0 = r7.f();
        if (r8.getType() != 5) goto L7;
        r0.a(null);
        r0.b(Boolean.FALSE);
        return;
    L7:
        if (r8.getType() == 16) goto L9;
        return;
    L9:
        a(r0);
        Integer r4 = r0.L();
        if (r4 != null) goto L12;
        r4 = 0;
        r0.a(r4);
    L12:
        com.alibaba.excel.h.c.b r9 = (com.alibaba.excel.h.c.b) ZeusTransformUtils.preCheckCast(r0.C().get(r4.intValue()), com.alibaba.excel.h.c.b.class, "com.obric.memorydata.plugin");
        if (f123a == true) goto L18;
        if (r9 != null) goto L18;
        throw new AssertionError("Can't find the sheet.");
    L18:
        com.alibaba.excel.h.c.b r10 = com.alibaba.excel.i.n.a(r9, r7);
        if (r10 == null) goto L21;
        r7.a(r10);
        com.alibaba.excel.h.c.a.b.b r11 = r7.f();
        Boolean r12 = Boolean.FALSE;
    L22:
        r11.b(r12);
        r0.a(Integer.valueOf(r0.L().intValue() + 1));
        return;
    L21:
        r11 = r7.f();
        r12 = Boolean.TRUE;
        goto L22
    }
}
