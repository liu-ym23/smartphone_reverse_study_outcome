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
public class GL3ShaderViewRain extends GLSurfaceView implements Choreographer.FrameCallback {
    public static final /* synthetic */ int b = 0;
    public a a;

    public static class a implements GLSurfaceView.Renderer {
        public int A;
        public int B;
        public int C;
        public int D;
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
        public float l;
        public float m;
        public float n;
        public int o;
        public int p;
        public int q;
        public int r;
        public final c s;
        public final c t;
        public final c u;
        public final float[] v;
        public final FloatBuffer w;
        public Bitmap x;
        public int y;
        public int z;

        public a(Context r4) {
            this.l = -1.0f;
            this.m = -1.0f;
            this.n = -1.0f;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.s = new c(1.0f);
            this.t = new c(1.0f);
            this.u = new c(0.25f);
            float[] r0 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.v = r0;
            this.y = 0;
            this.C = 0;
            this.D = 0;
            FloatBuffer r1 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r0);
            this.w = r1;
            r1.position(0);
        }

        public static void a(String r3) {
            int r0 = GLES30.glGetError();
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = GL3ShaderViewRain.b;
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
            int r6 = GL3ShaderViewRain.b;
            GLES30.glGetProgramInfoLog(r2);
            GLES30.glDeleteProgram(r2);
            return 0;
        L14:
            return r2;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r21) {
            if (this.o != this.p) goto L7;
            if (this.q != this.r) goto L7;
        L16:
            long r1 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.a);
            GLES30.glUniform1f(this.f, (r1 % 1000000) / 1000.0f);
            int r2 = this.o;
            if (r2 == this.p) goto L19;
        L20:
            this.p = r2;
            int r3 = this.q;
            this.r = r3;
            GLES30.glUniform2f(this.e, r2, r3);
        L21:
            float r4 = this.s.a;
            if (r4 == this.l) goto L24;
            this.l = r4;
            GLES30.glUniform1f(this.g, r4);
        L24:
            float r5 = this.t.a;
            if (r5 == this.m) goto L27;
            this.m = r5;
            GLES30.glUniform1f(this.h, r5);
        L27:
            float r6 = this.u.a;
            if (r6 == this.n) goto L30;
            this.n = r6;
            GLES30.glUniform1f(this.i, r6);
        L30:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.j);
            GLES30.glUniform1i(this.c, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.D);
            GLES30.glUniform1i(this.d, 1);
            GLES30.glBindVertexArray(this.k);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L19:
            if (this.q == this.r) goto L21;
        L7:
            if (this.y != 0) goto L9;
            int r7 = b("#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.y = r7;
            this.z = GLES30.glGetAttribLocation(r7, "vPosition");
            a("glGetAttribLocation");
            this.A = GLES30.glGetUniformLocation(this.y, "u_background");
            a("glGetAttribLocation");
            this.B = GLES30.glGetUniformLocation(this.y, "u_resolution");
            a("glGetUniformLocation");
        L9:
            GLES30.glUseProgram(this.y);
            if (this.C != 0) goto L12;
            int[] r8 = new int[1];
            GLES30.glGenFramebuffers(1, r8, 0);
            this.C = r8[0];
        L12:
            GLES30.glBindFramebuffer(36160, this.C);
            if (this.D != 0) goto L15;
            int[] r9 = new int[1];
            GLES30.glGenTextures(1, r9, 0);
            this.D = r9[0];
        L15:
            GLES30.glBindTexture(3553, this.D);
            GLES30.glTexImage2D(3553, 0, 6408, this.o, this.q, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.D, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
            GLES30.glBindFramebuffer(36160, this.C);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.y);
            GLES30.glUniform2f(this.B, this.o, this.q);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.j);
            GLES30.glUniform1i(this.A, 0);
            GLES30.glEnableVertexAttribArray(this.z);
            GLES30.glVertexAttribPointer(this.z, 2, 5126, false, 0, this.w);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.D);
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
            int r6 = GL3ShaderViewRain.b;
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
            int r11 = b("#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
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
            this.f = GLES30.glGetUniformLocation(this.a, "u_time");
            a("glGetUniformLocation");
            this.g = GLES30.glGetUniformLocation(this.a, "u_alpha");
            a("glGetUniformLocation");
            this.h = GLES30.glGetUniformLocation(this.a, "u_intensity");
            a("glGetUniformLocation");
            this.i = GLES30.glGetUniformLocation(this.a, "u_speed");
            a("glGetUniformLocation");
            GLES30.glUseProgram(this.a);
            Bitmap r12 = this.x;
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
            this.j = r0[0];
            int[] r13 = new int[1];
            GLES30.glGenVertexArrays(1, r13, 0);
            int r14 = r13[0];
            this.k = r14;
            GLES30.glBindVertexArray(r14);
            int[] r15 = new int[1];
            GLES30.glGenBuffers(1, r15, 0);
            GLES30.glBindBuffer(34962, r15[0]);
            GLES30.glBufferData(34962, this.v.length * 4, this.w, 35044);
            GLES30.glEnableVertexAttribArray(this.b);
            GLES30.glVertexAttribPointer(this.b, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r1, int r2, int r3) {
            this.o = r2;
            this.q = r3;
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

    public GL3ShaderViewRain(Context r2) {
        super(r2, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r2) {
        this.a.x = r2;
    }

    public void setShaderAlpha(float r2) {
        this.a.s.a = r2;
    }

    public void setShaderIntensity(float r2) {
        this.a.t.a = r2;
    }

    public void setShaderSpeed(float r2) {
        this.a.u.a = r2;
    }

    public GL3ShaderViewRain(Context r8, AttributeSet r9) {
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
