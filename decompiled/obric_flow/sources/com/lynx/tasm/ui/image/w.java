package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements com.lynx.tasm.behavior.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11142c;
    public final /* synthetic */ long d;
    public final /* synthetic */ a0 e;

    public w(a0 r5, String r10, int r11, int r12, long r13) {
        this.e = r5;
        this.f11140a = r10;
        this.f11141b = r11;
        this.f11142c = r12;
        this.d = r13;
    }

    public final void a(Object r5) {
    L7:
        th = move-exception;
        a0.k(this.e);
        th.printStackTrace();
        return;
    L4:
        if ((r5 instanceof CloseableReference) == true) goto L9;
        a0.k(this.e);     // Catch: Throwable -> L7
        LynxLog.b(3, "ImageDelegate", "localCache image is not CloseableReference and the url is: " + this.f11140a);     // Catch: Throwable -> L7
        return;
    L9:
        CloseableReference r10 = (CloseableReference) r5;     // Catch: Throwable -> L7
        monitor-enter(r10);     // Catch: Throwable -> L7
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L25
        monitor-exit(r10);     // Catch: Throwable -> L25
    L14:
        if ((r11 instanceof Bitmap) == false) goto L16;
    L19:
        v r12 = new v(0, this, r5);     // Catch: Throwable -> L7
        if (Looper.myLooper() != Looper.getMainLooper()) goto L23;
        r12.run();     // Catch: Throwable -> L7
        return;
    L23:
        new Handler(Looper.getMainLooper()).post(r12);     // Catch: Throwable -> L7
        return;
    L16:
        if ((r11 instanceof CloseableBitmap) == true) goto L19;
        a0.k(this.e);     // Catch: Throwable -> L7
        LynxLog.b(3, "ImageDelegate", "localCache cannot get bitmap and the url is: " + this.f11140a);     // Catch: Throwable -> L7
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    }
}
