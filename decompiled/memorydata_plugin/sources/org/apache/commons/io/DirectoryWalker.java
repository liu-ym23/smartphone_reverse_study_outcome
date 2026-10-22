package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class DirectoryWalker<T> {

    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File r2, int r3) {
            this("Operation Cancelled", r2, r3);
        }

        public CancelException(String r1, File r2, int r3) {
            super(r1);
            this.file = r2;
            this.depth = r3;
        }

        public int getDepth() {
            return this.depth;
        }

        public File getFile() {
            return this.file;
        }
    }
}
