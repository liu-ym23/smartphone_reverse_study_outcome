package com.bytedance.android.live.livepkaudience.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.livepkaudience.list.e;
import com.bytedance.android.live.livepkaudience.list.g;
import com.bytedance.android.live.livepkaudience.list.n;
import com.bytedance.android.live.livepkaudience.list.o;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class PkStickHeaderDecoration extends RecyclerView.ItemDecoration {
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public final Rect d;
    public final boolean e;

    static {
        f = s1.f(32.0f);
        g = s1.f(16.0f);
        h = s1.f(60.0f);
        i = s1.f(14.0f);
    }

    public PkStickHeaderDecoration() {
        this.e = false;
        this.d = new Rect();
        this.e = false;
        Paint r0 = new Paint(1);
        this.a = r0;
        r0.setColor(-1);
        Paint r1 = new Paint(1);
        this.b = r1;
        float r2 = i;
        r1.setTextSize(r2);
        r1.setColor(ColorProtector.parseColor("#161823"));
        Paint r3 = new Paint(1);
        this.c = r3;
        r3.setTextSize(r2);
        r3.setColor(ColorProtector.parseColor("#57161823"));
    }

    public final String h(List<?> r3, int r4) {
        Object r0 = ListProtector.get(r3, r4);
        if ((r0 instanceof LinkPlayerInfo) == true) goto L20;
        if ((r0 instanceof o) == true) goto L20;
        if ((r0 instanceof n) == true) goto L20;
        if ((ListProtector.get(r3, r4) instanceof e) == false) goto L14;
        return s1.B(2131918037);
    L14:
        if ((ListProtector.get(r3, r4) instanceof g) == true) goto L16;
        return "";
    L16:
        return s1.B(2131918038);
    L20:
        return s1.B(2131918036);
    }

    public final boolean i(List<?> r4, int r5) {
        if (r5 == 0) goto L17;
        if (r5 >= r4.size()) goto L17;
        if ((ListProtector.get(r4, r5) instanceof LinkPlayerInfo) == false) goto L12;
        return !(ListProtector.get(r4, r5 - 1) instanceof LinkPlayerInfo);
    L12:
        if ((ListProtector.get(r4, r5) instanceof g) == true) goto L14;
        return false;
    L14:
        return !(ListProtector.get(r4, r5 - 1) instanceof g);
    L17:
        if (this.e == false) goto L19;
        return true;
    L19:
        return false;
    }

    public final void onDraw(Canvas r17, RecyclerView r18, RecyclerView.State r19) {
        if (r18.getAdapter() == null) goto L19;
        List<?> r9 = r18.getAdapter().a;
        int r10 = r18.getChildCount();
        int r12 = 0;
    L5:
        if (r12 >= r10) goto L23;
        View r13 = r18.getChildAt(r12);
        int r14 = r18.getChildLayoutPosition(r13);
        if (i(r9, r14) == false) goto L18;
        int r1 = r13.getTop();
        int r15 = f;
        r17.drawRect(0.0f, r1 - r15, r18.getWidth(), r13.getTop(), this.a);
        this.b.getTextBounds(h(r9, r14), 0, h(r9, r14).length(), this.d);
        String r2 = h(r9, r14);
        int r3 = g;
        r17.drawText(r2, r3, (r13.getTop() - (r15 / 2)) + (this.d.height() / 2), this.b);
        Object r4 = ListProtector.get(r9, r14);
        if ((r4 instanceof LinkPlayerInfo) == false) goto L11;
    L16:
        String r5 = "贡献排序";
    L17:
        r17.drawText(r5, (r13.getRight() - r3) - h, (r13.getTop() - (r15 / 2)) + (this.d.height() / 2), this.c);
        goto L18
    L11:
        if ((r4 instanceof o) == true) goto L16;
        if ((r4 instanceof n) == true) goto L16;
        r5 = "";
    L18:
        r12 = r12 + 1;
        goto L5
    L23:
        return;
    }

    public final void onDrawOver(Canvas r12, RecyclerView r13, RecyclerView.State r14) {
        if (r13.getAdapter() != null) goto L5;
        return;
    L5:
        if (r13.getLayoutManager() == null) goto L17;
        List<?> r15 = r13.getAdapter().a;
        int r0 = r13.getLayoutManager().findFirstVisibleItemPosition();
        if (r13.findViewHolderForAdapterPosition(r0) == null) goto L18;
        View r1 = r13.findViewHolderForAdapterPosition(r0).itemView;
        if (i(r15, r0 + 1) == false) goto L12;
        if (r0 == 0) goto L12;
        int r2 = f;
        int r4 = Math.min(r2, r1.getBottom());
        r12.drawRect(0.0f, r1.getTop() - r13.getWidth(), r13.getWidth(), r4, this.a);
        this.b.getTextBounds(h(r15, r0), 0, h(r15, r0).length(), this.d);
        r12.drawText(h(r15, r0), g, ((this.d.height() / 2) - (r2 / 2)) + r4, this.b);
    L14:
        r12.save();
        return;
    L12:
        if (r0 == 0) goto L14;
        float r7 = r13.getWidth();
        int r16 = f;
        r12.drawRect(0.0f, 0.0f, r7, r16, this.a);
        this.b.getTextBounds(h(r15, r0), 0, h(r15, r0).length(), this.d);
        r12.drawText(h(r15, r0), g, (r16 / 2) + (this.d.height() / 2), this.b);
        goto L14
    L18:
        return;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        if (r3.getAdapter() != null) goto L5;
        return;
    L5:
        if (i(r3.getAdapter().a, r3.getChildLayoutPosition(r2)) == false) goto L9;
        r1.top = f;
        return;
    }
}
