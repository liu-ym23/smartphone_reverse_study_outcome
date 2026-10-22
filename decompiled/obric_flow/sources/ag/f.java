package ag;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.tasm.utils.BlurUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Postprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f168b;

    public f(ArrayList r5, Bitmap.Config r10) {
        this.f168b = r10;
        this.f167a = r5;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference a(Bitmap r10, PlatformBitmapFactory r11) {
        CloseableReference r5 = null;
        Iterator r12 = this.f167a.iterator();     // Catch: Throwable -> L39
        CloseableReference r13 = null;
        CloseableReference r14 = null;
    L47:
    L22:
        th = th;
        r5 = r13;
    L40:
        if (r5 == null) goto L42;
        r5.close();
    L42:
        throw th;
    L6:
        if (r12.hasNext() == false) goto L34;
        xn.b r15 = (xn.b) r12.next();     // Catch: Throwable -> L22
        Bitmap.Config r16 = this.f168b;     // Catch: Throwable -> L22
        if (r16 != null) goto L11;
        r16 = r10.getConfig();     // Catch: Throwable -> L22
    L11:
        int r17 = r10.getWidth();     // Catch: Throwable -> L22
        int r18 = r10.getHeight();     // Catch: Throwable -> L22
        if (r16 != null) goto L15;
        r16 = BasePostprocessor.f8412a;     // Catch: Throwable -> L22
    L15:
        r13 = r11.a(r17, r18, r16);     // Catch: Throwable -> L22
        monitor-enter(r13);     // Catch: Throwable -> L22
        Object r19 = r13.f7671b.d();     // Catch: Throwable -> L31
        monitor-exit(r13);     // Catch: Throwable -> L31
    L20:
        if (((Bitmap) r19).getConfig() != r10.getConfig()) goto L24;
        Bitmaps.copyBitmap((Bitmap) r13.c(), r10);     // Catch: Throwable -> L22
    L25:
        if (r14 == null) goto L27;
        Bitmap r20 = (Bitmap) r14.c();     // Catch: Throwable -> L22
    L27:
        BlurUtils.iterativeBoxBlur((Bitmap) r13.c(), r15.f23177a);     // Catch: Throwable -> L22
        if (r14 == null) goto L30;
        r14.close();     // Catch: Throwable -> L22
    L30:
        r14 = r13.b();     // Catch: Throwable -> L22
        goto L47
    L24:
        new Canvas((Bitmap) r13.c()).drawBitmap(r10, 0.0f, 0.0f, null);     // Catch: Throwable -> L22
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L34:
        if (r13 == null) goto L36;
        r5 = r13.b();     // Catch: Throwable -> L22
    L36:
        if (r13 == null) goto L38;
        r13.close();
    L38:
        return r5;
    L39:
        th = th;
        goto L40
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        StringBuilder r5 = new StringBuilder();
        Iterator r10 = this.f167a.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        xn.b r11 = (xn.b) r10.next();
        if (r5.length() <= 0) goto L8;
        r5.append(",");
    L8:
        r5.append(r11.getClass().getSimpleName());
        goto L4
    L9:
        r5.insert(0, "MultiPostProcessor (");
        r5.append(")");
        return r5.toString();
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        LinkedList r5 = new LinkedList();
        Iterator r10 = this.f167a.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        xn.b r11 = (xn.b) r10.next();
        if (r11.f23178b != null) goto L8;
        r11.f23178b = String.valueOf(r11.f23177a);
    L8:
        r5.push(new SimpleCacheKey(r11.f23178b));
        goto L4
    L10:
        return new MultiCacheKey(r5);
    }
}
