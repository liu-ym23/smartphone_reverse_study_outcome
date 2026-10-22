package rja;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public float[] e;
    public FloatBuffer f;
    public final float[] g;
    public final float[] h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final AtomicBoolean o;
    public final AtomicBoolean p;
    public SurfaceTexture q;
    public a.InterfaceC0070a r;
    public ScaleType s;
    public final tja.a t;

    @Override // rja.a
    public final void onCompletion() {
        this.o.compareAndSet(true, false);
        this.o.get();
        this.t.requestRender();
    }

    @Override // rja.a
    public final void onFirstFrame() {
        this.o.compareAndSet(false, true);
        this.o.get();
        this.t.requestRender();
    }

    public static void a() {
        if (GLES20.glGetError() != 0) goto L5;
        return;
    }

    public b(tja.a r4) {
        Intrinsics.checkNotNullParameter(r4, "alphaVideoView");
        this.t = r4;
        this.a = 4;
        this.b = 20;
        this.c = 3;
        this.d = 36197;
        this.e = new float[]{-1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.g = new float[16];
        float[] r0 = new float[16];
        this.h = r0;
        this.o = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.s = ScaleType.ScaleAspectFill;
        FloatBuffer r5 = ByteBuffer.allocateDirect(this.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = r5;
        r5.put(this.e).position(0);
        Matrix.setIdentityM(r0, 0);
    }

    @Override // rja.a
    public final void f(a.InterfaceC0070a r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceListener");
        this.r = r2;
    }

    @Override // rja.a
    public final void m(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        this.s = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m, android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r11) {
        Intrinsics.checkNotNullParameter(r11, "glUnused");
        if (this.p.compareAndSet(true, false) == true) goto L21;
    L15:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.o.get() == true) goto L19;
        GLES20.glFinish();
        return;
    L19:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(this.i);
        a();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.d, this.j);
        this.f.position(0);
        GLES20.glVertexAttribPointer(this.m, 3, 5126, false, this.b, this.f);
        a();
        GLES20.glEnableVertexAttribArray(this.m);
        a();
        this.f.position(this.c);
        GLES20.glVertexAttribPointer(this.n, 3, 5126, false, this.b, this.f);
        a();
        GLES20.glEnableVertexAttribArray(this.n);
        a();
        Matrix.setIdentityM(this.g, 0);
        GLES20.glUniformMatrix4fv(this.k, 1, false, this.g, 0);
        GLES20.glUniformMatrix4fv(this.l, 1, false, this.h, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a();
        GLES20.glFinish();
        return;
    L21:
        SurfaceTexture r12 = this.q;     // Catch: Exception -> L9
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");     // Catch: Exception -> L9
    L7:
        r12.updateTexImage();     // Catch: Exception -> L9
    L11:
        SurfaceTexture r13 = this.q;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L14:
        r13.getTransformMatrix(this.h);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r3) {
        Intrinsics.checkNotNullParameter(r3, "surface");
        this.p.compareAndSet(false, true);
        this.t.requestRender();
    }

    public static int b(int r2, String r3) {
        int r4 = GLES20.glCreateShader(r2);
        if (r4 == 0) goto L8;
        GLES20.glShaderSource(r4, r3);
        GLES20.glCompileShader(r4);
        int[] r5 = new int[1];
        GLES20.glGetShaderiv(r4, 35713, r5, 0);
        if (r5[0] != 0) goto L9;
        GLES20.glGetShaderInfoLog(r4);
        GLES20.glDeleteShader(r4);
        return 0;
    L9:
        return r4;
    L8:
        return r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m, android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r4, EGLConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "glUnused");
        Intrinsics.checkNotNullParameter(r5, "config");
        int r6 = b(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}");
        if (r6 == 0) goto L13;
        int r1 = b(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\n\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec4 color2Map = vec4(1.0, 1.0, 1.0, 1.0);\n    if (vTextureCoord.x >= 0.5) {\n        color2Map = texture2D(sTexture, vec2(vTextureCoord.x - 0.5, vTextureCoord.y));\n        gl_FragColor = vec4(color.r, color.g, color.b, color2Map.g);\n    } else {\n        gl_FragColor = vec4(color.r, color.g, color.b, color.a);\n    }\n}");
        if (r1 != 0) goto L8;
        GLES20.glDeleteShader(r6);
        goto L13
    L8:
        int r2 = GLES20.glCreateProgram();
        if (r2 == 0) goto L14;
        GLES20.glAttachShader(r2, r6);
        a();
        GLES20.glAttachShader(r2, r1);
        a();
        GLES20.glLinkProgram(r2);
        int[] r7 = new int[1];
        GLES20.glGetProgramiv(r2, 35714, r7, 0);
        if (r7[0] == 1) goto L14;
        GLES20.glGetProgramInfoLog(r2);
        GLES20.glDeleteProgram(r2);
    L14:
        this.i = r2;
        if (r2 != 0) goto L17;
        return;
    L17:
        this.m = GLES20.glGetAttribLocation(r2, "aPosition");
        a();
        if (this.m == (-1)) goto L43;
        this.n = GLES20.glGetAttribLocation(this.i, "aTextureCoord");
        a();
        if (this.n == (-1)) goto L41;
        this.k = GLES20.glGetUniformLocation(this.i, "uMVPMatrix");
        a();
        if (this.k == (-1)) goto L39;
        this.l = GLES20.glGetUniformLocation(this.i, "uSTMatrix");
        a();
        if (this.l == (-1)) goto L37;
        int[] r8 = new int[1];
        GLES20.glGenTextures(1, r8, 0);
        int r9 = r8[0];
        this.j = r9;
        GLES20.glBindTexture(this.d, r9);
        a();
        GLES20.glTexParameterf(this.d, 10241, 9728);
        GLES20.glTexParameterf(this.d, 10240, 9729);
        SurfaceTexture r10 = new SurfaceTexture(this.j);
        this.q = r10;
        r10.setDefaultBufferSize(this.t.getMeasuredWidth(), this.t.getMeasuredHeight());
        SurfaceTexture r11 = this.q;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L28:
        r11.setOnFrameAvailableListener(this);
        SurfaceTexture r3 = this.q;
        if (r3 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L31:
        Surface r12 = new Surface(r3);
        a.InterfaceC0070a r13 = this.r;
        if (r13 == null) goto L34;
        r13.a(r12);
    L34:
        this.p.compareAndSet(true, false);
        return;
    L37:
        throw new RuntimeException("Could not get attrib location for uSTMatrix");
    L39:
        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    L41:
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
    L43:
        throw new RuntimeException("Could not get attrib location for aPosition");
    L13:
        r2 = 0;
        goto L14
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m, android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "glUnused");
        GLES20.glViewport(0, 0, r3, r4);
    }

    @Override // rja.a
    public final void h(float r9, float r10, float r11, float r12) {
        float r1 = 0;
        if (r9 > r1) goto L5;
        return;
    L5:
        if (r10 > r1) goto L7;
        return;
    L7:
        if (r11 > r1) goto L9;
        return;
    L9:
        if (r12 <= r1) goto L36;
        ScaleType r2 = this.s;
        float r3 = r9 / r10;
        float r13 = r11 / r12;
        float r14 = 0.0f;
        if (r3 <= r13) goto L14;
        float r6 = (1.0f - (r10 / (r9 / r13))) / 2.0f;
        float r5 = 0.0f;
    L16:
        switch(sja.a.C0072a.a[r2.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L17;
        };
    L17:
        float[] r15 = sja.a.a(0.0f, 0.0f, 0.0f, 0.0f);
    L31:
        this.e = r15;
        FloatBuffer r16 = ByteBuffer.allocateDirect(r15.length * this.a).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = r16;
        r16.put(this.e).position(0);
        return;
    L18:
        r15 = sja.a.b(((1.0f - ((r10 * r13) / r9)) / 2.0f) * 2.0f, 0.0f, 0.0f, 0.0f);
        goto L31
    L19:
        r15 = sja.a.b(0.0f, 0.0f, ((1.0f - ((r10 * r13) / r9)) / 2.0f) * 2.0f, 0.0f);
        goto L31
    L20:
        r15 = sja.a.b(0.0f, ((1.0f - ((r9 / r13) / r10)) / 2.0f) * 2.0f, 0.0f, 0.0f);
        goto L31
    L21:
        r15 = sja.a.b(0.0f, 0.0f, 0.0f, ((1.0f - ((r9 / r13) / r10)) / 2.0f) * 2.0f);
        goto L31
    L22:
        r15 = sja.a.a(r5 * 2.0f, r6, 0.0f, r6);
        goto L31
    L23:
        r15 = sja.a.a(0.0f, r6, r5 * 2.0f, r6);
        goto L31
    L24:
        r15 = sja.a.a(r5, r6 * 2.0f, r5, 0.0f);
        goto L31
    L25:
        r15 = sja.a.a(r5, 0.0f, r5, r6 * 2.0f);
        goto L31
    L26:
        r15 = sja.a.a(r5, r6, r5, r6);
        goto L31
    L27:
        if (r3 <= r13) goto L29;
        r14 = (1.0f - ((r10 * r13) / r9)) / 2.0f;
        float r4 = 0.0f;
    L30:
        r15 = sja.a.b(r14, r4, r14, r4);
        goto L31
    L29:
        r4 = (1.0f - ((r9 / r13) / r10)) / 2.0f;
        goto L30
    L14:
        r5 = (1.0f - (r9 / (r10 * r13))) / 2.0f;
        r6 = 0.0f;
        goto L16
    }
}
