package com.larus.common_ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import z19.e;
import z19.f;
import z19.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014JH\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0013J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/larus/common_ui/widget/CircleSimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "currentUrl", "", "getCurrentUrl", "()Ljava/lang/String;", "setCurrentUrl", "(Ljava/lang/String;)V", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "setAvatarUrl", "uri", "Landroid/net/Uri;", "lowResUri", "traceController", "Lcom/larus/common_ui/widget/ImageTraceController;", "imageExtra", "Lcom/larus/image/loader/ImageExtra;", "width", "height", "setGifRound", "placeHolder", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleSimpleDraweeView extends SimpleDraweeView {
    public static final /* synthetic */ int c = 0;
    public final Path a;
    public String b;

    public static final class a {
    }

    static {
    }

    public final String getCurrentUrl() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r2.clipPath(this.a);
        super/*android.widget.ImageView*/.onDraw(r2);
    }

    public final void setCurrentUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setGifRound(int r4) {
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        final ImageDecodeOptions r0 = ImageDecodeOptions.newBuilder().setForceStaticImage(true).build();
        ImageLoaderKt.y(this, "res://" + getContext().getPackageName() + '/' + r4, null, new f(this, r0), 6);
    }

    public CircleSimpleDraweeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new Path();
        this.b = "";
        RoundingParams r4 = RoundingParams.asCircle();
        getHierarchy().setRoundingParams(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super/*android.widget.ImageView*/.onSizeChanged(r2, r3, r4, r5);
        float r6 = Math.min(r2, r3) / 2.0f;
        this.a.reset();
        this.a.addCircle(r2 / 2.0f, r3 / 2.0f, r6, Path.Direction.CCW);
    }

    public static void f(final CircleSimpleDraweeView r12, Uri r13, Uri r14, k r15, int r16, int r17, int r18) {
        final ImageRequest r1 = null;
        if ((r18 & 2) == 0) goto L5;
        Uri r0 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        final k r3 = null;
    L10:
        int r4 = 0;
        if ((r18 & 16) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r18 & 32) != 0) goto L18;
        r4 = r17;
    L18:
        r12.getClass();
        if (r13 == null) goto L33;
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        if (Intrinsics.areEqual(StringsKt.substringBeforeLast$default(r13.toString(), "&x-signature=", null, 2, null), StringsKt.substringBeforeLast$default(r12.b, "&x-signature=", null, 2, null)) == true) goto L34;
        r12.b = r13.toString();
        final ImageDecodeOptions r8 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        if (r0 == null) goto L31;
        ImageRequestBuilder r6 = ImageRequestBuilder.newBuilderWithSource(r0).setImageDecodeOptions(r8);
        if (r2 == 0) goto L30;
        if (r4 == 0) goto L30;
        r6.setResizeOptions(new ResizeOptions(r2, r4));
    L30:
        r1 = r6.build();
    L31:
        ImageLoaderKt.x(r12, r13, null, null, new e(r1, r8, r3, r5, r12), 2);
        return;
    L34:
        return;
    L33:
        return;
    L13:
        r2 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L10
    L5:
        r0 = r14;
        goto L7
    }
}
