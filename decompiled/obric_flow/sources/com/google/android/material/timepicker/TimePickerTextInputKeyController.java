package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView hourLayoutComboView;
    private boolean keyListenerRunning;
    private final ChipTextInputComboView minuteLayoutComboView;
    private final TimeModel time;

    public TimePickerTextInputKeyController(ChipTextInputComboView r5, ChipTextInputComboView r10, TimeModel r11) {
        this.keyListenerRunning = false;
        this.hourLayoutComboView = r5;
        this.minuteLayoutComboView = r10;
        this.time = r11;
    }

    private void clearPrefilledText(EditText r5) {
        if (r5.getSelectionStart() == 0) goto L5;
        return;
    L5:
        if (r5.length() != 2) goto L9;
        r5.getText().clear();
        return;
    }

    private void moveSelection(int r5) {
        ChipTextInputComboView r10 = this.minuteLayoutComboView;
        boolean r11 = false;
        if (r5 != 12) goto L5;
        boolean r12 = true;
    L6:
        r10.setChecked(r12);
        ChipTextInputComboView r13 = this.hourLayoutComboView;
        if (r5 != 10) goto L9;
        r11 = true;
    L9:
        r13.setChecked(r11);
        this.time.selection = r5;
        return;
    L5:
        r12 = false;
        goto L6
    }

    private boolean onHourKeyPress(int r5, KeyEvent r10, EditText r11) {
        Editable r12 = r11.getText();
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r5 >= 7) goto L8;
    L17:
        clearPrefilledText(r11);
        return false;
    L8:
        if (r5 > 16) goto L17;
        if (r10.getAction() != 1) goto L17;
        if (r11.getSelectionStart() != 2) goto L17;
        if (r12.length() != 2) goto L17;
        moveSelection(12);
        return true;
    }

    private boolean onMinuteKeyPress(int r5, KeyEvent r10, EditText r11) {
        if (r5 == 67) goto L5;
    L10:
        clearPrefilledText(r11);
        return false;
    L5:
        if (r10.getAction() != 0) goto L10;
        if (TextUtils.isEmpty(r11.getText()) == false) goto L10;
        moveSelection(10);
        return true;
    }

    public void bind() {
        TextInputLayout r5 = this.hourLayoutComboView.getTextInput();
        TextInputLayout r10 = this.minuteLayoutComboView.getTextInput();
        EditText r11 = r5.getEditText();
        EditText r12 = r10.getEditText();
        r11.setImeOptions(268435461);
        r12.setImeOptions(268435462);
        r11.setOnEditorActionListener(this);
        r11.setOnKeyListener(this);
        r12.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView r5, int r10, KeyEvent r11) {
        if (r10 != 5) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        moveSelection(12);
    L8:
        return r12;
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r5, int r10, KeyEvent r11) {
        if (this.keyListenerRunning == false) goto L5;
        return false;
    L5:
        this.keyListenerRunning = true;
        EditText r12 = (EditText) r5;
        if (this.time.selection != 12) goto L8;
        boolean r13 = onMinuteKeyPress(r10, r11, r12);
    L9:
        this.keyListenerRunning = false;
        return r13;
    L8:
        r13 = onHourKeyPress(r10, r11, r12);
        goto L9
    }
}
