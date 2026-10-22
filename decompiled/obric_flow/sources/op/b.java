package op;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import com.obric.common.oea.foundation.effect.GL3ShaderViewKawaseBlur;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements GLSurfaceView.Renderer {
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
    public final float[] O;
    public final FloatBuffer P;
    public Bitmap Q;
    public Bitmap R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20842a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f20843a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20844b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f20845b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20846c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f20847c0;
    public int d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f20848d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final /* synthetic */ GL3ShaderViewKawaseBlur f20849e0;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f20855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f20856n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20857o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20858p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20859q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20860r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20861t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f20862u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f20863v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20864w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20865x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f20866y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20867z;

    public b(GL3ShaderViewKawaseBlur r5) {
        this.f20849e0 = r5;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        float[] r10 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.O = r10;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f20843a0 = 0;
        this.f20845b0 = 0;
        this.f20847c0 = 0.0f;
        this.f20848d0 = 0.0f;
        FloatBuffer r11 = ByteBuffer.allocateDirect(r10.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r10);
        this.P = r11;
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
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
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
        GLES20.glBufferData(34962, this.O.length * 4, this.P, 35044);
        GLES20.glEnableVertexAttribArray(r13);
        GLES20.glVertexAttribPointer(r13, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES30.glBindVertexArray(0);
        GLES20.glUseProgram(0);
        return new int[]{r10, r14};
    }

    public final void f(float r5, int r10, int r11, int r12, int r13) {
        GLES20.glViewport(0, 0, r12, r13);
        GLES20.glBindFramebuffer(36160, r11);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.g);
        GLES20.glUniform2f(this.f20852j, r12, r13);
        GLES20.glUniform1f(this.f20853k, r5);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20851i, 0);
        GLES30.glBindVertexArray(this.f20854l);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        if (r11 == 0) goto L6;
        GLES20.glBindFramebuffer(36160, 0);
        return;
    }

    public final void g(float r5, int r10, int r11, int r12, int r13) {
        GLES20.glViewport(0, 0, r12, r13);
        GLES20.glBindFramebuffer(36160, r11);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20855m);
        GLES20.glUniform2f(this.f20858p, r12, r13);
        GLES20.glUniform1f(this.f20859q, r5);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20857o, 0);
        GLES30.glBindVertexArray(this.f20860r);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final void h(int r5, int r10, float r11, boolean r12) {
        GLES20.glViewport(0, 0, this.C, this.E);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.s);
        GLES20.glUniform2f(this.f20864w, this.C, this.E);
        GLES20.glUniform1i(this.f20865x, r12 ? 1 : 0);
        GLES20.glUniform1f(this.f20866y, r11);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r5);
        GLES20.glUniform1i(this.f20862u, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20863v, 1);
        GLES30.glBindVertexArray(this.f20867z);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
    }

    public final void i(int r10, int r11) {
        if (r11 == 0) goto L5;
        GLES20.glViewport(0, 0, this.G, this.H);
        GLES20.glBindFramebuffer(36160, r11);
    L6:
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20842a);
        if (r11 == 0) goto L9;
        GLES20.glUniform2f(this.d, this.G, this.H);
        GLES20.glUniform1i(this.e, 1);
    L10:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r10);
        GLES20.glUniform1i(this.f20846c, 0);
        GLES30.glBindVertexArray(this.f);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        GLES20.glBindTexture(3553, 0);
        if (r11 == 0) goto L14;
        GLES20.glBindFramebuffer(36160, 0);
        return;
    L14:
        return;
    L9:
        GLES20.glUniform2f(this.d, this.C, this.E);
        GLES20.glUniform1i(this.e, 0);
        goto L10
    L5:
        GLES20.glViewport(0, 0, this.C, this.E);
        goto L6
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r23) {
        int r5 = this.C;
        if (r5 == 0) goto L43;
        int r10 = this.E;
        if (r10 != 0) goto L8;
        return;
    L8:
        if (r5 == this.D) goto L10;
    L13:
        boolean r11 = true;
    L15:
        if (this.R == this.Q) goto L23;
        int r12 = this.A;
        if (r12 == 0) goto L19;
        GLES20.glDeleteTextures(1, new int[]{r12}, 0);
    L19:
        Bitmap r13 = this.R;
        int[] r14 = new int[1];
        GLES20.glGenTextures(1, r14, 0);
        int r15 = r14[0];
        if (r15 == 0) goto L22;
        GLES20.glBindTexture(3553, r15);
        GLUtils.texImage2D(3553, 0, r13, 0);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
    L22:
        this.A = r14[0];
        r11 = true;
    L23:
        if (r11 == false) goto L28;
        i(this.A, this.S);
        if (this.B != 0) goto L27;
        int r16 = this.G;
        int r17 = this.H;
        int[] r18 = new int[1];
        GLES20.glGenTextures(1, r18, 0);
        GLES20.glBindTexture(3553, r18[0]);
        GLES20.glTexImage2D(3553, 0, 6408, r16, r17, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        this.B = r18[0];
    L27:
        GLES20.glBindFramebuffer(36160, this.S);
        GLES20.glBindTexture(3553, this.B);
        GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.G, this.H);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
    L28:
        float r19 = this.f20847c0;
        if (r19 < 150.0f) goto L32;
        float r20 = r19 / 120.0f;
        f(r20, this.B, this.W, this.I, this.J);
        f(r20, this.X, this.Y, this.K, this.L);
        f(r20, this.Z, this.f20843a0, this.M, this.N);
        g(r20, this.f20845b0, this.Y, this.K, this.L);
        g(r20, this.Z, this.W, this.I, this.J);
        g(r20, this.X, this.S, this.G, this.H);
        i(this.T, 0);
    L41:
        this.D = this.C;
        this.F = this.E;
        this.Q = this.R;
        return;
    L32:
        if (r19 < 120.0f) goto L35;
        float r21 = r19 / 120.0f;
        f(r21, this.B, this.W, this.I, this.J);
        f(r21, this.X, this.Y, this.K, this.L);
        f(r21, this.Z, this.f20843a0, this.M, this.N);
        g(r21, this.f20845b0, this.Y, this.K, this.L);
        g(r21, this.Z, this.W, this.I, this.J);
        g(r21, this.X, this.U, this.G, this.H);
        float r22 = this.f20847c0 / 30.0f;
        f(r22, this.B, this.W, this.I, this.J);
        g(r22, this.X, this.S, this.G, this.H);
        f(r22, this.T, this.W, this.I, this.J);
        g(r22, this.X, this.S, this.G, this.H);
        f(r22, this.T, this.W, this.I, this.J);
        g(r22, this.X, this.S, this.G, this.H);
        h(this.T, this.V, 1.0f - ((150.0f - this.f20847c0) / 30.0f), false);
        goto L41
    L35:
        if (r19 < 30.0f) goto L38;
        float r24 = r19 / 30.0f;
        f(r24, this.B, this.W, this.I, this.J);
        g(r24, this.X, this.S, this.G, this.H);
        f(r24, this.T, this.W, this.I, this.J);
        g(r24, this.X, this.S, this.G, this.H);
        f(r24, this.T, this.W, this.I, this.J);
        g(r24, this.X, this.S, this.G, this.H);
        i(this.T, 0);
        goto L41
    L38:
        if (r19 < 15.0f) goto L40;
        float r25 = r19 / 15.0f;
        f(r25, this.B, this.S, this.G, this.H);
        g(r25, this.T, this.U, this.G, this.H);
        f(r25, this.V, this.S, this.G, this.H);
        g(r25, this.T, this.U, this.G, this.H);
        f(r25, this.V, this.S, this.G, this.H);
        g(r25, this.T, this.U, this.G, this.H);
        float r26 = this.f20847c0 / 30.0f;
        f(r26, this.B, this.W, this.I, this.J);
        g(r26, this.X, this.S, this.G, this.H);
        f(r26, this.T, this.W, this.I, this.J);
        g(r26, this.X, this.S, this.G, this.H);
        f(r26, this.T, this.W, this.I, this.J);
        g(r26, this.X, this.S, this.G, this.H);
        h(this.V, this.T, 1.0f - ((30.0f - this.f20847c0) / 15.0f), false);
        goto L41
    L40:
        f(1.0f, this.B, this.S, this.G, this.H);
        g(1.0f, this.T, this.U, this.G, this.H);
        f(1.0f, this.V, this.S, this.G, this.H);
        g(1.0f, this.T, this.U, this.G, this.H);
        f(1.0f, this.V, this.S, this.G, this.H);
        g(1.0f, this.T, this.U, this.G, this.H);
        h(this.A, this.V, this.f20847c0 / 15.0f, true);
        goto L41
    L10:
        if (r10 != this.F) goto L13;
        r11 = false;
        goto L15
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r5, int r10, int r11) {
        this.C = r10;
        this.E = r11;
        if (r10 == 0) goto L43;
        if (r11 != 0) goto L7;
        return;
    L7:
        if (r10 == this.D) goto L9;
    L11:
        int r12 = this.S;
        if (r12 == 0) goto L14;
        GLES20.glDeleteFramebuffers(1, new int[]{r12}, 0);
    L14:
        int r13 = this.T;
        if (r13 == 0) goto L17;
        GLES20.glDeleteTextures(1, new int[]{r13}, 0);
    L17:
        int r14 = this.U;
        if (r14 == 0) goto L20;
        GLES20.glDeleteFramebuffers(1, new int[]{r14}, 0);
    L20:
        int r15 = this.V;
        if (r15 == 0) goto L23;
        GLES20.glDeleteTextures(1, new int[]{r15}, 0);
    L23:
        int r16 = this.W;
        if (r16 == 0) goto L26;
        GLES20.glDeleteFramebuffers(1, new int[]{r16}, 0);
    L26:
        int r17 = this.X;
        if (r17 == 0) goto L29;
        GLES20.glDeleteTextures(1, new int[]{r17}, 0);
    L29:
        int r18 = this.Y;
        if (r18 == 0) goto L32;
        GLES20.glDeleteFramebuffers(1, new int[]{r18}, 0);
    L32:
        int r19 = this.Z;
        if (r19 == 0) goto L35;
        GLES20.glDeleteTextures(1, new int[]{r19}, 0);
    L35:
        int r20 = this.f20843a0;
        if (r20 == 0) goto L38;
        GLES20.glDeleteFramebuffers(1, new int[]{r20}, 0);
    L38:
        int r21 = this.f20845b0;
        if (r21 == 0) goto L41;
        GLES20.glDeleteTextures(1, new int[]{r21}, 0);
    L41:
        int r22 = this.C / 4;
        this.G = r22;
        int r23 = this.E / 4;
        this.H = r23;
        int[] r24 = b(r22, r23);
        this.S = r24[0];
        this.T = r24[1];
        int[] r25 = b(this.G, this.H);
        this.U = r25[0];
        this.V = r25[1];
        this.I = (int) Math.ceil(this.G / 2.0f);
        int r26 = (int) Math.ceil(this.H / 2.0f);
        this.J = r26;
        int[] r27 = b(this.I, r26);
        this.W = r27[0];
        this.X = r27[1];
        this.K = (int) Math.ceil(this.I / 2.0f);
        int r28 = (int) Math.ceil(this.J / 2.0f);
        this.L = r28;
        int[] r29 = b(this.K, r28);
        this.Y = r29[0];
        this.Z = r29[1];
        this.M = (int) Math.ceil(this.K / 2.0f);
        int r30 = (int) Math.ceil(this.L / 2.0f);
        this.N = r30;
        int[] r31 = b(this.M, r30);
        this.f20843a0 = r31[0];
        this.f20845b0 = r31[1];
        return;
    L9:
        if (r11 != this.F) goto L11;
        return;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r10, EGLConfig r11) {
        int r12 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
        this.f20842a = r12;
        this.f20844b = GLES20.glGetAttribLocation(r12, "vPosition");
        a("glGetAttribLocation");
        this.f20846c = GLES20.glGetUniformLocation(this.f20842a, "u_background");
        a("glGetAttribLocation");
        this.d = GLES20.glGetUniformLocation(this.f20842a, "u_resolution");
        a("glGetUniformLocation");
        this.e = GLES20.glGetUniformLocation(this.f20842a, "u_revert");
        a("glGetUniformLocation");
        this.f = e(this.f20842a, this.f20844b)[0];
        int r5 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n");
        this.g = r5;
        this.f20850h = GLES20.glGetAttribLocation(r5, "vPosition");
        a("glGetAttribLocation");
        this.f20851i = GLES20.glGetUniformLocation(this.g, "u_background");
        a("glGetAttribLocation");
        this.f20852j = GLES20.glGetUniformLocation(this.g, "u_resolution");
        a("glGetUniformLocation");
        this.f20853k = GLES20.glGetUniformLocation(this.g, "u_blurOffset");
        a("glGetUniformLocation");
        this.f20854l = e(this.g, this.f20850h)[0];
        int r13 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
        this.f20855m = r13;
        this.f20856n = GLES20.glGetAttribLocation(r13, "vPosition");
        a("glGetAttribLocation");
        this.f20857o = GLES20.glGetUniformLocation(this.f20855m, "u_background");
        a("glGetAttribLocation");
        this.f20858p = GLES20.glGetUniformLocation(this.f20855m, "u_resolution");
        a("glGetUniformLocation");
        this.f20859q = GLES20.glGetUniformLocation(this.f20855m, "u_blurOffset");
        a("glGetUniformLocation");
        this.f20860r = e(this.f20855m, this.f20856n)[0];
        int r14 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n");
        this.s = r14;
        this.f20861t = GLES20.glGetAttribLocation(r14, "vPosition");
        a("glGetAttribLocation");
        this.f20862u = GLES20.glGetUniformLocation(this.s, "u_background");
        a("glGetAttribLocation");
        this.f20863v = GLES20.glGetUniformLocation(this.s, "u_foreground");
        a("glGetAttribLocation");
        this.f20864w = GLES20.glGetUniformLocation(this.s, "u_resolution");
        a("glGetUniformLocation");
        this.f20865x = GLES20.glGetUniformLocation(this.s, "u_revert");
        a("glGetUniformLocation");
        this.f20866y = GLES20.glGetUniformLocation(this.s, "u_alpha");
        a("glGetUniformLocation");
        this.f20867z = e(this.s, this.f20861t)[0];
    }
}
