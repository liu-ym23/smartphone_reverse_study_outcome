package com.bytedance.bmmt.video;

import android.opengl.GLES20;
import com.bytedance.bmmt.base.Logging;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GlGenericDrawer implements RendererCommon.GlDrawer {
    private static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
    private static final FloatBuffer FULL_RECTANGLE_BUFFER = null;
    private static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER = null;
    private static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
    private static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
    private static final String ORI_TEX_SIZE_NAME = "ori_tex_size";
    private static final String TAR_TEX_SIZE_NAME = "tar_tex_size";
    private static final String TEXTURE_MATRIX_NAME = "tex_mat";
    private FilterType currentScaleFilter;
    private GlShader currentShader;
    private ShaderType currentShaderType;
    private int dstHeight;
    private int dstWidth;
    private int frameHeight;
    private int frameWidth;
    private final String genericFragmentSource;
    private int inPosLocation;
    private int inTcLocation;
    private FloatBuffer mPosCoordinate;
    private int oriTexSizeLocation;
    private final ShaderCallbacks shaderCallbacks;
    private int tarTexSizeLocation;
    private int texMatrixLocation;
    private final String vertexShader;

    public interface ShaderCallbacks {
        void onNewShader(GlShader r1);

        void onPrepareShader(GlShader r1, float[] r2, int r3, int r4, int r5, int r6);
    }

    public static final enum ShaderType extends Enum<ShaderType> {
        private static final /* synthetic */ ShaderType[] $VALUES = null;
        public static final ShaderType OES = null;
        public static final ShaderType RGB = null;
        public static final ShaderType YUV = null;

        private static /* synthetic */ ShaderType[] $values() {
            return new ShaderType[]{OES, RGB, YUV};
        }

        static {
            OES = new ShaderType("OES", 0);
            RGB = new ShaderType("RGB", 1);
            YUV = new ShaderType("YUV", 2);
            $VALUES = $values();
        }

        public static ShaderType[] values() {
            return (ShaderType[]) $VALUES.clone();
        }

        public static ShaderType valueOf(String r1) {
            return (ShaderType) r27.a.a(ShaderType.class, r1);
        }

        private ShaderType(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void release() {
        GlShader r0 = this.currentShader;
        if (r0 == null) goto L6;
        r0.release();
        this.currentShader = null;
        this.currentShaderType = null;
        return;
    }

    public GlGenericDrawer(String r2, ShaderCallbacks r3) {
        this(DEFAULT_VERTEX_SHADER_STRING, r2, r3);
    }

    public GlShader createShader(ShaderType r4, FilterType r5) {
        return new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, r4, r5));
    }

    public GlGenericDrawer(String r2, String r3, ShaderCallbacks r4) {
        this.mPosCoordinate = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.vertexShader = r2;
        this.genericFragmentSource = r3;
        this.shaderCallbacks = r4;
    }

    public static String createFragmentShaderString(String r3, ShaderType r4, FilterType r5) {
        StringBuilder r0 = new StringBuilder();
        ShaderType r1 = ShaderType.OES;
        if (r4 != r1) goto L5;
        r0.append("#extension GL_OES_EGL_image_external : require\n");
    L5:
        r0.append("precision mediump float;\nvarying vec2 tc;\n");
        if (r5 == FilterType.Origin) goto L9;
        r0.append("uniform vec2 tar_tex_size;\nuniform vec2 ori_tex_size;\n");
    L9:
        if (r4 != ShaderType.YUV) goto L21;
        r0.append("uniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n");
        if (r5 != FilterType.Bilinear) goto L14;
        r0.append("float bilinearTextureSample(sampler2D tex, vec2 p) {\n        vec2 c_onePixel =  vec2(1.0 / ori_tex_size.y - tar_tex_size.x + tar_tex_size.x, 1.0 / ori_tex_size.y);\n    vec2 frac = vec2(0.5, 0.5);\n    float C11 = texture2D(tex, p - c_onePixel).r;\n    float C21 = texture2D(tex, p + vec2( c_onePixel.x , -c_onePixel.y)).r;\n    float C12 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).r;\n    float C22 = texture2D(tex, p + c_onePixel).r;\n    float x1 = mix(C11, C21, frac.x);\n    float x2 = mix(C12, C22, frac.x);\n    return mix(x1, x2, frac.y);\n}\nvec4 sample(vec2 p) {\n  float y = bilinearTextureSample(y_tex, p) * 1.16438;\n  float u = bilinearTextureSample(u_tex, p);\n  float v = bilinearTextureSample(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
    L20:
        r0.append(r3);
    L35:
        return r0.toString();
    L14:
        if (r5 != FilterType.Bicubic) goto L17;
        r0.append("vec3 cubic_hermite (vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n    float t2 = t*t;\n    float t3 = t*t*t;\n    vec3 a = -A/2.0 + (3.0*B)/2.0 - (3.0*C)/2.0 + D/2.0;\n    vec3 b = A - (5.0*B)/2.0 + 2.0*C - D / 2.0;\n    vec3 c = -A/2.0 + C/2.0;\n   \tvec3 d = B;\n    return a*t3 + b*t2 + c*t + d;\n}\nvec4 bicubic_sample (sampler2D tex, vec2 P) {\n    float c_onePixel_x = 1.0 / ori_tex_size.x - tar_tex_size.x + tar_tex_size.x;\n    float c_onePixel_y = 1.0 / ori_tex_size.y;\n    float c_twoPixels_x = 2.0 / ori_tex_size.x;\n    float c_twoPixels_y = 2.0 / ori_tex_size.y;\n    vec2 pixel = vec2(P.x * ori_tex_size.x, P.y * ori_tex_size.y) + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel);\n    pixel = vec2(pixel.x / ori_tex_size.x, pixel.y / ori_tex_size.y) - vec2(c_onePixel_x, c_onePixel_y) / 2.0;\n    vec3 C00 = texture2D(tex, pixel + vec2(-c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C10 = texture2D(tex, pixel + vec2( 0.0        ,-c_onePixel_y)).rgb;\n    vec3 C20 = texture2D(tex, pixel + vec2( c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C30 = texture2D(tex, pixel + vec2( c_twoPixels_x,-c_onePixel_y)).rgb;\n    vec3 C01 = texture2D(tex, pixel + vec2(-c_onePixel_x , 0.0)).rgb;\n    vec3 C11 = texture2D(tex, pixel + vec2( 0.0        , 0.0)).rgb;\n    vec3 C21 = texture2D(tex, pixel + vec2( c_onePixel_x , 0.0)).rgb;\n    vec3 C31 = texture2D(tex, pixel + vec2( c_twoPixels_x, 0.0)).rgb;\n    vec3 C02 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C12 = texture2D(tex, pixel + vec2( 0.0        , c_onePixel_y)).rgb;\n    vec3 C22 = texture2D(tex, pixel + vec2( c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C32 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_onePixel_y)).rgb;\n    vec3 C03 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C13 = texture2D(tex, pixel + vec2( 0.0        , c_twoPixels_y)).rgb;\n    vec3 C23 = texture2D(tex, pixel + vec2( c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C33 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_twoPixels_y)).rgb;  \n    vec3 CP0X = cubic_hermite(C00, C10, C20, C30, frac.x);\n    vec3 CP1X = cubic_hermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubic_hermite(C02, C12, C22, C32, frac.x);\n    vec3 CP3X = cubic_hermite(C03, C13, C23, C33, frac.x);\n    return vec4(cubic_hermite(CP0X, CP1X, CP2X, CP3X, frac.y), 1.0);}\nvec4 sample(vec2 p) {\n  float y = bicubic_sample(y_tex, p) * 1.16438;\n  float u = bicubic_sample(u_tex, p);\n  float v = bicubic_sample(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
        goto L20
    L17:
        if (r5 != FilterType.BOX) goto L19;
        r0.append("float box_filter(sampler2D tex, vec2 p) {\n  vec2 c_onePixel =  1.0 / ori_tex_size;\n  float C11, C12, C13, C21, C22, C23, C31, C32, C33;\n  C11 = texture2D(tex, p - c_onePixel).r;\n  C12 = texture2D(tex, p + vec2( 0, -c_onePixel.y)).r;\n  C13 = texture2D(tex, p + vec2( c_onePixel.x, -c_onePixel.y)).r;\n  C21 = texture2D(tex, p + vec2( -c_onePixel.x , 0)).r;\n  C22 = texture2D(tex, p).r;\n  C23 = texture2D(tex, p + vec2( c_onePixel.x , 0)).r;\n  C31 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).r;\n  C32 = texture2D(tex, p + vec2( 0 , c_onePixel.y)).r;\n  C33 = texture2D(tex, p + c_onePixel).r;\n  return (C11 + C12 + C13 + C21 + C22 + C23 + C31 + C32 + C33) / 9.0;\n}\nvec4 sample(vec2 p) {\n  float y = box_filter(y_tex, p) * 1.16438;\n  float u = box_filter(u_tex, p);\n  float v = box_filter(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
        goto L20
    L19:
        r0.append("vec4 sample(vec2 p) {\n  float y = texture2D(y_tex, p).r * 1.16438;\n  float u = texture2D(u_tex, p).r;\n  float v = texture2D(v_tex, p).r;\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
        goto L20
    L21:
        if (r4 != r1) goto L23;
        String r6 = "samplerExternalOES";
    L24:
        r0.append("uniform ");
        r0.append(r6);
        r0.append(" tex;\n");
        if (r5 != FilterType.Bilinear) goto L28;
        r0.append("vec4 sample(vec2 p) {\n    vec2 c_onePixel =  vec2(1.0 / ori_tex_size.y - tar_tex_size.x + tar_tex_size.x, 1.0 / ori_tex_size.y);\n    vec2 frac = vec2(0.5, 0.5);\n    vec3 C11 = texture2D(tex, p - c_onePixel).rgb;\n    vec3 C21 = texture2D(tex, p + vec2( c_onePixel.x , -c_onePixel.y)).rgb;\n    vec3 C12 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).rgb;\n    vec3 C22 = texture2D(tex, p + c_onePixel).rgb;\n    vec3 x1 = mix(C11, C21, frac.x);\n    vec3 x2 = mix(C12, C22, frac.x);\n    return vec4(mix(x1, x2, frac.y), 1);\n}\n");
        r0.append(r3);
        goto L35
    L28:
        if (r5 != FilterType.Bicubic) goto L31;
        r0.append("vec3 cubic_hermite (vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n\t  float t2 = t*t;\n    float t3 = t*t*t;\n    vec3 a = -A/2.0 + (3.0*B)/2.0 - (3.0*C)/2.0 + D/2.0;\n    vec3 b = A - (5.0*B)/2.0 + 2.0*C - D / 2.0;\n    vec3 c = -A/2.0 + C/2.0;\n   \tvec3 d = B;\n    return a*t3 + b*t2 + c*t + d;\n}\nvec4 sample (vec2 P) {\n    float c_onePixel_x = 1.0 / ori_tex_size.x - tar_tex_size.x + tar_tex_size.x;\n    float c_onePixel_y = 1.0 / ori_tex_size.y;\n    float c_twoPixels_x = 2.0 / ori_tex_size.x;\n    float c_twoPixels_y = 2.0 / ori_tex_size.y;\n    vec2 pixel = vec2(P.x * ori_tex_size.x, P.y * ori_tex_size.y) + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel);\n    pixel = vec2(pixel.x / ori_tex_size.x, pixel.y / ori_tex_size.y) - vec2(c_onePixel_x, c_onePixel_y) / 2.0;\n    vec3 C00 = texture2D(tex, pixel + vec2(-c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C10 = texture2D(tex, pixel + vec2( 0.0        ,-c_onePixel_y)).rgb;\n    vec3 C20 = texture2D(tex, pixel + vec2( c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C30 = texture2D(tex, pixel + vec2( c_twoPixels_x,-c_onePixel_y)).rgb;\n    vec3 C01 = texture2D(tex, pixel + vec2(-c_onePixel_x , 0.0)).rgb;\n    vec3 C11 = texture2D(tex, pixel + vec2( 0.0        , 0.0)).rgb;\n    vec3 C21 = texture2D(tex, pixel + vec2( c_onePixel_x , 0.0)).rgb;\n    vec3 C31 = texture2D(tex, pixel + vec2( c_twoPixels_x, 0.0)).rgb;\n    vec3 C02 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C12 = texture2D(tex, pixel + vec2( 0.0        , c_onePixel_y)).rgb;\n    vec3 C22 = texture2D(tex, pixel + vec2( c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C32 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_onePixel_y)).rgb;\n    vec3 C03 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C13 = texture2D(tex, pixel + vec2( 0.0        , c_twoPixels_y)).rgb;\n    vec3 C23 = texture2D(tex, pixel + vec2( c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C33 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_twoPixels_y)).rgb;  \n    vec3 CP0X = cubic_hermite(C00, C10, C20, C30, frac.x);\n    vec3 CP1X = cubic_hermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubic_hermite(C02, C12, C22, C32, frac.x);\n    vec3 CP3X = cubic_hermite(C03, C13, C23, C33, frac.x);\n    return vec4(cubic_hermite(CP0X, CP1X, CP2X, CP3X, frac.y), 1.0);}\n");
        r0.append(r3);
        goto L35
    L31:
        if (r5 != FilterType.BOX) goto L33;
        r0.append("vec4 sample(vec2 p) {\n  vec2 c_onePixel =  1.0 / ori_tex_size;\n  vec3 C11 = texture2D(tex, p - c_onePixel).rgb;\n  vec3 C12 = texture2D(tex, p + vec2( 0, -c_onePixel.y)).rgb;\n  vec3 C13 = texture2D(tex, p + vec2( c_onePixel.x, -c_onePixel.y)).rgb;\n  vec3 C21 = texture2D(tex, p + vec2( -c_onePixel.x , 0)).rgb;\n  vec3 C22 = texture2D(tex, p).rgb;\n  vec3 C23 = texture2D(tex, p + vec2( c_onePixel.x , 0)).rgb;\n  vec3 C31 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).rgb;\n  vec3 C32 = texture2D(tex, p + vec2( 0 , c_onePixel.y)).rgb;\n  vec3 C33 = texture2D(tex, p + c_onePixel).rgb;\n  return vec4((C11 + C12 + C13 + C21 + C22 + C23 + C31 + C32 + C33) / 9.0, 1.0);\n}\n");
        r0.append(r3);
        goto L35
    L33:
        r0.append(r3.replace("sample(", "texture2D(tex, "));
        goto L35
    L23:
        r6 = "sampler2D";
        goto L24
    }

    private void prepareTexAndPosCoord(int r3, int r4, int r5, int r6) {
        if (r5 == 0) goto L18;
        if (r6 == 0) goto L19;
        if (r3 > r5) goto L20;
        if (r4 <= r6) goto L8;
        return;
    L8:
        if (this.frameWidth == r3) goto L10;
    L16:
        this.frameWidth = r3;
        this.frameHeight = r4;
        this.dstWidth = r5;
        this.dstHeight = r6;
        float r7 = (((r6 - r4) * 2.0f) / r6) - 1.0f;
        float r8 = ((r3 * 2.0f) / r5) - 1.0f;
        this.mPosCoordinate = GlUtil.createFloatBuffer(new float[]{-1.0f, r7, r8, r7, -1.0f, 1.0f, r8, 1.0f});
        return;
    L10:
        if (this.frameHeight != r4) goto L16;
        if (this.dstWidth != r5) goto L16;
        if (this.dstHeight != r6) goto L16;
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawOes(int r13, float[] r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        drawOes(r13, r14, r15, r16, r17, r18, r19, r20, FilterType.Origin, 0, 0);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawRgb(int r13, float[] r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        drawRgb(r13, r14, r15, r16, r17, r18, r19, r20, FilterType.Origin, 0, 0);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawYuv(int[] r13, float[] r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        drawYuv(r13, r14, r15, r16, r17, r18, r19, r20, FilterType.Origin, 0, 0);
    }

    private void prepareShader(ShaderType r17, float[] r18, int r19, int r20, int r21, int r22, FilterType r23, int r24, int r25) {
        if (r23 == null) goto L8;
        if (r24 == 0) goto L8;
        if (r25 == 0) goto L8;
        FilterType r3 = r23;
        int r4 = r24;
        int r5 = r25;
    L10:
        if (r17.equals(this.currentShaderType) == true) goto L12;
    L14:
        this.currentShaderType = r17;
        GlShader r6 = this.currentShader;
        if (r6 == null) goto L17;
        r6.release();
    L17:
        GlShader r7 = createShader(r17, r3);
        this.currentShader = r7;
        this.currentScaleFilter = r3;
        r7.useProgram();
        if (r17 != ShaderType.YUV) goto L20;
        GLES20.glUniform1i(r7.getUniformLocation("y_tex"), 0);
        GLES20.glUniform1i(r7.getUniformLocation("u_tex"), 1);
        GLES20.glUniform1i(r7.getUniformLocation("v_tex"), 2);
    L21:
        GlUtil.checkNoGLES2Error("Create shader");
        this.shaderCallbacks.onNewShader(r7);
        this.texMatrixLocation = r7.getUniformLocation(TEXTURE_MATRIX_NAME);
        this.inPosLocation = r7.getAttribLocation(INPUT_VERTEX_COORDINATE_NAME);
        this.inTcLocation = r7.getAttribLocation(INPUT_TEXTURE_COORDINATE_NAME);
        GlShader r9 = r7;
    L22:
        FilterType r1 = FilterType.Origin;
        if (r3 != r1) goto L25;
    L28:
        GlUtil.checkNoGLES2Error("before useProgram ");
        r9.useProgram();
        GLES20.glEnableVertexAttribArray(this.inPosLocation);
        GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, this.mPosCoordinate);
        GLES20.glEnableVertexAttribArray(this.inTcLocation);
        GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, FULL_RECTANGLE_TEXTURE_BUFFER);
        GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, r18, 0);
        if (r3 == r1) goto L40;
        if (r4 <= 0) goto L40;
        if (r4 <= 0) goto L40;
        int r2 = this.tarTexSizeLocation;
        if (r2 == 0) goto L36;
        GLES20.glUniform2f(r2, r19, r20);
    L36:
        int r8 = this.oriTexSizeLocation;
        if (r8 == 0) goto L40;
        GLES20.glUniform2f(r8, r4, r5);
    L40:
        this.shaderCallbacks.onPrepareShader(r9, r18, r19, r20, r21, r22);
        GlUtil.checkNoGLES2Error("Prepare shader");
        return;
    L25:
        if (r3 == FilterType.BOX) goto L27;
        this.tarTexSizeLocation = r9.getUniformLocation(TAR_TEX_SIZE_NAME);
    L27:
        this.oriTexSizeLocation = r9.getUniformLocation(ORI_TEX_SIZE_NAME);
        goto L28
    L20:
        GLES20.glUniform1i(r7.getUniformLocation("tex"), 0);
        goto L21
    L12:
        if (r3.equals(this.currentScaleFilter) == false) goto L14;
        r9 = this.currentShader;
    L8:
        r3 = FilterType.Origin;
        r4 = 0;
        r5 = 0;
        goto L10
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawOes(int r11, float[] r12, int r13, int r14, int r15, int r16, int r17, int r18, FilterType r19, int r20, int r21) {
        prepareShader(ShaderType.OES, r12, r13, r14, r17, r18, r19, r20, r21);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r11);
        int r1 = GLES20.glGetError();
        if (r1 == 0) goto L6;
        Logging.e("GlGenericDrawer", "drawOes glBindTexture error: " + r1);
        return;
    L6:
        GLES20.glViewport(r15, r16, r17, r18);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
        GlUtil.checkNoGLES2Error("drawOes done");
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawRgb(int r11, float[] r12, int r13, int r14, int r15, int r16, int r17, int r18, FilterType r19, int r20, int r21) {
        prepareShader(ShaderType.RGB, r12, r13, r14, r17, r18, r19, r20, r21);
        GlUtil.checkNoGLES2Error("after prepare shader");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r11);
        int r1 = GLES20.glGetError();
        if (r1 == 0) goto L6;
        Logging.e("GlGenericDrawer", "drawRgb glBindTexture error: " + r1);
        return;
    L6:
        GLES20.glViewport(r15, r16, r17, r18);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
        GlUtil.checkNoGLES2Error("drawRgb done");
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawYuv(int[] r11, float[] r12, int r13, int r14, int r15, int r16, int r17, int r18, FilterType r19, int r20, int r21) {
        prepareShader(ShaderType.YUV, r12, r13, r14, r17, r18, r19, r20, r21);
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L6;
        GLES20.glActiveTexture(33984 + r1);
        GLES20.glBindTexture(3553, r11[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        int r2 = GLES20.glGetError();
        if (r2 == 0) goto L10;
        Logging.e("GlGenericDrawer", "drawYuv glBindTexture error: " + r2);
        return;
    L10:
        GLES20.glViewport(r15, r16, r17, r18);
        GLES20.glDrawArrays(5, 0, 4);
        int r3 = 0;
    L11:
        if (r3 >= 3) goto L13;
        GLES20.glActiveTexture(r3 + 33984);
        GLES20.glBindTexture(3553, 0);
        r3 = r3 + 1;
        goto L11
    L13:
        GlUtil.checkNoGLES2Error("drawYuv done");
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawOes(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11, int r12, int r13) {
        prepareTexAndPosCoord(r3, r4, r12, r13);
        drawOes(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawRgb(int r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11, int r12, int r13) {
        prepareTexAndPosCoord(r3, r4, r12, r13);
        drawRgb(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.GlDrawer
    public void drawYuv(int[] r1, float[] r2, int r3, int r4, int r5, int r6, int r7, int r8, FilterType r9, int r10, int r11, int r12, int r13) {
        prepareTexAndPosCoord(r3, r4, r12, r13);
        drawYuv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }
}
