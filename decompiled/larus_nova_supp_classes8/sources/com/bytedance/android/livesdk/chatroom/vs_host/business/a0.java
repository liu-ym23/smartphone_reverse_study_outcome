package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.livesdk.castscreen.views.bytecast.GameCastScreenEntryWidgetForByteCast;
import com.bytedance.android.livesdk.castscreen.views.bytecast.MultiDeviceEntryWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.FullVideoButtonWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.business.VSInjectWidgetType;
import com.bytedance.android.livesdk.chatroom.widget.ShadowPlayerWidget;
import com.bytedance.android.livesdk.commonpop.CommonPopupMessageWidget;
import com.bytedance.android.livesdk.lottie.CommonLottieAnimationWidget;
import com.bytedance.android.livesdk.widget.CountdownTaskWidget;
import com.bytedance.android.livesdk.widgetdescriptor.matchroom.publish.LivePortraitPublishLoadingWidget;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements yr1.t, com.bytedance.android.scope.o {
    public a0() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.t
    public final void c(DataCenter r3) {
        if (r3 == null) goto L5;
        r3.put("cmd_widget_loaded", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    }

    @Override // yr1.t
    public final Class<? extends Widget> getWidgetClass(@VSInjectWidgetType int r2) {
        if (r2 != 3) goto L5;
        return CommonLottieAnimationWidget.class;
    L5:
        if (r2 != 4) goto L7;
        return CommonPopupMessageWidget.class;
    L7:
        if (r2 != 5) goto L9;
        return CountdownTaskWidget.class;
    L9:
        if (r2 != 6) goto L11;
        return LivePortraitPublishLoadingWidget.class;
    L11:
        if (r2 == 7) goto L22;
        switch(r2) {
            case 100: goto L19;
            case 101: goto L18;
            case 102: goto L17;
            case 103: goto L16;
            default: goto L14;
        };
    L16:
        return MultiDeviceEntryWidget.class;
    L17:
        return ShadowPlayerWidget.class;
    L18:
        return GameCastScreenEntryWidgetForByteCast.class;
    L19:
        return FullVideoButtonWidget.class;
    L14:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L21;
    L25:
        return null;
    L21:
        throw new RuntimeException("ReplayWidgetService getWidgetClass type error");
    L22:
        qh1.a r3 = pm1.f.n();
        if (r3 == null) goto L25;
        return r3.getReplayElementClass();
    }

    @Override // yr1.t
    public final c0.b a(Context r3, Episode r4) {
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.createReplayVisibilityBehavior(r3, r4);
    }
}
