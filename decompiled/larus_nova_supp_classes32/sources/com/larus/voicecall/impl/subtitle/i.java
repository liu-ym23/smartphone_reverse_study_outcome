package com.larus.voicecall.impl.subtitle;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends RecyclerView.ItemDecoration {
    public final Paint a;

    public i() {
        Paint r0 = new Paint(1);
        r0.setColor(ColorProtector.parseColor("#CCCCCC"));
        this.a = r0;
    }

    public final void onDrawOver(Canvas r12, RecyclerView r13, RecyclerView.State r14) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r14, "state");
        RecyclerView.Adapter r15 = r13.getAdapter();
        if (r15 == null) goto L5;
        int r16 = r15.getItemCount();
    L7:
        if (r16 > 8) goto L9;
        return;
    L9:
        int r17 = r13.computeVerticalScrollRange();
        int r1 = r13.computeVerticalScrollExtent();
        if (r17 <= r1) goto L18;
        if (r1 <= 0) goto L19;
        int r18 = r17 - r1;
        int r0 = RangesKt.coerceIn(r13.computeVerticalScrollOffset(), 0, r18);
        float r2 = i5.z();
        float r3 = r13.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971273, r13.getContext(), 2131166915));
        float r4 = i5.z();
        float r5 = i5.E();
        float r6 = RangesKt.coerceAtLeast((r13.getHeight() - r5) - r3, r5);
        if (r18 <= 0) goto L16;
        r5 = r5 + (((r6 - r5) * r0) / r18);
    L16:
        float r7 = r5;
        float r8 = r13.getWidth() - r4;
        r12.drawRect(r8 - r2, r7, r8, r7 + r3, this.a);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r16 = 0;
        goto L7
    }
}
