package org.apache.poi.xssf.model;

import com.microsoft.schemas.vml.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.OoxmlSheetExtensions;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFVMLDrawing;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ag;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ai;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fu;

/* JADX INFO: loaded from: classes7.dex */
public class CommentsTable extends POIXMLDocumentPart implements Comments {
    private Map<CellAddress, ag> commentRefs;
    private ai comments;
    private Sheet sheet;
    private XSSFVMLDrawing vmlDrawing;

    public CommentsTable() {
        ai r0 = (ai) ZeusTransformUtils.preCheckCast(ai.f19425a.newInstance(), ai.class, "com.obric.memorydata.plugin");
        this.comments = r0;
        r0.addNewCommentList();
        this.comments.addNewAuthors().addAuthor("");
    }

    public CommentsTable(PackagePart r2) {
        super(r2);
        InputStream r3 = r2.getInputStream();
        readFrom(r3);     // Catch: Throwable -> L7
        if (r3 == null) goto L22;
        r3.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r3 != null) goto L20;
    L15:
        throw th;
    L20:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    private XSSFVMLDrawing getVMLDrawing(Sheet r3, boolean r4) {
        Sheet r5 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r3, Sheet.class, "com.obric.memorydata.plugin");
        if (this.vmlDrawing != null) goto L8;
        if (ZeusTransformUtils.instanceOf(r5, OoxmlSheetExtensions.class) == false) goto L8;
        this.vmlDrawing = ((OoxmlSheetExtensions) ZeusTransformUtils.preCheckCast(r5, OoxmlSheetExtensions.class, "com.obric.memorydata.plugin")).getVMLDrawing(r4);
    L8:
        return this.vmlDrawing;
    }

    private void prepareCTCommentCache() {
        if (this.commentRefs != null) goto L7;
        this.commentRefs = new HashMap();
        ag[] r0 = this.comments.getCommentList().getCommentArray();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        ag r3 = r0[r2];
        this.commentRefs.put(new CellAddress(r3.getRef()), r3);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        writeTo(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.xssf.model.Comments
    public XSSFComment findCellComment(CellAddress r5) {
        ag r0 = getCTComment(r5);
        o r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        XSSFVMLDrawing r2 = getVMLDrawing(this.sheet, false);
        if (r2 == null) goto L10;
        r1 = r2.findCommentShape(r5.getRow(), r5.getColumn());
    L10:
        return new XSSFComment(this, r0, r1);
    }

    ag getCTComment(CellAddress r2) {
        prepareCTCommentCache();
        return (ag) ZeusTransformUtils.preCheckCast(this.commentRefs.get(r2), ag.class, "com.obric.memorydata.plugin");
    }

    public Iterator<CellAddress> getCellAddresses() {
        prepareCTCommentCache();
        return this.commentRefs.keySet().iterator();
    }

    public void readFrom(InputStream r3) {
        this.comments = ((fu) ZeusTransformUtils.preCheckCast(fu.f19713a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fu.class, "com.obric.memorydata.plugin")).getComments();     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }

    @Override // org.apache.poi.xssf.model.Comments
    public void setSheet(Sheet r3) {
        this.sheet = (Sheet) ZeusTransformUtils.wrapperContextForParams(r3, Sheet.class, "com.obric.memorydata.plugin");
    }

    public void writeTo(OutputStream r4) {
        fu r0 = (fu) ZeusTransformUtils.preCheckCast(fu.f19713a.newInstance(), fu.class, "com.obric.memorydata.plugin");
        r0.setComments(this.comments);
        r0.save(r4, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
