package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.TryApplyLinkResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.hf;
import w20.x6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "tryApplyLink")
public final class a extends x6<hf, TryApplyLinkResultModel> {
    public a() {
    }

    public final void invoke(Object r23, CallContext r24) {
        hf r0 = (hf) r23;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r24, "context");
        IInteractService r1 = (IInteractService) jc1.k.n(IInteractService.class);
        int r2 = r1.getCurrentScene();
        if (r2 == 5) goto L9;
        if (r2 == 12) goto L9;
        if (r2 == 16) goto L9;
        if (r2 == 8) goto L9;
        if (r2 == 9) goto L9;
        boolean r3 = false;
    L10:
        boolean r10 = hd0.c.f().g();
        int r11 = r1.getCurrentScene();
        if (r11 == 5) goto L27;
        if (r11 == 12) goto L26;
        if (r11 == 16) goto L17;
        if (r11 == 8) goto L26;
        if (r11 == 9) goto L27;
        Boolean r12 = Boolean.FALSE;
    L28:
        Room r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r13 == null) goto L33;
        IBaseUser r14 = r13.getOwner();
        if (r14 == null) goto L33;
        boolean r15 = r14.isFollowing();
    L35:
        if (r12.booleanValue() == false) goto L39;
        if (r15 == true) goto L39;
        boolean r16 = false;
    L40:
        boolean r17 = r1.hasEmptySeatForLink();
        TryApplyLinkResultModel r18 = new TryApplyLinkResultModel();
        r18.c(Integer.valueOf(r1.getCurrentScene()));
        if (r3 == true) goto L44;
        r18.b(10001);
        r18.a(TryApplyLinkResultModel.Code.Failed);
    L94:
        finishWithResult(r18);
        return;
    L44:
        if (r10 == true) goto L46;
        r18.b(10002);
        r18.a(TryApplyLinkResultModel.Code.Failed);
        goto L94
    L46:
        if (r16 == true) goto L48;
        r18.b(10003);
        r18.a(TryApplyLinkResultModel.Code.Failed);
        goto L94
    L48:
        if (r17 == true) goto L50;
        r18.b(10004);
        r18.a(TryApplyLinkResultModel.Code.Failed);
        goto L94
    L50:
        r18.b(0);
        r18.a(TryApplyLinkResultModel.Code.Success);
        String r4 = r0.d();
        String r5 = r0.a();
        Integer r6 = r0.c();
        String r7 = r0.b();
        if (r4 == null) goto L94;
        if (r5 == null) goto L94;
        int r19 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r19 == 5) goto L84;
        if (r19 == 12) goto L81;
        if (r19 == 16) goto L62;
        if (r19 == 8) goto L81;
        if (r19 == 9) goto L84;
    L62:
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r8 == null) goto L78;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L78;
        if (r9.isLiveTypeAudio() != true) goto L78;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r20 = IVoiceChatGuestService.a.a();
        if (r20 == null) goto L94;
        if (TextUtils.isEmpty(r7) == false) goto L73;
        r7 = String.valueOf(110);
    L74:
        if (r6 == null) goto L76;
        int r21 = r6.intValue();
    L77:
        r20.checkAndApplyFromH5(r7, r21, r5, r4);
        goto L94
    L76:
        r21 = LinkApplyType.NORMAL.getValue();
        goto L77
    L73:
        Intrinsics.checkNotNull(r7);
    L78:
        rj0.l.n2.getClass();
        rj0.l r110 = rj0.l.a.a();
        if (r110 == null) goto L94;
        rj0.l.b.b(r110, -1, 110, r4, r5, null, null, 112);
    L81:
        rj0.l.n2.getClass();
        rj0.l r111 = rj0.l.a.a();
        if (r111 == null) goto L94;
        rj0.l.b.b(r111, -1, 110, r4, r5, null, null, 112);
    L84:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r22 = IVoiceChatGuestService.a.a();
        if (r22 == null) goto L94;
        if (TextUtils.isEmpty(r7) == false) goto L89;
        r7 = String.valueOf(110);
    L90:
        if (r6 == null) goto L92;
        int r25 = r6.intValue();
    L93:
        r22.checkAndApplyFromH5(r7, r25, r5, r4);
        goto L94
    L92:
        r25 = LinkApplyType.NORMAL.getValue();
        goto L93
    L89:
        Intrinsics.checkNotNull(r7);
    L39:
        r16 = true;
    L33:
        r15 = true;
        goto L35
    L17:
        com.bytedance.live.datacontext.m r112 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r112 == null) goto L24;
        IRoom r113 = (IRoom) r112.getValue();
        if (r113 == null) goto L24;
        if (r113.isLiveTypeAudio() != true) goto L24;
        com.bytedance.android.livesdk.sharedpref.e r114 = com.bytedance.android.livesdk.sharedpref.c.M0;
    L25:
        r12 = (Boolean) r114.getValue();
    L24:
        r114 = com.bytedance.android.livesdk.sharedpref.c.p1;
    L26:
        r12 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue();
    L27:
        r12 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.M0.getValue();
    L9:
        r3 = true;
        goto L10
    }
}
