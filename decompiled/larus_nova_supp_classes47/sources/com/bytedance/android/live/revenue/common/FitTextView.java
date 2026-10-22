package com.bytedance.android.live.revenue.common;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.LiveTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revenue/common/FitTextView;", "Lcom/bytedance/android/live/core/widget/LiveTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FitTextView extends LiveTextView {
    public final Paint c;
    public final float d;
    public final float e;

    public FitTextView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FitTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        TextPaint r3 = new TextPaint();
        this.c = r3;
        this.e = 6.0f;
        r3.set(getPaint());
        this.d = getTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r2, TextView.BufferType r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "type");
        super/*android.widget.TextView*/.setText(r2, r3);
        y(r2.toString(), getWidth());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(String r4, int r5) {
        if (r5 <= 0) goto L14;
        int r6 = (r5 - getPaddingLeft()) - getPaddingRight();
        float r0 = this.d;
        this.c.setTextSize(r0);
    L5:
        if (this.c.measureText(r4) <= r6) goto L10;
        r0 = r0 - 1.0f;
        float r1 = this.e;
        if (r0 <= r1) goto L8;
        this.c.setTextSize(r0);
        goto L5
    L8:
        r0 = r1;
    L10:
        setTextSize(0, r0);
        return;
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        if (r1 == r3) goto L5;
        y(getText().toString(), r1);
        return;
    }
}
