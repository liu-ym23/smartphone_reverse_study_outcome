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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Calendar f3174c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f3175g;

    public MaterialCalendarGridView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public MaterialCalendarGridView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f3174c = j.q();
        if (MaterialDatePicker.isFullscreen(getContext()) == false) goto L5;
        setNextFocusLeftId(q5.f.cancel_button);
        setNextFocusRightId(q5.f.confirm_button);
    L5:
        this.f3175g = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    private void a(int r10, Rect r11) {
        if (r10 != 33) goto L7;
        int r12 = b().i();
    L5:
        setSelection(r12);
        return;
    L7:
        if (r10 != 130) goto L9;
        r12 = b().b();
        goto L5
    L9:
        super.onFocusChanged(true, r10, r11);
    }

    private View c(int r10) {
        return getChildAt(r10 - getFirstVisiblePosition());
    }

    private static int d(@NonNull View r10) {
        return r10.getLeft() + (r10.getWidth() / 2);
    }

    private static boolean e(@Nullable Long r10, @Nullable Long r11, @Nullable Long r12, @Nullable Long r13) {
        if (r10 == null) goto L15;
        if (r11 == null) goto L16;
        if (r12 == null) goto L17;
        if (r13 != null) goto L9;
        return true;
    L9:
        if (r12.longValue() <= r11.longValue()) goto L11;
        return true;
    L11:
        if (r13.longValue() < r10.longValue()) goto L20;
        return false;
    L20:
        return true;
    L17:
        return true;
    L16:
        return true;
    L15:
        return true;
    }

    @NonNull
    public g b() {
        return (g) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return b();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return b();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas r27) {
        MaterialCalendarGridView r10 = this;
        super.onDraw(r27);
        g r11 = b();
        DateSelector<?> r12 = r11.f3225g;
        b r13 = r11.f3227i;
        int r14 = Math.max(r11.b(), getFirstVisiblePosition());
        int r15 = Math.min(r11.i(), getLastVisiblePosition());
        Long r16 = r11.c(r14);
        Long r17 = r11.c(r15);
        Iterator<Pair<Long, Long>> r18 = r12.getSelectedRanges().iterator();
    L4:
        if (r18.hasNext() == false) goto L55;
        Pair<Long, Long> r19 = r18.next();
        Long r20 = r19.first;
        if (r20 != null) goto L8;
        r10 = this;
        goto L4
    L8:
        if (r19.second == null) goto L4;
        long r21 = r20.longValue();
        long r110 = r19.second.longValue();
        if (e(r16, r17, Long.valueOf(r21), Long.valueOf(r110)) == true) goto L4;
        boolean r22 = ViewUtils.i(this);
        if (r21 < r16.longValue()) goto L16;
        r10.f3174c.setTimeInMillis(r21);
        int r23 = r11.a(r10.f3174c.get(5));
        int r111 = d(r10.c(r23));
    L25:
        if (r110 > r17.longValue()) goto L27;
        r10.f3174c.setTimeInMillis(r110);
        int r112 = r11.a(r10.f3174c.get(5));
        int r113 = d(r10.c(r112));
    L35:
        int r114 = (int) r11.getItemId(r23);
        int r115 = r14;
        int r116 = r15;
        int r24 = (int) r11.getItemId(r112);
    L36:
        if (r114 > r24) goto L53;
        int r25 = getNumColumns() * r114;
        int r117 = (r25 + getNumColumns()) - 1;
        View r118 = r10.c(r25);
        int r26 = r118.getTop() + r13.f3201a.c();
        g r119 = r11;
        int r28 = r118.getBottom() - r13.f3201a.b();
        if (r22 == true) goto L45;
        if (r25 <= r23) goto L41;
        int r29 = 0;
    L42:
        if (r112 <= r117) goto L44;
        int r120 = getWidth();
    L52:
        r27.drawRect(r29, r26, r120, r28, r13.f3208h);
        r114 = r114 + 1;
        r10 = this;
        r18 = r18;
        r11 = r119;
        goto L36
    L44:
        r120 = r113;
        goto L52
    L41:
        r29 = r111;
        goto L42
    L45:
        if (r112 <= r117) goto L47;
        int r121 = 0;
    L48:
        if (r25 <= r23) goto L50;
        int r30 = getWidth();
    L51:
        int r210 = r121;
        r120 = r30;
        r29 = r210;
        goto L52
    L50:
        r30 = r111;
        goto L51
    L47:
        r121 = r113;
        goto L48
    L53:
        r10 = this;
        r14 = r115;
        r15 = r116;
        goto L4
    L27:
        if (r11.g(r15) == false) goto L29;
        int r122 = getWidth();
    L33:
        r113 = r122;
        r112 = r15;
        goto L35
    L29:
        View r123 = r10.c(r15);
        if (r22 == true) goto L32;
        r122 = r123.getRight();
        goto L33
    L32:
        r122 = r123.getLeft();
        goto L33
    L16:
        if (r11.f(r14) == false) goto L18;
        int r31 = 0;
    L22:
        r111 = r31;
        r23 = r14;
        goto L25
    L18:
        View r32 = r10.c(r14 - 1);
        if (r22 == true) goto L21;
        r31 = r32.getRight();
        goto L22
    L21:
        r31 = r32.getLeft();
        goto L22
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean r10, int r11, Rect r12) {
        if (r10 == false) goto L4;
        a(r11, r12);
        return;
    L4:
        super.onFocusChanged(false, r11, r12);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (super.onKeyDown(r10, r11) == true) goto L6;
        return false;
    L6:
        if (getSelectedItemPosition() != (-1)) goto L8;
    L15:
        return true;
    L8:
        if (getSelectedItemPosition() >= b().b()) goto L15;
        if (19 != r10) goto L14;
        setSelection(b().b());
        return true;
    L14:
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f3175g == false) goto L5;
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r12 = getLayoutParams();
        r12.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r10, r11);
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r10) {
        setAdapter((ListAdapter) r10);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r10) {
        if ((r10 instanceof g) == false) goto L7;
        super.setAdapter(r10);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), g.class.getCanonicalName()}));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r10) {
        if (r10 >= b().b()) goto L5;
        r10 = b().b();
    L5:
        super.setSelection(r10);
    }
}
