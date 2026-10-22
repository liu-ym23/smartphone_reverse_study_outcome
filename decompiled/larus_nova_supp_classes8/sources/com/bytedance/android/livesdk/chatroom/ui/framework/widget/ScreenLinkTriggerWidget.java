package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.utils.f4;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ScreenLinkTriggerWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/s;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenLinkTriggerWidget extends MiddlewareRoomWidget implements s {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a b;
    public final f4 c;
    public y0 d;

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.s
    public final tlc.d gi() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L8;
        r1.removeMessageListener(this.c);
    L8:
        return this.c.a;
    }

    public final void wq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L11;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r1 = this.b;
        if (r1 == null) goto L12;
        j70.f r2 = com.bytedance.android.livesdk.chatroom.ui.framework.f.a;
        r1.Og(com.bytedance.android.livesdk.chatroom.ui.framework.f.L);
        return;
    L12:
        return;
    }

    public ScreenLinkTriggerWidget() {
        this.c = new f4();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.c(getComponentContext());
        ho1.a.p(getComponentContext(), s.class, this);
        LivePluginSPIManager.e.getClass();
        if (LivePluginSPIManager.b() == true) goto L5;
    L17:
        wq();
        return;
    L5:
        if (LivePluginSPIManager.c() == true) goto L17;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L9;
    L11:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L16;
        vlc.d r2 = (vlc.d) r1.get("data_message_manager", null);
        if (r2 == null) goto L16;
        r2.addMessageListener(MessageType.LINKER.getIntType(), this.c);
    L16:
        y0 r3 = new y0(this);
        this.d = r3;
        Unit r4 = Unit.INSTANCE;
        LivePluginSPIManager.d(r3);
        return;
    L9:
        if (r0.o5() != true) goto L11;
        LivePluginSPIManager.a().addOnSuccess(new x0(this)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare("AudienceLandscapeInteractionFragment");
    }

    public final void onDestroy() {
        super.onDestroy();
        y0 r0 = this.d;
        if (r0 == null) goto L5;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.e(r0);
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ho1.a.q(getComponentContext(), s.class);
        this.a = null;
        this.b = null;
    }
}
