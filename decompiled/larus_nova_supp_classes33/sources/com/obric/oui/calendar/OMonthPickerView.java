package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\"#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0014\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001b\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b\u0012\u0010\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0010\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001d\u001a\u00020\t2\b\b\u0001\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002¨\u0006$"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView;", "Landroid/view/ViewGroup;", "", "getRowCount", "getFullRowWidth", "getContentHeight", "getDayCount", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "", "setSelectionMode", "getSelectionMode", "count", "setColumnCount", "getColumnCount", "", "", "newLabels", "setLabels", "", "([Ljava/lang/String;)V", "getLabels", "days", "setSelectedDays", "getSelectedDays", "Lcom/obric/oui/calendar/OMonthPickerView$b;", "listener", "setOnDaysChangedListener", "resourceId", "setDayTextAppearance", "itemDiameterDp", "setItemDiameterDp", "itemPaddingDp", "setItemPaddingDp", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OMonthPickerView extends ViewGroup {
    public static final /* synthetic */ int o = 0;
    public final int a;
    public final int b;
    public PickerSelectionMode c;
    public int d;
    public List<String> e;
    public int f;
    public int g;
    public final int h;
    public final int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final List<a> n;

    public static final class a extends AppCompatCheckedTextView {
        public final int a;
        public final int b;
        public int c;
        public int d;
        public int e;

        /* JADX WARN: Multi-variable type inference failed */
        public final void b() {
            StateListDrawable r0 = new StateListDrawable();
            r0.addState(new int[]{R.attr.state_checked}, a(this.c));
            r0.addState(new int[]{R.attr.state_pressed}, a(this.c));
            r0.addState(new int[0], a(this.d));
            setBackground(r0);
        }

        public final ShapeDrawable a(int r3) {
            ShapeDrawable r0 = new ShapeDrawable(new OvalShape());
            r0.getPaint().setColor(r3);
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void setChecked(boolean r2) {
            if (isChecked() == r2) goto L5;
            boolean r0 = true;
        L6:
            super/*android.widget.CheckedTextView*/.setChecked(r2);
            if (r0 == true) goto L9;
            return;
        L9:
            if (isChecked() == false) goto L11;
            int r3 = this.a;
        L12:
            vma.f.a(this, r3);
            return;
        L11:
            r3 = this.b;
            goto L12
        L5:
            r0 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onMeasure(int r2, int r3) {
            super/*android.widget.CheckedTextView*/.onMeasure(r2, r3);
            setMeasuredDimension(CheckedTextView.resolveSize(this.e, r2), CheckedTextView.resolveSize(this.e, r3));
        }

        public a(Context r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.a = r3;
            this.b = r4;
        }
    }

    public interface b {
    }

    public OMonthPickerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public OMonthPickerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public OMonthPickerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final void setOnDaysChangedListener(b r1) {
    }

    private final int getDayCount() {
        return this.e.size();
    }

    private final int getFullRowWidth() {
        int r0 = this.d;
        return (this.k * r0) + ((r0 - 1) * this.l);
    }

    public final List<String> getLabels() {
        return CollectionsKt.toList(this.e);
    }

    public final List<Integer> getSelectedDays() {
        List<a> r0 = this.n;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) r4).isChecked() == false) goto L11;
        Integer r6 = Integer.valueOf(r3);
    L12:
        if (r6 == null) goto L14;
        r1.add(r6);
    L14:
        r3 = r5;
        goto L4
    L11:
        r6 = null;
        goto L12
    L15:
        return r1;
    }

    private final int getContentHeight() {
        return (getRowCount() * this.k) + ((getRowCount() - 1) * this.m);
    }

    private final int getRowCount() {
        int r0 = getDayCount();
        int r1 = this.d;
        return ((r0 + r1) - 1) / r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View, android.widget.CheckedTextView, android.widget.TextView, androidx.appcompat.widget.AppCompatCheckedTextView, com.obric.oui.calendar.OMonthPickerView$a, java.lang.Object] */
    public final void a() {
        removeAllViews();
        ((ArrayList) this.n).clear();
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) r0.next();
        final ?? r2 = new a(getContext(), this.h, this.i);
        r2.setText(r1);
        r2.setGravity(17);
        if (this.j == 0) goto L9;
        r2.setTextAppearance(getContext(), this.j);
    L9:
        if (r2.isChecked() == false) goto L11;
        int r3 = r2.a;
    L12:
        vma.f.a(r2, r3);
        r2.setIncludeFontPadding(false);
        r2.setSingleLine(true);
        r2.setTextAlignment(4);
        r2.setClickable(true);
        r2.setFocusable(true);
        r2.e = this.k;
        r2.requestLayout();
        r2.b();
        int r4 = this.f;
        int r5 = this.g;
        r2.c = r4;
        r2.d = r5;
        r2.b();
        r2.setOnClickListener(new t(this, r2));
        int r6 = this.k;
        addView(r2, new ViewGroup.LayoutParams(r6, r6));
        ((ArrayList) this.n).add(r2);
        goto L4
    L11:
        r3 = r2.b;
        goto L12
    }

    public final int getColumnCount() {
        return this.d;
    }

    public final PickerSelectionMode getSelectionMode() {
        return this.c;
    }

    public final void setColumnCount(int r2) {
        int r3 = RangesKt.coerceAtLeast(r2, 1);
        if (this.d != r3) goto L5;
        return;
    L5:
        this.d = r3;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.CheckedTextView, android.widget.TextView, androidx.appcompat.widget.AppCompatCheckedTextView, com.obric.oui.calendar.OMonthPickerView$a] */
    public final void setDayTextAppearance(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.j = r4;
        Iterator r5 = ((ArrayList) this.n).iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        ?? r0 = (a) r5.next();
        if (this.j == 0) goto L11;
        r0.setTextAppearance(getContext(), this.j);
    L11:
        if (r0.isChecked() == false) goto L13;
        int r1 = r0.a;
    L14:
        vma.f.a(r0, r1);
        r0.setIncludeFontPadding(false);
        goto L6
    L13:
        r1 = r0.b;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.CheckedTextView, com.obric.oui.calendar.OMonthPickerView$a] */
    public final void setItemDiameterDp(int r3) {
        this.k = pla.d.n(this, r3);
        Iterator r4 = ((ArrayList) this.n).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ?? r0 = (a) r4.next();
        r0.e = this.k;
        r0.requestLayout();
        r0.b();
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemPaddingDp(int r2) {
        this.l = pla.d.n(this, r2);
        this.m = pla.d.n(this, r2);
        requestLayout();
    }

    public final void setLabels(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "newLabels");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        List<Integer> r0 = getSelectedDays();
        if (r8.size() == getChildCount()) goto L8;
        boolean r1 = true;
    L9:
        this.e = CollectionsKt.toList(r8);
        if (r1 == false) goto L12;
        a();
    L19:
        ArrayList r9 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L21:
        if (r2.hasNext() == false) goto L30;
        Object r3 = r2.next();
        int r4 = ((Number) r3).intValue();
        if (r4 >= 0) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r5 == false) goto L21;
        r9.add(r3);
        goto L21
    L25:
        if (r4 >= this.e.size()) goto L27;
        r5 = true;
        goto L28
    L30:
        setSelectedDays(r9);
        requestLayout();
        return;
    L12:
        Iterator r10 = ((ArrayList) this.n).iterator();
        int r6 = 0;
    L14:
        if (r10.hasNext() == false) goto L19;
        Object r7 = r10.next();
        int r11 = r6 + 1;
        if (r6 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        ((a) r7).setText((CharSequence) ListProtector.get(this.e, r6));
        r6 = r11;
        goto L14
    L8:
        r1 = false;
        goto L9
    }

    public final void setSelectedDays(List<Integer> r7) {
        Intrinsics.checkNotNullParameter(r7, "days");
        int r2 = 0;
        if (this.c != PickerSelectionMode.SINGLE) goto L18;
        Integer r8 = (Integer) CollectionsKt.firstOrNull(r7);
        Iterator<T> r0 = this.n.iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L25;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        a r5 = (a) r3;
        if (r8 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        r5.setChecked(r6);
        r1 = r4;
        goto L6
    L14:
        if (r1 != r8.intValue()) goto L16;
        r6 = true;
        goto L17
    L25:
        return;
    L18:
        Set r9 = CollectionsKt.toSet(r7);
        Iterator<T> r10 = this.n.iterator();
    L20:
        if (r10.hasNext() == false) goto L32;
        Object r11 = r10.next();
        int r12 = r2 + 1;
        if (r2 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((a) r11).setChecked(r9.contains(Integer.valueOf(r2)));
        r2 = r12;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r6) {
        Intrinsics.checkNotNullParameter(r6, "mode");
        this.c = r6;
        if (r6 != PickerSelectionMode.SINGLE) goto L24;
        Iterator r7 = ((ArrayList) this.n).iterator();
        int r1 = 0;
    L6:
        if (r7.hasNext() == false) goto L11;
        if (((a) r7.next()).isChecked() == true) goto L12;
        r1 = r1 + 1;
    L12:
        Iterator<T> r8 = this.n.iterator();
        int r2 = 0;
    L14:
        if (r8.hasNext() == false) goto L30;
        Object r3 = r8.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        a r5 = (a) r3;
        if (r2 != r1) goto L22;
        if (r1 < 0) goto L22;
        boolean r9 = true;
    L23:
        r5.setChecked(r9);
        r2 = r4;
    L22:
        r9 = false;
        goto L23
    L30:
        return;
    L11:
        r1 = -1;
        goto L12
    }

    public final void setLabels(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        setLabels(ArraysKt.toList(r2));
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        int r0 = View.MeasureSpec.getSize(r8);
        int r2 = 0;
        if (View.MeasureSpec.getMode(r8) == 0) goto L14;
        if (r0 <= 0) goto L14;
        int r1 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r3 = this.d;
        int r4 = this.k;
        if (((r3 * r4) + ((r3 - 1) * this.l)) <= r1) goto L14;
        int r5 = r1 - (r4 * r3);
        if (r5 > 0) goto L10;
    L12:
        int r6 = 0;
    L13:
        this.l = r6;
        goto L14
    L10:
        if (r3 <= 1) goto L12;
        r6 = r5 / (r3 - 1);
    L14:
        setMeasuredDimension(ViewGroup.resolveSize((getPaddingLeft() + getFullRowWidth()) + getPaddingRight(), r8), ViewGroup.resolveSize((getPaddingTop() + getContentHeight()) + getPaddingBottom(), r9));
        int r10 = View.MeasureSpec.makeMeasureSpec(this.k, 1073741824);
        int r11 = getChildCount();
    L15:
        if (r2 >= r11) goto L17;
        getChildAt(r2).measure(r10, r10);
        r2 = r2 + 1;
        goto L15
    }

    public OMonthPickerView(Context r6, AttributeSet r7, int r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r8 = 2130972977;
    L9:
        if ((r9 & 8) == 0) goto L11;
        int r10 = 2131953063;
    L12:
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.a = r8;
        this.b = r10;
        this.c = PickerSelectionMode.MULTIPLE;
        this.d = 1;
        ArrayList r11 = new ArrayList(31);
        int r3 = 0;
    L13:
        if (r3 >= 31) goto L15;
        r3 = r3 + 1;
        r11.add(String.valueOf(r3));
        goto L13
    L15:
        this.e = r11;
        this.h = getResources().getInteger(2131427394);
        this.i = getResources().getInteger(2131427398);
        this.n = new ArrayList();
        TypedArray r12 = r6.obtainStyledAttributes(r7, new int[]{2130972894, 2130972920, 2130972921, 2130972922, 2130972923, 2130972924, 2130972925, 2130972926}, this.a, this.b);
    L46:
        th = move-exception;
        r12.recycle();
        throw th;
    L17:
        if (r12.hasValue(5) == false) goto L20;
        this.f = r12.getColor(5, this.f);     // Catch: Throwable -> L46
    L20:
        if (r12.hasValue(7) == false) goto L23;
        this.g = r12.getColor(7, this.g);     // Catch: Throwable -> L46
    L23:
        if (r12.hasValue(1) == false) goto L26;
        this.j = r12.getResourceId(1, this.j);     // Catch: Throwable -> L46
    L26:
        if (r12.hasValue(6) == false) goto L33;
        int r13 = r12.getInt(6, this.c.ordinal());     // Catch: Throwable -> L46
        PickerSelectionMode r14 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L46
        if (r13 == r14.ordinal()) goto L31;
        r14 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L46
    L31:
        this.c = r14;     // Catch: Throwable -> L46
    L33:
        if (r12.hasValue(0) == false) goto L36;
        this.d = RangesKt.coerceAtLeast(r12.getInt(0, this.d), 1);     // Catch: Throwable -> L46
    L36:
        if (r12.hasValue(3) == false) goto L39;
        this.k = r12.getDimensionPixelSize(3, this.k);     // Catch: Throwable -> L46
    L39:
        if (r12.hasValue(2) == false) goto L42;
        this.l = r12.getDimensionPixelSize(2, this.l);     // Catch: Throwable -> L46
    L42:
        if (r12.hasValue(4) == false) goto L44;
        this.m = r12.getDimensionPixelSize(4, this.m);     // Catch: Throwable -> L46
    L44:
        r12.recycle();
        setClipChildren(false);
        setClipToPadding(false);
        a();
        return;
    L11:
        r10 = 0;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        int r13 = r11 - r9;
        int r14 = (r13 - getPaddingLeft()) - getPaddingRight();
        int r15 = getFullRowWidth();
        int r16 = (r14 - r15) / 2;
        int r17 = getPaddingLeft() + RangesKt.coerceAtLeast(r16, 0);
        int r18 = (r13 - getPaddingRight()) - RangesKt.coerceAtLeast(r16, 0);
        int r19 = getChildCount();
        int r110 = 0;
    L3:
        if (r110 >= r19) goto L12;
        int r0 = r110 + 1;
        View r1 = getChildAt(r110);
        int r2 = this.d;
        int r3 = r110 / r2;
        int r111 = r110 % r2;
        int r4 = getPaddingTop() + (r3 * (this.k + this.m));
        boolean r5 = true;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L8;
        r5 = false;
    L8:
        if (r5 == false) goto L10;
        int r6 = this.k;
        int r112 = r18 - (r111 * (this.l + r6));
        int r7 = r112 - r6;
    L11:
        r1.layout(r7, r4, r112, this.k + r4);
        r110 = r0;
        goto L3
    L10:
        int r20 = this.k;
        int r113 = (r111 * (this.l + r20)) + r17;
        int r21 = r20 + r113;
        r7 = r113;
        r112 = r21;
        goto L11
    }
}
