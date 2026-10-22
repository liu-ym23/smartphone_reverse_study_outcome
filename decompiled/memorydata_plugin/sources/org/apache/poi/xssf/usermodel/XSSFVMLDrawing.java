package org.apache.poi.xssf.usermodel;

import com.microsoft.schemas.office.excel.STObjectType;
import com.microsoft.schemas.office.excel.a;
import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.office.office.b;
import com.microsoft.schemas.office.office.e;
import com.microsoft.schemas.office.office.g;
import com.microsoft.schemas.vml.STExt;
import com.microsoft.schemas.vml.STStrokeJoinStyle;
import com.microsoft.schemas.vml.k;
import com.microsoft.schemas.vml.o;
import com.microsoft.schemas.vml.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.schemas.vmldrawing.XmlDocument;
import org.apache.poi.util.ReplacingInputStream;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFVMLDrawing extends POIXMLDocumentPart {
    public static final QName QNAME_VMLDRAWING = null;
    private static final Pattern ptrn_shapeId = null;
    private int _shapeId;
    private String _shapeTypeId;
    private XmlDocument root;

    static {
        QNAME_VMLDRAWING = new QName("urn:schemas-poi-apache-org:vmldrawing", "xml");
        ptrn_shapeId = Pattern.compile("_x0000_s(\\d+)");
    }

    public XSSFVMLDrawing() {
        this._shapeId = 1024;
        newDrawing();
    }

    public XSSFVMLDrawing(PackagePart r2) {
        super(r2);
        this._shapeId = 1024;
        InputStream r3 = getPackagePart().getInputStream();
        read(r3);     // Catch: Throwable -> L7
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
        if (r3 != null) goto L16;
    L15:
        throw th;
    L16:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    private boolean matchCommentShape(XmlObject r3, int r4, int r5) {
        XmlObject r2 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, o.class) == true) goto L5;
        return false;
    L5:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r2, o.class, "com.obric.memorydata.plugin");
        if (r6.sizeOfClientDataArray() != 0) goto L8;
        return false;
    L8:
        a r7 = r6.getClientDataArray(0);
        if (r7.getObjectType() == STObjectType.m) goto L11;
        return false;
    L11:
        int r8 = r7.getRowArray(0).intValue();
        int r9 = r7.getColumnArray(0).intValue();
        if (r8 != r4) goto L16;
        if (r9 != r5) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    }

    private void newDrawing() {
        XmlDocument r0 = (XmlDocument) ZeusTransformUtils.preCheckCast(XmlDocument.Factory.newInstance(), XmlDocument.class, "com.obric.memorydata.plugin");
        this.root = r0;
        XmlCursor r1 = r0.addNewXml().newCursor();
        g r2 = (g) ZeusTransformUtils.preCheckCast(g.f5707a.newInstance(), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        e r3 = r2.addNewShapelayout();     // Catch: Throwable -> L32
        r3.setExt(STExt.d);     // Catch: Throwable -> L32
        b r4 = r3.addNewIdmap();     // Catch: Throwable -> L32
        r4.setExt(STExt.d);     // Catch: Throwable -> L32
        r4.setData("1");     // Catch: Throwable -> L32
        r1.toEndToken();     // Catch: Throwable -> L32
        XmlCursor r5 = r2.newCursor();     // Catch: Throwable -> L32
        r5.copyXmlContents(r1);     // Catch: Throwable -> L23
        if (r5 == null) goto L7;
        r5.close();     // Catch: Throwable -> L32
    L7:
        com.microsoft.schemas.vml.e r6 = (com.microsoft.schemas.vml.e) ZeusTransformUtils.preCheckCast(com.microsoft.schemas.vml.e.f5783a.newInstance(), com.microsoft.schemas.vml.e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        p r7 = r6.addNewShapetype();     // Catch: Throwable -> L32
        this._shapeTypeId = "_x0000_t202";     // Catch: Throwable -> L32
        r7.setId("_x0000_t202");     // Catch: Throwable -> L32
        r7.setCoordsize("21600,21600");     // Catch: Throwable -> L32
        r7.setSpt(202.0f);     // Catch: Throwable -> L32
        r7.setPath2("m,l,21600r21600,l21600,xe");     // Catch: Throwable -> L32
        r7.addNewStroke().setJoinstyle(STStrokeJoinStyle.e);     // Catch: Throwable -> L32
        k r8 = r7.addNewPath();     // Catch: Throwable -> L32
        r8.setGradientshapeok(STTrueFalse.c);     // Catch: Throwable -> L32
        r8.setConnecttype(STConnectType.d);     // Catch: Throwable -> L32
        r1.toEndToken();     // Catch: Throwable -> L32
        XmlCursor r9 = r6.newCursor();     // Catch: Throwable -> L32
        r9.copyXmlContents(r1);     // Catch: Throwable -> L14
        if (r9 == null) goto L11;
        r9.close();     // Catch: Throwable -> L32
    L11:
        if (r1 == null) goto L58;
        r1.close();
        return;
    L58:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r9 != null) goto L55;
    L22:
        throw th;     // Catch: Throwable -> L32
    L55:
        r9.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
        goto L22
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r5 != null) goto L53;
    L31:
        throw th;     // Catch: Throwable -> L32
    L53:
        r5.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (r1 != null) goto L51;
    L40:
        throw th;
    L51:
        r1.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.addSuppressed(th);
        goto L40
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        write(r0);     // Catch: Throwable -> L7
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

    public o findCommentShape(int r4, int r5) {
        XmlCursor r0 = this.root.getXml().newCursor();
        boolean r1 = r0.toFirstChild();     // Catch: Throwable -> L17
    L4:
        if (r1 == false) goto L13;
        XmlObject r2 = r0.getObject();     // Catch: Throwable -> L17
        if (matchCommentShape(r2, r4, r5) == true) goto L7;
        r1 = r0.toNextSibling();     // Catch: Throwable -> L17
        goto L4
    L7:
        o r3 = (o) ZeusTransformUtils.preCheckCast(r2, o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r0 == null) goto L10;
        r0.close();
    L10:
        return r3;
    L13:
        if (r0 == null) goto L34;
        r0.close();
        return null;
    L34:
        return null;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r0 != null) goto L30;
    L25:
        throw th;
    L30:
        r0.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    public void read(InputStream r8) {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setLoadSubstituteNamespaces(Collections.singletonMap("", QNAME_VMLDRAWING.getNamespaceURI()));
        r0.setDocumentType(XmlDocument.type);
        XmlDocument r9 = (XmlDocument) ZeusTransformUtils.preCheckCast(XmlDocument.Factory.parse(new ReplacingInputStream(new ReplacingInputStream(r8, "<br>", "<br/>"), " xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\"", ""), r0), XmlDocument.class, "com.obric.memorydata.plugin");
        this.root = r9;
        XmlCursor r10 = r9.getXml().newCursor();
        boolean r1 = r10.toFirstChild();     // Catch: Throwable -> L20
    L4:
        if (r1 == false) goto L17;
        XmlObject r2 = r10.getObject();     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r2, p.class) == false) goto L9;
        this._shapeTypeId = ((p) ZeusTransformUtils.preCheckCast(r2, p.class, "com.obric.memorydata.plugin")).getId();     // Catch: Throwable -> L20
    L15:
        r1 = r10.toNextSibling();     // Catch: Throwable -> L20
        goto L4
    L9:
        if (ZeusTransformUtils.instanceOf(r2, o.class) == false) goto L15;
        String r3 = ((o) ZeusTransformUtils.preCheckCast(r2, o.class, "com.obric.memorydata.plugin")).getId();     // Catch: Throwable -> L20
        if (r3 == null) goto L15;
        Matcher r4 = ptrn_shapeId.matcher(r3);     // Catch: Throwable -> L20
        if (r4.find() == false) goto L15;
        this._shapeId = Math.max(this._shapeId, Integer.parseInt(r4.group(1)));     // Catch: Throwable -> L20
        goto L15
    L17:
        if (r10 == null) goto L41;
        r10.close();
        return;
    L41:
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r10 != null) goto L33;
    L28:
        throw th;
    L33:
        r10.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    }

    public void write(OutputStream r4) {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveImplicitNamespaces(Collections.singletonMap("", QNAME_VMLDRAWING.getNamespaceURI()));
        this.root.save(r4, r0);
    }
}
