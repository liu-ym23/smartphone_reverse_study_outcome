package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
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
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip chip;
    private final EditText editText;
    private TextView label;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ChipTextInputComboView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";
        final /* synthetic */ ChipTextInputComboView this$0;

        private TextFormatter(ChipTextInputComboView r5) {
            this.this$0 = r5;
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable r5) {
            if (TextUtils.isEmpty(r5) == false) goto L6;
            ChipTextInputComboView.access$200(this.this$0).setText(ChipTextInputComboView.access$100(this.this$0, DEFAULT_TEXT));
            return;
        L6:
            String r10 = ChipTextInputComboView.access$100(this.this$0, r5);
            Chip r11 = ChipTextInputComboView.access$200(this.this$0);
            if (TextUtils.isEmpty(r10) == false) goto L9;
            r10 = ChipTextInputComboView.access$100(this.this$0, DEFAULT_TEXT);
        L9:
            r11.setText(r10);
        }

        public /* synthetic */ TextFormatter(ChipTextInputComboView r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public ChipTextInputComboView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ String access$100(ChipTextInputComboView r5, CharSequence r10) {
        return r5.formatText(r10);
    }

    public static /* synthetic */ Chip access$200(ChipTextInputComboView r5) {
        return r5.chip;
    }

    private String formatText(CharSequence r5) {
        return TimeModel.formatText(getResources(), r5);
    }

    private void updateHintLocales() {
        LocaleList r5 = getContext().getResources().getConfiguration().getLocales();
        this.editText.setImeHintLocales(r5);
    }

    public void addInputFilter(InputFilter r5) {
        InputFilter[] r10 = this.editText.getFilters();
        InputFilter[] r11 = (InputFilter[]) Arrays.copyOf(r10, r10.length + 1);
        r11[r10.length] = r5;
        this.editText.setFilters(r11);
    }

    @VisibleForTesting
    public CharSequence getChipText() {
        return this.chip.getText();
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        updateHintLocales();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        this.chip.setChecked(r5);
        EditText r10 = this.editText;
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        Chip r12 = this.chip;
        if (r5 == false) goto L9;
        int r13 = 8;
    L10:
        r12.setVisibility(r13);
        if (isChecked() == false) goto L14;
        ViewUtils.requestFocusAndShowKeyboard(this.editText, false);
        return;
    L14:
        return;
    L9:
        r13 = 0;
        goto L10
    L5:
        r11 = 4;
        goto L6
    }

    public void setChipDelegate(AccessibilityDelegateCompat r5) {
        ViewCompat.setAccessibilityDelegate(this.chip, r5);
    }

    public void setCursorVisible(boolean r5) {
        this.editText.setCursorVisible(r5);
    }

    public void setHelperText(CharSequence r5) {
        this.label.setText(r5);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r5) {
        this.chip.setOnClickListener(r5);
    }

    @Override // android.view.View
    public void setTag(int r5, Object r10) {
        this.chip.setTag(r5, r10);
    }

    public void setText(CharSequence r5) {
        String r10 = formatText(r5);
        this.chip.setText(r10);
        if (TextUtils.isEmpty(r10) == true) goto L6;
        this.editText.removeTextChangedListener(this.watcher);
        this.editText.setText(r10);
        this.editText.addTextChangedListener(this.watcher);
        return;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.chip.toggle();
    }

    public ChipTextInputComboView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ChipTextInputComboView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        LayoutInflater r12 = LayoutInflater.from(r5);
        Chip r13 = (Chip) r12.inflate(R.layout.material_time_chip, this, false);
        this.chip = r13;
        r13.setAccessibilityClassName("android.view.View");
        TextInputLayout r14 = (TextInputLayout) r12.inflate(R.layout.material_time_input, this, false);
        this.textInputLayout = r14;
        EditText r15 = r14.getEditText();
        this.editText = r15;
        r15.setVisibility(4);
        TextFormatter r16 = new TextFormatter(this, null);
        this.watcher = r16;
        r15.addTextChangedListener(r16);
        updateHintLocales();
        addView(r13);
        addView(r14);
        this.label = (TextView) findViewById(R.id.material_label);
        r15.setId(ViewCompat.generateViewId());
        ViewCompat.setLabelFor(this.label, r15.getId());
        r15.setSaveEnabled(false);
        r15.setLongClickable(false);
    }
}
