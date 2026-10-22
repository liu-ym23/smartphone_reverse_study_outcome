package com.bytedance.android.ec.core.widget.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class TagFlowLayout extends FlowLayout {
    public static final /* synthetic */ int m = 0;
    public ei.a i;
    public int j;
    public final Set<Integer> k;
    public b l;

    public interface a {
    }

    public interface b {
        void a(int r1);
    }

    public void setOnSelectListener(a r1) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.k);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("key_default", super.onSaveInstanceState());
        StringBuilder r1 = new StringBuilder();
        if (((HashSet) this.k).size() <= 0) goto L9;
        Iterator r10 = ((HashSet) this.k).iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r1.append(((Integer) r10.next()).intValue());
        r1.append("|");
        goto L6
    L8:
        r1.deleteCharAt(r1.length() - 1);
    L9:
        r0.putString("key_choose_pos", r1.toString());
        return r0;
    }

    public ei.a getAdapter() {
        return this.i;
    }

    public TagFlowLayout(Context r10) {
        this(r10, null);
    }

    public final void a(ei.b r10) {
        r10.setChecked(true);
        ei.a r0 = this.i;
        r10.getTagView();
        r0.getClass();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof Bundle) == false) goto L14;
        Bundle r11 = (Bundle) r10;
        String r0 = r11.getString("key_choose_pos");
        if (TextUtils.isEmpty(r0) == true) goto L12;
        String[] r1 = r0.split("\\|");
        int r12 = r1.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L12;
        int r14 = CastIntegerProtector.parseInt(r1[r13]);
        Set<Integer> r15 = this.k;
        HashSet r16 = (HashSet) r15;
        r16.add(Integer.valueOf(r14));
        ei.b r17 = (ei.b) getChildAt(r14);
        if (r17 == null) goto L11;
        a(r17);
    L11:
        r13 = r13 + 1;
    L12:
        super.onRestoreInstanceState(r11.getParcelable("key_default"));
        return;
    L14:
        super.onRestoreInstanceState(r10);
    }

    public void setAdapter(ei.a r10) {
        this.i = r10;
        r10.getClass();
        ((HashSet) this.k).clear();
        removeAllViews();
        ei.a r11 = this.i;
        HashSet<Integer> r0 = r11.b;
        int r12 = 0;
    L3:
        List<T> r13 = r11.a;
        if (r13 != 0) goto L6;
        int r14 = 0;
    L7:
        if (r12 >= r14) goto L16;
        View r15 = r11.a(ListProtector.get(r11.a, r12));
        ei.b r16 = new ei.b(getContext());
        r15.setDuplicateParentStateEnabled(true);
        if (r15.getLayoutParams() == null) goto L11;
        r16.setLayoutParams(r15.getLayoutParams());
    L12:
        r15.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r16.addView(r15);
        addView(r16);
        if (r0.contains(Integer.valueOf(r12)) == false) goto L15;
        a(r16);
    L15:
        ei.a r17 = this.i;
        ListProtector.get(r11.a, r12);
        r17.getClass();
        r15.setClickable(false);
        r16.setOnClickListener(new com.bytedance.android.ec.core.widget.flow.a(this, r16, r12));
        r12 = r12 + 1;
        goto L3
    L11:
        r16.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        goto L12
    L16:
        this.k.addAll(r0);
        return;
    L6:
        r14 = r13.size();
        goto L7
    }

    public void setMaxSelectCount(int r10) {
        if (((HashSet) this.k).size() <= r10) goto L5;
        ((HashSet) this.k).clear();
    L5:
        this.j = r10;
    }

    public void setOnTagClickListener(b r1) {
        this.l = r1;
    }

    public TagFlowLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    @Override // com.bytedance.android.ec.core.widget.flow.FlowLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        ei.b r12 = (ei.b) getChildAt(r1);
        if (r12.getVisibility() == 8) goto L10;
        if (r12.getTagView().getVisibility() != 8) goto L10;
        r12.setVisibility(8);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        super.onMeasure(r10, r11);
    }

    public TagFlowLayout(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        this.k = new HashSet();
        TypedArray r12 = r1.obtainStyledAttributes(r10, new int[]{2130972717, 2130974466, 2130974470, 2130974474, 2130974477});
        this.j = r12.getInt(0, -1);
        r12.recycle();
    }
}
