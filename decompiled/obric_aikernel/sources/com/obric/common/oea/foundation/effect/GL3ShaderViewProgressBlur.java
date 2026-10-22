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
import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5690c;

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
        private int f5691J;
        private int K;
        private int L;
        private int M;
        private int N;
        private float O;
        private float P;
        int Q;
        int R;
        int S;
        int T;
        private final float[] U;
        private FloatBuffer V;
        private Bitmap W;
        private Bitmap X;
        private int Y;
        private int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5692a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        private int f5693a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5694b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        private int f5695b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5696c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        private int f5697c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5698d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        private int f5699d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5700e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        private int f5701e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5702f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        private int f5703f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5704g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        private int f5705g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f5706h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        private int f5707h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f5708i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        private int f5709i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f5710j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        private int f5711j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f5712k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        private float f5713k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f5714l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        private int f5715l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f5716m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        private Rect f5717m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f5718n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        private Rect f5719n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f5720o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f5721p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f5722q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f5723r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f5724s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f5725t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f5726u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f5727v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f5728w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f5729x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f5730y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f5731z;

        public a(GL3ShaderViewProgressBlur r10) {
            this.f5691J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0.0f;
            this.P = 0.0f;
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.U = r11;
            this.Y = 0;
            this.Z = 0;
            this.f5693a0 = 0;
            this.f5695b0 = 0;
            this.f5697c0 = 0;
            this.f5699d0 = 0;
            this.f5701e0 = 0;
            this.f5703f0 = 0;
            this.f5705g0 = 0;
            this.f5707h0 = 0;
            this.f5709i0 = 0;
            this.f5711j0 = 0;
            this.f5713k0 = 60.0f;
            this.f5715l0 = 0;
            this.f5717m0 = new Rect(0, 0, 1264, 400);
            this.f5719n0 = new Rect(0, 0, 1264, 400);
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.V = r12;
            r12.position(0);
        }

        private void a(String r10) {
            int r11 = GLES30.glGetError();
            if (r11 != 0) goto L5;
            return;
        L5:
            Log.e("GL3BlurRenderer", r10 + ": glError " + r11);
            throw new RuntimeException(r10 + ": glError " + r11);
        }

        private int[] b(int r17, int r18) {
            int[] r10 = new int[1];
            GLES30.glGenFramebuffers(1, r10, 0);
            GLES30.glBindFramebuffer(36160, r10[0]);
            int[] r11 = new int[1];
            GLES30.glGenTextures(1, r11, 0);
            GLES30.glBindTexture(3553, r11[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r17, r18, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33648);
            GLES30.glTexParameteri(3553, 10243, 33648);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r11[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r10[0], r11[0]};
        }

        private int c(String r10, String r11) {
            int r12 = d(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = d(35632, r11);
            if (r13 != 0) goto L8;
            return 0;
        L8:
            int r14 = GLES30.glCreateProgram();
            if (r14 == 0) goto L14;
            GLES30.glAttachShader(r14, r12);
            a("glAttachShader");
            GLES30.glAttachShader(r14, r13);
            a("glAttachShader");
            GLES30.glLinkProgram(r14);
            int[] r15 = new int[1];
            GLES30.glGetProgramiv(r14, 35714, r15, 0);
            if (r15[0] == 1) goto L14;
            Log.e("GL3BlurRenderer", "Could not link program: ");
            Log.e("GL3BlurRenderer", GLES30.glGetProgramInfoLog(r14));
            GLES30.glDeleteProgram(r14);
            return 0;
        L14:
            return r14;
        }

        private int d(int r10, String r11) {
            int r12 = GLES30.glCreateShader(r10);
            if (r12 == 0) goto L8;
            GLES30.glShaderSource(r12, r11);
            GLES30.glCompileShader(r12);
            int[] r13 = new int[1];
            GLES30.glGetShaderiv(r12, 35713, r13, 0);
            if (r13[0] != 0) goto L9;
            Log.e("GL3BlurRenderer", "Could not compile shader " + r10 + ":");
            Log.e("GL3BlurRenderer", GLES30.glGetShaderInfoLog(r12));
            GLES30.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        private int e(Bitmap r10) {
            int[] r11 = new int[1];
            GLES30.glGenTextures(1, r11, 0);
            if (r11[0] == 0) goto L6;
            GLES30.glBindTexture(3553, r11[0]);
            GLUtils.texImage2D(3553, 0, r10, 0);
            GLES30.glTexParameteri(3553, 10241, 9728);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9728);
            GLES30.glTexParameteri(3553, 10242, 10497);
            GLES30.glTexParameteri(3553, 10243, 10497);
            GLES30.glBindTexture(3553, 0);
        L6:
            return r11[0];
        }

        private int[] f(int r13, int r14) {
            GLES30.glUseProgram(r13);
            int[] r10 = new int[1];
            GLES30.glGenVertexArrays(1, r10, 0);
            int r11 = r10[0];
            GLES30.glBindVertexArray(r11);
            int[] r12 = new int[1];
            GLES30.glGenBuffers(1, r12, 0);
            int r15 = r12[0];
            GLES30.glBindBuffer(34962, r15);
            GLES30.glBufferData(34962, this.U.length * 4, this.V, 35044);
            GLES30.glEnableVertexAttribArray(r14);
            GLES30.glVertexAttribPointer(r14, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r11, r15};
        }

        private void h(int r10, int r11, float r12, int r13, int r14) {
            GLES30.glViewport(0, 0, r13, r14);
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5706h);
            GLES30.glUniform2f(this.f5712k, r13, r14);
            GLES30.glUniform1f(this.f5716m, r12);
            int r15 = this.f5715l0;
            if (r15 != 0) goto L6;
            GLES30.glUniform4f(this.f5714l, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5710j, 0);
            GLES30.glBindVertexArray(this.f5718n);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r11 == 0) goto L12;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L12:
            return;
        L6:
            if (r15 != 1) goto L8;
            GLES30.glUniform4f(this.f5714l, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        private void i(int r10, int r11, float r12, int r13, int r14) {
            GLES30.glViewport(0, 0, r13, r14);
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5720o);
            GLES30.glUniform2f(this.f5723r, r13, r14);
            GLES30.glUniform1f(this.f5725t, r12);
            int r15 = this.f5715l0;
            if (r15 != 0) goto L6;
            GLES30.glUniform4f(this.f5724s, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5722q, 0);
            GLES30.glBindVertexArray(this.f5726u);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L6:
            if (r15 != 1) goto L8;
            GLES30.glUniform4f(this.f5724s, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        private void j(int r10, int r11) {
            if (r11 == 0) goto L5;
            GLES30.glViewport(0, 0, this.f5717m0.width(), this.f5717m0.height());
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
        L6:
            GLES30.glUseProgram(this.f5727v);
            Rect r12 = this.f5717m0;
            float r13 = r12.left / this.K;
            int r14 = this.M;
            float r15 = (r14 - r12.bottom) / r14;
            float r16 = r12.width() / this.K;
            float r17 = this.f5717m0.height();
            int r18 = this.M;
            float r19 = r17 / r18;
            if (r11 == 0) goto L9;
            GLES30.glUniform2f(this.f5730y, this.f5717m0.width(), this.f5717m0.height());
            GLES30.glUniform4f(this.f5731z, r13, r15, r16, r19);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5729x, 0);
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
            GLES30.glUniform2f(this.f5730y, this.K, r18);
            GLES30.glUniform4f(this.f5731z, (-r13) / r16, (-r15) / r19, 1.0f / r16, 1.0f / r19);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.K, this.M);
            goto L6
        }

        private void k(int r10, int r11, int r12, float r13) {
            GLES30.glViewport(0, 0, this.f5717m0.width(), this.f5717m0.height());
            GLES30.glBindFramebuffer(36160, r12);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.B);
            GLES30.glUniform2f(this.F, this.f5717m0.width(), this.f5717m0.height());
            GLES30.glUniform1f(this.H, r13);
            int r14 = this.f5715l0;
            if (r14 != 0) goto L5;
            GLES30.glUniform4f(this.G, 0.0f, 0.0f, 0.0f, 1.0f);
        L7:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.D, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r11);
            GLES30.glUniform1i(this.E, 1);
            GLES30.glBindVertexArray(this.I);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L5:
            if (r14 != 1) goto L7;
            GLES30.glUniform4f(this.G, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L7
        }

        private void l(int r10, int r11, boolean r12, float r13, float r14) {
            GLES30.glViewport(0, 0, this.K, this.M);
            if (r11 == 0) goto L5;
            GLES30.glBindFramebuffer(36160, r11);
        L5:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5692a);
            GLES30.glUniform2f(this.f5698d, this.K, this.M);
            GLES30.glUniform1i(this.f5700e, r12 ? 1 : 0);
            GLES30.glUniform2f(this.f5702f, r13, r14);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5696c, 0);
            GLES30.glBindVertexArray(this.f5704g);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L9;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        public void g() {
            int r10 = this.f5693a0;
            if (r10 == 0) goto L5;
            GLES30.glDeleteFramebuffers(1, new int[]{r10}, 0);
        L5:
            int r11 = this.f5695b0;
            if (r11 == 0) goto L8;
            GLES30.glDeleteTextures(1, new int[]{r11}, 0);
        L8:
            int r12 = this.f5697c0;
            if (r12 == 0) goto L11;
            GLES30.glDeleteFramebuffers(1, new int[]{r12}, 0);
        L11:
            int r13 = this.f5699d0;
            if (r13 == 0) goto L14;
            GLES30.glDeleteTextures(1, new int[]{r13}, 0);
        L14:
            int r14 = this.f5701e0;
            if (r14 == 0) goto L17;
            GLES30.glDeleteFramebuffers(1, new int[]{r14}, 0);
        L17:
            int r15 = this.f5703f0;
            if (r15 == 0) goto L20;
            GLES30.glDeleteTextures(1, new int[]{r15}, 0);
        L20:
            int r16 = this.f5705g0;
            if (r16 == 0) goto L23;
            GLES30.glDeleteFramebuffers(1, new int[]{r16}, 0);
        L23:
            int r17 = this.f5707h0;
            if (r17 == 0) goto L26;
            GLES30.glDeleteTextures(1, new int[]{r17}, 0);
        L26:
            int r18 = this.f5709i0;
            if (r18 == 0) goto L29;
            GLES30.glDeleteFramebuffers(1, new int[]{r18}, 0);
        L29:
            int r19 = this.f5711j0;
            if (r19 == 0) goto L32;
            GLES30.glDeleteTextures(1, new int[]{r19}, 0);
        L32:
            int[] r20 = b(this.f5717m0.width(), this.f5717m0.height());
            this.f5693a0 = r20[0];
            this.f5695b0 = r20[1];
            int[] r21 = b(this.f5717m0.width(), this.f5717m0.height());
            this.f5697c0 = r21[0];
            this.f5699d0 = r21[1];
            this.Q = this.f5717m0.width() / 2;
            int r22 = this.f5717m0.height() / 2;
            this.R = r22;
            int[] r23 = b(this.Q, r22);
            this.f5701e0 = r23[0];
            this.f5703f0 = r23[1];
            int[] r24 = b(this.Q, this.R);
            this.f5705g0 = r24[0];
            this.f5707h0 = r24[1];
            this.S = (int) Math.ceil(this.Q / 2.0f);
            int r25 = (int) Math.ceil(this.R / 2.0f);
            this.T = r25;
            int[] r26 = b(this.S, r25);
            this.f5709i0 = r26[0];
            this.f5711j0 = r26[1];
        }

        public void m(Bitmap r10) {
            this.X = r10;
        }

        public void n(float r10) {
            this.f5713k0 = r10 * 20.0f;
        }

        public void o(Rect r10) {
            this.f5717m0.set(r10);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r11) {
            if (this.K != 0) goto L5;
            return;
        L5:
            if (this.M != 0) goto L8;
            return;
        L8:
            if (this.X == this.W) goto L13;
            int r12 = this.f5691J;
            if (r12 == 0) goto L12;
            GLES30.glDeleteTextures(1, new int[]{r12}, 0);
        L12:
            this.f5691J = e(this.X);
        L13:
            l(this.f5691J, this.Y, true, this.O, this.P);
            if (this.f5719n0.width() == this.f5717m0.width()) goto L16;
        L17:
            g();
        L18:
            j(this.Z, this.f5693a0);
            float r13 = this.f5713k0 / 30.0f;
            h(this.f5695b0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            h(this.f5703f0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            h(this.f5703f0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            h(this.f5703f0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            h(this.f5703f0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            h(this.f5703f0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            h(this.f5703f0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            h(this.f5703f0, this.f5709i0, r13, this.S, this.T);
            i(this.f5711j0, this.f5701e0, r13, this.Q, this.R);
            k(this.f5695b0, this.f5703f0, this.f5697c0, r13);
            l(this.Z, 0, false, 0.0f, 0.0f);
            j(this.f5699d0, 0);
            this.L = this.K;
            this.N = this.M;
            this.W = this.X;
            this.f5719n0.set(this.f5717m0);
            return;
        L16:
            if (this.f5719n0.height() == this.f5717m0.height()) goto L18;
            goto L17
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.K = r11;
            this.M = r12;
            if (r11 == 0) goto L19;
            if (r12 != 0) goto L7;
            return;
        L7:
            if (r11 == this.L) goto L9;
        L11:
            int r13 = this.Y;
            if (r13 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r13}, 0);
        L14:
            int r14 = this.Z;
            if (r14 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r14}, 0);
        L17:
            int[] r15 = b(this.K, this.M);
            this.Y = r15[0];
            this.Z = r15[1];
            g();
            return;
        L9:
            if (r12 != this.N) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            int r13 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f5692a = r13;
            this.f5694b = GLES30.glGetAttribLocation(r13, "vPosition");
            a("glGetAttribLocation");
            this.f5696c = GLES30.glGetUniformLocation(this.f5692a, "u_background");
            a("glGetAttribLocation");
            this.f5698d = GLES30.glGetUniformLocation(this.f5692a, "u_resolution");
            a("glGetUniformLocation");
            this.f5700e = GLES30.glGetUniformLocation(this.f5692a, "u_revert");
            a("glGetUniformLocation");
            this.f5702f = GLES30.glGetUniformLocation(this.f5692a, "u_uvOffset");
            a("glGetUniformLocation");
            int[] r10 = f(this.f5692a, this.f5694b);
            this.f5704g = r10[0];
            int r14 = r10[1];
            int r15 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n");
            this.f5706h = r15;
            this.f5708i = GLES30.glGetAttribLocation(r15, "vPosition");
            a("glGetAttribLocation");
            this.f5710j = GLES30.glGetUniformLocation(this.f5706h, "u_background");
            a("glGetAttribLocation");
            this.f5712k = GLES30.glGetUniformLocation(this.f5706h, "u_resolution");
            a("glGetUniformLocation");
            this.f5714l = GLES30.glGetUniformLocation(this.f5706h, "u_direction");
            a("glGetUniformLocation");
            this.f5716m = GLES30.glGetUniformLocation(this.f5706h, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r16 = f(this.f5706h, this.f5708i);
            this.f5718n = r16[0];
            int r17 = r16[1];
            int r18 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.f5720o = r18;
            this.f5721p = GLES30.glGetAttribLocation(r18, "vPosition");
            a("glGetAttribLocation");
            this.f5722q = GLES30.glGetUniformLocation(this.f5720o, "u_background");
            a("glGetAttribLocation");
            this.f5723r = GLES30.glGetUniformLocation(this.f5720o, "u_resolution");
            a("glGetUniformLocation");
            this.f5724s = GLES30.glGetUniformLocation(this.f5720o, "u_direction");
            a("glGetUniformLocation");
            this.f5725t = GLES30.glGetUniformLocation(this.f5720o, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r19 = f(this.f5720o, this.f5721p);
            this.f5726u = r19[0];
            int r20 = r19[1];
            int r21 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f5727v = r21;
            this.f5728w = GLES30.glGetAttribLocation(r21, "vPosition");
            a("glGetAttribLocation");
            this.f5729x = GLES30.glGetUniformLocation(this.f5727v, "u_background");
            a("glGetAttribLocation");
            this.f5730y = GLES30.glGetUniformLocation(this.f5727v, "u_resolution");
            a("glGetUniformLocation");
            this.f5731z = GLES30.glGetUniformLocation(this.f5727v, "u_clip");
            a("glGetUniformLocation");
            int[] r22 = f(this.f5727v, this.f5728w);
            this.A = r22[0];
            int r23 = r22[1];
            int r110 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n");
            this.B = r110;
            this.C = GLES30.glGetAttribLocation(r110, "vPosition");
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
            int[] r111 = f(this.B, this.C);
            this.I = r111[0];
            int r112 = r111[1];
        }

        public void p(int r10) {
            this.f5715l0 = r10;
        }
    }

    static {
    }

    public GL3ShaderViewProgressBlur(Context r10) {
        super(r10, null);
    }

    public GL3ShaderViewProgressBlur(Context r10, AttributeSet r11) {
        super(r10, r11);
        a();
    }

    private void a() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r10 = new a(this);
        this.f5690c = r10;
        setRenderer(r10);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r10) {
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

    public void setBackgroundImage(Bitmap r10) {
        this.f5690c.m(r10);
    }

    public void setBlurRadius(float r10) {
        this.f5690c.n(r10);
    }

    public void setClipRect(Rect r10) {
        this.f5690c.o(r10);
    }

    public void setDirection(int r10) {
        this.f5690c.p(r10);
    }
}
