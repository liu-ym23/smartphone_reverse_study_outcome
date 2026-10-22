package com.larus.bmhome.view.actionbar.custom.actionbarpanel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J0\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/ActionBarGridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalSpacing", "", "verticalSpacing", "topOrBottomVerticalSpacing", "edgeEnabled", "", "<init>", "(IIIZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "makeGridSpacing", "position", "itemCount", "orientation", "spanCount", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarGridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;

    public static final class a {
    }

    static {
    }

    public ActionBarGridSpacingItemDecoration(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = true;
    }

    public final void getItemOffsets(Rect r7, View r8, RecyclerView r9, RecyclerView.State r10) {
        Intrinsics.checkNotNullParameter(r7, "outRect");
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "state");
        GridLayoutManager r0 = r9.getLayoutManager();
        if ((r0 instanceof GridLayoutManager) == false) goto L43;
        int r11 = r9.getChildAdapterPosition(r8);
        int r12 = r10.getItemCount();
        GridLayoutManager r1 = r0;
        int r13 = r1.getOrientation();
        int r2 = r1.getSpanCount();
        if ((r12 % r2) != 0) goto L7;
        int r14 = r12 / r2;
    L8:
        if (r13 != 0) goto L10;
        int r3 = r11 / r2;
    L11:
        if (r13 != 0) goto L13;
        int r15 = r11 % r2;
    L14:
        int r4 = 0;
        if (r15 != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r13 != 0) goto L23;
        if (r15 == (r2 - 1)) goto L24;
    L25:
        boolean r16 = false;
    L26:
        boolean r17 = this.d;
        int r18 = this.a;
        if (r17 == false) goto L29;
        int r6 = (r2 - r3) * r18;
    L30:
        r7.left = r6 / r2;
        if (r5 == false) goto L33;
        int r19 = this.c;
    L34:
        r7.top = r19;
        if (r17 == false) goto L37;
        int r110 = (r18 * (r3 + 1)) / r2;
    L38:
        r7.right = r110;
        if (r16 == false) goto L41;
        r4 = this.c;
    L41:
        r7.bottom = r4;
        return;
    L37:
        r110 = (r18 * (r2 - (r3 + 1))) / r2;
        goto L38
    L33:
        r19 = this.b;
        goto L34
    L29:
        r6 = r18 * r3;
    L24:
        r16 = true;
        goto L26
    L23:
        if (r15 != (r14 - 1)) goto L25;
    L17:
        r5 = false;
        goto L18
    L13:
        r15 = r11 / r2;
        goto L14
    L10:
        r3 = r11 % r2;
        goto L11
    L7:
        r14 = (r12 / r2) + 1;
        goto L8
    }
}
