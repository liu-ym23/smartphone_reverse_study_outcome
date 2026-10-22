package com.obric.miniapp.lynx;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public a(int r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = 4;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.Adapter r7 = r4.getAdapter();
        if (r7 == null) goto L5;
        int r8 = r7.getItemCount();
    L6:
        if (r6 != 0) goto L9;
        r2.top = 0;
        return;
    L9:
        if (r6 == (r8 - 1)) goto L11;
        r2.top = this.a;
        return;
    L11:
        if (r8 < this.c) goto L13;
        r2.top = this.b;
        return;
    L13:
        r2.top = this.a;
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
