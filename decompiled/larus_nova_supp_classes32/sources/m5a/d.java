package m5a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends TextureView {
    public SurfaceTexture a;
    public Runnable b;
    public Runnable c;
    public ExternalViewPlugin d;
    public k5a.a e;

    @Override // android.view.TextureView
    public SurfaceTexture getSurfaceTexture() {
        return this.a;
    }

    public d(Context r1) {
        super(r1);
        setSurfaceTextureListener(new c(this));
    }

    public void setExternalViewPlugin(ExternalViewPlugin r1) {
        this.d = r1;
    }

    public void setLifecycleListener(k5a.a r1) {
        this.e = r1;
    }

    public void setSurfaceTextureReadyListener(Runnable r1) {
        this.b = r1;
    }

    public void setSurfaceTextureUpdatedListener(Runnable r1) {
        this.c = r1;
    }

    public void setVisible(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }
}
