package com.larus.bmhome.chat.standarduikit.search.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/search/view/ColumnGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "columnSize", "", "marginStart", "spaceHorizontal", "spaceVertical", "marginTop", "marginEnd", "marginBottom", "<init>", "(IIIIIII)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnGridItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public ColumnGridItemDecoration() {
        this(2, 0, 0, 0, 0, 0, 0);
    }

    public final void getItemOffsets(Rect r11, View r12, RecyclerView r13, RecyclerView.State r14) {
        Intrinsics.checkNotNullParameter(r11, "outRect");
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r14, "state");
        super.getItemOffsets(r11, r12, r13, r14);
        int r15 = r13.getChildAdapterPosition(r12);
        if (r15 != (-1)) goto L6;
        r11.setEmpty();
        return;
    L6:
        boolean r0 = true;
        int r16 = RangesKt.coerceAtLeast(this.a, 1);
        FLogger r1 = FLogger.a;
        r1.i("PureVideoView", "position: " + r15 + ", outRect: " + r11);
        int r2 = r15 % r16;
        int r6 = 0;
        if (r2 != 0) goto L9;
        boolean r7 = true;
    L10:
        if (r15 < 0) goto L13;
        if (r15 >= r16) goto L13;
        boolean r8 = true;
    L15:
        if (r2 != (r16 - 1)) goto L17;
        boolean r3 = true;
    L19:
        if (r14.getItemCount() <= 0) goto L21;
        int r17 = ((r14.getItemCount() - 1) / r16) * r16;
    L22:
        if (r15 >= r17) goto L25;
        r0 = false;
    L25:
        if (r7 == false) goto L27;
        int r18 = this.b;
    L28:
        if (r8 == false) goto L30;
        int r19 = this.e;
    L31:
        if (r3 == false) goto L33;
        int r4 = this.f;
    L34:
        if (r0 == false) goto L36;
        r6 = this.g;
    L36:
        r11.set(r18, r19, r4, r6);
        r1.i("PureVideoView", "position: " + r15 + ", outRect: " + r11 + " after");
        return;
    L33:
        r4 = 0;
        goto L34
    L30:
        r19 = this.d;
        goto L31
    L27:
        r18 = this.c;
        goto L28
    L21:
        r17 = 0;
        goto L22
    L17:
        r3 = false;
    L13:
        r8 = false;
        goto L15
    L9:
        r7 = false;
        goto L10
    }

    public ColumnGridItemDecoration(int r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
