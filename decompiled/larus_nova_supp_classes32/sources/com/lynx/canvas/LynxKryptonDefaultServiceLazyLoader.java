package com.lynx.canvas;

import android.content.Context;
import com.lynx.canvas.camera.KryptonDefaultCamera;
import com.lynx.canvas.hardware.KryptonDefaultSensorService;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.lynx.canvas.telemetry.KryptonTelemetryService;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import i8a.h;
import i8a.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class LynxKryptonDefaultServiceLazyLoader extends KryptonServiceLazyLoader {
    private static final String TAG = "LynxKryptonDefaultServiceLazyLoader";
    private static String mEnableUsingGenericFetcherInCanvasKey = "lynx_canvas_enable_using_generic_fetcher";
    private final Context mApplicationContext;
    private KryptonLoaderService mCurrentLoaderService;
    private final WeakReference<LynxContext> mLynxContext;
    private String mTemporaryDirectory;

    private KryptonDefaultMediaRecorder.Delegate createMediaRecorderDelegate() {
        return new AnonymousClass3(this);
    }

    public boolean usingGenericFetcherInCanvas() {
        LynxContext r0 = this.mLynxContext.get();
        if (LynxSettingsUtils.booleanValueForKey(mEnableUsingGenericFetcherInCanvasKey, false) == true) goto L5;
        return false;
    L5:
        if (r0.getGenericResourceFetcher() != null) goto L7;
        return false;
    L7:
        if (r0.getMediaResourceFetcher() == null) goto L12;
        return true;
    L12:
        return false;
    }

    public static /* synthetic */ KryptonDefaultCamera.Invoker access$100() {
        return createCameraInvoker();
    }

    public static /* synthetic */ KryptonDefaultMediaRecorder.Invoker access$300() {
        return createMediaRecorderInvoker();
    }

    private static KryptonDefaultCamera.Invoker createCameraInvoker() {
        final h r0 = getSystemInvokeService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass5(r0);
    }

    private static KryptonDefaultMediaRecorder.Invoker createMediaRecorderInvoker() {
        final h r0 = getSystemInvokeService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass4(r0);
    }

    private static KryptonDefaultSensorService.Invoker createSensorInvoker() {
        final h r0 = getSystemInvokeService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass6(r0);
    }

    private static h getSystemInvokeService() {
        return (h) n.c().a(h.class);
    }

    public LynxKryptonDefaultServiceLazyLoader(LynxContext r2) {
        this.mLynxContext = new WeakReference(r2);
        this.mApplicationContext = r2.getApplicationContext();
    }

    public static /* synthetic */ Context access$000(LynxKryptonDefaultServiceLazyLoader r0) {
        return r0.mApplicationContext;
    }

    public static /* synthetic */ KryptonDefaultMediaRecorder.Delegate access$200(LynxKryptonDefaultServiceLazyLoader r0) {
        return r0.createMediaRecorderDelegate();
    }

    public static /* synthetic */ String access$400(LynxKryptonDefaultServiceLazyLoader r0) {
        return r0.mTemporaryDirectory;
    }

    @Override // com.lynx.canvas.KryptonServiceLazyLoader
    public <T extends KryptonService> T createServiceInstance(Class<T> r3) {
        if (r3 != KryptonLoaderService.class) goto L11;
        if (usingGenericFetcherInCanvas() == false) goto L7;
        LLog.i(TAG, "Krypton using Lynx generic fetcher to load canvas resources.");
        this.mCurrentLoaderService = new LynxKryptonLoaderServiceImpl(this.mLynxContext);
    L9:
        return this.mCurrentLoaderService;
    L7:
        LLog.i(TAG, "Krypton using resource fetcher to load canvas resources.");
        this.mCurrentLoaderService = new CanvasLoaderService(this.mLynxContext);
        goto L9
    L11:
        if (r3 != KryptonCameraService.class) goto L15;
        return new AnonymousClass1(this);
    L15:
        if (r3 != KryptonMediaRecorderService.class) goto L19;
        return new AnonymousClass2(this);
    L19:
        if (r3 != KryptonSettingsService.class) goto L23;
        return new LynxKryptonSettingsService();
    L23:
        if (r3 != KryptonSensorService.class) goto L27;
        return new KryptonDefaultSensorService(this.mApplicationContext, createSensorInvoker());
    L27:
        if (r3 == KryptonTelemetryService.class) goto L29;
        return null;
    L29:
        return new LynxKryptonTelemetryService(this.mLynxContext);
    }

    public void registerToKryptonApp(KryptonApp r2) {
        r2.registerService(KryptonLoaderService.class, this);
        r2.registerService(KryptonCameraService.class, this);
        r2.registerService(KryptonMediaRecorderService.class, this);
        r2.registerService(KryptonSettingsService.class, this);
        r2.registerService(KryptonSensorService.class, this);
        r2.registerService(KryptonTelemetryService.class, this);
    }

    public void setTemporaryDirectory(String r1) {
        this.mTemporaryDirectory = r1;
    }
}
