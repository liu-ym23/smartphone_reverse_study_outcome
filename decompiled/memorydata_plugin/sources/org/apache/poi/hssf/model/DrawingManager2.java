package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;

/* JADX INFO: loaded from: classes7.dex */
public class DrawingManager2 {
    private final EscherDggRecord dgg;
    private final List<EscherDgRecord> drawingGroups;

    public DrawingManager2(EscherDggRecord r2) {
        this.drawingGroups = new ArrayList();
        this.dgg = r2;
    }

    public int allocateShapeId(EscherDgRecord r2) {
        return this.dgg.allocateShapeId(r2, true);
    }

    public short findNewDrawingGroupId() {
        return this.dgg.findNewDrawingGroupId();
    }

    public void incrementDrawingsSaved() {
        EscherDggRecord r1 = this.dgg;
        r1.setDrawingsSaved(r1.getDrawingsSaved() + 1);
    }
}
