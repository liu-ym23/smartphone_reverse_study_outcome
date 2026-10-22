package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.livesdk.config.g1;
import com.bytedance.android.livesdk.config.j51;
import com.bytedance.android.livesdk.config.r91;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ FriendsInviteListBinder.ViewHolder a;

    public c(FriendsInviteListBinder.ViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        int r6 = com.bytedance.android.live.liveinteract.e.a;
        Context r7 = ((RecyclerView.ViewHolder) this.a).itemView.getContext();
        r91 r0 = h.h().a();
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L7:
        u6 r2 = new u6(r1);
        r91 r3 = h.h().a();
        if (r3 == null) goto L11;
        String r4 = r3.b();
        if (r4 == null) goto L11;
    L12:
        j51 r8 = vm2.d.d0();
        if (r8 == null) goto L15;
        String r9 = r8.a();
    L17:
        if (r2.a(r9) == false) goto L19;
        r4 = "https://" + r9 + ":60006/pages/ai_guest_list/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%2C%22localCache%3Achat_room_lynx-ai_guest_list-%7Broom_id%7D%22%5D";
    L19:
        r2.b("url", r4);
        r2.d("url");
        k.n(IBaseLiveActionHandler.class).handle(r7, r2.c());
        if (m.h() == false) goto L23;
        HashMap r10 = new HashMap();
        m.B(r10, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), 4);
        m.L("livesdk_anchor_invitee_AI_guest_click", r10, new Object[0]);
        return;
    L23:
        return;
    L15:
        r9 = null;
    L11:
        r4 = g1.c.b();
        Intrinsics.checkNotNull(r4);
    L6:
        r1 = g1.c.a();
        Intrinsics.checkNotNull(r1);
        goto L7
    }
}
