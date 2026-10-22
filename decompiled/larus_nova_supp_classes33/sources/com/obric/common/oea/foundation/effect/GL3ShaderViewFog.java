package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
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
public class GL3ShaderViewFog extends GLSurfaceView implements Choreographer.FrameCallback {
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
        public float m;
        public float n;
        public float o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public final c u;
        public final c v;
        public final c w;
        public int x;
        public final float[] y;
        public final FloatBuffer z;

        public a(Context r4) {
            this.m = -1.0f;
            this.n = -1.0f;
            this.o = -1.0f;
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = new c(1.0f);
            this.v = new c(0.8f);
            this.w = new c(0.5f);
            this.x = -3618616;
            float[] r0 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.y = r0;
            this.B = 0;
            this.F = 0;
            this.G = 0;
            FloatBuffer r1 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r0);
            this.z = r1;
            r1.position(0);
        }

        public static void a(String r3) {
            int r0 = GLES30.glGetError();
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = GL3ShaderViewFog.b;
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
            int r6 = GL3ShaderViewFog.b;
            GLES30.glGetProgramInfoLog(r2);
            GLES30.glDeleteProgram(r2);
            return 0;
        L14:
            return r2;
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
            GLES30.glUniform2f(this.e, r2, r3);
        L21:
            float r4 = this.u.a;
            if (r4 == this.m) goto L24;
            this.m = r4;
            GLES30.glUniform1f(this.h, r4);
        L24:
            float r5 = this.v.a;
            if (r5 == this.n) goto L27;
            this.n = r5;
            GLES30.glUniform1f(this.i, r5);
        L27:
            float r6 = this.w.a;
            if (r6 == this.o) goto L30;
            this.o = r6;
            GLES30.glUniform1f(this.j, r6);
        L30:
            int r7 = this.x;
            if (r7 == this.p) goto L33;
            this.p = r7;
            GLES30.glUniform3f(this.f, Color.red(r7) / 255.0f, Color.green(this.p) / 255.0f, Color.blue(this.p) / 255.0f);
        L33:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.k);
            GLES30.glUniform1i(this.c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.G);
            GLES30.glUniform1i(this.d, 1);
            GLES30.glBindVertexArray(this.l);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L19:
            if (this.s == this.t) goto L21;
        L7:
            if (this.B != 0) goto L9;
            int r8 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.B = r8;
            this.C = GLES30.glGetAttribLocation(r8, "vPosition");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.B, "u_background");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.B, "u_resolution");
            a("glGetUniformLocation");
        L9:
            GLES30.glUseProgram(this.B);
            if (this.F != 0) goto L12;
            int[] r9 = new int[1];
            GLES30.glGenFramebuffers(1, r9, 0);
            this.F = r9[0];
        L12:
            GLES30.glBindFramebuffer(36160, this.F);
            if (this.G != 0) goto L15;
            int[] r10 = new int[1];
            GLES30.glGenTextures(1, r10, 0);
            this.G = r10[0];
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
            GLES30.glVertexAttribPointer(this.C, 2, 5126, false, 0, this.z);
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
            int r6 = GL3ShaderViewFog.b;
            GLES30.glGetShaderInfoLog(r4);
            GLES30.glDeleteShader(r4);
            return 0;
        L9:
            return r4;
        L8:
            return r4;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r9, EGLConfig r10) {
            int r11 = b("#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.a = r11;
            if (r11 != 0) goto L5;
            return;
        L5:
            this.b = GLES30.glGetAttribLocation(r11, "vPosition");
            a("glGetAttribLocation");
            this.c = GLES30.glGetUniformLocation(this.a, "u_background");
            a("glGetAttribLocation");
            this.d = GLES30.glGetUniformLocation(this.a, "u_prepass");
            a("glGetAttribLocation");
            this.e = GLES30.glGetUniformLocation(this.a, "u_resolution");
            a("glGetUniformLocation");
            this.f = GLES30.glGetUniformLocation(this.a, "u_color");
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
            Bitmap r12 = this.A;
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            int r2 = r0[0];
            if (r2 == 0) goto L8;
            GLES30.glBindTexture(3553, r2);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r12, 0);
            GLES30.glBindTexture(3553, 0);
            r12.recycle();
        L8:
            this.k = r0[0];
            int[] r13 = new int[1];
            GLES30.glGenVertexArrays(1, r13, 0);
            int r14 = r13[0];
            this.l = r14;
            GLES30.glBindVertexArray(r14);
            int[] r15 = new int[1];
            GLES30.glGenBuffers(1, r15, 0);
            GLES30.glBindBuffer(34962, r15[0]);
            GLES30.glBufferData(34962, this.y.length * 4, this.z, 35044);
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

    public GL3ShaderViewFog(Context r2) {
        super(r2, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r2) {
        this.a.A = r2;
    }

    public void setShaderAlpha(float r2) {
        this.a.u.a = r2;
    }

    public void setShaderColor(int r2) {
        this.a.x = r2;
    }

    public void setShaderIntensity(float r2) {
        this.a.v.a = r2;
    }

    public void setShaderSpeed(float r2) {
        this.a.w.a = r2;
    }

    public GL3ShaderViewFog(Context r8, AttributeSet r9) {
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
