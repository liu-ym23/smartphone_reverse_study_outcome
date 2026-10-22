package k50;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final Handler a;
    public boolean b;
    public final b c;
    public final GLSurfaceView d;
    public final float e;

    public final void a() {
        this.b = false;
        b();
    }

    public final void b() {
        this.a.removeCallbacks(this.c);
        if (this.b == true) goto L6;
        this.a.postDelayed(this.c, (long) (1000.0f / this.e));
        this.d.requestRender();
        return;
    }

    public c(GLSurfaceView r2) {
        Intrinsics.checkNotNullParameter(r2, "glSurfaceView");
        this.d = r2;
        this.e = 60.0f;
        this.a = new Handler();
        this.c = new b(this);
        r2.setRenderMode(0);
    }
}
