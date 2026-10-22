package org.apache.poi.hwpf.sprm;

/* JADX INFO: loaded from: classes7.dex */
public final class SprmIterator {
    private byte[] _grpprl;
    int _offset;

    public SprmIterator(byte[] r1, int r2) {
        this._grpprl = r1;
        this._offset = r2;
    }

    public boolean hasNext() {
        if (this._offset < (this._grpprl.length - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public SprmOperation next() {
        SprmOperation r0 = new SprmOperation(this._grpprl, this._offset);
        this._offset += r0.size();
        return r0;
    }
}
