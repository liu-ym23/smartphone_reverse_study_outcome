package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.usermodel.DifferentialStyleProvider;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bd;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fd;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFTableStyle implements TableStyle {
    private static final c LOG = null;
    private final Map<TableStyleType, DifferentialStyleProvider> elementMap;
    private final int index;
    private final String name;

    static {
        LOG = b.a(XSSFTableStyle.class);
    }

    public XSSFTableStyle(int r7, bd r8, fc r9, IndexedColorMap r10) {
        bd r11 = (bd) ZeusTransformUtils.wrapperContextForParams(r8, bd.class, "com.obric.memorydata.plugin");
        fc r12 = (fc) ZeusTransformUtils.wrapperContextForParams(r9, fc.class, "com.obric.memorydata.plugin");
        IndexedColorMap r13 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r10, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this.elementMap = new EnumMap(TableStyleType.class);
        this.name = r12.getName();
        this.index = r7;
        ArrayList r14 = new ArrayList();
        XmlCursor r15 = r11.newCursor();
        r15.selectPath("declare namespace x='http://schemas.openxmlformats.org/spreadsheetml/2006/main' .//x:dxf | .//dxf");     // Catch: Throwable -> L37
    L4:
        if (r15.toNextSelection() == false) goto L23;
        XmlObject r0 = r15.getObject();     // Catch: Throwable -> L37
        String r2 = r0.getDomNode().getParentNode().getNodeName();     // Catch: Throwable -> L37
        if (r2.equals("mc:Fallback") == false) goto L9;
    L48:
    L13:
        if (ZeusTransformUtils.instanceOf(r0, bc.class) == false) goto L16;
        Object r1 = ZeusTransformUtils.preCheckCast(r0, bc.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L20 Throwable -> L37
    L15:
        bc r3 = (bc) r1;     // Catch: XmlException -> L20 Throwable -> L37
        if (r3 == null) goto L4;
        r14.add(r3);     // Catch: XmlException -> L20 Throwable -> L37
        goto L4
    L16:
        r1 = ZeusTransformUtils.preCheckCast(bc.f19463a.parse(r0.newXMLStreamReader(), new XmlOptions().setDocumentType(bc.f19464b)), bc.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L20 Throwable -> L37
    L20:
        e = move-exception;
        LOG.atWarn().a(e).a("Error parsing XSSFTableStyle");     // Catch: Throwable -> L37
        goto L4
    L9:
        if (r2.equals("x:dxfs") == true) goto L48;
        if (r2.contentEquals("dxfs") == false) goto L4;
    L23:
        if (r15 == null) goto L25;
        r15.close();
    L25:
        Iterator<fd> r16 = r12.getTableStyleElementList().iterator();
    L27:
        if (r16.hasNext() == false) goto L36;
        fd r17 = (fd) ZeusTransformUtils.preCheckCast(r16.next(), fd.class, "com.obric.memorydata.plugin");
        TableStyleType r4 = TableStyleType.valueOf(r17.getType().toString());
        XSSFDxfStyleProvider r5 = null;
        if (r17.isSetDxfId() == false) goto L35;
        bc r6 = (bc) ZeusTransformUtils.preCheckCast(r14.get((int) r17.getDxfId()), bc.class, "com.obric.memorydata.plugin");
        int r18 = 0;
        if (r17.isSetSize() == false) goto L33;
        r18 = (int) r17.getSize();
    L33:
        if (r6 == null) goto L35;
        r5 = new XSSFDxfStyleProvider(r6, r18, r13);
    L35:
        this.elementMap.put(r4, r5);
        goto L27
    L36:
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r15 != null) goto L46;
    L45:
        throw th;
    L46:
        r15.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);
        goto L45
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public String getName() {
        return this.name;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public DifferentialStyleProvider getStyle(TableStyleType r2) {
        return (DifferentialStyleProvider) ZeusTransformUtils.preCheckCast(this.elementMap.get(r2), DifferentialStyleProvider.class, "com.obric.memorydata.plugin");
    }
}
