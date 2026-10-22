package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 extends g {
    public final com.bytedance.android.livesdk.chatroom.model.interact.r f;
    public final String g;
    public final boolean h;
    public final Context i;
    public final String j;
    public final ILinkmicInteractEntrance k;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        ILinkmicInteractEntrance r0 = this.k;
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
        u6 r1 = new u6(r12);
        u6 r13 = r1.d("url");
        r13.b("to_user_id", this.j.toString());
        r13.b("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentFunctionType());
        r13.b("live_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLiveTypeForLog());
        jc1.k.n(IBaseLiveActionHandler.class).handle(this.i, r1.c());
    L13:
        int r14 = dk0.b.a;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_link_interact_panel_head_decorate_icon_click", new HashMap(), new Object[]{IRoom.class});
        com.bytedance.android.livesdk.chatroom.model.interact.r r15 = this.f;
        Map<String, List<ILinkmicInteractEntrance>> r2 = null;
        List<ILinkmicInteractEntrance> r3 = null;
        if (r15 == null) goto L16;
        Boolean r16 = r15.getClickToNext();
    L18:
        if (Intrinsics.areEqual(r16, Boolean.TRUE) == false) goto L95;
        String r17 = this.j;
        if (r17 != null) goto L22;
    L25:
        boolean r18 = true;
    L26:
        if (r18 == false) goto L59;
        IInteractService r19 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r19 == null) goto L30;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r110 = r19.getLinkUserInfoCenter();
    L32:
        if ((r110 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L34;
        r110 = null;
    L34:
        com.bytedance.android.live.liveinteract.plantform.core.y r111 = (com.bytedance.android.live.liveinteract.plantform.core.y) r110;
        if (r111 == null) goto L37;
        r3 = r111.D;
    L37:
        if (r3 == null) goto L95;
        ArrayList r112 = new ArrayList();
        Iterator r4 = r3.iterator();
    L40:
        if (r4.hasNext() == false) goto L49;
        Object r5 = r4.next();
        ILinkmicInteractEntrance r6 = (ILinkmicInteractEntrance) r5;
        if ((r6 instanceof ILinkmicInteractEntrance) == true) goto L44;
    L46:
        boolean r7 = false;
    L47:
        if (r7 == false) goto L40;
        r112.add(r5);
        goto L40
    L44:
        if (r6.getEntranceId() != this.k.getEntranceId()) goto L46;
        r7 = true;
        goto L47
    L49:
        ILinkmicInteractEntrance r113 = (ILinkmicInteractEntrance) CollectionsKt.firstOrNull(r112);
        if (r113 == null) goto L95;
        List r8 = r113.getButtons();
        if (r8 == null) goto L54;
        int r9 = r8.size();
    L55:
        if (r9 <= 1) goto L95;
        List r114 = r113.getButtons();
        if (r114 == null) goto L95;
        com.bytedance.android.livesdk.chatroom.model.interact.r r115 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.remove(r114, 0);
        goto L95
    L54:
        r9 = 0;
        goto L55
    L30:
        r110 = null;
        goto L32
    L59:
        IInteractService r116 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r116 == null) goto L62;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r117 = r116.getLinkUserInfoCenter();
    L64:
        if ((r117 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L66;
        r117 = null;
    L66:
        com.bytedance.android.live.liveinteract.plantform.core.y r118 = (com.bytedance.android.live.liveinteract.plantform.core.y) r117;
        if (r118 == null) goto L69;
        r2 = r118.E;
    L69:
        if (r2 == null) goto L95;
        if (r2.containsKey(this.j) != true) goto L95;
        List<ILinkmicInteractEntrance> r119 = r2.get(this.j);
        if (r119 == null) goto L95;
        ArrayList r20 = new ArrayList();
        Iterator<T> r120 = r119.iterator();
    L76:
        if (r120.hasNext() == false) goto L85;
        Object r21 = r120.next();
        ILinkmicInteractEntrance r22 = (ILinkmicInteractEntrance) r21;
        if ((r22 instanceof ILinkmicInteractEntrance) == true) goto L80;
    L82:
        boolean r23 = false;
    L83:
        if (r23 == false) goto L76;
        r20.add(r21);
        goto L76
    L80:
        if (r22.getEntranceId() != this.k.getEntranceId()) goto L82;
        r23 = true;
        goto L83
    L85:
        ILinkmicInteractEntrance r121 = (ILinkmicInteractEntrance) CollectionsKt.firstOrNull(r20);
        if (r121 == null) goto L95;
        List r24 = r121.getButtons();
        if (r24 == null) goto L90;
        int r25 = r24.size();
    L91:
        if (r25 <= 1) goto L95;
        List r122 = r121.getButtons();
        if (r122 == null) goto L95;
        com.bytedance.android.livesdk.chatroom.model.interact.r r123 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.remove(r122, 0);
        goto L95
    L90:
        r25 = 0;
        goto L91
    L62:
        r117 = null;
        goto L64
    L22:
        if (r17.length() == 0) goto L25;
        r18 = false;
    L95:
        this.e.dismissDialog();
        return;
    L16:
        r16 = null;
        goto L18
    L10:
        r0 = false;
    L6:
        r12 = "";
        goto L8
    }

    public l0(q0 r2, Context r3, String r4, ILinkmicInteractEntrance r5) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "targetUser");
        Intrinsics.checkNotNullParameter(r5, "entrance");
        super(r2);
        this.i = r3;
        this.j = r4;
        this.k = r5;
        List r6 = r5.getButtons();
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
