package com.alibaba.excel.a.a;

import com.alibaba.excel.a.c;
import com.alibaba.excel.enums.ByteOrderMarkEnum;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.enums.RowTypeEnum;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.h.c.b;
import com.alibaba.excel.i.n;
import com.alibaba.excel.i.o;
import com.alibaba.excel.metadata.data.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.slf4j.d;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f119b;
    private final com.alibaba.excel.e.a.a c;

    static {
        f118a = d.a(a.class);
    }

    public a(com.alibaba.excel.e.a.a r3) {
        this.c = (com.alibaba.excel.e.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.e.a.a.class, "com.obric.memorydata.plugin");
        ArrayList r4 = new ArrayList();
        this.f119b = r4;
        b r2 = new b();
        r4.add(r2);
        r2.b(0);
    }

    private CSVParser a(CSVFormat r5, InputStream r6, ByteOrderMarkEnum r7) {
        if (r7 != null) goto L6;
        return r5.parse(new InputStreamReader(r6, this.c.f().q()));
    L6:
        return r5.parse(new InputStreamReader(new BOMInputStream(r6, new ByteOrderMark[]{r7.getByteOrderMark()}), this.c.f().q()));
    }

    private void a(CSVRecord r7, int r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r9 = r7.iterator();
        Boolean r1 = this.c.d().b().a();
        int r2 = 0;
    L4:
        if (r9.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        f r4 = new f();
        r4.a(Integer.valueOf(r8));
        r4.b(Integer.valueOf(r2));
        if (o.c(r3) == false) goto L11;
        r4.a(CellDataTypeEnum.STRING);
        if (r1.booleanValue() == false) goto L10;
        r3 = r3.trim();
    L10:
        r4.a(r3);
    L12:
        int r5 = r2 + 1;
        r0.put(Integer.valueOf(r2), r4);
        r2 = r5;
        goto L4
    L11:
        r4.a(CellDataTypeEnum.EMPTY);
        goto L12
    L14:
        if (MapUtils.isEmpty(r0) == false) goto L16;
        RowTypeEnum r10 = RowTypeEnum.EMPTY;
    L17:
        com.alibaba.excel.h.c.a.c r6 = new com.alibaba.excel.h.c.a.c(Integer.valueOf(r8), r10, this.c.a().f(), r0);
        this.c.a(r6);
        this.c.g().b(r0);
        this.c.g().b(Integer.valueOf(r8));
        this.c.e().b(this.c);
        return;
    L16:
        r10 = RowTypeEnum.DATA;
        goto L17
    }

    private CSVParser b() {
        com.alibaba.excel.h.c.a.a.b r0 = this.c.f();
        CSVFormat r1 = r0.G();
        ByteOrderMarkEnum r2 = ByteOrderMarkEnum.valueOfByCharsetName(this.c.f().q().name());
        if (r0.r().booleanValue() == false) goto L8;
    L4:
        InputStream r3 = r0.o();
    L6:
        return a(r1, r3, r2);
    L8:
        if (r0.p() == null) goto L4;
        r3 = Files.newInputStream(r0.p().toPath(), new OpenOption[0]);
        goto L6
    }

    @Override // com.alibaba.excel.a.c
    public void a() {
        CSVParser r0 = b();     // Catch: IOException -> L15
        this.c.f().a(r0);     // Catch: IOException -> L15
        Iterator<b> r1 = this.f119b.iterator();
    L5:
        if (r1.hasNext() == false) goto L14;
        b r2 = n.a((b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin"), this.c);
        if (r2 == null) goto L5;
        this.c.a(r2);
        int r3 = 0;
        Iterator<CSVRecord> r4 = r0.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        a((CSVRecord) ZeusTransformUtils.preCheckCast(r4.next(), CSVRecord.class, "com.obric.memorydata.plugin"), r3);
        r3 = r3 + 1;
        goto L11
    L13:
        this.c.e().c(this.c);
        goto L5
    L14:
        return;
    L15:
        e = move-exception;
        throw new ExcelAnalysisException(e);
    }
}
