package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import sh0.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements ne0.a {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public t(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r20, Object r21) {
        Intrinsics.checkNotNullParameter(r20, "store");
        if (r21 == null) goto L34;
        g0 r0 = (g0) r21;
        MultiLinkVoiceChatRoomGuestWidget r2 = this.a;
        int r3 = MultiLinkVoiceChatRoomGuestWidget.e3;
        r2.getClass();
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L7;
        DataCenter r4 = ((Widget) r2).dataCenter;
        if (r4 == null) goto L15;
        Boolean r5 = (Boolean) r4.get("status_bar_is_visible", Boolean.TRUE);
        if (r5 == null) goto L15;
        boolean r11 = r5.booleanValue();
    L16:
        Triple r15 = new Triple(0, 0, "MultiLinkVoiceChatLayoutSwitcher#updateLinkWindowLayoutConfig, with switchType = " + r0.a);
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(r2).s();
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r6.getValue();
        if (r7 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r8 = r7.t();
        if (r8 == null) goto L23;
        ClientUIInfo r9 = r8.a();
    L24:
        ln0.a r10 = yg0.h.a;
        zj0.c r12 = r0.a;
        if (r12 == null) goto L32;
        int r13 = ((zj0.c.b) r12).c;
        List<Integer> r14 = r0.b;
        int r16 = r2.Ta();
        pn0.i r17 = new pn0.i(true);
        if (r9 == null) goto L29;
        List r18 = r9.getUiFeatureList();
    L30:
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.t(r13, r14, 0, r11, r16, false, r17, r15, r18, ((Widget) r2).dataCenter, 76), new d0(r2), null);
        return;
    L29:
        r18 = null;
        goto L30
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.switcher.SwitchLayoutType.Init");
    L23:
        r9 = null;
    L15:
        r11 = true;
        goto L16
    L7:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L15;
        r11 = false;
        goto L16
    }
}
