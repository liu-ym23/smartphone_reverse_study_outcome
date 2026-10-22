package com.lynx.tasm.ui.image;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.lynx.tasm.LynxEnv;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 extends DraweeHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ColorDrawable f11027k = null;
    public final CloseableReference g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BitmapDrawable f11028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f11029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ForwardingDrawable f11030j;

    static {
        f11027k = new ColorDrawable();
    }

    public b1(CloseableReference r5) {
        super(null);
        this.f11029i = new Handler(Looper.getMainLooper());
        this.g = r5;
        monitor-enter(r5);
        Object r10 = r5.f7671b.d();     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        BitmapDrawable r11 = new BitmapDrawable(LynxEnv.inst().getAppContext().getResources(), ((CloseableStaticBitmap) r10).g);
        this.f11028h = r11;
        this.f11030j = new ForwardingDrawable(r11);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.view.DraweeHolder
    public final Drawable d() {
        return this.f11030j;
    }

    @Override // com.facebook.drawee.view.DraweeHolder
    public final void f() {
    }

    @Override // com.facebook.drawee.view.DraweeHolder
    public final void g() {
        this.f11030j.b(f11027k);
        this.f11029i.post(new h(this, 6));
    }
}
