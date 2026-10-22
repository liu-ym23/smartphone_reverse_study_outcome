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
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001a\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u0014\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\u0014\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\u001b\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0004\b\u0017\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "", "setSelectionMode", "", "resourceId", "setDayTextAppearance", "itemDiameterDp", "setItemSizeDp", "itemPaddingDp", "setItemHorizontalPaddingDp", "Lcom/obric/oui/calendar/OWeekPickerView$b;", "listener", "setOnDaysChangedListener", "first", "setFirstDayOfWeek", "", "days", "setSelectedDays", "", "newLabels", "setLabels", "", "([Ljava/lang/String;)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OWeekPickerView extends LinearLayout {
    public static final /* synthetic */ int n = 0;
    public PickerSelectionMode a;
    public int b;
    public int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public b i;
    public int j;
    public String[] k;
    public final List<a> l;
    public final List<Boolean> m;

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
            int r0 = this.e;
            setMeasuredDimension(CheckedTextView.resolveSize(r0, r2), CheckedTextView.resolveSize(r0, r3));
        }

        public a(Context r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.a = r3;
            this.b = r4;
        }
    }

    public interface b {
        void onChanged(List<Integer> r1);
    }

    public OWeekPickerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public OWeekPickerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public OWeekPickerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final void b() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.l.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) r3).isChecked() == false) goto L11;
        r0.add(Integer.valueOf(r2));
    L11:
        r2 = r4;
        goto L4
    L12:
        b r5 = this.i;
        if (r5 == null) goto L20;
        r5.onChanged(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View, android.widget.CheckedTextView, android.widget.TextView, androidx.appcompat.widget.AppCompatCheckedTextView, com.obric.oui.calendar.OWeekPickerView$a, java.lang.Object] */
    public final void a() {
        removeAllViews();
        ((ArrayList) this.l).clear();
        int r0 = this.k.length;
        final int r2 = 0;
    L3:
        if (r2 >= r0) goto L23;
        int r3 = r2 + 1;
        final ?? r4 = new a(getContext(), this.d, this.e);
        r4.setText(this.k[r2]);
        r4.setGravity(17);
        if (this.f == 0) goto L8;
        r4.setTextAppearance(getContext(), this.f);
    L8:
        if (r4.isChecked() == false) goto L10;
        int r6 = r4.a;
    L11:
        vma.f.a(r4, r6);
        r4.setSingleLine(true);
        r4.setTextAlignment(4);
        r4.setClickable(true);
        r4.setFocusable(true);
        if (((Boolean) ListProtector.get(this.m, r2)).booleanValue() == false) goto L14;
        float r7 = 1.0f;
    L15:
        r4.setAlpha(r7);
        r4.e = this.g;
        r4.requestLayout();
        r4.b();
        int r8 = this.b;
        int r9 = this.c;
        r4.c = r8;
        r4.d = r9;
        r4.b();
        r4.setChecked(false);
        r4.setOnClickListener(new u(this, r2, r4));
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        int r11 = this.h / 2;
        if (r2 != 0) goto L18;
        int r12 = 0;
    L20:
        if (r2 != ArraysKt.getLastIndex(this.k)) goto L22;
        r11 = 0;
    L22:
        r10.setMargins(r12, 0, r11, 0);
        r10.gravity = 17;
        addView(r4, r10);
        ((ArrayList) this.l).add(r4);
        r2 = r3;
        goto L3
    L18:
        r12 = r11;
        goto L20
    L14:
        r7 = 0.45f;
        goto L15
    L10:
        r6 = r4.b;
        goto L11
    }

    public final void d(int r9) {
        int r10 = r9 / 2;
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        int r3 = r2 + 1;
        View r4 = getChildAt(r2);
        if (r4 == null) goto L18;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L20;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        if (r2 != 0) goto L12;
        int r7 = 0;
    L14:
        if (r2 != (getChildCount() - 1)) goto L16;
        int r8 = 0;
    L17:
        r6.setMargins(r7, 0, r8, 0);
        r4.setLayoutParams(r6);
        goto L18
    L16:
        r8 = r10;
        goto L17
    L12:
        r7 = r10;
        goto L14
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L18:
        r2 = r3;
        goto L3
    }

    public final void e(String[] r8) {
        List<a> r0 = this.l;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) r0).iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L16;
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
    L16:
        if (r8.length == getChildCount()) goto L18;
        boolean r7 = true;
    L19:
        String[] r9 = (String[]) Arrays.copyOf(r8, r8.length);
        this.k = r9;
        if (r7 == false) goto L29;
        int r10 = r9.length;
        List r11 = CollectionsKt.toList(this.m);
        ((ArrayList) this.m).clear();
        int r12 = 0;
    L22:
        if (r12 >= r10) goto L28;
        List<Boolean> r13 = this.m;
        Boolean r14 = (Boolean) CollectionsKt.getOrNull(r11, r12);
        if (r14 != null) goto L26;
        boolean r15 = true;
    L27:
        ArrayList r16 = (ArrayList) r13;
        r16.add(Boolean.valueOf(r15));
        r12 = r12 + 1;
        goto L22
    L26:
        r15 = r14.booleanValue();
        goto L27
    L28:
        a();
    L36:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r1.iterator();
    L38:
        if (r18.hasNext() == false) goto L47;
        Object r19 = r18.next();
        int r20 = ((Number) r19).intValue();
        if (r20 >= 0) goto L42;
    L44:
        boolean r21 = false;
    L45:
        if (r21 == false) goto L38;
        r17.add(r19);
        goto L38
    L42:
        if (r20 >= this.k.length) goto L44;
        r21 = true;
        goto L45
    L47:
        setSelectedDays(r17);
        requestLayout();
        return;
    L29:
        Iterator r22 = ((ArrayList) this.l).iterator();
        int r23 = 0;
    L31:
        if (r22.hasNext() == false) goto L36;
        Object r24 = r22.next();
        int r25 = r23 + 1;
        if (r23 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        ((a) r24).setText(this.k[r23]);
        r23 = r25;
        goto L31
    L18:
        r7 = false;
        goto L19
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.CheckedTextView, android.widget.TextView, androidx.appcompat.widget.AppCompatCheckedTextView, com.obric.oui.calendar.OWeekPickerView$a] */
    public final void setDayTextAppearance(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.f = r4;
        Iterator r5 = ((ArrayList) this.l).iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        ?? r0 = (a) r5.next();
        if (this.f == 0) goto L11;
        r0.setTextAppearance(getContext(), this.f);
    L11:
        if (r0.isChecked() == false) goto L13;
        int r1 = r0.a;
    L14:
        vma.f.a(r0, r1);
        goto L6
    L13:
        r1 = r0.b;
        goto L14
    }

    public final void setFirstDayOfWeek(int r2) {
        this.j = r2;
        e(c(getContext(), this.j));
    }

    public final void setItemHorizontalPaddingDp(int r1) {
        int r2 = pla.d.n(this, r1);
        this.h = r2;
        d(r2);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.CheckedTextView, com.obric.oui.calendar.OWeekPickerView$a] */
    public final void setItemSizeDp(int r3) {
        this.g = pla.d.n(this, r3);
        Iterator r4 = ((ArrayList) this.l).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ?? r0 = (a) r4.next();
        r0.e = this.g;
        r0.requestLayout();
        r0.b();
        goto L4
    L6:
        requestLayout();
    }

    public final void setLabels(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r3 = r2.toArray(new String[0]);
        if (r3 == null) goto L10;
        e((String[]) r3);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void setOnDaysChangedListener(b r1) {
        this.i = r1;
    }

    public final void setSelectedDays(List<Integer> r7) {
        Intrinsics.checkNotNullParameter(r7, "days");
        int r2 = 0;
        if (this.a != PickerSelectionMode.SINGLE) goto L18;
        Integer r8 = (Integer) CollectionsKt.firstOrNull(r7);
        Iterator<T> r0 = this.l.iterator();
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
    L25:
        b();
        return;
    L18:
        Iterator<T> r9 = this.l.iterator();
    L20:
        if (r9.hasNext() == false) goto L25;
        Object r10 = r9.next();
        int r11 = r2 + 1;
        if (r2 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((a) r10).setChecked(r7.contains(Integer.valueOf(r2)));
        r2 = r11;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r6) {
        Intrinsics.checkNotNullParameter(r6, "mode");
        this.a = r6;
        if (r6 != PickerSelectionMode.SINGLE) goto L31;
        Iterator r7 = ((ArrayList) this.l).iterator();
        int r1 = 0;
    L6:
        if (r7.hasNext() == false) goto L11;
        if (((a) r7.next()).isChecked() == true) goto L12;
        r1 = r1 + 1;
    L12:
        Iterator<T> r8 = this.l.iterator();
        int r2 = 0;
    L14:
        if (r8.hasNext() == false) goto L24;
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
    L24:
        b();
        return;
    L11:
        r1 = -1;
        goto L12
    }

    public final void setLabels(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        setLabels(ArraysKt.toList(r2));
    }

    public static String[] c(Context r7, int r8) {
        String[] r1 = new String[7];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 7) goto L6;
        r1[r3] = "";
        r3 = r3 + 1;
    L6:
        if (r2 >= 7) goto L28;
        int r4 = r2 + 1;
        switch(r8) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L9;
        };
    L9:
        String r5 = "";
    L18:
        if (vma.h.b(r7.getResources().getConfiguration().fontScale) == false) goto L27;
        Character r6 = StringsKt.firstOrNull(r5);
        if (r6 == null) goto L27;
        String r9 = Character.valueOf(Character.toUpperCase(r6.charValue())).toString();
        if (r9 == null) goto L27;
        r5 = r9;
    L27:
        r1[r2] = r5;
        r8 = (r8 % 7) + 1;
        r2 = r4;
        goto L6
    L10:
        r5 = r7.getString(2131912794);
        goto L18
    L11:
        r5 = r7.getString(2131912792);
        goto L18
    L12:
        r5 = r7.getString(2131912796);
        goto L18
    L13:
        r5 = r7.getString(2131912798);
        goto L18
    L14:
        r5 = r7.getString(2131912797);
        goto L18
    L15:
        r5 = r7.getString(2131912793);
        goto L18
    L16:
        r5 = r7.getString(2131912795);
        goto L18
    L28:
        return r1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getSize(r9);
        int r1 = View.MeasureSpec.getMode(r9);
        int r2 = this.h;
        if (r1 == 0) goto L12;
        if (r0 <= 0) goto L12;
        int r3 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r4 = getChildCount();
        int r5 = RangesKt.coerceAtLeast(r4 - 1, 0);
        int r6 = this.g;
        if (((r4 * r6) + (this.h * r5)) <= r3) goto L12;
        int r7 = r3 - (r4 * r6);
        if (r7 <= 0) goto L11;
        if (r5 <= 0) goto L11;
        r2 = r7 / r5;
    L11:
        r2 = 0;
    L12:
        d(r2);
        super.onMeasure(r9, r10);
    }

    public OWeekPickerView(Context r7, AttributeSet r8, int r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r9 = 2130973425;
    L9:
        if ((r10 & 8) == 0) goto L11;
        int r11 = 2131953123;
    L12:
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        PickerSelectionMode r1 = PickerSelectionMode.MULTIPLE;
        this.a = r1;
        this.d = getResources().getInteger(2131427394);
        this.e = getResources().getInteger(2131427398);
        this.j = 2;
        this.k = c(r7, 2);
        this.l = new ArrayList();
        ArrayList r3 = new ArrayList();
        this.m = r3;
        TypedArray r12 = r7.obtainStyledAttributes(r8, new int[]{2130972920, 2130972921, 2130972922, 2130972924, 2130972925, 2130972926, 2130972927}, r9, r11);
    L42:
        th = move-exception;
        r12.recycle();
        throw th;
    L14:
        if (r12.hasValue(3) == false) goto L17;
        this.b = r12.getColor(3, this.b);     // Catch: Throwable -> L42
    L17:
        if (r12.hasValue(5) == false) goto L20;
        this.c = r12.getColor(5, this.c);     // Catch: Throwable -> L42
    L20:
        if (r12.hasValue(0) == false) goto L23;
        this.f = r12.getResourceId(0, this.f);     // Catch: Throwable -> L42
    L23:
        if (r12.hasValue(4) == false) goto L29;
        int r13 = r12.getInt(4, this.a.ordinal());     // Catch: Throwable -> L42
        PickerSelectionMode r14 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L42
        if (r13 != r14.ordinal()) goto L27;
        r1 = r14;
    L27:
        this.a = r1;     // Catch: Throwable -> L42
    L29:
        if (r12.hasValue(2) == false) goto L32;
        this.g = r12.getDimensionPixelSize(2, this.g);     // Catch: Throwable -> L42
    L32:
        if (r12.hasValue(1) == false) goto L35;
        this.h = r12.getDimensionPixelSize(1, this.h);     // Catch: Throwable -> L42
    L35:
        if (r12.hasValue(6) == false) goto L37;
        this.j = r12.getInt(6, this.j);     // Catch: Throwable -> L42
    L37:
        r12.recycle();
        this.k = c(r7, this.j);
        r3.clear();
        int r15 = 0;
    L38:
        if (r15 >= 7) goto L40;
        List<Boolean> r16 = this.m;
        ArrayList r17 = (ArrayList) r16;
        r17.add(Boolean.TRUE);
        r15 = r15 + 1;
        goto L38
    L40:
        setOrientation(0);
        setGravity(17);
        a();
        return;
    L11:
        r11 = 0;
        goto L12
    }
}
