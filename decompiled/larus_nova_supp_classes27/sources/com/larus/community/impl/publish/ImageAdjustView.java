package com.larus.community.impl.publish;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.larus.community.impl.databinding.LarusCommunityCreationImageAdjustLayoutBinding;
import com.larus.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cJ0\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0006\u0010&\u001a\u00020\u0013J\"\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/community/impl/publish/ImageAdjustView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationImageAdjustLayoutBinding;", "currentBitmap", "Landroid/graphics/Bitmap;", "currentBitmapReference", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "lastMaxHeight", "bindImageUrl", "", "imageUrl", "", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "showVideoPlayIcon", "", "bindRefImageUrl", "refImageUrls", "", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDestroy", "adjustImageViewSize", "bitmap", "maxWidth", "maxHeight", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageAdjustView extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final LarusCommunityCreationImageAdjustLayoutBinding a;
    public Bitmap b;
    public CloseableReference<CloseableImage> c;
    public int d;

    public ImageAdjustView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageAdjustView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageAdjustView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131561942, this);
        int r5 = 2131375096;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131375096);
        if (r6 == null) goto L11;
        r5 = 2131375098;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(this, 2131375098);
        if (r7 == null) goto L11;
        r5 = 2131392347;
        ImageView r0 = (ImageView) ViewBindings.findChildViewById(this, 2131392347);
        if (r0 == null) goto L11;
        this.a = new LarusCommunityCreationImageAdjustLayoutBinding(this, r6, r7, r0);
        w0.e(r6, i5.h());
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public final void R5(final Bitmap r6, final int r7, final int r8) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L12;
        m29.a.c("ImageAdjustView", "bitmap?.isRecycled");
        return;
    L12:
        this.d = r8;
        m29.a.a("ImageAdjustView", new a0(r7, r8));
        if (r6 != null) goto L15;
    L35:
        ImageView r1 = this.a.b;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        r3.width = r7;
        r3.height = r8;
        r1.setLayoutParams(r3);
        SimpleDraweeView r4 = this.a.c;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        int r9 = r7 / 4;
        r5.width = r9;
        r5.height = r9;
        r4.setLayoutParams(r5);
        m29.a.a("ImageAdjustView", new e0(r6, r7, r8));
        return;
    L15:
        if (r6.getWidth() != 0) goto L17;
    L21:
        if (r0 == false) goto L23;
        Bitmap r10 = r6;
    L24:
        if (r10 == null) goto L35;
        final Ref.FloatRef r11 = new Ref.FloatRef();
        float r12 = r10.getWidth() / r10.getHeight();
        r11.element = r12;
        if (r12 >= 0.33333334f) goto L29;
        r11.element = 0.33333334f;
    L31:
        float r13 = r7;
        float r14 = r8;
        final float r15 = r13 / r14;
        m29.a.a("ImageAdjustView", new b0(r11, r15));
        float r16 = r11.element;
        if (r16 <= r15) goto L34;
        final int r17 = (int) (r13 / r16);
        ImageView r18 = this.a.b;
        ViewGroup.LayoutParams r20 = r18.getLayoutParams();
        r20.width = r7;
        r20.height = r17;
        r18.setLayoutParams(r20);
        SimpleDraweeView r21 = this.a.c;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        r22.width = RangesKt.coerceAtMost(r7, r17) / 4;
        r22.height = RangesKt.coerceAtMost(r7, r17) / 4;
        r21.setLayoutParams(r22);
        m29.a.a("ImageAdjustView", new c0(r7, r17));
        return;
    L34:
        final int r23 = (int) (r14 * r16);
        ImageView r24 = this.a.b;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        r25.width = r23;
        r25.height = r8;
        r24.setLayoutParams(r25);
        SimpleDraweeView r26 = this.a.c;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        r27.width = RangesKt.coerceAtMost(r23, r8) / 4;
        r27.height = RangesKt.coerceAtMost(r23, r8) / 4;
        r26.setLayoutParams(r27);
        m29.a.a("ImageAdjustView", new d0(r23, r8));
        return;
    L29:
        if (r12 <= 3.0f) goto L31;
        r11.element = 3.0f;
        goto L31
    L23:
        r10 = null;
        goto L24
    L17:
        if (r6.getHeight() == 0) goto L21;
        if (r8 == 0) goto L21;
        if (r7 == 0) goto L21;
        r0 = true;
        goto L21
    L5:
        if (r6.isRecycled() != true) goto L7;
        r2 = true;
        goto L9
    }

    public /* synthetic */ ImageAdjustView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (getHeight() != this.d) goto L6;
        m29.a.a("ImageAdjustView", new z(this));
        return;
    L6:
        R5(this.b, getWidth(), getHeight());
    }
}
