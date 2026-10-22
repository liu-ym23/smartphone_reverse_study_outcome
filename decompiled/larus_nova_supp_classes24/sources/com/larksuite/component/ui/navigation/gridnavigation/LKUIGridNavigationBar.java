package com.larksuite.component.ui.navigation.gridnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.GridView;
import androidx.core.content.ContextCompat;
import f08.a;
import j08.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIGridNavigationBar extends GridView {
    public LKUIGridNavigationBar(Context r2) {
        this(r2, null);
    }

    public void setAdapter(a r1) {
        super.setAdapter(r1);
    }

    public void setGridItemImageHeight(int r1) {
        if (a.a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public void setGridItemImageWidth(int r1) {
        if (a.a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public void setGridItemTextColor(int r1) {
        if (a.a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public void setGridItemTextSize(float r2) {
        b.e(getContext(), r2);
        if (a.a != null) goto L5;
        return;
    L5:
        if (getAdapter() != null) goto L7;
        return;
    L7:
        if ((getAdapter() instanceof BaseAdapter) == false) goto L12;
        ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        return;
    }

    public LKUIGridNavigationBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LKUIGridNavigationBar(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        if (r5 == null) goto L5;
        TypedArray r7 = getContext().obtainStyledAttributes(r5, new int[]{2130970177, 2130970178, 2130970179, 2130970180});
        r7.getColor(2, ContextCompat.getColor(getContext(), 2131103463));
        r7.getDimension(3, b.e(getContext(), 14.0f));
        r7.getDimensionPixelSize(0, 140);
        r7.getDimensionPixelSize(1, 140);
        r7.recycle();
    L6:
        a.a = new f08.b();
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setSelector(2131103546);
        return;
    L5:
        ContextCompat.getColor(getContext(), 2131103463);
        b.e(getContext(), 14.0f);
        goto L6
    }
}
