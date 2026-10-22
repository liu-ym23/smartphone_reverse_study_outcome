package com.alibaba.excel.a.b;

import com.alibaba.excel.a.b.a.e;
import com.alibaba.excel.a.b.a.f;
import com.alibaba.excel.a.b.a.g;
import com.alibaba.excel.a.b.a.h;
import com.alibaba.excel.a.b.a.i;
import com.alibaba.excel.a.b.a.j;
import com.alibaba.excel.a.b.a.k;
import com.alibaba.excel.a.b.a.l;
import com.alibaba.excel.a.b.a.m;
import com.alibaba.excel.a.b.a.n;
import com.alibaba.excel.a.b.a.o;
import com.alibaba.excel.a.b.a.p;
import com.alibaba.excel.a.b.a.q;
import com.alibaba.excel.a.b.a.r;
import com.alibaba.excel.a.b.a.s;
import com.alibaba.excel.a.b.a.t;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener;
import org.apache.poi.hssf.record.Record;
import org.slf4j.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alibaba.excel.a.c, HSSFListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f128a = null;
    private static final Map<Short, b> c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.alibaba.excel.e.b.b f129b;

    static {
        f128a = d.a(c.class);
        HashMap r0 = new HashMap(32);
        c = r0;
        r0.put((short) 513, new com.alibaba.excel.a.b.a.b());
        r0.put((short) 2057, new com.alibaba.excel.a.b.a.c());
        r0.put((short) 517, new com.alibaba.excel.a.b.a.d());
        r0.put((short) 133, new e());
        r0.put((short) -1, new f());
        r0.put((short) 10, new g());
        r0.put((short) 6, new h());
        r0.put((short) 440, new i());
        r0.put((short) 523, new j());
        r0.put((short) 516, new k());
        r0.put((short) 253, new l());
        r0.put((short) 229, new m());
        r0.put((short) 28, new n());
        r0.put((short) 515, new o());
        r0.put((short) 93, new p());
        r0.put((short) 638, new q());
        r0.put((short) 252, new r());
        r0.put((short) 519, new s());
        r0.put((short) 438, new t());
    }

    public c(com.alibaba.excel.e.b.b r3) {
        this.f129b = (com.alibaba.excel.e.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.b.b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.a.c
    public void a() {
        com.alibaba.excel.h.c.a.b.b r0 = this.f129b.f();
        r0.a(new FormatTrackingHSSFListener(new MissingRecordAwareHSSFListener(this)));
        r0.a(new EventWorkbookBuilder.SheetRecordCollectingListener(r0.H()).getStubHSSFWorkbook());
        HSSFEventFactory r3 = new HSSFEventFactory();
        HSSFRequest r1 = new HSSFRequest();
        r1.addListenerForAllRecords(r0.H());
        r3.processWorkbookEvents(r1, r0.G());     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new ExcelAnalysisException(e);
    }

    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record r4) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(c.get(Short.valueOf(r4.getSid())), b.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, a.class) == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L14;
        return;
    L14:
        if (r0.a(this.f129b, r4) == true) goto L16;
        return;
    L16:
        r0.b(this.f129b, r4);
        return;
    L8:
        if (this.f129b.f().M().booleanValue() == false) goto L10;
        r1 = true;
        goto L11
    }
}
