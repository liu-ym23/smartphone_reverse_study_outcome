package com.bytedance.android.live.recharge.widget;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.service.IHostApi;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements IHostApi {
    public final RechargeDialogContext a;
    public final Context b;

    public final void fetchRenderData() {
    }

    public final void clickConfirmBtn() {
        this.a.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
        this.a.getClickRechargeBtn().onNext(Unit.INSTANCE);
    }

    public Activity getContext() {
        Context r0 = this.b;
        if (r0 == null) goto L7;
        return (Activity) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final int getPageHeight() {
        return (int) s1.G(this.a.getNoPasswordDialogHeight());
    }

    public final boolean changePayTypeAnimUp() {
        return IHostApi.DefaultImpls.changePayTypeAnimUp(this);
    }

    public final boolean changePayTypeNeedMask() {
        return IHostApi.DefaultImpls.changePayTypeNeedMask(this);
    }

    public d(RechargeDialogContext r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }
}
