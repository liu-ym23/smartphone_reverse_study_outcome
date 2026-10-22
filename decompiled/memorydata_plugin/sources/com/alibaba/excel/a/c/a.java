package com.alibaba.excel.a.c;

import com.alibaba.excel.a.c;
import com.alibaba.excel.e.c.b;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.i.g;
import com.alibaba.excel.i.j;
import com.alibaba.excel.i.n;
import com.alibaba.excel.i.o;
import com.alibaba.excel.metadata.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.xml.parsers.SAXParserFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fk;
import org.slf4j.d;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PackagePartName f130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final org.slf4j.c f131b = null;
    private final b c;
    private final List<com.alibaba.excel.h.c.b> d;
    private final Map<Integer, InputStream> e;
    private final Map<Integer, CommentsTable> f;

    static {
        f131b = d.a(a.class);
        f130a = PackagingURIHelper.createPartName("/xl/sharedStrings.xml");     // Catch: InvalidFormatException -> L5
        return;
    L5:
        e = move-exception;
        f131b.error("Initialize the XlsxSaxAnalyser failure", e);
        throw new ExcelAnalysisException("Initialize the XlsxSaxAnalyser failure", e);
    }

    public a(b r9, InputStream r10) {
        b r11 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.memorydata.plugin");
        this.c = r11;
        com.alibaba.excel.h.c.a.c.b r0 = r11.f();
        OPCPackage r12 = a(r0, r10);
        r0.a(r12);
        PackagePart r2 = r12.getPart(f130a);
        if (r2 == null) goto L5;
        a(r0, r2);
        a(r2.getInputStream(), r0);
    L5:
        XSSFReader r3 = new XSSFReader(r12);
        a(r3, r0);
        a(r0, r3);
        this.d = new ArrayList();
        this.e = new HashMap();
        this.f = new HashMap();
        HashMap r13 = j.a();
        r0.b(r13);
        XSSFReader.SheetIterator r1 = (XSSFReader.SheetIterator) ZeusTransformUtils.preCheckCast(r3.getSheetsData(), XSSFReader.SheetIterator.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (r1.hasNext() == false) goto L22;
    L8:
        if (r1.hasNext() == false) goto L20;
        InputStream r5 = r1.next();
        this.d.add(new com.alibaba.excel.h.c.b(Integer.valueOf(r4), r1.getSheetName()));
        this.e.put(Integer.valueOf(r4), r5);
        if (r11.a().B().contains(CellExtraTypeEnum.COMMENT) == false) goto L15;
        CommentsTable r6 = r1.getSheetComments();
        if (r6 == null) goto L15;
        this.f.put(Integer.valueOf(r4), r6);
    L15:
        if (r11.a().B().contains(CellExtraTypeEnum.HYPERLINK) == false) goto L19;
        PackageRelationshipCollection r7 = (PackageRelationshipCollection) ZeusTransformUtils.preCheckCast(Optional.ofNullable(r1.getSheetPart()).map($$Lambda$a$7iD5UbmAAlrLpvlb_uXLdW5ZV4.INSTANCE).orElse(null), PackageRelationshipCollection.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L19;
        r13.put(Integer.valueOf(r4), r7);
    L19:
        r4 = r4 + 1;
        goto L8
    L20:
        return;
    L22:
        throw new ExcelAnalysisException("Can not find any sheet!");
    }

    private OPCPackage a(com.alibaba.excel.h.c.a.c.b r4, InputStream r5) {
        if (r5 != null) goto L8;
        if (r4.p() == null) goto L8;
        return OPCPackage.open(r4.p());
    L8:
        if (r4.r().booleanValue() == false) goto L14;
        if (r5 == null) goto L13;
        return OPCPackage.open(r5);
    L13:
        return OPCPackage.open(r4.o());
    L14:
        File r3 = g.a();
        r4.a(r3);
        File r0 = new File(r3.getPath(), UUID.randomUUID().toString() + ".xlsx");
        if (r5 == null) goto L17;
        g.a(r0, r5, false);
    L19:
        return OPCPackage.open(r0, PackageAccess.READ);
    L17:
        g.a(r0, r4.o(), r4.s().booleanValue());
        goto L19
    }

    private static /* synthetic */ PackageRelationshipCollection a(PackagePart r2) {
        return r2.getRelationships();
    L4:
        e = move-exception;
        f131b.warn("Reading the Relationship failed", e);
        return null;
    }

    private void a(com.alibaba.excel.h.c.a.c.b r2, PackagePart r3) {
        com.alibaba.excel.c.c r4 = r2.y().a(r3);
        r2.a(r4);
        r4.a(this.c);
    }

    private void a(com.alibaba.excel.h.c.a.c.b r1, XSSFReader r2) {
        r1.a(r2.getStylesTable());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        f131b.warn("Currently excel cannot get style information, but it doesn't affect the data analysis.You can try to save the file with office again or ignore the current error.", e);
    }

    private void a(com.alibaba.excel.h.c.b r8) {
        if (this.c.a().B().contains(CellExtraTypeEnum.COMMENT) == true) goto L5;
        return;
    L5:
        CommentsTable r9 = (CommentsTable) ZeusTransformUtils.preCheckCast(this.f.get(r8.k()), CommentsTable.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L8;
        return;
    L8:
        Iterator<CellAddress> r0 = r9.getCellAddresses();
    L10:
        if (r0.hasNext() == false) goto L12;
        CellAddress r2 = (CellAddress) ZeusTransformUtils.preCheckCast(r0.next(), CellAddress.class, "com.obric.memorydata.plugin");
        XSSFComment r3 = r9.findCellComment(r2);
        f r4 = new f(CellExtraTypeEnum.COMMENT, r3.getString().toString(), Integer.valueOf(r2.getRow()), Integer.valueOf(r2.getColumn()));
        this.c.b().a(r4);
        this.c.e().a(this.c);
        goto L10
    }

    private void a(InputStream r3, com.alibaba.excel.h.c.a.c.b r4) {
        a(r3, new com.alibaba.excel.a.c.a.a.a(r4.x()));
        r4.x().a();
    }

    private void a(InputStream r5, ContentHandler r6) {
        ContentHandler r7 = (ContentHandler) ZeusTransformUtils.wrapperContextForParams(r6, ContentHandler.class, "com.obric.memorydata.plugin");
        InputSource r1 = new InputSource(r5);
        String r4 = this.c.f().H();     // Catch: Throwable -> L18 Throwable -> L20
        if (o.a(r4) == false) goto L6;
        SAXParserFactory r8 = SAXParserFactory.newInstance();     // Catch: Throwable -> L18 Throwable -> L20
    L34:
        r8.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);     // Catch: Throwable -> L29
    L38:
        r8.setFeature("http://xml.org/sax/features/external-general-entities", false);     // Catch: Throwable -> L30
    L42:
        r8.setFeature("http://xml.org/sax/features/external-parameter-entities", false);     // Catch: Throwable -> L31
    L11:
        XMLReader r9 = r8.newSAXParser().getXMLReader();     // Catch: Throwable -> L18 Throwable -> L20 Throwable -> L20 Throwable -> L20
        r9.setContentHandler(r7);     // Catch: Throwable -> L18 Throwable -> L20 Throwable -> L20 Throwable -> L20
        r9.parse(r1);     // Catch: Throwable -> L18 Throwable -> L20 Throwable -> L20 Throwable -> L20
        r5.close();     // Catch: Throwable -> L18 Throwable -> L20 Throwable -> L20 Throwable -> L20
        if (r5 != null) goto L36;
        return;
    L36:
        r5.close();     // Catch: IOException -> L15
        return;
    L16:
        throw new ExcelAnalysisException("Can not close 'inputStream'!");
    L6:
        r8 = SAXParserFactory.newInstance(r4, null);     // Catch: Throwable -> L18 Throwable -> L20
    L18:
        th = move-exception;
        if (r5 != null) goto L32;
    L28:
        throw th;
    L32:
        r5.close();     // Catch: IOException -> L26
    L27:
        throw new ExcelAnalysisException("Can not close 'inputStream'!");
    L20:
        e = move-exception;
        throw new ExcelAnalysisException(e);     // Catch: Throwable -> L18
    }

    private void a(XSSFReader r1, com.alibaba.excel.h.c.a.c.b r2) {
        if (r2.b().b() == null) goto L5;
        return;
    L5:
        fk r0 = WorkbookDocument.Factory.parse(r1.getWorkbookData()).getWorkbook().getWorkbookPr();
        if (r0 != null) goto L8;
    L10:
        com.alibaba.excel.metadata.j r3 = r2.f();
        Boolean r4 = Boolean.FALSE;
    L11:
        r3.b(r4);
        return;
    L8:
        if (r0.getDate1904() == false) goto L10;
        r3 = r2.f();
        r4 = Boolean.TRUE;
        goto L11
    }

    /* JADX INFO: renamed from: lambda$-7iD5UbmAAlrLpvlb_uXLdW5ZV4, reason: not valid java name */
    public static /* synthetic */ PackageRelationshipCollection m67lambda$7iD5UbmAAlrLpvlb_uXLdW5ZV4(PackagePart r0) {
        return a(r0);
    }

    @Override // com.alibaba.excel.a.c
    public void a() {
        Iterator<com.alibaba.excel.h.c.b> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.alibaba.excel.h.c.b r1 = n.a((com.alibaba.excel.h.c.b) ZeusTransformUtils.preCheckCast(r0.next(), com.alibaba.excel.h.c.b.class, "com.obric.memorydata.plugin"), this.c);
        if (r1 == null) goto L4;
        this.c.a(r1);
        a((InputStream) ZeusTransformUtils.preCheckCast(this.e.get(r1.k()), InputStream.class, "com.obric.memorydata.plugin"), new com.alibaba.excel.a.c.a.a.b(this.c));
        a(r1);
        this.c.e().c(this.c);
        goto L4
    }
}
