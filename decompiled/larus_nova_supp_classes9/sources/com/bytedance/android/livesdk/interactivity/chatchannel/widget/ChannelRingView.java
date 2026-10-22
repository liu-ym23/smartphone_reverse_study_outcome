package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChannelRingView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelRingView extends View {
    public final float a;
    public float b;
    public float c;
    public final Paint d;

    public ChannelRingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelRingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        this.b = (getWidth() / 2) - (this.a / 2);
        r5.drawCircle(getWidth() / 2, getWidth() / 2, this.b, this.d);
    }

    public ChannelRingView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.c = 1.0f;
        Paint r7 = new Paint(1);
        this.d = r7;
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130973806, 2130973807});
        float r9 = r8.getDimensionPixelSize(1, s1.f(2.0f));
        this.a = r9;
        int r10 = r8.getColor(0, ColorProtector.parseColor("#161823"));
        r7.setStyle(Paint.Style.STROKE);
        r7.setStrokeWidth(r9 * this.c);
        r7.setColor(r10);
        r7.setAntiAlias(true);
    }

    public /* synthetic */ ChannelRingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
