package org.apache.commons.io.monitor;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes6.dex */
public class FileEntry implements Serializable {
    static final FileEntry[] EMPTY_FILE_ENTRY_ARRAY = null;
    private static final long serialVersionUID = -2505664948818681153L;
    private FileEntry[] children;
    private boolean directory;
    private boolean exists;
    private final File file;
    private long lastModified;
    private long length;
    private String name;
    private final FileEntry parent;

    static {
        EMPTY_FILE_ENTRY_ARRAY = new FileEntry[0];
    }

    public FileEntry(File r2) {
        this(null, r2);
    }

    public FileEntry(FileEntry r1, File r2) {
        if (r2 == null) goto L7;
        this.file = r2;
        this.parent = r1;
        this.name = r2.getName();
        return;
    L7:
        throw new IllegalArgumentException("File is missing");
    }

    public FileEntry[] getChildren() {
        FileEntry[] r0 = this.children;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return EMPTY_FILE_ENTRY_ARRAY;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry r0 = this.parent;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File r2) {
        return new FileEntry(this, r2);
    }

    public boolean refresh(File r14) {
        boolean r0 = this.exists;
        long r1 = this.lastModified;
        boolean r3 = this.directory;
        long r4 = this.length;
        this.name = r14.getName();
        boolean r6 = Files.exists(r14.toPath(), new LinkOption[0]);
        this.exists = r6;
        if (r6 == true) goto L5;
    L7:
        boolean r7 = false;
    L8:
        this.directory = r7;
        long r9 = 0;
    L15:
        this.lastModified = 0;
    L17:
        if (this.exists == true) goto L19;
    L21:
        this.length = r9;
        if (this.exists != r0) goto L30;
        if (this.lastModified != r1) goto L30;
        if (this.directory != r3) goto L30;
        if (r9 != r4) goto L30;
        return false;
    L30:
        return true;
    L19:
        if (this.directory == true) goto L21;
        r9 = r14.length();
        goto L21
    L10:
        if (this.exists == false) goto L12;
        long r11 = FileUtils.lastModified(r14);     // Catch: IOException -> L15
    L13:
        this.lastModified = r11;     // Catch: IOException -> L15
        goto L17
    L12:
        r11 = 0;
        goto L13
    L5:
        if (r14.isDirectory() == false) goto L7;
        r7 = true;
        goto L8
    }

    public void setChildren(FileEntry... r1) {
        this.children = r1;
    }

    public void setDirectory(boolean r1) {
        this.directory = r1;
    }

    public void setExists(boolean r1) {
        this.exists = r1;
    }

    public void setLastModified(long r1) {
        this.lastModified = r1;
    }

    public void setLength(long r1) {
        this.length = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }
}
