package com.google.android.material.datepicker;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4671b;

    public /* synthetic */ e(Object r8, int r10) {
        this.f4670a = r10;
        this.f4671b = r8;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r8, boolean r10) {
        int r11 = this.f4670a;
        Object r12 = this.f4671b;
        switch(r11) {
            case 0: goto L5;
            default: goto L15;
        };
    L5:
        EditText[] r13 = (EditText[]) r12;
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L11;
        if (r13[r15].hasFocus() == true) goto L22;
        r15 = r15 + 1;
        goto L6
    L22:
        return;
    L11:
        Context r16 = r8.getContext();
        Object r17 = androidx.core.content.a.f1674a;
        InputMethodManager r18 = (InputMethodManager) androidx.core.content.a.c.b(r16, InputMethodManager.class);
        if (r18 == null) goto L21;
        r18.hideSoftInputFromWindow(r8.getWindowToken(), 0);
        return;
    L21:
        return;
    L15:
        com.google.android.material.textfield.l r19 = (com.google.android.material.textfield.l) r12;
        r19.f5042l = r10;
        r19.q();
        if (r10 == true) goto L23;
        r19.t(false);
        r19.f5043m = false;
        return;
    }
}
