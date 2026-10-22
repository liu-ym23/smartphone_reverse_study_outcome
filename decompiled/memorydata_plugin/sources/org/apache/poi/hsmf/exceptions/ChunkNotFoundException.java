package org.apache.poi.hsmf.exceptions;

/* JADX INFO: loaded from: classes7.dex */
public final class ChunkNotFoundException extends Exception {
    private static final long serialVersionUID = 1;

    public ChunkNotFoundException() {
        super("Chunk not found");
    }

    public ChunkNotFoundException(String r2) {
        super(r2 + " was named, but not found in POIFS object");
    }
}
