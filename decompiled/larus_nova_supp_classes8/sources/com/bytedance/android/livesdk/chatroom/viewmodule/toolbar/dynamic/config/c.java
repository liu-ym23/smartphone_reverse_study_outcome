package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.room.compatibility.commerce.ToolbarCommerceAnchorInMoreBehavior;
import com.bytedance.android.livesdk.room.placeholder.behavior.AnchorCommerceWrapper;
import com.bytedance.android.livesdk.room.placeholder.behavior.AudienceCommerceWrapper;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.COMMERCE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, null, r1, ToolbarButton.COMMERCE_MORE);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.CommerceCart.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final void a(ToolbarButton r3) {
        if (r3 == ToolbarButton.COMMERCE) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.e(this.g, false) == false) goto L7;
        this.g.put("DATA_COMMERCE_COMPAT_ANCHOR_BTN_ATTACH", Boolean.TRUE);
        return;
    L7:
        DataCenter r4 = this.g;
        Boolean r0 = Boolean.TRUE;
        r4.put("DATA_COMMERCE_COMPAT_AUDIENCE_BTN_ATTACH", r0);
        this.g.put("DATA_COMMERCE_COMPAT_AUDIENCE_HAS_ATTACHED", r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final void b(ToolbarButton r3) {
        if (r3 == ToolbarButton.COMMERCE) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.e(this.g, false) == false) goto L7;
        this.g.put("DATA_COMMERCE_COMPAT_ANCHOR_BTN_ATTACH", Boolean.FALSE);
        return;
    L7:
        this.g.put("DATA_COMMERCE_COMPAT_AUDIENCE_BTN_ATTACH", Boolean.FALSE);
    }

    public c(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final String i(boolean r3, boolean r4) {
        String r0 = NewToolbarButtonConstants.CommerceCart.INSTANCE.getName();
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        if (r3 == false) goto L5;
        String r5 = "_More";
    L6:
        r1.append(r5);
        String r6 = r1.toString();
        StringBuilder r2 = new StringBuilder();
        r2.append(r6);
        if (r4 == false) goto L9;
        String r7 = "_Anchor";
    L10:
        r2.append(r7);
        return r2.toString();
    L9:
        r7 = "_Audience";
        goto L10
    L5:
        r5 = "_Toolbar";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if (r3 == false) goto L8;
        if (r4 == true) goto L6;
        return null;
    L6:
        if (tb1.c.c == false) goto L20;
        return null;
    L20:
        return new ToolbarCommerceAnchorInMoreBehavior(this.f);
    L8:
        Object r5 = r2.l.c;
        if ((r5 instanceof IExternalButton) == true) goto L11;
        r5 = null;
    L11:
        IExternalButton r6 = (IExternalButton) r5;
        if (r6 == null) goto L21;
        if (r4 == false) goto L15;
        AnchorCommerceWrapper r7 = new AnchorCommerceWrapper(r6);
    L17:
        return r7;
    L15:
        r7 = new AudienceCommerceWrapper(r6);
        goto L17
    L21:
        return null;
    }
}
