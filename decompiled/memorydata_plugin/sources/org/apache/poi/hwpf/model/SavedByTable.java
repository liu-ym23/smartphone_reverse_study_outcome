package org.apache.poi.hwpf.model;

/* JADX INFO: loaded from: classes7.dex */
public final class SavedByTable {
    private SavedByEntry[] entries;

    public SavedByTable(byte[] r5, int r6, int r7) {
        String[] r8 = SttbUtils.readSttbSavedBy(r5, r6);
        int r9 = r8.length / 2;
        this.entries = new SavedByEntry[r9];
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L5;
        int r2 = r10 * 2;
        this.entries[r10] = new SavedByEntry(r8[r2], r8[r2 + 1]);
        r10 = r10 + 1;
        goto L3
    }
}
