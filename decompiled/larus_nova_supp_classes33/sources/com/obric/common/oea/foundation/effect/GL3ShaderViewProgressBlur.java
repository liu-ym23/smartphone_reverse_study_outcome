package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {
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
        public int H0;
        public int I;
        public int J;
        public int K;
        public int L;
        public int L0;
        public int M;
        public int N;
        public int O;
        public int P;
        public int P0;
        public int Q;
        public int R;
        public final float[] S;
        public final FloatBuffer T;
        public Bitmap U;
        public Bitmap V;
        public int V0;
        public int W;
        public int X;
        public int Y;
        public int Z;
        public int a;
        public int b;
        public int b1;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int g1;
        public int h;
        public float h1;
        public int i;
        public int j;
        public int k;
        public int k0;
        public int k1;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int p0;
        public final Rect p1;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public final Rect v1;
        public int w;
        public int x;
        public int y;
        public int z;

        public final void g() {
            int r0 = this.Y;
            if (r0 == 0) goto L5;
            GLES30.glDeleteFramebuffers(1, new int[]{r0}, 0);
        L5:
            int r1 = this.Z;
            if (r1 == 0) goto L8;
            GLES30.glDeleteTextures(1, new int[]{r1}, 0);
        L8:
            int r2 = this.k0;
            if (r2 == 0) goto L11;
            GLES30.glDeleteFramebuffers(1, new int[]{r2}, 0);
        L11:
            int r3 = this.p0;
            if (r3 == 0) goto L14;
            GLES30.glDeleteTextures(1, new int[]{r3}, 0);
        L14:
            int r4 = this.H0;
            if (r4 == 0) goto L17;
            GLES30.glDeleteFramebuffers(1, new int[]{r4}, 0);
        L17:
            int r5 = this.L0;
            if (r5 == 0) goto L20;
            GLES30.glDeleteTextures(1, new int[]{r5}, 0);
        L20:
            int r6 = this.P0;
            if (r6 == 0) goto L23;
            GLES30.glDeleteFramebuffers(1, new int[]{r6}, 0);
        L23:
            int r7 = this.V0;
            if (r7 == 0) goto L26;
            GLES30.glDeleteTextures(1, new int[]{r7}, 0);
        L26:
            int r8 = this.b1;
            if (r8 == 0) goto L29;
            GLES30.glDeleteFramebuffers(1, new int[]{r8}, 0);
        L29:
            int r9 = this.g1;
            if (r9 == 0) goto L32;
            GLES30.glDeleteTextures(1, new int[]{r9}, 0);
        L32:
            int[] r10 = b(this.p1.width(), this.p1.height());
            this.Y = r10[0];
            this.Z = r10[1];
            int[] r11 = b(this.p1.width(), this.p1.height());
            this.k0 = r11[0];
            this.p0 = r11[1];
            this.O = this.p1.width() / 2;
            int r12 = this.p1.height() / 2;
            this.P = r12;
            int[] r13 = b(this.O, r12);
            this.H0 = r13[0];
            this.L0 = r13[1];
            int[] r14 = b(this.O, this.P);
            this.P0 = r14[0];
            this.V0 = r14[1];
            this.Q = (int) Math.ceil(this.O / 2.0f);
            int r15 = (int) Math.ceil(this.P / 2.0f);
            this.R = r15;
            int[] r16 = b(this.Q, r15);
            this.b1 = r16[0];
            this.g1 = r16[1];
        }

        public a() {
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            float[] r1 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.S = r1;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.k0 = 0;
            this.p0 = 0;
            this.H0 = 0;
            this.L0 = 0;
            this.P0 = 0;
            this.V0 = 0;
            this.b1 = 0;
            this.g1 = 0;
            this.h1 = 60.0f;
            this.k1 = 0;
            this.p1 = new Rect(0, 0, 1264, WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS);
            this.v1 = new Rect(0, 0, 1264, WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS);
            FloatBuffer r2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r1);
            this.T = r2;
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
        public final void onDrawFrame(GL10 r11) {
            if (this.K != 0) goto L5;
            return;
        L5:
            if (this.M != 0) goto L8;
            return;
        L8:
            if (this.V == this.U) goto L16;
            int r12 = this.J;
            if (r12 == 0) goto L12;
            GLES30.glDeleteTextures(1, new int[]{r12}, 0);
        L12:
            Bitmap r13 = this.V;
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            int r4 = r0[0];
            if (r4 == 0) goto L15;
            GLES30.glBindTexture(3553, r4);
            GLUtils.texImage2D(3553, 0, r13, 0);
            GLES30.glTexParameteri(3553, 10241, 9728);
            GLES30.glTexParameteri(3553, 10240, 9728);
            GLES30.glTexParameteri(3553, 10242, 10497);
            GLES30.glTexParameteri(3553, 10243, 10497);
            GLES30.glBindTexture(3553, 0);
        L15:
            this.J = r0[0];
        L16:
            l(this.J, this.W, true);
            if (this.v1.width() == this.p1.width()) goto L19;
        L20:
            g();
        L21:
            k(this.X, this.Y);
            float r14 = this.h1 / 30.0f;
            i(this.Z, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            i(this.L0, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            i(this.L0, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            i(this.L0, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            i(this.L0, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            i(this.L0, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            i(this.L0, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            i(this.L0, this.b1, r14, this.Q, this.R);
            j(this.g1, this.H0, r14, this.O, this.P);
            int r1 = this.Z;
            int r5 = this.L0;
            int r6 = this.k0;
            GLES30.glViewport(0, 0, this.p1.width(), this.p1.height());
            GLES30.glBindFramebuffer(36160, r6);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.B);
            GLES30.glUniform2f(this.F, this.p1.width(), this.p1.height());
            GLES30.glUniform1f(this.H, r14);
            int r15 = this.k1;
            if (r15 != 0) goto L24;
            GLES30.glUniform4f(this.G, 0.0f, 0.0f, 0.0f, 1.0f);
        L26:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r1);
            GLES30.glUniform1i(this.D, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r5);
            GLES30.glUniform1i(this.E, 1);
            GLES30.glBindVertexArray(this.I);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            l(this.X, 0, false);
            k(this.p0, 0);
            this.L = this.K;
            this.N = this.M;
            this.U = this.V;
            this.v1.set(this.p1);
            return;
        L24:
            if (r15 != 1) goto L26;
            GLES30.glUniform4f(this.G, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L26
        L19:
            if (this.v1.height() == this.p1.height()) goto L21;
            goto L20
        }

        public static int[] b(int r16, int r17) {
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            GLES30.glBindFramebuffer(36160, r1[0]);
            int[] r3 = new int[1];
            GLES30.glGenTextures(1, r3, 0);
            GLES30.glBindTexture(3553, r3[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r16, r17, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33648);
            GLES30.glTexParameteri(3553, 10243, 33648);
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
            GLES30.glBufferData(34962, this.S.length * 4, this.T, 35044);
            GLES30.glEnableVertexAttribArray(r15);
            GLES30.glVertexAttribPointer(r15, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r1, r3};
        }

        public final void k(int r10, int r11) {
            if (r11 == 0) goto L5;
            GLES30.glViewport(0, 0, this.p1.width(), this.p1.height());
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
        L6:
            GLES30.glUseProgram(this.v);
            Rect r2 = this.p1;
            float r3 = r2.left / this.K;
            int r4 = this.M;
            float r5 = (r4 - r2.bottom) / r4;
            float r6 = r2.width() / this.K;
            float r7 = this.p1.height();
            int r8 = this.M;
            float r9 = r7 / r8;
            if (r11 == 0) goto L9;
            GLES30.glUniform2f(this.y, this.p1.width(), this.p1.height());
            GLES30.glUniform4f(this.z, r3, r5, r6, r9);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.x, 0);
            GLES30.glBindVertexArray(this.A);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.y, this.K, r8);
            GLES30.glUniform4f(this.z, (-r3) / r6, (-r5) / r9, 1.0f / r6, 1.0f / r9);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.K, this.M);
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r9, EGLConfig r10) {
            int r11 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.a = r11;
            this.b = GLES30.glGetAttribLocation(r11, "vPosition");
            a("glGetAttribLocation");
            this.c = GLES30.glGetUniformLocation(this.a, "u_background");
            a("glGetAttribLocation");
            this.d = GLES30.glGetUniformLocation(this.a, "u_resolution");
            a("glGetUniformLocation");
            this.e = GLES30.glGetUniformLocation(this.a, "u_revert");
            a("glGetUniformLocation");
            this.f = GLES30.glGetUniformLocation(this.a, "u_uvOffset");
            a("glGetUniformLocation");
            this.g = e(this.a, this.b)[0];
            int r3 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n");
            this.h = r3;
            this.i = GLES30.glGetAttribLocation(r3, "vPosition");
            a("glGetAttribLocation");
            this.j = GLES30.glGetUniformLocation(this.h, "u_background");
            a("glGetAttribLocation");
            this.k = GLES30.glGetUniformLocation(this.h, "u_resolution");
            a("glGetUniformLocation");
            this.l = GLES30.glGetUniformLocation(this.h, "u_direction");
            a("glGetUniformLocation");
            this.m = GLES30.glGetUniformLocation(this.h, "u_blurOffset");
            a("glGetUniformLocation");
            this.n = e(this.h, this.i)[0];
            int r4 = c("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.o = r4;
            this.p = GLES30.glGetAttribLocation(r4, "vPosition");
            a("glGetAttribLocation");
            this.q = GLES30.glGetUniformLocation(this.o, "u_background");
            a("glGetAttribLocation");
            this.r = GLES30.glGetUniformLocation(this.o, "u_resolution");
            a("glGetUniformLocation");
            this.s = GLES30.glGetUniformLocation(this.o, "u_direction");
            a("glGetUniformLocation");
            this.t = GLES30.glGetUniformLocation(this.o, "u_blurOffset");
            a("glGetUniformLocation");
            this.u = e(this.o, this.p)[0];
            int r5 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n");
            this.v = r5;
            this.w = GLES30.glGetAttribLocation(r5, "vPosition");
            a("glGetAttribLocation");
            this.x = GLES30.glGetUniformLocation(this.v, "u_background");
            a("glGetAttribLocation");
            this.y = GLES30.glGetUniformLocation(this.v, "u_resolution");
            a("glGetUniformLocation");
            this.z = GLES30.glGetUniformLocation(this.v, "u_clip");
            a("glGetUniformLocation");
            this.A = e(this.v, this.w)[0];
            int r6 = c("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n");
            this.B = r6;
            this.C = GLES30.glGetAttribLocation(r6, "vPosition");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.B, "u_background");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.B, "u_foreground");
            a("glGetAttribLocation");
            this.F = GLES30.glGetUniformLocation(this.B, "u_resolution");
            a("glGetUniformLocation");
            this.G = GLES30.glGetUniformLocation(this.B, "u_direction");
            a("glGetUniformLocation");
            this.H = GLES30.glGetUniformLocation(this.B, "u_blurOffset");
            a("glGetUniformLocation");
            this.I = e(this.B, this.C)[0];
        }

        public final void l(int r7, int r8, boolean r9) {
            GLES30.glViewport(0, 0, this.K, this.M);
            if (r8 == 0) goto L5;
            GLES30.glBindFramebuffer(36160, r8);
        L5:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.a);
            GLES30.glUniform2f(this.d, this.K, this.M);
            GLES30.glUniform1i(this.e, r9 ? 1 : 0);
            GLES30.glUniform2f(this.f, 0.0f, 0.0f);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r7);
            GLES30.glUniform1i(this.c, 0);
            GLES30.glBindVertexArray(this.g);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r8 == 0) goto L9;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r2, int r3, int r4) {
            this.K = r3;
            this.M = r4;
            if (r3 == 0) goto L19;
            if (r4 != 0) goto L7;
            return;
        L7:
            if (r3 == this.L) goto L9;
        L11:
            int r5 = this.W;
            if (r5 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r5}, 0);
        L14:
            int r6 = this.X;
            if (r6 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r6}, 0);
        L17:
            int[] r7 = b(this.K, this.M);
            this.W = r7[0];
            this.X = r7[1];
            g();
            return;
        L9:
            if (r4 != this.N) goto L11;
            return;
        }

        public final void i(int r5, int r6, float r7, int r8, int r9) {
            GLES30.glViewport(0, 0, r8, r9);
            GLES30.glBindFramebuffer(36160, r6);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.h);
            GLES30.glUniform2f(this.k, r8, r9);
            GLES30.glUniform1f(this.m, r7);
            int r10 = this.k1;
            if (r10 != 0) goto L6;
            GLES30.glUniform4f(this.l, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r5);
            GLES30.glUniform1i(this.j, 0);
            GLES30.glBindVertexArray(this.n);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r6 == 0) goto L12;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L12:
            return;
        L6:
            if (r10 != 1) goto L8;
            GLES30.glUniform4f(this.l, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        public final void j(int r4, int r5, float r6, int r7, int r8) {
            GLES30.glViewport(0, 0, r7, r8);
            GLES30.glBindFramebuffer(36160, r5);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.o);
            GLES30.glUniform2f(this.r, r7, r8);
            GLES30.glUniform1f(this.t, r6);
            int r9 = this.k1;
            if (r9 != 0) goto L6;
            GLES30.glUniform4f(this.s, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r4);
            GLES30.glUniform1i(this.q, 0);
            GLES30.glBindVertexArray(this.u);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L6:
            if (r9 != 1) goto L8;
            GLES30.glUniform4f(this.s, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
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

    public GL3ShaderViewProgressBlur(Context r2) {
        super(r2, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r2) {
        this.a.V = r2;
    }

    public void setBlurRadius(float r3) {
        float r4 = r3 * 20.0f;
        this.a.h1 = r4;
    }

    public void setClipRect(Rect r2) {
        this.a.p1.set(r2);
    }

    public void setDirection(int r2) {
        this.a.k1 = r2;
    }

    public GL3ShaderViewProgressBlur(Context r8, AttributeSet r9) {
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
