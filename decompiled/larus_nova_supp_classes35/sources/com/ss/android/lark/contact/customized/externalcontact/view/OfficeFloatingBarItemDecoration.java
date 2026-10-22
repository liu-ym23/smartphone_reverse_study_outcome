package com.ss.android.lark.contact.customized.externalcontact.view;

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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class OfficeFloatingBarItemDecoration extends RecyclerView.ItemDecoration {
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public int d;
    public final int e;
    public final int f;
    public int g;
    public final int h;
    public Map<Integer, String> i;
    public List<String> j;

    private OfficeFloatingBarItemDecoration() {
        this.a = new Paint();
        this.b = new Paint();
        this.c = new Paint();
        this.i = Collections.emptyMap();
        this.j = Collections.emptyList();
    }

    public final String h(int r3) {
    L3:
        if (r3 < this.h) goto L9;
        if (this.i.containsKey(Integer.valueOf(r3)) == true) goto L7;
        r3 = r3 - 1;
        goto L3
    L7:
        return this.i.get(Integer.valueOf(r3));
    L9:
        return null;
    }

    public static Map<Integer, String> i(Map<Integer, String> r3, int r4) {
        if (r3 == null) goto L4;
        if (r4 != 0) goto L7;
        return r3;
    L7:
        LinkedHashMap r0 = new LinkedHashMap(r3.size());
        Iterator r5 = ((LinkedHashMap) r3).entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) r5.next();
        Integer r2 = (Integer) r1.getKey();
        if (r2 == null) goto L9;
        r0.put(Integer.valueOf(r2.intValue() + r4), (String) r1.getValue());
        goto L9
    L14:
        return r0;
    L4:
        return Collections.emptyMap();
    }

    public OfficeFloatingBarItemDecoration(Context r5, Map r6, int r7) {
        Paint r0 = new Paint();
        this.a = r0;
        Paint r1 = new Paint();
        this.b = r1;
        Paint r2 = new Paint();
        this.c = r2;
        this.i = Collections.emptyMap();
        this.j = Collections.emptyList();
        this.h = Math.max(0, r7);
        this.d = UIUtils.dp2px(r5, 32.0f);
        r0.setColor(ContextCompat.getColor(r5, 2131100548));
        r2.setColor(ContextCompat.getColor(r5, 2131100545));
        r1.setColor(ContextCompat.getColor(r5, 2131106607));
        r1.setTextSize(UIUtils.dp2px(r5, 14.0f));
        r1.setAntiAlias(true);
        Paint.FontMetrics r8 = r1.getFontMetrics();
        float r3 = r8.bottom;
        this.e = (int) (r3 - r8.top);
        this.f = (int) r3;
        this.g = UIUtils.dp2px(r5, 16.0f);
        if (r6 != null) goto L5;
        r6 = Collections.emptyMap();
    L5:
        this.j = new LinkedList(new LinkedHashSet(r6.values()));
        this.i = r6;
    }

    public final void onDraw(Canvas r20, RecyclerView r21, RecyclerView.State r22) {
        super.onDraw(r20, r21, r22);
        int r2 = r21.getPaddingLeft();
        int r3 = r21.getWidth() - r21.getPaddingRight();
        int r4 = r21.getChildCount();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L20;
        View r7 = r21.getChildAt(r6);
        RecyclerView.LayoutParams r8 = r7.getLayoutParams();
        int r9 = r21.getChildAdapterPosition(r7);
        if (r9 != (-1)) goto L8;
    L19:
        r6 = r6 + 1;
        goto L3
    L8:
        if (r9 < this.h) goto L19;
        if (this.i.containsKey(Integer.valueOf(r9)) == false) goto L14;
        String r10 = this.i.get(Integer.valueOf(r9));
        int r11 = r7.getTop() - ((ViewGroup.MarginLayoutParams) r8).topMargin;
        r20.drawRect(r2, r11 - this.d, r3, r11, this.a);
        r20.drawText(r10, r7.getPaddingLeft() + this.g, (r11 - ((this.d - this.e) / 2)) - this.f, this.b);
    L14:
        int r12 = r9 + 1;
        if (r12 < this.h) goto L19;
        if (this.i.containsKey(Integer.valueOf(r12)) == false) goto L19;
        int r5 = r7.getBottom() + ((ViewGroup.MarginLayoutParams) r8).bottomMargin;
        r20.drawRect(r2, r5, r3, 0 + r5, this.c);
        goto L19
    }

    public final void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        super.onDrawOver(r10, r11, r12);
        int r13 = r11.getLayoutManager().findFirstVisibleItemPosition();
        if (r13 != (-1)) goto L6;
        return;
    L6:
        if (r13 >= this.h) goto L8;
        return;
    L8:
        RecyclerView.ViewHolder r0 = r11.findViewHolderForAdapterPosition(r13);
        if (r0 != null) goto L11;
        return;
    L11:
        View r1 = r0.itemView;
        String r2 = h(r13);
        if (r2 != null) goto L14;
        return;
    L14:
        this.j.indexOf(r2);
        boolean r3 = true;
        String r14 = h(r13 + 1);
        if (r14 != null) goto L17;
    L21:
        r3 = false;
    L22:
        r10.drawRect(r11.getPaddingLeft(), r11.getPaddingTop(), r11.getRight() - r11.getPaddingRight(), r11.getPaddingTop() + this.d, this.a);
        float r15 = r1.getPaddingLeft() + this.g;
        int r16 = r11.getPaddingTop();
        int r4 = this.d;
        r10.drawText(r2, r15, ((r16 + r4) - ((r4 - this.e) / 2)) - this.f, this.b);
        if (r3 == false) goto L26;
        r10.restore();
        return;
    L26:
        return;
    L17:
        if (TextUtils.equals(r2, r14) == true) goto L21;
        if (((r1.getHeight() + r1.getTop()) + 0) >= this.d) goto L21;
        r10.save();
        r10.translate(0.0f, ((r1.getHeight() + r1.getTop()) + 0) - this.d);
        goto L22
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != (-1)) goto L7;
        r2.set(0, 0, 0, 0);
        return;
    L7:
        if (r6 >= this.h) goto L11;
        r2.set(0, 0, 0, 0);
        return;
    L11:
        if (this.i.containsKey(Integer.valueOf(r6)) == false) goto L13;
        int r7 = this.d;
    L14:
        int r8 = r6 + 1;
        if (r8 < this.h) goto L17;
        this.i.containsKey(Integer.valueOf(r8));
    L17:
        r2.set(0, r7, 0, 0);
        return;
    L13:
        r7 = 0;
        goto L14
    }
}
