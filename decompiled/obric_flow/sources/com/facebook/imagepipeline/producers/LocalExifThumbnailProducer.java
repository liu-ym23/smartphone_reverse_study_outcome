package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.media.ExifInterface;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.soloader.DoNotOptimize;
import java.io.FileDescriptor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f8334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f8335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f8336c;

    @DoNotOptimize
    public class Api24Utils {
        public static ExifInterface a(FileDescriptor r5) {
            return new ExifInterface(r5);
        }
    }

    public LocalExifThumbnailProducer(ExecutorService r5, PooledByteBufferFactory r10, ContentResolver r11) {
        this.f8334a = r5;
        this.f8335b = r10;
        this.f8336c = r11;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public final boolean a(ResizeOptions r5) {
        return ThumbnailSizeChecker.a(512, 512, r5);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(final Consumer r10, final ProducerContext r11) {
        BaseProducerContext r5 = (BaseProducerContext) r11;
        final InternalRequestListener r12 = r5.f8259c;
        final ImageRequest r13 = r5.f8257a;
        r5.a("local", "exif");
        final StatefulProducerRunnable<EncodedImage> r14 = new AnonymousClass1(this, r10, r12, r11, r13);
        r5.a(new AnonymousClass2(r14));
        this.f8334a.execute(r14);
    }
}
