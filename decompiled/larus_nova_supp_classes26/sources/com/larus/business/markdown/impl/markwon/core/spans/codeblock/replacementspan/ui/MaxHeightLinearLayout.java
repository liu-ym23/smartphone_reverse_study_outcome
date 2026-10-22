package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/ui/MaxHeightLinearLayout;", "Landroid/widget/LinearLayout;", "", "value", "a", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final class MaxHeightLinearLayout extends LinearLayout {
    public int a;

    public static final class a {
    }

    static {
    }

    public MaxHeightLinearLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MaxHeightLinearLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int getMaxHeight() {
        return this.a;
    }

    public final void setMaxHeight(int r2) {
        if (this.a == r2) goto L6;
        this.a = r2;
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r5);
        if (getMaxHeight() != (-1)) goto L5;
    L12:
        super.onMeasure(r4, r5);
        return;
    L5:
        if (r0 == 1073741824) goto L12;
        if (getMaxHeight() != Integer.MAX_VALUE) goto L10;
        int r6 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
    L11:
        super.onMeasure(r4, r6);
        return;
    L10:
        r6 = View.MeasureSpec.makeMeasureSpec(getMaxHeight(), Integer.MIN_VALUE);
        goto L11
    }

    public MaxHeightLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = Integer.MAX_VALUE;
    }

    public /* synthetic */ MaxHeightLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
