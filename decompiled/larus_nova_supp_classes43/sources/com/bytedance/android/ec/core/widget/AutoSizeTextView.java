package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/widget/AutoSizeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "baseTextSize", "", "setBaseTextSize", "", "maxWidth", "setViewMaxWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AutoSizeTextView extends AppCompatTextView {
    public float a;
    public int b;

    public AutoSizeTextView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public AutoSizeTextView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void setBaseTextSize(float r1) {
        this.a = r1;
    }

    public final void setViewMaxWidth(int r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r10, int r11) {
        if (this.b > 0) goto L5;
    L22:
        super.onMeasure(r10, r11);
        return;
    L5:
        if (TextViewCompat.getAutoSizeTextType(this) == 1) goto L22;
        int r0 = View.MeasureSpec.getMode(r10);
        int r12 = this.b;
        int r13 = Integer.MAX_VALUE;
        if (r0 != 0) goto L9;
        int r14 = Integer.MAX_VALUE;
    L10:
        int r15 = Math.min(r12, r14);
        if (View.MeasureSpec.getMode(r11) == 0) goto L14;
        r13 = View.MeasureSpec.getSize(r11);
    L14:
        float r1 = this.a;
        setTextSize(0, r1);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r11);
    L16:
        if (getMeasuredHeight() > r13) goto L20;
        if (getMeasuredWidth() > r15) goto L20;
        return;
    L20:
        if (r1 <= 0) goto L27;
        r1 = r1 - vf4.a.b(1);
        setTextSize(0, r1);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r11);
        goto L16
    L27:
        return;
    L9:
        r14 = View.MeasureSpec.getSize(r10);
        goto L10
    }

    public AutoSizeTextView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ AutoSizeTextView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
