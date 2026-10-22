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
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.j;
import com.google.android.material.internal.r;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chip f4183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f4184b;
    private final EditText c;
    private TextWatcher d;
    private TextView e;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ChipTextInputComboView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChipTextInputComboView f4185a;

        private a(ChipTextInputComboView r1) {
            this.f4185a = r1;
        }

        /* synthetic */ a(ChipTextInputComboView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.android.material.internal.j, android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
            if (TextUtils.isEmpty(r4) == false) goto L6;
            ChipTextInputComboView.a(this.f4185a).setText(ChipTextInputComboView.a(this.f4185a, "00"));
            return;
        L6:
            ChipTextInputComboView.a(this.f4185a).setText(ChipTextInputComboView.a(this.f4185a, r4));
        }
    }

    public ChipTextInputComboView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public ChipTextInputComboView(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        super(r8, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin"), r7);
        LayoutInflater r9 = LayoutInflater.from(r8);
        Chip r10 = (Chip) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r9, ZeusTransformUtils.mapRes(R.layout.material_time_chip, "layout", "material_time_chip"), this, false, "com.obric.memorydata.plugin"), Chip.class, "com.obric.memorydata.plugin");
        this.f4183a = r10;
        r10.setAccessibilityClassName("android.view.View");
        TextInputLayout r11 = (TextInputLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r9, ZeusTransformUtils.mapRes(R.layout.material_time_input, "layout", "material_time_input"), this, false, "com.obric.memorydata.plugin"), TextInputLayout.class, "com.obric.memorydata.plugin");
        this.f4184b = r11;
        EditText r12 = r11.getEditText();
        this.c = r12;
        r12.setVisibility(4);
        a r2 = new a(this, null);
        this.d = r2;
        r12.addTextChangedListener(r2);
        b();
        addView(r10);
        addView(r11);
        this.e = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_label, OaidModel.KEY_ID, "material_label")), TextView.class, "com.obric.memorydata.plugin");
        r12.setSaveEnabled(false);
        r12.setLongClickable(false);
    }

    static /* synthetic */ Chip a(ChipTextInputComboView r0) {
        return r0.f4183a;
    }

    static /* synthetic */ String a(ChipTextInputComboView r2, CharSequence r3) {
        return r2.b((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private String b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return TimeModel.formatText(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), r4);
    }

    private void b() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        LocaleList r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().getLocales();
        this.c.setImeHintLocales(r0);
        return;
    }

    public TextInputLayout a() {
        return this.f4184b;
    }

    public void a(InputFilter r5) {
        InputFilter r6 = (InputFilter) ZeusTransformUtils.wrapperContextForParams(r5, InputFilter.class, "com.obric.memorydata.plugin");
        InputFilter[] r0 = this.c.getFilters();
        InputFilter[] r1 = (InputFilter[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r0.length + 1), InputFilter[].class, "com.obric.memorydata.plugin");
        r1[r0.length] = r6;
        this.c.setFilters(r1);
    }

    public void a(AccessibilityDelegateCompat r1) {
        ViewCompat.setAccessibilityDelegate(this.f4183a, r1);
    }

    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f4183a.setText(b(r4));
        if (TextUtils.isEmpty(this.c.getText()) == true) goto L6;
        this.c.removeTextChangedListener(this.d);
        this.c.setText(null);
        this.c.addTextChangedListener(this.d);
        return;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f4183a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        b();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r4) {
        this.f4183a.setChecked(r4);
        EditText r0 = this.c;
        int r1 = 0;
        if (r4 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        Chip r3 = this.f4183a;
        if (r4 == false) goto L9;
        r1 = 8;
    L9:
        r3.setVisibility(r1);
        if (isChecked() == false) goto L15;
        r.b(this.c);
        if (TextUtils.isEmpty(this.c.getText()) == true) goto L16;
        EditText r5 = this.c;
        r5.setSelection(r5.getText().length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = 4;
        goto L6
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.f4183a.setOnClickListener(r4);
    }

    @Override // android.view.View
    public void setTag(int r1, Object r2) {
        this.f4183a.setTag(r1, r2);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f4183a.toggle();
    }
}
