package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.j;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import q5.f;
import q5.h;

/* JADX INFO: loaded from: classes2.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Chip f4021c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout f4022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final EditText f4023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextWatcher f4024i;

    static /* synthetic */ class a {
    }

    private class b extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ChipTextInputComboView f4025c;

        private b(ChipTextInputComboView r10) {
            this.f4025c = r10;
        }

        /* synthetic */ b(ChipTextInputComboView r10, a r11) {
            this(r10);
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            ChipTextInputComboView.b(this.f4025c).setText(ChipTextInputComboView.a(this.f4025c, "00"));
            return;
        L6:
            ChipTextInputComboView.b(this.f4025c).setText(ChipTextInputComboView.a(this.f4025c, r10));
        }
    }

    public ChipTextInputComboView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ChipTextInputComboView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        LayoutInflater r13 = LayoutInflater.from(r10);
        Chip r14 = (Chip) r13.inflate(h.material_time_chip, this, false);
        this.f4021c = r14;
        r14.setAccessibilityClassName("android.view.View");
        TextInputLayout r15 = (TextInputLayout) r13.inflate(h.material_time_input, this, false);
        this.f4022g = r15;
        EditText r16 = r15.getEditText();
        this.f4023h = r16;
        r16.setVisibility(4);
        b r17 = new b(this, null);
        this.f4024i = r17;
        r16.addTextChangedListener(r17);
        h();
        addView(r14);
        addView(r15);
        TextView r18 = (TextView) findViewById(f.material_label);
        r16.setSaveEnabled(false);
        r16.setLongClickable(false);
    }

    static /* synthetic */ String a(ChipTextInputComboView r10, CharSequence r11) {
        return r10.d(r11);
    }

    static /* synthetic */ Chip b(ChipTextInputComboView r10) {
        return r10.f4021c;
    }

    private String d(CharSequence r10) {
        return TimeModel.formatText(getResources(), r10);
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        LocaleList r10 = getContext().getResources().getConfiguration().getLocales();
        this.f4023h.setImeHintLocales(r10);
        return;
    }

    public void c(InputFilter r10) {
        InputFilter[] r11 = this.f4023h.getFilters();
        InputFilter[] r12 = (InputFilter[]) Arrays.copyOf(r11, r11.length + 1);
        r12[r11.length] = r10;
        this.f4023h.setFilters(r12);
    }

    public TextInputLayout e() {
        return this.f4022g;
    }

    public void f(AccessibilityDelegateCompat r10) {
        ViewCompat.setAccessibilityDelegate(this.f4021c, r10);
    }

    public void g(CharSequence r10) {
        this.f4021c.setText(d(r10));
        if (TextUtils.isEmpty(this.f4023h.getText()) == true) goto L6;
        this.f4023h.removeTextChangedListener(this.f4024i);
        this.f4023h.setText(null);
        this.f4023h.addTextChangedListener(this.f4024i);
        return;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f4021c.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        this.f4021c.setChecked(r10);
        EditText r11 = this.f4023h;
        int r12 = 0;
        if (r10 == false) goto L5;
        int r13 = 0;
    L6:
        r11.setVisibility(r13);
        Chip r14 = this.f4021c;
        if (r10 == false) goto L9;
        r12 = 8;
    L9:
        r14.setVisibility(r12);
        if (isChecked() == false) goto L15;
        ViewUtils.l(this.f4023h);
        if (TextUtils.isEmpty(this.f4023h.getText()) == true) goto L16;
        EditText r15 = this.f4023h;
        r15.setSelection(r15.getText().length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r13 = 4;
        goto L6
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r10) {
        this.f4021c.setOnClickListener(r10);
    }

    @Override // android.view.View
    public void setTag(int r10, Object r11) {
        this.f4021c.setTag(r10, r11);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f4021c.toggle();
    }
}
