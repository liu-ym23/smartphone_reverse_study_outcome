package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes2.dex */
class c implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ChipTextInputComboView f4076c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ChipTextInputComboView f4077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TimeModel f4078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4079i;

    c(ChipTextInputComboView r10, ChipTextInputComboView r11, TimeModel r12) {
        this.f4079i = false;
        this.f4076c = r10;
        this.f4077g = r11;
        this.f4078h = r12;
    }

    private void b(int r10) {
        ChipTextInputComboView r11 = this.f4077g;
        boolean r12 = true;
        if (r10 != 12) goto L5;
        boolean r13 = true;
    L6:
        r11.setChecked(r13);
        ChipTextInputComboView r14 = this.f4076c;
        if (r10 == 10) goto L10;
        r12 = false;
    L10:
        r14.setChecked(r12);
        this.f4078h.selection = r10;
        return;
    L5:
        r13 = false;
        goto L6
    }

    private boolean c(int r10, KeyEvent r11, EditText r12) {
        Editable r13 = r12.getText();
        if (r13 != null) goto L6;
        return false;
    L6:
        if (r10 >= 7) goto L8;
    L16:
        boolean r14 = false;
    L17:
        if (r14 == false) goto L20;
        b(12);
        return true;
    L20:
        return false;
    L8:
        if (r10 > 16) goto L16;
        if (r11.getAction() != 1) goto L16;
        if (r12.getSelectionStart() != 2) goto L16;
        if (r13.length() != 2) goto L16;
        r14 = true;
        goto L17
    }

    private boolean d(int r10, KeyEvent r11, EditText r12) {
        if (r10 == 67) goto L5;
    L9:
        boolean r13 = false;
    L10:
        if (r13 == false) goto L13;
        b(10);
        return true;
    L13:
        return false;
    L5:
        if (r11.getAction() != 0) goto L9;
        if (TextUtils.isEmpty(r12.getText()) == false) goto L9;
        r13 = true;
        goto L10
    }

    public void a() {
        TextInputLayout r10 = this.f4076c.e();
        TextInputLayout r11 = this.f4077g.e();
        EditText r12 = r10.getEditText();
        EditText r13 = r11.getEditText();
        r12.setImeOptions(268435461);
        r13.setImeOptions(268435462);
        r12.setOnEditorActionListener(this);
        r12.setOnKeyListener(this);
        r13.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView r10, int r11, KeyEvent r12) {
        if (r11 != 5) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        b(12);
    L8:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r10, int r11, KeyEvent r12) {
        if (this.f4079i == false) goto L5;
        return false;
    L5:
        this.f4079i = true;
        EditText r13 = (EditText) r10;
        if (this.f4078h.selection != 12) goto L8;
        boolean r14 = d(r11, r12, r13);
    L9:
        this.f4079i = false;
        return r14;
    L8:
        r14 = c(r11, r12, r13);
        goto L9
    }
}
