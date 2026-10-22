package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7741a = "GL2ShaderView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f7742b;

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
        private int f7743J;
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
        private int Y;
        private int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7744a;
        private int aa;
        private int ab;
        private int ac;
        private int ad;
        private float ae;
        private float af;
        private final float[] ag;
        private FloatBuffer ah;
        private Bitmap ai;
        private Bitmap aj;
        private int ak;
        private int al;
        private int am;
        private int an;
        private int ao;
        private int ap;
        private int aq;
        private int ar;
        private int as;
        private int at;
        private int au;
        private int av;
        private float aw;
        private int ax;
        private Rect ay;
        private Rect az;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7745b;
        int c;
        int d;
        final /* synthetic */ GL3ShaderViewProgressBlur e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private final String j;
        private final String k;
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

        public a(GL3ShaderViewProgressBlur r5) {
            this.e = r5;
            this.f = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.g = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n";
            this.h = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n";
            this.i = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n";
            this.j = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n";
            this.k = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n";
            this.Z = 0;
            this.aa = 0;
            this.ab = 0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0.0f;
            this.af = 0.0f;
            float[] r0 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.ag = r0;
            this.ak = 0;
            this.al = 0;
            this.am = 0;
            this.an = 0;
            this.ao = 0;
            this.ap = 0;
            this.aq = 0;
            this.ar = 0;
            this.as = 0;
            this.at = 0;
            this.au = 0;
            this.av = 0;
            this.aw = 60.0f;
            this.ax = 0;
            this.ay = new Rect(0, 0, 1264, 400);
            this.az = new Rect(0, 0, 1264, 400);
            FloatBuffer r1 = ByteBuffer.allocateDirect(r0.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r0);
            this.ah = r1;
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

        private void a(int r10, int r11) {
            if (r11 == 0) goto L5;
            GLES30.glViewport(0, 0, this.ay.width(), this.ay.height());
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
        L6:
            GLES30.glUseProgram(this.f7743J);
            float r2 = this.ay.left / this.aa;
            float r3 = (this.ac - this.ay.bottom) / this.ac;
            float r4 = this.ay.width() / this.aa;
            float r5 = this.ay.height();
            int r6 = this.ac;
            float r7 = r5 / r6;
            if (r11 == 0) goto L9;
            GLES30.glUniform2f(this.M, this.ay.width(), this.ay.height());
            GLES30.glUniform4f(this.N, r2, r3, r4, r7);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.L, 0);
            GLES30.glBindVertexArray(this.O);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.M, this.aa, r6);
            GLES30.glUniform4f(this.N, (-r2) / r4, (-r3) / r7, 1.0f / r4, 1.0f / r7);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.aa, this.ac);
            goto L6
        }

        private void a(int r5, int r6, float r7, int r8, int r9) {
            GLES30.glViewport(0, 0, r8, r9);
            GLES30.glBindFramebuffer(36160, r6);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.t);
            GLES30.glUniform2f(this.w, r8, r9);
            GLES30.glUniform1f(this.y, r7);
            int r10 = this.ax;
            if (r10 != 0) goto L6;
            GLES30.glUniform4f(this.x, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r5);
            GLES30.glUniform1i(this.v, 0);
            GLES30.glBindVertexArray(this.z);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r6 == 0) goto L12;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L12:
            return;
        L6:
            if (r10 != 1) goto L8;
            GLES30.glUniform4f(this.x, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        private void a(int r6, int r7, int r8, float r9) {
            GLES30.glViewport(0, 0, this.ay.width(), this.ay.height());
            GLES30.glBindFramebuffer(36160, r8);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.Q);
            GLES30.glUniform2f(this.U, this.ay.width(), this.ay.height());
            GLES30.glUniform1f(this.W, r9);
            int r10 = this.ax;
            if (r10 != 0) goto L5;
            GLES30.glUniform4f(this.V, 0.0f, 0.0f, 0.0f, 1.0f);
        L7:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.S, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r7);
            GLES30.glUniform1i(this.T, 1);
            GLES30.glBindVertexArray(this.X);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L5:
            if (r10 != 1) goto L7;
            GLES30.glUniform4f(this.V, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L7
        }

        private void a(int r6, int r7, boolean r8, float r9, float r10) {
            GLES30.glViewport(0, 0, this.aa, this.ac);
            if (r7 == 0) goto L5;
            GLES30.glBindFramebuffer(36160, r7);
        L5:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.l);
            GLES30.glUniform2f(this.o, this.aa, this.ac);
            GLES30.glUniform1i(this.p, r8 ? 1 : 0);
            GLES30.glUniform2f(this.q, r9, r10);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.n, 0);
            GLES30.glBindVertexArray(this.r);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r7 == 0) goto L9;
            GLES30.glBindFramebuffer(36160, 0);
            return;
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
            GLES30.glTexParameteri(3553, 10241, 9728);
            GLES30.glTexParameteri(3553, 10240, 9728);
            GLES30.glTexParameteri(3553, 10242, 10497);
            GLES30.glTexParameteri(3553, 10243, 10497);
            GLES30.glBindTexture(3553, 0);
        L6:
            return r0[0];
        }

        private void b(int r4, int r5, float r6, int r7, int r8) {
            GLES30.glViewport(0, 0, r7, r8);
            GLES30.glBindFramebuffer(36160, r5);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.B);
            GLES30.glUniform2f(this.E, r7, r8);
            GLES30.glUniform1f(this.G, r6);
            int r9 = this.ax;
            if (r9 != 0) goto L6;
            GLES30.glUniform4f(this.F, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r4);
            GLES30.glUniform1i(this.D, 0);
            GLES30.glBindVertexArray(this.H);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L6:
            if (r9 != 1) goto L8;
            GLES30.glUniform4f(this.F, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        private int[] b(int r17, int r18) {
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            GLES30.glBindFramebuffer(36160, r1[0]);
            int[] r3 = new int[1];
            GLES30.glGenTextures(1, r3, 0);
            GLES30.glBindTexture(3553, r3[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r17, r18, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33648);
            GLES30.glTexParameteri(3553, 10243, 33648);
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
            GLES30.glBufferData(34962, this.ag.length * 4, this.ah, 35044);
            GLES30.glEnableVertexAttribArray(r14);
            GLES30.glVertexAttribPointer(r14, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r1, r3};
        }

        public void a() {
            int r0 = this.am;
            if (r0 == 0) goto L5;
            GLES30.glDeleteFramebuffers(1, new int[]{r0}, 0);
        L5:
            int r1 = this.an;
            if (r1 == 0) goto L8;
            GLES30.glDeleteTextures(1, new int[]{r1}, 0);
        L8:
            int r2 = this.ao;
            if (r2 == 0) goto L11;
            GLES30.glDeleteFramebuffers(1, new int[]{r2}, 0);
        L11:
            int r3 = this.ap;
            if (r3 == 0) goto L14;
            GLES30.glDeleteTextures(1, new int[]{r3}, 0);
        L14:
            int r4 = this.aq;
            if (r4 == 0) goto L17;
            GLES30.glDeleteFramebuffers(1, new int[]{r4}, 0);
        L17:
            int r5 = this.ar;
            if (r5 == 0) goto L20;
            GLES30.glDeleteTextures(1, new int[]{r5}, 0);
        L20:
            int r6 = this.as;
            if (r6 == 0) goto L23;
            GLES30.glDeleteFramebuffers(1, new int[]{r6}, 0);
        L23:
            int r7 = this.at;
            if (r7 == 0) goto L26;
            GLES30.glDeleteTextures(1, new int[]{r7}, 0);
        L26:
            int r8 = this.au;
            if (r8 == 0) goto L29;
            GLES30.glDeleteFramebuffers(1, new int[]{r8}, 0);
        L29:
            int r9 = this.av;
            if (r9 == 0) goto L32;
            GLES30.glDeleteTextures(1, new int[]{r9}, 0);
        L32:
            int[] r10 = b(this.ay.width(), this.ay.height());
            this.am = r10[0];
            this.an = r10[1];
            int[] r11 = b(this.ay.width(), this.ay.height());
            this.ao = r11[0];
            this.ap = r11[1];
            this.f7744a = this.ay.width() / 2;
            int r12 = this.ay.height() / 2;
            this.f7745b = r12;
            int[] r13 = b(this.f7744a, r12);
            this.aq = r13[0];
            this.ar = r13[1];
            int[] r14 = b(this.f7744a, this.f7745b);
            this.as = r14[0];
            this.at = r14[1];
            this.c = (int) Math.ceil(this.f7744a / 2.0f);
            int r15 = (int) Math.ceil(this.f7745b / 2.0f);
            this.d = r15;
            int[] r16 = b(this.c, r15);
            this.au = r16[0];
            this.av = r16[1];
        }

        public void a(float r2) {
            this.aw = r2 * 20.0f;
        }

        public void a(int r1) {
            this.ax = r1;
        }

        public void a(Bitmap r1) {
            this.aj = r1;
        }

        public void a(Rect r1) {
            this.ay.set(r1);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r11) {
            GL10 r12 = (GL10) ZeusTransformUtils.wrapperContextForParams(r11, GL10.class, "com.obric.memorydata.plugin");
            if (this.aa != 0) goto L5;
            return;
        L5:
            if (this.ac != 0) goto L8;
            return;
        L8:
            if (this.aj == this.ai) goto L13;
            int r13 = this.Z;
            if (r13 == 0) goto L12;
            GLES30.glDeleteTextures(1, new int[]{r13}, 0);
        L12:
            this.Z = b(this.aj);
        L13:
            a(this.Z, this.ak, true, this.ae, this.af);
            if (this.az.width() == this.ay.width()) goto L16;
        L17:
            a();
        L18:
            a(this.al, this.am);
            float r14 = this.aw / 30.0f;
            a(this.an, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.ar, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.ar, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.ar, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.ar, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.ar, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.ar, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.ar, this.au, r14, this.c, this.d);
            b(this.av, this.aq, r14, this.f7744a, this.f7745b);
            a(this.an, this.ar, this.ao, r14);
            a(this.al, 0, false, 0.0f, 0.0f);
            a(this.ap, 0);
            this.ab = this.aa;
            this.ad = this.ac;
            this.ai = this.aj;
            this.az.set(this.ay);
            return;
        L16:
            if (this.az.height() == this.ay.height()) goto L18;
            goto L17
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r3, int r4, int r5) {
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.memorydata.plugin");
            this.aa = r4;
            this.ac = r5;
            if (r4 == 0) goto L19;
            if (r5 != 0) goto L7;
            return;
        L7:
            if (r4 == this.ab) goto L9;
        L11:
            int r7 = this.ak;
            if (r7 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r7}, 0);
        L14:
            int r8 = this.al;
            if (r8 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r8}, 0);
        L17:
            int[] r9 = b(this.aa, this.ac);
            this.ak = r9[0];
            this.al = r9[1];
            a();
            return;
        L9:
            if (r5 != this.ad) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            GL10 r13 = (GL10) ZeusTransformUtils.wrapperContextForParams(r11, GL10.class, "com.obric.memorydata.plugin");
            int r14 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.l = r14;
            this.m = GLES30.glGetAttribLocation(r14, "vPosition");
            a("glGetAttribLocation");
            this.n = GLES30.glGetUniformLocation(this.l, "u_background");
            a("glGetAttribLocation");
            this.o = GLES30.glGetUniformLocation(this.l, "u_resolution");
            a("glGetUniformLocation");
            this.p = GLES30.glGetUniformLocation(this.l, "u_revert");
            a("glGetUniformLocation");
            this.q = GLES30.glGetUniformLocation(this.l, "u_uvOffset");
            a("glGetUniformLocation");
            int[] r4 = c(this.l, this.m);
            this.r = r4[0];
            this.s = r4[1];
            int r5 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n");
            this.t = r5;
            this.u = GLES30.glGetAttribLocation(r5, "vPosition");
            a("glGetAttribLocation");
            this.v = GLES30.glGetUniformLocation(this.t, "u_background");
            a("glGetAttribLocation");
            this.w = GLES30.glGetUniformLocation(this.t, "u_resolution");
            a("glGetUniformLocation");
            this.x = GLES30.glGetUniformLocation(this.t, "u_direction");
            a("glGetUniformLocation");
            this.y = GLES30.glGetUniformLocation(this.t, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r6 = c(this.t, this.u);
            this.z = r6[0];
            this.A = r6[1];
            int r7 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.B = r7;
            this.C = GLES30.glGetAttribLocation(r7, "vPosition");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.B, "u_background");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.B, "u_resolution");
            a("glGetUniformLocation");
            this.F = GLES30.glGetUniformLocation(this.B, "u_direction");
            a("glGetUniformLocation");
            this.G = GLES30.glGetUniformLocation(this.B, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r8 = c(this.B, this.C);
            this.H = r8[0];
            this.I = r8[1];
            int r9 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f7743J = r9;
            this.K = GLES30.glGetAttribLocation(r9, "vPosition");
            a("glGetAttribLocation");
            this.L = GLES30.glGetUniformLocation(this.f7743J, "u_background");
            a("glGetAttribLocation");
            this.M = GLES30.glGetUniformLocation(this.f7743J, "u_resolution");
            a("glGetUniformLocation");
            this.N = GLES30.glGetUniformLocation(this.f7743J, "u_clip");
            a("glGetUniformLocation");
            int[] r10 = c(this.f7743J, this.K);
            this.O = r10[0];
            this.P = r10[1];
            int r15 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n");
            this.Q = r15;
            this.R = GLES30.glGetAttribLocation(r15, "vPosition");
            a("glGetAttribLocation");
            this.S = GLES30.glGetUniformLocation(this.Q, "u_background");
            a("glGetAttribLocation");
            this.T = GLES30.glGetUniformLocation(this.Q, "u_foreground");
            a("glGetAttribLocation");
            this.U = GLES30.glGetUniformLocation(this.Q, "u_resolution");
            a("glGetUniformLocation");
            this.V = GLES30.glGetUniformLocation(this.Q, "u_direction");
            a("glGetUniformLocation");
            this.W = GLES30.glGetUniformLocation(this.Q, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r16 = c(this.Q, this.R);
            this.X = r16[0];
            this.Y = r16[1];
        }
    }

    static {
    }

    public GL3ShaderViewProgressBlur(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public GL3ShaderViewProgressBlur(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        a();
    }

    private void a() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r0 = new a(this);
        this.f7742b = r0;
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
        this.f7742b.a(r1);
    }

    public void setBlurRadius(float r1) {
        this.f7742b.a(r1);
    }

    public void setClipRect(Rect r1) {
        this.f7742b.a(r1);
    }

    public void setDirection(int r1) {
        this.f7742b.a(r1);
    }
}
