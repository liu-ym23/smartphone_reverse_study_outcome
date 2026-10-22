package com.larus.common_ui.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import q19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class AbsRefreshHeaderLayout extends FrameLayout {
    public abstract void a(SuperSwipeRefreshLayout r1, c r2);

    public abstract void b(SuperSwipeRefreshLayout r1);

    public abstract void c(SuperSwipeRefreshLayout r1, int r2);

    public abstract void d();

    public AbsRefreshHeaderLayout(Context r2) {
        this(r2, null);
    }

    public AbsRefreshHeaderLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AbsRefreshHeaderLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
