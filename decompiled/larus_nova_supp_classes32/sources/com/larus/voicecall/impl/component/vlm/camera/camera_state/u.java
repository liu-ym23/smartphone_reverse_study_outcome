package com.larus.voicecall.impl.component.vlm.camera.camera_state;

import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Display;
import android.view.WindowManager;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o3;
import com.larus.utils.logger.FLogger;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.vesdk.VEAudioEncodeSettings;
import com.ss.android.vesdk.VECameraCapture;
import com.ss.android.vesdk.VECommonCallback;
import com.ss.android.vesdk.VEDisplaySettings;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VEPreviewSettings;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESDK;
import com.ss.android.vesdk.VESize;
import com.ss.android.vesdk.VEVideoEncodeSettings;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public final r3a.k a;
    public VERecorder b;
    public long c;
    public long d;
    public final AtomicBoolean e;
    public VESize f;
    public final Lazy g;
    public VEDisplaySettings.VEDisplayFitMode h;
    public DisplayManager i;
    public c j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b implements VECommonCallback {
        public final /* synthetic */ u a;
        public final /* synthetic */ VECameraCapture b;

        public final /* synthetic */ void onCallBackForTrack(int r1, int r2, float r3, long r4) {
            VECommonCallback.-CC.$default$onCallBackForTrack(this, r1, r2, r3, r4);
        }

        public b(u r1, VECameraCapture r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onCallback(int r12, int r13, float r14, String r15) {
            if (r12 != 1004) goto L5;
        L9:
            int r0 = VEInfo.TE_INFO_PREVIEW_RENDER_FPS;
            if (r12 == r0) goto L12;
        L14:
            if (r12 != r0) goto L19;
            long r6 = SystemClock.elapsedRealtime();
            u r1 = this.a;
            if ((r6 - r1.d) <= 2000) goto L19;
            r1.d = SystemClock.elapsedRealtime();
            FLogger.a.i("RealtimeCameraRecorder", "onCallback, type: " + r12 + ", ext: " + r13 + ", f: " + r14 + ", msg: " + r15);
        L19:
            if (r12 != 1000) goto L21;
            FLogger.a.i("RealtimeCameraRecorder", "Recorder render environment created successfully");
            VERecorder r16 = this.a.b;
            if (r16 == null) goto L29;
            r16.startCameraPreview(this.b);
            return;
        L29:
            return;
        L21:
            if (r12 != 1001) goto L30;
            this.a.a.h();
            FLogger.a.i("RealtimeCameraRecorder", "Recorder render environment destroyed successfully");
            return;
        L30:
            return;
        L12:
            if (AppHost.a.isDebug() == false) goto L14;
            FLogger.a.i("RealtimeCameraRecorder", "onCallback, type: " + r12 + ", ext: " + r13 + ", f: " + r14 + ", msg: " + r15);
            goto L14
        L5:
            if (r12 == 1005) goto L9;
            if (r12 == VEInfo.TE_INFO_PREVIEW_RENDER_FPS) goto L9;
            FLogger.a.i("RealtimeCameraRecorder", "onCallback, type: " + r12 + ", ext: " + r13 + ", f: " + r14 + ", msg: " + r15);
            goto L9
        }
    }

    public static final class c implements DisplayManager.DisplayListener {
        public final /* synthetic */ u a;
        public final /* synthetic */ VECameraCapture b;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int r4) {
            DisplayManager r0 = this.a.i;
            if (r0 != null) goto L5;
            return;
        L5:
            Display r5 = r0.getDisplay(r4);
            if (r5 != null) goto L9;
            return;
        L9:
            if (((Boolean) this.a.k.getValue()).booleanValue() == false) goto L14;
            if (StringsKt.equals(Build.MANUFACTURER, "xiaomi", true) == true) goto L14;
            this.b.setDeviceRotation(r5.getRotation() * 90);
            return;
        L14:
            if (r5.getRotation() != 2) goto L16;
        L19:
            this.b.setDeviceRotation(r5.getRotation() * 90);
            return;
        L16:
            if (r5.getRotation() == 0) goto L19;
            this.b.setDeviceRotation(0);
        }

        public c(u r1, VECameraCapture r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements VERecorder.OnFrameAvailableListenerExt {
        public final /* synthetic */ u a;
        public final /* synthetic */ VERecorder.OnFrameAvailableListenerExt.Config b;

        public final VERecorder.OnFrameAvailableListenerExt.Config config() {
            return this.b;
        }

        public final void OnFrameAvailable(VEFrame r8) {
            long r0 = SystemClock.elapsedRealtime();
            u r2 = this.a;
            if ((r0 - r2.c) <= 5000) goto L24;
            r2.c = SystemClock.elapsedRealtime();
            FLogger r1 = FLogger.a;
            StringBuilder r3 = new StringBuilder("OnFrameAvailable, frame_info width=");
            float[] r4 = null;
            if (r8 == null) goto L7;
            Integer r5 = Integer.valueOf(r8.getWidth());
        L8:
            r3.append(r5);
            r3.append(" height=");
            if (r8 == null) goto L11;
            Integer r6 = Integer.valueOf(r8.getHeight());
        L12:
            r3.append(r6);
            r3.append(" rotation=");
            if (r8 == null) goto L15;
            Integer r7 = Integer.valueOf(r8.getRotation());
        L16:
            r3.append(r7);
            r3.append(" format=");
            if (r8 == null) goto L19;
            VEFrame.ETEPixelFormat r9 = r8.getFormat();
        L20:
            r3.append(r9);
            r3.append(" textureTransformMatrix=");
            if (r8 == null) goto L23;
            r4 = r8.getTextureTransformMatrix();
        L23:
            r3.append(Arrays.toString(r4));
            r1.i("RealtimeCameraRecorder", r3.toString());
            goto L24
        L19:
            r9 = null;
            goto L20
        L15:
            r7 = null;
            goto L16
        L11:
            r6 = null;
            goto L12
        L7:
            r5 = null;
        L24:
            if (r8 != null) goto L27;
            FLogger.a.e("RealtimeCameraRecorder", "OnFrameAvailable, frame is null");
            return;
        L27:
            this.a.a.l(r8);
        }

        public d(u r1, VERecorder.OnFrameAvailableListenerExt.Config r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void c() {
        c r0 = this.j;
        if (r0 == null) goto L7;
        DisplayManager r1 = this.i;
        if (r1 == null) goto L7;
        r1.unregisterDisplayListener(r0);
    L7:
        this.j = null;
        this.i = null;
        VERecorder r2 = this.b;
        if (r2 == null) goto L10;
        r2.onDestroy();
    L10:
        this.b = null;
        this.e.set(false);
    }

    public u(r3a.f r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r2;
        this.e = new AtomicBoolean(false);
        this.g = LazyKt.lazy(new r());
        this.k = LazyKt.lazy(new s());
    }

    public final void d(VECameraCapture r10) {
        if (r10 != null) goto L7;
        FLogger.a.e("RealtimeCameraRecorder", "capture is null");
        return;
    L7:
        if (this.e.get() == false) goto L10;
        FLogger.a.e("RealtimeCameraRecorder", "init isInitialized. return directed");
        return;
    L10:
        this.e.set(true);
        o3.b.c();
        VESDK.enableRefactorRecorder(true);
        VESDK.enableNewRecorder(true);
        WindowManager r1 = this.a.getActivity().getWindowManager();
        int r3 = r1.getDefaultDisplay().getWidth();
        int r2 = r1.getDefaultDisplay().getHeight();
        VESize r4 = this.f;
        if (r4 != null) goto L13;
        r4 = new VESize(r3, r2);
    L13:
        Integer r5 = null;
        this.f = null;
        VEPreviewSettings r6 = new VEPreviewSettings.Builder().setRenderSize(r4).blockRenderExit(true).enableCheckStatusWhenStopPreview(true).setDisplaySettings(a(null, r4, this.h)).build();
        this.h = null;
        VEVideoEncodeSettings r7 = new VEVideoEncodeSettings.Builder(1).setVideoRes(this.a.g().a, this.a.g().b).build();
        VEAudioEncodeSettings r8 = new VEAudioEncodeSettings.Builder().Build();
        VERecorder.OnFrameAvailableListenerExt.Config r9 = new VERecorder.OnFrameAvailableListenerExt.Config();
        r9.a = this.a.g().a;
        r9.b = this.a.g().b;
        r9.c = VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_RGBA8;
        r9.d = VERecorder.OnFrameAvailableListenerExt.Config.ReqFrameStage.REQUEST_FRAME_STAGE_CAMERA_INPUT;
        if (this.b != null) goto L16;
        pq9.k.a.getClass();
        this.b = new VERecorder(pq9.k.g, this.a.getActivity());
    L16:
        VERecorder r11 = this.b;
        if (r11 == null) goto L19;
        r11.addCommonCallback(new b(this, r10));
    L19:
        VERecorder r12 = this.b;
        if (r12 == null) goto L41;
        r5 = Integer.valueOf(r12.init(null, r7, r8, r6));
    L41:
        VERecorder r13 = this.b;     // Catch: Exception -> L26
        if (r13 == null) goto L28;
        r13.enableEffect(false);     // Catch: Exception -> L26
    L28:
        Object r14 = this.a.getActivity().getSystemService("display");
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager r15 = (DisplayManager) r14;
        this.i = r15;
        c r16 = new c(this, r10);
        this.j = r16;
        if (r15 == null) goto L31;
        r15.registerDisplayListener(r16, new Handler(Looper.getMainLooper()));
    L31:
        VERecorder r17 = this.b;
        if (r17 == null) goto L34;
        r17.setOnFrameAvailableListenerExt(new d(this, r9));
    L34:
        if (r5 != null) goto L37;
    L39:
        FLogger.a.e("RealtimeCameraRecorder", "init recorder failed, result: " + r5);
        return;
    L37:
        if (r5.intValue() != 0) goto L39;
        FLogger.a.i("RealtimeCameraRecorder", "init recorder success");
        return;
    L26:
        e = move-exception;
        FLogger.a.e("RealtimeCameraRecorder", "recorder set enableEffect failed", e);
        goto L28
    }

    public static VEDisplaySettings a(VEDisplaySettings r1, VESize r2, VEDisplaySettings.VEDisplayFitMode r3) {
        if (r1 != null) goto L5;
        r1 = new VEDisplaySettings.Builder().build();
    L5:
        VEDisplaySettings.Builder r4 = new VEDisplaySettings.Builder(r1).setRenderSize(r2).setDisplayLayoutSize(r2).setCanvasSize(r2).setForceAdaptSurfaceSize(true);
        if (r3 == null) goto L9;
        r4.setFitMode(r3);
    L9:
        return r4.build();
    }

    public final void b(int r9, int r10, VEDisplaySettings.VEDisplayFitMode r11) {
        Intrinsics.checkNotNullParameter(r11, "fitMode");
        VESize r0 = new VESize(r9, r10);
        VERecorder r1 = this.b;
        if (r1 == null) goto L11;
        VEDisplaySettings r2 = r1.getDisplaySettings();
        if (r2 == null) goto L11;
        VERecorder r6 = this.b;
        if (r6 == null) goto L9;
        Integer r3 = Integer.valueOf(r6.setDisplaySettings(a(r2, r0, r11)));
    L10:
        FLogger.a.i("RealtimeCameraRecorder", "changePreviewSize, width: " + r9 + ", height: " + r10 + ", fitMode=" + r11 + " isRecorderInit=" + this.e.get() + " result: " + r3);
        return;
    L9:
        r3 = null;
    L11:
        this.f = r0;
        this.h = r11;
        FLogger.a.i("RealtimeCameraRecorder", "changePreviewSize pending, width: " + r9 + ", height: " + r10 + ", fitMode=" + r11 + " isRecorderInit=" + this.e.get());
    }
}
