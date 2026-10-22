package com.bytedance.android.live.broadcastgame.opengame.service;

import com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.IntroduceCardWidget;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.BottomRightBanner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/miniapp/card/e;", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/openplatform/miniapp/card/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class AudienceMiniGameIntroCardService$showCard$2 extends Lambda implements Function1<com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e, Unit> {
    final /* synthetic */ long $delay;
    final /* synthetic */ long $duration;
    final /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.a $gameIntroCardInfo;
    final /* synthetic */ IntroduceCardWidget $widget;
    final /* synthetic */ AudienceMiniGameIntroCardService this$0;

    public AudienceMiniGameIntroCardService$showCard$2(AudienceMiniGameIntroCardService r1, IntroduceCardWidget r2, long r3, com.bytedance.android.live.broadcastgame.api.openplatform.a r5, long r6) {
        this.this$0 = r1;
        this.$widget = r2;
        this.$delay = r3;
        this.$gameIntroCardInfo = r5;
        this.$duration = r6;
        super(1);
    }

    public final void invoke(com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        if (this.$widget.a == true) goto L10;
        IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> r0 = this.this$0.b;
        if (r0 == null) goto L10;
        ILiveRoomViewHandler r1 = (ILiveRoomViewHandler) r0.d.getValue();
        if (r1 == null) goto L10;
        r1.provideWidget(r0, BottomRightBanner.INSTANCE);
    L10:
        if (this.$widget.b == true) goto L12;
        r4.a("show", new AnonymousClass1(this));
        r4.a("展示toolbar动画", new AnonymousClass2(this));
        r4.a("展示卡片动画", new AnonymousClass3(this));
        r4.a("自动隐藏", new AnonymousClass4(this));
    L12:
        r4.b();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e) r1);
        return Unit.INSTANCE;
    }
}
