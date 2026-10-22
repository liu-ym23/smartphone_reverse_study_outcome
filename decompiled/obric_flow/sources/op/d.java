package op;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import com.obric.common.oea.foundation.effect.GL3ShaderViewRain;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements GLSurfaceView.Renderer {
    public int A;
    public int B;
    public int C;
    public int D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20901c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f20906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f20907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f20908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20911q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20912r;
    public final ip.b s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ip.b f20913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ip.b f20914u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float[] f20915v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FloatBuffer f20916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bitmap f20917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f20918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20919z;

    public d(Context r5) {
        this.f20906l = -1.0f;
        this.f20907m = -1.0f;
        this.f20908n = -1.0f;
        this.f20909o = 0;
        this.f20910p = 0;
        this.f20911q = 0;
        this.f20912r = 0;
        this.s = new ip.b(1.0f);
        this.f20913t = new ip.b(1.0f);
        this.f20914u = new ip.b(0.25f);
        float[] r10 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.f20915v = r10;
        this.f20918y = 0;
        this.C = 0;
        this.D = 0;
        FloatBuffer r11 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r10);
        this.f20916w = r11;
        r11.position(0);
    }

    public static void a(String r5) {
        int r10 = GLES20.glGetError();
        if (r10 != 0) goto L5;
        return;
    L5:
        int r11 = GL3ShaderViewRain.f11337b;
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
        int r14 = GL3ShaderViewRain.f11337b;
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
        int r13 = GL3ShaderViewRain.f11337b;
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
        if (this.f20909o != this.f20910p) goto L7;
        if (this.f20911q != this.f20912r) goto L7;
    L16:
        long r5 = System.currentTimeMillis();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20899a);
        GLES20.glUniform1f(this.f, (r5 % 1000000) / 1000.0f);
        int r10 = this.f20909o;
        if (r10 == this.f20910p) goto L19;
    L20:
        this.f20910p = r10;
        int r11 = this.f20911q;
        this.f20912r = r11;
        GLES20.glUniform2f(this.e, r10, r11);
    L21:
        float r12 = this.s.f18208a;
        if (r12 == this.f20906l) goto L24;
        this.f20906l = r12;
        GLES20.glUniform1f(this.g, r12);
    L24:
        float r13 = this.f20913t.f18208a;
        if (r13 == this.f20907m) goto L27;
        this.f20907m = r13;
        GLES20.glUniform1f(this.f20902h, r13);
    L27:
        float r14 = this.f20914u.f18208a;
        if (r14 == this.f20908n) goto L30;
        this.f20908n = r14;
        GLES20.glUniform1f(this.f20903i, r14);
    L30:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f20904j);
        GLES20.glUniform1i(this.f20901c, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.D);
        GLES20.glUniform1i(this.d, 1);
        GLES30.glBindVertexArray(this.f20905k);
        GLES20.glDrawArrays(6, 0, 4);
        GLES30.glBindVertexArray(0);
        return;
    L19:
        if (this.f20911q == this.f20912r) goto L21;
    L7:
        if (this.f20918y != 0) goto L9;
        int r15 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
        this.f20918y = r15;
        this.f20919z = GLES20.glGetAttribLocation(r15, "vPosition");
        a("glGetAttribLocation");
        this.A = GLES20.glGetUniformLocation(this.f20918y, "u_background");
        a("glGetAttribLocation");
        this.B = GLES20.glGetUniformLocation(this.f20918y, "u_resolution");
        a("glGetUniformLocation");
    L9:
        GLES20.glUseProgram(this.f20918y);
        if (this.C != 0) goto L12;
        int[] r16 = new int[1];
        GLES20.glGenFramebuffers(1, r16, 0);
        this.C = r16[0];
    L12:
        GLES20.glBindFramebuffer(36160, this.C);
        if (this.D != 0) goto L15;
        int[] r17 = new int[1];
        GLES20.glGenTextures(1, r17, 0);
        this.D = r17[0];
    L15:
        GLES20.glBindTexture(3553, this.D);
        GLES20.glTexImage2D(3553, 0, 6408, this.f20909o, this.f20911q, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.D, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, this.C);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.f20918y);
        GLES20.glUniform2f(this.B, this.f20909o, this.f20911q);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f20904j);
        GLES20.glUniform1i(this.A, 0);
        GLES20.glEnableVertexAttribArray(this.f20919z);
        GLES20.glVertexAttribPointer(this.f20919z, 2, 5126, false, 0, this.f20916w);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glBindTexture(3553, this.D);
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        goto L16
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r5, int r10, int r11) {
        this.f20909o = r10;
        this.f20911q = r11;
        GLES20.glViewport(0, 0, r10, r11);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r10, EGLConfig r11) {
        int r12 = b("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
        this.f20899a = r12;
        if (r12 != 0) goto L5;
        return;
    L5:
        this.f20900b = GLES20.glGetAttribLocation(r12, "vPosition");
        a("glGetAttribLocation");
        this.f20901c = GLES20.glGetUniformLocation(this.f20899a, "u_background");
        a("glGetAttribLocation");
        this.d = GLES20.glGetUniformLocation(this.f20899a, "u_prepass");
        a("glGetAttribLocation");
        this.e = GLES20.glGetUniformLocation(this.f20899a, "u_resolution");
        a("glGetUniformLocation");
        this.f = GLES20.glGetUniformLocation(this.f20899a, "u_time");
        a("glGetUniformLocation");
        this.g = GLES20.glGetUniformLocation(this.f20899a, "u_alpha");
        a("glGetUniformLocation");
        this.f20902h = GLES20.glGetUniformLocation(this.f20899a, "u_intensity");
        a("glGetUniformLocation");
        this.f20903i = GLES20.glGetUniformLocation(this.f20899a, "u_speed");
        a("glGetUniformLocation");
        GLES20.glUseProgram(this.f20899a);
        Bitmap r13 = this.f20917x;
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
        this.f20904j = r5[0];
        int[] r15 = new int[1];
        GLES30.glGenVertexArrays(1, r15, 0);
        int r16 = r15[0];
        this.f20905k = r16;
        GLES30.glBindVertexArray(r16);
        int[] r17 = new int[1];
        GLES20.glGenBuffers(1, r17, 0);
        GLES20.glBindBuffer(34962, r17[0]);
        GLES20.glBufferData(34962, this.f20915v.length * 4, this.f20916w, 35044);
        GLES20.glEnableVertexAttribArray(this.f20900b);
        GLES20.glVertexAttribPointer(this.f20900b, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES30.glBindVertexArray(0);
        GLES20.glUseProgram(0);
    }
}
