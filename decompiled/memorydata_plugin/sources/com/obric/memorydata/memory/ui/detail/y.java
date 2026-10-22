package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a4\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u001a&\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002\u001a.\u0010\u001c\u001a\u00020\u0001*\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 H\u0002\u001a\u000e\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u0002H\u0002\u001a\f\u0010$\u001a\u00020\u0001*\u00020%H\u0002\"\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"setStrokeDrawable", "", "Landroid/view/View;", "strokeWidth", "", "strokeColor", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "calculateFitImageSize", "Lkotlin/Pair;", "imageWidth", "imageHeight", "maxWidth", "maxHeight", "MAX_PREVIEW_IMAGE_HEIGHT_DP", "readImageBounds", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "calculatePreviewImageLayout", "Lcom/obric/memorydata/memory/ui/detail/PreviewImageLayout;", "applyPreviewImageLayout", "Landroid/widget/ImageView;", "previewLayout", "showImage", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "onLoaded", "Lkotlin/Function1;", "", "getLifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "setupMemoryDetailLinkStyle", "Landroid/widget/TextView;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class y {

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/memory/ui/detail/MemoryDetailViewHolderKt$showImage$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onResourceReady", "", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "onLoadCleared", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.bumptech.glide.request.a.a<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f10885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ac f10886b;
        final /* synthetic */ Function1<Boolean, Unit> c;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.y$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/detail/MemoryDetailViewHolderKt$showImage$1$onResourceReady$1$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0556a extends ViewOutlineProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ac f10887a;

            C0556a(ac r1) {
                this.f10887a = r1;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View r8, Outline r9) {
                Intrinsics.checkNotNullParameter(r8, "view");
                Intrinsics.checkNotNullParameter(r9, "outline");
                int r4 = r8.getWidth();
                int r5 = r8.getHeight();
                if (this.f10887a.c() == false) goto L5;
                float r7 = (float) 21.33d;
            L6:
                r9.setRoundRect(0, 0, r4, r5, TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics()));
                return;
            L5:
                r7 = 16;
                goto L6
            }
        }

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1 f10888a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ac f10889b;

            public b(Function1 r3, ac r4) {
                this.f10888a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
                this.f10889b = r4;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
                Function1 r10 = this.f10888a;
                if (r10 == null) goto L6;
                r10.invoke(Boolean.valueOf(this.f10889b.c()));
                return;
            }
        }

        a(ImageView r3, ac r4, Function1<? super Boolean, Unit> r5, int r6, int r7) {
            Function1<Boolean, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            this.f10885a = r3;
            this.f10886b = r4;
            this.c = r8;
            super(r6, r7);
        }

        private static final void a(ImageView r3, ac r4, Function1 r5) {
            Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            r3.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new C0556a(r4), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
            r3.setClipToOutline(true);
            r3.invalidateOutline();
            View r7 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
            if (ViewCompat.isLaidOut(r7) == true) goto L5;
        L8:
            r7.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new b(r6, r4), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            if (r7.isLayoutRequested() == true) goto L8;
            if (r6 == null) goto L10;
            r6.invoke(Boolean.valueOf(r4.c()));
            return;
        }

        /* JADX INFO: renamed from: lambda$ZFR-l9h6oP7CFSSW61X8ydptGOE, reason: not valid java name */
        public static /* synthetic */ void m854lambda$ZFRl9h6oP7CFSSW61X8ydptGOE(ImageView r0, ac r1, Function1 r2) {
            a(r0, r1, r2);
        }

        public void a(Bitmap r4, com.bumptech.glide.request.b.b<? super Bitmap> r5) {
            com.bumptech.glide.request.b.b r6 = (com.bumptech.glide.request.b.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.request.b.b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "resource");
            this.f10885a.setVisibility(0);
            RunLog.INSTANCE.debug("MemoryDetailItemViewHolder", "preview image decoded: " + r4.getWidth() + " x " + r4.getHeight() + ", view=" + this.f10886b.a() + " x " + this.f10886b.b());
            this.f10885a.setImageBitmap(r4);
            final ImageView r7 = this.f10885a;
            final ac r8 = this.f10886b;
            final Function1<Boolean, Unit> r3 = this.c;
            r7.post(new $$Lambda$y$a$ZFRl9h6oP7CFSSW61X8ydptGOE(r7, r8, r3));
        }

        @Override // com.bumptech.glide.request.a.e
        public /* synthetic */ void a(Object r3, com.bumptech.glide.request.b.b r4) {
            com.bumptech.glide.request.b.b<? super Bitmap> r5 = (com.bumptech.glide.request.b.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.b.b.class, "com.obric.memorydata.plugin");
            a((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // com.bumptech.glide.request.a.e
        public void a_(Drawable r1) {
            this.f10885a.setVisibility(8);
        }

        @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.e
        public void b(Drawable r7) {
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "load image failed", null, 4, null);
            this.f10885a.setVisibility(8);
        }
    }

    public static final /* synthetic */ LifecycleCoroutineScope a(View r0) {
        return b(r0);
    }

    private static final ac a(int r4, int r5) {
        if (r5 <= r4) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        int r0 = MathKt.roundToInt(TypedValue.applyDimension(1, 184, Resources.getSystem().getDisplayMetrics()));
        return new ac(r0, RangesKt.coerceIn((int) (r0 / RangesKt.coerceAtLeast(r4 / r5, 0.01f)), 1, MathKt.roundToInt(TypedValue.applyDimension(1, 320, Resources.getSystem().getDisplayMetrics()))), true);
    L9:
        return new ac(MathKt.roundToInt(TypedValue.applyDimension(1, 288, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 144, Resources.getSystem().getDisplayMetrics())), false);
    L5:
        r2 = false;
        goto L6
    }

    private static final Pair<Integer, Integer> a(Context r6, Uri r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        InputStream r2 = r8.getContentResolver().openInputStream(r7);     // Catch: Exception -> L32
        if (r2 == null) goto L14;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L32
        int r4 = new ExifInterface((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin")).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L32
    L15:
        BitmapFactory.Options r5 = new BitmapFactory.Options();     // Catch: Exception -> L32
        r5.inJustDecodeBounds = true;     // Catch: Exception -> L32
        InputStream r9 = r8.getContentResolver().openInputStream(r7);     // Catch: Exception -> L32
        if (r9 == null) goto L27;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L32
        BitmapFactory.decodeStream((InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.memorydata.plugin"), null, r5);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r10, null);     // Catch: Exception -> L32
        goto L27
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Exception -> L32
        throw th;     // Catch: Exception -> L32
    L27:
        if (r5.outWidth > 0) goto L29;
        return null;
    L29:
        if (r5.outHeight > 0) goto L46;
        return null;
    L46:
        return j.f10859a.a(r5.outWidth, r5.outHeight, r4);
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L32
        throw th;     // Catch: Exception -> L32
    L14:
        r4 = 1;
    L32:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryDetailItemViewHolder", "read image bounds failed: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public static final /* synthetic */ void a(View r0, int r1, int r2, float r3, float r4, float r5, float r6) {
        b(r0, r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ void a(ImageView r2, FileEntity r3, Function1 r4) {
        b(r2, r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(ImageView r1, FileEntity r2, Function1 r3, int r4, Object r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        b(r1, r2, r6);
    }

    private static final void a(ImageView r7, ac r8) {
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        ViewParent r1 = r7.getParent();
        LinearLayout r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L5;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
    L6:
        r0.width = r8.a();
        r0.height = r8.b();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L10;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).bottomMargin = 0;
    L10:
        if (r8.c() == false) goto L30;
        if (ZeusTransformUtils.instanceOf(r0, LinearLayout.LayoutParams.class) == false) goto L19;
        ((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin")).gravity = 49;
        if (ZeusTransformUtils.instanceOf(r2, LinearLayout.class) == false) goto L16;
        r3 = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.memorydata.plugin");
    L16:
        if (r3 == null) goto L25;
        r3.setGravity(49);
    L25:
        if (r2 == null) goto L27;
        r2.setClipChildren(true);
    L27:
        if (r2 == null) goto L46;
        r2.setClipToPadding(true);
    L46:
        r7.setLayoutParams(r0);
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r0, FrameLayout.LayoutParams.class) == false) goto L22;
        ((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin")).gravity = 49;
        goto L25
    L22:
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.LayoutParams.class) == false) goto L25;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).topToTop = 0;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).startToStart = 0;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).bottomToBottom = -1;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).verticalBias = 0.0f;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).horizontalBias = 0.5f;
        goto L25
    L30:
        if (ZeusTransformUtils.instanceOf(r0, LinearLayout.LayoutParams.class) == false) goto L37;
        ((LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin")).gravity = 17;
        if (ZeusTransformUtils.instanceOf(r2, LinearLayout.class) == false) goto L34;
        r3 = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.memorydata.plugin");
    L34:
        if (r3 == null) goto L42;
        r3.setGravity(17);
    L42:
        if (r2 == null) goto L44;
        r2.setClipChildren(false);
    L44:
        if (r2 == null) goto L46;
        r2.setClipToPadding(false);
        goto L46
    L37:
        if (ZeusTransformUtils.instanceOf(r0, FrameLayout.LayoutParams.class) == false) goto L40;
        ((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin")).gravity = 17;
        goto L42
    L40:
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.LayoutParams.class) == false) goto L42;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).topToTop = 0;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).startToStart = 0;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).verticalBias = 0.5f;
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).horizontalBias = 0.5f;
        goto L42
    L5:
        r2 = null;
        goto L6
    }

    public static final /* synthetic */ void a(TextView r0) {
        b(r0);
    }

    private static final LifecycleCoroutineScope b(View r0) {
        LifecycleOwner r1 = ViewTreeLifecycleOwner.get(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r1);
    }

    private static final void b(View r2, int r3, int r4, float r5, float r6, float r7, float r8) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setColor(0);
        r0.setStroke(r3, r4);
        r0.setCornerRadii(new float[]{r5, r5, r6, r6, r7, r7, r8, r8});
        r2.setForeground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.memorydata.plugin"));
    }

    private static final void b(ImageView r8, FileEntity r9, Function1<? super Boolean, Unit> r10) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L6;
        r8.setVisibility(8);
        return;
    L6:
        Uri r11 = com.obric.memorydata.memory.utils.f.f11537a.a(r9.getContentUrl());
        if (r11 != null) goto L10;
        r8.setVisibility(8);
        return;
    L10:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "getContext(...)");
        Pair<Integer, Integer> r13 = a(r12, r11);
        if (r13 == null) goto L15;
        ac r14 = a(((Number) ZeusTransformUtils.preCheckCast(r13.component1(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r13.component2(), Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r14 == null) goto L15;
    L16:
        ac r4 = r14;
        a(r8, r4);
        com.bumptech.glide.c.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        ((com.bumptech.glide.h) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.h) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.c.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin")).h().a(r11).a(com.bumptech.glide.load.engine.h.f780b), com.bumptech.glide.h.class, "com.obric.memorydata.plugin")).a(r4.a(), r4.b()), com.bumptech.glide.h.class, "com.obric.memorydata.plugin")).a((com.bumptech.glide.load.h) ZeusTransformUtils.preCheckCast(new com.bumptech.glide.load.resource.bitmap.i(), com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin")), com.bumptech.glide.h.class, "com.obric.memorydata.plugin")).a((com.bumptech.glide.request.a.e) ZeusTransformUtils.preCheckCast(new a(r8, r4, r5, r4.a(), r4.b()), com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        r14 = new ac(MathKt.roundToInt(TypedValue.applyDimension(1, 288, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 144, Resources.getSystem().getDisplayMetrics())), false);
        goto L16
    }

    private static final void b(TextView r6) {
        float r3 = 1;
        com.obric.memorydata.markdown.stream.s.b(r6, new com.obric.memorydata.markdown.stream.r(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r3, Resources.getSystem().getDisplayMetrics()))));
    }
}
