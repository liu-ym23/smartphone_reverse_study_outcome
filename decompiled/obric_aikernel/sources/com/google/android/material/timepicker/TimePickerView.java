package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;
import q5.h;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout {
    static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private e onDoubleTapListener;
    private f onPeriodChangeListener;
    private g onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimePickerView f4071c;

        a(TimePickerView r10) {
            this.f4071c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if (TimePickerView.access$000(this.f4071c) == null) goto L6;
            TimePickerView.access$000(this.f4071c).c(((Integer) r10.getTag(q5.f.selection_type)).intValue());
            return;
        }
    }

    class b implements MaterialButtonToggleGroup.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TimePickerView f4072a;

        b(TimePickerView r10) {
            this.f4072a = r10;
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.c
        public void a(MaterialButtonToggleGroup r10, int r11, boolean r12) {
            if (r11 != q5.f.material_clock_period_pm_button) goto L5;
            int r13 = 1;
        L7:
            if (TimePickerView.access$100(this.f4072a) == null) goto L11;
            if (r12 == false) goto L12;
            TimePickerView.access$100(this.f4072a).b(r13);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r13 = 0;
            goto L7
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TimePickerView f4073a;

        c(TimePickerView r10) {
            this.f4073a = r10;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r10) {
            e r11 = TimePickerView.access$200(this.f4073a);
            if (r11 == null) goto L6;
            r11.onDoubleTap();
            return true;
        L6:
            return false;
        }
    }

    class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ GestureDetector f4074c;

        d(TimePickerView r10, GestureDetector r11) {
            this.f4074c = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            if (((Checkable) r10).isChecked() == true) goto L5;
            return false;
        L5:
            return this.f4074c.onTouchEvent(r11);
        }
    }

    interface e {
        void onDoubleTap();
    }

    interface f {
        void b(int r10);
    }

    interface g {
        void c(int r10);
    }

    public TimePickerView(Context r10) {
        this(r10, null);
    }

    public TimePickerView(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public TimePickerView(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.selectionListener = new a(this);
        LayoutInflater.from(r10).inflate(h.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(q5.f.material_clock_face);
        MaterialButtonToggleGroup r13 = (MaterialButtonToggleGroup) findViewById(q5.f.material_clock_period_toggle);
        this.toggle = r13;
        r13.b(new b(this));
        this.minuteView = (Chip) findViewById(q5.f.material_minute_tv);
        this.hourView = (Chip) findViewById(q5.f.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(q5.f.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }

    static /* synthetic */ g access$000(TimePickerView r10) {
        return r10.onSelectionChangeListener;
    }

    static /* synthetic */ f access$100(TimePickerView r10) {
        return r10.onPeriodChangeListener;
    }

    static /* synthetic */ e access$200(TimePickerView r10) {
        return r10.onDoubleTapListener;
    }

    private void setUpDisplay() {
        Chip r10 = this.minuteView;
        int r11 = q5.f.selection_type;
        r10.setTag(r11, 12);
        this.hourView.setTag(r11, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
        this.minuteView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        this.hourView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        d r10 = new d(this, new GestureDetector(getContext(), new c(this)));
        this.minuteView.setOnTouchListener(r10);
        this.hourView.setOnTouchListener(r10);
    }

    private void updateSelection(Chip r10, boolean r11) {
        r10.setChecked(r11);
        if (r11 == false) goto L5;
        int r12 = 2;
    L6:
        ViewCompat.setAccessibilityLiveRegion(r10, r12);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() != 0) goto L12;
        ConstraintSet r10 = new ConstraintSet();
        r10.clone(this);
        int r11 = 1;
        if (ViewCompat.getLayoutDirection(this) != 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L10;
        r11 = 2;
    L10:
        r10.clear(q5.f.material_clock_display, r11);
        r10.applyTo(this);
        return;
    L7:
        r12 = false;
        goto L8
    }

    public void addOnRotateListener(ClockHandView.d r10) {
        this.clockHandView.b(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if (r10 != this) goto L7;
        if (r11 != 0) goto L8;
        updateToggleConstraints();
        return;
    L8:
        return;
    }

    public void setActiveSelection(int r10) {
        Chip r11 = this.minuteView;
        boolean r12 = true;
        if (r10 != 12) goto L5;
        boolean r13 = true;
    L6:
        updateSelection(r11, r13);
        Chip r14 = this.hourView;
        if (r10 == 10) goto L10;
        r12 = false;
    L10:
        updateSelection(r14, r12);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public void setAnimateOnTouchUp(boolean r10) {
        this.clockHandView.j(r10);
    }

    public void setHandRotation(float r10) {
        this.clockHandView.l(r10);
    }

    public void setHandRotation(float r10, boolean r11) {
        this.clockHandView.m(r10, r11);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat r10) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, r10);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat r10) {
        ViewCompat.setAccessibilityDelegate(this.hourView, r10);
    }

    public void setOnActionUpListener(ClockHandView.c r10) {
        this.clockHandView.o(r10);
    }

    void setOnDoubleTapListener(@Nullable e r10) {
        this.onDoubleTapListener = r10;
    }

    void setOnPeriodChangeListener(f r10) {
        this.onPeriodChangeListener = r10;
    }

    void setOnSelectionChangeListener(g r10) {
        this.onSelectionChangeListener = r10;
    }

    public void setValues(String[] r10, @StringRes int r11) {
        this.clockFace.setValues(r10, r11);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @SuppressLint({"DefaultLocale"})
    public void updateTime(int r10, int r11, int r12) {
        if (r10 != 1) goto L5;
        int r13 = q5.f.material_clock_period_pm_button;
    L6:
        this.toggle.e(r13);
        Locale r14 = getResources().getConfiguration().locale;
        String r15 = String.format(r14, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r12)});
        String r16 = String.format(r14, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)});
        if (TextUtils.equals(this.minuteView.getText(), r15) == true) goto L10;
        this.minuteView.setText(r15);
    L10:
        if (TextUtils.equals(this.hourView.getText(), r16) == true) goto L13;
        this.hourView.setText(r16);
        return;
    L13:
        return;
    L5:
        r13 = q5.f.material_clock_period_am_button;
        goto L6
    }
}
