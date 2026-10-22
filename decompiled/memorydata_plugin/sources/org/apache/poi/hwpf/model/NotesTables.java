package org.apache.poi.hwpf.model;

import org.apache.poi.hwpf.model.types.FRDAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public class NotesTables {
    private PlexOfCps descriptors;
    private final NoteType noteType;
    private PlexOfCps textPositions;

    public NotesTables(NoteType r4) {
        this.descriptors = new PlexOfCps(FRDAbstractType.getSize());
        PlexOfCps r0 = new PlexOfCps(0);
        this.textPositions = r0;
        this.noteType = r4;
        r0.addProperty(new GenericPropertyNode(0, 1, new byte[0]));
    }

    public NotesTables(NoteType r3, byte[] r4, FileInformationBlock r5) {
        this.descriptors = new PlexOfCps(FRDAbstractType.getSize());
        this.textPositions = new PlexOfCps(0);
        this.noteType = r3;
        read(r4, r5);
    }

    private void read(byte[] r5, FileInformationBlock r6) {
        int r0 = r6.getNotesDescriptorsOffset(this.noteType);
        int r1 = r6.getNotesDescriptorsSize(this.noteType);
        if (r0 == 0) goto L6;
        if (r1 == 0) goto L6;
        this.descriptors = new PlexOfCps(r5, r0, r1, FRDAbstractType.getSize());
    L6:
        int r2 = r6.getNotesTextPositionsOffset(this.noteType);
        int r7 = r6.getNotesTextPositionsSize(this.noteType);
        if (r2 == 0) goto L11;
        if (r7 == 0) goto L12;
        this.textPositions = new PlexOfCps(r5, r2, r7, 0);
        return;
    L12:
        return;
    }
}
