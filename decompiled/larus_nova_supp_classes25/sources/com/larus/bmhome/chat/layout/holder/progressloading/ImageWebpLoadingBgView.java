package com.larus.bmhome.chat.layout.holder.progressloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/ImageWebpLoadingBgView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawPartType", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ImageLoadingDrawPartType;", "isDrawPartMode", "", "matrix", "Landroid/graphics/Matrix;", "init", "", "loadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "bizType", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImageWebpLoadingBgView extends SimpleDraweeView {
    public static final /* synthetic */ int d = 0;
    public ImageLoadingDrawPartType a;
    public boolean b;
    public final Matrix c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageLoadingDrawPartType.values().length];
            r0[ImageLoadingDrawPartType.LEFT_TOP_PART.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ImageLoadingDrawPartType.RIGHT_TOP_PART.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ImageLoadingDrawPartType.LEFT_BOTTOM_PART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ImageLoadingDrawPartType.RIGHT_BOTTOM_PART.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ ImageWebpLoadingBgView a;
        public final /* synthetic */ e b;

        public c(ImageWebpLoadingBgView r1, e r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailure(String r3, Throwable r4) {
            super.onFailure(r3, r4);
            FLogger.a.e("ImageWebpLoadingBgView", "load webp fail " + r4);
            this.a.setActualImageResource(((e.b) this.b).b);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            Intrinsics.checkNotNullParameter(r1, "id");
            if (r3 == null) goto L6;
            r3.start();
            return;
        }
    }

    static {
    }

    public ImageWebpLoadingBgView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageWebpLoadingBgView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        if (this.b == false) goto L22;
        int r0 = r7.getWidth();
        int r1 = r7.getHeight();
        Matrix r2 = this.c;
        r2.reset();
        r2.postScale(2.0f, 2.0f);
        ImageLoadingDrawPartType r3 = this.a;
        if (r3 != null) goto L7;
        int r4 = -1;
    L9:
        if (r4 != 1) goto L11;
        r2.postTranslate(0.0f, 0.0f);
    L21:
        r7.save();
        r7.concat(this.c);
        getDrawable().draw(r7);
        r7.restore();
        return;
    L11:
        if (r4 != 2) goto L13;
        r2.postTranslate(-r0, 0.0f);
        goto L21
    L13:
        if (r4 != 3) goto L15;
        r2.postTranslate(0.0f, -r1);
        goto L21
    L15:
        if (r4 != 4) goto L21;
        r2.postTranslate(-r0, -r1);
        goto L21
    L7:
        r4 = b.a[r3.ordinal()];
        goto L9
    L22:
        super/*android.widget.ImageView*/.onDraw(r7);
    }

    public ImageWebpLoadingBgView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new Matrix();
    }

    public /* synthetic */ ImageWebpLoadingBgView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(final e r7, boolean r8, ImageLoadingDrawPartType r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "loadingResource");
        Intrinsics.checkNotNullParameter(r10, "bizType");
        this.b = r8;
        this.a = r9;
        if (r8 == false) goto L5;
        ImageView.ScaleType r11 = ImageView.ScaleType.MATRIX;
    L6:
        setScaleType(r11);
        if ((r7 instanceof e.a) == false) goto L10;
        setActualImageResource(((e.a) r7).a);
        return;
    L10:
        if ((r7 instanceof e.b) == false) goto L14;
        setAlpha(0.7f);
        ImageLoaderKt.x(this, Uri.fromFile(new PolarisFileWrapper(((e.b) r7).a)), r10, null, new d(this, r7), 4);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r11 = ImageView.ScaleType.CENTER_CROP;
        goto L6
    }
}
