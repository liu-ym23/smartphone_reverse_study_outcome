package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements com.lynx.tasm.behavior.m.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ h e;

    public class a implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ i b;

        public final void a() {
            i r0 = this.b;
            m8a.g r1 = r0.e.x;
            if (r1 != null) goto L5;
        L9:
            h.b(this.b.e);
            LLog.w("ImageDelegate", "localCache url check error: " + this.b.a);
            return;
        L5:
            if (r0.a.equals(r1.b) == false) goto L9;
            long r7 = System.currentTimeMillis();
            i r2 = this.b;
            int r10 = r2.e.c(r2.b, r2.c);
            i r3 = this.b;
            h r4 = r3.e;
            r4.l(r4.v, true, true, r3.d, r7, 0, r10);
            this.b.e.A.f((CloseableReference) this.a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(i r1, Object r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // com.lynx.tasm.behavior.m.a
    public final void a(Object r4, Throwable r5) {
    L19:
        th = move-exception;
        h.b(this.e);
        th.printStackTrace();
        return;
    L5:
        if ((r4 instanceof CloseableReference) == true) goto L8;
        h.b(this.e);     // Catch: Throwable -> L19
        LLog.w("ImageDelegate", "localCache image is not CloseableReference and the url is: " + this.a);     // Catch: Throwable -> L19
        return;
    L8:
        Object r0 = ((CloseableReference) r4).get();     // Catch: Throwable -> L19
        if ((r0 instanceof Bitmap) == false) goto L11;
    L14:
        a r6 = new a(this, r4);     // Catch: Throwable -> L19
        if (Looper.myLooper() != Looper.getMainLooper()) goto L17;
        r6.run();     // Catch: Throwable -> L19
        return;
    L17:
        new Handler(Looper.getMainLooper()).post(r6);     // Catch: Throwable -> L19
        return;
    L11:
        if ((r0 instanceof CloseableBitmap) == true) goto L14;
        h.b(this.e);     // Catch: Throwable -> L19
        LLog.w("ImageDelegate", "localCache cannot get bitmap and the url is: " + this.a);     // Catch: Throwable -> L19
    }

    public i(h r1, String r2, int r3, int r4, long r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
