package com.ss.android.lark.passport.flow.auth_type;

import android.view.View;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.router.FlowStep;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AuthTypeActivity a;
    public final /* synthetic */ ButtonInfo b;

    public a(AuthTypeActivity r1, ButtonInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        AuthTypeActivity r6 = this.a;
        int r0 = AuthTypeActivity.f;
        AuthTypeViewModel r7 = r6.z1();
        ButtonInfo r1 = this.b;
        FlowStep r2 = r1.next;
        ButtonType.a r3 = ButtonType.Companion;
        int r4 = r1.actionType;
        r3.getClass();
        r7.reduce(new AuthTypeViewModel.a.b(r2, ButtonType.a.a(r4)));
    }
}
