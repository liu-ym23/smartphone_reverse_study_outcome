package com.larus.community.impl.quickmenu;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/community/impl/quickmenu/QuickMenuItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalSpacing", "", "verticalSpacing", "includeEdge", "", "<init>", "(IIZ)V", "spacing", "(IZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setGridItemOffsets", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "setLinearItemOffsets", "Landroidx/recyclerview/widget/LinearLayoutManager;", "setDefaultItemOffsets", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickMenuItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final boolean c;

    public static final class a {
    }

    static {
    }

    public QuickMenuItemDecoration() {
        this(0, 0, false);
    }

    public QuickMenuItemDecoration(int r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        GridLayoutManager r9 = r7.getLayoutManager();
        int r2 = 0;
        if ((r9 instanceof GridLayoutManager) == false) goto L20;
        GridLayoutManager r10 = r9;
        int r11 = r7.getChildAdapterPosition(r6);
        if (r11 == (-1)) goto L82;
        int r12 = r10.getSpanCount();
        int r0 = r11 % r12;
        RecyclerView.Adapter r13 = r7.getAdapter();
        if (r13 == null) goto L10;
        r2 = r13.getItemCount();
    L10:
        int r14 = r11 / r12;
        int r3 = ((r2 + r12) - 1) / r12;
        if (this.c == false) goto L16;
        int r15 = this.a;
        r5.left = r15 - ((r0 * r15) / r12);
        r5.right = ((r0 + 1) * r15) / r12;
        if (r14 != 0) goto L15;
        r5.top = this.b;
    L15:
        r5.bottom = this.b;
        return;
    L16:
        int r16 = this.a;
        r5.left = (r0 * r16) / r12;
        r5.right = r16 - (((r0 + 1) * r16) / r12);
        if (r14 <= 0) goto L73;
        r5.top = this.b;
        return;
    L73:
        return;
    L82:
        return;
    L20:
        if ((r9 instanceof LinearLayoutManager) == false) goto L55;
        LinearLayoutManager r17 = (LinearLayoutManager) r9;
        int r18 = r7.getChildAdapterPosition(r6);
        if (r18 == (-1)) goto L83;
        RecyclerView.Adapter r20 = r7.getAdapter();
        if (r20 == null) goto L28;
        r2 = r20.getItemCount();
    L28:
        if (r17.getOrientation() != 1) goto L43;
        if (this.c == false) goto L40;
        int r21 = this.a;
        r5.left = r21;
        r5.right = r21;
        int r22 = this.b;
        if (r18 != 0) goto L34;
        int r23 = r22;
    L35:
        r5.top = r23;
        if (r18 == (r2 - 1)) goto L39;
        r22 = r22 / 2;
    L39:
        r5.bottom = r22;
        return;
    L34:
        r23 = r22 / 2;
        goto L35
    L40:
        if (r18 <= 0) goto L76;
        r5.top = this.b;
        return;
    L76:
        return;
    L43:
        if (this.c == false) goto L53;
        int r24 = this.b;
        r5.top = r24;
        r5.bottom = r24;
        int r25 = this.a;
        if (r18 != 0) goto L47;
        int r26 = r25;
    L48:
        r5.left = r26;
        if (r18 == (r2 - 1)) goto L52;
        r25 = r25 / 2;
    L52:
        r5.right = r25;
        return;
    L47:
        r26 = r25 / 2;
        goto L48
    L53:
        if (r18 <= 0) goto L79;
        r5.left = this.a;
        return;
    L79:
        return;
    L83:
        return;
    L55:
        int r27 = r7.getChildAdapterPosition(r6);
        if (r27 == (-1)) goto L84;
        RecyclerView.Adapter r28 = r7.getAdapter();
        if (r28 == null) goto L62;
        r28.getItemCount();
    L62:
        if (this.c == false) goto L64;
        int r30 = this.a;
        int r31 = this.b;
        r5.set(r30, r31, r30, r31);
        return;
    L64:
        if (r27 <= 0) goto L66;
        int r32 = this.b;
    L67:
        r5.top = r32;
        if (r27 <= 0) goto L70;
        r2 = this.a;
    L70:
        r5.left = r2;
        return;
    L66:
        r32 = 0;
        goto L67
    }
}
