package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0 extends g {
    public final String f;
    public final boolean g;
    public final Context h;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 2131251839;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return s1.B(2131919810);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String f() {
        return this.f;
    }

    public final Context getContext() {
        return this.h;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final boolean i() {
        return this.g;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r14) {
        Intrinsics.checkNotNullParameter(r14, "v");
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.c.P0;
        if ((!((Collection) r15.getValue()).isEmpty()) == false) goto L54;
        String r0 = ((com.bytedance.android.livesdk.chatroom.model.r) ListProtector.get((List) r15.getValue(), 0)).c;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L55;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 != null) goto L13;
        return;
    L13:
        if (r0.length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L42;
        u6 r6 = new u6(r0);
        u6 r1 = r6.d("url");
        r1.b("room_id", String.valueOf(r4.getRoomId()));
        r1.b("anchor_id", r4.getOwnerUserIdString().toString());
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L20;
        r1.b("user_type", "anchor");
    L21:
        r1.b("request_page", "link_interact");
        int r7 = je0.d.f();
        if (r7 != 4) goto L24;
        r1.b("live_type", "video_live");
        r1.b("function_type", "audience");
    L41:
        jc1.k.n(IBaseLiveActionHandler.class).handle(this.h, r6.c());
        goto L42
    L24:
        if (r7 == 5) goto L36;
        if (r7 != 8) goto L28;
        r1.b("live_type", "video_live");
        r1.b("function_type", "radio");
        goto L41
    L28:
        if (r7 != 9) goto L30;
        r1.b("live_type", "voice_live");
        r1.b("function_type", "ktv");
        goto L41
    L30:
        if (r7 != 12) goto L41;
        r1.b("live_type", "video_live");
        r1.b("function_type", "party");
        goto L41
    L36:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r4) == false) goto L38;
        r1.b("function_type", "party");
    L39:
        r1.b("live_type", "voice_live");
        goto L41
    L38:
        r1.b("function_type", "radio");
        goto L39
    L20:
        r1.b("user_type", "guest");
    L42:
        int r2 = dk0.b.a;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_link_interact_panel_head_decorate_icon_click", new HashMap(), new Object[]{IRoom.class});
        List r8 = (List) r15.getValue();
        if ((!r8.isEmpty()) == false) goto L52;
        Boolean r9 = ((com.bytedance.android.livesdk.chatroom.model.r) ListProtector.get(r8, 0)).d;
        if (r9 == null) goto L47;
        boolean r10 = r9.booleanValue();
    L48:
        int r11 = r8.size();
        if (r10 == false) goto L52;
        if (r11 <= 1) goto L52;
        ListProtector.remove(r8, 0);
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r8);
        goto L52
    L47:
        r10 = false;
    L52:
        this.e.dismissDialog();
        return;
    L15:
        r5 = false;
        goto L16
    L55:
        return;
    }

    public s0(q0 r2, String r3, Context r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "bubbleText");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r2);
        this.h = r4;
        this.f = r3;
        this.g = r5;
    }
}
