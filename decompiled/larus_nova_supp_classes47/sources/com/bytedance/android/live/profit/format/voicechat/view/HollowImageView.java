package com.bytedance.android.live.profit.format.voicechat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/HollowImageView;", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HollowImageView extends ImageView {
    public final Path a;
    public final Paint b;
    public float c;
    public float d;
    public final float e;

    public HollowImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HollowImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        int r0 = r4.save();
        super.onDraw(r4);     // Catch: Throwable -> L6
        r4.drawPath(this.a, this.b);     // Catch: Throwable -> L6
        r4.restoreToCount(r0);
        return;
    L6:
        th = move-exception;
        r4.restoreToCount(r0);
        throw th;
    }

    public HollowImageView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = new Path();
        Paint r7 = new Paint(1);
        r7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Unit r1 = Unit.INSTANCE;
        this.b = r7;
        setLayerType(1, null);
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130970260}, 0, 0);
        this.e = r8.getDimension(0, 0.0f);
        r8.recycle();
    }

    public /* synthetic */ HollowImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super.onSizeChanged(r2, r3, r4, r5);
        this.c = r2 / 2.0f;
        this.d = r3 / 2.0f;
        this.a.reset();
        this.a.addCircle(this.c, this.d, this.e, Path.Direction.CW);
    }
}
