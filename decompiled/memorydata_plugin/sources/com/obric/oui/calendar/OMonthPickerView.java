package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002MNB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u0006\u0010 \u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\b\u0010)\u001a\u00020\u0007H\u0002J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013J\u0006\u0010+\u001a\u00020\u001aJ\u001a\u0010,\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J\u001a\u00107\u001a\u00020\u001e2\b\b\u0001\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\u001b\u001a\u00020\u0007J\u000e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u0007J\u0010\u0010:\u001a\u00020\u001e2\b\b\u0001\u0010;\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u0007J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\u0019\u0010B\u001a\u00020\u001e2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140D¢\u0006\u0002\u0010EJ\u0014\u0010B\u001a\u00020\u001e2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0010\u0010F\u001a\u00020\u001e2\b\u0010G\u001a\u0004\u0018\u00010\u0016J\u0014\u0010H\u001a\u00020\u001e2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013J\u000e\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020\u001aJ\b\u0010L\u001a\u00020\u001eH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chips", "", "Lcom/obric/oui/calendar/OMonthPickerView$MonthDayChip;", "columnCount", "dayTextAppearance", "itemHorizontalPaddingPx", "itemSizePx", "itemVerticalPaddingPx", "labels", "", "", "onDaysChangedListener", "Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;", "selectedBackgroundColor", "selectedTextFontWeight", "selectionMode", "Lcom/obric/oui/calendar/PickerSelectionMode;", "unSelectedBackgroundColor", "unselectedTextFontWeight", "applyDayTextAppearance", "", "chip", "clearSelection", "createChildren", "dispatchSelection", "generateDefaultLabels", "getColumnCount", "getContentHeight", "getDayCount", "getFullRowWidth", "getLabels", "getRowCount", "getSelectedDays", "getSelectionMode", "initAttrs", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBackgroundColorColor", "setColumnCount", CommonConsts.COUNT_TYPE, "setDayTextAppearance", "resourceId", "setItemDiameterDp", "itemDiameterDp", "setItemPaddingDp", "itemPaddingDp", "itemHorizontalPaddingDp", "itemVerticalPaddingDp", "setLabels", "newLabels", "", "([Ljava/lang/String;)V", "setOnDaysChangedListener", "listener", "setSelectedDays", "days", "setSelectionMode", "mode", "updateChildrenText", "MonthDayChip", "OnDaysChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMonthPickerView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13425b;
    private PickerSelectionMode c;
    private int d;
    private List<String> e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private a n;
    private final List<MonthDayChip> o;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0002J\u001a\u0010\u0014\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView$MonthDayChip;", "Landroidx/appcompat/widget/AppCompatCheckedTextView;", "context", "Landroid/content/Context;", "selectedTextFontWeight", "", "unselectedTextFontWeight", "(Landroid/content/Context;II)V", "selectedBackgroundColor", "sizePx", "unSelectedBackgroundColor", "applyTextFontWeight", "", "circleDrawable", "Landroid/graphics/drawable/ShapeDrawable;", TypedValues.Custom.S_COLOR, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "regenerateBackground", "setBackgroundColorColor", "setChecked", "checked", "", "setSize", "px", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class MonthDayChip extends AppCompatCheckedTextView {
        private int selectedBackgroundColor;
        private final int selectedTextFontWeight;
        private int sizePx;
        private int unSelectedBackgroundColor;
        private final int unselectedTextFontWeight;

        public MonthDayChip(Context r3, int r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "context");
            super(r6);
            this.selectedTextFontWeight = r4;
            this.unselectedTextFontWeight = r5;
        }

        private final ShapeDrawable circleDrawable(int r4) {
            ShapeDrawable r3 = new ShapeDrawable((Shape) ZeusTransformUtils.preCheckCast(new OvalShape(), Shape.class, "com.obric.memorydata.plugin"));
            r3.getPaint().setColor(r4);
            return r3;
        }

        private final void regenerateBackground() {
            StateListDrawable r0 = new StateListDrawable();
            r0.addState(new int[]{R.attr.state_checked}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackgroundColor), Drawable.class, "com.obric.memorydata.plugin"));
            r0.addState(new int[]{R.attr.state_pressed}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackgroundColor), Drawable.class, "com.obric.memorydata.plugin"));
            r0.addState(new int[0], (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.unSelectedBackgroundColor), Drawable.class, "com.obric.memorydata.plugin"));
            setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.memorydata.plugin"));
        }

        public final void applyTextFontWeight() {
            if (isChecked() == false) goto L5;
            int r0 = this.selectedTextFontWeight;
        L6:
            com.obric.oui.c.f.a((TextView) ZeusTransformUtils.preCheckCast(this, TextView.class, "com.obric.memorydata.plugin"), r0);
            return;
        L5:
            r0 = this.unselectedTextFontWeight;
            goto L6
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            setMeasuredDimension(AppCompatCheckedTextView.resolveSize(this.sizePx, r2), AppCompatCheckedTextView.resolveSize(this.sizePx, r3));
        }

        public final void setBackgroundColorColor(int r1, int r2) {
            this.selectedBackgroundColor = r1;
            this.unSelectedBackgroundColor = r2;
            regenerateBackground();
        }

        @Override // android.widget.CheckedTextView, android.widget.Checkable
        public void setChecked(boolean r2) {
            if (isChecked() == r2) goto L5;
            boolean r0 = true;
        L6:
            super.setChecked(r2);
            if (r0 == false) goto L10;
            applyTextFontWeight();
            return;
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void setSize(int r1) {
            this.sizePx = r1;
            requestLayout();
            regenerateBackground();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;", "", "onChanged", "", "selectedDays", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(List<Integer> r1);
    }

    public OMonthPickerView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OMonthPickerView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OMonthPickerView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OMonthPickerView(Context r4, AttributeSet r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r6);
        this.f13424a = r6;
        this.f13425b = r7;
        this.c = PickerSelectionMode.MULTIPLE;
        this.d = 1;
        this.e = c();
        this.h = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.integer.oui_font_weight_bold, TypedValues.Custom.S_INT, "oui_font_weight_bold"));
        this.i = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.integer.oui_font_weight_regular, TypedValues.Custom.S_INT, "oui_font_weight_regular"));
        this.o = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a(r8, r9);
        setClipChildren(false);
        setClipToPadding(false);
        a();
    }

    public /* synthetic */ OMonthPickerView(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.omonthPickerViewStyle, "attr", "omonthPickerViewStyle");
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.OStyleV2_OMonthPickerView_DayNight, "style", "OStyleV2_OMonthPickerView_DayNight");
    L11:
        this(r8, r9, r4, r5);
    }

    private final void a() {
        removeAllViews();
        this.o.clear();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        final MonthDayChip r3 = new MonthDayChip(r4, this.h, this.i);
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"));
        r3.setGravity(17);
        a(r3);
        r3.applyTextFontWeight();
        r3.setIncludeFontPadding(false);
        r3.setSingleLine(true);
        r3.setTextAlignment(4);
        r3.setClickable(true);
        r3.setFocusable(true);
        r3.setSize(this.k);
        r3.setBackgroundColorColor(this.f, this.g);
        r3.setOnClickListener(new $$Lambda$OMonthPickerView$mgBliNuppen4SD2ZL4hgMBkJkjo(this, r3));
        View r2 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        int r5 = this.k;
        addView(r2, new ViewGroup.LayoutParams(r5, r5));
        this.o.add(r3);
        goto L4
    }

    private final void a(Context r13, AttributeSet r14) {
        TypedArray r15 = ((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.OMonthPickerView, this.f13424a, this.f13425b);
        Intrinsics.checkNotNullExpressionValue(r15, "context.obtainStyledAttr…    defStyleRes\n        )");
    L33:
        th = move-exception;
        r15.recycle();
        throw th;
    L4:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_selectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_selectedBackgroundColor")) == false) goto L7;
        this.f = r15.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_selectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_selectedBackgroundColor"), this.f);     // Catch: Throwable -> L33
    L7:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_unSelectedBackgroundColor")) == false) goto L10;
        this.g = r15.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OMonthPickerView_o_pv_unSelectedBackgroundColor"), this.g);     // Catch: Throwable -> L33
    L10:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_dayTextAppearance, "styleable", "OMonthPickerView_o_pv_dayTextAppearance")) == false) goto L13;
        this.j = r15.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_dayTextAppearance, "styleable", "OMonthPickerView_o_pv_dayTextAppearance"), this.j);     // Catch: Throwable -> L33
    L13:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_selectionMode, "styleable", "OMonthPickerView_o_pv_selectionMode")) == false) goto L20;
        if (r15.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_selectionMode, "styleable", "OMonthPickerView_o_pv_selectionMode"), this.c.ordinal()) != PickerSelectionMode.SINGLE.ordinal()) goto L17;
        PickerSelectionMode r16 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L33
    L18:
        this.c = r16;     // Catch: Throwable -> L33
        goto L20
    L17:
        r16 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L33
    L20:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_mpv_columnCount, "styleable", "OMonthPickerView_o_mpv_columnCount")) == false) goto L23;
        this.d = RangesKt.coerceAtLeast(r15.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_mpv_columnCount, "styleable", "OMonthPickerView_o_mpv_columnCount"), this.d), 1);     // Catch: Throwable -> L33
    L23:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_itemSize, "styleable", "OMonthPickerView_o_pv_itemSize")) == false) goto L26;
        this.k = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_itemSize, "styleable", "OMonthPickerView_o_pv_itemSize"), this.k);     // Catch: Throwable -> L33
    L26:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_itemHPadding, "styleable", "OMonthPickerView_o_pv_itemHPadding")) == false) goto L29;
        this.l = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_itemHPadding, "styleable", "OMonthPickerView_o_pv_itemHPadding"), this.l);     // Catch: Throwable -> L33
    L29:
        if (r15.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_itemVPadding, "styleable", "OMonthPickerView_o_pv_itemVPadding")) == false) goto L31;
        this.m = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMonthPickerView_o_pv_itemVPadding, "styleable", "OMonthPickerView_o_pv_itemVPadding"), this.m);     // Catch: Throwable -> L33
    L31:
        r15.recycle();
    }

    private final void a(MonthDayChip r4) {
        if (this.j == 0) goto L6;
        r4.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.j);
        return;
    }

    private static final void a(OMonthPickerView r3, MonthDayChip r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$this_apply");
        if (r3.c != PickerSelectionMode.SINGLE) goto L8;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3.o, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        MonthDayChip r0 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r6.next(), MonthDayChip.class, "com.obric.memorydata.plugin");
        r0.setChecked(Intrinsics.areEqual(r0, r4));
    L9:
        r3.b();
        return;
    L8:
        r4.toggle();
        goto L9
    }

    private final void b() {
        a r0 = this.n;
        if (r0 == null) goto L7;
        r0.a(getSelectedDays());
        return;
    }

    private final List<String> c() {
        ArrayList r3 = new ArrayList(31);
        int r1 = 0;
    L3:
        if (r1 >= 31) goto L6;
        r1 = r1 + 1;
        r3.add(String.valueOf(r1));
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    }

    private final void d() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r3, MonthDayChip.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(this.e.get(r1), CharSequence.class, "com.obric.memorydata.plugin"));
        r1 = r4;
        goto L4
    }

    private final int getContentHeight() {
        return (getRowCount() * this.k) + ((getRowCount() - 1) * this.m);
    }

    private final int getDayCount() {
        return this.e.size();
    }

    private final int getFullRowWidth() {
        int r0 = this.d;
        return (this.k * r0) + ((r0 - 1) * this.l);
    }

    private final int getRowCount() {
        int r0 = getDayCount();
        int r1 = this.d;
        return ((r0 + r1) - 1) / r1;
    }

    public static /* synthetic */ void lambda$mgBliNuppen4SD2ZL4hgMBkJkjo(OMonthPickerView r0, MonthDayChip r1, View r2) {
        a(r0, r1, r2);
    }

    public final void a(int r3, int r4) {
        this.l = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
        this.m = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        requestLayout();
    }

    public final int getColumnCount() {
        return this.d;
    }

    public final List<String> getLabels() {
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final List<Integer> getSelectedDays() {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L16;
        Object r3 = r7.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((MonthDayChip) ZeusTransformUtils.preCheckCast(r3, MonthDayChip.class, "com.obric.memorydata.plugin")).isChecked() == false) goto L11;
        Integer r5 = Integer.valueOf(r2);
    L12:
        if (r5 == null) goto L14;
        r0.add(r5);
    L14:
        r2 = r4;
        goto L4
    L11:
        r5 = null;
        goto L12
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public final PickerSelectionMode getSelectionMode() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = r10 - r8;
        int r13 = (r12 - getPaddingLeft()) - getPaddingRight();
        int r14 = getFullRowWidth();
        int r15 = (r13 - r14) / 2;
        int r16 = 0;
        int r17 = getPaddingLeft() + RangesKt.coerceAtLeast(r15, 0);
        int r18 = (r12 - getPaddingRight()) - RangesKt.coerceAtLeast(r15, 0);
        int r19 = getChildCount();
    L3:
        if (r16 >= r19) goto L9;
        int r110 = r16 + 1;
        View r0 = getChildAt(r16);
        int r1 = this.d;
        int r2 = r16 / r1;
        int r20 = r16 % r1;
        int r3 = getPaddingTop() + (r2 * (this.k + this.m));
        if (g.a() == false) goto L7;
        int r4 = this.k;
        int r21 = r18 - (r20 * (this.l + r4));
        int r5 = r21 - r4;
    L8:
        r0.layout(r5, r3, r21, this.k + r3);
        r16 = r110;
        goto L3
    L7:
        int r6 = this.k;
        int r22 = (r20 * (this.l + r6)) + r17;
        int r23 = r6 + r22;
        r5 = r22;
        r21 = r23;
        goto L8
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r9) {
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

    public final void setColumnCount(int r2) {
        int r3 = RangesKt.coerceAtLeast(r2, 1);
        if (this.d != r3) goto L5;
        return;
    L5:
        this.d = r3;
        requestLayout();
    }

    public final void setDayTextAppearance(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.j = r4;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        MonthDayChip r0 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r5.next(), MonthDayChip.class, "com.obric.memorydata.plugin");
        a(r0);
        r0.applyTextFontWeight();
        r0.setIncludeFontPadding(false);
        goto L6
    }

    public final void setItemDiameterDp(int r4) {
        this.k = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r5.next(), MonthDayChip.class, "com.obric.memorydata.plugin")).setSize(this.k);
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemPaddingDp(int r1) {
        a(r1, r1);
    }

    public final void setLabels(List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "newLabels");
        if (r9.isEmpty() == false) goto L5;
        return;
    L5:
        List<Integer> r0 = getSelectedDays();
        if (r9.size() == getChildCount()) goto L8;
        boolean r2 = true;
    L9:
        this.e = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));
        if (r2 == false) goto L12;
        a();
    L13:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L24;
        Object r3 = r11.next();
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r4 >= 0) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L15;
        r1.add(r3);
        goto L15
    L19:
        if (r4 >= this.e.size()) goto L21;
        r5 = true;
        goto L22
    L24:
        setSelectedDays((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"));
        requestLayout();
        return;
    L12:
        d();
        goto L13
    L8:
        r2 = false;
        goto L9
    }

    public final void setLabels(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        setLabels(ArraysKt.toList(r2));
    }

    public final void setOnDaysChangedListener(a r3) {
        this.n = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public final void setSelectedDays(List<Integer> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "days");
        int r3 = 0;
        if (this.c != PickerSelectionMode.SINGLE) goto L18;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r9), Integer.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L25;
        Object r4 = r0.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        MonthDayChip r6 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r4, MonthDayChip.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        r6.setChecked(r7);
        r2 = r5;
        goto L6
    L14:
        if (r2 != r10.intValue()) goto L16;
        r7 = true;
    L25:
        b();
        return;
    L18:
        Set r11 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r1.hasNext() == false) goto L25;
        Object r12 = r1.next();
        int r13 = r3 + 1;
        if (r3 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((MonthDayChip) ZeusTransformUtils.preCheckCast(r12, MonthDayChip.class, "com.obric.memorydata.plugin")).setChecked(r11.contains(Integer.valueOf(r3)));
        r3 = r13;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r8) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        this.c = r8;
        if (r8 != PickerSelectionMode.SINGLE) goto L31;
        Iterator<MonthDayChip> r9 = this.o.iterator();
        int r1 = 0;
    L6:
        if (r9.hasNext() == false) goto L11;
        if (((MonthDayChip) ZeusTransformUtils.preCheckCast(r9.next(), MonthDayChip.class, "com.obric.memorydata.plugin")).isChecked() == true) goto L12;
        r1 = r1 + 1;
    L12:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L14:
        if (r10.hasNext() == false) goto L24;
        Object r4 = r10.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        MonthDayChip r6 = (MonthDayChip) ZeusTransformUtils.preCheckCast(r4, MonthDayChip.class, "com.obric.memorydata.plugin");
        if (r2 != r1) goto L22;
        if (r1 < 0) goto L22;
        boolean r3 = true;
    L23:
        r6.setChecked(r3);
        r2 = r5;
    L22:
        r3 = false;
        goto L23
    L24:
        b();
        return;
    L11:
        r1 = -1;
        goto L12
    }
}
