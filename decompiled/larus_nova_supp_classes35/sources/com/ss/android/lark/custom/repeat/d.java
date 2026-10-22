package com.ss.android.lark.custom.repeat;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends oab.b {
    public final /* synthetic */ ChooseCustomRepeatFragment b;

    public d(ChooseCustomRepeatFragment r1) {
        this.b = r1;
    }

    @Override // oab.b
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        ChooseCustomRepeatFragment r3 = this.b;
        ChooseCustomRepeatFragment.b r0 = r3.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customRepeatAction");
        r0 = null;
    L5:
        r0.onBackPressed();
        r3.r.clearRule();
        r3.T90().c();
    }
}
