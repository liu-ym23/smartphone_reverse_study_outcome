package com.larksuite.framework.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class DividerDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final Paint d;

    public static class a {
        public final Resources a;
        public int b;
        public int c;

        public a(Context r3) {
            this.a = r3.getResources();
            Resources r4 = r3.getResources();
            this.b = (int) TypedValue.applyDimension(0, 1.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
            this.c = -16777216;
        }
    }

    public DividerDecoration(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = 0;
        Paint r4 = new Paint();
        this.d = r4;
        r4.setColor(r3);
    }

    public final void onDrawOver(Canvas r13, RecyclerView r14, RecyclerView.State r15) {
        int r16 = r14.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r16) goto L5;
        View r1 = r14.getChildAt(r0);
        int r2 = r1.getBottom();
        int r3 = this.a + r2;
        int r4 = r1.getLeft() + this.b;
        int r5 = r1.getRight() - this.c;
        int r6 = (int) (r1.getTranslationY() + 0.5f);
        r13.save();
        r13.drawRect(r4, r2 + r6, r5, r3 + r6, this.d);
        r13.restore();
        r0 = r0 + 1;
        goto L3
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        r1.set(0, 0, 0, this.a);
    }
}
