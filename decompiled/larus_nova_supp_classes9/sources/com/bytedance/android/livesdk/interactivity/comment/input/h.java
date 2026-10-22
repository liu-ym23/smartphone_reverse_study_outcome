package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.View;
import android.widget.CheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        CheckBox r4 = this.a.c;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L5:
        CheckBox r1 = this.a.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L8:
        r4.setChecked(!r1.isChecked());
    }
}
