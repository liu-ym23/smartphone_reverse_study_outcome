package com.ss.android.lark.movable.attatchment;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(IAttachmentBinder.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageGalleryAttachmentBinder;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentBinder;", "<init>", "()V", "attachmentTypeId", "", "getAttachmentTypeId", "()I", "declareMeasureResolver", "Ljava/lang/Class;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentMeasureResolver;", "bind", "", "container", "Lcom/ss/android/lark/movable/attatchment/AttachmentView;", "info", "Lcom/ss/android/lark/movable/attatchment/AttachmentInfo;", "decorateImageView", "img", "Landroid/widget/ImageView;", "imageList", "", "Lcom/ss/android/lark/movable/attatchment/ImageGalleryItem;", "index", "convert2ImageGallery", "context", "Landroid/content/Context;", "generateLongPhotoLabel", "Landroid/widget/TextView;", "photoId", "computeMatrix", "imageView", "Companion", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageGalleryAttachmentBinder implements IAttachmentBinder {
    public static final a Companion = null;
    private static final String TAG = "ImageGalleryAttachmentBinder";
    private final int attachmentTypeId;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ ImageGalleryAttachmentBinder a;
        public final /* synthetic */ ImageView b;

        public b(ImageGalleryAttachmentBinder r1, LKUIRoundedImageView2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if ((r4 - r2) == (r8 - r6)) goto L6;
            ImageGalleryAttachmentBinder.access$computeMatrix(this.a, this.b);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ com.ss.android.lark.movable.attatchment.d a;
        public final /* synthetic */ j b;

        public c(com.ss.android.lark.movable.attatchment.d r1, j r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.movable.b r3 = this.a.getMovableEventClickListener();
            if (r3 == null) goto L6;
            r3.b(this.b.g());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/movable/attatchment/ImageGalleryAttachmentBinder$convert2ImageGallery$originList$1$itemType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/ss/android/lark/movable/attatchment/ImageGalleryItem;", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class d extends TypeToken<List<? extends j>> {
        public d() {
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ com.ss.android.lark.movable.attatchment.d a;
        public final /* synthetic */ List<j> b;
        public final /* synthetic */ int c;

        public e(com.ss.android.lark.movable.attatchment.d r1, List<j> r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.ss.android.lark.movable.b r0 = this.a.getMovableEventClickListener();
            if (r0 == null) goto L5;
            r0.a(((j) ListProtector.get(this.b, this.c)).f());
        L5:
            lsb.b.a.getClass();
            lsb.b r1 = (lsb.b) ClaymoreServiceLoader.loadFirstOrNull(lsb.b.class);
            if (r1 != null) goto L8;
            Log.i(ImageGalleryAttachmentBinder.TAG, "image gallery preview ignored: no IMovableImagePreviewer impl");
            return;
        L8:
            Intrinsics.checkNotNull(r4);
            List<j> r5 = this.b;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r6 = r5.iterator();
        L10:
            if (r6.hasNext() == false) goto L12;
            r2.add(((j) r6.next()).f());
            goto L10
        L12:
            r1.b();
        }
    }

    static {
        Companion = new a();
    }

    public ImageGalleryAttachmentBinder() {
        int r0 = com.ss.android.lark.movable.attatchment.c.a;
        this.attachmentTypeId = com.ss.android.lark.movable.attatchment.c.a;
    }

    public Class<? extends i> declareMeasureResolver() {
        return i.class;
    }

    @Override // com.ss.android.lark.movable.attatchment.IAttachmentBinder
    public int getAttachmentTypeId() {
        return this.attachmentTypeId;
    }

    private final void computeMatrix(ImageView r8) {
        Drawable r0 = r8.getDrawable();
        if (r0 == null) goto L19;
        Matrix r1 = r8.getImageMatrix();
        int r2 = (r8.getWidth() - r8.getPaddingLeft()) - r8.getPaddingRight();
        int r3 = (r8.getHeight() - r8.getPaddingStart()) - r8.getPaddingBottom();
        int r4 = r0.getIntrinsicWidth();
        int r5 = r0.getIntrinsicHeight();
        if (r5 == 0) goto L8;
        if (r4 == 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ImageView r7 = r8;
    L12:
        if (r7 != null) goto L14;
        return;
    L14:
        if ((r4 * r3) <= (r5 * r2)) goto L16;
        float r9 = r3 / r5;
    L17:
        r1.setScale(r9, r9);
        r1.postTranslate((-((r9 * r4) - r2)) * 0.5f, 0.0f);
        r8.setImageMatrix(r1);
        return;
    L16:
        r9 = r2 / r4;
        goto L17
    L11:
        r7 = null;
    L8:
        r6 = false;
        goto L9
    }

    public static final /* synthetic */ void access$computeMatrix(ImageGalleryAttachmentBinder r0, ImageView r1) {
        r0.computeMatrix(r1);
    }

    private final List<j> convert2ImageGallery(com.ss.android.lark.movable.attatchment.b r9, Context r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Gson r1 = new Gson();     // Catch: Throwable -> L7
        Type r2 = new d().getType();     // Catch: Throwable -> L7
        String r11 = r9.g.get("img-gallery");     // Catch: Throwable -> L7
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        Object r12 = Result.constructor-impl((List) r1.fromJson(r11, r2));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r12) == false) goto L12;
        r12 = null;
    L12:
        List r13 = (List) r12;
        if (r13 != null) goto L15;
        r13 = CollectionsKt.emptyList();
    L15:
        List r14 = r13;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        j r4 = (j) r15.next();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r10, "context");
        float r5 = com.ss.android.lark.movable.utils.b.d(r4.h(), r10);
        float r6 = com.ss.android.lark.movable.utils.b.d(r4.c(), r10);
        com.ss.android.lark.movable.attatchment.e r7 = r4.e();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r10, "context");
        f r8 = r7.a();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "context");
        f r16 = new f(com.ss.android.lark.movable.utils.b.d(r8.a(), r10), com.ss.android.lark.movable.utils.b.d(r8.b(), r10));
        g r17 = com.ss.android.lark.movable.utils.b.b(r7.b(), r10);
        Intrinsics.checkNotNullParameter(r16, "origin");
        Intrinsics.checkNotNullParameter(r17, "size");
        r3.add(j.a(r4, r5, r6, new com.ss.android.lark.movable.attatchment.e(r16, r17), com.ss.android.lark.movable.utils.b.b(r4.d(), r10)));
        goto L17
    L19:
        return r3;
    L7:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private final TextView generateLongPhotoLabel(Context r6, int r7) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(UIUtils.dp2px(r6, 4.0f));
        r0.setStroke(UIUtils.dp2px(r6, 0.5f), UDColorUtils.getColor(r6, 2131106525));
        r0.setColor(UDColorUtils.getColor(r6, 2131106511));
        TextView r1 = new TextView(r6);
        r1.setTextSize(10.0f);
        r1.setText(UIUtils.getString(r6, 2131890863));
        r1.setTextColor(UIUtils.getColor(r6, 2131106521));
        r1.setBackground(r0);
        r1.setPadding(com.ss.android.lark.movable.utils.e.a(4), com.ss.android.lark.movable.utils.e.a(1), com.ss.android.lark.movable.utils.e.a(4), com.ss.android.lark.movable.utils.e.a(1));
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-2, -2);
        r2.bottomToBottom = r7;
        r2.endToEnd = r7;
        r2.setMarginEnd(com.ss.android.lark.movable.utils.e.a(4));
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = com.ss.android.lark.movable.utils.e.a(4);
        r1.setLayoutParams(r2);
        return r1;
    }

    @Override // com.ss.android.lark.movable.attatchment.IAttachmentBinder
    public void bind(com.ss.android.lark.movable.attatchment.d r18, com.ss.android.lark.movable.attatchment.b r19) {
        Intrinsics.checkNotNullParameter(r18, "container");
        Intrinsics.checkNotNullParameter(r19, "info");
        r18.removeAllViews();
        Context r9 = r18.getContext();
        Intrinsics.checkNotNull(r9);
        List<j> r10 = convert2ImageGallery(r19, r9);
        Iterator<T> r11 = r10.iterator();
        int r12 = 0;
        int r0 = 0;
    L4:
        if (r11.hasNext() == false) goto L29;
        Object r2 = r11.next();
        int r13 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        j r14 = (j) r2;
        ConstraintLayout r15 = new ConstraintLayout(r9);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams((int) r14.e().b().b(), (int) r14.e().b().a());
        r3.leftMargin = (int) r14.e().a().a();
        r3.topMargin = (int) r14.e().a().b();
        r18.addView(r15, r3);
        int r4 = o.a;
        o.a r5 = o.a(r9, (int) r14.d().b(), (int) r14.d().a(), TAG);
        int r6 = r5.a;
        int r7 = r5.b;
        ViewGroup.LayoutParams r8 = new ConstraintLayout.LayoutParams(r6, r7);
        ((ConstraintLayout.LayoutParams) r8).topToTop = r12;
        ((ConstraintLayout.LayoutParams) r8).startToStart = r12;
        ((ConstraintLayout.LayoutParams) r8).endToEnd = r12;
        LKUIRoundedImageView2 r16 = com.ss.android.lark.movable.attatchment.a.b(com.ss.android.lark.movable.attatchment.a.a, r18, r14.g(), r6, r7, "image_key");
        r16.setRadius(com.ss.android.lark.movable.utils.e.a(4));
        int r17 = View.generateViewId();
        r16.setId(r17);
        decorateImageView(r16, r18, r10, r0);
        r15.addView(r16, r8);
        if (r14.i() == false) goto L11;
        r16.setScaleType(ImageView.ScaleType.MATRIX);
        r16.addOnLayoutChangeListener(new b(this, r16));
        r15.addView(generateLongPhotoLabel(r9, r17));
    L11:
        TextView r20 = new TextView(r9);
        r20.setTextSize(12.0f);
        r20.setText(r14.b());
        r20.setTextColor(UDColorUtils.getColor(r9, 2131106607));
        r20.setPadding(com.ss.android.lark.movable.utils.e.a(8), com.ss.android.lark.movable.utils.e.a(3), com.ss.android.lark.movable.utils.e.a(8), com.ss.android.lark.movable.utils.e.a(3));
        boolean r21 = true;
        r20.setMaxLines(1);
        r20.setEllipsize(TextUtils.TruncateAt.END);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r22 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r14.g()), "lark_source"));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r22) == false) goto L19;
        r22 = null;
    L19:
        String r23 = (String) r22;
        if (r23 != null) goto L22;
    L25:
        if (r21 == false) goto L27;
        r20.setBackground(null);
    L28:
        ViewGroup.LayoutParams r24 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ConstraintLayout.LayoutParams) r24).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r24).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r24).endToEnd = 0;
        r15.addView(r20, r24);
        r0 = r13;
        r12 = 0;
        goto L4
    L27:
        r20.setBackgroundResource(2131244008);
        r20.setOnClickListener(new c(r18, r14));
        goto L28
    L22:
        if (r23.length() == 0) goto L25;
        r21 = false;
    L14:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    private final void decorateImageView(ImageView r4, com.ss.android.lark.movable.attatchment.d r5, List<j> r6, int r7) {
        if ((r4 instanceof LKUIRoundedImageView2) == false) goto L5;
        LKUIRoundedImageView2 r0 = (LKUIRoundedImageView2) r4;
        r0.setBorderWidthInDp(0.5f);
        r0.setBorderColor(UDColorUtils.getColor(r5.getContext(), 2131099926));
        r0.setRadius(com.ss.android.lark.movable.utils.e.a(4));
    L5:
        r4.setBackgroundColor(UDColorUtils.getColor(r5.getContext(), 2131099930));
        r4.setOnClickListener(new e(r5, r6, r7));
    }
}
