package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECRingImageView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECRingImageView extends SimpleDraweeView {
    public final Path a;

    public ECRingImageView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ECRingImageView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        int r0 = getWidth();
        float r1 = r0 / 2.0f;
        int r11 = r0 - r0;
        r10.getClipBounds().inset(r11, r11);
        Path r12 = this.a;
        r12.reset();
        r12.addCircle(r1, r1, r0 / 2.0f, Path.Direction.CW);
        Unit r13 = Unit.INSTANCE;
        r10.clipPath(r12);
        super/*android.widget.ImageView*/.draw(r10);
    }

    public final void onMeasure(int r1, int r10) {
        super/*com.facebook.drawee.view.DraweeView*/.onMeasure(r1, r1);
    }

    public ECRingImageView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        new Paint().setAntiAlias(true);
        Unit r13 = Unit.INSTANCE;
        this.a = new Path();
    }

    public /* synthetic */ ECRingImageView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
