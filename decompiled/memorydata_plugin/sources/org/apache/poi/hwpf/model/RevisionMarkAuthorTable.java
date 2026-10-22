package org.apache.poi.hwpf.model;

/* JADX INFO: loaded from: classes7.dex */
public final class RevisionMarkAuthorTable {
    private String[] entries;

    public RevisionMarkAuthorTable(byte[] r1, int r2, int r3) {
        this.entries = SttbUtils.readSttbfRMark(r1, r2);
    }
}
