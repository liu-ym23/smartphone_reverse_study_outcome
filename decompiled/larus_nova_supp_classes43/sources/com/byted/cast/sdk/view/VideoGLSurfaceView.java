package com.byted.cast.sdk.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class VideoGLSurfaceView extends GLSurfaceView implements IRenderView {
    private static final String TAG = "VideoGLSurfaceView";
    private MeasureHelper mMeasureHelper;
    private VideoRenderer mRenderer;
    private IRenderView.IRenderCallback mSurfaceCallback;

    public static final class VideoRenderer implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int GL_TEXTURE_EXTERNAL_OES = 36197;
        private static final String TAG = "VideoRenderer";
        private static final int VERTICES_DATA_POS_OFFSET = 0;
        private static final int VERTICES_DATA_STRIDE_BYTES = 20;
        private static final int VERTICES_DATA_UV_OFFSET = 3;
        private Context mContext;
        private final String mFragmentShader;
        private float[] mMMatrix;
        private float[] mMVPMatrix;
        private int mProgram;
        private float[] mProjMatrix;
        private float mRatio;
        private IRenderView.IRenderCallback mRenderCallback;
        private float[] mSTMatrix;
        private SurfaceTexture mSurface;
        private int mTextureID;
        private float[] mVMatrix;
        private final String mVertexShader;
        private FloatBuffer mVertices;
        private final float[] mVerticesData;
        private WeakReference<VideoGLSurfaceView> mWeakSurfaceView;
        private int maPositionHandle;
        private int maTextureHandle;
        private int muMVPMatrixHandle;
        private int muSTMatrixHandle;
        private boolean updateSurface;

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurface;
        }

        private void checkGlError(String r10) {
            int r0 = GLES20.glGetError();
            if (r0 != 0) goto L6;
            return;
        L6:
            throw new RuntimeException(r10 + ": glError " + r0);
        }

        public void addRenderCallback(IRenderView.IRenderCallback r1) {
            this.mRenderCallback = r1;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r10) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.updateSurface == false) goto L6;
            this.mSurface.updateTexImage();     // Catch: Throwable -> L9
            this.mSurface.getTransformMatrix(this.mSTMatrix);     // Catch: Throwable -> L9
            this.updateSurface = false;     // Catch: Throwable -> L9
        L6:
            monitor-exit(this);     // Catch: Throwable -> L9
            GLES20.glClear(16640);
            GLES20.glUseProgram(this.mProgram);
            checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            this.mVertices.position(0);
            GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mVertices);
            checkGlError("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(this.maPositionHandle);
            checkGlError("glEnableVertexAttribArray maPositionHandle");
            this.mVertices.position(3);
            GLES20.glVertexAttribPointer(this.maTextureHandle, 3, 5126, false, 20, this.mVertices);
            checkGlError("glVertexAttribPointer maTextureHandle");
            GLES20.glEnableVertexAttribArray(this.maTextureHandle);
            checkGlError("glEnableVertexAttribArray maTextureHandle");
            Matrix.setIdentityM(this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
            GLES20.glDrawArrays(5, 0, 4);
            checkGlError("glDrawArrays");
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public synchronized void onFrameAvailable(SurfaceTexture r1) {
            monitor-enter(this);
            this.updateSurface = true;     // Catch: Throwable -> L9
            VideoGLSurfaceView r10 = this.mWeakSurfaceView.get();     // Catch: Throwable -> L9
            if (r10 == null) goto L7;
            r10.requestRender();     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void removeRenderCallback(IRenderView.IRenderCallback r1) {
            this.mRenderCallback = null;
        }

        public VideoRenderer(Context r10, VideoGLSurfaceView r11) {
            float[] r0 = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
            this.mVerticesData = r0;
            this.mVertexShader = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
            this.mFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
            this.mMVPMatrix = new float[16];
            this.mProjMatrix = new float[16];
            this.mMMatrix = new float[16];
            this.mVMatrix = new float[16];
            this.mSTMatrix = new float[16];
            this.mRatio = 1.0f;
            this.updateSurface = false;
            this.mContext = r10;
            this.mWeakSurfaceView = new WeakReference(r11);
            FloatBuffer r12 = ByteBuffer.allocateDirect(r0.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mVertices = r12;
            r12.put(r0).position(0);
            Matrix.setIdentityM(this.mSTMatrix, 0);
            Matrix.setIdentityM(this.mMMatrix, 0);
        }

        private int createProgram(String r10, String r11) {
            int r12 = loadShader(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = loadShader(35632, r11);
            if (r13 != 0) goto L8;
            return 0;
        L8:
            int r1 = GLES20.glCreateProgram();
            if (r1 == 0) goto L14;
            GLES20.glAttachShader(r1, r12);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(r1, r13);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(r1);
            int[] r14 = new int[1];
            GLES20.glGetProgramiv(r1, 35714, r14, 0);
            if (r14[0] == 1) goto L14;
            GLES20.glGetProgramInfoLog(r1);
            GLES20.glDeleteProgram(r1);
            return 0;
        L14:
            return r1;
        }

        private int loadShader(int r10, String r11) {
            int r12 = GLES20.glCreateShader(r10);
            if (r12 == 0) goto L8;
            GLES20.glShaderSource(r12, r11);
            GLES20.glCompileShader(r12);
            int[] r13 = new int[1];
            GLES20.glGetShaderiv(r12, 35713, r13, 0);
            if (r13[0] != 0) goto L9;
            GLES20.glGetShaderInfoLog(r12);
            GLES20.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r13, EGLConfig r14) {
            int r15 = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
            this.mProgram = r15;
            if (r15 != 0) goto L5;
            return;
        L5:
            this.maPositionHandle = GLES20.glGetAttribLocation(r15, "aPosition");
            checkGlError("glGetAttribLocation aPosition");
            if (this.maPositionHandle == (-1)) goto L35;
            this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
            checkGlError("glGetAttribLocation aTextureCoord");
            if (this.maTextureHandle == (-1)) goto L33;
            this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
            checkGlError("glGetUniformLocation uMVPMatrix");
            if (this.muMVPMatrixHandle == (-1)) goto L31;
            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            checkGlError("glGetUniformLocation uSTMatrix");
            if (this.muMVPMatrixHandle == (-1)) goto L29;
            checkGlError("glGetUniformLocation uCRatio");
            if (this.muMVPMatrixHandle == (-1)) goto L27;
            int[] r16 = new int[1];
            GLES20.glGenTextures(1, r16, 0);
            int r17 = r16[0];
            this.mTextureID = r17;
            GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, r17);
            checkGlError("glBindTexture mTextureID");
            GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
            GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, CalDavException.MAX_EXCERPT_SIZE, 9729.0f);
            GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
            GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
            checkGlError("glTexParameteri mTextureID");
            this.mSurface = new SurfaceTexture(this.mTextureID);
            Surface r18 = new Surface(this.mSurface);
            IRenderView.IRenderCallback r19 = this.mRenderCallback;
            if (r19 == null) goto L18;
            r19.onSurfaceTextureCreated(this.mWeakSurfaceView.get(), r18);
        L18:
            this.mSurface.setOnFrameAvailableListener(this);
            Matrix.setLookAtM(this.mVMatrix, 0, 0.0f, 0.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            monitor-enter(this);
            this.updateSurface = false;     // Catch: Throwable -> L23
            monitor-exit(this);     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new RuntimeException("Could not get attrib location for uCRatio");
        L29:
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        L31:
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        L33:
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        L35:
            throw new RuntimeException("Could not get attrib location for aPosition");
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            GLES20.glViewport(0, 0, r11, r12);
            if (r11 <= r12) goto L5;
            float r13 = r11;
            float r0 = r12;
        L6:
            float r14 = r13 / r0;
            if (r11 <= r12) goto L9;
            Matrix.orthoM(this.mProjMatrix, 0, -r14, r14, -1.0f, 1.0f, 0.0f, 10.0f);
            return;
        L9:
            Matrix.orthoM(this.mProjMatrix, 0, -1.0f, 1.0f, -r14, r14, 0.0f, 10.0f);
            return;
        L5:
            r13 = r12;
            r0 = r11;
            goto L6
        }
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public View getView() {
        return this;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoRotation(int r1) {
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mRenderer.getSurfaceTexture();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
    }

    public VideoGLSurfaceView(Context r10) {
        super(r10, null);
        init(r10);
        initView(r10);
    }

    private void init(Context r10) {
        setEGLContextClientVersion(2);
        VideoRenderer r0 = new VideoRenderer(r10, this);
        this.mRenderer = r0;
        setRenderer(r0);
        setRenderMode(0);
    }

    private void initView(Context r1) {
        this.mMeasureHelper = new MeasureHelper(this);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void addRenderCallback(IRenderView.IRenderCallback r10) {
        this.mRenderer.addRenderCallback(r10);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void removeRenderCallback(IRenderView.IRenderCallback r10) {
        this.mRenderer.removeRenderCallback(r10);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setAspectRatio(int r10) {
        this.mMeasureHelper.setAspectRatio(r10);
        requestLayout();
    }

    public VideoGLSurfaceView(Context r1, AttributeSet r10) {
        super(r1, r10);
        init(r1);
        initView(r1);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r10, int r11) {
        this.mMeasureHelper.doMeasure(r10, r11);
        setMeasuredDimension(this.mMeasureHelper.getMeasuredWidth(), this.mMeasureHelper.getMeasuredHeight());
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSampleAspectRatio(int r10, int r11) {
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L7;
        this.mMeasureHelper.setVideoSampleAspectRatio(r10, r11);
        requestLayout();
        return;
    L7:
        return;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSize(int r10, int r11) {
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L7;
        this.mMeasureHelper.setVideoSize(r10, r11);
        getHolder().setFixedSize(r10, r11);
        requestLayout();
        return;
    L7:
        return;
    }
}
