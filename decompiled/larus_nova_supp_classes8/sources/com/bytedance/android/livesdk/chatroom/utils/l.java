package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ Function1 b;

    public static final class a implements Runnable {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        public final void a() {
            Bitmap r0 = this.a.a;
            if (r0 != null) goto L5;
        L8:
            ALogger.e("CatchUtils", "Bitmap is black or empty");
            this.a.b.invoke(null);
            return;
        L5:
            if (r0.sameAs(Bitmap.createBitmap(r0.getWidth(), this.a.a.getHeight(), Bitmap.Config.RGB_565)) == true) goto L8;
            l r1 = this.a;
            r1.b.invoke(r1.a);
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
    }

    public l(Bitmap r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r2) {
        if (r2 != 0) goto L4;
        new Handler(Looper.getMainLooper()).post(new a(this));
        return;
    L4:
        ALogger.e("CatchUtils", "Error capturing bitmap");
        this.b.invoke(null);
    }
}
