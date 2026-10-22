package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
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
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5658c;

    private class a implements GLSurfaceView.Renderer {
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        int G;
        int H;
        int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        int f5659J;
        int K;
        int L;
        int M;
        int N;
        private final float[] O;
        private FloatBuffer P;
        private Bitmap Q;
        private Bitmap R;
        private int S;
        private int T;
        private int U;
        private int V;
        private int W;
        private int X;
        private int Y;
        private int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5660a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        private int f5661a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5662b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        private int f5663b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5664c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        private float f5665c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5666d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        private float f5667d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5668e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5669f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5670g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f5671h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f5672i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f5673j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f5674k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f5675l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f5676m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f5677n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f5678o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f5679p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f5680q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f5681r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f5682s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f5683t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f5684u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f5685v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f5686w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f5687x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f5688y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f5689z;

        public a(GL3ShaderViewKawaseBlur r10) {
            this.A = 0;
            this.B = 0;
            this.C = 0;
            this.D = 0;
            this.E = 0;
            this.F = 0;
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.O = r11;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 0;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.f5661a0 = 0;
            this.f5663b0 = 0;
            this.f5665c0 = 0.0f;
            this.f5667d0 = 0.0f;
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.P = r12;
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
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r11[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r10[0], r11[0]};
        }

        private int c(String r10, String r11) {
            int r12 = e(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = e(35632, r11);
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

        private int d(int r13, int r14) {
            int[] r10 = new int[1];
            GLES30.glGenTextures(1, r10, 0);
            GLES30.glBindTexture(3553, r10[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r13, r14, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
            return r10[0];
        }

        private int e(int r10, String r11) {
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

        private int f(Bitmap r10) {
            int[] r11 = new int[1];
            GLES30.glGenTextures(1, r11, 0);
            if (r11[0] == 0) goto L6;
            GLES30.glBindTexture(3553, r11[0]);
            GLUtils.texImage2D(3553, 0, r10, 0);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
        L6:
            return r11[0];
        }

        private int[] g(int r13, int r14) {
            GLES30.glUseProgram(r13);
            int[] r10 = new int[1];
            GLES30.glGenVertexArrays(1, r10, 0);
            int r11 = r10[0];
            GLES30.glBindVertexArray(r11);
            int[] r12 = new int[1];
            GLES30.glGenBuffers(1, r12, 0);
            int r15 = r12[0];
            GLES30.glBindBuffer(34962, r15);
            GLES30.glBufferData(34962, this.O.length * 4, this.P, 35044);
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
            GLES30.glUseProgram(this.f5670g);
            GLES30.glUniform2f(this.f5673j, r13, r14);
            GLES30.glUniform1f(this.f5674k, r12);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5672i, 0);
            GLES30.glBindVertexArray(this.f5675l);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r11 == 0) goto L6;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        private void i(int r10, int r11, float r12, int r13, int r14) {
            GLES30.glViewport(0, 0, r13, r14);
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5676m);
            GLES30.glUniform2f(this.f5679p, r13, r14);
            GLES30.glUniform1f(this.f5680q, r12);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5678o, 0);
            GLES30.glBindVertexArray(this.f5681r);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        private void j(int r10, int r11, int r12, float r13, boolean r14) {
            if (r12 == 0) goto L5;
            GLES30.glViewport(0, 0, this.G, this.H);
            GLES30.glBindFramebuffer(36160, r12);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5682s);
            int r15 = this.f5686w;
            if (r12 == 0) goto L9;
            float r16 = this.G;
            int r17 = this.H;
        L10:
            GLES30.glUniform2f(r15, r16, r17);
            GLES30.glUniform1i(this.f5687x, r14 ? 1 : 0);
            GLES30.glUniform1f(this.f5688y, r13);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5684u, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r11);
            GLES30.glUniform1i(this.f5685v, 1);
            GLES30.glBindVertexArray(this.f5689z);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r12 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            r16 = this.C;
            r17 = this.E;
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.C, this.E);
            goto L6
        }

        private void k(int r10, int r11) {
            if (r11 == 0) goto L5;
            GLES30.glViewport(0, 0, this.G, this.H);
            GLES30.glBindFramebuffer(36160, r11);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5660a);
            int r12 = this.f5666d;
            if (r11 == 0) goto L9;
            GLES30.glUniform2f(r12, this.G, this.H);
            GLES30.glUniform1i(this.f5668e, 1);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f5664c, 0);
            GLES30.glBindVertexArray(this.f5669f);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(r12, this.C, this.E);
            GLES30.glUniform1i(this.f5668e, 0);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.C, this.E);
            goto L6
        }

        public void l(Bitmap r10) {
            this.R = r10;
        }

        public void m(float r10) {
            if (this.f5667d0 == r10) goto L6;
            this.f5667d0 = r10;
            this.f5665c0 = r10 * 10.0f;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r17) {
            int r10 = this.C;
            if (r10 == 0) goto L44;
            int r11 = this.E;
            if (r11 == 0) goto L45;
            boolean r12 = true;
            if (r10 == this.D) goto L10;
        L13:
            boolean r13 = true;
        L15:
            if (this.R == this.Q) goto L20;
            int r14 = this.A;
            if (r14 == 0) goto L19;
            GLES30.glDeleteTextures(1, new int[]{r14}, 0);
        L19:
            this.A = f(this.R);
        L21:
            if (r12 == false) goto L26;
            k(this.A, this.S);
            if (this.B != 0) goto L25;
            this.B = d(this.G, this.H);
        L25:
            GLES30.glBindFramebuffer(36160, this.S);
            GLES30.glBindTexture(3553, this.B);
            GLES30.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.G, this.H);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glBindTexture(3553, 0);
        L26:
            float r15 = this.f5665c0;
            if (r15 < 150.0f) goto L31;
            float r16 = r15 / 120.0f;
            a r18 = this;
            float r19 = r16;
            r18.h(this.B, this.W, r19, this.I, this.f5659J);
            r18.h(this.X, this.Y, r19, this.K, this.L);
            r18.h(this.Z, this.f5661a0, r19, this.M, this.N);
            r18.i(this.f5663b0, this.Y, r19, this.K, this.L);
            r18.i(this.Z, this.W, r19, this.I, this.f5659J);
        L29:
            r18.i(this.X, this.S, r19, this.G, this.H);
            k(this.T, 0);
        L42:
            this.D = this.C;
            this.F = this.E;
            this.Q = this.R;
            return;
        L31:
            if (r15 < 120.0f) goto L36;
            float r20 = r15 / 120.0f;
            h(this.B, this.W, r20, this.I, this.f5659J);
            h(this.X, this.Y, r20, this.K, this.L);
            h(this.Z, this.f5661a0, r20, this.M, this.N);
            i(this.f5663b0, this.Y, r20, this.K, this.L);
            i(this.Z, this.W, r20, this.I, this.f5659J);
            i(this.X, this.U, r20, this.G, this.H);
            float r21 = this.f5665c0 / 30.0f;
            h(this.B, this.W, r21, this.I, this.f5659J);
            i(this.X, this.S, r21, this.G, this.H);
            h(this.T, this.W, r21, this.I, this.f5659J);
            i(this.X, this.S, r21, this.G, this.H);
            h(this.T, this.W, r21, this.I, this.f5659J);
            i(this.X, this.S, r21, this.G, this.H);
            float r22 = 1.0f - ((150.0f - this.f5665c0) / 30.0f);
            int r23 = this.T;
            int r24 = this.V;
        L33:
            int r25 = 0;
            boolean r26 = false;
        L34:
            j(r23, r24, r25, r22, r26);
            goto L42
        L36:
            if (r15 < 30.0f) goto L39;
            float r27 = r15 / 30.0f;
            r18 = this;
            r19 = r27;
            r18.h(this.B, this.W, r19, this.I, this.f5659J);
            r18.i(this.X, this.S, r19, this.G, this.H);
            r18.h(this.T, this.W, r19, this.I, this.f5659J);
            r18.i(this.X, this.S, r19, this.G, this.H);
            r18.h(this.T, this.W, r19, this.I, this.f5659J);
            goto L29
        L39:
            if (r15 < 15.0f) goto L41;
            float r28 = r15 / 15.0f;
            h(this.B, this.S, r28, this.G, this.H);
            i(this.T, this.U, r28, this.G, this.H);
            h(this.V, this.S, r28, this.G, this.H);
            i(this.T, this.U, r28, this.G, this.H);
            h(this.V, this.S, r28, this.G, this.H);
            i(this.T, this.U, r28, this.G, this.H);
            float r29 = this.f5665c0 / 30.0f;
            h(this.B, this.W, r29, this.I, this.f5659J);
            i(this.X, this.S, r29, this.G, this.H);
            h(this.T, this.W, r29, this.I, this.f5659J);
            i(this.X, this.S, r29, this.G, this.H);
            h(this.T, this.W, r29, this.I, this.f5659J);
            i(this.X, this.S, r29, this.G, this.H);
            r22 = 1.0f - ((30.0f - this.f5665c0) / 15.0f);
            r23 = this.V;
            r24 = this.T;
            goto L33
        L41:
            h(this.B, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            h(this.V, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            h(this.V, this.S, 1.0f, this.G, this.H);
            i(this.T, this.U, 1.0f, this.G, this.H);
            r22 = this.f5665c0 / 15.0f;
            r23 = this.A;
            r24 = this.V;
            r25 = 0;
            r26 = true;
            goto L34
        L20:
            r12 = r13;
            goto L21
        L10:
            if (r11 != this.F) goto L13;
            r13 = false;
            goto L15
        L45:
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.C = r11;
            this.E = r12;
            if (r11 == 0) goto L43;
            if (r12 != 0) goto L7;
            return;
        L7:
            if (r11 == this.D) goto L9;
        L11:
            int r13 = this.S;
            if (r13 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r13}, 0);
        L14:
            int r14 = this.T;
            if (r14 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r14}, 0);
        L17:
            int r15 = this.U;
            if (r15 == 0) goto L20;
            GLES30.glDeleteFramebuffers(1, new int[]{r15}, 0);
        L20:
            int r16 = this.V;
            if (r16 == 0) goto L23;
            GLES30.glDeleteTextures(1, new int[]{r16}, 0);
        L23:
            int r17 = this.W;
            if (r17 == 0) goto L26;
            GLES30.glDeleteFramebuffers(1, new int[]{r17}, 0);
        L26:
            int r18 = this.X;
            if (r18 == 0) goto L29;
            GLES30.glDeleteTextures(1, new int[]{r18}, 0);
        L29:
            int r19 = this.Y;
            if (r19 == 0) goto L32;
            GLES30.glDeleteFramebuffers(1, new int[]{r19}, 0);
        L32:
            int r20 = this.Z;
            if (r20 == 0) goto L35;
            GLES30.glDeleteTextures(1, new int[]{r20}, 0);
        L35:
            int r21 = this.f5661a0;
            if (r21 == 0) goto L38;
            GLES30.glDeleteFramebuffers(1, new int[]{r21}, 0);
        L38:
            int r22 = this.f5663b0;
            if (r22 == 0) goto L41;
            GLES30.glDeleteTextures(1, new int[]{r22}, 0);
        L41:
            int r23 = this.C / 4;
            this.G = r23;
            int r24 = this.E / 4;
            this.H = r24;
            int[] r25 = b(r23, r24);
            this.S = r25[0];
            this.T = r25[1];
            int[] r26 = b(this.G, this.H);
            this.U = r26[0];
            this.V = r26[1];
            this.I = (int) Math.ceil(this.G / 2.0f);
            int r27 = (int) Math.ceil(this.H / 2.0f);
            this.f5659J = r27;
            int[] r28 = b(this.I, r27);
            this.W = r28[0];
            this.X = r28[1];
            this.K = (int) Math.ceil(this.I / 2.0f);
            int r29 = (int) Math.ceil(this.f5659J / 2.0f);
            this.L = r29;
            int[] r30 = b(this.K, r29);
            this.Y = r30[0];
            this.Z = r30[1];
            this.M = (int) Math.ceil(this.K / 2.0f);
            int r31 = (int) Math.ceil(this.L / 2.0f);
            this.N = r31;
            int[] r32 = b(this.M, r31);
            this.f5661a0 = r32[0];
            this.f5663b0 = r32[1];
            return;
        L9:
            if (r12 != this.F) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            int r13 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f5660a = r13;
            this.f5662b = GLES30.glGetAttribLocation(r13, "vPosition");
            a("glGetAttribLocation");
            this.f5664c = GLES30.glGetUniformLocation(this.f5660a, "u_background");
            a("glGetAttribLocation");
            this.f5666d = GLES30.glGetUniformLocation(this.f5660a, "u_resolution");
            a("glGetUniformLocation");
            this.f5668e = GLES30.glGetUniformLocation(this.f5660a, "u_revert");
            a("glGetUniformLocation");
            int[] r10 = g(this.f5660a, this.f5662b);
            this.f5669f = r10[0];
            int r14 = r10[1];
            int r15 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n");
            this.f5670g = r15;
            this.f5671h = GLES30.glGetAttribLocation(r15, "vPosition");
            a("glGetAttribLocation");
            this.f5672i = GLES30.glGetUniformLocation(this.f5670g, "u_background");
            a("glGetAttribLocation");
            this.f5673j = GLES30.glGetUniformLocation(this.f5670g, "u_resolution");
            a("glGetUniformLocation");
            this.f5674k = GLES30.glGetUniformLocation(this.f5670g, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r16 = g(this.f5670g, this.f5671h);
            this.f5675l = r16[0];
            int r17 = r16[1];
            int r18 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.f5676m = r18;
            this.f5677n = GLES30.glGetAttribLocation(r18, "vPosition");
            a("glGetAttribLocation");
            this.f5678o = GLES30.glGetUniformLocation(this.f5676m, "u_background");
            a("glGetAttribLocation");
            this.f5679p = GLES30.glGetUniformLocation(this.f5676m, "u_resolution");
            a("glGetUniformLocation");
            this.f5680q = GLES30.glGetUniformLocation(this.f5676m, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r19 = g(this.f5676m, this.f5677n);
            this.f5681r = r19[0];
            int r20 = r19[1];
            int r110 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n");
            this.f5682s = r110;
            this.f5683t = GLES30.glGetAttribLocation(r110, "vPosition");
            a("glGetAttribLocation");
            this.f5684u = GLES30.glGetUniformLocation(this.f5682s, "u_background");
            a("glGetAttribLocation");
            this.f5685v = GLES30.glGetUniformLocation(this.f5682s, "u_foreground");
            a("glGetAttribLocation");
            this.f5686w = GLES30.glGetUniformLocation(this.f5682s, "u_resolution");
            a("glGetUniformLocation");
            this.f5687x = GLES30.glGetUniformLocation(this.f5682s, "u_revert");
            a("glGetUniformLocation");
            this.f5688y = GLES30.glGetUniformLocation(this.f5682s, "u_alpha");
            a("glGetUniformLocation");
            int[] r111 = g(this.f5682s, this.f5683t);
            this.f5689z = r111[0];
            int r112 = r111[1];
        }
    }

    static {
    }

    public GL3ShaderViewKawaseBlur(Context r10) {
        super(r10, null);
    }

    public GL3ShaderViewKawaseBlur(Context r10, AttributeSet r11) {
        super(r10, r11);
        a();
    }

    private void a() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r10 = new a(this);
        this.f5658c = r10;
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
        this.f5658c.l(r10);
    }

    public void setBlurRadius(float r10) {
        this.f5658c.m(r10);
    }
}
