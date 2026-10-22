package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "a", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class MaxHeightRecyclerView extends RecyclerView {
    public int a;

    public MaxHeightRecyclerView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public MaxHeightRecyclerView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    public final int getMaxHeight() {
        return this.a;
    }

    public final void setMaxHeight(int r1) {
        this.a = r1;
    }

    public final void onMeasure(int r10, int r11) {
        int r0 = this.a;
        if (r0 < 0) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE);
    L5:
        super.onMeasure(r10, r11);
    }

    public MaxHeightRecyclerView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = -1;
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{2130972696});
        this.a = r13.getDimensionPixelSize(0, -1);     // Catch: Throwable -> L6
        r13.recycle();
        return;
    L6:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    public /* synthetic */ MaxHeightRecyclerView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
