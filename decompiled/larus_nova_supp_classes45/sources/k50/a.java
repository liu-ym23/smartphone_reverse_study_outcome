package k50;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements GLSurfaceView.Renderer {
    public n50.a a;
    public final f b;
    public final com.bytedance.android.live.core.gl.primitive.a c;

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r3) {
        Intrinsics.checkNotNullParameter(r3, "unused");
        f r4 = this.b;
        if (r4.e == false) goto L5;
        r4.d = System.currentTimeMillis();
    L5:
        GLES20.glClear(16640);
        n50.a r5 = this.a;
        if (r5 == null) goto L8;
        r5.c(this.b);
    L8:
        this.b.a.b.getClass();
        this.b.a.a.b();
    }

    public a(Context r3, com.bytedance.android.live.core.gl.primitive.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "backgroundColor");
        f r1 = new f(r3);
        Intrinsics.checkNotNullParameter(r1, "rendererParams");
        Intrinsics.checkNotNullParameter(r4, "backgroundColor");
        this.b = r1;
        this.c = r4;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r5, EGLConfig r6) {
        Intrinsics.checkNotNullParameter(r5, "unused");
        Intrinsics.checkNotNullParameter(r6, "config");
        com.bytedance.android.live.core.gl.primitive.a r7 = this.c;
        GLES20.glClearColor(r7.a, r7.b, r7.c, r7.d);
        GLES20.glDisable(2929);
        GLES20.glFrontFace(2305);
        GLES20.glCullFace(1029);
        f r8 = this.b;
        r8.b++;
        n50.a r9 = this.a;
        if (r9 == null) goto L15;
        Intrinsics.checkNotNullParameter(r8, "rendererParams");
        ArrayList<m50.b> r0 = r9.a;
        monitor-enter(r0);
        int r1 = r9.a.size();     // Catch: Throwable -> L12
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r9.a.get(r2).b(r8);     // Catch: Throwable -> L12
        r2 = r2 + 1;     // Catch: Throwable -> L12
        goto L7
    L9:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
    L12:
        th = move-exception;
        throw th;
    L15:
        f r12 = this.b;
        com.bytedance.android.live.core.gl.core.shader.b r13 = r12.a.b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r12, "rendererParams");
        Iterator<com.bytedance.android.live.core.gl.core.shader.a> r14 = r13.a.values().iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        r14.next().a(r12);
        goto L17
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "unused");
        this.b.getClass();
        GLES20.glViewport(0, 0, r3, r4);
        n50.a r5 = this.a;
        if (r5 == null) goto L6;
        r5.d(this.b, r3, r4);
        return;
    }
}
