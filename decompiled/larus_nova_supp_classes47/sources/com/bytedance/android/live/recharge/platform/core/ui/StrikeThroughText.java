package com.bytedance.android.live.recharge.platform.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/ui/StrikeThroughText;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "enable", "", "setDrawLineEnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrikeThroughText extends AppCompatTextView {
    public final Paint a;
    public int b;
    public boolean c;

    public StrikeThroughText(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.c == false) goto L5;
        r8.drawLine(0.0f, getHeight() / 2.0f, getWidth(), getHeight() / 2.0f, this.a);
    L5:
        super/*android.widget.TextView*/.onDraw(r8);
    }

    public final void setDrawLineEnable(boolean r1) {
        this.c = r1;
    }

    public StrikeThroughText(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public StrikeThroughText(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        this.a = r5;
        Paint.Cap r6 = Paint.Cap.ROUND;
        this.c = true;
        r5.setColor(this.b);
        r5.setStrokeCap(r5.getStrokeCap());
        r5.setStrokeWidth(r5.getStrokeWidth());
    }
}
