package org.apache.poi;

import java.io.Closeable;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes4.dex */
public abstract class POIDocument implements Closeable {
    private static final c LOG = null;
    private DirectoryNode directory;

    static {
        LOG = b.a(POIDocument.class);
    }

    public POIDocument(DirectoryNode r1) {
        this.directory = r1;
    }

    public POIDocument(POIFSFileSystem r1) {
        this(r1.getRoot());
    }

    public void clearDirectory() {
        this.directory = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DirectoryNode r0 = this.directory;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getFileSystem() == null) goto L9;
        this.directory.getFileSystem().close();
        clearDirectory();
        return;
    }

    public DirectoryNode getDirectory() {
        return this.directory;
    }

    public EncryptionInfo getEncryptionInfo() {
        return null;
    }
}
