package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class ListData {
    private ListLevel[] _levels;
    private LSTF _lstf;

    ListData(byte[] r2, int r3) {
        LSTF r0 = new LSTF(r2, r3);
        this._lstf = r0;
        if (r0.isFSimpleList() == false) goto L5;
        this._levels = new ListLevel[1];
        return;
    L5:
        this._levels = new ListLevel[9];
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        ListData r6 = (ListData) ZeusTransformUtils.preCheckCast(r5, ListData.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(this._levels, r6._levels) == true) goto L14;
        return false;
    L14:
        LSTF r4 = this._lstf;
        if (r4 != null) goto L20;
        if (r6._lstf == null) goto L22;
        return false;
    L22:
        return true;
    L20:
        if (r4.equals(r6._lstf) == true) goto L22;
        return false;
    }

    public ListLevel[] getLevels() {
        return this._levels;
    }

    public int getLsid() {
        return this._lstf.getLsid();
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this._levels, this._lstf});
    }

    public int numLevels() {
        return this._levels.length;
    }

    public void setLevel(int r1, ListLevel r2) {
        this._levels[r1] = r2;
    }
}
