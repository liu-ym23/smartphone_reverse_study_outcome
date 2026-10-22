package com.obric.memorydata.memory.ui.detail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.github.chrisbanes.photoview.PhotoView;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ar;
import com.obric.oui.progress.ODownloadProgressView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b*\u0001.\u0018\u0000 v2\u00020\u0001:\u0004vwxyB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00100\u001a\u00020\u0015H\u0014J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0014J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u0002022\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\b\u0010<\u001a\u000202H\u0002J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u000202H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020\u0019H\u0002J\b\u0010A\u001a\u00020&H\u0002J\u0010\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u0017H\u0002J\u0010\u0010D\u001a\u0002022\u0006\u0010E\u001a\u00020\u0010H\u0002J\b\u0010F\u001a\u000202H\u0002J \u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020I2\u0006\u0010C\u001a\u00020\u00172\u0006\u0010J\u001a\u00020&H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010H\u001a\u00020IH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010\u00172\u0006\u0010H\u001a\u00020IH\u0002J\n\u0010N\u001a\u0004\u0018\u00010IH\u0002J\u0010\u0010O\u001a\u0002022\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010P\u001a\u00020\u001eH\u0002J\b\u0010Q\u001a\u00020\u001eH\u0002J\b\u0010R\u001a\u000202H\u0002J\b\u0010S\u001a\u000202H\u0002J\u0012\u0010T\u001a\u00020\u00152\b\b\u0001\u0010U\u001a\u00020\u001eH\u0002J\b\u0010V\u001a\u000202H\u0002J\b\u0010W\u001a\u000202H\u0002J\u0010\u0010X\u001a\u0002022\u0006\u0010Y\u001a\u00020\u0015H\u0016J\b\u0010Z\u001a\u000202H\u0014J\u0012\u0010[\u001a\u0004\u0018\u00010\u00102\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010\\\u001a\u00020\u00102\u0006\u0010H\u001a\u00020I2\u0006\u0010E\u001a\u00020\u0010H\u0002J\u0010\u0010]\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020IH\u0002J \u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u001e2\u0006\u0010b\u001a\u00020\u001eH\u0002J\u0010\u0010c\u001a\u00020&2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010d\u001a\u000202H\u0002J\u0010\u0010e\u001a\u0002022\u0006\u0010f\u001a\u00020gH\u0002J\f\u0010h\u001a\u00020g*\u00020IH\u0002J\f\u0010i\u001a\u00020g*\u00020IH\u0002J\u0010\u0010j\u001a\u0002022\u0006\u0010k\u001a\u00020gH\u0002J\b\u0010l\u001a\u000202H\u0014J\b\u0010m\u001a\u000202H\u0016J\b\u0010n\u001a\u000202H\u0002J\"\u0010o\u001a\u0002022\u0006\u0010p\u001a\u00020\"2\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010rH\u0002J\b\u0010s\u001a\u000202H\u0002J\b\u0010t\u001a\u000202H\u0002J\b\u0010u\u001a\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006z"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "photoView", "Lcom/github/chrisbanes/photoview/PhotoView;", "subsamplingView", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;", "progressBar", "Lcom/obric/oui/progress/ODownloadProgressView;", "rootLayout", "Landroid/widget/FrameLayout;", "viewerLayer", "transitionSnapshotView", "Landroid/widget/ImageView;", "transitionSnapshotBitmap", "Landroid/graphics/Bitmap;", "currentBitmap", "stagedTiledImageFile", "Ljava/io/File;", "usingSubsamplingView", "", "currentImageInfo", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$ImageInfo;", "presentationState", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerPresentationState;", "isFinishingViewer", "windowAlphaAnimator", "Landroid/animation/ValueAnimator;", "backgroundColor", "", "scaleBounceBack", "fullScreen", "initialScale", "", "dynamicMaxScale", "frameMonitorStarted", "lastFrameTimeNanos", "", "frameCount", "slowFrame32Count", "slowFrame50Count", "maxFrameDurationMs", "showDelayedProgress", "Ljava/lang/Runnable;", "frameCallback", "com/obric/memorydata/memory/ui/detail/ImageViewerActivity$frameCallback$1", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$frameCallback$1;", "skipOnCreateCustomLogic", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setViewerMode", "mode", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$ViewerMode;", "getCurrentViewerScale", "showActiveViewer", "hideProgress", "showProgress", "applyPresentation", "state", "contentFadeDurationMs", "applySubsamplingScaleType", "imageInfo", "applyPhotoViewScaleType", "bitmap", "setupSubsamplingView", "loadSubsamplingImage", "uri", "Landroid/net/Uri;", "startTime", "prepareTiledImageSource", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$TiledImageSource;", "decodeImageInfo", "getImageUri", "loadImage", "getRealScreenWidth", "getRealScreenHeight", "updateSystemBarsAppearance", "setupWindow", "isColorLight", TypedValues.Custom.S_COLOR, "setupContentView", "setupScaleBounceBack", "onWindowFocusChanged", "hasFocus", "onPause", "loadBitmapFromUri", "applyExifOrientation", "readExifOrientation", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "getImageLength", "startFrameMonitor", "stopFrameMonitor", InfoRequestQPSOptTraceLogger.REASON, "", "redactedForLog", "maskedForLog", "showError", "message", "onDestroy", "onBackPressed", "finishViewer", "animateWindowAlpha", "targetAlpha", "onEnd", "Lkotlin/Function0;", "cancelWindowAlphaAnimation", "completeBackNavigation", "configureActivityTransitions", "Companion", "ImageInfo", "TiledImageSource", "ViewerMode", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageViewerActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    public static final String EXTRA_BACKGROUND_COLOR = "extra_background_color";
    public static final String EXTRA_FULL_SCREEN = "extra_full_screen";
    public static final String EXTRA_IMAGE_URI = "extra_image_uri";
    public static final String EXTRA_SCALE_BOUNCE_BACK = "extra_scale_bounce_back";
    private static final int MAX_BITMAP_SIZE = 4096;
    private static final float MAX_ZOOM_FACTOR = 3.0f;
    private static final String TAG = "ImageViewerActivity";
    private int backgroundColor;
    private Bitmap currentBitmap;
    private b currentImageInfo;
    private float dynamicMaxScale;
    private final e frameCallback;
    private int frameCount;
    private boolean frameMonitorStarted;
    private boolean fullScreen;
    private float initialScale;
    private boolean isFinishingViewer;
    private long lastFrameTimeNanos;
    private float maxFrameDurationMs;
    private PhotoView photoView;
    private ImageViewerPresentationState presentationState;
    private ODownloadProgressView progressBar;
    private FrameLayout rootLayout;
    private boolean scaleBounceBack;
    private final Runnable showDelayedProgress;
    private int slowFrame32Count;
    private int slowFrame50Count;
    private File stagedTiledImageFile;
    private SubsamplingScaleImageView subsamplingView;
    private Bitmap transitionSnapshotBitmap;
    private ImageView transitionSnapshotView;
    private boolean usingSubsamplingView;
    private FrameLayout viewerLayer;
    private ValueAnimator windowAlphaAnimator;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$ViewerMode;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PHOTO_VIEW", "SUBSAMPLING", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum ViewerMode extends Enum<ViewerMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ViewerMode[] $VALUES = null;
        public static final ViewerMode PHOTO_VIEW = null;
        public static final ViewerMode SUBSAMPLING = null;
        private final String value;

        private static final /* synthetic */ ViewerMode[] $values() {
            return new ViewerMode[]{PHOTO_VIEW, SUBSAMPLING};
        }

        static {
            PHOTO_VIEW = new ViewerMode("PHOTO_VIEW", 0, "photoView");
            SUBSAMPLING = new ViewerMode("SUBSAMPLING", 1, "subsampling");
            ViewerMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private ViewerMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<ViewerMode> getEntries() {
            return $ENTRIES;
        }

        public static ViewerMode valueOf(String r2) {
            return (ViewerMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ViewerMode.class, r2), ViewerMode.class, "com.obric.memorydata.plugin");
        }

        public static ViewerMode[] values() {
            return (ViewerMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ViewerMode[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_IMAGE_URI", "EXTRA_BACKGROUND_COLOR", "EXTRA_SCALE_BOUNCE_BACK", "EXTRA_FULL_SCREEN", "MAX_BITMAP_SIZE", "", "MAX_ZOOM_FACTOR", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$ImageInfo;", "", "width", "", "height", "fileLength", "", "<init>", "(IIJ)V", "getWidth", "()I", "getHeight", "getFileLength", "()J", "pixels", "getPixels", "requiresTiling", "", "getRequiresTiling", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10806b;
        private final long c;

        public b(int r1, int r2, long r3) {
            this.f10805a = r1;
            this.f10806b = r2;
            this.c = r3;
        }

        public final int a() {
            return this.f10805a;
        }

        public final int b() {
            return this.f10806b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return ((long) this.f10805a) * ((long) this.f10806b);
        }

        public final boolean e() {
            if (this.f10805a <= 4096) goto L5;
        L8:
            return true;
        L5:
            if (this.f10806b > 4096) goto L8;
            return false;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
            if (this.f10805a == r8.f10805a) goto L12;
            return false;
        L12:
            if (this.f10806b == r8.f10806b) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f10805a) * 31) + Integer.hashCode(this.f10806b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "ImageInfo(width=" + this.f10805a + ", height=" + this.f10806b + ", fileLength=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerActivity$TiledImageSource;", "", "uri", "Landroid/net/Uri;", "stagedFile", "Ljava/io/File;", "<init>", "(Landroid/net/Uri;Ljava/io/File;)V", "getUri", "()Landroid/net/Uri;", "getStagedFile", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f10807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final File f10808b;

        public c(Uri r2, File r3) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            this.f10807a = r2;
            this.f10808b = r3;
        }

        public /* synthetic */ c(Uri r1, File r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final Uri a() {
            return this.f10807a;
        }

        public final File b() {
            return this.f10808b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10807a, r6.f10807a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10808b, r6.f10808b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f10807a.hashCode() * 31;
            File r1 = this.f10808b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TiledImageSource(uri=" + this.f10807a + ", stagedFile=" + this.f10808b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/detail/ImageViewerActivity$animateWindowAlpha$animator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageViewerActivity f10809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f10810b;

        d(ImageViewerActivity r3, Function0<Unit> r4) {
            ImageViewerActivity r5 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            this.f10809a = r5;
            this.f10810b = r6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (ImageViewerActivity.access$getWindowAlphaAnimator$p(this.f10809a) == r2) goto L5;
            return;
        L5:
            ImageViewerActivity.access$setWindowAlphaAnimator$p(this.f10809a, null);
            Function0<Unit> r1 = this.f10810b;
            if (r1 == null) goto L9;
            r1.invoke();
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/detail/ImageViewerActivity$frameCallback$1", "Landroid/view/Choreographer$FrameCallback;", "doFrame", "", "frameTimeNanos", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageViewerActivity f10811a;

        e(ImageViewerActivity r3) {
            this.f10811a = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r5) {
            if (ImageViewerActivity.access$getFrameMonitorStarted$p(this.f10811a) == true) goto L6;
            return;
        L6:
            if (ImageViewerActivity.access$getLastFrameTimeNanos$p(this.f10811a) <= 0) goto L16;
            float r0 = (r5 - ImageViewerActivity.access$getLastFrameTimeNanos$p(this.f10811a)) / 1000000.0f;
            ImageViewerActivity.access$setFrameCount$p(this.f10811a, ImageViewerActivity.access$getFrameCount$p(this.f10811a) + 1);
            if (r0 <= 32.0f) goto L11;
            ImageViewerActivity.access$setSlowFrame32Count$p(this.f10811a, ImageViewerActivity.access$getSlowFrame32Count$p(this.f10811a) + 1);
        L11:
            if (r0 <= 50.0f) goto L14;
            ImageViewerActivity.access$setSlowFrame50Count$p(this.f10811a, ImageViewerActivity.access$getSlowFrame50Count$p(this.f10811a) + 1);
        L14:
            if (r0 <= ImageViewerActivity.access$getMaxFrameDurationMs$p(this.f10811a)) goto L16;
            ImageViewerActivity.access$setMaxFrameDurationMs$p(this.f10811a, r0);
        L16:
            ImageViewerActivity.access$setLastFrameTimeNanos$p(this.f10811a, r5);
            Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/detail/ImageViewerActivity$setupContentView$9", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onSingleTapConfirmed", "", "event", "Landroid/view/MotionEvent;", "onDoubleTap", "onDoubleTapEvent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements GestureDetector.OnDoubleTapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageViewerActivity f10812a;

        f(ImageViewerActivity r3) {
            this.f10812a = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r7) {
            Intrinsics.checkNotNullParameter(r7, "event");
            i r0 = i.f10858a;
            PhotoView r1 = ImageViewerActivity.access$getPhotoView$p(this.f10812a);
            PhotoView r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
            r1 = null;
        L5:
            float r3 = r0.a(r1.getScale(), ImageViewerActivity.access$getInitialScale$p(this.f10812a), ImageViewerActivity.access$getDynamicMaxScale$p(this.f10812a));
            PhotoView r6 = ImageViewerActivity.access$getPhotoView$p(this.f10812a);
            if (r6 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
        L9:
            r2.setScale(r3, r7.getX(), r7.getY(), true);
            return true;
        L8:
            r2 = r6;
            goto L9
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent r1) {
            Intrinsics.checkNotNullParameter(r1, "event");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent r1) {
            Intrinsics.checkNotNullParameter(r1, "event");
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\u0005\u001a\u00020\u00032\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\u0014\u0010\t\u001a\u00020\u00032\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/memory/ui/detail/ImageViewerActivity$setupSubsamplingView$2", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView$DefaultOnImageEventListener;", "onReady", "", "onImageLoaded", "onImageLoadError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onTileLoadError", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends SubsamplingScaleImageView.DefaultOnImageEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageViewerActivity f10813a;

        g(ImageViewerActivity r3) {
            this.f10813a = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        }

        private static final void a(ImageViewerActivity r6, b r7) {
            ImageViewerActivity r8 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r6, ImageViewerActivity.class, "com.obric.memorydata.plugin");
            ImageViewerActivity.access$applySubsamplingScaleType(r8, r7);
            ImageViewerActivity.access$showActiveViewer(r8);
            ImageViewerActivity.access$hideProgress(r8);
            ImageViewerActivity.access$startFrameMonitor(r8);
            IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r9 = new StringBuilder().append("subsamplingImageReady scale=");
            SubsamplingScaleImageView r10 = ImageViewerActivity.access$getSubsamplingView$p(r8);
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
            r10 = null;
        L5:
            IRunLog.a.a(r0, ImageViewerActivity.TAG, r9.append(r10.getScale()).toString(), false, 4, null);
        }

        /* JADX INFO: renamed from: lambda$QwJ7iL0Ayi4odEXuK77t-TKChUQ, reason: not valid java name */
        public static /* synthetic */ void m841lambda$QwJ7iL0Ayi4odEXuK77tTKChUQ(ImageViewerActivity r0, b r1) {
            a(r0, r1);
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.DefaultOnImageEventListener, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            RunLog.INSTANCE.error(ImageViewerActivity.TAG, "subsamplingImageLoadError", (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
            ImageViewerActivity.access$showError(this.f10813a, "无法加载图片");
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.DefaultOnImageEventListener, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
            RunLog r0 = RunLog.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("subsamplingImageLoaded scale=");
            SubsamplingScaleImageView r3 = ImageViewerActivity.access$getSubsamplingView$p(this.f10813a);
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
            r3 = null;
        L5:
            r0.debug(ImageViewerActivity.TAG, r1.append(r3.getScale()).toString());
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.DefaultOnImageEventListener, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
            final b r0 = ImageViewerActivity.access$getCurrentImageInfo$p(this.f10813a);
            if (r0 != null) goto L5;
            return;
        L5:
            SubsamplingScaleImageView r1 = ImageViewerActivity.access$getSubsamplingView$p(this.f10813a);
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
            r1 = null;
        L8:
            final ImageViewerActivity r3 = this.f10813a;
            r1.post(new $$Lambda$ImageViewerActivity$g$QwJ7iL0Ayi4odEXuK77tTKChUQ(r3, r0));
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.DefaultOnImageEventListener, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            RunLog.INSTANCE.error(ImageViewerActivity.TAG, "subsamplingTileLoadError", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/detail/ImageViewerActivity$setupSubsamplingView$3", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView$DefaultOnStateChangedListener;", "onScaleChanged", "", "newScale", "", "origin", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends SubsamplingScaleImageView.DefaultOnStateChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageViewerActivity f10814a;

        h(ImageViewerActivity r3) {
            this.f10814a = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.DefaultOnStateChangedListener, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float r3, int r4) {
            if (ImageViewerActivity.access$getScaleBounceBack$p(this.f10814a) == true) goto L5;
            return;
        L5:
            if (r3 <= ImageViewerActivity.access$getDynamicMaxScale$p(this.f10814a)) goto L16;
            SubsamplingScaleImageView r5 = ImageViewerActivity.access$getSubsamplingView$p(this.f10814a);
            SubsamplingScaleImageView r6 = null;
            if (r5 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
            r5 = null;
        L9:
            float r1 = ImageViewerActivity.access$getDynamicMaxScale$p(this.f10814a);
            SubsamplingScaleImageView r2 = ImageViewerActivity.access$getSubsamplingView$p(this.f10814a);
            if (r2 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        L13:
            r5.setScaleAndCenter(r1, r6.getCenter());
            return;
        L12:
            r6 = r2;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.ImageViewerActivity$loadImage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.ImageViewerActivity$loadImage$1", f = "ImageViewerActivity.kt", i = {0, 1, 1, 2}, l = {465, 470, 485}, m = "invokeSuspend", n = {"startTime", "imageInfo", "startTime", "startTime"}, s = {"J$0", "L$0", "J$0", "J$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        long J$0;
        Object L$0;
        int label;
        final /* synthetic */ ImageViewerActivity this$0;

        AnonymousClass1(ImageViewerActivity r3, Uri r4, Continuation<? super AnonymousClass1> r5) {
            ImageViewerActivity r6 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$uri = r4;
            super(2, r7);
        }

        private static final void invokeSuspend$lambda$0(ImageViewerActivity r6, Bitmap r7) {
            ImageViewerActivity r8 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r6, ImageViewerActivity.class, "com.obric.memorydata.plugin");
            ImageViewerActivity.access$applyPhotoViewScaleType(r8, r7);
            ImageViewerActivity.access$showActiveViewer(r8);
            ImageViewerActivity.access$hideProgress(r8);
            ImageViewerActivity.access$startFrameMonitor(r8);
            IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r9 = new StringBuilder().append("photoImageReady scale=");
            PhotoView r10 = ImageViewerActivity.access$getPhotoView$p(r8);
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("photoView");
            r10 = null;
        L5:
            IRunLog.a.a(r0, ImageViewerActivity.TAG, r9.append(r10.getScale()).toString(), false, 4, null);
        }

        public static /* synthetic */ void lambda$Y0N92cVpBacm1AsMJg5IiqdPfow(ImageViewerActivity r0, Bitmap r1) {
            invokeSuspend$lambda$0(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$uri, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r6 = true;
            PhotoView r7 = null;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L12;
            if (r1 != 3) goto L11;
            long r2 = this.J$0;
            ResultKt.throwOnFailure(r14);     // Catch: Exception -> L64
        L52:
            final Bitmap r15 = (Bitmap) ZeusTransformUtils.preCheckCast(r14, Bitmap.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            if (r15 == null) goto L62;
            ImageViewerActivity.access$setCurrentBitmap$p(this.this$0, r15);     // Catch: Exception -> L64
            PhotoView r3 = ImageViewerActivity.access$getPhotoView$p(this.this$0);     // Catch: Exception -> L64
            if (r3 != null) goto L57;
            Intrinsics.throwUninitializedPropertyAccessException("photoView");     // Catch: Exception -> L64
            r3 = null;
        L57:
            r3.setImageBitmap(r15);     // Catch: Exception -> L64
            RunLog.INSTANCE.debug(ImageViewerActivity.TAG, "setImageBitmap cost=" + (SystemClock.elapsedRealtime() - r2) + "ms");     // Catch: Exception -> L64
            PhotoView r4 = ImageViewerActivity.access$getPhotoView$p(this.this$0);     // Catch: Exception -> L64
            if (r4 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("photoView");     // Catch: Exception -> L64
        L61:
            final ImageViewerActivity r5 = this.this$0;     // Catch: Exception -> L64
            Boxing.boxBoolean(r7.post(new $$Lambda$ImageViewerActivity$loadImage$1$Y0N92cVpBacm1AsMJg5IiqdPfow(r5, r15)));     // Catch: Exception -> L64
        L67:
            return Unit.INSTANCE;
        L60:
            r7 = r4;
            goto L61
        L62:
            ImageViewerActivity.access$showError(this.this$0, "无法加载图片");     // Catch: Exception -> L64
            goto L67
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            long r8 = this.J$0;
            b r9 = (b) ZeusTransformUtils.preCheckCast(this.L$0, b.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Exception -> L64
        L39:
            c r16 = (c) ZeusTransformUtils.preCheckCast(r14, c.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            if (r16 != null) goto L43;
            ImageViewerActivity.access$showError(this.this$0, "无法加载图片");     // Catch: Exception -> L64
            return Unit.INSTANCE;
        L43:
            File r10 = ImageViewerActivity.access$getStagedTiledImageFile$p(this.this$0);     // Catch: Exception -> L64
            if (r10 == null) goto L46;
            Boxing.boxBoolean(r10.delete());     // Catch: Exception -> L64
        L46:
            ImageViewerActivity.access$setStagedTiledImageFile$p(this.this$0, r16.b());     // Catch: Exception -> L64
            ImageViewerActivity.access$loadSubsamplingImage(this.this$0, r16.a(), r9, r8);     // Catch: Exception -> L64
            return Unit.INSTANCE;
        L15:
            long r11 = this.J$0;
            ResultKt.throwOnFailure(r14);     // Catch: Exception -> L64
        L28:
            b r17 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            if (r17 != null) goto L31;
        L33:
            r6 = false;
        L34:
            if (r6 == false) goto L48;
            CoroutineContext r12 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            Function2 r13 = (Function2) ZeusTransformUtils.preCheckCast(new ImageViewerActivity$loadImage$1$tiledImageSource$1(this.this$0, this.$uri, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            this.L$0 = r17;     // Catch: Exception -> L64
            this.J$0 = r11;     // Catch: Exception -> L64
            this.label = 2;     // Catch: Exception -> L64
            Object r19 = kotlinx.coroutines.i.a(r12, r13, r18);     // Catch: Exception -> L64
            if (r19 != r0) goto L38;
            return r0;
        L38:
            r9 = r17;
            r14 = r19;
            r8 = r11;
            goto L39
        L48:
            ImageViewerActivity.access$setViewerMode(this.this$0, ViewerMode.PHOTO_VIEW);     // Catch: Exception -> L64
            ImageViewerActivity.access$setCurrentImageInfo$p(this.this$0, r17);     // Catch: Exception -> L64
            CoroutineContext r110 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            Function2 r20 = (Function2) ZeusTransformUtils.preCheckCast(new ImageViewerActivity$loadImage$1$bitmap$1(this.this$0, this.$uri, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            Continuation r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            this.J$0 = r11;     // Catch: Exception -> L64
            this.label = 3;     // Catch: Exception -> L64
            r14 = kotlinx.coroutines.i.a(r110, r20, r21);     // Catch: Exception -> L64
            if (r14 != r0) goto L51;
            return r0;
        L51:
            r2 = r11;
            goto L52
        L31:
            if (r17.e() != true) goto L33;
        L18:
            ResultKt.throwOnFailure(r14);
            r11 = SystemClock.elapsedRealtime();     // Catch: Exception -> L64
            ImageViewerActivity.access$showProgress(this.this$0);     // Catch: Exception -> L64
            PhotoView r111 = ImageViewerActivity.access$getPhotoView$p(this.this$0);     // Catch: Exception -> L64
            if (r111 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("photoView");     // Catch: Exception -> L64
            r111 = null;
        L22:
            r111.setVisibility(4);     // Catch: Exception -> L64
            SubsamplingScaleImageView r112 = ImageViewerActivity.access$getSubsamplingView$p(this.this$0);     // Catch: Exception -> L64
            if (r112 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");     // Catch: Exception -> L64
            r112 = null;
        L25:
            r112.setVisibility(4);     // Catch: Exception -> L64
            CoroutineContext r113 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            Function2 r22 = (Function2) ZeusTransformUtils.preCheckCast(new ImageViewerActivity$loadImage$1$imageInfo$1(this.this$0, this.$uri, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            Continuation r114 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L64
            this.J$0 = r11;     // Catch: Exception -> L64
            this.label = 1;     // Catch: Exception -> L64
            r14 = kotlinx.coroutines.i.a(r113, r22, r114);     // Catch: Exception -> L64
            if (r14 != r0) goto L28;
            return r0;
        L64:
            e = move-exception;
            e.printStackTrace();
            ImageViewerActivity.access$showError(this.this$0, "加载图片失败: " + e.getMessage());
            goto L67
        }
    }

    static {
        Companion = new a(null);
    }

    public ImageViewerActivity() {
        this.presentationState = ImageViewerPresentationState.LOADING;
        this.backgroundColor = ViewCompat.MEASURED_STATE_MASK;
        this.fullScreen = true;
        this.initialScale = 1.0f;
        this.dynamicMaxScale = 3.0f;
        this.showDelayedProgress = new $$Lambda$ImageViewerActivity$2ccrLbiCtGaoIa03Z4GLqAoPwFA(this);
        this.frameCallback = new e(this);
    }

    public static final /* synthetic */ void access$applyPhotoViewScaleType(ImageViewerActivity r2, Bitmap r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).applyPhotoViewScaleType(r3);
    }

    public static final /* synthetic */ void access$applySubsamplingScaleType(ImageViewerActivity r2, b r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).applySubsamplingScaleType(r3);
    }

    public static final /* synthetic */ b access$decodeImageInfo(ImageViewerActivity r2, Uri r3) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).decodeImageInfo(r3);
    }

    public static final /* synthetic */ b access$getCurrentImageInfo$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).currentImageInfo;
    }

    public static final /* synthetic */ float access$getDynamicMaxScale$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).dynamicMaxScale;
    }

    public static final /* synthetic */ int access$getFrameCount$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).frameCount;
    }

    public static final /* synthetic */ boolean access$getFrameMonitorStarted$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).frameMonitorStarted;
    }

    public static final /* synthetic */ float access$getInitialScale$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).initialScale;
    }

    public static final /* synthetic */ long access$getLastFrameTimeNanos$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).lastFrameTimeNanos;
    }

    public static final /* synthetic */ float access$getMaxFrameDurationMs$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).maxFrameDurationMs;
    }

    public static final /* synthetic */ PhotoView access$getPhotoView$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).photoView;
    }

    public static final /* synthetic */ boolean access$getScaleBounceBack$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).scaleBounceBack;
    }

    public static final /* synthetic */ int access$getSlowFrame32Count$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).slowFrame32Count;
    }

    public static final /* synthetic */ int access$getSlowFrame50Count$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).slowFrame50Count;
    }

    public static final /* synthetic */ File access$getStagedTiledImageFile$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).stagedTiledImageFile;
    }

    public static final /* synthetic */ SubsamplingScaleImageView access$getSubsamplingView$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).subsamplingView;
    }

    public static final /* synthetic */ ValueAnimator access$getWindowAlphaAnimator$p(ImageViewerActivity r2) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).windowAlphaAnimator;
    }

    public static final /* synthetic */ void access$hideProgress(ImageViewerActivity r2) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).hideProgress();
    }

    public static final /* synthetic */ Bitmap access$loadBitmapFromUri(ImageViewerActivity r2, Uri r3) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).loadBitmapFromUri(r3);
    }

    public static final /* synthetic */ void access$loadSubsamplingImage(ImageViewerActivity r2, Uri r3, b r4, long r5) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).loadSubsamplingImage(r3, r4, r5);
    }

    public static final /* synthetic */ c access$prepareTiledImageSource(ImageViewerActivity r2, Uri r3) {
        return ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).prepareTiledImageSource(r3);
    }

    public static final /* synthetic */ void access$setCurrentBitmap$p(ImageViewerActivity r2, Bitmap r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).currentBitmap = r3;
    }

    public static final /* synthetic */ void access$setCurrentImageInfo$p(ImageViewerActivity r2, b r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).currentImageInfo = r3;
    }

    public static final /* synthetic */ void access$setFrameCount$p(ImageViewerActivity r2, int r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).frameCount = r3;
    }

    public static final /* synthetic */ void access$setLastFrameTimeNanos$p(ImageViewerActivity r2, long r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).lastFrameTimeNanos = r3;
    }

    public static final /* synthetic */ void access$setMaxFrameDurationMs$p(ImageViewerActivity r2, float r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).maxFrameDurationMs = r3;
    }

    public static final /* synthetic */ void access$setSlowFrame32Count$p(ImageViewerActivity r2, int r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).slowFrame32Count = r3;
    }

    public static final /* synthetic */ void access$setSlowFrame50Count$p(ImageViewerActivity r2, int r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).slowFrame50Count = r3;
    }

    public static final /* synthetic */ void access$setStagedTiledImageFile$p(ImageViewerActivity r2, File r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).stagedTiledImageFile = r3;
    }

    public static final /* synthetic */ void access$setViewerMode(ImageViewerActivity r2, ViewerMode r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).setViewerMode(r3);
    }

    public static final /* synthetic */ void access$setWindowAlphaAnimator$p(ImageViewerActivity r2, ValueAnimator r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).windowAlphaAnimator = r3;
    }

    public static final /* synthetic */ void access$showActiveViewer(ImageViewerActivity r2) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).showActiveViewer();
    }

    public static final /* synthetic */ void access$showError(ImageViewerActivity r2, String r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).showError(r3);
    }

    public static final /* synthetic */ void access$showProgress(ImageViewerActivity r2) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).showProgress();
    }

    public static final /* synthetic */ void access$startFrameMonitor(ImageViewerActivity r2) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).startFrameMonitor();
    }

    private final void animateWindowAlpha(float r6, Function0<Unit> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        cancelWindowAlphaAnimation();
        float r0 = getWindow().getAttributes().alpha;
        if (r0 != r6) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        if (r8 == null) goto L12;
        r8.invoke();
        return;
    L12:
        return;
    L10:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{r0, r6});
        r9.setDuration(contentFadeDurationMs());
        r9.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r9.addUpdateListener(new $$Lambda$ImageViewerActivity$DNi2jbXdOgMTEVEymz90zfwAfA(this));
        r9.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new d(this, r8), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        this.windowAlphaAnimator = r9;
        r9.start();
        return;
    L5:
        r2 = false;
        goto L6
    }

    static /* synthetic */ void animateWindowAlpha$default(ImageViewerActivity r1, float r2, Function0 r3, int r4, Object r5) {
        ImageViewerActivity r6 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r1, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r6.animateWindowAlpha(r2, r7);
    }

    private static final void animateWindowAlpha$lambda$40$lambda$39(ImageViewerActivity r3, ValueAnimator r4) {
        ImageViewerActivity r5 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "valueAnimator");
        Window r0 = r5.getWindow();
        WindowManager.LayoutParams r6 = r5.getWindow().getAttributes();
        Object r7 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Float");
        r6.alpha = ((Float) ZeusTransformUtils.preCheckCast(r7, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r0.setAttributes(r6);
    }

    private final Bitmap applyExifOrientation(Uri r8, Bitmap r9) {
        int r7 = readExifOrientation(r8);
        k r10 = j.f10859a.a(r7);
        if (r10.a() != 0.0f) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
    L10:
        Matrix r5 = new Matrix();
        r5.postRotate(r10.a());
        if (r10.b() == false) goto L13;
        r5.postScale(-1.0f, 1.0f);
    L13:
        Bitmap r12 = Bitmap.createBitmap(r9, 0, 0, r9.getWidth(), r9.getHeight(), r5, true);
        Intrinsics.checkNotNullExpressionValue(r12, "createBitmap(...)");
        if (r12 == r9) goto L16;
        r9.recycle();
    L16:
        return r12;
    L8:
        if (r10.b() == true) goto L10;
        return r9;
    L5:
        r11 = false;
        goto L6
    }

    private final void applyPhotoViewScaleType(Bitmap r18) {
        float r1 = getRealScreenWidth();
        float r2 = getRealScreenHeight();
        if (r1 > 0.0f) goto L5;
        return;
    L5:
        if (r2 <= 0.0f) goto L29;
        float r4 = r18.getWidth();
        float r5 = r18.getHeight();
        if (r4 > 0.0f) goto L10;
        return;
    L10:
        if (r5 <= 0.0f) goto L30;
        float r6 = Math.min(r1 / r4, r2 / r5);
        if (r6 > 0.0f) goto L15;
        return;
    L15:
        PhotoView r3 = this.photoView;
        PhotoView r7 = null;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r3 = null;
    L18:
        r3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.initialScale = 1.0f;
        float r8 = Math.max(3.0f, Math.max(r1 / (r4 * r6), r2 / (r5 * r6)));
        this.dynamicMaxScale = r8;
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        String r10 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r8)}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(...)");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "imageViewerScale mode=" + ViewerMode.PHOTO_VIEW.getValue() + ", decoded=" + r18.getWidth() + 'x' + r18.getHeight() + ", screen=" + ((int) r1) + 'x' + ((int) r2) + ", initialScale=" + this.initialScale + ", maxScale=" + r10, false, 4, null);
        PhotoView r11 = this.photoView;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r11 = null;
    L21:
        float r12 = this.initialScale;
        r11.setScaleLevels(r12, (r12 + r8) / 2.0f, r8);
        PhotoView r13 = this.photoView;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L25:
        float r14 = 2;
        r7.setScale(this.initialScale, r1 / r14, r2 / r14, false);
        return;
    L24:
        r7 = r13;
        goto L25
    L30:
        return;
    }

    private final void applyPresentation(ImageViewerPresentationState r9) {
        int r2 = 0;
        if (this.presentationState == ImageViewerPresentationState.READY) goto L5;
        boolean r0 = true;
    L6:
        this.presentationState = r9;
        m r10 = n.f10866a.a(r9, this.backgroundColor);
        FrameLayout r1 = this.viewerLayer;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewerLayer");
        r1 = null;
    L9:
        r1.setBackgroundColor(r10.a());
        FrameLayout r3 = this.rootLayout;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r3 = null;
    L12:
        r3.setAlpha(1.0f);
        ODownloadProgressView r4 = this.progressBar;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        r4 = null;
    L16:
        if (r10.b() == false) goto L18;
        int r5 = 0;
    L19:
        r4.setVisibility(r5);
        if (r10.c() == true) goto L35;
        PhotoView r6 = this.photoView;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r6 = null;
    L24:
        r6.setVisibility(4);
        SubsamplingScaleImageView r7 = this.subsamplingView;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r7 = null;
    L28:
        if (this.usingSubsamplingView == true) goto L30;
    L32:
        r2 = 4;
    L33:
        r7.setVisibility(r2);
    L50:
        if (r0 == true) goto L52;
        return;
    L52:
        if (r10.e() != ImageViewerContentTransition.WINDOW_FADE_IN) goto L56;
        animateWindowAlpha$default(this, 1.0f, null, 2, null);
        return;
    L56:
        return;
    L30:
        if (r10.d() == false) goto L32;
    L35:
        if (this.usingSubsamplingView == false) goto L43;
        SubsamplingScaleImageView r8 = this.subsamplingView;
        if (r8 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r8 = null;
    L39:
        r8.setVisibility(0);
        PhotoView r11 = this.photoView;
        if (r11 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r11 = null;
    L42:
        r11.setVisibility(4);
        goto L50
    L43:
        PhotoView r12 = this.photoView;
        if (r12 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r12 = null;
    L46:
        r12.setVisibility(0);
        SubsamplingScaleImageView r13 = this.subsamplingView;
        if (r13 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r13 = null;
    L49:
        r13.setVisibility(4);
        goto L50
    L18:
        r5 = 8;
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    private final void applySubsamplingScaleType(b r11) {
        float r0 = getRealScreenWidth();
        float r1 = getRealScreenHeight();
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        if (r1 <= 0.0f) goto L35;
        float r3 = r11.a();
        float r4 = r11.b();
        if (r3 > 0.0f) goto L10;
        return;
    L10:
        if (r4 <= 0.0f) goto L36;
        float r5 = r0 / r3;
        float r6 = r1 / r4;
        float r7 = Math.min(r5, r6);
        if (r7 > 0.0f) goto L15;
        return;
    L15:
        float r2 = Math.max(3.0f * r7, Math.max(r5, r6));
        this.initialScale = r7;
        this.dynamicMaxScale = r2;
        SubsamplingScaleImageView r8 = this.subsamplingView;
        SubsamplingScaleImageView r9 = null;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r8 = null;
    L18:
        r8.setMinimumScaleType(3);
        SubsamplingScaleImageView r10 = this.subsamplingView;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r10 = null;
    L21:
        r10.setMinScale(this.initialScale);
        SubsamplingScaleImageView r12 = this.subsamplingView;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r12 = null;
    L24:
        r12.setMaxScale(r2);
        SubsamplingScaleImageView r13 = this.subsamplingView;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r13 = null;
    L27:
        r13.setDoubleTapZoomScale(r2);
        SubsamplingScaleImageView r14 = this.subsamplingView;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
    L31:
        r9.setScaleAndCenter(r7, new PointF(r11.a() / 2.0f, r11.b() / 2.0f));
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("imageViewerScale mode=").append(ViewerMode.SUBSAMPLING.getValue()).append(", original=").append(r11.a()).append('x').append(r11.b()).append(", screen=").append((int) r0).append('x').append((int) r1).append(", initialScale=");
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        String r18 = String.format(Locale.US, "%.4f", Arrays.copyOf(new Object[]{Float.valueOf(this.initialScale)}, 1));
        Intrinsics.checkNotNullExpressionValue(r18, "format(...)");
        StringBuilder r19 = r16.append(r18).append(", maxScale=");
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        String r111 = String.format(Locale.US, "%.4f", Arrays.copyOf(new Object[]{Float.valueOf(r2)}, 1));
        Intrinsics.checkNotNullExpressionValue(r111, "format(...)");
        IRunLog.a.a(r15, TAG, r19.append(r111).toString(), false, 4, null);
        return;
    L30:
        r9 = r14;
        goto L31
    L36:
        return;
    }

    private final int calculateInSampleSize(BitmapFactory.Options r3, int r4, int r5) {
        Pair r2 = TuplesKt.to(Integer.valueOf(r3.outHeight), Integer.valueOf(r3.outWidth));
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r2.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r2.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r0 = 1;
        if (r6 > r5) goto L6;
        if (r7 > r4) goto L6;
    L10:
        return r0;
    L6:
        if ((r6 / r0) > r5) goto L11;
        if ((r7 / r0) <= r4) goto L10;
    L11:
        r0 = r0 * 2;
        goto L6
    }

    private final void cancelWindowAlphaAnimation() {
        ValueAnimator r0 = this.windowAlphaAnimator;
        if (r0 != null) goto L5;
        return;
    L5:
        this.windowAlphaAnimator = null;
        r0.cancel();
    }

    private final void completeBackNavigation() {
        getWindow().setWindowAnimations(0);
        if (Build.VERSION.SDK_INT < 34) goto L5;
        overrideActivityTransition(1, 0, 0);
    L5:
        finish();
        overridePendingTransition(0, 0);
    }

    private final void configureActivityTransitions() {
        getWindow().setWindowAnimations(ZeusTransformUtils.mapRes(R.style.ImageViewerAnimation, "style", "ImageViewerAnimation"));
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        overrideActivityTransition(0, android.R.anim.fade_in, android.R.anim.fade_out);
        overrideActivityTransition(1, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private final long contentFadeDurationMs() {
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getInteger(android.R.integer.config_shortAnimTime);
    }

    private final b decodeImageInfo(Uri r9) {
        long r1 = getImageLength(r9);
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L23
        InputStream r5 = ((ImageViewerActivity) ZeusTransformUtils.preCheckCast(this, ImageViewerActivity.class, "com.obric.memorydata.plugin")).getContentResolver().openInputStream(r9);     // Catch: Throwable -> L23
        if (r5 == null) goto L20;
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        InputStream r7 = (InputStream) ZeusTransformUtils.preCheckCast(r6, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        BitmapFactory.Options r8 = new BitmapFactory.Options();     // Catch: Throwable -> L15
        r8.inJustDecodeBounds = true;     // Catch: Throwable -> L15
        BitmapFactory.decodeStream(r7, null, r8);     // Catch: Throwable -> L15
        if (r8.outWidth > 0) goto L9;
    L12:
        b r10 = null;
    L13:
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L23
    L21:
        Object r2 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L23
    L25:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r2);
        if (r11 != null) goto L28;
        r3 = r2;
    L30:
        return (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
    L28:
        RunLog.INSTANCE.error(TAG, "decodeImageInfo failed, uri=" + maskedForLog(r9), r11);
        goto L30
    L9:
        if (r8.outHeight <= 0) goto L12;
        r10 = new b(r8.outWidth, r8.outHeight, r1);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L20:
        r10 = null;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    private final void finishViewer() {
        if (this.isFinishingViewer == false) goto L5;
        return;
    L5:
        this.isFinishingViewer = true;
        FrameLayout r0 = this.rootLayout;
        if (r0 == null) goto L10;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L9:
        r0.removeCallbacks(this.showDelayedProgress);
    L10:
        completeBackNavigation();
    }

    private final float getCurrentViewerScale() {
        PhotoView r1 = null;
        SubsamplingScaleImageView r2 = null;
        if (this.usingSubsamplingView == false) goto L10;
        SubsamplingScaleImageView r0 = this.subsamplingView;
        if (r0 == null) goto L10;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
    L18:
        return r2.getScale();
    L8:
        r2 = r0;
    L10:
        PhotoView r3 = this.photoView;
        if (r3 == null) goto L16;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L19:
        return r1.getScale();
    L14:
        r1 = r3;
        goto L19
    L16:
        return 1.0f;
    }

    private final long getImageLength(Uri r6) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        AssetFileDescriptor r5 = ((ImageViewerActivity) ZeusTransformUtils.preCheckCast(this, ImageViewerActivity.class, "com.obric.memorydata.plugin")).getContentResolver().openAssetFileDescriptor(r6, "r");     // Catch: Throwable -> L18
        if (r5 == null) goto L15;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        long r4 = ((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r7, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).getLength();     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L18
    L16:
        Object r8 = Result.m1421constructorimpl(Long.valueOf(r4));     // Catch: Throwable -> L18
    L21:
        if (Result.m1427isFailureimpl(r8) == false) goto L24;
        r8 = -1L;
    L24:
        return ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L15:
        r4 = -1;
    L18:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final Uri getImageUri() {
        Uri r0 = getIntent().getData();
        if (r0 == null) goto L5;
        return r0;
    L5:
        Uri r1 = (Uri) ZeusTransformUtils.preCheckCast(getIntent().getParcelableExtra(EXTRA_IMAGE_URI), Uri.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        return r1;
    L8:
        String r4 = getIntent().getStringExtra(EXTRA_IMAGE_URI);
        if (r4 != null) goto L11;
        return null;
    L11:
        return Uri.parse(r4);
    }

    private final int getRealScreenHeight() {
        return getWindowManager().getCurrentWindowMetrics().getBounds().height();
    }

    private final int getRealScreenWidth() {
        return getWindowManager().getCurrentWindowMetrics().getBounds().width();
    }

    private final void hideProgress() {
        FrameLayout r0 = this.rootLayout;
        ODownloadProgressView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L5:
        r0.removeCallbacks(this.showDelayedProgress);
        ODownloadProgressView r3 = this.progressBar;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L9:
        r1.setVisibility(8);
        return;
    L8:
        r1 = r3;
        goto L9
    }

    private final boolean isColorLight(int r9) {
        if ((((double) 1) - ((((((double) Color.red(r9)) * 0.299d) + (((double) Color.green(r9)) * 0.587d)) + (((double) Color.blue(r9)) * 0.114d)) / ((double) 255))) < 0.5d) goto L7;
        return false;
    L7:
        return true;
    }

    public static /* synthetic */ void lambda$2ccrLbiCtGaoIa03Z4GLqAoPwFA(ImageViewerActivity r0) {
        showDelayedProgress$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$CMo-M41a_PZzg-8Y2awmgkQn2tA, reason: not valid java name */
    public static /* synthetic */ void m837lambda$CMoM41a_PZzg8Y2awmgkQn2tA(ImageViewerActivity r0, b r1) {
        onConfigurationChanged$lambda$2$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$DN-i2jbXdOgMTEVEymz90zfwAfA, reason: not valid java name */
    public static /* synthetic */ void m838lambda$DNi2jbXdOgMTEVEymz90zfwAfA(ImageViewerActivity r0, ValueAnimator r1) {
        animateWindowAlpha$lambda$40$lambda$39(r0, r1);
    }

    public static /* synthetic */ void lambda$ON4asZg6M6soI7PrJ8mSwjIPcHI(Ref.BooleanRef r0, Ref.FloatRef r1, ImageViewerActivity r2, float r3, float r4, float r5) {
        setupScaleBounceBack$lambda$26(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$QRqMki2bVRDURehZkHo2lP9djLc(View r0) {
        setupSubsamplingView$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$V78SSG1OjDlL31vNZCd-YUbm6OY, reason: not valid java name */
    public static /* synthetic */ void m839lambda$V78SSG1OjDlL31vNZCdYUbm6OY(ImageViewerActivity r0, Runnable r1, RectF r2) {
        setupScaleBounceBack$lambda$28(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$WkHYc8hVFjlsS6H9AQgP-UOXVx0, reason: not valid java name */
    public static /* synthetic */ void m840lambda$WkHYc8hVFjlsS6H9AQgPUOXVx0(ImageView r0, float r1, float r2) {
        setupContentView$lambda$25(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$hfEyjHDmb_ohw4bKBT_KMmo44vM(Ref.BooleanRef r0, ImageViewerActivity r1) {
        setupScaleBounceBack$lambda$27(r0, r1);
    }

    public static /* synthetic */ void lambda$vnp69UJ5ZA09L0mQOlbyl5KwOMA(ImageViewerActivity r0, Bitmap r1) {
        onConfigurationChanged$lambda$4$lambda$3(r0, r1);
    }

    private final Bitmap loadBitmapFromUri(Uri r25) {
        long r5 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L82 Exception -> L85
        long r7 = getImageLength(r25);     // Catch: Throwable -> L82 Exception -> L85
        Canvas r9 = new Canvas();     // Catch: Throwable -> L82 Exception -> L85
        InputStream r10 = getContentResolver().openInputStream(r25);     // Catch: Throwable -> L82 Exception -> L85
        if (r10 != null) goto L134;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        ImageViewerActivity r0 = (ImageViewerActivity) ZeusTransformUtils.preCheckCast(this, ImageViewerActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Result.m1421constructorimpl(null);     // Catch: Throwable -> L7
    L9:
        return null;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    L134:
        BitmapFactory.Options r11 = new BitmapFactory.Options();     // Catch: Throwable -> L78 Exception -> L80
        r11.inJustDecodeBounds = true;     // Catch: Throwable -> L78 Exception -> L80
        BitmapFactory.decodeStream(r10, null, r11);     // Catch: Throwable -> L78 Exception -> L80
        r10.close();     // Catch: Throwable -> L78 Exception -> L80
        int r13 = r11.outWidth;     // Catch: Throwable -> L78 Exception -> L80
        int r14 = r11.outHeight;     // Catch: Throwable -> L78 Exception -> L80
        r11.inSampleSize = calculateInSampleSize(r11, 4096, 4096);     // Catch: Throwable -> L78 Exception -> L80
        r11.inJustDecodeBounds = false;     // Catch: Throwable -> L78 Exception -> L80
        r11.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L78 Exception -> L80
        InputStream r15 = getContentResolver().openInputStream(r25);     // Catch: Throwable -> L78 Exception -> L80
        if (r15 == null) goto L127;
        Bitmap r12 = BitmapFactory.decodeStream(r15, null, r11);     // Catch: Throwable -> L73 Exception -> L76
        if (r12 != null) goto L136;
        Bitmap r16 = null;
    L27:
        if (r7 >= 0) goto L124;
        InputStream r21 = r10;
        InputStream r17 = r15;
        String r3 = "unknown";
    L41:
        if (r16 == null) goto L49;
        int r8 = r16.getByteCount();     // Catch: Throwable -> L45 Exception -> L47
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L45 Exception -> L47
        BitmapFactory.Options r23 = r11;
        String r4 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf((((double) r8) / 1024.0d) / 1024.0d)}, 1));     // Catch: Throwable -> L45 Exception -> L47
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");     // Catch: Throwable -> L45 Exception -> L47
        if (r4 == null) goto L50;
    L51:
        if (r13 <= 0) goto L54;
        if (r14 <= 0) goto L54;
        StringCompanionObject r19 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L45 Exception -> L47
        String r6 = String.format(Locale.US, "%.2fMP", Arrays.copyOf(new Object[]{Double.valueOf((((double) r13) * ((double) r14)) / 1000000.0d)}, 1));     // Catch: Throwable -> L45 Exception -> L47
        Intrinsics.checkNotNullExpressionValue(r6, "format(...)");     // Catch: Throwable -> L45 Exception -> L47
    L55:
        IRunLog r20 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45 Exception -> L47
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L45 Exception -> L47
        StringBuilder r24 = r22.append("decodeImage original=").append(r13).append('x').append(r14).append(", decoded=");     // Catch: Throwable -> L45 Exception -> L47
        if (r16 == null) goto L58;
        Integer r110 = Integer.valueOf(r16.getWidth());     // Catch: Throwable -> L45 Exception -> L47
    L59:
        StringBuilder r26 = r24.append(r110).append('x');     // Catch: Throwable -> L45 Exception -> L47
        if (r16 == null) goto L62;
        Integer r111 = Integer.valueOf(r16.getHeight());     // Catch: Throwable -> L45 Exception -> L47
    L63:
        StringBuilder r27 = r26.append(r111).append(", file=").append(r3).append("MB, bitmap=").append(r4).append("MB, inSampleSize=").append(r23.inSampleSize).append(", pixels=").append(r6).append(", canvasMax=").append(r9.getMaximumBitmapWidth()).append('x').append(r9.getMaximumBitmapHeight()).append(", config=");     // Catch: Throwable -> L45 Exception -> L47
        if (r16 == null) goto L66;
        Bitmap.Config r28 = r16.getConfig();     // Catch: Throwable -> L45 Exception -> L47
    L67:
        r27.append(r28).append(", cost=");     // Catch: Throwable -> L45 Exception -> L47
        r22.append(SystemClock.elapsedRealtime() - r5).append("ms");     // Catch: Throwable -> L45 Exception -> L47
        IRunLog.a.a(r20, TAG, r22.toString(), false, 4, null);     // Catch: Throwable -> L45 Exception -> L47
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L70
        ImageViewerActivity r30 = (ImageViewerActivity) ZeusTransformUtils.preCheckCast(this, ImageViewerActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        r21.close();     // Catch: Throwable -> L70
        r17.close();     // Catch: Throwable -> L70
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L72:
        return r16;
    L70:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L72
    L47:
        e = e;
        r15 = r17;
        r10 = r21;
    L122:
        RunLog.INSTANCE.error(TAG, "loadBitmapFromUri failed, uri=" + maskedForLog(r25), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L102
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L98
        InputStream r33 = (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L98
        if (r33 == null) goto L92;
        r33.close();     // Catch: Throwable -> L98
    L92:
        InputStream r34 = (InputStream) ZeusTransformUtils.preCheckCast(r15, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L98
        if (r34 == null) goto L95;
        r34.close();     // Catch: Throwable -> L98
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L98
    L96:
        Result.m1421constructorimpl(r35);     // Catch: Throwable -> L98
        return null;
    L95:
        r35 = null;
    L98:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return null;
    L102:
        th = move-exception;
        Unit r37 = null;
        Throwable r38 = th;
    L129:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L113
        InputStream r40 = (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L113
        if (r40 == null) goto L107;
        r40.close();     // Catch: Throwable -> L113
    L107:
        InputStream r41 = (InputStream) ZeusTransformUtils.preCheckCast(r15, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L113
        if (r41 == null) goto L110;
        r41.close();     // Catch: Throwable -> L113
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L113
    L111:
        Result.m1421constructorimpl(r42);     // Catch: Throwable -> L113
        throw r38;
    L110:
        r42 = r37;
    L113:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw r38;
    L45:
        th = move-exception;
        r38 = th;
        r15 = r17;
        r10 = r21;
    L39:
        r37 = null;
        goto L129
    L66:
        r28 = null;
        goto L67
    L62:
        r111 = null;
        goto L63
    L58:
        r110 = null;
    L54:
        r6 = "unknown";
    L50:
        r4 = "unknown";
        goto L51
    L49:
        r23 = r11;
        goto L50
    L124:
        StringCompanionObject r112 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L37 Exception -> L76
        r17 = r15;
        r21 = r10;
        r3 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf((r7 / 1024.0d) / 1024.0d)}, 1));     // Catch: Throwable -> L45 Exception -> L47
        Intrinsics.checkNotNullExpressionValue(r3, "format(...)");     // Catch: Throwable -> L45 Exception -> L47
        goto L41
    L35:
        e = e;
        r15 = r17;
    L33:
        th = move-exception;
        r38 = th;
        r15 = r17;
        goto L39
    L37:
        th = move-exception;
        r38 = th;
        goto L39
    L136:
        r16 = applyExifOrientation(r25, r12);     // Catch: Throwable -> L21 Exception -> L23
    L23:
        e = e;
    L21:
        th = th;
    L75:
        r38 = th;
        r37 = null;
    L76:
        e = e;
    L73:
        th = th;
        goto L75
    L127:
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L14
        ImageViewerActivity r45 = (ImageViewerActivity) ZeusTransformUtils.preCheckCast(this, ImageViewerActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r10.close();     // Catch: Throwable -> L14
        Result.m1421constructorimpl(null);     // Catch: Throwable -> L14
    L16:
        return null;
    L14:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L80:
        e = e;
    L87:
        r15 = null;
    L78:
        th = move-exception;
        r38 = th;
        r37 = null;
    L84:
        r15 = null;
        goto L129
    L85:
        e = e;
        r10 = null;
    L82:
        th = move-exception;
        r38 = th;
        r37 = null;
        r10 = null;
        goto L84
    }

    private final void loadImage(Uri r9) {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void loadSubsamplingImage(Uri r16, b r17, long r18) {
        Bitmap r1 = this.currentBitmap;
        if (r1 == null) goto L5;
        r1.recycle();
    L5:
        SubsamplingScaleImageView r2 = null;
        this.currentBitmap = null;
        this.currentImageInfo = r17;
        setViewerMode(ViewerMode.SUBSAMPLING);
        setupSubsamplingView();
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder().append("decodeImage mode=").append(ViewerMode.SUBSAMPLING.getValue()).append(", original=").append(r17.a()).append('x').append(r17.b()).append(", file=");
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        String r6 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf((r17.c() / 1024.0d) / 1024.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(r6, "format(...)");
        StringBuilder r7 = r3.append(r6).append("MB, pixels=");
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        String r9 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r17.d() / 1000000.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(r9, "format(...)");
        IRunLog.a.a(r4, TAG, r7.append(r9).append("MP, cost=").append(SystemClock.elapsedRealtime() - r18).append("ms").toString(), false, 4, null);
        SubsamplingScaleImageView r10 = this.subsamplingView;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
    L9:
        r2.setImage(ImageSource.uri(r16).tilingEnabled().dimensions(r17.a(), r17.b()));
        RunLog.INSTANCE.debug(TAG, "subsamplingSetImage uri=" + maskedForLog(r16));
        return;
    L8:
        r2 = r10;
        goto L9
    }

    private final String maskedForLog(Uri r2) {
        return com.obric.memorydata.utils.q.f13259a.b(redactedForLog(r2));
    }

    private static final void onConfigurationChanged$lambda$2$lambda$1(ImageViewerActivity r2, b r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).applySubsamplingScaleType(r3);
    }

    private static final void onConfigurationChanged$lambda$4$lambda$3(ImageViewerActivity r2, Bitmap r3) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).applyPhotoViewScaleType(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final c prepareTiledImageSource(Uri r10) {
        int r2 = 2;
        Object r3 = null;
        Object[] r4 = 0;
        Object[] r5 = 0;
        if (o.f10868a.a(r10.getScheme()) == false) goto L5;
        File r1 = File.createTempFile("image_viewer_", ".image", getCacheDir());
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L31
        InputStream r7 = ((ImageViewerActivity) ZeusTransformUtils.preCheckCast(this, ImageViewerActivity.class, "com.obric.memorydata.plugin")).getContentResolver().openInputStream(r10);     // Catch: Throwable -> L31
        if (r7 == null) goto L30;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        InputStream r9 = (InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L24
        OutputStream r11 = (OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1), OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (ZeusTransformUtils.instanceOf(r11, BufferedOutputStream.class) == false) goto L13;
        BufferedOutputStream r12 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r11, BufferedOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L14:
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        ByteStreamsKt.copyTo$default(r9, (OutputStream) ZeusTransformUtils.preCheckCast(r13, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L31
        Uri r14 = Uri.fromFile(r1);     // Catch: Throwable -> L31
        Intrinsics.checkNotNullExpressionValue(r14, "fromFile(...)");     // Catch: Throwable -> L31
        Object r15 = Result.m1421constructorimpl(new c(r14, r1));     // Catch: Throwable -> L31
    L33:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L37;
        r1.delete();
        RunLog.INSTANCE.error(TAG, "stage tiled image source failed, uri=" + maskedForLog(r10), r16);
    L37:
        if (Result.m1427isFailureimpl(r15) == true) goto L41;
        r3 = r15;
    L41:
        return (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L13:
        r12 = new BufferedOutputStream(r11, 8192);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L30:
        throw new IllegalStateException("Unable to open tiled image source".toString());     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L33
    L5:
        return new c(r10, r5 == true ? 1 : 0, r2, r4 == true ? 1 : 0);
    }

    private final int readExifOrientation(Uri r7) {
        InputStream r2 = getContentResolver().openInputStream(r7);     // Catch: IOException -> L15
        if (r2 == null) goto L23;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L15
        int r4 = new ExifInterface((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin")).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r3, null);     // Catch: IOException -> L15
        return r4;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: IOException -> L15
        throw th;     // Catch: IOException -> L15
    L23:
        return 1;
    L15:
        e = move-exception;
        RunLog.INSTANCE.warn(TAG, "read image exif orientation failed, uri=" + maskedForLog(r7), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return 1;
    }

    private final String redactedForLog(Uri r5) {
        String r4 = r5.getScheme();
        String r1 = "";
        if (r4 == null) goto L24;
        int r2 = r4.hashCode();
        if (r2 == 3143036) goto L19;
        if (r2 != 951530617) goto L24;
        if (r4.equals(Params.CONTENT) == false) goto L24;
        StringBuilder r6 = new StringBuilder().append("content://");
        String r3 = r5.getAuthority();
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        StringBuilder r7 = r6.append(r3).append('/');
        String r8 = r5.getLastPathSegment();
        if (r8 == null) goto L32;
    L30:
        r1 = r8;
    L32:
        return r7.append(r1).toString();
    L19:
        if (r4.equals("file") == false) goto L24;
        r7 = new StringBuilder().append("file://");
        r8 = r5.getLastPathSegment();
        if (r8 != null) goto L30;
    L24:
        StringBuilder r9 = new StringBuilder().append(r5.getScheme()).append("://");
        String r10 = r5.getAuthority();
        if (r10 != null) goto L27;
        r10 = "";
    L27:
        r7 = r9.append(r10).append('/');
        r8 = r5.getLastPathSegment();
        if (r8 != null) goto L30;
        goto L30
    }

    private final void setViewerMode(ViewerMode r2) {
        if (r2 != ViewerMode.SUBSAMPLING) goto L5;
        boolean r3 = true;
    L6:
        this.usingSubsamplingView = r3;
        applyPresentation(this.presentationState);
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void setupContentView() {
        FrameLayout r0 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r0.setBackgroundColor(0);
        this.rootLayout = r0;
        Bitmap r1 = p.f10869a.a();
        this.transitionSnapshotBitmap = r1;
        PhotoView r4 = null;
        if (r1 == null) goto L5;
        ImageView r5 = new ImageView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r5.setScaleType(ImageView.ScaleType.FIT_XY);
        r5.setImageBitmap(r1);
    L6:
        this.transitionSnapshotView = r5;
        FrameLayout r2 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r2.setBackgroundColor(0);
        this.viewerLayer = r2;
        PhotoView r3 = new PhotoView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r3.setVisibility(4);
        r3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r3.setMinimumScale(0.5f);
        r3.setMediumScale(2.5f);
        r3.setMaximumScale(5.0f);
        this.photoView = r3;
        SubsamplingScaleImageView r6 = new SubsamplingScaleImageView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.setVisibility(4);
        this.subsamplingView = r6;
        ODownloadProgressView r7 = new ODownloadProgressView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2, 17), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r7.setSize(2);
        r7.setVisibility(8);
        this.progressBar = r7;
        ImageView r8 = this.transitionSnapshotView;
        if (r8 == null) goto L12;
        FrameLayout r9 = this.rootLayout;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r9 = null;
    L11:
        r9.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
    L12:
        FrameLayout r10 = this.viewerLayer;
        if (r10 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewerLayer");
        r10 = null;
    L15:
        PhotoView r11 = this.photoView;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r11 = null;
    L18:
        r10.addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
        FrameLayout r12 = this.viewerLayer;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewerLayer");
        r12 = null;
    L21:
        SubsamplingScaleImageView r13 = this.subsamplingView;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r13 = null;
    L24:
        r12.addView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"));
        FrameLayout r14 = this.viewerLayer;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewerLayer");
        r14 = null;
    L27:
        ODownloadProgressView r15 = this.progressBar;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        r15 = null;
    L30:
        r14.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"));
        FrameLayout r16 = this.rootLayout;
        if (r16 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r16 = null;
    L33:
        FrameLayout r17 = this.viewerLayer;
        if (r17 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewerLayer");
        r17 = null;
    L36:
        r16.addView((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"));
        FrameLayout r18 = this.rootLayout;
        if (r18 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r18 = null;
    L39:
        setContentView((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"));
        PhotoView r19 = this.photoView;
        if (r19 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r19 = null;
    L42:
        r19.setOnPhotoTapListener($$Lambda$ImageViewerActivity$WkHYc8hVFjlsS6H9AQgPUOXVx0.INSTANCE);
        PhotoView r20 = this.photoView;
        if (r20 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L46:
        r4.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) ZeusTransformUtils.preCheckCast(new f(this), GestureDetector.OnDoubleTapListener.class, "com.obric.memorydata.plugin"));
        if (this.scaleBounceBack == false) goto L50;
        setupScaleBounceBack();
        return;
    L50:
        return;
    L45:
        r4 = r20;
        goto L46
    L5:
        r5 = null;
        goto L6
    }

    private static final void setupContentView$lambda$25(ImageView r0, float r1, float r2) {
    }

    private final void setupScaleBounceBack() {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        final Ref.FloatRef r1 = new Ref.FloatRef();
        r1.element = this.initialScale;
        PhotoView r2 = this.photoView;
        PhotoView r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r2 = null;
    L5:
        r2.setOnScaleChangeListener(new $$Lambda$ImageViewerActivity$ON4asZg6M6soI7PrJ8mSwjIPcHI(r0, r1, this));
        final Runnable r4 = new $$Lambda$ImageViewerActivity$hfEyjHDmb_ohw4bKBT_KMmo44vM(r0, this);
        PhotoView r5 = this.photoView;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L9:
        r3.setOnMatrixChangeListener(new $$Lambda$ImageViewerActivity$V78SSG1OjDlL31vNZCdYUbm6OY(this, r4));
        return;
    L8:
        r3 = r5;
        goto L9
    }

    private static final void setupScaleBounceBack$lambda$26(Ref.BooleanRef r0, Ref.FloatRef r1, ImageViewerActivity r2, float r3, float r4, float r5) {
        ImageViewerActivity r6 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        r0.element = true;
        PhotoView r7 = r6.photoView;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r7 = null;
    L5:
        r1.element = r7.getScale();
    }

    private static final void setupScaleBounceBack$lambda$27(Ref.BooleanRef r6, ImageViewerActivity r7) {
        ImageViewerActivity r8 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r7, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        if (r6.element == false) goto L21;
        PhotoView r0 = r8.photoView;
        PhotoView r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r0 = null;
    L7:
        float r2 = r0.getScale();
        float r3 = r8.dynamicMaxScale;
        if (r2 >= r8.initialScale) goto L15;
        PhotoView r4 = r8.photoView;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L13:
        r1.setScale(r8.initialScale, true);
        goto L21
    L12:
        r1 = r4;
        goto L13
    L15:
        if (r2 <= r3) goto L21;
        PhotoView r9 = r8.photoView;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L20:
        r1.setScale(r3, true);
        goto L21
    L19:
        r1 = r9;
    L21:
        r6.element = false;
    }

    private static final void setupScaleBounceBack$lambda$28(ImageViewerActivity r3, Runnable r4, RectF r5) {
        ImageViewerActivity r6 = (ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r3, ImageViewerActivity.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        PhotoView r8 = r6.photoView;
        PhotoView r0 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r8 = null;
    L5:
        r8.removeCallbacks(r7);
        PhotoView r9 = r6.photoView;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L9:
        r0.postDelayed(r7, 50);
        return;
    L8:
        r0 = r9;
        goto L9
    }

    private final void setupSubsamplingView() {
        SubsamplingScaleImageView r0 = this.subsamplingView;
        SubsamplingScaleImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r0 = null;
    L5:
        r0.setPanLimit(1);
        SubsamplingScaleImageView r2 = this.subsamplingView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r2 = null;
    L8:
        r2.setMinimumScaleType(1);
        SubsamplingScaleImageView r3 = this.subsamplingView;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r3 = null;
    L11:
        r3.setOrientation(-1);
        SubsamplingScaleImageView r4 = this.subsamplingView;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r4 = null;
    L14:
        r4.setDoubleTapZoomStyle(1);
        SubsamplingScaleImageView r5 = this.subsamplingView;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r5 = null;
    L17:
        r5.setDoubleTapZoomDuration(200);
        SubsamplingScaleImageView r6 = this.subsamplingView;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r6 = null;
    L20:
        r6.setEagerLoadingEnabled(true);
        SubsamplingScaleImageView r7 = this.subsamplingView;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r7 = null;
    L23:
        r7.setOnClickListener($$Lambda$ImageViewerActivity$QRqMki2bVRDURehZkHo2lP9djLc.INSTANCE);
        SubsamplingScaleImageView r8 = this.subsamplingView;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r8 = null;
    L26:
        r8.setOnImageEventListener((SubsamplingScaleImageView.OnImageEventListener) ZeusTransformUtils.preCheckCast(new g(this), SubsamplingScaleImageView.OnImageEventListener.class, "com.obric.memorydata.plugin"));
        SubsamplingScaleImageView r9 = this.subsamplingView;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
    L30:
        r1.setOnStateChangedListener((SubsamplingScaleImageView.OnStateChangedListener) ZeusTransformUtils.preCheckCast(new h(this), SubsamplingScaleImageView.OnStateChangedListener.class, "com.obric.memorydata.plugin"));
        return;
    L29:
        r1 = r9;
        goto L30
    }

    private static final void setupSubsamplingView$lambda$5(View r0) {
    }

    private final void setupWindow() {
        Window r0 = getWindow();
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.layoutInDisplayCutoutMode = 1;
        r1.alpha = 0.0f;
        r0.setAttributes(r1);
        r0.setStatusBarColor(0);
        r0.setStatusBarContrastEnforced(false);
        r0.setNavigationBarContrastEnforced(false);
        if (this.fullScreen == false) goto L5;
        getWindow().getDecorView().setSystemUiVisibility(5894);
        return;
    L5:
        updateSystemBarsAppearance();
    }

    private final void showActiveViewer() {
        FrameLayout r0 = this.rootLayout;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L5:
        r0.removeCallbacks(this.showDelayedProgress);
        applyPresentation(ImageViewerPresentationState.READY);
    }

    private static final void showDelayedProgress$lambda$0(ImageViewerActivity r2) {
        ((ImageViewerActivity) ZeusTransformUtils.wrapperContextForParams(r2, ImageViewerActivity.class, "com.obric.memorydata.plugin")).applyPresentation(ImageViewerPresentationState.LOADING_WITH_PROGRESS);
    }

    private final void showError(String r9) {
        FrameLayout r0 = this.rootLayout;
        ODownloadProgressView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L5:
        r0.removeCallbacks(this.showDelayedProgress);
        ODownloadProgressView r2 = this.progressBar;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L9:
        r1.setVisibility(8);
        com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), r9, 0, 4, null);
        finish();
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void showProgress() {
        FrameLayout r0 = this.rootLayout;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L5:
        r0.removeCallbacks(this.showDelayedProgress);
        applyPresentation(ImageViewerPresentationState.LOADING);
        FrameLayout r2 = this.rootLayout;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
    L9:
        r1.postDelayed(this.showDelayedProgress, 150);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void startFrameMonitor() {
        if (this.frameMonitorStarted == false) goto L5;
        return;
    L5:
        this.frameMonitorStarted = true;
        this.lastFrameTimeNanos = 0;
        this.frameCount = 0;
        this.slowFrame32Count = 0;
        this.slowFrame50Count = 0;
        this.maxFrameDurationMs = 0.0f;
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.frameCallback, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
    }

    private final void stopFrameMonitor(String r9) {
        if (this.frameMonitorStarted == true) goto L5;
        return;
    L5:
        this.frameMonitorStarted = false;
        Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.frameCallback, Choreographer.FrameCallback.class, "com.obric.memorydata.plugin"));
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("imageViewerFrameStats reason=").append(r9).append(", frameCount=").append(this.frameCount).append(", slowFrame32=").append(this.slowFrame32Count).append(", slowFrame50=").append(this.slowFrame50Count).append(", maxFrameDurationMs=");
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        String r0 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.maxFrameDurationMs)}, 1));
        Intrinsics.checkNotNullExpressionValue(r0, "format(...)");
        IRunLog.a.a(r2, TAG, r10.append(r0).append(", scale=").append(getCurrentViewerScale()).toString(), false, 4, null);
    }

    private final void updateSystemBarsAppearance() {
        if (this.fullScreen == true) goto L9;
        int r0 = 1792;
        if (isColorLight(this.backgroundColor) == false) goto L7;
        r0 = 10000;
    L7:
        getWindow().getDecorView().setSystemUiVisibility(r0);
        return;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        int r0 = com.obric.memorydata.utils.ba.c();
        boolean r1 = isLocked();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed taskId=" + getTaskId() + ", numActivities=" + r0 + ", locked=" + r1, false, 4, null);
        if (r1 == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed: locked → exitApp", false, 4, null);
        exitApp();
        return;
    L6:
        finishViewer();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super.onConfigurationChanged(r3);
        if (getIntent().hasExtra(EXTRA_BACKGROUND_COLOR) == true) goto L5;
        this.backgroundColor = getColor(ZeusTransformUtils.mapRes(R.color.bg_activity_image_viewer, TypedValues.Custom.S_COLOR, "bg_activity_image_viewer"));
        applyPresentation(this.presentationState);
        updateSystemBarsAppearance();
    L5:
        PhotoView r0 = null;
        SubsamplingScaleImageView r1 = null;
        if (this.usingSubsamplingView == false) goto L14;
        final b r4 = this.currentImageInfo;
        if (r4 == null) goto L22;
        SubsamplingScaleImageView r2 = this.subsamplingView;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
    L13:
        r1.post(new $$Lambda$ImageViewerActivity$CMoM41a_PZzg8Y2awmgkQn2tA(this, r4));
        return;
    L12:
        r1 = r2;
        goto L13
    L22:
        return;
    L14:
        final Bitmap r5 = this.currentBitmap;
        if (r5 == null) goto L24;
        PhotoView r6 = this.photoView;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
    L20:
        r0.post(new $$Lambda$ImageViewerActivity$vnp69UJ5ZA09L0mQOlbyl5KwOMA(this, r5));
        return;
    L19:
        r0 = r6;
        goto L20
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r9) {
        configureActivityTransitions();
        SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.ARGB_8888);
        if (getIntent().hasExtra(EXTRA_BACKGROUND_COLOR) == false) goto L5;
        int r10 = getIntent().getIntExtra(EXTRA_BACKGROUND_COLOR, ViewCompat.MEASURED_STATE_MASK);
    L6:
        this.backgroundColor = r10;
        this.scaleBounceBack = getIntent().getBooleanExtra(EXTRA_SCALE_BOUNCE_BACK, false);
        this.fullScreen = getIntent().getBooleanExtra(EXTRA_FULL_SCREEN, true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "openImageViewer fullScreen=" + this.fullScreen + ", scaleBounceBack=" + this.scaleBounceBack + ", device=" + DeviceInfoState.INSTANCE.getDeviceModel() + ", rom=" + ar.a() + ", density=" + ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().densityDpi + ", hardwareAccelerated=" + getWindow().getDecorView().isHardwareAccelerated(), false, 4, null);
        RunLog r11 = RunLog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("openImageViewer uri=");
        Uri r2 = getImageUri();
        if (r2 == null) goto L9;
        String r3 = maskedForLog(r2);
    L10:
        r11.debug(TAG, r0.append(r3).toString());
        setupWindow();
        setupContentView();
        Uri r12 = com.obric.memorydata.memory.utils.f.f11537a.a(getImageUri());
        if (r12 == null) goto L13;
        loadImage(r12);
        return;
    L13:
        com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "无效的图片URI", 0, 4, null);
        finish();
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r10 = getColor(ZeusTransformUtils.mapRes(R.color.bg_activity_image_viewer, TypedValues.Custom.S_COLOR, "bg_activity_image_viewer"));
        goto L6
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        cancelWindowAlphaAnimation();
        FrameLayout r0 = this.rootLayout;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r0 = null;
    L6:
        r0.removeCallbacks(this.showDelayedProgress);
    L7:
        stopFrameMonitor("onDestroy");
        PhotoView r1 = this.photoView;
        if (r1 == null) goto L12;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");
        r1 = null;
    L11:
        r1.setImageDrawable(null);
    L12:
        SubsamplingScaleImageView r2 = this.subsamplingView;
        if (r2 == null) goto L17;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("subsamplingView");
        r2 = null;
    L16:
        r2.recycle();
    L17:
        super.onDestroy();
        Bitmap r3 = this.currentBitmap;
        if (r3 == null) goto L20;
        r3.recycle();
    L20:
        this.currentBitmap = null;
        ImageView r4 = this.transitionSnapshotView;
        if (r4 == null) goto L23;
        r4.setImageDrawable(null);
    L23:
        this.transitionSnapshotView = null;
        Bitmap r5 = this.transitionSnapshotBitmap;
        if (r5 != null) goto L26;
    L31:
        this.transitionSnapshotBitmap = null;
        File r6 = this.stagedTiledImageFile;
        if (r6 == null) goto L34;
        r6.delete();
    L34:
        this.stagedTiledImageFile = null;
        return;
    L26:
        if ((!r5.isRecycled()) == true) goto L29;
        r5 = null;
    L29:
        if (r5 == null) goto L31;
        r5.recycle();
        goto L31
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        stopFrameMonitor("onPause");
        super.onPause();
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.fullScreen == false) goto L9;
        getWindow().getDecorView().setSystemUiVisibility(5894);
        return;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean skipOnCreateCustomLogic() {
        return true;
    }
}
