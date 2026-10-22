package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import androidx.appcompat.widget.AppCompatRadioButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ PkMuteCheckDialogFragment a;

    public h(PkMuteCheckDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        AppCompatRadioButton r6 = this.a.h;
        boolean r0 = false;
        if (r6 == null) goto L12;
        if (r6 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        r6.setChecked(r2);
        goto L12
    L6:
        if (r6.isChecked() != true) goto L9;
        r2 = false;
    L12:
        if (Intrinsics.areEqual(this.a.k, Boolean.TRUE) == false) goto L19;
        AppCompatRadioButton r7 = this.a.h;
        if (r7 != null) goto L16;
    L17:
        r0 = true;
    L18:
        l51.a.T.setValue(null, l51.a.a[48], Boolean.valueOf(r0));
        return;
    L16:
        if (r7.isChecked() == true) goto L18;
    L19:
        AppCompatRadioButton r8 = this.a.h;
        if (r8 != null) goto L22;
    L23:
        r0 = true;
    L24:
        l51.a.S.setValue(null, l51.a.a[47], Boolean.valueOf(r0));
        return;
    L22:
        if (r8.isChecked() == true) goto L24;
        goto L23
    }
}
