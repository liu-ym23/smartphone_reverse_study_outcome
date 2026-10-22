package op;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import com.obric.common.oea.foundation.effect.GL3ShaderViewFog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements GLSurfaceView.Renderer {
    public Bitmap A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20823c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f20829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f20830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f20831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20832p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20833q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20834r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20835t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ip.b f20836u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ip.b f20837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ip.b f20838w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20839x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float[] f20840y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final FloatBuffer f20841z;

    public a(Context r5) {
        this.f20829m = -1.0f;
        this.f20830n = -1.0f;
        this.f20831o = -1.0f;
        this.f20832p = 0;
        this.f20833q = 0;
        this.f20834r = 0;
        this.s = 0;
        this.f20835t = 0;
        this.f20836u = new ip.b(1.0f);
        this.f20837v = new ip.b(0.8f);
        this.f20838w = new ip.b(0.5f);
        this.f20839x = -3618616;
        float[] r10 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.f20840y = r10;
        this.B = 0;
        this.F = 0;
        this.G = 0;
        FloatBuffer r11 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r10);
        this.f20841z = r11;
        r11.position(0);
    }

    public static void a(String r5) {
        int r10 = GLES20.glGetError();
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = GL3ShaderViewFog.f11333b;
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
        int r14 = GL3ShaderViewFog.f11333b;
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
        int r13 = GL3ShaderViewFog.f11333b;
        Log.e("GL2ShaderView", "Could not compile shader " + r5 + ":");
        Log.e("GL2ShaderView", GLES20.glGetShaderInfoLog(r11));
        GLES20.glDeleteShader(r11);
        return 0;
    L9:
        return r11;
    L8:
        return r11;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r21) {
        if (this.f20833q != this.f20834r) goto L7;
        if (this.s != this.f20835t) goto L7;
    L16:
        long r5 = System.currentTimeMillis();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20821a);
        GLES20.glUniform1f(this.g, (r5 % 1000000) / 1000.0f);
        int r10 = this.f20833q;
        if (r10 == this.f20834r) goto L19;
    L20:
        this.f20834r = r10;
        int r11 = this.s;
        this.f20835t = r11;
        GLES20.glUniform2f(this.e, r10, r11);
    L21:
        float r12 = this.f20836u.f18208a;
        if (r12 == this.f20829m) goto L24;
        this.f20829m = r12;
        GLES20.glUniform1f(this.f20824h, r12);
    L24:
        float r13 = this.f20837v.f18208a;
        if (r13 == this.f20830n) goto L27;
        this.f20830n = r13;
        GLES20.glUniform1f(this.f20825i, r13);
    L27:
        float r14 = this.f20838w.f18208a;
        if (r14 == this.f20831o) goto L30;
        this.f20831o = r14;
        GLES20.glUniform1f(this.f20826j, r14);
    L30:
        int r15 = this.f20839x;
        if (r15 == this.f20832p) goto L33;
        this.f20832p = r15;
        GLES20.glUniform3f(this.f, Color.red(r15) / 255.0f, Color.green(this.f20832p) / 255.0f, Color.blue(this.f20832p) / 255.0f);
    L33:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f20827k);
        GLES20.glUniform1i(this.f20823c, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.G);
        GLES20.glUniform1i(this.d, 1);
        GLES30.glBindVertexArray(this.f20828l);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        return;
    L19:
        if (this.s == this.f20835t) goto L21;
    L7:
        if (this.B != 0) goto L9;
        int r16 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
        this.B = r16;
        this.C = GLES20.glGetAttribLocation(r16, "vPosition");
        a("glGetAttribLocation");
        this.D = GLES20.glGetUniformLocation(this.B, "u_background");
        a("glGetAttribLocation");
        this.E = GLES20.glGetUniformLocation(this.B, "u_resolution");
        a("glGetUniformLocation");
    L9:
        GLES20.glUseProgram(this.B);
        if (this.F != 0) goto L12;
        int[] r17 = new int[1];
        GLES20.glGenFramebuffers(1, r17, 0);
        this.F = r17[0];
    L12:
        GLES20.glBindFramebuffer(36160, this.F);
        if (this.G != 0) goto L15;
        int[] r18 = new int[1];
        GLES20.glGenTextures(1, r18, 0);
        this.G = r18[0];
    L15:
        GLES20.glBindTexture(3553, this.G);
        GLES20.glTexImage2D(3553, 0, 6408, this.f20833q, this.s, 0, 6408, 5121, null);
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
        GLES20.glUniform2f(this.E, this.f20833q, this.s);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f20827k);
        GLES20.glUniform1i(this.D, 0);
        GLES20.glEnableVertexAttribArray(this.C);
        GLES20.glVertexAttribPointer(this.C, 2, 5126, false, 0, this.f20841z);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glBindTexture(3553, this.G);
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        goto L16
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r5, int r10, int r11) {
        this.f20833q = r10;
        this.s = r11;
        GLES20.glViewport(0, 0, r10, r11);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r10, EGLConfig r11) {
        int r12 = b("#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
        this.f20821a = r12;
        if (r12 != 0) goto L5;
        return;
    L5:
        this.f20822b = GLES20.glGetAttribLocation(r12, "vPosition");
        a("glGetAttribLocation");
        this.f20823c = GLES20.glGetUniformLocation(this.f20821a, "u_background");
        a("glGetAttribLocation");
        this.d = GLES20.glGetUniformLocation(this.f20821a, "u_prepass");
        a("glGetAttribLocation");
        this.e = GLES20.glGetUniformLocation(this.f20821a, "u_resolution");
        a("glGetUniformLocation");
        this.f = GLES20.glGetUniformLocation(this.f20821a, "u_color");
        a("glGetUniformLocation");
        this.g = GLES20.glGetUniformLocation(this.f20821a, "u_time");
        a("glGetUniformLocation");
        this.f20824h = GLES20.glGetUniformLocation(this.f20821a, "u_alpha");
        a("glGetUniformLocation");
        this.f20825i = GLES20.glGetUniformLocation(this.f20821a, "u_intensity");
        a("glGetUniformLocation");
        this.f20826j = GLES20.glGetUniformLocation(this.f20821a, "u_speed");
        a("glGetUniformLocation");
        GLES20.glUseProgram(this.f20821a);
        Bitmap r13 = this.A;
        int[] r5 = new int[1];
        GLES20.glGenTextures(1, r5, 0);
        int r14 = r5[0];
        if (r14 == 0) goto L8;
        GLES20.glBindTexture(3553, r14);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLUtils.texImage2D(3553, 0, r13, 0);
        GLES20.glBindTexture(3553, 0);
        r13.recycle();
    L8:
        this.f20827k = r5[0];
        int[] r15 = new int[1];
        GLES30.glGenVertexArrays(1, r15, 0);
        int r16 = r15[0];
        this.f20828l = r16;
        GLES30.glBindVertexArray(r16);
        int[] r17 = new int[1];
        GLES20.glGenBuffers(1, r17, 0);
        GLES20.glBindBuffer(34962, r17[0]);
        GLES20.glBufferData(34962, this.f20840y.length * 4, this.f20841z, 35044);
        GLES20.glEnableVertexAttribArray(this.f20822b);
        GLES20.glVertexAttribPointer(this.f20822b, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES30.glBindVertexArray(0);
        GLES20.glUseProgram(0);
    }
}
