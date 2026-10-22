package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ ChatMatchDialog a;

    public h(ChatMatchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        ChatMatchDialog r7 = this.a;
        int r0 = ChatMatchDialog.V;
        r7.getClass();
        String r1 = vm2.h.U().g();
        LinkedHashMap r2 = new LinkedHashMap();
        ChatMatchViewModel r3 = r7.h;
        if (r3 == null) goto L9;
        MutableLiveData<b1> r4 = r3.getMatchData();
        if (r4 == null) goto L9;
        b1 r5 = (b1) r4.getValue();
        if (r5 == null) goto L9;
        r2.put("matched_room_id", String.valueOf(r5.getMatchedRoomId()));
    L9:
        String r8 = y0.b(r1, r2);
        IBaseLiveActionHandler r9 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r9 == null) goto L12;
        r9.handle(r7.getContext(), r8);
    L12:
        r7.U90();
        gk0.a r10 = this.a.m;
        if (r10 == null) goto L16;
        LinkMatchType r11 = LinkMatchType.MORE_ROOM;
        r10.a(r11.getValue(), r11.getValue());
        return;
    }
}
