package com.alibaba.excel.metadata;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CellExtraTypeEnum f286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f287b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;

    public f(CellExtraTypeEnum r8, String r9, Integer r10, Integer r11) {
        this(r8, r9, r10, r10, r11, r11);
    }

    public f(CellExtraTypeEnum r1, String r2, Integer r3, Integer r4, Integer r5, Integer r6) {
        a(r3);
        b(r5);
        this.f286a = r1;
        this.f287b = r2;
        this.c = r3;
        this.e = r5;
        this.d = r4;
        this.f = r6;
    }

    public f(CellExtraTypeEnum r2, String r3, String r4) {
        this.f286a = r2;
        this.f287b = r3;
        String[] r5 = r4.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        CellReference r6 = new CellReference(r5[0]);
        this.c = Integer.valueOf(r6.getRow());
        this.e = Integer.valueOf(r6.getCol());
        a(this.c);
        b(this.e);
        if (r5.length <= 1) goto L5;
        r6 = new CellReference(r5[1]);
    L5:
        this.d = Integer.valueOf(r6.getRow());
        this.f = Integer.valueOf(r6.getCol());
    }

    public CellExtraTypeEnum getType() {
        return this.f286a;
    }
}
