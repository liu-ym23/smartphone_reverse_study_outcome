package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class VersionSafeCallbacks$UploadDataProviderWrapper extends UploadDataProvider {
    private final UploadDataProvider mWrappedProvider;

    @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mWrappedProvider.close();
    }

    @Override // com.ttnet.org.chromium.net.UploadDataProvider
    public long getLength() throws IOException {
        return this.mWrappedProvider.getLength();
    }

    public VersionSafeCallbacks$UploadDataProviderWrapper(UploadDataProvider r1) {
        this.mWrappedProvider = r1;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataProvider
    public void rewind(UploadDataSink r2) throws IOException {
        this.mWrappedProvider.rewind(r2);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataProvider
    public void read(UploadDataSink r2, ByteBuffer r3) throws IOException {
        this.mWrappedProvider.read(r2, r3);
    }
}
