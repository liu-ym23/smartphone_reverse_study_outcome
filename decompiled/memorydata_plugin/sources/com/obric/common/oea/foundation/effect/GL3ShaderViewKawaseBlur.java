package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7736a = "GL2ShaderView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f7737b;

    private class a implements GLSurfaceView.Renderer {
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private int f7738J;
        private int K;
        private int L;
        private int M;
        private int N;
        private int O;
        private int P;
        private int Q;
        private int R;
        private int S;
        private int T;
        private int U;
        private int V;
        private int W;
        private int X;
        private final float[] Y;
        private FloatBuffer Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7739a;
        private Bitmap aa;
        private Bitmap ab;
        private int ac;
        private int ad;
        private int ae;
        private int af;
        private int ag;
        private int ah;
        private int ai;
        private int aj;
        private int ak;
        private int al;
        private float am;
        private float an;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7740b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        final /* synthetic */ GL3ShaderViewKawaseBlur i;
        private final String j;
        private final String k;
        private final String l;
        private final String m;
        private final String n;
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

        public a(GL3ShaderViewKawaseBlur r4) {
            this.i = r4;
            this.j = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.k = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n";
            this.l = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n";
            this.m = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n";
            this.n = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n";
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 0;
            this.W = 0;
            this.X = 0;
            float[] r0 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.Y = r0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0;
            this.af = 0;
            this.ag = 0;
            this.ah = 0;
            this.ai = 0;
            this.aj = 0;
            this.ak = 0;
            this.al = 0;
            this.am = 0.0f;
            this.an = 0.0f;
            FloatBuffer r1 = ByteBuffer.allocateDirect(r0.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r0);
            this.Z = r1;
            r1.position(0);
        }

        private int a(int r3, String r4) {
            int r2 = GLES30.glCreateShader(r3);
            if (r2 == 0) goto L8;
            GLES30.glShaderSource(r2, r4);
            GLES30.glCompileShader(r2);
            int[] r5 = new int[1];
            GLES30.glGetShaderiv(r2, 35713, r5, 0);
            if (r5[0] != 0) goto L9;
            Log.e("GL3BlurRenderer", "Could not compile shader " + r3 + ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Log.e("GL3BlurRenderer", GLES30.glGetShaderInfoLog(r2));
            GLES30.glDeleteShader(r2);
            return 0;
        L9:
            return r2;
        L8:
            return r2;
        }

        private int a(String r3, String r4) {
            int r5 = a(35633, r3);
            if (r5 != 0) goto L5;
            return 0;
        L5:
            int r6 = a(35632, r4);
            if (r6 != 0) goto L8;
            return 0;
        L8:
            int r1 = GLES30.glCreateProgram();
            if (r1 == 0) goto L14;
            GLES30.glAttachShader(r1, r5);
            a("glAttachShader");
            GLES30.glAttachShader(r1, r6);
            a("glAttachShader");
            GLES30.glLinkProgram(r1);
            int[] r7 = new int[1];
            GLES30.glGetProgramiv(r1, 35714, r7, 0);
            if (r7[0] == 1) goto L14;
            Log.e("GL3BlurRenderer", "Could not link program: ");
            Log.e("GL3BlurRenderer", GLES30.glGetProgramInfoLog(r1));
            GLES30.glDeleteProgram(r1);
            return 0;
        L14:
            return r1;
        }

        private void a(int r6, int r7) {
            if (r7 == 0) goto L5;
            GLES30.glViewport(0, 0, this.f7739a, this.f7740b);
            GLES30.glBindFramebuffer(36160, r7);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.o);
            int r2 = this.r;
            if (r7 == 0) goto L9;
            GLES30.glUniform2f(r2, this.f7739a, this.f7740b);
            GLES30.glUniform1i(this.s, 1);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.q, 0);
            GLES30.glBindVertexArray(this.t);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r7 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(r2, this.U, this.W);
            GLES30.glUniform1i(this.s, 0);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.U, this.W);
            goto L6
        }

        private void a(int r4, int r5, float r6, int r7, int r8) {
            GLES30.glViewport(0, 0, r7, r8);
            GLES30.glBindFramebuffer(36160, r5);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.v);
            GLES30.glUniform2f(this.y, r7, r8);
            GLES30.glUniform1f(this.z, r6);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r4);
            GLES30.glUniform1i(this.x, 0);
            GLES30.glBindVertexArray(this.A);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r5 == 0) goto L6;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        private void a(int r6, int r7, int r8, float r9, boolean r10) {
            if (r8 == 0) goto L5;
            GLES30.glViewport(0, 0, this.f7739a, this.f7740b);
            GLES30.glBindFramebuffer(36160, r8);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f7738J);
            int r2 = this.N;
            if (r8 == 0) goto L9;
            float r3 = this.f7739a;
            int r4 = this.f7740b;
        L10:
            GLES30.glUniform2f(r2, r3, r4);
            GLES30.glUniform1i(this.O, r10 ? 1 : 0);
            GLES30.glUniform1f(this.P, r9);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.L, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r7);
            GLES30.glUniform1i(this.M, 1);
            GLES30.glBindVertexArray(this.Q);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r8 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            r3 = this.U;
            r4 = this.W;
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.U, this.W);
            goto L6
        }

        private void a(String r4) {
            int r3 = GLES30.glGetError();
            if (r3 != 0) goto L5;
            return;
        L5:
            Log.e("GL3BlurRenderer", r4 + ": glError " + r3);
            throw new RuntimeException(r4 + ": glError " + r3);
        }

        private int b(Bitmap r4) {
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            if (r0[0] == 0) goto L6;
            GLES30.glBindTexture(3553, r0[0]);
            GLUtils.texImage2D(3553, 0, r4, 0);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
        L6:
            return r0[0];
        }

        private void b(int r3, int r4, float r5, int r6, int r7) {
            GLES30.glViewport(0, 0, r6, r7);
            GLES30.glBindFramebuffer(36160, r4);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.C);
            GLES30.glUniform2f(this.F, r6, r7);
            GLES30.glUniform1f(this.G, r5);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r3);
            GLES30.glUniform1i(this.E, 0);
            GLES30.glBindVertexArray(this.H);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        private int[] b(int r17, int r18) {
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            GLES30.glBindFramebuffer(36160, r1[0]);
            int[] r3 = new int[1];
            GLES30.glGenTextures(1, r3, 0);
            GLES30.glBindTexture(3553, r3[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r17, r18, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r3[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r1[0], r3[0]};
        }

        private int[] c(int r13, int r14) {
            GLES30.glUseProgram(r13);
            int[] r0 = new int[1];
            GLES30.glGenVertexArrays(1, r0, 0);
            int r1 = r0[0];
            GLES30.glBindVertexArray(r1);
            int[] r2 = new int[1];
            GLES30.glGenBuffers(1, r2, 0);
            int r3 = r2[0];
            GLES30.glBindBuffer(34962, r3);
            GLES30.glBufferData(34962, this.Y.length * 4, this.Z, 35044);
            GLES30.glEnableVertexAttribArray(r14);
            GLES30.glVertexAttribPointer(r14, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r1, r3};
        }

        private int d(int r13, int r14) {
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            GLES30.glBindTexture(3553, r0[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r13, r14, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
            return r0[0];
        }

        public void a(float r2) {
            if (this.an == r2) goto L6;
            this.an = r2;
            this.am = r2 * 10.0f;
            return;
        }

        public void a(Bitmap r1) {
            this.ab = r1;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r17) {
            GL10 r0 = (GL10) ZeusTransformUtils.wrapperContextForParams(r17, GL10.class, "com.obric.memorydata.plugin");
            int r1 = this.U;
            if (r1 == 0) goto L44;
            int r2 = this.W;
            if (r2 == 0) goto L45;
            boolean r3 = true;
            if (r1 == this.V) goto L10;
        L13:
            boolean r4 = true;
        L15:
            if (this.ab == this.aa) goto L20;
            int r5 = this.S;
            if (r5 == 0) goto L19;
            GLES30.glDeleteTextures(1, new int[]{r5}, 0);
        L19:
            this.S = b(this.ab);
        L21:
            if (r3 == false) goto L26;
            a(this.S, this.ac);
            if (this.T != 0) goto L25;
            this.T = d(this.f7739a, this.f7740b);
        L25:
            GLES30.glBindFramebuffer(36160, this.ac);
            GLES30.glBindTexture(3553, this.T);
            GLES30.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.f7739a, this.f7740b);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glBindTexture(3553, 0);
        L26:
            float r6 = this.am;
            if (r6 < 150.0f) goto L31;
            float r8 = r6 / 120.0f;
            a r7 = this;
            float r9 = r8;
            r7.a(this.T, this.ag, r9, this.c, this.d);
            r7.a(this.ah, this.ai, r9, this.e, this.f);
            r7.a(this.aj, this.ak, r9, this.g, this.h);
            r7.b(this.al, this.ai, r9, this.e, this.f);
            r7.b(this.aj, this.ag, r9, this.c, this.d);
        L29:
            r7.b(this.ah, this.ac, r9, this.f7739a, this.f7740b);
            a(this.ad, 0);
        L42:
            this.V = this.U;
            this.X = this.W;
            this.aa = this.ab;
            return;
        L31:
            if (r6 < 120.0f) goto L36;
            float r10 = r6 / 120.0f;
            a(this.T, this.ag, r10, this.c, this.d);
            a(this.ah, this.ai, r10, this.e, this.f);
            a(this.aj, this.ak, r10, this.g, this.h);
            b(this.al, this.ai, r10, this.e, this.f);
            b(this.aj, this.ag, r10, this.c, this.d);
            b(this.ah, this.ae, r10, this.f7739a, this.f7740b);
            float r11 = this.am / 30.0f;
            a(this.T, this.ag, r11, this.c, this.d);
            b(this.ah, this.ac, r11, this.f7739a, this.f7740b);
            a(this.ad, this.ag, r11, this.c, this.d);
            b(this.ah, this.ac, r11, this.f7739a, this.f7740b);
            a(this.ad, this.ag, r11, this.c, this.d);
            b(this.ah, this.ac, r11, this.f7739a, this.f7740b);
            float r12 = 1.0f - ((150.0f - this.am) / 30.0f);
            int r13 = this.ad;
            int r14 = this.af;
        L33:
            int r15 = 0;
            boolean r16 = false;
        L34:
            a(r13, r14, r15, r12, r16);
            goto L42
        L36:
            if (r6 < 30.0f) goto L39;
            float r18 = r6 / 30.0f;
            r7 = this;
            r9 = r18;
            r7.a(this.T, this.ag, r9, this.c, this.d);
            r7.b(this.ah, this.ac, r9, this.f7739a, this.f7740b);
            r7.a(this.ad, this.ag, r9, this.c, this.d);
            r7.b(this.ah, this.ac, r9, this.f7739a, this.f7740b);
            r7.a(this.ad, this.ag, r9, this.c, this.d);
            goto L29
        L39:
            if (r6 < 15.0f) goto L41;
            float r19 = r6 / 15.0f;
            a(this.T, this.ac, r19, this.f7739a, this.f7740b);
            b(this.ad, this.ae, r19, this.f7739a, this.f7740b);
            a(this.af, this.ac, r19, this.f7739a, this.f7740b);
            b(this.ad, this.ae, r19, this.f7739a, this.f7740b);
            a(this.af, this.ac, r19, this.f7739a, this.f7740b);
            b(this.ad, this.ae, r19, this.f7739a, this.f7740b);
            float r20 = this.am / 30.0f;
            a(this.T, this.ag, r20, this.c, this.d);
            b(this.ah, this.ac, r20, this.f7739a, this.f7740b);
            a(this.ad, this.ag, r20, this.c, this.d);
            b(this.ah, this.ac, r20, this.f7739a, this.f7740b);
            a(this.ad, this.ag, r20, this.c, this.d);
            b(this.ah, this.ac, r20, this.f7739a, this.f7740b);
            r12 = 1.0f - ((30.0f - this.am) / 15.0f);
            r13 = this.af;
            r14 = this.ad;
            goto L33
        L41:
            a(this.T, this.ac, 1.0f, this.f7739a, this.f7740b);
            b(this.ad, this.ae, 1.0f, this.f7739a, this.f7740b);
            a(this.af, this.ac, 1.0f, this.f7739a, this.f7740b);
            b(this.ad, this.ae, 1.0f, this.f7739a, this.f7740b);
            a(this.af, this.ac, 1.0f, this.f7739a, this.f7740b);
            b(this.ad, this.ae, 1.0f, this.f7739a, this.f7740b);
            r12 = this.am / 15.0f;
            r13 = this.S;
            r14 = this.af;
            r15 = 0;
            r16 = true;
            goto L34
        L20:
            r3 = r4;
            goto L21
        L10:
            if (r2 != this.X) goto L13;
            r4 = false;
            goto L15
        L45:
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r4, int r5, int r6) {
            GL10 r7 = (GL10) ZeusTransformUtils.wrapperContextForParams(r4, GL10.class, "com.obric.memorydata.plugin");
            this.U = r5;
            this.W = r6;
            if (r5 == 0) goto L43;
            if (r6 != 0) goto L7;
            return;
        L7:
            if (r5 == this.V) goto L9;
        L11:
            int r8 = this.ac;
            if (r8 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r8}, 0);
        L14:
            int r9 = this.ad;
            if (r9 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r9}, 0);
        L17:
            int r10 = this.ae;
            if (r10 == 0) goto L20;
            GLES30.glDeleteFramebuffers(1, new int[]{r10}, 0);
        L20:
            int r11 = this.af;
            if (r11 == 0) goto L23;
            GLES30.glDeleteTextures(1, new int[]{r11}, 0);
        L23:
            int r12 = this.ag;
            if (r12 == 0) goto L26;
            GLES30.glDeleteFramebuffers(1, new int[]{r12}, 0);
        L26:
            int r13 = this.ah;
            if (r13 == 0) goto L29;
            GLES30.glDeleteTextures(1, new int[]{r13}, 0);
        L29:
            int r14 = this.ai;
            if (r14 == 0) goto L32;
            GLES30.glDeleteFramebuffers(1, new int[]{r14}, 0);
        L32:
            int r15 = this.aj;
            if (r15 == 0) goto L35;
            GLES30.glDeleteTextures(1, new int[]{r15}, 0);
        L35:
            int r16 = this.ak;
            if (r16 == 0) goto L38;
            GLES30.glDeleteFramebuffers(1, new int[]{r16}, 0);
        L38:
            int r17 = this.al;
            if (r17 == 0) goto L41;
            GLES30.glDeleteTextures(1, new int[]{r17}, 0);
        L41:
            int r18 = this.U / 4;
            this.f7739a = r18;
            int r0 = this.W / 4;
            this.f7740b = r0;
            int[] r19 = b(r18, r0);
            this.ac = r19[0];
            this.ad = r19[1];
            int[] r20 = b(this.f7739a, this.f7740b);
            this.ae = r20[0];
            this.af = r20[1];
            this.c = (int) Math.ceil(this.f7739a / 2.0f);
            int r21 = (int) Math.ceil(this.f7740b / 2.0f);
            this.d = r21;
            int[] r22 = b(this.c, r21);
            this.ag = r22[0];
            this.ah = r22[1];
            this.e = (int) Math.ceil(this.c / 2.0f);
            int r23 = (int) Math.ceil(this.d / 2.0f);
            this.f = r23;
            int[] r24 = b(this.e, r23);
            this.ai = r24[0];
            this.aj = r24[1];
            this.g = (int) Math.ceil(this.e / 2.0f);
            int r25 = (int) Math.ceil(this.f / 2.0f);
            this.h = r25;
            int[] r26 = b(this.g, r25);
            this.ak = r26[0];
            this.al = r26[1];
            return;
        L9:
            if (r6 != this.X) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            GL10 r13 = (GL10) ZeusTransformUtils.wrapperContextForParams(r11, GL10.class, "com.obric.memorydata.plugin");
            int r14 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.o = r14;
            this.p = GLES30.glGetAttribLocation(r14, "vPosition");
            a("glGetAttribLocation");
            this.q = GLES30.glGetUniformLocation(this.o, "u_background");
            a("glGetAttribLocation");
            this.r = GLES30.glGetUniformLocation(this.o, "u_resolution");
            a("glGetUniformLocation");
            this.s = GLES30.glGetUniformLocation(this.o, "u_revert");
            a("glGetUniformLocation");
            int[] r4 = c(this.o, this.p);
            this.t = r4[0];
            this.u = r4[1];
            int r5 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n");
            this.v = r5;
            this.w = GLES30.glGetAttribLocation(r5, "vPosition");
            a("glGetAttribLocation");
            this.x = GLES30.glGetUniformLocation(this.v, "u_background");
            a("glGetAttribLocation");
            this.y = GLES30.glGetUniformLocation(this.v, "u_resolution");
            a("glGetUniformLocation");
            this.z = GLES30.glGetUniformLocation(this.v, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r6 = c(this.v, this.w);
            this.A = r6[0];
            this.B = r6[1];
            int r7 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.C = r7;
            this.D = GLES30.glGetAttribLocation(r7, "vPosition");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.C, "u_background");
            a("glGetAttribLocation");
            this.F = GLES30.glGetUniformLocation(this.C, "u_resolution");
            a("glGetUniformLocation");
            this.G = GLES30.glGetUniformLocation(this.C, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r8 = c(this.C, this.D);
            this.H = r8[0];
            this.I = r8[1];
            int r15 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n");
            this.f7738J = r15;
            this.K = GLES30.glGetAttribLocation(r15, "vPosition");
            a("glGetAttribLocation");
            this.L = GLES30.glGetUniformLocation(this.f7738J, "u_background");
            a("glGetAttribLocation");
            this.M = GLES30.glGetUniformLocation(this.f7738J, "u_foreground");
            a("glGetAttribLocation");
            this.N = GLES30.glGetUniformLocation(this.f7738J, "u_resolution");
            a("glGetUniformLocation");
            this.O = GLES30.glGetUniformLocation(this.f7738J, "u_revert");
            a("glGetUniformLocation");
            this.P = GLES30.glGetUniformLocation(this.f7738J, "u_alpha");
            a("glGetUniformLocation");
            int[] r16 = c(this.f7738J, this.K);
            this.Q = r16[0];
            this.R = r16[1];
        }
    }

    static {
    }

    public GL3ShaderViewKawaseBlur(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public GL3ShaderViewKawaseBlur(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        a();
    }

    private void a() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r0 = new a(this);
        this.f7737b = r0;
        setRenderer(r0);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r1) {
        this.f7737b.a(r1);
    }

    public void setBlurRadius(float r1) {
        this.f7737b.a(r1);
    }
}
