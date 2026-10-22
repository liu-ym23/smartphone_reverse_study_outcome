package com.larus.bmhome.viewholder;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.t1;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import com.larus.common_ui.view.CustomTransitionPhotoDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uo8.j;
import yt8.f;
import yt8.g;
import yt8.h;
import yt8.i;
import yt8.k;
import yt8.l;
import yt8.m;
import yt8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001eH\u0002J:\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J.\u0010.\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010'2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001e01H\u0002J:\u00102\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\b\u0002\u00103\u001a\u00020-H\u0002J:\u00104\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\b\u0002\u00103\u001a\u00020-H\u0002J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0003H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00069"}, d2 = {"Lcom/larus/bmhome/viewholder/PhotoVH;", "Lcom/larus/bmhome/viewholder/LifeViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "transitionPhotoDraweeView", "Lcom/larus/common_ui/view/CustomTransitionPhotoDraweeView;", "getTransitionPhotoDraweeView", "()Lcom/larus/common_ui/view/CustomTransitionPhotoDraweeView;", "layerView", "getLayerView", "()Landroid/view/View;", "loadingView", "getLoadingView", "retryView", "getRetryView", "curItem", "Lcom/larus/bmhome/bigimg/MediaItem;", "getCurItem", "()Lcom/larus/bmhome/bigimg/MediaItem;", "setCurItem", "(Lcom/larus/bmhome/bigimg/MediaItem;)V", "transitionListener", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "getTransitionListener", "()Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "setTransitionListener", "(Lcom/larus/common_ui/photoviewer/transition/TransitionListener;)V", "bindMediaData", "", "imagePreviewDownloadUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "orNull", "", "bindStatus", "holderLoadImage", "holder", "uri", "Landroid/net/Uri;", "thumbUrl", "position", "", "onFail", "Lkotlin/Function0;", "", "loadThumbImage", "thumbUri", "callBack", "Lkotlin/Function1;", "loadImage", "needShowStatus", "loadImageWithResizeOptions", "getResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "view", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoVH extends LifeViewHolder {
    public static final /* synthetic */ int p = 0;
    public final CustomTransitionPhotoDraweeView k;
    public final View l;
    public final View m;
    public final View n;
    public t1 o;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ PhotoVH a;

        public a(PhotoVH r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            super.onLongPress(r3);
            t1 r4 = this.a.o;
            boolean r0 = false;
            if (r4 != null) goto L5;
        L7:
            if (r0 == false) goto L9;
            return;
        L9:
            Function0<Unit> r5 = this.a.h;
            if (r5 == null) goto L13;
            r5.invoke();
            return;
        L13:
            return;
        L5:
            if (r4.d() != true) goto L7;
            r0 = true;
            goto L7
        }
    }

    public static final class b {
    }

    public static final class c extends BaseControllerListener<Object> {
        public final /* synthetic */ PhotoVH a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Uri c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ PhotoVH e;
        public final /* synthetic */ Function0<Boolean> f;

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            if (((Boolean) this.f.invoke()).booleanValue() == false) goto L5;
            return;
        L5:
            if (this.d == false) goto L9;
            this.e.n.setVisibility(0);
            this.e.m.setVisibility(8);
            return;
        }

        public final void onSubmit(String r1, Object r2) {
            super.onSubmit(r1, r2);
            if (this.d == false) goto L6;
            this.e.n.setVisibility(8);
            this.e.m.setVisibility(0);
            return;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, r2, r3);
            Function1<? super Integer, Unit> r4 = this.a.g;
            if (r4 == null) goto L5;
            r4.invoke(Integer.valueOf(this.b));
        L5:
            FLogger.a.i("PhotoVH", "load photo Image success " + this.c);
            j r5 = this.a.f;
            if (r5 == null) goto L9;
            r5.a(this.b, this.c);
        L9:
            if (this.d == false) goto L14;
            this.e.n.setVisibility(8);
            this.e.m.setVisibility(8);
            View r6 = this.e.l;
            if (r6 == null) goto L15;
            e1.o(r6);
            return;
        L15:
            return;
        }

        public c(PhotoVH r1, int r2, Uri r3, boolean r4, PhotoVH r5, Function0<Boolean> r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    public PhotoVH(View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        CustomTransitionPhotoDraweeView r0 = r5.findViewById(2131364164);
        this.k = r0;
        this.l = r5.findViewById(2131364165);
        this.m = r5.findViewById(2131364163);
        View r6 = r5.findViewById(2131364166);
        this.n = r6;
        T3().setDelegateDragTransitionView(r0);
        r0.setHorizontalNestedScrollEnabled(true);
        r0.setMaxScaleFactor(3.0f);
        T3().setTransitionAnimationDuration(200);
        r0.setTapListener(new a(this));
        r0.setOnScaleChangeCallback(new g(this));
        r6.setOnClickListener(new h(this));
    }

    @Override // com.larus.bmhome.viewholder.LifeViewHolder
    public final void U3(n1 r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "imagePreviewDownloadUrl");
        super.U3(r10, r11);
        this.o = r10.b;
        ((com.larus.common_ui.photoviewer.a) this.k.getControllerImp()).d = true;
        T3().setDragTransitionEnabled(true);
        T3().c(new n());
        String r12 = r10.c;
        Object r2 = null;
        if (r12 != null) goto L5;
    L31:
        final Uri r5 = null;
    L46:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L38
        if (r11 == null) goto L35;
        Uri r14 = b0.a(r11, "common.photo_dialog_preview", false, false, 6);     // Catch: Throwable -> L38
    L36:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r15) == true) goto L44;
        r2 = r15;
    L44:
        final Uri r6 = (Uri) r2;
        this.k.getHierarchy().setActualImageColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(((TransitionViewHolder) this).a.getContext(), 2131103188), BlendModeCompat.DST_OVER));
        Z3(this, r5, r6, getPosition(), new f(r5, this, r6));
        return;
    L35:
        r14 = null;
    L38:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L5:
        if (r12.length() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L11;
    L29:
        if (r12 == null) goto L31;
        r5 = UriProtector.parse(r12);
        goto L46
    L11:
        if (StringsKt.startsWith(r12, "http://", true) == true) goto L29;
        if (StringsKt.startsWith(r12, "https://", true) == true) goto L29;
        if (StringsKt.startsWith$default(r12, "content://", false, 2, null) == true) goto L29;
        if (StringsKt.startsWith$default(r12, "android_asset://", false, 2, null) == true) goto L29;
        if (StringsKt.startsWith(r12, "res:///", true) == true) goto L29;
        if (StringsKt.startsWith(r12, "file://", true) == true) goto L29;
        r12 = "file://".concat(r12);
        goto L29
    L7:
        r3 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [yt8.i] */
    public final void Z3(final PhotoVH r8, final Uri r9, Uri r10, final int r11, final Function0<Boolean> r12) {
        if (r10 == null) goto L4;
        final ?? r6 = new i(r8, this, r9, r11, r12);
        ImageLoaderKt.x(r8.k, r10, null, null, new l(r8, r6), 6);
        return;
    L4:
        a4(r8, r9, r11, r12, true);
    }

    public final void a4(final PhotoVH r10, final Uri r11, final int r12, final Function0<Boolean> r13, final boolean r14) {
        if (r10.k.getWidth() != 0) goto L5;
    L8:
        r10.k.post(new k(r10, this, r11, r12, r13, r14));
        return;
    L5:
        if (r10.k.getHeight() == 0) goto L8;
        b4(r10, r11, r12, r13, r14);
    }

    public final void b4(final PhotoVH r13, final Uri r14, final int r15, final Function0<Boolean> r16, final boolean r17) {
        CustomTransitionPhotoDraweeView r0 = r13.k;
        int r2 = r0.getWidth();
        int r1 = r0.getHeight();
        if (r2 <= 0) goto L7;
        if (r1 <= 0) goto L7;
        final ResizeOptions r3 = new ResizeOptions(r2, r1);
    L8:
        ImageLoaderKt.x(r13.k, r14, "photoTransitionPager", null, new m(r13, r3, r14, this, r15, r17, r16), 4);
        return;
    L7:
        r3 = null;
        goto L8
    }
}
