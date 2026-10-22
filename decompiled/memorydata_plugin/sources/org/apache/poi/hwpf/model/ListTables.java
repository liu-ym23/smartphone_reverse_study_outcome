package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Objects;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.model.types.LSTFAbstractType;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ListTables {
    private static final c LOGGER = null;
    private final LinkedHashMap<Integer, ListData> _listMap;
    private PlfLfo _plfLfo;

    static {
        LOGGER = b.a(ListTables.class);
    }

    public ListTables() {
        this._listMap = new LinkedHashMap();
    }

    public ListTables(byte[] r10, int r11, int r12, int r13) {
        this._listMap = new LinkedHashMap();
        short r0 = LittleEndian.getShort(r10, r11);
        int r14 = r11 + 2;
        int r1 = (LSTFAbstractType.getSize() * r0) + r14;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        ListData r4 = new ListData(r10, r14);
        this._listMap.put(Integer.valueOf(r4.getLsid()), r4);
        r14 = r14 + LSTFAbstractType.getSize();
        int r5 = r4.numLevels();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L7;
        ListLevel r7 = new ListLevel();
        r1 = r1 + r7.read(r10, r1);
        r4.setLevel(r6, r7);
        r6 = r6 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        this._plfLfo = new PlfLfo(r10, r12, r13);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (getClass() == r4.getClass()) goto L11;
        return false;
    L11:
        ListTables r5 = (ListTables) ZeusTransformUtils.preCheckCast(r4, ListTables.class, "com.obric.memorydata.plugin");
        if (this._listMap.equals(r5._listMap) == true) goto L15;
        return false;
    L15:
        return Objects.equals(this._plfLfo, r5._plfLfo);
    }

    public ListLevel getLevel(int r3, int r4) {
        ListData r2 = (ListData) ZeusTransformUtils.preCheckCast(this._listMap.get(Integer.valueOf(r3)), ListData.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        LOGGER.atWarn().a("ListData for {} was null.", v.a(r3));
        return null;
    L7:
        if (r4 < r2.numLevels()) goto L9;
        LOGGER.atWarn().a("Requested level {} which was greater than the maximum defined ({})", v.a(r4), v.a(r2.numLevels()));
        return null;
    L9:
        return r2.getLevels()[r4];
    }

    public LFO getLfo(int r1) {
        return this._plfLfo.getLfo(r1);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this._listMap, this._plfLfo});
    }
}
