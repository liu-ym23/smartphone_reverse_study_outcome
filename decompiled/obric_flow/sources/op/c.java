package op;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import com.obric.common.oea.foundation.effect.GL3ShaderViewProgressBlur;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements GLSurfaceView.Renderer {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public final float[] S;
    public final FloatBuffer T;
    public Bitmap U;
    public Bitmap V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20868a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f20869a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20870b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f20871b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20872c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f20873c0;
    public int d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f20874d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f20875e0;
    public int f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f20876f0;
    public int g;
    public int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20877h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f20878h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20879i;
    public float i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20880j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f20881j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20882k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Rect f20883k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20884l;
    public final Rect l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f20885m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final /* synthetic */ GL3ShaderViewProgressBlur f20886m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f20887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20891r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f20893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f20894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20896x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f20897y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20898z;

    public c(GL3ShaderViewProgressBlur r5) {
        this.f20886m0 = r5;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        float[] r10 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.S = r10;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f20869a0 = 0;
        this.f20871b0 = 0;
        this.f20873c0 = 0;
        this.f20874d0 = 0;
        this.f20875e0 = 0;
        this.f20876f0 = 0;
        this.g0 = 0;
        this.f20878h0 = 0;
        this.i0 = 60.0f;
        this.f20881j0 = 0;
        this.f20883k0 = new Rect(0, 0, 1264, 400);
        this.l0 = new Rect(0, 0, 1264, 400);
        FloatBuffer r11 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r10);
        this.T = r11;
        r11.position(0);
    }

    public static void a(String r5) {
        int r10 = GLES20.glGetError();
        if (r10 != 0) goto L5;
        return;
    L5:
        Log.e("GL3BlurRenderer", r5 + ": glError " + r10);
        throw new RuntimeException(r5 + ": glError " + r10);
    }

    public static int[] b(int r15, int r16) {
        int[] r5 = new int[1];
        GLES20.glGenFramebuffers(1, r5, 0);
        GLES20.glBindFramebuffer(36160, r5[0]);
        int[] r10 = new int[1];
        GLES20.glGenTextures(1, r10, 0);
        GLES20.glBindTexture(3553, r10[0]);
        GLES20.glTexImage2D(3553, 0, 6408, r15, r16, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33648);
        GLES20.glTexParameteri(3553, 10243, 33648);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r10[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
        return new int[]{r5[0], r10[0]};
    }

    public static int c(String r5) {
        int r10 = d(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r11 = d(35632, r5);
        if (r11 != 0) goto L8;
        return 0;
    L8:
        int r12 = GLES20.glCreateProgram();
        if (r12 == 0) goto L14;
        GLES20.glAttachShader(r12, r10);
        a("glAttachShader");
        GLES20.glAttachShader(r12, r11);
        a("glAttachShader");
        GLES20.glLinkProgram(r12);
        int[] r13 = new int[1];
        GLES20.glGetProgramiv(r12, 35714, r13, 0);
        if (r13[0] == 1) goto L14;
        Log.e("GL3BlurRenderer", "Could not link program: ");
        Log.e("GL3BlurRenderer", GLES20.glGetProgramInfoLog(r12));
        GLES20.glDeleteProgram(r12);
        return 0;
    L14:
        return r12;
    }

    public static int d(int r5, String r10) {
        int r11 = GLES20.glCreateShader(r5);
        if (r11 == 0) goto L8;
        GLES20.glShaderSource(r11, r10);
        GLES20.glCompileShader(r11);
        int[] r12 = new int[1];
        GLES20.glGetShaderiv(r11, 35713, r12, 0);
        if (r12[0] != 0) goto L9;
        Log.e("GL3BlurRenderer", "Could not compile shader " + r5 + ":");
        Log.e("GL3BlurRenderer", GLES20.glGetShaderInfoLog(r11));
        GLES20.glDeleteShader(r11);
        return 0;
    L9:
        return r11;
    L8:
        return r11;
    }

    public final int[] e(int r12, int r13) {
        GLES20.glUseProgram(r12);
        int[] r5 = new int[1];
        GLES30.glGenVertexArrays(1, r5, 0);
        int r10 = r5[0];
        GLES30.glBindVertexArray(r10);
        int[] r11 = new int[1];
        GLES20.glGenBuffers(1, r11, 0);
        int r14 = r11[0];
        GLES20.glBindBuffer(34962, r14);
        GLES20.glBufferData(34962, this.S.length * 4, this.T, 35044);
        GLES20.glEnableVertexAttribArray(r13);
        GLES20.glVertexAttribPointer(r13, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES30.glBindVertexArray(0);
        GLES20.glUseProgram(0);
        return new int[]{r10, r14};
    }

    public final void f() {
        int r5 = this.Y;
        if (r5 == 0) goto L5;
        GLES20.glDeleteFramebuffers(1, new int[]{r5}, 0);
    L5:
        int r10 = this.Z;
        if (r10 == 0) goto L8;
        GLES20.glDeleteTextures(1, new int[]{r10}, 0);
    L8:
        int r11 = this.f20869a0;
        if (r11 == 0) goto L11;
        GLES20.glDeleteFramebuffers(1, new int[]{r11}, 0);
    L11:
        int r12 = this.f20871b0;
        if (r12 == 0) goto L14;
        GLES20.glDeleteTextures(1, new int[]{r12}, 0);
    L14:
        int r13 = this.f20873c0;
        if (r13 == 0) goto L17;
        GLES20.glDeleteFramebuffers(1, new int[]{r13}, 0);
    L17:
        int r14 = this.f20874d0;
        if (r14 == 0) goto L20;
        GLES20.glDeleteTextures(1, new int[]{r14}, 0);
    L20:
        int r15 = this.f20875e0;
        if (r15 == 0) goto L23;
        GLES20.glDeleteFramebuffers(1, new int[]{r15}, 0);
    L23:
        int r16 = this.f20876f0;
        if (r16 == 0) goto L26;
        GLES20.glDeleteTextures(1, new int[]{r16}, 0);
    L26:
        int r17 = this.g0;
        if (r17 == 0) goto L29;
        GLES20.glDeleteFramebuffers(1, new int[]{r17}, 0);
    L29:
        int r18 = this.f20878h0;
        if (r18 == 0) goto L32;
        GLES20.glDeleteTextures(1, new int[]{r18}, 0);
    L32:
        Rect r19 = this.f20883k0;
        int[] r20 = b(r19.width(), r19.height());
        this.Y = r20[0];
        this.Z = r20[1];
        int[] r21 = b(r19.width(), r19.height());
        this.f20869a0 = r21[0];
        this.f20871b0 = r21[1];
        this.O = r19.width() / 2;
        int r22 = r19.height() / 2;
        this.P = r22;
        int[] r23 = b(this.O, r22);
        this.f20873c0 = r23[0];
        this.f20874d0 = r23[1];
        int[] r24 = b(this.O, this.P);
        this.f20875e0 = r24[0];
        this.f20876f0 = r24[1];
        this.Q = (int) Math.ceil(this.O / 2.0f);
        int r25 = (int) Math.ceil(this.P / 2.0f);
        this.R = r25;
        int[] r26 = b(this.Q, r25);
        this.g0 = r26[0];
        this.f20878h0 = r26[1];
    }

    public final void g(float r5, int r10, int r11, int r12, int r13) {
        GLES20.glViewport(0, 0, r12, r13);
        GLES20.glBindFramebuffer(36160, r11);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20877h);
        GLES20.glUniform2f(this.f20882k, r12, r13);
        GLES20.glUniform1f(this.f20885m, r5);
        int r14 = this.f20881j0;
        if (r14 != 0) goto L6;
        GLES20.glUniform4f(this.f20884l, 0.0f, 0.0f, 0.0f, 1.0f);
    L8:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20880j, 0);
        GLES30.glBindVertexArray(this.f20887n);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        if (r11 == 0) goto L12;
        GLES20.glBindFramebuffer(36160, 0);
        return;
    L12:
        return;
    L6:
        if (r14 != 1) goto L8;
        GLES20.glUniform4f(this.f20884l, 0.0f, 1.0f, 0.0f, -1.0f);
        goto L8
    }

    public final void h(float r5, int r10, int r11, int r12, int r13) {
        GLES20.glViewport(0, 0, r12, r13);
        GLES20.glBindFramebuffer(36160, r11);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20888o);
        GLES20.glUniform2f(this.f20891r, r12, r13);
        GLES20.glUniform1f(this.f20892t, r5);
        int r14 = this.f20881j0;
        if (r14 != 0) goto L6;
        GLES20.glUniform4f(this.s, 0.0f, 0.0f, 0.0f, 1.0f);
    L8:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20890q, 0);
        GLES30.glBindVertexArray(this.f20893u);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        GLES20.glBindFramebuffer(36160, 0);
        return;
    L6:
        if (r14 != 1) goto L8;
        GLES20.glUniform4f(this.s, 0.0f, 1.0f, 0.0f, -1.0f);
        goto L8
    }

    public final void i(int r10, int r11) {
        Rect r5 = this.f20883k0;
        if (r11 == 0) goto L5;
        GLES20.glViewport(0, 0, r5.width(), r5.height());
        GLES20.glBindFramebuffer(36160, r11);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
    L6:
        GLES20.glUseProgram(this.f20894v);
        float r12 = r5.left / this.K;
        int r13 = this.M;
        float r14 = (r13 - r5.bottom) / r13;
        float r15 = r5.width() / this.K;
        float r16 = r5.height();
        int r17 = this.M;
        float r18 = r16 / r17;
        if (r11 == 0) goto L9;
        GLES20.glUniform2f(this.f20897y, r5.width(), r5.height());
        GLES20.glUniform4f(this.f20898z, r12, r14, r15, r18);
    L10:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20896x, 0);
        GLES30.glBindVertexArray(this.A);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        GLES20.glBindTexture(3553, 0);
        if (r11 == 0) goto L14;
        GLES20.glBindFramebuffer(36160, 0);
        return;
    L14:
        return;
    L9:
        GLES20.glUniform2f(this.f20897y, this.K, r17);
        GLES20.glUniform4f(this.f20898z, (-r12) / r15, (-r14) / r18, 1.0f / r15, 1.0f / r18);
        goto L10
    L5:
        GLES20.glViewport(0, 0, this.K, this.M);
        goto L6
    }

    public final void j(int r10, int r11, boolean r12) {
        GLES20.glViewport(0, 0, this.K, this.M);
        if (r11 == 0) goto L5;
        GLES20.glBindFramebuffer(36160, r11);
    L5:
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20868a);
        GLES20.glUniform2f(this.d, this.K, this.M);
        GLES20.glUniform1i(this.e, r12 ? 1 : 0);
        GLES20.glUniform2f(this.f, 0.0f, 0.0f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20872c, 0);
        GLES30.glBindVertexArray(this.g);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        GLES20.glBindTexture(3553, 0);
        if (r11 == 0) goto L9;
        GLES20.glBindFramebuffer(36160, 0);
        return;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r13) {
        if (this.K != 0) goto L5;
        return;
    L5:
        if (this.M != 0) goto L8;
        return;
    L8:
        if (this.V == this.U) goto L16;
        int r14 = this.J;
        if (r14 == 0) goto L12;
        GLES20.glDeleteTextures(1, new int[]{r14}, 0);
    L12:
        Bitmap r15 = this.V;
        int[] r5 = new int[1];
        GLES20.glGenTextures(1, r5, 0);
        int r10 = r5[0];
        if (r10 == 0) goto L15;
        GLES20.glBindTexture(3553, r10);
        GLUtils.texImage2D(3553, 0, r15, 0);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        GLES20.glBindTexture(3553, 0);
    L15:
        this.J = r5[0];
    L16:
        j(this.J, this.W, true);
        Rect r16 = this.l0;
        int r11 = r16.width();
        Rect r12 = this.f20883k0;
        if (r11 == r12.width()) goto L19;
    L20:
        f();
    L21:
        i(this.X, this.Y);
        float r17 = this.i0 / 30.0f;
        g(r17, this.Z, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        g(r17, this.f20874d0, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        g(r17, this.f20874d0, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        g(r17, this.f20874d0, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        g(r17, this.f20874d0, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        g(r17, this.f20874d0, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        g(r17, this.f20874d0, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        g(r17, this.f20874d0, this.g0, this.Q, this.R);
        h(r17, this.f20878h0, this.f20873c0, this.O, this.P);
        int r18 = this.Z;
        int r19 = this.f20874d0;
        int r20 = this.f20869a0;
        GLES20.glViewport(0, 0, r12.width(), r12.height());
        GLES20.glBindFramebuffer(36160, r20);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.B);
        GLES20.glUniform2f(this.F, r12.width(), r12.height());
        GLES20.glUniform1f(this.H, r17);
        int r21 = this.f20881j0;
        if (r21 != 0) goto L24;
        GLES20.glUniform4f(this.G, 0.0f, 0.0f, 0.0f, 1.0f);
    L26:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r18);
        GLES20.glUniform1i(this.D, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, r19);
        GLES20.glUniform1i(this.E, 1);
        GLES30.glBindVertexArray(this.I);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        GLES20.glBindFramebuffer(36160, 0);
        j(this.X, 0, false);
        i(this.f20871b0, 0);
        this.L = this.K;
        this.N = this.M;
        this.U = this.V;
        r16.set(r12);
        return;
    L24:
        if (r21 != 1) goto L26;
        GLES20.glUniform4f(this.G, 0.0f, 1.0f, 0.0f, -1.0f);
        goto L26
    L19:
        if (r16.height() == r12.height()) goto L21;
        goto L20
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r5, int r10, int r11) {
        this.K = r10;
        this.M = r11;
        if (r10 == 0) goto L19;
        if (r11 != 0) goto L7;
        return;
    L7:
        if (r10 == this.L) goto L9;
    L11:
        int r12 = this.W;
        if (r12 == 0) goto L14;
        GLES20.glDeleteFramebuffers(1, new int[]{r12}, 0);
    L14:
        int r13 = this.X;
        if (r13 == 0) goto L17;
        GLES20.glDeleteTextures(1, new int[]{r13}, 0);
    L17:
        int[] r14 = b(this.K, this.M);
        this.W = r14[0];
        this.X = r14[1];
        f();
        return;
    L9:
        if (r11 != this.N) goto L11;
        return;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r10, EGLConfig r11) {
        int r12 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
        this.f20868a = r12;
        this.f20870b = GLES20.glGetAttribLocation(r12, "vPosition");
        a("glGetAttribLocation");
        this.f20872c = GLES20.glGetUniformLocation(this.f20868a, "u_background");
        a("glGetAttribLocation");
        this.d = GLES20.glGetUniformLocation(this.f20868a, "u_resolution");
        a("glGetUniformLocation");
        this.e = GLES20.glGetUniformLocation(this.f20868a, "u_revert");
        a("glGetUniformLocation");
        this.f = GLES20.glGetUniformLocation(this.f20868a, "u_uvOffset");
        a("glGetUniformLocation");
        this.g = e(this.f20868a, this.f20870b)[0];
        int r5 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n");
        this.f20877h = r5;
        this.f20879i = GLES20.glGetAttribLocation(r5, "vPosition");
        a("glGetAttribLocation");
        this.f20880j = GLES20.glGetUniformLocation(this.f20877h, "u_background");
        a("glGetAttribLocation");
        this.f20882k = GLES20.glGetUniformLocation(this.f20877h, "u_resolution");
        a("glGetUniformLocation");
        this.f20884l = GLES20.glGetUniformLocation(this.f20877h, "u_direction");
        a("glGetUniformLocation");
        this.f20885m = GLES20.glGetUniformLocation(this.f20877h, "u_blurOffset");
        a("glGetUniformLocation");
        this.f20887n = e(this.f20877h, this.f20879i)[0];
        int r13 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
        this.f20888o = r13;
        this.f20889p = GLES20.glGetAttribLocation(r13, "vPosition");
        a("glGetAttribLocation");
        this.f20890q = GLES20.glGetUniformLocation(this.f20888o, "u_background");
        a("glGetAttribLocation");
        this.f20891r = GLES20.glGetUniformLocation(this.f20888o, "u_resolution");
        a("glGetUniformLocation");
        this.s = GLES20.glGetUniformLocation(this.f20888o, "u_direction");
        a("glGetUniformLocation");
        this.f20892t = GLES20.glGetUniformLocation(this.f20888o, "u_blurOffset");
        a("glGetUniformLocation");
        this.f20893u = e(this.f20888o, this.f20889p)[0];
        int r14 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n");
        this.f20894v = r14;
        this.f20895w = GLES20.glGetAttribLocation(r14, "vPosition");
        a("glGetAttribLocation");
        this.f20896x = GLES20.glGetUniformLocation(this.f20894v, "u_background");
        a("glGetAttribLocation");
        this.f20897y = GLES20.glGetUniformLocation(this.f20894v, "u_resolution");
        a("glGetUniformLocation");
        this.f20898z = GLES20.glGetUniformLocation(this.f20894v, "u_clip");
        a("glGetUniformLocation");
        this.A = e(this.f20894v, this.f20895w)[0];
        int r15 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n");
        this.B = r15;
        this.C = GLES20.glGetAttribLocation(r15, "vPosition");
        a("glGetAttribLocation");
        this.D = GLES20.glGetUniformLocation(this.B, "u_background");
        a("glGetAttribLocation");
        this.E = GLES20.glGetUniformLocation(this.B, "u_foreground");
        a("glGetAttribLocation");
        this.F = GLES20.glGetUniformLocation(this.B, "u_resolution");
        a("glGetUniformLocation");
        this.G = GLES20.glGetUniformLocation(this.B, "u_direction");
        a("glGetUniformLocation");
        this.H = GLES20.glGetUniformLocation(this.B, "u_blurOffset");
        a("glGetUniformLocation");
        this.I = e(this.B, this.C)[0];
    }
}
