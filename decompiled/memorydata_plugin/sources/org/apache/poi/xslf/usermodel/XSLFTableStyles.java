package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.openxmlformats.schemas.drawingml.x2006.main.cz;
import org.openxmlformats.schemas.drawingml.x2006.main.db;
import org.openxmlformats.schemas.drawingml.x2006.main.fv;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTableStyles extends POIXMLDocumentPart implements Iterable<XSLFTableStyle> {
    private List<XSLFTableStyle> _styles;
    private db _tblStyleLst;

    public XSLFTableStyles() {
    }

    public XSLFTableStyles(PackagePart r5) {
        super(r5);
        InputStream r6 = getPackagePart().getInputStream();
        fv r1 = (fv) ZeusTransformUtils.preCheckCast(fv.f18970a.parse(r6), fv.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r6 == null) goto L6;
        r6.close();
    L6:
        db r7 = r1.getTblStyleLst();
        this._tblStyleLst = r7;
        List<cz> r8 = r7.getTblStyleList();
        this._styles = new ArrayList(r8.size());
        Iterator<cz> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        cz r2 = (cz) ZeusTransformUtils.preCheckCast(r9.next(), cz.class, "com.obric.memorydata.plugin");
        this._styles.add(new XSLFTableStyle(r2));
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r6 != null) goto L20;
    L19:
        throw th;
    L20:
        r6.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableStyle> iterator() {
        return this._styles.iterator();
    }
}
