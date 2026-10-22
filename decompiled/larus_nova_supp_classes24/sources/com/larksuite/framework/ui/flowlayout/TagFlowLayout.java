package com.larksuite.framework.ui.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class TagFlowLayout extends FlowLayout {
    public p28.a f;
    public final boolean g;
    public int h;
    public MotionEvent i;
    public final Set<Integer> j;
    public int k;

    public interface a {
    }

    public interface b {
    }

    public void setOnSelectListener(a r1) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.j);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("key_default", super.onSaveInstanceState());
        String r2 = "";
        if (((HashSet) this.j).size() <= 0) goto L9;
        Iterator r1 = ((HashSet) this.j).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r2 = r2 + ((Integer) r1.next()).intValue() + "|";
        goto L6
    L8:
        r2 = r2.substring(0, r2.length() - 1);
    L9:
        r0.putString("key_choose_pos", r2);
        return r0;
    }

    @Override // android.view.View
    public final boolean performClick() {
        MotionEvent r0 = this.i;
        if (r0 == null) goto L5;
        int r1 = (int) r0.getX();
        int r2 = (int) this.i.getY();
        p28.b r3 = null;
        this.i = null;
        int r4 = getChildCount();
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L15;
        p28.b r6 = (p28.b) getChildAt(r5);
        if (r6.getVisibility() == 8) goto L14;
        Rect r7 = new Rect();
        r6.getHitRect(r7);
        if (r7.contains(r1, r2) == false) goto L14;
        r3 = r6;
    L14:
        r5 = r5 + 1;
    L15:
        int r8 = getChildCount();
        int r9 = 0;
    L16:
        if (r9 >= r8) goto L21;
        if (getChildAt(r9) == r3) goto L23;
        r9 = r9 + 1;
    L23:
        if (r3 != null) goto L25;
    L40:
        return true;
    L25:
        if (this.g == false) goto L40;
        if (r3.a == false) goto L29;
        r3.setChecked(false);
        Set<Integer> r10 = this.j;
        HashSet r11 = (HashSet) r10;
        r11.remove(Integer.valueOf(r9));
        goto L40
    L29:
        if (this.h != 1) goto L34;
        if (((HashSet) this.j).size() != 1) goto L34;
        Integer r12 = (Integer) ((HashSet) this.j).iterator().next();
        ((p28.b) getChildAt(r12.intValue())).setChecked(false);
        r3.setChecked(true);
        ((HashSet) this.j).remove(r12);
        Set<Integer> r13 = this.j;
        HashSet r14 = (HashSet) r13;
        r14.add(Integer.valueOf(r9));
    L34:
        if (this.h > 0) goto L36;
    L38:
        r3.setChecked(true);
        Set<Integer> r15 = this.j;
        HashSet r16 = (HashSet) r15;
        r16.add(Integer.valueOf(r9));
        goto L40
    L36:
        if (((HashSet) this.j).size() < this.h) goto L38;
    L21:
        r9 = -1;
        goto L23
    L5:
        return super.performClick();
    }

    public p28.a getAdapter() {
        return this.f;
    }

    public TagFlowLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r7) {
        if ((r7 instanceof Bundle) == false) goto L14;
        Bundle r8 = (Bundle) r7;
        String r0 = r8.getString("key_choose_pos");
        if (TextUtils.isEmpty(r0) == true) goto L12;
        String[] r1 = r0.split("\\|");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        int r4 = CastIntegerProtector.parseInt(r1[r3]);
        Set<Integer> r5 = this.j;
        HashSet r6 = (HashSet) r5;
        r6.add(Integer.valueOf(r4));
        p28.b r9 = (p28.b) getChildAt(r4);
        if (r9 == null) goto L11;
        r9.setChecked(true);
    L11:
        r3 = r3 + 1;
    L12:
        super.onRestoreInstanceState(r8.getParcelable("key_default"));
        return;
    L14:
        super.onRestoreInstanceState(r7);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 1) goto L6;
        this.i = MotionEvent.obtain(r3);
    L6:
        return super.onTouchEvent(r3);
    }

    public void setAdapter(p28.a r13) {
        this.f = r13;
        r13.getClass();
        ((HashSet) this.j).clear();
        removeAllViews();
        p28.a r14 = this.f;
        HashSet<Integer> r0 = r14.b;
        int r2 = 0;
    L3:
        List<T> r3 = r14.a;
        if (r3 != 0) goto L6;
        int r4 = 0;
    L7:
        if (r2 >= r4) goto L15;
        View r5 = r14.a(this, ListProtector.get(r14.a, r2));
        p28.b r6 = new p28.b(getContext());
        r5.setDuplicateParentStateEnabled(true);
        if (r5.getLayoutParams() != null) goto L11;
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(-2, -2);
        r7.setMargins(a(getContext(), this.k), a(getContext(), this.k), a(getContext(), this.k), a(getContext(), this.k));
        r6.setLayoutParams(r7);
    L11:
        r6.addView(r5);
        addView(r6);
        if (r0.contains(Integer.valueOf(r2)) == false) goto L14;
        r6.setChecked(true);
    L14:
        p28.a r8 = this.f;
        ListProtector.get(r14.a, r2);
        r8.getClass();
        r2 = r2 + 1;
        goto L3
    L15:
        this.j.addAll(r0);
        return;
    L6:
        r4 = r3.size();
        goto L7
    }

    public void setMaxSelectCount(int r2) {
        if (((HashSet) this.j).size() <= r2) goto L5;
        ((HashSet) this.j).clear();
    L5:
        this.h = r2;
    }

    public void setOnTagClickListener(b r1) {
        if (r1 == null) goto L5;
        setClickable(true);
        return;
    }

    public void setTagMarginInDp(int r1) {
        this.k = r1;
    }

    public TagFlowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static int a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // com.larksuite.framework.ui.flowlayout.FlowLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        p28.b r2 = (p28.b) getChildAt(r1);
        if (r2.getVisibility() == 8) goto L10;
        if (r2.getTagView().getVisibility() != 8) goto L10;
        r2.setVisibility(8);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        super.onMeasure(r6, r7);
    }

    public TagFlowLayout(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.g = true;
        this.h = -1;
        this.j = new HashSet();
        this.k = 5;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130968882, 2130970172, 2130972675, 2130972701, 2130972715, 2130973427, 2130973429, 2130973430, 2130973431, 2130973858, 2130974467, 2130974468, 2130974472, 2130974475, 2130974525, 2130974542});
        boolean r7 = r6.getBoolean(0, true);
        this.g = r7;
        this.h = r6.getInt(4, -1);
        r6.recycle();
        if (r7 == false) goto L6;
        setClickable(true);
        return;
    }
}
