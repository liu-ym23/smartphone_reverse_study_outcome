package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import sh0.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements ne0.a {
    public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

    public g(MultiLinkVoiceChatRoomAnchorWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r18, Object r19) {
        Intrinsics.checkNotNullParameter(r18, "store");
        if (r19 == null) goto L20;
        g0 r0 = (g0) r19;
        MultiLinkVoiceChatRoomAnchorWidget r2 = this.a;
        int r3 = MultiLinkVoiceChatRoomAnchorWidget.E2;
        DataCenter r4 = ((Widget) r2).dataCenter;
        if (r4 == null) goto L9;
        Boolean r5 = (Boolean) r4.get("status_bar_is_visible", Boolean.TRUE);
        if (r5 == null) goto L9;
        boolean r9 = r5.booleanValue();
    L10:
        Triple r13 = new Triple(0, 0, "MultiLinkVoiceChatLayoutSwitcher#updateLinkWindowLayoutConfig, with switchType = " + r0.a);
        ln0.a r6 = yg0.h.a;
        zj0.c r7 = r0.a;
        if (r7 == null) goto L18;
        int r8 = ((zj0.c.b) r7).c;
        List<Integer> r10 = r0.b;
        int r11 = r2.Ta();
        pn0.i r12 = new pn0.i(true);
        ClientUIInfo r1 = r2.P1;
        if (r1 == null) goto L15;
        List r14 = r1.getUiFeatureList();
    L16:
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.t(r8, r10, 0, r9, r11, false, r12, r13, r14, ((Widget) r2).dataCenter, 76), new o(r2), null);
        return;
    L15:
        r14 = null;
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.videotalk.switcher.SwitchLayoutType.Init");
    L9:
        r9 = true;
        goto L10
    }
}
