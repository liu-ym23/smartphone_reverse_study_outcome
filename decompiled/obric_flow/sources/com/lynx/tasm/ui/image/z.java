package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.lynx.base.log.LynxLog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends no.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f11149o;

    public z(String r5, int r10, int r11, int r12, int r13, int r14, int r15, float[] r16, ScalingUtils.ScaleType r17, String r18, String r19, Bitmap.Config r110, boolean r111) {
        super(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111);
        this.f11149o = r5;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference a(Bitmap r10, PlatformBitmapFactory r11) {
        ConcurrentHashMap r5 = a0.f10992m0;
        if (r5.containsKey(this.f11149o) == true) goto L5;
        r5.put(this.f11149o, new m(r10.getWidth(), r10.getHeight()));
    L5:
        Bitmap.Config r12 = this.f20289n;
        if (r12 != null) goto L9;
        r12 = r10.getConfig();
    L9:
        CloseableReference r13 = null;
        int r14 = this.f20282c;     // Catch: Throwable -> L33
        int r15 = this.d;     // Catch: Throwable -> L33
        if (r12 != null) goto L14;
        r12 = BasePostprocessor.f8412a;     // Catch: Throwable -> L33
    L14:
        CloseableReference r16 = r11.a(r14, r15, r12);     // Catch: Throwable -> L33
    L22:
        th = th;
    L43:
        LynxLog.b(4, "BaseRoundedCornerPostprocessor", "process image error " + th.getMessage());     // Catch: Throwable -> L39
        if (r16 == null) goto L38;
        r16.close();
    L38:
        return null;
    L39:
        th = move-exception;
        if (r16 == null) goto L42;
        r16.close();
    L42:
        throw th;
    L16:
        if (this.f20287l != null) goto L27;
        LynxLog.b(2, "Lynx Image Processor", "process image from Fresco without cap-insets");     // Catch: Throwable -> L22
        monitor-enter(r16);     // Catch: Throwable -> L22
        Object r17 = r16.f7671b.d();     // Catch: Throwable -> L24
        monitor-exit(r16);     // Catch: Throwable -> L24
        c((Bitmap) r17, r10);     // Catch: Throwable -> L22
    L28:
        if (r16 == null) goto L30;
        r13 = r16.b();     // Catch: Throwable -> L22
    L30:
        if (r16 == null) goto L32;
        r16.close();
    L32:
        return r13;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L27:
        LynxLog.b(2, "Lynx Image Processor", "process image from Fresco with cap-insets");     // Catch: Throwable -> L22
        d((Bitmap) r16.c(), r10);     // Catch: Throwable -> L22
    L33:
        th = th;
        r16 = null;
        goto L43
    }
}
