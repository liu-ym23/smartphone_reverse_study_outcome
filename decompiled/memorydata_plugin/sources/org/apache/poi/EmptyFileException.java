package org.apache.poi;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class EmptyFileException extends IllegalArgumentException {
    private static final long serialVersionUID = 1536449292174360166L;

    public EmptyFileException() {
        super("The supplied file was empty (zero bytes long)");
    }

    public EmptyFileException(File r3) {
        if (r3.exists() == false) goto L5;
        StringBuilder r4 = new StringBuilder().append("The supplied file '").append(r3.getAbsolutePath());
        String r0 = "' was empty (zero bytes long)";
    L6:
        super(r4.append(r0).toString());
        return;
    L5:
        r4 = new StringBuilder().append("The file '").append(r3.getAbsolutePath());
        r0 = "' does not exist";
        goto L6
    }
}
