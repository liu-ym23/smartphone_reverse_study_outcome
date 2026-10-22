package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Sets;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DummyTrackingInUseBitmapPool implements BitmapPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f8220a;

    public DummyTrackingInUseBitmapPool() {
        this.f8220a = Sets.a();
    }

    @Override // com.facebook.common.memory.Pool
    public final Object get(int r5) {
        Bitmap r10 = Bitmap.createBitmap(1, (int) Math.ceil(((double) r5) / 2.0d), Bitmap.Config.RGB_565);
        this.f8220a.add(r10);
        return r10;
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public final void release(Object r5) {
        Bitmap r10 = (Bitmap) r5;
        r10.getClass();
        this.f8220a.remove(r10);
        r10.recycle();
    }
}
