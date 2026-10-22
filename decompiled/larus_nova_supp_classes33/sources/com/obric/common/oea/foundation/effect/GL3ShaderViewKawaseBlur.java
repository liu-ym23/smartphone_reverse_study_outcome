package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {
    public a a;

    public class a implements GLSurfaceView.Renderer {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public float H0;
        public int I;
        public int J;
        public int K;
        public int L;
        public float L0;
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
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int k0;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int p0;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public int z;

        public a() {
            this.A = 0;
            this.B = 0;
            this.C = 0;
            this.D = 0;
            this.E = 0;
            this.F = 0;
            float[] r1 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.O = r1;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 0;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.k0 = 0;
            this.p0 = 0;
            this.H0 = 0.0f;
            this.L0 = 0.0f;
            FloatBuffer r2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r1);
            this.P = r2;
            r2.position(0);
        }

        public static void a(String r3) {
            int r0 = GLES30.glGetError();
            if (r0 != 0) goto L6;
            return;
        L6:
            throw new RuntimeException(r3 + ": glError " + r0);
        }

        public static int c(String r4) {
            int r0 = d(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
            if (r0 != 0) goto L5;
            return 0;
        L5:
            int r5 = d(35632, r4);
            if (r5 != 0) goto L8;
            return 0;
        L8:
            int r2 = GLES30.glCreateProgram();
            if (r2 == 0) goto L14;
            GLES30.glAttachShader(r2, r0);
            a("glAttachShader");
            GLES30.glAttachShader(r2, r5);
            a("glAttachShader");
            GLES30.glLinkProgram(r2);
            int[] r1 = new int[1];
            GLES30.glGetProgramiv(r2, 35714, r1, 0);
            if (r1[0] == 1) goto L14;
            GLES30.glGetProgramInfoLog(r2);
            GLES30.glDeleteProgram(r2);
            return 0;
        L14:
            return r2;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r23) {
            int r0 = this.C;
            if (r0 == 0) goto L43;
            int r1 = this.E;
            if (r1 != 0) goto L8;
            return;
        L8:
            if (r0 == this.D) goto L10;
        L13:
            boolean r2 = true;
        L15:
            if (this.R == this.Q) goto L23;
            int r3 = this.A;
            if (r3 == 0) goto L19;
            GLES30.glDeleteTextures(1, new int[]{r3}, 0);
        L19:
            Bitmap r4 = this.R;
            int[] r5 = new int[1];
            GLES30.glGenTextures(1, r5, 0);
            int r6 = r5[0];
            if (r6 == 0) goto L22;
            GLES30.glBindTexture(3553, r6);
            GLUtils.texImage2D(3553, 0, r4, 0);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
        L22:
            this.A = r5[0];
            r2 = true;
        L23:
            if (r2 == false) goto L28;
            k(this.A, this.S);
            if (this.B != 0) goto L27;
            int r7 = this.G;
            int r8 = this.H;
            int[] r9 = new int[1];
            GLES30.glGenTextures(1, r9, 0);
            GLES30.glBindTexture(3553, r9[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r7, r8, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
            this.B = r9[0];
        L27:
            GLES30.glBindFramebuffer(36160, this.S);
            GLES30.glBindTexture(3553, this.B);
            GLES30.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.G, this.H);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glBindTexture(3553, 0);
        L28:
            float r10 = this.H0;
            if (r10 < 150.0f) goto L32;
            float r11 = r10 / 120.0f;
            g(this.B, this.W, r11, this.I, this.J);
            g(this.X, this.Y, r11, this.K, this.L);
            g(this.Z, this.k0, r11, this.M, this.N);
            i(this.p0, this.Y, r11, this.K, this.L);
            i(this.Z, this.W, r11, this.I, this.J);
            i(this.X, this.S, r11, this.G, this.H);
            k(this.T, 0);
        L41:
            this.D = this.C;
            this.F = this.E;
            this.Q = this.R;
            return;
        L32:
            if (r10 < 120.0f) goto L35;
            float r12 = r10 / 120.0f;
            g(this.B, this.W, r12, this.I, this.J);
            g(this.X, this.Y, r12, this.K, this.L);
            g(this.Z, this.k0, r12, this.M, this.N);
            i(this.p0, this.Y, r12, this.K, this.L);
            i(this.Z, this.W, r12, this.I, this.J);
            i(this.X, this.U, r12, this.G, this.H);
            float r13 = this.H0 / 30.0f;
            g(this.B, this.W, r13, this.I, this.J);
            i(this.X, this.S, r13, this.G, this.H);
            g(this.T, this.W, r13, this.I, this.J);
            i(this.X, this.S, r13, this.G, this.H);
            g(this.T, this.W, r13, this.I, this.J);
            i(this.X, this.S, r13, this.G, this.H);
            j(this.T, this.V, 1.0f - ((150.0f - this.H0) / 30.0f), false);
            goto L41
        L35:
            if (r10 < 30.0f) goto L38;
            float r14 = r10 / 30.0f;
            g(this.B, this.W, r14, this.I, this.J);
            i(this.X, this.S, r14, this.G, this.H);
            g(this.T, this.W, r14, this.I, this.J);
            i(this.X, this.S, r14, this.G, this.H);
            g(this.T, this.W, r14, this.I, this.J);
            i(this.X, this.S, r14, this.G, this.H);
            k(this.T, 0);
            goto L41
        L38:
            if (r10 < 15.0f) goto L40;
            float r15 = r10 / 15.0f;
            g(this.B, this.S, r15, this.G, this.H);
            i(this.T, this.U, r15, this.G, this.H);
            g(this.V, this.S, r15, this.G, this.H);
            i(this.T, this.U, r15, this.G, this.H);
            g(this.V, this.S, r15, this.G, this.H);
            i(this.T, this.U, r15, this.G, this.H);
            float r16 = this.H0 / 30.0f;
            g(this.B, this.W, r16, this.I, this.J);
            i(this.X, this.S, r16, this.G, this.H);
            g(this.T, this.W, r16, this.I, this.J);
            i(this.X, this.S, r16, this.G, this.H);
            g(this.T, this.W, r16, this.I, this.J);
            i(this.X, this.S, r16, this.G, this.H);
            j(this.V, this.T, 1.0f - ((30.0f - this.H0) / 15.0f), false);
            goto L41
        L40:
            g(this.B, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            g(this.V, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            g(this.V, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            j(this.A, this.V, this.H0 / 15.0f, true);
            goto L41
        L10:
            if (r1 != this.F) goto L13;
            r2 = false;
            goto L15
        }

        public static int[] b(int r16, int r17) {
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            GLES30.glBindFramebuffer(36160, r1[0]);
            int[] r3 = new int[1];
            GLES30.glGenTextures(1, r3, 0);
            GLES30.glBindTexture(3553, r3[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r16, r17, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r3[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r1[0], r3[0]};
        }

        public static int d(int r2, String r3) {
            int r4 = GLES30.glCreateShader(r2);
            if (r4 == 0) goto L8;
            GLES30.glShaderSource(r4, r3);
            GLES30.glCompileShader(r4);
            int[] r5 = new int[1];
            GLES30.glGetShaderiv(r4, 35713, r5, 0);
            if (r5[0] != 0) goto L9;
            GLES30.glGetShaderInfoLog(r4);
            GLES30.glDeleteShader(r4);
            return 0;
        L9:
            return r4;
        L8:
            return r4;
        }

        public final int[] e(int r14, int r15) {
            GLES30.glUseProgram(r14);
            int[] r0 = new int[1];
            GLES30.glGenVertexArrays(1, r0, 0);
            int r1 = r0[0];
            GLES30.glBindVertexArray(r1);
            int[] r2 = new int[1];
            GLES30.glGenBuffers(1, r2, 0);
            int r3 = r2[0];
            GLES30.glBindBuffer(34962, r3);
            GLES30.glBufferData(34962, this.O.length * 4, this.P, 35044);
            GLES30.glEnableVertexAttribArray(r15);
            GLES30.glVertexAttribPointer(r15, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r1, r3};
        }

        public final void k(int r6, int r7) {
            if (r7 == 0) goto L5;
            GLES30.glViewport(0, 0, this.G, this.H);
            GLES30.glBindFramebuffer(36160, r7);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.a);
            if (r7 == 0) goto L9;
            GLES30.glUniform2f(this.d, this.G, this.H);
            GLES30.glUniform1i(this.e, 1);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.c, 0);
            GLES30.glBindVertexArray(this.f);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r7 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.d, this.C, this.E);
            GLES30.glUniform1i(this.e, 0);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.C, this.E);
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r9, EGLConfig r10) {
            int r11 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.a = r11;
            this.b = GLES30.glGetAttribLocation(r11, "vPosition");
            a("glGetAttribLocation");
            this.c = GLES30.glGetUniformLocation(this.a, "u_background");
            a("glGetAttribLocation");
            this.d = GLES30.glGetUniformLocation(this.a, "u_resolution");
            a("glGetUniformLocation");
            this.e = GLES30.glGetUniformLocation(this.a, "u_revert");
            a("glGetUniformLocation");
            this.f = e(this.a, this.b)[0];
            int r3 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n");
            this.g = r3;
            this.h = GLES30.glGetAttribLocation(r3, "vPosition");
            a("glGetAttribLocation");
            this.i = GLES30.glGetUniformLocation(this.g, "u_background");
            a("glGetAttribLocation");
            this.j = GLES30.glGetUniformLocation(this.g, "u_resolution");
            a("glGetUniformLocation");
            this.k = GLES30.glGetUniformLocation(this.g, "u_blurOffset");
            a("glGetUniformLocation");
            this.l = e(this.g, this.h)[0];
            int r4 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.m = r4;
            this.n = GLES30.glGetAttribLocation(r4, "vPosition");
            a("glGetAttribLocation");
            this.o = GLES30.glGetUniformLocation(this.m, "u_background");
            a("glGetAttribLocation");
            this.p = GLES30.glGetUniformLocation(this.m, "u_resolution");
            a("glGetUniformLocation");
            this.q = GLES30.glGetUniformLocation(this.m, "u_blurOffset");
            a("glGetUniformLocation");
            this.r = e(this.m, this.n)[0];
            int r5 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n");
            this.s = r5;
            this.t = GLES30.glGetAttribLocation(r5, "vPosition");
            a("glGetAttribLocation");
            this.u = GLES30.glGetUniformLocation(this.s, "u_background");
            a("glGetAttribLocation");
            this.v = GLES30.glGetUniformLocation(this.s, "u_foreground");
            a("glGetAttribLocation");
            this.w = GLES30.glGetUniformLocation(this.s, "u_resolution");
            a("glGetUniformLocation");
            this.x = GLES30.glGetUniformLocation(this.s, "u_revert");
            a("glGetUniformLocation");
            this.y = GLES30.glGetUniformLocation(this.s, "u_alpha");
            a("glGetUniformLocation");
            this.z = e(this.s, this.t)[0];
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r4, int r5, int r6) {
            this.C = r5;
            this.E = r6;
            if (r5 == 0) goto L43;
            if (r6 != 0) goto L7;
            return;
        L7:
            if (r5 == this.D) goto L9;
        L11:
            int r7 = this.S;
            if (r7 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r7}, 0);
        L14:
            int r8 = this.T;
            if (r8 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r8}, 0);
        L17:
            int r9 = this.U;
            if (r9 == 0) goto L20;
            GLES30.glDeleteFramebuffers(1, new int[]{r9}, 0);
        L20:
            int r10 = this.V;
            if (r10 == 0) goto L23;
            GLES30.glDeleteTextures(1, new int[]{r10}, 0);
        L23:
            int r11 = this.W;
            if (r11 == 0) goto L26;
            GLES30.glDeleteFramebuffers(1, new int[]{r11}, 0);
        L26:
            int r12 = this.X;
            if (r12 == 0) goto L29;
            GLES30.glDeleteTextures(1, new int[]{r12}, 0);
        L29:
            int r13 = this.Y;
            if (r13 == 0) goto L32;
            GLES30.glDeleteFramebuffers(1, new int[]{r13}, 0);
        L32:
            int r14 = this.Z;
            if (r14 == 0) goto L35;
            GLES30.glDeleteTextures(1, new int[]{r14}, 0);
        L35:
            int r15 = this.k0;
            if (r15 == 0) goto L38;
            GLES30.glDeleteFramebuffers(1, new int[]{r15}, 0);
        L38:
            int r16 = this.p0;
            if (r16 == 0) goto L41;
            GLES30.glDeleteTextures(1, new int[]{r16}, 0);
        L41:
            int r17 = this.C / 4;
            this.G = r17;
            int r0 = this.E / 4;
            this.H = r0;
            int[] r18 = b(r17, r0);
            this.S = r18[0];
            this.T = r18[1];
            int[] r19 = b(this.G, this.H);
            this.U = r19[0];
            this.V = r19[1];
            this.I = (int) Math.ceil(this.G / 2.0f);
            int r20 = (int) Math.ceil(this.H / 2.0f);
            this.J = r20;
            int[] r21 = b(this.I, r20);
            this.W = r21[0];
            this.X = r21[1];
            this.K = (int) Math.ceil(this.I / 2.0f);
            int r22 = (int) Math.ceil(this.J / 2.0f);
            this.L = r22;
            int[] r23 = b(this.K, r22);
            this.Y = r23[0];
            this.Z = r23[1];
            this.M = (int) Math.ceil(this.K / 2.0f);
            int r24 = (int) Math.ceil(this.L / 2.0f);
            this.N = r24;
            int[] r25 = b(this.M, r24);
            this.k0 = r25[0];
            this.p0 = r25[1];
            return;
        L9:
            if (r6 != this.F) goto L11;
            return;
        }

        public final void j(int r5, int r6, float r7, boolean r8) {
            GLES30.glViewport(0, 0, this.C, this.E);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.s);
            GLES30.glUniform2f(this.w, this.C, this.E);
            GLES30.glUniform1i(this.x, r8 ? 1 : 0);
            GLES30.glUniform1f(this.y, r7);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r5);
            GLES30.glUniform1i(this.u, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.v, 1);
            GLES30.glBindVertexArray(this.z);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
        }

        public final void g(int r4, int r5, float r6, int r7, int r8) {
            GLES30.glViewport(0, 0, r7, r8);
            GLES30.glBindFramebuffer(36160, r5);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.g);
            GLES30.glUniform2f(this.j, r7, r8);
            GLES30.glUniform1f(this.k, r6);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r4);
            GLES30.glUniform1i(this.i, 0);
            GLES30.glBindVertexArray(this.l);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r5 == 0) goto L6;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        public final void i(int r3, int r4, float r5, int r6, int r7) {
            GLES30.glViewport(0, 0, r6, r7);
            GLES30.glBindFramebuffer(36160, r4);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.m);
            GLES30.glUniform2f(this.p, r6, r7);
            GLES30.glUniform1f(this.q, r5);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r3);
            GLES30.glUniform1i(this.o, 0);
            GLES30.glBindVertexArray(this.r);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public GL3ShaderViewKawaseBlur(Context r2) {
        super(r2, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r2) {
        this.a.R = r2;
    }

    public void setBlurRadius(float r3) {
        a r0 = this.a;
        if (r0.L0 == r3) goto L6;
        r0.L0 = r3;
        r0.H0 = r3 * 10.0f;
        return;
    }

    public GL3ShaderViewKawaseBlur(Context r8, AttributeSet r9) {
        super(r8, r9);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r10 = new a();
        this.a = r10;
        setRenderer(r10);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
