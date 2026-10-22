package com.bytedance.android.anniex.container.ui;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.salamander.anniex.AnnieXCommonUIViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements DialogInterface.OnKeyListener {
    public final /* synthetic */ AnnieXSLDialog a;

    public g(AnnieXSLDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r10, int r11, KeyEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r12, "keyEvent");
        if (r11 == 4) goto L5;
        return false;
    L5:
        if (r12.getAction() != 1) goto L13;
        AnnieXCommonUIViewModel r13 = this.a.d;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r13 = null;
    L10:
        return r13.j();
    L13:
        return false;
    }
}
