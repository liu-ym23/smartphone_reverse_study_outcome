package com.bytedance.android.live.recharge.panel;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.subjects.SingleSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargeAgreementUtilsKt {
    public static final Single<Boolean> a(final com.bytedance.android.live.recharge.panel.context.c r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$ensureRechargeAgreementAccepted");
        Intrinsics.checkNotNullParameter(r3, "context");
        Boolean r0 = r2.b().isRechargeAgreementAccepted();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L5;
        final SingleSubject r4 = SingleSubject.create();
        c9 r5 = com.bytedance.android.live.recharge.util.h.d(r3, new RechargeAgreementUtilsKt$ensureRechargeAgreementAccepted$1(r2, r4), new RechargeAgreementUtilsKt$ensureRechargeAgreementAccepted$2(r4));
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r5);
    L11:
        return r4;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L11
    L5:
        return Single.just(r1);
    }
}
