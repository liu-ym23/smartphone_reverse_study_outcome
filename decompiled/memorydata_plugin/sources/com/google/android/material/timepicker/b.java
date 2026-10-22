package com.google.android.material.timepicker;

import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class b implements ClockHandView.a, ClockHandView.b, TimePickerView.b, TimePickerView.c, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f4203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f4204b = null;
    private static final String[] c = null;
    private final TimePickerView d;
    private final TimeModel e;
    private float f;
    private float g;
    private boolean h;

    static {
        f4203a = new String[]{"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        f4204b = new String[]{"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", BDLocationException.ERROR_AMAP_FAIL};
        c = new String[]{"00", "5", "10", "15", "20", "25", BDLocationException.ERROR_SDK_NO_PERMISSION, "35", BDLocationException.ERROR_MULTI_THREAD_LOCATE, "45", BDLocationException.ERROR_BYTE_SCAN_RESULT_IS_EMPTY, "55"};
    }

    public b(TimePickerView r2, TimeModel r3) {
        this.h = false;
        this.d = r2;
        this.e = r3;
        a();
    }

    static /* synthetic */ TimeModel a(b r0) {
        return r0.e;
    }

    private void a(int r2, int r3) {
        if (this.e.minute != r3) goto L7;
        if (this.e.hour != r2) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        int r4 = 4;
    L10:
        this.d.performHapticFeedback(r4);
        return;
    L9:
        r4 = 1;
        goto L10
    }

    private void a(String[] r4, String r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r4[r0] = TimeModel.formatText(ZeusTransformUtils.getResources(this.d, "com.obric.memorydata.plugin"), r4[r0], r5);
        r0 = r0 + 1;
        goto L4
    }

    private String[] e() {
        if (this.e.format != 1) goto L6;
        return f4204b;
    L6:
        return f4203a;
    }

    private int f() {
        if (this.e.format != 1) goto L5;
        return 15;
    L5:
        return 30;
    }

    private void g() {
        this.d.updateTime(this.e.period, this.e.getHourForDisplay(), this.e.minute);
    }

    private void h() {
        a(f4203a, TimeModel.NUMBER_FORMAT);
        a(f4204b, TimeModel.NUMBER_FORMAT);
        a(c, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    public void a() {
        if (this.e.format != 0) goto L5;
        this.d.showToggle();
    L5:
        this.d.addOnRotateListener(this);
        this.d.setOnSelectionChangeListener(this);
        this.d.setOnPeriodChangeListener(this);
        this.d.setOnActionUpListener(this);
        h();
        b();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.a
    public void a(float r7, boolean r8) {
        this.h = true;
        int r1 = this.e.minute;
        int r2 = this.e.hour;
        if (this.e.selection != 10) goto L12;
        this.d.setHandRotation(this.g, false);
        AccessibilityManager r9 = (AccessibilityManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), AccessibilityManager.class), AccessibilityManager.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == true) goto L16;
        a(12, true);
    L16:
        this.h = false;
        g();
        a(r2, r1);
        return;
    L7:
        if (r9.isTouchExplorationEnabled() == false) goto L9;
        r10 = true;
        goto L10
    L12:
        int r11 = Math.round(r7);
        if (r8 == true) goto L15;
        this.e.setMinute(((r11 + 15) / 30) * 5);
        this.f = this.e.minute * 6;
    L15:
        this.d.setHandRotation(this.f, r8);
        goto L16
    }

    @Override // com.google.android.material.timepicker.TimePickerView.c
    public void a(int r2) {
        a(r2, true);
    }

    void a(int r7, boolean r8) {
        if (r7 != 12) goto L5;
        boolean r0 = true;
    L6:
        this.d.setAnimateOnTouchUp(r0);
        this.e.selection = r7;
        TimePickerView r1 = this.d;
        if (r0 == false) goto L9;
        String[] r2 = c;
    L11:
        if (r0 == false) goto L13;
        int r4 = R.string.material_minute_suffix;
        String r5 = "material_minute_suffix";
    L14:
        r1.setValues(r2, ZeusTransformUtils.mapRes(r4, TypedValues.Custom.S_STRING, r5));
        TimePickerView r3 = this.d;
        if (r0 == false) goto L17;
        float r6 = this.f;
    L18:
        r3.setHandRotation(r6, r8);
        this.d.setActiveSelection(r7);
        TimePickerView r9 = this.d;
        final Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        final int r11 = ZeusTransformUtils.mapRes(R.string.material_hour_selection, TypedValues.Custom.S_STRING, "material_hour_selection");
        r9.setMinuteHourDelegate(new TimePickerClockPresenter$1(this, r10, r11));
        TimePickerView r12 = this.d;
        final Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        final int r14 = ZeusTransformUtils.mapRes(R.string.material_minute_selection, TypedValues.Custom.S_STRING, "material_minute_selection");
        r12.setHourClickDelegate(new TimePickerClockPresenter$2(this, r13, r14));
        return;
    L17:
        r6 = this.g;
        goto L18
    L13:
        r4 = R.string.material_hour_suffix;
        r5 = "material_hour_suffix";
        goto L14
    L9:
        r2 = e();
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.c
    public void b() {
        this.g = this.e.getHourForDisplay() * f();
        this.f = this.e.minute * 6;
        a(this.e.selection, false);
        g();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.b
    public void b(int r1) {
        this.e.setPeriod(r1);
    }

    @Override // com.google.android.material.timepicker.c
    public void c() {
        this.d.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.c
    public void d() {
        this.d.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void onRotate(float r5, boolean r6) {
        if (this.h == false) goto L5;
        return;
    L5:
        int r0 = this.e.hour;
        int r1 = this.e.minute;
        int r7 = Math.round(r5);
        if (this.e.selection != 12) goto L8;
        this.e.setMinute((r7 + 3) / 6);
        this.f = (float) Math.floor(this.e.minute * 6);
    L9:
        if (r6 == true) goto L12;
        g();
        a(r0, r1);
        return;
    L12:
        return;
    L8:
        this.e.setHour((r7 + (f() / 2)) / f());
        this.g = this.e.getHourForDisplay() * f();
        goto L9
    }
}
