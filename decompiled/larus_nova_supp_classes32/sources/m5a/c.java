package m5a;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
        d r0 = this.a;
        r0.a = null;
        ExternalViewPlugin r1 = r0.d;
        if (r1 == null) goto L7;
        ExternalViewPlugin.nativeOnSurfaceTextureDestroyed(r1.c, r3);
        return false;
    L7:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r1) {
        Runnable r2 = this.a.c;
        if (r2 == null) goto L6;
        r2.run();
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(final SurfaceTexture r9, final int r10, final int r11) {
        final d r6 = this.a;
        r6.a = r9;
        final ExternalViewPlugin r3 = r6.d;
        if (r3 == null) goto L7;
        r6.postOnAnimation(new a(r6, r9, r3, r10, r11));
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(final SurfaceTexture r9, final int r10, final int r11) {
        final d r6 = this.a;
        r6.a = r9;
        final ExternalViewPlugin r3 = r6.d;
        if (r3 == null) goto L7;
        r6.postOnAnimation(new b(r6, r9, r3, r10, r11));
        return;
    }
}
