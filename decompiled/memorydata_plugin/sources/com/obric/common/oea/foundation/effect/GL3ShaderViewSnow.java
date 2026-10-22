package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import com.obric.common.oea.foundation.animation.c.d;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public class GL3ShaderViewSnow extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7750a = "GL2ShaderView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f7751b;

    private static class a implements GLSurfaceView.Renderer {
        private d A;
        private d B;
        private Context C;
        private final float[] D;
        private FloatBuffer E;
        private Bitmap F;
        private Bitmap G;
        private int H;
        private int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private int f7752J;
        private int K;
        private int L;
        private int M;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7754b;
        private final String c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private float r;
        private float s;
        private float t;
        private int u;
        private int v;
        private int w;
        private int x;
        private int y;
        private d z;

        public a(Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            this.f7753a = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.f7754b = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.c = "#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.r = -1.0f;
            this.s = -1.0f;
            this.t = -1.0f;
            this.u = 0;
            this.v = 0;
            this.w = 0;
            this.x = 0;
            this.y = 0;
            this.z = new d(1.0f);
            this.A = new d(0.5f);
            this.B = new d(1.0f);
            float[] r2 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.D = r2;
            this.H = 0;
            this.L = 0;
            this.M = 0;
            this.C = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
            FloatBuffer r8 = ByteBuffer.allocateDirect(r2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r2);
            this.E = r8;
            r8.position(0);
        }

        private int a(int r4, String r5) {
            int r3 = GLES30.glCreateShader(r4);
            if (r3 == 0) goto L8;
            GLES30.glShaderSource(r3, r5);
            GLES30.glCompileShader(r3);
            int[] r6 = new int[1];
            GLES30.glGetShaderiv(r3, 35713, r6, 0);
            if (r6[0] != 0) goto L9;
            Log.e(GL3ShaderViewSnow.a(), "Could not compile shader " + r4 + ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Log.e(GL3ShaderViewSnow.a(), GLES30.glGetShaderInfoLog(r3));
            GLES30.glDeleteShader(r3);
            return 0;
        L9:
            return r3;
        L8:
            return r3;
        }

        private static int a(Context r4, Bitmap r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            if (r0[0] == 0) goto L6;
            GLES30.glBindTexture(3553, r0[0]);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r5, 0);
            GLES30.glBindTexture(3553, 0);
            r5.recycle();
        L6:
            return r0[0];
        }

        private int a(String r3, String r4) {
            int r5 = a(35633, r3);
            if (r5 != 0) goto L5;
            return 0;
        L5:
            int r6 = a(35632, r4);
            if (r6 != 0) goto L8;
            return 0;
        L8:
            int r1 = GLES30.glCreateProgram();
            if (r1 == 0) goto L14;
            GLES30.glAttachShader(r1, r5);
            a("glAttachShader");
            GLES30.glAttachShader(r1, r6);
            a("glAttachShader");
            GLES30.glLinkProgram(r1);
            int[] r7 = new int[1];
            GLES30.glGetProgramiv(r1, 35714, r7, 0);
            if (r7[0] == 1) goto L14;
            Log.e(GL3ShaderViewSnow.a(), "Could not link program: ");
            Log.e(GL3ShaderViewSnow.a(), GLES30.glGetProgramInfoLog(r1));
            GLES30.glDeleteProgram(r1);
            return 0;
        L14:
            return r1;
        }

        static /* synthetic */ d a(a r0) {
            return r0.z;
        }

        private void a() {
            if (this.H != 0) goto L5;
            int r0 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.H = r0;
            this.I = GLES30.glGetAttribLocation(r0, "vPosition");
            a("glGetAttribLocation");
            this.f7752J = GLES30.glGetUniformLocation(this.H, "u_background");
            a("glGetAttribLocation");
            this.K = GLES30.glGetUniformLocation(this.H, "u_resolution");
            a("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.H);
            if (this.L != 0) goto L8;
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            this.L = r1[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.L);
            if (this.M != 0) goto L11;
            int[] r2 = new int[1];
            GLES30.glGenTextures(1, r2, 0);
            this.M = r2[0];
        L11:
            GLES30.glBindTexture(3553, this.M);
            GLES30.glTexImage2D(3553, 0, 6408, this.v, this.x, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.M, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        private void a(String r4) {
            int r3 = GLES30.glGetError();
            if (r3 != 0) goto L5;
            return;
        L5:
            Log.e(GL3ShaderViewSnow.a(), r4 + ": glError " + r3);
            throw new RuntimeException(r4 + ": glError " + r3);
        }

        static /* synthetic */ d b(a r0) {
            return r0.A;
        }

        private void b() {
            GLES30.glBindFramebuffer(36160, this.L);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.H);
            GLES30.glUniform2f(this.K, this.v, this.x);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.n);
            GLES30.glUniform1i(this.f7752J, 0);
            GLES30.glEnableVertexAttribArray(this.I);
            GLES30.glVertexAttribPointer(this.I, 2, 5126, false, 0, this.E);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.M);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        static /* synthetic */ d c(a r0) {
            return r0.B;
        }

        public void a(Bitmap r1) {
            this.F = r1;
        }

        public void b(Bitmap r1) {
            this.G = r1;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r5) {
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r5, GL10.class, "com.obric.memorydata.plugin");
            if (this.v == this.w) goto L5;
        L6:
            a();
            b();
        L7:
            long r0 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.d);
            GLES30.glUniform1f(this.j, (r0 % TimeUtils.NANOSECONDS_PER_MILLISECOND) / 1000.0f);
            int r7 = this.v;
            if (r7 == this.w) goto L10;
        L11:
            this.w = r7;
            int r1 = this.x;
            this.y = r1;
            GLES30.glUniform2f(this.i, r7, r1);
        L13:
            if (this.z.a() == this.r) goto L16;
            float r8 = this.z.a();
            this.r = r8;
            GLES30.glUniform1f(this.k, r8);
        L16:
            if (this.A.a() == this.s) goto L19;
            float r9 = this.A.a();
            this.s = r9;
            GLES30.glUniform1f(this.l, r9);
        L19:
            if (this.B.a() == this.t) goto L21;
            float r10 = this.B.a();
            this.t = r10;
            GLES30.glUniform1f(this.m, r10);
        L21:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.n);
            GLES30.glUniform1i(this.f, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.M);
            GLES30.glUniform1i(this.g, 1);
            GLES30.glActiveTexture(33986);
            GLES30.glBindTexture(3553, this.o);
            GLES30.glUniform1i(this.h, 2);
            GLES30.glBindVertexArray(this.p);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.x == this.y) goto L13;
        L5:
            if (this.x == this.y) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r3, int r4, int r5) {
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.memorydata.plugin");
            this.v = r4;
            this.x = r5;
            GLES30.glViewport(0, 0, r4, r5);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r8, EGLConfig r9) {
            GL10 r10 = (GL10) ZeusTransformUtils.wrapperContextForParams(r8, GL10.class, "com.obric.memorydata.plugin");
            int r11 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.d = r11;
            if (r11 != 0) goto L5;
            return;
        L5:
            this.e = GLES30.glGetAttribLocation(r11, "vPosition");
            a("glGetAttribLocation");
            this.f = GLES30.glGetUniformLocation(this.d, "u_background");
            a("glGetAttribLocation");
            this.g = GLES30.glGetUniformLocation(this.d, "u_prepass");
            a("glGetAttribLocation");
            this.h = GLES30.glGetUniformLocation(this.d, "u_frostTex");
            a("glGetAttribLocation");
            this.i = GLES30.glGetUniformLocation(this.d, "u_resolution");
            a("glGetUniformLocation");
            this.j = GLES30.glGetUniformLocation(this.d, "u_time");
            a("glGetUniformLocation");
            this.k = GLES30.glGetUniformLocation(this.d, "u_alpha");
            a("glGetUniformLocation");
            this.l = GLES30.glGetUniformLocation(this.d, "u_intensity");
            a("glGetUniformLocation");
            this.m = GLES30.glGetUniformLocation(this.d, "u_speed");
            a("glGetUniformLocation");
            GLES30.glUseProgram(this.d);
            this.n = a(this.C, this.F);
            this.o = a(this.C, this.G);
            int[] r12 = new int[1];
            GLES30.glGenVertexArrays(1, r12, 0);
            int r13 = r12[0];
            this.p = r13;
            GLES30.glBindVertexArray(r13);
            int[] r14 = new int[1];
            GLES30.glGenBuffers(1, r14, 0);
            int r15 = r14[0];
            this.q = r15;
            GLES30.glBindBuffer(34962, r15);
            GLES30.glBufferData(34962, this.D.length * 4, this.E, 35044);
            GLES30.glEnableVertexAttribArray(this.e);
            GLES30.glVertexAttribPointer(this.e, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }
    }

    static {
    }

    public GL3ShaderViewSnow(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public GL3ShaderViewSnow(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        b();
    }

    static /* synthetic */ String a() {
        return f7750a;
    }

    private void b() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r0 = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f7751b = r0;
        setRenderer(r0);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r1) {
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

    public void setBackgroundImage(Bitmap r1) {
        this.f7751b.a(r1);
    }

    public void setFrostImage(Bitmap r1) {
        this.f7751b.b(r1);
    }

    public void setShaderAlpha(float r1) {
        a.a(this.f7751b).a(r1);
    }

    public void setShaderIntensity(float r1) {
        a.b(this.f7751b).a(r1);
    }

    public void setShaderSpeed(float r1) {
        a.c(this.f7751b).a(r1);
    }
}
