package com.xiphias.browser.scanner;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.loc.o;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.barcode.SourceData;
import com.xiphias.browser.scanner.util.AutoFitSurfaceView;
import com.xiphias.browser.scanner.util.Immersive;
import com.xiphias.browser.scanner.util.MotionDetector;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0093\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f*\u0003\t\u0080\u0001\u0018\u0000 §\u00012\u00020\u0001:\u0004§\u0001¨\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\b\u0010D\u001a\u00020AH\u0014J\b\u0010E\u001a\u00020AH\u0014J\b\u0010F\u001a\u00020AH\u0014J-\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020+2\u000e\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020K0J2\u0006\u0010L\u001a\u00020MH\u0016¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020A2\u0006\u0010R\u001a\u000200H\u0002J\b\u0010S\u001a\u00020AH\u0002J\b\u0010T\u001a\u00020AH\u0002J\b\u0010U\u001a\u00020AH\u0002J\u0010\u0010V\u001a\u00020A2\u0006\u0010W\u001a\u00020XH\u0002J\b\u0010Y\u001a\u00020AH\u0002J\b\u0010Z\u001a\u00020AH\u0002J\b\u0010[\u001a\u00020AH\u0002J\b\u0010\\\u001a\u00020\fH\u0002J\b\u0010]\u001a\u00020AH\u0002J\u0010\u0010^\u001a\u00020A2\u0006\u0010_\u001a\u00020 H\u0002J\u0018\u0010`\u001a\u00020A2\u0006\u0010a\u001a\u00020 2\u0006\u0010b\u001a\u00020\fH\u0002J\b\u0010c\u001a\u00020AH\u0002J\b\u0010d\u001a\u00020AH\u0002J\u0010\u0010e\u001a\u00020A2\u0006\u0010f\u001a\u00020gH\u0002J\u0010\u0010h\u001a\u00020A2\u0006\u0010f\u001a\u00020gH\u0002J\b\u0010i\u001a\u00020AH\u0002J\b\u0010j\u001a\u00020\fH\u0002J\u0010\u0010k\u001a\u00020A2\u0006\u0010l\u001a\u00020mH\u0002J\u0014\u0010n\u001a\u00020A2\n\u0010o\u001a\u00060pj\u0002`qH\u0002J\u0010\u0010r\u001a\u00020A2\u0006\u0010f\u001a\u00020gH\u0002J\b\u0010s\u001a\u00020AH\u0002J\b\u0010t\u001a\u00020\fH\u0002J\u0010\u0010u\u001a\u00020A2\u0006\u0010l\u001a\u00020mH\u0002J\u0010\u0010v\u001a\u00020A2\u0006\u0010o\u001a\u00020wH\u0002J\b\u0010x\u001a\u00020AH\u0002J\b\u0010y\u001a\u00020AH\u0002J\b\u0010z\u001a\u00020\fH\u0002J\b\u0010{\u001a\u00020AH\u0002J\b\u0010|\u001a\u00020\fH\u0002J\u0012\u0010}\u001a\u00020\f2\b\b\u0002\u0010~\u001a\u00020+H\u0002J!\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020+2\u0007\u0010\u0082\u0001\u001a\u00020+H\u0002¢\u0006\u0003\u0010\u0083\u0001J\t\u0010\u0084\u0001\u001a\u00020AH\u0002J\u0013\u0010\u0085\u0001\u001a\u00020A2\b\b\u0002\u0010~\u001a\u00020+H\u0002J\t\u0010\u0086\u0001\u001a\u00020AH\u0002J\t\u0010\u0087\u0001\u001a\u00020AH\u0002J\u0019\u0010\u0088\u0001\u001a\u00020A2\u000e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u008a\u0001H\u0002J\t\u0010\u008b\u0001\u001a\u00020AH\u0002J\u0015\u0010\u008c\u0001\u001a\u00020A2\n\b\u0002\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\t\u0010\u008f\u0001\u001a\u00020AH\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0091\u0001\u001a\u00020AH\u0002J\t\u0010\u0092\u0001\u001a\u00020AH\u0002J\t\u0010\u0093\u0001\u001a\u00020\fH\u0002J\u001b\u0010\u0094\u0001\u001a\u00020\f2\u0007\u0010\u0081\u0001\u001a\u00020+2\u0007\u0010\u0082\u0001\u001a\u00020+H\u0002J\t\u0010\u0095\u0001\u001a\u00020AH\u0002J\t\u0010\u0096\u0001\u001a\u00020AH\u0002J\t\u0010\u0097\u0001\u001a\u00020AH\u0002J\u0012\u0010\u0098\u0001\u001a\u00020A2\u0007\u0010\u0099\u0001\u001a\u00020+H\u0002J\u0013\u0010\u009a\u0001\u001a\u0004\u0018\u00010m2\u0006\u0010f\u001a\u00020gH\u0002J\u0013\u0010\u009b\u0001\u001a\u00020+2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J\t\u0010\u009e\u0001\u001a\u00020AH\u0002J2\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00112\r\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020\u00110J2\u0007\u0010¡\u0001\u001a\u00020+2\u0007\u0010¢\u0001\u001a\u00020+H\u0002¢\u0006\u0003\u0010£\u0001J\t\u0010¤\u0001\u001a\u00020AH\u0002J\t\u0010¥\u0001\u001a\u00020AH\u0002J\t\u0010¦\u0001\u001a\u00020AH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010=0=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0010\u0012\f\u0012\n >*\u0004\u0018\u00010=0=0<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006©\u0001"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "visualExecutor", "Ljava/util/concurrent/ExecutorService;", "captureRunnable", "com/xiphias/browser/scanner/ScannerActivity$captureRunnable$1", "Lcom/xiphias/browser/scanner/ScannerActivity$captureRunnable$1;", "captureInFlight", "", "captureThread", "Landroid/os/HandlerThread;", "captureHandler", "surfaceSize", "Landroid/util/Size;", "surfaceView", "Lcom/xiphias/browser/scanner/util/AutoFitSurfaceView;", "scannerMaskView", "Lcom/xiphias/browser/scanner/ScannerMaskView;", "motionDetector", "Lcom/xiphias/browser/scanner/util/MotionDetector;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "captureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "captureRequestBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "cameraZoomRange", "Landroid/util/Range;", "", "cameraZoomFactor", "canStartCapture", "isInSelectingPicture", "isScannerPageVisibleForCapture", "permissionRequestState", "Lcom/xiphias/browser/scanner/ScannerActivity$PermissionRequestState;", "backgroundThread", "backgroundHandler", "isOpeningCamera", "surfaceGeneration", "", "openingSurfaceGeneration", "openingCameraGeneration", "enabledModes", "", "Lcom/xiphias/browser/scanner/ScannerMode;", "currentMode", "documentScanConfig", "Lcom/xiphias/browser/scanner/DocumentScanConfig;", "visualCaptureInFlight", "documentCaptureInFlight", "scannerManager", "Lcom/xiphias/browser/scanner/barcode/ScannerManager;", "uiBinding", "Lcom/xiphias/browser/scanner/ScannerUiBinding;", "isTorchOn", "openGalleryRequest", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "documentProcessingRequest", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "createUiController", "Lcom/xiphias/browser/scanner/ScannerUiController;", "selectMode", "mode", "closeAndFinish", "activeScanner", "inactiveScanner", "onMotionStateChanged", "state", "Lcom/xiphias/browser/scanner/util/MotionDetector$State;", "showRequestPermissionDialog", "openGallery", "pauseScannerPipelineForExternalUi", "resumeScannerPipelineIfVisible", "toggleFlashlight", "applyBarcodeZoomFactor", "zoomFactor", "applyCameraZoomFactor", "requestedZoomFactor", "barcodeModeOnly", "openBrowserPermissionManager", "openBrowserSettingOnAndroid15", "handleImage", "uri", "Landroid/net/Uri;", "handleVisualImage", "captureVisualSearch", "beginVisualCapture", "createVisualSearchSession", "bitmap", "Landroid/graphics/Bitmap;", "onVisualCaptureFailed", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleDocumentImage", "captureDocument", "beginDocumentCapture", "launchDocumentProcessing", "onDocumentCapturePreparationFailed", "", "requestCameraPermissionIfNeeded", "requestCameraPermission", "hasDeniedCameraPermissionBefore", "markCameraPermissionDenied", "isActivityUnavailable", "isPreviewSurfaceReady", "expectedGeneration", "createStateCallback", "com/xiphias/browser/scanner/ScannerActivity$createStateCallback$1", "expectedSurfaceGeneration", "expectedOpenGeneration", "(II)Lcom/xiphias/browser/scanner/ScannerActivity$createStateCallback$1;", "openCamera", "startPreview", "startCaptureRequest", "stopCaptureRequest", "runOnCameraThread", "task", "Lkotlin/Function0;", "stopCameraDevice", "startFrameCapture", "delayMs", "", "stopFrameCapture", "ensureCaptureHandler", "stopCaptureThread", "scheduleNextFrameCapture", "canCaptureFrame", "canUseCopiedFrame", "startMotionDetector", "stopMotionDetector", "captureBitmapFromSurface", "showToast", "messageId", "decodeBitmapFromUri", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "updateCameraPreviewRatio", "getOptimalPreviewSize", "sizes", "w", o.g, "([Landroid/util/Size;II)Landroid/util/Size;", "setupStatusBarForScannerDarkBackground", "startBackgroundThread", "stopBackgroundThread", "Companion", "PermissionRequestState", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScannerActivity extends AppCompatActivity {
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private static final long CAPTURE_INTERVAL_MS = 50;
    public static final a Companion = null;
    private static final float DEFAULT_CAMERA_ZOOM_FACTOR = 1.0f;
    public static final int DESIRED_IMAGE_SIZE = 1000000;
    private static final float MIN_CAMERA_ZOOM_DELTA = 0.05f;
    private static final long OPEN_CAMERA_TIMEOUT_MS = 5000;
    public static final String TAG = "ScannerActivity";
    private Handler backgroundHandler;
    private HandlerThread backgroundThread;
    private CameraDevice cameraDevice;
    private volatile float cameraZoomFactor;
    private volatile Range<Float> cameraZoomRange;
    private volatile boolean canStartCapture;
    private Handler captureHandler;
    private volatile boolean captureInFlight;
    private CaptureRequest.Builder captureRequestBuilder;
    private final b captureRunnable;
    private CameraCaptureSession captureSession;
    private HandlerThread captureThread;
    private volatile ScannerMode currentMode;
    private volatile boolean documentCaptureInFlight;
    private final ActivityResultLauncher<Intent> documentProcessingRequest;
    private com.xiphias.browser.scanner.c documentScanConfig;
    private Set<? extends ScannerMode> enabledModes;
    private volatile boolean isInSelectingPicture;
    private volatile boolean isOpeningCamera;
    private volatile boolean isScannerPageVisibleForCapture;
    private boolean isTorchOn;
    private final Handler mainHandler;
    private MotionDetector motionDetector;
    private final ActivityResultLauncher<Intent> openGalleryRequest;
    private volatile int openingCameraGeneration;
    private volatile int openingSurfaceGeneration;
    private PermissionRequestState permissionRequestState;
    private final com.xiphias.browser.scanner.barcode.g scannerManager;
    private ScannerMaskView scannerMaskView;
    private volatile int surfaceGeneration;
    private Size surfaceSize;
    private AutoFitSurfaceView surfaceView;
    private com.xiphias.browser.scanner.g uiBinding;
    private volatile boolean visualCaptureInFlight;
    private final ExecutorService visualExecutor;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerActivity$PermissionRequestState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "STARTED", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PermissionRequestState extends Enum<PermissionRequestState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PermissionRequestState[] $VALUES = null;
        public static final PermissionRequestState NOT_STARTED = null;
        public static final PermissionRequestState STARTED = null;

        private static final /* synthetic */ PermissionRequestState[] $values() {
            return new PermissionRequestState[]{NOT_STARTED, STARTED};
        }

        static {
            NOT_STARTED = new PermissionRequestState("NOT_STARTED", 0);
            STARTED = new PermissionRequestState("STARTED", 1);
            PermissionRequestState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private PermissionRequestState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<PermissionRequestState> getEntries() {
            return $ENTRIES;
        }

        public static PermissionRequestState valueOf(String r2) {
            return (PermissionRequestState) ZeusTransformUtils.preCheckCast(Enum.valueOf(PermissionRequestState.class, r2), PermissionRequestState.class, "com.obric.memorydata.plugin");
        }

        public static PermissionRequestState[] values() {
            return (PermissionRequestState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PermissionRequestState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerActivity$Companion;", "", "<init>", "()V", "TAG", "", "CAMERA_PERMISSION_REQUEST_CODE", "", "DESIRED_IMAGE_SIZE", "OPEN_CAMERA_TIMEOUT_MS", "", "CAPTURE_INTERVAL_MS", "DEFAULT_CAMERA_ZOOM_FACTOR", "", "MIN_CAMERA_ZOOM_DELTA", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/xiphias/browser/scanner/ScannerActivity$captureRunnable$1", "Ljava/lang/Runnable;", "run", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScannerActivity f16305a;

        b(ScannerActivity r3) {
            this.f16305a = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public void run() {
            ScannerActivity.access$captureBitmapFromSurface(this.f16305a);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/xiphias/browser/scanner/ScannerActivity$createStateCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onOpened", "", "camera", "Landroid/hardware/camera2/CameraDevice;", "onDisconnected", "onError", "error", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends CameraDevice.StateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScannerActivity f16306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f16307b;
        final /* synthetic */ int c;

        c(ScannerActivity r3, int r4, int r5) {
            this.f16306a = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
            this.f16307b = r4;
            this.c = r5;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "camera");
            r2.close();
            if (ScannerActivity.access$getOpeningCameraGeneration$p(this.f16306a) == this.f16307b) goto L5;
            return;
        L5:
            ScannerActivity.access$setOpeningCamera$p(this.f16306a, false);
            ScannerActivity.access$stopCameraDevice(this.f16306a);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "camera");
            Log.e(ScannerActivity.TAG, "camera error, error_code: " + r4);
            r3.close();
            if (ScannerActivity.access$getOpeningCameraGeneration$p(this.f16306a) == this.f16307b) goto L5;
            return;
        L5:
            ScannerActivity.access$setOpeningCamera$p(this.f16306a, false);
            ScannerActivity.access$stopCameraDevice(this.f16306a);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice r3) {
            Intrinsics.checkNotNullParameter(r3, "camera");
            if (ScannerActivity.access$getOpeningCameraGeneration$p(this.f16306a) == this.f16307b) goto L5;
        L9:
            Log.w(ScannerActivity.TAG, "Skip preview startup for stale or destroyed surface");
            r3.close();
            return;
        L5:
            if (ScannerActivity.access$isPreviewSurfaceReady(this.f16306a, this.c) == false) goto L9;
            ScannerActivity.access$setOpeningCamera$p(this.f16306a, false);
            ScannerActivity.access$setCameraDevice$p(this.f16306a, r3);
            ScannerActivity.access$startPreview(this.f16306a, this.c);
            ScannerActivity.access$startFrameCapture(this.f16306a, ScannerActivity.CAPTURE_INTERVAL_MS);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"com/xiphias/browser/scanner/ScannerActivity$createUiController$1", "Lcom/xiphias/browser/scanner/ScannerUiController;", IslandSession.REOPEN_VALUE_CLOSE, "", "openGallery", "toggleTorch", "", "resetActiveTime", "activeScanner", "enabledModes", "", "Lcom/xiphias/browser/scanner/ScannerMode;", "currentMode", "selectMode", "mode", "captureVisualSearch", "captureDocument", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScannerActivity f16308a;

        d(ScannerActivity r3) {
            this.f16308a = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.xiphias.browser.scanner.h
        public void a() {
            ScannerActivity.access$closeAndFinish(this.f16308a);
        }

        @Override // com.xiphias.browser.scanner.h
        public void b() {
            MotionDetector r0 = ScannerActivity.access$getMotionDetector$p(this.f16308a);
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        @Override // com.xiphias.browser.scanner.h
        public void c() {
            ScannerActivity.access$activeScanner(this.f16308a);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/xiphias/browser/scanner/ScannerActivity$onCreate$5", "Landroid/view/SurfaceHolder$Callback;", "surfaceCreated", "", "holder", "Landroid/view/SurfaceHolder;", "surfaceChanged", "format", "", "width", "height", "surfaceDestroyed", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScannerActivity f16309a;

        e(ScannerActivity r3) {
            this.f16309a = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceHolder.class, "com.obric.memorydata.plugin"), "holder");
            Log.d(ScannerActivity.TAG, "surfaceChanged, width = " + r3 + ", height = " + r4);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder r3) {
            Intrinsics.checkNotNullParameter((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.memorydata.plugin"), "holder");
            int r4 = ScannerActivity.access$getSurfaceGeneration$p(this.f16309a);
            ScannerActivity.access$setSurfaceGeneration$p(this.f16309a, r4 + 1);
            ScannerActivity.access$setCanStartCapture$p(this.f16309a, true);
            ScannerActivity.access$openCamera(this.f16309a);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder r3) {
            Intrinsics.checkNotNullParameter((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.memorydata.plugin"), "holder");
            int r4 = ScannerActivity.access$getSurfaceGeneration$p(this.f16309a);
            ScannerActivity.access$setSurfaceGeneration$p(this.f16309a, r4 + 1);
            ScannerActivity.access$setCanStartCapture$p(this.f16309a, false);
            ScannerActivity.access$setOpeningSurfaceGeneration$p(this.f16309a, -1);
            ScannerActivity.access$stopFrameCapture(this.f16309a);
            ScannerActivity.access$stopCameraDevice(this.f16309a);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiphias/browser/scanner/ScannerActivity$scannerManager$1", "Lcom/xiphias/browser/scanner/barcode/BarcodeResultCallback;", "onResult", "", "result", "Lcom/xiphias/browser/scanner/barcode/BarDecodeResult;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.xiphias.browser.scanner.barcode.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScannerActivity f16310a;

        f(ScannerActivity r3) {
            this.f16310a = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.xiphias.browser.scanner.barcode.d
        public void a(com.xiphias.browser.scanner.barcode.a r5) {
            if (ScannerActivity.access$getCurrentMode$p(this.f16310a) == ScannerMode.BARCODE) goto L5;
            return;
        L5:
            if (r5 != null) goto L7;
            return;
        L7:
            Float r0 = r5.c();
            if (r0 == null) goto L11;
            ScannerActivity.access$applyBarcodeZoomFactor(this.f16310a, ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).floatValue());
        L11:
            if (r5.getType() != SourceData.Type.FROM_GALLERY) goto L22;
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L15;
        L18:
            boolean r2 = true;
        L19:
            if (r2 == false) goto L22;
            ScannerActivity.access$showToast(this.f16310a, ZeusTransformUtils.mapRes(R.string.not_scanned_barcode, TypedValues.Custom.S_STRING, "not_scanned_barcode"));
            return;
        L15:
            if (StringsKt.isBlank(r1) == true) goto L18;
            r2 = false;
        L22:
            String r3 = r5.a();
            if (r3 != null) goto L25;
            return;
        L25:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L28;
            r3 = null;
        L28:
            if (r3 == null) goto L33;
            Intent r4 = new Intent();
            r4.putExtra("contents", r3);
            r4.putExtra("barcodeFormat", (Serializable) ZeusTransformUtils.preCheckCast(r5.b(), Serializable.class, "com.obric.memorydata.plugin"));
            ZeusTransformUtils.setResult(this.f16310a, -1, r4, "com.obric.memorydata.plugin");
            ScannerActivity.access$closeAndFinish(this.f16310a);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xiphias/browser/scanner/ScannerActivity$startPreview$sessionConfiguration$2", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "onConfigured", "", "session", "Landroid/hardware/camera2/CameraCaptureSession;", "onConfigureFailed", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends CameraCaptureSession.StateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScannerActivity f16311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f16312b;

        g(ScannerActivity r3, int r4) {
            this.f16311a = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
            this.f16312b = r4;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession r1) {
            Intrinsics.checkNotNullParameter(r1, "session");
            Log.e(ScannerActivity.TAG, "camera config failed!");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession r3) {
            Intrinsics.checkNotNullParameter(r3, "session");
            if (ScannerActivity.access$isPreviewSurfaceReady(this.f16311a, this.f16312b) == true) goto L5;
        L11:
            r3.close();
            return;
        L5:
            if (ScannerActivity.access$getCameraDevice$p(this.f16311a) == null) goto L11;
            ScannerActivity.access$setCaptureSession$p(this.f16311a, r3);     // Catch: CameraAccessException -> L9
            ScannerActivity.access$startCaptureRequest(this.f16311a);     // Catch: CameraAccessException -> L9
            return;
        L9:
            Log.e(ScannerActivity.TAG, "start camera session failed!");
        }
    }

    /* JADX INFO: renamed from: com.xiphias.browser.scanner.ScannerActivity$startMotionDetector$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<MotionDetector.State, Unit> {
        AnonymousClass1(Object r8) {
            super(1, r8, ScannerActivity.class, "onMotionStateChanged", "onMotionStateChanged(Lcom/xiphias/browser/scanner/util/MotionDetector$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(MotionDetector.State r3) {
            invoke2((MotionDetector.State) ZeusTransformUtils.preCheckCast(r3, MotionDetector.State.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MotionDetector.State r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            ScannerActivity.access$onMotionStateChanged((ScannerActivity) ZeusTransformUtils.preCheckCast(this.receiver, ScannerActivity.class, "com.obric.memorydata.plugin"), r3);
        }
    }

    static {
        Companion = new a(null);
    }

    public ScannerActivity() {
        this.mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService r0 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor(...)");
        this.visualExecutor = r0;
        this.captureRunnable = new b(this);
        this.cameraZoomFactor = 1.0f;
        this.isScannerPageVisibleForCapture = true;
        this.permissionRequestState = PermissionRequestState.NOT_STARTED;
        this.openingSurfaceGeneration = -1;
        this.enabledModes = SetsKt.setOf(ScannerMode.BARCODE);
        this.currentMode = ScannerMode.BARCODE;
        this.scannerManager = new com.xiphias.browser.scanner.barcode.g((com.xiphias.browser.scanner.barcode.d) ZeusTransformUtils.preCheckCast(new f(this), com.xiphias.browser.scanner.barcode.d.class, "com.obric.memorydata.plugin"));
        ActivityResultLauncher<Intent> r1 = registerForActivityResult((ActivityResultContract) ZeusTransformUtils.preCheckCast(new ActivityResultContracts.StartActivityForResult(), ActivityResultContract.class, "com.obric.memorydata.plugin"), new $$Lambda$ScannerActivity$ar1zq1LrYvtVZb1mHZ5yx62paOU(this));
        Intrinsics.checkNotNullExpressionValue(r1, "registerForActivityResult(...)");
        this.openGalleryRequest = r1;
        ActivityResultLauncher<Intent> r2 = registerForActivityResult((ActivityResultContract) ZeusTransformUtils.preCheckCast(new ActivityResultContracts.StartActivityForResult(), ActivityResultContract.class, "com.obric.memorydata.plugin"), new $$Lambda$ScannerActivity$eYweqVZosLLrHp2A5thzCGutliA(this));
        Intrinsics.checkNotNullExpressionValue(r2, "registerForActivityResult(...)");
        this.documentProcessingRequest = r2;
    }

    public static final /* synthetic */ void access$activeScanner(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).activeScanner();
    }

    public static final /* synthetic */ void access$applyBarcodeZoomFactor(ScannerActivity r2, float r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).applyBarcodeZoomFactor(r3);
    }

    public static final /* synthetic */ void access$captureBitmapFromSurface(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).captureBitmapFromSurface();
    }

    public static final /* synthetic */ void access$captureDocument(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).captureDocument();
    }

    public static final /* synthetic */ void access$captureVisualSearch(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).captureVisualSearch();
    }

    public static final /* synthetic */ void access$closeAndFinish(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).closeAndFinish();
    }

    public static final /* synthetic */ CameraDevice access$getCameraDevice$p(ScannerActivity r2) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).cameraDevice;
    }

    public static final /* synthetic */ ScannerMode access$getCurrentMode$p(ScannerActivity r2) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).currentMode;
    }

    public static final /* synthetic */ Set access$getEnabledModes$p(ScannerActivity r2) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).enabledModes;
    }

    public static final /* synthetic */ MotionDetector access$getMotionDetector$p(ScannerActivity r2) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).motionDetector;
    }

    public static final /* synthetic */ int access$getOpeningCameraGeneration$p(ScannerActivity r2) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).openingCameraGeneration;
    }

    public static final /* synthetic */ int access$getSurfaceGeneration$p(ScannerActivity r2) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).surfaceGeneration;
    }

    public static final /* synthetic */ boolean access$isPreviewSurfaceReady(ScannerActivity r2, int r3) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).isPreviewSurfaceReady(r3);
    }

    public static final /* synthetic */ boolean access$isTorchOn$p(ScannerActivity r2) {
        return ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).isTorchOn;
    }

    public static final /* synthetic */ void access$onMotionStateChanged(ScannerActivity r2, MotionDetector.State r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).onMotionStateChanged(r3);
    }

    public static final /* synthetic */ void access$openCamera(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).openCamera();
    }

    public static final /* synthetic */ void access$openGallery(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).openGallery();
    }

    public static final /* synthetic */ void access$selectMode(ScannerActivity r2, ScannerMode r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).selectMode(r3);
    }

    public static final /* synthetic */ void access$setCameraDevice$p(ScannerActivity r2, CameraDevice r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).cameraDevice = r3;
    }

    public static final /* synthetic */ void access$setCanStartCapture$p(ScannerActivity r2, boolean r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).canStartCapture = r3;
    }

    public static final /* synthetic */ void access$setCaptureSession$p(ScannerActivity r2, CameraCaptureSession r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).captureSession = r3;
    }

    public static final /* synthetic */ void access$setOpeningCamera$p(ScannerActivity r2, boolean r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).isOpeningCamera = r3;
    }

    public static final /* synthetic */ void access$setOpeningSurfaceGeneration$p(ScannerActivity r2, int r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).openingSurfaceGeneration = r3;
    }

    public static final /* synthetic */ void access$setSurfaceGeneration$p(ScannerActivity r2, int r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).surfaceGeneration = r3;
    }

    public static final /* synthetic */ void access$showToast(ScannerActivity r2, int r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).showToast(r3);
    }

    public static final /* synthetic */ void access$startCaptureRequest(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).startCaptureRequest();
    }

    public static final /* synthetic */ void access$startFrameCapture(ScannerActivity r2, long r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).startFrameCapture(r3);
    }

    public static final /* synthetic */ void access$startPreview(ScannerActivity r2, int r3) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).startPreview(r3);
    }

    public static final /* synthetic */ void access$stopCameraDevice(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).stopCameraDevice();
    }

    public static final /* synthetic */ void access$stopFrameCapture(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).stopFrameCapture();
    }

    public static final /* synthetic */ void access$toggleFlashlight(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).toggleFlashlight();
    }

    private final void activeScanner() {
        runOnUiThread(new $$Lambda$ScannerActivity$Xxk0GNrn4dYD9I41Qq1DMMI8rK4(this));
    }

    private static final void activeScanner$lambda$10(ScannerActivity r5) {
        ScannerActivity r6 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r5, ScannerActivity.class, "com.obric.memorydata.plugin");
        com.xiphias.browser.scanner.g r0 = r6.uiBinding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
        r0 = null;
    L5:
        r0.b().setVisibility(0);
        com.xiphias.browser.scanner.g r1 = r6.uiBinding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
        r1 = null;
    L8:
        r1.c().setVisibility(8);
        r6.isScannerPageVisibleForCapture = true;
        startFrameCapture$default(r6, 0, 1, null);
        r6.startCaptureRequest();
        MotionDetector r7 = r6.motionDetector;
        if (r7 == null) goto L12;
        r7.c();
        return;
    }

    private final void applyBarcodeZoomFactor(float r2) {
        applyCameraZoomFactor(r2, true);
    }

    private final void applyCameraZoomFactor(float r5, final boolean r6) {
        Range<Float> r0 = this.cameraZoomRange;
        if (r0 != null) goto L5;
        return;
    L5:
        Comparable r1 = r0.getLower();
        Intrinsics.checkNotNullExpressionValue(r1, "getLower(...)");
        float r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).floatValue();
        Comparable r3 = r0.getUpper();
        Intrinsics.checkNotNullExpressionValue(r3, "getUpper(...)");
        Float r7 = com.xiphias.browser.scanner.barcode.e.a(r5, r2, ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue(), this.cameraZoomFactor, MIN_CAMERA_ZOOM_DELTA);
        if (r7 == null) goto L11;
        final float r8 = r7.floatValue();
        Handler r4 = this.backgroundHandler;
        if (r4 == null) goto L12;
        r4.post(new $$Lambda$ScannerActivity$v2tuuxFBHx2_sWeE778Ooo2iIE(r6, this, r8));
        return;
    L12:
        return;
    }

    private static final void applyCameraZoomFactor$lambda$15(boolean r7, ScannerActivity r8, float r9) {
        ScannerActivity r10 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r8, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r7 == true) goto L5;
    L7:
        Range<Float> r11 = r10.cameraZoomRange;
        if (r11 != null) goto L10;
        return;
    L10:
        CaptureRequest.Builder r1 = r10.captureRequestBuilder;
        if (r1 != null) goto L13;
        return;
    L13:
        CameraCaptureSession r3 = r10.captureSession;
        if (r3 != null) goto L16;
        return;
    L16:
        Comparable r4 = r11.getLower();
        Intrinsics.checkNotNullExpressionValue(r4, "getLower(...)");
        float r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue();
        Comparable r12 = r11.getUpper();
        Intrinsics.checkNotNullExpressionValue(r12, "getUpper(...)");
        Float r13 = com.xiphias.browser.scanner.barcode.e.a(r9, r5, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).floatValue(), r10.cameraZoomFactor, MIN_CAMERA_ZOOM_DELTA);
        if (r13 == null) goto L31;
        float r14 = r13.floatValue();
        r1.set(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(r14));     // Catch: CameraAccessException -> L21 IllegalStateException -> L23 IllegalArgumentException -> L26
        r3.setRepeatingRequest(r1.build(), null, null);     // Catch: CameraAccessException -> L21 IllegalStateException -> L23 IllegalArgumentException -> L26
        r10.cameraZoomFactor = r14;     // Catch: CameraAccessException -> L21 IllegalStateException -> L23 IllegalArgumentException -> L26
        Log.d(TAG, "Applied Bach zoom factor: " + r14);     // Catch: CameraAccessException -> L21 IllegalStateException -> L23 IllegalArgumentException -> L26
    L33:
        return;
    L21:
        e = move-exception;
        Throwable r15 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        String r16 = "Unable to apply Bach zoom";
    L25:
        Log.e(TAG, r16, r15);
        return;
    L26:
        e = move-exception;
        Log.e(TAG, "Invalid Bach zoom factor: " + r14, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L23:
        e = move-exception;
        r15 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        r16 = "Unable to apply Bach zoom: session is closed";
        goto L25
    L31:
        return;
    L5:
        if (r10.currentMode == ScannerMode.BARCODE) goto L7;
    }

    private final boolean beginDocumentCapture() {
        if (this.documentCaptureInFlight == false) goto L6;
        return false;
    L6:
        this.documentCaptureInFlight = true;
        runOnUiThread(new $$Lambda$ScannerActivity$FZTYb1eQKuMeen2GciFbpHwhHEA(this));
        return true;
    }

    private static final void beginDocumentCapture$lambda$26(ScannerActivity r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r4, ScannerActivity.class, "com.obric.memorydata.plugin");
        View r0 = r5.findViewById(ZeusTransformUtils.mapRes(R.id.capture_visual_search, OaidModel.KEY_ID, "capture_visual_search"));
        if (r0 == null) goto L5;
        r0.setEnabled(false);
    L5:
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(ZeusTransformUtils.mapRes(R.id.barcode_scan_hint, OaidModel.KEY_ID, "barcode_scan_hint")), TextView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        r6.setText(ZeusTransformUtils.mapRes(R.string.document_scan_processing, TypedValues.Custom.S_STRING, "document_scan_processing"));
        return;
    }

    private final boolean beginVisualCapture() {
        if (this.visualCaptureInFlight == false) goto L6;
        return false;
    L6:
        this.visualCaptureInFlight = true;
        runOnUiThread(new $$Lambda$ScannerActivity$XucxMUlKm_UmUBW_GTVZRvRp3c(this));
        return true;
    }

    private static final void beginVisualCapture$lambda$20(ScannerActivity r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r4, ScannerActivity.class, "com.obric.memorydata.plugin");
        View r0 = r5.findViewById(ZeusTransformUtils.mapRes(R.id.capture_visual_search, OaidModel.KEY_ID, "capture_visual_search"));
        if (r0 == null) goto L5;
        r0.setEnabled(false);
    L5:
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(ZeusTransformUtils.mapRes(R.id.barcode_scan_hint, OaidModel.KEY_ID, "barcode_scan_hint")), TextView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        r6.setText(ZeusTransformUtils.mapRes(R.string.vision_search_processing, TypedValues.Custom.S_STRING, "vision_search_processing"));
        return;
    }

    private final int calculateInSampleSize(BitmapFactory.Options r3) {
        Pair r2 = TuplesKt.to(Integer.valueOf(r3.outHeight), Integer.valueOf(r3.outWidth));
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.component1(), Number.class, "com.obric.memorydata.plugin")).intValue() * ((Number) ZeusTransformUtils.preCheckCast(r2.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r5 = 1;
    L4:
        if (r4 <= ((1000000 * r5) * r5)) goto L6;
        r5 = r5 * 2;
        goto L4
    L6:
        return r5;
    }

    private final boolean canCaptureFrame() {
        if (this.uiBinding != null) goto L6;
        return false;
    L6:
        if (this.currentMode == ScannerMode.BARCODE) goto L9;
        return false;
    L9:
        if (isActivityUnavailable() == false) goto L11;
        return false;
    L11:
        com.xiphias.browser.scanner.g r0 = this.uiBinding;
        AutoFitSurfaceView r2 = null;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
        r0 = null;
    L15:
        if (r0.b().getVisibility() == 0) goto L18;
        return false;
    L18:
        if (this.isInSelectingPicture == false) goto L20;
    L30:
        return false;
    L20:
        if (this.canStartCapture == false) goto L30;
        if (this.cameraDevice == null) goto L30;
        AutoFitSurfaceView r3 = this.surfaceView;
        if (r3 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    L29:
        return r2.getHolder().getSurface().isValid();
    L27:
        r2 = r3;
        goto L29
    }

    private final boolean canUseCopiedFrame(int r2, int r3) {
        if (this.isScannerPageVisibleForCapture == true) goto L5;
    L13:
        return false;
    L5:
        if (this.canStartCapture == false) goto L13;
        if (this.isInSelectingPicture == true) goto L13;
        if (this.surfaceGeneration != r2) goto L13;
        if (this.openingCameraGeneration != r3) goto L13;
        return true;
    }

    private final void captureBitmapFromSurface() {
        if (canCaptureFrame() == true) goto L6;
        return;
    L6:
        if (this.captureInFlight == false) goto L8;
        return;
    L8:
        final int r0 = this.surfaceGeneration;
        final int r1 = this.openingCameraGeneration;
        ScannerMaskView r3 = this.scannerMaskView;
        AutoFitSurfaceView r4 = null;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
        r3 = null;
    L11:
        Rect r2 = new Rect(r3.getRealCaptureRect());
        int r5 = r2.width();
        int r6 = r2.height();
        if (r5 <= 0) goto L25;
        if (r6 <= 0) goto L25;
        this.captureInFlight = true;
        AutoFitSurfaceView r7 = this.surfaceView;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    L19:
        Surface r8 = r4.getHolder().getSurface();
        final Bitmap r9 = Bitmap.createBitmap(r5, r6, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(r9, "createBitmap(...)");
        PixelCopy.request(r8, r2, r9, new $$Lambda$ScannerActivity$ZAXGfjt4bhqWyq1zaHC9T8WEGcA(this, r0, r1, r9), ensureCaptureHandler());     // Catch: IllegalArgumentException -> L22
        return;
    L22:
        e = move-exception;
        this.captureInFlight = false;
        r9.recycle();
        Log.e(TAG, "captureBitmapFromSurface PixelCopy failed: " + e.getMessage());
        scheduleNextFrameCapture();
        return;
    L18:
        r4 = r7;
    L25:
        Log.e(TAG, "captureBitmapFromSurface: invalid capture rect, width=" + r5 + ", height=" + r6);
    }

    private static final void captureBitmapFromSurface$lambda$53(ScannerActivity r2, int r3, int r4, Bitmap r5, int r6) {
        final ScannerActivity r7 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r6 == 0) goto L5;
        r5.recycle();
        if (r6 == 3) goto L11;
        Log.e(TAG, "Failed to copy bitmap: " + r6);
    L11:
        r7.captureInFlight = false;
        r7.mainHandler.post(new $$Lambda$ScannerActivity$hrxRqMQi2bS3lwf1k_K94ueyONE(r7));
        return;
    L5:
        if (r7.canUseCopiedFrame(r3, r4) == false) goto L7;
        r7.scannerManager.a(new SourceData(SourceData.Type.FROM_CAMERA, r5, r7.cameraZoomFactor));
        goto L11
    L7:
        r5.recycle();
        goto L11
    }

    private static final void captureBitmapFromSurface$lambda$53$lambda$52(ScannerActivity r2) {
        ((ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin")).scheduleNextFrameCapture();
    }

    private final void captureDocument() {
        if (this.currentMode == ScannerMode.DOCUMENT) goto L5;
        return;
    L5:
        if (beginDocumentCapture() == true) goto L8;
        return;
    L8:
        if (this.canStartCapture == false) goto L38;
        AutoFitSurfaceView r0 = this.surfaceView;
        AutoFitSurfaceView r2 = null;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r0 = null;
    L13:
        if (r0.getHolder().getSurface().isValid() == false) goto L38;
        AutoFitSurfaceView r1 = this.surfaceView;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r1 = null;
    L18:
        int r3 = r1.getWidth();
        AutoFitSurfaceView r4 = this.surfaceView;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r4 = null;
    L21:
        int r5 = r4.getHeight();
        if (r3 <= 0) goto L35;
        if (r5 <= 0) goto L35;
        final Bitmap r6 = Bitmap.createBitmap(r3, r5, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(r6, "createBitmap(...)");
        AutoFitSurfaceView r7 = this.surfaceView;     // Catch: Throwable -> L32
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");     // Catch: Throwable -> L32
    L30:
        PixelCopy.request(r2.getHolder().getSurface(), r6, new $$Lambda$ScannerActivity$4RY166z0zzELX4zCRfQAA4bWwAA(r6, this), ensureCaptureHandler());     // Catch: Throwable -> L32
        return;
    L29:
        r2 = r7;
    L32:
        th = move-exception;
        r6.recycle();
        onDocumentCapturePreparationFailed(th);
        return;
    L35:
        IllegalStateException r8 = new IllegalStateException("Camera preview has invalid dimensions");
    L36:
        onDocumentCapturePreparationFailed((Throwable) ZeusTransformUtils.preCheckCast(r8, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L38:
        r8 = new IllegalStateException("Camera preview is not ready");
        goto L36
    }

    private static final void captureDocument$lambda$25(final Bitmap r3, ScannerActivity r4, int r5) {
        final ScannerActivity r6 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r4, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r5 == 0) goto L6;
        r3.recycle();
        r6.onDocumentCapturePreparationFailed((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("PixelCopy failed with code " + r5), Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        r6.visualExecutor.execute(new $$Lambda$ScannerActivity$M8f1j9dhZGyu6tcSYXXB5hx4xCg(r6, r3));
    }

    private static final void captureDocument$lambda$25$lambda$24(ScannerActivity r2, Bitmap r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        r4.launchDocumentProcessing(r3);     // Catch: Throwable -> L7
        if (r3.isRecycled() == true) goto L12;
    L6:
        r3.recycle();
        return;
    L12:
        return;
    L7:
        th = move-exception;
        r4.onDocumentCapturePreparationFailed(th);     // Catch: Throwable -> L13
        if (r3.isRecycled() == false) goto L6;
        return;
    L13:
        th = move-exception;
        if (r3.isRecycled() == true) goto L17;
        r3.recycle();
    L17:
        throw th;
    }

    private final void captureVisualSearch() {
        if (this.currentMode.isVisualSearch() == true) goto L5;
        return;
    L5:
        if (beginVisualCapture() == true) goto L8;
        return;
    L8:
        if (this.canStartCapture == false) goto L38;
        AutoFitSurfaceView r0 = this.surfaceView;
        AutoFitSurfaceView r2 = null;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r0 = null;
    L13:
        if (r0.getHolder().getSurface().isValid() == false) goto L38;
        AutoFitSurfaceView r1 = this.surfaceView;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r1 = null;
    L18:
        int r3 = r1.getWidth();
        AutoFitSurfaceView r4 = this.surfaceView;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r4 = null;
    L21:
        int r5 = r4.getHeight();
        if (r3 <= 0) goto L35;
        if (r5 <= 0) goto L35;
        final Bitmap r6 = Bitmap.createBitmap(r3, r5, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(r6, "createBitmap(...)");
        AutoFitSurfaceView r7 = this.surfaceView;     // Catch: Exception -> L32
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");     // Catch: Exception -> L32
    L30:
        PixelCopy.request(r2.getHolder().getSurface(), r6, new $$Lambda$ScannerActivity$UluFPMF8BgdMdSvATFV0jBmtvGk(r6, this), ensureCaptureHandler());     // Catch: Exception -> L32
        return;
    L29:
        r2 = r7;
    L32:
        e = move-exception;
        r6.recycle();
        onVisualCaptureFailed(e);
        return;
    L35:
        IllegalStateException r8 = new IllegalStateException("Camera preview has invalid dimensions");
    L36:
        onVisualCaptureFailed((Exception) ZeusTransformUtils.preCheckCast(r8, Exception.class, "com.obric.memorydata.plugin"));
        return;
    L38:
        r8 = new IllegalStateException("Camera preview is not ready");
        goto L36
    }

    private static final void captureVisualSearch$lambda$19(final Bitmap r3, ScannerActivity r4, int r5) {
        final ScannerActivity r6 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r4, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r5 == 0) goto L6;
        r3.recycle();
        r6.onVisualCaptureFailed((Exception) ZeusTransformUtils.preCheckCast(new IllegalStateException("PixelCopy failed with code " + r5), Exception.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        r6.visualExecutor.execute(new $$Lambda$ScannerActivity$vBF4CW0xaZMR_tF53FTSE9E5wPM(r6, r3));
    }

    private static final void captureVisualSearch$lambda$19$lambda$18(ScannerActivity r2, Bitmap r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        r4.createVisualSearchSession(r3);     // Catch: Throwable -> L7 Exception -> L9
    L5:
        if (r3.isRecycled() == true) goto L14;
    L6:
        r3.recycle();
        return;
    L14:
        return;
    L9:
        e = move-exception;
        r4.onVisualCaptureFailed(e);     // Catch: Throwable -> L7
        if (r3.isRecycled() == false) goto L6;
        return;
    L7:
        th = move-exception;
        if (r3.isRecycled() == true) goto L18;
        r3.recycle();
    L18:
        throw th;
    }

    private final void closeAndFinish() {
        runOnUiThread(new $$Lambda$ScannerActivity$UuRTfUFPrsknanVn7zLrshH1mug(this));
    }

    private static final void closeAndFinish$lambda$9(ScannerActivity r2) {
        ScannerActivity r3 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        r3.stopFrameCapture();
        r3.stopCameraDevice();
        r3.finish();
    }

    private final c createStateCallback(int r2, int r3) {
        return new c(this, r3, r2);
    }

    private final h createUiController() {
        return (h) ZeusTransformUtils.preCheckCast(new d(this), h.class, "com.obric.memorydata.plugin");
    }

    private final void createVisualSearchSession(Bitmap r4) {
        final com.xiphias.browser.scanner.b.c r5 = com.xiphias.browser.scanner.b.a.f16322a.a().a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r4, this.currentMode);
        runOnUiThread(new $$Lambda$ScannerActivity$aOIHGlOcGjJO27U2HwW_2FJXA8(this, r5));
    }

    private static final void createVisualSearchSession$lambda$21(ScannerActivity r2, com.xiphias.browser.scanner.b.c r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        com.xiphias.browser.scanner.b.c r5 = (com.xiphias.browser.scanner.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.xiphias.browser.scanner.b.c.class, "com.obric.memorydata.plugin");
        if (r4.isActivityUnavailable() == false) goto L6;
        r5.b();
        return;
    L6:
        ZeusTransformUtils.startActivity(r4, r5.a(), "com.obric.memorydata.plugin");
    }

    private final Bitmap decodeBitmapFromUri(Uri r6) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        InputStream r1 = getContentResolver().openInputStream(r6);
        if (r1 == null) goto L12;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");
        BitmapFactory.decodeStream((InputStream) ZeusTransformUtils.preCheckCast(r2, InputStream.class, "com.obric.memorydata.plugin"), null, r0);     // Catch: Throwable -> L7
        CloseableKt.closeFinally(r2, null);
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L12:
        r0.inSampleSize = calculateInSampleSize(r0);
        r0.inJustDecodeBounds = false;
        InputStream r5 = getContentResolver().openInputStream(r6);
        if (r5 == null) goto L22;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.memorydata.plugin");
        Bitmap r8 = BitmapFactory.decodeStream((InputStream) ZeusTransformUtils.preCheckCast(r7, InputStream.class, "com.obric.memorydata.plugin"), null, r0);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r7, null);
        return r8;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L22:
        return null;
    }

    private static final void documentProcessingRequest$lambda$3(ScannerActivity r3, ActivityResult r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r4.getResultCode() == (-1)) goto L5;
    L8:
        r5.documentCaptureInFlight = false;
        View r6 = r5.findViewById(ZeusTransformUtils.mapRes(R.id.capture_visual_search, OaidModel.KEY_ID, "capture_visual_search"));
        if (r6 == null) goto L11;
        r6.setEnabled(true);
    L11:
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(ZeusTransformUtils.mapRes(R.id.barcode_scan_hint, OaidModel.KEY_ID, "barcode_scan_hint")), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        r7.setText(ZeusTransformUtils.mapRes(R.string.document_scan_hint, TypedValues.Custom.S_STRING, "document_scan_hint"));
    L14:
        r5.startMotionDetector();
        r5.openCamera();
        return;
    L5:
        if (r4.getData() == null) goto L8;
        ZeusTransformUtils.setResult(r5, -1, r4.getData(), "com.obric.memorydata.plugin");
        r5.closeAndFinish();
    }

    private final Handler ensureCaptureHandler() {
        Handler r0 = this.captureHandler;
        if (r0 == null) goto L5;
        return r0;
    L5:
        HandlerThread r1 = new HandlerThread("ScannerFrameCapture");
        r1.start();
        this.captureThread = r1;
        Handler r2 = new Handler(r1.getLooper());
        this.captureHandler = r2;
        return r2;
    }

    private final Size getOptimalPreviewSize(Size[] r17, int r18, int r19) {
        double r3 = ((double) r18) / ((double) r19);
        int r5 = 0;
        if (r17.length != 0) goto L5;
        boolean r1 = true;
    L6:
        Size r6 = null;
        if (r1 == false) goto L9;
        return null;
    L9:
        int r2 = r17.length;
        int r9 = 0;
        double r10 = Double.MAX_VALUE;
    L10:
        if (r9 >= r2) goto L17;
        Size r12 = r17[r9];
        if (Math.abs((((double) r12.getWidth()) / ((double) r12.getHeight())) - r3) > 0.1d) goto L16;
        if (Math.abs(r12.getHeight() - r19) >= r10) goto L16;
        r10 = Math.abs(r12.getHeight() - r19);
        r6 = r12;
    L16:
        r9 = r9 + 1;
        goto L10
    L17:
        if (r6 != null) goto L24;
        int r4 = r17.length;
        double r7 = Double.MAX_VALUE;
    L19:
        if (r5 >= r4) goto L24;
        Size r8 = r17[r5];
        double r11 = Math.abs((((double) r8.getWidth()) / ((double) r8.getHeight())) - r3);
        if (r11 >= r7) goto L23;
        r6 = r8;
        r7 = r11;
    L23:
        r5 = r5 + 1;
    L24:
        return r6;
    L5:
        r1 = false;
        goto L6
    }

    private final void handleDocumentImage(final Uri r3) {
        if (beginDocumentCapture() == true) goto L5;
        return;
    L5:
        this.visualExecutor.execute(new $$Lambda$ScannerActivity$19d0nhe5nbWZQ4sVu0cTRAGJA0(this, r3));
    }

    private static final void handleDocumentImage$lambda$23(ScannerActivity r3, Uri r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        com.xiphias.browser.scanner.a.a r0 = com.xiphias.browser.scanner.a.a.f16318a;     // Catch: Throwable -> L13
        ContentResolver r1 = r5.getContentResolver();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r1, "getContentResolver(...)");     // Catch: Throwable -> L13
        Bitmap r6 = r0.a(r1, r4);     // Catch: Throwable -> L13
        r5.launchDocumentProcessing(r6);     // Catch: Throwable -> L8
    L6:
        if (r6.isRecycled() == true) goto L19;
        r6.recycle();     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L8:
        th = move-exception;
        if (r6.isRecycled() == true) goto L12;
        r6.recycle();     // Catch: Throwable -> L13
    L12:
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r5.onDocumentCapturePreparationFailed(th);
    }

    private final void handleImage(Uri r9) {
        Bitmap r3 = decodeBitmapFromUri(r9);     // Catch: Exception -> L8
        if (r3 == null) goto L6;
        this.scannerManager.a(new SourceData(SourceData.Type.FROM_GALLERY, r3, 0.0f, 4, null));     // Catch: Exception -> L8
    L11:
        return;
    L6:
        Log.e(TAG, "decode bitmap from uri is null, uri: " + r9);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "get image data failed, uri: " + r9 + ", exception: " + e.getMessage());
    }

    private final void handleVisualImage(final Uri r3) {
        if (beginVisualCapture() == true) goto L5;
        return;
    L5:
        this.visualExecutor.execute(new $$Lambda$ScannerActivity$5l33OIzGQ7jfDmmU0a6Rl2CxWQ(this, r3));
    }

    private static final void handleVisualImage$lambda$17(ScannerActivity r3, Uri r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        com.xiphias.browser.scanner.b.b r0 = com.xiphias.browser.scanner.b.a.f16322a.a();     // Catch: Exception -> L13
        ContentResolver r1 = r5.getContentResolver();     // Catch: Exception -> L13
        Intrinsics.checkNotNullExpressionValue(r1, "getContentResolver(...)");     // Catch: Exception -> L13
        Bitmap r6 = r0.a(r1, r4);     // Catch: Exception -> L13
        r5.createVisualSearchSession(r6);     // Catch: Throwable -> L8
    L6:
        if (r6.isRecycled() == true) goto L19;
        r6.recycle();     // Catch: Exception -> L13
        return;
    L19:
        return;
    L8:
        th = move-exception;
        if (r6.isRecycled() == true) goto L12;
        r6.recycle();     // Catch: Exception -> L13
    L12:
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r5.onVisualCaptureFailed(e);
    }

    private final boolean hasDeniedCameraPermissionBefore() {
        return getSharedPreferences("scanner_prefs", 0).getBoolean("camera_permission_denied", false);
    }

    private final void inactiveScanner() {
        runOnUiThread(new $$Lambda$ScannerActivity$Bk8Jez4znP3TJnZ36nafp8kbkXs(this));
    }

    private static final void inactiveScanner$lambda$11(ScannerActivity r5) {
        ScannerActivity r6 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r5, ScannerActivity.class, "com.obric.memorydata.plugin");
        r6.isScannerPageVisibleForCapture = false;
        r6.stopFrameCapture();
        r6.stopCaptureRequest();
        com.xiphias.browser.scanner.g r1 = r6.uiBinding;
        com.xiphias.browser.scanner.g r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
        r1 = null;
    L5:
        r1.b().setVisibility(8);
        com.xiphias.browser.scanner.g r7 = r6.uiBinding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
    L9:
        r2.c().setVisibility(0);
        return;
    L8:
        r2 = r7;
        goto L9
    }

    private final boolean isActivityUnavailable() {
        if (isFinishing() == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 17) goto L7;
    L9:
        return false;
    L7:
        if (isDestroyed() == false) goto L9;
        goto L9
    }

    private final boolean isPreviewSurfaceReady(int r3) {
        AutoFitSurfaceView r0 = this.surfaceView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r0 = null;
    L5:
        Surface r1 = r0.getHolder().getSurface();
        if (this.canStartCapture == true) goto L8;
    L14:
        return false;
    L8:
        if (r3 != this.surfaceGeneration) goto L14;
        if (isActivityUnavailable() == true) goto L14;
        if (r1.isValid() == false) goto L14;
        return true;
    }

    static /* synthetic */ boolean isPreviewSurfaceReady$default(ScannerActivity r1, int r2, int r3, Object r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r1, ScannerActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = r5.surfaceGeneration;
    L6:
        return r5.isPreviewSurfaceReady(r2);
    }

    /* JADX INFO: renamed from: lambda$-Pr4QcQd3Y32pC4kXnYmYPWv9Wk, reason: not valid java name */
    public static /* synthetic */ void m1401lambda$Pr4QcQd3Y32pC4kXnYmYPWv9Wk(ScannerActivity r0, Throwable r1) {
        onDocumentCapturePreparationFailed$lambda$29(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$-XucxMUlKm_UmUBW_GTVZRvRp3c, reason: not valid java name */
    public static /* synthetic */ void m1402lambda$XucxMUlKm_UmUBW_GTVZRvRp3c(ScannerActivity r0) {
        beginVisualCapture$lambda$20(r0);
    }

    /* JADX INFO: renamed from: lambda$0Si_1usPqkqMhK4sW-OKDkljM_k, reason: not valid java name */
    public static /* synthetic */ void m1403lambda$0Si_1usPqkqMhK4sWOKDkljM_k(ScannerActivity r0, DialogInterface r1, int r2) {
        showRequestPermissionDialog$lambda$13(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$19d0nhe5nbW-ZQ4sVu0cTRAGJA0, reason: not valid java name */
    public static /* synthetic */ void m1404lambda$19d0nhe5nbWZQ4sVu0cTRAGJA0(ScannerActivity r0, Uri r1) {
        handleDocumentImage$lambda$23(r0, r1);
    }

    public static /* synthetic */ void lambda$1njNrr86MfAKcg17298gErB5bjk(ScannerActivity r0) {
        stopCaptureRequest$lambda$35(r0);
    }

    public static /* synthetic */ void lambda$4RY166z0zzELX4zCRfQAA4bWwAA(Bitmap r0, ScannerActivity r1, int r2) {
        captureDocument$lambda$25(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$5l33OIzGQ7jfDmmU0a-6Rl2CxWQ, reason: not valid java name */
    public static /* synthetic */ void m1405lambda$5l33OIzGQ7jfDmmU0a6Rl2CxWQ(ScannerActivity r0, Uri r1) {
        handleVisualImage$lambda$17(r0, r1);
    }

    public static /* synthetic */ void lambda$8RXpvryvcntx4Ow_ccSnlSq3vVg(ScannerActivity r0, Exception r1) {
        onVisualCaptureFailed$lambda$22(r0, r1);
    }

    public static /* synthetic */ void lambda$9pb86TDMesnhZqPGXPBJiwJaA9U(Function0 r0) {
        runOnCameraThread$lambda$37(r0);
    }

    public static /* synthetic */ void lambda$Bk8Jez4znP3TJnZ36nafp8kbkXs(ScannerActivity r0) {
        inactiveScanner$lambda$11(r0);
    }

    public static /* synthetic */ void lambda$FZTYb1eQKuMeen2GciFbpHwhHEA(ScannerActivity r0) {
        beginDocumentCapture$lambda$26(r0);
    }

    public static /* synthetic */ Unit lambda$HkBs77kC3ZK2EVQgruejvtNHnZw(ScannerActivity r0) {
        return stopCameraDevice$lambda$48(r0);
    }

    public static /* synthetic */ void lambda$M8f1j9dhZGyu6tcSYXXB5hx4xCg(ScannerActivity r0, Bitmap r1) {
        captureDocument$lambda$25$lambda$24(r0, r1);
    }

    public static /* synthetic */ void lambda$UluFPMF8BgdMdSvATFV0jBmtvGk(Bitmap r0, ScannerActivity r1, int r2) {
        captureVisualSearch$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$UuRTfUFPrsknanVn7zLrshH1mug(ScannerActivity r0) {
        closeAndFinish$lambda$9(r0);
    }

    public static /* synthetic */ void lambda$W9IHtllFtXeYveSzJN8gfVAwWOU(ScannerActivity r0, Runnable r1) {
        startPreview$lambda$33(r0, r1);
    }

    public static /* synthetic */ void lambda$Xxk0GNrn4dYD9I41Qq1DMMI8rK4(ScannerActivity r0) {
        activeScanner$lambda$10(r0);
    }

    public static /* synthetic */ void lambda$ZAXGfjt4bhqWyq1zaHC9T8WEGcA(ScannerActivity r0, int r1, int r2, Bitmap r3, int r4) {
        captureBitmapFromSurface$lambda$53(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$aOIHGlOcGj-JO27U2HwW_2FJXA8, reason: not valid java name */
    public static /* synthetic */ void m1406lambda$aOIHGlOcGjJO27U2HwW_2FJXA8(ScannerActivity r0, com.xiphias.browser.scanner.b.c r1) {
        createVisualSearchSession$lambda$21(r0, r1);
    }

    public static /* synthetic */ void lambda$ar1zq1LrYvtVZb1mHZ5yx62paOU(ScannerActivity r0, ActivityResult r1) {
        openGalleryRequest$lambda$2(r0, r1);
    }

    public static /* synthetic */ void lambda$eYweqVZosLLrHp2A5thzCGutliA(ScannerActivity r0, ActivityResult r1) {
        documentProcessingRequest$lambda$3(r0, r1);
    }

    public static /* synthetic */ void lambda$gIikOv7iQBsjcKdODONSHQR9fG0(Function0 r0) {
        runOnCameraThread$lambda$36(r0);
    }

    public static /* synthetic */ void lambda$gNXzNaXJxnc6tej6uee2C5q6V1Y(ScannerActivity r0) {
        startCaptureRequest$lambda$34(r0);
    }

    public static /* synthetic */ void lambda$hrxRqMQi2bS3lwf1k_K94ueyONE(ScannerActivity r0) {
        captureBitmapFromSurface$lambda$53$lambda$52(r0);
    }

    public static /* synthetic */ void lambda$lyUQf7Gb8MXyGyOUonxqFAukYNc(ScannerActivity r0, DialogInterface r1, int r2) {
        showRequestPermissionDialog$lambda$12(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$mFBbhDyMWBLmJXnRTku6Dbu6JUk(ScannerActivity r0, Uri r1, com.xiphias.browser.scanner.c r2) {
        launchDocumentProcessing$lambda$28(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$qPjvXXXR246Bfnxdz75WXps_UwI(ScannerActivity r0, int r1) {
        openCamera$lambda$30(r0, r1);
    }

    public static /* synthetic */ void lambda$rvRmPLxaZA3p_wme2wwbD9FwPdc(ScannerActivity r0, int r1) {
        showToast$lambda$54(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$u_qDd3bnouVwk3o23Q1o6q-ttNo, reason: not valid java name */
    public static /* synthetic */ Result m1407lambda$u_qDd3bnouVwk3o23Q1o6qttNo(ScannerActivity r0, HandlerThread r1) {
        return stopBackgroundThread$lambda$62(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$v2tuuxFBHx2_sWeE778Ooo2i-IE, reason: not valid java name */
    public static /* synthetic */ void m1408lambda$v2tuuxFBHx2_sWeE778Ooo2iIE(boolean r0, ScannerActivity r1, float r2) {
        applyCameraZoomFactor$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$vBF4CW0xaZMR_tF53FTSE9E5wPM(ScannerActivity r0, Bitmap r1) {
        captureVisualSearch$lambda$19$lambda$18(r0, r1);
    }

    public static /* synthetic */ void lambda$vFVsHqAgCRGXy2Akxbyjipy6d8E(Function0 r0) {
        stopBackgroundThread$lambda$63(r0);
    }

    public static /* synthetic */ void lambda$xjkXES2oVNfavf9Flo5vZLIMTCY(ScannerActivity r0, int r1, int r2, Handler r3) {
        openCamera$lambda$31(r0, r1, r2, r3);
    }

    private final void launchDocumentProcessing(Bitmap r5) {
        final com.xiphias.browser.scanner.c r0 = this.documentScanConfig;
        if (r0 == null) goto L7;
        final Uri r6 = com.xiphias.browser.scanner.a.c.f16320a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r5, r0.c());
        runOnUiThread(new $$Lambda$ScannerActivity$mFBbhDyMWBLmJXnRTku6Dbu6JUk(this, r6, r0));
        return;
    L7:
        throw new IllegalStateException("Document scan is not configured".toString());
    }

    private static final void launchDocumentProcessing$lambda$28(ScannerActivity r4, Uri r5, com.xiphias.browser.scanner.c r6) {
        ScannerActivity r7 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r4, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r7.isActivityUnavailable() == false) goto L5;
        return;
    L5:
        r7.stopMotionDetector();
        r7.stopFrameCapture();
        r7.scannerManager.b();
        r7.stopCameraDevice();
        r7.documentProcessingRequest.launch(com.xiphias.browser.scanner.a.b.f16319a.a((Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.memorydata.plugin"), r5, r6));
    }

    private final void markCameraPermissionDenied() {
        getSharedPreferences("scanner_prefs", 0).edit().putBoolean("camera_permission_denied", true).apply();
    }

    private final void onDocumentCapturePreparationFailed(final Throwable r3) {
        Log.e(TAG, "Document capture preparation failed", r3);
        this.documentCaptureInFlight = false;
        runOnUiThread(new $$Lambda$ScannerActivity$Pr4QcQd3Y32pC4kXnYmYPWv9Wk(this, r3));
    }

    private static final void onDocumentCapturePreparationFailed$lambda$29(ScannerActivity r5, Throwable r6) {
        ScannerActivity r7 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r5, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r7.isActivityUnavailable() == false) goto L5;
        return;
    L5:
        View r0 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.capture_visual_search, OaidModel.KEY_ID, "capture_visual_search"));
        if (r0 == null) goto L8;
        r0.setEnabled(true);
    L8:
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.barcode_scan_hint, OaidModel.KEY_ID, "barcode_scan_hint")), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.setText(ZeusTransformUtils.mapRes(R.string.document_scan_hint, TypedValues.Custom.S_STRING, "document_scan_hint"));
    L11:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.memorydata.plugin");
        String r8 = r6.getMessage();
        if (r8 != null) goto L14;
        r8 = r7.getString(ZeusTransformUtils.mapRes(R.string.document_scan_failed, TypedValues.Custom.S_STRING, "document_scan_failed"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
    L14:
        Toast.makeText(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
    }

    private final void onMotionStateChanged(MotionDetector.State r3) {
        Log.d(TAG, "onMotionStateChanged, state = " + r3);
        if (this.isInSelectingPicture == false) goto L6;
        return;
    L6:
        if (r3 != MotionDetector.State.INACTIVE) goto L9;
        inactiveScanner();
        return;
    }

    private final void onVisualCaptureFailed(final Exception r4) {
        Log.e(TAG, "Visual search capture failed", (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        this.visualCaptureInFlight = false;
        runOnUiThread(new $$Lambda$ScannerActivity$8RXpvryvcntx4Ow_ccSnlSq3vVg(this, r4));
    }

    private static final void onVisualCaptureFailed$lambda$22(ScannerActivity r13, Exception r14) {
        ScannerActivity r15 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r13, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r15.isActivityUnavailable() == false) goto L5;
        return;
    L5:
        View r0 = r15.findViewById(ZeusTransformUtils.mapRes(R.id.capture_visual_search, OaidModel.KEY_ID, "capture_visual_search"));
        if (r0 == null) goto L8;
        r0.setEnabled(true);
    L8:
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(ZeusTransformUtils.mapRes(R.id.barcode_scan_hint, OaidModel.KEY_ID, "barcode_scan_hint")), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        r1.setText(ZeusTransformUtils.mapRes(R.string.vision_search_hint, TypedValues.Custom.S_STRING, "vision_search_hint"));
    L11:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(r15, Context.class, "com.obric.memorydata.plugin");
        String r16 = r14.getMessage();
        if (r16 != null) goto L14;
        String r17 = r15.getString(ZeusTransformUtils.mapRes(R.string.vision_search_capture_failed, TypedValues.Custom.S_STRING, "vision_search_capture_failed"));
        Intrinsics.checkNotNullExpressionValue(r17, "getString(...)");
        String r6 = r17;
    L15:
        new com.obric.oui.toast.a(r5, r6, 80, false, null, 0, 56, null).d();
        return;
    L14:
        r6 = r16;
        goto L15
    }

    private final void openBrowserPermissionManager() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.obric.security", "com.bytedanceos.security.NativePackageDetail"));
        r0.setAction("com.bytedanceos.security.action.NATIVE_PACKAGE_DETAIL");
        r0.putExtra(MemoryListActivity.JUMP_FROM_DETAIL, (Parcelable) ZeusTransformUtils.preCheckCast(getPackageManager().getPackageInfo(getPackageName(), 0), Parcelable.class, "com.obric.memorydata.plugin"));
        r0.putExtra("from_security_center", false);
        r0.putExtra("extra_outer", false);
        ZeusTransformUtils.startActivity(this, r0, "com.obric.memorydata.plugin");
    }

    private final void openBrowserSettingOnAndroid15() {
        CharSequence r2 = null;
        if (com.obric.matrix.platform.sdk.ones.region.a.f8122a.b() == false) goto L8;
        Intent r0 = new Intent("com.android.permissioncontroller.permissionplus.AppPermissionGroup");
        r0.putExtra("PACKAGE_NAME", getPackageName());
        ApplicationInfo r3 = getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo;
        if (r3 == null) goto L7;
        r2 = r3.loadLabel(getPackageManager());
    L7:
        r0.putExtra("APP_NAME", r2);
    L9:
        ZeusTransformUtils.startActivity(this, r0, "com.obric.memorydata.plugin");
        return;
    L8:
        Intent r1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r1.setData(Uri.fromParts("package", getPackageName(), null));
        setIntent(r1);
        r0 = getIntent();
        goto L9
    }

    private final void openCamera() {
        if (isPreviewSurfaceReady$default(this, 0, 1, null) == true) goto L6;
        return;
    L6:
        if (this.cameraDevice == null) goto L8;
        return;
    L8:
        if (this.isOpeningCamera == false) goto L11;
        return;
    L11:
        if (ActivityCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "android.permission.CAMERA") == 0) goto L14;
        Log.e(TAG, "permission is denied, can not open camera!");
        return;
    L14:
        final Handler r0 = this.backgroundHandler;
        if (r0 != null) goto L17;
        return;
    L17:
        final int r2 = this.surfaceGeneration;
        this.openingCameraGeneration++;
        final int r3 = this.openingCameraGeneration;
        this.openingSurfaceGeneration = r2;
        this.isOpeningCamera = true;
        this.mainHandler.postDelayed(new $$Lambda$ScannerActivity$qPjvXXXR246Bfnxdz75WXps_UwI(this, r3), 5000);
        r0.post(new $$Lambda$ScannerActivity$xjkXES2oVNfavf9Flo5vZLIMTCY(this, r2, r3, r0));
    }

    private static final void openCamera$lambda$30(ScannerActivity r2, int r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r4.isOpeningCamera == true) goto L5;
        return;
    L5:
        if (r4.openingCameraGeneration != r3) goto L9;
        Log.w(TAG, "openCamera timeout, generation=" + r3);
        r4.isOpeningCamera = false;
        r4.openingSurfaceGeneration = -1;
        r4.openingCameraGeneration++;
        r4.stopFrameCapture();
        return;
    }

    private static final void openCamera$lambda$31(ScannerActivity r8, int r9, int r10, Handler r11) {
        ScannerActivity r12 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r8, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r12.isPreviewSurfaceReady(r9) == false) goto L27;
        if (r12.openingCameraGeneration != r10) goto L27;
        Object r0 = r12.getSystemService("camera");     // Catch: Exception -> L20
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");     // Catch: Exception -> L20
        CameraManager r1 = (CameraManager) ZeusTransformUtils.preCheckCast(r0, CameraManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        String[] r3 = r1.getCameraIdList();     // Catch: Exception -> L20
        Intrinsics.checkNotNullExpressionValue(r3, "getCameraIdList(...)");     // Catch: Exception -> L20
        String r4 = (String) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        if (r4 == null) goto L10;
        CameraCharacteristics r5 = r1.getCameraCharacteristics(r4);     // Catch: Exception -> L20
        Intrinsics.checkNotNullExpressionValue(r5, "getCameraCharacteristics(...)");     // Catch: Exception -> L20
        r12.cameraZoomRange = (Range) ZeusTransformUtils.preCheckCast(r5.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE), Range.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        Range<Float> r6 = r12.cameraZoomRange;     // Catch: Exception -> L20
        float r7 = 1.0f;
        if (r6 == null) goto L18;
        Float r13 = (Float) ZeusTransformUtils.preCheckCast(r6.clamp((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(1.0f), Comparable.class, "com.obric.memorydata.plugin")), Float.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        if (r13 == null) goto L18;
        r7 = r13.floatValue();     // Catch: Exception -> L20
    L18:
        r12.cameraZoomFactor = r7;     // Catch: Exception -> L20
        r1.openCamera(r4, (CameraDevice.StateCallback) ZeusTransformUtils.preCheckCast(r12.createStateCallback(r9, r10), CameraDevice.StateCallback.class, "com.obric.memorydata.plugin"), r11);     // Catch: Exception -> L20
        return;
    L10:
        if (r12.openingCameraGeneration != r10) goto L31;
        r12.isOpeningCamera = false;     // Catch: Exception -> L20
        return;
    L31:
        return;
    L20:
        e = move-exception;
        if (r12.openingCameraGeneration != r10) goto L24;
        r12.isOpeningCamera = false;
    L24:
        Log.e(TAG, "open camera failed, exception: " + e);
        return;
    L27:
        if (r12.openingCameraGeneration != r10) goto L33;
        r12.isOpeningCamera = false;
        return;
    }

    private final void openGallery() {
        this.isInSelectingPicture = true;
        pauseScannerPipelineForExternalUi();
        this.openGalleryRequest.launch(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "openGallery failed: " + e + ", try to use ACTION_GET_CONTENT");
        Intent r0 = new Intent("android.intent.action.GET_CONTENT");     // Catch: Exception -> L9
        r0.setType("image/*");     // Catch: Exception -> L9
        this.openGalleryRequest.launch(r0);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "openGallery failed with ACTION_GET_CONTENT: " + e);
        this.isInSelectingPicture = false;
        resumeScannerPipelineIfVisible();
        com.obric.oui.toast.a.f14807a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "No gallery app found", 80);
    }

    private static final void openGalleryRequest$lambda$2(ScannerActivity r3, ActivityResult r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        MotionDetector r0 = r5.motionDetector;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        Uri r2 = null;
        if (r4.getResultCode() != (-1)) goto L10;
        Intent r6 = r4.getData();
        if (r6 == null) goto L10;
        r2 = r6.getData();
    L10:
        r5.isInSelectingPicture = false;
        if (r5.currentMode.isVisualSearch() == false) goto L17;
        r5.openCamera();
        if (r2 == null) goto L27;
        r5.handleVisualImage(r2);
        return;
    L27:
        return;
    L17:
        if (r5.currentMode != ScannerMode.DOCUMENT) goto L23;
        r5.openCamera();
        if (r2 == null) goto L28;
        r5.handleDocumentImage(r2);
        return;
    L28:
        return;
    L23:
        if (r5.resumeScannerPipelineIfVisible() == false) goto L29;
        if (r2 == null) goto L30;
        r5.handleImage(r2);
        return;
    L30:
        return;
    }

    private final void pauseScannerPipelineForExternalUi() {
        stopFrameCapture();
        this.scannerManager.b();
        stopCaptureRequest();
    }

    private final void requestCameraPermission() {
        ActivityCompat.requestPermissions((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), new String[]{"android.permission.CAMERA"}, 100);
    }

    private final void requestCameraPermissionIfNeeded() {
        if (this.permissionRequestState != PermissionRequestState.STARTED) goto L5;
        return;
    L5:
        this.permissionRequestState = PermissionRequestState.STARTED;
    L13:
        e = move-exception;
        Log.e(TAG, "open camera failed, exception: " + e);
        return;
    L7:
        if (ActivityCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "android.permission.CAMERA") != 0) goto L9;
        return;
    L9:
        if (hasDeniedCameraPermissionBefore() == false) goto L11;
        showRequestPermissionDialog();     // Catch: CameraAccessException -> L13
        return;
    L11:
        requestCameraPermission();     // Catch: CameraAccessException -> L13
    }

    private final boolean resumeScannerPipelineIfVisible() {
        if (this.uiBinding != null) goto L5;
    L18:
        return false;
    L5:
        if (isActivityUnavailable() == true) goto L18;
        com.xiphias.browser.scanner.g r0 = this.uiBinding;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
        r0 = null;
    L11:
        if (r0.b().getVisibility() == 0) goto L14;
        return false;
    L14:
        if (this.currentMode != ScannerMode.BARCODE) goto L16;
        this.scannerManager.a();
    L16:
        openCamera();
        return true;
    }

    private final void runOnCameraThread(Function0<Unit> r3) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Handler r2 = this.backgroundHandler;
        if (r2 == null) goto L6;
        r2.post(new $$Lambda$ScannerActivity$gIikOv7iQBsjcKdODONSHQR9fG0(r4));
        return;
    L6:
        new Thread(new $$Lambda$ScannerActivity$9pb86TDMesnhZqPGXPBJiwJaA9U(r4), "CameraShutdown").start();
    }

    private static final void runOnCameraThread$lambda$36(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final void runOnCameraThread$lambda$37(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private final void scheduleNextFrameCapture() {
        if (canCaptureFrame() == true) goto L5;
        return;
    L5:
        startFrameCapture(CAPTURE_INTERVAL_MS);
    }

    private final void selectMode(ScannerMode r5) {
        if (this.enabledModes.contains(r5) == true) goto L5;
        return;
    L5:
        if (r5 != this.currentMode) goto L7;
        return;
    L7:
        if (this.visualCaptureInFlight == false) goto L9;
        return;
    L9:
        if (this.documentCaptureInFlight == false) goto L12;
        return;
    L12:
        if (this.currentMode == ScannerMode.BARCODE) goto L14;
    L16:
        this.currentMode = r5;
        MotionDetector r0 = this.motionDetector;
        if (r0 == null) goto L19;
        r0.c();
    L19:
        ScannerMaskView r3 = null;
        if (r5 != ScannerMode.BARCODE) goto L25;
        this.scannerManager.a();
        ScannerMaskView r6 = this.scannerMaskView;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
        r6 = null;
    L24:
        r6.setLaserAnimationEnabled(true);
        startFrameCapture$default(this, 0, 1, null);
        return;
    L25:
        stopFrameCapture();
        this.scannerManager.b();
        ScannerMaskView r4 = this.scannerMaskView;
        if (r4 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
    L29:
        r3.setLaserAnimationEnabled(false);
        return;
    L28:
        r3 = r4;
        goto L29
    L14:
        if (r5 == ScannerMode.BARCODE) goto L16;
        applyCameraZoomFactor(1.0f, false);
        goto L16
    }

    private final void setupStatusBarForScannerDarkBackground() {
        WindowInsetsControllerCompat r1 = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        if (r1 == null) goto L6;
        r1.setAppearanceLightStatusBars(false);
        return;
    }

    private final void showRequestPermissionDialog() {
        com.obric.oui.dialog.v2.alert.b r1 = com.obric.oui.dialog.v2.alert.b.a(com.obric.oui.dialog.v2.alert.b.b(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).a(ZeusTransformUtils.mapRes(R.string.web_permission_dialog_title, TypedValues.Custom.S_STRING, "web_permission_dialog_title")).b(ZeusTransformUtils.mapRes(R.string.request_camera_permission_hint, TypedValues.Custom.S_STRING, "request_camera_permission_hint")), ZeusTransformUtils.mapRes(R.string.browser_cancel, TypedValues.Custom.S_STRING, "browser_cancel"), new $$Lambda$ScannerActivity$lyUQf7Gb8MXyGyOUonxqFAukYNc(this), null, 4, null), ZeusTransformUtils.mapRes(R.string.go_to_settings, TypedValues.Custom.S_STRING, "go_to_settings"), new $$Lambda$ScannerActivity$0Si_1usPqkqMhK4sWOKDkljM_k(this), null, 4, null);
        if (com.xiphias.browser.scanner.util.c.f16358a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")) == true) goto L6;
        r1.h();
        return;
    }

    private static final void showRequestPermissionDialog$lambda$12(ScannerActivity r1, DialogInterface r2, int r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r1, ScannerActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        Log.e(TAG, "request camera permission denied!");
        r5.dismiss();
        r4.closeAndFinish();
    }

    private static final void showRequestPermissionDialog$lambda$13(ScannerActivity r1, DialogInterface r2, int r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r1, ScannerActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        r4.permissionRequestState = PermissionRequestState.NOT_STARTED;
        if (Build.VERSION.SDK_INT <= 34) goto L5;
        r4.openBrowserSettingOnAndroid15();
    L6:
        r5.dismiss();
        return;
    L5:
        r4.openBrowserPermissionManager();
        goto L6
    }

    private final void showToast(final int r2) {
        runOnUiThread(new $$Lambda$ScannerActivity$rvRmPLxaZA3p_wme2wwbD9FwPdc(this, r2));
    }

    private static final void showToast$lambda$54(ScannerActivity r9, int r10) {
        ScannerActivity r11 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r9, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r11.isFinishing() == false) goto L6;
        Log.e(TAG, "activity is finishing.");
        return;
    L6:
        String r2 = r11.getString(r10);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        new com.obric.oui.toast.a((Context) ZeusTransformUtils.preCheckCast(r11, Context.class, "com.obric.memorydata.plugin"), r2, 80, false, null, 0, 56, null).d();
    }

    private final void startBackgroundThread() {
        HandlerThread r0 = new HandlerThread("CameraBackground");
        r0.start();
        this.backgroundThread = r0;
        HandlerThread r1 = this.backgroundThread;
        Intrinsics.checkNotNull(r1);
        this.backgroundHandler = new Handler(r1.getLooper());
    }

    private final void startCaptureRequest() {
        Handler r0 = this.backgroundHandler;
        if (r0 == null) goto L6;
        r0.post(new $$Lambda$ScannerActivity$gNXzNaXJxnc6tej6uee2C5q6V1Y(this));
        return;
    }

    private static final void startCaptureRequest$lambda$34(ScannerActivity r5) {
        ScannerActivity r6 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r5, ScannerActivity.class, "com.obric.memorydata.plugin");
        AutoFitSurfaceView r1 = r6.surfaceView;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r1 = null;
    L6:
        if (r1.getHolder().getSurface().isValid() == true) goto L9;
        return;
    L9:
        if (r6.canStartCapture == true) goto L11;
        return;
    L11:
        if (r6.cameraDevice != null) goto L14;
        return;
    L14:
        if (r6.captureSession == null) goto L36;
        CaptureRequest.Builder r2 = r6.captureRequestBuilder;
        if (r2 != null) goto L19;
        return;
    L19:
        if (r6.isTorchOn == false) goto L21;
        int r3 = 2;
    L33:
        Intrinsics.checkNotNull(r2);     // Catch: CameraAccessException -> L26 IllegalStateException -> L30
        r2.set(CaptureRequest.FLASH_MODE, Integer.valueOf(r3));     // Catch: CameraAccessException -> L26 IllegalStateException -> L30
        CameraCaptureSession r4 = r6.captureSession;     // Catch: CameraAccessException -> L26 IllegalStateException -> L30
        if (r4 == null) goto L35;
        CaptureRequest.Builder r7 = r6.captureRequestBuilder;     // Catch: CameraAccessException -> L26 IllegalStateException -> L30
        Intrinsics.checkNotNull(r7);     // Catch: CameraAccessException -> L26 IllegalStateException -> L30
        r4.setRepeatingRequest(r7.build(), null, null);     // Catch: CameraAccessException -> L26 IllegalStateException -> L30
        return;
    L35:
        return;
    L26:
        e = move-exception;
        StringBuilder r8 = new StringBuilder().append("startCaptureRequest camera access failed: ").append(e);
    L28:
        Log.e(TAG, r8.toString());
        return;
    L30:
        e = move-exception;
        r8 = new StringBuilder().append("startCaptureRequest failed: session is closed, ").append(e.getMessage());
        goto L28
    L21:
        r3 = 0;
        goto L33
    }

    private final void startFrameCapture(long r5) {
        this.mainHandler.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.captureRunnable, Runnable.class, "com.obric.memorydata.plugin"));
        if (canCaptureFrame() == true) goto L5;
        return;
    L5:
        this.mainHandler.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this.captureRunnable, Runnable.class, "com.obric.memorydata.plugin"), r5);
    }

    static /* synthetic */ void startFrameCapture$default(ScannerActivity r1, long r2, int r4, Object r5) {
        ScannerActivity r3 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r1, ScannerActivity.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = 0;
    L5:
        r3.startFrameCapture(r2);
    }

    private final void startMotionDetector() {
        MotionDetector r0 = new MotionDetector((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function1.class, "com.obric.memorydata.plugin"));
        this.motionDetector = r0;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    private final void startPreview(int r9) {
        if (this.cameraDevice != null) goto L5;
        return;
    L5:
        if (isPreviewSurfaceReady(r9) == false) goto L35;
        AutoFitSurfaceView r1 = this.surfaceView;     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        r1 = null;
    L10:
        Surface r2 = r1.getHolder().getSurface();     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        if (r2.isValid() == true) goto L13;
        return;
    L13:
        if (r9 != this.surfaceGeneration) goto L31;
        CameraDevice r3 = this.cameraDevice;     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        Intrinsics.checkNotNull(r3);     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        CaptureRequest.Builder r4 = r3.createCaptureRequest(1);     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        this.captureRequestBuilder = r4;     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        Intrinsics.checkNotNull(r4);     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        r4.addTarget(r2);     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        Range<Float> r5 = this.cameraZoomRange;     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        if (r5 == null) goto L19;
        CaptureRequest.Builder r6 = this.captureRequestBuilder;     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        Intrinsics.checkNotNull(r6);     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        r6.set(CaptureRequest.CONTROL_ZOOM_RATIO, r5.clamp((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(this.cameraZoomFactor), Comparable.class, "com.obric.memorydata.plugin")));     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
    L19:
        SessionConfiguration r7 = new SessionConfiguration(0, CollectionsKt.listOf(new OutputConfiguration(r2)), new $$Lambda$ScannerActivity$W9IHtllFtXeYveSzJN8gfVAwWOU(this), (CameraCaptureSession.StateCallback) ZeusTransformUtils.preCheckCast(new g(this, r9), CameraCaptureSession.StateCallback.class, "com.obric.memorydata.plugin"));     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        CameraDevice r8 = this.cameraDevice;     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
        if (r8 == null) goto L33;
        r8.createCaptureSession(r7);     // Catch: CameraAccessException -> L24 IllegalArgumentException -> L26
    L36:
        return;
    L33:
        return;
    L31:
        return;
    L24:
        e = move-exception;
        Log.e(TAG, "startPreview camera access failed: " + e);
        return;
    L26:
        e = move-exception;
        Log.w(TAG, "startPreview skipped: surface abandoned, " + e.getMessage());
        return;
    }

    static /* synthetic */ void startPreview$default(ScannerActivity r1, int r2, int r3, Object r4) {
        ScannerActivity r5 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r1, ScannerActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = r5.surfaceGeneration;
    L5:
        r5.startPreview(r2);
    }

    private static final void startPreview$lambda$33(ScannerActivity r2, Runnable r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Handler r6 = r4.backgroundHandler;
        if (r6 == null) goto L6;
        r6.post(r5);
        return;
    }

    private final void stopBackgroundThread() {
        final HandlerThread r0 = this.backgroundThread;
        if (r0 != null) goto L5;
        return;
    L5:
        this.backgroundThread = null;
        this.backgroundHandler = null;
        r0.quitSafely();
        final Function0 r1 = new $$Lambda$ScannerActivity$u_qDd3bnouVwk3o23Q1o6qttNo(this, r0);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        new Thread(new $$Lambda$ScannerActivity$vFVsHqAgCRGXy2Akxbyjipy6d8E(r1), "CameraBackgroundJoiner").start();
        return;
    L8:
        r1.invoke();
    }

    private static final Result stopBackgroundThread$lambda$62(ScannerActivity r2, HandlerThread r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScannerActivity.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        r3.join(5000);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L11;
        Log.w(TAG, "join CameraBackground failed", r7);
    L11:
        return Result.m1420boximpl(r6);
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final void stopBackgroundThread$lambda$63(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private final void stopCameraDevice() {
        stopFrameCapture();
        this.openingCameraGeneration++;
        this.openingSurfaceGeneration = -1;
        this.isOpeningCamera = false;
        runOnCameraThread(new $$Lambda$ScannerActivity$HkBs77kC3ZK2EVQgruejvtNHnZw(this));
    }

    private static final Unit stopCameraDevice$lambda$48(ScannerActivity r6) {
        ScannerActivity r7 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r6, ScannerActivity.class, "com.obric.memorydata.plugin");
        CameraCaptureSession r0 = r7.captureSession;
        if (r0 != null) goto L44;
    L26:
        r7.captureRequestBuilder = null;
        r7.cameraZoomRange = null;
        r7.cameraZoomFactor = 1.0f;
        CameraDevice r1 = r7.cameraDevice;
        if (r1 != null) goto L38;
    L36:
        r7.isOpeningCamera = false;
        r7.openingSurfaceGeneration = -1;
        return Unit.INSTANCE;
    L38:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L30
        r1.close();     // Catch: Throwable -> L30
        Object r2 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r2);
        if (r4 == null) goto L35;
        Log.w(TAG, "close cameraDevice failed: " + r4.getMessage());
    L35:
        r7.cameraDevice = null;
    L30:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L32
    L44:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L6
        r0.stopRepeating();     // Catch: Throwable -> L6
        Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L40;
        Log.w(TAG, "stopRepeating before close failed: " + r10.getMessage());
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        r0.abortCaptures();     // Catch: Throwable -> L13
        Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L42;
        Log.w(TAG, "abortCaptures before close failed: " + r13.getMessage());
    L42:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20
        r0.close();     // Catch: Throwable -> L20
        Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L25;
        Log.w(TAG, "close captureSession failed: " + r16.getMessage());
    L25:
        r7.captureSession = null;
    L20:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L6:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void stopCaptureRequest() {
        Handler r0 = this.backgroundHandler;
        if (r0 == null) goto L6;
        r0.post(new $$Lambda$ScannerActivity$1njNrr86MfAKcg17298gErB5bjk(this));
        return;
    }

    private static final void stopCaptureRequest$lambda$35(ScannerActivity r3) {
        ScannerActivity r4 = (ScannerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScannerActivity.class, "com.obric.memorydata.plugin");
        if (r4.canStartCapture == true) goto L5;
        return;
    L5:
        if (r4.cameraDevice == null) goto L20;
        CameraCaptureSession r5 = r4.captureSession;     // Catch: IllegalStateException -> L11 CameraAccessException -> L13
        if (r5 == null) goto L19;
        r5.stopRepeating();     // Catch: IllegalStateException -> L11 CameraAccessException -> L13
    L21:
        return;
    L19:
        return;
    L13:
        String r6 = "stop camera session failed!";
    L14:
        Log.e(TAG, r6);
        return;
    L11:
        e = move-exception;
        r6 = "stopCaptureRequest session closed: " + e.getMessage();
        goto L14
    }

    private final void stopCaptureThread() {
        HandlerThread r0 = this.captureThread;
        if (r0 != null) goto L5;
        return;
    L5:
        this.captureThread = null;
        this.captureHandler = null;
        r0.quitSafely();
    }

    private final void stopFrameCapture() {
        this.mainHandler.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.captureRunnable, Runnable.class, "com.obric.memorydata.plugin"));
        this.captureInFlight = false;
    }

    private final void stopMotionDetector() {
        MotionDetector r0 = this.motionDetector;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.motionDetector = null;
    }

    private final void toggleFlashlight() {
        if (this.captureSession != null) goto L5;
        return;
    L5:
        if (this.captureRequestBuilder == null) goto L10;
        this.isTorchOn = !this.isTorchOn;
        startCaptureRequest();
        return;
    }

    private final void updateCameraPreviewRatio() {
        Object r1 = getSystemService("camera");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager r2 = (CameraManager) ZeusTransformUtils.preCheckCast(r1, CameraManager.class, "com.obric.memorydata.plugin");
        String[] r3 = r2.getCameraIdList();     // Catch: Exception -> L43
        Intrinsics.checkNotNullExpressionValue(r3, "getCameraIdList(...)");     // Catch: Exception -> L43
        boolean r5 = true;
        if (r3.length != 0) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L9;
        return;
    L9:
        CameraCharacteristics r6 = r2.getCameraCharacteristics(r3[0]);     // Catch: Exception -> L43
        Intrinsics.checkNotNullExpressionValue(r6, "getCameraCharacteristics(...)");     // Catch: Exception -> L43
        StreamConfigurationMap r7 = (StreamConfigurationMap) ZeusTransformUtils.preCheckCast(r6.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP), StreamConfigurationMap.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L43
        if (r7 != null) goto L12;
        return;
    L12:
        Size[] r8 = r7.getOutputSizes(SurfaceHolder.class);     // Catch: Exception -> L43
        if (r8 != null) goto L15;
    L21:
        if (r5 == true) goto L48;
        Size r9 = this.surfaceSize;     // Catch: Exception -> L43
        AutoFitSurfaceView r10 = null;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r9 = null;
    L26:
        int r11 = r9.getHeight();     // Catch: Exception -> L43
        Size r12 = this.surfaceSize;     // Catch: Exception -> L43
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r12 = null;
    L29:
        Size r13 = getOptimalPreviewSize(r8, r11, r12.getWidth());     // Catch: Exception -> L43
        if (r13 == null) goto L49;
        StringBuilder r14 = new StringBuilder().append("Selected optimal preview size: ").append(r13.getWidth()).append('x').append(r13.getHeight()).append(" for screen ");     // Catch: Exception -> L43
        Size r15 = this.surfaceSize;     // Catch: Exception -> L43
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r15 = null;
    L34:
        StringBuilder r16 = r14.append(r15.getWidth()).append('x');     // Catch: Exception -> L43
        Size r17 = this.surfaceSize;     // Catch: Exception -> L43
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r17 = null;
    L37:
        Log.i(TAG, r16.append(r17.getHeight()).toString());     // Catch: Exception -> L43
        AutoFitSurfaceView r18 = this.surfaceView;     // Catch: Exception -> L43
        if (r18 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");     // Catch: Exception -> L43
    L41:
        r10.a(r13.getWidth(), r13.getHeight(), 0.0f, false);     // Catch: Exception -> L43
        return;
    L40:
        r10 = r18;
        goto L41
    L49:
        return;
    L48:
        return;
    L15:
        if (r8.length != 0) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == true) goto L21;
        r5 = false;
        goto L21
    L17:
        r19 = false;
        goto L18
    L6:
        r4 = false;
    L43:
        e = move-exception;
        Log.e(TAG, "Failed to update camera preview ratio: " + e.getMessage());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r9) {
        startBackgroundThread();
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        this.surfaceSize = com.xiphias.browser.scanner.util.b.f16357a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        super.onCreate(r9);
        boolean r10 = com.xiphias.browser.scanner.f.f16343a.b(getIntent());
        this.documentScanConfig = com.xiphias.browser.scanner.f.f16343a.d(getIntent());
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(com.xiphias.browser.scanner.f.f16343a.f(getIntent()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L24;
        Object r4 = r1.next();
        ScannerMode r5 = (ScannerMode) ZeusTransformUtils.preCheckCast(r4, ScannerMode.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        if (r5.isVisualSearch() == false) goto L13;
        if (com.xiphias.browser.scanner.d.e == false) goto L11;
        if (r10 == false) goto L11;
    L22:
        if (r7 == false) goto L4;
        r2.add(r4);
    L11:
        r7 = false;
        goto L22
    L13:
        if (r5 != ScannerMode.DOCUMENT) goto L20;
        if (com.xiphias.browser.scanner.d.d == false) goto L11;
        if (this.documentScanConfig == null) goto L11;
    L20:
        if (r5 != ScannerMode.BARCODE) goto L22;
        r7 = com.xiphias.browser.scanner.d.f;
        goto L22
    L24:
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin");
        AutoFitSurfaceView r3 = null;
        if (r11.isEmpty() == false) goto L27;
        r11 = com.xiphias.browser.scanner.f.f16343a.f(null);
    L27:
        this.enabledModes = (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.memorydata.plugin");
        ScannerMode r12 = com.xiphias.browser.scanner.f.f16343a.e(getIntent());
        if (this.enabledModes.contains(r12) == true) goto L31;
        r12 = null;
    L31:
        if (r12 != null) goto L33;
        r12 = (ScannerMode) ZeusTransformUtils.preCheckCast(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(this.enabledModes, Iterable.class, "com.obric.memorydata.plugin")), ScannerMode.class, "com.obric.memorydata.plugin");
    L33:
        this.currentMode = r12;
        if (this.enabledModes.contains(ScannerMode.BARCODE) == false) goto L36;
        this.scannerManager.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), com.xiphias.browser.scanner.f.f16343a.c(getIntent()));
    L36:
        new Immersive((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin")).setup();
        setupStatusBarForScannerDarkBackground();
        WindowManager.LayoutParams r13 = getWindow().getAttributes();
        Intrinsics.checkNotNullExpressionValue(r13, "getAttributes(...)");
        com.obric.common.oea.style.scene.transition.a.a(r13, false, 2, null);
        com.xiphias.browser.scanner.g r14 = i.f16348a.a(com.xiphias.browser.scanner.f.f16343a.a(getIntent())).a((AppCompatActivity) ZeusTransformUtils.preCheckCast(this, AppCompatActivity.class, "com.obric.memorydata.plugin"), createUiController());
        this.scannerMaskView = r14.e();
        AutoFitSurfaceView r6 = r14.d();
        Size r8 = this.surfaceSize;
        if (r8 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");
        r8 = null;
    L39:
        int r15 = r8.getHeight();
        Size r16 = this.surfaceSize;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");
        r16 = null;
    L42:
        r6.a(r15, r16.getWidth(), 0.0f, false);
        this.surfaceView = r6;
        this.uiBinding = r14;
        updateCameraPreviewRatio();
        com.xiphias.browser.scanner.g r17 = this.uiBinding;
        if (r17 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
        r17 = null;
    L45:
        setContentView(r17.a());
        AutoFitSurfaceView r18 = this.surfaceView;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    L49:
        r3.getHolder().addCallback((SurfaceHolder.Callback) ZeusTransformUtils.preCheckCast(new e(this), SurfaceHolder.Callback.class, "com.obric.memorydata.plugin"));
        return;
    L48:
        r3 = r18;
        goto L49
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        closeAndFinish();
        this.scannerManager.c();
        stopBackgroundThread();
        stopCaptureThread();
        this.visualExecutor.shutdownNow();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        stopMotionDetector();
        this.scannerManager.b();
        ScannerMaskView r0 = this.scannerMaskView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
        r0 = null;
    L5:
        r0.setLaserAnimationEnabled(false);
        stopCameraDevice();
        getWindow().clearFlags(128);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        Intrinsics.checkNotNullParameter(r4, "grantResults");
        super.onRequestPermissionsResult(r2, r3, r4);
        if (r2 == 100) goto L5;
        return;
    L5:
        if (r4.length != 0) goto L7;
        boolean r5 = true;
    L9:
        if ((!r5) == true) goto L11;
    L13:
        markCameraPermissionDenied();
        showRequestPermissionDialog();
        return;
    L11:
        if (r4[0] != 0) goto L13;
        getSharedPreferences("scanner_prefs", 0).edit().putBoolean("camera_permission_denied", false).apply();
        openCamera();
        return;
    L7:
        r5 = false;
        goto L9
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        requestCameraPermissionIfNeeded();
        startMotionDetector();
        boolean r0 = false;
        this.visualCaptureInFlight = false;
        ScannerMaskView r4 = null;
        if (this.documentCaptureInFlight == false) goto L12;
        stopMotionDetector();
        this.scannerManager.b();
        ScannerMaskView r1 = this.scannerMaskView;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
    L8:
        r4.setLaserAnimationEnabled(false);
        this.isScannerPageVisibleForCapture = false;
    L9:
        getWindow().addFlags(128);
        return;
    L7:
        r4 = r1;
        goto L8
    L12:
        if (this.currentMode != ScannerMode.BARCODE) goto L14;
        this.scannerManager.a();
    L15:
        com.xiphias.browser.scanner.g r2 = this.uiBinding;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("uiBinding");
        r2 = null;
    L19:
        if (r2.b().getVisibility() != 0) goto L21;
        boolean r3 = true;
    L22:
        this.isScannerPageVisibleForCapture = r3;
        openCamera();
        ScannerMaskView r5 = this.scannerMaskView;
        if (r5 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
    L27:
        if (this.currentMode != ScannerMode.BARCODE) goto L29;
        r0 = true;
    L29:
        r4.setLaserAnimationEnabled(r0);
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.capture_visual_search, OaidModel.KEY_ID, "capture_visual_search"));
        if (r6 == null) goto L9;
        r6.setEnabled(true);
        goto L9
    L25:
        r4 = r5;
        goto L27
    L21:
        r3 = false;
        goto L22
    L14:
        this.scannerManager.b();
        goto L15
    }
}
