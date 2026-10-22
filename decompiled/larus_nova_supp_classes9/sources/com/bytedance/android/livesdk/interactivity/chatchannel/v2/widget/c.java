package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.live.datacontext.m;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ ChatChannelWidgetV2 b;
    public final /* synthetic */ s22.a c;

    public c(String r1, ChatChannelWidgetV2 r2, s22.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        int r10 = j.a;
        j.a(this.c);
        if (((Number) this.c.d0().a).longValue() < this.c.getMaxMemberCount()) goto L6;
        f2.c(s1.B(2131915760), 0);
        return;
    L6:
        IBaseLiveActionHandler r11 = k.f(IBaseLiveActionHandler.class);
        if (r11 == null) goto L9;
        r11.handle(com.bytedance.android.live.core.utils.a.d(), this.a);
    L9:
        ChatChannelWidgetV2 r13 = this.b;
        int r0 = ChatChannelWidgetV2.v;
        s22.e r1 = r13.yq();
        if (r1 == null) goto L29;
        long r2 = this.c.getChannelId();
        RoomContext r14 = this.b.getRoomContext();
        if (r14 == null) goto L18;
        m r15 = r14.getRoom();
        if (r15 == null) goto L18;
        Room r16 = (Room) r15.getValue();
        if (r16 == null) goto L18;
        Long r4 = Long.valueOf(r16.id);
    L19:
        FansChannelCreateInfo r17 = this.c.C();
        if (r17 == null) goto L22;
        Long r5 = Long.valueOf(r17.getFansChannelType());
    L23:
        FansChannelCreateInfo r18 = this.c.C();
        if (r18 == null) goto L26;
        Long r6 = Long.valueOf(r18.getGroupId());
    L27:
        r1.applyAnchorFansChannel(r2, r4, r5, r6);
        return;
    L26:
        r6 = null;
        goto L27
    L22:
        r5 = null;
    L18:
        r4 = null;
        goto L19
    }
}
