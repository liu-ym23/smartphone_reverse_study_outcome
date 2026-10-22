package com.alibaba.excel.h.c.a.a;

import com.alibaba.excel.h.c.a.e;
import com.alibaba.excel.h.c.c;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

/* JADX INFO: loaded from: classes.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CSVFormat f181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CSVParser f182b;

    public b(c r1) {
        super(r1);
        a(ExcelTypeEnum.CSV);
        this.f181a = CSVFormat.DEFAULT;
    }

    public CSVFormat G() {
        return this.f181a;
    }

    public CSVParser H() {
        return this.f182b;
    }

    public void a(CSVParser r1) {
        this.f182b = r1;
    }

    @Override // com.alibaba.excel.h.c.a.e, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, b.class);
    }

    @Override // com.alibaba.excel.h.c.a.e, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r0 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        CSVFormat r6 = G();
        CSVFormat r2 = r0.G();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        CSVParser r4 = H();
        CSVParser r7 = r0.H();
        if (r4 != null) goto L26;
        if (r7 != null) goto L27;
    L28:
        return true;
    L27:
        return false;
    L26:
        if (r4.equals(r7) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.h.c.a.e, com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        CSVFormat r1 = G();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        CSVParser r5 = H();
        int r6 = (r2 + r4) * 59;
        if (r5 == null) goto L11;
        r3 = r5.hashCode();
    L11:
        return r6 + r3;
    L5:
        r4 = r1.hashCode();
        goto L6
    }
}
