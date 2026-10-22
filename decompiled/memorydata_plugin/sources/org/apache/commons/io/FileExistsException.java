package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(File r3) {
        super("File " + r3 + " exists");
    }

    public FileExistsException(String r1) {
        super(r1);
    }
}
