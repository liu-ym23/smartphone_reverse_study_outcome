package com.larus.common_ui.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_res.common_ui.databinding.LarusDialogInputBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c1 implements TextWatcher {
    public final /* synthetic */ InputDialog a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public c1(InputDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r5, int r6, int r7, int r8) {
        if (r5 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        LarusDialogInputBinding r10 = null;
        if (r9 == false) goto L25;
        LarusDialogInputBinding r11 = this.a.d;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L14:
        TextView r12 = r11.c;
        LarusDialogInputBinding r13 = this.a.d;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L17:
        Context r14 = r13.d.getContext();
        LarusDialogInputBinding r1 = this.a.d;
        if (r1 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L20:
        r12.setTextColor(ContextCompat.getColor(r14, v19.c.b(2130972081, r1.d.getContext(), 2131103143)));
        LarusDialogInputBinding r15 = this.a.d;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r10.c.setEnabled(false);
        return;
    L23:
        r10 = r15;
        goto L24
    L25:
        LarusDialogInputBinding r16 = this.a.d;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L28:
        TextView r17 = r16.c;
        LarusDialogInputBinding r18 = this.a.d;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L31:
        Context r20 = r18.d.getContext();
        LarusDialogInputBinding r2 = this.a.d;
        if (r2 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L34:
        r17.setTextColor(ContextCompat.getColor(r20, v19.c.b(2130972123, r2.d.getContext(), 2131103203)));
        LarusDialogInputBinding r21 = this.a.d;
        if (r21 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L38:
        r10.c.setEnabled(true);
        return;
    L37:
        r10 = r21;
        goto L38
    L5:
        if (r5.length() == 0) goto L8;
        r9 = false;
        goto L9
    }
}
