package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class CloseShieldFilterInputStream extends FilterInputStream {
    public CloseShieldFilterInputStream(InputStream r1) {
        super(r1);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
