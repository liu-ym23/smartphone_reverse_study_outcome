package com.larus.vesdk.impl.camera;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.fragment.app.FragmentActivity;
import com.larus.avatar.impl.scan.component.ScanCameraComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.camera.ve.Ratio;
import com.larus.platform.model.camera.ve.VeCameraInputParam;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.vesdk.impl.VeSDKInitStateManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import com.ss.android.vesdk.VECameraCapture;
import com.ss.android.vesdk.VECameraSettings;
import com.ss.android.vesdk.VEFocusSettings;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESDK;
import com.ss.android.vesdk.VEShotScreenSettings;
import com.ss.android.vesdk.VESize;
import hq9.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VeCameraImpl implements pq9.j {
    public final Activity a;
    public final VeCameraInputParam b;
    public VECameraCapture c;
    public VERecorder d;
    public String e;
    public boolean f;
    public boolean g;
    public float h;
    public String i;
    public final Lazy j;
    public final com.larus.vesdk.impl.utils.b k;
    public final Handler l;
    public final CoroutineScope m;
    public pq9.b n;
    public float o;
    public float p;
    public boolean q;
    public final Lazy r;
    public final j2a.b s;
    public final Lazy t;
    public final Lazy u;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Ratio.values().length];
            r0[Ratio.RATIO_3_4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Ratio.RATIO_9_16.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Ratio.RATIO_FULL_SCREEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements VEListener.VECameraStateExtListener {
        public final /* synthetic */ VeCameraImpl a;

        public final /* synthetic */ void onInfoForTrack(int r1, int r2, String r3, long r4) {
            VEListener.VECameraStateExtListener.-CC.$default$onInfoForTrack(this, r1, r2, r3, r4);
        }

        public final void cameraOpenSuccess() {
            FLogger r0 = FLogger.a;
            r0.i("VeCameraImpl", "[initCapture] cameraOpenSuccess");
            VeCameraImpl r2 = this.a;
            VECameraCapture r3 = r2.c;
            if (r3 == null) goto L5;
            r3.setZoomListener(new b0(r2));
        L5:
            VECameraCapture r4 = r2.c;
            if (r4 == null) goto L8;
            Integer r5 = Integer.valueOf(r4.queryZoomAbility(r2.y()));
        L9:
            r0.i("VeCameraImpl", "queryZoomAbility, ret:" + r5 + ",isV2:" + r2.y());
            final VeCameraImpl r1 = this.a;
            r1.l.postDelayed(new z(r1), 100);
            pq9.b r6 = this.a.n;
            if (r6 == null) goto L13;
            r6.d(true);
            return;
        L13:
            return;
        L8:
            r5 = null;
            goto L9
        }

        public c(VeCameraImpl r1) {
            this.a = r1;
        }

        public final void cameraOpenFailed(int r4) {
            FLogger.a.e("VeCameraImpl", "[initCapture] cameraOpenFailed, cameraType:" + r4);
            pq9.b r5 = this.a.n;
            if (r5 == null) goto L6;
            r5.d(false);
            return;
        }

        public final void onError(int r4, String r5) {
            FLogger.a.e("VeCameraImpl", "[initCapture] onError, ret:" + r4 + ",msg:" + r5);
        }

        public final void onInfo(int r4, int r5, String r6) {
            FLogger.a.i("VeCameraImpl", "[initCapture] onInfo, infoType:" + r4 + ",ext:" + r5 + ",msg:" + r6);
        }
    }

    static {
    }

    public final void w() {
        this.f = false;
        com.larus.vesdk.impl.utils.f r0 = (com.larus.vesdk.impl.utils.f) this.j.getValue();
        if (r0 == null) goto L6;
        r0.b();
    L6:
        if (this.b.getAsyncCloseCapture() == false) goto L10;
        VECameraCapture r1 = this.c;
        if (r1 == null) goto L13;
        Integer r2 = Integer.valueOf(r1.close(true));
    L14:
        FLogger.a.i("VeCameraImpl", "closeCamera, ret:" + r2);
        return;
    L13:
        r2 = null;
        goto L14
    L10:
        VECameraCapture r3 = this.c;
        if (r3 == null) goto L13;
        r2 = Integer.valueOf(r3.close());
        goto L14
    }

    @Override // pq9.j
    public final void a() {
        m(Ratio.RATIO_3_4);
    }

    @Override // pq9.j
    public final boolean g() {
        VECameraCapture r0 = this.c;
        if (r0 == null) goto L5;
        VECameraSettings.CAMERA_FACING_ID r1 = r0.getCameraFacing();
    L7:
        if (r1 != VECameraSettings.CAMERA_FACING_ID.FACING_FRONT) goto L9;
        boolean r2 = true;
    L10:
        FLogger.a.i("VeCameraImpl", "isFrontCamera:" + r2);
        return r2;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // pq9.j
    public final String getFlashMode() {
        FLogger.a.i("VeCameraImpl", "getFlashMode, flashMode:" + this.i);
        return this.i;
    }

    @Override // pq9.j
    public final void i() {
        FLogger.a.i("VeCameraImpl", "prepareFinish");
        this.g = true;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.vesdk.impl.camera.d, kotlin.jvm.functions.Function0] */
    @Override // pq9.j
    public final void o() {
        FLogger.a.i("VeCameraImpl", "destroyCamera");
        this.l.removeCallbacksAndMessages(null);
        VESDK.enableRefactorRecorder(false);
        com.larus.vesdk.impl.utils.f r0 = (com.larus.vesdk.impl.utils.f) this.j.getValue();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        VECameraCapture r1 = this.c;
        if (r1 == null) goto L8;
        r1.destroy();
    L8:
        ?? r2 = new d(this);
        if (this.b.getAsyncDestroyRecorder() == false) goto L11;
        BuildersKt.launch$default(this.m, null, null, new VeCameraImpl$releaseRecorder$1(r2, null), 3, null);
    L12:
        this.c = null;
        this.d = null;
        this.n = null;
        return;
    L11:
        r2.invoke();
        goto L12
    }

    @Override // pq9.j
    public final void p() {
        VERecorder r0 = this.d;
        if (r0 == null) goto L5;
        r0.setComposerNodesWithTag(new String[0], 0, new String[0]);
    L5:
        FLogger.a.i("VeCameraImpl", "Cleared beauty effects");
    }

    @Override // pq9.j
    public final void switchCamera() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        VECameraCapture r3 = this.c;     // Catch: Throwable -> L12
        Integer r4 = null;
        if (r3 == null) goto L6;
        VECameraSettings.CAMERA_FACING_ID r5 = r3.getCameraFacing();     // Catch: Throwable -> L12
    L7:
        FLogger.a.i("VeCameraImpl", "switchCamera, currentFacing:" + r5);     // Catch: Throwable -> L12
        VECameraCapture r1 = this.c;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        r4 = Integer.valueOf(r1.switchCamera());     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        FLogger.a.e("VeCameraImpl", "switchCamera, error:" + r7);
    L18:
        if (Result.exceptionOrNull-impl(r6) == null) goto L21;
        r6 = -1;
    L21:
        FLogger.a.i("VeCameraImpl", "switchCamera, ret:" + ((Integer) r6));
        return;
    L6:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // pq9.j
    public final int t() {
        if (this.f == false) goto L8;
        VERecorder r0 = this.d;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return (int) r0.getPreviewRenderFps();
    L8:
        return -1;
    }

    @Override // pq9.j
    public final void u() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        w();     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L19;
        FLogger.a.w("VeCameraImpl", "reopen: closeCamera failed, " + r2, r2);
    L19:
        B("default");     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L21;
        FLogger.a.w("VeCameraImpl", "reopen: openCamera failed, " + r4, r4);
        return;
    L21:
        return;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final int x() {
        return ((Number) this.u.getValue()).intValue();
    }

    public final boolean y() {
        return ((Boolean) this.r.getValue()).booleanValue();
    }

    public final void z() {
        VECameraCapture r0 = new VECameraCapture();
        this.c = r0;
        r0.setCameraStateListener(new c(this));
        if (y() == false) goto L5;
        VECameraSettings.CAMERA_TYPE r1 = VECameraSettings.CAMERA_TYPE.TYPE2;
    L6:
        j2a.b r2 = this.s;
        r2.getClass();
        if (z2.a.enableCamera2() == false) goto L9;
        VECameraSettings.CAMERA_TYPE r3 = VECameraSettings.CAMERA_TYPE.TYPE2;
    L10:
        VECameraSettings.Builder r4 = new VECameraSettings.Builder().setIsUseNewCameraTypeStrategy(true).setPreviewSize(r2.c(), r2.c).setCameraAntiShake(false).setCameraVideoAntiShake(false).setEnableFallback(true).enablePreviewingFallback(true).setDefaultZoomRatio(1.0f).setCameraType(r3);
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "$this$getCameraPreviewSettings");
        if (this.b.isFrontCamera() == false) goto L13;
        VECameraSettings.CAMERA_FACING_ID r5 = VECameraSettings.CAMERA_FACING_ID.FACING_FRONT;
    L14:
        r4.setCameraFacing(r5);
        r4.setFpsRange(this.b.getFpsRange());
        Unit r6 = Unit.INSTANCE;
        VECameraSettings r7 = r4.build();
        VECameraCapture r8 = this.c;
        if (r8 == null) goto L17;
        Integer r9 = Integer.valueOf(r8.init(this.a, r7));
    L18:
        FLogger.a.i("VeCameraImpl", "[initCapture] ret:" + r9 + ", cameraType: " + r1);
        return;
    L17:
        r9 = null;
        goto L18
    L13:
        r5 = VECameraSettings.CAMERA_FACING_ID.FACING_BACK;
        goto L14
    L9:
        r3 = VECameraSettings.CAMERA_TYPE.TYPE1;
        goto L10
    L5:
        r1 = VECameraSettings.CAMERA_TYPE.TYPE1;
        goto L6
    }

    @Override // pq9.j
    public final boolean c() {
        return y();
    }

    public static final void v(final VeCameraImpl r2) {
        r2.f = false;
        com.larus.vesdk.impl.utils.f r0 = (com.larus.vesdk.impl.utils.f) r2.j.getValue();
        if (r0 == null) goto L6;
        r0.b();
    L6:
        if (r2.b.getAsyncStopPreview() == false) goto L10;
        VERecorder r1 = r2.d;
        if (r1 == null) goto L15;
        r1.stopPreviewAsync(new i(r2));
        return;
    L15:
        return;
    L10:
        VERecorder r3 = r2.d;
        if (r3 == null) goto L13;
        r3.stopPreview();
    L13:
        FLogger.a.i("VeCameraImpl", "stopPreview done");
    }

    public final void B(String r5) {
        VECameraCapture r0 = this.c;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.open());
    L6:
        this.o = 1.0f;
        FLogger.a.i("VeCameraImpl", "openCamera, from:" + r5 + ",ret:" + r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void F(Surface r3) {
        if (r3.isValid() == true) goto L5;
        return;
    L5:
        VERecorder r0 = this.d;
        if (r0 == null) goto L8;
        r0.startPreviewAsync(r3, new m(this));
    L8:
        VERecorder r1 = this.d;
        if (r1 == null) goto L12;
        r1.changeSurface(r3);
        return;
    }

    public final void G(final boolean r3) {
        if (this.g == false) goto L6;
        FLogger.a.e("VeCameraImpl", "switchTorch, isFinishing");
        return;
    L6:
        t0.e(new g(this, r3));
    }

    @Override // pq9.j
    public final void b(pq9.f r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(this.m, null, null, new VeCameraImpl$stopRecord$1(this, r8, null), 3, null);
    }

    @Override // pq9.j
    public final void d(float r8) {
        FLogger r0 = FLogger.a;
        r0.i("VeCameraImpl", "zoom, ratio:" + r8 + ", maxZoomValue:" + this.h);
        Integer r3 = null;
        float r4 = 1.0f;
        if (y() == false) goto L11;
        float r1 = 1;
        float r2 = r1 + ((this.h - r1) * RangesKt.coerceIn(r8, 0.0f, 1.0f));
        float r9 = r2 / this.o;
        VECameraCapture r5 = this.c;
        if (r5 == null) goto L7;
        r3 = Integer.valueOf(r5.zoomV2(r9));
    L7:
        r0.i("VeCameraImpl", "[zoomV2] zoomByDistanceInCamera2, ret:" + r3 + ", last:" + this.o + ", current:" + r2);
        this.o = r2;
        pq9.b r10 = this.n;
        if (r10 == null) goto L27;
        r10.c(x(), r2);
        return;
    L27:
        return;
    L11:
        float r6 = this.h;
        float r11 = r8 * r6;
        if (r11 < 1.0f) goto L16;
        r4 = r11;
    L16:
        if (r4 > r6) goto L19;
        r6 = r4;
    L19:
        VECameraCapture r12 = this.c;
        if (r12 == null) goto L22;
        r3 = Integer.valueOf(r12.startZoom(r6));
    L22:
        this.p = r6;
        pq9.b r13 = this.n;
        if (r13 == null) goto L25;
        r13.c(x(), (float) Math.floor(r6));
    L25:
        r0.i("VeCameraImpl", "[zoomV1] zoom finish, ret:" + r3 + ", zoomValue:" + r6);
    }

    @Override // pq9.j
    public final void f(CameraCaptureViewModel.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        com.larus.vesdk.impl.utils.f r0 = (com.larus.vesdk.impl.utils.f) this.j.getValue();
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // pq9.j
    public final void h(float r12) {
        FLogger r0 = FLogger.a;
        r0.i("VeCameraImpl", "zoomByValue, maxZoomValue:" + this.h + ", zoomValue=" + r12 + ", enableZoomAnimation:" + this.b.getEnableZoomAnimation());
        Integer r7 = null;
        if (y() == false) goto L23;
        if (this.b.getEnableZoomAnimation() == false) goto L15;
        float r1 = this.o;
        if (r1 != r12) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == false) goto L14;
        pq9.b r2 = this.n;
        if (r2 == null) goto L41;
        r2.c(x(), r12);
        return;
    L41:
        return;
    L14:
        r0.i("VeCameraImpl", "[zoomV2] animateZoomRatioToCamera2, start:" + r1 + ", target:" + r12);
        this.q = true;
        final ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{r1, r12});
        r3.setDuration(200);
        r3.addUpdateListener(new u(this));
        r3.addListener(new w(this, r12));
        t0.e(new v(r3));
        return;
    L9:
        r8 = false;
        goto L10
    L15:
        float r4 = r12 / this.o;
        VECameraCapture r5 = this.c;
        if (r5 == null) goto L18;
        r7 = Integer.valueOf(r5.zoomV2(r4));
    L18:
        r0.i("VeCameraImpl", "[zoomV2] zoomByRatioInCamera2, ret:" + r7 + ", last:" + this.o + ", current:" + r12);
        this.o = r12;
        pq9.b r6 = this.n;
        if (r6 == null) goto L44;
        r6.c(x(), r12);
        return;
    L44:
        return;
    L23:
        if (this.b.getEnableZoomAnimation() == false) goto L33;
        float r9 = this.p;
        if (r9 != r12) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L32;
        pq9.b r11 = this.n;
        if (r11 == null) goto L45;
        r11.c(x(), (float) Math.floor(r12));
        return;
    L45:
        return;
    L32:
        r0.i("VeCameraImpl", "[zoomV2] animateZoomRatioToCamera1, start:" + r9 + ", target:" + r12);
        this.q = true;
        final ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{r9, r12});
        r13.setDuration(200);
        r13.addUpdateListener(new s(this));
        r13.addListener(new x(this, r12));
        t0.e(new t(r13));
        return;
    L27:
        r10 = false;
        goto L28
    L33:
        VECameraCapture r14 = this.c;
        if (r14 == null) goto L36;
        r7 = Integer.valueOf(r14.startZoom(r12));
    L36:
        pq9.b r15 = this.n;
        if (r15 == null) goto L39;
        r15.c(x(), (float) Math.floor(r12));
    L39:
        r0.i("VeCameraImpl", "[zoomV1] zoomByValue finish, ret:" + r7);
    }

    @Override // pq9.j
    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "flashMode");
        FLogger.a.i("VeCameraImpl", "setFlashMode, flashMode:" + r4);
        this.i = r4;
        G(Intrinsics.areEqual(r4, "FLASH_MODE_TORCH"));
    }

    @Override // pq9.j
    public final boolean l(String r3) {
        Intrinsics.checkNotNullParameter(r3, "panelName");
        DownloadableModelConfig.ModelFileEnv r1 = com.larus.vesdk.impl.effectplatform.f.a;
        Intrinsics.checkNotNullParameter(r3, "panelName");
        ConcurrentHashMap r4 = (ConcurrentHashMap) com.larus.vesdk.impl.effectplatform.f.d.get(r3);
        if (r4 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r4.isEmpty()) != true) goto L7;
        return true;
    }

    @Override // pq9.j
    public final void m(final Ratio r4) {
        Intrinsics.checkNotNullParameter(r4, "ratio");
        final long r0 = System.currentTimeMillis();
        E(new h(r0, r4), false, false);
    }

    @Override // pq9.j
    public final void n(ScanCameraComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        Pair<Integer, Integer> r0 = this.s.b();
        VESize r1 = new VESize(((Number) r0.getFirst()).intValue(), ((Number) r0.getSecond()).intValue());
        BuildersKt.launch$default(this.m, null, null, new VeCameraImpl$getPreviewFrame$1(this, r1, r10, null), 3, null);
    }

    public VeCameraImpl(FragmentActivity r3, VeCameraInputParam r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "param");
        this.a = r3;
        this.b = r4;
        this.h = 1.0f;
        this.i = r4.getFlashMode();
        this.j = LazyKt.lazy(new n(this));
        this.k = new com.larus.vesdk.impl.utils.b(r3);
        this.l = new Handler(Looper.getMainLooper());
        this.m = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.o = 1.0f;
        this.p = 1.0f;
        this.r = LazyKt.lazy(new o());
        this.s = new j2a.b(r4.getPreviewRatio());
        this.t = LazyKt.lazy(new p());
        this.u = LazyKt.lazy(new q(this));
    }

    public final void A(CameraCaptureViewModel.d r7, Boolean r8) {
        pq9.k.a.getClass();
        VERecorder r0 = new VERecorder(pq9.k.g, this.a);
        this.d = r0;
        Integer r1 = Integer.valueOf(r0.init(this.c, this.s.e(), this.s.d(), this.s.a()));
        VERecorder r2 = this.d;
        if (r2 == null) goto L5;
        r2.addRecorderStateListener(new a0(this));
    L5:
        if (r7 == null) goto L9;
        Pair<Integer, Integer> r3 = this.s.b();
        int r4 = com.larus.vesdk.impl.utils.c.c;
        VERecorder r5 = this.d;
        VESize r6 = new VESize(((Number) r3.getFirst()).intValue(), ((Number) r3.getSecond()).intValue());
        Intrinsics.checkNotNullParameter(r6, "scanSize");
        FLogger.a.i("VeBashScanner", "start");
        if (r5 == null) goto L9;
        com.larus.vesdk.impl.utils.c r9 = new com.larus.vesdk.impl.utils.c(r5, r7, r6);
        eic.b r10 = r5.getRecordScanControl();
        aic.a r11 = new aic.a();
        r11.a = true;
        r11.b = r6;
        eic.b r12 = r10;
        r12.e = r11;
        r12.a(r9.b);
        r12.b(new com.larus.vesdk.impl.utils.d(r9));
    L9:
        if (r8 == null) goto L13;
        boolean r13 = r8.booleanValue();
        VERecorder r14 = this.d;
        if (r14 == null) goto L13;
        r14.enableEffect(r13);
    L13:
        FLogger.a.i("VeCameraImpl", "[initRecorder] ret:" + r1);
    }

    @Override // pq9.j
    public final void e(int r11, CameraCaptureViewModel.a r12) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        FLogger.a.i("VeCameraImpl", "takePicture, orientation:" + r11 + ", flashMode:" + this.i);
        String r1 = this.i;
        if (Intrinsics.areEqual(r1, "FLASH_MODE_ON") == false) goto L6;
        G(true);
        E(new f(this, r12, r11), true, false);
        return;
    L6:
        if (Intrinsics.areEqual(r1, "FLASH_MODE_AUTO") == false) goto L10;
        final i0 r2 = new i0(System.currentTimeMillis(), this, r11, r12);
        Intrinsics.checkNotNullParameter(r2, "callback");
        final com.larus.vesdk.impl.utils.f r13 = (com.larus.vesdk.impl.utils.f) this.j.getValue();
        if (r13 == null) goto L13;
        Intrinsics.checkNotNullParameter(r2, "callback");
        r13.a(r2);
        r13.d.postDelayed(new com.larus.vesdk.impl.utils.e(r13, r2), 500);
        return;
    L13:
        return;
    L10:
        E(new f(this, r12, r11), false, false);
    }

    @Override // pq9.j
    public final void s(String r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "panelName");
        Intrinsics.checkNotNullParameter(r19, "categoryKey");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L46
        DownloadableModelConfig.ModelFileEnv r7 = com.larus.vesdk.impl.effectplatform.f.a;     // Catch: Throwable -> L46
        List r8 = com.larus.vesdk.impl.effectplatform.f.b.a(r18, r19);     // Catch: Throwable -> L46
        if (r8.isEmpty() == false) goto L7;
        FLogger.a.w("VeCameraImpl", "No effect found for categoryKey: " + r19 + ", fallback to clear");     // Catch: Throwable -> L46
        p();     // Catch: Throwable -> L46
        return;
    L7:
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L46
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L46
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L46
        Iterator r11 = r8.iterator();     // Catch: Throwable -> L46
    L9:
        if (r11.hasNext() == false) goto L33;
        com.larus.platform.api.t r12 = (com.larus.platform.api.t) r11.next();     // Catch: Throwable -> L46
        List r13 = r12.c;     // Catch: Throwable -> L46
        if (r13 == null) goto L9;
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L46
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L46
    L15:
        if (r15.hasNext() == false) goto L19;
        String r16 = ((com.larus.platform.api.r) r15.next()).e();     // Catch: Throwable -> L46
        if (r16 == null) goto L15;
        r14.add(r16);     // Catch: Throwable -> L46
        goto L15
    L19:
        List r17 = r13;     // Catch: Throwable -> L46
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));     // Catch: Throwable -> L46
        Iterator r111 = r17.iterator();     // Catch: Throwable -> L46
    L21:
        if (r111.hasNext() == false) goto L27;
        com.larus.platform.api.r r112 = (com.larus.platform.api.r) r111.next();     // Catch: Throwable -> L46
        float r113 = 0.0f;
        if (r112.b() <= 0.0f) goto L25;
        r113 = r112.f() / r112.b();     // Catch: Throwable -> L46
    L25:
        r110.add(Float.valueOf(r113));     // Catch: Throwable -> L46
        goto L21
    L27:
        if (r14.size() != r110.size()) goto L9;
        int r114 = r14.size();     // Catch: Throwable -> L46
        int r115 = 0;
    L29:
        if (r115 >= r114) goto L31;
        r5.add(r12.a);     // Catch: Throwable -> L46
        r115 = r115 + 1;     // Catch: Throwable -> L46
        goto L29
    L31:
        r9.addAll(r14);     // Catch: Throwable -> L46
        r10.addAll(r110);     // Catch: Throwable -> L46
        goto L9
    L33:
        if ((!r5.isEmpty()) == false) goto L40;
        String[] r116 = (String[]) r5.toArray(new String[0]);     // Catch: Throwable -> L46
        String[] r20 = (String[]) r9.toArray(new String[0]);     // Catch: Throwable -> L46
        float[] r21 = CollectionsKt.toFloatArray(r10);     // Catch: Throwable -> L46
        VERecorder r22 = this.d;     // Catch: Throwable -> L46
        if (r22 == null) goto L37;
        r22.setComposerNodesWithTag(r116, r5.size(), r20);     // Catch: Throwable -> L46
    L37:
        VERecorder r23 = this.d;     // Catch: Throwable -> L46
        if (r23 == null) goto L40;
        r23.updateMultiComposerNodes(r5.size(), r116, r20, r21);     // Catch: Throwable -> L46
    L40:
        FLogger.a.i("VeCameraImpl", "Applied beauty by categoryKey: " + r19 + " with " + r8.size() + " effects");     // Catch: Throwable -> L46
        Iterator r24 = r8.iterator();     // Catch: Throwable -> L46
    L42:
        if (r24.hasNext() == false) goto L44;
        com.larus.platform.api.t r25 = (com.larus.platform.api.t) r24.next();     // Catch: Throwable -> L46
        FLogger.a.i("VeCameraImpl", "Applied beauty by categoryKey: " + r19 + " with " + r25);     // Catch: Throwable -> L46
        goto L42
    L44:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L48:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L71;
        FLogger.a.e("VeCameraImpl", "[applyComposerByPanel] failed, " + r1);
        return;
    L71:
        return;
    L46:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    }

    public static final void C(final VeCameraImpl r1, final Ref.BooleanRef r2, final SurfaceHolder r3) {
        if (((j0) r1.t.getValue()).b() == false) goto L6;
        t0.d(new l(r1, r3, r2), ((j0) r1.t.getValue()).e());
        return;
    L6:
        D(r2, r1, r3);
    }

    public static final void D(Ref.BooleanRef r1, VeCameraImpl r2, SurfaceHolder r3) {
        if (r1.element == false) goto L5;
        return;
    L5:
        if (r2.g == false) goto L7;
        return;
    L7:
        if (r3.getSurface().isValid() == false) goto L16;
        r1.element = true;
        pq9.b r4 = r2.n;
        if (r4 == null) goto L12;
        r4.surfaceCreated(r3);
    L12:
        r2.B("surfaceCreated");
        r2.F(r3.getSurface());
        return;
    }

    public final void E(VERecorder.IBitmapShotScreenCallback r7, boolean r8, boolean r9) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Pair<Integer, Integer> r4 = this.s.b();     // Catch: Throwable -> L9
        VESize r5 = new VESize(((Number) r4.getFirst()).intValue(), ((Number) r4.getSecond()).intValue());     // Catch: Throwable -> L9
        FLogger.a.d("VeCameraImpl", "shotScreen, TargetResolution: width-" + r5.width + ", height-" + r5.height);     // Catch: Throwable -> L9
        VEShotScreenSettings r10 = new VEShotScreenSettings.Builder().setTargetResolution(r5).setIsTakePicture(true).setFormat(Bitmap.CompressFormat.JPEG).setEnableUpscaleShot(true).setShotScreenInHD(true).setNeedPreviewAfterShotScreen(true).setNeedDelay(r8).setNeedEffect(r9).setBitmapCallback(r7).build();     // Catch: Throwable -> L9
        VERecorder r11 = this.d;     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        r11.shotScreen(r10);     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L17;
        FLogger.a.e("VeCameraImpl", "[shotScreen] " + r14);
        r7.onShotScreen(null, -1);
        return;
    L17:
        return;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // pq9.j
    public final void k(boolean r11, pq9.g r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(this.m, null, null, new VeCameraImpl$startRecord$1(this, r11, r13, r12, null), 3, null);
    }

    @Override // pq9.j
    public final void r(int r8, int r9, int r10) {
        Resources r0 = AppHost.a.getApplication().getApplicationContext().getResources();
        VEFocusSettings r1 = new VEFocusSettings(r8, r9, r10, r10, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
        VEFocusSettings.access$502(r1, new r());
        VECameraCapture r11 = this.c;
        if (r11 == null) goto L5;
        Integer r12 = Integer.valueOf(r11.focusAtPoint(r1));
    L6:
        FLogger.a.i("VeCameraImpl", "focusAtPoint finish, ret:" + r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // pq9.j
    public final void q(final SurfaceHolder r19, int r20, CameraCaptureViewModel.d r21, pq9.b r22, Boolean r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r19, "surfaceHolder");
        FLogger r0 = FLogger.a;
        r0.i("VeCameraImpl", "open, model:" + Build.MODEL + ",param:" + this.b + ",isFinishing:" + this.g + ", enableEffect" + r23 + ", recorder:" + this.b.getEnableRecorder());
        if (this.g == true) goto L71;
        this.n = r22;
        z2 r5 = z2.a;
        if (r5.cameraInitOptConfig().c() == false) goto L45;
        r0.i("VeCameraImpl", "open: camera init optimization enabled, waiting for VESDK init");
        long r10 = System.currentTimeMillis();
        long r12 = r5.cameraInitOptConfig().a();
        boolean r6 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        if (r6 == false) goto L10;
        long r14 = 0;
    L11:
        int r7 = com.larus.vesdk.impl.e.a;
        VeSDKInitStateManager.a.getClass();
        AtomicReference<VeSDKInitStateManager.InitState> r8 = VeSDKInitStateManager.c;
        VeSDKInitStateManager.InitState r9 = r8.get();
        VeSDKInitStateManager.InitState r11 = VeSDKInitStateManager.InitState.INITIALIZED;
        if (r9 != r11) goto L14;
        r0.i("VeSDKInitStateManager", "waitForInit: already initialized");
        boolean r2 = true;
    L31:
        long r3 = System.currentTimeMillis() - r10;
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L38
        r13.put("wait_duration", r3);     // Catch: Exception -> L38
        if (r2 == false) goto L35;
        int r4 = 1;
    L36:
        r13.put("success", r4);     // Catch: Exception -> L38
        r13.put("timeout_ms", r12);     // Catch: Exception -> L38
        com.larus.platform.service.o.a.reportEvent("camera_open_wait_duration", r13);     // Catch: Exception -> L38
        r0.i("VeCameraImpl", "reportCameraOpenWaitDuration: " + r13);     // Catch: Exception -> L38
    L40:
        if (r2 == true) goto L43;
        if (r6 == true) goto L43;
        FLogger.a.e("VeCameraImpl", "open: wait for VESDK init failed or timeout, fallback to sync init");
    L43:
        if (r2 == true) goto L45;
        FLogger.a.e("VeCameraImpl", "open: skip blocking wait for VESDK init on main thread, fallback to sync init");
        goto L45
    L35:
        r4 = 0;
    L38:
        e = move-exception;
        FLogger.a.e("VeCameraImpl", "reportCameraOpenWaitDuration failed", e);
        goto L40
    L14:
        VeSDKInitStateManager.InitState r15 = r8.get();
        if (r15 != VeSDKInitStateManager.InitState.UNINITIALIZED) goto L17;
    L20:
        boolean r16 = true;
    L21:
        if (r16 == false) goto L23;
        r0.w("VeSDKInitStateManager", "waitForInit: not started yet, state=" + r9);
    L26:
        r2 = false;
        goto L31
    L23:
        r0.i("VeSDKInitStateManager", "waitForInit: waiting for initialization, timeout=" + r14 + "ms");
        boolean r17 = VeSDKInitStateManager.d.await(r14, TimeUnit.MILLISECONDS);
        VeSDKInitStateManager.InitState r18 = r8.get();
        if (r17 == true) goto L27;
        r0.e("VeSDKInitStateManager", "waitForInit: timeout after " + r14 + "ms, state=" + r18);
        goto L26
    L27:
        if (r18 != r11) goto L29;
        r2 = true;
    L30:
        r0.i("VeSDKInitStateManager", "waitForInit: completed, success=" + r2 + ", state=" + r18);
        goto L31
    L29:
        r2 = false;
        goto L30
    L17:
        if (r15 == VeSDKInitStateManager.InitState.TIMEOUT) goto L20;
        r16 = false;
        goto L21
    L10:
        r14 = r12;
    L45:
        int r1 = com.larus.vesdk.impl.e.a;
        com.larus.vesdk.impl.e.a(Integer.valueOf(r20));
        FLogger.a.i("VeCameraImpl", "[open] vesdk init completed");
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L57
        VESDK.enableRefactorRecorder(true);     // Catch: Throwable -> L57
        VESDK.enableNewRecorder(true);     // Catch: Throwable -> L57
        if (this.b.getEnableRecorder() == false) goto L49;
        VESDK.enableAudioCapture(true);     // Catch: Throwable -> L57
    L49:
        z();     // Catch: Throwable -> L57
        A(r21, r23);     // Catch: Throwable -> L57
        if (r24 == true) goto L52;
        r19.addCallback(new e0(this));     // Catch: Throwable -> L57
    L55:
        B("default");     // Catch: Throwable -> L57
        int r26 = VeCameraDiskCleaner.a;     // Catch: Throwable -> L57
        VeCameraDiskCleaner.b();     // Catch: Throwable -> L57
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L69;
        FLogger.a.e("VeCameraImpl", "[open] failed, " + r28);
        if (r22 == null) goto L70;
        r28.getMessage();
        r22.d(false);
        return;
    L70:
        return;
    L69:
        return;
    L52:
        final Ref.BooleanRef r29 = new Ref.BooleanRef();     // Catch: Throwable -> L57
        r19.addCallback(new c0(this, r29));     // Catch: Throwable -> L57
        if (r24 == false) goto L55;
        t0.a.post(new e(r19, this, r29));     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L59
    }
}
