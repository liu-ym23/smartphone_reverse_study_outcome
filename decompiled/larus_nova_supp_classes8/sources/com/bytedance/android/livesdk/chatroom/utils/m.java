package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.LivePlayerPixelCopy;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "sysCallback");
        ILivePlayerClient r1 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.p().currentClient();
        Bitmap r2 = null;
        if (r1 == null) goto L5;
        IRenderView r3 = r1.getRenderView();
    L7:
        if ((r3 instanceof SurfaceView) == true) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L38;
        ILivePlayerClient r6 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.p().currentClient();
        if (r6 == null) goto L16;
        IRenderView r7 = r6.getRenderView();
    L18:
        if ((r7 instanceof SurfaceView) == true) goto L20;
        r7 = null;
    L20:
        SurfaceView r8 = (SurfaceView) r7;
        Intrinsics.checkNotNullParameter(r5, "sysCallback");
        if ((r8 instanceof SurfaceRenderView) == true) goto L23;
    L34:
        ILivePlayerClient r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.p().currentClient();
        if (r0 == null) goto L37;
        r2 = r0.getBitmap();
    L37:
        r5.invoke(r2);
        return;
    L23:
        if (Build.VERSION.SDK_INT < 24) goto L34;
        SurfaceHolder r9 = r8.getHolder();
        if (r9 == null) goto L34;
        if (r9.getSurface() == null) goto L34;
        if (r9.getSurface().isValid() == false) goto L34;
        int r10 = r8.getWidth();
        int r11 = r8.getHeight();
        if (r10 <= 0) goto L34;
        if (r11 <= 0) goto L34;
        Bitmap r12 = Bitmap.createBitmap(r10, r11, Bitmap.Config.RGB_565);
        LivePlayerPixelCopy.Companion.request(r8, r12, new l(r12, r5), new Handler(Looper.getMainLooper()));
        return;
    L16:
        r7 = null;
        goto L18
    L38:
        ILivePlayerClient r13 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.p().currentClient();
        if (r13 == null) goto L41;
        IRenderView r14 = r13.getRenderView();
    L43:
        if ((r14 instanceof TextureView) == true) goto L45;
        r14 = null;
    L45:
        TextureView r15 = (TextureView) r14;
        if (r15 == null) goto L48;
        r2 = r15.getBitmap();
    L48:
        r5.invoke(r2);
        return;
    L41:
        r14 = null;
        goto L43
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        r4 = true;
        goto L12
    L5:
        r3 = null;
        goto L7
    }
}
