package com.obric.oui.actionbar.v2;

import android.aimedia.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.cae.R;
import com.obric.oui.divider.ODivider;
import he.i;
import java.util.Iterator;
import java.util.List;
import xd.j;
import zc.b;

/* JADX INFO: loaded from: classes2.dex */
public final class OBottomActionBarNormalVertical extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ODivider f6158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f6159b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f6160m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f6161n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6162o;

    public OBottomActionBarNormalVertical(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10);
        this.f6161n = a.a("Resources.getSystem()", 1, 12);
        this.f6162o = 3;
        View.inflate(r8, R.layout.o_widget_bottom_action_bar_v2_normal_vertical, this);
        ODivider r11 = new ODivider(r8, null, 6);
        this.f6158a = r11;
        addView(r11, new FrameLayout.LayoutParams(-1, a.a("Resources.getSystem()", 1, (float) 0.6d)));
        View r12 = findViewById(R.id.action_bar_vertical_container);
        i.e(r12, "findViewById(R.id.action_bar_vertical_container)");
        this.f6159b = (LinearLayout) r12;
        View r13 = findViewById(R.id.action_bar_header_container);
        i.e(r13, "findViewById(R.id.action_bar_header_container)");
        this.f6160m = (FrameLayout) r13;
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final int getButtonCount() {
        return this.f6159b.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.f6162o;
    }

    public final void setButtons(List<? extends View> r8) {
        i.f(r8, "buttons");
        LinearLayout r10 = this.f6159b;
        r10.removeAllViews();
        Iterator<T> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        View r12 = (View) r11.next();
        i.f(r12, "button");
        if (r10.getChildCount() >= this.f6162o) goto L7;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L11;
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(r13.width, r13.height);
    L13:
        if (r10.getChildCount() <= 0) goto L15;
        r14.topMargin = this.f6161n;
    L15:
        j r15 = j.f13877a;
        r10.addView(r12, r14);
        goto L4
    L11:
        r14 = new LinearLayout.LayoutParams(-1, -2);
        goto L13
    L7:
        b.h("OBottomActionBarNormalVertical", "Maximum number of buttons reached: " + this.f6162o);
        goto L4
    }

    public final void setHeaderView(View r8) {
        i.f(r8, "headerView");
        FrameLayout r10 = this.f6160m;
        r10.removeAllViews();
        r10.addView(r8);
    }

    public final void setMaxButtonCount(int r8) {
        if (this.f6159b.getChildCount() <= r8) goto L6;
        b.b("OBottomActionBarNormalVertical", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r8 <= 0) goto L8;
        this.f6162o = r8;
        return;
    L8:
        b.b("OBottomActionBarNormalVertical", "Max button count must be greater than 0");
    }
}
