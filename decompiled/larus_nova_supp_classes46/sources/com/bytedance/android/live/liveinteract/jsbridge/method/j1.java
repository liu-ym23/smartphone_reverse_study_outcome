package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.StartInteractItemResultModel;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.videotalk.utils.TalkRoomIntegrationPlayMethodUtils;
import com.bytedance.android.livesdk.chatroom.model.q1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.bf;
import w20.r6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j1 extends r6<bf, StartInteractItemResultModel> {
    public final DataCenter a;

    public j1(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    public final void invoke(Object r10, CallContext r11) {
        bf r12 = (bf) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        int r2 = 0;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMultiLinkScene() == true) goto L5;
        f2.c("主播已经关闭聊天室", 0);
        return;
    L5:
        String r1 = r12.d();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r7 = r1;
        Integer r3 = r12.c();
        if (r3 == null) goto L11;
        long r4 = r3.intValue();
    L12:
        bf.a r5 = r12.b();
        if (r5 == null) goto L15;
        String r6 = r5.a();
    L16:
        bf.a r8 = r12.b();
        if (r8 == null) goto L21;
        Integer r9 = r8.b();
        if (r9 == null) goto L21;
        int r13 = r9.intValue();
    L22:
        bf.a r14 = r12.b();
        if (r14 == null) goto L27;
        Boolean r15 = r14.c();
        if (r15 == null) goto L27;
        boolean r16 = r15.booleanValue();
    L28:
        Integer r17 = r12.getType();
        if (r17 == null) goto L31;
        int r18 = r17.intValue();
    L32:
        Integer r19 = r12.a();
        if (r19 == null) goto L35;
        r2 = r19.intValue();
    L35:
        q1 r110 = vh7.f.c(q1.class);
        r110.setInteractType(r13);
        r110.setAppId(r6);
        r110.setInteractiveScreenCast(r16);
        com.bytedance.android.livesdk.chatroom.model.k1 r20 = vh7.f.c(com.bytedance.android.livesdk.chatroom.model.k1.class);
        r20.setType(r18);
        r20.setInteractInfo(r110);
        r20.setGameDataType(r2);
        r20.setPlayModeId(r4);
        int r111 = TalkRoomIntegrationPlayMethodUtils.a;
        Context r21 = r11.getContext();
        DataCenter r22 = this.a;
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        Intrinsics.checkNotNullParameter(r7, "source");
        IInteractService r112 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r112 == null) goto L38;
        r112.updateSwitchSceneSource(r7);
    L38:
        TalkRoomIntegrationPlayMethodUtils.b(r21, r22, r18, r7, r7, r20);
        StartInteractItemResultModel r113 = new StartInteractItemResultModel();
        r113.a(StartInteractItemResultModel.Code.Success);
        r113.b("请求成功");
        finishWithResult(r113);
        return;
    L31:
        r18 = 0;
    L27:
        r16 = false;
    L21:
        r13 = 0;
        goto L22
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = 0;
        goto L12
    }
}
