package com.larus.business.multitask_management.impl.sheet;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.business.multitask_management.impl.component.OngoingTaskListAdapter;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J0\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmSheetItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "ongoingVerticalSpacingPx", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "applyHeaderSpacing", "localPosition", "absolutePosition", "adapter", "Lcom/larus/business/multitask_management/impl/sheet/MtmSectionHeaderAdapter;", "applyServiceSpacing", "Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter;", "applyListSpacing", "verticalSpacing", "applyGridSpacing", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MtmSheetItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public MtmSheetItemDecoration(int r2) {
        this.a = 2;
        this.b = r2;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        ConcatAdapter.a r9 = ConcatAdapter.y2(r7.getChildViewHolder(r6));
        if (r9 != null) goto L5;
        return;
    L5:
        RecyclerView.Adapter r10 = r9.a;
        int r11 = r9.b;
        int r12 = r9.c;
        if ((r10 instanceof MtmSectionHeaderAdapter) == false) goto L14;
        MtmSectionHeaderAdapter r13 = (MtmSectionHeaderAdapter) r10;
        if (r11 != r12) goto L11;
        if (r12 != 0) goto L11;
        int r14 = 0;
    L12:
        r5.set(0, r14, 0, 0);
        return;
    L11:
        r14 = r13.b;
        goto L12
    L14:
        if ((r10 instanceof MtmServiceSectionAdapter) == false) goto L29;
        MtmServiceSectionAdapter r15 = (MtmServiceSectionAdapter) r10;
        if (RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r15.c.c, this.a), 1) != 1) goto L22;
        int r16 = r15.c.g;
        if (r11 != r12) goto L21;
        if (r12 != 0) goto L21;
        r16 = 0;
    L21:
        r5.set(0, r16, 0, 0);
        return;
    L22:
        int r0 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r15.c.c, this.a), 1);
        com.larus.business.multitask_management.impl.component.j r17 = r15.c;
        int r3 = r17.f;
        if (r11 != r12) goto L26;
        if (r12 >= r0) goto L26;
        int r18 = 0;
    L27:
        int r19 = r11 % r0;
        float r4 = r3;
        float r1 = r0;
        r5.set(MathKt.roundToInt((r19 * r4) / r1), r18, MathKt.roundToInt(r4 - (((r19 + 1) * r4) / r1)), 0);
        return;
    L26:
        r18 = r17.g;
        goto L27
    L29:
        if ((r10 instanceof OngoingTaskListAdapter) == false) goto L39;
        int r20 = this.b;
        if (r11 != r12) goto L34;
        if (r12 != 0) goto L34;
        r20 = 0;
    L34:
        r5.set(0, r20, 0, 0);
        return;
    }
}
