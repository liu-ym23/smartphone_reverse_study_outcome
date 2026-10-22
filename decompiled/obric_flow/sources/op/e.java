package op;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import com.obric.common.oea.foundation.effect.GL3ShaderViewSnow;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements GLSurfaceView.Renderer {
    public Bitmap A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20922c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f20928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f20929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f20930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f20931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20933r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20934t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ip.b f20935u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ip.b f20936v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ip.b f20937w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f20938x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final FloatBuffer f20939y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Bitmap f20940z;

    public e(Context r5) {
        this.f20929n = -1.0f;
        this.f20930o = -1.0f;
        this.f20931p = -1.0f;
        this.f20932q = 0;
        this.f20933r = 0;
        this.s = 0;
        this.f20934t = 0;
        this.f20935u = new ip.b(1.0f);
        this.f20936v = new ip.b(0.5f);
        this.f20937w = new ip.b(1.0f);
        float[] r10 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.f20938x = r10;
        this.B = 0;
        this.F = 0;
        this.G = 0;
        FloatBuffer r11 = ByteBuffer.allocateDirect(r10.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r10);
        this.f20939y = r11;
        r11.position(0);
    }

    public static void a(String r5) {
        int r10 = GLES20.glGetError();
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = GL3ShaderViewSnow.f11339b;
        Log.e("GL2ShaderView", r5 + ": glError " + r10);
        throw new RuntimeException(r5 + ": glError " + r10);
    }

    public static int b(String r5) {
        int r10 = c(35633, "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n");
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r11 = c(35632, r5);
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
        int r14 = GL3ShaderViewSnow.f11339b;
        Log.e("GL2ShaderView", "Could not link program: ");
        Log.e("GL2ShaderView", GLES20.glGetProgramInfoLog(r12));
        GLES20.glDeleteProgram(r12);
        return 0;
    L14:
        return r12;
    }

    public static int c(int r5, String r10) {
        int r11 = GLES20.glCreateShader(r5);
        if (r11 == 0) goto L8;
        GLES20.glShaderSource(r11, r10);
        GLES20.glCompileShader(r11);
        int[] r12 = new int[1];
        GLES20.glGetShaderiv(r11, 35713, r12, 0);
        if (r12[0] != 0) goto L9;
        int r13 = GL3ShaderViewSnow.f11339b;
        Log.e("GL2ShaderView", "Could not compile shader " + r5 + ":");
        Log.e("GL2ShaderView", GLES20.glGetShaderInfoLog(r11));
        GLES20.glDeleteShader(r11);
        return 0;
    L9:
        return r11;
    L8:
        return r11;
    }

    public static int d(Bitmap r5) {
        int[] r10 = new int[1];
        GLES20.glGenTextures(1, r10, 0);
        int r11 = r10[0];
        if (r11 == 0) goto L6;
        GLES20.glBindTexture(3553, r11);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLUtils.texImage2D(3553, 0, r5, 0);
        GLES20.glBindTexture(3553, 0);
        r5.recycle();
    L6:
        return r10[0];
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r21) {
        if (this.f20932q != this.f20933r) goto L7;
        if (this.s != this.f20934t) goto L7;
    L16:
        long r5 = System.currentTimeMillis();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20920a);
        GLES20.glUniform1f(this.g, (r5 % 1000000) / 1000.0f);
        int r10 = this.f20932q;
        if (r10 == this.f20933r) goto L19;
    L20:
        this.f20933r = r10;
        int r11 = this.s;
        this.f20934t = r11;
        GLES20.glUniform2f(this.f, r10, r11);
    L21:
        float r12 = this.f20935u.f18208a;
        if (r12 == this.f20929n) goto L24;
        this.f20929n = r12;
        GLES20.glUniform1f(this.f20923h, r12);
    L24:
        float r13 = this.f20936v.f18208a;
        if (r13 == this.f20930o) goto L27;
        this.f20930o = r13;
        GLES20.glUniform1f(this.f20924i, r13);
    L27:
        float r14 = this.f20937w.f18208a;
        if (r14 == this.f20931p) goto L30;
        this.f20931p = r14;
        GLES20.glUniform1f(this.f20925j, r14);
    L30:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f20926k);
        GLES20.glUniform1i(this.f20922c, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.G);
        GLES20.glUniform1i(this.d, 1);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f20927l);
        GLES20.glUniform1i(this.e, 2);
        GLES30.glBindVertexArray(this.f20928m);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        return;
    L19:
        if (this.s == this.f20934t) goto L21;
    L7:
        if (this.B != 0) goto L9;
        int r15 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
        this.B = r15;
        this.C = GLES20.glGetAttribLocation(r15, "vPosition");
        a("glGetAttribLocation");
        this.D = GLES20.glGetUniformLocation(this.B, "u_background");
        a("glGetAttribLocation");
        this.E = GLES20.glGetUniformLocation(this.B, "u_resolution");
        a("glGetUniformLocation");
    L9:
        GLES20.glUseProgram(this.B);
        if (this.F != 0) goto L12;
        int[] r16 = new int[1];
        GLES20.glGenFramebuffers(1, r16, 0);
        this.F = r16[0];
    L12:
        GLES20.glBindFramebuffer(36160, this.F);
        if (this.G != 0) goto L15;
        int[] r17 = new int[1];
        GLES20.glGenTextures(1, r17, 0);
        this.G = r17[0];
    L15:
        GLES20.glBindTexture(3553, this.G);
        GLES20.glTexImage2D(3553, 0, 6408, this.f20932q, this.s, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.G, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, this.F);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.B);
        GLES20.glUniform2f(this.E, this.f20932q, this.s);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f20926k);
        GLES20.glUniform1i(this.D, 0);
        GLES20.glEnableVertexAttribArray(this.C);
        GLES20.glVertexAttribPointer(this.C, 2, 5126, false, 0, this.f20939y);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glBindTexture(3553, this.G);
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        goto L16
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r5, int r10, int r11) {
        this.f20932q = r10;
        this.s = r11;
        GLES20.glViewport(0, 0, r10, r11);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r10, EGLConfig r11) {
        int r12 = b("#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
        this.f20920a = r12;
        if (r12 != 0) goto L5;
        return;
    L5:
        this.f20921b = GLES20.glGetAttribLocation(r12, "vPosition");
        a("glGetAttribLocation");
        this.f20922c = GLES20.glGetUniformLocation(this.f20920a, "u_background");
        a("glGetAttribLocation");
        this.d = GLES20.glGetUniformLocation(this.f20920a, "u_prepass");
        a("glGetAttribLocation");
        this.e = GLES20.glGetUniformLocation(this.f20920a, "u_frostTex");
        a("glGetAttribLocation");
        this.f = GLES20.glGetUniformLocation(this.f20920a, "u_resolution");
        a("glGetUniformLocation");
        this.g = GLES20.glGetUniformLocation(this.f20920a, "u_time");
        a("glGetUniformLocation");
        this.f20923h = GLES20.glGetUniformLocation(this.f20920a, "u_alpha");
        a("glGetUniformLocation");
        this.f20924i = GLES20.glGetUniformLocation(this.f20920a, "u_intensity");
        a("glGetUniformLocation");
        this.f20925j = GLES20.glGetUniformLocation(this.f20920a, "u_speed");
        a("glGetUniformLocation");
        GLES20.glUseProgram(this.f20920a);
        this.f20926k = d(this.f20940z);
        this.f20927l = d(this.A);
        int[] r13 = new int[1];
        GLES30.glGenVertexArrays(1, r13, 0);
        int r14 = r13[0];
        this.f20928m = r14;
        GLES30.glBindVertexArray(r14);
        int[] r15 = new int[1];
        GLES20.glGenBuffers(1, r15, 0);
        GLES20.glBindBuffer(34962, r15[0]);
        GLES20.glBufferData(34962, this.f20938x.length * 4, this.f20939y, 35044);
        GLES20.glEnableVertexAttribArray(this.f20921b);
        GLES20.glVertexAttribPointer(this.f20921b, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES30.glBindVertexArray(0);
        GLES20.glUseProgram(0);
    }
}
