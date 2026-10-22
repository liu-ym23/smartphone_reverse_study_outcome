package com.bytedance.crash.upload;

import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends GZIPOutputStream {
    public final void b() {
        super.close();
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void d() {
        super.finish();
    }

    @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
    public final void finish() {
    }
}
