package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public BucketsBitmapPool(NoOpMemoryTrimmableRegistry r5, PoolParams r10, NoOpPoolStatsTracker r11) {
        super(r5, r10, r11);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final void a(Object r5) {
        Bitmap r10 = (Bitmap) r5;
        r10.getClass();
        r10.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int b(Object r5) {
        Bitmap r10 = (Bitmap) r5;
        r10.getClass();
        return r10.getAllocationByteCount();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final boolean c(Object r5) {
        Bitmap r10 = (Bitmap) r5;
        r10.getClass();
        if (r10.isRecycled() == false) goto L5;
        return false;
    L5:
        if (r10.isMutable() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int e(int r5) {
        return r5;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int f(int r5) {
        return r5;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object a(int r5) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) r5) / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object a(Bucket r5) {
        monitor-enter(this);
        Object r10 = r5.a();     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        r5.d++;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L11:
        Bitmap r11 = (Bitmap) r10;
        if (r11 == null) goto L14;
        r11.eraseColor(0);
    L14:
        return r11;
    L10:
        monitor-exit(this);
    L8:
        th = move-exception;
        throw th;
    }
}
