package com.bytedance.awemeopen.infra.base.player.surface;

import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.base.player.surface.a$a, reason: collision with other inner class name */
    public interface InterfaceC0192a {
        void onSurfaceAvailable();

        void onSurfaceDestroyed();
    }

    Surface getSurface();

    void release();
}
