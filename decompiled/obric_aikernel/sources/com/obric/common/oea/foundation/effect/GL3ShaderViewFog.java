package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import androidx.work.Data;
import com.ttnet.org.chromium.base.TimeUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewFog extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f5630g = "GL2ShaderView";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5631c;

    private static class a implements GLSurfaceView.Renderer {
        private final float[] A;
        private FloatBuffer B;
        private Bitmap C;
        private int D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5636e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5637f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5638g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f5639h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f5640i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f5641j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f5642k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f5643l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f5644m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private float f5645n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private float f5646o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private float f5647p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f5648q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f5649r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f5650s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f5651t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f5652u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private m8.a f5653v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private m8.a f5654w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private m8.a f5655x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f5656y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private Context f5657z;

        public a(Context r10) {
            this.f5645n = -1.0f;
            this.f5646o = -1.0f;
            this.f5647p = -1.0f;
            this.f5648q = 0;
            this.f5649r = 0;
            this.f5650s = 0;
            this.f5651t = 0;
            this.f5652u = 0;
            this.f5653v = new m8.a(1.0f);
            this.f5654w = new m8.a(0.8f);
            this.f5655x = new m8.a(0.5f);
            this.f5656y = -3618616;
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.A = r11;
            this.D = 0;
            this.H = 0;
            this.I = 0;
            this.f5657z = r10;
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.B = r12;
            r12.position(0);
        }

        static /* synthetic */ m8.a a(a r10) {
            return r10.f5653v;
        }

        static /* synthetic */ m8.a b(a r10) {
            return r10.f5654w;
        }

        static /* synthetic */ m8.a c(a r10) {
            return r10.f5655x;
        }

        static /* synthetic */ int d(a r10, int r11) {
            r10.f5656y = r11;
            return r11;
        }

        private void e(String r10) {
            int r11 = GLES30.glGetError();
            if (r11 != 0) goto L5;
            return;
        L5:
            Log.e(GL3ShaderViewFog.a(), r10 + ": glError " + r11);
            throw new RuntimeException(r10 + ": glError " + r11);
        }

        private int f(String r10, String r11) {
            int r12 = h(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = h(35632, r11);
            if (r13 != 0) goto L8;
            return 0;
        L8:
            int r14 = GLES30.glCreateProgram();
            if (r14 == 0) goto L14;
            GLES30.glAttachShader(r14, r12);
            e("glAttachShader");
            GLES30.glAttachShader(r14, r13);
            e("glAttachShader");
            GLES30.glLinkProgram(r14);
            int[] r15 = new int[1];
            GLES30.glGetProgramiv(r14, 35714, r15, 0);
            if (r15[0] == 1) goto L14;
            Log.e(GL3ShaderViewFog.a(), "Could not link program: ");
            Log.e(GL3ShaderViewFog.a(), GLES30.glGetProgramInfoLog(r14));
            GLES30.glDeleteProgram(r14);
            return 0;
        L14:
            return r14;
        }

        private void g() {
            if (this.D != 0) goto L5;
            int r10 = f("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.D = r10;
            this.E = GLES30.glGetAttribLocation(r10, "vPosition");
            e("glGetAttribLocation");
            this.F = GLES30.glGetUniformLocation(this.D, "u_background");
            e("glGetAttribLocation");
            this.G = GLES30.glGetUniformLocation(this.D, "u_resolution");
            e("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.D);
            if (this.H != 0) goto L8;
            int[] r11 = new int[1];
            GLES30.glGenFramebuffers(1, r11, 0);
            this.H = r11[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.H);
            if (this.I != 0) goto L11;
            int[] r12 = new int[1];
            GLES30.glGenTextures(1, r12, 0);
            this.I = r12[0];
        L11:
            GLES30.glBindTexture(3553, this.I);
            GLES30.glTexImage2D(3553, 0, 6408, this.f5649r, this.f5651t, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.I, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        private int h(int r10, String r11) {
            int r12 = GLES30.glCreateShader(r10);
            if (r12 == 0) goto L8;
            GLES30.glShaderSource(r12, r11);
            GLES30.glCompileShader(r12);
            int[] r13 = new int[1];
            GLES30.glGetShaderiv(r12, 35713, r13, 0);
            if (r13[0] != 0) goto L9;
            Log.e(GL3ShaderViewFog.a(), "Could not compile shader " + r10 + ":");
            Log.e(GL3ShaderViewFog.a(), GLES30.glGetShaderInfoLog(r12));
            GLES30.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        private static int i(Context r10, Bitmap r11) {
            int[] r12 = new int[1];
            GLES30.glGenTextures(1, r12, 0);
            if (r12[0] == 0) goto L6;
            GLES30.glBindTexture(3553, r12[0]);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLUtils.texImage2D(3553, 0, r11, 0);
            GLES30.glBindTexture(3553, 0);
            r11.recycle();
        L6:
            return r12[0];
        }

        private void j() {
            GLES30.glBindFramebuffer(36160, this.H);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.D);
            GLES30.glUniform2f(this.G, this.f5649r, this.f5651t);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f5642k);
            GLES30.glUniform1i(this.F, 0);
            GLES30.glEnableVertexAttribArray(this.E);
            GLES30.glVertexAttribPointer(this.E, 2, 5126, false, 0, this.B);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.I);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        public void k(Bitmap r10) {
            this.C = r10;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r10) {
            if (this.f5649r == this.f5650s) goto L5;
        L6:
            g();
            j();
        L7:
            long r11 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5632a);
            GLES30.glUniform1f(this.f5638g, (r11 % TimeUtils.NANOSECONDS_PER_MILLISECOND) / 1000.0f);
            int r12 = this.f5649r;
            if (r12 == this.f5650s) goto L10;
        L11:
            this.f5650s = r12;
            int r13 = this.f5651t;
            this.f5652u = r13;
            GLES30.glUniform2f(this.f5636e, r12, r13);
        L13:
            if (this.f5653v.a() == this.f5645n) goto L16;
            float r14 = this.f5653v.a();
            this.f5645n = r14;
            GLES30.glUniform1f(this.f5639h, r14);
        L16:
            if (this.f5654w.a() == this.f5646o) goto L19;
            float r15 = this.f5654w.a();
            this.f5646o = r15;
            GLES30.glUniform1f(this.f5640i, r15);
        L19:
            if (this.f5655x.a() == this.f5647p) goto L21;
            float r16 = this.f5655x.a();
            this.f5647p = r16;
            GLES30.glUniform1f(this.f5641j, r16);
        L21:
            int r17 = this.f5656y;
            if (r17 == this.f5648q) goto L24;
            this.f5648q = r17;
            GLES30.glUniform3f(this.f5637f, Color.red(r17) / 255.0f, Color.green(this.f5648q) / 255.0f, Color.blue(this.f5648q) / 255.0f);
        L24:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f5642k);
            GLES30.glUniform1i(this.f5634c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.I);
            GLES30.glUniform1i(this.f5635d, 1);
            GLES30.glBindVertexArray(this.f5643l);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.f5651t == this.f5652u) goto L13;
        L5:
            if (this.f5651t == this.f5652u) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.f5649r = r11;
            this.f5651t = r12;
            GLES30.glViewport(0, 0, r11, r12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r10, EGLConfig r11) {
            int r12 = f("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f5632a = r12;
            if (r12 != 0) goto L5;
            return;
        L5:
            this.f5633b = GLES30.glGetAttribLocation(r12, "vPosition");
            e("glGetAttribLocation");
            this.f5634c = GLES30.glGetUniformLocation(this.f5632a, "u_background");
            e("glGetAttribLocation");
            this.f5635d = GLES30.glGetUniformLocation(this.f5632a, "u_prepass");
            e("glGetAttribLocation");
            this.f5636e = GLES30.glGetUniformLocation(this.f5632a, "u_resolution");
            e("glGetUniformLocation");
            this.f5637f = GLES30.glGetUniformLocation(this.f5632a, "u_color");
            e("glGetUniformLocation");
            this.f5638g = GLES30.glGetUniformLocation(this.f5632a, "u_time");
            e("glGetUniformLocation");
            this.f5639h = GLES30.glGetUniformLocation(this.f5632a, "u_alpha");
            e("glGetUniformLocation");
            this.f5640i = GLES30.glGetUniformLocation(this.f5632a, "u_intensity");
            e("glGetUniformLocation");
            this.f5641j = GLES30.glGetUniformLocation(this.f5632a, "u_speed");
            e("glGetUniformLocation");
            GLES30.glUseProgram(this.f5632a);
            this.f5642k = i(this.f5657z, this.C);
            int[] r13 = new int[1];
            GLES30.glGenVertexArrays(1, r13, 0);
            int r14 = r13[0];
            this.f5643l = r14;
            GLES30.glBindVertexArray(r14);
            int[] r15 = new int[1];
            GLES30.glGenBuffers(1, r15, 0);
            int r16 = r15[0];
            this.f5644m = r16;
            GLES30.glBindBuffer(34962, r16);
            GLES30.glBufferData(34962, this.A.length * 4, this.B, 35044);
            GLES30.glEnableVertexAttribArray(this.f5633b);
            GLES30.glVertexAttribPointer(this.f5633b, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }
    }

    static {
    }

    public GL3ShaderViewFog(Context r10) {
        super(r10, null);
    }

    public GL3ShaderViewFog(Context r10, AttributeSet r11) {
        super(r10, r11);
        b();
    }

    static /* synthetic */ String a() {
        return f5630g;
    }

    private void b() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r10 = new a(getContext());
        this.f5631c = r10;
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
        this.f5631c.k(r10);
    }

    public void setShaderAlpha(float r10) {
        a.a(this.f5631c).b(r10);
    }

    public void setShaderColor(int r10) {
        a.d(this.f5631c, r10);
    }

    public void setShaderIntensity(float r10) {
        a.b(this.f5631c).b(r10);
    }

    public void setShaderSpeed(float r10) {
        a.c(this.f5631c).b(r10);
    }
}
