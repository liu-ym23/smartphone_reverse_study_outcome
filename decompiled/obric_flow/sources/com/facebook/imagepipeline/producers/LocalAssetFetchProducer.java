package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class LocalAssetFetchProducer extends LocalFetchProducer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AssetManager f8331c;

    public LocalAssetFetchProducer(ExecutorService r5, PooledByteBufferFactory r10, AssetManager r11) {
        super(r5, r10);
        this.f8331c = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.facebook.imagepipeline.producers.LocalAssetFetchProducer, com.facebook.imagepipeline.producers.LocalFetchProducer] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.facebook.imagepipeline.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage a(ImageRequest r5) {
        InputStream r10 = this.f8331c.open(r5.f8415b.getPath().substring(1), 2);
        AssetFileDescriptor r11 = null;
        ?? r12 = this.f8331c;     // Catch: Throwable -> L7 IOException -> L11
        r5 = r5.f8415b.getPath().substring(1);     // Catch: Throwable -> L7 IOException -> L11
        r11 = r12.openFd(r5);     // Catch: Throwable -> L7 IOException -> L11
        int r13 = (int) r11.getLength();
        r11.close();     // Catch: IOException -> L16
        r5 = r13;
    L18:
        goto L15
    L11:
        r5 = -1;
        r5 = -1;
        if (r11 == null) goto L15;
        r11.close();     // Catch: IOException -> L16
    L7:
        th = move-exception;
        if (r11 != null) goto L21;
    L10:
        throw th;
    L21:
        r11.close();     // Catch: IOException -> L17
    L15:
        return a(r10, r5);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String a() {
        return "LocalAssetFetchProducer";
    }
}
