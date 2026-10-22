package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.hwpf.model.types.FSPAAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class FSPATable {
    private final Map<Integer, GenericPropertyNode> _byStart;

    public FSPATable(byte[] r3, FileInformationBlock r4, FSPADocumentPart r5) {
        this._byStart = new LinkedHashMap();
        PlexOfCps r6 = new PlexOfCps(r3, r4.getFSPAPlcfOffset(r5), r4.getFSPAPlcfLength(r5), FSPAAbstractType.getSize());
        int r7 = 0;
    L4:
        if (r7 >= r6.length()) goto L6;
        GenericPropertyNode r8 = r6.getProperty(r7);
        this._byStart.put(Integer.valueOf(r8.getStart()), r8);
        r7 = r7 + 1;
        goto L4
    }

    public FSPA getFspaFromCp(int r2) {
        GenericPropertyNode r1 = (GenericPropertyNode) ZeusTransformUtils.preCheckCast(this._byStart.get(Integer.valueOf(r2)), GenericPropertyNode.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return new FSPA(r1.getBytes(), 0);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[FPSA PLC size=").append(this._byStart.size()).append("]\n");
        Iterator<Map.Entry<Integer, GenericPropertyNode>> r1 = this._byStart.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin");
        r0.append("  ").append(r2).append(" => \t");
        r0.append(getFspaFromCp(r2.intValue()));     // Catch: Exception -> L8
    L10:
        r0.append("\n");
    L8:
        e = move-exception;
        r0.append(e.getMessage());
        goto L10
    L11:
        r0.append("[/FSPA PLC]");
        return r0.toString();
    }
}
