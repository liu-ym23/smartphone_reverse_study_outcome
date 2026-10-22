package com.facebook.common.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FileUtils {

    public static class CreateDirectoryException extends IOException {
        public CreateDirectoryException(String r5) {
            super(r5);
        }

        public CreateDirectoryException(String r5, FileDeleteException r10) {
            super(r5);
            initCause(r10);
        }
    }

    public static class FileDeleteException extends IOException {
        public FileDeleteException(String r5) {
            super(r5);
        }
    }

    public static class ParentDirNotFoundException extends FileNotFoundException {
        public ParentDirNotFoundException(String r5) {
            super(r5);
        }
    }

    public static class RenameException extends IOException {
        public RenameException(String r5, IOException r10) {
            super(r5);
            initCause(r10);
        }
    }

    public static void a(File r5) {
        if (r5.exists() == false) goto L13;
        if (r5.isDirectory() == false) goto L8;
        return;
    L8:
        if (r5.delete() == true) goto L13;
        throw new CreateDirectoryException(r5.getAbsolutePath(), new FileDeleteException(r5.getAbsolutePath()));
    L13:
        if (r5.mkdirs() == false) goto L15;
        return;
    L15:
        if (r5.isDirectory() == false) goto L18;
        return;
    L18:
        throw new CreateDirectoryException(r5.getAbsolutePath());
    }

    public static void a(File r5, File r10) {
        r5.getClass();
        r10.delete();
        if (r5.renameTo(r10) == false) goto L6;
        return;
    L6:
        if (r10.exists() == false) goto L8;
        IOException r11 = new FileDeleteException(r10.getAbsolutePath());
    L16:
        throw new RenameException("Unknown error renaming " + r5.getAbsolutePath() + " to " + r10.getAbsolutePath(), r11);
    L8:
        if (r5.getParentFile().exists() == true) goto L10;
        r11 = new ParentDirNotFoundException(r5.getAbsolutePath());
        goto L16
    L10:
        if (r5.exists() == true) goto L12;
        r11 = new FileNotFoundException(r5.getAbsolutePath());
        goto L16
    L12:
        r11 = null;
        goto L16
    }
}
