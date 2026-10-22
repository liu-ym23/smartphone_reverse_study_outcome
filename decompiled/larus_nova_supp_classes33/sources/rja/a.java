package rja;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface a extends GLTextureView.m, GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: rja.a$a, reason: collision with other inner class name */
    public interface InterfaceC0070a {
        void a(Surface r1);
    }

    void f(InterfaceC0070a r1);

    void h(float r1, float r2, float r3, float r4);

    void m(ScaleType r1);

    void onCompletion();

    void onFirstFrame();
}
