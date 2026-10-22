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
public class GL3ShaderViewFog extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7731a = "GL2ShaderView";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f7732b;

    private static class a implements GLSurfaceView.Renderer {
        private d A;
        private int B;
        private Context C;
        private final float[] D;
        private FloatBuffer E;
        private Bitmap F;
        private int G;
        private int H;
        private int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private int f7733J;
        private int K;
        private int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7735b;
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
        private float q;
        private float r;
        private float s;
        private int t;
        private int u;
        private int v;
        private int w;
        private int x;
        private d y;
        private d z;

        public a(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            this.f7734a = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.f7735b = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.c = "#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.q = -1.0f;
            this.r = -1.0f;
            this.s = -1.0f;
            this.t = 0;
            this.u = 0;
            this.v = 0;
            this.w = 0;
            this.x = 0;
            this.y = new d(1.0f);
            this.z = new d(0.8f);
            this.A = new d(0.5f);
            this.B = -3618616;
            float[] r2 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.D = r2;
            this.G = 0;
            this.K = 0;
            this.L = 0;
            this.C = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            FloatBuffer r7 = ByteBuffer.allocateDirect(r2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r2);
            this.E = r7;
            r7.position(0);
        }

        private int a(int r4, String r5) {
            int r3 = GLES30.glCreateShader(r4);
            if (r3 == 0) goto L8;
            GLES30.glShaderSource(r3, r5);
            GLES30.glCompileShader(r3);
            int[] r6 = new int[1];
            GLES30.glGetShaderiv(r3, 35713, r6, 0);
            if (r6[0] != 0) goto L9;
            Log.e(GL3ShaderViewFog.a(), "Could not compile shader " + r4 + ParameterizedMessage.ERROR_MSG_SEPARATOR);
            Log.e(GL3ShaderViewFog.a(), GLES30.glGetShaderInfoLog(r3));
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

        static /* synthetic */ int a(a r0, int r1) {
            r0.B = r1;
            return r1;
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
            Log.e(GL3ShaderViewFog.a(), "Could not link program: ");
            Log.e(GL3ShaderViewFog.a(), GLES30.glGetProgramInfoLog(r1));
            GLES30.glDeleteProgram(r1);
            return 0;
        L14:
            return r1;
        }

        static /* synthetic */ d a(a r0) {
            return r0.y;
        }

        private void a() {
            if (this.G != 0) goto L5;
            int r0 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.G = r0;
            this.H = GLES30.glGetAttribLocation(r0, "vPosition");
            a("glGetAttribLocation");
            this.I = GLES30.glGetUniformLocation(this.G, "u_background");
            a("glGetAttribLocation");
            this.f7733J = GLES30.glGetUniformLocation(this.G, "u_resolution");
            a("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.G);
            if (this.K != 0) goto L8;
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            this.K = r1[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.K);
            if (this.L != 0) goto L11;
            int[] r2 = new int[1];
            GLES30.glGenTextures(1, r2, 0);
            this.L = r2[0];
        L11:
            GLES30.glBindTexture(3553, this.L);
            GLES30.glTexImage2D(3553, 0, 6408, this.u, this.w, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.L, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        private void a(String r4) {
            int r3 = GLES30.glGetError();
            if (r3 != 0) goto L5;
            return;
        L5:
            Log.e(GL3ShaderViewFog.a(), r4 + ": glError " + r3);
            throw new RuntimeException(r4 + ": glError " + r3);
        }

        static /* synthetic */ d b(a r0) {
            return r0.z;
        }

        private void b() {
            GLES30.glBindFramebuffer(36160, this.K);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.G);
            GLES30.glUniform2f(this.f7733J, this.u, this.w);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.n);
            GLES30.glUniform1i(this.I, 0);
            GLES30.glEnableVertexAttribArray(this.H);
            GLES30.glVertexAttribPointer(this.H, 2, 5126, false, 0, this.E);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.L);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        static /* synthetic */ d c(a r0) {
            return r0.A;
        }

        public void a(Bitmap r1) {
            this.F = r1;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r5) {
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r5, GL10.class, "com.obric.memorydata.plugin");
            if (this.u == this.v) goto L5;
        L6:
            a();
            b();
        L7:
            long r0 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.d);
            GLES30.glUniform1f(this.j, (r0 % TimeUtils.NANOSECONDS_PER_MILLISECOND) / 1000.0f);
            int r7 = this.u;
            if (r7 == this.v) goto L10;
        L11:
            this.v = r7;
            int r1 = this.w;
            this.x = r1;
            GLES30.glUniform2f(this.h, r7, r1);
        L13:
            if (this.y.a() == this.q) goto L16;
            float r8 = this.y.a();
            this.q = r8;
            GLES30.glUniform1f(this.k, r8);
        L16:
            if (this.z.a() == this.r) goto L19;
            float r9 = this.z.a();
            this.r = r9;
            GLES30.glUniform1f(this.l, r9);
        L19:
            if (this.A.a() == this.s) goto L21;
            float r10 = this.A.a();
            this.s = r10;
            GLES30.glUniform1f(this.m, r10);
        L21:
            int r11 = this.B;
            if (r11 == this.t) goto L24;
            this.t = r11;
            GLES30.glUniform3f(this.i, Color.red(r11) / 255.0f, Color.green(this.t) / 255.0f, Color.blue(this.t) / 255.0f);
        L24:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.n);
            GLES30.glUniform1i(this.f, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.L);
            GLES30.glUniform1i(this.g, 1);
            GLES30.glBindVertexArray(this.o);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.w == this.x) goto L13;
        L5:
            if (this.w == this.x) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r3, int r4, int r5) {
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.memorydata.plugin");
            this.u = r4;
            this.w = r5;
            GLES30.glViewport(0, 0, r4, r5);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r8, EGLConfig r9) {
            GL10 r10 = (GL10) ZeusTransformUtils.wrapperContextForParams(r8, GL10.class, "com.obric.memorydata.plugin");
            int r11 = a("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
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
            this.h = GLES30.glGetUniformLocation(this.d, "u_resolution");
            a("glGetUniformLocation");
            this.i = GLES30.glGetUniformLocation(this.d, "u_color");
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
            int[] r12 = new int[1];
            GLES30.glGenVertexArrays(1, r12, 0);
            int r13 = r12[0];
            this.o = r13;
            GLES30.glBindVertexArray(r13);
            int[] r14 = new int[1];
            GLES30.glGenBuffers(1, r14, 0);
            int r15 = r14[0];
            this.p = r15;
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

    public GL3ShaderViewFog(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public GL3ShaderViewFog(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        b();
    }

    static /* synthetic */ String a() {
        return f7731a;
    }

    private void b() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r0 = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f7732b = r0;
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
        this.f7732b.a(r1);
    }

    public void setShaderAlpha(float r1) {
        a.a(this.f7732b).a(r1);
    }

    public void setShaderColor(int r1) {
        a.a(this.f7732b, r1);
    }

    public void setShaderIntensity(float r1) {
        a.b(this.f7732b).a(r1);
    }

    public void setShaderSpeed(float r1) {
        a.c(this.f7732b).a(r1);
    }
}
