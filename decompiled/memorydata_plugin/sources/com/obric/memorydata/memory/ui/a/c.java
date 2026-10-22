package com.obric.memorydata.memory.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.util.TypedValue;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.utils.v;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001DB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010,\u001a\u00020-J\u0014\u0010.\u001a\u00020-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020-00J\u001c\u00101\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\"\u00106\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0016J\u0012\u00109\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u000bH\u0002J\u001a\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010@\u001a\u00020\u000b2\b\u0010A\u001a\u0004\u0018\u00010;H\u0002J\u0010\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020;H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/memorydata/memory/ui/animation/CommonProcessingRender;", "Landroid/opengl/GLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mTriangleVertices", "Ljava/nio/FloatBuffer;", "mTriangleVerticesData", "", "mTimeHandle", "", "mResolutionHandle", "mAlphaHandle", "mRadiusHandle", "mTextureEnabledHandle", "mTextureHandle", "mDotEnabledHandle", "mDotsAlphaHandle", "mDotsGridSizeHandle", "mDotsSizeHandle", "mDotsSpeedHandle", "mDotsMovementHandle", "mNoiseSizeHandle", "mNoiseSpeedHandle", "mSurfaceEffectEnabledHandle", "mSurfaceEffectAlphaHandle", "mEdgeEffectEnabledHandle", "mMaskCenterHandle", "mMaskEdgeHandle", "mEdgeEffectAlphaHandle", "mEdgeWidthHandle", "mMaskEnterSizeHandle", "mMaskExitSizeHandle", "mWidth", "mLastWidth", "mHeight", "mLastHeight", "mProgram", "mvPositionHandle", "maskSize", "", "animatorHelper", "Lcom/obric/memorydata/memory/ui/animation/CommonProcessingAnimatorHelper;", "show", "", "hide", "onEnd", "Lkotlin/Function0;", "onSurfaceCreated", "p0", "Ljavax/microedition/khronos/opengles/GL10;", "p1", "Ljavax/microedition/khronos/egl/EGLConfig;", "onSurfaceChanged", "width", "height", "onDrawFrame", "readRawTextFile", "", "resId", "loadShader", "shaderType", AILabCheckPermissionTask.KEY_SOURCE, "createProgram", "fragmentSource", "checkGlError", "op", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements GLSurfaceView.Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10563a = null;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private final b H;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f10564b;
    private final FloatBuffer c;
    private final float[] d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/animation/CommonProcessingRender$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10563a = new a(null);
    }

    public c(Context r9) {
        this.f10564b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        float[] r10 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.d = r10;
        this.H = new b();
        FloatBuffer r0 = ByteBuffer.allocateDirect(r10.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(r0, "asFloatBuffer(...)");
        this.c = r0;
        r0.put(r10).position(0);
        Point r11 = v.f11566a.a();
        int r1 = r11.x;
        int r12 = r11.y;
        double r2 = r1;
        double r4 = r2 * 0.5d;
        this.G = (float) ((Math.sqrt(((r2 * r4) * 0.5d) + ((double) (r12 * r12))) * ((double) 2)) + (r4 * 0.5d));
    }

    private final int a(int r3, String r4) {
        int r2 = GLES30.glCreateShader(r3);
        if (r2 == 0) goto L8;
        GLES30.glShaderSource(r2, r4);
        GLES30.glCompileShader(r2);
        int[] r5 = new int[1];
        GLES30.glGetShaderiv(r2, 35713, r5, 0);
        if (r5[0] != 0) goto L9;
        Log.e("CommonProcessingRender", "Could not compile shader " + r3 + ':');
        Log.e("CommonProcessingRender", GLES30.glGetShaderInfoLog(r2));
        GLES30.glDeleteShader(r2);
        return 0;
    L9:
        return r2;
    L8:
        return r2;
    }

    private final int a(String r4) {
        int r0 = a(35633, "\n                #version 300 es\n                in vec4 vPosition;\n                void main() {\n                    gl_Position = vPosition;\n                }\n            ");
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r5 = a(35632, r4);
        if (r5 != 0) goto L8;
        return 0;
    L8:
        int r2 = GLES30.glCreateProgram();
        if (r2 == 0) goto L14;
        GLES30.glAttachShader(r2, r0);
        b("glAttachShader");
        GLES30.glAttachShader(r2, r5);
        b("glAttachShader");
        GLES30.glLinkProgram(r2);
        int[] r6 = new int[1];
        GLES30.glGetProgramiv(r2, 35714, r6, 0);
        if (r6[0] == 1) goto L14;
        Log.e("CommonProcessingRender", "Could not link program: ");
        Log.e("CommonProcessingRender", GLES30.glGetProgramInfoLog(r2));
        GLES30.glDeleteProgram(r2);
        return 0;
    L14:
        return r2;
    }

    private final String a(int r14) {
        Context r13 = this.f10564b;     // Catch: Exception -> L29
        if (r13 != null) goto L6;
        return null;
    L6:
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").openRawResource(r14), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(r15, InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedReader((Reader) ZeusTransformUtils.preCheckCast((InputStreamReader) ZeusTransformUtils.preCheckCast(r16, InputStreamReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        String r0 = SequencesKt.joinToString$default(TextStreamsKt.lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r2, BufferedReader.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r15, null);     // Catch: Exception -> L29
        return r0;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Exception -> L29
        throw th;     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private final void b(String r4) {
        int r3 = GLES30.glGetError();
        if (r3 != 0) goto L5;
        return;
    L5:
        Log.e("CommonProcessingRender", r4 + ": glError " + r3);
        throw new RuntimeException(r4 + ": glError " + r3);
    }

    public final void a() {
        this.H.a(this.G);
    }

    public final void a(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onEnd");
        this.H.a(this.G, r4);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r10) {
        GL10 r11 = (GL10) ZeusTransformUtils.wrapperContextForParams(r10, GL10.class, "com.obric.memorydata.plugin");
        Thread.sleep(18);     // Catch: InterruptedException -> L11
        com.obric.memorydata.memory.ui.a.a.a().b().a();
        GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES30.glClear(17664);
        GLES30.glUniform1f(this.e, (System.currentTimeMillis() % 100000) / 1000.0f);
        int r12 = this.A;
        if (r12 == this.B) goto L7;
    L8:
        this.B = r12;
        int r0 = this.C;
        this.D = r0;
        GLES30.glUniform2f(this.f, r12, r0);
    L9:
        GLES30.glUniform1f(this.g, 1.0f);
        GLES30.glUniform1f(this.h, TypedValue.applyDimension(1, 37, Resources.getSystem().getDisplayMetrics()));
        GLES30.glUniform1i(this.i, 0);
        GLES30.glUniform1i(this.j, 0);
        GLES30.glUniform1f(this.k, 1.0f);
        GLES30.glUniform1f(this.l, 64.0f);
        GLES30.glUniform1f(this.m, 6.0f);
        GLES30.glUniform1f(this.n, 0.5f);
        GLES30.glUniform1f(this.o, 0.05f);
        GLES30.glUniform1f(this.p, 640.0f);
        GLES30.glUniform1f(this.q, 0.45f);
        GLES30.glUniform1i(this.r, 0);
        GLES30.glUniform1f(this.s, 0.25f);
        GLES30.glUniform1i(this.t, 1);
        GLES30.glUniform2f(this.u, this.A * 0.5f, this.C);
        GLES30.glUniform1f(this.v, this.A * 0.5f);
        GLES30.glUniform1f(this.w, this.H.a());
        GLES30.glUniform1f(this.x, this.H.b());
        GLES30.glUniform1f(this.y, this.H.c());
        GLES30.glUniform1f(this.z, this.H.d());
        GLES30.glVertexAttribPointer(this.F, 2, 5126, false, 0, (Buffer) ZeusTransformUtils.preCheckCast(this.c, Buffer.class, "com.obric.memorydata.plugin"));
        GLES30.glEnableVertexAttribArray(this.F);
        GLES30.glDrawArrays(6, 0, 4);
        return;
    L7:
        if (this.C == this.D) goto L9;
    L11:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r3, int r4, int r5) {
        GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.memorydata.plugin");
        this.A = r4;
        this.C = r5;
        GLES30.glViewport(0, 0, r4, r5);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r2, EGLConfig r3) {
        GL10 r4 = (GL10) ZeusTransformUtils.wrapperContextForParams(r2, GL10.class, "com.obric.memorydata.plugin");
        int r5 = a(a(ZeusTransformUtils.mapRes(R.raw.processing, "raw", "processing")));
        this.E = r5;
        if (r5 != 0) goto L5;
        return;
    L5:
        this.F = GLES30.glGetAttribLocation(r5, "vPosition");
        b("glGetAttribLocation");
        this.e = GLES30.glGetUniformLocation(this.E, "uTime");
        this.f = GLES30.glGetUniformLocation(this.E, "uResolution");
        this.g = GLES30.glGetUniformLocation(this.E, "uAlpha");
        this.h = GLES30.glGetUniformLocation(this.E, "uRadius");
        this.i = GLES30.glGetUniformLocation(this.E, "uTextureEnabled");
        this.j = GLES30.glGetUniformLocation(this.E, "uDotsEnabled");
        this.k = GLES30.glGetUniformLocation(this.E, "uDotsAlpha");
        this.l = GLES30.glGetUniformLocation(this.E, "uDotsGridSize");
        this.m = GLES30.glGetUniformLocation(this.E, "uDotsSize");
        this.n = GLES30.glGetUniformLocation(this.E, "uDotsSpeed");
        this.o = GLES30.glGetUniformLocation(this.E, "uDotsMovement");
        this.p = GLES30.glGetUniformLocation(this.E, "uNoiseSize");
        this.q = GLES30.glGetUniformLocation(this.E, "uNoiseSpeed");
        this.r = GLES30.glGetUniformLocation(this.E, "uSurfaceEffectEnabled");
        this.s = GLES30.glGetUniformLocation(this.E, "uSurfaceEffectAlpha");
        this.t = GLES30.glGetUniformLocation(this.E, "uEdgeEffectEnabled");
        this.w = GLES30.glGetUniformLocation(this.E, "uEdgeEffectAlpha");
        this.x = GLES30.glGetUniformLocation(this.E, "uEdgeWidth");
        this.u = GLES30.glGetUniformLocation(this.E, "uMaskCenter");
        this.v = GLES30.glGetUniformLocation(this.E, "uMaskEdge");
        this.y = GLES30.glGetUniformLocation(this.E, "uMaskEnterSize");
        this.z = GLES30.glGetUniformLocation(this.E, "uMaskExitSize");
        if (this.F == (-1)) goto L10;
        GLES30.glUseProgram(this.E);
        b("glUseProgram");
        return;
    L10:
        throw new RuntimeException("Could not get attrib location for vPosition");
    }
}
