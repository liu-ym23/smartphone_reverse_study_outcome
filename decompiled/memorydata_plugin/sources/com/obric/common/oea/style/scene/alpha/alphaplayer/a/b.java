package com.obric.common.oea.style.scene.alpha.alphaplayer.a;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\tH\u0002J(\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0016J\b\u00101\u001a\u00020%H\u0016J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020%H\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u001dH\u0016J \u00108\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0016J\u0018\u0010;\u001a\u00020%2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u00020=H\u0016J\u0012\u0010>\u001a\u00020%2\b\u0010?\u001a\u0004\u0018\u000104H\u0016J\b\u0010@\u001a\u00020%H\u0002J\u0010\u0010A\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010B\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/VideoRenderer;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "alphaVideoView", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;)V", "FLOAT_SIZE_BYTES", "", "GL_TEXTURE_EXTERNAL_OES", "TAG", "", "TRIANGLE_VERTICES_DATA_POS_OFFSET", "TRIANGLE_VERTICES_DATA_STRIDE_BYTES", "TRIANGLE_VERTICES_DATA_UV_OFFSET", "aPositionHandle", "aTextureHandle", "getAlphaVideoView", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "canDraw", "Ljava/util/concurrent/atomic/AtomicBoolean;", "halfRightVerticeData", "", "mVPMatrix", "programID", "sTMatrix", "scaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "surfaceListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender$SurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "textureID", "triangleVertices", "Ljava/nio/FloatBuffer;", "uMVPMatrixHandle", "uSTMatrixHandle", "updateSurface", "checkGlError", "", "op", "createProgram", "loadShader", "shaderType", AILabCheckPermissionTask.KEY_SOURCE, "measureInternal", "viewWidth", "", "viewHeight", "videoWidth", "videoHeight", "onCompletion", "onDrawFrame", "glUnused", "Ljavax/microedition/khronos/opengles/GL10;", "onFirstFrame", "onFrameAvailable", "surface", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onSurfaceDestroyed", "gl", "prepareSurface", "setScaleType", "setSurfaceListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7775b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private float[] g;
    private FloatBuffer h;
    private final float[] i;
    private final float[] j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private final AtomicBoolean q;
    private final AtomicBoolean r;
    private SurfaceTexture s;
    private a.InterfaceC0378a t;
    private ScaleType u;
    private final com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a v;

    public b(com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r4) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r5 = (com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "alphaVideoView");
        this.v = r5;
        this.f7774a = "VideoRender";
        this.f7775b = 4;
        this.c = 4 * 5;
        this.e = 3;
        this.f = 36197;
        this.g = new float[]{-1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.i = new float[16];
        float[] r0 = new float[16];
        this.j = r0;
        this.q = new AtomicBoolean(false);
        this.r = new AtomicBoolean(false);
        this.u = ScaleType.ScaleAspectFill;
        FloatBuffer r6 = ByteBuffer.allocateDirect(this.g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(r6, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.h = r6;
        r6.put(this.g).position(0);
        Matrix.setIdentityM(r0, 0);
    }

    private final int a(int r5, String r6) {
        int r0 = GLES20.glCreateShader(r5);
        if (r0 == 0) goto L8;
        GLES20.glShaderSource(r0, r6);
        GLES20.glCompileShader(r0);
        int[] r7 = new int[1];
        GLES20.glGetShaderiv(r0, 35713, r7, 0);
        if (r7[0] != 0) goto L9;
        Log.e(this.f7774a, "Could not compile shader " + r5 + ':');
        Log.e(this.f7774a, GLES20.glGetShaderInfoLog(r0));
        GLES20.glDeleteShader(r0);
        return 0;
    L9:
        return r0;
    L8:
        return r0;
    }

    private final void a(String r3) {
        int r0 = GLES20.glGetError();
        if (r0 == 0) goto L6;
        Log.e(this.f7774a, r3 + ": glError " + r0);
        return;
    }

    private final void c() {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        int r2 = r1[0];
        this.l = r2;
        GLES20.glBindTexture(this.f, r2);
        a("glBindTexture textureID");
        GLES20.glTexParameterf(this.f, 10241, 9728);
        GLES20.glTexParameterf(this.f, 10240, 9729);
        this.s = new SurfaceTexture(this.l);
        if (Build.VERSION.SDK_INT < 15) goto L8;
        SurfaceTexture r3 = this.s;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L7:
        r3.setDefaultBufferSize(this.v.getMeasuredWidth(), this.v.getMeasuredHeight());
    L8:
        SurfaceTexture r4 = this.s;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L11:
        r4.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) ZeusTransformUtils.preCheckCast(this, SurfaceTexture.OnFrameAvailableListener.class, "com.obric.memorydata.plugin"));
        SurfaceTexture r5 = this.s;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L14:
        Surface r6 = new Surface(r5);
        a.InterfaceC0378a r7 = this.t;
        if (r7 == null) goto L17;
        r7.a(r6);
    L17:
        this.r.compareAndSet(true, false);
    }

    private final int d() {
        int r0 = a(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}");
        if (r0 != 0) goto L6;
        Log.e(this.f7774a, "Failed to compile vertex shader");
        return 0;
    L6:
        int r2 = a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\n\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec4 color2Map = vec4(1.0, 1.0, 1.0, 1.0);\n    if (vTextureCoord.x >= 0.5) {\n        color2Map = texture2D(sTexture, vec2(vTextureCoord.x - 0.5, vTextureCoord.y));\n        gl_FragColor = vec4(color.r, color.g, color.b, color2Map.g);\n    } else {\n        gl_FragColor = vec4(color.r, color.g, color.b, color.a);\n    }\n}");
        if (r2 != 0) goto L10;
        Log.e(this.f7774a, "Failed to compile fragment shader");
        GLES20.glDeleteShader(r0);
        return 0;
    L10:
        int r3 = GLES20.glCreateProgram();
        if (r3 == 0) goto L16;
        GLES20.glAttachShader(r3, r0);
        a("glAttachShader");
        GLES20.glAttachShader(r3, r2);
        a("glAttachShader");
        GLES20.glLinkProgram(r3);
        int[] r4 = new int[1];
        GLES20.glGetProgramiv(r3, 35714, r4, 0);
        if (r4[0] == 1) goto L16;
        Log.e(this.f7774a, "Could not link programID: ");
        Log.e(this.f7774a, GLES20.glGetProgramInfoLog(r3));
        GLES20.glDeleteProgram(r3);
        return 0;
    L16:
        return r3;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.a.a
    public void a() {
        this.q.compareAndSet(false, true);
        Log.i(this.f7774a, "onFirstFrame:    canDraw = " + this.q.get());
        this.v.requestRender();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.a.a
    public void a(float r4, float r5, float r6, float r7) {
        float r1 = 0;
        if (r4 > r1) goto L5;
        return;
    L5:
        if (r5 > r1) goto L7;
        return;
    L7:
        if (r6 > r1) goto L9;
        return;
    L9:
        if (r7 <= r1) goto L16;
        float[] r8 = com.obric.common.oea.style.scene.alpha.alphaplayer.b.a.a(this.u, r4, r5, r6, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "TextureCropUtil.calculat… videoWidth, videoHeight)");
        this.g = r8;
        FloatBuffer r9 = ByteBuffer.allocateDirect(r8.length * this.f7775b).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(r9, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.h = r9;
        r9.put(this.g).position(0);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.a.a
    public void a(a.InterfaceC0378a r3) {
        a.InterfaceC0378a r4 = (a.InterfaceC0378a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0378a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "surfaceListener");
        this.t = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.a.a
    public void a(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        this.u = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.a.a
    public void b() {
        this.q.compareAndSet(true, false);
        Log.i(this.f7774a, "onCompletion:   canDraw = " + this.q.get());
        this.v.requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m
    public void onDrawFrame(GL10 r11) {
        Intrinsics.checkNotNullParameter((GL10) ZeusTransformUtils.wrapperContextForParams(r11, GL10.class, "com.obric.memorydata.plugin"), "glUnused");
        if (this.r.compareAndSet(true, false) == true) goto L21;
    L15:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.q.get() == true) goto L19;
        GLES20.glFinish();
        return;
    L19:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(this.k);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f, this.l);
        this.h.position(this.d);
        GLES20.glVertexAttribPointer(this.o, 3, 5126, false, this.c, (Buffer) ZeusTransformUtils.preCheckCast(this.h, Buffer.class, "com.obric.memorydata.plugin"));
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.o);
        a("glEnableVertexAttribArray aPositionHandle");
        this.h.position(this.e);
        GLES20.glVertexAttribPointer(this.p, 3, 5126, false, this.c, (Buffer) ZeusTransformUtils.preCheckCast(this.h, Buffer.class, "com.obric.memorydata.plugin"));
        a("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.p);
        a("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.i, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.i, 0);
        GLES20.glUniformMatrix4fv(this.n, 1, false, this.j, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
        return;
    L21:
        SurfaceTexture r12 = this.s;     // Catch: Exception -> L9
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");     // Catch: Exception -> L9
    L7:
        r12.updateTexImage();     // Catch: Exception -> L9
    L11:
        SurfaceTexture r13 = this.s;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L14:
        r13.getTransformMatrix(this.j);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r3) {
        Intrinsics.checkNotNullParameter(r3, "surface");
        this.r.compareAndSet(false, true);
        this.v.requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m
    public void onSurfaceChanged(GL10 r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter((GL10) ZeusTransformUtils.wrapperContextForParams(r2, GL10.class, "com.obric.memorydata.plugin"), "glUnused");
        GLES20.glViewport(0, 0, r3, r4);
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m
    public void onSurfaceCreated(GL10 r3, EGLConfig r4) {
        Intrinsics.checkNotNullParameter((GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.memorydata.plugin"), "glUnused");
        Intrinsics.checkNotNullParameter(r4, "config");
        int r5 = d();
        this.k = r5;
        if (r5 != 0) goto L5;
        return;
    L5:
        this.o = GLES20.glGetAttribLocation(r5, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.o == (-1)) goto L22;
        this.p = GLES20.glGetAttribLocation(this.k, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.p == (-1)) goto L20;
        this.m = GLES20.glGetUniformLocation(this.k, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.m == (-1)) goto L18;
        this.n = GLES20.glGetUniformLocation(this.k, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.n == (-1)) goto L16;
        c();
        return;
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for uSTMatrix"), Throwable.class, "com.obric.memorydata.plugin"));
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for uMVPMatrix"), Throwable.class, "com.obric.memorydata.plugin"));
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for aTextureCoord"), Throwable.class, "com.obric.memorydata.plugin"));
    L22:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for aPosition"), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
