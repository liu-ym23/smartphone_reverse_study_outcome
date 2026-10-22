package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$integer;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001e\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\nJ\u001b\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0004\b\u001b\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c¢\u0006\u0004\b\u001b\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "", "setSelectionMode", "(Lcom/obric/oui/calendar/PickerSelectionMode;)V", "", "resourceId", "setDayTextAppearance", "(I)V", "itemDiameterDp", "setItemSizeDp", "itemPaddingDp", "setItemHorizontalPaddingDp", "Lcom/obric/oui/calendar/x;", "listener", "setOnDaysChangedListener", "(Lcom/obric/oui/calendar/x;)V", "first", "setFirstDayOfWeek", "", "days", "setSelectedDays", "(Ljava/util/List;)V", "", "newLabels", "setLabels", "", "([Ljava/lang/String;)V", "com/obric/oui/calendar/w", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OWeekPickerView extends LinearLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f12228m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PickerSelectionMode f12229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12231c;
    public final int d;
    public final int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String[] f12234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f12235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f12236l;

    @JvmOverloads
    public OWeekPickerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    public static String[] c(int r10, Context r11) {
        String[] r5 = new String[7];
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= 7) goto L6;
        r5[r13] = "";
        r13 = r13 + 1;
    L6:
        if (r12 >= 7) goto L18;
        int r14 = r12 + 1;
        switch(r10) {
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
        String r15 = "";
    L17:
        r5[r12] = r15;
        r10 = (r10 % 7) + 1;
        r12 = r14;
        goto L6
    L10:
        r15 = r11.getString(R$string.oui_calendar_day_of_week_sat);
        goto L17
    L11:
        r15 = r11.getString(R$string.oui_calendar_day_of_week_fri);
        goto L17
    L12:
        r15 = r11.getString(R$string.oui_calendar_day_of_week_thu);
        goto L17
    L13:
        r15 = r11.getString(R$string.oui_calendar_day_of_week_wed);
        goto L17
    L14:
        r15 = r11.getString(R$string.oui_calendar_day_of_week_tue);
        goto L17
    L15:
        r15 = r11.getString(R$string.oui_calendar_day_of_week_mon);
        goto L17
    L16:
        r15 = r11.getString(R$string.oui_calendar_day_of_week_sun);
        goto L17
    L18:
        return r5;
    }

    public final void a() {
        removeAllViews();
        ArrayList r5 = this.f12235k;
        r5.clear();
        int r10 = this.f12234j.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L23;
        int r12 = r11 + 1;
        w r13 = new w(getContext(), this.d, this.e);
        r13.setText(this.f12234j[r11]);
        r13.setGravity(17);
        if (this.f == 0) goto L8;
        r13.setTextAppearance(getContext(), this.f);
    L8:
        if (r13.isChecked() == false) goto L10;
        int r14 = r13.f12301a;
    L11:
        ym.m.m(r13, r14);
        r13.setSingleLine(true);
        r13.setTextAlignment(4);
        r13.setClickable(true);
        r13.setFocusable(true);
        if (((Boolean) this.f12236l.get(r11)).booleanValue() == false) goto L14;
        float r15 = 1.0f;
    L15:
        r13.setAlpha(r15);
        r13.e = this.g;
        r13.requestLayout();
        r13.b();
        int r16 = this.f12230b;
        int r17 = this.f12231c;
        r13.f12303c = r16;
        r13.d = r17;
        r13.b();
        r13.setChecked(false);
        r13.setOnClickListener(new com.obric.clockwidgets.ui.b(this, r11, r13, 1));
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        int r19 = this.f12232h / 2;
        if (r11 != 0) goto L18;
        int r20 = 0;
    L20:
        if (r11 != ArraysKt.getLastIndex(this.f12234j)) goto L22;
        r19 = 0;
    L22:
        r18.setMargins(r20, 0, r19, 0);
        r18.gravity = 17;
        addView(r13, r18);
        r5.add(r13);
        r11 = r12;
        goto L3
    L18:
        r20 = r19;
        goto L20
    L14:
        r15 = 0.45f;
        goto L15
    L10:
        r14 = r13.f12302b;
        goto L11
    }

    public final void b() {
        ArrayList r5 = new ArrayList();
        Iterator r10 = this.f12235k.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((w) r12).isChecked() == false) goto L11;
        r5.add(Integer.valueOf(r11));
    L11:
        r11 = r13;
        goto L4
    }

    public final void d(int r10) {
        int r11 = r10 / 2;
        int r5 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L21;
        int r13 = r12 + 1;
        View r14 = getChildAt(r12);
        if (r14 == null) goto L18;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L20;
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r15;
        if (r12 != 0) goto L12;
        int r17 = 0;
    L14:
        if (r12 != (getChildCount() - 1)) goto L16;
        int r18 = 0;
    L17:
        r16.setMargins(r17, 0, r18, 0);
        r14.setLayoutParams(r16);
        goto L18
    L16:
        r18 = r11;
        goto L17
    L12:
        r17 = r11;
        goto L14
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L18:
        r12 = r13;
        goto L3
    }

    public final void e(String[] r10) {
        ArrayList r5 = this.f12235k;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r5.iterator();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L16;
        Object r15 = r12.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((w) r15).isChecked() == false) goto L11;
        Integer r17 = Integer.valueOf(r14);
    L12:
        if (r17 == null) goto L14;
        r11.add(r17);
    L14:
        r14 = r16;
        goto L4
    L11:
        r17 = null;
        goto L12
    L16:
        if (r10.length == getChildCount()) goto L18;
        boolean r18 = true;
    L19:
        String[] r19 = (String[]) Arrays.copyOf(r10, r10.length);
        this.f12234j = r19;
        if (r18 == false) goto L29;
        int r20 = r19.length;
        ArrayList r21 = this.f12236l;
        List r22 = CollectionsKt.toList(r21);
        r21.clear();
    L22:
        if (r13 >= r20) goto L28;
        Boolean r23 = (Boolean) CollectionsKt.getOrNull(r22, r13);
        if (r23 != null) goto L26;
        boolean r24 = true;
    L27:
        r21.add(Boolean.valueOf(r24));
        r13 = r13 + 1;
        goto L22
    L26:
        r24 = r23.booleanValue();
        goto L27
    L28:
        a();
    L36:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r11.iterator();
    L38:
        if (r26.hasNext() == false) goto L44;
        Object r27 = r26.next();
        int r28 = ((Number) r27).intValue();
        if (r28 < 0) goto L38;
        if (r28 >= this.f12234j.length) goto L38;
        r25.add(r27);
        goto L38
    L44:
        setSelectedDays(r25);
        requestLayout();
        return;
    L29:
        Iterator r29 = r5.iterator();
    L31:
        if (r29.hasNext() == false) goto L36;
        Object r30 = r29.next();
        int r31 = r13 + 1;
        if (r13 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        ((w) r30).setText(this.f12234j[r13]);
        r13 = r31;
        goto L31
    L18:
        r18 = false;
        goto L19
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        int r5 = View.MeasureSpec.getSize(r10);
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = this.f12232h;
        if (r12 == 0) goto L12;
        if (r5 <= 0) goto L12;
        int r14 = (r5 - getPaddingLeft()) - getPaddingRight();
        int r15 = getChildCount();
        int r16 = RangesKt.coerceAtLeast(r15 - 1, 0);
        int r17 = this.g;
        if (((this.f12232h * r16) + (r15 * r17)) <= r14) goto L12;
        int r18 = r14 - (r15 * r17);
        if (r18 <= 0) goto L11;
        if (r16 <= 0) goto L11;
        r13 = r18 / r16;
    L11:
        r13 = 0;
    L12:
        d(r13);
        super.onMeasure(r10, r11);
    }

    public final void setDayTextAppearance(@StyleRes int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        this.f = r5;
        Iterator r10 = this.f12235k.iterator();
    L6:
        if (r10.hasNext() == false) goto L15;
        w r11 = (w) r10.next();
        if (this.f == 0) goto L11;
        r11.setTextAppearance(getContext(), this.f);
    L11:
        if (r11.isChecked() == false) goto L13;
        int r12 = r11.f12301a;
    L14:
        ym.m.m(r11, r12);
        goto L6
    L13:
        r12 = r11.f12302b;
        goto L14
    }

    public final void setFirstDayOfWeek(int r5) {
        this.f12233i = r5;
        Context r10 = getContext();
        e(c(this.f12233i, r10));
    }

    public final void setItemHorizontalPaddingDp(int r5) {
        int r10 = com.lynx.tasm.utils.a.B(r5, this);
        this.f12232h = r10;
        d(r10);
    }

    public final void setItemSizeDp(int r5) {
        this.g = com.lynx.tasm.utils.a.B(r5, this);
        Iterator r10 = this.f12235k.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        w r11 = (w) r10.next();
        r11.e = this.g;
        r11.requestLayout();
        r11.b();
        goto L4
    L6:
        requestLayout();
    }

    public final void setLabels(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "newLabels");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r10 = r5.toArray(new String[0]);
        if (r10 == null) goto L10;
        e((String[]) r10);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void setOnDaysChangedListener(x r5) {
    }

    public final void setSelectedDays(List<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "days");
        PickerSelectionMode r5 = this.f12229a;
        PickerSelectionMode r11 = PickerSelectionMode.SINGLE;
        ArrayList r12 = this.f12235k;
        int r13 = 0;
        if (r5 != r11) goto L18;
        Integer r14 = (Integer) CollectionsKt.firstOrNull(r10);
        Iterator r15 = r12.iterator();
        int r16 = 0;
    L6:
        if (r15.hasNext() == false) goto L25;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        w r19 = (w) r17;
        if (r14 != null) goto L14;
    L16:
        boolean r20 = false;
    L17:
        r19.setChecked(r20);
        r16 = r18;
        goto L6
    L14:
        if (r16 != r14.intValue()) goto L16;
        r20 = true;
    L25:
        b();
        return;
    L18:
        Iterator r21 = r12.iterator();
    L20:
        if (r21.hasNext() == false) goto L25;
        Object r22 = r21.next();
        int r23 = r13 + 1;
        if (r13 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((w) r22).setChecked(r10.contains(Integer.valueOf(r13)));
        r13 = r23;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        this.f12229a = r10;
        if (r10 != PickerSelectionMode.SINGLE) goto L31;
        ArrayList r11 = this.f12235k;
        Iterator r5 = r11.iterator();
        int r12 = 0;
    L6:
        if (r5.hasNext() == false) goto L11;
        if (((w) r5.next()).isChecked() == true) goto L12;
        r12 = r12 + 1;
    L12:
        Iterator r13 = r11.iterator();
        int r14 = 0;
    L14:
        if (r13.hasNext() == false) goto L24;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        w r17 = (w) r15;
        if (r14 != r12) goto L22;
        if (r12 < 0) goto L22;
        boolean r18 = true;
    L23:
        r17.setChecked(r18);
        r14 = r16;
    L22:
        r18 = false;
        goto L23
    L24:
        b();
        return;
    L11:
        r12 = -1;
        goto L12
    }

    @JvmOverloads
    public OWeekPickerView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OWeekPickerView(Context r5, AttributeSet r10, @AttrRes int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OWeekPickerView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = R$attr.oweekPickerViewStyle;
    L8:
        int r13 = R$style.OStyleV2_OWeekPickerView_DayNight;
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        PickerSelectionMode r14 = PickerSelectionMode.MULTIPLE;
        this.f12229a = r14;
        this.d = getResources().getInteger(R$integer.oui_font_weight_bold);
        this.e = getResources().getInteger(R$integer.oui_font_weight_regular);
        this.f12233i = 2;
        this.f12234j = c(2, r5);
        this.f12235k = new ArrayList();
        ArrayList r15 = new ArrayList();
        this.f12236l = r15;
        TypedArray r16 = r5.obtainStyledAttributes(r10, R$styleable.OWeekPickerView, r11, r13);
    L12:
        th = move-exception;
        r16.recycle();
        throw th;
    L10:
        if (r16.hasValue(R$styleable.OWeekPickerView_o_pv_selectedBackgroundColor) == false) goto L15;
        this.f12230b = r16.getColor(R$styleable.OWeekPickerView_o_pv_selectedBackgroundColor, this.f12230b);     // Catch: Throwable -> L12
    L15:
        if (r16.hasValue(R$styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor) == false) goto L18;
        this.f12231c = r16.getColor(R$styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor, this.f12231c);     // Catch: Throwable -> L12
    L18:
        if (r16.hasValue(R$styleable.OWeekPickerView_o_pv_dayTextAppearance) == false) goto L21;
        this.f = r16.getResourceId(R$styleable.OWeekPickerView_o_pv_dayTextAppearance, this.f);     // Catch: Throwable -> L12
    L21:
        if (r16.hasValue(R$styleable.OWeekPickerView_o_pv_selectionMode) == false) goto L27;
        int r17 = r16.getInt(R$styleable.OWeekPickerView_o_pv_selectionMode, this.f12229a.ordinal());     // Catch: Throwable -> L12
        PickerSelectionMode r18 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L12
        if (r17 != r18.ordinal()) goto L25;
        r14 = r18;
    L25:
        this.f12229a = r14;     // Catch: Throwable -> L12
    L27:
        if (r16.hasValue(R$styleable.OWeekPickerView_o_pv_itemSize) == false) goto L30;
        this.g = r16.getDimensionPixelSize(R$styleable.OWeekPickerView_o_pv_itemSize, this.g);     // Catch: Throwable -> L12
    L30:
        if (r16.hasValue(R$styleable.OWeekPickerView_o_pv_itemHPadding) == false) goto L33;
        this.f12232h = r16.getDimensionPixelSize(R$styleable.OWeekPickerView_o_pv_itemHPadding, this.f12232h);     // Catch: Throwable -> L12
    L33:
        if (r16.hasValue(R$styleable.OWeekPickerView_o_wpv_firstDayOfWeek) == false) goto L35;
        this.f12233i = r16.getInt(R$styleable.OWeekPickerView_o_wpv_firstDayOfWeek, this.f12233i);     // Catch: Throwable -> L12
    L35:
        r16.recycle();
        this.f12234j = c(this.f12233i, r5);
        r15.clear();
        int r19 = 0;
    L37:
        if (r19 >= 7) goto L39;
        r15.add(Boolean.TRUE);
        r19 = r19 + 1;
        goto L37
    L39:
        setOrientation(0);
        setGravity(17);
        a();
    }

    public final void setLabels(String[] r5) {
        Intrinsics.checkNotNullParameter(r5, "newLabels");
        setLabels(ArraysKt.toList(r5));
    }
}
