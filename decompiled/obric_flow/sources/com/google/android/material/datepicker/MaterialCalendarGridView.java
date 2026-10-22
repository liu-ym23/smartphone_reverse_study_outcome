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
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context r5) {
        this(r5, null);
    }

    private void gainFocus(int r5, Rect r10) {
        if (r5 != 33) goto L6;
        setSelection(getAdapter().lastPositionInMonth());
        return;
    L6:
        if (r5 != 130) goto L8;
        setSelection(getAdapter().firstPositionInMonth());
        return;
    L8:
        super.onFocusChanged(true, r5, r10);
    }

    private View getChildAtPosition(int r5) {
        return getChildAt(r5 - getFirstVisiblePosition());
    }

    private static int horizontalMidPoint(@NonNull View r5) {
        int r10 = r5.getLeft();
        return (r5.getWidth() / 2) + r10;
    }

    private static boolean skipMonth(@Nullable Long r5, @Nullable Long r10, @Nullable Long r11, @Nullable Long r12) {
        if (r5 == null) goto L15;
        if (r10 == null) goto L16;
        if (r11 == null) goto L17;
        if (r12 != null) goto L9;
        return true;
    L9:
        if (r11.longValue() <= r10.longValue()) goto L11;
        return true;
    L11:
        if (r12.longValue() < r5.longValue()) goto L20;
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

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas r27) {
        MaterialCalendarGridView r5 = this;
        super.onDraw(r27);
        MonthAdapter r10 = getAdapter();
        DateSelector<?> r11 = r10.dateSelector;
        CalendarStyle r12 = r10.calendarStyle;
        int r13 = Math.max(r10.firstPositionInMonth(), getFirstVisiblePosition());
        int r14 = Math.min(r10.lastPositionInMonth(), getLastVisiblePosition());
        Long r15 = r10.getItem(r13);
        Long r16 = r10.getItem(r14);
        Iterator<Pair<Long, Long>> r17 = r11.getSelectedRanges().iterator();
    L4:
        if (r17.hasNext() == false) goto L53;
        Pair<Long, Long> r18 = r17.next();
        Long r19 = r18.first;
        if (r19 != null) goto L8;
        r5 = this;
        goto L4
    L8:
        if (r18.second == null) goto L4;
        Long r20 = r19;
        long r110 = r20.longValue();
        Long r21 = r18.second;
        long r111 = r21.longValue();
        if (skipMonth(r15, r16, r20, r21) == true) goto L4;
        boolean r22 = ViewUtils.isLayoutRtl(this);
        if (r110 < r15.longValue()) goto L16;
        r5.dayCompute.setTimeInMillis(r110);
        int r23 = r10.dayToPosition(r5.dayCompute.get(5));
        int r112 = horizontalMidPoint(r5.getChildAtPosition(r23));
    L24:
        if (r111 > r16.longValue()) goto L26;
        r5.dayCompute.setTimeInMillis(r111);
        int r113 = r10.dayToPosition(r5.dayCompute.get(5));
        int r114 = horizontalMidPoint(r5.getChildAtPosition(r113));
    L33:
        int r115 = (int) r10.getItemId(r23);
        int r116 = r13;
        int r117 = r14;
        int r24 = (int) r10.getItemId(r113);
    L34:
        if (r115 > r24) goto L51;
        int r25 = getNumColumns() * r115;
        int r118 = (getNumColumns() + r25) - 1;
        View r119 = r5.getChildAtPosition(r25);
        int r26 = r119.getTop() + r12.day.getTopInset();
        MonthAdapter r120 = r10;
        int r28 = r119.getBottom() - r12.day.getBottomInset();
        if (r22 == true) goto L43;
        if (r25 <= r23) goto L39;
        int r29 = 0;
    L40:
        if (r113 <= r118) goto L42;
        int r121 = getWidth();
    L50:
        r27.drawRect(r29, r26, r121, r28, r12.rangeFill);
        r115 = r115 + 1;
        r5 = this;
        r17 = r17;
        r10 = r120;
        goto L34
    L42:
        r121 = r114;
        goto L50
    L39:
        r29 = r112;
        goto L40
    L43:
        if (r113 <= r118) goto L45;
        int r122 = 0;
    L46:
        if (r25 <= r23) goto L48;
        int r30 = getWidth();
    L49:
        int r210 = r122;
        r121 = r30;
        r29 = r210;
        goto L50
    L48:
        r30 = r112;
        goto L49
    L45:
        r122 = r114;
        goto L46
    L51:
        r5 = this;
        r13 = r116;
        r14 = r117;
        goto L4
    L26:
        if (r10.isLastInRow(r14) == false) goto L28;
        int r123 = getWidth();
    L31:
        r114 = r123;
        r113 = r14;
        goto L33
    L28:
        if (r22 == true) goto L30;
        r123 = r5.getChildAtPosition(r14).getRight();
        goto L31
    L30:
        r123 = r5.getChildAtPosition(r14).getLeft();
        goto L31
    L16:
        if (r10.isFirstInRow(r13) == false) goto L18;
        int r31 = 0;
    L21:
        r112 = r31;
        r23 = r13;
        goto L24
    L18:
        if (r22 == true) goto L20;
        r31 = r5.getChildAtPosition(r13 - 1).getRight();
        goto L21
    L20:
        r31 = r5.getChildAtPosition(r13 - 1).getLeft();
        goto L21
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean r5, int r10, Rect r11) {
        if (r5 == false) goto L4;
        gainFocus(r10, r11);
        return;
    L4:
        super.onFocusChanged(false, r10, r11);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r5, KeyEvent r10) {
        if (super.onKeyDown(r5, r10) == true) goto L6;
        return false;
    L6:
        if (getSelectedItemPosition() != (-1)) goto L8;
    L15:
        return true;
    L8:
        if (getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) goto L15;
        if (19 != r5) goto L14;
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    L14:
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.nestedScrollable == false) goto L5;
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r11 = getLayoutParams();
        r11.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r5, r10);
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r5) {
        setAdapter((ListAdapter) r5);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r5) {
        if (r5 >= getAdapter().firstPositionInMonth()) goto L5;
        super.setSelection(getAdapter().firstPositionInMonth());
        return;
    L5:
        super.setSelection(r5);
    }

    public MaterialCalendarGridView(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r5) {
        if ((r5 instanceof MonthAdapter) == false) goto L7;
        super.setAdapter(r5);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    public MaterialCalendarGridView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext()) == false) goto L5;
        setNextFocusLeftId(R.id.cancel_button);
        setNextFocusRightId(R.id.confirm_button);
    L5:
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }
}
