package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public a0(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.Adapter r7 = r4.getAdapter();
        if (r7 == null) goto L5;
        int r8 = r7.getItemCount();
    L6:
        if (r6 != 0) goto L9;
        r2.top = this.a;
    L9:
        if (r6 != (r8 - 1)) goto L11;
        r2.bottom = this.c;
        return;
    L11:
        r2.bottom = this.b;
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
