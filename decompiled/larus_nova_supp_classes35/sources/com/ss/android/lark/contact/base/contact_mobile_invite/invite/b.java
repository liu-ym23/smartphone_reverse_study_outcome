package com.ss.android.lark.contact.base.contact_mobile_invite.invite;

import android.content.Context;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ViewUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements ApiUtils.a {
    public final /* synthetic */ a a;
    public final /* synthetic */ Context b;

    public b(a r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void consume(Object r4) {
        z8b.a r5 = (z8b.a) r4;
        if (r5 != null) goto L5;
        ViewUtils.showCommonErrorTip();
        return;
    L5:
        ErrorResult r0 = r5.c;
        if (r0 == null) goto L8;
        ViewUtils.showToastShort(r0.getDisplayMsg());
        return;
    L8:
        String r1 = a.k;
        InvitationInfo r2 = r5.b;
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L11;
        String r6 = r2.invMsg;
    L12:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        a.k = r6;
        InvitationInfo r7 = r5.b;
        if (r7 == null) goto L15;
        r3 = r7.uniqueId;
    L15:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        a.l = r3;
        a.c(this.a, this.b);
        return;
    L11:
        r6 = BuildConfig.FLAVOR;
        goto L12
    }
}
