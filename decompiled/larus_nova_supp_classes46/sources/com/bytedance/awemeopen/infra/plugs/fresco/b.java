package com.bytedance.awemeopen.infra.plugs.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final Context a;
    public c b;
    public DraweeHolder<DraweeHierarchy> c;
    public Postprocessor d;
    public final List<Uri> e;
    public Uri f;
    public final int g;
    public Drawable h;
    public Drawable i;
    public Bitmap.Config j;
    public ScalingUtils.ScaleType k;
    public ScalingUtils.ScaleType l;
    public ScalingUtils.ScaleType m;
    public final ScalingUtils.ScaleType n;
    public ScalingUtils.ScaleType o;
    public RoundingParams p;
    public boolean q;
    public BaseControllerListener<ImageInfo> r;
    public l64.c s;
    public final List<ImageRequestBuilder> t;

    public class a implements ImageOriginListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onImageLoaded(String r1, int r2, boolean r3) {
            this.a.s.a(r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.plugs.fresco.b$b, reason: collision with other inner class name */
    public static /* synthetic */ class C0193b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            a = r0;
            r0[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            a[ImageView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            a[ImageView.ScaleType.FIT_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public class c implements View.OnAttachStateChangeListener, View.OnTouchListener, d {
        public final /* synthetic */ b a;

        @Override // com.bytedance.awemeopen.infra.plugs.fresco.b.d
        public final void a() {
        }

        public c(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
            DraweeHolder<DraweeHierarchy> r2 = this.a.c;
            if (r2 == null) goto L6;
            r2.onAttach();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            DraweeHolder<DraweeHierarchy> r2 = this.a.c;
            if (r2 == null) goto L6;
            r2.onDetach();
            return;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            DraweeHolder<DraweeHierarchy> r3 = this.a.c;
            if (r3 != null) goto L5;
            return false;
        L5:
            if (r3.onTouchEvent(r2) == false) goto L10;
            return true;
        L10:
            return false;
        }
    }

    public interface d {
        void a();
    }

    public b(Context r2) {
        this.e = new ArrayList();
        this.t = new ArrayList();
        this.a = r2.getApplicationContext();
        this.b = null;
        this.g = 300;
        this.h = null;
        ScalingUtils.ScaleType r0 = ScalingUtils.ScaleType.FIT_CENTER;
        this.k = r0;
        this.l = r0;
        this.i = null;
        this.m = r0;
        this.n = r0;
        this.o = r0;
        this.p = null;
        this.q = false;
        this.d = null;
        this.c = null;
        this.r = null;
    }

    public final void a(ImageView r7) {
        GenericDraweeHierarchy r8 = new GenericDraweeHierarchyBuilder(r7.getResources()).setPlaceholderImage(this.h).setPlaceholderImageScaleType(this.k).setFailureImage(this.i).setFailureImageScaleType(this.m).setProgressBarImage(null).setProgressBarImageScaleType(this.n).setRetryImage(null).setRetryImageScaleType(this.l).setFadeDuration(this.g).setActualImageFocusPoint(null).setActualImageColorFilter(null).setActualImageScaleType(this.o).setBackground(null).setOverlays(null).setPressedStateOverlay(null).setRoundingParams(this.p).build();
        this.c.setHierarchy(r8);
        ImageDecodeOptionsBuilder r9 = new ImageDecodeOptionsBuilder();
        Bitmap.Config r1 = this.j;
        if (r1 == null) goto L5;
        r9.setBitmapConfig(r1);
    L5:
        r9.setForceStaticImage(false);
        ImageDecodeOptions r2 = new ImageDecodeOptions(r9);
        ArrayList r10 = new ArrayList();
        int r3 = 0;
    L7:
        if (r3 >= ((ArrayList) this.e).size()) goto L9;
        r10.add(ImageRequestBuilder.newBuilderWithSource((Uri) ListProtector.get(this.e, r3)).setImageDecodeOptions(r2).setAutoRotateEnabled(false).setLocalThumbnailPreviewsEnabled(false).setPostprocessor(this.d).setProgressiveRenderingEnabled(false).setResizeOptions(null).build());
        r3 = r3 + 1;
        goto L7
    L9:
        PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(this.q).setControllerListener(this.r).setOldController(this.c.getController()).setRetainImageOnFailure(false).setTapToRetryEnabled(false);
        if (this.s == null) goto L13;
        r0.setImageOriginListener(new a(this));
    L13:
        if (r10.size() <= 0) goto L15;
        r0.setFirstAvailableImageRequests(r10.toArray(new ImageRequest[r10.size()]));
    L15:
        Uri r11 = this.f;
        if (r11 == null) goto L18;
        r0.setLowResImageRequest(ImageRequest.fromUri(r11));
    L18:
        AbstractDraweeController r12 = r0.build();
        this.c.setController(r12);
    }

    public final void c(List r3) {
        ((ArrayList) this.e).addAll(r3);
        Iterator r4 = ((ArrayList) r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Uri r0 = (Uri) r4.next();
        List<ImageRequestBuilder> r1 = this.t;
        ArrayList r2 = (ArrayList) r1;
        r2.add(ImageRequestBuilder.newBuilderWithSource(r0));
        goto L4
    }

    public static ScalingUtils.ScaleType b(ImageView.ScaleType r1, ScalingUtils.ScaleType r2) {
        switch(C0193b.a[r1.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return r2;
    L6:
        return ScalingUtils.ScaleType.FOCUS_CROP;
    L8:
        return ScalingUtils.ScaleType.FIT_XY;
    L10:
        return ScalingUtils.ScaleType.FIT_END;
    L12:
        return ScalingUtils.ScaleType.FIT_START;
    L14:
        return ScalingUtils.ScaleType.FIT_CENTER;
    L16:
        return ScalingUtils.ScaleType.CENTER_INSIDE;
    L18:
        return ScalingUtils.ScaleType.CENTER_CROP;
    L20:
        return ScalingUtils.ScaleType.CENTER;
    }
}
