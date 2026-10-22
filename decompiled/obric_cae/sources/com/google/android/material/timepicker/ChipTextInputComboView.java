package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.k;
import com.google.android.material.internal.n;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chip f5133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f5134b;

    public class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChipTextInputComboView f5135a;

        public a(ChipTextInputComboView r8) {
            this.f5135a = r8;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r8) {
            boolean r10 = TextUtils.isEmpty(r8);
            ChipTextInputComboView r11 = this.f5135a;
            if (r10 == false) goto L6;
            r11.f5133a.setText(ChipTextInputComboView.a(r11, "00"));
            return;
        L6:
            String r12 = ChipTextInputComboView.a(r11, r8);
            Chip r13 = r11.f5133a;
            if (TextUtils.isEmpty(r12) == false) goto L9;
            r12 = ChipTextInputComboView.a(r11, "00");
        L9:
            r13.setText(r12);
        }
    }

    public ChipTextInputComboView(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        LayoutInflater r11 = LayoutInflater.from(r8);
        Chip r12 = (Chip) r11.inflate(R.layout.material_time_chip, this, false);
        this.f5133a = r12;
        r12.setAccessibilityClassName("android.view.View");
        TextInputLayout r13 = (TextInputLayout) r11.inflate(R.layout.material_time_input, this, false);
        EditText r14 = r13.getEditText();
        this.f5134b = r14;
        r14.setVisibility(4);
        r14.addTextChangedListener(new a(this));
        r14.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(r12);
        addView(r13);
        TextView r15 = (TextView) findViewById(R.id.material_label);
        WeakHashMap<View, h0> r16 = w.f8437a;
        r14.setId(w.e.a());
        w.e.h(r15, r14.getId());
        r14.setSaveEnabled(false);
        r14.setLongClickable(false);
    }

    public static String a(ChipTextInputComboView r8, CharSequence r10) {
        return String.format(r8.getResources().getConfiguration().locale, "%02d", new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(r10)))});
    L5:
        return null;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f5133a.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        LocaleList r10 = getContext().getResources().getConfiguration().getLocales();
        this.f5134b.setImeHintLocales(r10);
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean r8) {
        Chip r10 = this.f5133a;
        r10.setChecked(r8);
        int r11 = 0;
        if (r8 == false) goto L5;
        int r12 = 0;
    L6:
        EditText r13 = this.f5134b;
        r13.setVisibility(r12);
        if (r8 == false) goto L9;
        r11 = 8;
    L9:
        r10.setVisibility(r11);
        if (isChecked() == false) goto L13;
        r13.requestFocus();
        r13.post(new n(r13));
        return;
    L13:
        return;
    L5:
        r12 = 4;
        goto L6
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener r8) {
        this.f5133a.setOnClickListener(r8);
    }

    @Override // android.view.View
    public final void setTag(int r8, Object r10) {
        this.f5133a.setTag(r8, r10);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f5133a.toggle();
    }
}
