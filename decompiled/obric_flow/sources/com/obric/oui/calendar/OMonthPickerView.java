package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.text.TextUtilsCompat;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$integer;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0002)\u001bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0004\b\u0012\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u0019\u0010\u0013J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u001a\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010\fJ\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b\"\u0010\fJ\u0015\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\t¢\u0006\u0004\b$\u0010\fJ\u000f\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010\u000eJ\u000f\u0010(\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010\u000e¨\u0006*"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView;", "Landroid/view/ViewGroup;", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "", "setSelectionMode", "(Lcom/obric/oui/calendar/PickerSelectionMode;)V", "getSelectionMode", "()Lcom/obric/oui/calendar/PickerSelectionMode;", "", "count", "setColumnCount", "(I)V", "getColumnCount", "()I", "", "", "newLabels", "setLabels", "(Ljava/util/List;)V", "", "([Ljava/lang/String;)V", "getLabels", "()Ljava/util/List;", "days", "setSelectedDays", "getSelectedDays", "Lcom/obric/oui/calendar/v;", "listener", "setOnDaysChangedListener", "(Lcom/obric/oui/calendar/v;)V", "resourceId", "setDayTextAppearance", "itemDiameterDp", "setItemDiameterDp", "itemPaddingDp", "setItemPaddingDp", "getRowCount", "getFullRowWidth", "getContentHeight", "getDayCount", "com/obric/oui/calendar/u", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMonthPickerView extends ViewGroup {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f12217o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PickerSelectionMode f12220c;
    public int d;
    public List e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12225l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f12227n;

    @JvmOverloads
    public OMonthPickerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    private final int getContentHeight() {
        return ((getRowCount() - 1) * this.f12226m) + (getRowCount() * this.f12224k);
    }

    private final int getDayCount() {
        return this.e.size();
    }

    private final int getFullRowWidth() {
        int r5 = this.d;
        return ((r5 - 1) * this.f12225l) + (this.f12224k * r5);
    }

    private final int getRowCount() {
        int r5 = getDayCount();
        int r10 = this.d;
        return ((r5 + r10) - 1) / r10;
    }

    public final void a() {
        removeAllViews();
        ArrayList r5 = this.f12227n;
        r5.clear();
        Iterator r10 = this.e.iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        String r11 = (String) r10.next();
        u r12 = new u(getContext(), this.f12221h, this.f12222i);
        r12.setText(r11);
        r12.setGravity(17);
        if (this.f12223j == 0) goto L9;
        r12.setTextAppearance(getContext(), this.f12223j);
    L9:
        if (r12.isChecked() == false) goto L11;
        int r13 = r12.f12298a;
    L12:
        ym.m.m(r12, r13);
        r12.setIncludeFontPadding(false);
        r12.setSingleLine(true);
        r12.setTextAlignment(4);
        r12.setClickable(true);
        r12.setFocusable(true);
        r12.e = this.f12224k;
        r12.requestLayout();
        r12.b();
        int r14 = this.f;
        int r15 = this.g;
        r12.f12300c = r14;
        r12.d = r15;
        r12.b();
        r12.setOnClickListener(new com.google.android.material.snackbar.a(2, this, r12));
        int r16 = this.f12224k;
        addView(r12, new ViewGroup.LayoutParams(r16, r16));
        r5.add(r12);
        goto L4
    L11:
        r13 = r12.f12299b;
        goto L12
    }

    public final int getColumnCount() {
        return this.d;
    }

    public final List<String> getLabels() {
        return CollectionsKt.toList(this.e);
    }

    public final List<Integer> getSelectedDays() {
        ArrayList r5 = this.f12227n;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L15;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((u) r13).isChecked() == false) goto L11;
        Integer r15 = Integer.valueOf(r12);
    L12:
        if (r15 == null) goto L14;
        r10.add(r15);
    L14:
        r12 = r14;
        goto L4
    L11:
        r15 = null;
        goto L12
    L15:
        return r10;
    }

    public final PickerSelectionMode getSelectionMode() {
        return this.f12220c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = r13 - r11;
        int r16 = (r15 - getPaddingLeft()) - getPaddingRight();
        int r17 = getFullRowWidth();
        int r18 = getPaddingLeft();
        int r19 = (r16 - r17) / 2;
        int r20 = 0;
        int r110 = RangesKt.coerceAtLeast(r19, 0) + r18;
        int r111 = (r15 - getPaddingRight()) - RangesKt.coerceAtLeast(r19, 0);
        int r21 = getChildCount();
    L3:
        if (r20 >= r21) goto L9;
        int r22 = r20 + 1;
        View r5 = getChildAt(r20);
        int r23 = this.d;
        int r24 = r20 / r23;
        int r25 = r20 % r23;
        int r26 = getPaddingTop();
        int r27 = ((this.f12224k + this.f12226m) * r24) + r26;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L7;
        int r28 = this.f12224k;
        int r29 = r111 - ((this.f12225l + r28) * r25);
        int r30 = r29 - r28;
    L8:
        r5.layout(r30, r27, r29, this.f12224k + r27);
        r20 = r22;
        goto L3
    L7:
        int r31 = this.f12224k;
        int r32 = ((this.f12225l + r31) * r25) + r110;
        int r33 = r31 + r32;
        r30 = r32;
        r29 = r33;
        goto L8
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        int r5 = View.MeasureSpec.getSize(r10);
        int r12 = 0;
        if (View.MeasureSpec.getMode(r10) == 0) goto L14;
        if (r5 <= 0) goto L14;
        int r13 = (r5 - getPaddingLeft()) - getPaddingRight();
        int r14 = this.d;
        int r15 = this.f12224k;
        if ((((r14 - 1) * this.f12225l) + (r14 * r15)) <= r13) goto L14;
        int r16 = r13 - (r15 * r14);
        if (r16 > 0) goto L10;
    L12:
        int r17 = 0;
    L13:
        this.f12225l = r17;
        goto L14
    L10:
        if (r14 <= 1) goto L12;
        r17 = r16 / (r14 - 1);
    L14:
        setMeasuredDimension(View.resolveSize(getPaddingRight() + (getPaddingLeft() + getFullRowWidth()), r10), View.resolveSize(getPaddingBottom() + (getPaddingTop() + getContentHeight()), r11));
        int r18 = View.MeasureSpec.makeMeasureSpec(this.f12224k, BasicMeasure.EXACTLY);
        int r19 = getChildCount();
    L15:
        if (r12 >= r19) goto L17;
        getChildAt(r12).measure(r18, r18);
        r12 = r12 + 1;
        goto L15
    }

    public final void setColumnCount(int r5) {
        int r10 = RangesKt.coerceAtLeast(r5, 1);
        if (this.d != r10) goto L5;
        return;
    L5:
        this.d = r10;
        requestLayout();
    }

    public final void setDayTextAppearance(@StyleRes int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        this.f12223j = r5;
        Iterator r10 = this.f12227n.iterator();
    L6:
        if (r10.hasNext() == false) goto L15;
        u r11 = (u) r10.next();
        if (this.f12223j == 0) goto L11;
        r11.setTextAppearance(getContext(), this.f12223j);
    L11:
        if (r11.isChecked() == false) goto L13;
        int r12 = r11.f12298a;
    L14:
        ym.m.m(r11, r12);
        r11.setIncludeFontPadding(false);
        goto L6
    L13:
        r12 = r11.f12299b;
        goto L14
    }

    public final void setItemDiameterDp(int r5) {
        this.f12224k = com.lynx.tasm.utils.a.B(r5, this);
        Iterator r10 = this.f12227n.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        u r11 = (u) r10.next();
        r11.e = this.f12224k;
        r11.requestLayout();
        r11.b();
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemPaddingDp(int r5) {
        this.f12225l = com.lynx.tasm.utils.a.B(r5, this);
        this.f12226m = com.lynx.tasm.utils.a.B(r5, this);
        requestLayout();
    }

    public final void setLabels(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "newLabels");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        List<Integer> r5 = getSelectedDays();
        int r11 = 0;
        if (r10.size() == getChildCount()) goto L8;
        boolean r12 = true;
    L9:
        this.e = CollectionsKt.toList(r10);
        if (r12 == false) goto L12;
        a();
    L19:
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r5.iterator();
    L21:
        if (r14.hasNext() == false) goto L27;
        Object r15 = r14.next();
        int r16 = ((Number) r15).intValue();
        if (r16 < 0) goto L21;
        if (r16 >= this.e.size()) goto L21;
        r13.add(r15);
        goto L21
    L27:
        setSelectedDays(r13);
        requestLayout();
        return;
    L12:
        Iterator r17 = this.f12227n.iterator();
    L14:
        if (r17.hasNext() == false) goto L19;
        Object r18 = r17.next();
        int r19 = r11 + 1;
        if (r11 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        ((u) r18).setText((CharSequence) this.e.get(r11));
        r11 = r19;
        goto L14
    L8:
        r12 = false;
        goto L9
    }

    public final void setOnDaysChangedListener(v r5) {
    }

    public final void setSelectedDays(List<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "days");
        PickerSelectionMode r5 = this.f12220c;
        PickerSelectionMode r11 = PickerSelectionMode.SINGLE;
        ArrayList r12 = this.f12227n;
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
        u r19 = (u) r17;
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
        goto L17
    L25:
        return;
    L18:
        Set r21 = CollectionsKt.toSet(r10);
        Iterator r22 = r12.iterator();
    L20:
        if (r22.hasNext() == false) goto L32;
        Object r23 = r22.next();
        int r24 = r13 + 1;
        if (r13 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((u) r23).setChecked(r21.contains(Integer.valueOf(r13)));
        r13 = r24;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r5) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        this.f12220c = r5;
        if (r5 != PickerSelectionMode.SINGLE) goto L24;
        ArrayList r10 = this.f12227n;
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L11;
        if (((u) r11.next()).isChecked() == true) goto L12;
        r12 = r12 + 1;
    L12:
        Iterator r13 = r10.iterator();
        int r14 = 0;
    L14:
        if (r13.hasNext() == false) goto L30;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        u r17 = (u) r15;
        if (r14 != r12) goto L22;
        if (r12 < 0) goto L22;
        boolean r18 = true;
    L23:
        r17.setChecked(r18);
        r14 = r16;
    L22:
        r18 = false;
        goto L23
    L30:
        return;
    L11:
        r12 = -1;
        goto L12
    }

    @JvmOverloads
    public OMonthPickerView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OMonthPickerView(Context r5, AttributeSet r10, @AttrRes int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OMonthPickerView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = R$attr.omonthPickerViewStyle;
    L8:
        int r13 = R$style.OStyleV2_OMonthPickerView_DayNight;
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f12218a = r11;
        this.f12219b = r13;
        this.f12220c = PickerSelectionMode.MULTIPLE;
        this.d = 1;
        ArrayList r14 = new ArrayList(31);
        int r15 = 0;
    L9:
        if (r15 >= 31) goto L11;
        r15 = r15 + 1;
        r14.add(String.valueOf(r15));
        goto L9
    L11:
        this.e = r14;
        this.f12221h = getResources().getInteger(R$integer.oui_font_weight_bold);
        this.f12222i = getResources().getInteger(R$integer.oui_font_weight_regular);
        this.f12227n = new ArrayList();
        TypedArray r16 = r5.obtainStyledAttributes(r10, R$styleable.OMonthPickerView, this.f12218a, this.f12219b);
    L15:
        th = move-exception;
        r16.recycle();
        throw th;
    L13:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_pv_selectedBackgroundColor) == false) goto L18;
        this.f = r16.getColor(R$styleable.OMonthPickerView_o_pv_selectedBackgroundColor, this.f);     // Catch: Throwable -> L15
    L18:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor) == false) goto L21;
        this.g = r16.getColor(R$styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor, this.g);     // Catch: Throwable -> L15
    L21:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_pv_dayTextAppearance) == false) goto L24;
        this.f12223j = r16.getResourceId(R$styleable.OMonthPickerView_o_pv_dayTextAppearance, this.f12223j);     // Catch: Throwable -> L15
    L24:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_pv_selectionMode) == false) goto L31;
        int r17 = r16.getInt(R$styleable.OMonthPickerView_o_pv_selectionMode, this.f12220c.ordinal());     // Catch: Throwable -> L15
        PickerSelectionMode r18 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L15
        if (r17 == r18.ordinal()) goto L29;
        r18 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L15
    L29:
        this.f12220c = r18;     // Catch: Throwable -> L15
    L31:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_mpv_columnCount) == false) goto L34;
        this.d = RangesKt.coerceAtLeast(r16.getInt(R$styleable.OMonthPickerView_o_mpv_columnCount, this.d), 1);     // Catch: Throwable -> L15
    L34:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_pv_itemSize) == false) goto L37;
        this.f12224k = r16.getDimensionPixelSize(R$styleable.OMonthPickerView_o_pv_itemSize, this.f12224k);     // Catch: Throwable -> L15
    L37:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_pv_itemHPadding) == false) goto L40;
        this.f12225l = r16.getDimensionPixelSize(R$styleable.OMonthPickerView_o_pv_itemHPadding, this.f12225l);     // Catch: Throwable -> L15
    L40:
        if (r16.hasValue(R$styleable.OMonthPickerView_o_pv_itemVPadding) == false) goto L42;
        this.f12226m = r16.getDimensionPixelSize(R$styleable.OMonthPickerView_o_pv_itemVPadding, this.f12226m);     // Catch: Throwable -> L15
    L42:
        r16.recycle();
        setClipChildren(false);
        setClipToPadding(false);
        a();
    }

    public final void setLabels(String[] r5) {
        Intrinsics.checkNotNullParameter(r5, "newLabels");
        setLabels(ArraysKt.toList(r5));
    }
}
