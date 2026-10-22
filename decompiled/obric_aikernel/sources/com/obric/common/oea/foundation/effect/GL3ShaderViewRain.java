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
import com.ttnet.org.chromium.base.TimeUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewRain extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f5732g = "GL2ShaderView";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5733c;

    private static class a implements GLSurfaceView.Renderer {
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5739f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5740g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f5741h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f5742i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f5743j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f5744k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f5745l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private float f5746m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private float f5747n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private float f5748o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f5749p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f5750q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f5751r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f5752s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private m8.a f5753t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private m8.a f5754u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private m8.a f5755v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private Context f5756w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float[] f5757x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private FloatBuffer f5758y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private Bitmap f5759z;

        public a(Context r10) {
            this.f5746m = -1.0f;
            this.f5747n = -1.0f;
            this.f5748o = -1.0f;
            this.f5749p = 0;
            this.f5750q = 0;
            this.f5751r = 0;
            this.f5752s = 0;
            this.f5753t = new m8.a(1.0f);
            this.f5754u = new m8.a(1.0f);
            this.f5755v = new m8.a(0.25f);
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.f5757x = r11;
            this.A = 0;
            this.E = 0;
            this.F = 0;
            this.f5756w = r10;
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.f5758y = r12;
            r12.position(0);
        }

        static /* synthetic */ m8.a a(a r10) {
            return r10.f5753t;
        }

        static /* synthetic */ m8.a b(a r10) {
            return r10.f5754u;
        }

        static /* synthetic */ m8.a c(a r10) {
            return r10.f5755v;
        }

        private void d(String r10) {
            int r11 = GLES30.glGetError();
            if (r11 != 0) goto L5;
            return;
        L5:
            Log.e(GL3ShaderViewRain.a(), r10 + ": glError " + r11);
            throw new RuntimeException(r10 + ": glError " + r11);
        }

        private int e(String r10, String r11) {
            int r12 = g(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = g(35632, r11);
            if (r13 != 0) goto L8;
            return 0;
        L8:
            int r14 = GLES30.glCreateProgram();
            if (r14 == 0) goto L14;
            GLES30.glAttachShader(r14, r12);
            d("glAttachShader");
            GLES30.glAttachShader(r14, r13);
            d("glAttachShader");
            GLES30.glLinkProgram(r14);
            int[] r15 = new int[1];
            GLES30.glGetProgramiv(r14, 35714, r15, 0);
            if (r15[0] == 1) goto L14;
            Log.e(GL3ShaderViewRain.a(), "Could not link program: ");
            Log.e(GL3ShaderViewRain.a(), GLES30.glGetProgramInfoLog(r14));
            GLES30.glDeleteProgram(r14);
            return 0;
        L14:
            return r14;
        }

        private void f() {
            if (this.A != 0) goto L5;
            int r10 = e("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.A = r10;
            this.B = GLES30.glGetAttribLocation(r10, "vPosition");
            d("glGetAttribLocation");
            this.C = GLES30.glGetUniformLocation(this.A, "u_background");
            d("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.A, "u_resolution");
            d("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.A);
            if (this.E != 0) goto L8;
            int[] r11 = new int[1];
            GLES30.glGenFramebuffers(1, r11, 0);
            this.E = r11[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.E);
            if (this.F != 0) goto L11;
            int[] r12 = new int[1];
            GLES30.glGenTextures(1, r12, 0);
            this.F = r12[0];
        L11:
            GLES30.glBindTexture(3553, this.F);
            GLES30.glTexImage2D(3553, 0, 6408, this.f5749p, this.f5751r, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.F, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        private int g(int r10, String r11) {
            int r12 = GLES30.glCreateShader(r10);
            if (r12 == 0) goto L8;
            GLES30.glShaderSource(r12, r11);
            GLES30.glCompileShader(r12);
            int[] r13 = new int[1];
            GLES30.glGetShaderiv(r12, 35713, r13, 0);
            if (r13[0] != 0) goto L9;
            Log.e(GL3ShaderViewRain.a(), "Could not compile shader " + r10 + ":");
            Log.e(GL3ShaderViewRain.a(), GLES30.glGetShaderInfoLog(r12));
            GLES30.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        private static int h(Context r10, Bitmap r11) {
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

        private void i() {
            GLES30.glBindFramebuffer(36160, this.E);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.A);
            GLES30.glUniform2f(this.D, this.f5749p, this.f5751r);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f5743j);
            GLES30.glUniform1i(this.C, 0);
            GLES30.glEnableVertexAttribArray(this.B);
            GLES30.glVertexAttribPointer(this.B, 2, 5126, false, 0, this.f5758y);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.F);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        public void j(Bitmap r10) {
            this.f5759z = r10;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r10) {
            if (this.f5749p == this.f5750q) goto L5;
        L6:
            f();
            i();
        L7:
            long r11 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f5734a);
            GLES30.glUniform1f(this.f5739f, (r11 % TimeUtils.NANOSECONDS_PER_MILLISECOND) / 1000.0f);
            int r12 = this.f5749p;
            if (r12 == this.f5750q) goto L10;
        L11:
            this.f5750q = r12;
            int r13 = this.f5751r;
            this.f5752s = r13;
            GLES30.glUniform2f(this.f5738e, r12, r13);
        L13:
            if (this.f5753t.a() == this.f5746m) goto L16;
            float r14 = this.f5753t.a();
            this.f5746m = r14;
            GLES30.glUniform1f(this.f5740g, r14);
        L16:
            if (this.f5754u.a() == this.f5747n) goto L19;
            float r15 = this.f5754u.a();
            this.f5747n = r15;
            GLES30.glUniform1f(this.f5741h, r15);
        L19:
            if (this.f5755v.a() == this.f5748o) goto L21;
            float r16 = this.f5755v.a();
            this.f5748o = r16;
            GLES30.glUniform1f(this.f5742i, r16);
        L21:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f5743j);
            GLES30.glUniform1i(this.f5736c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.F);
            GLES30.glUniform1i(this.f5737d, 1);
            GLES30.glBindVertexArray(this.f5744k);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.f5751r == this.f5752s) goto L13;
        L5:
            if (this.f5751r == this.f5752s) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.f5749p = r11;
            this.f5751r = r12;
            GLES30.glViewport(0, 0, r11, r12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r10, EGLConfig r11) {
            int r12 = e("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f5734a = r12;
            if (r12 != 0) goto L5;
            return;
        L5:
            this.f5735b = GLES30.glGetAttribLocation(r12, "vPosition");
            d("glGetAttribLocation");
            this.f5736c = GLES30.glGetUniformLocation(this.f5734a, "u_background");
            d("glGetAttribLocation");
            this.f5737d = GLES30.glGetUniformLocation(this.f5734a, "u_prepass");
            d("glGetAttribLocation");
            this.f5738e = GLES30.glGetUniformLocation(this.f5734a, "u_resolution");
            d("glGetUniformLocation");
            this.f5739f = GLES30.glGetUniformLocation(this.f5734a, "u_time");
            d("glGetUniformLocation");
            this.f5740g = GLES30.glGetUniformLocation(this.f5734a, "u_alpha");
            d("glGetUniformLocation");
            this.f5741h = GLES30.glGetUniformLocation(this.f5734a, "u_intensity");
            d("glGetUniformLocation");
            this.f5742i = GLES30.glGetUniformLocation(this.f5734a, "u_speed");
            d("glGetUniformLocation");
            GLES30.glUseProgram(this.f5734a);
            this.f5743j = h(this.f5756w, this.f5759z);
            int[] r13 = new int[1];
            GLES30.glGenVertexArrays(1, r13, 0);
            int r14 = r13[0];
            this.f5744k = r14;
            GLES30.glBindVertexArray(r14);
            int[] r15 = new int[1];
            GLES30.glGenBuffers(1, r15, 0);
            int r16 = r15[0];
            this.f5745l = r16;
            GLES30.glBindBuffer(34962, r16);
            GLES30.glBufferData(34962, this.f5757x.length * 4, this.f5758y, 35044);
            GLES30.glEnableVertexAttribArray(this.f5735b);
            GLES30.glVertexAttribPointer(this.f5735b, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }
    }

    static {
    }

    public GL3ShaderViewRain(Context r10) {
        super(r10, null);
    }

    public GL3ShaderViewRain(Context r10, AttributeSet r11) {
        super(r10, r11);
        b();
    }

    static /* synthetic */ String a() {
        return f5732g;
    }

    private void b() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r10 = new a(getContext());
        this.f5733c = r10;
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
        this.f5733c.j(r10);
    }

    public void setShaderAlpha(float r10) {
        a.a(this.f5733c).b(r10);
    }

    public void setShaderIntensity(float r10) {
        a.b(this.f5733c).b(r10);
    }

    public void setShaderSpeed(float r10) {
        a.c(this.f5733c).b(r10);
    }
}
