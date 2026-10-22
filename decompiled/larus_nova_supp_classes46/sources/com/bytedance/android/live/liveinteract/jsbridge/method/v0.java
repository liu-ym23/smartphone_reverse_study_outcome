package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.OpenPlayModePanelResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.rc;
import w20.s4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v0 extends s4<rc, OpenPlayModePanelResultModel> {

    public static final class a {
    }

    static {
    }

    public v0() {
    }

    public final void invoke(Object r4, CallContext r5) {
        rc r6 = (rc) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r7 = r6.getType();
        if (r7 == null) goto L46;
        String r1 = "activity";
        switch(r7.hashCode()) {
            case -1435945641: goto L38;
            case -1331214983: goto L29;
            case -253527960: goto L20;
            case 408060947: goto L9;
            default: goto L46;
        };
    L9:
        if (r7.equals("interact_room_battle") == false) goto L46;
        String r8 = r6.b();
        if (r8 == null) goto L14;
        r1 = r8;
    L14:
        Integer r9 = r6.a();
        if (r9 == null) goto L17;
        int r10 = r9.intValue();
    L18:
        ((IInteractService) jc1.k.n(IInteractService.class)).clickLinkRoomFightIcon(MapsKt.mapOf(new Pair[]{TuplesKt.to("request_page", r1), TuplesKt.to("match_type", String.valueOf(r10))}));
        return;
    L17:
        r10 = 0;
        goto L18
    L20:
        if (r7.equals("interact_guest_battle") == false) goto L46;
        String r11 = r6.b();
        if (r11 == null) goto L25;
        r1 = r11;
    L25:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r12 = MultiRevenueDataContext.a.a();
        if (r12 == null) goto L49;
        r12.a(r1);
        return;
    L49:
        return;
    L29:
        if (r7.equals("interact_guest_battle_setting") == false) goto L46;
        String r13 = r6.b();
        if (r13 == null) goto L34;
        r1 = r13;
    L34:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r14 = MultiRevenueDataContext.a.a();
        if (r14 == null) goto L51;
        r14.b(r1);
        return;
    L51:
        return;
    L38:
        if (r7.equals("interact_team_fight") == false) goto L46;
        String r15 = r6.b();
        if (r15 == null) goto L43;
        r1 = r15;
    L43:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.d r16 = MultiRevenueDataContext.a.f();
        if (r16 == null) goto L53;
        r16.o5(r1);
        return;
    L53:
        return;
    L46:
        ALogger.e("open_play_mode_panel_method", "unsupported type " + r6.getType());
    }
}
