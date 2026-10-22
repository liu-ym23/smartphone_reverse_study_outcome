package com.lynx.clay.embedding.engine.sharedimage;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import c5a.c;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SurfaceTexturePlatformWrapper {
    public static final Object a = null;
    public static Handler b;
    public static final WeakHashMap<SurfaceTexture, a> c = null;

    public interface a {
        void a();
    }

    public SurfaceTexturePlatformWrapper() {
    }

    static {
        a = new Object();
        c = new WeakHashMap();
    }

    private static SurfaceTexture create() {
        SurfaceTexture r0 = new SurfaceTexture(0);
        r0.detachFromGLContext();
        return r0;
    }

    private static void destroy(SurfaceTexture r1) {
        a(r1, null);
        r1.release();
    }

    private static void detachFromGLContext(SurfaceTexture r0) {
        r0.detachFromGLContext();
    }

    private static void release(SurfaceTexture r0) {
        r0.release();
    }

    private static void updateTexImage(SurfaceTexture r2) {
        r2.updateTexImage();     // Catch: RuntimeException -> L12
        WeakHashMap<SurfaceTexture, a> r0 = c;     // Catch: RuntimeException -> L12
        monitor-enter(r0);     // Catch: RuntimeException -> L12
        a r3 = r0.get(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r3 == null) goto L18;
        r3.a();     // Catch: RuntimeException -> L12
        return;
    L18:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L12
    L12:
        e = move-exception;
        c.b("SurfaceTexturePlatformWrapper", "Error calling updateTexImage", e);
    }

    public static void a(SurfaceTexture r3, SurfaceTexture.OnFrameAvailableListener r4) {
        if (r4 == null) goto L15;
        Object r0 = a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (b != null) goto L8;
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("ClaySurfaceTextureFrameAvailable");     // Catch: Throwable -> L12
        ThreadMethodProxy.start(r1);     // Catch: Throwable -> L12
        b = new Handler(r1.getLooper());     // Catch: Throwable -> L12
    L8:
        Handler r2 = b;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        r3.setOnFrameAvailableListener(r4, r2);
        return;
    L15:
        r3.setOnFrameAvailableListener(r4);
    }

    private static void attachToGLContext(SurfaceTexture r0, int r1) {
        r0.attachToGLContext(r1);
    }

    private static void getTransformMatrix(SurfaceTexture r0, float[] r1) {
        r0.getTransformMatrix(r1);
    }

    private static void setFrameAvailableCallback(SurfaceTexture r3, long r4) {
        if (r4 != 0) goto L5;
        a(r3, null);
        return;
    L5:
        a(r3, new SurfaceTextureListener(r4));
    }

    private static void setDefaultBufferSize(SurfaceTexture r0, int r1, int r2) {
        r0.setDefaultBufferSize(r1, r2);
    }
}
