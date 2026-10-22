package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.ViewUtils;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final TextWatcher hourTextWatcher;
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TextWatcher minuteTextWatcher;
    private final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;

    public TimePickerTextInputPresenter(LinearLayout r10, final TimeModel r11) {
        this.minuteTextWatcher = new AnonymousClass1(this);
        this.hourTextWatcher = new AnonymousClass2(this);
        this.timePickerView = r10;
        this.time = r11;
        Resources r5 = r10.getResources();
        ChipTextInputComboView r12 = (ChipTextInputComboView) r10.findViewById(R.id.material_minute_text_input);
        this.minuteTextInput = r12;
        ChipTextInputComboView r13 = (ChipTextInputComboView) r10.findViewById(R.id.material_hour_text_input);
        this.hourTextInput = r13;
        TextView r14 = (TextView) r12.findViewById(R.id.material_label);
        TextView r15 = (TextView) r13.findViewById(R.id.material_label);
        r14.setText(r5.getString(R.string.material_timepicker_minute));
        r15.setText(r5.getString(R.string.material_timepicker_hour));
        r12.setTag(R.id.selection_type, 12);
        r13.setTag(R.id.selection_type, 10);
        if (r11.format != 0) goto L5;
        setupPeriodToggle();
    L5:
        View.OnClickListener r16 = new AnonymousClass3(this);
        r13.setOnClickListener(r16);
        r12.setOnClickListener(r16);
        r13.addInputFilter(r11.getHourInputValidator());
        r12.addInputFilter(r11.getMinuteInputValidator());
        this.hourEditText = r13.getTextInput().getEditText();
        this.minuteEditText = r12.getTextInput().getEditText();
        this.controller = new TimePickerTextInputKeyController(r13, r12, r11);
        final Context r17 = r10.getContext();
        final int r18 = R.string.material_hour_selection;
        r13.setChipDelegate(new AnonymousClass4(this, r17, r18, r11));
        final Context r19 = r10.getContext();
        final int r20 = R.string.material_minute_selection;
        r12.setChipDelegate(new AnonymousClass5(this, r19, r20, r11));
        initialize();
    }

    public static /* synthetic */ void a(TimePickerTextInputPresenter r5, MaterialButtonToggleGroup r10, int r11, boolean r12) {
        r5.lambda$setupPeriodToggle$0(r10, r11, r12);
    }

    public static /* synthetic */ TimeModel access$000(TimePickerTextInputPresenter r5) {
        return r5.time;
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private /* synthetic */ void lambda$setupPeriodToggle$0(MaterialButtonToggleGroup r5, int r10, boolean r11) {
        if (r11 == true) goto L5;
        return;
    L5:
        if (r10 != R.id.material_clock_period_pm_button) goto L7;
        int r12 = 1;
    L8:
        this.time.setPeriod(r12);
        return;
    L7:
        r12 = 0;
        goto L8
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private static void setCursorDrawableColor(EditText r5, @ColorInt int r10) {
        Context r11 = r5.getContext();     // Catch: Throwable -> L5
        Field r12 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L5
        r12.setAccessible(true);     // Catch: Throwable -> L5
        int r13 = r12.getInt(r5);     // Catch: Throwable -> L5
        Field r14 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L5
        r14.setAccessible(true);     // Catch: Throwable -> L5
        Object r15 = r14.get(r5);     // Catch: Throwable -> L5
        Field r16 = r15.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L5
        r16.setAccessible(true);     // Catch: Throwable -> L5
        Drawable r17 = AppCompatResources.getDrawable(r11, r13);     // Catch: Throwable -> L5
        r17.setColorFilter(r10, PorterDuff.Mode.SRC_IN);     // Catch: Throwable -> L5
        r16.set(r15, new Drawable[]{r17, r17});     // Catch: Throwable -> L5
        return;
    }

    private void setTime(TimeModel r5) {
        removeTextWatchers();
        Locale r10 = this.timePickerView.getResources().getConfiguration().locale;
        String r11 = String.format(r10, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r5.minute)});
        String r12 = String.format(r10, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r5.getHourForDisplay())});
        this.minuteTextInput.setText(r11);
        this.hourTextInput.setText(r12);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        MaterialButtonToggleGroup r5 = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle = r5;
        r5.addOnButtonCheckedListener(new c(this, 0));
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        MaterialButtonToggleGroup r5 = this.toggle;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.time.period != 0) goto L8;
        int r10 = R.id.material_clock_period_am_button;
    L9:
        r5.check(r10);
        return;
    L8:
        r10 = R.id.material_clock_period_pm_button;
        goto L9
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View r5 = this.timePickerView.getFocusedChild();
        if (r5 == null) goto L5;
        ViewUtils.hideKeyboard(r5, false);
    L5:
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r5) {
        this.time.selection = r5;
        ChipTextInputComboView r10 = this.minuteTextInput;
        boolean r11 = false;
        if (r5 != 12) goto L5;
        boolean r12 = true;
    L6:
        r10.setChecked(r12);
        ChipTextInputComboView r13 = this.hourTextInput;
        if (r5 != 10) goto L9;
        r11 = true;
    L9:
        r13.setChecked(r11);
        updateSelection();
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void resetChecked() {
        ChipTextInputComboView r5 = this.minuteTextInput;
        boolean r10 = false;
        if (this.time.selection != 12) goto L5;
        boolean r11 = true;
    L6:
        r5.setChecked(r11);
        ChipTextInputComboView r12 = this.hourTextInput;
        if (this.time.selection != 10) goto L9;
        r10 = true;
    L9:
        r12.setChecked(r10);
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
        onSelectionChanged(this.time.selection);
    }
}
