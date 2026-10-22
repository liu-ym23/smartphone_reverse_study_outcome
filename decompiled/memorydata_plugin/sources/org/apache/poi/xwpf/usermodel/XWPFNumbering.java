package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.a;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bs;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fw;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFNumbering extends POIXMLDocumentPart {
    protected List<XWPFAbstractNum> abstractNums;
    private bs ctNumbering;
    boolean isNew;
    protected List<XWPFNum> nums;

    public XWPFNumbering() {
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    public XWPFNumbering(PackagePart r1) {
        super(r1);
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(bs.f19981b.getName().getNamespaceURI(), "numbering"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.ctNumbering.save(r1, r0);     // Catch: Throwable -> L7
        if (r1 == null) goto L22;
        r1.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L18;
    L15:
        throw th;
    L18:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r0 = getPackagePart().getInputStream();
        bs r1 = ((fw) ZeusTransformUtils.preCheckCast(fw.f20180a.parse(r0, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fw.class, "com.obric.memorydata.plugin")).getNumbering();     // Catch: Throwable -> L12 XmlException -> L14
        this.ctNumbering = r1;     // Catch: Throwable -> L12 XmlException -> L14
        bn[] r2 = r1.getNumArray();     // Catch: Throwable -> L12 XmlException -> L14
        int r3 = r2.length;     // Catch: Throwable -> L12 XmlException -> L14
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L6;
        this.nums.add(new XWPFNum(r2[r4], this));     // Catch: Throwable -> L12 XmlException -> L14
        r4 = r4 + 1;     // Catch: Throwable -> L12 XmlException -> L14
        goto L4
    L6:
        a[] r5 = this.ctNumbering.getAbstractNumArray();     // Catch: Throwable -> L12 XmlException -> L14
        int r6 = r5.length;     // Catch: Throwable -> L12 XmlException -> L14
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L9;
        this.abstractNums.add(new XWPFAbstractNum(r5[r7], this));     // Catch: Throwable -> L12 XmlException -> L14
        r7 = r7 + 1;     // Catch: Throwable -> L12 XmlException -> L14
        goto L7
    L9:
        this.isNew = false;     // Catch: Throwable -> L12 XmlException -> L14
        r0.close();
        return;
    L12:
        th = move-exception;
        r0.close();
        throw th;
    L15:
        throw new POIXMLException();     // Catch: Throwable -> L12
    }
}
