package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RoomChannelConfig extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean o() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.ROOM_CHANNEL;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, r1, null, null);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarRoomChannel.INSTANCE;
    }

    public RoomChannelConfig(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
        Lazy r5 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r4, NewToolbarButtonConstants.ToolbarRoomChannel.INSTANCE, new AnonymousClass1(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "button");
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, this.g, 0, 2);
        if (r7 != null) goto L5;
        return null;
    L5:
        s22.e r8 = ChatChannelUtils.b(r7);
        if (r8 != null) goto L9;
        return null;
    L9:
        return r8.getToolbarManager().b(r5);
    }
}
