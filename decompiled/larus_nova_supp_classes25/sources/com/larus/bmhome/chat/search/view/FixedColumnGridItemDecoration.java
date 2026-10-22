package com.larus.bmhome.chat.search.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/search/view/FixedColumnGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "marginStart", "", "spaceHorizontal", "spaceVertical", "marginEnd", "splitHorizontalSpacingAcrossSpans", "", "<init>", "(IIIIZ)V", "columnSize", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FixedColumnGridItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;

    public FixedColumnGridItemDecoration() {
        this(0, 0, 0, 0, 31);
    }

    public final void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        Intrinsics.checkNotNullParameter(r10, "outRect");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r13, "state");
        super.getItemOffsets(r10, r11, r12, r13);
        int r14 = r12.getChildAdapterPosition(r11);
        FLogger r15 = FLogger.a;
        r15.i("SearchListBox_Decoration", "position: " + r14 + ", outRect: " + r10);
        int r16 = this.f;
        boolean r4 = true;
        if ((r14 % r16) != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r14 < 0) goto L9;
        if (r14 >= r16) goto L9;
        boolean r6 = true;
    L11:
        if ((r14 % r16) == (r16 - 1)) goto L14;
        r4 = false;
    L14:
        int r17 = this.b;
        int r7 = r17 / 2;
        boolean r8 = this.e;
        if (r8 == false) goto L19;
        if (r3 == false) goto L18;
        int r5 = this.a;
    L22:
        if (r6 == false) goto L24;
        int r9 = 0;
    L25:
        if (r8 == false) goto L29;
        if (r4 == false) goto L28;
        int r18 = this.d;
    L32:
        r10.set(r5, r9, r18, 0);
        r15.i("SearchListBox_Decoration", "position: " + r14 + ", outRect: " + r10 + " after");
        return;
    L28:
        r18 = r17 - r7;
        goto L32
    L29:
        if (r4 == false) goto L31;
        r18 = this.d;
        goto L32
    L31:
        r18 = 0;
        goto L32
    L24:
        r9 = this.c;
        goto L25
    L18:
        r5 = r7;
        goto L22
    L19:
        if (r3 == false) goto L21;
        r5 = this.a;
        goto L22
    L21:
        r5 = r17;
    L9:
        r6 = false;
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    public FixedColumnGridItemDecoration(int r3, int r4, int r5, int r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 0;
    L14:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = false;
        this.f = 2;
    }
}
