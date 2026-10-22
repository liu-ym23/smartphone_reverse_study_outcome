package org.apache.commons.compress.archivers.dump;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class DumpArchiveException extends IOException {
    private static final long serialVersionUID = 1;

    public DumpArchiveException() {
    }

    public DumpArchiveException(String r1) {
        super(r1);
    }

    public DumpArchiveException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }

    public DumpArchiveException(Throwable r1) {
        initCause(r1);
    }
}
