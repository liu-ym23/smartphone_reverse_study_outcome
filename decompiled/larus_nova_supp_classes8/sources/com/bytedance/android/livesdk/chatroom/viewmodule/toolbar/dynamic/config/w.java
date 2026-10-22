package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.y1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final DataCenter f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.VS_SELECT_EPISODE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1.setPureText(true), r1, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarVSAnthology.INSTANCE;
    }

    public w(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(null, null, 7);
        this.f = r3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        IRoom r5 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f);
        boolean r6 = false;
        if (((Boolean) this.f.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L20;
        IEpisodeExtraInfo r7 = r5.getEpisodeExtra();
        if (r7 == null) goto L20;
        String r8 = r7.getCurrentPeriod();
        if (r8 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == true) goto L20;
        if (r5.getRoomAuthStatus().isDisableSelectionAlbum() == true) goto L20;
        if (r5.isMergeVSRoom() == false) goto L20;
        r6 = true;
        goto L20
    L10:
        if (r8.length() == 0) goto L13;
        r9 = false;
    L20:
        if (r6 == true) goto L24;
        return null;
    L24:
        return new y1();
    }
}
