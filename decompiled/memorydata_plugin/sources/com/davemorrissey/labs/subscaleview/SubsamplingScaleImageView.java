package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    private static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    private static final List<Integer> VALID_EASING_STYLES = null;
    private static final List<Integer> VALID_ORIENTATIONS = null;
    private static final List<Integer> VALID_PAN_LIMITS = null;
    private static final List<Integer> VALID_SCALE_TYPES = null;
    private static final List<Integer> VALID_ZOOM_STYLES = null;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    private final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;

    private static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }

        /* synthetic */ Anim(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean access$2700(Anim r0) {
            return r0.interruptible;
        }

        static /* synthetic */ boolean access$2702(Anim r0, boolean r1) {
            r0.interruptible = r1;
            return r1;
        }

        static /* synthetic */ OnAnimationEventListener access$2800(Anim r0) {
            return r0.listener;
        }

        static /* synthetic */ OnAnimationEventListener access$2802(Anim r2, OnAnimationEventListener r3) {
            OnAnimationEventListener r4 = (OnAnimationEventListener) ZeusTransformUtils.wrapperContextForParams(r3, OnAnimationEventListener.class, "com.obric.memorydata.plugin");
            r2.listener = r4;
            return r4;
        }

        static /* synthetic */ PointF access$3100(Anim r0) {
            return r0.vFocusStart;
        }

        static /* synthetic */ PointF access$3102(Anim r0, PointF r1) {
            r0.vFocusStart = r1;
            return r1;
        }

        static /* synthetic */ long access$3200(Anim r2) {
            return r2.time;
        }

        static /* synthetic */ long access$3202(Anim r0, long r1) {
            r0.time = r1;
            return r1;
        }

        static /* synthetic */ long access$3300(Anim r2) {
            return r2.duration;
        }

        static /* synthetic */ long access$3302(Anim r0, long r1) {
            r0.duration = r1;
            return r1;
        }

        static /* synthetic */ int access$3400(Anim r0) {
            return r0.easing;
        }

        static /* synthetic */ int access$3402(Anim r0, int r1) {
            r0.easing = r1;
            return r1;
        }

        static /* synthetic */ float access$3500(Anim r0) {
            return r0.scaleStart;
        }

        static /* synthetic */ float access$3502(Anim r0, float r1) {
            r0.scaleStart = r1;
            return r1;
        }

        static /* synthetic */ float access$3600(Anim r0) {
            return r0.scaleEnd;
        }

        static /* synthetic */ float access$3602(Anim r0, float r1) {
            r0.scaleEnd = r1;
            return r1;
        }

        static /* synthetic */ PointF access$3700(Anim r0) {
            return r0.vFocusEnd;
        }

        static /* synthetic */ PointF access$3702(Anim r0, PointF r1) {
            r0.vFocusEnd = r1;
            return r1;
        }

        static /* synthetic */ PointF access$3800(Anim r0) {
            return r0.sCenterEnd;
        }

        static /* synthetic */ PointF access$3802(Anim r0, PointF r1) {
            r0.sCenterEnd = r1;
            return r1;
        }

        static /* synthetic */ int access$3900(Anim r0) {
            return r0.origin;
        }

        static /* synthetic */ int access$3902(Anim r0, int r1) {
            r0.origin = r1;
            return r1;
        }

        static /* synthetic */ PointF access$4400(Anim r0) {
            return r0.sCenterStart;
        }

        static /* synthetic */ PointF access$4402(Anim r0, PointF r1) {
            r0.sCenterStart = r1;
            return r1;
        }

        static /* synthetic */ PointF access$4500(Anim r0) {
            return r0.sCenterEndRequested;
        }

        static /* synthetic */ PointF access$4502(Anim r0, PointF r1) {
            r0.sCenterEndRequested = r1;
            return r1;
        }
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        final /* synthetic */ SubsamplingScaleImageView this$0;
        private final PointF vFocus;

        private AnimationBuilder(SubsamplingScaleImageView r3, float r4) {
            this.this$0 = r3;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = r4;
            this.targetSCenter = r3.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(SubsamplingScaleImageView r3, float r4, PointF r5) {
            this.this$0 = r3;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = r4;
            this.targetSCenter = r5;
            this.vFocus = null;
        }

        private AnimationBuilder(SubsamplingScaleImageView r3, float r4, PointF r5, PointF r6) {
            this.this$0 = r3;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = r4;
            this.targetSCenter = r5;
            this.vFocus = r6;
        }

        /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r1, float r2, PointF r3, PointF r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r1, float r2, PointF r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r1, float r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private AnimationBuilder(SubsamplingScaleImageView r3, PointF r4) {
            this.this$0 = r3;
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.access$1000(r3);
            this.targetSCenter = r4;
            this.vFocus = null;
        }

        /* synthetic */ AnimationBuilder(SubsamplingScaleImageView r1, PointF r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ AnimationBuilder access$1200(AnimationBuilder r0, boolean r1) {
            return r0.withPanLimited(r1);
        }

        static /* synthetic */ AnimationBuilder access$1300(AnimationBuilder r0, int r1) {
            return r0.withOrigin(r1);
        }

        private AnimationBuilder withOrigin(int r1) {
            this.origin = r1;
            return this;
        }

        private AnimationBuilder withPanLimited(boolean r1) {
            this.panLimited = r1;
            return this;
        }

        public void start() {
            if (SubsamplingScaleImageView.access$6400(this.this$0) != null) goto L5;
        L10:
            int r0 = this.this$0.getPaddingLeft() + (((this.this$0.getWidth() - this.this$0.getPaddingRight()) - this.this$0.getPaddingLeft()) / 2);
            int r1 = this.this$0.getPaddingTop() + (((this.this$0.getHeight() - this.this$0.getPaddingBottom()) - this.this$0.getPaddingTop()) / 2);
            float r2 = SubsamplingScaleImageView.access$6500(this.this$0, this.targetScale);
            if (this.panLimited == false) goto L13;
            PointF r3 = SubsamplingScaleImageView.access$6600(this.this$0, this.targetSCenter.x, this.targetSCenter.y, r2, new PointF());
        L14:
            AnonymousClass1 r6 = null;
            SubsamplingScaleImageView.access$6402(this.this$0, new Anim(r6));
            Anim.access$3502(SubsamplingScaleImageView.access$6400(this.this$0), SubsamplingScaleImageView.access$1000(this.this$0));
            Anim.access$3602(SubsamplingScaleImageView.access$6400(this.this$0), r2);
            Anim.access$3202(SubsamplingScaleImageView.access$6400(this.this$0), System.currentTimeMillis());
            Anim.access$4502(SubsamplingScaleImageView.access$6400(this.this$0), r3);
            Anim.access$4402(SubsamplingScaleImageView.access$6400(this.this$0), this.this$0.getCenter());
            Anim.access$3802(SubsamplingScaleImageView.access$6400(this.this$0), r3);
            Anim.access$3102(SubsamplingScaleImageView.access$6400(this.this$0), this.this$0.sourceToViewCoord(r3));
            Anim.access$3702(SubsamplingScaleImageView.access$6400(this.this$0), new PointF(r0, r1));
            Anim.access$3302(SubsamplingScaleImageView.access$6400(this.this$0), this.duration);
            Anim.access$2702(SubsamplingScaleImageView.access$6400(this.this$0), this.interruptible);
            Anim.access$3402(SubsamplingScaleImageView.access$6400(this.this$0), this.easing);
            Anim.access$3902(SubsamplingScaleImageView.access$6400(this.this$0), this.origin);
            Anim.access$3202(SubsamplingScaleImageView.access$6400(this.this$0), System.currentTimeMillis());
            Anim.access$2802(SubsamplingScaleImageView.access$6400(this.this$0), this.listener);
            PointF r4 = this.vFocus;
            if (r4 == null) goto L17;
            float r5 = r4.x - (Anim.access$4400(SubsamplingScaleImageView.access$6400(this.this$0)).x * r2);
            float r7 = this.vFocus.y - (Anim.access$4400(SubsamplingScaleImageView.access$6400(this.this$0)).y * r2);
            ScaleAndTranslate r8 = new ScaleAndTranslate(r2, new PointF(r5, r7), r6);
            SubsamplingScaleImageView.access$6800(this.this$0, true, r8);
            Anim.access$3702(SubsamplingScaleImageView.access$6400(this.this$0), new PointF(this.vFocus.x + (ScaleAndTranslate.access$4800(r8).x - r5), this.vFocus.y + (ScaleAndTranslate.access$4800(r8).y - r7)));
        L17:
            this.this$0.invalidate();
            return;
        L13:
            r3 = this.targetSCenter;
            goto L14
        L5:
            if (Anim.access$2800(SubsamplingScaleImageView.access$6400(this.this$0)) == null) goto L10;
            Anim.access$2800(SubsamplingScaleImageView.access$6400(this.this$0)).onInterruptedByNewAnim();     // Catch: Exception -> L8
        L8:
            e = move-exception;
            Log.w(SubsamplingScaleImageView.access$5400(), "Error thrown by animation listener", e);
            goto L10
        }

        public AnimationBuilder withDuration(long r1) {
            this.duration = r1;
            return this;
        }

        public AnimationBuilder withEasing(int r3) {
            if (SubsamplingScaleImageView.access$6300().contains(Integer.valueOf(r3)) == false) goto L7;
            this.easing = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Unknown easing type: " + r3);
        }

        public AnimationBuilder withInterruptible(boolean r1) {
            this.interruptible = r1;
            return this;
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener r3) {
            this.listener = (OnAnimationEventListener) ZeusTransformUtils.wrapperContextForParams(r3, OnAnimationEventListener.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(SubsamplingScaleImageView r3, Context r4, DecoderFactory<? extends ImageDecoder> r5, Uri r6, boolean r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            DecoderFactory r9 = (DecoderFactory) ZeusTransformUtils.wrapperContextForParams(r5, DecoderFactory.class, "com.obric.memorydata.plugin");
            this.viewRef = new WeakReference(r3);
            this.contextRef = new WeakReference(r8);
            this.decoderFactoryRef = new WeakReference(r9);
            this.source = r6;
            this.preview = r7;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Integer doInBackground2(Void... r7) {
            String r0 = this.source.toString();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(this.contextRef.get(), Context.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L9 Exception -> L11
            DecoderFactory r2 = (DecoderFactory) ZeusTransformUtils.preCheckCast(this.decoderFactoryRef.get(), DecoderFactory.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L9 Exception -> L11
            SubsamplingScaleImageView r3 = (SubsamplingScaleImageView) ZeusTransformUtils.preCheckCast(this.viewRef.get(), SubsamplingScaleImageView.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L9 Exception -> L11
            if (r1 == null) goto L17;
            if (r2 == null) goto L18;
            if (r3 == null) goto L19;
            SubsamplingScaleImageView.access$5100(r3, "BitmapLoadTask.doInBackground", new Object[0]);     // Catch: OutOfMemoryError -> L9 Exception -> L11
            this.bitmap = ((ImageDecoder) ZeusTransformUtils.preCheckCast(r2.make(), ImageDecoder.class, "com.obric.memorydata.plugin")).decode(r1, this.source);     // Catch: OutOfMemoryError -> L9 Exception -> L11
            return Integer.valueOf(SubsamplingScaleImageView.access$5200(r3, r1, r0));
        L19:
            return null;
        L18:
            return null;
        L17:
            return null;
        L11:
            e = move-exception;
            Log.e(SubsamplingScaleImageView.access$5400(), "Failed to load bitmap", e);
            this.exception = e;
            return null;
        L9:
            e = move-exception;
            Log.e(SubsamplingScaleImageView.access$5400(), "Failed to load bitmap - OutOfMemoryError", e);
            this.exception = new RuntimeException(e);
            return null;
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ Integer doInBackground(Void[] r3) {
            return doInBackground2((Void[]) ZeusTransformUtils.preCheckCast(r3, Void[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Integer r4) {
            SubsamplingScaleImageView r0 = (SubsamplingScaleImageView) ZeusTransformUtils.preCheckCast(this.viewRef.get(), SubsamplingScaleImageView.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L20;
            Bitmap r1 = this.bitmap;
            if (r1 == null) goto L12;
            if (r4 == null) goto L12;
            if (this.preview == false) goto L10;
            SubsamplingScaleImageView.access$6000(r0, r1);
            return;
        L10:
            SubsamplingScaleImageView.access$6100(r0, r1, r4.intValue(), false);
            return;
        L12:
            if (this.exception != null) goto L14;
            return;
        L14:
            if (SubsamplingScaleImageView.access$5600(r0) != null) goto L16;
            return;
        L16:
            if (this.preview == false) goto L18;
            SubsamplingScaleImageView.access$5600(r0).onPreviewLoadError(this.exception);
            return;
        L18:
            SubsamplingScaleImageView.access$5600(r0).onImageLoadError(this.exception);
            return;
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(Integer r3) {
            onPostExecute2((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin"));
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public DefaultOnAnimationEventListener() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public DefaultOnImageEventListener() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception r1) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception r1) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception r1) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public DefaultOnStateChangedListener() {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(PointF r1, int r2) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float r1, int r2) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception r1);

        void onImageLoaded();

        void onPreviewLoadError(Exception r1);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception r1);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF r1, int r2);

        void onScaleChanged(float r1, int r2);
    }

    private static class ScaleAndTranslate {
        private float scale;
        private final PointF vTranslate;

        private ScaleAndTranslate(float r1, PointF r2) {
            this.scale = r1;
            this.vTranslate = r2;
        }

        /* synthetic */ ScaleAndTranslate(float r1, PointF r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ float access$4700(ScaleAndTranslate r0) {
            return r0.scale;
        }

        static /* synthetic */ float access$4702(ScaleAndTranslate r0, float r1) {
            r0.scale = r1;
            return r1;
        }

        static /* synthetic */ PointF access$4800(ScaleAndTranslate r0) {
            return r0.vTranslate;
        }
    }

    private static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }

        /* synthetic */ Tile(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean access$400(Tile r0) {
            return r0.visible;
        }

        static /* synthetic */ boolean access$4000(Tile r0) {
            return r0.loading;
        }

        static /* synthetic */ boolean access$4002(Tile r0, boolean r1) {
            r0.loading = r1;
            return r1;
        }

        static /* synthetic */ boolean access$402(Tile r0, boolean r1) {
            r0.visible = r1;
            return r1;
        }

        static /* synthetic */ Rect access$4100(Tile r0) {
            return r0.sRect;
        }

        static /* synthetic */ Rect access$4102(Tile r0, Rect r1) {
            r0.sRect = r1;
            return r1;
        }

        static /* synthetic */ Rect access$4200(Tile r0) {
            return r0.vRect;
        }

        static /* synthetic */ Rect access$4202(Tile r0, Rect r1) {
            r0.vRect = r1;
            return r1;
        }

        static /* synthetic */ int access$4300(Tile r0) {
            return r0.sampleSize;
        }

        static /* synthetic */ int access$4302(Tile r0, int r1) {
            r0.sampleSize = r1;
            return r1;
        }

        static /* synthetic */ Bitmap access$500(Tile r0) {
            return r0.bitmap;
        }

        static /* synthetic */ Rect access$5000(Tile r0) {
            return r0.fileSRect;
        }

        static /* synthetic */ Rect access$5002(Tile r0, Rect r1) {
            r0.fileSRect = r1;
            return r1;
        }

        static /* synthetic */ Bitmap access$502(Tile r0, Bitmap r1) {
            r0.bitmap = r1;
            return r1;
        }
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TileLoadTask(SubsamplingScaleImageView r3, ImageRegionDecoder r4, Tile r5) {
            ImageRegionDecoder r6 = (ImageRegionDecoder) ZeusTransformUtils.wrapperContextForParams(r4, ImageRegionDecoder.class, "com.obric.memorydata.plugin");
            this.viewRef = new WeakReference(r3);
            this.decoderRef = new WeakReference(r6);
            this.tileRef = new WeakReference(r5);
            Tile.access$4002(r5, true);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Bitmap doInBackground2(Void... r8) {
            SubsamplingScaleImageView r0 = (SubsamplingScaleImageView) ZeusTransformUtils.preCheckCast(this.viewRef.get(), SubsamplingScaleImageView.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L28 Exception -> L30
            ImageRegionDecoder r1 = (ImageRegionDecoder) ZeusTransformUtils.preCheckCast(this.decoderRef.get(), ImageRegionDecoder.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L28 Exception -> L30
            Tile r9 = (Tile) ZeusTransformUtils.preCheckCast(this.tileRef.get(), Tile.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L28 Exception -> L30
            if (r1 == null) goto L25;
            if (r9 == null) goto L25;
            if (r0 == null) goto L25;
            if (r1.isReady() == false) goto L25;
            if (Tile.access$400(r9) == false) goto L25;
            SubsamplingScaleImageView.access$5100(r0, "TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", new Object[]{Tile.access$4100(r9), Integer.valueOf(Tile.access$4300(r9))});     // Catch: OutOfMemoryError -> L28 Exception -> L30
            SubsamplingScaleImageView.access$5700(r0).readLock().lock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L22:
            th = move-exception;
            SubsamplingScaleImageView.access$5700(r0).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            throw th;     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L13:
            if (r1.isReady() == false) goto L20;
            SubsamplingScaleImageView.access$5800(r0, Tile.access$4100(r9), Tile.access$5000(r9));     // Catch: Throwable -> L22
            if (SubsamplingScaleImageView.access$5300(r0) == null) goto L17;
            Tile.access$5000(r9).offset(SubsamplingScaleImageView.access$5300(r0).left, SubsamplingScaleImageView.access$5300(r0).top);     // Catch: Throwable -> L22
        L17:
            Bitmap r10 = r1.decodeRegion(Tile.access$5000(r9), Tile.access$4300(r9));     // Catch: Throwable -> L22
            SubsamplingScaleImageView.access$5700(r0).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            return r10;
        L20:
            Tile.access$4002(r9, false);     // Catch: Throwable -> L22
            SubsamplingScaleImageView.access$5700(r0).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            return null;
        L25:
            if (r9 == null) goto L37;
            Tile.access$4002(r9, false);     // Catch: OutOfMemoryError -> L28 Exception -> L30
            return null;
        L37:
            return null;
        L30:
            e = move-exception;
            Log.e(SubsamplingScaleImageView.access$5400(), "Failed to decode tile", e);
            this.exception = e;
            return null;
        L28:
            e = move-exception;
            Log.e(SubsamplingScaleImageView.access$5400(), "Failed to decode tile - OutOfMemoryError", e);
            this.exception = new RuntimeException(e);
            return null;
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ Bitmap doInBackground(Void[] r3) {
            return doInBackground2((Void[]) ZeusTransformUtils.preCheckCast(r3, Void[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Bitmap r5) {
            SubsamplingScaleImageView r0 = (SubsamplingScaleImageView) ZeusTransformUtils.preCheckCast(this.viewRef.get(), SubsamplingScaleImageView.class, "com.obric.memorydata.plugin");
            Tile r1 = (Tile) ZeusTransformUtils.preCheckCast(this.tileRef.get(), Tile.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L13;
            if (r1 == null) goto L14;
            if (r5 == null) goto L8;
            Tile.access$502(r1, r5);
            Tile.access$4002(r1, false);
            SubsamplingScaleImageView.access$5900(r0);
            return;
        L8:
            if (this.exception != null) goto L10;
            return;
        L10:
            if (SubsamplingScaleImageView.access$5600(r0) == null) goto L17;
            SubsamplingScaleImageView.access$5600(r0).onTileLoadError(this.exception);
            return;
        L17:
            return;
        L14:
            return;
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(Bitmap r3) {
            onPostExecute2((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TilesInitTask(SubsamplingScaleImageView r3, Context r4, DecoderFactory<? extends ImageRegionDecoder> r5, Uri r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            DecoderFactory r8 = (DecoderFactory) ZeusTransformUtils.wrapperContextForParams(r5, DecoderFactory.class, "com.obric.memorydata.plugin");
            this.viewRef = new WeakReference(r3);
            this.contextRef = new WeakReference(r7);
            this.decoderFactoryRef = new WeakReference(r8);
            this.source = r6;
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ int[] doInBackground(Void[] r3) {
            return doInBackground2((Void[]) ZeusTransformUtils.preCheckCast(r3, Void[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public int[] doInBackground2(Void... r8) {
            String r0 = this.source.toString();     // Catch: Exception -> L12
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(this.contextRef.get(), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            DecoderFactory r2 = (DecoderFactory) ZeusTransformUtils.preCheckCast(this.decoderFactoryRef.get(), DecoderFactory.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            SubsamplingScaleImageView r3 = (SubsamplingScaleImageView) ZeusTransformUtils.preCheckCast(this.viewRef.get(), SubsamplingScaleImageView.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            if (r1 == null) goto L18;
            if (r2 == null) goto L19;
            if (r3 == null) goto L20;
            SubsamplingScaleImageView.access$5100(r3, "TilesInitTask.doInBackground", new Object[0]);     // Catch: Exception -> L12
            ImageRegionDecoder r9 = (ImageRegionDecoder) ZeusTransformUtils.preCheckCast(r2.make(), ImageRegionDecoder.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            this.decoder = r9;     // Catch: Exception -> L12
            Point r10 = r9.init(r1, this.source);     // Catch: Exception -> L12
            int r4 = r10.x;     // Catch: Exception -> L12
            int r11 = r10.y;     // Catch: Exception -> L12
            int r5 = SubsamplingScaleImageView.access$5200(r3, r1, r0);     // Catch: Exception -> L12
            if (SubsamplingScaleImageView.access$5300(r3) == null) goto L10;
            SubsamplingScaleImageView.access$5300(r3).left = Math.max(0, SubsamplingScaleImageView.access$5300(r3).left);     // Catch: Exception -> L12
            SubsamplingScaleImageView.access$5300(r3).top = Math.max(0, SubsamplingScaleImageView.access$5300(r3).top);     // Catch: Exception -> L12
            SubsamplingScaleImageView.access$5300(r3).right = Math.min(r4, SubsamplingScaleImageView.access$5300(r3).right);     // Catch: Exception -> L12
            SubsamplingScaleImageView.access$5300(r3).bottom = Math.min(r11, SubsamplingScaleImageView.access$5300(r3).bottom);     // Catch: Exception -> L12
            r4 = SubsamplingScaleImageView.access$5300(r3).width();     // Catch: Exception -> L12
            r11 = SubsamplingScaleImageView.access$5300(r3).height();     // Catch: Exception -> L12
        L10:
            return new int[]{r4, r11, r5};
        L20:
            return null;
        L19:
            return null;
        L18:
            return null;
        L12:
            e = move-exception;
            Log.e(SubsamplingScaleImageView.access$5400(), "Failed to initialise bitmap decoder", e);
            this.exception = e;
            return null;
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(int[] r3) {
            onPostExecute2((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(int[] r5) {
            SubsamplingScaleImageView r0 = (SubsamplingScaleImageView) ZeusTransformUtils.preCheckCast(this.viewRef.get(), SubsamplingScaleImageView.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L16;
            ImageRegionDecoder r1 = this.decoder;
            if (r1 == null) goto L11;
            if (r5 == null) goto L11;
            if (r5.length != 3) goto L11;
            SubsamplingScaleImageView.access$5500(r0, r1, r5[0], r5[1], r5[2]);
            return;
        L11:
            if (this.exception != null) goto L13;
            return;
        L13:
            if (SubsamplingScaleImageView.access$5600(r0) == null) goto L19;
            SubsamplingScaleImageView.access$5600(r0).onImageLoadError(this.exception);
            return;
        L19:
            return;
        }
    }

    static {
        VALID_ORIENTATIONS = Arrays.asList(new Integer[]{0, 90, Integer.valueOf(ORIENTATION_180), Integer.valueOf(ORIENTATION_270), -1});
        VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{1, 2, 3});
        VALID_EASING_STYLES = Arrays.asList(new Integer[]{2, 1});
        VALID_PAN_LIMITS = Arrays.asList(new Integer[]{1, 2, 3});
        VALID_SCALE_TYPES = Arrays.asList(new Integer[]{2, 1, 3, 4});
    }

    public SubsamplingScaleImageView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public SubsamplingScaleImageView(Context r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r9, r10);
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(r9);
        this.handler = new Handler(new AnonymousClass1(this));
        if (r10 == null) goto L29;
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r10, R.styleable.SubsamplingScaleImageView);
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_assetName, "styleable", "SubsamplingScaleImageView_assetName")) == false) goto L12;
        String r3 = r11.getString(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_assetName, "styleable", "SubsamplingScaleImageView_assetName"));
        if (r3 == null) goto L12;
        if (r3.length() <= 0) goto L12;
        setImage(ImageSource.asset(r3).tilingEnabled());
    L12:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_src, "styleable", "SubsamplingScaleImageView_src")) == false) goto L17;
        int r4 = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_src, "styleable", "SubsamplingScaleImageView_src"), 0);
        if (r4 <= 0) goto L17;
        setImage(ImageSource.resource(r4).tilingEnabled());
    L17:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_panEnabled, "styleable", "SubsamplingScaleImageView_panEnabled")) == false) goto L20;
        setPanEnabled(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_panEnabled, "styleable", "SubsamplingScaleImageView_panEnabled"), true));
    L20:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_zoomEnabled, "styleable", "SubsamplingScaleImageView_zoomEnabled")) == false) goto L23;
        setZoomEnabled(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_zoomEnabled, "styleable", "SubsamplingScaleImageView_zoomEnabled"), true));
    L23:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_quickScaleEnabled, "styleable", "SubsamplingScaleImageView_quickScaleEnabled")) == false) goto L26;
        setQuickScaleEnabled(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_quickScaleEnabled, "styleable", "SubsamplingScaleImageView_quickScaleEnabled"), true));
    L26:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_tileBackgroundColor, "styleable", "SubsamplingScaleImageView_tileBackgroundColor")) == false) goto L28;
        setTileBackgroundColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.SubsamplingScaleImageView_tileBackgroundColor, "styleable", "SubsamplingScaleImageView_tileBackgroundColor"), Color.argb(0, 0, 0, 0)));
    L28:
        r11.recycle();
    L29:
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getDisplayMetrics());
    }

    static /* synthetic */ View.OnLongClickListener access$000(SubsamplingScaleImageView r0) {
        return r0.onLongClickListener;
    }

    static /* synthetic */ float access$1000(SubsamplingScaleImageView r0) {
        return r0.scale;
    }

    static /* synthetic */ int access$102(SubsamplingScaleImageView r0, int r1) {
        r0.maxTouchCount = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1400(SubsamplingScaleImageView r0) {
        return r0.zoomEnabled;
    }

    static /* synthetic */ void access$1500(SubsamplingScaleImageView r2, Context r3) {
        r2.setGestureDetector((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean access$1600(SubsamplingScaleImageView r0) {
        return r0.quickScaleEnabled;
    }

    static /* synthetic */ PointF access$1700(SubsamplingScaleImageView r0) {
        return r0.vCenterStart;
    }

    static /* synthetic */ PointF access$1702(SubsamplingScaleImageView r0, PointF r1) {
        r0.vCenterStart = r1;
        return r1;
    }

    static /* synthetic */ PointF access$1802(SubsamplingScaleImageView r0, PointF r1) {
        r0.vTranslateStart = r1;
        return r1;
    }

    static /* synthetic */ float access$1902(SubsamplingScaleImageView r0, float r1) {
        r0.scaleStart = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2002(SubsamplingScaleImageView r0, boolean r1) {
        r0.isQuickScaling = r1;
        return r1;
    }

    static /* synthetic */ void access$201(SubsamplingScaleImageView r2, View.OnLongClickListener r3) {
        super.setOnLongClickListener((View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ float access$2102(SubsamplingScaleImageView r0, float r1) {
        r0.quickScaleLastDistance = r1;
        return r1;
    }

    static /* synthetic */ PointF access$2200(SubsamplingScaleImageView r0) {
        return r0.quickScaleSCenter;
    }

    static /* synthetic */ PointF access$2202(SubsamplingScaleImageView r0, PointF r1) {
        r0.quickScaleSCenter = r1;
        return r1;
    }

    static /* synthetic */ PointF access$2302(SubsamplingScaleImageView r0, PointF r1) {
        r0.quickScaleVStart = r1;
        return r1;
    }

    static /* synthetic */ PointF access$2402(SubsamplingScaleImageView r0, PointF r1) {
        r0.quickScaleVLastPoint = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2502(SubsamplingScaleImageView r0, boolean r1) {
        r0.quickScaleMoved = r1;
        return r1;
    }

    static /* synthetic */ void access$2600(SubsamplingScaleImageView r0, PointF r1, PointF r2) {
        r0.doubleTapZoom(r1, r2);
    }

    static /* synthetic */ void access$301(SubsamplingScaleImageView r2, View.OnLongClickListener r3) {
        super.setOnLongClickListener((View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void access$5100(SubsamplingScaleImageView r0, String r1, Object[] r2) {
        r0.debug(r1, r2);
    }

    static /* synthetic */ int access$5200(SubsamplingScaleImageView r2, Context r3, String r4) {
        return r2.getExifOrientation((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ Rect access$5300(SubsamplingScaleImageView r0) {
        return r0.sRegion;
    }

    static /* synthetic */ String access$5400() {
        return TAG;
    }

    static /* synthetic */ void access$5500(SubsamplingScaleImageView r2, ImageRegionDecoder r3, int r4, int r5, int r6) {
        r2.onTilesInited((ImageRegionDecoder) ZeusTransformUtils.wrapperContextForParams(r3, ImageRegionDecoder.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    static /* synthetic */ OnImageEventListener access$5600(SubsamplingScaleImageView r0) {
        return r0.onImageEventListener;
    }

    static /* synthetic */ ReadWriteLock access$5700(SubsamplingScaleImageView r0) {
        return r0.decoderLock;
    }

    static /* synthetic */ void access$5800(SubsamplingScaleImageView r0, Rect r1, Rect r2) {
        r0.fileSRect(r1, r2);
    }

    static /* synthetic */ void access$5900(SubsamplingScaleImageView r0) {
        r0.onTileLoaded();
    }

    static /* synthetic */ boolean access$600(SubsamplingScaleImageView r0) {
        return r0.panEnabled;
    }

    static /* synthetic */ void access$6000(SubsamplingScaleImageView r0, Bitmap r1) {
        r0.onPreviewLoaded(r1);
    }

    static /* synthetic */ void access$6100(SubsamplingScaleImageView r0, Bitmap r1, int r2, boolean r3) {
        r0.onImageLoaded(r1, r2, r3);
    }

    static /* synthetic */ List access$6300() {
        return VALID_EASING_STYLES;
    }

    static /* synthetic */ Anim access$6400(SubsamplingScaleImageView r0) {
        return r0.anim;
    }

    static /* synthetic */ Anim access$6402(SubsamplingScaleImageView r0, Anim r1) {
        r0.anim = r1;
        return r1;
    }

    static /* synthetic */ float access$6500(SubsamplingScaleImageView r0, float r1) {
        return r0.limitedScale(r1);
    }

    static /* synthetic */ PointF access$6600(SubsamplingScaleImageView r0, float r1, float r2, float r3, PointF r4) {
        return r0.limitedSCenter(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$6800(SubsamplingScaleImageView r0, boolean r1, ScaleAndTranslate r2) {
        r0.fitToBounds(r1, r2);
    }

    static /* synthetic */ boolean access$700(SubsamplingScaleImageView r0) {
        return r0.readySent;
    }

    static /* synthetic */ PointF access$800(SubsamplingScaleImageView r0) {
        return r0.vTranslate;
    }

    static /* synthetic */ boolean access$900(SubsamplingScaleImageView r0) {
        return r0.isZooming;
    }

    static /* synthetic */ boolean access$902(SubsamplingScaleImageView r0, boolean r1) {
        r0.isZooming = r1;
        return r1;
    }

    private int calculateInSampleSize(float r4) {
        if (this.minimumTileDpi <= 0) goto L5;
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics();
        r4 = r4 * (this.minimumTileDpi / ((r0.xdpi + r0.ydpi) / 2.0f));
    L5:
        int r1 = (int) (sWidth() * r4);
        int r5 = (int) (sHeight() * r4);
        if (r1 == 0) goto L23;
        if (r5 == 0) goto L27;
        int r2 = 1;
        if (sHeight() <= r5) goto L12;
    L15:
        int r6 = Math.round(sHeight() / r5);
        int r3 = Math.round(sWidth() / r1);
        if (r6 < r3) goto L19;
        r6 = r3;
    L19:
        int r7 = r2 * 2;
        if (r7 >= r6) goto L22;
        r2 = r7;
        goto L19
    L22:
        return r2;
    L12:
        if (sWidth() > r1) goto L15;
        r6 = 1;
        goto L19
    L27:
        return 32;
    L23:
        return 32;
    }

    private boolean checkImageLoaded() {
        boolean r0 = isBaseLayerReady();
        if (this.imageLoadedSent == true) goto L8;
        if (r0 == false) goto L8;
        preDraw();
        this.imageLoadedSent = true;
        onImageLoaded();
        OnImageEventListener r2 = this.onImageEventListener;
        if (r2 == null) goto L8;
        r2.onImageLoaded();
    L8:
        return r0;
    }

    private boolean checkReady() {
        if (getWidth() > 0) goto L5;
    L15:
        boolean r0 = false;
    L17:
        if (this.readySent == true) goto L22;
        if (r0 == false) goto L22;
        preDraw();
        this.readySent = true;
        onReady();
        OnImageEventListener r3 = this.onImageEventListener;
        if (r3 == null) goto L22;
        r3.onReady();
    L22:
        return r0;
    L5:
        if (getHeight() <= 0) goto L15;
        if (this.sWidth <= 0) goto L15;
        if (this.sHeight <= 0) goto L15;
        if (this.bitmap == null) goto L13;
    L14:
        r0 = true;
        goto L17
    L13:
        if (isBaseLayerReady() == false) goto L15;
        goto L14
    }

    private void createPaints() {
        if (this.bitmapPaint != null) goto L6;
        Paint r0 = new Paint();
        this.bitmapPaint = r0;
        r0.setAntiAlias(true);
        this.bitmapPaint.setFilterBitmap(true);
        this.bitmapPaint.setDither(true);
    L6:
        if (this.debugTextPaint == null) goto L10;
        if (this.debugLinePaint == null) goto L10;
        return;
    L10:
        if (this.debug == false) goto L14;
        Paint r1 = new Paint();
        this.debugTextPaint = r1;
        r1.setTextSize(px(12));
        this.debugTextPaint.setColor(-65281);
        this.debugTextPaint.setStyle(Paint.Style.FILL);
        Paint r2 = new Paint();
        this.debugLinePaint = r2;
        r2.setColor(-65281);
        this.debugLinePaint.setStyle(Paint.Style.STROKE);
        this.debugLinePaint.setStrokeWidth(px(1));
        return;
    }

    private void debug(String r1, Object... r2) {
        if (this.debug == false) goto L6;
        Log.d(TAG, String.format(r1, r2));
        return;
    }

    private float distance(float r1, float r2, float r3, float r4) {
        float r5 = r1 - r2;
        float r6 = r3 - r4;
        return (float) Math.sqrt((r5 * r5) + (r6 * r6));
    }

    private void doubleTapZoom(PointF r13, PointF r14) {
        if (this.panEnabled == true) goto L9;
        PointF r0 = this.sRequestedCenter;
        if (r0 == null) goto L7;
        r13.x = r0.x;
        float r1 = this.sRequestedCenter.y;
    L8:
        r13.y = r1;
        goto L9
    L7:
        r13.x = sWidth() / 2;
        r1 = sHeight() / 2;
    L9:
        float r2 = Math.min(this.maxScale, this.doubleTapZoomScale);
        float r3 = this.scale;
        if (r3 > (((double) r2) * 0.9d)) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        r2 = minScale();
    L19:
        float r8 = r2;
        int r5 = this.doubleTapZoomStyle;
        if (r5 != 3) goto L23;
        setScaleAndCenter(r8, r13);
    L32:
        invalidate();
        return;
    L23:
        if (r5 == 2) goto L30;
        if (r4 == false) goto L30;
        if (this.panEnabled == false) goto L30;
        if (r5 != 1) goto L32;
        AnimationBuilder r15 = new AnimationBuilder(this, r8, r13, r14, null).withInterruptible(false);
    L31:
        AnimationBuilder.access$1300(r15.withDuration(this.doubleTapZoomDuration), 4).start();
    L30:
        r15 = new AnimationBuilder(this, r8, r13, null).withInterruptible(false);
        goto L31
    L12:
        if (r3 == this.minScale) goto L15;
        r4 = false;
        goto L16
    }

    private float ease(int r8, long r9, float r11, float r12, long r13) {
        if (r8 == 1) goto L11;
        if (r8 != 2) goto L9;
        return easeInOutQuad(r9, r11, r12, r13);
    L9:
        throw new IllegalStateException("Unexpected easing type: " + r8);
    L11:
        return easeOutQuad(r9, r11, r12, r13);
    }

    private float easeInOutQuad(long r1, float r3, float r4, long r5) {
        float r0 = r1 / (r5 / 2.0f);
        if (r0 >= 1.0f) goto L7;
        float r6 = (r4 / 2.0f) * r0;
    L6:
        return (r6 * r0) + r3;
    L7:
        float r2 = r0 - 1.0f;
        r6 = (-r4) / 2.0f;
        r0 = (r2 * (r2 - 2.0f)) - 1.0f;
        goto L6
    }

    private float easeOutQuad(long r1, float r3, float r4, long r5) {
        float r0 = r1 / r5;
        return (((-r4) * r0) * (r0 - 2.0f)) + r3;
    }

    private void execute(AsyncTask<Void, Void, ?> r2) {
        r2.executeOnExecutor(this.executor, new Void[0]);
    }

    private void fileSRect(Rect r5, Rect r6) {
        if (getRequiredRotation() != 0) goto L6;
        r6.set(r5);
        return;
    L6:
        if (getRequiredRotation() != 90) goto L10;
        int r0 = r5.top;
        int r1 = this.sHeight - r5.right;
        int r2 = r5.bottom;
        int r4 = this.sHeight;
        int r7 = r5.left;
    L8:
        r6.set(r0, r1, r2, r4 - r7);
        return;
    L10:
        if (getRequiredRotation() != 180) goto L12;
        r0 = this.sWidth - r5.right;
        r1 = this.sHeight - r5.bottom;
        r2 = this.sWidth - r5.left;
        r4 = this.sHeight;
        r7 = r5.top;
        goto L8
    L12:
        r6.set(this.sWidth - r5.bottom, r5.left, this.sWidth - r5.top, r5.right);
    }

    private void fitToBounds(boolean r6) {
        float r1 = 0.0f;
        if (this.vTranslate != null) goto L5;
        boolean r0 = true;
        this.vTranslate = new PointF(0.0f, 0.0f);
    L7:
        if (this.satTemp != null) goto L9;
        this.satTemp = new ScaleAndTranslate(r1, new PointF(0.0f, 0.0f), null);
    L9:
        ScaleAndTranslate.access$4702(this.satTemp, this.scale);
        ScaleAndTranslate.access$4800(this.satTemp).set(this.vTranslate);
        fitToBounds(r6, this.satTemp);
        this.scale = ScaleAndTranslate.access$4700(this.satTemp);
        this.vTranslate.set(ScaleAndTranslate.access$4800(this.satTemp));
        if (r0 == true) goto L12;
        return;
    L12:
        if (this.minimumScaleType == 4) goto L16;
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L7
    }

    private void fitToBounds(boolean r12, ScaleAndTranslate r13) {
        if (this.panLimit == 2) goto L5;
    L7:
        PointF r0 = ScaleAndTranslate.access$4800(r13);
        float r3 = limitedScale(ScaleAndTranslate.access$4700(r13));
        float r4 = sWidth() * r3;
        float r5 = sHeight() * r3;
        if (this.panLimit == 3) goto L10;
    L12:
        float r6 = r0.x;
        if (r12 == false) goto L16;
        r0.x = Math.max(r6, getWidth() - r4);
        float r7 = r0.y;
        int r8 = getHeight();
    L15:
        float r9 = r8 - r5;
    L17:
        r0.y = Math.max(r7, r9);
        float r10 = 0.5f;
        if (getPaddingLeft() <= 0) goto L20;
    L23:
        float r11 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
    L25:
        if (getPaddingTop() <= 0) goto L27;
    L28:
        r10 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
    L30:
        if (this.panLimit == 3) goto L32;
    L34:
        if (r12 == false) goto L36;
        float r14 = Math.max(0.0f, (getWidth() - r4) * r11);
        float r15 = Math.max(0.0f, (getHeight() - r5) * r10);
    L38:
        r0.x = Math.min(r0.x, r14);
        r0.y = Math.min(r0.y, r15);
        ScaleAndTranslate.access$4702(r13, r3);
        return;
    L36:
        r14 = Math.max(0, getWidth());
        int r16 = getHeight();
    L37:
        r15 = Math.max(0, r16);
        goto L38
    L32:
        if (isReady() == false) goto L34;
        r14 = Math.max(0, getWidth() / 2);
        r16 = getHeight() / 2;
        goto L37
    L27:
        if (getPaddingBottom() <= 0) goto L30;
    L20:
        if (getPaddingRight() > 0) goto L23;
        r11 = 0.5f;
        goto L25
    L16:
        r0.x = Math.max(r6, -r4);
        r7 = r0.y;
        r9 = -r5;
        goto L17
    L10:
        if (isReady() == false) goto L12;
        r0.x = Math.max(r0.x, (getWidth() / 2) - r4);
        r7 = r0.y;
        r8 = getHeight() / 2;
        goto L15
    L5:
        if (isReady() == false) goto L7;
        r12 = false;
        goto L7
    }

    private int getExifOrientation(Context r10, String r11) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r11.startsWith(Params.CONTENT) == false) goto L26;
        Cursor r12 = null;
        r12 = ZeusProviderTransform.query(r9.getContentResolver(), Uri.parse(r11), new String[]{"orientation"}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 Exception -> L19
        if (r12 != null) goto L8;
    L15:
        if (r12 == null) goto L52;
    L16:
        r12.close();
        return r0;
    L52:
        return r0;
    L8:
        if (r12.moveToFirst() == false) goto L15;
        int r13 = r12.getInt(0);     // Catch: Throwable -> L17 Exception -> L19
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(r13)) == true) goto L12;
    L14:
        Log.w(TAG, "Unsupported orientation: " + r13);     // Catch: Throwable -> L17 Exception -> L19
    L12:
        if (r13 == (-1)) goto L14;
        r0 = r13;
    L19:
        Log.w(TAG, "Could not get orientation of image from media store");     // Catch: Throwable -> L17
        if (r12 != null) goto L16;
        return 0;
    L17:
        th = move-exception;
        if (r12 == null) goto L24;
        r12.close();
    L24:
        throw th;
    L26:
        if (r11.startsWith("file:///") == true) goto L28;
        return 0;
    L28:
        if (r11.startsWith("file:///android_asset/") == true) goto L56;
        int r14 = new ExifInterface(r11.substring(7)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);     // Catch: Exception -> L45
        if (r14 == 1) goto L57;
        if (r14 != 0) goto L34;
        return 0;
    L34:
        if (r14 != 6) goto L38;
        int r15 = 90;
    L59:
        return r15;
    L38:
        if (r14 != 3) goto L41;
        r15 = ORIENTATION_180;
        goto L59
    L41:
        if (r14 != 8) goto L43;
        r15 = ORIENTATION_270;
        goto L59
    L43:
        Log.w(TAG, "Unsupported EXIF orientation: " + r14);     // Catch: Exception -> L45
        return 0;
    L57:
        return 0;
    L45:
        Log.w(TAG, "Could not get EXIF orientation of image");
        return 0;
    L56:
        return 0;
    }

    private Point getMaxBitmapDimensions(Canvas r4) {
        return new Point(Math.min(r4.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(r4.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    private int getRequiredRotation() {
        int r0 = this.orientation;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return this.sOrientation;
    }

    private synchronized void initialiseBaseLayer(Point r13) {
        monitor-enter(this);
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r13.x), Integer.valueOf(r13.y)});     // Catch: Throwable -> L22
        ScaleAndTranslate r0 = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);     // Catch: Throwable -> L22
        this.satTemp = r0;     // Catch: Throwable -> L22
        fitToBounds(true, r0);     // Catch: Throwable -> L22
        int r1 = calculateInSampleSize(ScaleAndTranslate.access$4700(this.satTemp));     // Catch: Throwable -> L22
        this.fullImageSampleSize = r1;     // Catch: Throwable -> L22
        if (r1 <= 1) goto L7;
        this.fullImageSampleSize = r1 / 2;     // Catch: Throwable -> L22
    L7:
        if (this.fullImageSampleSize == 1) goto L9;
    L15:
        initialiseTileMap(r13);     // Catch: Throwable -> L22
        Iterator r14 = ((List) ZeusTransformUtils.preCheckCast(this.tileMap.get(Integer.valueOf(this.fullImageSampleSize)), List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L22
    L17:
        if (r14.hasNext() == false) goto L19;
        execute(new TileLoadTask(this, this.decoder, (Tile) ZeusTransformUtils.preCheckCast(r14.next(), Tile.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L22
        goto L17
    L19:
        refreshRequiredTiles(true);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L9:
        if (this.sRegion != null) goto L15;
        if (sWidth() >= r13.x) goto L15;
        if (sHeight() >= r13.y) goto L15;
        this.decoder.recycle();     // Catch: Throwable -> L22
        this.decoder = null;     // Catch: Throwable -> L22
        execute(new BitmapLoadTask(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.bitmapDecoderFactory, this.uri, false));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initialiseTileMap(Point r19) {
        int r4 = 0;
        int r5 = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r19.x), Integer.valueOf(r19.y)});
        this.tileMap = new LinkedHashMap();
        int r2 = this.fullImageSampleSize;
        int r3 = 1;
        int r6 = 1;
    L3:
        int r7 = sWidth() / r3;
        int r8 = sHeight() / r6;
        int r9 = r7 / r2;
        int r10 = r8 / r2;
    L5:
        if (((r9 + r3) + r5) > r19.x) goto L41;
        if (r9 <= (((double) getWidth()) * 1.25d)) goto L12;
        if (r2 < this.fullImageSampleSize) goto L41;
    L12:
        if (((r10 + r6) + r5) > r19.y) goto L40;
        if (r10 <= (((double) getHeight()) * 1.25d)) goto L18;
        if (r2 < this.fullImageSampleSize) goto L40;
    L18:
        ArrayList r11 = new ArrayList(r3 * r6);
        int r12 = r4;
    L19:
        if (r12 >= r3) goto L36;
        int r13 = r4;
    L21:
        if (r13 >= r6) goto L35;
        Tile r14 = new Tile(null);
        Tile.access$4302(r14, r2);
        if (r2 != this.fullImageSampleSize) goto L25;
        boolean r15 = r5;
    L26:
        Tile.access$402(r14, r15);
        int r16 = r12 * r7;
        int r17 = r13 * r8;
        if (r12 != (r3 - 1)) goto L29;
        int r18 = sWidth();
    L31:
        if (r13 != (r6 - 1)) goto L33;
        int r20 = sHeight();
    L34:
        Tile.access$4102(r14, new Rect(r16, r17, r18, r20));
        Tile.access$4202(r14, new Rect(0, 0, 0, 0));
        Tile.access$5002(r14, new Rect(Tile.access$4100(r14)));
        r11.add(r14);
        r13 = r13 + 1;
        r4 = 0;
        r5 = 1;
        goto L21
    L33:
        r20 = (r13 + 1) * r8;
        goto L34
    L29:
        r18 = (r12 + 1) * r7;
        goto L31
    L25:
        r15 = r4;
        goto L26
    L35:
        r12 = r12 + 1;
        r5 = 1;
        goto L19
    L36:
        int r21 = r4;
        this.tileMap.put(Integer.valueOf(r2), r11);
        if (r2 == 1) goto L38;
        r2 = r2 / 2;
        r5 = 1;
        r4 = r21;
        goto L3
    L38:
        return;
    L40:
        r6 = r6 + 1;
        r8 = sHeight() / r6;
        r10 = r8 / r2;
        r5 = r5;
        r4 = r4;
    L41:
        r3 = r3 + 1;
        r7 = sWidth() / r3;
        r9 = r7 / r2;
        r5 = r5;
        r4 = r4;
        goto L5
    }

    private boolean isBaseLayerReady() {
        boolean r1 = true;
        if (this.bitmap != null) goto L5;
    L7:
        Map<Integer, List<Tile>> r0 = this.tileMap;
        if (r0 == null) goto L23;
        Iterator<Map.Entry<Integer, List<Tile>>> r2 = r0.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() != this.fullImageSampleSize) goto L11;
        Iterator r4 = ((List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r4.hasNext() == false) goto L11;
        Tile r5 = (Tile) ZeusTransformUtils.preCheckCast(r4.next(), Tile.class, "com.obric.memorydata.plugin");
        if (Tile.access$4000(r5) == true) goto L21;
        if (Tile.access$500(r5) != null) goto L16;
    L21:
        r1 = false;
        goto L16
    L22:
        return r1;
    L23:
        return false;
    L5:
        if (this.bitmapIsPreview == true) goto L7;
        return true;
    }

    private PointF limitedSCenter(float r4, float r5, float r6, PointF r7) {
        PointF r8 = vTranslateForSCenter(r4, r5, r6);
        r7.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - r8.x) / r6, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - r8.y) / r6);
        return r7;
    }

    private float limitedScale(float r2) {
        float r3 = Math.max(minScale(), r2);
        return Math.min(this.maxScale, r3);
    }

    private float minScale() {
        int r0 = getPaddingBottom() + getPaddingTop();
        int r1 = getPaddingLeft() + getPaddingRight();
        int r2 = this.minimumScaleType;
        if (r2 == 2) goto L15;
        if (r2 == 4) goto L15;
        if (r2 != 3) goto L13;
        float r3 = this.minScale;
        if (r3 <= 0.0f) goto L13;
        return r3;
    L13:
        return Math.min((getWidth() - r1) / sWidth(), (getHeight() - r0) / sHeight());
    L15:
        return Math.max((getWidth() - r1) / sWidth(), (getHeight() - r0) / sHeight());
    }

    private synchronized void onImageLoaded(Bitmap r4, int r5, boolean r6) {
        monitor-enter(this);
        debug("onImageLoaded", new Object[0]);     // Catch: Throwable -> L30
        int r0 = this.sWidth;     // Catch: Throwable -> L30
        if (r0 > 0) goto L6;
    L12:
        Bitmap r1 = this.bitmap;     // Catch: Throwable -> L30
        if (r1 == null) goto L18;
        if (this.bitmapIsCached == true) goto L18;
        r1.recycle();     // Catch: Throwable -> L30
    L18:
        if (this.bitmap != null) goto L20;
    L24:
        this.bitmapIsPreview = false;     // Catch: Throwable -> L30
        this.bitmapIsCached = r6;     // Catch: Throwable -> L30
        this.bitmap = r4;     // Catch: Throwable -> L30
        this.sWidth = r4.getWidth();     // Catch: Throwable -> L30
        this.sHeight = r4.getHeight();     // Catch: Throwable -> L30
        this.sOrientation = r5;     // Catch: Throwable -> L30
        boolean r7 = checkReady();     // Catch: Throwable -> L30
        boolean r8 = checkImageLoaded();     // Catch: Throwable -> L30
        if (r7 == true) goto L27;
        if (r8 == true) goto L27;
    L28:
        monitor-exit(this);
        return;
    L27:
        invalidate();     // Catch: Throwable -> L30
        requestLayout();     // Catch: Throwable -> L30
        goto L28
    L20:
        if (this.bitmapIsCached == false) goto L24;
        OnImageEventListener r2 = this.onImageEventListener;     // Catch: Throwable -> L30
        if (r2 == null) goto L24;
        r2.onPreviewReleased();     // Catch: Throwable -> L30
        goto L24
    L6:
        if (this.sHeight <= 0) goto L12;
        if (r0 == r4.getWidth()) goto L10;
    L11:
        reset(false);     // Catch: Throwable -> L30
        goto L12
    L10:
        if (this.sHeight == r4.getHeight()) goto L12;
    L30:
        th = move-exception;
        throw th;
    }

    private synchronized void onPreviewLoaded(Bitmap r5) {
        monitor-enter(this);
        debug("onPreviewLoaded", new Object[0]);     // Catch: Throwable -> L19
        if (this.bitmap == null) goto L6;
    L16:
        r5.recycle();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L6:
        if (this.imageLoadedSent == true) goto L16;
        Rect r0 = this.pRegion;     // Catch: Throwable -> L19
        if (r0 == null) goto L11;
        r5 = Bitmap.createBitmap(r5, r0.left, this.pRegion.top, this.pRegion.width(), this.pRegion.height());     // Catch: Throwable -> L19
    L11:
        this.bitmap = r5;     // Catch: Throwable -> L19
        this.bitmapIsPreview = true;     // Catch: Throwable -> L19
        if (checkReady() == false) goto L14;
        invalidate();     // Catch: Throwable -> L19
        requestLayout();     // Catch: Throwable -> L19
    L14:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private synchronized void onTileLoaded() {
        monitor-enter(this);
        debug("onTileLoaded", new Object[0]);     // Catch: Throwable -> L19
        checkReady();     // Catch: Throwable -> L19
        checkImageLoaded();     // Catch: Throwable -> L19
        if (isBaseLayerReady() == false) goto L16;
        Bitmap r0 = this.bitmap;     // Catch: Throwable -> L19
        if (r0 == null) goto L16;
        if (this.bitmapIsCached == true) goto L10;
        r0.recycle();     // Catch: Throwable -> L19
    L10:
        this.bitmap = null;     // Catch: Throwable -> L19
        OnImageEventListener r1 = this.onImageEventListener;     // Catch: Throwable -> L19
        if (r1 != null) goto L13;
    L15:
        this.bitmapIsPreview = false;     // Catch: Throwable -> L19
        this.bitmapIsCached = false;     // Catch: Throwable -> L19
        goto L16
    L13:
        if (this.bitmapIsCached == false) goto L15;
        r1.onPreviewReleased();     // Catch: Throwable -> L19
    L16:
        invalidate();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private synchronized void onTilesInited(ImageRegionDecoder r6, int r7, int r8, int r9) {
        monitor-enter(this);
        ImageRegionDecoder r10 = (ImageRegionDecoder) ZeusTransformUtils.wrapperContextForParams(r6, ImageRegionDecoder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", new Object[]{Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(this.orientation)});     // Catch: Throwable -> L37
        int r0 = this.sWidth;     // Catch: Throwable -> L37
        if (r0 <= 0) goto L20;
        int r1 = this.sHeight;     // Catch: Throwable -> L37
        if (r1 <= 0) goto L20;
        if (r0 != r7) goto L9;
        if (r1 == r8) goto L20;
    L9:
        reset(false);     // Catch: Throwable -> L37
        Bitmap r2 = this.bitmap;     // Catch: Throwable -> L37
        if (r2 == null) goto L20;
        if (this.bitmapIsCached == true) goto L14;
        r2.recycle();     // Catch: Throwable -> L37
    L14:
        this.bitmap = null;     // Catch: Throwable -> L37
        OnImageEventListener r3 = this.onImageEventListener;     // Catch: Throwable -> L37
        if (r3 != null) goto L17;
    L19:
        this.bitmapIsPreview = false;     // Catch: Throwable -> L37
        this.bitmapIsCached = false;     // Catch: Throwable -> L37
        goto L20
    L17:
        if (this.bitmapIsCached == false) goto L19;
        r3.onPreviewReleased();     // Catch: Throwable -> L37
    L20:
        this.decoder = r10;     // Catch: Throwable -> L37
        this.sWidth = r7;     // Catch: Throwable -> L37
        this.sHeight = r8;     // Catch: Throwable -> L37
        this.sOrientation = r9;     // Catch: Throwable -> L37
        checkReady();     // Catch: Throwable -> L37
        if (checkImageLoaded() == true) goto L34;
        int r11 = this.maxTileWidth;     // Catch: Throwable -> L37
        if (r11 <= 0) goto L34;
        if (r11 == Integer.MAX_VALUE) goto L34;
        int r12 = this.maxTileHeight;     // Catch: Throwable -> L37
        if (r12 <= 0) goto L34;
        if (r12 == Integer.MAX_VALUE) goto L34;
        if (getWidth() <= 0) goto L34;
        if (getHeight() <= 0) goto L34;
        initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));     // Catch: Throwable -> L37
    L34:
        invalidate();     // Catch: Throwable -> L37
        requestLayout();     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    private boolean onTouchEventInternal(MotionEvent r13) {
        int r0 = r13.getPointerCount();
        int r1 = r13.getAction();
        if (r1 == 0) goto L167;
        if (r1 == 1) goto L139;
        if (r1 == 2) goto L16;
        if (r1 == 5) goto L167;
        if (r1 == 6) goto L139;
        if (r1 == 261) goto L167;
        if (r1 == 262) goto L139;
    L138:
        return false;
    L16:
        if (this.maxTouchCount > 0) goto L18;
    L134:
        boolean r14 = false;
    L135:
        if (r14 == false) goto L138;
        this.handler.removeMessages(1);
        invalidate();
        return true;
    L18:
        if (r0 < 2) goto L47;
        float r2 = distance(r13.getX(0), r13.getX(1), r13.getY(0), r13.getY(1));
        float r6 = (r13.getX(0) + r13.getX(1)) / 2.0f;
        float r7 = (r13.getY(0) + r13.getY(1)) / 2.0f;
        if (this.zoomEnabled == false) goto L134;
        if (distance(this.vCenterStart.x, r6, this.vCenterStart.y, r7) <= 5.0f) goto L24;
    L27:
        this.isZooming = true;
        this.isPanning = true;
        double r3 = this.scale;
        float r15 = Math.min(this.maxScale, (r2 / this.vDistStart) * this.scaleStart);
        this.scale = r15;
        if (r15 > minScale()) goto L31;
        this.vDistStart = r2;
        this.scaleStart = minScale();
        this.vCenterStart.set(r6, r7);
        this.vTranslateStart.set(this.vTranslate);
    L81:
        fitToBounds(true);
    L82:
        refreshRequiredTiles(this.eagerLoadingEnabled);
        r14 = true;
        goto L135
    L31:
        if (this.panEnabled == false) goto L42;
        float r16 = this.vCenterStart.x - this.vTranslateStart.x;
        float r4 = this.vCenterStart.y - this.vTranslateStart.y;
        float r8 = this.scale;
        float r9 = this.scaleStart;
        this.vTranslate.x = r6 - (r16 * (r8 / r9));
        this.vTranslate.y = r7 - (r4 * (r8 / r9));
        if ((((double) sHeight()) * r3) >= getHeight()) goto L37;
        if ((this.scale * sHeight()) < getHeight()) goto L37;
    L40:
        fitToBounds(true);
        this.vCenterStart.set(r6, r7);
        this.vTranslateStart.set(this.vTranslate);
        this.scaleStart = this.scale;
        this.vDistStart = r2;
    L37:
        if ((r3 * ((double) sWidth())) >= getWidth()) goto L81;
        if ((this.scale * sWidth()) < getWidth()) goto L81;
    L42:
        if (this.sRequestedCenter == null) goto L44;
        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
        PointF r17 = this.vTranslate;
        float r5 = getHeight() / 2;
        float r10 = this.scale;
        float r11 = this.sRequestedCenter.y;
    L45:
        r17.y = r5 - (r10 * r11);
        goto L81
    L44:
        this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        r17 = this.vTranslate;
        r5 = getHeight() / 2;
        r10 = this.scale;
        r11 = sHeight() / 2;
        goto L45
    L24:
        if (Math.abs(r2 - this.vDistStart) > 5.0f) goto L27;
        if (this.isPanning == false) goto L134;
    L47:
        if (this.isQuickScaling == false) goto L84;
        float r12 = (Math.abs(this.quickScaleVStart.y - r13.getY()) * 2.0f) + this.quickScaleThreshold;
        if (this.quickScaleLastDistance != (-1.0f)) goto L52;
        this.quickScaleLastDistance = r12;
    L52:
        if (r13.getY() <= this.quickScaleVLastPoint.y) goto L54;
        boolean r18 = true;
    L55:
        this.quickScaleVLastPoint.set(0.0f, r13.getY());
        float r19 = 1.0f;
        float r110 = Math.abs(1.0f - (r12 / this.quickScaleLastDistance)) * 0.5f;
        if (r110 <= 0.03f) goto L58;
    L59:
        this.quickScaleMoved = true;
        if (this.quickScaleLastDistance <= 0.0f) goto L64;
        if (r18 == false) goto L63;
        r19 = r110 + 1.0f;
        goto L64
    L63:
        r19 = 1.0f - r110;
    L64:
        double r20 = this.scale;
        this.scale = Math.max(minScale(), Math.min(this.maxScale, this.scale * r19));
        if (this.panEnabled == false) goto L76;
        float r111 = this.vCenterStart.x - this.vTranslateStart.x;
        float r21 = this.vCenterStart.y - this.vTranslateStart.y;
        float r22 = this.scale;
        float r23 = this.scaleStart;
        float r112 = r111 * (r22 / r23);
        float r24 = r21 * (r22 / r23);
        this.vTranslate.x = this.vCenterStart.x - r112;
        this.vTranslate.y = this.vCenterStart.y - r24;
        if ((((double) sHeight()) * r20) >= getHeight()) goto L71;
        if ((this.scale * sHeight()) < getHeight()) goto L71;
    L74:
        fitToBounds(true);
        this.vCenterStart.set(sourceToViewCoord(this.quickScaleSCenter));
        this.vTranslateStart.set(this.vTranslate);
        this.scaleStart = this.scale;
        r12 = 0.0f;
    L80:
        this.quickScaleLastDistance = r12;
    L71:
        if ((r20 * ((double) sWidth())) >= getWidth()) goto L80;
        if ((this.scale * sWidth()) < getWidth()) goto L80;
    L76:
        if (this.sRequestedCenter == null) goto L78;
        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
        PointF r113 = this.vTranslate;
        float r25 = getHeight() / 2;
        float r26 = this.scale;
        float r27 = this.sRequestedCenter.y;
    L79:
        r113.y = r25 - (r26 * r27);
        goto L80
    L78:
        this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        r113 = this.vTranslate;
        r25 = getHeight() / 2;
        r26 = this.scale;
        r27 = sHeight() / 2;
        goto L79
    L58:
        if (this.quickScaleMoved == false) goto L80;
    L54:
        r18 = false;
        goto L55
    L84:
        if (this.isZooming == true) goto L134;
        float r28 = Math.abs(r13.getX() - this.vCenterStart.x);
        float r29 = Math.abs(r13.getY() - this.vCenterStart.y);
        float r30 = this.density * 5.0f;
        if (r28 <= r30) goto L88;
    L91:
        this.vTranslate.x = this.vTranslateStart.x + (r13.getX() - this.vCenterStart.x);
        this.vTranslate.y = this.vTranslateStart.y + (r13.getY() - this.vCenterStart.y);
        float r114 = this.vTranslate.x;
        float r31 = this.vTranslate.y;
        fitToBounds(true);
        if (r114 == this.vTranslate.x) goto L94;
        boolean r115 = true;
    L96:
        if (r31 == this.vTranslate.y) goto L98;
        boolean r32 = true;
    L99:
        if (r115 == true) goto L101;
    L105:
        boolean r33 = false;
    L106:
        if (r32 == true) goto L108;
    L112:
        boolean r34 = false;
    L114:
        if (r31 == this.vTranslate.y) goto L116;
    L118:
        boolean r35 = false;
    L119:
        if (r33 == true) goto L127;
        if (r34 == true) goto L127;
        if (r115 == false) goto L126;
        if (r32 == false) goto L126;
        if (r35 == true) goto L126;
        if (this.isPanning == false) goto L127;
    L126:
        this.isPanning = true;
    L132:
        if (this.panEnabled == true) goto L82;
        this.vTranslate.x = this.vTranslateStart.x;
        this.vTranslate.y = this.vTranslateStart.y;
        requestDisallowInterceptTouchEvent(false);
    L127:
        if (r28 <= r30) goto L129;
    L130:
        this.maxTouchCount = 0;
        this.handler.removeMessages(1);
        requestDisallowInterceptTouchEvent(false);
        goto L132
    L129:
        if (r29 <= r30) goto L132;
    L116:
        if (r29 <= (3.0f * r30)) goto L118;
        r35 = true;
        goto L119
    L108:
        if (r29 <= r28) goto L112;
        if (this.isPanning == true) goto L112;
        r34 = true;
        goto L114
    L101:
        if (r28 <= r29) goto L105;
        if (this.isPanning == true) goto L105;
        r33 = true;
        goto L106
    L98:
        r32 = false;
        goto L99
    L94:
        r115 = false;
        goto L96
    L88:
        if (r29 > r30) goto L91;
        if (this.isPanning == false) goto L134;
    L139:
        this.handler.removeMessages(1);
        if (this.isQuickScaling == false) goto L145;
        this.isQuickScaling = false;
        if (this.quickScaleMoved == true) goto L145;
        doubleTapZoom(this.quickScaleSCenter, this.vCenterStart);
    L145:
        if (this.maxTouchCount <= 0) goto L164;
        boolean r36 = this.isZooming;
        if (r36 == false) goto L149;
    L150:
        if (r36 == false) goto L158;
        if (r0 != 2) goto L158;
        this.isPanning = true;
        this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
        if (r13.getActionIndex() != 1) goto L155;
        PointF r37 = this.vCenterStart;
        float r38 = r13.getX(0);
        float r116 = r13.getY(0);
    L156:
        r37.set(r38, r116);
        goto L158
    L155:
        r37 = this.vCenterStart;
        r38 = r13.getX(1);
        r116 = r13.getY(1);
    L158:
        if (r0 >= 3) goto L160;
        this.isZooming = false;
    L160:
        if (r0 >= 2) goto L162;
        this.isPanning = false;
        this.maxTouchCount = 0;
    L162:
        refreshRequiredTiles(true);
        return true;
    L149:
        if (this.isPanning == true) goto L150;
    L164:
        if (r0 != 1) goto L166;
        this.isZooming = false;
        this.isPanning = false;
        this.maxTouchCount = 0;
    L166:
        return true;
    L167:
        this.anim = null;
        requestDisallowInterceptTouchEvent(true);
        this.maxTouchCount = Math.max(this.maxTouchCount, r0);
        if (r0 < 2) goto L175;
        if (this.zoomEnabled == false) goto L172;
        float r39 = distance(r13.getX(0), r13.getX(1), r13.getY(0), r13.getY(1));
        this.scaleStart = this.scale;
        this.vDistStart = r39;
        this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
        this.vCenterStart.set((r13.getX(0) + r13.getX(1)) / 2.0f, (r13.getY(0) + r13.getY(1)) / 2.0f);
    L173:
        this.handler.removeMessages(1);
    L177:
        return true;
    L172:
        this.maxTouchCount = 0;
        goto L173
    L175:
        if (this.isQuickScaling == true) goto L177;
        this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
        this.vCenterStart.set(r13.getX(), r13.getY());
        this.handler.sendEmptyMessageDelayed(1, 600);
        goto L177
    }

    private void preDraw() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() != 0) goto L7;
        return;
    L7:
        if (this.sWidth > 0) goto L9;
        return;
    L9:
        if (this.sHeight > 0) goto L12;
        return;
    L12:
        if (this.sPendingCenter == null) goto L19;
        Float r0 = this.pendingScale;
        if (r0 == null) goto L19;
        this.scale = r0.floatValue();
        if (this.vTranslate != null) goto L18;
        this.vTranslate = new PointF();
    L18:
        this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
        this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
        this.sPendingCenter = null;
        this.pendingScale = null;
        fitToBounds(true);
        refreshRequiredTiles(true);
    L19:
        fitToBounds(false);
    }

    private int px(int r1) {
        return (int) (this.density * r1);
    }

    private void refreshRequiredTiles(boolean r10) {
        if (this.decoder != null) goto L5;
        return;
    L5:
        if (this.tileMap == null) goto L63;
        int r0 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        Iterator<Map.Entry<Integer, List<Tile>>> r1 = this.tileMap.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L64;
        Iterator r2 = ((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r2.hasNext() == false) goto L9;
        Tile r3 = (Tile) ZeusTransformUtils.preCheckCast(r2.next(), Tile.class, "com.obric.memorydata.plugin");
        if (Tile.access$4300(r3) >= r0) goto L16;
    L19:
        Tile.access$402(r3, false);
        if (Tile.access$500(r3) == null) goto L23;
        Tile.access$500(r3).recycle();
        Tile.access$502(r3, null);
    L23:
        if (Tile.access$4300(r3) == r0) goto L25;
        if (Tile.access$4300(r3) != this.fullImageSampleSize) goto L12;
        Tile.access$402(r3, true);
        goto L12
    L25:
        if (tileVisible(r3) == true) goto L26;
        if (Tile.access$4300(r3) == this.fullImageSampleSize) goto L12;
        Tile.access$402(r3, false);
        if (Tile.access$500(r3) == null) goto L12;
        Tile.access$500(r3).recycle();
        Tile.access$502(r3, null);
        goto L12
    L26:
        Tile.access$402(r3, true);
        if (Tile.access$4000(r3) == true) goto L12;
        if (Tile.access$500(r3) != null) goto L12;
        if (r10 == false) goto L12;
        execute(new TileLoadTask(this, this.decoder, r3));
        goto L12
    L16:
        if (Tile.access$4300(r3) <= r0) goto L23;
        if (Tile.access$4300(r3) == this.fullImageSampleSize) goto L23;
    L64:
        return;
    }

    private void requestDisallowInterceptTouchEvent(boolean r1) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(r1);
        return;
    }

    private void reset(boolean r7) {
        debug("reset newImage=" + r7, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (r7 == false) goto L24;
        this.uri = null;
        this.decoderLock.writeLock().lock();
        ImageRegionDecoder r8 = this.decoder;     // Catch: Throwable -> L21
        if (r8 == null) goto L8;
        r8.recycle();     // Catch: Throwable -> L21
        this.decoder = null;     // Catch: Throwable -> L21
    L8:
        this.decoderLock.writeLock().unlock();
        Bitmap r9 = this.bitmap;
        if (r9 == null) goto L14;
        if (this.bitmapIsCached == true) goto L14;
        r9.recycle();
    L14:
        if (this.bitmap != null) goto L16;
    L20:
        this.sWidth = 0;
        this.sHeight = 0;
        this.sOrientation = 0;
        this.sRegion = null;
        this.pRegion = null;
        this.readySent = false;
        this.imageLoadedSent = false;
        this.bitmap = null;
        this.bitmapIsPreview = false;
        this.bitmapIsCached = false;
        goto L24
    L16:
        if (this.bitmapIsCached == false) goto L20;
        OnImageEventListener r10 = this.onImageEventListener;
        if (r10 == null) goto L20;
        r10.onPreviewReleased();
    L21:
        th = move-exception;
        this.decoderLock.writeLock().unlock();
        throw th;
    L24:
        Map<Integer, List<Tile>> r11 = this.tileMap;
        if (r11 == null) goto L36;
        Iterator<Map.Entry<Integer, List<Tile>>> r12 = r11.entrySet().iterator();
    L28:
        if (r12.hasNext() == false) goto L35;
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r3.hasNext() == false) goto L28;
        Tile r4 = (Tile) ZeusTransformUtils.preCheckCast(r3.next(), Tile.class, "com.obric.memorydata.plugin");
        Tile.access$402(r4, false);
        if (Tile.access$500(r4) == null) goto L31;
        Tile.access$500(r4).recycle();
        Tile.access$502(r4, null);
        goto L31
    L35:
        this.tileMap = null;
    L36:
        setGestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private void restoreState(ImageViewState r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(r3.getOrientation())) == false) goto L8;
        this.orientation = r3.getOrientation();
        this.pendingScale = Float.valueOf(r3.getScale());
        this.sPendingCenter = r3.getCenter();
        invalidate();
        return;
    }

    private int sHeight() {
        int r0 = getRequiredRotation();
        if (r0 == 90) goto L10;
        if (r0 == 270) goto L10;
        return this.sHeight;
    L10:
        return this.sWidth;
    }

    private int sWidth() {
        int r0 = getRequiredRotation();
        if (r0 == 90) goto L10;
        if (r0 == 270) goto L10;
        return this.sWidth;
    L10:
        return this.sHeight;
    }

    private void sendStateChanged(float r3, PointF r4, int r5) {
        OnStateChangedListener r0 = this.onStateChangedListener;
        if (r0 == null) goto L8;
        float r1 = this.scale;
        if (r1 == r3) goto L8;
        r0.onScaleChanged(r1, r5);
    L8:
        if (this.onStateChangedListener != null) goto L10;
        return;
    L10:
        if (this.vTranslate.equals(r4) == true) goto L14;
        this.onStateChangedListener.onCenterChanged(getCenter(), r5);
        return;
    }

    private void setGestureDetector(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.detector = new GestureDetector(r4, new AnonymousClass2(this, r4));
        this.singleDetector = new GestureDetector(r4, new AnonymousClass3(this));
    }

    private void setMatrixArray(float[] r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        r1[0] = r2;
        r1[1] = r3;
        r1[2] = r4;
        r1[3] = r5;
        r1[4] = r6;
        r1[5] = r7;
        r1[6] = r8;
        r1[7] = r9;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config r0) {
        preferredBitmapConfig = r0;
    }

    private void sourceToViewRect(Rect r4, Rect r5) {
        r5.set((int) sourceToViewX(r4.left), (int) sourceToViewY(r4.top), (int) sourceToViewX(r4.right), (int) sourceToViewY(r4.bottom));
    }

    private float sourceToViewX(float r2) {
        PointF r0 = this.vTranslate;
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return (r2 * this.scale) + r0.x;
    }

    private float sourceToViewY(float r2) {
        PointF r0 = this.vTranslate;
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return (r2 * this.scale) + r0.y;
    }

    private boolean tileVisible(Tile r5) {
        float r1 = viewToSourceX(0.0f);
        float r2 = viewToSourceX(getWidth());
        float r0 = viewToSourceY(0.0f);
        float r4 = viewToSourceY(getHeight());
        if (r1 <= Tile.access$4100(r5).right) goto L5;
    L11:
        return false;
    L5:
        if (Tile.access$4100(r5).left > r2) goto L11;
        if (r0 > Tile.access$4100(r5).bottom) goto L11;
        if (Tile.access$4100(r5).top > r4) goto L11;
        return true;
    }

    private PointF vTranslateForSCenter(float r7, float r8, float r9) {
        int r0 = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int r1 = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp != null) goto L5;
        this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
    L5:
        ScaleAndTranslate.access$4702(this.satTemp, r9);
        ScaleAndTranslate.access$4800(this.satTemp).set(r0 - (r7 * r9), r1 - (r8 * r9));
        fitToBounds(true, this.satTemp);
        return ScaleAndTranslate.access$4800(this.satTemp);
    }

    private float viewToSourceX(float r2) {
        PointF r0 = this.vTranslate;
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return (r2 - r0.x) / this.scale;
    }

    private float viewToSourceY(float r2) {
        PointF r0 = this.vTranslate;
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return (r2 - r0.y) / this.scale;
    }

    public AnimationBuilder animateCenter(PointF r3) {
        AnonymousClass1 r1 = null;
        if (isReady() == true) goto L6;
        return null;
    L6:
        return new AnimationBuilder(this, r3, r1);
    }

    public AnimationBuilder animateScale(float r3) {
        AnonymousClass1 r1 = null;
        if (isReady() == true) goto L6;
        return null;
    L6:
        return new AnimationBuilder(this, r3, r1);
    }

    public AnimationBuilder animateScaleAndCenter(float r3, PointF r4) {
        AnonymousClass1 r1 = null;
        if (isReady() == true) goto L6;
        return null;
    L6:
        return new AnimationBuilder(this, r3, r4, r1);
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF r7) {
        if (isReady() == true) goto L5;
        return;
    L5:
        float r0 = this.scale * sWidth();
        float r1 = this.scale * sHeight();
        int r2 = this.panLimit;
        if (r2 != 3) goto L9;
        r7.top = Math.max(0.0f, -(this.vTranslate.y - (getHeight() / 2)));
        r7.left = Math.max(0.0f, -(this.vTranslate.x - (getWidth() / 2)));
        r7.bottom = Math.max(0.0f, this.vTranslate.y - ((getHeight() / 2) - r1));
        float r6 = Math.max(0.0f, this.vTranslate.x - ((getWidth() / 2) - r0));
    L8:
        r7.right = r6;
        return;
    L9:
        if (r2 != 2) goto L11;
        r7.top = Math.max(0.0f, -(this.vTranslate.y - getHeight()));
        r7.left = Math.max(0.0f, -(this.vTranslate.x - getWidth()));
        r7.bottom = Math.max(0.0f, this.vTranslate.y + r1);
        r6 = Math.max(0.0f, this.vTranslate.x + r0);
        goto L8
    L11:
        r7.top = Math.max(0.0f, -this.vTranslate.y);
        r7.left = Math.max(0.0f, -this.vTranslate.x);
        r7.bottom = Math.max(0.0f, (r1 + this.vTranslate.y) - getHeight());
        r6 = Math.max(0.0f, (r0 + this.vTranslate.x) - getWidth());
        goto L8
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        if (this.vTranslate != null) goto L5;
        return null;
    L5:
        if (this.sWidth > 0) goto L7;
        return null;
    L7:
        if (this.sHeight > 0) goto L9;
        return null;
    L9:
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        if (this.uri == null) goto L5;
    L8:
        return true;
    L5:
        if (this.bitmap != null) goto L8;
        return false;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    @Override // android.view.View
    public void onDraw(Canvas r32) {
        super.onDraw(r32);
        createPaints();
        if (this.sWidth != 0) goto L5;
        return;
    L5:
        if (this.sHeight != 0) goto L7;
        return;
    L7:
        if (getWidth() != 0) goto L9;
        return;
    L9:
        if (getHeight() != 0) goto L12;
        return;
    L12:
        if (this.tileMap != null) goto L17;
        if (this.decoder == null) goto L17;
        initialiseBaseLayer(getMaxBitmapDimensions(r32));
    L17:
        if (checkReady() == true) goto L19;
        return;
    L19:
        preDraw();
        Anim r0 = this.anim;
        if (r0 != null) goto L22;
    L47:
        int r10 = 35;
        int r8 = 90;
        if (this.tileMap != null) goto L50;
    L116:
        int r3 = 35;
        Bitmap r1 = this.bitmap;
        if (r1 == null) goto L150;
        float r2 = this.scale;
        if (this.bitmapIsPreview == false) goto L121;
        r2 = r2 * (this.sWidth / r1.getWidth());
        float r4 = this.scale * (this.sHeight / this.bitmap.getHeight());
    L123:
        if (this.matrix != null) goto L125;
        this.matrix = new Matrix();
    L125:
        this.matrix.reset();
        this.matrix.postScale(r2, r4);
        this.matrix.postRotate(getRequiredRotation());
        this.matrix.postTranslate(this.vTranslate.x, this.vTranslate.y);
        if (getRequiredRotation() != 180) goto L129;
        Matrix r5 = this.matrix;
        float r6 = this.scale;
        r5.postTranslate(this.sWidth * r6, r6 * this.sHeight);
    L135:
        if (this.tileBgPaint != null) goto L137;
    L148:
        r32.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
        goto L150
    L137:
        if (this.sRect != null) goto L139;
        this.sRect = new RectF();
    L139:
        RectF r7 = this.sRect;
        if (this.bitmapIsPreview == false) goto L142;
        int r9 = this.bitmap.getWidth();
    L143:
        float r11 = r9;
        if (this.bitmapIsPreview == false) goto L146;
        int r12 = this.bitmap.getHeight();
    L147:
        r7.set(0.0f, 0.0f, r11, r12);
        this.matrix.mapRect(this.sRect);
        r32.drawRect(this.sRect, this.tileBgPaint);
        goto L148
    L146:
        r12 = this.sHeight;
        goto L147
    L142:
        r9 = this.sWidth;
        goto L143
    L129:
        if (getRequiredRotation() != 90) goto L132;
        this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
        goto L135
    L132:
        if (getRequiredRotation() != 270) goto L135;
        this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
        goto L135
    L121:
        r4 = r2;
    L150:
        if (this.debug == false) goto L189;
        r32.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.scale)}) + " (" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(minScale())}) + " - " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.maxScale)}) + ")", px(5), px(15), this.debugTextPaint);
        r32.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.vTranslate.x)}) + ParameterizedMessage.ERROR_MSG_SEPARATOR + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.vTranslate.y)}), px(5), px(30), this.debugTextPaint);
        PointF r13 = getCenter();
        r32.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(r13.x)}) + ParameterizedMessage.ERROR_MSG_SEPARATOR + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(r13.y)}), px(5), px(45), this.debugTextPaint);
        Anim r14 = this.anim;
        if (r14 == null) goto L155;
        PointF r15 = sourceToViewCoord(Anim.access$4400(r14));
        PointF r16 = sourceToViewCoord(Anim.access$4500(this.anim));
        PointF r17 = sourceToViewCoord(Anim.access$3800(this.anim));
        r32.drawCircle(r15.x, r15.y, px(10), this.debugLinePaint);
        this.debugLinePaint.setColor(-65536);
        r32.drawCircle(r16.x, r16.y, px(20), this.debugLinePaint);
        this.debugLinePaint.setColor(-16776961);
        r32.drawCircle(r17.x, r17.y, px(25), this.debugLinePaint);
        this.debugLinePaint.setColor(-16711681);
        r32.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
    L155:
        if (this.vCenterStart == null) goto L158;
        this.debugLinePaint.setColor(-65536);
        r32.drawCircle(this.vCenterStart.x, this.vCenterStart.y, px(20), this.debugLinePaint);
    L158:
        if (this.quickScaleSCenter == null) goto L161;
        this.debugLinePaint.setColor(-16776961);
        r32.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(r3), this.debugLinePaint);
    L161:
        if (this.quickScaleVStart != null) goto L163;
    L165:
        this.debugLinePaint.setColor(-65281);
        return;
    L163:
        if (this.isQuickScaling == false) goto L165;
        this.debugLinePaint.setColor(-16711681);
        r32.drawCircle(this.quickScaleVStart.x, this.quickScaleVStart.y, px(30), this.debugLinePaint);
        goto L165
    L189:
        return;
    L50:
        if (isBaseLayerReady() == false) goto L116;
        int r18 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        Iterator<Map.Entry<Integer, List<Tile>>> r19 = this.tileMap.entrySet().iterator();
        boolean r110 = false;
    L52:
        String r20 = "com.obric.memorydata.plugin";
        if (r19.hasNext() == false) goto L66;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r21.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() != r18) goto L52;
        Iterator r22 = ((List) ZeusTransformUtils.preCheckCast(r21.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();
    L58:
        if (r22.hasNext() == false) goto L52;
        Tile r23 = (Tile) ZeusTransformUtils.preCheckCast(r22.next(), Tile.class, "com.obric.memorydata.plugin");
        if (Tile.access$400(r23) == false) goto L58;
        if (Tile.access$4000(r23) == true) goto L65;
        if (Tile.access$500(r23) != null) goto L58;
    L65:
        r110 = true;
        goto L58
    L66:
        Iterator<Map.Entry<Integer, List<Tile>>> r111 = this.tileMap.entrySet().iterator();
    L68:
        if (r111.hasNext() == false) goto L115;
        Map.Entry r24 = (Map.Entry) ZeusTransformUtils.preCheckCast(r111.next(), Map.Entry.class, r20);
        if (((Integer) ZeusTransformUtils.preCheckCast(r24.getKey(), Integer.class, r20)).intValue() == r18) goto L74;
        if (r110 == true) goto L74;
    L114:
        r10 = r10;
        r8 = r8;
        r20 = r20;
    L74:
        Iterator r112 = ((List) ZeusTransformUtils.preCheckCast(r24.getValue(), List.class, r20)).iterator();
    L76:
        if (r112.hasNext() == false) goto L114;
        Tile r113 = (Tile) ZeusTransformUtils.preCheckCast(r112.next(), Tile.class, r20);
        sourceToViewRect(Tile.access$4100(r113), Tile.access$4200(r113));
        if (Tile.access$4000(r113) == false) goto L80;
    L102:
        int r114 = r8;
        String r25 = r20;
        if (Tile.access$4000(r113) == true) goto L105;
    L107:
        int r26 = 35;
    L109:
        if (Tile.access$400(r113) == false) goto L113;
        if (this.debug == false) goto L113;
        r32.drawText("ISS " + Tile.access$4300(r113) + " RECT " + Tile.access$4100(r113).top + "," + Tile.access$4100(r113).left + "," + Tile.access$4100(r113).bottom + "," + Tile.access$4100(r113).right, Tile.access$4200(r113).left + px(5), Tile.access$4200(r113).top + px(15), this.debugTextPaint);
    L113:
        r10 = r26;
        r8 = r114;
        r20 = r25;
        goto L76
    L105:
        if (this.debug == false) goto L107;
        r26 = 35;
        r32.drawText("LOADING", Tile.access$4200(r113).left + px(5), Tile.access$4200(r113).top + px(35), this.debugTextPaint);
        goto L109
    L80:
        if (Tile.access$500(r113) == null) goto L102;
        if (this.tileBgPaint == null) goto L85;
        r32.drawRect(Tile.access$4200(r113), this.tileBgPaint);
    L85:
        if (this.matrix != null) goto L87;
        this.matrix = new Matrix();
    L87:
        this.matrix.reset();
        r114 = r8;
        r25 = r20;
        setMatrixArray(this.srcArray, 0.0f, 0.0f, Tile.access$500(r113).getWidth(), 0.0f, Tile.access$500(r113).getWidth(), Tile.access$500(r113).getHeight(), 0.0f, Tile.access$500(r113).getHeight());
        if (getRequiredRotation() != 0) goto L91;
        setMatrixArray(this.dstArray, Tile.access$4200(r113).left, Tile.access$4200(r113).top, Tile.access$4200(r113).right, Tile.access$4200(r113).top, Tile.access$4200(r113).right, Tile.access$4200(r113).bottom, Tile.access$4200(r113).left, Tile.access$4200(r113).bottom);
    L99:
        this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
        r32.drawBitmap(Tile.access$500(r113), this.matrix, this.bitmapPaint);
        if (this.debug == false) goto L107;
        r32.drawRect(Tile.access$4200(r113), this.debugLinePaint);
        goto L107
    L91:
        if (getRequiredRotation() != r114) goto L94;
        setMatrixArray(this.dstArray, Tile.access$4200(r113).right, Tile.access$4200(r113).top, Tile.access$4200(r113).right, Tile.access$4200(r113).bottom, Tile.access$4200(r113).left, Tile.access$4200(r113).bottom, Tile.access$4200(r113).left, Tile.access$4200(r113).top);
        goto L99
    L94:
        if (getRequiredRotation() != 180) goto L97;
        setMatrixArray(this.dstArray, Tile.access$4200(r113).right, Tile.access$4200(r113).bottom, Tile.access$4200(r113).left, Tile.access$4200(r113).bottom, Tile.access$4200(r113).left, Tile.access$4200(r113).top, Tile.access$4200(r113).right, Tile.access$4200(r113).top);
        goto L99
    L97:
        if (getRequiredRotation() != 270) goto L99;
        setMatrixArray(this.dstArray, Tile.access$4200(r113).left, Tile.access$4200(r113).bottom, Tile.access$4200(r113).left, Tile.access$4200(r113).top, Tile.access$4200(r113).right, Tile.access$4200(r113).top, Tile.access$4200(r113).right, Tile.access$4200(r113).bottom);
        goto L99
    L115:
        r3 = r10;
        goto L150
    L22:
        if (Anim.access$3100(r0) == null) goto L47;
        float r27 = this.scale;
        if (this.vTranslateBefore != null) goto L26;
        this.vTranslateBefore = new PointF(0.0f, 0.0f);
    L26:
        this.vTranslateBefore.set(this.vTranslate);
        long r28 = System.currentTimeMillis() - Anim.access$3200(this.anim);
        if (r28 <= Anim.access$3300(this.anim)) goto L29;
        boolean r115 = true;
    L30:
        long r116 = Math.min(r28, Anim.access$3300(this.anim));
        this.scale = ease(Anim.access$3400(this.anim), r116, Anim.access$3500(this.anim), Anim.access$3600(this.anim) - Anim.access$3500(this.anim), Anim.access$3300(this.anim));
        float r117 = ease(Anim.access$3400(this.anim), r116, Anim.access$3100(this.anim).x, Anim.access$3700(this.anim).x - Anim.access$3100(this.anim).x, Anim.access$3300(this.anim));
        float r29 = ease(Anim.access$3400(this.anim), r116, Anim.access$3100(this.anim).y, Anim.access$3700(this.anim).y - Anim.access$3100(this.anim).y, Anim.access$3300(this.anim));
        this.vTranslate.x -= sourceToViewX(Anim.access$3800(this.anim).x) - r117;
        this.vTranslate.y -= sourceToViewY(Anim.access$3800(this.anim).y) - r29;
        if (r115 == false) goto L33;
    L36:
        boolean r30 = true;
    L37:
        fitToBounds(r30);
        sendStateChanged(r27, this.vTranslateBefore, Anim.access$3900(this.anim));
        refreshRequiredTiles(r115);
        if (r115 == true) goto L40;
    L46:
        invalidate();
        goto L47
    L40:
        if (Anim.access$2800(this.anim) != null) goto L167;
    L45:
        this.anim = null;
        goto L46
    L167:
        Anim.access$2800(this.anim).onComplete();     // Catch: Exception -> L43
    L43:
        e = move-exception;
        Log.w(TAG, "Error thrown by animation listener", e);
        goto L45
    L33:
        if (Anim.access$3500(this.anim) == Anim.access$3600(this.anim)) goto L36;
        r30 = false;
        goto L37
    L29:
        r115 = false;
        goto L30
    }

    public void onImageLoaded() {
    }

    @Override // android.view.View
    public void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getMode(r6);
        int r1 = View.MeasureSpec.getMode(r7);
        int r8 = View.MeasureSpec.getSize(r6);
        int r9 = View.MeasureSpec.getSize(r7);
        boolean r2 = true;
        if (r0 == 1073741824) goto L5;
        boolean r3 = true;
    L6:
        if (r1 != 1073741824) goto L10;
        r2 = false;
    L10:
        if (this.sWidth > 0) goto L12;
    L20:
        setMeasuredDimension(Math.max(r8, getSuggestedMinimumWidth()), Math.max(r9, getSuggestedMinimumHeight()));
        return;
    L12:
        if (this.sHeight <= 0) goto L20;
        if (r3 == false) goto L16;
        if (r2 == false) goto L16;
        r8 = sWidth();
        r9 = sHeight();
    L16:
        if (r2 == false) goto L18;
        r9 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) r8));
        goto L20
    L18:
        if (r3 == false) goto L20;
        r8 = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) r9));
        goto L20
    L5:
        r3 = false;
        goto L6
    }

    public void onReady() {
    }

    @Override // android.view.View
    public void onSizeChanged(int r3, int r4, int r5, int r6) {
        debug("onSizeChanged %dx%d -> %dx%d", new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r3), Integer.valueOf(r4)});
        PointF r7 = getCenter();
        if (this.readySent == false) goto L7;
        if (r7 == null) goto L8;
        this.anim = null;
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = r7;
        return;
    L8:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        Anim r0 = this.anim;
        if (r0 != null) goto L5;
    L8:
        Anim r1 = this.anim;
        if (r1 != null) goto L11;
    L16:
        this.anim = null;
        if (this.vTranslate != null) goto L23;
        GestureDetector r6 = this.singleDetector;
        if (r6 == null) goto L21;
        r6.onTouchEvent(r7);
    L21:
        return true;
    L23:
        if (this.isQuickScaling == true) goto L31;
        GestureDetector r2 = this.detector;
        if (r2 != null) goto L27;
    L28:
        this.isZooming = false;
        this.isPanning = false;
        this.maxTouchCount = 0;
        return true;
    L27:
        if (r2.onTouchEvent(r7) == true) goto L28;
    L31:
        if (this.vTranslateStart != null) goto L34;
        this.vTranslateStart = new PointF(0.0f, 0.0f);
    L34:
        if (this.vTranslateBefore != null) goto L37;
        this.vTranslateBefore = new PointF(0.0f, 0.0f);
    L37:
        if (this.vCenterStart != null) goto L39;
        this.vCenterStart = new PointF(0.0f, 0.0f);
    L39:
        float r3 = this.scale;
        this.vTranslateBefore.set(this.vTranslate);
        boolean r4 = onTouchEventInternal(r7);
        sendStateChanged(r3, this.vTranslateBefore, 2);
        if (r4 == false) goto L42;
        return true;
    L42:
        if (super.onTouchEvent(r7) == false) goto L45;
        return true;
    L45:
        return false;
    L11:
        if (Anim.access$2800(r1) == null) goto L16;
        Anim.access$2800(this.anim).onInterruptedByUser();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.w(TAG, "Error thrown by animation listener", e);
        goto L16
    L5:
        if (Anim.access$2700(r0) == true) goto L8;
        requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady() == false) goto L5;
        this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
    L6:
        invalidate();
        return;
    L5:
        this.sPendingCenter = new PointF(0.0f, 0.0f);
        goto L6
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> r2) {
        if (r2 == null) goto L6;
        this.bitmapDecoderFactory = new CompatDecoderFactory(r2);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> r3) {
        DecoderFactory<? extends ImageDecoder> r4 = (DecoderFactory) ZeusTransformUtils.wrapperContextForParams(r3, DecoderFactory.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.bitmapDecoderFactory = r4;
        return;
    L7:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean r1) {
        this.debug = r1;
    }

    public final void setDoubleTapZoomDpi(int r3) {
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics();
        setDoubleTapZoomScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setDoubleTapZoomDuration(int r2) {
        this.doubleTapZoomDuration = Math.max(0, r2);
    }

    public final void setDoubleTapZoomScale(float r1) {
        this.doubleTapZoomScale = r1;
    }

    public final void setDoubleTapZoomStyle(int r3) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(r3)) == false) goto L7;
        this.doubleTapZoomStyle = r3;
        return;
    L7:
        throw new IllegalArgumentException("Invalid zoom style: " + r3);
    }

    public void setEagerLoadingEnabled(boolean r1) {
        this.eagerLoadingEnabled = r1;
    }

    public void setExecutor(Executor r3) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Executor must not be null");
        this.executor = r4;
    }

    public final void setImage(ImageSource r2) {
        setImage(r2, null, null);
    }

    public final void setImage(ImageSource r2, ImageSource r3) {
        setImage(r2, r3, null);
    }

    public final void setImage(ImageSource r10, ImageSource r11, ImageViewState r12) {
        Objects.requireNonNull(r10, "imageSource must not be null");
        reset(true);
        if (r12 == null) goto L6;
        restoreState(r12);
    L6:
        if (r11 == null) goto L27;
        if (r10.getBitmap() != null) goto L25;
        if (r10.getSWidth() <= 0) goto L23;
        if (r10.getSHeight() <= 0) goto L23;
        this.sWidth = r10.getSWidth();
        this.sHeight = r10.getSHeight();
        this.pRegion = r11.getSRegion();
        if (r11.getBitmap() == null) goto L16;
        this.bitmapIsCached = r11.isCached();
        onPreviewLoaded(r11.getBitmap());
        goto L27
    L16:
        Uri r2 = r11.getUri();
        if (r2 == null) goto L19;
    L21:
        execute(new BitmapLoadTask(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.bitmapDecoderFactory, r2, true));
        goto L27
    L19:
        if (r11.getResource() == null) goto L21;
        r2 = Uri.parse("android.resource://" + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName() + "/" + r11.getResource());
    L23:
        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
    L25:
        throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
    L27:
        if (r10.getBitmap() == null) goto L32;
        if (r10.getSRegion() == null) goto L32;
        onImageLoaded(Bitmap.createBitmap(r10.getBitmap(), r10.getSRegion().left, r10.getSRegion().top, r10.getSRegion().width(), r10.getSRegion().height()), 0, false);
        return;
    L32:
        if (r10.getBitmap() == null) goto L34;
        onImageLoaded(r10.getBitmap(), 0, r10.isCached());
        return;
    L34:
        this.sRegion = r10.getSRegion();
        Uri r13 = r10.getUri();
        this.uri = r13;
        if (r13 != null) goto L40;
        if (r10.getResource() == null) goto L40;
        this.uri = Uri.parse("android.resource://" + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName() + "/" + r10.getResource());
    L40:
        if (r10.getTile() == false) goto L42;
    L45:
        AsyncTask<Void, Void, ?> r14 = new TilesInitTask(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.regionDecoderFactory, this.uri);
    L46:
        execute(r14);
        return;
    L42:
        if (this.sRegion != null) goto L45;
        r14 = new BitmapLoadTask(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.bitmapDecoderFactory, this.uri, false);
        goto L46
    }

    public final void setImage(ImageSource r2, ImageViewState r3) {
        setImage(r2, null, r3);
    }

    public final void setMaxScale(float r1) {
        this.maxScale = r1;
    }

    public void setMaxTileSize(int r1) {
        this.maxTileWidth = r1;
        this.maxTileHeight = r1;
    }

    public void setMaxTileSize(int r1, int r2) {
        this.maxTileWidth = r1;
        this.maxTileHeight = r2;
    }

    public final void setMaximumDpi(int r3) {
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics();
        setMinScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setMinScale(float r1) {
        this.minScale = r1;
    }

    public final void setMinimumDpi(int r3) {
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics();
        setMaxScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setMinimumScaleType(int r3) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(r3)) == false) goto L9;
        this.minimumScaleType = r3;
        if (isReady() == false) goto L10;
        fitToBounds(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid scale type: " + r3);
    }

    public void setMinimumTileDpi(int r3) {
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((r0.xdpi + r0.ydpi) / 2.0f, r3);
        if (isReady() == false) goto L6;
        reset(false);
        invalidate();
        return;
    }

    public void setOnImageEventListener(OnImageEventListener r3) {
        this.onImageEventListener = (OnImageEventListener) ZeusTransformUtils.wrapperContextForParams(r3, OnImageEventListener.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r3) {
        this.onLongClickListener = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
    }

    public void setOnStateChangedListener(OnStateChangedListener r3) {
        this.onStateChangedListener = (OnStateChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnStateChangedListener.class, "com.obric.memorydata.plugin");
    }

    public final void setOrientation(int r3) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(r3)) == false) goto L7;
        this.orientation = r3;
        reset(false);
        invalidate();
        requestLayout();
        return;
    L7:
        throw new IllegalArgumentException("Invalid orientation: " + r3);
    }

    public final void setPanEnabled(boolean r4) {
        this.panEnabled = r4;
        if (r4 == true) goto L10;
        PointF r5 = this.vTranslate;
        if (r5 == null) goto L11;
        r5.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        if (isReady() == false) goto L12;
        refreshRequiredTiles(true);
        invalidate();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setPanLimit(int r3) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(r3)) == false) goto L9;
        this.panLimit = r3;
        if (isReady() == false) goto L10;
        fitToBounds(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid pan limit: " + r3);
    }

    public final void setQuickScaleEnabled(boolean r1) {
        this.quickScaleEnabled = r1;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> r2) {
        if (r2 == null) goto L6;
        this.regionDecoderFactory = new CompatDecoderFactory(r2);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> r3) {
        DecoderFactory<? extends ImageRegionDecoder> r4 = (DecoderFactory) ZeusTransformUtils.wrapperContextForParams(r3, DecoderFactory.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.regionDecoderFactory = r4;
        return;
    L7:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float r2, PointF r3) {
        this.anim = null;
        this.pendingScale = Float.valueOf(r2);
        this.sPendingCenter = r3;
        this.sRequestedCenter = r3;
        invalidate();
    }

    public final void setTileBackgroundColor(int r3) {
        if (Color.alpha(r3) != 0) goto L5;
        this.tileBgPaint = null;
    L6:
        invalidate();
        return;
    L5:
        Paint r0 = new Paint();
        this.tileBgPaint = r0;
        r0.setStyle(Paint.Style.FILL);
        this.tileBgPaint.setColor(r3);
        goto L6
    }

    public final void setZoomEnabled(boolean r1) {
        this.zoomEnabled = r1;
    }

    public final PointF sourceToViewCoord(float r2, float r3) {
        return sourceToViewCoord(r2, r3, new PointF());
    }

    public final PointF sourceToViewCoord(float r2, float r3, PointF r4) {
        if (this.vTranslate != null) goto L6;
        return null;
    L6:
        r4.set(sourceToViewX(r2), sourceToViewY(r3));
        return r4;
    }

    public final PointF sourceToViewCoord(PointF r3) {
        return sourceToViewCoord(r3.x, r3.y, new PointF());
    }

    public final PointF sourceToViewCoord(PointF r2, PointF r3) {
        return sourceToViewCoord(r2.x, r2.y, r3);
    }

    public void viewToFileRect(Rect r5, Rect r6) {
        if (this.vTranslate != null) goto L5;
        return;
    L5:
        if (this.readySent == false) goto L13;
        r6.set((int) viewToSourceX(r5.left), (int) viewToSourceY(r5.top), (int) viewToSourceX(r5.right), (int) viewToSourceY(r5.bottom));
        fileSRect(r6, r6);
        r6.set(Math.max(0, r6.left), Math.max(0, r6.top), Math.min(this.sWidth, r6.right), Math.min(this.sHeight, r6.bottom));
        Rect r7 = this.sRegion;
        if (r7 == null) goto L12;
        r6.offset(r7.left, this.sRegion.top);
        return;
    L12:
        return;
    }

    public final PointF viewToSourceCoord(float r2, float r3) {
        return viewToSourceCoord(r2, r3, new PointF());
    }

    public final PointF viewToSourceCoord(float r2, float r3, PointF r4) {
        if (this.vTranslate != null) goto L6;
        return null;
    L6:
        r4.set(viewToSourceX(r2), viewToSourceY(r3));
        return r4;
    }

    public final PointF viewToSourceCoord(PointF r3) {
        return viewToSourceCoord(r3.x, r3.y, new PointF());
    }

    public final PointF viewToSourceCoord(PointF r2, PointF r3) {
        return viewToSourceCoord(r2.x, r2.y, r3);
    }

    public void visibleFileRect(Rect r4) {
        if (this.vTranslate != null) goto L5;
        return;
    L5:
        if (this.readySent == false) goto L10;
        r4.set(0, 0, getWidth(), getHeight());
        viewToFileRect(r4, r4);
        return;
    }
}
