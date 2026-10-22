package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.GetGiftMessageBoardPanelParamResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends w20.j1<JsonObject, GetGiftMessageBoardPanelParamResultModel> {
    public final int a;
    public final boolean b;
    public final IRoom c;

    public final void invoke(Object r5, CallContext r6) {
        Intrinsics.checkNotNullParameter((JsonObject) r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        py.t r8 = jc1.k.n(IMiddlewareUserService.class).user().b().getUserAttr();
        String r1 = null;
        if (gd0.v.a(this.a, 32) == false) goto L14;
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L14;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r3.b) == false) goto L13;
        String r4 = "on";
    L16:
        if (this.b == true) goto L29;
        boolean r9 = true;
        if (r8 != null) goto L20;
    L22:
        IRoom r10 = this.c;
        if (r10 == null) goto L29;
        IRoomAuthStatus r11 = r10.getRoomAuthStatus();
        if (r11 == null) goto L29;
        if (r11.getEnableUserCard() == true) goto L29;
    L30:
        GetGiftMessageBoardPanelParamResultModel r12 = new GetGiftMessageBoardPanelParamResultModel();
        r12.a(GetGiftMessageBoardPanelParamResultModel.Code.Success);
        if (r7 == null) goto L33;
        String r13 = r7.getLiveTypeForLog();
    L34:
        r12.c(r13);
        if (r7 == null) goto L37;
        r1 = r7.getFunctionTypeForLog();
    L37:
        r12.b(r1);
        r12.e(r4);
        r12.d(Boolean.valueOf(r9));
        finishWithResult(r12);
        return;
    L33:
        r13 = null;
        goto L34
    L20:
        if (r8.isAdmin() != true) goto L22;
    L29:
        r9 = false;
        goto L30
    L13:
        r4 = "off";
    L14:
        r4 = null;
        goto L16
    }

    public p(int r1, boolean r2, IRoom r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
