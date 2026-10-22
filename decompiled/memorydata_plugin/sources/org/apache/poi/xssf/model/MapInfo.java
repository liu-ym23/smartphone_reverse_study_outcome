package org.apache.poi.xssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fw;

/* JADX INFO: loaded from: classes7.dex */
public class MapInfo extends POIXMLDocumentPart {
    private cs mapInfo;
    private Map<Integer, XSSFMap> maps;

    public MapInfo() {
        this.mapInfo = (cs) ZeusTransformUtils.preCheckCast(cs.f19549a.newInstance(), cs.class, "com.obric.memorydata.plugin");
    }

    public MapInfo(PackagePart r2) {
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

    public void readFrom(InputStream r7) {
        this.mapInfo = ((fw) ZeusTransformUtils.preCheckCast(fw.f19717a.parse(r7, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fw.class, "com.obric.memorydata.plugin")).getMapInfo();     // Catch: XmlException -> L7
        this.maps = new HashMap();     // Catch: XmlException -> L7
        cr[] r8 = this.mapInfo.getMapArray();     // Catch: XmlException -> L7
        int r0 = r8.length;     // Catch: XmlException -> L7
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        cr r2 = r8[r1];     // Catch: XmlException -> L7
        this.maps.put(Integer.valueOf((int) r2.getID()), new XSSFMap(r2, this));     // Catch: XmlException -> L7
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    L7:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }

    public void writeTo(OutputStream r4) {
        fw r0 = (fw) ZeusTransformUtils.preCheckCast(fw.f19717a.newInstance(), fw.class, "com.obric.memorydata.plugin");
        r0.setMapInfo(this.mapInfo);
        r0.save(r4, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
