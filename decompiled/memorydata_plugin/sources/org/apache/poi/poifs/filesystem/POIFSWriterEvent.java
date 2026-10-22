package org.apache.poi.poifs.filesystem;

/* JADX INFO: loaded from: classes7.dex */
public class POIFSWriterEvent {
    private String documentName;
    private int limit;
    private POIFSDocumentPath path;
    private DocumentOutputStream stream;

    POIFSWriterEvent(DocumentOutputStream r1, POIFSDocumentPath r2, String r3, int r4) {
        this.stream = r1;
        this.path = r2;
        this.documentName = r3;
        this.limit = r4;
    }

    public DocumentOutputStream getStream() {
        return this.stream;
    }
}
