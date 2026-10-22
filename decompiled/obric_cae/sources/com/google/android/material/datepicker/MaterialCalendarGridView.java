package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.obric.cae.R;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f4619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4620b;

    public MaterialCalendarGridView(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        this.f4619a = g0.g(null);
        if (r.f(getContext()) == false) goto L5;
        setNextFocusLeftId(R.id.cancel_button);
        setNextFocusRightId(R.id.confirm_button);
    L5:
        this.f4620b = r.g(getContext(), R.attr.nestedScrollable);
        j0.w.m(this, new p());
    }

    public final v a() {
        return (v) super.getAdapter();
    }

    public final View b(int r8) {
        return getChildAt(r8 - getFirstVisiblePosition());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final /* bridge */ /* synthetic */ Adapter getAdapter() {
        return a();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a().notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onDraw(Canvas r29) {
        MaterialCalendarGridView r8 = this;
        super.onDraw(r29);
        v r10 = a();
        DateSelector<?> r11 = r10.f4734b;
        b r12 = r10.f4736n;
        int r13 = Math.max(r10.b(), getFirstVisiblePosition());
        int r14 = r10.b();
        Month r15 = r10.f4733a;
        int r16 = Math.min((r14 + r15.f4625o) - 1, getLastVisiblePosition());
        Long r17 = r10.c(r13);
        Long r18 = r10.c(r16);
        Iterator r19 = r11.e().iterator();
    L4:
        if (r19.hasNext() == false) goto L74;
        i0.c r20 = (i0.c) r19.next();
        F r110 = r20.f8079a;
        if (r110 == 0) goto L72;
        S r21 = r20.f8080b;
        if (r21 == 0) goto L4;
        long r111 = ((Long) r110).longValue();
        long r112 = ((Long) r21).longValue();
        Long r22 = Long.valueOf(r111);
        Long r113 = Long.valueOf(r112);
        if (r17 == null) goto L22;
        if (r18 == null) goto L22;
        if (r22 == null) goto L22;
        if (r113 == null) goto L22;
        if (r22.longValue() > r18.longValue()) goto L22;
        if (r113.longValue() < r17.longValue()) goto L22;
        boolean r23 = false;
    L23:
        if (r23 == true) goto L4;
        boolean r24 = com.google.android.material.internal.q.a(this);
        long r114 = r17.longValue();
        Calendar r115 = r8.f4619a;
        if (r111 < r114) goto L28;
        r115.setTimeInMillis(r111);
        int r116 = r10.b() + (r115.get(5) - 1);
        View r117 = r8.b(r116);
        int r118 = (r117.getWidth() / 2) + r117.getLeft();
    L40:
        if (r112 > r18.longValue()) goto L42;
        r115.setTimeInMillis(r112);
        int r119 = r10.b() + (r115.get(5) - 1);
        View r120 = r8.b(r119);
        int r121 = (r120.getWidth() / 2) + r120.getLeft();
    L53:
        int r122 = (int) r10.getItemId(r116);
        int r25 = (int) r10.getItemId(r119);
    L54:
        if (r122 > r25) goto L71;
        int r26 = getNumColumns() * r122;
        v r123 = r10;
        int r27 = (getNumColumns() + r26) - 1;
        View r124 = r8.b(r26);
        int r28 = r124.getTop() + r12.f4644a.f4634a.top;
        Iterator r210 = r19;
        int r30 = r124.getBottom() - r12.f4644a.f4634a.bottom;
        if (r24 == true) goto L63;
        if (r26 <= r116) goto L59;
        int r31 = 0;
    L60:
        if (r119 <= r27) goto L62;
        int r32 = getWidth();
    L70:
        r29.drawRect(r31, r28, r32, r30, r12.f4651h);
        r122 = r122 + 1;
        r8 = this;
        r25 = r25;
        r10 = r123;
        r19 = r210;
        goto L54
    L62:
        r32 = r121;
        goto L70
    L59:
        r31 = r118;
        goto L60
    L63:
        if (r119 <= r27) goto L65;
        int r33 = 0;
    L66:
        if (r26 <= r116) goto L68;
        int r34 = getWidth();
    L69:
        int r211 = r34;
        r31 = r33;
        r32 = r211;
        goto L70
    L68:
        r34 = r118;
        goto L69
    L65:
        r33 = r121;
        goto L66
    L71:
        v r125 = r10;
        Iterator r212 = r19;
    L73:
        r8 = this;
        r13 = r13;
        r16 = r16;
        r10 = r125;
        r19 = r212;
        goto L4
    L42:
        if (((r16 + 1) % r15.f4624n) != 0) goto L44;
        boolean r126 = true;
    L45:
        if (r126 == false) goto L47;
        r121 = getWidth();
    L51:
        r119 = r16;
        goto L53
    L47:
        View r127 = r8.b(r16);
        if (r24 == true) goto L50;
        r121 = r127.getRight();
        goto L51
    L50:
        r121 = r127.getLeft();
        goto L51
    L44:
        r126 = false;
        goto L45
    L28:
        if ((r13 % r15.f4624n) != 0) goto L30;
        boolean r128 = true;
    L31:
        if (r128 == false) goto L33;
        int r129 = 0;
    L37:
        r118 = r129;
        r116 = r13;
        goto L40
    L33:
        View r130 = r8.b(r13 - 1);
        if (r24 == true) goto L36;
        r129 = r130.getRight();
        goto L37
    L36:
        r129 = r130.getLeft();
        goto L37
    L30:
        r128 = false;
    L22:
        r23 = true;
        goto L23
    L72:
        r125 = r10;
        r212 = r19;
        goto L73
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean r8, int r10, Rect r11) {
        if (r8 == true) goto L4;
        super.onFocusChanged(false, r10, r11);
        return;
    L4:
        if (r10 != 33) goto L7;
        v r12 = a();
        int r13 = (r12.b() + r12.f4733a.f4625o) - 1;
    L9:
        setSelection(r13);
        return;
    L7:
        if (r10 != 130) goto L10;
        r13 = a().b();
        goto L9
    L10:
        super.onFocusChanged(true, r10, r11);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r8, KeyEvent r10) {
        if (super.onKeyDown(r8, r10) == true) goto L6;
        return false;
    L6:
        if (getSelectedItemPosition() != (-1)) goto L8;
    L15:
        return true;
    L8:
        if (getSelectedItemPosition() >= a().b()) goto L15;
        if (19 != r8) goto L14;
        setSelection(a().b());
        return true;
    L14:
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int r8, int r10) {
        if (this.f4620b == false) goto L5;
        super.onMeasure(r8, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r11 = getLayoutParams();
        r11.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r8, r10);
    }

    @Override // android.widget.AdapterView
    public final /* bridge */ /* synthetic */ void setAdapter(Adapter r8) {
        setAdapter((ListAdapter) r8);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int r8) {
        if (r8 >= a().b()) goto L5;
        r8 = a().b();
    L5:
        super.setSelection(r8);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return a();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r8) {
        if ((r8 instanceof v) == false) goto L7;
        super.setAdapter(r8);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), v.class.getCanonicalName()}));
    }
}
