package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g1 {
    public static final boolean a() {
        Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.c.e1.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public static final boolean b() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
    L6:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 != null) goto L9;
    L10:
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r2 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L29;
        com.bytedance.android.live.liveinteract.plantform.model.n0 r4 = tc0.c.h().P;
        if (r4 == null) goto L20;
        long r5 = r4.getPaidAmount();
    L22:
        if (r5 <= 0) goto L30;
        cj0.c r6 = PaidLinkMicContext.Companion.a();
        if (r6 != null) goto L26;
        return false;
    L26:
        if (r6.isPaidLinkOn() == true) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    L20:
        r5 = 0;
        goto L22
    L29:
        return false;
    L13:
        if (r2.isCurrentLinkPaid() != true) goto L15;
    L14:
        r3 = true;
        goto L16
    L9:
        if (r1.isCurrentLinkPaid() == true) goto L14;
    L5:
        if (r0.isCurrentLinkPaid() == true) goto L14;
        goto L6
    }

    public static final boolean d() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        String r2 = r1.getAnchorAbValue("support_multiple_add_price");
        if (r2 == null) goto L9;
        Integer r3 = StringsKt.toIntOrNull(r2);
    L10:
        if (r3 != null) goto L13;
    L15:
        return false;
    L13:
        if (r3.intValue() != 1) goto L15;
        return true;
    L9:
        r3 = null;
        goto L10
    }

    public static final boolean c(ILinkPlayerInfoBridge r7) {
        Intrinsics.checkNotNullParameter(r7, "linkPlayerInfo");
        PaidLinkMicContext.a r0 = PaidLinkMicContext.Companion;
        cj0.c r1 = r0.a();
        if (r1 != null) goto L5;
    L10:
        cj0.c r2 = r0.a();
        if (r2 != null) goto L13;
    L17:
        return false;
    L13:
        if (r2.isPaidLinkOn() == true) goto L17;
        if (r7.getPaidAmount() <= 0) goto L17;
        return true;
    L5:
        if (r1.isPaidLinkOn() != true) goto L10;
        if (d() == false) goto L10;
        if (r7.getPaidAmount() <= 0) goto L10;
        return true;
    }
}
