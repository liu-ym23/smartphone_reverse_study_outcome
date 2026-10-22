package com.bytedance.android.livesdk.dislike.action;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.chatroom.utils.o4;
import com.bytedance.android.livesdk.config.b11;
import com.bytedance.android.livesdk.config.v9;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AddWidgetAction extends OptionAction {
    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.q.c;
    }

    public AddWidgetAction(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        v9 r0 = v9.a;
        if (((b11) r0.getValue()).b() == true) goto L5;
        com.bytedance.android.livesdk.castscreen.utils.c.a("livesdk_live_widget_click", this.b, AddWidgetAction$doClick$1.INSTANCE);
    L5:
        Room r1 = this.b;
        if (r1 == null) goto L27;
        Context r11 = r10.getContext();
        if (r11 != null) goto L11;
        return;
    L11:
        if (NetworkUtils.f(r11) == true) goto L15;
        f2.b(2131915628, 0);
        return;
    L15:
        if (((b11) r0.getValue()).b() == false) goto L21;
        IHostBusiness r3 = jc1.k.n(IHostBusiness.class);
        String r12 = r1.getOwnerUserIdString();
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        r3.addPanelThreeDesktop("live_desktop_business", "panel_desktop_item", "passAll", "1", r12);
        o4.c("livesdk_desktop_app_guide_click", "long_press");
        return;
    L21:
        boolean r13 = jc1.k.n(IHostBusiness.class).hasLiveAppWidgetAdded(r11);
        Activity r2 = com.bytedance.android.live.core.utils.a.d();
        if (r2 == null) goto L28;
        if (r13 == true) goto L25;
        jc1.k.n(IHostBusiness.class).tryAddLiveAppWidget(r2, false, "long_press");
        return;
    L25:
        f2.b(2131914623, 0);
        return;
    L28:
        return;
    }
}
