package com.lynx.clay.embedding.engine.sharedimage;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class SurfacePlatformWrapper {
    public SurfacePlatformWrapper() {
    }

    private static Surface createSurface(SurfaceTexture r1) {
        return new Surface(r1);
    }

    private static void releaseSurface(Surface r0) {
        r0.release();
    }

    private static boolean surfaceIsValid(Surface r0) {
        return r0.isValid();
    }
}
