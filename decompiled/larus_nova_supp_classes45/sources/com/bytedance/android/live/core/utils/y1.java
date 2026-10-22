package com.bytedance.android.live.core.utils;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.LivePlayerPixelCopy;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y1 {

    public static final class a implements PixelCopy.OnPixelCopyFinishedListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int r1) {
        }
    }

    public static final class b extends Handler {
        public b(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r1, long r2) {
            Intrinsics.checkNotNullParameter(r1, "msg");
            Runnable r3 = r1.getCallback();
            if (r3 == null) goto L7;
            r3.run();
            return true;
        L7:
            return true;
        }
    }

    static {
    }

    @JvmStatic
    public static final Bitmap a(IRenderView r4, ILivePlayerClient r5) {
        Intrinsics.checkNotNullParameter(r4, "renderView");
        if ((r4 instanceof SurfaceRenderView) == true) goto L5;
    L17:
        if (r5 != null) goto L21;
        return null;
    L21:
        return r5.getBitmap();
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L17;
        SurfaceView r6 = (SurfaceView) r4;
        SurfaceHolder r0 = r6.getHolder();
        if (r0 == null) goto L17;
        if (r0.getSurface() == null) goto L17;
        if (r0.getSurface().isValid() == false) goto L17;
        int r1 = r6.getWidth();
        int r2 = r6.getHeight();
        if (r1 <= 0) goto L17;
        if (r2 <= 0) goto L17;
        Bitmap r7 = Bitmap.createBitmap(r1, r2, Bitmap.Config.RGB_565);
        LivePlayerPixelCopy.Companion.request(r6, r7, a.a, new b(Looper.getMainLooper()));
        return r7;
    }
}
