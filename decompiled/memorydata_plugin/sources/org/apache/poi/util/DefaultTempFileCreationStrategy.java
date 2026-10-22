package org.apache.poi.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultTempFileCreationStrategy implements TempFileCreationStrategy {
    private File dir;

    public DefaultTempFileCreationStrategy() {
        this(null);
    }

    public DefaultTempFileCreationStrategy(File r1) {
        this.dir = r1;
    }

    private void createPOIFilesDirectory() {
        if (this.dir != null) goto L9;
        String r0 = System.getProperty("java.io.tmpdir");
        if (r0 == null) goto L8;
        this.dir = new File(r0, "poifiles");
        goto L9
    L8:
        throw new IOException("Systems temporary directory not defined - set the -Djava.io.tmpdir jvm property!");
    L9:
        createTempDirectory(this.dir);
    }

    private synchronized void createTempDirectory(File r4) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (r4.exists() == false) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L18;
        if (r4.isDirectory() == false) goto L16;
        monitor-exit(this);
        return;
    L16:
        throw new IOException("Could not create temporary directory. '" + r4 + "' exists but is not a directory.");     // Catch: Throwable -> L19
    L18:
        throw new IOException("Could not create temporary directory '" + r4 + "'");     // Catch: Throwable -> L19
    L6:
        if (r4.mkdirs() == true) goto L9;
        r0 = false;
        goto L10
    }

    @Override // org.apache.poi.util.TempFileCreationStrategy
    public File createTempFile(String r2, String r3) {
        createPOIFilesDirectory();
        File r1 = Files.createTempFile(this.dir.toPath(), r2, r3, new FileAttribute[0]).toFile();
        if (System.getProperty("poi.delete.tmp.files.on.exit") == null) goto L5;
        r1.deleteOnExit();
    L5:
        return r1;
    }
}
