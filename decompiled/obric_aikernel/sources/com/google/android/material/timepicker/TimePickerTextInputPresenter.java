package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.j;
import java.lang.reflect.Field;
import java.util.Locale;
import q5.f;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerTextInputPresenter implements TimePickerView.g, com.google.android.material.timepicker.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinearLayout f4057c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeModel f4058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextWatcher f4059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextWatcher f4060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ChipTextInputComboView f4061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ChipTextInputComboView f4062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.google.android.material.timepicker.c f4063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final EditText f4064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final EditText f4065n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MaterialButtonToggleGroup f4066o;

    class a extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimePickerTextInputPresenter f4067c;

        a(TimePickerTextInputPresenter r10) {
            this.f4067c = r10;
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            TimePickerTextInputPresenter.a(this.f4067c).setMinute(0);     // Catch: NumberFormatException -> L8
            return;
        L6:
            int r11 = Integer.parseInt(r10.toString());     // Catch: NumberFormatException -> L8
            TimePickerTextInputPresenter.a(this.f4067c).setMinute(r11);     // Catch: NumberFormatException -> L8
            return;
        }
    }

    class b extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimePickerTextInputPresenter f4068c;

        b(TimePickerTextInputPresenter r10) {
            this.f4068c = r10;
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            TimePickerTextInputPresenter.a(this.f4068c).setHour(0);     // Catch: NumberFormatException -> L8
            return;
        L6:
            int r11 = Integer.parseInt(r10.toString());     // Catch: NumberFormatException -> L8
            TimePickerTextInputPresenter.a(this.f4068c).setHour(r11);     // Catch: NumberFormatException -> L8
            return;
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimePickerTextInputPresenter f4069c;

        c(TimePickerTextInputPresenter r10) {
            this.f4069c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            this.f4069c.c(((Integer) r10.getTag(f.selection_type)).intValue());
        }
    }

    class d implements MaterialButtonToggleGroup.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TimePickerTextInputPresenter f4070a;

        d(TimePickerTextInputPresenter r10) {
            this.f4070a = r10;
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.c
        public void a(MaterialButtonToggleGroup r10, int r11, boolean r12) {
            if (r11 != f.material_clock_period_pm_button) goto L5;
            int r13 = 1;
        L6:
            TimePickerTextInputPresenter.a(this.f4070a).setPeriod(r13);
            return;
        L5:
            r13 = 0;
            goto L6
        }
    }

    public TimePickerTextInputPresenter(LinearLayout r10, final TimeModel r11) {
        this.f4059h = new a(this);
        this.f4060i = new b(this);
        this.f4057c = r10;
        this.f4058g = r11;
        Resources r12 = r10.getResources();
        ChipTextInputComboView r13 = (ChipTextInputComboView) r10.findViewById(f.material_minute_text_input);
        this.f4061j = r13;
        ChipTextInputComboView r14 = (ChipTextInputComboView) r10.findViewById(f.material_hour_text_input);
        this.f4062k = r14;
        int r15 = f.material_label;
        TextView r16 = (TextView) r13.findViewById(r15);
        TextView r17 = (TextView) r14.findViewById(r15);
        r16.setText(r12.getString(q5.j.material_timepicker_minute));
        r17.setText(r12.getString(q5.j.material_timepicker_hour));
        int r18 = f.selection_type;
        r13.setTag(r18, 12);
        r14.setTag(r18, 10);
        if (r11.format != 0) goto L5;
        k();
    L5:
        c r19 = new c(this);
        r14.setOnClickListener(r19);
        r13.setOnClickListener(r19);
        r14.c(r11.getHourInputValidator());
        r13.c(r11.getMinuteInputValidator());
        EditText r20 = r14.e().getEditText();
        this.f4064m = r20;
        EditText r21 = r13.e().getEditText();
        this.f4065n = r21;
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        int r22 = t5.a.d(r10, q5.b.colorPrimary);
        i(r20, r22);
        i(r21, r22);
    L8:
        this.f4063l = new com.google.android.material.timepicker.c(r14, r13, r11);
        final Context r23 = r10.getContext();
        final int r24 = q5.j.material_hour_selection;
        r14.f(new AnonymousClass4(this, r23, r24, r11));
        final Context r25 = r10.getContext();
        final int r26 = q5.j.material_minute_selection;
        r13.f(new AnonymousClass5(this, r25, r26, r11));
        f();
    }

    static /* synthetic */ TimeModel a(TimePickerTextInputPresenter r10) {
        return r10.f4058g;
    }

    private void b() {
        this.f4064m.addTextChangedListener(this.f4060i);
        this.f4065n.addTextChangedListener(this.f4059h);
    }

    private void g() {
        this.f4064m.removeTextChangedListener(this.f4060i);
        this.f4065n.removeTextChangedListener(this.f4059h);
    }

    private static void i(EditText r10, @ColorInt int r11) {
        Context r12 = r10.getContext();     // Catch: Throwable -> L4
        Field r13 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L4
        r13.setAccessible(true);     // Catch: Throwable -> L4
        int r14 = r13.getInt(r10);     // Catch: Throwable -> L4
        Field r15 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L4
        r15.setAccessible(true);     // Catch: Throwable -> L4
        Object r16 = r15.get(r10);     // Catch: Throwable -> L4
        Field r17 = r16.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L4
        r17.setAccessible(true);     // Catch: Throwable -> L4
        Drawable r18 = AppCompatResources.getDrawable(r12, r14);     // Catch: Throwable -> L4
        r18.setColorFilter(r11, PorterDuff.Mode.SRC_IN);     // Catch: Throwable -> L4
        r17.set(r16, new Drawable[]{r18, r18});     // Catch: Throwable -> L4
        return;
    }

    private void j(TimeModel r10) {
        g();
        Locale r11 = this.f4057c.getResources().getConfiguration().locale;
        String r12 = String.format(r11, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r10.minute)});
        String r13 = String.format(r11, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r10.getHourForDisplay())});
        this.f4061j.g(r12);
        this.f4062k.g(r13);
        b();
        l();
    }

    private void k() {
        MaterialButtonToggleGroup r10 = (MaterialButtonToggleGroup) this.f4057c.findViewById(f.material_clock_period_toggle);
        this.f4066o = r10;
        r10.b(new d(this));
        this.f4066o.setVisibility(0);
        l();
    }

    private void l() {
        MaterialButtonToggleGroup r10 = this.f4066o;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f4058g.period != 0) goto L8;
        int r11 = f.material_clock_period_am_button;
    L9:
        r10.e(r11);
        return;
    L8:
        r11 = f.material_clock_period_pm_button;
        goto L9
    }

    @Override // com.google.android.material.timepicker.TimePickerView.g
    public void c(int r10) {
        this.f4058g.selection = r10;
        ChipTextInputComboView r11 = this.f4061j;
        boolean r12 = true;
        if (r10 != 12) goto L5;
        boolean r13 = true;
    L6:
        r11.setChecked(r13);
        ChipTextInputComboView r14 = this.f4062k;
        if (r10 == 10) goto L10;
        r12 = false;
    L10:
        r14.setChecked(r12);
        l();
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.b
    public void d() {
        View r10 = this.f4057c.getFocusedChild();
        if (r10 != null) goto L6;
    L4:
        this.f4057c.setVisibility(8);
        return;
    L6:
        InputMethodManager r11 = (InputMethodManager) ContextCompat.getSystemService(this.f4057c.getContext(), InputMethodManager.class);
        if (r11 == null) goto L4;
        r11.hideSoftInputFromWindow(r10.getWindowToken(), 0);
        goto L4
    }

    public void e() {
        this.f4061j.setChecked(false);
        this.f4062k.setChecked(false);
    }

    public void f() {
        b();
        j(this.f4058g);
        this.f4063l.a();
    }

    public void h() {
        ChipTextInputComboView r10 = this.f4061j;
        boolean r11 = true;
        if (this.f4058g.selection != 12) goto L5;
        boolean r12 = true;
    L6:
        r10.setChecked(r12);
        ChipTextInputComboView r13 = this.f4062k;
        if (this.f4058g.selection == 10) goto L10;
        r11 = false;
    L10:
        r13.setChecked(r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.b
    public void invalidate() {
        j(this.f4058g);
    }

    @Override // com.google.android.material.timepicker.b
    public void show() {
        this.f4057c.setVisibility(0);
    }
}
