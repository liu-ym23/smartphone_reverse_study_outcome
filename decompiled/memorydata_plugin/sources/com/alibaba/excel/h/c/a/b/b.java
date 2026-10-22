package com.alibaba.excel.h.c.a.b;

import com.alibaba.excel.h.c.a.e;
import com.alibaba.excel.h.c.c;
import com.alibaba.excel.support.ExcelTypeEnum;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POIFSFileSystem f185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FormatTrackingHSSFListener f186b;
    private HSSFWorkbook c;
    private List<BoundSheetRecord> d;
    private Boolean e;
    private Integer f;
    private Boolean g;

    public b(c r2) {
        super(r2);
        this.d = new ArrayList();
        this.e = Boolean.TRUE;
        a(ExcelTypeEnum.XLS);
        if (f().b() != null) goto L5;
        f().b(Boolean.FALSE);
    L5:
        this.g = Boolean.FALSE;
    }

    public POIFSFileSystem G() {
        return this.f185a;
    }

    public FormatTrackingHSSFListener H() {
        return this.f186b;
    }

    public HSSFWorkbook I() {
        return this.c;
    }

    public List<BoundSheetRecord> J() {
        return this.d;
    }

    public Boolean K() {
        return this.e;
    }

    public Integer L() {
        return this.f;
    }

    public Boolean M() {
        return this.g;
    }

    public void a(Integer r1) {
        this.f = r1;
    }

    public void a(FormatTrackingHSSFListener r1) {
        this.f186b = r1;
    }

    public void a(HSSFWorkbook r1) {
        this.c = r1;
    }

    public void a(POIFSFileSystem r1) {
        this.f185a = r1;
    }

    public void b(Boolean r1) {
        this.g = r1;
    }
}
