package com.larus.dora.obric.onboarding;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceType;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0011J(\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/obric/onboarding/BottomFadeImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fadeHeight", "", "maskPaint", "Landroid/graphics/Paint;", "bottomGradient", "Landroid/graphics/LinearGradient;", "bottomFadeEnabled", "", "showImage", "", "imageUrl", "", "fallbackResourceName", "setBottomFadeEnabled", "enabled", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateGradient", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomFadeImageView extends SimpleDraweeView {
    public final float a;
    public final Paint b;
    public LinearGradient c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public BottomFadeImageView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomFadeImageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        LinearGradient r0 = this.c;
        if (this.d == false) goto L10;
        if (r0 == null) goto L10;
        if (this.a <= 0.0f) goto L10;
        int r1 = r11.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super/*android.widget.ImageView*/.onDraw(r11);
        float r6 = getHeight() - Math.min(this.a, getHeight());
        this.b.setShader(r0);
        r11.drawRect(0.0f, r6, getWidth(), getHeight(), this.b);
        this.b.setShader(null);
        r11.restoreToCount(r1);
        return;
    L10:
        super/*android.widget.ImageView*/.onDraw(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBottomFadeEnabled(boolean r2) {
        if (this.d == r2) goto L6;
        this.d = r2;
        invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "fallbackResourceName");
        com.larus.dora.impl.resource.j0 r1 = com.larus.dora.impl.resource.j0.a;
        Context r0 = getContext();
        DoraResourceDeviceType r3 = DoraResourceDeviceType.G2;
        Uri r2 = com.larus.dora.impl.resource.j0.g(r1, r0, r3, DoraResourceType.DRAWABLE, r9);
        Drawable r10 = com.larus.dora.impl.resource.j0.f(r1, getContext(), r3, r9, null, 24);
        GenericDraweeHierarchy r4 = getHierarchy();
        ScalingUtils.ScaleType r5 = ScalingUtils.ScaleType.CENTER_CROP;
        r4.setPlaceholderImage(r10, r5);
        getHierarchy().setFailureImage(r10, r5);
        if (r8 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        ImageLoaderKt.s(this, r2, null);
        return;
    L11:
        ImageLoaderKt.u(this, r8, "dora_obric_onboarding_query_picture");
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomFadeImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = getResources().getDimension(2131167397);
        Paint r5 = new Paint(1);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.b = r5;
        this.d = true;
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        getHierarchy().setFadeDuration(100);
    }

    public /* synthetic */ BottomFadeImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r9, int r10, int r11, int r12) {
        super/*android.widget.ImageView*/.onSizeChanged(r9, r10, r11, r12);
        if (r9 <= 0) goto L7;
        if (r10 <= 0) goto L7;
        float r4 = r10;
        this.c = new LinearGradient(0.0f, r4 - Math.min(this.a, r4), 0.0f, r4, new int[]{-16777216, 0}, null, Shader.TileMode.CLAMP);
        return;
    L7:
        this.c = null;
    }
}
