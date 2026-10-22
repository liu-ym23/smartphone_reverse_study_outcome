package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m0 implements Postprocessor {
    public final List<Postprocessor> a;

    public final String getName() {
        StringBuilder r0 = new StringBuilder();
        Iterator<Postprocessor> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Postprocessor r2 = r1.next();
        if (r0.length() <= 0) goto L8;
        r0.append(",");
    L8:
        r0.append(r2.getName());
        goto L4
    L9:
        r0.insert(0, "MultiPostProcessor (");
        r0.append(")");
        return r0.toString();
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

    public m0(List<Postprocessor> r2) {
        this.a = new LinkedList(r2);
    }

    public final CloseableReference<Bitmap> process(Bitmap r6, PlatformBitmapFactory r7) {
        CloseableReference r0 = null;
        Iterator<Postprocessor> r1 = this.a.iterator();     // Catch: Throwable -> L14
        CloseableReference r2 = null;
    L5:
        if (r1.hasNext() == false) goto L11;
        Postprocessor r3 = r1.next();     // Catch: Throwable -> L14
        if (r2 == null) goto L9;
        Bitmap r4 = (Bitmap) r2.get();     // Catch: Throwable -> L14
    L10:
        r0 = r3.process(r4, r7);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r2);     // Catch: Throwable -> L14
        r2 = CloseableReference.cloneOrNull(r0);     // Catch: Throwable -> L14
        goto L5
    L9:
        r4 = r6;
        goto L10
    L11:
        CloseableReference<Bitmap> r8 = CloseableReference.cloneOrNull(r0);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r0);
        return r8;
    L14:
        th = move-exception;
        CloseableReference.closeSafely(r0);
        throw th;
    }
}
