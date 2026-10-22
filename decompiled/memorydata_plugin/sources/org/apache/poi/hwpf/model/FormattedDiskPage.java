package org.apache.poi.hwpf.model;

import androidx.core.app.FrameMetricsAggregator;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FormattedDiskPage {
    protected int _crun;
    protected byte[] _fkp;
    protected int _offset;

    public FormattedDiskPage() {
    }

    public FormattedDiskPage(byte[] r2, int r3) {
        this._crun = LittleEndian.getUByte(r2, r3 + FrameMetricsAggregator.EVERY_DURATION);
        this._fkp = r2;
        this._offset = r3;
    }

    public int getEnd(int r2) {
        return LittleEndian.getInt(this._fkp, this._offset + ((r2 + 1) * 4));
    }

    public int getStart(int r2) {
        return LittleEndian.getInt(this._fkp, this._offset + (r2 * 4));
    }
}
