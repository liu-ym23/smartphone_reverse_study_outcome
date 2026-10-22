package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 implements Postprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f11023a;

    public a1(LinkedList r5) {
        this.f11023a = new LinkedList(r5);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        LinkedList r5 = new LinkedList();
        Iterator r10 = this.f11023a.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r5.push(((Postprocessor) r10.next()).a());
        goto L4
    L7:
        return new MultiCacheKey(r5);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        StringBuilder r5 = new StringBuilder();
        Iterator r10 = this.f11023a.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Postprocessor r11 = (Postprocessor) r10.next();
        if (r5.length() <= 0) goto L8;
        r5.append(",");
    L8:
        r5.append(r11.getName());
        goto L4
    L9:
        r5.insert(0, "MultiPostProcessor (");
        r5.append(")");
        return r5.toString();
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference a(Bitmap r10, PlatformBitmapFactory r11) {
        CloseableReference r5 = null;
        Iterator r12 = this.f11023a.iterator();     // Catch: Throwable -> L30
        CloseableReference r13 = null;
        CloseableReference r14 = null;
    L34:
    L13:
        th = th;
        r5 = r13;
    L31:
        if (r5 == null) goto L33;
        r5.close();
    L33:
        throw th;
    L6:
        if (r12.hasNext() == false) goto L25;
        Postprocessor r15 = (Postprocessor) r12.next();     // Catch: Throwable -> L13
        if (r14 == null) goto L18;
        monitor-enter(r14);     // Catch: Throwable -> L13
        Object r16 = r14.f7671b.d();     // Catch: Throwable -> L15
        monitor-exit(r14);     // Catch: Throwable -> L15
        Bitmap r17 = (Bitmap) r16;     // Catch: Throwable -> L13
    L19:
        r13 = r15.a(r17, r11);     // Catch: Throwable -> L13
        if (r14 == null) goto L22;
        r14.close();     // Catch: Throwable -> L13
    L22:
        if (r13 != null) goto L23;
        r14 = null;
        goto L34
    L23:
        r14 = r13.b();     // Catch: Throwable -> L13
        goto L34
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L18:
        r17 = r10;
        goto L19
    L25:
        if (r13 == null) goto L27;
        r5 = r13.b();     // Catch: Throwable -> L13
    L27:
        if (r13 == null) goto L29;
        r13.close();
    L29:
        return r5;
    L30:
        th = th;
        goto L31
    }
}
