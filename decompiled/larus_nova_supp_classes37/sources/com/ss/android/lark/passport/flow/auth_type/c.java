package com.ss.android.lark.passport.flow.auth_type;

import android.view.View;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ AuthTypeActivity a;
    public final /* synthetic */ ButtonInfo b;

    public c(AuthTypeActivity r1, ButtonInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        AuthTypeActivity r4 = this.a;
        int r0 = AuthTypeActivity.f;
        r4.z1().reduce(new AuthTypeViewModel.a.C0084a(this.b.next));
    }
}
