package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MaxLinesRecyclerView extends CommonRecyclerView {
    public int k;
    public final List<Integer> l;
    public int m;

    public interface a {
    }

    public void setOnHeightChangedListener(a r1) {
    }

    public MaxLinesRecyclerView(Context r1) {
        super(r1);
        this.l = new ArrayList();
        this.m = 0;
    }

    public void setMaxLines(int r1) {
        this.k = r1;
    }

    public MaxLinesRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.l = new ArrayList();
        this.m = 0;
    }

    public final void onMeasure(int r4, int r5) {
        computeVerticalScrollRange();
        int r0 = computeVerticalScrollExtent();
        if (this.k <= 0) goto L8;
        if (((ArrayList) this.l).size() != this.k) goto L8;
        List<Integer> r6 = this.l;
        r5 = View.MeasureSpec.makeMeasureSpec(((Integer) ListProtector.get(r6, ((ArrayList) r6).size() - 1)).intValue(), PluginList.LEVEL_NOT_SET);
    L8:
        if (((ArrayList) this.l).size() >= this.k) goto L13;
        if (r0 <= 0) goto L13;
        if (((ArrayList) this.l).contains(Integer.valueOf(r0)) == true) goto L13;
        ((ArrayList) this.l).add(Integer.valueOf(r0));
    L13:
        super/*androidx.recyclerview.widget.RecyclerView*/.onMeasure(r4, r5);
    }

    public MaxLinesRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.l = new ArrayList();
        this.m = 0;
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*androidx.recyclerview.widget.RecyclerView*/.onLayout(r1, r2, r3, r4, r5);
        int r6 = r5 - r3;
        if (this.m == r6) goto L6;
        this.m = r6;
        return;
    }
}
