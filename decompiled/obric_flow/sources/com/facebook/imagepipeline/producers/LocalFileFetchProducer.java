package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class LocalFileFetchProducer extends LocalFetchProducer {
    public LocalFileFetchProducer(ExecutorService r5, PooledByteBufferFactory r10) {
        super(r5, r10);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage a(ImageRequest r5) {
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r5.d != null) goto L9;
        r5.d = new File(r5.f8415b.getPath());     // Catch: Throwable -> L7
    L9:
        File r10 = r5.d;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return a(new FileInputStream(r10.toString()), (int) r5.a().length());
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String a() {
        return "LocalFileFetchProducer";
    }
}
