package com.bytedance.android.live.liveinteract.view;

import am2.x;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ GuestHonorView a;

    public a(GuestHonorView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        String r8 = (String) d.J.getValue(null, d.a[33]);
        LinkedHashMap r0 = new LinkedHashMap();
        IBaseUser r1 = this.a.getMUser();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.getIdString();
        if (r3 == null) goto L6;
    L7:
        r0.put("to_user_id", r3);
        r0.put("request_page", "link_panel");
        r0.put("business_type", "livelinkmic");
        r0.put("business_group", "livelinkmic");
        k.n(IBaseLiveActionHandler.class).handle(this.a.getContext(), y0.b(r8, r0));
        i0 r9 = TalkRoomLogUtils.a;
        IBaseUser r10 = this.a.getMUser();
        if (r10 == null) goto L13;
        String r11 = r10.getIdString();
        if (r11 == null) goto L13;
        r2 = r11;
    L13:
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("request_page", "link_panel"), TuplesKt.to("user_id", k.n(IMiddlewareUserService.class).user().n()), TuplesKt.to("to_userid", r2)});
        TalkRoomLogUtils.c1(r12);
        j0.l().sendLog("livesdk_chatroom_audiencehornor_entrance_click", r12, new Object[]{IRoom.class, x.class});
        return;
    L6:
        r3 = "";
        goto L7
    }
}
