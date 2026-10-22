package com.larksuite.component.universe_design.timepicker.impl.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.datepicker.databinding.UdTimepickerActionviewBinding;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\r2\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010&\u001a\u00020\r2\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010(\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020#J\u000e\u0010-\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/action/UDTimePickerActionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewBinding", "Lcom/larksuite/component/universe_design/datepicker/databinding/UdTimepickerActionviewBinding;", "setPickerMode", "", "pickerModel", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerModel;", "setLeftActionViewText", "text", "", "setInterval", "interval", "setSelectedTime", "calendarDate", "Ljava/util/Calendar;", "setLeftActionViewTextSize", "size", "", "setLeftTextColor", "color", "setLeftActionViewClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setLeftActionViewVisibility", "visibility", "getLeftActionView", "Landroid/widget/TextView;", "setRightActionViewText", "setRightActionViewTextSize", "setRightActionViewTextColor", "setRightActionViewClickListener", "setRightActionViewVisibility", "getRightActionView", "getUDTimePicker", "Lcom/larksuite/component/universe_design/timepicker/UDTimePicker;", "getTitleTextView", "setTitleText", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDTimePickerActionView extends LinearLayout {
    private final UdTimepickerActionviewBinding viewBinding;

    public UDTimePickerActionView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public UDTimePickerActionView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public final TextView getLeftActionView() {
        return this.viewBinding.b;
    }

    public final TextView getRightActionView() {
        return this.viewBinding.c;
    }

    public final TextView getTitleTextView() {
        return this.viewBinding.e;
    }

    public final UDTimePicker getUDTimePicker() {
        return this.viewBinding.d;
    }

    public final void setInterval(int r2) {
        this.viewBinding.d.setMinuteInterval(r2);
    }

    public final void setLeftActionViewClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        this.viewBinding.b.setOnClickListener(r2);
    }

    public final void setLeftActionViewText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.viewBinding.b.setText(r2);
    }

    public final void setLeftActionViewTextSize(float r3) {
        this.viewBinding.b.setTextSize(0, r3);
    }

    public final void setLeftActionViewVisibility(int r2) {
        this.viewBinding.b.setVisibility(r2);
    }

    public final void setLeftTextColor(int r2) {
        this.viewBinding.b.setTextColor(r2);
    }

    public final void setPickerMode(PickerModel r2) {
        Intrinsics.checkNotNullParameter(r2, "pickerModel");
        this.viewBinding.d.setPickerMode(r2);
    }

    public final void setRightActionViewClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        this.viewBinding.c.setOnClickListener(r2);
    }

    public final void setRightActionViewText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.viewBinding.c.setText(r2);
    }

    public final void setRightActionViewTextColor(int r2) {
        this.viewBinding.c.setTextColor(r2);
    }

    public final void setRightActionViewTextSize(float r2) {
        this.viewBinding.c.setTextSize(r2);
    }

    public final void setRightActionViewVisibility(int r2) {
        this.viewBinding.c.setVisibility(r2);
    }

    public final void setSelectedTime(Calendar r2) {
        Intrinsics.checkNotNullParameter(r2, "calendarDate");
        this.viewBinding.d.setSelectedCalendar(r2);
    }

    public final void setTitleText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.viewBinding.e.setText(r2);
    }

    public UDTimePickerActionView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        View r10 = LayoutInflater.from(r7).inflate(2131568098, this, false);
        addView(r10);
        int r11 = 2131377694;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r10, 2131377694);
        if (r2 == null) goto L13;
        r11 = 2131384501;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131384501);
        if (r3 == null) goto L13;
        r11 = 2131388658;
        UDTimePicker r4 = (UDTimePicker) ViewBindings.findChildViewById(r10, 2131388658);
        if (r4 == null) goto L13;
        r11 = 2131388792;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131388792);
        if (r5 == null) goto L13;
        this.viewBinding = new UdTimepickerActionviewBinding((LinearLayout) r10, r2, r3, r4, r5);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public /* synthetic */ UDTimePickerActionView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
