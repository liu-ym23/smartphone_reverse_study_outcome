package com.bytedance.android.live.broadcastgame.xplay.container;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.event.i;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        if (((Boolean) r5).booleanValue() == false) goto L5;
        this.a.k();
        return;
    L5:
        b r6 = this.a;
        r6.getClass();
        XplayLog.c("InteractPlayContainerService", "move to bottom");
        if (((XplayScene) r6.i.getCurrentScene().getValue()) != XplayScene.Video) goto L9;
        xs2.b.a().post(new i(false));
    L9:
        if (r6.b != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L11:
        r6.h.a(false);
        if (((XplayScene) r6.i.getCurrentScene().getValue()) != XplayScene.TalkRoom) goto L21;
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 == null) goto L21;
        if (r0.isEnableDanmuGameClearScreen() == true) goto L21;
        e r1 = r6.b;
        if (r1 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L20:
        r1.setBlockTouchEvents(false);
    L26:
        if (r6.e == false) goto L30;
        r6.e = false;
        r6.f.onNext(Boolean.FALSE);
        return;
    L30:
        return;
    L21:
        e r2 = r6.b;
        if (r2 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L24:
        r2.setBlockTouchEvents(true);
        goto L26
    }
}
