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
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.internal.r;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f3860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3861b;

    public MaterialCalendarGridView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public MaterialCalendarGridView(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        this.f3860a = j.c();
        if (MaterialDatePicker.isFullscreen((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        setNextFocusLeftId(ZeusTransformUtils.mapRes(R.id.cancel_button, OaidModel.KEY_ID, "cancel_button"));
        setNextFocusRightId(ZeusTransformUtils.mapRes(R.id.confirm_button, OaidModel.KEY_ID, "confirm_button"));
    L5:
        this.f3861b = MaterialDatePicker.isNestedScrollable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    private static int a(View r1) {
        return r1.getLeft() + (r1.getWidth() / 2);
    }

    private View a(int r2) {
        return getChildAt(r2 - getFirstVisiblePosition());
    }

    private void a(int r2, Rect r3) {
        if (r2 != 33) goto L7;
        int r4 = a().b();
    L5:
        setSelection(r4);
        return;
    L7:
        if (r2 != 130) goto L9;
        r4 = a().a();
        goto L5
    L9:
        super.onFocusChanged(true, r2, r3);
    }

    private static boolean a(Long r3, Long r4, Long r5, Long r6) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L16;
        if (r5 == null) goto L17;
        if (r6 != null) goto L9;
        return true;
    L9:
        if (r5.longValue() <= r4.longValue()) goto L11;
        return true;
    L11:
        if (r6.longValue() < r3.longValue()) goto L20;
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

    public g a() {
        return (g) ZeusTransformUtils.preCheckCast(super.getAdapter(), g.class, "com.obric.memorydata.plugin");
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public /* synthetic */ Adapter getAdapter() {
        return a();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public /* synthetic */ ListAdapter getAdapter() {
        return a();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r27) {
        MaterialCalendarGridView r0 = this;
        super.onDraw(r27);
        g r1 = a();
        DateSelector<?> r2 = r1.c;
        b r3 = r1.d;
        int r4 = Math.max(r1.a(), getFirstVisiblePosition());
        int r5 = Math.min(r1.b(), getLastVisiblePosition());
        Long r6 = r1.a(r4);
        Long r7 = r1.a(r5);
        Iterator<Pair<Long, Long>> r8 = r2.getSelectedRanges().iterator();
    L4:
        if (r8.hasNext() == false) goto L55;
        Pair r9 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");
        if (r9.first != 0) goto L8;
        r0 = this;
        goto L4
    L8:
        if (r9.second == 0) goto L4;
        long r11 = ((Long) ZeusTransformUtils.preCheckCast(r9.first, Long.class, "com.obric.memorydata.plugin")).longValue();
        long r10 = ((Long) ZeusTransformUtils.preCheckCast(r9.second, Long.class, "com.obric.memorydata.plugin")).longValue();
        if (a(r6, r7, Long.valueOf(r11), Long.valueOf(r10)) == true) goto L4;
        boolean r12 = r.a(this);
        if (r11 < r6.longValue()) goto L16;
        r0.f3860a.setTimeInMillis(r11);
        int r13 = r1.c(r0.f3860a.get(5));
        int r14 = a(r0.a(r13));
    L25:
        if (r10 > r7.longValue()) goto L27;
        r0.f3860a.setTimeInMillis(r10);
        int r15 = r1.c(r0.f3860a.get(5));
        int r16 = a(r0.a(r15));
    L35:
        int r17 = (int) r1.getItemId(r13);
        int r18 = r4;
        int r19 = r5;
        int r20 = (int) r1.getItemId(r15);
    L36:
        if (r17 > r20) goto L53;
        int r21 = getNumColumns() * r17;
        int r110 = (r21 + getNumColumns()) - 1;
        View r111 = r0.a(r21);
        int r22 = r111.getTop() + r3.f3881a.a();
        g r112 = r1;
        int r23 = r111.getBottom() - r3.f3881a.b();
        if (r12 == true) goto L45;
        if (r21 <= r13) goto L41;
        int r24 = 0;
    L42:
        if (r15 <= r110) goto L44;
        int r113 = getWidth();
    L52:
        r27.drawRect(r24, r22, r113, r23, r3.h);
        r17 = r17 + 1;
        r0 = this;
        r8 = r8;
        r1 = r112;
        goto L36
    L44:
        r113 = r16;
        goto L52
    L41:
        r24 = r14;
        goto L42
    L45:
        if (r15 <= r110) goto L47;
        int r114 = 0;
    L48:
        if (r21 <= r13) goto L50;
        int r25 = getWidth();
    L51:
        int r26 = r114;
        r113 = r25;
        r24 = r26;
        goto L52
    L50:
        r25 = r14;
        goto L51
    L47:
        r114 = r16;
        goto L48
    L53:
        r0 = this;
        r4 = r18;
        r5 = r19;
        goto L4
    L27:
        if (r1.f(r5) == false) goto L29;
        int r28 = getWidth();
    L33:
        r16 = r28;
        r15 = r5;
        goto L35
    L29:
        View r29 = r0.a(r5);
        if (r12 == true) goto L32;
        r28 = r29.getRight();
        goto L33
    L32:
        r28 = r29.getLeft();
        goto L33
    L16:
        if (r1.e(r4) == false) goto L18;
        int r115 = 0;
    L22:
        r14 = r115;
        r13 = r4;
        goto L25
    L18:
        View r116 = r0.a(r4 - 1);
        if (r12 == true) goto L21;
        r115 = r116.getRight();
        goto L22
    L21:
        r115 = r116.getLeft();
        goto L22
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean r1, int r2, Rect r3) {
        if (r1 == false) goto L4;
        a(r2, r3);
        return;
    L4:
        super.onFocusChanged(false, r2, r3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r4, KeyEvent r5) {
        if (super.onKeyDown(r4, r5) == true) goto L6;
        return false;
    L6:
        if (getSelectedItemPosition() != (-1)) goto L8;
    L15:
        return true;
    L8:
        if (getSelectedItemPosition() >= a().a()) goto L15;
        if (19 != r4) goto L14;
        setSelection(a().a());
        return true;
    L14:
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.f3861b == false) goto L5;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r4 = getLayoutParams();
        r4.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r2, r3);
    }

    @Override // android.widget.AdapterView
    public /* synthetic */ void setAdapter(Adapter r3) {
        setAdapter((ListAdapter) ZeusTransformUtils.preCheckCast((Adapter) ZeusTransformUtils.wrapperContextForParams(r3, Adapter.class, "com.obric.memorydata.plugin"), ListAdapter.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r3) {
        ListAdapter r4 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L7;
        super.setAdapter(r4);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), g.class.getCanonicalName()}));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r2) {
        if (r2 >= a().a()) goto L5;
        r2 = a().a();
    L5:
        super.setSelection(r2);
    }
}
