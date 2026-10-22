package d19;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements GLSurfaceView.Renderer {
    public int a;
    public float b;
    public float c;
    public float d;
    public int e;
    public float f;
    public float g;
    public c h;
    public final long i;

    public f() {
        this.a = 2;
        this.c = 1.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = System.nanoTime();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r10) {
        float r2 = ((System.nanoTime() - this.i) / 1.0E9f) % 10000.0f;
        c r1 = this.h;
        if (r1 == null) goto L6;
        r1.b(r2, this.b, this.c, this.d, this.e, this.f, this.g);
        return;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r1, EGLConfig r2) {
        if (this.a < 3) goto L5;
        c r3 = new e();
    L6:
        r3.a();
        this.h = r3;
        return;
    L5:
        r3 = new d();
        goto L6
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r1, int r2, int r3) {
        c r4 = this.h;
        if (r4 == null) goto L5;
        r4.onSurfaceChanged(r2, r3);
    L5:
        this.f = r2;
        this.g = r3;
    }
}
