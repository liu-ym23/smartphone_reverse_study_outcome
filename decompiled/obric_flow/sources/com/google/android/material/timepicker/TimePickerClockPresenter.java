package com.google.android.material.timepicker;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private static final String[] HOUR_CLOCK_24_VALUES = null;
    private static final String[] HOUR_CLOCK_VALUES = null;
    private static final String[] MINUTE_CLOCK_VALUES = null;
    private boolean broadcasting;
    private float hourRotation;
    private float minuteRotation;
    private final TimeModel time;
    private final TimePickerView timePickerView;

    static {
        HOUR_CLOCK_VALUES = new String[]{"12", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        HOUR_CLOCK_24_VALUES = new String[]{"00", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        MINUTE_CLOCK_VALUES = new String[]{"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    }

    public TimePickerClockPresenter(TimePickerView r5, TimeModel r10) {
        this.broadcasting = false;
        this.timePickerView = r5;
        this.time = r10;
        initialize();
    }

    public static /* synthetic */ TimeModel access$000(TimePickerClockPresenter r5) {
        return r5.time;
    }

    private String[] getHourClockValues() {
        if (this.time.format != 1) goto L6;
        return HOUR_CLOCK_24_VALUES;
    L6:
        return HOUR_CLOCK_VALUES;
    }

    private int getHourRotation() {
        return (this.time.getHourForDisplay() * 30) % 360;
    }

    private void performHapticFeedback(int r5, int r10) {
        TimeModel r11 = this.time;
        if (r11.minute == r10) goto L5;
    L6:
        this.timePickerView.performHapticFeedback(4);
        return;
    L5:
        if (r11.hour != r5) goto L6;
    }

    private void updateCurrentLevel() {
        TimeModel r5 = this.time;
        int r10 = 1;
        if (r5.selection == 10) goto L5;
    L9:
        this.timePickerView.setCurrentLevel(r10);
        return;
    L5:
        if (r5.format != 1) goto L9;
        if (r5.hour < 12) goto L9;
        r10 = 2;
        goto L9
    }

    private void updateTime() {
        TimePickerView r5 = this.timePickerView;
        TimeModel r10 = this.time;
        r5.updateTime(r10.period, r10.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        if (this.time.format != 0) goto L5;
        this.timePickerView.showToggle();
    L5:
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.hourRotation = getHourRotation();
        TimeModel r5 = this.time;
        this.minuteRotation = r5.minute * 6;
        setSelection(r5.selection, false);
        updateTime();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float r10, boolean r11) {
        this.broadcasting = true;
        TimeModel r5 = this.time;
        int r12 = r5.minute;
        int r13 = r5.hour;
        if (r5.selection != 10) goto L10;
        this.timePickerView.setHandRotation(this.hourRotation, false);
        AccessibilityManager r14 = (AccessibilityManager) ContextCompat.getSystemService(this.timePickerView.getContext(), AccessibilityManager.class);
        if (r14 != null) goto L7;
    L9:
        setSelection(12, true);
    L14:
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(r13, r12);
        return;
    L7:
        if (r14.isTouchExplorationEnabled() == false) goto L9;
    L10:
        int r15 = Math.round(r10);
        if (r11 == true) goto L13;
        this.time.setMinute(((r15 + 15) / 30) * 5);
        this.minuteRotation = this.time.minute * 6;
    L13:
        this.timePickerView.setHandRotation(this.minuteRotation, r11);
        goto L14
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void onPeriodChange(int r5) {
        this.time.setPeriod(r5);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float r10, boolean r11) {
        if (this.broadcasting == false) goto L5;
        return;
    L5:
        TimeModel r5 = this.time;
        int r12 = r5.hour;
        int r13 = r5.minute;
        int r14 = Math.round(r10);
        TimeModel r15 = this.time;
        if (r15.selection != 12) goto L8;
        r15.setMinute((r14 + 3) / 6);
        this.minuteRotation = (float) Math.floor(this.time.minute * 6);
    L14:
        if (r11 == true) goto L17;
        updateTime();
        performHapticFeedback(r12, r13);
        return;
    L17:
        return;
    L8:
        int r16 = (r14 + 15) / 30;
        if (r15.format != 1) goto L13;
        r16 = r16 % 12;
        if (this.timePickerView.getCurrentLevel() != 2) goto L13;
        r16 = r16 + 12;
    L13:
        this.time.setHour(r16);
        this.hourRotation = getHourRotation();
        goto L14
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r5) {
        setSelection(r5, true);
    }

    public void setSelection(int r5, boolean r10) {
        if (r5 != 12) goto L5;
        boolean r11 = true;
    L6:
        this.timePickerView.setAnimateOnTouchUp(r11);
        this.time.selection = r5;
        TimePickerView r12 = this.timePickerView;
        if (r11 == false) goto L9;
        String[] r13 = MINUTE_CLOCK_VALUES;
    L10:
        if (r11 == false) goto L12;
        int r14 = R.string.material_minute_suffix;
    L13:
        r12.setValues(r13, r14);
        updateCurrentLevel();
        TimePickerView r15 = this.timePickerView;
        if (r11 == false) goto L16;
        float r16 = this.minuteRotation;
    L17:
        r15.setHandRotation(r16, r10);
        this.timePickerView.setActiveSelection(r5);
        TimePickerView r17 = this.timePickerView;
        final Context r18 = this.timePickerView.getContext();
        final int r19 = R.string.material_hour_selection;
        r17.setMinuteHourDelegate(new AnonymousClass1(this, r18, r19));
        TimePickerView r20 = this.timePickerView;
        final Context r21 = this.timePickerView.getContext();
        final int r22 = R.string.material_minute_selection;
        r20.setHourClickDelegate(new AnonymousClass2(this, r21, r22));
        return;
    L16:
        r16 = this.hourRotation;
        goto L17
    L12:
        r14 = this.time.getHourContentDescriptionResId();
        goto L13
    L9:
        r13 = getHourClockValues();
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }

    private void updateValues(String[] r5, String r10) {
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r5[r11] = TimeModel.formatText(this.timePickerView.getResources(), r5[r11], r10);
        r11 = r11 + 1;
        goto L4
    }
}
