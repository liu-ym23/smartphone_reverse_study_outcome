package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends g {
    public final com.bytedance.android.livesdk.chatroom.model.interact.r f;
    public final String g;
    public final boolean h;
    public final Context i;
    public final ILinkmicInteractEntrance j;
    public final String k;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        ILinkmicInteractEntrance r0 = this.j;
        if (r0 == null) goto L6;
        String r1 = r0.getName();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String f() {
        return this.g;
    }

    public final Context getContext() {
        return this.i;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final boolean i() {
        return this.h;
    }

    public static boolean m(String r1) {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.getOwnerUserIdString();
    L9:
        return Intrinsics.areEqual(r3, r1);
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void a(HSImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "icon");
        com.bytedance.android.livesdk.chatroom.model.interact.r r0 = this.f;
        if (r0 == null) goto L5;
        py.k r1 = r0.getIcon();
    L6:
        ImageUtil.loadRoundImage(r2, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        com.bytedance.android.livesdk.chatroom.model.interact.r r11 = this.f;
        if (r11 == null) goto L6;
        String r12 = r11.getSchema();
        if (r12 == null) goto L6;
    L8:
        if (r12.length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        jc1.k.n(IBaseLiveActionHandler.class).handle(this.i, new u6(r12).c());
    L13:
        this.e.dismissDialog();
        ALogger.i("AdventureEntranceItem", "entranceId: " + this.j.getEntranceId() + ", schema: " + r12);
        long r3 = this.j.getEntranceId();
        if (r3 != ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE.getValue()) goto L21;
        String r4 = this.k.toString();
        boolean r5 = m(this.k);
        int r6 = com.bytedance.android.live.liveinteract.utils.b.a;
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        Intrinsics.checkNotNullParameter("link_interact_panel", "requestPage");
        HashMap r7 = new HashMap();
        com.bytedance.android.live.liveinteract.utils.b.a(r7);
        r7.put("to_user_id", r4);
        if (r5 == false) goto L18;
        String r8 = "anchor";
    L19:
        r7.put("to_user_type", r8);
        r7.put("request_page", "link_interact_panel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_meetgame_invite_icon_click", r7, new Object[]{IRoom.class, am2.x.class});
        return;
    L18:
        r8 = "guest";
        goto L19
    L21:
        if (r3 == ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE_LIST.getValue()) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(je0.d.b0(), this.k) == false) goto L25;
        String r9 = "my_link_interact_panel";
    L26:
        int r13 = com.bytedance.android.live.liveinteract.utils.b.a;
        Intrinsics.checkNotNullParameter(r9, "requestPage");
        HashMap r14 = new HashMap();
        com.bytedance.android.live.liveinteract.utils.b.a(r14);
        r14.put("request_page", r9);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_meetgame_invite_message_icon_click", r14, new Object[]{IRoom.class, am2.x.class});
        return;
    L25:
        r9 = "other_link_interact_panel";
        goto L26
    L10:
        r0 = false;
    L6:
        r12 = "";
        goto L8
    }

    public b(Context r2, ILinkmicInteractEntrance r3, q0 r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "entrance");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        super(r4);
        this.i = r2;
        this.j = r3;
        this.k = r5;
        List r6 = r3.getButtons();
        boolean r7 = false;
        if (r6 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.model.interact.r r8 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r6, 0);
    L6:
        this.f = r8;
        if (r8 == null) goto L10;
        String r9 = r8.getToast();
        if (r9 == null) goto L10;
    L11:
        this.g = r9;
        if (r8 == null) goto L14;
        r7 = r8.getDisable();
    L14:
        this.h = r7;
        return;
    L10:
        r9 = "";
        goto L11
    L5:
        r8 = null;
        goto L6
    }
}
