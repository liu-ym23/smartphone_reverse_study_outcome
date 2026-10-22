package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.view.ViewTreeObserver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.LazyMVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ GiftMVIVerticalListView a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        ViewTreeObserver r1 = this.a.t().getViewTreeObserver();     // Catch: Throwable -> L13
        if (r1 != null) goto L5;
    L7:
        GiftMVIVerticalListView r2 = this.a;     // Catch: Throwable -> L13
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r3 = r2.p;     // Catch: Throwable -> L13
        if (r3 != null) goto L10;
        r2.t().post(new f1(r2));     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L10:
        r3.f = false;     // Catch: Throwable -> L13
        goto L11
    L5:
        if (r1.isAlive() == false) goto L7;
        r1.removeOnGlobalLayoutListener(this);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public g1(GiftMVIVerticalListView r1) {
        this.a = r1;
    }
}
