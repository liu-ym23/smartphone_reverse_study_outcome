package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.behavior.ToolbarVideoQualityBehavior;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ x a;

        public a(x r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.g.put("cmd_landscape_interaction_hide", Boolean.TRUE);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.SWITCH_VIDEO_QUALITY;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, r1, null, null);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarVSClarity.INSTANCE;
    }

    public x(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "button");
        Room r6 = com.bytedance.android.live.core.utils.z.o(this.g);
        if (r6.isMergeVSRoom() == false) goto L5;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L16;
        Boolean r8 = (Boolean) this.g.get("data_is_portrait", Boolean.TRUE);
        return new ToolbarVideoQualityBehavior(this.f, com.bytedance.android.live.core.utils.z.o(this.g), r8.booleanValue(), new a(this));
    L16:
        return null;
    L5:
        if (VSMediaUIConfigHelper.b(this.g) == true) goto L12;
        if (m50.a.getValue().a() == true) goto L9;
    L11:
        r7 = false;
        goto L13
    L9:
        if (r6.isMediaRoom() == true) goto L11;
        goto L11
    }
}
