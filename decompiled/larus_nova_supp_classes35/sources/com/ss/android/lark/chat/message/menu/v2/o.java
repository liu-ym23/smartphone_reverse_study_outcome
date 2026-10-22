package com.ss.android.lark.chat.message.menu.v2;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ MessageActionPanel a;

    public o(MessageActionPanel r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.i(false);
        MessageActionPanel r5 = this.a;
        View r0 = r5.D;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
        r0 = null;
    L5:
        View r2 = this.a.C;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("firstLevelActionsContainer");
    L9:
        r5.o(r0, r1);
        return;
    L8:
        r1 = r2;
        goto L9
    }
}
