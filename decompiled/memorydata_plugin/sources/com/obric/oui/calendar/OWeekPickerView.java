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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002JKB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0013H\u0002J#\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0016\u00100\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0016\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0018J\u0010\u00104\u001a\u00020 2\b\b\u0001\u00105\u001a\u00020\u0007J\u000e\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u0007J\u000e\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020\u0007J\u0019\u0010<\u001a\u00020 2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010>J\u0014\u0010<\u001a\u00020 2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130?J\u0010\u0010@\u001a\u00020 2\b\u0010A\u001a\u0004\u0018\u00010\u0016J\u0014\u0010B\u001a\u00020 2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070?J\u000e\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020\u001cJ\u0010\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020\u0007H\u0002J\b\u0010H\u001a\u00020 H\u0002J\u001b\u0010I\u001a\u00020 2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0002\u0010>R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chips", "", "Lcom/obric/oui/calendar/OWeekPickerView$DayChip;", "dayTextAppearance", "firstDayOfWeek", "itemHorizontalPaddingPx", "itemSizePx", "labels", "", "", "[Ljava/lang/String;", "onDaysChangedListener", "Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;", "selectable", "", "selectedBackgroundColor", "selectedTextFontWeight", "selectionMode", "Lcom/obric/oui/calendar/PickerSelectionMode;", "unSelectedBackgroundColor", "unselectedTextFontWeight", "applyDayTextAppearance", "", "chip", "createChildren", "dispatchSelection", "formatDefaultLabelForFontScale", AnnotatedPrivateKey.LABEL, "generateLabels", "startValue", "(Landroid/content/Context;I)[Ljava/lang/String;", "initAttrs", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetSelectable", "size", "resizeSelectable", "setBackgroundColorColor", "setDaySelectable", "index", "enabled", "setDayTextAppearance", "resourceId", "setFirstDayOfWeek", "first", "setItemHorizontalPaddingDp", "itemPaddingDp", "setItemSizeDp", "itemDiameterDp", "setLabels", "newLabels", "([Ljava/lang/String;)V", "", "setOnDaysChangedListener", "listener", "setSelectedDays", "days", "setSelectionMode", "mode", "updateChildMargins", "spacingPx", "updateChildrenText", "updateLabels", "DayChip", "OnDaysChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OWeekPickerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13427b;
    private PickerSelectionMode c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private a k;
    private int l;
    private String[] m;
    private final List<DayChip> n;
    private final List<Boolean> o;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView$DayChip;", "Landroidx/appcompat/widget/AppCompatCheckedTextView;", "context", "Landroid/content/Context;", "selectedTextFontWeight", "", "unselectedTextFontWeight", "(Landroid/content/Context;II)V", "selectedBackGroudColor", "sizePx", "unSelectedBackGroudColor", "applyTextFontWeight", "", "circleDrawable", "Landroid/graphics/drawable/ShapeDrawable;", TypedValues.Custom.S_COLOR, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "regenerateBackground", "setBackgroundColorColor", "selectedBackgroundColor", "unSelectedBackgroundColor", "setChecked", "checked", "", "setSize", "px", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DayChip extends AppCompatCheckedTextView {
        private int selectedBackGroudColor;
        private final int selectedTextFontWeight;
        private int sizePx;
        private int unSelectedBackGroudColor;
        private final int unselectedTextFontWeight;

        public DayChip(Context r3, int r4, int r5) {
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
            r0.addState(new int[]{R.attr.state_checked}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackGroudColor), Drawable.class, "com.obric.memorydata.plugin"));
            r0.addState(new int[]{R.attr.state_pressed}, (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.selectedBackGroudColor), Drawable.class, "com.obric.memorydata.plugin"));
            r0.addState(new int[0], (Drawable) ZeusTransformUtils.preCheckCast(circleDrawable(this.unSelectedBackGroudColor), Drawable.class, "com.obric.memorydata.plugin"));
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
            int r0 = this.sizePx;
            setMeasuredDimension(AppCompatCheckedTextView.resolveSize(r0, r2), AppCompatCheckedTextView.resolveSize(r0, r3));
        }

        public final void setBackgroundColorColor(int r1, int r2) {
            this.selectedBackGroudColor = r1;
            this.unSelectedBackGroudColor = r2;
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;", "", "onChanged", "", "selectedDays", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(List<Integer> r1);
    }

    public OWeekPickerView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OWeekPickerView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OWeekPickerView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OWeekPickerView(Context r4, AttributeSet r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r6);
        this.f13426a = r6;
        this.f13427b = r7;
        this.c = PickerSelectionMode.MULTIPLE;
        this.f = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.integer.oui_font_weight_bold, TypedValues.Custom.S_INT, "oui_font_weight_bold"));
        this.g = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getInteger(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.integer.oui_font_weight_regular, TypedValues.Custom.S_INT, "oui_font_weight_regular"));
        this.l = 2;
        this.m = a(r8, 2);
        this.n = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.o = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a(r8, r9);
        String[] r10 = a(r8, this.l);
        this.m = r10;
        a(r10.length);
        setOrientation(0);
        setGravity(17);
        a();
    }

    public /* synthetic */ OWeekPickerView(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.oweekPickerViewStyle, "attr", "oweekPickerViewStyle");
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.style.OStyleV2_OWeekPickerView_DayNight, "style", "OStyleV2_OWeekPickerView_DayNight");
    L11:
        this(r8, r9, r4, r5);
    }

    private final String a(Context r2, String r3) {
        if (com.obric.oui.c.h.a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().fontScale) == true) goto L5;
        return r3;
    L5:
        Character r1 = StringsKt.firstOrNull((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L13;
        String r4 = Character.valueOf(Character.toUpperCase(r1.charValue())).toString();
        if (r4 != null) goto L12;
        return r3;
    L12:
        return r4;
    L13:
        return r3;
    }

    private final void a() {
        removeAllViews();
        this.n.clear();
        int r0 = this.m.length;
        final int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        final DayChip r4 = new DayChip(r5, this.f, this.g);
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.m[r2], CharSequence.class, "com.obric.memorydata.plugin"));
        r4.setGravity(17);
        a(r4);
        r4.applyTextFontWeight();
        r4.setSingleLine(true);
        r4.setTextAlignment(4);
        r4.setClickable(true);
        r4.setFocusable(true);
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.o.get(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        float r7 = 1.0f;
    L8:
        r4.setAlpha(r7);
        r4.setSize(this.i);
        r4.setBackgroundColorColor(this.d, this.e);
        r4.setChecked(false);
        r4.setOnClickListener(new $$Lambda$OWeekPickerView$JKSMs6fiI39t1siOoME3nC2eUM(this, r2, r4));
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        int r9 = this.j / 2;
        if (r2 != 0) goto L11;
        int r10 = 0;
    L13:
        if (r2 != ArraysKt.getLastIndex(this.m)) goto L15;
        r9 = 0;
    L15:
        r8.setMargins(r10, 0, r9, 0);
        r8.gravity = 17;
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.n.add(r4);
        r2 = r3;
        goto L3
    L11:
        r10 = r9;
        goto L13
    L7:
        r7 = 0.45f;
        goto L8
    }

    private final void a(int r4) {
        this.o.clear();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.o.add(true);
        r0 = r0 + 1;
        goto L3
    }

    private final void a(Context r12, AttributeSet r13) {
        TypedArray r14 = ((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.OWeekPickerView, this.f13426a, this.f13427b);
        Intrinsics.checkNotNullExpressionValue(r14, "context.obtainStyledAttr…    defStyleRes\n        )");
    L30:
        th = move-exception;
        r14.recycle();
        throw th;
    L4:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_selectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_selectedBackgroundColor")) == false) goto L7;
        this.d = r14.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_selectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_selectedBackgroundColor"), this.d);     // Catch: Throwable -> L30
    L7:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_unSelectedBackgroundColor")) == false) goto L10;
        this.e = r14.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor, "styleable", "OWeekPickerView_o_pv_unSelectedBackgroundColor"), this.e);     // Catch: Throwable -> L30
    L10:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_dayTextAppearance, "styleable", "OWeekPickerView_o_pv_dayTextAppearance")) == false) goto L13;
        this.h = r14.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_dayTextAppearance, "styleable", "OWeekPickerView_o_pv_dayTextAppearance"), this.h);     // Catch: Throwable -> L30
    L13:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_selectionMode, "styleable", "OWeekPickerView_o_pv_selectionMode")) == false) goto L20;
        if (r14.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_selectionMode, "styleable", "OWeekPickerView_o_pv_selectionMode"), this.c.ordinal()) != PickerSelectionMode.SINGLE.ordinal()) goto L17;
        PickerSelectionMode r15 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L30
    L18:
        this.c = r15;     // Catch: Throwable -> L30
        goto L20
    L17:
        r15 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L30
    L20:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_itemSize, "styleable", "OWeekPickerView_o_pv_itemSize")) == false) goto L23;
        this.i = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_itemSize, "styleable", "OWeekPickerView_o_pv_itemSize"), this.i);     // Catch: Throwable -> L30
    L23:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_itemHPadding, "styleable", "OWeekPickerView_o_pv_itemHPadding")) == false) goto L26;
        this.j = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_pv_itemHPadding, "styleable", "OWeekPickerView_o_pv_itemHPadding"), this.j);     // Catch: Throwable -> L30
    L26:
        if (r14.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_wpv_firstDayOfWeek, "styleable", "OWeekPickerView_o_wpv_firstDayOfWeek")) == false) goto L28;
        this.l = r14.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWeekPickerView_o_wpv_firstDayOfWeek, "styleable", "OWeekPickerView_o_wpv_firstDayOfWeek"), this.l);     // Catch: Throwable -> L30
    L28:
        r14.recycle();
    }

    private final void a(DayChip r4) {
        if (this.h == 0) goto L6;
        r4.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.h);
        return;
    }

    private static final void a(OWeekPickerView r2, int r3, DayChip r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$this_apply");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2.o.get(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        return;
    L6:
        if (r2.c != PickerSelectionMode.SINGLE) goto L11;
        Iterator<DayChip> r6 = r2.n.iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        DayChip r7 = (DayChip) ZeusTransformUtils.preCheckCast(r6.next(), DayChip.class, "com.obric.memorydata.plugin");
        r7.setChecked(Intrinsics.areEqual(r7, r4));
    L12:
        r2.c();
        return;
    L11:
        r4.toggle();
        goto L12
    }

    private final void a(String[] r9) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L15;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((DayChip) ZeusTransformUtils.preCheckCast(r5, DayChip.class, "com.obric.memorydata.plugin")).isChecked() == false) goto L11;
        Integer r7 = Integer.valueOf(r4);
    L12:
        if (r7 == null) goto L14;
        r1.add(r7);
    L14:
        r4 = r6;
        goto L4
    L11:
        r7 = null;
        goto L12
    L15:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (r9.length == getChildCount()) goto L18;
        boolean r8 = true;
    L19:
        Object[] r10 = Arrays.copyOf(r9, r9.length);
        Intrinsics.checkNotNullExpressionValue(r10, "copyOf(this, size)");
        String[] r11 = (String[]) ZeusTransformUtils.preCheckCast(r10, String[].class, "com.obric.memorydata.plugin");
        this.m = r11;
        if (r8 == false) goto L22;
        b(r11.length);
        a();
    L23:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L34;
        Object r15 = r14.next();
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r16 >= 0) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r17 == false) goto L25;
        r13.add(r15);
        goto L25
    L29:
        if (r16 >= this.m.length) goto L31;
        r17 = true;
        goto L32
    L34:
        setSelectedDays((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"));
        requestLayout();
        return;
    L22:
        b();
        goto L23
    L18:
        r8 = false;
        goto L19
    }

    private final String[] a(Context r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        String[] r1 = new String[7];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= 7) goto L5;
        r1[r3] = "";
        r3 = r3 + 1;
    L5:
        if (r2 >= 7) goto L7;
        r1[r2] = a(r8, b(r8, r7));
        r7 = (r7 % 7) + 1;
        r2 = r2 + 1;
        goto L5
    L7:
        return r1;
    }

    private static final String b(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        switch(r3) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        String r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_calendar_day_of_week_sat, TypedValues.Custom.S_STRING, "oui_calendar_day_of_week_sat"));
        String r6 = "context.getString(R.stri…calendar_day_of_week_sat)";
    L12:
        Intrinsics.checkNotNullExpressionValue(r5, r6);
        return r5;
    L6:
        r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_calendar_day_of_week_fri, TypedValues.Custom.S_STRING, "oui_calendar_day_of_week_fri"));
        r6 = "context.getString(R.stri…calendar_day_of_week_fri)";
        goto L12
    L7:
        r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_calendar_day_of_week_thu, TypedValues.Custom.S_STRING, "oui_calendar_day_of_week_thu"));
        r6 = "context.getString(R.stri…calendar_day_of_week_thu)";
        goto L12
    L8:
        r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_calendar_day_of_week_wed, TypedValues.Custom.S_STRING, "oui_calendar_day_of_week_wed"));
        r6 = "context.getString(R.stri…calendar_day_of_week_wed)";
        goto L12
    L9:
        r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_calendar_day_of_week_tue, TypedValues.Custom.S_STRING, "oui_calendar_day_of_week_tue"));
        r6 = "context.getString(R.stri…calendar_day_of_week_tue)";
        goto L12
    L10:
        r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_calendar_day_of_week_mon, TypedValues.Custom.S_STRING, "oui_calendar_day_of_week_mon"));
        r6 = "context.getString(R.stri…calendar_day_of_week_mon)";
        goto L12
    L11:
        r5 = r4.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_calendar_day_of_week_sun, TypedValues.Custom.S_STRING, "oui_calendar_day_of_week_sun"));
        r6 = "context.getString(R.stri…calendar_day_of_week_sun)";
        goto L12
    }

    private final void b() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((DayChip) ZeusTransformUtils.preCheckCast(r3, DayChip.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(this.m[r1], CharSequence.class, "com.obric.memorydata.plugin"));
        r1 = r4;
        goto L4
    }

    private final void b(int r7) {
        List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.o, Iterable.class, "com.obric.memorydata.plugin"));
        this.o.clear();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        List<Boolean> r3 = this.o;
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r0, r1), Boolean.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        boolean r5 = true;
    L8:
        r3.add(Boolean.valueOf(r5));
        r1 = r1 + 1;
        goto L3
    L7:
        r5 = r4.booleanValue();
        goto L8
    }

    private final void c() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((DayChip) ZeusTransformUtils.preCheckCast(r4, DayChip.class, "com.obric.memorydata.plugin")).isChecked() == false) goto L11;
        r0.add(Integer.valueOf(r3));
    L11:
        r3 = r5;
        goto L4
    L12:
        a r7 = this.k;
        if (r7 == null) goto L20;
        r7.a(r0);
        return;
    }

    private final void c(int r10) {
        int r11 = r10 / 2;
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        int r3 = r2 + 1;
        View r4 = getChildAt(r2);
        if (r4 == null) goto L16;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r2 != 0) goto L10;
        int r7 = 0;
    L12:
        if (r2 != (getChildCount() - 1)) goto L14;
        int r8 = 0;
    L15:
        r6.setMargins(r7, 0, r8, 0);
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        goto L16
    L14:
        r8 = r11;
        goto L15
    L10:
        r7 = r11;
    L16:
        r2 = r3;
        goto L3
    }

    /* JADX INFO: renamed from: lambda$JKSMs6fiI39t1siOoME3nC-2eUM, reason: not valid java name */
    public static /* synthetic */ void m1271lambda$JKSMs6fiI39t1siOoME3nC2eUM(OWeekPickerView r0, int r1, DayChip r2, View r3) {
        a(r0, r1, r2, r3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getSize(r9);
        int r1 = View.MeasureSpec.getMode(r9);
        int r2 = this.j;
        if (r1 == 0) goto L12;
        if (r0 <= 0) goto L12;
        int r3 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r4 = getChildCount();
        int r5 = RangesKt.coerceAtLeast(r4 - 1, 0);
        int r6 = this.i;
        if (((r4 * r6) + (this.j * r5)) <= r3) goto L12;
        int r7 = r3 - (r4 * r6);
        if (r7 <= 0) goto L11;
        if (r5 <= 0) goto L11;
        r2 = r7 / r5;
    L11:
        r2 = 0;
    L12:
        c(r2);
        super.onMeasure(r9, r10);
    }

    public final void setDayTextAppearance(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.h = r4;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        DayChip r0 = (DayChip) ZeusTransformUtils.preCheckCast(r5.next(), DayChip.class, "com.obric.memorydata.plugin");
        a(r0);
        r0.applyTextFontWeight();
        goto L6
    }

    public final void setFirstDayOfWeek(int r3) {
        this.l = r3;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        a(a(r4, this.l));
    }

    public final void setItemHorizontalPaddingDp(int r3) {
        int r4 = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
        this.j = r4;
        c(r4);
    }

    public final void setItemSizeDp(int r4) {
        this.i = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((DayChip) ZeusTransformUtils.preCheckCast(r5.next(), DayChip.class, "com.obric.memorydata.plugin")).setSize(this.i);
        goto L4
    L6:
        requestLayout();
    }

    public final void setLabels(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "newLabels");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r5 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a((String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.memorydata.plugin"));
    }

    public final void setLabels(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        setLabels(ArraysKt.toList(r2));
    }

    public final void setOnDaysChangedListener(a r3) {
        this.k = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public final void setSelectedDays(List<Integer> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "days");
        int r3 = 0;
        if (this.c != PickerSelectionMode.SINGLE) goto L18;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r9), Integer.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L25;
        Object r4 = r0.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        DayChip r6 = (DayChip) ZeusTransformUtils.preCheckCast(r4, DayChip.class, "com.obric.memorydata.plugin");
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
        c();
        return;
    L18:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r1.hasNext() == false) goto L25;
        Object r11 = r1.next();
        int r12 = r3 + 1;
        if (r3 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((DayChip) ZeusTransformUtils.preCheckCast(r11, DayChip.class, "com.obric.memorydata.plugin")).setChecked(r9.contains(Integer.valueOf(r3)));
        r3 = r12;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r8) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        this.c = r8;
        if (r8 != PickerSelectionMode.SINGLE) goto L31;
        Iterator<DayChip> r9 = this.n.iterator();
        int r1 = 0;
    L6:
        if (r9.hasNext() == false) goto L11;
        if (((DayChip) ZeusTransformUtils.preCheckCast(r9.next(), DayChip.class, "com.obric.memorydata.plugin")).isChecked() == true) goto L12;
        r1 = r1 + 1;
    L12:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L14:
        if (r10.hasNext() == false) goto L24;
        Object r4 = r10.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        DayChip r6 = (DayChip) ZeusTransformUtils.preCheckCast(r4, DayChip.class, "com.obric.memorydata.plugin");
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
        c();
        return;
    L11:
        r1 = -1;
        goto L12
    }
}
