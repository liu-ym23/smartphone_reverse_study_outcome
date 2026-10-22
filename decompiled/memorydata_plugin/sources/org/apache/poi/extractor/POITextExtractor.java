package org.apache.poi.extractor;

import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public interface POITextExtractor extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
        Closeable r0 = getFilesystem();
        if (isCloseFilesystem() == false) goto L7;
        if (r0 == null) goto L8;
        r0.close();
        return;
    L8:
        return;
    }

    Closeable getFilesystem();

    boolean isCloseFilesystem();
}
