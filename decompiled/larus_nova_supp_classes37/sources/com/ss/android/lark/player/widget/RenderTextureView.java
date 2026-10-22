package com.ss.android.lark.player.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class RenderTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public a a;

    public interface a {
    }

    public interface b {
    }

    public static final class c implements b {
        public final WeakReference<SurfaceTexture> a;

        public c(SurfaceTexture r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    public a getRenderCallback() {
        return this.a;
    }

    public RenderTextureView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
        Log.i("RenderSurfaceView", "onSurfaceTextureDestroyed");
        a r0 = this.a;
        if (r0 == null) goto L7;
        new WeakReference(r3);
        ((VideoViewForVC.a) r0).a.j = null;
        return true;
    L7:
        return true;
    }

    public void setRenderCallback(a r1) {
        this.a = r1;
    }

    public RenderTextureView(Context r1, AttributeSet r2) {
        super(r1, r2);
        setOpaque(true);
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
        Log.i("RenderSurfaceView", "onSurfaceTextureAvailable, width = " + r4 + ", height = " + r5);
        a r6 = this.a;
        if (r6 == null) goto L6;
        c r7 = new c(r3);
        VideoViewForVC r8 = ((VideoViewForVC.a) r6).a;
        r8.j = r7;
        VideoViewForVC.b(r8, r7);
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r3, int r4, int r5) {
        Log.i("RenderSurfaceView", "onSurfaceTextureSizeChanged, width = " + r4 + ", height " + r5);
        a r6 = this.a;
        if (r6 == null) goto L6;
        new WeakReference(r3);
        r6.getClass();
        return;
    }
}
