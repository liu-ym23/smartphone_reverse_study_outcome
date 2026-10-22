package org.apache.poi.hwpf.model;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class FIBFieldHandler {
    private static final c LOGGER = null;
    private int[] _fields;
    private Map<Integer, UnhandledDataStructure> _unknownMap;

    static {
        LOGGER = b.a(FIBFieldHandler.class);
    }

    FIBFieldHandler(byte[] r9, int r10, int r11, byte[] r12, HashSet<Integer> r13, boolean r14) {
        this._unknownMap = new HashMap();
        this._fields = new int[r11 * 2];
        int r0 = 0;
    L3:
        if (r0 >= r11) goto L12;
        int r1 = (r0 * 8) + r10;
        int r2 = LittleEndian.getInt(r9, r1);
        int r3 = LittleEndian.getInt(r9, r1 + 4);
        if ((r13.contains(Integer.valueOf(r0)) ^ r14) == false) goto L11;
        if (r3 <= 0) goto L11;
        if ((r2 + r3) <= r12.length) goto L10;
        LOGGER.atWarn().a("Unhandled data structure points to outside the buffer. offset = {}, length = {}, buffer length = {}", v.a(r2), v.a(r3), v.a(r12.length));
        goto L11
    L10:
        UnhandledDataStructure r4 = new UnhandledDataStructure(r12, r2, r3);
        this._unknownMap.put(Integer.valueOf(r0), r4);
    L11:
        int[] r5 = this._fields;
        int r6 = r0 * 2;
        r5[r6] = r2;
        r5[r6 + 1] = r3;
        r0 = r0 + 1;
        goto L3
    }

    private static String leftPad(String r3, int r4, char r5) {
        if (r3.length() < r4) goto L5;
        return r3;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= (r4 - r3.length())) goto L9;
        r0.append(r5);
        r1 = r1 + 1;
        goto L7
    L9:
        r0.append(r3);
        return r0.toString();
    }

    public int getFieldOffset(int r1) {
        return this._fields[r1 * 2];
    }

    public int getFieldSize(int r1) {
        return this._fields[(r1 * 2) + 1];
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[FIBFieldHandler]:\n");
        r0.append("\tFields:\n");
        r0.append("\t");
        r0.append(leftPad(i.j, 8, ' '));
        r0.append(leftPad("FIB offset", 15, ' '));
        r0.append(leftPad("Offset", 8, ' '));
        r0.append(leftPad("Size", 8, ' '));
        r0.append('\n');
        int r4 = 0;
    L4:
        if (r4 >= (this._fields.length / 2)) goto L10;
        r0.append('\t');
        r0.append(leftPad(Integer.toString(r4), 8, ' '));
        int r5 = ((r4 * 4) * 2) + 154;
        r0.append(leftPad(Integer.toString(r5), 6, ' '));
        r0.append("   0x");
        r0.append(leftPad(Integer.toHexString(r5), 4, '0'));
        r0.append(leftPad(Integer.toString(getFieldOffset(r4)), 8, ' '));
        r0.append(leftPad(Integer.toString(getFieldSize(r4)), 8, ' '));
        UnhandledDataStructure r6 = (UnhandledDataStructure) ZeusTransformUtils.preCheckCast(this._unknownMap.get(Integer.valueOf(r4)), UnhandledDataStructure.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L8;
        r0.append(" => Unknown structure of size ");
        r0.append(r6.getBuf().length);
    L8:
        r0.append('\n');
        r4 = r4 + 1;
        goto L4
    L10:
        return r0.toString();
    }
}
