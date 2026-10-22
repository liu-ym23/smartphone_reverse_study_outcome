package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IModFavoriteList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements IModFavoriteList {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Sticker c;
    public final /* synthetic */ z d;

    public final void onFail(ExceptionResult r7) {
        String r0 = this.a;
        boolean r1 = this.b;
        int r2 = r7.getErrorCode();
        String r8 = r7.getMsg();
        PthreadHandlerThreadV2 r3 = LiveEffectMonitor.a;
        Intrinsics.checkNotNullParameter(r0, "panel");
        NewBroadcastMonitor.a r4 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_CHANGE_EFFECT_FAVORITE, null, null, 14);
        r4.l(r2);
        r4.c(r0);
        if (r1 == false) goto L5;
        String r5 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L6:
        r4.d(r5);
        r4.i("err_msg", r8);
        r4.a().report();
        this.d.s(this.a, this.c, !this.b);
        this.d.i = Boolean.FALSE;
        return;
    L5:
        r5 = "0";
        goto L6
    }

    public final void onSuccess(Object r5) {
        List r6 = (List) r5;
        z r7 = this.d;
        r7.i = Boolean.FALSE;
        String r8 = this.a;
        boolean r0 = this.b;
        PthreadHandlerThreadV2 r1 = LiveEffectMonitor.a;
        Intrinsics.checkNotNullParameter(r8, "panel");
        NewBroadcastMonitor.a r2 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_CHANGE_EFFECT_FAVORITE, null, null, 14);
        r2.l(0);
        r2.c(r8);
        if (r0 == false) goto L5;
        String r9 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L6:
        r2.d(r9);
        r2.a().report();
        return;
    L5:
        r9 = "0";
        goto L6
    }

    public y(z r1, String r2, boolean r3, Sticker r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
