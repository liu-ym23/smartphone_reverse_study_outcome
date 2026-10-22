package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.config.fm;
import com.bytedance.android.livesdk.room.placeholder.behavior.AnchorGameCpWrapper;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.GAME_PROMOTE_AUDIENCE;
        if (fm.a.getValue().booleanValue() == false) goto L5;
        ToolbarButton r2 = ToolbarButton.GAME_PROMOTE_AUDIENCE_MORE;
    L7:
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, r2, ToolbarButton.GAME_PROMOTE, ToolbarButton.GAME_PROMOTE_MORE);
    L5:
        r2 = null;
        goto L7
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.GamePromote.INSTANCE;
    }

    public i(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "button");
        if (r8 == false) goto L11;
        if (r9 == true) goto L11;
        if (tb1.c.a == false) goto L11;
        if (com.bytedance.android.live.core.utils.z.m(this.g, true) == false) goto L11;
        return new com.bytedance.android.livesdk.room.placeholder.behavior.i();
    L11:
        Object r0 = r7.l.c;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r2 = null;
        if ((r0 instanceof IExternalButton) == true) goto L14;
        r0 = null;
    L14:
        IExternalButton r1 = (IExternalButton) r0;
        if (r1 != null) goto L17;
        int r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0.a(String.valueOf(r7.a), this.g, r7.l.b, ErrorReason.GAMECP_EXTERNAL_BUTTON_IS_NULL.getValue(), null);
    L17:
        if (r1 == null) goto L28;
        if (r9 == true) goto L23;
        if (r8 == true) goto L23;
        if (tb1.c.a == false) goto L23;
        r2 = new com.bytedance.android.livesdk.room.placeholder.behavior.j(r1, this.g, r7);
    L23:
        if (r9 == true) goto L25;
        return r2;
    L25:
        if (tb1.c.g == true) goto L27;
        return r2;
    L27:
        return new AnchorGameCpWrapper(r1, Boolean.valueOf(r8), r7.d);
    L28:
        return null;
    }
}
