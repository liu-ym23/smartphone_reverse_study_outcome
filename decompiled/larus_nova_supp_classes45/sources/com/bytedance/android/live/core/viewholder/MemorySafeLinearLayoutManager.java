package com.bytedance.android.live.core.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/viewholder/MemorySafeLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MemorySafeLinearLayoutManager extends LinearLayoutManager {
    public final void onDetachedFromWindow(RecyclerView r3, RecyclerView.Recycler r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super.onDetachedFromWindow(r3, r4);
        RecyclerView.Adapter r5 = r3.getAdapter();
        if (r5 == null) goto L10;
        int r6 = r5.getItemCount() - 1;
    L5:
        if (r6 < 0) goto L14;
        RecyclerView.ViewHolder r0 = r3.findViewHolderForAdapterPosition(r6);
        if ((r0 instanceof BaseViewHolder) == false) goto L9;
        ((BaseViewHolder) r0).unbind();
    L9:
        r6 = r6 - 1;
        goto L5
    L14:
        return;
    }

    public MemorySafeLinearLayoutManager(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4, r5);
    }
}
