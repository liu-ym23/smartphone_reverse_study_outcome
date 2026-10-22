package org.apache.commons.compress.archivers.sevenz;

/* JADX INFO: loaded from: classes6.dex */
class Folder {
    static final Folder[] EMPTY_FOLDER_ARRAY = null;
    BindPair[] bindPairs;
    Coder[] coders;
    long crc;
    boolean hasCrc;
    int numUnpackSubStreams;
    long[] packedStreams;
    long totalInputStreams;
    long totalOutputStreams;
    long[] unpackSizes;

    static {
        EMPTY_FOLDER_ARRAY = new Folder[0];
    }

    Folder() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Folder with ").append(this.coders.length).append(" coders, ").append(this.totalInputStreams).append(" input streams, ").append(this.totalOutputStreams).append(" output streams, ").append(this.bindPairs.length).append(" bind pairs, ").append(this.packedStreams.length).append(" packed streams, ").append(this.unpackSizes.length).append(" unpack sizes, ");
        if (this.hasCrc == false) goto L5;
        String r1 = "with CRC " + this.crc;
    L7:
        return r0.append(r1).append(" and ").append(this.numUnpackSubStreams).append(" unpack streams").toString();
    L5:
        r1 = "without CRC";
        goto L7
    }
}
