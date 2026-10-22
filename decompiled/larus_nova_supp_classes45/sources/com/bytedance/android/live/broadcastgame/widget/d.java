package com.bytedance.android.live.broadcastgame.widget;

import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements com.bytedance.android.live.broadcastgame.effectgame.base.c.a {
    public final /* synthetic */ LiveGameControlWidget a;
    public final /* synthetic */ u b;
    public final /* synthetic */ r c;
    public final /* synthetic */ com.bytedance.android.live.broadcastgame.effectgame.base.a d;

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.c.a
    public final void a(String r5, Sticker r6) {
        Intrinsics.checkNotNullParameter(r5, "effectId");
        Intrinsics.checkNotNullParameter(r6, "sticker");
        LiveGameControlWidget r7 = this.a;
        u r0 = this.b;
        r r1 = this.c;
        com.bytedance.android.live.broadcastgame.effectgame.base.a r2 = this.d;
        int r3 = LiveGameControlWidget.f;
        r7.getClass();
        com.bytedance.android.live.broadcastgame.effectgame.base.c.a(r6, r1);
        com.bytedance.android.live.broadcastgame.effectgame.base.c.b(r6, 1, new LiveGameControlWidget$processEffectGameSticker$1(r7, r2, r0));
    }

    @Override // com.bytedance.android.live.broadcastgame.effectgame.base.c.a
    public final void b(String r2, ExceptionResult r3) {
        Intrinsics.checkNotNullParameter(r2, "effectId");
        Intrinsics.checkNotNullParameter(r3, "e");
        IESUIUtils.displayToast(s1.getContext(), 2131919146);
    }

    public d(LiveGameControlWidget r1, u r2, r r3, LiveGameControlWidget$fetchCallBack$1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
