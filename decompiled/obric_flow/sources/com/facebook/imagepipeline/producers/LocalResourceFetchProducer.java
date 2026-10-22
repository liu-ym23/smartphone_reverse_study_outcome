package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class LocalResourceFetchProducer extends LocalFetchProducer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Resources f8343c;

    public LocalResourceFetchProducer(ExecutorService r5, PooledByteBufferFactory r10, Resources r11) {
        super(r5, r10);
        this.f8343c = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.facebook.imagepipeline.producers.LocalFetchProducer, com.facebook.imagepipeline.producers.LocalResourceFetchProducer] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.facebook.imagepipeline.request.ImageRequest] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage a(ImageRequest r5) {
        InputStream r10 = this.f8343c.openRawResource(Integer.parseInt(r5.f8415b.getPath().substring(1)));
        AssetFileDescriptor r11 = null;
        ?? r12 = this.f8343c;     // Catch: Throwable -> L7 Resources.NotFoundException -> L11
        r5 = Integer.parseInt(r5.f8415b.getPath().substring(1));     // Catch: Throwable -> L7 Resources.NotFoundException -> L11
        r11 = r12.openRawResourceFd(r5);     // Catch: Throwable -> L7 Resources.NotFoundException -> L11
        int r13 = (int) r11.getLength();
        r11.close();     // Catch: IOException -> L16
        r5 = r13;
    L20:
        goto L15
    L11:
        r5 = -1;
        r5 = -1;
        if (r11 == null) goto L15;
        r11.close();     // Catch: IOException -> L16
    L7:
        th = move-exception;
        if (r11 != null) goto L18;
    L10:
        throw th;
    L18:
        r11.close();     // Catch: IOException -> L17
    L15:
        return a(r10, r5);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String a() {
        return "LocalResourceFetchProducer";
    }
}
