package com.ss.android.lark.contact.base.contact_new.mvp;

import com.larksuite.framework.utils.y;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.base.entity.ExternalContactSummary;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class h implements y.a {
    public final /* synthetic */ NewContactPresenter a;

    public /* synthetic */ h(NewContactPresenter r1) {
        this.a = r1;
    }

    public final Object get(Object r5) {
        ChatApplication r6 = (ChatApplication) r5;
        this.a.getClass();
        ExternalContactSummary r0 = r6.getExternalContactSummary();
        if (r0 != null) goto L5;
        return null;
    L5:
        NewContactView.a r1 = new NewContactView.a();
        r1.c = r0.getAvatarKey();
        r1.d = com.ss.android.lark.chat.utils.m.c(r0.getI18nName(), r0.getUserName());
        r1.a = r6.getId();
        r1.b = r0.getUseId();
        r1.e = r0.getTenantName();
        r1.f = r0.getTenantNameStatus();
        r1.g = r6.getExtraMessage();
        r1.h = r6.getStatus();
        r1.i = r6.getCertificationInfo();
        return r1;
    }
}
