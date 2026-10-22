package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import eja.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class GL3ShaderViewSnow extends GLSurfaceView implements Choreographer.FrameCallback {
    public static final /* synthetic */ int b = 0;
    public a a;

    public static class a implements GLSurfaceView.Renderer {
        public Bitmap A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
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
        public int l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public final c u;
        public final c v;
        public final c w;
        public final float[] x;
        public final FloatBuffer y;
        public Bitmap z;

        public a(Context r4) {
            this.n = -1.0f;
            this.o = -1.0f;
            this.p = -1.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = new c(1.0f);
            this.v = new c(0.5f);
            this.w = new c(1.0f);
            float[] r0 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.x = r0;
            this.B = 0;
            this.F = 0;
            this.G = 0;
            FloatBuffer r1 = ByteBuffer.allocateDirect(r0.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r0);
            this.y = r1;
            r1.position(0);
        }

        public static void a(String r3) {
            int r0 = GLES30.glGetError();
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = GL3ShaderViewSnow.b;
            throw new RuntimeException(r3 + ": glError " + r0);
        }

        public static int b(String r4) {
            int r0 = c(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
            if (r0 != 0) goto L5;
            return 0;
        L5:
            int r5 = c(35632, r4);
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
            int r6 = GL3ShaderViewSnow.b;
            GLES30.glGetProgramInfoLog(r2);
            GLES30.glDeleteProgram(r2);
            return 0;
        L14:
            return r2;
        }

        public static int d(Bitmap r5) {
            int[] r1 = new int[1];
            GLES30.glGenTextures(1, r1, 0);
            int r0 = r1[0];
            if (r0 == 0) goto L6;
            GLES30.glBindTexture(3553, r0);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r5, 0);
            GLES30.glBindTexture(3553, 0);
            r5.recycle();
        L6:
            return r1[0];
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r21) {
            if (this.q != this.r) goto L7;
            if (this.s != this.t) goto L7;
        L16:
            long r1 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.a);
            GLES30.glUniform1f(this.g, (r1 % 1000000) / 1000.0f);
            int r2 = this.q;
            if (r2 == this.r) goto L19;
        L20:
            this.r = r2;
            int r3 = this.s;
            this.t = r3;
            GLES30.glUniform2f(this.f, r2, r3);
        L21:
            float r4 = this.u.a;
            if (r4 == this.n) goto L24;
            this.n = r4;
            GLES30.glUniform1f(this.h, r4);
        L24:
            float r5 = this.v.a;
            if (r5 == this.o) goto L27;
            this.o = r5;
            GLES30.glUniform1f(this.i, r5);
        L27:
            float r6 = this.w.a;
            if (r6 == this.p) goto L30;
            this.p = r6;
            GLES30.glUniform1f(this.j, r6);
        L30:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.k);
            GLES30.glUniform1i(this.c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.G);
            GLES30.glUniform1i(this.d, 1);
            GLES30.glActiveTexture(33986);
            GLES30.glBindTexture(3553, this.l);
            GLES30.glUniform1i(this.e, 2);
            GLES30.glBindVertexArray(this.m);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L19:
            if (this.s == this.t) goto L21;
        L7:
            if (this.B != 0) goto L9;
            int r7 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.B = r7;
            this.C = GLES30.glGetAttribLocation(r7, "vPosition");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.B, "u_background");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.B, "u_resolution");
            a("glGetUniformLocation");
        L9:
            GLES30.glUseProgram(this.B);
            if (this.F != 0) goto L12;
            int[] r8 = new int[1];
            GLES30.glGenFramebuffers(1, r8, 0);
            this.F = r8[0];
        L12:
            GLES30.glBindFramebuffer(36160, this.F);
            if (this.G != 0) goto L15;
            int[] r9 = new int[1];
            GLES30.glGenTextures(1, r9, 0);
            this.G = r9[0];
        L15:
            GLES30.glBindTexture(3553, this.G);
            GLES30.glTexImage2D(3553, 0, 6408, this.q, this.s, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.G, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
            GLES30.glBindFramebuffer(36160, this.F);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.B);
            GLES30.glUniform2f(this.E, this.q, this.s);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.k);
            GLES30.glUniform1i(this.D, 0);
            GLES30.glEnableVertexAttribArray(this.C);
            GLES30.glVertexAttribPointer(this.C, 2, 5126, false, 0, this.y);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.G);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
            goto L16
        }

        public static int c(int r2, String r3) {
            int r4 = GLES30.glCreateShader(r2);
            if (r4 == 0) goto L8;
            GLES30.glShaderSource(r4, r3);
            GLES30.glCompileShader(r4);
            int[] r5 = new int[1];
            GLES30.glGetShaderiv(r4, 35713, r5, 0);
            if (r5[0] != 0) goto L9;
            int r6 = GL3ShaderViewSnow.b;
            GLES30.glGetShaderInfoLog(r4);
            GLES30.glDeleteShader(r4);
            return 0;
        L9:
            return r4;
        L8:
            return r4;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r8, EGLConfig r9) {
            int r10 = b("#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.a = r10;
            if (r10 != 0) goto L5;
            return;
        L5:
            this.b = GLES30.glGetAttribLocation(r10, "vPosition");
            a("glGetAttribLocation");
            this.c = GLES30.glGetUniformLocation(this.a, "u_background");
            a("glGetAttribLocation");
            this.d = GLES30.glGetUniformLocation(this.a, "u_prepass");
            a("glGetAttribLocation");
            this.e = GLES30.glGetUniformLocation(this.a, "u_frostTex");
            a("glGetAttribLocation");
            this.f = GLES30.glGetUniformLocation(this.a, "u_resolution");
            a("glGetUniformLocation");
            this.g = GLES30.glGetUniformLocation(this.a, "u_time");
            a("glGetUniformLocation");
            this.h = GLES30.glGetUniformLocation(this.a, "u_alpha");
            a("glGetUniformLocation");
            this.i = GLES30.glGetUniformLocation(this.a, "u_intensity");
            a("glGetUniformLocation");
            this.j = GLES30.glGetUniformLocation(this.a, "u_speed");
            a("glGetUniformLocation");
            GLES30.glUseProgram(this.a);
            this.k = d(this.z);
            this.l = d(this.A);
            int[] r11 = new int[1];
            GLES30.glGenVertexArrays(1, r11, 0);
            int r12 = r11[0];
            this.m = r12;
            GLES30.glBindVertexArray(r12);
            int[] r13 = new int[1];
            GLES30.glGenBuffers(1, r13, 0);
            GLES30.glBindBuffer(34962, r13[0]);
            GLES30.glBufferData(34962, this.x.length * 4, this.y, 35044);
            GLES30.glEnableVertexAttribArray(this.b);
            GLES30.glVertexAttribPointer(this.b, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r1, int r2, int r3) {
            this.q = r2;
            this.s = r3;
            GLES30.glViewport(0, 0, r2, r3);
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

    public GL3ShaderViewSnow(Context r2) {
        super(r2, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r2) {
        this.a.z = r2;
    }

    public void setFrostImage(Bitmap r2) {
        this.a.A = r2;
    }

    public void setShaderAlpha(float r2) {
        this.a.u.a = r2;
    }

    public void setShaderIntensity(float r2) {
        this.a.v.a = r2;
    }

    public void setShaderSpeed(float r2) {
        this.a.w.a = r2;
    }

    public GL3ShaderViewSnow(Context r8, AttributeSet r9) {
        super(r8, r9);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r10 = new a(getContext());
        this.a = r10;
        setRenderer(r10);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
