package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/common/MinMaxWidthLinearLayout;", "Landroid/widget/LinearLayout;", "", "minWidthPx", "", "setMinWidth", "maxWidthPx", "setMaxWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MinMaxWidthLinearLayout extends LinearLayout {
    public int a;

    public MinMaxWidthLinearLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MinMaxWidthLinearLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setMaxWidth(int r1) {
        this.a = r1;
    }

    public final void setMinWidth(int r1) {
        setMinimumWidth(r1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        if (this.a <= 0) goto L8;
        int r0 = View.MeasureSpec.getMode(r4);
        int r1 = View.MeasureSpec.getSize(r4);
        int r2 = this.a;
        if (r2 <= 0) goto L8;
        if (r1 <= r2) goto L8;
        r4 = View.MeasureSpec.makeMeasureSpec(r2, r0);
    L8:
        super.onMeasure(r4, r5);
    }

    public MinMaxWidthLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ MinMaxWidthLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
