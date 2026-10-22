package com.lynx.tasm.ui.image;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n0 extends DraweeHolder<GenericDraweeHierarchy> {
    public static final Drawable e = null;
    public final CloseableReference<CloseableImage> a;
    public final Drawable b;
    public final Handler c;
    public final ForwardingDrawable d;

    public class a implements Runnable {
        public final /* synthetic */ n0 a;

        @Override // java.lang.Runnable
        public final void run() {
            CloseableReference.closeSafely(this.a.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(n0 r1) {
            this.a = r1;
        }
    }

    public final void onAttach() {
    }

    static {
        e = new ColorDrawable();
    }

    public final void onDetach() {
        this.d.setDrawable(e);
        this.c.post(new a(this));
    }

    public final Drawable getTopLevelDrawable() {
        return this.d;
    }

    public n0(CloseableReference<CloseableImage> r3) {
        super(null);
        this.c = new Handler(Looper.getMainLooper());
        this.a = r3;
        CloseableStaticBitmap r4 = (CloseableStaticBitmap) r3.get();
        BitmapDrawable r0 = new BitmapDrawable(LynxEnv.inst().getAppContext().getResources(), r4.getUnderlyingBitmap());
        this.b = r0;
        this.d = new ForwardingDrawable(r0);
    }
}
