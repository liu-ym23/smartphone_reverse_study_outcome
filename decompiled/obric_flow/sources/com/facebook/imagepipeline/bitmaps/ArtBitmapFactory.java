package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class ArtBitmapFactory extends PlatformBitmapFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapPool f7981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CloseableReferenceFactory f7982b;

    public ArtBitmapFactory(BitmapPool r5, CloseableReferenceFactory r10) {
        this.f7981a = r5;
        this.f7982b = r10;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public final CloseableReference a(int r5, int r10, Bitmap.Config r11) {
        int r12 = r5 * r10;
        int r13 = BitmapUtil.a(r11) * r12;
        Bitmap r14 = (Bitmap) this.f7981a.get(r13);
        if (r14.getAllocationByteCount() < (BitmapUtil.a(r11) * r12)) goto L7;
        r14.reconfigure(r5, r10, r11);
        CloseableReferenceFactory r15 = this.f7982b;
        return CloseableReference.a(r14, this.f7981a, r15.f8057a);
    L7:
        throw new IllegalArgumentException();
    }
}
