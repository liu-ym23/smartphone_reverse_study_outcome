package com.bytedance.android.live.ktv.common.karaokestation;

import android.graphics.Rect;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.ktv.common.util.j;
import nb0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ItemExposureCheckHelper {
    public c a;
    public RecyclerView b;

    public static final class a {
    }

    static {
    }

    public ItemExposureCheckHelper() {
    }

    public final void a(boolean r13) {
        RecyclerView r1 = this.b;
        if (r1 != null) goto L5;
    L29:
        boolean r2 = true;
    L30:
        if (r13 == false) goto L33;
        if (r2 == false) goto L33;
        boolean r3 = true;
    L34:
        if (r3 == false) goto L75;
        return;
    L75:
        int[] r4 = new int[2];     // Catch: Exception -> L72
        RecyclerView r5 = this.b;     // Catch: Exception -> L72
        if (r5 == null) goto L40;
        RecyclerView.LayoutManager r6 = r5.getLayoutManager();     // Catch: Exception -> L72
    L42:
        if ((r6 instanceof GridLayoutManager) == false) goto L45;
        GridLayoutManager r7 = (GridLayoutManager) r6;     // Catch: Exception -> L72
        r4 = new int[]{r7.findFirstVisibleItemPosition(), r7.findLastVisibleItemPosition()};     // Catch: Exception -> L72
    L63:
        if (r4.length >= 2) goto L65;
        return;
    L65:
        j.j("ItemExposureCheckHelper", "handleCurrentVisibleItems ;; visible item ;;  start position == " + r4[0] + " ;;  end position == " + r4[1] + ' ');     // Catch: Exception -> L72
        int r8 = r4[0];     // Catch: Exception -> L72
        int r9 = r4[1];     // Catch: Exception -> L72
        if (r8 > r9) goto L84;
    L67:
        c r11 = this.a;     // Catch: Exception -> L72
        if (r11 == null) goto L70;
        r11.a(r8, r13);     // Catch: Exception -> L72
    L70:
        if (r8 == r9) goto L85;
        r8 = r8 + 1;
        goto L67
    L85:
        return;
    L84:
        return;
    L45:
        if ((r6 instanceof LinearLayoutManager) == false) goto L48;
        LinearLayoutManager r12 = (LinearLayoutManager) r6;     // Catch: Exception -> L72
        r4 = new int[]{r12.findFirstVisibleItemPosition(), r12.findLastVisibleItemPosition()};     // Catch: Exception -> L72
        goto L63
    L48:
        if ((r6 instanceof StaggeredGridLayoutManager) == false) goto L63;
        StaggeredGridLayoutManager r14 = (StaggeredGridLayoutManager) r6;     // Catch: Exception -> L72
        int r15 = r14.getSpanCount();     // Catch: Exception -> L72
        int[] r16 = new int[r15];     // Catch: Exception -> L72
        int r17 = r14.getSpanCount();     // Catch: Exception -> L72
        int[] r18 = new int[r17];     // Catch: Exception -> L72
        r14.findFirstVisibleItemPositions(r16);     // Catch: Exception -> L72
        r14.findLastVisibleItemPositions(r18);     // Catch: Exception -> L72
        int r19 = r16[0];     // Catch: Exception -> L72
        int r21 = r18[0];     // Catch: Exception -> L72
        int r110 = 1;
    L50:
        if (r110 >= r15) goto L55;
        int r111 = r16[r110];     // Catch: Exception -> L72
        if (r19 <= r111) goto L54;
        r19 = r111;
    L54:
        r110 = r110 + 1;     // Catch: Exception -> L72
        goto L50
    L55:
        int r22 = 1;
    L56:
        if (r22 >= r17) goto L61;
        int r23 = r18[r22];     // Catch: Exception -> L72
        if (r21 >= r23) goto L60;
        r21 = r23;
    L60:
        r22 = r22 + 1;     // Catch: Exception -> L72
        goto L56
    L61:
        r4 = new int[]{r19, r21};     // Catch: Exception -> L72
        goto L63
    L40:
        r6 = null;
    L72:
        e = move-exception;
        j.j("ItemExposureCheckHelper", "handleCurrentVisibleItems ;; error message == " + e.getMessage());
        return;
    L33:
        r3 = false;
        goto L34
    L5:
        if (r1.getVisibility() != 0) goto L29;
        RecyclerView r24 = this.b;
        if (r24 == null) goto L29;
        if (r24.isShown() != true) goto L29;
        RecyclerView r25 = this.b;
        Rect r26 = new Rect();
        if (r25 == null) goto L16;
        if (r25.getGlobalVisibleRect(r26) != true) goto L16;
    L25:
        boolean r27 = true;
    L26:
        if (r27 == false) goto L29;
        r2 = false;
    L16:
        if (r26.top != 0) goto L25;
        if (r26.bottom != 0) goto L25;
        if (r26.left != 0) goto L25;
        if (r26.right != 0) goto L25;
        r27 = false;
        goto L26
    }

    public final void b(RecyclerView r1, c r2) {
        this.a = r2;
        this.b = r1;
        if (r1 == null) goto L6;
        r1.addOnScrollListener(new ItemExposureCheckHelper$setRecyclerItemExposureListener$1(this));
        return;
    }
}
