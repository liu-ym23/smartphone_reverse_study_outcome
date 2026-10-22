package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class FontTable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private short _extraDataSz;
    private Ffn[] _fontNames;
    private short _stringCount;
    private int fcSttbfffn;
    private int lcbSttbfffn;

    static {
        LOG = b.a(FontTable.class);
    }

    public FontTable(byte[] r3, int r4, int r5) {
        this.lcbSttbfffn = r5;
        this.fcSttbfffn = r4;
        this._stringCount = LittleEndian.getShort(r3, r4);
        int r6 = r4 + 2;
        this._extraDataSz = LittleEndian.getShort(r3, r6);
        int r7 = r6 + 2;
        this._fontNames = new Ffn[this._stringCount];
        int r8 = 0;
    L4:
        if (r8 >= this._stringCount) goto L6;
        this._fontNames[r8] = new Ffn(r3, r7);
        r7 = r7 + this._fontNames[r8].getSize();
        r8 = r8 + 1;
        goto L4
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, FontTable.class) == true) goto L5;
        return false;
    L5:
        FontTable r6 = (FontTable) ZeusTransformUtils.preCheckCast(r5, FontTable.class, "com.obric.memorydata.plugin");
        if (r6._stringCount == this._stringCount) goto L8;
    L21:
        return false;
    L8:
        if (r6._extraDataSz != this._extraDataSz) goto L21;
        if (r6._fontNames.length != this._fontNames.length) goto L21;
        int r0 = 0;
    L13:
        Ffn[] r1 = r6._fontNames;
        if (r0 >= r1.length) goto L19;
        if (r1[r0].equals(this._fontNames[r0]) == false) goto L17;
        r0 = r0 + 1;
        goto L13
    L17:
        return false;
    L19:
        return true;
    }

    public int hashCode() {
        return 42;
    }
}
