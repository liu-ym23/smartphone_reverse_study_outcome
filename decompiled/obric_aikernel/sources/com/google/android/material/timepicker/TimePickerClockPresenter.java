package com.google.android.material.timepicker;

import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.NetConst;
import q5.j;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerClockPresenter implements ClockHandView.d, TimePickerView.g, TimePickerView.f, ClockHandView.c, b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f4049k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f4050l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f4051m = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimePickerView f4052c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeModel f4053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f4054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f4055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f4056j;

    static {
        f4049k = new String[]{"12", NetConst.ENCRYPT_VERISON_CODE, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        f4050l = new String[]{"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};
        f4051m = new String[]{"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    }

    public TimePickerClockPresenter(TimePickerView r10, TimeModel r11) {
        this.f4056j = false;
        this.f4052c = r10;
        this.f4053g = r11;
        h();
    }

    static /* synthetic */ TimeModel e(TimePickerClockPresenter r10) {
        return r10.f4053g;
    }

    private int f() {
        if (this.f4053g.format != 1) goto L5;
        return 15;
    L5:
        return 30;
    }

    private String[] g() {
        if (this.f4053g.format != 1) goto L6;
        return f4050l;
    L6:
        return f4049k;
    }

    private void i(int r10, int r11) {
        TimeModel r12 = this.f4053g;
        if (r12.minute != r11) goto L7;
        if (r12.hour != r10) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        int r13 = 4;
    L10:
        this.f4052c.performHapticFeedback(r13);
        return;
    L9:
        r13 = 1;
        goto L10
    }

    private void k() {
        TimePickerView r10 = this.f4052c;
        TimeModel r11 = this.f4053g;
        r10.updateTime(r11.period, r11.getHourForDisplay(), this.f4053g.minute);
    }

    private void l() {
        m(f4049k, TimeModel.NUMBER_FORMAT);
        m(f4050l, TimeModel.NUMBER_FORMAT);
        m(f4051m, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void m(String[] r10, String r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r10[r12] = TimeModel.formatText(this.f4052c.getResources(), r10[r12], r11);
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float r10, boolean r11) {
        this.f4056j = true;
        TimeModel r12 = this.f4053g;
        int r13 = r12.minute;
        int r14 = r12.hour;
        if (r12.selection != 10) goto L12;
        this.f4052c.setHandRotation(this.f4055i, false);
        AccessibilityManager r15 = (AccessibilityManager) ContextCompat.getSystemService(this.f4052c.getContext(), AccessibilityManager.class);
        if (r15 != null) goto L7;
    L9:
        boolean r16 = false;
    L10:
        if (r16 == true) goto L16;
        j(12, true);
    L16:
        this.f4056j = false;
        k();
        i(r14, r13);
        return;
    L7:
        if (r15.isTouchExplorationEnabled() == false) goto L9;
        r16 = true;
        goto L10
    L12:
        int r17 = Math.round(r10);
        if (r11 == true) goto L15;
        this.f4053g.setMinute(((r17 + 15) / 30) * 5);
        this.f4054h = this.f4053g.minute * 6;
    L15:
        this.f4052c.setHandRotation(this.f4054h, r11);
        goto L16
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void b(int r10) {
        this.f4053g.setPeriod(r10);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void c(int r10) {
        j(r10, true);
    }

    @Override // com.google.android.material.timepicker.b
    public void d() {
        this.f4052c.setVisibility(8);
    }

    public void h() {
        if (this.f4053g.format != 0) goto L5;
        this.f4052c.showToggle();
    L5:
        this.f4052c.addOnRotateListener(this);
        this.f4052c.setOnSelectionChangeListener(this);
        this.f4052c.setOnPeriodChangeListener(this);
        this.f4052c.setOnActionUpListener(this);
        l();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.b
    public void invalidate() {
        this.f4055i = this.f4053g.getHourForDisplay() * f();
        TimeModel r10 = this.f4053g;
        this.f4054h = r10.minute * 6;
        j(r10.selection, false);
        k();
    }

    void j(int r10, boolean r11) {
        if (r10 != 12) goto L5;
        boolean r12 = true;
    L6:
        this.f4052c.setAnimateOnTouchUp(r12);
        this.f4053g.selection = r10;
        TimePickerView r13 = this.f4052c;
        if (r12 == false) goto L9;
        String[] r14 = f4051m;
    L10:
        if (r12 == false) goto L12;
        int r15 = j.material_minute_suffix;
    L13:
        r13.setValues(r14, r15);
        TimePickerView r16 = this.f4052c;
        if (r12 == false) goto L16;
        float r17 = this.f4054h;
    L17:
        r16.setHandRotation(r17, r11);
        this.f4052c.setActiveSelection(r10);
        TimePickerView r18 = this.f4052c;
        final Context r19 = this.f4052c.getContext();
        final int r20 = j.material_hour_selection;
        r18.setMinuteHourDelegate(new AnonymousClass1(this, r19, r20));
        TimePickerView r21 = this.f4052c;
        final Context r22 = this.f4052c.getContext();
        final int r23 = j.material_minute_selection;
        r21.setHourClickDelegate(new AnonymousClass2(this, r22, r23));
        return;
    L16:
        r17 = this.f4055i;
        goto L17
    L12:
        r15 = j.material_hour_suffix;
        goto L13
    L9:
        r14 = g();
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void onRotate(float r10, boolean r11) {
        if (this.f4056j == false) goto L5;
        return;
    L5:
        TimeModel r12 = this.f4053g;
        int r13 = r12.hour;
        int r14 = r12.minute;
        int r15 = Math.round(r10);
        TimeModel r16 = this.f4053g;
        if (r16.selection != 12) goto L8;
        r16.setMinute((r15 + 3) / 6);
        this.f4054h = (float) Math.floor(this.f4053g.minute * 6);
    L9:
        if (r11 == true) goto L12;
        k();
        i(r13, r14);
        return;
    L12:
        return;
    L8:
        this.f4053g.setHour((r15 + (f() / 2)) / f());
        this.f4055i = this.f4053g.getHourForDisplay() * f();
        goto L9
    }

    @Override // com.google.android.material.timepicker.b
    public void show() {
        this.f4052c.setVisibility(0);
    }
}
