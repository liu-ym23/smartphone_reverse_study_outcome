package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements t {
    public final /* synthetic */ GiftRoomCleanCacheService a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.t
    public final void a() {
        ToastUtil.b("正在清理礼物缓存", 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.t
    public final void b() {
        Disposable r0 = this.a.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        GiftRoomCleanCacheService r1 = this.a;
        r1.d = null;
        r1.c();
        ToastUtil.b("礼物缓存清理成功", 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.delete.t
    public final void c() {
        GiftRoomCleanCacheService r0 = this.a;
        r0.getClass();
        com.bytedance.android.livesdk.gift.platform.business.g r2 = com.bytedance.android.livesdk.gift.util.b.c(false);
        Context r3 = null;
        if (r2 == null) goto L5;
        Context r4 = r2.getContext();
    L7:
        if ((r4 instanceof Activity) == false) goto L10;
        r3 = r4;
    L10:
        Activity r5 = (Activity) r3;
        if (r5 == null) goto L25;
        r0.c();
        b r6 = new b(r5);
        r6.setCancelable(false);
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(r6);
    L17:
        Unit r1 = Unit.INSTANCE;
        r0.a = r6;
        Disposable r7 = r0.d;
        if (r7 == null) goto L20;
        r7.dispose();
    L20:
        r0.d = Observable.timer(com.bytedance.android.livesdk.gift.platform.business.i.d().T7(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r0));
        return;
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L16:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        goto L17
    L25:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public f(GiftRoomCleanCacheService r1) {
        this.a = r1;
    }
}
