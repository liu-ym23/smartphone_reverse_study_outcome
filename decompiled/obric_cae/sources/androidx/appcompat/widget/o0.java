package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class o0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    public class a extends LinearLayout {
        public a() {
            throw null;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
            super.onInitializeAccessibilityEvent(r8);
            r8.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
            super.onInitializeAccessibilityNodeInfo(r8);
            r8.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r8, int r10) {
            super.onMeasure(r8, r10);
            throw null;
        }

        @Override // android.view.View
        public final void setSelected(boolean r8) {
            if (isSelected() == r8) goto L5;
            boolean r10 = true;
        L6:
            super.setSelected(r8);
            if (r10 == false) goto L11;
            if (r8 == false) goto L12;
            sendAccessibilityEvent(4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    static {
        new DecelerateInterpolator();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        Context r10 = getContext();
        TypedArray r11 = r10.obtainStyledAttributes(null, c.a.f3215a, R.attr.actionBarStyle, 0);
        int r12 = r11.getLayoutDimension(13, 0);
        Resources r13 = r10.getResources();
        if (r10.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs) == true) goto L5;
        r12 = Math.min(r12, r13.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    L5:
        r11.recycle();
        setContentHeight(r12);
        r10.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> r8, View r10, int r11, long r12) {
        ((a) r10).getClass();
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        if (View.MeasureSpec.getMode(r8) != 1073741824) goto L5;
        boolean r11 = true;
    L6:
        setFillViewport(r11);
        throw null;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> r8) {
    }

    public void setAllowCollapse(boolean r8) {
    }

    public void setContentHeight(int r8) {
        requestLayout();
    }

    public void setTabSelected(int r8) {
        throw null;
    }
}
