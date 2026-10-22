package com.lynx.clay.embedding.engine.plugins.externalview;

import android.graphics.SurfaceTexture;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import k5a.a;
import m5a.d;
import m5a.h;
import m5a.p;
import m5a.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ExternalViewPlugin {
    public final ClayPluginContext a;
    public d b;
    public final long c;

    public static native void nativeOnSurfaceTextureDestroyed(long r0, SurfaceTexture r2);

    public static native void nativeOnSurfaceTextureReady(long r0, SurfaceTexture r2, int r3, int r4);

    public static native void nativeOnSurfaceTextureSizeChanged(long r0, SurfaceTexture r2, int r3, int r4);

    public void onAttachToTree() {
        d r0 = this.b;
        if (r0 == null) goto L6;
        a r1 = r0.e;
        return;
    }

    public void onDetachToTree() {
        d r0 = this.b;
        if (r0 == null) goto L9;
        a r1 = r0.e;
        if (r1 == null) goto L7;
        ((p) r1).a.setVisible(false);
    L7:
        this.b = null;
        return;
    }

    public void onViewDestroy() {
        d r0 = this.b;
        if (r0 == null) goto L19;
        a r1 = r0.e;
        if (r1 == null) goto L15;
        q r2 = ((p) r1).a;
        r2.m = true;
        h r3 = h.e;
        int r4 = r2.w;
        if (r3.b.get(Integer.valueOf(r4)) != r2) goto L10;
        r3.b.remove(Integer.valueOf(r4));
    L10:
        if (r2.f.isShowing() == true) goto L17;
        r2.g();
        goto L15
    L17:
        q.b(r2.f);     // Catch: RuntimeException -> L13
    L13:
        r2.g();
    L15:
        this.b = null;
        return;
    }

    private void changeVisibility(boolean r2) {
        d r0 = this.b;
        if (r0 == null) goto L6;
        r0.setVisible(r2);
        return;
    }

    public ExternalViewPlugin(ClayPluginContext r3, long r4) {
        this.c = 0;
        this.a = r3;
        this.c = r4;
    }

    private static ExternalViewPlugin createPlugin(ClayPluginContext r1, long r2) {
        return new ExternalViewPlugin(r1, r2);
    }

    public boolean onCreateView(int r2, String r3) {
        if (this.a.a == null) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
        return false;
    L8:
        d r5 = new d(this.a.a.getContext());
        this.b = r5;
        r5.setExternalViewPlugin(this);
        return true;
    L5:
        r4 = false;
        goto L6
    }
}
