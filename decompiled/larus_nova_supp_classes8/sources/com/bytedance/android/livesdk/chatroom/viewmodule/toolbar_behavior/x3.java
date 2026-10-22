package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.t90;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public x3() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.android.livesdk.log.g r6 = com.bytedance.android.livesdk.log.u.l();
        HashMap r0 = new HashMap();
        DataCenter r1 = this.a;
        LiveMode r2 = null;
        if (r1 == null) goto L5;
        r2 = (LiveMode) r1.get("data_live_mode", null);
    L5:
        int r3 = com.bytedance.android.live.core.utils.h1.a;
        r0.put("live_type", com.bytedance.android.live.core.utils.i1.a(r2));
        Unit r4 = Unit.INSTANCE;
        r6.sendLog("livesdk_teenager_refund_button_click", r0, new Object[]{new am2.x(), Room.class});
        Activity r7 = com.bytedance.android.live.core.utils.a.d();
        String r8 = t90.a.getValue().schema;
        if ((!StringsKt.isBlank(r8)) == true) goto L13;
        if (tb1.c.a == false) goto L11;
        r8 = "sslocal://webcast_webview?type=fullscreen&hide_nav_bar=1&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fies%2Fwallet%2Ffalcon%2Fwallet_h5_douyin%2Fpage%2Fteen_refund%2Fmain%2Findex.html%3Frequest_page%3Dmoretools%26status_bar_color%3Dwhite%26enter_from%3Dlaiyuan";
        goto L13
    L11:
        r8 = "";
    L13:
        if ((!StringsKt.isBlank(r8)) == false) goto L16;
        jc1.k.n(ILiveActionHandler.class).handle(r7, r8);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
    }
}
