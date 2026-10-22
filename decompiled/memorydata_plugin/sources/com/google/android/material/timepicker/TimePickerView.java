package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerView extends ConstraintLayout {
    static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private a onDoubleTapListener;
    private b onPeriodChangeListener;
    private c onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    interface a {
        void onDoubleTap();
    }

    interface b {
        void b(int r1);
    }

    interface c {
        void a(int r1);
    }

    public TimePickerView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public TimePickerView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public TimePickerView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r6, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        this.selectionListener = new AnonymousClass1(this);
        ZeusTransformUtils.inflate(LayoutInflater.from(r6), ZeusTransformUtils.mapRes(R.layout.material_timepicker, "layout", "material_timepicker"), this, "com.obric.memorydata.plugin");
        this.clockFace = (ClockFaceView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_clock_face, OaidModel.KEY_ID, "material_clock_face")), ClockFaceView.class, "com.obric.memorydata.plugin");
        MaterialButtonToggleGroup r7 = (MaterialButtonToggleGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_clock_period_toggle, OaidModel.KEY_ID, "material_clock_period_toggle")), MaterialButtonToggleGroup.class, "com.obric.memorydata.plugin");
        this.toggle = r7;
        r7.a(new AnonymousClass2(this));
        this.minuteView = (Chip) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_minute_tv, OaidModel.KEY_ID, "material_minute_tv")), Chip.class, "com.obric.memorydata.plugin");
        this.hourView = (Chip) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_hour_tv, OaidModel.KEY_ID, "material_hour_tv")), Chip.class, "com.obric.memorydata.plugin");
        this.clockHandView = (ClockHandView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_clock_hand, OaidModel.KEY_ID, "material_clock_hand")), ClockHandView.class, "com.obric.memorydata.plugin");
        setupDoubleTap();
        setUpDisplay();
    }

    static /* synthetic */ c access$000(TimePickerView r0) {
        return r0.onSelectionChangeListener;
    }

    static /* synthetic */ b access$100(TimePickerView r0) {
        return r0.onPeriodChangeListener;
    }

    static /* synthetic */ a access$200(TimePickerView r0) {
        return r0.onDoubleTapListener;
    }

    private void setUpDisplay() {
        this.minuteView.setTag(ZeusTransformUtils.mapRes(R.id.selection_type, OaidModel.KEY_ID, "selection_type"), 12);
        this.hourView.setTag(ZeusTransformUtils.mapRes(R.id.selection_type, OaidModel.KEY_ID, "selection_type"), 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
        this.minuteView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        this.hourView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    }

    private void setupDoubleTap() {
        final GestureDetector r0 = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new AnonymousClass3(this));
        View.OnTouchListener r1 = new AnonymousClass4(this, r0);
        this.minuteView.setOnTouchListener(r1);
        this.hourView.setOnTouchListener(r1);
    }

    private void updateSelection(Chip r1, boolean r2) {
        r1.setChecked(r2);
        if (r2 == false) goto L5;
        int r0 = 2;
    L6:
        ViewCompat.setAccessibilityLiveRegion(r1, r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() != 0) goto L12;
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(this);
        int r2 = 1;
        if (ViewCompat.getLayoutDirection(this) != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r2 = 2;
    L10:
        r0.clear(ZeusTransformUtils.mapRes(R.id.material_clock_display, OaidModel.KEY_ID, "material_clock_display"), r2);
        r0.applyTo(this);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void addOnRotateListener(ClockHandView.b r3) {
        ClockHandView.b r4 = (ClockHandView.b) ZeusTransformUtils.wrapperContextForParams(r3, ClockHandView.b.class, "com.obric.memorydata.plugin");
        this.clockHandView.a(r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r1 != this) goto L7;
        if (r2 != 0) goto L8;
        updateToggleConstraints();
        return;
    L8:
        return;
    }

    public void setActiveSelection(int r5) {
        Chip r0 = this.minuteView;
        boolean r1 = true;
        if (r5 != 12) goto L5;
        boolean r3 = true;
    L6:
        updateSelection(r0, r3);
        Chip r2 = this.hourView;
        if (r5 == 10) goto L10;
        r1 = false;
    L10:
        updateSelection(r2, r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void setAnimateOnTouchUp(boolean r1) {
        this.clockHandView.a(r1);
    }

    public void setHandRotation(float r1) {
        this.clockHandView.a(r1);
    }

    public void setHandRotation(float r1, boolean r2) {
        this.clockHandView.a(r1, r2);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat r1) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, r1);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat r1) {
        ViewCompat.setAccessibilityDelegate(this.hourView, r1);
    }

    public void setOnActionUpListener(ClockHandView.a r3) {
        ClockHandView.a r4 = (ClockHandView.a) ZeusTransformUtils.wrapperContextForParams(r3, ClockHandView.a.class, "com.obric.memorydata.plugin");
        this.clockHandView.a(r4);
    }

    void setOnDoubleTapListener(a r3) {
        this.onDoubleTapListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    void setOnPeriodChangeListener(b r3) {
        this.onPeriodChangeListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    void setOnSelectionChangeListener(c r3) {
        this.onSelectionChangeListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public void setValues(String[] r1, int r2) {
        this.clockFace.setValues(r1, r2);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    public void updateTime(int r4, int r5, int r6) {
        if (r4 != 1) goto L5;
        int r7 = R.id.material_clock_period_pm_button;
        String r2 = "material_clock_period_pm_button";
    L6:
        this.toggle.a(ZeusTransformUtils.mapRes(r7, OaidModel.KEY_ID, r2));
        Locale r8 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().locale;
        String r0 = String.format(r8, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6)});
        String r9 = String.format(r8, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r5)});
        if (TextUtils.equals(this.minuteView.getText(), r0) == true) goto L10;
        this.minuteView.setText(r0);
    L10:
        if (TextUtils.equals(this.hourView.getText(), r9) == true) goto L13;
        this.hourView.setText(r9);
        return;
    L13:
        return;
    L5:
        r7 = R.id.material_clock_period_am_button;
        r2 = "material_clock_period_am_button";
        goto L6
    }
}
