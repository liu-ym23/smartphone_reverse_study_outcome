package com.bytedance.android.live.profit.redpacket.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.RedEnvelopeUpdateResultModel;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w20.c5;
import w20.dd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends c5<dd, RedEnvelopeUpdateResultModel> {
    public Disposable a;
    public final Context b;
    public final Function2<Long, Boolean, Unit> c;
    public final Function1<Long, Unit> d;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.ies.web.jsbridge2.f*/.onDestroy();
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public final Context getContext() {
        return this.b;
    }

    public final void invoke(Object r62, CallContext r63) {
        dd r1 = (dd) r62;
        Intrinsics.checkNotNullParameter(r1, "p0");
        Intrinsics.checkNotNullParameter(r63, "p1");
        String r2 = r1.getType();
        if (r2 != null) goto L6;
    L30:
        finishWithFailure();
        return;
    L6:
        switch(r2.hashCode()) {
            case -1335458389: goto L28;
            case 3267882: goto L21;
            case 12811976: goto L14;
            case 1682120465: goto L9;
            default: goto L30;
        };
    L9:
        if (r2.equals("openRecharge") == false) goto L30;
        com.bytedance.android.live.recharge.model.d r3 = new com.bytedance.android.live.recharge.model.d(true, "red_envelope", null, 0, false, 0, 0, null, null, null, null, "red_envelope", null, 30716);
        Context r4 = ContextUtil.contextToFragmentActivity(this.b);
        if (r4 == null) goto L30;
        ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).showRechargeDialogFragment(r4, r3, null);
        goto L30
    L14:
        if (r2.equals("sendProps") == false) goto L30;
        a r5 = (a) GsonProtectorUtils.fromJson(GsonHelper.get(), r1.b(), a.class);
        if (TextUtils.isEmpty(r5.b()) == true) goto L18;
        String r6 = r5.b();
    L19:
        String r12 = r6;
        this.a = k.n(IGiftService.class).sendProp(new b0(r5.c(), SendGiftSource.RedPacketGiftGuide, null, null, 0, 0, r12, null, null, null, 0, null, null, false, null, 0, true, null, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -65604, 8388607), r5.a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        return;
    L18:
        r6 = "redpackage";
        goto L19
    L21:
        if (r2.equals("join") == false) goto L30;
        f r7 = (f) GsonProtectorUtils.fromJson(GsonHelper.get(), r1.b(), f.class);
        if (r7 == null) goto L25;
        boolean r8 = r7.a();
    L26:
        this.c.invoke(r1.a(), Boolean.valueOf(r8));
        finishWithSuccess();
        return;
    L25:
        r8 = false;
        goto L26
    L28:
        if (r2.equals("delete") == false) goto L30;
        this.d.invoke(r1.a());
        finishWithSuccess();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Context r2, DataCenter r3, Function2<? super Long, ? super Boolean, Unit> r4, Function1<? super Long, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "markJoined");
        Intrinsics.checkNotNullParameter(r5, "markRushed");
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }
}
