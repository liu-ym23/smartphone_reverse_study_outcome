package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<V> implements Callable {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.c b;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.g c;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.n d;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.m e;
    public final /* synthetic */ String f;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.o g;
    public final /* synthetic */ MultiLinkScriptInfo h;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.e i;

    public d(MultiLinkUniversalAnimWidget r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r3, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r5, String r6, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r7, MultiLinkScriptInfo r8, com.bytedance.android.live.liveinteract.animation.e r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    @Override // java.util.concurrent.Callable
    public final Boolean call() {
        ALogger.d("MultiLinkEffect.Widget", "compatGuestBattleAnimation.fallback.waiting GuestBattle animation timeout.giftInfo:" + this.b);
        this.a.m9(this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i);
        return Boolean.TRUE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
