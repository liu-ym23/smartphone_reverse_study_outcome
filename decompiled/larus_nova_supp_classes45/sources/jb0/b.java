package jb0;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import com.bytedance.android.live.ktv.common.canvasgl.glview.GLContinuousSurfaceAdapterView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final Handler a;
    public boolean b;
    public final a c;
    public final GLSurfaceView d;
    public final float e;

    public final void a() {
        this.a.removeCallbacks(this.c);
        if (this.b == true) goto L6;
        this.a.postDelayed(this.c, (long) (1000.0f / this.e));
        this.d.requestRender();
        return;
    }

    public b(GLContinuousSurfaceAdapterView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "glSurfaceView");
        this.d = r2;
        this.e = r3;
        this.a = new Handler();
        this.c = new a(this);
        r2.setRenderMode(0);
    }
}
