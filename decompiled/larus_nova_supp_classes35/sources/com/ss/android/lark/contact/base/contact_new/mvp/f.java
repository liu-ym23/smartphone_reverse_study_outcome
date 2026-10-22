package com.ss.android.lark.contact.base.contact_new.mvp;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.contact.base.common_ui.AgreementDialog$fetchAndShowDialog$1;
import com.ss.android.lark.contact.export.IAgreementCallback;
import com.ss.android.lark.pb.chatters.PullUserAgreementRequest;
import com.ss.android.lark.pb.chatters.PullUserAgreementResponse;
import com.ss.android.lark.pb.chatters.UserAgreementType;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.s0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends s0.c<Boolean> {
    public final /* synthetic */ NewContactView.a j;
    public final /* synthetic */ IGetDataCallback k;
    public final /* synthetic */ NewContactAdapter l;

    public final Object c() {
        final Activity r0 = Contexts.findActivity(this.l.a);
        if (r0 == null) goto L6;
        int r1 = com.ss.android.lark.contact.base.common_ui.c.a;
        final String r2 = this.j.b;
        final IAgreementCallback r3 = new NewContactAdapter$4$1(this);
        Intrinsics.checkNotNullParameter(r0, "activity");
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        int r4 = com.ss.android.lark.contact.base.service.d.a;
        IGetDataCallback<PullUserAgreementResponse> r5 = new AgreementDialog$fetchAndShowDialog$1(r0, r2, r3);
        PullUserAgreementRequest.Builder r6 = new PullUserAgreementRequest.Builder().target_user_id(r2).user_agreement_type(UserAgreementType.PERSONAL_INFO_TRANSFER_TO_ABROAD);
        SdkSender.sendPassThroughRequest(Command.PULL_USER_AGREEMENT, r6, r5, com.ss.android.lark.contact.base.service.f.a);
    L6:
        return Boolean.TRUE;
    }

    public final /* bridge */ /* synthetic */ void d(Object r1) {
        Boolean r2 = (Boolean) r1;
    }

    public f(NewContactAdapter r1, NewContactView.a r2, UIGetDataCallback r3) {
        this.l = r1;
        this.j = r2;
        this.k = r3;
    }
}
