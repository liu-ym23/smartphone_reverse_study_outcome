package com.byted.cast.sdk.gl.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.byted.cast.sdk.gl.drawer.TextureDrawer;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class GLUtils {
    public static final Object GL_RENDER_FENCE = null;
    private static int GL_VERSION = 2;
    public static final float[] IDENTITY_MATRIX = null;
    private static final String TAG = "GLUtils";
    public static final String TEXTURE_2D_FS = "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n";
    public static float[] TEXTURE_COORDINATE = null;
    public static float[] TEXTURE_COORDINATE_VERTICAL_FLIP = null;
    public static final String TEXTURE_EXTERNAL_FS = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n";
    public static final String TEXTURE_VS = "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n";
    public static float[] VERTEX_POSITION;

    public static final enum DISPLAY_MODE extends Enum<DISPLAY_MODE> {
        private static final /* synthetic */ DISPLAY_MODE[] $VALUES = null;
        public static final DISPLAY_MODE FIT = null;
        public static final DISPLAY_MODE FULL = null;

        static {
            DISPLAY_MODE r0 = new DISPLAY_MODE("FIT", 0);
            FIT = r0;
            DISPLAY_MODE r1 = new DISPLAY_MODE("FULL", 1);
            FULL = r1;
            $VALUES = new DISPLAY_MODE[]{r0, r1};
        }

        public static DISPLAY_MODE[] values() {
            return (DISPLAY_MODE[]) $VALUES.clone();
        }

        public static DISPLAY_MODE valueOf(String r1) {
            return (DISPLAY_MODE) a.a(DISPLAY_MODE.class, r1);
        }

        private DISPLAY_MODE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public GLUtils() {
    }

    public static int createFBO() {
        int[] r1 = new int[1];
        GLES20.glGenFramebuffers(1, r1, 0);
        return r1[0];
    }

    public static int createTexture() {
        return createTextures(1)[0];
    }

    public static int createVAO() {
        int[] r1 = new int[1];
        GLES30.glGenVertexArrays(1, r1, 0);
        return r1[0];
    }

    static {
        GL_RENDER_FENCE = new Object();
        VERTEX_POSITION = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        TEXTURE_COORDINATE = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        TEXTURE_COORDINATE_VERTICAL_FLIP = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        float[] r0 = new float[16];
        IDENTITY_MATRIX = r0;
        Matrix.setIdentityM(r0, 0);
    }

    public static boolean isGL3() {
        if (GL_VERSION <= 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static FloatBuffer createFloatBuffer(float[] r10) {
        FloatBuffer r0 = ByteBuffer.allocateDirect(r10.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r0.put(r10).position(0);
        return r0;
    }

    public static ShortBuffer createShortBuffer(short[] r10) {
        ShortBuffer r0 = ByteBuffer.allocateDirect(r10.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        r0.put(r10).position(0);
        return r0;
    }

    public static int[] createTextures(int r10) {
        int[] r0 = new int[r10];
        GLES20.glGenTextures(r10, r0, 0);
        return r0;
    }

    public static boolean isSupportEGL14(String r10) {
        Logger r11 = LoggerManager.getLogger(r10);
        EGL14.eglGetCurrentContext();     // Catch: NoClassDefFoundError -> L6
        return true;
    L6:
        r11.i(TAG, "EGL14 isn't supported on this platform, change to use EGL10.");
        return false;
    }

    public static boolean checkGlError(String r10, String r11) {
        Logger r12 = LoggerManager.getLogger(r11);
        int r0 = GLES20.glGetError();
        if (r0 == 0) goto L6;
        r12.e(TAG, r10 + ": glError 0x" + Integer.toHexString(r0));
        return false;
    L6:
        return true;
    }

    public static int loadTextureByBitmap(Bitmap r10, String r11) {
        Logger r12 = LoggerManager.getLogger(r11);
        if (r10 != null) goto L6;
        r12.e(TAG, "loadTextureByBitmap，load bitmap error, check the file path is correct!");
        return 0;
    L6:
        int[] r13 = new int[1];
        GLES20.glGenTextures(1, r13, 0);
        int r14 = r13[0];
        if (r14 == 0) goto L10;
        GLES20.glBindTexture(3553, r14);
        GLES20.glTexParameteri(3553, CalDavException.MAX_EXCERPT_SIZE, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        android.opengl.GLUtils.texImage2D(3553, 0, r10, 0);
    L10:
        if (r13[0] != 0) goto L13;
        r12.e(TAG, "loadTextureByBitmap, the texture id is 0!");
    L13:
        return r13[0];
    }

    private static boolean validateProgram(int r10, String r11) {
        Logger r12 = LoggerManager.getLogger(r11);
        GLES20.glValidateProgram(r10);
        int[] r1 = new int[1];
        GLES20.glGetProgramiv(r10, 35715, r1, 0);
        r12.d(TAG, "Results of validating program: " + r1[0] + "\nLog:" + GLES20.glGetProgramInfoLog(r10));
        if (r1[0] != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static int compileShader(int r10, String r11, String r12) {
        Logger r13 = LoggerManager.getLogger(r12);
        int r14 = GLES20.glCreateShader(r10);
        GLES20.glShaderSource(r14, r11);
        GLES20.glCompileShader(r14);
        int[] r15 = new int[1];
        GLES20.glGetShaderiv(r14, 35713, r15, 0);
        if (r15[0] != 0) goto L6;
        GLES20.glDeleteShader(r14);
        r13.e(TAG, "Compilation of shader failed.");
        return 0;
    L6:
        return r14;
    }

    public static TextureDrawer createAndSetupTexDrawer(int r1, int r10, String r11) {
        TextureDrawer r0 = new TextureDrawer(r11);
        r0.setViewportSize(r1, r10);
        r0.setup();
        return r0;
    }

    public static int createProgram(String r10, String r11, String r12) {
        Logger r0 = LoggerManager.getLogger(r12);
        int r13 = compileShader(35633, r10, r12);
        int r14 = compileShader(35632, r11, r12);
        if (r13 == 0) goto L14;
        if (r14 == 0) goto L14;
        int r15 = GLES20.glCreateProgram();
        GLES20.glAttachShader(r15, r13);
        GLES20.glAttachShader(r15, r14);
        GLES20.glLinkProgram(r15);
        int[] r16 = new int[1];
        GLES20.glGetProgramiv(r15, 35714, r16, 0);
        if (r16[0] != 0) goto L11;
        GLES20.glDeleteProgram(r15);
        r0.d(TAG, "Linking of program failed !");
        return -1;
    L11:
        if (validateProgram(r15, r12) == true) goto L13;
        return -1;
    L13:
        return r15;
    L14:
        return -1;
    }

    private static Bitmap getResizedBitmap(Bitmap r10, int r11, int r12) {
        int r13 = r10.getWidth();
        int r14 = r10.getHeight();
        android.graphics.Matrix r15 = new android.graphics.Matrix();
        r15.postScale(r11 / r13, r12 / r14);
        Bitmap r16 = Bitmap.createBitmap(r10, 0, 0, r13, r14, r15, false);
        r10.recycle();
        return r16;
    }

    public static int createImageTexture(ByteBuffer r11, int r12, int r13, int r14, String r15) {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        int r0 = r1[0];
        checkGlError("glGenTextures", r15);
        GLES20.glBindTexture(3553, r0);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, CalDavException.MAX_EXCERPT_SIZE, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        checkGlError("loadImageTexture", r15);
        GLES20.glTexImage2D(3553, 0, r14, r12, r13, 0, r14, 5121, r11);
        checkGlError("loadImageTexture", r15);
        return r0;
    }

    public static Bitmap loadSuitableBitmap(Context r10, Uri r11, int r12, int r13, String r14) {
        Logger r15 = LoggerManager.getLogger(r14);
        if (r10 == null) goto L47;
        if (r11 == null) goto L47;
        InputStream r16 = ContentResolverWrapper.openInputStream(r10.getContentResolver(), r11);     // Catch: FileNotFoundException -> L44
        if (r12 <= 0) goto L38;
        if (r13 <= 0) goto L38;
        BitmapFactory.Options r17 = new BitmapFactory.Options();
        int r18 = 1;
        r17.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r16, null, r17);
        r16.close();     // Catch: IOException -> L13
    L15:
        r17.inJustDecodeBounds = false;
        int r19 = r17.outWidth;
        int r20 = r17.outHeight;
        r15.i(TAG, "loadSuitableBitmap, bitmap size = " + r19 + "x" + r20);
        int r21 = r19 / r12;
        int r22 = r20 / r13;
        if (r21 < r22) goto L19;
        r21 = r22;
    L19:
        if (r21 <= 0) goto L22;
        r18 = r21;
    L22:
        r17.inSampleSize = r18;
        r15.i(TAG, "loadSuitableBitmap, inSampleSize = " + r18);
        InputStream r23 = ContentResolverWrapper.openInputStream(r10.getContentResolver(), r11);     // Catch: FileNotFoundException -> L35
        Bitmap r24 = BitmapFactory.decodeStream(r23, null, r17);
        r23.close();     // Catch: IOException -> L27
    L30:
        if (r24.getWidth() != r12) goto L34;
        if (r24.getHeight() != r13) goto L34;
        return r24;
    L34:
        return getResizedBitmap(r24, r12, r13);
    L27:
        e = move-exception;
        e.printStackTrace();
    L35:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
    L38:
        Bitmap r25 = BitmapFactory.decodeStream(r16);
        r16.close();     // Catch: IOException -> L41
    L43:
        return r25;
    L41:
        e = move-exception;
        e.printStackTrace();
    L44:
        e = move-exception;
        e.printStackTrace();
        r15.e(TAG, "loadSuitableBitmap error : parsing uri error!");
        return null;
    L47:
        r15.e(TAG, "loadSuitableBitmap error : context and uri can'tt be null!");
        return null;
    }
}
