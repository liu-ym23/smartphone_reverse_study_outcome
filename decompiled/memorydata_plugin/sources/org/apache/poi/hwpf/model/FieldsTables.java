package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class FieldsTables {
    private Map<FieldsDocumentPart, PlexOfCps> _tables;

    public FieldsTables(byte[] r7, FileInformationBlock r8) {
        this._tables = new HashMap(FieldsDocumentPart.values().length);
        FieldsDocumentPart[] r0 = FieldsDocumentPart.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        FieldsDocumentPart r3 = r0[r2];
        PlexOfCps r4 = readPLCF(r7, r8, r3);
        this._tables.put(r3, r4);
        r2 = r2 + 1;
        goto L3
    }

    private PlexOfCps readPLCF(byte[] r2, FileInformationBlock r3, FieldsDocumentPart r4) {
        int r1 = r3.getFieldsPlcfOffset(r4);
        int r5 = r3.getFieldsPlcfLength(r4);
        if (r1 <= 0) goto L8;
        if (r5 > 0) goto L7;
        return null;
    L7:
        return new PlexOfCps(r2, r1, r5, 2);
    L8:
        return null;
    }

    private static ArrayList<PlexOfField> toArrayList(PlexOfCps r4) {
        if (r4 == null) goto L4;
        ArrayList<PlexOfField> r0 = new ArrayList(r4.length());
        int r1 = 0;
    L7:
        if (r1 >= r4.length()) goto L9;
        r0.add(new PlexOfField(r4.getProperty(r1)));
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    L4:
        return new ArrayList();
    }

    public ArrayList<PlexOfField> getFieldsPLCF(FieldsDocumentPart r2) {
        return toArrayList((PlexOfCps) ZeusTransformUtils.preCheckCast(this._tables.get(r2), PlexOfCps.class, "com.obric.memorydata.plugin"));
    }
}
