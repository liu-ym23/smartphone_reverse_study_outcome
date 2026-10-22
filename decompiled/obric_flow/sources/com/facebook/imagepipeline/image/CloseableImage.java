package com.facebook.imagepipeline.image;

import android.util.Log;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.imageformat.ImageFormat;
import java.io.Closeable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CloseableImage implements Closeable, ImageInfo, HasImageMetadata, MemoryCacheHitTracker {
    public static final String[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageFormat f8168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f8169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8170c;
    public boolean d;

    static {
        e = new String[]{"encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config"};
    }

    public CloseableImage() {
        this.f8169b = new HashMap();
        this.f8170c = false;
        this.d = false;
    }

    public final void a(HashMap r10) {
        if (r10 == null) goto L12;
        String[] r5 = e;
        int r11 = 0;
    L6:
        if (r11 >= 6) goto L16;
        String r12 = r5[r11];
        Object r13 = r10.get(r12);
        if (r13 == null) goto L11;
        this.f8169b.put(r12, r13);
    L11:
        r11 = r11 + 1;
        goto L6
    L16:
        return;
    }

    public abstract boolean a();

    @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
    public final void b() {
        this.d = true;
        this.f8170c = false;
    }

    public QualityInfo c() {
        return ImmutableQualityInfo.d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract int d();

    public final void finalize() {
        if (a() == false) goto L5;
        return;
    L5:
        String r5 = getClass().getSimpleName();
        Integer r10 = Integer.valueOf(System.identityHashCode(this));
        if (FLogDefaultLoggingDelegate.f7658a.a(3) == false) goto L14;
        String r11 = String.format(null, "finalize: %s %x still open.", new Object[]{r5, r10});
        Log.println(3, FLogDefaultLoggingDelegate.a("CloseableImage"), r11);
    L14:
        close();     // Catch: Throwable -> L11
        super.finalize();
        return;
    L11:
        th = move-exception;
        super.finalize();
        throw th;
    }
}
