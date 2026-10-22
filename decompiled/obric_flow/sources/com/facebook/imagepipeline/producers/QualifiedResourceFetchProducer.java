package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class QualifiedResourceFetchProducer extends LocalFetchProducer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f8379c;

    public QualifiedResourceFetchProducer(ExecutorService r5, PooledByteBufferFactory r10, ContentResolver r11) {
        super(r5, r10);
        this.f8379c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String a() {
        return "QualifiedResourceFetchProducer";
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage a(ImageRequest r5) {
        Uri r10 = r5.f8415b;
        return a(this.f8379c.openInputStream(r10), -1);
    }
}
