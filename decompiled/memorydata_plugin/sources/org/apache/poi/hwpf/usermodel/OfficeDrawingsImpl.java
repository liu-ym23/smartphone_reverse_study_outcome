package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.FSPATable;
import org.apache.poi.hwpf.model.OfficeArtContent;

/* JADX INFO: loaded from: classes7.dex */
public class OfficeDrawingsImpl {
    private final FSPATable _fspaTable;
    private final byte[] _mainStream;
    private final OfficeArtContent officeArtContent;

    public OfficeDrawingsImpl(FSPATable r1, OfficeArtContent r2, byte[] r3) {
        this._fspaTable = r1;
        this.officeArtContent = r2;
        this._mainStream = r3;
    }
}
