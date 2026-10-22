package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.h4;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.TICKET_SALE, null, ToolbarButton.TICKET_SALE_ANCHOR, ToolbarButton.TICKET_SALE_ANCHOR_MORE);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.TicketSale.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
        Intrinsics.checkNotNullParameter(r3, "button");
        return new h4(this.f, true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
        Intrinsics.checkNotNullParameter(r3, "button");
        return new h4(this.f, false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
        Intrinsics.checkNotNullParameter(r3, "button");
        boolean r0 = true;
        if (lu2.c.c(lu2.c.f(this.g)) == true) goto L5;
    L35:
        if (r0 == false) goto L38;
        int r4 = qu2.a.a;
        return jc1.k.n(lu2.f.class).toolbarBehaviorProvider().a(this.f, this.g);
    L38:
        return null;
    L5:
        if (lu2.c.f(this.g).isPaidRoom() == false) goto L7;
    L8:
        nm1.m r5 = pm1.f.l();
        if (r5 != null) goto L11;
    L15:
        nm1.m r6 = pm1.f.l();
        if (r6 != null) goto L18;
    L20:
        nm1.m r7 = pm1.f.l();
        if (r7 != null) goto L23;
    L27:
        nm1.m r8 = pm1.f.l();
        if (r8 != null) goto L30;
    L34:
        r0 = false;
        goto L35
    L30:
        if (r8.a(this.g) == true) goto L34;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.g).isPaidLive() == false) goto L34;
    L23:
        if (r7.a(this.g) != true) goto L27;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.g).l1(PaidSceneEnum.PAID_PRIVILEGE_CAMERA) == false) goto L27;
    L18:
        if (r6.i(this.g) != true) goto L20;
    L11:
        if (r5.a(this.g) == true) goto L15;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.g).isPaidLive() == false) goto L15;
    L7:
        if (lu2.c.d(lu2.c.f(this.g)) == false) goto L35;
        goto L8
    }

    public q(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
    }
}
