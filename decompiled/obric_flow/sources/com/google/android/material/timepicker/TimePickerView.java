package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {
    static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private OnDoubleTapListener onDoubleTapListener;
    private OnPeriodChangeListener onPeriodChangeListener;
    private OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnPeriodChangeListener {
        void onPeriodChange(int r5);
    }

    public interface OnSelectionChange {
        void onSelectionChanged(int r5);
    }

    public TimePickerView(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ OnSelectionChange access$000(TimePickerView r5) {
        return r5.onSelectionChangeListener;
    }

    public static /* synthetic */ OnDoubleTapListener access$100(TimePickerView r5) {
        return r5.onDoubleTapListener;
    }

    public static /* synthetic */ void e(TimePickerView r5, MaterialButtonToggleGroup r10, int r11, boolean r12) {
        r5.lambda$new$0(r10, r11, r12);
    }

    private /* synthetic */ void lambda$new$0(MaterialButtonToggleGroup r5, int r10, boolean r11) {
        if (r11 == true) goto L4;
        return;
    L4:
        OnPeriodChangeListener r12 = this.onPeriodChangeListener;
        if (r12 != null) goto L7;
        return;
    L7:
        if (r10 != R.id.material_clock_period_pm_button) goto L9;
        int r13 = 1;
    L10:
        r12.onPeriodChange(r13);
        return;
    L9:
        r13 = 0;
        goto L10
    }

    private void setUpDisplay() {
        this.minuteView.setTag(R.id.selection_type, 12);
        this.hourView.setTag(R.id.selection_type, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
        this.minuteView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        this.hourView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector r5 = new GestureDetector(getContext(), new AnonymousClass2(this));
        View.OnTouchListener r10 = new AnonymousClass3(this, r5);
        this.minuteView.setOnTouchListener(r10);
        this.hourView.setOnTouchListener(r10);
    }

    private void updateSelection(Chip r5, boolean r10) {
        r5.setChecked(r10);
        if (r10 == false) goto L5;
        int r11 = 2;
    L6:
        ViewCompat.setAccessibilityLiveRegion(r5, r11);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener r5) {
        this.clockHandView.addOnRotateListener(r5);
    }

    public int getCurrentLevel() {
        return this.clockFace.getCurrentLevel();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View r5, int r10) {
        super.onVisibilityChanged(r5, r10);
        if (r5 != this) goto L7;
        if (r10 != 0) goto L8;
        this.hourView.sendAccessibilityEvent(8);
        return;
    L8:
        return;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setActiveSelection(int r5) {
        Chip r10 = this.minuteView;
        boolean r11 = false;
        if (r5 != 12) goto L5;
        boolean r12 = true;
    L6:
        updateSelection(r10, r12);
        Chip r13 = this.hourView;
        if (r5 != 10) goto L9;
        r11 = true;
    L9:
        updateSelection(r13, r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void setAnimateOnTouchUp(boolean r5) {
        this.clockHandView.setAnimateOnTouchUp(r5);
    }

    public void setCurrentLevel(int r5) {
        this.clockFace.setCurrentLevel(r5);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setHandRotation(float r5) {
        this.clockHandView.setHandRotation(r5);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat r5) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, r5);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat r5) {
        ViewCompat.setAccessibilityDelegate(this.hourView, r5);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener r5) {
        this.clockHandView.setOnActionUpListener(r5);
    }

    public void setOnDoubleTapListener(@Nullable OnDoubleTapListener r5) {
        this.onDoubleTapListener = r5;
    }

    public void setOnPeriodChangeListener(OnPeriodChangeListener r5) {
        this.onPeriodChangeListener = r5;
    }

    public void setOnSelectionChangeListener(OnSelectionChange r5) {
        this.onSelectionChangeListener = r5;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setValues(String[] r5, @StringRes int r10) {
        this.clockFace.setValues(r5, r10);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    @SuppressLint({"DefaultLocale"})
    public void updateTime(int r5, int r10, int r11) {
        if (r5 != 1) goto L5;
        int r12 = R.id.material_clock_period_pm_button;
    L6:
        this.toggle.check(r12);
        Locale r13 = getResources().getConfiguration().locale;
        String r14 = String.format(r13, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)});
        String r15 = String.format(r13, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r10)});
        if (TextUtils.equals(this.minuteView.getText(), r14) == true) goto L10;
        this.minuteView.setText(r14);
    L10:
        if (TextUtils.equals(this.hourView.getText(), r15) == true) goto L13;
        this.hourView.setText(r15);
        return;
    L13:
        return;
    L5:
        r12 = R.id.material_clock_period_am_button;
        goto L6
    }

    public TimePickerView(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public void setHandRotation(float r5, boolean r10) {
        this.clockHandView.setHandRotation(r5, r10);
    }

    public TimePickerView(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.selectionListener = new AnonymousClass1(this);
        LayoutInflater.from(r5).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup r12 = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = r12;
        r12.addOnButtonCheckedListener(new c(this, 1));
        this.minuteView = (Chip) findViewById(R.id.material_minute_tv);
        this.hourView = (Chip) findViewById(R.id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }
}
