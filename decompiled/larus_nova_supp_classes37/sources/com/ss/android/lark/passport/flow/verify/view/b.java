package com.ss.android.lark.passport.flow.verify.view;

import android.view.View;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ VerifyCodeFragment a;

    public b(VerifyCodeFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        VerifyCodeFragment r3 = this.a;
        int r0 = VerifyCodeFragment.m;
        ((VerifyCodeViewModel) r3.W90().getValue()).reduce(VerifyCodeViewModel.a.C0087a.a);
    }
}
