package com.lynx.xelement.scroll.coordinator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class BaseScrollCoordinatorAppBarLayout extends AppBarLayout implements CoordinatorLayout.AttachedBehavior {
    public boolean a;

    public void setToolbarDragEnabled(boolean r1) {
    }

    public BaseScrollCoordinatorAppBarLayout(Context r1) {
        super(r1);
        this.a = true;
    }

    public void setScrollEnabled(boolean r1) {
        this.a = r1;
    }

    public BaseScrollCoordinatorAppBarLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = true;
    }
}
