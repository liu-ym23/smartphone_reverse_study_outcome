package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ChatChannelWidgetV2 a;
    public final /* synthetic */ s22.a b;
    public final /* synthetic */ Room c;

    public e(ChatChannelWidgetV2 r1, s22.a r2, Room r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        int r13 = j.a;
        j.a(this.b);
        if (((Number) this.b.d0().a).longValue() < this.b.getMaxMemberCount()) goto L6;
        f2.c(s1.B(2131915760), 0);
        return;
    L6:
        FansClubEntranceParams r14 = new FansClubEntranceParams(FansClubEntranceParams.Page.FansGroup, false, "chat_channel_qualify_guide", "top", FansClubEntranceParams.Entrance.UserInfoFansClubWidget, false, null, 466);
        o r0 = yt0.c.c();
        if (r0 == null) goto L11;
        p r15 = r0.Z8(r14);
        if (r15 == null) goto L11;
        r15.show();
    L11:
        ChatChannelWidgetV2 r16 = this.a;
        int r1 = ChatChannelWidgetV2.v;
        s22.e r2 = r16.yq();
        if (r2 == null) goto L27;
        long r3 = this.b.getChannelId();
        Room r17 = this.c;
        if (r17 == null) goto L16;
        Long r4 = Long.valueOf(r17.id);
    L17:
        FansChannelCreateInfo r18 = this.b.C();
        if (r18 == null) goto L20;
        Long r5 = Long.valueOf(r18.getFansChannelType());
    L21:
        FansChannelCreateInfo r19 = this.b.C();
        if (r19 == null) goto L24;
        Long r6 = Long.valueOf(r19.getGroupId());
    L25:
        r2.applyAnchorFansChannel(r3, r4, r5, r6);
        return;
    L24:
        r6 = null;
        goto L25
    L20:
        r5 = null;
        goto L21
    L16:
        r4 = null;
        goto L17
    }
}
