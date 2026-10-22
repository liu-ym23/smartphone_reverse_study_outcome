package r3a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.display.DisplayManager;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.Surface;
import android.view.TextureView;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.vlm.VideoFrameBufferType;
import com.larus.platform.service.o3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.component.vlm.camera.camera_state.t;
import com.larus.voicecall.impl.component.vlm.camera.camera_state.u;
import com.larus.voicecall.impl.component.vlm.camera.core.CameraOpenScene;
import com.lynx.canvas.camera.CameraSize;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.vesdk.VECameraCapture;
import com.ss.android.vesdk.VECameraSettings;
import com.ss.android.vesdk.VEDisplaySettings;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESDK;
import com.ss.android.vesdk.VESize;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements k {
    public static final VEDisplaySettings.VEDisplayFitMode N = null;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public final FloatBuffer F;
    public final FloatBuffer G;
    public final float[] H;
    public final FloatBuffer I;
    public final FloatBuffer J;
    public final FloatBuffer K;
    public final FloatBuffer L;
    public final FloatBuffer M;
    public final Activity a;
    public final m b;
    public final Fragment c;
    public final q3a.o d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public int i;
    public h j;
    public volatile int k;
    public final AtomicBoolean l;
    public volatile Boolean m;
    public volatile VECameraCapture n;
    public Surface o;
    public TextureView p;
    public final p3a.c q;
    public final AtomicBoolean r;
    public final AtomicBoolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static final class a {
    }

    public static final class b implements VEListener.s {
        public b() {
        }

        public final VESize a(List<? extends VESize> r10) {
            int r2 = 1;
            if (r10.isEmpty() == false) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L9;
            VESize r1 = (VESize) ListProtector.get(r10, 0);
            if (r1 == null) goto L13;
            int r3 = Math.abs(1280 - r1.width) + Math.abs(720 - r1.height);
            int r5 = ((ArrayList) r10).size();
        L15:
            if (r2 >= r5) goto L23;
            VESize r6 = (VESize) ListProtector.get(r10, r2);
            if (r6 == null) goto L22;
            int r7 = Math.abs(1280 - r6.width) + Math.abs(720 - r6.height);
            if (r7 >= r3) goto L22;
            r1 = r6;
            r3 = r7;
        L22:
            r2 = r2 + 1;
            goto L15
        L23:
            return r1;
        L13:
            return new VESize(CameraSize.highHeight, CameraSize.highWidth);
        L9:
            return new VESize(CameraSize.highHeight, CameraSize.highWidth);
        L5:
            r0 = false;
            goto L7
        }
    }

    public static final class c implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ f a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surfaceTexture");
        }

        public c(f r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
            Intrinsics.checkNotNullParameter(r3, "surfaceTexture");
            FLogger.a.i("CameraContextImpl", "onSurfaceTextureDestroyed");
            f r4 = this.a;
            r4.q.f = false;
            Surface r5 = r4.o;
            if (r5 == null) goto L5;
            r5.release();
        L5:
            this.a.o = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "surfaceTexture");
            FLogger r0 = FLogger.a;
            r0.i("CameraContextImpl", "onSurfaceTextureAvailable width=" + r5 + " height=" + r6);
            if (this.a.n != null) goto L5;
            this.a.D();
        L5:
            Surface r1 = this.a.o;
            if (r1 == null) goto L8;
            r1.release();
        L8:
            this.a.o = new Surface(r4);
            f r7 = this.a;
            r7.q.f = true;
            q3a.o r8 = r7.d;
            if (r8.c.get() == true) goto L12;
            r0.i("CameraEventDispatcher", "Dispatching surface created");
            r8.c("onSurfaceCreated", new q3a.c());
        L12:
            this.a.B().b(r5, r6, f.N);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "surfaceTexture");
            FLogger r0 = FLogger.a;
            r0.i("CameraContextImpl", "onSurfaceTextureSizeChanged width=" + r5 + " height=" + r6);
            this.a.o = new Surface(r4);
            f r7 = this.a;
            r7.q.f = true;
            u r8 = r7.B();
            Surface r1 = this.a.o;
            if (r1 != null) goto L5;
            r8.getClass();
            r0.e("RealtimeCameraRecorder", "onSurfaceChanged but surface is null");
        L8:
            this.a.B().b(r5, r6, f.N);
            return;
        L5:
            VERecorder r9 = r8.b;
            if (r9 == null) goto L8;
            r9.changeSurface(r1);
            goto L8
        }
    }

    @Override // r3a.k
    public final void a() {
        this.m = null;
    }

    static {
        N = VEDisplaySettings.VEDisplayFitMode.SCALE_MODE_CENTER_CROP;
    }

    public final u B() {
        return (u) this.f.getValue();
    }

    public final boolean D() {
        if (this.r.compareAndSet(false, true) == true) goto L8;
        FLogger.a.i("CameraContextImpl", "initializeCapture already initialized, skip");
        if (this.n == null) goto L22;
        return true;
    L22:
        return false;
    L8:
        FLogger r0 = FLogger.a;
        r0.i("CameraContextImpl", "Initializing camera capture");
        o3.b.c();     // Catch: Exception -> L18
        VESDK.enableRefactorRecorder(true);     // Catch: Exception -> L18
        VESDK.enableNewRecorder(true);     // Catch: Exception -> L18
        this.n = new VECameraCapture();     // Catch: Exception -> L18
        VECameraCapture r5 = this.n;     // Catch: Exception -> L18
        if (r5 == null) goto L13;
        r5.setCameraStateListener(new g(this));     // Catch: Exception -> L18
    L13:
        if (y() == true) goto L16;
        this.n = null;     // Catch: Exception -> L18
        this.r.set(false);     // Catch: Exception -> L18
        r0.e("CameraContextImpl", "Camera capture init failed, reset initialized state");     // Catch: Exception -> L18
        return false;
    L16:
        r0.i("CameraContextImpl", "Camera capture initialized successfully");     // Catch: Exception -> L18
        return true;
    L18:
        e = move-exception;
        this.n = null;
        this.r.set(false);
        FLogger.a.e("CameraContextImpl", "Failed to initialize camera capture", e);
        i r3 = new i(1, "Failed to initialize camera capture: " + e.getMessage(), e);
        Intrinsics.checkNotNullParameter(r3, "error");
        this.d.b(r3);
        return false;
    }

    @Override // r3a.k
    public final void h() {
        this.q.e = false;
    }

    @Override // r3a.k
    public final boolean isCameraTorchSupported() {
        VECameraCapture r0 = this.n;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isTorchSupported();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, r3a.e] */
    @Override // r3a.k
    public final boolean k() {
        Intrinsics.checkNotNullParameter("onStateChanged_RealtimeCameraManager", "from");
        if (n() == true) goto L7;
        FLogger.a.e("CameraContextImpl", "Resources not available for preview");
        return false;
    L7:
        if (this.q.b == true) goto L10;
        FLogger.a.e("CameraContextImpl", "Camera is not open, cannot start preview");
        return false;
    L10:
        FLogger r0 = FLogger.a;
        r0.i("CameraContextImpl", "Performing start preview operation. from=[onStateChanged_RealtimeCameraManager]");
        this.q.d = true;     // Catch: Exception -> L19
        u r3 = B();     // Catch: Exception -> L19
        Surface r5 = this.o;     // Catch: Exception -> L19
        final ?? r6 = new e(this);     // Catch: Exception -> L19
        r3.getClass();     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r6, "onResult");     // Catch: Exception -> L19
        if (r5 != null) goto L14;
        r0.e("RealtimeCameraRecorder", "surface is empty!");     // Catch: Exception -> L19
    L17:
        System.currentTimeMillis();     // Catch: Exception -> L19
        r0.i("CameraContextImpl", "Preview started successfully ");     // Catch: Exception -> L19
        return true;
    L14:
        VERecorder r4 = r3.b;     // Catch: Exception -> L19
        if (r4 == null) goto L17;
        r4.startPreviewAsync(r5, new t(r6));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        FLogger.a.e("CameraContextImpl", "Exception starting preview", e);
        return false;
    }

    @Override // r3a.k
    public final boolean n() {
        if (this.s.get() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.n == null) goto L7;
        return true;
    }

    @Override // r3a.k
    public final boolean q() {
        Boolean r0 = this.m;
        if (r0 != null) goto L5;
        z2 r1 = z2.a;
        int r2 = r1.getRealtimeCallCamera2Override();
        if (r2 != 0) goto L9;
        return false;
    L9:
        if (r2 != 1) goto L14;
        return true;
    L14:
        return r1.enableCamera2();
    L5:
        return r0.booleanValue();
    }

    @Override // r3a.k
    public final void s() {
        FLogger r0 = FLogger.a;
        r0.i("CameraContextImpl", "performDestroy");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L47
        o r2 = (o) this.e.getValue();     // Catch: Throwable -> L47
        r2.getClass();     // Catch: Throwable -> L47
        if (z2.a.enableVideoCaptureStartStatusAlignRtc() == false) goto L18;
        r2.d("onContextDestroy");     // Catch: Throwable -> L47
        Object r3 = r2.n;     // Catch: Throwable -> L47
        monitor-enter(r3);     // Catch: Throwable -> L47
        r2.p = 0;     // Catch: Throwable -> L14
        r2.q = false;     // Catch: Throwable -> L14
        r2.r = false;     // Catch: Throwable -> L14
        n r6 = r2.s;     // Catch: Throwable -> L14
        if (r6 == null) goto L11;
        r2.m.removeCallbacks(r6);     // Catch: Throwable -> L14
    L11:
        r2.s = null;     // Catch: Throwable -> L14
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L47
        goto L18
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L18:
        if (this.q.c == true) goto L20;
    L28:
        this.l.set(true);     // Catch: Throwable -> L47
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L34;
        h r5 = this.j;     // Catch: Throwable -> L47
        if (r5 == null) goto L33;
        r5.disable();     // Catch: Throwable -> L47
    L33:
        this.j = null;     // Catch: Throwable -> L47
    L34:
        u r7 = B();     // Catch: Throwable -> L47
        u.c r8 = r7.j;     // Catch: Throwable -> L47
        if (r8 == null) goto L39;
        DisplayManager r9 = r7.i;     // Catch: Throwable -> L47
        if (r9 == null) goto L39;
        r9.unregisterDisplayListener(r8);     // Catch: Throwable -> L47
    L39:
        r7.j = null;     // Catch: Throwable -> L47
        r7.i = null;     // Catch: Throwable -> L47
        this.s.set(true);     // Catch: Throwable -> L47
        Surface r10 = this.o;     // Catch: Throwable -> L47
        if (r10 == null) goto L42;
        r10.release();     // Catch: Throwable -> L47
    L42:
        q3a.o r11 = this.d;     // Catch: Throwable -> L47
        if (r11.c.compareAndSet(false, true) == false) goto L45;
        r0.i("CameraEventDispatcher", "Shutting down event dispatcher");     // Catch: Throwable -> L47
        r11.a.clear();     // Catch: Throwable -> L47
        r0.d("CameraEventDispatcher", "Cleared all listeners");     // Catch: Throwable -> L47
        r11.b.shutdown();     // Catch: Throwable -> L47
    L45:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L57;
        FLogger.a.e("CameraContextImpl", "performDestroy err=" + r13);
        return;
    L57:
        return;
    L20:
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L24;
        VERecorder r14 = B().b;     // Catch: Throwable -> L47
        if (r14 == null) goto L24;
        r14.stopPreview();     // Catch: Throwable -> L47
    L24:
        VECameraCapture r15 = this.n;     // Catch: Throwable -> L47
        if (r15 == null) goto L27;
        r15.destroy();     // Catch: Throwable -> L47
    L27:
        B().c();     // Catch: Throwable -> L47
        r0.i("CameraContextImpl", "destroy recorder from performDestroy");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    }

    public final int C() {
        int r0 = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (r0 != 0) goto L5;
        return 0;
    L5:
        if (r0 != 1) goto L7;
        return 90;
    L7:
        if (r0 != 2) goto L9;
        return 180;
    L9:
        if (r0 != 3) goto L18;
        return 270;
    L18:
        return 0;
    }

    @Override // r3a.k
    public final void i() {
        B().d(this.n);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "CameraContextImpl_performInitRecorder()");
        FLogger.a.e("CameraContextImpl", "performInitRecorder() failed", th);
    }

    public final boolean y() {
        if (q() == false) goto L5;
        VECameraSettings.CAMERA_TYPE r0 = VECameraSettings.CAMERA_TYPE.TYPE2;
    L6:
        boolean r1 = this.b.d;
        if (r1 == false) goto L9;
        VECameraSettings.CAMERA_FACING_ID r2 = VECameraSettings.CAMERA_FACING_ID.FACING_FRONT;
    L10:
        this.q.a = r1;
        H(r1);
        z2 r3 = z2.a;
        boolean r4 = r3.enableVeCaptureTargetSize();
        boolean r5 = r3.enableVeCaptureRtcSetting();
        m r6 = this.b;
        RangesKt.coerceAtLeast(r6.a, r6.b);
        VECameraSettings.Builder r7 = new VECameraSettings.Builder();
        boolean r8 = true;
        VECameraSettings.Builder r9 = r7.setIsUseNewCameraTypeStrategy(true).setCameraFacing(r2);
        m r10 = this.b;
        r9.setPreviewSize(r10.a, r10.b).setCameraAntiShake(this.b.e).setCameraVideoAntiShake(this.b.f).setEnableFallback(this.b.h).setFps(this.b.c).enablePreviewingFallback(this.b.i).setDefaultZoomRatio(this.b.g).setCameraType(r0);
        if (r5 == false) goto L13;
        r7.setRetryCnt(30).setCamera2RetryCnt(1).setFpsRange(new int[]{7, this.b.c}).enableGyroFocusAndMeter(true);
    L13:
        VECameraSettings r11 = r7.build();
        if (r5 == false) goto L16;
        r11.enableManualReleaseCaptureResult(false);
    L16:
        VECameraCapture r12 = this.n;
        if (r12 == null) goto L19;
        Integer r13 = Integer.valueOf(r12.init(getActivity(), r11));
    L20:
        if (r13 != null) goto L23;
    L25:
        r8 = false;
    L26:
        if (r4 == false) goto L30;
        VECameraCapture r14 = this.n;
        if (r14 == null) goto L30;
        r14.setPreviewSizeListener(new b());
    L30:
        FLogger.a.i("CameraContextImpl", "Camera settings configured, result: " + r13 + ", cameraType: " + r0);
        return r8;
    L23:
        if (r13.intValue() != 0) goto L25;
    L19:
        r13 = null;
        goto L20
    L9:
        r2 = VECameraSettings.CAMERA_FACING_ID.FACING_BACK;
        goto L10
    L5:
        r0 = VECameraSettings.CAMERA_TYPE.TYPE1;
        goto L6
    }

    @Override // r3a.k
    public final m g() {
        return this.b;
    }

    @Override // r3a.k
    public Activity getActivity() {
        return this.a;
    }

    @Override // r3a.k
    public final Fragment getFragment() {
        return this.c;
    }

    @Override // r3a.k
    public final p3a.c j() {
        return this.q;
    }

    @Override // r3a.k
    public final void o() {
        D();
    }

    public static int A(int r3) {
        if (r3 > 0) goto L6;
        return 3553;
    L6:
        if (GLES20.glGetError() != 0) goto L6;
        GLES20.glBindTexture(3553, r3);
        int r1 = GLES20.glGetError();
        GLES20.glBindTexture(3553, 0);
        if (r1 != 0) goto L10;
        return 3553;
    L10:
        GLES20.glBindTexture(36197, r3);
        int r4 = GLES20.glGetError();
        GLES20.glBindTexture(36197, 0);
        if (r4 != 0) goto L13;
        return 36197;
    L13:
        return 3553;
    }

    public static int E(int r0) {
        return ((r0 % 360) + 360) % 360;
    }

    public static Integer v(String r7) {
        Integer r0 = w(35633, "attribute vec4 aPosition;\nattribute vec2 aTexCoord;\nvarying vec2 vTexCoord;\nuniform mat4 uTexMatrix;\nvoid main() {\n    gl_Position = aPosition;\n    vec4 tc = uTexMatrix * vec4(aTexCoord, 0.0, 1.0);\n    vTexCoord = tc.xy;\n}");
        if (r0 == null) goto L17;
        int r1 = r0.intValue();
        Integer r8 = w(35632, r7);
        if (r8 == null) goto L16;
        int r9 = r8.intValue();
        int r2 = GLES20.glCreateProgram();
        if (r2 != 0) goto L10;
        GLES20.glDeleteShader(r1);
        GLES20.glDeleteShader(r9);
        return null;
    L10:
        GLES20.glAttachShader(r2, r1);
        GLES20.glAttachShader(r2, r9);
        GLES20.glLinkProgram(r2);
        int[] r4 = new int[1];
        GLES20.glGetProgramiv(r2, 35714, r4, 0);
        GLES20.glDeleteShader(r1);
        GLES20.glDeleteShader(r9);
        if (r4[0] == 1) goto L15;
        FLogger.a.e("CameraContextImpl", "buildProgram link failed: " + GLES20.glGetProgramInfoLog(r2));
        GLES20.glDeleteProgram(r2);
        return null;
    L15:
        return Integer.valueOf(r2);
    L16:
        GLES20.glDeleteShader(r1);
    L17:
        return null;
    }

    public static FloatBuffer z(float[] r2) {
        FloatBuffer r0 = ByteBuffer.allocateDirect(r2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r0.put(r2);
        r0.position(0);
        return r0;
    }

    public final boolean F(String r11) {
        Intrinsics.checkNotNullParameter(r11, "from");
        FLogger r1 = FLogger.a;
        r1.i("CameraContextImpl", "Performing stop preview operation. from=[" + r11 + ']');
        this.q.d = false;     // Catch: Exception -> L21
        VECameraCapture r3 = this.n;     // Catch: Exception -> L21
        if (r3 == null) goto L6;
        Integer r4 = Integer.valueOf(r3.stopPreview(true));     // Catch: Exception -> L21
    L7:
        if (r4 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L19;
        q3a.o r7 = this.d;     // Catch: Exception -> L21
        if (r4 == null) goto L17;
        int r8 = r4.intValue();     // Catch: Exception -> L21
    L18:
        r7.b(new i(r8, "failed_to_stop_preview, result: " + r4, null));     // Catch: Exception -> L21
        goto L19
    L17:
        r8 = -1;
    L19:
        r1.i("CameraContextImpl", "Preview stopped successfully");     // Catch: Exception -> L21
        return true;
    L10:
        if (r4.intValue() != 0) goto L12;
        r6 = true;
        goto L13
    L6:
        r4 = null;
    L21:
        e = move-exception;
        FLogger.a.e("CameraContextImpl", "Exception stopping preview", e);
        return false;
    }

    public final void H(boolean r8) {
        if (r8 == false) goto L4;
        int r0 = 270;
    L5:
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        int r3 = 0;
        if (r8 == false) goto L9;
        int r9 = 1;
    L10:
        int r4 = Camera.getNumberOfCameras();     // Catch: Throwable -> L27
        if (r4 <= 0) goto L24;
        Camera.CameraInfo[] r5 = new Camera.CameraInfo[r4];     // Catch: Throwable -> L27
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L16;
        r5[r6] = new Camera.CameraInfo();     // Catch: Throwable -> L27
        r6 = r6 + 1;     // Catch: Throwable -> L27
        goto L14
    L16:
        int r7 = 0;
    L17:
        if (r7 >= r4) goto L19;
        Camera.getCameraInfo(r7, r5[r7]);     // Catch: Throwable -> L27
        r7 = r7 + 1;     // Catch: Throwable -> L27
    L19:
        if (r3 >= r4) goto L24;
        Camera.CameraInfo r10 = r5[r3];     // Catch: Throwable -> L27
        if (r10.facing == r9) goto L22;
        r3 = r3 + 1;     // Catch: Throwable -> L27
        goto L19
    L22:
        Integer r11 = Integer.valueOf(((r10.orientation % 360) + 360) % 360);     // Catch: Throwable -> L27
    L25:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r12) == true) goto L33;
        r1 = r12;
    L33:
        Integer r13 = (Integer) r1;
        if (r13 == null) goto L36;
        r0 = r13.intValue();
    L36:
        this.i = r0;
        return;
    L24:
        r11 = null;
        goto L25
    L9:
        r9 = 0;
    L27:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L4:
        r0 = 90;
        goto L5
    }

    @Override // r3a.k
    public final void b(final boolean r13) {
        Intrinsics.checkNotNullParameter("switchCamera", "from");
        p3a.c r6 = this.q;     // Catch: Exception -> L49
        if (r6.b == true) goto L6;
    L47:
        FLogger.a.i("CameraContextImpl", "performSwitchCamera return directly. isCameraOpen=" + this.q.b + " isPreviewing=" + this.q.d);     // Catch: Exception -> L49
        return;
    L6:
        if (r6.d == false) goto L47;
        if (r13 != (!r6.a)) goto L12;
        FLogger.a.e("CameraContextImpl", "current camera is back=" + r13 + ", do not need to switch it!");     // Catch: Exception -> L49
        return;
    L12:
        VECameraCapture r4 = this.n;     // Catch: Exception -> L49
        if (r4 == null) goto L15;
        r4.cancelFocus();     // Catch: Exception -> L49
    L15:
        FLogger r5 = FLogger.a;     // Catch: Exception -> L49
        r5.e("CameraContextImpl", "cancelFocus exec");     // Catch: Exception -> L49
        if (r13 == false) goto L20;
        VECameraCapture r7 = this.n;     // Catch: Exception -> L49
        if (r7 == null) goto L23;
        Integer r8 = Integer.valueOf(r7.switchCamera(VECameraSettings.CAMERA_FACING_ID.FACING_BACK));     // Catch: Exception -> L49
    L24:
        p3a.c r9 = this.q;     // Catch: Exception -> L49
        if (r13 == true) goto L27;
        boolean r10 = true;
    L28:
        r9.a = r10;     // Catch: Exception -> L49
        H(r10);     // Catch: Exception -> L49
        q3a.o r11 = this.d;     // Catch: Exception -> L49
        if (r8 == null) goto L31;
        final int r12 = r8.intValue();     // Catch: Exception -> L49
    L33:
        if (r11.c.get() == true) goto L36;
        r5.i("CameraEventDispatcher", "Dispatching camera switched: useBack=" + r13);     // Catch: Exception -> L49
        r11.c("onCameraSwitched", new q3a.g(r13, r12));     // Catch: Exception -> L49
    L36:
        String r14 = "Performing switch camera operation. useBack=" + r13 + " from=[switchCamera] result=" + r8;     // Catch: Exception -> L49
        if (r8 != null) goto L40;
    L41:
        q3a.o r0 = this.d;     // Catch: Exception -> L49
        if (r8 == null) goto L44;
        int r15 = r8.intValue();     // Catch: Exception -> L49
    L45:
        r0.b(new i(r15, "failed_to_switch_camera, result: " + r8, null));     // Catch: Exception -> L49
        r5.e("CameraContextImpl", r14);     // Catch: Exception -> L49
        return;
    L44:
        r15 = -1;
        goto L45
    L40:
        if (r8.intValue() != 0) goto L41;
        r5.i("CameraContextImpl", r14);     // Catch: Exception -> L49
        ((o) this.e.getValue()).e(true);     // Catch: Exception -> L49
        return;
    L31:
        r12 = -999;
        goto L33
    L27:
        r10 = false;
    L23:
        r8 = null;
        goto L24
    L20:
        VECameraCapture r16 = this.n;     // Catch: Exception -> L49
        if (r16 == null) goto L23;
        r8 = Integer.valueOf(r16.switchCamera(VECameraSettings.CAMERA_FACING_ID.FACING_FRONT));     // Catch: Exception -> L49
    L49:
        e = move-exception;
        FLogger.a.e("CameraContextImpl", "Exception in switch camera", e);
        if (AppHost.a.isDebug() == false) goto L56;
        throw e;
    }

    @Override // r3a.k
    public final boolean c(boolean r2) {
        VECameraCapture r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.switchTorch(r2) != 0) goto L7;
        return true;
    }

    @Override // r3a.k
    public final boolean d(String r11) {
        Intrinsics.checkNotNullParameter(r11, "from");
        FLogger r3 = FLogger.a;
        r3.i("CameraContextImpl", "Performing close camera operation. from=[" + r11 + ']');
        VECameraCapture r5 = this.n;     // Catch: Exception -> L60
        boolean r6 = true;
        if (r5 != null) goto L6;
    L8:
        boolean r7 = false;
    L10:
        if (r7 == true) goto L33;
        VECameraCapture r8 = this.n;     // Catch: Exception -> L60
        if (r8 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L33;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L26
        VERecorder r4 = B().b;     // Catch: Throwable -> L26
        if (r4 == null) goto L23;
        Pair r10 = TuplesKt.to(Float.valueOf(r4.getPreviewRenderFps()), Float.valueOf(r4.getPreviewAvgRenderFps()));     // Catch: Throwable -> L26
        if (r10 == null) goto L23;
    L24:
        Object r12 = Result.constructor-impl(r10);     // Catch: Throwable -> L26
    L29:
        if (Result.exceptionOrNull-impl(r12) == null) goto L32;
        r12 = TuplesKt.to(Float.valueOf(-1.0f), Float.valueOf(-1.0f));     // Catch: Exception -> L60
    L32:
        Pair r13 = (Pair) r12;     // Catch: Exception -> L60
    L38:
        final HashMap r14 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("current_fps", r13.getFirst()), TuplesKt.to("average_fps", r13.getSecond())});     // Catch: Exception -> L60
        F("this.performCloseCamera()");     // Catch: Exception -> L60
        this.q.b = false;     // Catch: Exception -> L60
        VECameraCapture r15 = this.n;     // Catch: Exception -> L60
        if (r15 == null) goto L41;
        Integer r16 = Integer.valueOf(r15.close());     // Catch: Exception -> L60
    L42:
        if (r16 != null) goto L45;
    L47:
        r6 = false;
    L48:
        if (r6 == false) goto L54;
        q3a.o r0 = this.d;     // Catch: Exception -> L60
        r0.getClass();     // Catch: Exception -> L60
        Intrinsics.checkNotNullParameter(r14, "captureParams");     // Catch: Exception -> L60
        if (r0.c.get() == true) goto L53;
        FLogger.a.i("CameraEventDispatcher", "Dispatching camera closed");     // Catch: Exception -> L60
        r0.c("onCameraClosed", new q3a.f(r14));     // Catch: Exception -> L60
    L53:
        FLogger.a.i("CameraContextImpl", "Camera closed successfully");     // Catch: Exception -> L60
    L66:
        return r6;
    L54:
        q3a.o r17 = this.d;     // Catch: Exception -> L60
        if (r16 == null) goto L57;
        int r18 = r16.intValue();     // Catch: Exception -> L60
    L58:
        r17.b(new i(r18, "failed_to_close_camera, result: " + r16, null));     // Catch: Exception -> L60
        FLogger.a.e("CameraContextImpl", "Failed to close camera, result: " + r16);     // Catch: Exception -> L60
        goto L66
    L57:
        r18 = -1;
        goto L58
    L45:
        if (r16.intValue() != 0) goto L47;
    L41:
        r16 = null;
    L23:
        r10 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Exception -> L60
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L60
        goto L29
    L14:
        if (r8.getCameraState() != 0) goto L16;
        r9 = true;
    L33:
        StringBuilder r20 = new StringBuilder("getRenderFps failed! cur state is: ");     // Catch: Exception -> L60
        VECameraCapture r21 = this.n;     // Catch: Exception -> L60
        if (r21 == null) goto L36;
        Integer r22 = Integer.valueOf(r21.getCameraState());     // Catch: Exception -> L60
    L37:
        r20.append(r22);     // Catch: Exception -> L60
        r3.e("CameraContextImpl", r20.toString());     // Catch: Exception -> L60
        r13 = new Pair(Float.valueOf(-1.0f), Float.valueOf(-1.0f));     // Catch: Exception -> L60
        goto L38
    L36:
        r22 = null;
        goto L37
    L6:
        if (r5.getCameraState() != 4) goto L8;
        r7 = true;
    L60:
        e = move-exception;
        FLogger.a.e("CameraContextImpl", "Exception closing camera", e);
        return false;
    }

    @Override // r3a.k
    public final void l(VEFrame r46) {
        Intrinsics.checkNotNullParameter(r46, "frame");
        VEFrame.TextureFrame r0 = r46.getFrame();
        if ((r0 instanceof VEFrame.TextureFrame) == true) goto L5;
        return;
    L5:
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L22;
        q3a.o r3 = this.d;
        VEFrame.TextureFrame r1 = r0;
        int r15 = this.k;
        if (r46.getTextureTransformMatrix() != null) goto L9;
    L11:
        float[] r11 = this.H;
    L12:
        float[] r20 = r11;
        float[] r12 = new float[16];
        if (this.q.a == false) goto L19;
        float[] r5 = new float[16];
        Matrix.setIdentityM(r5, 0);
        r5[0] = -1.0f;
        r5[12] = 1.0f;
        if (r15 == 90) goto L18;
        if (r15 == 270) goto L18;
        Matrix.multiplyMM(r12, 0, r20, 0, r5, 0);
    L20:
        FLogger.a.i("CameraContextImpl", "push oes frame info: width=" + r46.getWidth() + ", height=" + r46.getHeight() + ", textureId=" + r1.b + ", frame.rotation=" + r46.getRotation() + ", gravitySensorRotation=" + r15);
        r3.e(new j(r1.b, ((long) 1000) * SystemClock.elapsedRealtime(), Arrays.copyOf(r12, r12.length), r15, r1.a, VideoFrameBufferType.GL_TEXTURE_OES));
        return;
    L18:
        Matrix.multiplyMM(r12, 0, r5, 0, r20, 0);
        goto L20
    L19:
        Intrinsics.checkNotNull(r20);
        r12 = r20;
        goto L20
    L9:
        if (r46.getTextureTransformMatrix().length != 16) goto L11;
        r11 = r46.getTextureTransformMatrix();
        goto L12
    L22:
        VEFrame.TextureFrame r4 = r0;
        int r13 = r4.b;
        int r14 = C();
        int r2 = r46.getWidth();
        int r16 = r46.getHeight();
        int r17 = Math.min(r2, r16);
        int r18 = Math.max(r2, r16);
        if (r14 != 90) goto L25;
        boolean r7 = true;
    L26:
        if (r14 != 270) goto L28;
        boolean r8 = true;
    L29:
        boolean r6 = this.q.a;
        float[] r9 = r46.getTextureTransformMatrix();
        if (r13 <= 0) goto L46;
        if (r2 <= 0) goto L239;
        if (r16 <= 0) goto L239;
        if (r17 <= 0) goto L239;
        if (r18 <= 0) goto L239;
        int r10 = A(r13);
        if (r6 == true) goto L48;
        if (r7 == true) goto L48;
        if (r8 == true) goto L48;
        if (r10 != 3553) goto L48;
        if (r2 != 720) goto L48;
        if (r16 == 1280) goto L46;
    L48:
        if (r7 == true) goto L149;
        if (r8 == true) goto L149;
        if (r13 <= 0) goto L148;
        if (r2 <= 0) goto L148;
        if (r16 <= 0) goto L148;
        int r19 = A(r13);
        if (r6 == true) goto L64;
        if (r19 != 3553) goto L64;
        if (r2 != 720) goto L64;
        if (r16 == 1280) goto L148;
    L64:
        if (r19 == 36197) goto L67;
        if (r19 != 3553) goto L148;
    L67:
        int r110 = this.u;
        if (r110 != 0) goto L70;
    L75:
        if (r110 == 0) goto L77;
        int r21 = 1;
        int r22 = 0;
        GLES20.glDeleteTextures(1, new int[]{r110}, 0);
        this.u = 0;
    L78:
        int[] r111 = new int[r21];
        GLES20.glGenTextures(r21, r111, r22);
        int r23 = r111[r22];
        this.u = r23;
        this.v = CameraSize.highWidth;
        this.w = CameraSize.highHeight;
        GLES20.glBindTexture(3553, r23);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, CameraSize.highWidth, CameraSize.highHeight, 0, 6408, 5121, null);
        int r24 = 0;
        GLES20.glBindTexture(3553, 0);
    L80:
        if (this.t != 0) goto L83;
        int[] r112 = new int[1];
        GLES20.glGenFramebuffers(1, r112, r24);
        this.t = r112[r24];
    L83:
        if (this.t == 0) goto L148;
        if (this.u == 0) goto L148;
        if (this.x != 0) goto L95;
        Integer r25 = v("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r25 == null) goto L92;
        int r26 = r25.intValue();
    L93:
        this.x = r26;
        goto L95
    L92:
        r26 = 0;
    L95:
        if (this.y != 0) goto L102;
        Integer r27 = v("precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r27 == null) goto L99;
        int r28 = r27.intValue();
    L100:
        this.y = r28;
        goto L102
    L99:
        r28 = 0;
    L102:
        if (r19 != 36197) goto L104;
        boolean r29 = true;
    L105:
        if (r29 == false) goto L107;
        int r30 = this.x;
    L108:
        if (r30 == 0) goto L148;
        int[] r113 = new int[1];
        GLES20.glGetIntegerv(36006, r113, 0);
        VEFrame.TextureFrame r32 = r4;
        int[] r31 = new int[4];
        GLES20.glGetIntegerv(2978, r31, 0);
        GLES20.glBindFramebuffer(36160, this.t);     // Catch: Throwable -> L140
        int r33 = r14;
        boolean r34 = r7;
        boolean r35 = r8;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u, 0);     // Catch: Throwable -> L138
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) goto L137;
        int[] r36 = x(r2, r16);     // Catch: Throwable -> L138
        GLES20.glViewport(r36[0], r36[1], r36[2], r36[3]);     // Catch: Throwable -> L138
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);     // Catch: Throwable -> L138
        GLES20.glClear(16384);     // Catch: Throwable -> L138
        int r37 = GLES20.glGetAttribLocation(r30, "aPosition");     // Catch: Throwable -> L138
        int r38 = GLES20.glGetAttribLocation(r30, "aTexCoord");     // Catch: Throwable -> L138
        int r39 = GLES20.glGetUniformLocation(r30, "uTexture");     // Catch: Throwable -> L138
        int r40 = GLES20.glGetUniformLocation(r30, "uTexMatrix");     // Catch: Throwable -> L138
        if (r37 < 0) goto L137;
        if (r38 < 0) goto L137;
        if (r39 < 0) goto L137;
        if (r40 < 0) goto L137;
        GLES20.glUseProgram(r30);     // Catch: Throwable -> L138
        GLES20.glEnableVertexAttribArray(r37);     // Catch: Throwable -> L138
        GLES20.glVertexAttribPointer(r37, 2, 5126, false, 0, this.F);     // Catch: Throwable -> L138
        GLES20.glEnableVertexAttribArray(r38);     // Catch: Throwable -> L138
        GLES20.glVertexAttribPointer(r38, 2, 5126, false, 0, G(false, false, r6));     // Catch: Throwable -> L138
        if (r9 != null) goto L125;
    L127:
        r9 = this.H;     // Catch: Throwable -> L138
    L128:
        GLES20.glUniformMatrix4fv(r40, 1, false, r9, 0);     // Catch: Throwable -> L138
        GLES20.glActiveTexture(33984);     // Catch: Throwable -> L138
        if (r29 == false) goto L131;
        GLES20.glBindTexture(36197, r13);     // Catch: Throwable -> L138
    L132:
        GLES20.glUniform1i(r39, 0);     // Catch: Throwable -> L138
        GLES20.glDrawArrays(5, 0, 4);     // Catch: Throwable -> L138
        GLES20.glFinish();     // Catch: Throwable -> L138
        if (r29 == false) goto L135;
        GLES20.glBindTexture(36197, 0);     // Catch: Throwable -> L138
    L136:
        GLES20.glDisableVertexAttribArray(r37);     // Catch: Throwable -> L138
        GLES20.glDisableVertexAttribArray(r38);     // Catch: Throwable -> L138
        GLES20.glUseProgram(0);     // Catch: Throwable -> L138
        r13 = this.u;     // Catch: Throwable -> L138
        goto L137
    L135:
        GLES20.glBindTexture(3553, 0);     // Catch: Throwable -> L138
        goto L136
    L131:
        GLES20.glBindTexture(3553, r13);     // Catch: Throwable -> L138
        goto L132
    L125:
        if (r9.length != 16) goto L127;
    L137:
        GLES20.glBindFramebuffer(36160, r113[0]);
        int r41 = r31[0];
        int r42 = r31[1];
        int r43 = r31[2];
        int r44 = r31[3];
    L144:
        GLES20.glViewport(r41, r42, r43, r44);
    L193:
        boolean r114 = r34;
        boolean r45 = r35;
    L233:
        int r47 = r13;
    L241:
        int r48 = this.i;
        int r49 = C();
        if (this.q.a == false) goto L244;
        r49 = (360 - r49) % 360;
    L244:
        int r50 = (((r48 + r49) % 360) + 360) % 360;
        if (r114 == false) goto L247;
        int r51 = 90;
    L253:
        int r52 = E(E(-r51));
        if (r52 == 90) goto L258;
        if (r52 == 270) goto L257;
        int r115 = r52;
    L259:
        this.d.e(new j(r47, SystemClock.elapsedRealtime() * ((long) 1000), this.H, r115, r32.a, VideoFrameBufferType.GL_TEXTURE));
        return;
    L257:
        r115 = 90;
        goto L259
    L258:
        r115 = 270;
        goto L259
    L247:
        if (r45 == false) goto L250;
        r51 = 270;
        goto L253
    L250:
        if (r33 != 180) goto L252;
        r51 = 180;
        goto L253
    L252:
        r51 = 0;
    L138:
        th = th;
    L261:
        FLogger.a.e("CameraContextImpl", "ensureTexture2D error", th);     // Catch: Throwable -> L145
        GLES20.glBindFramebuffer(36160, r113[0]);
        r41 = r31[0];
        r42 = r31[1];
        r43 = r31[2];
        r44 = r31[3];
    L145:
        th = move-exception;
        GLES20.glBindFramebuffer(36160, r113[0]);
        GLES20.glViewport(r31[0], r31[1], r31[2], r31[3]);
        throw th;
    L140:
        th = th;
        r34 = r7;
        r35 = r8;
        r33 = r14;
        goto L261
    L107:
        r30 = this.y;
        goto L108
    L104:
        r29 = false;
        goto L105
    L77:
        r21 = 1;
        r22 = 0;
        goto L78
    L70:
        if (this.v != 720) goto L75;
        if (this.w != 1280) goto L75;
        r24 = 0;
    L148:
        r32 = r4;
        r34 = r7;
        r35 = r8;
        r33 = r14;
    L149:
        r32 = r4;
        r34 = r7;
        r35 = r8;
        r33 = r14;
        int r53 = this.A;
        if (r53 != 0) goto L152;
    L157:
        if (r53 == 0) goto L159;
        int r54 = 1;
        int r55 = 0;
        GLES20.glDeleteTextures(1, new int[]{r53}, 0);
        this.A = 0;
    L160:
        int[] r56 = new int[r54];
        GLES20.glGenTextures(r54, r56, r55);
        int r57 = r56[r55];
        this.A = r57;
        this.B = CameraSize.highWidth;
        this.C = CameraSize.highHeight;
        GLES20.glBindTexture(3553, r57);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, CameraSize.highWidth, CameraSize.highHeight, 0, 6408, 5121, null);
        int r58 = 0;
        GLES20.glBindTexture(3553, 0);
    L162:
        if (this.z != 0) goto L165;
        int[] r59 = new int[1];
        GLES20.glGenFramebuffers(1, r59, r58);
        this.z = r59[r58];
    L165:
        if (this.z != 0) goto L167;
    L237:
        r114 = r34;
        r45 = r35;
    L240:
        r47 = r13;
        goto L241
    L167:
        if (this.A == 0) goto L237;
        if (r10 != 36197) goto L172;
        boolean r60 = true;
    L173:
        if (r60 == true) goto L175;
    L181:
        if (r60 == false) goto L183;
    L189:
        if (r60 == false) goto L191;
        int r61 = this.D;
    L192:
        if (r61 == 0) goto L193;
        int[] r62 = new int[1];
        GLES20.glGetIntegerv(36006, r62, 0);
        int[] r63 = new int[4];
        GLES20.glGetIntegerv(2978, r63, 0);
        GLES20.glBindFramebuffer(36160, this.z);     // Catch: Throwable -> L228
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A, 0);     // Catch: Throwable -> L228
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) goto L198;
    L197:
        r114 = r34;
        r45 = r35;
    L227:
        GLES20.glBindFramebuffer(36160, r62[0]);
        int r64 = r63[0];
        int r65 = r63[1];
        int r66 = r63[2];
        int r67 = r63[3];
    L232:
        GLES20.glViewport(r64, r65, r66, r67);
        goto L233
    L198:
        int[] r68 = x(r17, r18);     // Catch: Throwable -> L228
        GLES20.glViewport(r68[0], r68[1], r68[2], r68[3]);     // Catch: Throwable -> L228
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);     // Catch: Throwable -> L228
        GLES20.glClear(16384);     // Catch: Throwable -> L228
        int r69 = GLES20.glGetAttribLocation(r61, "aPosition");     // Catch: Throwable -> L228
        int r70 = GLES20.glGetAttribLocation(r61, "aTexCoord");     // Catch: Throwable -> L228
        int r71 = GLES20.glGetUniformLocation(r61, "uTexture");     // Catch: Throwable -> L228
        int r116 = GLES20.glGetUniformLocation(r61, "uTexMatrix");     // Catch: Throwable -> L228
        if (r69 < 0) goto L197;
        if (r70 < 0) goto L197;
        if (r71 < 0) goto L197;
        if (r116 < 0) goto L197;
        GLES20.glUseProgram(r61);     // Catch: Throwable -> L228
        GLES20.glEnableVertexAttribArray(r69);     // Catch: Throwable -> L228
        GLES20.glVertexAttribPointer(r69, 2, 5126, false, 0, this.F);     // Catch: Throwable -> L228
        GLES20.glEnableVertexAttribArray(r70);     // Catch: Throwable -> L228
        r114 = r34;
        r45 = r35;
        GLES20.glVertexAttribPointer(r70, 2, 5126, false, 0, G(r114, r45, r6));     // Catch: Throwable -> L225
        if (r9 != null) goto L209;
    L211:
        r9 = this.H;     // Catch: Throwable -> L225
    L212:
        GLES20.glUniformMatrix4fv(r116, 1, false, r9, 0);     // Catch: Throwable -> L225
        GLES20.glActiveTexture(33984);     // Catch: Throwable -> L225
        if (r60 == false) goto L215;
        GLES20.glBindTexture(36197, r13);     // Catch: Throwable -> L225
    L217:
        if (GLES20.glGetError() != 0) goto L227;
        GLES20.glUniform1i(r71, 0);     // Catch: Throwable -> L225
        GLES20.glDrawArrays(5, 0, 4);     // Catch: Throwable -> L225
        GLES20.glFinish();     // Catch: Throwable -> L225
        if (r60 == false) goto L222;
        GLES20.glBindTexture(36197, 0);     // Catch: Throwable -> L225
    L223:
        GLES20.glDisableVertexAttribArray(r69);     // Catch: Throwable -> L225
        GLES20.glDisableVertexAttribArray(r70);     // Catch: Throwable -> L225
        GLES20.glUseProgram(0);     // Catch: Throwable -> L225
        r13 = this.A;     // Catch: Throwable -> L225
        goto L227
    L222:
        GLES20.glBindTexture(3553, 0);     // Catch: Throwable -> L225
        goto L223
    L215:
        GLES20.glBindTexture(3553, r13);     // Catch: Throwable -> L225
        goto L217
    L209:
        if (r9.length != 16) goto L211;
    L225:
        th = th;
    L265:
        FLogger.a.e("CameraContextImpl", "ensurePortraitTexture2D error", th);     // Catch: Throwable -> L234
        GLES20.glBindFramebuffer(36160, r62[0]);
        r64 = r63[0];
        r65 = r63[1];
        r66 = r63[2];
        r67 = r63[3];
    L234:
        th = move-exception;
        GLES20.glBindFramebuffer(36160, r62[0]);
        GLES20.glViewport(r63[0], r63[1], r63[2], r63[3]);
        throw th;
    L228:
        th = th;
        r114 = r34;
        r45 = r35;
        goto L265
    L191:
        r61 = this.E;
        goto L192
    L183:
        if (this.E != 0) goto L189;
        Integer r72 = v("precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r72 == null) goto L187;
        int r73 = r72.intValue();
    L188:
        this.E = r73;
        goto L189
    L187:
        r73 = 0;
        goto L188
    L175:
        if (this.D != 0) goto L181;
        Integer r74 = v("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTexCoord);\n}");
        if (r74 == null) goto L179;
        int r75 = r74.intValue();
    L180:
        this.D = r75;
        goto L181
    L179:
        r75 = 0;
        goto L180
    L172:
        r60 = false;
        goto L173
    L159:
        r54 = 1;
        r55 = 0;
        goto L160
    L152:
        if (this.B != 720) goto L157;
        if (this.C != 1280) goto L157;
        r58 = 0;
    L239:
        r32 = r4;
        r114 = r7;
        r45 = r8;
        r33 = r14;
    L46:
        r32 = r4;
        r114 = r7;
        r45 = r8;
        r33 = r14;
        goto L233
    L28:
        r8 = false;
        goto L29
    L25:
        r7 = false;
        goto L26
    }

    @Override // r3a.k
    public final void m(TextureView r2) {
        if (r2 == null) goto L4;
        r2.setSurfaceTextureListener(new c(this));
    L4:
        this.p = r2;
    }

    @Override // r3a.k
    public final void t(final s3a.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        q3a.o r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        FLogger.a.i("CameraEventDispatcher", "Dispatching custom event: CameraPushFrameFinishEvent");
        r1.c("onCustomEvent", new q3a.e(r5));
    }

    @Override // r3a.k
    public final void u(float r8) {
        VECameraCapture r0 = this.n;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.zoomV2(r8));
    L6:
        if (r1 != null) goto L9;
    L10:
        q3a.o r2 = this.d;
        if (r1 == null) goto L13;
        int r4 = r1.intValue();
    L14:
        r2.b(new i(r4, "failed_to_zoom_camera, result: " + r1, null));
        FLogger.a.e("CameraContextImpl", "performZoom isZoomIn=$ result=" + r1 + " factory=" + r8);
        return;
    L13:
        r4 = -1;
        goto L14
    L9:
        if (r1.intValue() != 0) goto L10;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static Integer w(int r4, String r5) {
        int r6 = GLES20.glCreateShader(r4);
        if (r6 != 0) goto L5;
        return null;
    L5:
        GLES20.glShaderSource(r6, r5);
        GLES20.glCompileShader(r6);
        int[] r1 = new int[1];
        GLES20.glGetShaderiv(r6, 35713, r1, 0);
        if (r1[0] == 1) goto L10;
        FLogger.a.e("CameraContextImpl", "compileShader failed: " + GLES20.glGetShaderInfoLog(r6));
        GLES20.glDeleteShader(r6);
        return null;
    L10:
        return Integer.valueOf(r6);
    }

    public static int[] x(int r5, int r6) {
        if (r5 <= 0) goto L9;
        if (r6 <= 0) goto L9;
        float r7 = r5;
        float r8 = r6;
        float r1 = Math.max(720.0f / r7, 1280.0f / r8);
        int r9 = (int) (r7 * r1);
        int r10 = (int) (r8 * r1);
        return new int[]{-((r9 - 720) / 2), -((r10 - 1280) / 2), r9, r10};
    L9:
        return new int[]{0, 0, CameraSize.highWidth, CameraSize.highHeight};
    }

    @Override // r3a.k
    public final void f(float r8, float r9) {
        TextureView r0 = this.p;
        if (r0 == null) goto L13;
        int r2 = r0.getWidth();
        int r3 = r0.getHeight();
        if (r2 == 0) goto L11;
        if (r3 == 0) goto L11;
        Resources r1 = r0.getContext().getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        VECameraCapture r5 = this.n;
        if (r5 == null) goto L14;
        r5.focusAtPoint(r2, r3, r4, (int) r8, (int) r9);
        return;
    L14:
        return;
    L11:
        FLogger.a.w("CameraContextImpl", "performFocus, surfaceView has not been measured.");
        return;
    }

    @Override // r3a.k
    public final boolean p(String r11, CameraOpenScene r12) {
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "scene");
        if (this.s.get() == false) goto L6;
        FLogger.a.w("CameraContextImpl", "Context is cleaned up, cannot open camera");
        return false;
    L6:
        FLogger r2 = FLogger.a;
        r2.i("CameraContextImpl", "Performing open camera operation. from=[" + r11 + "] scene=" + r12);
    L36:
        e = move-exception;
        FLogger.a.e("CameraContextImpl", "Exception opening camera", e);
        return false;
    L8:
        if (this.n != null) goto L10;
        D();     // Catch: Exception -> L36
    L10:
        o r13 = (o) this.e.getValue();     // Catch: Exception -> L36
        boolean r6 = true;
        if (r12 != CameraOpenScene.PRIMARY_START) goto L13;
        boolean r14 = true;
    L14:
        r13.c(r14);     // Catch: Exception -> L36
        VECameraCapture r15 = this.n;     // Catch: Exception -> L36
        if (r15 == null) goto L17;
        Integer r16 = Integer.valueOf(r15.open());     // Catch: Exception -> L36
    L18:
        if (r16 != null) goto L21;
    L22:
        if (r16 != null) goto L25;
    L27:
        r6 = false;
    L28:
        if (r6 == false) goto L30;
        System.currentTimeMillis();     // Catch: Exception -> L36
        r2.i("CameraContextImpl", "exec Camera opened successfully");     // Catch: Exception -> L36
    L40:
        return r6;
    L30:
        q3a.o r5 = this.d;     // Catch: Exception -> L36
        if (r16 == null) goto L33;
        int r8 = r16.intValue();     // Catch: Exception -> L36
    L34:
        r5.b(new i(r8, "failed_to_open_camera, result: " + r16, null));     // Catch: Exception -> L36
        r2.e("CameraContextImpl", "Failed to exec open camera, result: " + r16);     // Catch: Exception -> L36
        goto L40
    L33:
        r8 = -1;
        goto L34
    L25:
        if (r16.intValue() != (-423)) goto L27;
    L21:
        if (r16.intValue() == 0) goto L28;
    L17:
        r16 = null;
        goto L18
    L13:
        r14 = false;
        goto L14
    }

    @Override // r3a.k
    public final boolean r(boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "from");
        FLogger.a.i("CameraContextImpl", "recreateCaptureForRetry, useCamera2=" + r5 + ", from=" + r6);
        this.m = Boolean.valueOf(r5);     // Catch: Throwable -> L41
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L6
        Result.constructor-impl(Boolean.valueOf(F("recreateCaptureForRetry_" + r6)));     // Catch: Throwable -> L6
    L8:
        p3a.c r8 = this.q;     // Catch: Throwable -> L41
        r8.d = false;     // Catch: Throwable -> L41
        r8.b = false;     // Catch: Throwable -> L41
        r8.e = false;     // Catch: Throwable -> L41
        VECameraCapture r9 = this.n;     // Catch: Throwable -> L16
        if (r9 == null) goto L13;
        Integer r10 = Integer.valueOf(r9.close());     // Catch: Throwable -> L16
    L14:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L16
    L18:
        Throwable r12 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L41
        if (r12 == null) goto L44;
        FLogger.a.e("CameraContextImpl", "close old capture failed when retry", r12);     // Catch: Throwable -> L41
    L44:
        VECameraCapture r13 = this.n;     // Catch: Throwable -> L27
        if (r13 == null) goto L24;
        r13.destroy();     // Catch: Throwable -> L27
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L27
    L29:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L41
        if (r16 == null) goto L48;
        FLogger.a.e("CameraContextImpl", "destroy old capture failed when retry", r16);     // Catch: Throwable -> L41
    L48:
        B().c();     // Catch: Throwable -> L34
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L41
        if (r18 == null) goto L39;
        FLogger.a.e("CameraContextImpl", "destroy recorder failed when retry", r18);     // Catch: Throwable -> L41
    L39:
        this.n = null;     // Catch: Throwable -> L41
        this.r.set(false);     // Catch: Throwable -> L41
        return D();
    L34:
        th = move-exception;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L41
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L36
    L24:
        r14 = null;
    L27:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L41
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L29
    L13:
        r10 = null;
    L16:
        th = move-exception;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L41
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L18
    L6:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L41
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        FLogger.a.e("CameraContextImpl", "recreateCaptureForRetry failed", th);
        return false;
    }

    public final FloatBuffer G(boolean r1, boolean r2, boolean r3) {
        if (r3 == false) goto L5;
        if (r1 == false) goto L5;
        return this.L;
    L5:
        if (r3 == false) goto L8;
        if (r2 == false) goto L8;
        return this.M;
    L8:
        if (r3 == true) goto L18;
        if (r1 == true) goto L19;
        if (r2 == false) goto L15;
        return this.J;
    L15:
        return this.G;
    L19:
        return this.I;
    L18:
        return this.K;
    }

    @Override // r3a.k
    public final void e(int r2, int r3, VEDisplaySettings.VEDisplayFitMode r4) {
        Intrinsics.checkNotNullParameter(r4, "fitMode");
        if (r2 <= 0) goto L8;
        if (r3 <= 0) goto L9;
        B().b(r2, r3, r4);
        return;
    L9:
        return;
    }

    public f(Activity r2, m r3, Fragment r4, com.larus.voicecall.impl.component.vlm.camera.camera_state.e r5, q3a.o r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "cameraConfig");
        Intrinsics.checkNotNullParameter(r5, "stateManager");
        Intrinsics.checkNotNullParameter(r6, "eventDispatcher");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        Lazy r7 = LazyKt.lazy(new r3a.a(this));
        this.e = r7;
        this.f = LazyKt.lazy(new r3a.b(this));
        Lazy r8 = LazyKt.lazy(new r3a.c(this));
        this.g = r8;
        this.h = LazyKt.lazy(new d());
        if (r3.d == false) goto L5;
        int r9 = 270;
    L6:
        this.i = r9;
        this.l = new AtomicBoolean(false);
        this.q = new p3a.c();
        this.r = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        if (((Boolean) r8.getValue()).booleanValue() == true) goto L9;
    L16:
        r6.a((o) r7.getValue());
        this.F = z(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.G = z(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        this.H = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.I = z(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f});
        this.J = z(new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});
        this.K = z(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f});
        this.L = z(new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f});
        this.M = z(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        return;
    L9:
        if (this.j != null) goto L16;
        this.k = C();
        h r10 = new h(this, getActivity().getApplicationContext());
        if (r10.canDetectOrientation() == false) goto L14;
        r10.enable();
    L15:
        this.j = r10;
        goto L16
    L14:
        FLogger.a.w("CameraContextImpl", "gravity orientation listener can not detect orientation");
        goto L15
    L5:
        r9 = 90;
        goto L6
    }
}
