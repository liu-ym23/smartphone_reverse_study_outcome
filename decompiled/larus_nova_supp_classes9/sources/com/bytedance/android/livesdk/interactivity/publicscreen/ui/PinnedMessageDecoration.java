package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class PinnedMessageDecoration extends RecyclerView.ItemDecoration {
    public com.bytedance.android.livesdk.interactivity.publicscreen.pin.c a;

    public PinnedMessageDecoration() {
    }

    public final void onDrawOver(Canvas r1, RecyclerView r2, RecyclerView.State r3) {
        super.onDrawOver(r1, r2, r3);
        if (this.a == null) goto L12;
        View r4 = r2.getChildAt(0);
        if (r4 != null) goto L7;
        return;
    L7:
        int r5 = u42.g.a;
        Intrinsics.checkNotNullParameter(r4, "view");
        Object r6 = r4.getTag(2131389712);
        if ((r6 instanceof u42.b) == true) goto L10;
        r6 = null;
    L10:
        com.bytedance.android.livesdk.interactivity.publicscreen.pin.c r7 = this.a;
        r7.a((u42.b) r6);
        return;
    }
}
