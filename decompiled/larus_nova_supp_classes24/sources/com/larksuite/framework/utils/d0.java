package com.larksuite.framework.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d0 {
    public static final /* synthetic */ int a = 0;

    public static final class a implements PixelCopy.OnPixelCopyFinishedListener {
        public final /* synthetic */ IGetDataCallback<Bitmap> a;
        public final /* synthetic */ Bitmap b;

        public a(IGetDataCallback<Bitmap> r1, Bitmap r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int r3) {
            if (r3 != 0) goto L4;
            this.a.onSuccess(this.b);
            return;
        L4:
            this.a.onError(new ErrorResult(r3));
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ IGetDataCallback<Bitmap> b;

        public b(View r1, IGetDataCallback<Bitmap> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap r0 = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L4
            Canvas r1 = new Canvas(r0);     // Catch: Throwable -> L4
            this.a.draw(r1);     // Catch: Throwable -> L4
            r1.setBitmap(null);     // Catch: Throwable -> L4
            this.b.onSuccess(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(View r9, Window r10, IGetDataCallback<Bitmap> r11) {
        Intrinsics.checkNotNullParameter(r10, "window");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (r9 != null) goto L6;
        Log.e("ScreenShotUtil", "getScreenshot view is null");
        r11.onError(new ErrorResult("getScreenshot view is null"));
        return;
    L6:
        int r1 = r9.getWidth();
        if (r1 > 0) goto L10;
        String r12 = "getScreenshot view.getWidth() <= 0, view.getWidth() = " + r1;
        Log.e("ScreenShotUtil", r12);
        r11.onError(new ErrorResult(r12));
        return;
    L10:
        int r2 = r9.getHeight();
        if (r2 > 0) goto L15;
        String r13 = "getScreenshot view.getHeight() <= 0, view.getWidth() = " + r2;
        Log.e("ScreenShotUtil", r13);
        r11.onError(new ErrorResult(r13));
        return;
    L15:
        if (Build.VERSION.SDK_INT < 26) goto L21;
        Bitmap r3 = Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888);
        a r4 = new a(r11, r3);
        Handler r14 = new Handler(Looper.getMainLooper());
        int[] r5 = new int[2];     // Catch: Exception -> L19
        r9.getLocationInWindow(r5);     // Catch: Exception -> L19
        int r6 = r5[0];     // Catch: Exception -> L19
        PixelCopy.request(r10, new Rect(r6, r5[1], r9.getWidth() + r6, r5[1] + r9.getHeight()), r3, r4, r14);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Log.e("ScreenShotUtil", "screenshotAndroidO error", e);
        r14.post(new c0(r4));
        return;
    L21:
        UICallbackExecutor.execute(new b(r9, r11));
    }
}
