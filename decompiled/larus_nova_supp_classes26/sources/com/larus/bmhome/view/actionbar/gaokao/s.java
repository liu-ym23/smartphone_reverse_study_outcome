package com.larus.bmhome.view.actionbar.gaokao;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.larus.bmhome.databinding.LarusDialogGaokaoPreferenceBinding;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s implements TextWatcher {
    public final /* synthetic */ GaokaoPreferenceDialog a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public s(GaokaoPreferenceDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r7) {
        if (r7 == null) goto L5;
        Integer r1 = Integer.valueOf(r7.length());
    L6:
        boolean r3 = false;
        if (r1 != null) goto L9;
    L24:
        GaokaoPreferenceDialog r2 = this.a;
        int r4 = GaokaoPreferenceDialog.s;
        r2.ea0();
        if (r7 == null) goto L27;
        Integer r5 = Integer.valueOf(r7.length());
    L28:
        if (r5 != null) goto L30;
    L49:
        this.a.da0();
        return;
    L30:
        if (r7.length() >= 3) goto L36;
        if (r7.length() <= 0) goto L34;
        r3 = true;
    L34:
        if (r3 == false) goto L36;
    L39:
        Job r8 = this.a.n;
        if (r8 == null) goto L42;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L42:
        GaokaoPreferenceDialog r9 = this.a;
        r9.n = null;
        if (r9.Y90() == true) goto L55;
        LarusDialogGaokaoPreferenceBinding r10 = this.a.d;
        if (r10 == null) goto L56;
        EditText r11 = r10.q;
        if (r11 == null) goto L57;
        r11.setText(null);
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L36:
        if (r7.length() != 3) goto L49;
        if (GaokaoPreferenceDialog.aa0(this.a, r7.toString()) == true) goto L49;
    L27:
        r5 = null;
        goto L28
    L9:
        if (r7.length() <= 1) goto L24;
        if (StringsKt.startsWith$default(r7.toString(), TriggerSendLoading.NO_LOADING, false, 2, null) == false) goto L24;
        GaokaoPreferenceDialog r0 = this.a;
        String r12 = r7.toString();
        int r6 = GaokaoPreferenceDialog.s;
        r0.getClass();
        String r13 = GaokaoPreferenceDialog.ca0(r12);
        if (r13 == null) goto L51;
        LarusDialogGaokaoPreferenceBinding r14 = this.a.d;
        if (r14 == null) goto L19;
        EditText r15 = r14.r;
        if (r15 == null) goto L19;
        r15.setText(r13);
    L19:
        LarusDialogGaokaoPreferenceBinding r16 = this.a.d;
        if (r16 == null) goto L52;
        EditText r17 = r16.r;
        if (r17 == null) goto L53;
        r17.setSelection(r13.length());
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
