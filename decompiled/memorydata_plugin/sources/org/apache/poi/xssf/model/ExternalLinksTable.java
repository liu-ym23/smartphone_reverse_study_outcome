package org.apache.poi.xssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.Name;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bg;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bh;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bi;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bk;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bp;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.br;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fv;

/* JADX INFO: loaded from: classes7.dex */
public class ExternalLinksTable extends POIXMLDocumentPart {
    private bk link;

    protected class ExternalName implements Name {
        private final bi name;
        final /* synthetic */ ExternalLinksTable this$0;

        public ExternalName(ExternalLinksTable r3, bi r4) {
            bi r5 = (bi) ZeusTransformUtils.wrapperContextForParams(r4, bi.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.name = r5;
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public String getNameName() {
            return this.name.getName();
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public int getSheetIndex() {
            if (this.name.isSetSheetId() == true) goto L5;
            return -1;
        L5:
            return (int) this.name.getSheetId();
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setFunction(boolean r1) {
            throw new IllegalStateException("Not Supported");
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setNameName(String r1) {
            this.name.setName(r1);
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setSheetIndex(int r3) {
            this.name.setSheetId(r3);
        }
    }

    public ExternalLinksTable() {
        bk r0 = (bk) ZeusTransformUtils.preCheckCast(bk.f19479a.newInstance(), bk.class, "com.obric.memorydata.plugin");
        this.link = r0;
        r0.addNewExternalBook();
    }

    public ExternalLinksTable(PackagePart r2) {
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

    private bh getCell(bn r5, String r6) {
        bn r4 = (bn) ZeusTransformUtils.wrapperContextForParams(r5, bn.class, "com.obric.memorydata.plugin");
        bh[] r7 = r4.getCellArray();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        bh r2 = r7[r1];
        if (r2.getR().equals(r6) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        bh r8 = r4.addNewCell();
        r8.setR(r6);
        return r8;
    }

    private bn getRow(bo r6, long r7) {
        bo r5 = (bo) ZeusTransformUtils.wrapperContextForParams(r6, bo.class, "com.obric.memorydata.plugin");
        bn[] r8 = r5.getRowArray();
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        bn r2 = r8[r1];
        if (r2.getR() == r7) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        bn r9 = r5.addNewRow();
        r9.setR(r7);
        return r9;
    }

    private bo getSheetData(int r10) {
        bp r0 = this.link.getExternalBook().getSheetDataSet();
        if (r0 != null) goto L5;
        r0 = this.link.getExternalBook().addNewSheetDataSet();
    L5:
        bo r9 = null;
        bo[] r1 = r0.getSheetDataArray();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        bo r4 = r1[r3];
        if (r4.getSheetId() == r10) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        r9 = r4;
    L11:
        if (r9 != null) goto L16;
        bo r11 = r0.addNewSheetData();
        r11.setSheetId(r10);
        return r11;
    L16:
        return r9;
    }

    private int getSheetNameIndex(String r4) {
        bg r3 = this.link.getExternalBook();
        br r0 = r3.getSheetNames();
        if (r0 != null) goto L5;
        r0 = r3.addNewSheetNames();
    L5:
        int r5 = 0;
    L7:
        if (r5 >= r0.sizeOfSheetNameArray()) goto L12;
        if (r0.getSheetNameArray(r5).getVal().equals(r4) == true) goto L13;
        r5 = r5 + 1;
    L13:
        if (r5 != (-1)) goto L18;
        r0.addNewSheetName().setVal(r4);
        return r0.sizeOfSheetNameArray() - 1;
    L18:
        return r5;
    L12:
        r5 = -1;
        goto L13
    }

    public void cacheData(String r2, long r3, String r5, String r6) {
        Object r0 = this.link.getExternalBook().monitor();
        monitor-enter(r0);
        getCell(getRow(getSheetData(getSheetNameIndex(r2)), r3), r5).setV(r6);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
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

    public List<Name> getDefinedNames() {
        bi[] r0 = this.link.getExternalBook().getDefinedNames().getDefinedNameArray();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1.add(new ExternalName(this, r0[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public String getLinkedFileName() {
        String r0 = this.link.getExternalBook().getId();
        PackageRelationship r2 = getPackagePart().getRelationship(r0);
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.getTargetMode() == TargetMode.EXTERNAL) goto L7;
        return null;
    L7:
        return r2.getTargetURI().toString();
    }

    public void readFrom(InputStream r3) {
        this.link = ((fv) ZeusTransformUtils.preCheckCast(fv.f19715a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fv.class, "com.obric.memorydata.plugin")).getExternalLink();     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }

    public void writeTo(OutputStream r4) {
        fv r0 = (fv) ZeusTransformUtils.preCheckCast(fv.f19715a.newInstance(), fv.class, "com.obric.memorydata.plugin");
        r0.setExternalLink(this.link);
        r0.save(r4, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
