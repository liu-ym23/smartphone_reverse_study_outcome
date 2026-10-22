package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m;
import com.bytedance.android.livesdk.config.setting.s;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/CommonSlotMoreLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonSlotMoreLoader extends AbsDynamicLoader {
    public final ArrayList<gp1.a> h;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e i;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        if (s.b() == true) goto L5;
        return r0;
    L5:
        DataCenter r1 = this.a;
        Boolean r2 = Boolean.FALSE;
        Boolean r3 = (Boolean) r1.get("data_is_anchor", r2);
        if (LiveTbArchUtils.INSTANCE.enableOpt(this.a) == false) goto L16;
        IToolbarService r4 = k.f(IToolbarService.class);
        if (r4 == null) goto L20;
        com.bytedance.android.livesdk.arch.context.a r5 = r4.getTbContext(RoomContext.a.c(RoomContext.Companion, this.a, 0, 2), this.a);
        if (r5 == null) goto L20;
        m r6 = r5.getCompactTbLoader();
        if (r6 == null) goto L20;
        List<ToolbarButton> r7 = r6.getFoldButtons(r3);
        if (r7 == null) goto L20;
        r0.addAll(r7);
    L20:
        Boolean r8 = (Boolean) this.a.get("data_room_channel_move_to_more", r2);
        ToolbarButton r9 = ToolbarButton.ROOM_CHANNEL;
        boolean r10 = r0.contains(r9);
        RoomContext.a r11 = RoomContext.Companion;
        RoomContext r12 = RoomContext.a.c(r11, this.a, 0, 2);
        boolean r13 = false;
        if (r12 == null) goto L39;
        RoomContext r14 = RoomContext.a.c(r11, this.a, 0, 2);
        if (r14 == null) goto L30;
        com.bytedance.live.datacontext.m r15 = r14.isPortraitInteraction();
        if (r15 == null) goto L30;
        Boolean r16 = (Boolean) r15.getValue();
        if (r16 == null) goto L30;
        boolean r17 = r16.booleanValue();
    L32:
        if (ChatChannelUtils.a(r12) != ContainerType.MultiTab) goto L34;
        boolean r18 = true;
    L35:
        if (r17 == false) goto L39;
        if (r18 == true) goto L39;
        r13 = true;
        goto L39
    L34:
        r18 = false;
    L30:
        r17 = false;
    L39:
        if (r8.booleanValue() == true) goto L41;
        if (r10 == true) goto L41;
    L43:
        r0.remove(r9);
    L44:
        r0.remove(ToolbarButton.GAME_PROMOTE_AUDIENCE_MORE);
        r0.remove(ToolbarButton.SHARE);
        if (u40.a.c(this.c) == false) goto L61;
        Iterator<gp1.a> r19 = this.h.iterator();
    L48:
        if (r19.hasNext() == false) goto L59;
        gp1.a r20 = r19.next();
        Iterator r21 = r0.iterator();
    L51:
        if (r21.hasNext() == false) goto L55;
        Object r22 = r21.next();
        if (r20.a((a2) r22) == false) goto L51;
    L56:
        a2 r23 = (a2) r22;
        if (r23 == null) goto L48;
        ALogger.i("MorePanelDataManager", "change " + r23.debugName());
        r0.remove(r23);
        r0.add(r20.b(r23));
        goto L48
    L55:
        r22 = null;
        goto L56
    L59:
        return r0;
    L61:
        if (((Boolean) this.a.get("data_vs_message_board_move_to_more", r2)).booleanValue() == false) goto L78;
        ArrayList r24 = new ArrayList();
        r24.addAll(r0);
        if (this.i != null) goto L65;
        ExtendedToolbarButton.a r25 = ExtendedToolbarButton.h;
        ToolbarButton r26 = ToolbarButton.VS_MESSAGE_BOARD;
        r25.getClass();
        ExtendedToolbarButton.b r27 = ExtendedToolbarButton.a.a(r26);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r28 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(r27);
        r28.i = 1;
        r28.b = r27.i.getDrawableFolded();
        r28.f(r27.g());
        Unit r29 = Unit.INSTANCE;
        this.i = r28;
    L65:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r30 = this.i;
        if (r30 == null) goto L69;
        r24.remove(r30);
        r24.add(r30);
    L69:
        return r24;
    L78:
        return r0;
    L41:
        if (r13 == false) goto L43;
        r0.remove(r9);
        r0.add(r9);
        goto L44
    L16:
        BottomToolbarViewModel.a r31 = BottomToolbarViewModel.Companion;
        DataCenter r32 = this.a;
        r31.getClass();
        BottomToolbarViewModel r33 = BottomToolbarViewModel.a.a(r32);
        if (r33 != null) goto L19;
        return r0;
    L19:
        r0.addAll(r33.getFoldButtons(r3));
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        this.h.add(new gp1.c());
        this.h.add(new gp1.b());
    }

    public CommonSlotMoreLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new ArrayList();
    }
}
