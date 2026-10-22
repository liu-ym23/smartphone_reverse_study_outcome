package org.apache.poi.hssf.usermodel;

import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFPolygon extends HSSFSimpleShape {
    private static final c LOG = null;

    static {
        LOG = b.a(HSSFPolygon.class);
    }

    public HSSFPolygon(EscherContainerRecord r1, ObjRecord r2, TextObjectRecord r3) {
        super(r1, r2, r3);
    }
}
