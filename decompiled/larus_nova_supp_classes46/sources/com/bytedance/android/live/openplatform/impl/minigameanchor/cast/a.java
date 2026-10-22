package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.os.Handler;
import android.view.Surface;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final String a;
    public Handler b;
    public d0 c;
    public final h0.e d;
    public EGL10 e;
    public EGLDisplay f;
    public EGLContext g;
    public EGLSurface h;
    public final Surface i;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.minigameanchor.cast.a$a, reason: collision with other inner class name */
    public static final class C0180a {
    }

    public static final class b implements h0.e.a {
        public b() {
        }
    }

    static {
    }

    public a(Surface r5) {
        Intrinsics.checkNotNullParameter(r5, "littleWindowSurface");
        this.i = r5;
        this.a = "CameraPreviewRenderer";
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r6 = ILiveWrappedLivePusher.a.b();
        if (r6 == null) goto L5;
        h0.e r7 = r6.newTextureFrameAvailableListener(new b());
    L6:
        this.d = r7;
        FloatBuffer r2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r2.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
        FloatBuffer r0 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r0.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f}).position(0);
        PthreadHandlerThreadV2 r8 = new PthreadHandlerThreadV2("mg_cast_camera_preview_EGLRender");
        ThreadMethodProxy.start(r8);
        this.b = new Handler(r8.getLooper());
        EGL r9 = EGLContext.getEGL();
        if (r9 == null) goto L11;
        this.e = (EGL10) r9;
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
    L5:
        r7 = null;
        goto L6
    }
}
