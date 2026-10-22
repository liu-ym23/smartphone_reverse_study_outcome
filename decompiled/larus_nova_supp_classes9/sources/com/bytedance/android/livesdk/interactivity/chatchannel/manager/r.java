package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.interactivity.api.IRoomChannelService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements s22.f {
    public RoomContext a;
    public DataCenter b;
    public s22.e c;
    public CompositeDisposable d;

    public r() {
    }

    @Override // s22.f
    public final boolean a() {
        RoomContext r0 = this.a;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.isPortraitInteraction();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return false;
    L9:
        nm1.r r2 = pm1.f.o();
        if (r2 == null) goto L15;
        r2.a();
        if (MultiTabManagerImpl.e.g(this.b) != true) goto L15;
        ALogger.i("ChatChannelToolbarManager", " isMultiTabAndUgcPortraitFilter, return false ");
        return false;
    L15:
        s22.e r3 = this.c;
        if (r3 == null) goto L22;
        s22.e.b r4 = r3.getConfig();
        if (r4 == null) goto L22;
        if (r4.b != true) goto L22;
        return true;
    L22:
        s22.e r5 = this.c;
        if (r5 == null) goto L29;
        s22.e.b r6 = r5.getConfig();
        if (r6 == null) goto L29;
        if (r6.c != true) goto L29;
        return true;
    L29:
        return false;
    }

    @Override // s22.f
    public final void c() {
        DataCenter r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        RoomContext r1 = this.a;
        if (r1 != null) goto L8;
        return;
    L8:
        s22.e r2 = this.c;
        if (r2 != null) goto L11;
        return;
    L11:
        IRoomChannelService r3 = (IRoomChannelService) jc1.k.f(IRoomChannelService.class);
        if (r3 == null) goto L14;
        c0.b r4 = r3.createChatChannelLandscapeToolbarBehavior(r1, r0, r2);
    L15:
        y3.i(r0).p(ToolbarButton.CHAT_CHANNEL_LANDSCAPE.extended(), r4);
        return;
    L14:
        r4 = null;
        goto L15
    }

    @Override // s22.f
    public final com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.a b(boolean r6) {
        RoomContext r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        s22.e r2 = this.c;
        if (r2 != null) goto L8;
        return null;
    L8:
        DataCenter r3 = this.b;
        if (r3 != null) goto L12;
        return null;
    L12:
        if (ChatChannelUtils.i(r0) == false) goto L15;
        return null;
    L15:
        return new com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.a(r3, r0, r2, r6);
    }
}
