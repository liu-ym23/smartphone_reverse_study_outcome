package com.ss.android.lark.contact.base.contact_list.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FloatingBarItemDecoration extends RecyclerView.ItemDecoration {
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public int d;
    public final int e;
    public final int f;
    public int g;
    public Map<Integer, String> h;
    public List<String> i;

    private FloatingBarItemDecoration() {
    }

    public final String h(int r3) {
    L2:
        if (r3 < 0) goto L8;
        if (this.h.containsKey(Integer.valueOf(r3)) == true) goto L6;
        r3 = r3 - 1;
        goto L2
    L6:
        return this.h.get(Integer.valueOf(r3));
    L8:
        return null;
    }

    public FloatingBarItemDecoration(Context r3, Map<Integer, String> r4) {
        this.d = UIUtils.dp2px(r3, 32.0f);
        Paint r0 = new Paint();
        this.a = r0;
        r0.setColor(ContextCompat.getColor(r3, 2131100548));
        Paint r1 = new Paint();
        this.c = r1;
        r1.setColor(ContextCompat.getColor(r3, 2131100545));
        Paint r2 = new Paint();
        this.b = r2;
        r2.setColor(ContextCompat.getColor(r3, 2131106607));
        r2.setTextSize(UIUtils.dp2px(r3, 14.0f));
        r2.setAntiAlias(true);
        Paint.FontMetrics r5 = r2.getFontMetrics();
        float r6 = r5.bottom;
        this.e = (int) (r6 - r5.top);
        this.f = (int) r6;
        this.g = UIUtils.dp2px(r3, 16.0f);
        this.i = new LinkedList(new LinkedHashSet(r4.values()));
        this.h = r4;
    }

    public final void onDraw(Canvas r20, RecyclerView r21, RecyclerView.State r22) {
        super.onDraw(r20, r21, r22);
        int r1 = r21.getPaddingLeft();
        int r2 = r21.getWidth() - r21.getPaddingRight();
        int r3 = r21.getChildCount();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L13;
        View r7 = r21.getChildAt(r5);
        RecyclerView.LayoutParams r8 = r7.getLayoutParams();
        int r9 = r8.getViewAdapterPosition();
        if (this.h.containsKey(Integer.valueOf(r9)) == false) goto L9;
        String r10 = this.h.get(Integer.valueOf(r9));
        int r11 = r7.getTop() - ((ViewGroup.MarginLayoutParams) r8).topMargin;
        r20.drawRect(r1, r11 - this.d, r2, r11, this.a);
        r20.drawText(r10, r7.getPaddingLeft() + this.g, (r11 - ((this.d - this.e) / 2)) - this.f, this.b);
    L9:
        if (this.h.containsKey(Integer.valueOf(r9 + 1)) == false) goto L12;
        int r4 = r7.getBottom() + ((ViewGroup.MarginLayoutParams) r8).bottomMargin;
        r20.drawRect(r1, r4, r2, 0 + r4, this.c);
    L12:
        r5 = r5 + 1;
        goto L3
    }

    public final void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        super.onDrawOver(r10, r11, r12);
        int r13 = r11.getLayoutManager().findFirstVisibleItemPosition();
        if (r13 != (-1)) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r0 = r11.findViewHolderForAdapterPosition(r13);
        if (r0 != null) goto L8;
        return;
    L8:
        View r1 = r0.itemView;
        String r2 = h(r13);
        if (r2 != null) goto L11;
        return;
    L11:
        ((LinkedList) this.i).indexOf(r2);
        boolean r3 = true;
        String r14 = h(r13 + 1);
        if (r14 != null) goto L14;
    L18:
        r3 = false;
    L19:
        r10.drawRect(r11.getPaddingLeft(), r11.getPaddingTop(), r11.getRight() - r11.getPaddingRight(), r11.getPaddingTop() + this.d, this.a);
        float r15 = r1.getPaddingLeft() + this.g;
        int r16 = r11.getPaddingTop();
        int r4 = this.d;
        r10.drawText(r2, r15, ((r16 + r4) - ((r4 - this.e) / 2)) - this.f, this.b);
        if (r3 == false) goto L23;
        r10.restore();
        return;
    L23:
        return;
    L14:
        if (TextUtils.equals(r2, r14) == true) goto L18;
        if (((r1.getHeight() + r1.getTop()) + 0) >= this.d) goto L18;
        r10.save();
        r10.translate(0.0f, ((r1.getHeight() + r1.getTop()) + 0) - this.d);
        goto L19
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r3.getLayoutParams().getViewAdapterPosition();
        if (this.h.containsKey(Integer.valueOf(r6)) == false) goto L5;
        int r7 = this.d;
    L6:
        this.h.containsKey(Integer.valueOf(r6 + 1));
        r2.set(0, r7, 0, 0);
        return;
    L5:
        r7 = 0;
        goto L6
    }
}
