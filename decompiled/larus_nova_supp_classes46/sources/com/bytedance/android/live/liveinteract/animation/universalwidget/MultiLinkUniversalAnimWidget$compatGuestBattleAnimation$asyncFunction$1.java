package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkUniversalAnimWidget$compatGuestBattleAnimation$asyncFunction$1<T> implements ObservableOnSubscribe {
    public final /* synthetic */ MultiLinkUniversalAnimWidget a;
    public final /* synthetic */ IVoiceChatAdminService b;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.g c;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.c d;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.n e;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.m f;
    public final /* synthetic */ String g;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.o h;
    public final /* synthetic */ MultiLinkScriptInfo i;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.animation.e j;

    public MultiLinkUniversalAnimWidget$compatGuestBattleAnimation$asyncFunction$1(MultiLinkUniversalAnimWidget r1, IVoiceChatAdminService r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r3, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r6, String r7, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r8, MultiLinkScriptInfo r9, com.bytedance.android.live.liveinteract.animation.e r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final void subscribe(final ObservableEmitter<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        ALogger.d("MultiLinkEffect.Widget", "3d兼容-来了一个3d礼物动画，但灵活布局动画在播，先等待...");
        this.b.setDynamicAnimatorListener(new AnonymousClass1(this, r3));
    }
}
