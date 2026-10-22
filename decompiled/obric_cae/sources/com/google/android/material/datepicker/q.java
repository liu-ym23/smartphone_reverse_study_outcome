package com.google.android.material.datepicker;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.obric.cae.R;
import com.obric.cae.location.zpp.ui.StarZppModelActivity;
import com.obric.cae.location.zpp.ui.StarZppUiActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4716b;

    public /* synthetic */ q(Object r8, int r10) {
        this.f4715a = r10;
        this.f4716b = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = 0;
        int r11 = this.f4715a;
        Object r12 = this.f4716b;
        switch(r11) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L35;
        };
    L5:
        StarZppModelActivity.b((StarZppModelActivity) r12, r8);
        return;
    L7:
        com.google.android.material.textfield.u r13 = (com.google.android.material.textfield.u) r12;
        EditText r14 = r13.f5121f;
        if (r14 == null) goto L37;
        int r15 = r14.getSelectionEnd();
        EditText r16 = r13.f5121f;
        if (r16 != null) goto L13;
    L15:
        if (r10 == 0) goto L17;
        EditText r17 = r13.f5121f;
        PasswordTransformationMethod r18 = null;
    L18:
        r17.setTransformationMethod(r18);
        if (r15 < 0) goto L21;
        r13.f5121f.setSelection(r15);
    L21:
        r13.q();
        return;
    L17:
        r17 = r13.f5121f;
        r18 = PasswordTransformationMethod.getInstance();
        goto L18
    L13:
        if ((r16.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L15;
        r10 = 1;
        goto L15
    L37:
        return;
    L23:
        ((com.google.android.material.textfield.l) r12).u();
        return;
    L25:
        r r19 = (r) r12;
        r19.Z.setEnabled(r19.d().h());
        r19.X.toggle();
        if (r19.M == 1) goto L29;
        r10 = 1;
    L29:
        r19.M = r10;
        Context r20 = r19.X.getContext();
        if (r10 != 1) goto L32;
        int r21 = R.string.mtrl_picker_toggle_to_calendar_input_mode;
    L33:
        r19.X.setContentDescription(r20.getString(r21));
        r19.h();
        return;
    L32:
        r21 = R.string.mtrl_picker_toggle_to_text_input_mode;
        goto L33
    L35:
        StarZppUiActivity.c((StarZppUiActivity) r12, r8);
    }
}
