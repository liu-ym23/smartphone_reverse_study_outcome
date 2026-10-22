package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.TryOpenInvitePanelResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.if;
import w20.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t0 extends y6<if, TryOpenInvitePanelResultModel> {
    public t0() {
    }

    public final void invoke(Object r8, CallContext r9) {
        if r10 = (if) r8;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        Room r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r11 == null) goto L6;
        String r12 = r11.getOwnerUserIdString();
        if (r12 == null) goto L6;
    L7:
        boolean r13 = Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n(), r12);
        IInteractService r0 = (IInteractService) jc1.k.n(IInteractService.class);
        int r1 = r0.getCurrentScene();
        boolean r3 = true;
        if (r1 != 5) goto L10;
    L16:
        boolean r2 = true;
    L17:
        boolean r4 = hd0.c.f().h();
        TryOpenInvitePanelResultModel r5 = new TryOpenInvitePanelResultModel();
        r5.c(Integer.valueOf(r0.getCurrentScene()));
        if (r2 == true) goto L20;
        r5.b(20001);
        r5.a(TryOpenInvitePanelResultModel.Code.Failed);
    L31:
        finishWithResult(r5);
        return;
    L20:
        if (r13 == true) goto L30;
        if (r4 == true) goto L30;
        if (jc0.a.a() == true) goto L25;
    L27:
        r3 = false;
    L28:
        if (r3 == true) goto L30;
        r5.b(20002);
        r5.a(TryOpenInvitePanelResultModel.Code.Failed);
        goto L31
    L25:
        if (je0.d.Y() == false) goto L27;
    L30:
        r5.b(0);
        r5.a(TryOpenInvitePanelResultModel.Code.Success);
        r0.openInvitePanel(r10.a());
        goto L31
    L10:
        if (r1 == 12) goto L16;
        if (r1 == 8) goto L16;
        if (r1 == 9) goto L16;
        r2 = false;
    L6:
        r12 = "";
        goto L7
    }
}
