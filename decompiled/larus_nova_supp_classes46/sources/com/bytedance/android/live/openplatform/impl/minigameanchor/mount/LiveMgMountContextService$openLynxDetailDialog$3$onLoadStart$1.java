package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.utils.MiniGameLiveJsBridgeUtils;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "jsEvent", "Lcom/bytedance/android/livesdkapi/hybridapi/SubscriberJsEvent;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveMgMountContextService$openLynxDetailDialog$3$onLoadStart$1 extends Lambda implements Function1<SubscriberJsEvent, Unit> {
    final /* synthetic */ LiveMgMountContextService$openLynxDetailDialog$3 this$0;

    public LiveMgMountContextService$openLynxDetailDialog$3$onLoadStart$1(LiveMgMountContextService$openLynxDetailDialog$3 r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(SubscriberJsEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "jsEvent");
        int r0 = qo0.a.a;
        qo0.a.c("LiveMgMountContextService", "subscribe jsEvent: " + r6.getEventName() + ", params: " + String.valueOf(r6.getParams()));
        if (TextUtils.equals("live_launch_mg", r6.getEventName()) == true) goto L5;
        return;
    L5:
        final HashMap r7 = MiniGameLiveJsBridgeUtils.b(r6);
        String r1 = (String) r7.get("type");
        if (r1 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r1, "open") == false) goto L18;
        c0 r2 = this.this$0.a.f;
        if (r2 == null) goto L22;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r3 = AnchorMiniGameDataContext.a.a();
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.n<Pair<String, String>> r4 = r3.getSourceFromDetailPage();
        if (r4 == null) goto L16;
        r4.setValue(new Pair(r7.get("page_source"), r7.get("oe_source")));
    L16:
        LiveMgMountContextService$openLynxDetailDialog$3 r8 = this.this$0;
        r8.a.g(r8.c, r2);
        return;
    L22:
        return;
    L18:
        if (Intrinsics.areEqual(r1, "exit") == false) goto L24;
        Activity r5 = jc1.k.n(IHostApp.class).getTopActivity();
        int r9 = v.a;
        LiveMgMountContextService r10 = this.this$0.a;
        int r11 = LiveMgMountContextService.h;
        v.c(r5, r10.getOpenPlatformContext(), new LiveMgMountContextService$openLynxDetailDialog$3$onLoadStart$1$$special$$inlined$let$lambda$1(this, r7));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((SubscriberJsEvent) r1);
        return Unit.INSTANCE;
    }
}
