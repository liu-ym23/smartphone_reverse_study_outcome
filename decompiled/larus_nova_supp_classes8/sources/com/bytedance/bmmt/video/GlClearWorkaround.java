package com.bytedance.bmmt.video;

import android.opengl.GLES20;
import android.os.Build;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GlClearWorkaround {
    private static final String DEFAULT_FRAGMENT_SHADER_STRING = "#ifdef GL_ES\nprecision mediump float;\n#endif\nuniform vec4 u_clear_color;\nvoid main(void) {\n  gl_FragColor = u_clear_color;\n}\n";
    private static final String DEFAULT_VERTEX_SHADER_STRING = "#ifdef GL_ES\nprecision mediump float;\n#endif\nuniform float u_clear_depth;\nattribute vec4 a_position;\nvoid main(void) {\n  gl_Position = vec4(a_position.x, a_position.y, u_clear_depth, 1.0);\n}\n";
    private static final FloatBuffer FULL_RECTANGLE_BUFFER = null;
    private GlShader currentShader;
    private boolean mHasInit;

    public static final enum WORKAROUND_STATUS extends Enum<WORKAROUND_STATUS> {
        private static final /* synthetic */ WORKAROUND_STATUS[] $VALUES = null;
        public static final WORKAROUND_STATUS kStatusDisable = null;
        public static final WORKAROUND_STATUS kStatusEnable = null;
        public static final WORKAROUND_STATUS kStatusUnknown = null;

        private static /* synthetic */ WORKAROUND_STATUS[] $values() {
            return new WORKAROUND_STATUS[]{kStatusUnknown, kStatusEnable, kStatusDisable};
        }

        static {
            kStatusUnknown = new WORKAROUND_STATUS("kStatusUnknown", 0);
            kStatusEnable = new WORKAROUND_STATUS("kStatusEnable", 1);
            kStatusDisable = new WORKAROUND_STATUS("kStatusDisable", 2);
            $VALUES = $values();
        }

        public static WORKAROUND_STATUS[] values() {
            return (WORKAROUND_STATUS[]) $VALUES.clone();
        }

        public static WORKAROUND_STATUS valueOf(String r1) {
            return (WORKAROUND_STATUS) r27.a.a(WORKAROUND_STATUS.class, r1);
        }

        private WORKAROUND_STATUS(String r1, int r2) {
            super(r1, r2);
        }
    }

    public synchronized void init() {
        monitor-enter(this);
        this.mHasInit = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void release() {
        monitor-enter(this);
        this.mHasInit = false;     // Catch: Throwable -> L9
        GlShader r0 = this.currentShader;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.release();     // Catch: Throwable -> L9
        this.currentShader = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    }

    private GlShader createShader() {
        return new GlShader(DEFAULT_VERTEX_SHADER_STRING, DEFAULT_FRAGMENT_SHADER_STRING);
    }

    public static WORKAROUND_STATUS isNeedWorkaround() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 23) goto L7;
        return WORKAROUND_STATUS.kStatusEnable;
    L7:
        if (r0 >= 26) goto L9;
        String r1 = GLES20.glGetString(7936).toLowerCase();
        if (r1.contains("mali") == true) goto L18;
        if (r1.contains("arm") == true) goto L18;
        return WORKAROUND_STATUS.kStatusDisable;
    L18:
        return WORKAROUND_STATUS.kStatusEnable;
    L9:
        return WORKAROUND_STATUS.kStatusDisable;
    }

    public GlClearWorkaround() {
        this.mHasInit = false;
    }

    private void prepareShader() {
        GlShader r0 = createShader();
        this.currentShader = r0;
        r0.useProgram();
        GlUtil.checkNoGLES2Error("Create shader");
        int r2 = r0.getAttribLocation("a_position");
        GLES20.glEnableVertexAttribArray(r2);
        GLES20.glVertexAttribPointer(r2, 2, 5126, false, 0, FULL_RECTANGLE_BUFFER);
        GlUtil.checkNoGLES2Error("Prepare shader");
    }

    public synchronized void clear(int r3, int r4, int r5, float r6, float r7, float r8, float r9, float r10, int r11) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasInit == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.currentShader != null) goto L10;
        prepareShader();     // Catch: Throwable -> L24
    L10:
        this.currentShader.useProgram();     // Catch: Throwable -> L24
        GLES20.glUniform1f(this.currentShader.getUniformLocation("u_clear_depth"), r10);     // Catch: Throwable -> L24
        GLES20.glUniform4f(this.currentShader.getUniformLocation("u_clear_color"), r6, r7, r8, r9);     // Catch: Throwable -> L24
        if ((r5 & 16384) != 0) goto L13;
        GLES20.glColorMask(false, false, false, false);     // Catch: Throwable -> L24
    L13:
        GlUtil.checkNoGLES2Error("before depth test");     // Catch: Throwable -> L24
        if ((r5 & 256) == 0) goto L16;
        GLES20.glEnable(2929);     // Catch: Throwable -> L24
        GLES20.glDepthFunc(519);     // Catch: Throwable -> L24
    L17:
        GlUtil.checkNoGLES2Error("before stencil test");     // Catch: Throwable -> L24
        if ((r5 & 1024) == 0) goto L20;
        GLES20.glEnable(2960);     // Catch: Throwable -> L24
        GLES20.glStencilFunc(519, r11, 255);     // Catch: Throwable -> L24
        GLES20.glStencilOp(7680, 7680, 7681);     // Catch: Throwable -> L24
    L21:
        GlUtil.checkNoGLES2Error("before clear workaround");     // Catch: Throwable -> L24
        GLES20.glDisable(2884);     // Catch: Throwable -> L24
        GLES20.glDisable(3042);     // Catch: Throwable -> L24
        GLES20.glDisable(32823);     // Catch: Throwable -> L24
        GLES20.glViewport(0, 0, r3, r4);     // Catch: Throwable -> L24
        GLES20.glDrawArrays(5, 0, 4);     // Catch: Throwable -> L24
        GlUtil.checkNoGLES2Error("after clear workaround");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L20:
        GLES20.glDisable(2960);     // Catch: Throwable -> L24
        GLES20.glStencilOp(7680, 7680, 7680);     // Catch: Throwable -> L24
        GLES20.glStencilMask(0);     // Catch: Throwable -> L24
        goto L21
    L16:
        GLES20.glDisable(2929);     // Catch: Throwable -> L24
        GLES20.glDepthFunc(512);     // Catch: Throwable -> L24
        goto L17
    }
}
