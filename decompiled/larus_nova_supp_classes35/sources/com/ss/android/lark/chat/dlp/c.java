package com.ss.android.lark.chat.dlp;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements e {
    public c() {
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.RECEIVE_AUTHORIZATION;
    }

    public final boolean a(MessageActionType r2, yya.a r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        v5b.c r4 = r3.m();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<*>");
        ValidateIMFileResult r5 = ((y6b.a) r4).N();
        if (r5 == null) goto L5;
        IMFileResult r6 = r5.getResultType();
    L7:
        return MessagePermissionUtil.g(MessagePermissionUtil.h(r6));
    L5:
        r6 = null;
        goto L7
    }

    public final boolean b(MessageActionType r1, yya.a r2) {
        e.a.c(r1, r2);
        return false;
    }

    public final boolean c(MessageActionType r1, yya.a r2, boolean r3) {
        e.a.b(r1, r2);
        return false;
    }
}
