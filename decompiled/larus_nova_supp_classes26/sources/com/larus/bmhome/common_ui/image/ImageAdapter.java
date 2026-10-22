package com.larus.bmhome.common_ui.image;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.bmhome.bigimg.n1;
import com.larus.common_ui.view.CustomTransitionPhotoDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import j19.g;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l19.f;
import l19.l;
import uo8.d;
import uo8.e;
import uo8.h;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002bcB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010F\u001a\u00020\bJ\u0012\u0010G\u001a\u0004\u0018\u00010\t2\u0006\u0010F\u001a\u00020\bH\u0002J\u0010\u0010H\u001a\u0004\u0018\u00010\t2\u0006\u0010F\u001a\u00020\bJ\u001c\u0010I\u001a\u00060JR\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\bH\u0016J\u001a\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u00022\b\b\u0001\u0010F\u001a\u00020\bH\u0016J>\u0010P\u001a\u00020\u001d2\n\u0010O\u001a\u00060JR\u00020\u00002\b\u0010Q\u001a\u0004\u0018\u00010\t2\b\u0010R\u001a\u0004\u0018\u00010\t2\u0006\u0010F\u001a\u00020\b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020)0#H\u0002J\u0016\u0010T\u001a\u0004\u0018\u00010U2\n\u0010O\u001a\u00060JR\u00020\u0000H\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010W\u001a\u00020\bH\u0002J\u0016\u0010X\u001a\u0004\u0018\u00010U2\n\u0010O\u001a\u00060JR\u00020\u0000H\u0002J\u0014\u0010Y\u001a\u00020\b2\n\u0010Z\u001a\u00020[\"\u00020\bH\u0002J\u000e\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\bJ\u0010\u0010^\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0016J\b\u0010_\u001a\u00020\bH\u0016J\u0010\u0010`\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\bH\u0016J\u0010\u0010a\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\bH\u0016R:\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R\"\u00105\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\"\u00108\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010%\"\u0004\b:\u0010'R\u001a\u0010;\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006d"}, d2 = {"Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/common_ui/photoviewer/OnPageSelectedListener;", "<init>", "()V", "validMapUrl", "Ljava/util/LinkedHashMap;", "", "Landroid/net/Uri;", "Lkotlin/collections/LinkedHashMap;", "getValidMapUrl", "()Ljava/util/LinkedHashMap;", "setValidMapUrl", "(Ljava/util/LinkedHashMap;)V", "urls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "thumbUrls", "", "", "getThumbUrls", "setThumbUrls", "onImageLoadSuccess", "Lkotlin/Function1;", "", "getOnImageLoadSuccess", "()Lkotlin/jvm/functions/Function1;", "setOnImageLoadSuccess", "(Lkotlin/jvm/functions/Function1;)V", "onImageLongPressListener", "Lkotlin/Function0;", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "", "getOnImageScaleListener", "setOnImageScaleListener", "transitionListener", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "getTransitionListener", "()Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "setTransitionListener", "(Lcom/larus/common_ui/photoviewer/transition/TransitionListener;)V", "dismissCallback", "getDismissCallback", "setDismissCallback", "dismissCallbackByClick", "getDismissCallbackByClick", "setDismissCallbackByClick", "tapClickCallback", "getTapClickCallback", "setTapClickCallback", "slideDirection", "getSlideDirection", "()I", "setSlideDirection", "(I)V", "enableCreationFullSizeResize", "getEnableCreationFullSizeResize", "()Z", "setEnableCreationFullSizeResize", "(Z)V", "getValidUri", "position", "getPreviewUri", "getDownloadUri", "onCreateViewHolder", "Lcom/larus/bmhome/common_ui/image/ImageAdapter$PhotoVH;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "holderLoadImage", "uri", "thumbUri", "onFail", "buildCreationResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "buildFullSizeResizeOptions", "resizeSize", "buildContainerResizeOptions", "firstValidSize", "sizes", "", "deleteCreationInPosition", "pos", "getItemViewType", "getItemCount", "onPageSelected", "onPageUnselected", "Companion", "PhotoVH", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements g {
    public static final /* synthetic */ int m = 0;
    public final LinkedHashMap<Integer, Uri> a;
    public List<n1> b;
    public List<String> c;
    public Function1<? super Integer, Unit> d;
    public Function0<Unit> e;
    public Function1<? super Boolean, Unit> f;
    public f g;
    public Function0<Unit> h;
    public Function0<Unit> i;
    public Function0<Unit> j;
    public int k;
    public boolean l;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/common_ui/image/ImageAdapter$PhotoVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "dismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/bmhome/common_ui/image/ImageAdapter;Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "transitionPhotoDraweeView", "Lcom/larus/common_ui/view/CustomTransitionPhotoDraweeView;", "getTransitionPhotoDraweeView", "()Lcom/larus/common_ui/view/CustomTransitionPhotoDraweeView;", "loadingView", "getLoadingView", "()Landroid/view/View;", "retryView", "getRetryView", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PhotoVH extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final CustomTransitionPhotoDraweeView a;
        public final View b;
        public final View c;

        public static final class a extends GestureDetector.SimpleOnGestureListener {
            public final /* synthetic */ ImageAdapter a;

            public a(ImageAdapter r1) {
                this.a = r1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent r2) {
                Intrinsics.checkNotNullParameter(r2, "e");
                super.onLongPress(r2);
                Function0<Unit> r3 = this.a.e;
                if (r3 == null) goto L6;
                r3.invoke();
                return;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onSingleTapConfirmed(MotionEvent r2) {
                Intrinsics.checkNotNullParameter(r2, "e");
                int r3 = z2.a.creationDetailClickAction();
                if (r3 == 0) goto L11;
                if (r3 == 1) goto L8;
                Function0<Unit> r4 = this.a.i;
                if (r4 == null) goto L14;
                r4.invoke();
            L14:
                return true;
            L8:
                Function0<Unit> r5 = this.a.j;
                if (r5 == null) goto L14;
                r5.invoke();
                goto L14
            L11:
                Function0<Unit> r6 = this.a.i;
                if (r6 == null) goto L14;
                r6.invoke();
                goto L14
            }
        }

        public PhotoVH(final ImageAdapter r3, View r4, Function0<Unit> r5) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            super(r4);
            CustomTransitionPhotoDraweeView r0 = r4.findViewById(2131364164);
            this.a = r0;
            this.b = r4.findViewById(2131364163);
            View r6 = r4.findViewById(2131364166);
            this.c = r6;
            r0.setMaxScaleFactor(3.0f);
            r0.setTapListener(new a(r3));
            r0.setOnScaleChangeCallback(new uo8.g(r3));
            f r1 = r3.g;
            if (r1 == null) goto L5;
            r0.c(r1);
        L5:
            r6.setOnClickListener(new h(this));
            ((l) r0.getControllerImp()).M = false;
            ((l) r0.getControllerImp()).L = false;
            r0.setDismissCallback(r5);
            r0.setSlideDirection(r3.k);
        }
    }

    public static final class a {
    }

    public static final class b extends BaseControllerListener<Object> {
        public final /* synthetic */ ImageAdapter a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Uri c;
        public final /* synthetic */ PhotoVH d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ Function0<Boolean> g;

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            if (((Boolean) this.g.invoke()).booleanValue() == true) goto L6;
            this.d.c.setVisibility(0);
            this.d.b.setVisibility(8);
            return;
        }

        public final void onSubmit(String r2, Object r3) {
            super.onSubmit(r2, r3);
            int r4 = 8;
            this.d.c.setVisibility(8);
            View r5 = this.d.b;
            if (this.e == false) goto L5;
        L8:
            r5.setVisibility(r4);
            return;
        L5:
            if (this.f == true) goto L8;
            r4 = 0;
            goto L8
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, r2, r3);
            this.a.d.invoke(Integer.valueOf(this.b));
            FLogger.a.e("CustomPhotoTransitionPagerAdapter", "load photo Image success " + this.c);
            this.a.a.put(Integer.valueOf(this.b), this.c);
            this.d.c.setVisibility(8);
            this.d.b.setVisibility(8);
        }

        public b(ImageAdapter r1, int r2, Uri r3, PhotoVH r4, boolean r5, boolean r6, Function0<Boolean> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
    }

    public final void S80(int r1) {
    }

    public final int getItemViewType(int r1) {
        return 1;
    }

    public final void onPageSelected(int r1) {
    }

    public final void onPageSelected(int r1, boolean r2) {
    }

    public final int getItemCount() {
        List<n1> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public ImageAdapter() {
        this.a = new LinkedHashMap();
        this.d = new d();
        this.k = 1;
    }

    public final Uri A2(int r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(this.a.get(Integer.valueOf(r4)));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L17;
        List<n1> r2 = this.b;
        if (r2 == null) goto L14;
        n1 r5 = (n1) ListProtector.get(r2, r4);
        if (r5 == null) goto L14;
        String r6 = r5.a;
    L15:
        r1 = b0.a(r6, "common.photo_dialog_preview", false, false, 6);
    L14:
        r6 = null;
    L17:
        return (Uri) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final int y2(int... r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        int r3 = r6[r2];
        boolean r4 = true;
        if (r3 > 1) goto L8;
        r4 = false;
    L8:
        if (r4 == true) goto L9;
        r2 = r2 + 1;
        goto L3
    L9:
        Integer r7 = Integer.valueOf(r3);
    L12:
        if (r7 != null) goto L14;
        return 0;
    L14:
        return r7.intValue();
    L11:
        r7 = null;
        goto L12
    }

    public final Uri z2(int r4) {
        List<n1> r0 = this.b;
        if (r0 == null) goto L10;
        n1 r1 = (n1) CollectionsKt.getOrNull(r0, r4);
        if (r1 == null) goto L10;
        if (Intrinsics.areEqual(r1.a, r1.c) == true) goto L13;
        return b0.a(r1.c, "common.photo_dialog_download", false, false, 6);
    L13:
        return A2(r4);
    L10:
        return null;
    }

    public final void onBindViewHolder(final RecyclerView.ViewHolder r12, final int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        List<n1> r0 = this.b;
        Object r1 = null;
        if (r0 == null) goto L7;
        n1 r2 = (n1) ListProtector.get(r0, r13);
        if (r2 == null) goto L7;
        String r3 = r2.a;
    L8:
        Uri r7 = b0.a(r3, "common.photo_dialog_preview", false, false, 6);
        if ((r12 instanceof PhotoVH) == false) goto L29;
        ((PhotoVH) r12).a.getHierarchy().setActualImageColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(r12.itemView.getContext(), c.b(2130972118, r12.itemView.getContext(), 2131103188)), BlendModeCompat.DST_OVER));
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        List<String> r5 = this.c;     // Catch: Throwable -> L19
        if (r5 == null) goto L16;
        String r6 = (String) ListProtector.get(r5, r13);     // Catch: Throwable -> L19
        if (r6 == null) goto L16;
        Uri r8 = b0.a(r6, "common.photo_dialog_preview", false, false, 6);     // Catch: Throwable -> L19
    L17:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r9) == true) goto L25;
        r1 = r9;
    L25:
        final Uri r10 = (Uri) r1;
        B2((PhotoVH) r12, r7, r10, r13, new uo8.c(this, r12, r10, r13));
        return;
    L16:
        r8 = null;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L29:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PhotoVH(this, LayoutInflater.from(r4.getContext()).inflate(2131562008, r4, false), this.h);
    }

    public final void B2(final PhotoVH r12, final Uri r13, final Uri r14, final int r15, final Function0<Boolean> r16) {
        ImageLoaderKt.x(r12.a, r13, "common.photo_dialog_preview", null, new e(r12, r14, this, r15, r13, r16), 4);
    }
}
