package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class e implements TimePickerView.c, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f4207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeModel f4208b;
    private final TextWatcher c;
    private final TextWatcher d;
    private final ChipTextInputComboView e;
    private final ChipTextInputComboView f;
    private final d g;
    private final EditText h;
    private final EditText i;
    private MaterialButtonToggleGroup j;

    public e(LinearLayout r11, final TimeModel r12) {
        this.c = new AnonymousClass1(this);
        this.d = new AnonymousClass2(this);
        this.f4207a = r11;
        this.f4208b = r12;
        Resources r1 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin");
        ChipTextInputComboView r2 = (ChipTextInputComboView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.material_minute_text_input, OaidModel.KEY_ID, "material_minute_text_input")), ChipTextInputComboView.class, "com.obric.memorydata.plugin");
        this.e = r2;
        ChipTextInputComboView r4 = (ChipTextInputComboView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.material_hour_text_input, OaidModel.KEY_ID, "material_hour_text_input")), ChipTextInputComboView.class, "com.obric.memorydata.plugin");
        this.f = r4;
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.material_label, OaidModel.KEY_ID, "material_label")), TextView.class, "com.obric.memorydata.plugin");
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(R.id.material_label, OaidModel.KEY_ID, "material_label")), TextView.class, "com.obric.memorydata.plugin");
        r5.setText(r1.getString(ZeusTransformUtils.mapRes(R.string.material_timepicker_minute, TypedValues.Custom.S_STRING, "material_timepicker_minute")));
        r6.setText(r1.getString(ZeusTransformUtils.mapRes(R.string.material_timepicker_hour, TypedValues.Custom.S_STRING, "material_timepicker_hour")));
        r2.setTag(ZeusTransformUtils.mapRes(R.id.selection_type, OaidModel.KEY_ID, "selection_type"), 12);
        r4.setTag(ZeusTransformUtils.mapRes(R.id.selection_type, OaidModel.KEY_ID, "selection_type"), 10);
        if (r12.format != 0) goto L5;
        i();
    L5:
        View.OnClickListener r3 = new AnonymousClass3(this);
        r4.setOnClickListener(r3);
        r2.setOnClickListener(r3);
        r4.a(r12.getHourInputValidator());
        r2.a(r12.getMinuteInputValidator());
        EditText r7 = r4.a().getEditText();
        this.h = r7;
        EditText r8 = r2.a().getEditText();
        this.i = r8;
        if (Build.VERSION.SDK_INT >= 21) goto L8;
        int r9 = com.google.android.material.c.a.a(r11, ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"));
        a(r7, r9);
        a(r8, r9);
    L8:
        this.g = new d(r4, r2, r12);
        final Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        final int r13 = ZeusTransformUtils.mapRes(R.string.material_hour_selection, TypedValues.Custom.S_STRING, "material_hour_selection");
        r4.a(new TimePickerTextInputPresenter$4(this, r10, r13, r12));
        final Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        final int r0 = ZeusTransformUtils.mapRes(R.string.material_minute_selection, TypedValues.Custom.S_STRING, "material_minute_selection");
        r2.a(new TimePickerTextInputPresenter$5(this, r14, r0, r12));
        a();
    }

    static /* synthetic */ TimeModel a(e r0) {
        return r0.f4208b;
    }

    private static void a(EditText r5, int r6) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Field r1 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
        int r2 = r1.getInt(r5);     // Catch: Throwable -> L5
        Field r3 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        Object r7 = r3.get(r5);     // Catch: Throwable -> L5
        Field r4 = r7.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L5
        r4.setAccessible(true);     // Catch: Throwable -> L5
        Drawable r8 = AppCompatResources.getDrawable(r0, r2);     // Catch: Throwable -> L5
        r8.setColorFilter(r6, PorterDuff.Mode.SRC_IN);     // Catch: Throwable -> L5
        r4.set(r7, new Drawable[]{r8, r8});     // Catch: Throwable -> L5
        return;
    }

    private void a(TimeModel r6) {
        h();
        Locale r0 = ZeusTransformUtils.getResources(this.f4207a, "com.obric.memorydata.plugin").getConfiguration().locale;
        String r2 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.minute)});
        String r7 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.getHourForDisplay())});
        this.e.a(r2);
        this.f.a(r7);
        g();
        j();
    }

    private void g() {
        this.h.addTextChangedListener(this.d);
        this.i.addTextChangedListener(this.c);
    }

    private void h() {
        this.h.removeTextChangedListener(this.d);
        this.i.removeTextChangedListener(this.c);
    }

    private void i() {
        MaterialButtonToggleGroup r0 = (MaterialButtonToggleGroup) ZeusTransformUtils.preCheckCast(this.f4207a.findViewById(ZeusTransformUtils.mapRes(R.id.material_clock_period_toggle, OaidModel.KEY_ID, "material_clock_period_toggle")), MaterialButtonToggleGroup.class, "com.obric.memorydata.plugin");
        this.j = r0;
        r0.a(new AnonymousClass4(this));
        this.j.setVisibility(0);
        j();
    }

    private void j() {
        MaterialButtonToggleGroup r0 = this.j;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f4208b.period != 0) goto L8;
        int r3 = R.id.material_clock_period_am_button;
        String r2 = "material_clock_period_am_button";
    L9:
        r0.a(ZeusTransformUtils.mapRes(r3, OaidModel.KEY_ID, r2));
        return;
    L8:
        r3 = R.id.material_clock_period_pm_button;
        r2 = "material_clock_period_pm_button";
        goto L9
    }

    public void a() {
        g();
        a(this.f4208b);
        this.g.a();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.c
    public void a(int r5) {
        this.f4208b.selection = r5;
        ChipTextInputComboView r0 = this.e;
        boolean r1 = true;
        if (r5 != 12) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        ChipTextInputComboView r2 = this.f;
        if (r5 == 10) goto L10;
        r1 = false;
    L10:
        r2.setChecked(r1);
        j();
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.c
    public void b() {
        a(this.f4208b);
    }

    @Override // com.google.android.material.timepicker.c
    public void c() {
        this.f4207a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.c
    public void d() {
        View r0 = this.f4207a.getFocusedChild();
        if (r0 != null) goto L6;
    L4:
        this.f4207a.setVisibility(8);
        return;
    L6:
        InputMethodManager r2 = (InputMethodManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f4207a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), InputMethodManager.class), InputMethodManager.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r2.hideSoftInputFromWindow(r0.getWindowToken(), 0);
        goto L4
    }

    public void e() {
        ChipTextInputComboView r0 = this.e;
        boolean r2 = true;
        if (this.f4208b.selection != 12) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        ChipTextInputComboView r3 = this.f;
        if (this.f4208b.selection == 10) goto L10;
        r2 = false;
    L10:
        r3.setChecked(r2);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void f() {
        this.e.setChecked(false);
        this.f.setChecked(false);
    }
}
