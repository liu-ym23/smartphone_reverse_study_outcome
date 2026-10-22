package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecordTypes;

/* JADX INFO: loaded from: classes7.dex */
public final class OfficeArtContent {
    protected static final c LOG = null;
    private final EscherContainerRecord drawingGroupData;
    private EscherContainerRecord headerDocumentDgContainer;
    private EscherContainerRecord mainDocumentDgContainer;

    static {
        LOG = b.a(OfficeArtContent.class);
    }

    public OfficeArtContent(byte[] r2, int r3, int r4) {
        this.drawingGroupData = new EscherContainerRecord();
        fillEscherRecords(r2, r3, r4);
    }

    private void fillEscherRecords(byte[] r8, int r9, int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        DefaultEscherRecordFactory r0 = new DefaultEscherRecordFactory();
        int r1 = this.drawingGroupData.fillFields(r8, r9, r0) + r9;
        if (this.drawingGroupData.getRecordId() != EscherRecordTypes.DGG_CONTAINER.typeID) goto L7;
        LOG.atDebug().a("Invalid record-id for filling Escher records: " + this.drawingGroupData.getRecordId());
    L7:
        int r2 = r9 + r10;
        if (r1 >= r2) goto L24;
        byte r3 = r8[r1];
        if (r3 == 0) goto L15;
        if (r3 == 1) goto L15;
        throw new IllegalArgumentException("Invalid dgglbl when filling Escher records: " + r3);
    L15:
        int r4 = r1 + 1;
        EscherContainerRecord r5 = new EscherContainerRecord();
        r1 = r4 + r5.fillFields(r8, r4, r0);
        if (r5.getRecordId() != EscherRecordTypes.DG_CONTAINER.typeID) goto L23;
        if (r3 != 0) goto L18;
        this.mainDocumentDgContainer = r5;
        goto L7
    L18:
        if (r3 != 1) goto L19;
        this.headerDocumentDgContainer = r5;
        goto L7
    L19:
        b.a(OfficeArtContent.class).atWarn().a("dgglbl {} for OfficeArtWordDrawing is out of bounds [0, 1]", v.a(r3));
        goto L7
    L23:
        throw new IllegalArgumentException("Did have an invalid record-type: " + r5.getRecordId() + " when filling Escher records");
    L24:
        if (r1 != r2) goto L27;
        return;
    L27:
        throw new IllegalStateException("Did not read all data when filling Escher records: pos: " + r1 + ", offset: " + r9 + ", size: " + r10);
    }

    public EscherContainerRecord getBStoreContainer() {
        return (EscherContainerRecord) ZeusTransformUtils.preCheckCast(this.drawingGroupData.getChildById(EscherRecordTypes.BSTORE_CONTAINER.typeID), EscherContainerRecord.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return "OfficeArtContent{drawingGroupData=" + this.drawingGroupData + ", mainDocumentDgContainer=" + this.mainDocumentDgContainer + ", headerDocumentDgContainer=" + this.headerDocumentDgContainer + '}';
    }
}
