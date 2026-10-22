package com.larus.camera.impl.ui.component.capture;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.utils.a4;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.capture.ZoomRatio;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000÷\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0001a\u0018\u0000 ¬\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¬\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0014J\u0010\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020>H\u0014J\b\u0010n\u001a\u00020\u0007H\u0014J\b\u0010o\u001a\u00020\u0007H\u0002J\u0010\u0010p\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020f2\u0006\u0010s\u001a\u00020>H\u0002J\b\u0010t\u001a\u00020\u0017H\u0002J\b\u0010u\u001a\u00020\u0007H\u0003J \u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010y\u001a\u00020fH\u0002J\u0018\u0010z\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0017H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\n\u0010~\u001a\u0004\u0018\u00010\u007fH\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0007H\u0002J\u001e\u0010\u0081\u0001\u001a\u00020\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\u0014\u0010\u0086\u0001\u001a\u00020\u00072\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\t\u0010\u0088\u0001\u001a\u00020\u001eH\u0002J\u0016\u0010\u0089\u0001\u001a\u00020\u00072\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001eH\u0003J\u0011\u0010\u008b\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\u008e\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001b\u0010\u008f\u0001\u001a\u00020\u00072\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0006\u0010w\u001a\u00020xH\u0002J\u001a\u0010\u0099\u0001\u001a\u00020\u00072\u0007\u0010\u009a\u0001\u001a\u00020f2\u0006\u0010w\u001a\u00020xH\u0003J.\u0010\u0095\u0001\u001a\u00030\u0094\u00012\u0010\u0010\u009b\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u009c\u00012\u0010\u0010\u009d\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u009c\u0001H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020KH\u0002J\u000e\u0010\u009f\u0001\u001a\u00020\u000b*\u00030 \u0001H\u0002J\u0013\u0010¡\u0001\u001a\u00020\u00072\b\u0010¢\u0001\u001a\u00030 \u0001H\u0002J\t\u0010£\u0001\u001a\u00020\u0007H\u0002J\u001a\u0010¤\u0001\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0007\u0010¥\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010¦\u0001\u001a\u00020\u00072\u0007\u0010§\u0001\u001a\u00020\u0017H\u0002J\u0011\u0010¨\u0001\u001a\u00020\u00072\u0006\u0010w\u001a\u00020xH\u0002J\t\u0010©\u0001\u001a\u00020\u0007H\u0014J\t\u0010ª\u0001\u001a\u00020\u0007H\u0002J\t\u0010«\u0001\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010&\u001a\u0004\b2\u0010$R\u001b\u00104\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b5\u0010$R\u001b\u00107\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b8\u0010$R\u001b\u0010:\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010&\u001a\u0004\b;\u0010$R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010&\u001a\u0004\bC\u0010@R\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010&\u001a\u0004\bG\u0010HR\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010&\u001a\u0004\bL\u0010MR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010&\u001a\u0004\bP\u0010MR\u0010\u0010R\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010T\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010&\u001a\u0004\bU\u0010VR\u001d\u0010X\u001a\u0004\u0018\u00010Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010&\u001a\u0004\bZ\u0010[R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010&\u001a\u0004\bb\u0010cR\u000f\u0010\u0092\u0001\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0093\u0001\u001a\u00030\u0094\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0097\u0001\u0010&\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u000f\u0010\u0098\u0001\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u00ad\u0001"}, d2 = {"Lcom/larus/camera/impl/ui/component/capture/CaptureSurfaceComponent;", "Lcom/larus/camera/impl/ui/arch/LayerComponent;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/larus/camera/impl/ui/component/capture/CaptureComponent;", "<init>", "()V", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "moveTotalLength", "", "previewFrameAnimator", "Landroid/animation/ObjectAnimator;", "cameraSurface", "Landroid/view/SurfaceView;", "mediaLayoutObserver", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "legacyFocusLayout", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "isCameraOpened", "", "isScanCameraPermissionRequested", "isScanCameraPermissionRequesting", "scanCameraPermissionRunnable", "Ljava/lang/Runnable;", "supportedCaptureMode", "", "", "getSupportedCaptureMode", "()Ljava/util/List;", "singleZoomRatioBtn", "Landroid/widget/TextView;", "getSingleZoomRatioBtn", "()Landroid/widget/TextView;", "singleZoomRatioBtn$delegate", "Lkotlin/Lazy;", "zoomRatioStep", "Lcom/larus/camera/impl/utils/capture/ZoomRatioStep;", "getZoomRatioStep", "()Lcom/larus/camera/impl/utils/capture/ZoomRatioStep;", "zoomRatioStep$delegate", "zoomRatioLayout", "Landroid/widget/LinearLayout;", "getZoomRatioLayout", "()Landroid/widget/LinearLayout;", "zoomRatioLayout$delegate", "multiZoomRatio1XBtn", "getMultiZoomRatio1XBtn", "multiZoomRatio1XBtn$delegate", "multiZoomRatio2XBtn", "getMultiZoomRatio2XBtn", "multiZoomRatio2XBtn$delegate", "multiZoomRatio3XBtn", "getMultiZoomRatio3XBtn", "multiZoomRatio3XBtn$delegate", "multiZoomRatio4XBtn", "getMultiZoomRatio4XBtn", "multiZoomRatio4XBtn$delegate", "zoomCheckedColor", "", "getZoomCheckedColor", "()I", "zoomCheckedColor$delegate", "zoomUncheckedColor", "getZoomUncheckedColor", "zoomUncheckedColor$delegate", "zoomCheckedBgDrawable", "Landroid/graphics/drawable/Drawable;", "getZoomCheckedBgDrawable", "()Landroid/graphics/drawable/Drawable;", "zoomCheckedBgDrawable$delegate", "zoomCheckedTextSize", "", "getZoomCheckedTextSize", "()F", "zoomCheckedTextSize$delegate", "zoomUncheckedTextSize", "getZoomUncheckedTextSize", "zoomUncheckedTextSize$delegate", "mobStartZoomRatio", "maxFloorZoomRatio", "maxMoveLength", "getMaxMoveLength", "()D", "maxMoveLength$delegate", "obricCameraService", "Lcom/larus/camera/contract/ICameraServiceDiff;", "getObricCameraService", "()Lcom/larus/camera/contract/ICameraServiceDiff;", "obricCameraService$delegate", "startRetryTime", "", "isUIStopped", "cameraActionCallback", "com/larus/camera/impl/ui/component/capture/CaptureSurfaceComponent$cameraActionCallback$2$1", "getCameraActionCallback", "()Lcom/larus/camera/impl/ui/component/capture/CaptureSurfaceComponent$cameraActionCallback$2$1;", "cameraActionCallback$delegate", "createView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createLayoutParams", "Lcom/larus/camera/impl/ui/arch/CameraContainer$LayoutParams;", "gravity", "onViewCreated", "retryOpenCamera", "onDestroy", "startRotation", "v", "degree", "isFastZoomEnable", "initZoomRatioViews", "openCameraAfterPermissionIfNeeded", "viewModel", "Lcom/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel;", "anchorView", "openCamera", "initZoomRatioVisibility", "isShow", "initZoomRatioViewsAttachToAlbumThumbList", "zoomManager", "Lcom/larus/camera/impl/utils/capture/IZoomManager;", "initZoomRatioClickEvents", "multiZoomRatioBtnClicked", "showRatio", "zoomRatio", "Lcom/larus/camera/impl/utils/capture/ZoomRatio;", "initZoomRatioAccessibility", "mobClickZoomOnCapturePage", "switchMethod", "mobCurZoomRatio", "updateMultiZoomBtnResourceState", "checkedRatioStr", "onPause", "onStart", "onStop", "onResume", "animatePreviewFrame", "view", "Landroid/widget/ImageView;", "isTouchZoomFinal", "swipeVerticalGestureDetector", "Landroid/view/GestureDetector;", "getSwipeVerticalGestureDetector", "()Landroid/view/GestureDetector;", "swipeVerticalGestureDetector$delegate", "isHideAlbumThumbListJustNow", "setTouchGesture", "operationContainer", "onSwipeUp", "Lkotlin/Function0;", "onSwipeDown", "adjustMoveTotalLength", "getPointerLength", "Landroid/view/MotionEvent;", "showFocus", "e", "hideFocus", "updateComponent", "mode", "adjustSurfaceRatio", "fullScreen", "applyUnifiedCaptureLayout", "onViewDestroyed", "apply4To3Surface", "applyFullScreenSurface", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureSurfaceComponent extends com.larus.camera.impl.ui.arch.b implements DefaultLifecycleObserver, com.larus.camera.impl.ui.component.capture.a {
    public static final /* synthetic */ int T = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public String J;
    public float K;
    public final Lazy L;
    public final Lazy M;
    public long N;
    public boolean O;
    public final Lazy P;
    public boolean Q;
    public final Lazy R;
    public boolean S;
    public double m;
    public ObjectAnimator n;
    public SurfaceView o;
    public b1 p;
    public ConstraintLayout.LayoutParams q;
    public SurfaceHolder r;
    public boolean s;
    public boolean t;
    public boolean u;
    public t0 v;
    public final List<String> w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ZoomRatio.values().length];
            r0[ZoomRatio.RATIO_1X.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ZoomRatio.RATIO_2X.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ZoomRatio.RATIO_3X.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ZoomRatio.RATIO_4X.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final void onCreate(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
    }

    public CaptureSurfaceComponent() {
        super(com.larus.camera.impl.ui.arch.c.a, 1);
        this.w = fx8.a.f;
        this.x = LazyKt.lazy(new e1(this));
        this.y = LazyKt.lazy(new v1());
        this.z = LazyKt.lazy(new w1(this));
        this.A = LazyKt.lazy(new u0(this));
        this.B = LazyKt.lazy(new v0(this));
        this.C = LazyKt.lazy(new w0(this));
        this.D = LazyKt.lazy(new x0(this));
        this.E = LazyKt.lazy(new y0(this));
        this.F = LazyKt.lazy(new z0(this));
        this.G = LazyKt.lazy(new a1(this));
        this.H = LazyKt.lazy(new p1(this));
        this.I = LazyKt.lazy(new q1(this));
        this.K = 3.0f;
        this.L = LazyKt.lazy(new r1());
        this.M = LazyKt.lazy(new s1());
        this.P = LazyKt.lazy(new t1(this));
        this.R = LazyKt.lazy(new u1(this));
    }

    public final LinearLayout A() {
        return (LinearLayout) this.z.getValue();
    }

    public final xx8.i B() {
        return (xx8.i) this.y.getValue();
    }

    public final int C() {
        return ((Number) this.F.getValue()).intValue();
    }

    public final float D() {
        return ((Number) this.I.getValue()).floatValue();
    }

    public final void F() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getAlbumThumbListStateChanged(), new CaptureSurfaceComponent$initZoomRatioViewsAttachToAlbumThumbList$1(this, null)), k());
    }

    public final boolean G() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return false;
    L5:
        List<String> r2 = fx8.a.a;
        if (fx8.a.b.contains(r0.getCurrentCaptureMode()) == false) goto L8;
        return false;
    L8:
        xx8.c r1 = M();
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.b();
    }

    public final xx8.c M() {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getZoomService();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v31, types: [android.view.ViewTreeObserver$OnGlobalLayoutListener, com.larus.camera.impl.ui.component.capture.b1] */
    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131365096), 0, null, 6, null);
        if (r0.getCameraData().getUseUnifiedMediaCanvas() == false) goto L8;
        ConstraintLayout.LayoutParams r3 = h(2131373055).getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.q = new ConstraintLayout.LayoutParams(r3);
        ?? r1 = new b1(this, r0);
        j().getViewTreeObserver().addOnGlobalLayoutListener(r1);
        this.p = r1;
    L8:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureModeStatus(), new CaptureSurfaceComponent$onViewCreated$3(r0, this, null)), k());
        SurfaceView r2 = (SurfaceView) h(2131365104);
        this.o = r2;
        if (r2 == null) goto L11;
        SurfaceHolder r4 = r2.getHolder();
    L12:
        this.r = r4;
        if (fx8.a.b.contains(r0.getCurrentCaptureMode()) == true) goto L18;
        SurfaceHolder r5 = this.r;
        if (r5 != null) goto L17;
        return;
    L17:
        K(r0, r5);
    L18:
        final View r6 = h(2131373055);
        final Ref.DoubleRef r7 = new Ref.DoubleRef();
        final GestureDetector r8 = r0.createGestureDetector(getContext(), new c1(this, r0, r6), new CaptureSurfaceComponent$setTouchGesture$listener$2(r0));
        r6.setOnTouchListener(new d1(r0, this, r8, r7));
        i().addObserver(this);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getScaleLengthStatus(), new CaptureSurfaceComponent$onViewCreated$4(this, null)), k());
        if (G() == false) goto L21;
        E();
        com.larus.utils.e1.d(x(), new f1(this));
        com.larus.utils.e1.d(t(), new g1(this));
        com.larus.utils.e1.d(u(), new h1(this));
        com.larus.utils.e1.d(v(), new i1(this));
        com.larus.utils.e1.d(w(), new j1(this));
        AccessibilityDelegateCompat r9 = new CaptureSurfaceComponent$initZoomRatioAccessibility$accessibilityDelegate$1();
        ViewCompat.setAccessibilityDelegate(x(), r9);
        ViewCompat.setAccessibilityDelegate(t(), r9);
        ViewCompat.setAccessibilityDelegate(u(), r9);
        ViewCompat.setAccessibilityDelegate(v(), r9);
        ViewCompat.setAccessibilityDelegate(w(), r9);
        com.larus.utils.e1.x(A());
    L22:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getOnOrientationChanged(), new CaptureSurfaceComponent$onViewCreated$5(this, null)), k());
        return;
    L21:
        com.larus.utils.e1.o(A());
        goto L22
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        b1 r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        this.p = null;
        this.q = null;
        return;
    L5:
        if (j().getViewTreeObserver().isAlive() == false) goto L7;
        j().getViewTreeObserver().removeOnGlobalLayoutListener(r0);
        goto L7
    }

    public final double s() {
        return ((Number) this.L.getValue()).doubleValue();
    }

    public final TextView t() {
        return (TextView) this.A.getValue();
    }

    public final TextView u() {
        return (TextView) this.B.getValue();
    }

    public final TextView v() {
        return (TextView) this.C.getValue();
    }

    public final TextView w() {
        return (TextView) this.D.getValue();
    }

    public final TextView x() {
        return (TextView) this.x.getValue();
    }

    public final int y() {
        return ((Number) this.E.getValue()).intValue();
    }

    public final float z() {
        return ((Number) this.H.getValue()).floatValue();
    }

    public final void E() {
        xx8.c r0 = M();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.h() == false) goto L28;
        L(null);
        int r1 = (int) this.K;
        if (((oq9.d) com.larus.camera.impl.utils.k.a.getValue()).b() == true) goto L10;
        com.larus.utils.e1.x(t());
        com.larus.utils.e1.x(u());
        com.larus.utils.e1.x(v());
        com.larus.utils.e1.o(w());
    L26:
        com.larus.utils.e1.x(A());
        com.larus.utils.e1.o(x());
        F();
        return;
    L10:
        if (r1 < 1) goto L12;
        com.larus.utils.e1.x(t());
    L14:
        if (r1 < 2) goto L16;
        com.larus.utils.e1.x(u());
    L18:
        if (r1 < 3) goto L20;
        com.larus.utils.e1.x(v());
    L22:
        if (r1 < 4) goto L24;
        com.larus.utils.e1.x(w());
        goto L26
    L24:
        com.larus.utils.e1.o(w());
        goto L26
    L20:
        com.larus.utils.e1.o(v());
        goto L22
    L16:
        com.larus.utils.e1.o(u());
        goto L18
    L12:
        com.larus.utils.e1.o(t());
        goto L14
    L28:
        if (r0.d() == false) goto L30;
        x().setText(ZoomRatio.RATIO_1X.getRatioStr());
        com.larus.utils.e1.x(A());
        com.larus.utils.e1.x(x());
        com.larus.utils.e1.o(t());
        com.larus.utils.e1.o(u());
        com.larus.utils.e1.o(v());
        com.larus.utils.e1.o(w());
        F();
        return;
    L30:
        com.larus.utils.e1.o(A());
        com.larus.utils.e1.o(x());
        com.larus.utils.e1.o(t());
        com.larus.utils.e1.o(u());
        com.larus.utils.e1.o(v());
        com.larus.utils.e1.o(w());
    }

    public final String I() {
        xx8.c r0 = M();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L40;
        xx8.c r3 = M();
        if (r3 != null) goto L13;
    L15:
        if (r1 == true) goto L17;
        return "";
    L17:
        if (((oq9.d) com.larus.camera.impl.utils.k.a.getValue()).b() == false) goto L30;
        ZoomRatio r4 = B().a;
        int r5 = b.a[r4.ordinal()];
        if (r5 == 1) goto L44;
        if (r5 == 2) goto L43;
        if (r5 == 3) goto L42;
        if (r5 != 4) goto L26;
        return w().getText().toString();
    L26:
        throw new NoWhenBranchMatchedException();
    L42:
        return v().getText().toString();
    L43:
        return u().getText().toString();
    L44:
        return t().getText().toString();
    L30:
        ZoomRatio r6 = B().a;
        int r7 = b.a[r6.ordinal()];
        if (r7 == 1) goto L48;
        if (r7 == 2) goto L47;
        if (r7 == 3) goto L46;
        return v().getText().toString();
    L46:
        return v().getText().toString();
    L47:
        return u().getText().toString();
    L48:
        return t().getText().toString();
    L13:
        if (r3.h() != true) goto L15;
        r1 = true;
        goto L15
    L40:
        return x().getText().toString();
    L5:
        if (r0.d() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.w;
    }

    public final void H(String r10) {
        if (G() == true) goto L5;
        return;
    L5:
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L8;
        return;
    L8:
        xx8.c r1 = M();
        boolean r2 = false;
        if (r1 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L16;
        String r4 = "multi_focus";
    L24:
        String r5 = this.J;
        if (r5 == null) goto L27;
        String r6 = StringsKt.replace$default(r5, "x", "", false, 4, null);
    L28:
        r0.clickZoomOnCapturePage(r4, r6, StringsKt.replace$default(I(), "x", "", false, 4, null), r10);
        return;
    L27:
        r6 = null;
        goto L28
    L16:
        xx8.c r7 = M();
        if (r7 != null) goto L19;
    L21:
        if (r2 == false) goto L23;
        r4 = "single_focus";
        goto L24
    L23:
        r4 = "";
        goto L24
    L19:
        if (r7.d() != true) goto L21;
        r2 = true;
        goto L21
    L11:
        if (r1.h() != true) goto L13;
        r3 = true;
        goto L14
    }

    public final void L(String r11) {
        int r0 = b.a[B().a.ordinal()];     // Catch: Exception -> L33
        if (r0 != 1) goto L5;
        t().setTextColor(y());     // Catch: Exception -> L33
        u().setTextColor(C());     // Catch: Exception -> L33
        v().setTextColor(C());     // Catch: Exception -> L33
        w().setTextColor(C());     // Catch: Exception -> L33
        t().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        u().setBackground(null);     // Catch: Exception -> L33
        v().setBackground(null);     // Catch: Exception -> L33
        w().setBackground(null);     // Catch: Exception -> L33
        TextView r1 = t();     // Catch: Exception -> L33
        if (r11 != null) goto L31;
        r11 = ZoomRatio.RATIO_1X.getRatioStr();     // Catch: Exception -> L33
    L31:
        r1.setText(r11);     // Catch: Exception -> L33
        u().setText(StringsKt.replace$default(ZoomRatio.RATIO_2X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        v().setText(StringsKt.replace$default(ZoomRatio.RATIO_3X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        w().setText(StringsKt.replace$default(ZoomRatio.RATIO_4X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        t().setTextSize(0, z());     // Catch: Exception -> L33
        u().setTextSize(0, D());     // Catch: Exception -> L33
        v().setTextSize(0, D());     // Catch: Exception -> L33
        w().setTextSize(0, D());     // Catch: Exception -> L33
        return;
    L5:
        if (r0 != 2) goto L7;
        t().setTextColor(C());     // Catch: Exception -> L33
        u().setTextColor(y());     // Catch: Exception -> L33
        v().setTextColor(C());     // Catch: Exception -> L33
        w().setTextColor(C());     // Catch: Exception -> L33
        t().setBackground(null);     // Catch: Exception -> L33
        u().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        v().setBackground(null);     // Catch: Exception -> L33
        w().setBackground(null);     // Catch: Exception -> L33
        t().setText(StringsKt.replace$default(ZoomRatio.RATIO_1X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        TextView r2 = u();     // Catch: Exception -> L33
        if (r11 != null) goto L26;
        r11 = ZoomRatio.RATIO_2X.getRatioStr();     // Catch: Exception -> L33
    L26:
        r2.setText(r11);     // Catch: Exception -> L33
        v().setText(StringsKt.replace$default(ZoomRatio.RATIO_3X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        w().setText(StringsKt.replace$default(ZoomRatio.RATIO_4X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        t().setTextSize(0, D());     // Catch: Exception -> L33
        u().setTextSize(0, z());     // Catch: Exception -> L33
        v().setTextSize(0, D());     // Catch: Exception -> L33
        w().setTextSize(0, D());     // Catch: Exception -> L33
        return;
    L7:
        if (r0 != 3) goto L9;
        t().setTextColor(C());     // Catch: Exception -> L33
        u().setTextColor(C());     // Catch: Exception -> L33
        v().setTextColor(y());     // Catch: Exception -> L33
        w().setTextColor(C());     // Catch: Exception -> L33
        t().setBackground(null);     // Catch: Exception -> L33
        u().setBackground(null);     // Catch: Exception -> L33
        v().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        w().setBackground(null);     // Catch: Exception -> L33
        t().setText(StringsKt.replace$default(ZoomRatio.RATIO_1X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        u().setText(StringsKt.replace$default(ZoomRatio.RATIO_2X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        TextView r3 = v();     // Catch: Exception -> L33
        if (r11 != null) goto L21;
        r11 = ZoomRatio.RATIO_3X.getRatioStr();     // Catch: Exception -> L33
    L21:
        r3.setText(r11);     // Catch: Exception -> L33
        w().setText(StringsKt.replace$default(ZoomRatio.RATIO_4X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        t().setTextSize(0, D());     // Catch: Exception -> L33
        u().setTextSize(0, D());     // Catch: Exception -> L33
        v().setTextSize(0, z());     // Catch: Exception -> L33
        w().setTextSize(0, D());     // Catch: Exception -> L33
        return;
    L9:
        if (r0 != 4) goto L16;
        t().setTextColor(C());     // Catch: Exception -> L33
        u().setTextColor(C());     // Catch: Exception -> L33
        v().setTextColor(C());     // Catch: Exception -> L33
        w().setTextColor(y());     // Catch: Exception -> L33
        t().setBackground(null);     // Catch: Exception -> L33
        u().setBackground(null);     // Catch: Exception -> L33
        v().setBackground(null);     // Catch: Exception -> L33
        w().setBackground((Drawable) this.G.getValue());     // Catch: Exception -> L33
        t().setText(StringsKt.replace$default(ZoomRatio.RATIO_1X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        u().setText(StringsKt.replace$default(ZoomRatio.RATIO_2X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        v().setText(StringsKt.replace$default(ZoomRatio.RATIO_3X.getRatioStr(), "x", "", false, 4, null));     // Catch: Exception -> L33
        TextView r4 = w();     // Catch: Exception -> L33
        if (r11 != null) goto L14;
        r11 = ZoomRatio.RATIO_4X.getRatioStr();     // Catch: Exception -> L33
    L14:
        r4.setText(r11);     // Catch: Exception -> L33
        t().setTextSize(0, D());     // Catch: Exception -> L33
        u().setTextSize(0, D());     // Catch: Exception -> L33
        v().setTextSize(0, D());     // Catch: Exception -> L33
        w().setTextSize(0, z());     // Catch: Exception -> L33
        return;
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        FLogger.a.e("CaptureSurfaceComponent", "e=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        DefaultLifecycleObserver.-CC.$default$onDestroy(this, r2);
        t0 r3 = this.v;
        if (r3 == null) goto L7;
        SurfaceView r0 = this.o;
        if (r0 == null) goto L7;
        r0.removeCallbacks(r3);
    L7:
        this.v = null;
        this.u = false;
        ObjectAnimator r1 = this.n;
        if (r1 == null) goto L10;
        r1.cancel();
    L10:
        this.n = null;
    }

    public final void onPause(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        CameraCaptureViewModel r4 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r4 != null) goto L6;
        return;
    L6:
        if (com.larus.camera.impl.ui.component.capture.a.C0081a.a(this, r4) == true) goto L8;
        return;
    L8:
        List<String> r0 = fx8.a.a;
        if (fx8.a.b.contains(r4.getCurrentCaptureMode()) == false) goto L11;
        return;
    L11:
        r4.captureCurrentFrame();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.larus.camera.impl.ui.component.capture.t0, java.lang.Runnable] */
    public final void onResume(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        final CameraCaptureViewModel r11 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r11 != null) goto L5;
        return;
    L5:
        List<String> r0 = fx8.a.b;
        final FragmentActivity r2 = null;
        if (r0.contains(r11.getCurrentCaptureMode()) == false) goto L36;
        final SurfaceHolder r1 = this.r;
        if (r1 != null) goto L10;
        return;
    L10:
        SurfaceView r3 = this.o;
        if (r3 != 0) goto L14;
        return;
    L14:
        if (this.s == false) goto L17;
        return;
    L17:
        if (r0.contains(r11.getCurrentCaptureMode()) == true) goto L20;
        K(r11, r1);
        return;
    L20:
        if (this.u == true) goto L45;
        com.larus.camera.impl.starter.a.a.getClass();
        if (com.larus.camera.impl.starter.a.c() == false) goto L26;
        K(r11, r1);
        return;
    L26:
        if (this.t == true) goto L46;
        Activity r4 = com.larus.utils.i.getActivity(getContext());
        if ((r4 instanceof FragmentActivity) == false) goto L32;
        r2 = (FragmentActivity) r4;
    L32:
        if (r2 != null) goto L34;
        FLogger.a.w("CaptureSurfaceComponent", "scan camera permission request skip, activity null");
        return;
    L34:
        this.t = true;
        this.u = true;
        FLogger.a.i("CaptureSurfaceComponent", "scan camera permission request scheduled");
        ?? r5 = new t0(this, r11, r1, r2);
        this.v = r5;
        r3.postDelayed(r5, 300);
        return;
    L46:
        return;
    L45:
        return;
    L36:
        r11.checkCameraPermission();
        if (com.larus.camera.impl.ui.component.capture.a.C0081a.a(this, r11) == true) goto L39;
        return;
    L39:
        ImageView r6 = (ImageView) h(2131382918);
        BuildersKt.launch$default(k(), null, null, new CaptureSurfaceComponent$animatePreviewFrame$1(r11, this, r6, null), 3, null);
    }

    public final void onStart(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        DefaultLifecycleObserver.-CC.$default$onStart(this, r2);
        this.O = false;
    }

    public final void onStop(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        DefaultLifecycleObserver.-CC.$default$onStop(this, r2);
        this.O = true;
    }

    public final void q(float r4) {
        xx8.c r0 = M();
        if (r0 == null) goto L5;
        double r1 = r0.e(r4, s());
    L6:
        this.m = r1;
        FLogger.a.i("CaptureSurfaceComponent", "adjustMoveTotalLength moveTotalLength=" + this.m);
        return;
    L5:
        r1 = 0.0d;
        goto L6
    }

    public final void r(CameraCaptureViewModel r10) {
        CameraData r0 = r10.getCameraData();
        if (r0.getUseUnifiedMediaCanvas() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r10.getCurrentCaptureMode(), "CAPTURE_MODE_PHOTO") == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r0.getScene(), "ecom_page") == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r0.getScene(), "attach_photo_edit") == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r0.getScene(), "prompt_direct_send") == true) goto L63;
        ConstraintLayout r11 = h(2131365096);
        Intrinsics.checkNotNullParameter(r11, "root");
        if (r11.getWidth() > 0) goto L16;
    L41:
        Rect r4 = null;
    L42:
        if (r4 != null) goto L44;
        return;
    L44:
        float r12 = Math.min(r4.width() / 3.0f, r4.height() / 4.0f);
        int r1 = MathKt.roundToInt(3.0f * r12);
        int r13 = MathKt.roundToInt(r12 * 4.0f);
        int r5 = r4.top + ((r4.height() - r13) / 2);
        View r2 = h(2131373055);
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        if ((r6 instanceof ConstraintLayout.LayoutParams) == false) goto L47;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
    L48:
        if (r7 != null) goto L51;
        return;
    L51:
        if (((ViewGroup.MarginLayoutParams) r7).width == r1) goto L53;
    L57:
        r7.dimensionRatio = null;
        ((ViewGroup.MarginLayoutParams) r7).width = r1;
        ((ViewGroup.MarginLayoutParams) r7).height = r13;
        r7.topToTop = 0;
        r7.topToBottom = -1;
        r7.bottomToBottom = -1;
        r7.bottomToTop = -1;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = r5;
        ((ViewGroup.MarginLayoutParams) r7).bottomMargin = 0;
        r2.setLayoutParams(r7);
        return;
    L53:
        if (((ViewGroup.MarginLayoutParams) r7).height != r13) goto L57;
        if (((ViewGroup.MarginLayoutParams) r7).topMargin != r5) goto L57;
        return;
    L47:
        r7 = null;
        goto L48
    L16:
        if (r11.getHeight() <= 0) goto L41;
        Integer r3 = Integer.valueOf(r11.getRootView().getHeight());
        if (r3.intValue() <= 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L25;
        r3 = null;
    L25:
        if (r3 == null) goto L41;
        int r9 = r3.intValue();
        WindowInsetsCompat r14 = ViewCompat.getRootWindowInsets(r11);
        if (r14 == null) goto L29;
        Insets r15 = r14.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars());
    L30:
        Resources r16 = r11.getResources();
        float r17 = WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics()).density;
        int[] r18 = new int[2];
        r11.getLocationInWindow(r18);
        int r19 = r18[1];
        if (r15 == null) goto L33;
        int r20 = r15.top;
    L34:
        int r21 = RangesKt.coerceAtLeast((r20 + MathKt.roundToInt(52 * r17)) - r19, 0);
        if (r15 == null) goto L37;
        int r22 = r15.bottom;
    L38:
        int r23 = RangesKt.coerceAtMost(((r9 - r22) - MathKt.roundToInt(144 * r17)) - r19, r11.getHeight());
        if (r23 <= r21) goto L41;
        r4 = new Rect(0, r21, r11.getWidth(), r23);
        goto L42
    L37:
        r22 = 0;
        goto L38
    L33:
        com.larus.utils.i0.a.getClass();
        r20 = com.larus.utils.i0.g();
        goto L34
    L29:
        r15 = null;
        goto L30
    L21:
        r8 = false;
        goto L22
    }

    public final void J(String r7, ZoomRatio r8) {
        CameraCaptureViewModel r0 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        xx8.i r1 = B();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "zoomRatio");
        Intrinsics.checkNotNullParameter(r0, "viewModel");
        FLogger.a.i(r1.b, "multiSwitchToRatioStep: " + r7 + ", " + r8 + " wideMinRatio:null curZoomRatio:" + r1.a);
        ZoomRatio r2 = r1.a;
        if (r8 == r2) goto L8;
    L10:
        r1.a = r8;
        xx8.c r9 = r0.getZoomService();
        if (r9 == null) goto L13;
        r0.zoomByValue(r9.f(r1.a.getRatio()));
        boolean r10 = true;
    L14:
        if (r10 == false) goto L17;
        H("click");
        q(B().a.getRatio());
        a4.a.getClass();
        a4.a(a4.b / ((long) 3));
        return;
    L17:
        return;
    L13:
        r10 = false;
        goto L14
    L8:
        if (Intrinsics.areEqual(r7, r2.getRatioStr()) == false) goto L10;
        goto L10
    }

    public final void K(final CameraCaptureViewModel r4, SurfaceHolder r5) {
        this.s = true;
        r4.openCamera(r5, (CaptureSurfaceComponent$cameraActionCallback$2$1) this.P.getValue(), getContext());
        com.larus.utils.t0.a.postDelayed(new k1(r4), 10000);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return r3.inflate(2131562925, r4, false);
    }

    public static final void p(CaptureSurfaceComponent r0, View r1, int r2) {
        r0.getClass();
        ViewPropertyAnimator r3 = r1.animate();
        int r4 = com.larus.camera.impl.utils.c0.d;
        r3.rotation(com.larus.camera.impl.utils.c0.a.a(r2, false));
        r3.setDuration(300);
        r3.start();
    }
}
