package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.bmhome.chat.view.FixHorizontalDisallowRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class ScrollToRecyclerView extends FixHorizontalDisallowRecyclerView {
    public int k;
    public int l;
    public a m;

    public interface a {
        void a(int r1);
    }

    public ScrollToRecyclerView(Context r1) {
        super(r1);
        this.k = 0;
        this.l = 0;
        this.m = null;
        addOnScrollListener(new c1(this));
    }

    public void setRecyclerScrollListener(a r1) {
        this.m = r1;
        addOnScrollListener(new c1(this));
    }

    public ScrollToRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.k = 0;
        this.l = 0;
        this.m = null;
        addOnScrollListener(new c1(this));
    }

    public final void scrollTo(int r2, int r3) {
        super/*androidx.recyclerview.widget.RecyclerView*/.scrollTo(r2, r3);
        scrollBy(r2 - this.k, r3 - this.l);
    }

    public ScrollToRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.k = 0;
        this.l = 0;
        this.m = null;
        addOnScrollListener(new c1(this));
    }
}
