package org.apache.commons.compress.archivers;

/* JADX INFO: loaded from: classes6.dex */
public class ArchiveException extends Exception {
    private static final long serialVersionUID = 2772690708123267100L;

    public ArchiveException(String r1) {
        super(r1);
    }

    public ArchiveException(String r1, Exception r2) {
        super(r1);
        initCause(r2);
    }
}
