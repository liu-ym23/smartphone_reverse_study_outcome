package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes2.dex */
@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class CustomAppBarLayout extends BaseCustomAppBarLayout implements CoordinatorLayout.AttachedBehavior {

    public static class Behavior extends AppBarLayout.Behavior {
    }

    public CustomAppBarLayout(Context r5) {
        super(r5);
    }

    public CustomAppBarLayout(Context r5, AttributeSet r10) {
        super(r5, r10);
    }
}
