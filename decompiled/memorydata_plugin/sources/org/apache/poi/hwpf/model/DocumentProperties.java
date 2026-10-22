package org.apache.poi.hwpf.model;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.types.DOPAbstractType;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class DocumentProperties extends DOPAbstractType {
    private byte[] _preserved;

    public DocumentProperties(byte[] r2, int r3, int r4) {
        super.fillFields(r2, r3);
        int r0 = DOPAbstractType.getSize();
        if (r4 == r0) goto L5;
        this._preserved = IOUtils.safelyClone(r2, r3 + r0, r4 - r0, HWPFDocument.getMaxRecordLength());
        return;
    L5:
        this._preserved = new byte[0];
    }
}
