package org.apache.commons.compress.archivers.sevenz;

/* JADX INFO: loaded from: classes6.dex */
class Archive {
    SevenZArchiveEntry[] files;
    Folder[] folders;
    long[] packCrcs;
    long packPos;
    long[] packSizes;
    StreamMap streamMap;

    private static String lengthOf(long[] r0) {
        if (r0 != null) goto L5;
        return "(null)";
    L5:
        return String.valueOf(r0.length);
    }

    private static String lengthOf(Object[] r0) {
        if (r0 != null) goto L5;
        return "(null)";
    L5:
        return String.valueOf(r0.length);
    }

    public String toString() {
        return "Archive with packed streams starting at offset " + this.packPos + ", " + lengthOf(this.packSizes) + " pack sizes, " + lengthOf(this.packCrcs) + " CRCs, " + lengthOf(this.folders) + " folders, " + lengthOf(this.files) + " files and " + this.streamMap;
    }
}
