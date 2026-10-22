package com.bytedance.android.ec.core.imagex.common;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q extends BasePostprocessor {
    public static final /* synthetic */ int b = 0;
    public final List<Postprocessor> a;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "SRPostProcessor";
    }

    public final CacheKey getPostprocessorCacheKey() {
        LinkedList r0 = new LinkedList();
        Iterator<Postprocessor> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.push(r1.next().getPostprocessorCacheKey());
        goto L4
    L7:
        return new MultiCacheKey(r0);
    }

    public q(List r10) {
        this.a = new LinkedList(r10);
    }

    public final CloseableReference<Bitmap> process(Bitmap r10, PlatformBitmapFactory r11) {
        Intrinsics.checkNotNullParameter(r10, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r11, "bitmapFactory");
        CloseableReference r0 = null;
        Iterator<Postprocessor> r1 = this.a.iterator();     // Catch: Throwable -> L14
        CloseableReference r12 = null;
    L5:
        if (r1.hasNext() == false) goto L11;
        Postprocessor r13 = r1.next();     // Catch: Throwable -> L14
        if (r12 == null) goto L9;
        Bitmap r14 = (Bitmap) r12.get();     // Catch: Throwable -> L14
    L10:
        r0 = r13.process(r14, r11);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r12);     // Catch: Throwable -> L14
        r12 = CloseableReference.cloneOrNull(r0);     // Catch: Throwable -> L14
        goto L5
    L9:
        r14 = r10;
        goto L10
    L11:
        CloseableReference<Bitmap> r15 = CloseableReference.cloneOrNull(r0);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r0);
        return r15;
    L14:
        th = move-exception;
        CloseableReference.closeSafely(r0);
        throw th;
    }

    public final CloseableReference<Bitmap> process(Bitmap r10, PlatformBitmapFactory r11, Map<String, String> r12) {
        CloseableReference r0 = null;
        Iterator<Postprocessor> r1 = this.a.iterator();     // Catch: Throwable -> L20
        CloseableReference r13 = null;
    L5:
        if (r1.hasNext() == false) goto L17;
        BasePostprocessor r14 = (Postprocessor) r1.next();     // Catch: Throwable -> L20
        if (r13 == null) goto L9;
        Bitmap r15 = (Bitmap) r13.get();     // Catch: Throwable -> L20
    L11:
        if ((r14 instanceof BasePostprocessor) == true) goto L13;
    L15:
        r0 = r14.process(r15, r11);     // Catch: Throwable -> L20
    L16:
        CloseableReference.closeSafely(r13);     // Catch: Throwable -> L20
        r13 = CloseableReference.cloneOrNull(r0);     // Catch: Throwable -> L20
        goto L5
    L13:
        if (StringsKt.equals("SRPostProcessor", r14.getName(), true) == false) goto L15;
        r0 = r14.process(r15, r11, r12);     // Catch: Throwable -> L20
        goto L16
    L9:
        r15 = r10;
        goto L11
    L17:
        CloseableReference<Bitmap> r16 = CloseableReference.cloneOrNull(r0);     // Catch: Throwable -> L20
        CloseableReference.closeSafely(r0);
        return r16;
    L20:
        th = move-exception;
        CloseableReference.closeSafely(r0);
        throw th;
    }
}
