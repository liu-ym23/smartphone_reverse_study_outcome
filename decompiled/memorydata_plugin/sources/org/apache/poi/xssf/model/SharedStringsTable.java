package org.apache.poi.xssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.eb;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.eu;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.gq;

/* JADX INFO: loaded from: classes7.dex */
public class SharedStringsTable extends POIXMLDocumentPart implements Closeable, SharedStrings {
    private static final XmlOptions options = null;
    private gq _sstDoc;
    protected int count;
    private final Map<String, Integer> stmap;
    private final List<eb> strings;
    protected int uniqueCount;

    static {
        XmlOptions r0 = new XmlOptions();
        options = r0;
        r0.setSaveInner();
        r0.setSaveAggressiveNamespaces();
        r0.setUseDefaultNamespace(true);
        r0.setSaveImplicitNamespaces(Collections.singletonMap("", "http://schemas.openxmlformats.org/spreadsheetml/2006/main"));
    }

    public SharedStringsTable() {
        this.strings = new ArrayList();
        this.stmap = new HashMap();
        gq r0 = (gq) ZeusTransformUtils.preCheckCast(gq.f19753a.newInstance(), gq.class, "com.obric.memorydata.plugin");
        this._sstDoc = r0;
        r0.addNewSst();
    }

    public SharedStringsTable(PackagePart r2) {
        super(r2);
        this.strings = new ArrayList();
        this.stmap = new HashMap();
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
        if (r3 != null) goto L18;
    L15:
        throw th;
    L18:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    int addEntry(eb r5) {
        eb r6 = (eb) ZeusTransformUtils.wrapperContextForParams(r5, eb.class, "com.obric.memorydata.plugin");
        String r0 = xmlText(r6);
        this.count++;
        if (this.stmap.containsKey(r0) == true) goto L5;
        this.uniqueCount++;
        eb r1 = this._sstDoc.getSst().addNewSi();
        r1.set(r6);
        int r7 = this.strings.size();
        this.stmap.put(r0, Integer.valueOf(r7));
        this.strings.add(r1);
        return r7;
    L5:
        return ((Integer) ZeusTransformUtils.preCheckCast(this.stmap.get(r0), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public int addSharedStringItem(RichTextString r3) {
        RichTextString r4 = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r3, RichTextString.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, XSSFRichTextString.class) == false) goto L7;
        return addEntry(((XSSFRichTextString) ZeusTransformUtils.preCheckCast(r4, XSSFRichTextString.class, "com.obric.memorydata.plugin")).getCTRst());
    L7:
        throw new IllegalArgumentException("Only XSSFRichTextString argument is supported");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
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

    @Override // org.apache.poi.xssf.model.SharedStrings
    public RichTextString getItemAt(int r3) {
        return new XSSFRichTextString((eb) ZeusTransformUtils.preCheckCast(this.strings.get(r3), eb.class, "com.obric.memorydata.plugin"));
    }

    public void readFrom(InputStream r8) {
        gq r9 = (gq) ZeusTransformUtils.preCheckCast(gq.f19753a.parse(r8, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gq.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L7
        this._sstDoc = r9;     // Catch: XmlException -> L7
        eu r10 = r9.getSst();     // Catch: XmlException -> L7
        this.count = (int) r10.getCount();     // Catch: XmlException -> L7
        this.uniqueCount = (int) r10.getUniqueCount();     // Catch: XmlException -> L7
        eb[] r11 = r10.getSiArray();     // Catch: XmlException -> L7
        int r0 = r11.length;     // Catch: XmlException -> L7
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L6;
        eb r3 = r11[r1];     // Catch: XmlException -> L7
        this.stmap.put(xmlText(r3), Integer.valueOf(r2));     // Catch: XmlException -> L7
        this.strings.add(r3);     // Catch: XmlException -> L7
        r2 = r2 + 1;
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    L7:
        e = move-exception;
        throw new IOException("unable to parse shared strings table", e);
    }

    public void writeTo(OutputStream r5) {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveCDataLengthThreshold(1000000);
        r0.setSaveCDataEntityCountThreshold(-1);
        eu r1 = this._sstDoc.getSst();
        r1.setCount(this.count);
        r1.setUniqueCount(this.uniqueCount);
        this._sstDoc.save(r5, r0);
    }

    public String xmlText(eb r2) {
        return ((eb) ZeusTransformUtils.wrapperContextForParams(r2, eb.class, "com.obric.memorydata.plugin")).xmlText(options);
    }
}
