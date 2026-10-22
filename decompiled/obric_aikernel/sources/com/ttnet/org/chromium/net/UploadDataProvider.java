package com.ttnet.org.chromium.net;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UploadDataProvider implements Closeable {
    public UploadDataProvider() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public abstract long getLength();

    public abstract void read(UploadDataSink r10, ByteBuffer r11);

    public abstract void rewind(UploadDataSink r10);
}
