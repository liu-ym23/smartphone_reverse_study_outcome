package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.browser.jsbridge.base.EndInteractItemResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.TalkRoomIntegrationPlayMethodUtils;
import com.bytedance.android.livesdkapi.depend.model.live.linker.FinishReason;
import com.bytedance.android.livesdkapi.depend.model.live.linker.FinishType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import w20.u8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "endInteractItem")
public final class m extends w20.o0<u8, EndInteractItemResultModel> {
    public m() {
    }

    public final void invoke(Object r6, CallContext r7) {
        u8 r8 = (u8) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        Integer r9 = r8.b();
        int r0 = 0;
        if (r9 == null) goto L5;
        int r10 = r9.intValue();
    L6:
        Integer r1 = r8.a();
        if (r1 == null) goto L9;
        r0 = r1.intValue();
    L9:
        String r11 = r8.c();
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        int r2 = TalkRoomIntegrationPlayMethodUtils.a;
        Intrinsics.checkNotNullParameter(r11, "source");
        if (je0.d.I(Integer.valueOf(r0)) == false) goto L18;
        if (r10 != 0) goto L18;
        IMiddlewareInteractGameService r12 = jc1.k.f(IMiddlewareInteractGameService.class);
        if (r12 == null) goto L48;
        r12.stopRunningPlugin("user switch");
    L48:
        EndInteractItemResultModel r13 = new EndInteractItemResultModel();
        r13.a(EndInteractItemResultModel.Code.Success);
        r13.b("请求成功");
        finishWithResult(r13);
        return;
    L18:
        HashMap<String, Object> r3 = new HashMap();
        if (r10 != 5) goto L21;
        r3.put("reason", 2);
    L45:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r14 = MultiRevenueDataContext.a.d();
        if (r14 == null) goto L48;
        r14.k(r10, r3);
        goto L48
    L21:
        if (r10 != 6) goto L23;
        r3.put("source", r11);
        goto L45
    L23:
        if (r10 != 7) goto L25;
        r3.put("reason", 2);
        goto L45
    L25:
        if (r10 != 11) goto L27;
    L41:
        ALogger.w("TalkRoomIntegrationPlayMethodUtils", "Lynx PlayMode Closed ;; playModeKey == " + r10);
        goto L48
    L27:
        if (r10 == 19) goto L41;
        if (r10 != 29) goto L31;
        String r15 = bi0.a.a;
        Intrinsics.checkNotNullParameter("link_playmode_panel", "<set-?>");
        bi0.a.a = "link_playmode_panel";
        goto L45
    L31:
        if (r10 != 34) goto L33;
        String r16 = bi0.a.a;
        Intrinsics.checkNotNullParameter("link_playmode_panel", "<set-?>");
        bi0.a.a = "link_playmode_panel";
        goto L45
    L33:
        if (r10 != 16) goto L35;
        r3.put("finishType", FinishType.FINISH_WITH_SWITCH_SCENE);
        r3.put("finishReason", FinishReason.CUT_SHORT);
        goto L45
    L35:
        if (r10 == 17) goto L37;
        ALogger.w("TalkRoomIntegrationPlayMethodUtils", "Unknown PlayMode");
        goto L48
    L37:
        r3.put("status", 2);
        goto L45
    L5:
        r10 = 0;
        goto L6
    }
}
