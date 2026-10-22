package com.ss.android.lark.forwardv3.utils;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.forwardv3.ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ KeyboardFunctionEditText c;
    public final /* synthetic */ qib.a d;

    public g(boolean r1, FragmentActivity r2, KeyboardFunctionEditText r3, ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (this.a == false) goto L5;
        KeyboardUtils.hideKeyboard(this.b, this.c);
    L5:
        this.d.a();
    }
}
